package cn.guardwhy_02;
/**
 * 实现Data接口方法
 */
public class StudentData implements Data<Student>{
    @Override
    public void insert(Student s) {
        System.out.println("保存学生成功!"+ s);
    }

    @Override
    public void delete(Student s) {
        System.out.println("删除学生成功!" + s);
    }

    @Override
    public void update(Student s) {

    }

    @Override
    public void query() {

    }
}
