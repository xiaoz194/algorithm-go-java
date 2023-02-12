package main

import "log"

/**
 * @Description //TODO $ 二分搜索 在有序数组中找到num的位置下标 没有找到返回-1
 * @Author sanyejiantai
 * @Date 2023/2/12 14:01
 **/
func main() {
	arr := []int{1, 2, 3, 5, 7, 9, 10, 12, 15}
	num := 3
	res := binarySearch(arr, num)
	log.Println(res)
}

func binarySearch(arr []int, num int) int {
	if arr == nil || len(arr) < 2 {
		return -1
	}
	l := 0
	r := len(arr) - 1
	m := 0
	for l <= r {
		m = l + (r-l)>>1
		if arr[m] == num {
			return m
		} else if arr[m] < num {
			l = m + 1
		} else {
			r = m - 1
		}
	}
	return -1
}
