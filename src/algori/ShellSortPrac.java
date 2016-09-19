package algori;

/**
 * Created by fazhao on 16/9/19.
 */
public class ShellSortPrac {
    int tmp = 0;
    public void sort(int arr[]){
        for (int d = 5; d > 0; d-=2) {
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
    public static void main(String[] args)
    {
        ShellSortTest s=new ShellSortTest();
        int[] a={45,20,80,40,26,58,66,70};
        s.shell_sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }

    }
}
