import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MapEntry<K extends Comparable<K>,E> implements Comparable<K> {

   K key;
   E value;

   public MapEntry (K key, E val) {
       this.key = key;
       this.value = val;
   }

   public int compareTo (K that) {
       @SuppressWarnings("unchecked")
       MapEntry<K,E> other = (MapEntry<K,E>) that;
       return this.key.compareTo(other.key);
   }

   public String toString () {
       return "(" + key + "," + value + ")";
   }
}

class SLLNode<E> {
   protected E element;
   protected SLLNode<E> succ;

   public SLLNode(E elem, SLLNode<E> succ) {
       this.element = elem;
       this.succ = succ;
   }

   @Override
   public String toString() {
       return element.toString();
   }
}

class CBHT<K extends Comparable<K>, E> {

   private SLLNode<MapEntry<K,E>>[] buckets;

   @SuppressWarnings("unchecked")
   public CBHT(int m) {
       buckets = (SLLNode<MapEntry<K,E>>[]) new SLLNode[m];
   }

   private int hash(K key) {
       return Math.abs(key.hashCode()) % buckets.length;
   }

   public SLLNode<MapEntry<K,E>> search(K targetKey) {
       int b = hash(targetKey);
       for (SLLNode<MapEntry<K,E>> curr = buckets[b]; curr != null; curr = curr.succ) {
           if (targetKey.equals(((MapEntry<K, E>) curr.element).key))
               return curr;
       }
       return null;
   }

   public void insert(K key, E val) {		// Insert the entry <key, val> into this CBHT.
       MapEntry<K, E> newEntry = new MapEntry<K, E>(key, val);
       int b = hash(key);
//        for (SLLNode<MapEntry<K,E>> curr = buckets[b]; curr != null; curr = curr.succ) {
//            if (key.equals(((MapEntry<K, E>) curr.element).key)) {
//                curr.element = newEntry;
//                return;
//            }
//        }
       buckets[b] = new SLLNode<MapEntry<K,E>>(newEntry, buckets[b]);
   }

   public void delete(K key) {
       int b = hash(key);
       for (SLLNode<MapEntry<K,E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ) {
           if (key.equals(((MapEntry<K,E>) curr.element).key)) {
               if (pred == null)
                   buckets[b] = curr.succ;
               else
                   pred.succ = curr.succ;
               return;
           }
       }
   }

   public String toString() {
       String temp = "";
       for (int i = 0; i < buckets.length; i++) {
           temp += i + ":";
           for (SLLNode<MapEntry<K,E>> curr = buckets[i]; curr != null; curr = curr.succ) {
               temp += curr.element.toString() + " ";
           }
           temp += "\n";
       }
       return temp;
   }

}

public class MostFrequentSubstring {
   public static void main (String[] args) throws IOException {
       CBHT<String,Integer> tabela = new CBHT<String,Integer>(300);
       CBHT<Integer,String> tabelaReverse = new CBHT<Integer,String>(300);
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       String word = br.readLine().trim();
       int k=0;
       for(int i=0;i<word.length();i++){
           for(int j=i;j<=word.length();j++){
               String shortWord=word.substring(i,j);
               tabela.insert(shortWord,k);
               tabelaReverse.insert(k++,shortWord);
           }
       }
       int count=0;
       int max=0;
       int find=0;
       for(int i=0;i<k;i++){
           SLLNode<MapEntry<Integer, String>> list=tabelaReverse.search(i);
           while(list!=null){
               count++;
               list=list.succ;
           }
           if(max<=count){
               max=count;
               find=i;
           }
           count=0;
       }
       System.out.print(tabelaReverse.search(find).element.value);
   }
}

