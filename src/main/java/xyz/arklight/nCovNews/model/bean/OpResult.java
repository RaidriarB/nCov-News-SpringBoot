package xyz.arklight.nCovNews.model.bean;

/**
 * 这个类用来返回数据操作的结果。
 * 比如对Websites进行增加和删除，会返回对应的message
 */
public class OpResult {

    public static OpResult SUCCESS = new OpResult(1, "操作成功");
    public static OpResult FAILURE = new OpResult(-1, "操作失败");

    private int code;
    private String message;

    public OpResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
