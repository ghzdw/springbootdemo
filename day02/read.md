**日志门面**:
JCL（Jakarta  Commons Logging）    
SLF4j（Simple  Logging Facade for Java）    
jboss-logging
**日志实现**:
Log4j
JUL（java.util.logging）  
Log4j2  
Logback

springboot采用的是slf4j+logback

log4j、logback、slf4j都是出自一个人，slf4j的出现是为了把不同日志框架抽象出来共同的接口

**问题1：不同的日志实现，如何面向slf4j编程（使用单个日志实现框架）**
![avatar](src/main/resources/static/images/slf4j.png)
每一个日志的实现框架都有自己的配置文件。使用slf4j以后，配置文件还是做成日志实现框架自己本身的配置文件；
**问题2：使用多个日志框架，如何整合为slf4j**
![avatar](src/main/resources/static/images/legacy.png)


