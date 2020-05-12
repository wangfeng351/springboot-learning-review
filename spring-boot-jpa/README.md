### 一、搭建JPA
1. 引入依赖： 
```
<dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```
2. 配置数据源：

``` 
jpa:
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQL5InnoDBDialect
    show-sql: true
```
- ddl-auto属性值
  - create每次加载Hibernate时都会删除上一次生成的表（包括数据）
  - create-drop：每次加载Hibernate时都会生成表，但当SessionFactory关闭时，所生成的表将自动删除。
  - update 第一次加载Hibernate时创建数据表（前提是需要先有数据库），以后加载Hibernate时不会删除上一次生成的表，会根据实体更新，只新增字段，不会删除字段（即使实体中已经删除）。 
  - validate 每次加载Hibernate时都会验证数据表结构，只会和已经存在的数据表进行比较，根据model修改表结构，但不会创建新表。