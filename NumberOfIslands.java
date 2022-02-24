import java.util.*;
import java.lang.*;
import java.io.*;

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

interface Queue<E> {

   // Elementi na redicata se objekti od proizvolen tip.

   // Metodi za pristap:

   public boolean isEmpty();
   // Vrakja true ako i samo ako redicata e prazena.

   public int size();
   // Ja vrakja dolzinata na redicata.

   public E peek();
   // Go vrakja elementot na vrvot t.e. pocetokot od redicata.

   // Metodi za transformacija:

   public void clear();
   // Ja prazni redicata.

   public void enqueue(E x);
   // Go dodava x na kraj od redicata.

   public E dequeue();
   // Go otstranuva i vrakja pochetniot element na redicata.

}

class LinkedQueue<E> implements Queue<E> {

   // Redicata e pretstavena na sledniot nacin:
   // length go sodrzi brojot na elementi.
   // Elementite se zachuvuvaat vo jazli dod SLL
   // front i rear se linkovi do prviot i posledniot jazel soodvetno.
   SLLNode<E> front, rear;
   int length;

   // Konstruktor ...

   public LinkedQueue() {
       clear();
   }

   public boolean isEmpty() {
       // Vrakja true ako i samo ako redicata e prazena.
       return (length == 0);
   }

   public int size() {
       // Ja vrakja dolzinata na redicata.
       return length;
   }

   public E peek() {
       // Go vrakja elementot na vrvot t.e. pocetokot od redicata.
       if (front == null)
           throw new NoSuchElementException();
       return front.element;
   }

   public void clear() {
       // Ja prazni redicata.
       front = rear = null;
       length = 0;
   }

   public void enqueue(E x) {
       // Go dodava x na kraj od redicata.
       SLLNode<E> latest = new SLLNode<E>(x, null);
       if (rear != null) {
           rear.succ = latest;
           rear = latest;
       } else
           front = rear = latest;
       length++;
   }

   public E dequeue() {
       // Go otstranuva i vrakja pochetniot element na redicata.
       if (front != null) {
           E frontmost = front.element;
           front = front.succ;
           if (front == null) rear = null;
           length--;
           return frontmost;
       } else
           throw new NoSuchElementException();
   }

}

class GraphNode<E> {
   private int index;//index (reden broj) na temeto vo grafot
   private E info;
   private LinkedList<GraphNode<E>> neighbors;

   public GraphNode(int index, E info) {
       this.index = index;
       this.info = info;
       neighbors = new LinkedList<GraphNode<E>>();
   }
   public GraphNode(int index) {
       this.index = index;
       neighbors = new LinkedList<GraphNode<E>>();
   }

   boolean containsNeighbor(GraphNode<E> o) {
       return neighbors.contains(o);
   }

   void addNeighbor(GraphNode<E> o) {
       neighbors.add(o);
   }

   void removeNeighbor(GraphNode<E> o) {
       if (neighbors.contains(o))
           neighbors.remove(o);
   }

   @Override
   public String toString() {
       String ret = "INFO:" + info + " SOSEDI:";
       for (int i = 0; i < neighbors.size(); i++)
           ret += neighbors.get(i).info + " ";
       return ret;

   }

   @Override
   public boolean equals(Object obj) {
       @SuppressWarnings("unchecked")
       GraphNode<E> pom = (GraphNode<E>) obj;
       return (pom.info.equals(this.info));
   }

   public int getIndex() {
       return index;
   }

   public void setIndex(int index) {
       this.index = index;
   }

   public E getInfo() {
       return info;
   }

   public void setInfo(E info) {
       this.info = info;
   }

   public LinkedList<GraphNode<E>> getNeighbors() {
       return neighbors;
   }

   public void setNeighbors(LinkedList<GraphNode<E>> neighbors) {
       this.neighbors = neighbors;
   }


}

class Graph<E> {

   int num_nodes;
   GraphNode<E> adjList[];

   @SuppressWarnings("unchecked")
   public Graph(int num_nodes, E[] list) {
       this.num_nodes = num_nodes;
       adjList = (GraphNode<E>[]) new GraphNode[num_nodes];
       for (int i = 0; i < num_nodes; i++)
           adjList[i] = new GraphNode<E>(i);
   }

   @SuppressWarnings("unchecked")
   public Graph(int num_nodes, int[] list) {
       this.num_nodes = num_nodes;
       adjList = (GraphNode<E>[]) new GraphNode[num_nodes];

   }

   int adjacent(int x, int y) {
       // proveruva dali ima vrska od jazelot so
       // indeks x do jazelot so indeks y
       return (adjList[x].containsNeighbor(adjList[y])) ? 1 : 0;
   }

   void addEdge(int x, int y) {
       // dodava vrska od jazelot so indeks x do jazelot so indeks y
       if (!adjList[x].containsNeighbor(adjList[y])) {
           adjList[x].addNeighbor(adjList[y]);
       }
   }

   void deleteEdge(int x, int y) {
       adjList[x].removeNeighbor(adjList[y]);
   }

   void dfsSearch(int node) {
       boolean visited[] = new boolean[num_nodes];
       for (int i = 0; i < num_nodes; i++)
           visited[i] = false;
       dfsRecursive(node, visited);
   }

   void dfsRecursive(int node, boolean visited[]) {
       visited[node] = true;
       System.out.println(node + ": " + adjList[node].getInfo());

       for (int i = 0; i < adjList[node].getNeighbors().size(); i++) {
           GraphNode<E> pom = adjList[node].getNeighbors().get(i);
           if (!visited[pom.getIndex()])
               dfsRecursive(pom.getIndex(), visited);
       }
   }

   void dfsNonrecursive(int node) {
       boolean visited[] = new boolean[num_nodes];
       for (int i = 0; i < num_nodes; i++)
           visited[i] = false;
       visited[node] = true;
       System.out.println(node + ": " + adjList[node].getInfo());
       Stack<Integer> s = new Stack<Integer>();
       s.push(node);

       GraphNode<E> pom;

       while (!s.isEmpty()) {
           pom = adjList[s.peek()];
           GraphNode<E> tmp = null;
           for (int i = 0; i < pom.getNeighbors().size(); i++) {
               tmp = pom.getNeighbors().get(i);
               if (!visited[tmp.getIndex()])
                   break;
           }
           if (tmp != null && !visited[tmp.getIndex()]) {
               visited[tmp.getIndex()] = true;
               System.out.println(tmp.getIndex() + ": " + tmp.getInfo());
               s.push(tmp.getIndex());
           } else
               s.pop();
       }

   }


   @Override
   public String toString() {
       String ret = new String();
       for (int i = 0; i < this.num_nodes; i++)
           ret += i + ": " + adjList[i] + "\n";
       return ret;
   }

}

public class NumberOfIslands {
   public static boolean[][] calculateMatrix(int col, boolean vis[][], int i, int j, int matrix[][]) {
       System.out.println(j);
       boolean valid[][] = vis;
       if (j < col - 1 && matrix[i][j + 1] == 1 && !valid[i][j + 1]) {
           valid[i][j + 1] = true;
           valid = calculateMatrix(col, vis, i, j + 1, matrix);
       }
       if (i < col - 1 && matrix[i + 1][j] == 1 && !valid[i + 1][j]) {
           valid[i + 1][j] = true;
           valid = calculateMatrix(col, vis, i + 1, j, matrix);
       }
       if (i < col - 1 && j < col - 1 && matrix[i + 1][j + 1] == 1 && !valid[i + 1][j + 1]) {
           valid[i + 1][j + 1] = true;
           valid = calculateMatrix(col, vis, i + 1, j + 1, matrix);
       }
       if (i < col - 1 && j > 0 && matrix[i + 1][j - 1] == 1 && !valid[i + 1][j - 1]) {
           valid[i + 1][j - 1] = true;
           valid = calculateMatrix(col, vis, i + 1, j - 1, matrix);
       }

       if (j > 0 && matrix[i][j - 1] == 1 && !valid[i][j - 1]) {
           valid[i][j - 1] = true;
           valid = calculateMatrix(col, vis, i, j - 1, matrix);
       }
       if (i > 0 && matrix[i - 1][j] == 1 && !valid[i - 1][j]) {
           valid[i - 1][j] = true;
           valid = calculateMatrix(col, vis, i - 1, j, matrix);
       }
       if (i > 0 && j > 0 && matrix[i - 1][j - 1] == 1 && !valid[i - 1][j - 1]) {
           valid[i - 1][j - 1] = true;
           valid = calculateMatrix(col, vis, i - 1, j - 1, matrix);
       }
       if (i > 0 && j < col - 1 && matrix[i - 1][j + 1] == 1 && !valid[i - 1][j + 1]) {
           valid[i - 1][j + 1] = true;
           valid = calculateMatrix(col, vis, i + 1, j - 1, matrix);
       }


       return valid;
   }

   public static void main(String[] args) throws Exception {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());
       int matrix[][] = new int[n][n];
       int list[] = new int[n * n];
       int k = 0;
//        for(int i=0;i<n;i++)
//            for(int j=0;j<n;j++)
//                list[k]=k++;
//
//        Graph g = new Graph(n,list);
       for (int i = 0; i < n; i++) {
           String line[] = br.readLine().split(" ");
           for (int j = 0; j < n; j++) {
               matrix[i][j] = Integer.parseInt(line[j]);
           }
       }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (matrix[i][j] == 1) {
//                    g.adjacent(i, j);
//                }
//            }
//        }
//        int countVrski[] = new int[n];
//        for (int tmp = 0; tmp < n; tmp++){
//            for (int i = 0; i < n; i++) {
//                if (g.adjacent(tmp, i) == 1) {
//                    countVrski[tmp]++;
//                }
//            }
//        }
//        for(int i=0;i<n;i++){
//            System.out.print(countVrski[i]);
//        }
       boolean[][] visited = new boolean[n][n];
       for (int i = 0; i < n; i++) {
           for (int j = 0; j < n; j++)
               if (matrix[i][j] == 0) {
                   visited[i][j] = true;
               }
       }
       int sum = 0;
       for (int i = 0; i < n; i++) {
           for (int j = 0; j < n; j++) {
               if (matrix[i][j] == 1 && !visited[i][j]) {
                   visited[i][j] = true;
                   visited = calculateMatrix(n, visited, i, j, matrix);
                   sum++;
               }
           }
       }
       System.out.println();
       System.out.println(sum);
   }
}
