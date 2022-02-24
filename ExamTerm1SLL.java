//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Scanner;
//import java.util.Iterator;
//import java.util.NoSuchElementException;;
//class SLLNode<E> {
//    protected E element;
//    protected SLLNode<E> succ;
//
//    public SLLNode(E elem, SLLNode<E> succ) {
//        this.element = elem;
//        this.succ = succ;
//    }
//
//    @Override
//    public String toString() {
//        return element.toString();
//    }
//}
//
//class SLL<E> {
//    private SLLNode<E> first;
//
//    public SLL() {
//        // Construct an empty SLL
//        this.first = null;
//    }
//
//    public void deleteList() {
//        first = null;
//    }
//
//    public int length() {
//        int ret;
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            ret = 1;
//            while (tmp.succ != null) {
//                tmp = tmp.succ;
//                ret++;
//            }
//            return ret;
//        } else
//            return 0;
//
//    }
//
//    @Override
//    public String toString() {
//        String ret = new String();
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            ret += tmp + " ";
//            while (tmp.succ != null) {
//                tmp = tmp.succ;
//                ret += tmp + " ";
//            }
//        } else
//            ret = "";
//        return ret;
//    }
//
//    public void insertFirst(E o) {
//        SLLNode<E> ins = new SLLNode<E>(o, first);
//        first = ins;
//    }
//
//    public void insertAfter(E o, SLLNode<E> node) {
//        if (node != null) {
//            SLLNode<E> ins = new SLLNode<E>(o, node.succ);
//            node.succ = ins;
//        }
//    }
//
//    public void insertBefore(E o, SLLNode<E> before) {
//
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            if(first==before){
//                this.insertFirst(o);
//                return;
//            }
//            //ako first!=before
//            while (tmp.succ != before)
//                tmp = tmp.succ;
//            if (tmp.succ == before) {
//                SLLNode<E> ins = new SLLNode<E>(o, before);
//                tmp.succ = ins;
//            } else {
//                System.out.println("Elementot ne postoi vo listata");
//            }
//        } else {
//            System.out.println("Listata e prazna");
//        }
//    }
//
//    public void insertLast(E o) {
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            while (tmp.succ != null)
//                tmp = tmp.succ;
//            SLLNode<E> ins = new SLLNode<E>(o, null);
//            tmp.succ = ins;
//        } else {
//            insertFirst(o);
//        }
//    }
//
//    public E deleteFirst() {
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            first = first.succ;
//            return tmp.element;
//        } else {
//            System.out.println("Listata e prazna");
//            return null;
//        }
//    }
//
//    public E delete(SLLNode<E> node) {
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            if(first ==node){
//                return this.deleteFirst();
//            }
//            while (tmp.succ != node && tmp.succ.succ != null)
//                tmp = tmp.succ;
//            if (tmp.succ == node) {
//                tmp.succ = tmp.succ.succ;
//                return node.element;
//            } else {
//                return null;
//            }
//        } else {
//            return null;
//        }
//
//    }
//
//    public SLLNode<E> getFirst() {
//        return first;
//    }
//
//    public SLLNode<E> find(E o) {
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            while (tmp.element != o && tmp.succ != null)
//                tmp = tmp.succ;
//            if (tmp.element == o) {
//                return tmp;
//            }
//        }
//        return first;
//    }
//}
//
//
//public class ExamTerm1SLL {
//    public static void deleteDuplicates(SLL<Integer> list1, int key) {
//        SLLNode<Integer> sllNode=list1.getFirst();
//        SLLNode<Integer> tmp=list1.getFirst();
//        SLLNode<Integer> tmp1=list1.getFirst();
////        System.out.println(list1.length());
//        while(sllNode.succ!=null){
//
//            if(sllNode.succ.element==key)
//                tmp=sllNode;
//
//            if(sllNode.element==key)
//                tmp1=sllNode;
//
//            sllNode=sllNode.succ;
//        }
//        SLL<Integer> list2=new SLL<Integer>();
//        list2=list1;
////        System.out.println(list1.length());
//        tmp.succ=tmp.succ.succ;
//        list2.delete(tmp1);
//        System.out.print(list1);
//        System.out.println();
//        System.out.print(list2);
//
////        System.out.println();
////        System.out.println(list1.length());
//        //to do insert code here
//    }
//
//    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        SLL<Integer> list1 = new SLL<Integer>();
//        String line[]=br.readLine().split(" ");
//        for(int i=0;i<line.length;i++){
//            list1.insertLast(Integer.parseInt(line[i]));
//        }
//        //to do insert code here
//
//        int key = Integer.parseInt(br.readLine());
//        deleteDuplicates(list1,key);
//        //to do insert code here
//    }
//}