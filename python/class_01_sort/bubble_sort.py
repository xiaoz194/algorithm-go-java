"""
python - 冒泡排序

步骤理解：
    一个长度为n的数组Array [0,1,2,.....,n-1,n]
    第一遍：在 Array 中找到最大的一个数，放到 Array[n]
    第二遍：在 Array[0:-1] 中找到最大的一个数，放到 Array[n-1]
    ....

    依次类推对数组排序

时间复杂度：
    满有序度公式为: n*(n-1)/2 = 逆序度 + 有序度
    
    最坏的情况是 逆序度 为 n*(n-1)/2 有序度 为 0
        n*(n-1)/2, 用时间复杂度表示 O(n^2) , 忽略其他系数
    最好的情况是 有序度 为 n*(n-1)/2，
        这种情况只需要遍历一次数组，发现没有元素之间有交换，代表数组已经是有序的了，如代码中的 no_sort 所示
        用时间复杂度表示为 O(n)

空间复杂度为:
    O(1)

结论：
    冒泡算法是一种时间换空间的算法， 
"""

def bubble_sort(arr):
    n = len(arr)
    for i in range(n):
        no_sort = True
        for j in range(0, n-i-1):
            if arr[j] < arr[j+1]:
                continue
            arr[j], arr[j+1] = arr[j+1], arr[j]
            no_sort = False
        if no_sort:
            # 如果某次遍历对比，发现没有元素之间经过交换，说明剩余的元素都是有序的
            # 此时不需要进行后续对比了
            break
 
if __name__ == "__main__":
    arr = [13, 55, 15, 56, 98, 78]
    bubble_sort(arr)
    print(arr)