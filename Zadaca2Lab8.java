//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Hashtable;
//import java.util.Scanner;
//
//class Graph {
//
//    int num_nodes; // broj na jazli
//    int adjMat[][];  // matrica na sosednost
//
//    public Graph(int num_nodes) {
//        this.num_nodes = num_nodes;
//        adjMat = new int[num_nodes][num_nodes];
//
//        for (int i = 0; i < this.num_nodes; i++)
//            for (int j = 0; j < this.num_nodes; j++)
//                adjMat[i][j] = 0;
//    }
//
//    public Graph(int num_nodes, int[][] adjMat) {
//        this.num_nodes = num_nodes;
//        this.adjMat = adjMat;
//    }
//
//
//    int adjacent(int x, int y) {  // proveruva dali ima vrska od jazelot so indeks x do jazelot so indeks y
//        return (adjMat[x][y] != 0) ? 1 : 0;
//    }
//
//    void addEdge(int x, int y) {  // dodava vrska megu jazlite so indeksi x i y
//        adjMat[x][y] = 1;
//        adjMat[y][x] = 1;
//    }
//
//    void deleteEdge(int x, int y) {
//        // ja brise vrskata megu jazlite so indeksi x i y
//        adjMat[x][y] = 0;
//        adjMat[y][x] = 0;
//    }
//
//    public int getNum_nodes() {
//        return num_nodes;
//    }
//
//    public void setNum_nodes(int num_nodes) {
//        this.num_nodes = num_nodes;
//    }
//
//
//    @Override
//    public String toString() {
//        String ret = "  ";
//        for (int i = 0; i < num_nodes; i++)
//            ret += i + " ";
//        ret += "\n";
//        for (int i = 0; i < num_nodes; i++) {
//            ret += i + " ";
//            for (int j = 0; j < num_nodes; j++)
//                ret += adjMat[i][j] + " ";
//            ret += "\n";
//        }
//        return ret;
//    }
//    public void printGraph(){
//        for(int i=0;i<adjMat.length;i++){
//            for(int j=0;j<adjMat[i].length;j++){
//                System.out.print(adjMat[i][j]+" ");
//            }
//            System.out.println();
//        }
//    }
//
//}
//
//public class Zadaca2Lab8 {
//
//    public static void main(String args[]) throws IOException {
//        Scanner scan = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = scan.nextInt();
//        String array =new String();
//        String arraySplit[]=new String[10];
//        Hashtable<Integer,Character> hash=new Hashtable<Integer,Character>();
//        scan.next();
//        int m=scan.nextInt();
//        Graph g=new Graph(m);
//        char a='A';
//        for(int j=1;j<m;j++){
//            hash.put(j,a++);
//        }
//        for(int i=0;i<n;i++){
//            array=br.readLine();
//            arraySplit=array.split(" ");
////            System.out.println(arraySplit[1]);
//            switch (arraySplit[0]){
//                case ("ADDEDGE"):{
//                    g.addEdge(Integer.parseInt(arraySplit[1]),Integer.parseInt(arraySplit[2]));
//                    break;
//                }
//                case ("PRINTMATRIX"):{
//                    g.printGraph();
//                    break;
//                }
//                case ("PRINTNODE"):{
//                    System.out.println(hash.get(Integer.parseInt(arraySplit[1])));
//                    break;
//                }
//                case ("DELETEEDGE"):{
//                    g.deleteEdge(Integer.parseInt(arraySplit[1]),Integer.parseInt(arraySplit[2]));
//                    break;
//                }
//                case("ADЈACENT"):{
//                    System.out.println(g.adjacent(Integer.parseInt(arraySplit[1]),Integer.parseInt(arraySplit[2])));
//                    break;
//                }
//            }
//
//        }
//
//
//
//
//    }
//}
