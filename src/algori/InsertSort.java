package algori;

/**
 * Created by fazhao on 16/9/19.
 */
class InsertSort
{
    public void insert_sort(int[] arrays){
        for(int i=0;i<arrays.length;i++){
            for(int j=i;j>0;j--){
                /**
                * 所以把i=0改成i=1
                * */
                if(j==0)
                    continue;
//                if(j==0)
//                    continue;
                if(arrays[j]>arrays[j-1]){
                    int tmp;
                    tmp=arrays[j];
                    arrays[j]=arrays[j-1];
                    arrays[j-1]=tmp;

                }
            }
        }
        snp(arrays);
    }
    public void snp(int[] arrays){
        for(int i=0;i<arrays.length;i++){
            System.out.print(arrays[i]+" ");

        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        InsertSort i=new InsertSort();
        int[] a={4,8,6,7,2,9,5,10,54};
        i.insert_sort(a);
    }
}