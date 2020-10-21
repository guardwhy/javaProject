package cn.guardwhy.domain;

import java.sql.Timestamp;

/**
 * 订单实体类
 */
public class OrderForm {
    private Integer oid; // 主键
    private Integer userId; // 外键
    private String number; // 订单号
    private Timestamp createTime; // 下单时间
    private String note; // 备注信息
    private User user; // 用户信息

    // 无参构造
    public OrderForm() {
    }

    // 带参构造
    public OrderForm(Integer oid, Integer userId, String number, Timestamp createTime, String note) {
        this.oid = oid;
        this.userId = userId;
        this.number = number;
        this.createTime = createTime;
        this.note = note;
    }

    /**
     * get.set方法
     */
    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "OrderForm{" +
                "oid=" + oid +
                ", userId=" + userId +
                ", number='" + number + '\'' +
                ", createTime=" + createTime +
                ", note='" + note + '\'' +
                '}';
    }
}
