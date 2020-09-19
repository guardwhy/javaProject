package cn.guardwhy_02;

public class TeacherData implements Data<Teacher>{
    @Override
    public void insert(Teacher s) {
        System.out.println("保存老师成功" + s);
    }

    @Override
    public void delete(Teacher s) {
        System.out.println("删除老师成功" + s);
    }

    @Override
    public void update(Teacher s) {

    }

    @Override
    public void query() {

    }
}
