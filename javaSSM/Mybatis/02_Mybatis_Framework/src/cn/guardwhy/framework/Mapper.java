package cn.guardwhy.framework;
/**
 * 封装UserMapper.xml属性
 */
public class Mapper {
    private String namespace; // 封装接口名
    private String id; // 方法名
    private String resultType; // 返回实体类类型
    private String sql; // 要执行的SQL语句

    /**
     * get.set方法
     * @return
     */
    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    @Override
    public String toString() {
        return "Mapper{" +
                "namespace='" + namespace + '\'' +
                ", id='" + id + '\'' +
                ", resultType='" + resultType + '\'' +
                ", sql='" + sql + '\'' +
                '}';
    }
}
