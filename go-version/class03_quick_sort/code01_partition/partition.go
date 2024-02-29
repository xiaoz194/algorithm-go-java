package main

import "log"

func main() {
	arr := []int{2, 3, 11, 7, 4, 12, 14, 5, 9, 11, 7, 23, 13}
	log.Println(arr)
	partition(arr, 0, len(arr)-1, 7)
	log.Println(arr)
}

func partition(arr []int, l int, r int, n int) {
	if arr == nil || len(arr) < 2 {
		return
	}
	ptr := l - 1
	for i := l; i <= r; i++ {
		if arr[i] <= n {
			ptr++
			swap(arr, i, ptr)
		}
	}
}

func swap(arr []int, i int, j int) {
	tmp := arr[i]
	arr[i] = arr[j]
	arr[j] = tmp
}
