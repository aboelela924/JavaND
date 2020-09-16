public class Sort {
    public static int findTarget(int[] arr, int target) {

        int start = 0;
        int end = arr.length-1;

        return binarySearch(arr, start, end, target);
    }

    public static int binarySearch(int[] arr, int start, int end, int target){
        if (start > end){
            return -1;
        }

        int middle = (int) Math.ceil((start+end)/2);
        if(arr[middle] > target){
            return binarySearch(arr, start, middle-1, target);
        }else if (arr[middle] < target){
            return binarySearch(arr, middle+1, end, target);
        }else{
            return middle;
        }
    }
}
