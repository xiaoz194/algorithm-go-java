package main

import "fmt"

// 寻找大于等于num的最左位置
func main() {
	arr := []int{2, 5, 6, 6, 6, 6, 6, 13, 15, 17, 20}
	res := bsNearLeft(arr, 6)
	fmt.Println(res)
}

func bsNearLeft(arr []int, target int) int {
	if arr == nil || len(arr) == 0 {
		return -1
	}
	l := 0
	r := len(arr) - 1
	ans := -1
	for l <= r {
		mid := l + (r-l)>>1
		if arr[mid] >= target {
			ans = mid
			r = mid - 1
		} else {
			l = mid + 1
		}
	}
	return ans
}
