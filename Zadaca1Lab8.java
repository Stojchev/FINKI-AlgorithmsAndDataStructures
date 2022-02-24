import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Stack;

class Graph {

   int num_nodes; // broj na jazli
   int adjMat[][];  // matrica na sosednost

   public Graph(int num_nodes) {
       this.num_nodes = num_nodes;
       adjMat = new int[num_nodes][num_nodes];

       for (int i = 0; i < this.num_nodes; i++)
           for (int j = 0; j < this.num_nodes; j++)
               adjMat[i][j] = 0;
   }

   public Graph(int num_nodes, int[][] adjMat) {
       this.num_nodes = num_nodes;
       this.adjMat = adjMat;
   }


   int adjacent(int x, int y) {  // proveruva dali ima vrska od jazelot so indeks x do jazelot so indeks y
       return (adjMat[x][y] != 0) ? 1 : 0;
   }

   void addEdge(int x, int y) {  // dodava vrska megu jazlite so indeksi x i y
       adjMat[x][y] = 1;
       adjMat[y][x] = 1;
   }

   void deleteEdge(int x, int y) {
       // ja brise vrskata megu jazlite so indeksi x i y
       adjMat[x][y] = 0;
       adjMat[y][x] = 0;
   }

   public int getNum_nodes() {
       return num_nodes;
   }

   public void setNum_nodes(int num_nodes) {
       this.num_nodes = num_nodes;
   }


   @Override
   public String toString() {
       String ret = "  ";
       for (int i = 0; i < num_nodes; i++)
           ret += i + " ";
       ret += "\n";
       for (int i = 0; i < num_nodes; i++) {
           ret += i + " ";
           for (int j = 0; j < num_nodes; j++)
               ret += adjMat[i][j] + " ";
           ret += "\n";
       }
       return ret;
   }

}

class Maze {
   Graph g;
   int start_node;
   int end_node;
   Hashtable<String, Integer> h;
   Hashtable<Integer, String> hr;

   public Maze() {
       h = new Hashtable<String, Integer>();
       hr = new Hashtable<Integer, String>();
   }

   void generateGraph(int rows,int columns,String input[]){

       int n=0;
       String key;
       for(int i=0;i<rows;i++){
           for(int j=0;j<columns;j++){
               if(input[i].charAt(j)!='#'){
                   key=i+","+j;
                   h.put(key,n);
                   hr.put(n,key);
               }
               if(input[i].charAt(j)=='S'){
                   start_node=n;
               }
               if(input[i].charAt(j)=='E'){
                   end_node=n;
               }
               n++;
           }
       }
       g = new Graph(n);
       int x,y;
       for(int i=0;i<rows;i++){
           for(int j=0;j<columns;j++) {
               if(input[i].charAt(j)!='#'){
                   if(input[i].charAt(j-1)!='#'){
                       x=h.get(i+","+j);
                       y=h.get(i+","+(j-1));
                       g.addEdge(x,y);
                   }
                   if(input[i].charAt(j+1)!='#'){
                       x=h.get(i+","+j);
                       y=h.get(i+","+(j+1));
                       g.addEdge(x,y);
                   }
                   if(input[i+1].charAt(j)!='#'){
                       x=h.get(i+","+j);
                       y=h.get((i+1)+","+(j));
                       g.addEdge(x,y);
                   }
                   if(input[i-1].charAt(j)!='#'){
                       x=h.get(i+","+j);
                       y=h.get((i-1)+","+j);
                       g.addEdge(x,y);
                   }
               }
           }
       }

   }
   public void findPath(){

       Stack<Integer> stack=new Stack<Integer>();
       boolean visited[]=new boolean[g.getNum_nodes()];
       for(int i=0;i<g.getNum_nodes();i++)
           visited[i]=false;
       visited[start_node]=true;
       stack.push(start_node);
       int pom=0;
       while(!stack.isEmpty()&&stack.peek()!=end_node){
           pom=stack.peek();
           int pom1=pom;
           for(int i=0;i< g.num_nodes;i++){
               if(g.adjacent(pom,i)==1){
                   pom1=i;
                   if(!visited[i]){
                       break;
                   }
               }
           }
           if(!visited[pom1]){
               visited[pom1]=true;
               stack.push(pom1);
           }else stack.pop();
       }
       if(stack.isEmpty())
          System.out.println("Nema pat");
       else{
           Stack<Integer> reverStack=new Stack<>();
           while(!stack.isEmpty()){
               reverStack.push(stack.pop());
           }
           while(!reverStack.isEmpty()){
               System.out.println(hr.get(reverStack.pop()));
           }
       }


   }
}

public class Zadaca1Lab8 {
   public static void main(String args[]) throws IOException {
       Scanner scan = new Scanner(System.in);
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n, m;
       String asd = br.readLine();
       String as[] = asd.split(",");
       n = Integer.parseInt(as[0]);
       m = Integer.parseInt(as[1]);
       String lista[] = new String[n];
       for (int i = 0; i < n; i++) {
           lista[i] = br.readLine();
       }
       Maze maze=new Maze();
       maze.generateGraph(n,m,lista);
       maze.findPath();
   }
}
