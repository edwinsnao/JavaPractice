package algori;

/**
 * Created by fazhao on 16/9/19.
 */
class ShellSortTest
{
    public void shell_sort1(int[] a){
        int j = 0;
        for (int gap = a.length/2; gap>0; gap/=2) {
            for (int i = gap; i <a.length; i++) {
                int tmp = a[i];
                for (j = i-gap; j >=0 && tmp<a[j]; j-=gap) {
                    a[j+gap] = a[j];
                }
                a[j+gap] = tmp;
            }
        }
        snp(a);
    }

    public void shell_sort2(int[] a){
        int j = 0;
        int k = 0;
        for (int gap = a.length/2; gap >0 ; gap/=2) {
            for (int i = gap; i < a.length; i++) {
                int tmp = a[i];
                for (k = i-gap; k >=0 && tmp < a[k] ; k-=gap) {
                    a[k+gap] = a[k];
                }
                a[k+gap] = tmp;
            }
        }
        snp(a);
    }
    
    public void shell_sort(int [] arrays){
        for(int d=5;d>0;d=d-2){
            /**
            * 减少3则错，所以d得步长还是要算的？
            * */
//        for(int d=5;d>0;d=d-3){
            for(int c=0;c<arrays.length-d;c++){
                for(int i=c;i<arrays.length;i=i+d){
                    for(int j=i;j>0;j=j-d){
                        if(j<d)
                            break;
                        if(arrays[j]<arrays[j-d]){
                            int tmp;
                            tmp=arrays[j];
                            arrays[j]=arrays[j-d];
                            arrays[j-d]=tmp;

                        }
                    }
                }

            }
            snp(arrays);
        }

    }
    public void snp(int[] arrays){
        for(int i=0;i<arrays.length;i++){
            System.out.print(arrays[i]+" ");

        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        ShellSortTest s=new ShellSortTest();
        int[] a={45,20,80,40,26,58,66,70};
//        s.shell_sort(a);
//        s.shell_sort1(a);
        s.shell_sort2(a);

    }
}
