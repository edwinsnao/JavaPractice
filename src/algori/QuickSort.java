package algori;

/**
 * Created by fazhao on 16/9/19.
 */
public class QuickSort {
    public static void quicksort(int[] arr,int l,int r){
        if(l>r)
            return;;
        int i = l;
        int j = r;
        int x = arr[i];
        while(i<j){
            while(i<j&& arr[j]>x)
                j--;
            if(i<j)
                arr[i++] =arr[j];
            while(i<j && arr[i]<x)
                i++;
            if(i<j)
                arr[j--] = arr[i];

        }
        arr[i] =x;
        quicksort(arr,l,i-1);
        quicksort(arr,i+1,r);
    }
    public static void main(String args[]){
        int[] a={45,20,80,40,26,58,66,70};
        quicksort(a,0,a.length-1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        }
}
