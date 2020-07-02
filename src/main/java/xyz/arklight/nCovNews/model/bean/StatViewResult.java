package xyz.arklight.nCovNews.model.bean;

import xyz.arklight.nCovNews.model.DAO.StatStorage;

import java.util.Base64;
import java.util.List;

/**
 * 用来解析数据库中存储的图片/词云
 */
public class StatViewResult {
    private StatStorage storage;

    public StatViewResult(StatStorage statStorage){
        this.storage = statStorage;
    }

    public byte[] getClusterGraph(){
        String pristr = storage.getCluster_graph();
        try{
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] pic = decoder.decode(pristr);
            return pic;
        }catch (Exception e){
            System.out.println("图片base64转回失败！");
            e.printStackTrace();
            return null;
        }
    }

    public byte[] getWordCloud(){
        try{
            String content = storage.getWord_cloud();
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] b_content = decoder.decode(content);
            content = new String(b_content);

            System.out.println(content.substring(0,200));

            //json起始位置，根据文件结构是第二个大括号
            int pstart = content.indexOf("{",content.indexOf("{")+1);
            //json终止位置，根据文件结构是倒数第一个反大括号
            int pend = content.lastIndexOf("}")+1;
            String new_content = content.substring(pstart,pend);

            System.out.println(new_content.substring(0,200));

            byte[] new_bytes = new_content.getBytes("utf-8");
            return new_bytes;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String[] getKeywords(){
        try{
            String kwStr = storage.getKeywords();
            String[] result = kwStr.split(" ");
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
