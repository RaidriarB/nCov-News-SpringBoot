package xyz.arklight.nCovNews.model.bean;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Websites {

    @Id
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
