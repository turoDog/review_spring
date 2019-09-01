package com.nasus.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Project Name:review_spring <br/>
 * Package Name:com.nasus.hello <br/>
 * Date:2019/8/25 18:49 <br/>
 *
 * @author <a href="turodog@foxmail.com">chenzy</a><br/>
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
        model.addAttribute("data", "Hello World");
        return "hello";
    }

}
