package xyz.arklight.nCovNews.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.arklight.nCovNews.Util.IPUtil;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用来测试IPUtil工具类
 */
@RestController
@RequestMapping("/ip")
public class IPTestController {

    @RequestMapping("test")
    public String getIP(HttpServletRequest request){
        System.out.println("ip");
        String datetime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        System.out.println("当前时间为："+datetime);
        return IPUtil.getIpAddr(request);
    }
}
