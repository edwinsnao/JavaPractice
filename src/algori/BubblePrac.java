package algori;

/**
 * Created by fazhao on 16/9/19.
 */
public class BubblePrac {
    int tmp = 0;
    int times = 0;
    void BubbleSort_1(int a[], int size)
    {
        for (int i = 0; i < size -1; i++)
        {
            times++;
            for (int j = size - 1; j > i ; j--)
            {
                if (a[j-1] > a[j])
                {
                    int temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
            }
            for (int j = 0; j < a.length; j++) {

                System.out.print(a[j]+" ");
            }
            System.out.println("");
        }
        System.out.println(times);
    }
    void BubbleSort_2(int a[], int size)
    {
        boolean bSwaped = true;
        for (int i = 0; i < size -1; i++)
        {
            times++;
            // 每次先重置为false
            bSwaped = false;
            for (int j = size - 1; j > i ; j--)
            {
                if (a[j-1] > a[j])
                {
                    int temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;

                    bSwaped = true;
                }
            }
            for (int j = 0; j < a.length; j++) {

                System.out.print(a[j]+" ");
            }
            System.out.println("");
            // 如果上一次扫描没有发生交换，则说明数组已经全部有序，退出循环
            if (!bSwaped)
                break;
        }
        System.out.println(times);
    }
    void BubbleSort_3(int a[], int size)
    {
        int lastTmp = 0,lastTmp1 = 0;
        boolean bSwaped = true;
        for (int i = 0; i < size -1; i++)
        {
            times++;
            // 每次先重置为false
            bSwaped = false;
            lastTmp = lastTmp1;
            for (int j = size - 1; j > i ; j--)
            {
                if (a[j-1] > a[j])
                {
                    int temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;

                    lastTmp = j;
                    bSwaped = true;
                }
            }
            if(lastTmp == lastTmp1)
                break;
            for (int j = 0; j < a.length; j++) {

                System.out.print(a[j]+" ");
            }
            System.out.println("");
            // 如果上一次扫描没有发生交换，则说明数组已经全部有序，退出循环
            if (!bSwaped)
                break;
        }
        System.out.println(times);
    }

    public void sort(int array[]){
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[i] < array[j]){
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
            for (int j = 0; j < array.length; j++) {

                System.out.print(array[j]+" ");
            }
            System.out.println("");
        }
//        for (int i = 0; i < array.length; i++) {
//
//            System.out.print(array[i]+" ");
//        }
    }
    public static void main(String[] args)
    {
        BubblePrac b=new BubblePrac();
        int[] a={4,5,1,7,9,6,3,10,20,21,99,0};
//        b.sort(a);
//        b.BubbleSort_2(a,a.length);
        b.BubbleSort_3(a,a.length);
//        b.BubbleSort_1(a,a.length);
    }
}
