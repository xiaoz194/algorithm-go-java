package main

import "fmt"

// arr中 一定有一种数出现奇数次，其他数都出现偶数次，返回这种数
func main() {
	arr := []int{4, 3, 7, 2, 7, 2, 3, 2, 7, 2, 3, 3, 4}
	ans := OddTimesOneKind(arr)
	fmt.Println(ans)
}

func OddTimesOneKind(arr []int) int {
	eor := 0
	for i := 0; i < len(arr); i++ {
		eor ^= arr[i]
	}
	return eor
}
