
## 排错思路

```shell
[2021-09-29 08:50:40,725] Artifact ssmbuild:war exploded: Artifact is being deployed, please wait...
29-Sep-2021 08:50:41.361 严重 [RMI TCP Connection(2)-127.0.0.1] org.apache.catalina.core.StandardContext.startInternal 一个或多个筛选器启动失败。完整的详细信息将在相应的容器日志文件中找到
29-Sep-2021 08:50:41.363 严重 [RMI TCP Connection(2)-127.0.0.1] org.apache.catalina.core.StandardContext.startInternal Context [] startup failed due to previous errors
[2021-09-29 08:50:41,389] Artifact ssmbuild:war exploded: Error during artifact deployment. See server log for details.
29-Sep-2021 08:50:50.386 信息 [Catalina-utility-2] org.apache.catalina.startup.HostConfig.deployDirectory 把web 应用程序部署到目录 [/Users/andyron/java/Tomcat/apache-tomcat-9.0.30/webapps/manager]
29-Sep-2021 08:50:50.456 信息 [Catalina-utility-2] org.apache.catalina.startup.HostConfig.deployDirectory Deployment of web application directory [/Users/andyron/java/Tomcat/apache-tomcat-9.0.30/webapps/manager] has finished in [70] ms
```
解决：在【Project Structure】  中添加lib


``` 
org.apache.ibatis.builder.IncompleteElementException: 
Could not find parameter map com.andyron.dao.BooksMapper.Books
```
错误原因：mapper.xml文件有一个或者多个parameterType写成了parameterMap。

``` 
java.security.cert.CertPathValidatorException: Path does not chain with any of the trust anchors
```
把URL中useSSL=true，改成false即可


```
org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.andyron.service.BooksService' available: 
expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true), @org.springframework.beans.factory.annotation.Qualifier(value=booksServiceImpl)}

```
问题：bean不存在
步骤：
1.查看这个bean注入是否成功！ ok
2.Junit单元测试，看我们的代码是否能够查询出来结果！ok 
3.问题，一定不在我们的底层，是spring出了问题！
4.SpringMVC，整合的时候没调用到我们的service层的bean； 
    - applicationContext.xml没有注入bean
    - web.xml中，我们也绑定过配置文件！发现问题，我配置的是spring-mvc.xml，而这里面没有service的bean，修改为：
    ```xml
    <param-value>classpath:applicationContext.xml</param-value>
    ```
    