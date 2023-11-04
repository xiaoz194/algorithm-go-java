package class02_sort2;


/** 基数排序 桶排序
 * 基数排序是桶排序的扩展，他的基本思想是：将整数按位切割成不同的数字，然后按每个位数分别比较。
 * 具体做法是：将所有待比较数值统一为同样的位数长度，数位较短的数前边补零。然后，从最低位开始，依次进行一次排序，这样从最低位排序一直到最高位排序完成后，就变成一个有序数列。
 */

public class Code10_RadixSort {

    public static void main(String[] args) {
        int[] arr = new int[]{14, 23, 210, 170, 37,97};
        int maxDigest = getMaxDigest(arr);
        System.out.println(maxDigest);
        radixSort(arr,maxDigest);
        for(int e:arr){
            System.out.print(e+" ");
        }
    }

    // 拿到数组中最大的数有几位 找出最大位数，确定进行几次位排序
    private static int getMaxDigest(int[] arr) {
        int maxDigest = 0;
        for (int i = 0; i < arr.length; i++) {
            int ans = 0;
            int now = arr[i];
            while(now!=0) {
                now /= 10;
                ans += 1;
            }
            maxDigest = Math.max(maxDigest,ans);
        }
        return maxDigest;
    }

    public static void radixSort(int[] arr, int maxDigest) {
        //定义一个二维数组，表示10个桶，每个桶就是一个一位数组
        //说明:
        //1.二维数组包含10个一位数组（因为每一位对10取余的范围都是0-9)
        //2.为了防止放入数的时候，数据溢出，则每一个一位数组(桶)，大小定义为arr.length(可能出现整个数组的数据全放到一个桶中)。
        //3.明确：基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length]; // 桶
        //为了记录每个桶当中实际存放了多少数据，我们定义一个一位数组来记录每个桶的每次被放入的数据个数
        //可以这样理解：比如 bucketElementCounts[0],记录的就是bucket[0]桶的放入数据个数
        int[] elementCount = new int[10]; // 0～9 的每个桶中实际存放了多少数据
        int a = 1;
        for(int i=0;i<maxDigest;i++) {
            // 数据放入桶
            for(int j=0;j<arr.length;j++){
                int element = (arr[j]/a) % 10;
                bucket[element][elementCount[element]] = arr[j];
                elementCount[element]++;
            }
            int index=0;
            // 从桶中取出数放回arr 完成一轮排序
            for(int j=0;j<elementCount.length;j++){
                if(elementCount[j]!=0){
                    for(int k=0;k<elementCount[j];k++,index++){
                        arr[index]=bucket[j][k];
                    }
                }
                elementCount[j]=0;
            }
            a=a*10;
        }
    }

}
