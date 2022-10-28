package main

import "fmt"

func main() {
	a := 5
	b := 10
	swap(&a, &b)
	fmt.Println("a = ", a)
	fmt.Println("b = ", b)
	num := 148
	rightOne := num & (^num + 1)
	fmt.Println(rightOne)

	count := 0
	x := 148
	fmt.Println("依次提取出", x, "最右侧的1,得到1的个数")
	for x != 0 {
		rightOne := x & (^x + 1)
		count++
		x ^= rightOne
	}
	fmt.Println("count = ", count)

}

func swap(a *int, b *int) {
	//tmp := *a
	//*a = *b
	//*b = tmp
	*a = *a ^ *b
	*b = *a ^ *b
	*a = *a ^ *b
}
