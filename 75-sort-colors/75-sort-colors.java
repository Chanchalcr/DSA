class Solution {
    public void sortColors(int[] arr) {
        int n= arr.length;
        int low=0,mid=0,high=n-1;
        while (mid <= high) {
            switch (arr[mid]) {
                case 0 -> {
                    swap(arr, mid, low);
                    mid++;
                    low++;
                }
                case 1 -> {
                    mid++;
                }
                case 2 -> {
                    swap(arr, mid, high);
                    high--;
                }
            }
        }
    }
    public static void swap(int []arr, int a, int b) {
        int t= arr[a];
        arr[a]=arr[b];
        arr[b]=t;
    }
}