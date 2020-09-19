package cn.guardwhy_02;
/**
 * 字符串拼接(升级)
 */
public class StringBuilderDemo04 {
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
        // StringBuilder按照要求进行拼接,并把结果转成String返回
        StringBuilder sb = new StringBuilder();
        // 添加"["
        sb.append("[");
        // 遍历字符串
        for(int i=0; i<arr.length; i++){
            if(i == arr.length-1){
                // 添加元素
                sb.append(arr[i]);
            }else {
                sb.append(arr[i]).append(", ");
            }
        }
        // 添加"]"
        sb.append("]");
        // 通过toString()就可以实现把StringBuilder转换为String
        String s = sb.toString();
        // 返回字符串
        return s;
    }
}
