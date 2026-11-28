class Solution {
    public int reversePairs(int[] nums) {
        return (int) mergeSort(nums, 0, nums.length-1);
    }

    static long mergeSort(int[] arr, int low, int high){

        long count = 0;

        if (low>=high) return count;

        int mid = low+(high -low)/2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid+1, high);
        count += merge(arr, low, mid, high);

        return count;
    }

    static long merge(int [] arr, int low, int mid, int high){
        long count = 0;
        int j = mid + 1;

        for (int i = low; i <= mid; i++) {
            while (j <= high && arr[i] > 2L * arr[j]) {j++;}
            count += j - (mid + 1);
        }
        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int k = 0;

        while(left<=mid && right<=high){
            if (arr[left] <= arr[right]){
                temp[k] = arr[left];
                left ++;
            }

            else {
                temp[k] = arr[right];
                right ++;
            }

            k++;
        }

        while(left <= mid){
            temp[k] = arr[left];
            left ++;
            k ++;
        }

        while(right <= high){
            temp[k] = arr[right];
            right ++;
            k ++;
        }

        for(int i = 0; i < temp.length; i++){
            arr[low+i] = temp[i];
        }

        return count;
    }

}