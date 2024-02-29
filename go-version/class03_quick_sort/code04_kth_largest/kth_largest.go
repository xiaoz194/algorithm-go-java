package main

import (
	"log"
	"math/rand"
	"time"
)

// 所谓求第K大 就是排序后 下标在 n-k 位置上的数

func main() {
	arr := []int{2, 3, 11, 7, 4, 23, 13}
	k := 3
	log.Println(arr)
	res := findKthLargest(arr, k)
	log.Println(res)
}

func findKthLargest(arr []int, k int) int {
	return kthLargest(arr, 0, len(arr)-1, len(arr)-k)
}

func kthLargest(arr []int, l, r, p int) int {
	if l == r {
		return arr[l]
	}
	rand.Seed(time.Now().UnixNano())
	swap(arr, l+rand.Intn(r-l+1), r)
	x := partition(arr, l, r)
	if x == p {
		return arr[x]
	} else if x > p {
		return kthLargest(arr, l, x-1, p)
	} else {
		return kthLargest(arr, x+1, r, p)
	}
}

func partition(arr []int, l, r int) int {
	ptr := l - 1
	for i := l; i <= r; i++ {
		if arr[i] <= arr[r] {
			ptr++
			swap(arr, ptr, i)
		}
	}
	return ptr
}

func swap(arr []int, i, j int) {
	tmp := arr[i]
	arr[i] = arr[j]
	arr[j] = tmp
}
