# Spring Petclinic项目介绍

**本项目基于spring-petclinic-rest项目改造，主要加入mybatis等示例，以及增加中文语言支持**

官网地址: [https://projects.spring.io/spring-petclinic/](https://projects.spring.io/spring-petclinic/)

> PetClinic demonstrates the use of a Spring Boot with Spring MVC and Spring Data. The PetClinic has an old and varied history dating right back to the beginning of the Spring Framework. It started life as a demonstration of nearly all the common things that you could do with Spring, back when it was possible to conceive of such a demonstration. These days it is a very small slice of what you could achieve, but the community has a soft spot for it, so it's nice to see it still going after all this time, so we hope you enjoy it too.

翻译：
 
> 宠物诊所(PetClinic)项目演示了基于Spring Boot整合Spring MVC和Spring Data。 宠物诊所项目有长久的历史，可以追溯到Spring框架诞生的时候。它最初用来演示你可以用Spring做的几乎所有的事情，那时候你还可以假想这样的演示。现在它仅仅只是你可以实现的很小一部分，但是社区对它情有独终，所以很高兴可以看到它在这么长时间依然存在，也希望你能享受它。

![PetClinic Snapshot](https://cloud.githubusercontent.com/assets/838318/19727082/2aee6d6c-9b8e-11e6-81fe-e889a5ddfded.png)

## PetClinic示例应用需求

这个应用要求是实现一个可以通过Ｗeb访问的信息系统（在线宠物诊所）。这个应用的用户是宠物诊所的雇员，他们在工作过程中需要查看和管理有关宠物医生、客户及其宠物的信息。示例应用程序提供以下功能（用例）。

### 用例

* 查看宠物医生和他们的特长（列表展示）
* 查看有关宠物主人的信息
* 更新有关宠物主人的信息
* 向系统中增加一个宠物主人
* 查看有关宠物的信息
* 更新有关宠物的信息
* 向系统中增加一个宠物
* 查看有关宠物访问历史的信息
* 添加有关宠物访问历史的信息

### 业务规则

* 一个主人不能有多个具有相同名称(不区分大小写)的宠物

## 设计

### ER图设计

![ER Model](../db/petclinic-ermodel.png)

## 参考
- [Spring PetClinic项目官方介绍](https://projects.spring.io/spring-petclinic/)
- [官方Spring Petclinic项目地址 - 原版](https://github.com/spring-projects/spring-petclinic)