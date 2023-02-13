fn main() {
    println!("Hello, world!");
}
pub fn bubble_sort(arr: &mut [i32]) {
    let mut swapped = true;
    while swapped {
        swapped = false;
        for i in 1..arr.len()  {
            if arr[i - 1] > arr[i] {
                arr.swap(i - 1, i);
                swapped = true
            }
        }
    }
}

pub fn buble_sort_optimized(arr: &mut [i32]) {
    let mut new_len: usize;
    let mut len = arr.len();
    loop {
        new_len = 0;
        for i in 1..len {
            if arr[i - 1] > arr[i] {
                arr.swap(i - 1, i);
                new_len = i;
            }
            if len == 0 {
                break;
            }
            len = new_len;
        }
    }
}