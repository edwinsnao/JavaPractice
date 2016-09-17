package c3;

import java.util.*;

/**
 * Created by Kings on 2016/4/18.
 */
public class DataStructutre {
    void m_queue()
    {
        //Queue
        Queue<String> qu=new LinkedList<String>();//wrong:Queue<String> qu=new Queue<String>();
        qu.add("1a");
        qu.add("2b");
        qu.add("3c");
        qu.add("4d");
        //qu.offer("4d");//equal to add,but no exception
        System.out.println("remove is:"+qu.remove());
        System.out.println("size is:"+qu.size());
        //System.out.println("poll is:"+qu.poll());//equal to remove,but no exception
        System.out.println("peek is:"+qu.peek());
        System.out.println(qu.toString());
        System.out.println();
    }
    class m_priorityQueue extends PriorityQueue<m_priorityQueue>
            implements Comparable<m_priorityQueue>
    {
        private char primary;
        private int secondary;
        private String item;

        public m_priorityQueue(String td,char pri,int sec){
            item = td;
            primary = pri;
            secondary = sec;
        }
        //for comparable
        public int compareTo(m_priorityQueue arg) {
            if(primary > arg.primary)
                return +1;
            if(primary == arg.primary)
                if(secondary > arg.secondary)
                    return +1;
                else if(secondary == arg.secondary)
                    return 0;
            return -1;
        }
        public String toString()
        {
            return Character.toString(primary)+ secondary + ": " + item;
        }
        public void add(String td,char pri,int sec)
        {
            super.add(new m_priorityQueue(td,pri,sec));
        }
        public void run()
        {
            add("sixth",'C',4);
            add("second",'A',2);
            add("fourth",'B',7);
            add("fifth",'C',3);
            add("first",'A',1);
            add("third",'B',1);
            while(!isEmpty())
                System.out.println(remove());
        }
    }

    //link list
    void m_hash()
    {
        Hashtable<String, Integer> h=new Hashtable<String, Integer>();
        h.put("用户1",new Integer(90));
        h.put("用户1",new Integer(90));
        h.put("用户2",new Integer(50));
        h.put("用户3",new Integer(60));
        h.put("用户4",new Integer(70));
        h.put("用户1",new Integer(80));
        System.out.println("用户1: "+h.get("用户1"));
        Map<String, Integer> h1=new HashMap<>();
        h.put("用户1",new Integer(90));
        h.put("用户1",new Integer(90));
        h.put("用户2",new Integer(50));
        h.put("用户3",new Integer(60));
        h.put("用户4",new Integer(70));
        h.put("用户1",new Integer(80));
        System.out.println("用户2: "+h1.get("用户2"));
        System.out.println("用户1: "+h1.get("用户1"));
		/*
		//枚举
		Enumeration<Integer> e=h.elements();
		while(e.hasMoreElements())
		{
			System.out.println(e.nextElement());
		}*/
        for(Iterator<String> itor = h.keySet().iterator(); itor.hasNext();)
        {
            String word=itor.next().toString();
            Integer in=(Integer)h.get(word);
            System.out.println("word: "+word+" time："+in);
        }
    }
    void m_linkList()
    {
        LinkedList<String> head = new LinkedList<String>();
        head.add("1");
        head.add("3");
        head.add(1, "2");
        //鏈表會自動用遍歷的方式打印所有內容
        System.out.println(head);
        System.out.println("size is:"+head.size());

        //利用Vector或者是ArrayList等Collection往鏈表中加數據
        Vector<String> v = new Vector<String>();  //need to import java.util.Vector;
        //LinkedList<String> v=new LinkedList<String>();
        //向Vector中加入東西
        v.add("a");
        v.add("b");
        //將當前Vector加在當前鏈表的最后
        head.addAll(v);

        System.out.println(head);
        //將當前Vector加在當前鏈表的指定位置
        head.addAll(2, v);
        System.out.println(head);
        //打印指定位置的內容
        System.out.println("get(2) is："+head.get(2));
        System.out.println("index is:"+head.indexOf(head.get(2)));
        head.addFirst("fist");
        head.addLast("last");
        System.out.println(head);
        //刪除第一個
        head.remove(head.getFirst());
        head.remove(head.getLast());
        System.out.println(head);
        //再刪除第一個，采用下標的方式，下標從0開始
        head.remove(0);
        System.out.println(head);
        System.out.println();

    }
    static void m_stack()
    {
         //Stack
         Stack<String> st=new Stack<String>();
         //Stack<Integer> st=new Stack<Integer>();
         st.push("1a");
         st.push("2b");
         st.push("3c");
         st.push("4d");
         System.out.println("pop is:"+st.pop());
         System.out.println("size is:"+st.size());
         System.out.println("peek is:"+st.peek());
         System.out.println("isEmpty is:"+st.isEmpty());
         System.out.println("toString is:"+st.toString());
         System.out.println();

     }
         public static void main(String[] args) throws CloneNotSupportedException {
                 m_stack();
             System.out.println(100%33.00);
             System.out.println(100%33.0);
             DataStructutre da=new DataStructutre();
               da.m_stack();
               da.m_queue();
               da.m_linkList();
               da.m_hash();

               DataStructutre.m_priorityQueue pqueue=da.new m_priorityQueue(null, '0', 0);
               pqueue.run();

//             Student st = new Student("Test","Demo");
//             System.out.println(st.clone());
             Student stud = new Student("John", "Algebra");
             System.out.println("Original Object: " + stud.getName() + " - " + stud.getSubj().getName());
             // 拷贝对象
             Student clonedStud = (Student) stud.clone();
             System.out.println("Cloned Object: " + clonedStud.getName() + " - " + clonedStud.getSubj().getName());
             // 原始对象和拷贝对象是否一样：
             System.out.println("Is Original Object the same with Cloned Object: " + (stud == clonedStud));
             // 原始对象和拷贝对象的name属性是否一样
             System.out.println("Is Original Object's field name the same with Cloned Object: " +
                     (stud.getName() == clonedStud.getName()));
             // 原始对象和拷贝对象的subj属性是否一样
             System.out.println("Is Original Object's field subj the same with Cloned Object: " +
                     (stud.getSubj() == clonedStud.getSubj()));
             stud.setName("Dan");
             stud.getSubj().setName("Physics");
             System.out.println("Original Object after it is updated: " + stud.getName() + " - " +
                     stud.getSubj().getName());
             System.out.println("Cloned Object after updating original object: " + clonedStud.getName() +
                     " - " + clonedStud.getSubj().getName());

         }
    public static class Subject {
        private String name;
        public Subject(String s) {
            name = s;
        }
        public String getName() {
            return name;
        }
        public void setName(String s) {
            name = s;
        }
    }
    public static class Student implements Cloneable {
        // 对象引用
        private Subject subj;

        private String name;

        public Student(String s, String sub) {
            name = s;
            subj = new Subject(sub);
        }

        public Subject getSubj() {
            return subj;
        }

        public String getName() {
            return name;
        }

        public void setName(String s) {
            name = s;
        }

        /**
         * 重写clone()方法
         *
         * @return
         */
        public Object clone() throws CloneNotSupportedException {
            // 深拷贝，创建拷贝类的一个新对象，这样就和原始对象相互独立
            Student s = new Student(name, subj.getName());
            /*浅拷贝*/
//            Student s = (Student)super.clone();
            return s;
        }
    }
}
