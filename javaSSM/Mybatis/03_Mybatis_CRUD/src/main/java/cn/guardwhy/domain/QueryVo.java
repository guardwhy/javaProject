package cn.guardwhy.domain;
/**
 * 包装类
 */
public class QueryVo {
    private User user; // 包含用户对象
    private String start; // 开始日期
    private String end; // 结束日期

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
