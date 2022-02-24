//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
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
//                curr.element = newEntry;
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
//class Person{
//    private String name;
//    Date date;
//    Person(String name,Date date){
//        this.name=name;
//        this.date=date;
//    }
//    public Date getDate(){
//        return date;
//    }
//    public String getName(){
//        return name;
//    }
//}
//
//
//public class Radar {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        CBHT<String, String> hash = new CBHT<String, String>(100);
//        int n = Integer.parseInt(br.readLine());
//        for (int i = 0; i < n; i++) {
//            String line[] = br.readLine().split(" ");
//            String registracija = line[0];
//            String name = line[1] + " " + line[2];
//            hash.insert(registracija, name);
//        }
//        int maxBrzina = Integer.parseInt(br.readLine());
//        LinkedList<Person> personList=new LinkedList<>();
//
//        String line[] = br.readLine().split(" ");
//        for (int i = 0; i < line.length; i += 3) {
//            if (Integer.parseInt(line[i + 1]) > maxBrzina) {
//                String timer[] = line[i + 2].split(":");
//                int time = 0;
//                time = (Integer.parseInt(timer[0]) * 10000) + ((Integer.parseInt(timer[1])) * 100) + Integer.parseInt(timer[2]);
//                Date date=new Date(2000,1,1,Integer.parseInt(timer[0]),Integer.parseInt(timer[1]),Integer.parseInt(timer[2]));
////                System.out.println(date);
//                personList.add(new Person(hash.search(line[i]).element.value,date));
//            }
//        }
//        Collections.sort(personList, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getDate().compareTo(o2.getDate());
//            }
//        });
//        Iterator<Person> it=personList.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next().getName());
//        }
//    }
//
//}
