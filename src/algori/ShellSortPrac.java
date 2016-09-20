package algori;

/**
 * Created by fazhao on 16/9/19.
 */
public class ShellSortPrac {
    int tmp = 0;
    public void sort(int arr[]){
        for (int d = 5; d > 0; d/=2) {
            for (int i = 0; i < arr.length -d; i+=d) {
                for (int j = i; j >0 ; j-=d) {
                    if(arr[j]<arr[j-d]){
                        tmp = arr[j-d];
                        arr[j-d] =arr[j];
                        arr[j] = tmp;
                    }
                }
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println("");
        }
    }
    void shellsort1(int a[], int n)
    {
        int i, j, gap;

        for (gap = n / 2; gap > 0; gap /= 2) //步长
            for (i = 0; i < gap; i++)        //直接插入排序
            {
                for (j = i + gap; j < n; j += gap)
                    if (a[j] < a[j - gap])
                    {
                        int temp = a[j];
                        int k = j - gap;
                        while (k >= 0 && a[k] > temp)
                        {
                            a[k + gap] = a[k];
                            k -= gap;
                        }
                        a[k + gap] = temp;
                    }
            }
        for (int h = 0; h < a.length; h++) {
            System.out.print(a[h]+" ");
        }
        System.out.println("");
    }
    public static void main(String[] args)
    {
        ShellSortPrac s=new ShellSortPrac();
        int[] a={45,20,80,40,26,58,66,70};
        s.sort(a);
//        s.shellsort1(a,a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }

    }
}
