package com.course.server;

import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/",description = "这是我的全部post请求")
@RequestMapping("/v1")
public class MyPostMethod {
    private static Cookie cookie;//这个变量是用来装我们cookies信息的
    //用户登录成功获取到cookies，然后在访问其他接口获取到列表
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，成功后获取cookies信息",httpMethod = "POST")//描述这个方法是做什么的、访问方式
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName",required = true) String userName,    //value：调用接口时前端要传的参数，required：是否必传
                        @RequestParam(value = "password",required = true) String password){
        if (userName.equals("zhangsan") && password.equals("123456")){
            cookie = new Cookie("login","true");
            response.addCookie(cookie);
            return "恭喜你登录成功了!";
        }
        return "用户名或密码错误！";

    }


    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表",httpMethod = "POST")//描述这个方法是做什么的、访问方式
    public String getUserList(HttpServletRequest request,
                              @RequestBody User u){
        User user;
        //获取cookies
        Cookie[] cookies = request.getCookies();
        //验证cookies是否合法
        for(Cookie c : cookies){
            if (c.getName().equals("login")
                    && c.getValue().equals("true")
                    && u.getUserName().equals("zhangsan")
                    && u.getPassword().equals("123456")
                    ){
                user = new User();
                user.setName("lisi");//返回用户列表
                user.setAge("18");
                user.setSex("man");
                return user.toString();

            }
        }
        return "参数不合法";
    }

}
