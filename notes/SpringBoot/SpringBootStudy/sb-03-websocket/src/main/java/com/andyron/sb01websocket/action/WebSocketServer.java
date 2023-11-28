package com.andyron.sb01websocket.action;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author andyron
 **/
@Component
@Slf4j
@ServerEndpoint("/websocket/{sid}")
public class WebSocketServer {

    private static AtomicInteger onlineSessionClientCount = new AtomicInteger(0);

    private static Map<String, Session> onlineSessionClienMap = new ConcurrentHashMap<>();

    private String sid;
    private Session session;

    @OnOpen
    public void onOpen(@PathParam("sid") String sid, Session session) {
        log.info("建立链接中 ==> session_id = {}, sid = {}", session.getId(), sid);

        onlineSessionClientCount.incrementAndGet();
        this.sid = sid;
        this.session = session;
        sendToOne(sid, "连接成功");
        log.info("连接成功，当前在线数为：{} ==> 开始监听新链接：session_id = {}, sid = {}.",
                onlineSessionClientCount, session.getId(), sid);
    }

    @OnClose
    public void onClose(@PathParam("sid") String sid, Session session) {
        onlineSessionClienMap.remove(sid);

        onlineSessionClientCount.decrementAndGet();
        log.info("连接关闭成功，当前在线数为：{} ==> 关闭该连接信息：session_id = {}, sid = {}.",
                onlineSessionClientCount, session.getId(), sid);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        JSONObject jsonObject = JSON.parseObject(message);
        String toSid = jsonObject.getString("sid");
        String msg = jsonObject.getString("message");
        log.info("服务端收到客户端消息 ==> fromSid = {}, toSid = {}, message = {}", sid, toSid, message);

        if (toSid == null || toSid == "" || "".equalsIgnoreCase(toSid)) {
            sendToAll(msg);
        } else {
            sendToOne(toSid, msg);
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("WebSocket发生错误，错误信息为：" + error.getMessage());
        error.printStackTrace();
    }


    private void sendToAll(String message) {
        onlineSessionClienMap.forEach((onlineSid, toSession) -> {
            if (!sid.equalsIgnoreCase(onlineSid)) {
                log.info("服务端给客户端群发消息 ==> sid = {}, toSid = {}, message = {}", sid, onlineSid, message);
                toSession.getAsyncRemote().sendText(message);
            }
        });
    }

    private void sendToOne(String toSid, String message) {
        Session toSession = onlineSessionClienMap.get(toSid);
        if (toSession == null) {
            log.error("服务端给客户端发送消息 ==> toSid = {} 不存在, message = {}", toSid, message);
            return;
        }

        log.info("服务端给客户端发送消息 ==> toSid = {}, message = {}", toSid, message);
        toSession.getAsyncRemote().sendText(message);
    }
}
