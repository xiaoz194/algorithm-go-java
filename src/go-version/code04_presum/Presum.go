package main

import "fmt"

func main() {
	arr := []int{2, 5, 11, 4, 6, 7, 9, 13, 3}
	pre := preSumArr(arr)
	fmt.Println(getSum(pre, 2, 3))
}

func preSumArr(arr []int) []int {
	sum := make([]int, len(arr))
	sum[0] = arr[0]
	for i := 1; i < len(arr); i++ {
		sum[i] = sum[i-1] + arr[i]
	}
	return sum
}

func getSum(sum []int, l int, r int) int {
	if l == 0 {
		return sum[r]
	} else {
		return sum[r] - sum[l-1]
	}
}
