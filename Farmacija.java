//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
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
//class MapEntry<K extends Comparable<K>, E> implements Comparable<K> {
//
//    // Each MapEntry object is a pair consisting of a key (a Comparable
//    // object) and a value (an arbitrary object).
//    K key;
//    E value;
//
//    public MapEntry(K key, E val) {
//        this.key = key;
//        this.value = val;
//    }
//
//    public int compareTo(K that) {
//        // Compare this map entry to that map entry.
//        @SuppressWarnings("unchecked")
//        MapEntry<K, E> other = (MapEntry<K, E>) that;
//        return this.key.compareTo(other.key);
//    }
//
//    public String toString() {
//        return "<" + key + "," + value + ">";
//    }
//}
//
//
//class CBHT<K extends Comparable<K>, E> {
//
//    // An object of class CBHT is a closed-bucket hash table, containing
//    // entries of class MapEntry.
//    private SLLNode<MapEntry<K, E>>[] buckets;
//
//    @SuppressWarnings("unchecked")
//    public CBHT(int m) {
//        // Construct an empty CBHT with m buckets.
//        buckets = (SLLNode<MapEntry<K, E>>[]) new SLLNode[m];
//    }
//
//    private int hash(K key) {
//        // Translate key to an index of the array buckets.
//        return Math.abs(key.hashCode()) % buckets.length;
//    }
//
//    public SLLNode<MapEntry<K, E>> search(K targetKey) {
//        // Find which if any node of this CBHT contains an entry whose key is
//        // equal
//        // to targetKey. Return a link to that node (or null if there is none).
//        int b = hash(targetKey);
//        for (SLLNode<MapEntry<K, E>> curr = buckets[b]; curr != null; curr = curr.succ) {
//            if (targetKey.equals(((MapEntry<K, E>) curr.element).key))
//                return curr;
//        }
//        return null;
//    }
//
//    public void insert(K key, E val) {        // Insert the entry <key, val> into this CBHT.
//        MapEntry<K, E> newEntry = new MapEntry<K, E>(key, val);
//        int b = hash(key);
//        for (SLLNode<MapEntry<K, E>> curr = buckets[b]; curr != null; curr = curr.succ) {
//            if (key.equals(((MapEntry<K, E>) curr.element).key)) {
//                // Make newEntry replace the existing entry ...
//                while(curr.succ!=null)
//                    curr=curr.succ;
//                curr.succ=new SLLNode<MapEntry<K,E>>(newEntry,null);
//                return;
//            }
//        }
//        // Insert newEntry at the front of the 1WLL in bucket b ...
//        buckets[b] = new SLLNode<MapEntry<K, E>>(newEntry, buckets[b]);
//    }
//
//    public void delete(K key) {
//        // Delete the entry (if any) whose key is equal to key from this CBHT.
//        int b = hash(key);
//        for (SLLNode<MapEntry<K, E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ) {
//            if (key.equals(((MapEntry<K, E>) curr.element).key)) {
//                if (pred == null)
//                    buckets[b] = curr.succ;
//                else
//                    pred.succ = curr.succ;
//                return;
//            }
//        }
//    }
//
//    public String toString() {
//        String temp = "";
//        for (int i = 0; i < buckets.length; i++) {
//            temp += i + ":";
//            for (SLLNode<MapEntry<K, E>> curr = buckets[i]; curr != null; curr = curr.succ) {
//                temp += curr.element.toString() + " ";
//            }
//            temp += "\n";
//        }
//        return temp;
//    }
//
//}
//
//class Lek {
//    private String name;
//    private int price;
//
//    public Lek(String name, int price) {
//        this.name = name;
//        this.price = price;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//}
//
//public class Farmacija {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        CBHT<String, Lek> hash = new CBHT<String, Lek>(50);
//        int n = Integer.parseInt(br.readLine());
//        for (int i = 0; i < n; i++) {
//            String line[] = br.readLine().split(" ");
//            hash.insert(line[1], new Lek(line[0], Integer.parseInt(line[2])));
//        }
//        String str = br.readLine();
//        SLLNode<MapEntry<String, Lek>> node = hash.search(str);
//        String name = "";
//        if (node != null) {
//            int min = node.element.value.getPrice();
//            name = node.element.value.getName();
//            while (node.succ != null) {
//                node = node.succ;
//                if (min > node.element.value.getPrice()) {
//                    min = node.element.value.getPrice();
//                    name = node.element.value.getName();
//                }
//            }
//        } else System.out.println("Nema lek za baranata namena vo magacin.");
//
//        System.out.println(name);
//
//    }
//}