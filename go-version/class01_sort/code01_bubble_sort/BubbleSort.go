package main

import "log"

/**
 * @Description //TODO $ 冒泡排序 时间复杂度为O(N^2) 额外空间复杂度O(1）
 * @Author sanyejiantai
 * @Date 2023/2/12 13:14
 **/

func main() {
	arr := []int{2, 3, -2, 9, 11, 7, 23, 13}
	log.Println(arr)
	bubbleSort(arr)
	log.Println(arr)
}

func bubbleSort(arr []int) {
	if arr == nil || len(arr) < 2 {
		return
	}

	n := len(arr)

	for end := n - 1; end > 0; end-- {
		for i := 0; i < end; i++ {
			if arr[i] > arr[i+1] {
				swap(arr, i, i+1)
			}
		}
	}
}

func swap(arr []int, i int, j int) {
	tmp := arr[i]
	arr[i] = arr[j]
	arr[j] = tmp
}
