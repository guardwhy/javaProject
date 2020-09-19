package cn.guardwhy_01;
/**
泛型方法:
    使用了泛型的方法就是泛型方法。
    泛型方法可以实现功能的扩展性，可以做通用技术功能。

泛型方法的定义格式:
     修饰符 <泛型变量> 返回值类型 方法名称(形参列表){

     }
     泛型变量：一般是 E T K V
     泛型变量一旦申明了，泛型方法中就只能用这个泛型变量了。
总结：
     泛型方法需要先申明泛型变量，后面就只能用这个变量.
     泛型方法的优点是可以让方法的入参接收一切引用数据类型
 */
public class GenericityDemo04 {
    public static void main(String[] args) {
        // 初始化包装类数组
        Integer[] arrs1 = new Integer[]{10, 20, 30, 40};
        // 声明方法
        printArray(arrs1);

        Double[] arrs2 = new Double[]{99.9 , 100.2 , 223.2 , 3.0};
        // 声明方法
        printArray(arrs2);

        // 字符串数组
        String[] names = new String[]{"kobe", "curry", "james", "Rondo"};
        printArray(names);
    }

    public static<E> void printArray(E[] arrs) {
        // 拼接数组的元素内容输出
        StringBuilder sb = new StringBuilder();
        // 添加元素
        sb.append("[");
        for(int i=0; i < arrs.length; i++){
            // 取出数组的元素
            E ele = arrs[i];
            sb.append(i == arrs.length-1? ele:ele+ ", ");
        }
        sb.append("]");
        System.out.println("sb集合:" + sb);
    }
}
