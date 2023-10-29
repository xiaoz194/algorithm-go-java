package class02_sort2;


/**
 * @Classname Code03_NetherlandsFlag_Simple
 * @Description 荷兰国旗问题
 * 给定一个数组arr，和一个数num，请把小于num的数放在数组的左边，等于num的数放在数组的中间，
 * 大于num的数放在数组的右边。
 * 要求额外空间复杂度O(1)，时间复杂度 O(N)
 *  如：3,5,6,3,4,5,2,6,9,0 num=5
 *
 * 采用三指针法：i为移动指针，从0开始，j代表指向的范围是<区，从-1开始，向右方扩充
 * k代表指向的范围是>区，从arr.length（数组最后一个元素的下一个）开始，向左方扩充
 * 中间剩余的空间就是=区
 * 1) [i]<num [i]和<区的下一个数交换，<区右扩，i++
 * 2) [i]==num i++
 * 3) [i]>num [i]和>区的前一个数交换，>区左扩，i原地不变.不变的原因是从后面交换过来的数不确定是不是会比num大
 * 还是小，因为这个数没有看过，所以i不能变，需要看一遍这个换过来的数
 * 终止条件 当>区和i相遇的时候，即i==k时，结束。
 * @Date 2021/10/30
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class Code05_NetherlandsFlag {

    public static void main(String[] args) {
        int[] arr = {4,2,7,8,3,5,1,9,11,5,3,5,5};
        partition(arr,5);
        for(int e:arr){
            System.out.print(e+" ");
        }
    }

    public static void partition(int[] arr,int num){
        int i=0,j=-1,k=arr.length;
        while(i<k){
            if(arr[i]==num)
                i++;
            else if(arr[i]<num)
                swap(arr,i++,++j);
            else
                swap(arr,i,--k);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
