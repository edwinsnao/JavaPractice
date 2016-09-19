package algori;

/**
 * Created by fazhao on 16/9/19.
 */
/**
* 每次前面有序
* */
public class InsertSortPrac {
    int tmp = 0;
    public void sort(int[] array){
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j >0 ; j--) {
                if(array[j] > array[j-1]){
                    tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
    public static void main(String[] args)
    {
        InsertSortPrac i=new InsertSortPrac();
        int[] a={4,8,6,7,2,9,5,10,54};
        i.sort(a);
    }
}
