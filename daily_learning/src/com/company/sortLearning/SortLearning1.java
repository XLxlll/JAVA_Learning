package com.company.sortLearning;

/**
 *排序算法
 */
public class SortLearning1 {

    public static void main(String[] args) {
        //int[] arr = {4,5,6,1,3,2};
        SortLearning1 sortLearning1 = new SortLearning1();
        //sortLearning1.insertionSort(arr,arr.length);
       // sortLearning1.bubbleSort(arr,arr.length);
        //sortLearning1.selectionSort(arr,arr.length);
        int[] arr = {25,84,21,47,15,27,68,35,20};
       sortLearning1.quicksort(arr,0,arr.length-1);


    }
    /**
     * @description 冒泡排序
     * @param arr 数组
     * @param n  数组长度
     * @return void
     * @author Geek_Ling
     * @date 2020/8/1
     */

    public void bubbleSort(int[] arr,int n){
        if (n <= 1) return;
        //数组中有n个元素就要进行n次冒泡
        for (int i = 0; i < n ; i++) {
           //提前退出冒泡循环的标志位
            boolean flag = false;
            //相邻两个元素进行比较，
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]){
                   int temp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = temp;
                    //发生了数据交换
                    flag = true;
                }
            }
            //如果没有数据交换，提前退出
            if (!flag) break;
        }
    }
    /**
     * @description 插入排序
     * @param arr 数组
     * @param n 数组个数
     * @return void
     * @author Geek_Ling
     * @date 2020/8/1
     */

    public void insertionSort(int[] arr ,int n){
        if (n <= 1) return;
        //未排序区间
        for (int i = 1; i < n; i++) {
            int value = arr[i];
            int j = i-1;
            //查找插入位置
            for (; j >=0; j--) {
                if (arr[j] < value){
                    break;
                }else {
                    arr[j+1] =arr[j];
                }
            }
            arr[j+1] = value;
        }
    }
    /**
     * @description
     * @param arr
     * @param n
     * @return void
     * @author Geek_Ling
     * @date 2020/8/1
     */

    public void selectionSort(int[] arr ,int n){
        if (n <= 1) return;
        //为什么是n-1，因为前n-1个排好了，就不需要找找最小的那个了
        // 未完全确定当前最小元素之前，任何交换都没有意义，设置一个变量minIndex仅存储较小元素的下标，遍历完未排序区间之后，执行交换操作
        for (int i = 0; i <n-1 ; i++) {

            int minIndex = i;
            for (int j = i+1;j<n;j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            //考虑当前i是不是最小元素对应的下标，若是，则i++，若不是，则交换
            if (i != minIndex){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }

        }
    }
    /**
     * @description 快排
     * @param arr
     * @param left
     * @param right
     * @return void
     * @author Geek_Ling
     * @date 2020/8/1
     */

    public void quicksort(int[] arr,int left,int right){
        if (left>right) return;
       int i = left,j = right;
        int temp = arr[i];
       while (i<j){
          while (i<j&&arr[j]>temp) j--;
          if (i<j) arr[i++] = arr[j];
          while (i<j&&arr[i]<temp) i++;
          if (i<j) arr[j--] = arr[i];
       }
       arr[i] = temp;

       quicksort(arr,left,i-1);
       quicksort(arr,i+1,right);

    }

}
