package cn.guardwhy_01;
/**
 *字符串拼接
 */
public class StringDemo05 {
    public static void main(String[] args) {
        // 初始化数组
        int[] arr = {1, 2, 3, 5, 6};
        // 调用方法
        String s = arrayToString(arr);
        // 输出结果
        System.out.println("s的字符串:" + s);
    }

    /**
     * 把int数组中的数据按照指定格式拼接成一个字符串返回
     * @param arr
     * @return
     */
    public static String arrayToString(int[] arr) {
        //在方法中遍历数组,按照要求进行拼接
        String s = "";
        s +="[";
        // 遍历字符串
        for(int i=0; i<arr.length; i++){
            if(i==arr.length-1){
                s += arr[i];
            }else {
                s += arr[i];
                s += ", ";
            }
        }
        s += "]";

        return s;
    }
}
