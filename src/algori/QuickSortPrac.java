package algori;

/**
 * Created by fazhao on 16/9/19.
 */
public class QuickSortPrac {
    public static void sort(int[] arr,int i,int j){
        if(i>j)
            return;
        int l = i;
        int r = j;
        int x = arr[l];
        while (l < r){
            while(l<r && arr[r]>x)
                r--;
            if(l<r)
                arr[l++] = arr[r];
            while (l<r && arr[l]<x)
                l++;
            if(l<r)
                arr[r--] = arr[l];
        }
        arr[l] = x;
        sort(arr,i,l-1);
        sort(arr,l+1,r);
    }
    public static void main(String args[]){
        int[] a={45,20,80,40,26,58,66,70};
        sort(a,0,a.length-1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
