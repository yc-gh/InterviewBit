// https://www.interviewbit.com/problems/maximum-unsorted-subarray/

public class Solution {
    public int[] subUnsort(int[] arr) {
        int n = arr.length, l = 0, r = n - 1;
        int start = 0, end = 0;
        while (l < r && arr[l] <= arr[l + 1])
            l++;
        if (l == r)
            return new int[] { -1 };
        while (r > l && arr[r] >= arr[r - 1])
            r--;
        start = l;
        end = r;

        int max = arr[start], min = arr[start], i;
        for (i = start; i <= end; i++) {
            max = Integer.max(max, arr[i]);
            min = Integer.min(min, arr[i]);
        }

        for (i = start - 1; i >= 0 && min < arr[i]; --i) {}
        start = i + 1;
        for (i = end + 1; i < n && max > arr[i]; ++i) {}
        end = i - 1;

        return new int[] { start, end };
    }
}
