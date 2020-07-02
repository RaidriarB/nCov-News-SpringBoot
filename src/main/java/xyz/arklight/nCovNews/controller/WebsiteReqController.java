package xyz.arklight.nCovNews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.arklight.nCovNews.Util.IPUtil;
import xyz.arklight.nCovNews.model.DAO.WebsiteReq;
import xyz.arklight.nCovNews.model.bean.OpResult;
import xyz.arklight.nCovNews.service.WebsiteReqService;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(path = "/webreq")
public class WebsiteReqController {
    @Autowired
    WebsiteReqService service;

    @RequestMapping(path = "/{op}/{url}/{name}")
    public OpResult WebReq(HttpServletRequest request,
                           @PathVariable String op,
                           @PathVariable String url,
                           @PathVariable String name){

        WebsiteReq wreq = new WebsiteReq();

        try{
            //获取客户端IP
            //IP获取失败则使用默认值
            String ip = "";
            try{
                ip = IPUtil.getIpAddr(request);
                System.out.println("客户端IP为："+ip);

            }catch (Exception e){
                e.printStackTrace();
                System.out.println("IP 获取失败！");
                ip = "0.0.0.0";
            }

            //获取当前时间，格式和Mysql中datetime格式相同
            //示例： 2019-03-05 01:53:56
            String datetime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
            System.out.println("当前时间为："+datetime);

            //获取操作形式：add或delete
            //如果不是这两者直接返回出错
            if(op.equals("add")){
                wreq.setOp(true);
            }else if(op.equals("delete")){
                wreq.setOp(false);
            }else{
                System.out.println("操作不合法！");
                return OpResult.FAILURE;
            }

            wreq.setIp(ip);
            wreq.setRdtime(datetime);
            wreq.setName(name);
            wreq.setSurl(url);

            //写入数据库操作
            try{
                service.insertByWebsiteReq(wreq);
            }catch (Exception e){
                System.out.println("数据库操作失败!");
                e.printStackTrace();
                return OpResult.FAILURE;
            }

        }catch (Exception e){
            System.out.println("未知错误");
            e.printStackTrace();
            return OpResult.FAILURE;
        }
        return OpResult.SUCCESS;
    }


}
