package main

import "fmt"

func main() {
	arr := []int{2, 5, 6, 13, 15, 17, 20}
	res := binarySearch(arr, 20)
	fmt.Println(res)

}

func binarySearch(arr []int, target int) bool {
	if arr == nil || len(arr) == 0 {
		return false
	}
	l := 0
	r := len(arr) - 1

	for l <= r {
		mid := l + (r-l)>>1
		if arr[mid] == target {
			return true
		} else if arr[mid] < target {
			l = mid + 1
		} else {
			r = mid - 1
		}
	}
	return false
}
