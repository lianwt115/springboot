# springboot
springboot学习
基本RESTful API,mongdb

#1.接口文档在线生成  Swagger2 集成操作

依赖:

            implementation "io.springfox:springfox-swagger2:2.9.2"
            implementation "io.springfox:springfox-swagger-ui:2.9.2"
    
配置:

             @Configuration
             @EnableSwagger2 //添加swagger启用注解
             class Swagger2 {
                @Bean
                fun createRestApi(): Docket {
                              return Docket(DocumentationType.SWAGGER_2)
                                      .apiInfo(apiInfo())
                                      .select()
                                      .apis(RequestHandlerSelectors.basePackage("com.lwt.swg2"))  // 注意修改此处的包名
                                      .paths(PathSelectors.any())
                                      .build()
                          }
                          private fun apiInfo(): ApiInfo {
                              return  ApiInfoBuilder()
                                      .title("Swagger2使用测试")
                                      .description("API接口文档")
                                      .version("0.0.1")
                                      .build()
                          }
                      }
          
         
Controller:

                @Api(description = "测试类")
                @RestController
                @RequestMapping("/test")
                class Test2Controller {
                    @RequestMapping("/get")
                    @ApiOperation(value = "基本测试", notes = "使用说明", httpMethod = "GET",response = BaseHttpResponse::class)
                    @ApiImplicitParam(name = "name", value = "姓名",dataTypeClass = BaseHttpResponse::class)
                    fun deleteDevice(@RequestParam("name") name:String): BaseHttpResponse<String> {
                        val r = BaseHttpResponse<String>()
                        r.data = name.plus("我爱你")
                        return r
                    }
                }

启动:

      访问:http://localhost:8080/swagger-ui.html
