package algori;

/**
 * Created by fazhao on 16/9/19.
 */
class InsertSort {

    public static void sort1(int[] a){
        int tmp = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if(a[j]>a[j-1]){
                    tmp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = tmp;
                }
            }
        }
        for (int i = 0; i <a.length ; i++) {
            System.out.print(a[i]+" ");
        }
    }

    /**
     * wrong
     */
//    public void static sort(){
    public static void sort(int[] a) {
        int tmp = 0;
        for (int i = 0; i <a.length ; i++) {
            for (int j = i; j >0; j--) {
                if(a[j]>a[j-1]){
                    tmp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = tmp;
                }
            }
        }
        for (int i = 0; i <a.length ; i++) {
            System.out.print(a[i]+" ");
        }
    }

    public void insert_sort(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            for (int j = i; j > 0; j--) {
                /**
                 * 所以把i=0改成i=1
                 * */
                if (j == 0)
                    continue;
//                if(j==0)
//                    continue;
                if (arrays[j] > arrays[j - 1]) {
                    int tmp;
                    tmp = arrays[j];
                    arrays[j] = arrays[j - 1];
                    arrays[j - 1] = tmp;

                }
            }
        }
        snp(arrays);
    }

    public void snp(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i] + " ");

        }
        System.out.println();
    }

    public static void main(String[] args) {
        InsertSort i = new InsertSort();
        int[] a = {4, 8, 6, 7, 2, 9, 5, 10, 54};
//        i.insert_sort(a);
//        i.sort(a);
        i.sort1(a);
    }
}