package main

import "fmt"

// arr 中，一定有两种数出现了奇数次，其他数都出现偶数次，返回这两种数
func main() {
	arr := []int{1, 3, 3, 5, 1, 7, 7, 8, 7, 6, 8, 5}
	ans := OddTimesTwoKind(arr)
	fmt.Println(ans)
}

func OddTimesTwoKind(arr []int) []int {
	ans := make([]int, 2)
	eor := 0
	for i := 0; i < len(arr); i++ {
		eor ^= arr[i]
	}
	rightOne := eor & (^eor + 1)
	eor2 := 0
	for i := 0; i < len(arr); i++ {
		if (arr[i] & rightOne) != 0 {
			eor2 ^= arr[i]
		}
	}
	ans[0] = eor2
	ans[1] = eor ^ eor2
	return ans
}
