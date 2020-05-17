// https://www.interviewbit.com/problems/wave-array/

public class Solution {
    public int[] wave(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n; i += 2) {
            if (i > 0 && arr[i - 1] > arr[i])
                swap(arr, i - 1, i);
            if (i < n - 1 && arr[i + 1] > arr[i])
                swap(arr, i + 1, i);
        }
        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
