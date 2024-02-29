package main

import "log"

func main() {
	arr := []int{2, 3, 11, 7, 4, 7, 12, 14, 5, 9, 11, 7, 23, 13}
	log.Println(arr)
	partition(arr, 0, len(arr)-1, 7)
	log.Println(arr)
}

func partition(arr []int, l, r, n int) {
	if arr == nil || len(arr) < 2 {
		return
	}
	ptr1 := l - 1
	ptr2 := r + 1
	for i := l; i < ptr2; {
		if arr[i] < n {
			ptr1++
			swap(arr, i, ptr1)
			i++
		} else if arr[i] > n {
			ptr2--
			swap(arr, i, ptr2)
		} else {
			i++
		}
	}

}

func swap(arr []int, i int, j int) {
	tmp := arr[i]
	arr[i] = arr[j]
	arr[j] = tmp
}
