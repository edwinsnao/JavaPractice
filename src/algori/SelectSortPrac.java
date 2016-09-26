package algori;

/**
 * Created by fazhao on 16/9/20.
 */
public class SelectSortPrac {

    public static void select_sort2(int[] a){
        int min = 0;
        int tmp = 0;
        for (int i = 0; i <a.length ; i++) {
            min = i;
//            for (int j = i; j < a.length; j++) {
            /**
            * 不加1会进行多一步的无谓的操作
            * */
            for (int j = i + 1; j < a.length; j++) {
                if(a[min] < a[j])
                    min = j;
            }
            if(min != i){
                tmp = a[i];
                a[i] = a[min];
                a[min] = tmp;
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }

    public static void select_sort1(int[] a){
        int min = 0;
        int tmp = 0;
        for (int i = 0; i < a.length; i++) {
            min = i;
            for (int j = i + 1; j < a.length ; j++) {
                if(a[j]<a[min])
                    min = j;
            }
            if(min != i){
                tmp =a[i];
                a[i] = a[min];
                a[min] = tmp;
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }

    }

        public static void select_sort(int[] a){
            int min = 0;
            int tmp = 0;
            for (int i = 0; i < a.length; i++) {
                min = i;
                for (int i1 = i + 1; i1 < a.length; i1++) {
                    if(a[i1] < a[min]){
                        min = i1;
                    }
                }
                if(i != min){
                    tmp = a[i];
                    a[i] = a[min];
                    a[min] = tmp;
                }
            }
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i]+" ");
            }
        }

        public static void _choiceSort(int[] a) {
            if (a == null || a.length <= 0) {
                return;
            }
            for (int i = 0; i < a.length; i++) {
                int min = i; /* 将当前下标定义为最小值下标 */

                for (int j = i + 1; j < a.length; j++) {
                    if (a[min] > a[j]) { /* 如果有小于当前最小值的关键字 */
                        min = j; /* 将此关键字的下标赋值给min */
                    }
                }
                if (i != min) {/* 若min不等于i，说明找到最小值，交换 */
                    int tmp = a[min];
                    a[min] = a[i];
                    a[i] = tmp;
                }
            }
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i]+" ");
            }
            System.out.println("");
        }
        public static void main(String args[]){
            int[] a={4,5,1,7,9,6,3,10,20,21,99,0};
//        _choiceSort(a);
//        select_sort(a);
//        select_sort1(a);
        select_sort2(a);
            }

}
