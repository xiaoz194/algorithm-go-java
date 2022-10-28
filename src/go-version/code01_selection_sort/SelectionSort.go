package main

import "fmt"

func main() {
	arr := []int{2, 5, 11, 4, 6, 7, 9, 13, 3}
	selectionSort(arr)
	fmt.Println(arr)
}

func selectionSort(arr []int) {
	if arr == nil || len(arr) < 2 {
		return
	}
	n := len(arr)
	for i := 0; i < n-1; i++ {
		minIndex := i
		for j := i + 1; j < n; j++ {
			if arr[j] < arr[minIndex] {
				minIndex = j
			}
		}
		swap(arr, i, minIndex)
	}
}

func swap(arr []int, i int, index int) {
	tmp := arr[i]
	arr[i] = arr[index]
	arr[index] = tmp
}
