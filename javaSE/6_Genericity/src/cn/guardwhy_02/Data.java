package cn.guardwhy_02;
/**
 * 数据泛型接口
 */
public interface Data<E> {
    // 插入方法
    void insert(E s);
    // 删除方法
    void delete(E s);
    // 修改方法
    void update(E s);
    // 查询方法
    void query();
}
