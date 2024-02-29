package main

import (
	"log"
	"math/rand"
	"time"
)

func main() {
	arr := []int{2, 3, 11, 7, 4, 7, 12, 14, 5, 9, 11, 7, 23, 13}
	log.Println(arr)
	quickSort(arr, 0, len(arr)-1)
	log.Println(arr)
}

func quickSort(arr []int, l, r int) {
	if l < r {
		rand.Seed(time.Now().UnixNano()) //确保每次运行程序时，随机数生成器的种子都不一样，从而得到不同的随机数序列
		swap(arr, l+rand.Intn(r-l+1), r)
		mid := partition(arr, l, r)
		quickSort(arr, l, mid-1)
		quickSort(arr, mid+1, r)
	}
}

func partition(arr []int, l int, r int) int {
	ptr := l - 1
	for i := l; i <= r; i++ {
		if arr[i] <= arr[r] {
			ptr++
			swap(arr, ptr, i)
		}
	}
	return ptr
}

func swap(arr []int, i int, j int) {
	tmp := arr[i]
	arr[i] = arr[j]
	arr[j] = tmp
}
