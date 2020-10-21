package cn.guardwhy.domain;
/**
 * 用户拓展信息类
 */
public class UserInfo {
    private Integer id; // 主键
    private Double height; // 身高
    private Double weight; // 体重
    private Boolean married; // 是否结婚

    private User user; // 用户的基本信息

    /**
     * 无参构造
     */
    public UserInfo() {
    }

    /**
     * 带参构造
     */
    public UserInfo(Integer id, Double height, Double weight, Boolean married) {
        this.id = id;
        this.height = height;
        this.weight = weight;
        this.married = married;
    }

    /**
     * get.set方法
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", height=" + height +
                ", weight=" + weight +
                ", married=" + married +
                ", user=" + user +
                '}';
    }
}
