//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Locale;
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
//
//    public E getElement() {
//        return element;
//    }
//}
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
//        //return Math.abs(key.hashCode()) % buckets.length;
//        String name=(String)key;
//        int c1,c2,c3;
//        c1=(int)name.charAt(0);
//        c2=(int)name.charAt(1);
//        c3=(int)name.charAt(2);
//        return (29*(29*(29*0 + c1)+c3) % 102780);
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
//class LekovitiBilki {
//    private int pozitivnost;
//    private int cena;
//    private int kolicina;
//
//    public LekovitiBilki() {
//    }
//
//    public LekovitiBilki(int pozitivnost, int cena, int kolicina) {
//        this.pozitivnost = pozitivnost;
//        this.cena = cena;
//        this.kolicina = kolicina;
//    }
//
//    public void setPozitivnost(int pozitivnost) {
//        this.pozitivnost = pozitivnost;
//    }
//
//    public void setCena(int cena) {
//        this.cena = cena;
//    }
//
//    public void odzemiKolicina(int kol) {
//        this.kolicina = kolicina-kol;
//    }
//    public void setKolicina(int kolicina) {
//        this.kolicina = kolicina;
//    }
//    public int getCena() {
//        return cena;
//    }
//    public int getKolicina() {
//        return kolicina;
//    }
//
//    public int getPozitivnost() {
//        return pozitivnost;
//    }
//}
//
//public class Apteka {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        CBHT<String, LekovitiBilki> hash = new CBHT<String, LekovitiBilki>((int) (102780));
//        for (int i = 1; i <= N; i++) {
//            String[] reader = br.readLine().split(" ");
//            hash.insert(reader[0], new LekovitiBilki(Integer.parseInt(reader[1]), Integer.parseInt(reader[2]), Integer.parseInt(reader[3])));
//        }
//        while (true) {
//            String name = br.readLine();
//            if (name == "Kraj") break;
//            name=name.toUpperCase(Locale.ROOT);
//            int kolicina=Integer.parseInt(br.readLine());
//            SLLNode<MapEntry<String, LekovitiBilki>> tmp = hash.search(name);
//            if(tmp!=null){
//                System.out.println(name);
//                if(tmp.element.value.getPozitivnost()==1)
//                    System.out.println("POZ");
//                else System.out.println("NEG");
//                System.out.println(tmp.element.value.getCena());
//                System.out.println(tmp.element.value.getKolicina()+kolicina);
//                if(tmp.element.value.getKolicina()-kolicina<0){
//                    System.out.println("Nema dovolno na zaliha");
//                }else{
//                    System.out.println("Napraven naracka");
//                    tmp.element.value.odzemiKolicina(kolicina);
//                }
//            }else System.out.println("Nema takov lek");
//        }
//    }
//}
