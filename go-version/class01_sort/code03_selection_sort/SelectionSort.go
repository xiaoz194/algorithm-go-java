package main

import (
	"log"
)

/**
 * @Description TODO $ 选择排序 时间复杂度为O(N^2) 额外空间复杂度O(1）
				过程：
				arr[0～N-1]范围上，找到最小值所在的位置，然后把最小值交换到0位置。
				arr[1～N-1]范围上，找到最小值所在的位置，然后把最小值交换到1位置。
				arr[2～N-1]范围上，找到最小值所在的位置，然后把最小值交换到2位置。
				…
				arr[N-2～N-1]范围上，找到最小值位置，然后把最小值交换到N-2位置）
 * @Author sanyejiantai
 * @Date 2023/2/12 13:14
 **/

func main() {
	arr := []int{2, 3, -2, 9, 11, 7, 23, 13}
	log.Println(arr)
	selectionSort(arr)
	log.Println(arr)

}

func selectionSort(arr []int) {
	if arr == nil || len(arr) < 2 {
		return
	}
	n := len(arr)
	for i := 0; i < n-1; i++ {
		//i~n-1范围上，找到最小值，然后和i位置上的数交换 没有必要比较最后一个位置范围的数
		minIndex := i
		for j := i + 1; j < n; j++ {
			if arr[j] < arr[minIndex] {
				minIndex = j
			}
		}
		swap(arr, i, minIndex)
	}
}

func swap(arr []int, i int, j int) {
	tmp := arr[i]
	arr[i] = arr[j]
	arr[j] = tmp
}
