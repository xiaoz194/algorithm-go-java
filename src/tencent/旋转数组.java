package question;

/**
 * @Classname 旋转数组
 * @Description TODO
 * @Date 2022/8/17
 * @Created by sanyejiantai qq:2043439620 email:hayami_sora@163.com
 */
public class 旋转数组 {
    //1 全部翻转
    //2 翻转前k位 如果k》arr.length , k%=arr.length
    //3 翻转后k位
    public void rotateTwo(int[] arr,int k){
        k %= arr.length;
        reverse(arr,0,arr.length-1);
        reverse(arr,0,k-1);
        reverse(arr,k,arr.length-1);

    }

    private void reverse(int[] arr, int l, int r) {
        while(l<r){
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
         }
    }

}
