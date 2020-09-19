package cn.guardwhy_03;

/**
 * 判断两个数组内容是否相等
 */
public class ArrayCompare05 {
    public static void main(String[] args) {
        // 定义两个数组,分别使用静态初始化
        int[] arr = {11, 22, 33, 44, 55};
        int[] arr2 = {11, 22, 33, 44, 5};

        // 调用方法,用变量接收
        boolean flag = compare(arr, arr2);
        // 输出结果
        System.out.println("两个数组的内容是:" + flag);
    }

    /**
     * 定义一个方法,用于比较两个数组的内容是否相等
     * @param arr
     * @param arr2
     * @return
     */
    public static boolean compare(int[] arr, int[] arr2) {
        //比较长度
        if(arr.length != arr2.length){
            return false;
        }

        //其次遍历，比较两个数组中的每一个元素，只要有元素不相同，返回false
        for(int i=0; i< arr.length; i++){
            // 条件判断
            if(arr[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
}
