package main

import "log"

/**
 * @Description //TODO $ 有序数组中寻找小于等于num的最右位置
 * @Author sanyejiantai
 * @Date 2023/2/12 14:33
 **/
func main() {
	arr := []int{1, 5, 9, 9, 9, 9, 12, 13, 24, 48}
	search := 9
	log.Println("数组为: ", arr)
	log.Println(">=", search, "的最左位置下标： ", lessEqualMostRight(arr, search))
}

func lessEqualMostRight(arr []int, search int) int {
	ans := -1
	if arr == nil || len(arr) < 1 {
		return ans
	}
	l := 0
	r := len(arr) - 1
	m := 0
	for l <= r {
		m = l + (r-l)>>1
		if arr[m] <= search {
			ans = m
			l = m + 1
		} else {
			r = m - 1
		}
	}
	return ans
}
