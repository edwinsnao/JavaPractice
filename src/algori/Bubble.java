package algori;

/**
 * Created by fazhao on 16/9/19.
 */
public class Bubble {
    public void bubble_sort(int[] arrays){
        for(int i=0;i<arrays.length;i++){
            for(int j=i+1;j<arrays.length;j++){
                if(arrays[i]<arrays[j]){
                    int tmp;
                    tmp=arrays[i];
                    arrays[i]=arrays[j];
                    arrays[j]=tmp;
                }
            }
        }
        snp(arrays);
    }
    public void snp(int [] arrays){
        for(int i=0;i<arrays.length;i++){
            System.out.print(arrays[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        Bubble b=new Bubble();
        int[] a={4,5,1,7,9,6};
        b.bubble_sort(a);
    }
}
