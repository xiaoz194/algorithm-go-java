package main

import "fmt"

func main() {
	arr := []int{2, 5, 11, 4, 6, 7, 9, 13, 3}
	insertionSort(arr)
	fmt.Println(arr)
}

func insertionSort(arr []int) {
	if arr == nil || len(arr) < 2 {
		return
	}
	n := len(arr)
	for i := 1; i < n; i++ {
		for j := i - 1; j >= 0 && arr[j] > arr[j+1]; j-- {
			swap(arr, j, j+1)
		}
	}
}

func swap(arr []int, i int, j int) {
	tmp := arr[i]
	arr[i] = arr[j]
	arr[j] = tmp
}
