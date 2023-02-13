public func bubbleSort<T>(_ elements: [T]) -> [T] where T: Compareable {
    return bubbleSort(elements, <)
}
public func bubbleSort<T>(_ elements: [T], _ comparision: (T, T) -> Bool) -> [T] {
    var array = elements 
    for i in 0..<array.count {
        for j in 1..<array.count - i {
            if comparision(array[j], array[i]) {
                let tmp = array[j - 1]
                array[j - 1] = array[j]
                array[j] = tmp
            }
        }
    }
    return array
}