package xyz.arklight.nCovNews.model.DAO;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 实体类，对应数据库中的statistics_result表
 */
@Entity
@Table(name="statistics_result")
public class StatResult {

    @Id
    @NotNull
    private Long no;

    //这条记录更新时间
    private String time_of_update;

    //这篇正文的分类
    private int category;

    //可信度
    private double confidence;

    //热点度
    private double hot_spot_degree;

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public String getTime_of_updage() {
        return time_of_update;
    }

    public void setTime_of_updage(String time_of_updage) {
        this.time_of_update = time_of_updage;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    public double getHot_spot_degree() {
        return hot_spot_degree;
    }

    public void setHot_spot_degree(double hot_spot_degree) {
        this.hot_spot_degree = hot_spot_degree;
    }

    @Override
    public String toString() {
        return "StatResult{" +
                "no=" + no +
                ", time_of_updage='" + time_of_update + '\'' +
                ", category=" + category +
                ", confidence=" + confidence +
                ", hot_spot_degree=" + hot_spot_degree +
                '}';
    }
}
