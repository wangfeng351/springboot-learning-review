### MockMvc
  - 实例的两种形式
    ```
    //第一种
    MockMvcBuilders.standaloneSetup(controller).build()
    //第二种
    MockMvcBuilders.webAppContextSetup(webApplicationContext).build()
    ```
  - 方法分析：
    * 1、mockMvc.perform执行一个请求。
    * 2、MockMvcRequestBuilders.get("XXX")构造一个请求。
    * 3、ResultActions.param添加请求传值
    * 4、ResultActions.accept(MediaType.TEXT_HTML_VALUE))设置返回类型
    * 5、ResultActions.andExpect添加执行完成后的断言。
    * 6、ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情
    *    比如: 此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
    * 7、ResultActions.andReturn表示执行完成后返回相应的结果。
### dependencyManagement
  - 创建多模块时，可以使用dependencyManagement管理pom依赖，只需要时通过 groupId 和 artifactId 引用
  - 当模块太多时，父类的pom中的依赖依然会很多，管理起来也并不是很容易，这时候我们就可以把dependencyManagement放到单独的专门用来管理依赖的POM中，使用import scope就可以很清晰管理依赖了。引用时只需要通过import scope引入就可以了
  - dependencyManagement和dependencies的区别： 前者只是声明依赖，子类不会直接继承。后者是直接注入依赖，子类直接继承
### Spring Mvc
  - @ResponseBody: 
    - 指定返回的数据类型为json
  - @RequestMapping
    - 未指定method属性时，代表get、delete、post等多个请求方法
    - method : 指定请求方法
    - produce: 指定返回数据类型