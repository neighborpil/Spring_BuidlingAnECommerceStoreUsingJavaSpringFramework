# Spring_BuidlingAnECommerceStoreUsingJavaSpringFramework
hands on codes
-----------------
##Libraries
- JQuery: 3.5.1
- Pooper: 1.16.1
- Bootstrap: 4.6.1
-------------------------
### 파일 저장시 webapps폴더 밖에 파일을 두는 법
 - server.xml에서 host 영역 안에 파일 저장할 리얼 경로와 접근할 웹 경로를 매핑시켜 준다.
 - **<Context docBase="C:\codes\Utils\apache-tomcat-9.0.40\images"  path="/images" />**
```

  <Host name="localhost"  appBase="webapps"
            unpackWARs="true" autoDeploy="true">

		**<Context docBase="C:\codes\Utils\apache-tomcat-9.0.40\images"  path="/images" />**
        <!-- SingleSignOn valve, share authentication between web applications
             Documentation at: /docs/config/valve.html -->
        <!--
        <Valve className="org.apache.catalina.authenticator.SingleSignOn" />
        -->

        <!-- Access log processes all example.
             Documentation at: /docs/config/valve.html
             Note: The pattern used is equivalent to using pattern="common" -->
        <Valve className="org.apache.catalina.valves.AccessLogValve" directory="logs"
               prefix="localhost_access_log" suffix=".txt"
               pattern="%h %l %u %t &quot;%r&quot; %s %b" />

      </Host>
```
