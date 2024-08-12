import java.util.*;

public class mergesortalgo {

    public static void merge(int l, int h, int mid, int[] arr) {

        int low = l, high = mid + 1;

        int n = h - l + 1;
        int[] temp = new int[n];
        int k = 0;
        while (low <= mid && high <= h) {
            if (arr[low] < arr[high]) {
                temp[k++] = arr[low];
                low++;
            } else {
                temp[k++] = arr[high];
                high++;
            }
        }
        while (low <= mid) {
            temp[k++] = arr[low];
            low++;
        }
        while (high <= h) {
            temp[k++] = arr[high];
            high++;
        }
        for (int i = 0; i < n; i++) {
            arr[l++] = temp[i];
        }
        System.out.println(Arrays.toString(temp));

    }

    public static void mergesort(int l, int h, int[] arr) {
        if (l < h) {
            int mid = (l + h) / 2;
            mergesort(l, mid, arr);
            mergesort(mid + 1, h, arr);
            merge(l, h, mid, arr);

        }
    }

    public static void main(String[] args) {

        int[] arr = { 0,1, 5, 30, 15, 7 };
        mergesort(0, arr.length - 1, arr);
        System.out.println(Arrays.toString(arr));

    }
}
