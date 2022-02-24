//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.lang.reflect.Array;
//import java.util.Scanner;
//
//class ArrayQueue<E> {
//    E[] elems;
//    int length, front, rear;
//
//    @SuppressWarnings("unchecked")
//    public ArrayQueue(int maxlength) {
//        elems = (E[]) new Object[maxlength];
//        clear();
//    }
//
//    public boolean isEmpty() {
//        return (length == 0);
//    }
//
//    public int size() {
//        return length;
//    }
//
//    public E peek() {
//        if (length > 0)
//            return elems[front];
//        else {
//            System.out.println("Redicata e prazna");
//            return null;
//        }
//    }
//
//    public void clear() {
//        length = 0;
//        front = rear = 0;
//    }
//
//    public void enqueue(E x) {
//        elems[rear++] = x;
//        if (rear == elems.length)
//            rear = 0;
//        length++;
//    }
//
//    public E dequeue() {
//        if (length > 0) {
//            E frontmost = elems[front];
//            elems[front++] = null;
//            if (front == elems.length)
//                front = 0;
//            length--;
//            return frontmost;
//        } else {
//            System.out.println("Redicata e prazna");
//            return null;
//        }
//    }
//}
//
//public class Kolokvium {
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        ArrayQueue<String> assistenti=new ArrayQueue<String>(50);
//        ArrayQueue<String> otcutniAssistenti=new ArrayQueue<String>(50);
//        int brAssistenti=Integer.parseInt(br.readLine());
//        for(int i=0;i<brAssistenti;i++)
//            assistenti.enqueue(br.readLine());
//
//        String predmeti[] = new String[10];
//        Integer brPredmetiNiza[] = new Integer[10];
//        int brPredmeti=Integer.parseInt(br.readLine());
//        for(int i=0;i<brPredmeti;i++){
//            String line[]=br.readLine().split(" ");
//            predmeti[i]=line[0];
//            brPredmetiNiza[i]=Integer.parseInt(line[1]);
//        }
//        int brOtcutni=Integer.parseInt(br.readLine());
//        for(int i=0;i<brOtcutni;i++){
//            otcutniAssistenti.enqueue(br.readLine());
//        }
//        int flag=0;
//        for(int i=0;i<assistenti.length;i++){
//            String name=assistenti.peek();
//            for(int j=0;j<otcutniAssistenti.length;j++){
//                if(otcutniAssistenti.peek().equals(name))
//                    flag=1;
//            }
//            if(flag==1)
//                assistenti.dequeue();
//            else assistenti.enqueue(assistenti.dequeue());
//            flag=0;
//        }
//
//        for(int i=0;i<brPredmeti;i++){
//            System.out.println(predmeti[i]);
//            System.out.println(brPredmetiNiza[i]);
//            for(int j=0;j<brPredmetiNiza[i];j++){
//                String name=assistenti.peek();
//                System.out.println(name);
//                assistenti.enqueue(assistenti.dequeue());
//            }
//        }
//    }
//}