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
 * WebSocket的操作类
 * @author andyron
 **/
@Component
@Slf4j
@ServerEndpoint("/websocket/{sid}")
public class WebSocketServer {
    /**
     * 静态变量，用来记录当前在线连接数，线程安全的类。
     */
    private static AtomicInteger onlineSessionClientCount = new AtomicInteger(0);
    /**
     * 存放所有在线的客户端
     */
    private static Map<String, Session> onlineSessionClienMap = new ConcurrentHashMap<>();
    /**
     * 连接sid和连接会话
     */
    private String sid;
    private Session session;

    /**
     * 连接建立成功调用的方法。由前端<code>new WebSocket</code>触发
     *
     * @param sid     每次页面建立连接时传入到服务端的id，比如用户id等。可以自定义。
     * @param session 与某个客户端的连接会话，需要通过它来给客户端发送消息
     */
    @OnOpen
    public void onOpen(@PathParam("sid") String sid, Session session) {
        // session.getId()：当前session会话会自动生成一个id，从0开始累加的。
        log.info("建立链接中 ==> session_id = {}, sid = {}", session.getId(), sid);

        onlineSessionClienMap.put(sid, session);
        // 在线数加1
        onlineSessionClientCount.incrementAndGet();
        this.sid = sid;
        this.session = session;
        sendToOne(sid, "连接成功");
        log.info("连接成功，当前在线数为：{} ==> 开始监听新链接：session_id = {}, sid = {}.",
                onlineSessionClientCount, session.getId(), sid);
    }

    /**
     * 连接关闭调用的方法。由前端<code>socket.close()</code>触发
     *
     * @param sid
     * @param session
     */
    @OnClose
    public void onClose(@PathParam("sid") String sid, Session session) {
        onlineSessionClienMap.remove(sid);

        onlineSessionClientCount.decrementAndGet();
        log.info("连接关闭成功，当前在线数为：{} ==> 关闭该连接信息：session_id = {}, sid = {}.",
                onlineSessionClientCount, session.getId(), sid);
    }
    /**
     * 收到客户端消息后调用的方法。由前端<code>socket.send</code>触发
     * 当服务端执行toSession.getAsyncRemote().sendText(xxx)后，前端的socket.onmessage得到监听。
     *
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        JSONObject jsonObject = JSON.parseObject(message);
        String toSid = jsonObject.getString("sid");
        String msg = jsonObject.getString("message");
        log.info("服务端收到客户端消息 ==> fromSid = {}, toSid = {}, message = {}", sid, toSid, message);

        // 模拟约定：如果未指定sid信息，则群发，否则就单独发送
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

    /**
     * 群发消息
     * @param message
     */
    private void sendToAll(String message) {
        onlineSessionClienMap.forEach((onlineSid, toSession) -> {
            if (!sid.equalsIgnoreCase(onlineSid)) {
                log.info("服务端给客户端群发消息 ==> sid = {}, toSid = {}, message = {}", sid, onlineSid, message);
                toSession.getAsyncRemote().sendText(message);
            }
        });
    }

    /**
     * 指定发送消息
     * @param toSid
     * @param message
     */
    private void sendToOne(String toSid, String message) {
        Session toSession = onlineSessionClienMap.get(toSid);
        if (toSession == null) {
            log.error("服务端给客户端发送消息 ==> toSid = {} 不存在, message = {}", toSid, message);
            return;
        }
        // 异步发送
        log.info("服务端给客户端发送消息 ==> toSid = {}, message = {}", toSid, message);
        toSession.getAsyncRemote().sendText(message);

        /*
        // 同步发送
        try {
            toSession.getBasicRemote().sendText(message);
        } catch (IOException e) {
            log.error("发送消息失败，WebSocket IO异常");
            e.printStackTrace();
        }*/
    }
}
