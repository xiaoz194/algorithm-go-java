package main

import "log"

/*
*
  - @Description //TODO $ 前缀和数组 假设又一个数组arr 用户总是频繁查询arr中某个范围的累加和 如何使这种查询变得快捷？
    TODO $ 二分法的时间复杂度是logn
  - @Author sanyejiantai
  - @Date 2023/2/12 13:14
    *
*/
func main() {
	arr := []int{2, 3, 1, 5, -2}
	log.Println(arr)
	sum := preSumArray(arr)

	l := 1
	r := 3
	log.Println("数组范围[", l, "...", r, "]上的累加和: ", getSum(sum, l, r))

	l = 2
	r = 4
	log.Println("数组范围[", l, "...", r, "]上的累加和: ", getSum(sum, l, r))

	l = 0
	r = 4
	log.Println("数组范围[", l, "...", r, "]上的累加和: ", getSum(sum, l, r))

	l = 0
	r = 2
	log.Println("数组范围[", l, "...", r, "]上的累加和: ", getSum(sum, l, r))

}

// 原始数组arr[l...r]范围上的累加和返回
// 其实是利用前缀和数组sum加工得到
func getSum(sum []int, l int, r int) any {
	if l == 0 {
		return sum[r]
	} else {
		return sum[r] - sum[l-1]
	}
}

func preSumArray(arr []int) []int {
	n := len(arr)
	sum := make([]int, n)
	sum[0] = arr[0]
	for i := 1; i < n; i++ {
		//0~i-1范围上的前缀和 + arr[i] = 0~i范围上的前缀和
		sum[i] = sum[i-1] + arr[i]
	}
	return sum
}
