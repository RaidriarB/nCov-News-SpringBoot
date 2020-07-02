package xyz.arklight.nCovNews.model.DAO;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 实体类，用来对应数据库中websites表
 */
@Entity
public class Websites {


    //主键自动增长策略问题，默认是不符合要求的
    //如果不设置可能会造成Table 'covid_db.hibernate_sequence' doesn't exist错误。
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;
    @NotNull
    private String start_url;
    @NotNull
    private String name;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getStart_url() {
        return start_url;
    }

    public void setStart_url(String start_url) {
        this.start_url = start_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "websites{" +
                "uid=" + uid +
                ", start_url='" + start_url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
