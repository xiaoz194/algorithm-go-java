package main

import (
	"fmt"
)

func main() {
	arr := []int{2, 5, 11, 4, 6, 7, 9, 13, 3}
	bubbleSort(arr)
	fmt.Println(arr)

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

func swap(arr []int, i int, i2 int) {
	tmp := arr[i]
	arr[i] = arr[i2]
	arr[i2] = tmp
}
