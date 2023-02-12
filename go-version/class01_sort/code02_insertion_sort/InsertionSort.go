package main

import "log"

/**
 * @Description //TODO $ 插入排序 时间复杂度为O(N^2) 额外空间复杂度O(1）
 * @Author sanyejiantai
 * @Date 2023/2/12 13:14
 **/

func main() {
	arr := []int{2, 3, -2, 9, 11, 7, 23, 13}
	log.Println(arr)
	insertionSort(arr)
	log.Println(arr)
}

func insertionSort(arr []int) {
	if arr == nil || len(arr) < 2 {
		return
	}
	n := len(arr)
	for i := 1; i < n; i++ {
		//for j := i - 1; j >= 0 && arr[j] > arr[j+1]; j-- {
		//	swap(arr, j, j+1)
		//}

		for j := i; j > 0 && arr[j] < arr[j-1]; j-- {
			swap(arr, j, j-1)
		}
	}
}

func swap(arr []int, i int, j int) {
	tmp := arr[i]
	arr[i] = arr[j]
	arr[j] = tmp
}
