package algori;

/**
 * Created by fazhao on 16/9/19.
 */
public class QuickSortPrac {

    public static void quick3(int[] a,int i, int j){
        if(i > j)
            return;
        int l = i;
        int r = j;
        int x = a[l];
        while(l<r){
            while(x<a[r])
                r--;
            a[l++] = a[r];
            while(x > a[l])
                l++;
            a[r--] = a[l];
        }
        a[l] = x;
        quick(a,i,l-1);
        quick(a,r+1,j);
    }

    public static void quick2(int[] a,int i,int j){
        if(i > j)
            return;
        int l = i;
        int r = j;
        int x = a[l];
        while(l < r){
            while(x < a[r])
                r--;
            a[l++] = a[r];
            while(x > a[l])
                l++;
            a[r--] = a[l];
        }
        a[l] = x;
        quick(a,i,l-1);
        quick(a,r+1,j);
    }

    public static void quick1(int[] a,int i,int j){
        if(i>j)
            return;
        int l = i;
        int r = j;
        int x = a[l];
        while(l<r){
            while(l<r && a[r]>x)
                r--;
            /**
            * 因为外面的循环已经判断了，所以这里是多余的
            * */
//            if(l<r)
                a[l++] = a[r];
            while(l<r && a[l]<x)
                l++;
//            if(l<r)
                a[r--] = a[l];
        }
        a[l] = x;
        sort(a,i,l-1);
        sort(a,r+1,j);
    }

    public static void quick(int[] a,int i, int j){
        if(i>j)
            return;
        int l = i;
        int r = j;
        int x = a[l];
        while(l<r){
            while(l<r && a[r]>x)
                r--;
            if(l<r)
                a[l++] = a[r];
            while(l<r && a[l]<x)
                l++;
            if(l<r)
                a[r--] = a[l];
        }
        a[l] = x;
        sort(a,i,l-1);
        /**
        *wrong
        * */
//        sort(a,l+1,r);
        sort(a,r+1,j);

    }

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
        sort(arr,r+1,j);
    }
    public static void main(String args[]){
        int[] a={45,20,80,40,26,58,66,70};
//        sort(a,0,a.length-1);
//        quick(a,0,a.length-1);
//        quick1(a,0,a.length-1);
//        quick2(a,0,a.length-1);
        quick3(a,0,a.length-1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
