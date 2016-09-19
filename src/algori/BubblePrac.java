package algori;

/**
 * Created by fazhao on 16/9/19.
 */
public class BubblePrac {
    int tmp = 0;
    public void sort(int array[]){
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[i] < array[j]){
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {

            System.out.print(array[i]+" ");
        }
    }
    public static void main(String[] args)
    {
        BubblePrac b=new BubblePrac();
        int[] a={4,5,1,7,9,6};
        b.sort(a);
    }
}
