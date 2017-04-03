package com.silence.controller

import org.springframework.context.annotation.ComponentScan
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import com.silence.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RequestMapping
import javax.validation.Valid
import org.springframework.web.bind.annotation.RequestMethod
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiImplicitParams
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiResponses
import io.swagger.annotations.ApiResponse
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.ui.Model
import com.silence.service.UserService

@ComponentScan
@Controller
@Api(value = "用户相关操作")
class UserController @Autowired()(private val userService : UserService){
    
    private final val LOGGER:Logger = LoggerFactory.getLogger(classOf[UserController])
    
    @ResponseBody
    @ApiOperation("查询用户信息")
    @ApiImplicitParams(Array(new ApiImplicitParam(paramType="header",name="username",dataType="String",required=true,value="用户姓名",defaultValue="张三")))
    @ApiResponses(Array(new ApiResponse(code=400,message="请求参数没填好"),new ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")))
  	@RequestMapping(value = Array("/find/{username}"), method = Array(RequestMethod.GET))
    def find(@PathVariable(value = "username") username: String) = {
        userService.findUserByUsername(username)        
    }
    
    @RequestMapping(value = Array("/index"), method = Array(RequestMethod.GET))
    def index(model: Model): String = {
        println("index action")
        "index"
    }
}