# spring-petclinic-mybatis

基于mybatis的 [spring-petclinic](http://projects.spring.io/spring-petclinic/) (源于spring官方的一个宠物诊所网站示例)。

*这个项目仅供参考，个人觉得有许多地方的设计需要重构*

## 示例内容
* SpringBoot
* SpringMVC (REST API)
* MyBatis
* MySQL
* swagger-ui （springfox)
* Spring Rest Docs测试驱动生成文档
* Drone CI自动集成
* SonarCloud代码质量分析


## 安装

### 本地安装

* Java 8
* gradle

运行后台

```bash
git clone https://github.com/artificerpi/spring-petclinic-mybatis.git
cd spring-petclinic-mybatis
docker-compose up -d

gradle bootRun
```
可浏览器访问http://localhost:9966/petclinic/ 测试REST API

运行前端 (需安装nodejs和angular-cli)

```bash
# 使用npm安装最新angular-cli
npm uninstall -g angular-cli @angular/cli
npm cache clean
npm install -g @angular/cli@latest

git clone https://github.com/spring-petclinic/spring-petclinic-rest.git

cd spring-petclinic-rest
npm install
ng serve
```

运行成功后打开浏览器访问http://localhost:4200 即可

<img width="1427" alt="spring-petclinic-angular2" src="https://cloud.githubusercontent.com/assets/838318/23263243/f4509c4a-f9dd-11e6-951b-69d0ef72d8bd.png">

## 参考
* https://github.com/spring-projects/spring-petclinic
