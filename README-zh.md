# spring-petclinic-mybatis

基于mybatis的 [spring-petclinic](http://projects.spring.io/spring-petclinic/) (源于spring官方的一个宠物诊所网站示例，用来演示`SpringBoot`, `SpringMVC`和`SpringData`的使用)。

## 特点
* SpringBoot
* SpringMVC (REST API)
* MyBatis (todo)
* swagger-ui
* docker测试和部署
* MySQL

## 安装

### 本地安装

* Java 8
* gradle

运行后台

```bash
gradle bootRun
```
可浏览器访问http://localhost:9966测试REST API

运行前端

```bash
git clone https://github.com/spring-petclinic/spring-petclinic-rest.git

cd spring-petclinic-rest
npm install
ng serve
``
