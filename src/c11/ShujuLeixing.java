package c11;

/**
 * Created by Kings on 2016/4/12.
 */
public class ShujuLeixing {

    public void change(String str,char[] c){
        c[0] = 'b';
        str = "test";
    }

     public static void main(String[] args){
         ShujuLeixing test = new ShujuLeixing();
          int i = 1;
         byte b = 1;
         char c = '1';
         String s = "1234ab我";
         String s1 = "1234ab";
         char c1[] = s1.toCharArray();
         float f = 1f;
         double d = 1d;
         short ss =1;
         long l = 1;
         boolean bb = true;

         String s2 = "hello";
         char[] c2 = {'w','o','l','d'};
         System.out.println("s"+s.getBytes().length);
         System.out.println("s1: "+s1.getBytes().length);
         System.out.println(c1);
         for(int j = 0 ; j<c1.length;j++){
             System.out.print(c1[j]+"  ");
         }
         test.change(s2,c2);
         System.out.print(s2 +" "+c2[0]);

         }

}
/*
* s9
s1: 6
1234ab
1  2  3  4  a  b
*
* */