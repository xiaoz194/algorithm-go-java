package class02_sort2;

/**
 * @Classname Code03_NetherlandsFlag_Simple
 * @Description 荷兰国旗问题简化版
 * 给定一个数组arr，和一个数num，请把小于等于num的数放在数 组的左边，大于num的 数放在数组的右边。
 * 要求额外空间复杂度O(1)，时间复杂度O(N)
 * 如：4，2，7，8，3，5，1，9 num=5
 * 结果：4 2 3 5 1 8 7 9
 * 采用双指针法：i为移动指针，从0开始，j代表指向的范围是<=区，从-1开始
 * 1) [i]<=num [i]和<=区的下一个数交换，<=区合并扩充，i++
 * 2) [i]>num i++
 * @Date 2021/10/30
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code04_NetherlandsFlag_Simple {

    public static void main(String[] args) {
        int[] arr = {4,2,7,8,3,5,1,9};
        partition(arr,5);
        for(int e:arr){
            System.out.print(e+" ");
        }
    }

    public static void partition(int[] arr,int num){
        int i,j=-1;
        for(i=0;i<arr.length;i++){
            if(arr[i]<=num){
                int tmp = arr[i];
                arr[i] = arr[j+1];
                arr[j+1] = tmp;
                j++;
            }
        }
    }

}
