//
///*
//За да се изведе едно предвидување со тарот карти, гатачка користи еден шпил на карти, од кој зема точно 12
//карти и ги дели на две половини, кои се чуваат во две еднострано поврзани листи. Така, во првата листа се
//чуваат податоците за картите од првиот дел, а додека пак во втората се чуваат податоците за картите од вториот дел.
//
//За секоја карта се важни податоците за: id на картата (int id) и ранг на картата (int rank).
//
//Пред да започне со предвидувањето со картите, гатачката прави мешање на картите кое се изведува во 3 чекори,
//секогаш во овој редослед:
//
//    Од првиот дел ја зема првата карта и ја става како последна карта во вториот дел.
//    Потоа, од вториот дел ја зема првата карта и ја става како последна карта во првиот дел.
//    За крај, ја зема претпоследната карта од првиот дел и ја става на средина на вториот дел.
//
//Ваша задача е да симулирате вакво мешање на тарот картите, во точно кажаниот редослед.
//
//Влез: Во секој ред се дадени податоци за една тарот карта, одделени со празно место, во формат id rank. Притоа,
//прво се дадени картите од првиот дел, по што следуваат податоците за картите од вториот дел.
//
//Излез: Во првиот ред id на сите карти од првиот дел. Во вториот ред id на сите карти од вториот дел.
//
//Внимавајте:
//
//    1.Секое едно земање на карта од еден и префрлање на истата во друг дел, значи бришење на картата од едната
//    листа и вметнување во другата листа, на одреденото место.
//    2.Даден е целосниот код на структурата којашто треба да се користи. Дадена е и тест класата Tarot.java, со
//    целосно имплементиран input и output. Потребно е да се менува само во рамки на void tarotCards(SLL<Card>
//    firstPart, SLL<Card> secondPart) функцијата.
//    3.Притоа, бришењето треба да биде имплементирано како бришење на цел јазол, а додавањето како додавање на
//    цел јазол. Промените (бришење/додавање елемент) не треба да се однесуваат на информациите во самите јазли
//    туку во промени на врските помеѓу јазлите.
//    4.Не смее да менувате во main функцијата !
//
//Input:
//33 51
//18 52
//40 50
//6 24
//4 18
//88 13
//45 34
//98 3
//87 16
//32 19
//28 22
//82 5
//
//Output:
//18 40 6 4 45
//98 87 32 88 28 82 33
//*/
//
//import java.util.Scanner;
//
//class Card {
//
//    private int id;
//    private int rank;
//
//    public Card(int id, int rank) {
//        this.id = id;
//        this.rank = rank;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getRank() {
//        return rank;
//    }
//
//    public void setRank(int rank) {
//        this.rank = rank;
//    }
//
//    @Override
//    public String toString() {
//        return String.valueOf(id);
//    }
//}
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
//class SLL<E> {
//    private SLLNode<E> first;
//
//    public SLL() {
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
//            ret += tmp;
//            while (tmp.succ != null) {
//                tmp = tmp.succ;
//                ret += " " + tmp;
//            }
//        } else
//            ret = "Prazna lista!!!";
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
//        } else {
//            System.out.println("Dadenot jazol e null");
//        }
//    }
//
//    public void insertBefore(E o, SLLNode<E> before) {
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            if (first == before) {
//                this.insertFirst(o);
//                return;
//            }
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
//            if (first == node) {
//                return this.deleteFirst();
//            }
//            while (tmp.succ != node && tmp.succ.succ != null)
//                tmp = tmp.succ;
//            if (tmp.succ == node) {
//                tmp.succ = tmp.succ.succ;
//                return node.element;
//            } else {
//                System.out.println("Elementot ne postoi vo listata");
//                return null;
//            }
//        } else {
//            System.out.println("Listata e prazna");
//            return null;
//        }
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
//            } else {
//                System.out.println("Elementot ne postoi vo listata");
//            }
//        } else {
//            System.out.println("Listata e prazna");
//        }
//        return first;
//    }
//}
//
//public class Tarot {
//
//    //todo: implement function
//    public static void tarotCards(SLL<Card> firstPart, SLL<Card> secondPart) {
//        SLLNode<Card> tmp1=firstPart.getFirst();
//        SLLNode<Card> tmp=firstPart.getFirst();
//        while(tmp1!=null){
//            tmp=tmp1;
//            tmp1=tmp1.succ;
//        }
//        SLLNode<Card> first=firstPart.getFirst();
//        secondPart.insertLast(first.element);
//        firstPart.deleteFirst();
//        firstPart.delete(tmp);
//        first=secondPart.getFirst();
//        secondPart.deleteFirst();
//        firstPart.insertLast(first.element);
//        secondPart.insertAfter(tmp.element,secondPart.getFirst().succ.succ);
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        SLL<Card> firstPart = new SLL<Card>();
//        SLL<Card> secondPart = new SLL<Card>();
//
//        for (int i = 0; i < 6; i++) {
//            String line = scanner.nextLine();
//            String[] parts = line.split("\\s+");
//            firstPart.insertLast(new Card(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
//        }
//
//        for (int i = 0; i < 6; i++) {
//            String line = scanner.nextLine();
//            String[] parts = line.split("\\s+");
//            secondPart.insertLast(new Card(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
//        }
//
//        tarotCards(firstPart, secondPart);
//        System.out.println(firstPart.toString());
//        System.out.println(secondPart.toString());
//    }
//}