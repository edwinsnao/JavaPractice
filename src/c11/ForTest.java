package c11;

/**
 * Created by Kings on 2016/4/12.
 */
public class ForTest {
//        public static void main(String[] args) {
//            int i = 0 ;
//            for(foo('A');foo('B')&&i<3;foo('C')){
//                i++ ;
//                foo('D') ;
//            }
//        }
//        public static boolean foo(char c){
//            System.out.print(c + " ");
//            return true ;
//        }

    /*
    * 不用第三个变量交换
    * */
//    public void change(int a, int b){
//        a = a+b;
//        b = a-b;
//        a = a-b;
//    }

    public static void bulblesort(int[] arr){
        for(int i = 0 ; i < arr.length;i++)
            for(int j = 0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
    }
    /*
    * 这个是写错的，不过在已经有序时，输出还是正确 eg12345
    * */
//    public static void bulblesort(int[] arr){
//        for(int i = 0 ; i < arr.length;i++)
//            for(int j = 0;j<arr.length-i-1;j++){
//                if(arr[j]>arr[j+1]){
//                    int tmp = arr[j];
//                    arr[j] = arr[i];
//                    arr[i] = tmp;
//                }
//            }
//    }
//    public static void selectsort(int[] arr){
//        for(int i = 0 ; i < arr.length;i++) {
//            int num = arr[i];
//            int index = i;
//            for (int j = i+1; j < arr.length; j++) {
//                if (arr[j] > num) {
//                    num = arr[j];
//                    index = j;
//                }
//            }
//            if(index!=i){
//                int tmp = arr[i];
//                arr[i] = arr[index];
//                arr[index] = tmp;
//            }
//        }
//    }
//    public static void selectsort(int[] arr){
//        for(int i = 0 ; i < arr.length;i++)
//            for(int j = 0;j<arr.length;j++){
//                if(arr[j]>arr[i]){
//                    int tmp = arr[j];
//                    arr[j] = arr[i];
//                    arr[i] = tmp;
//                }
//            }
//    }

    public static void selectsort(int[] arr){
        for(int i = 0 ; i<arr.length;i++){
            int num = arr[i];
            int index = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[j]>num){
                    num = arr[j];
                    index = j;
                }
            }
            if(!(index ==i )){
                int tmp = arr[i];
                arr[i] = arr[index];
                arr[index] = tmp;

            }
        }
    }

    public static void quicksort(int[] arr,int l,int r){
        if(l>r)
            return;;
        int i = l;
        int j = r;
        int x = arr[i];
        while(i<j){
            while(i<j&& arr[j]>x)
                j--;
            if(i<j)
                arr[i++] =arr[j];
            while(i<j && arr[i]<x)
                i++;
            if(i<j)
                arr[j--] = arr[i];

        }
        arr[i] =x;
        quicksort(arr,l,i-1);
        quicksort(arr,i+1,r);
    }


//    public static void quicksort(int[] arr,int l,int r){
//        int ll = l;
//        int x = arr[l];
//        int rr = r;
//        while(ll<rr){
//            while(ll<rr&&arr[rr]>x)
//                rr--;
//            if(ll<rr)
//                arr[ll++] = arr[rr];
//            while(ll<rr && arr[ll]<x)
//                ll++;
//            if(ll<rr)
//                arr[rr--] = arr[ll];
//        }
//        arr[ll] = x;
//        quicksort(arr,l,ll-1);
//        quicksort(arr,ll+1,r);
//    }

    public static void quick_sort(Comparable[] a,int l,int r){
        if(l>=r)
            return;
        Comparable x;
        int i = l, j = r;
        x = a[l];
        while(i<j){
//            while(i<j && a[j].compareTo(x)>=0) 升序
//            必须从右找再从左找，否则会出错，结果不正确
            while(i<j && a[j].compareTo(x)<0)  //降序(从右边找齐，第一个大于x的数放到a[i]（左边），所以是从到小排序)
                j--;
            if(i<j)
                a[i++] = a[j];
//            while(i<j && a[i].compareTo(x)<0) 升序
            while(i<j && a[i].compareTo(x)>=0) //降序
                i++;
            if(i<j)
                a[j--] = a[i];
        }
        a[i] = x;
        quick_sort(a,l,i-1);
        quick_sort(a,i+1,r);
    }

    public static void reverse(int[] arr){
        for(int start = 0,end = arr.length-1;start<end;start++,end--){
            int tmp = arr[end];
            arr[end] = arr[start];
            arr[start] = tmp;
        }
    }

     public static void main(String[] args){
         int[] a1 = {1,4,3,2,5};
//         Comparable[] a1 = {1,4,3,2,5};
         int count = 0;
         int x = 2015;
         while(x>0){
            x = x&(x-1);
             count++;
         }
         System.out.println(count);
         System.out.println(2<<1);
         System.out.println(2<<2);
         System.out.println(2<<3);
         System.out.println(3^5);
         int a = 3;
         int b = 5;
         ForTest test = new ForTest();
//         test.change(a,b);
          /*
    * 不用第三个变量交换
    * */
//         a = a+b;
//         b = a-b;
//         a = a-b;


         a = a^b;
         b = a^b;
         a = a^b;
         System.out.println(a+" "+b);
//         selectsort(a1);
//         this.reverse(a1);
         reverse(a1);
//         quicksort(a1,0,a1.length-1);
//         quick_sort(a1,0,a1.length-1);
//         bulblesort(a1);
         for(int i = 0 ; i<a1.length;i++)
         System.out.print(a1[i]+ " ");
     }


}
