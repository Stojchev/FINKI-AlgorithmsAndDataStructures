//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.NoSuchElementException;
//import java.util.StringTokenizer;
//
//
//class BNode<E> {
//
//    public E info;
//    public BNode<E> left;
//    public BNode<E> right;
//
//    static int LEFT = 1;
//    static int RIGHT = 2;
//
//    public BNode(E info) {
//        this.info = info;
//        left = null;
//        right = null;
//    }
//
//    public BNode() {
//        this.info = null;
//        left = null;
//        right = null;
//    }
//
//    public BNode(E info, BNode<E> left, BNode<E> right) {
//        this.info = info;
//        this.left = left;
//        this.right = right;
//    }
//
//    @Override
//    public String toString() {
//        return "" + info;
//    }
//}
//
//class BTree<E> {
//
//    public BNode<E> root;
//
//    public BTree() {
//        root = null;
//    }
//
//    public BTree(E info) {
//        root = new BNode<E>(info);
//    }
//
//    public void makeRoot(E elem) {
//        root = new BNode(elem);
//    }
//
//    public void makeRootNode(BNode<E> node) {
//        root = node;
//    }
//
//    public BNode<E> addChild(BNode<E> node, int where, E elem) {
//
//        BNode<E> tmp = new BNode<E>(elem);
//
//        if (where == BNode.LEFT) {
//            if (node.left != null)  // veke postoi element
//                return null;
//            node.left = tmp;
//        } else {
//            if (node.right != null) // veke postoi element
//                return null;
//            node.right = tmp;
//        }
//
//        return tmp;
//    }
//
//    public BNode<E> addChildNode(BNode<E> node, int where, BNode<E> tmp) {
//
//        if (where == BNode.LEFT) {
//            if (node.left != null)  // veke postoi element
//                return null;
//            node.left = tmp;
//        } else {
//            if (node.right != null) // veke postoi element
//                return null;
//            node.right = tmp;
//        }
//
//        return tmp;
//    }
//
//    public BNode<String> find(BNode<String> node, String a) {
//        BNode<String> tmp = null;
//        if (node == null)
//            return null;
//        if (node.info.equals(a))
//            return node;
//
//        tmp = find(node.left, a);
//        if (tmp == null)
//            tmp = find(node.right, a);
//
//        return tmp;
//    }
//
//    public int findDistance(BNode<String> from, BNode<String> to, int sum) {
//        if (from == null)
//            return 0;
//        if (from.info == to.info) {
//            return sum;
//        }
//        int sum1 = 0;
//        sum1 += findDistance(from.left, to, sum + 2);
//        if (sum1 == 0)
//            sum1 += findDistance(from.right, to, sum + 2);
//        return sum1;
//    }
//
//    public BNode<String> LCA(BNode<String> root, BNode<String> start, BNode<String> finish) {
//        if (root == null)
//            return null;
//        if (root == start || root == finish)
//            return root;
//
//        BNode<String> left = LCA(root.left, start, finish);
//        BNode<String> right = LCA(root.right, start, finish);
//        if (left != null && right != null)
//            return root;
//        if (left != null)
//            return left;
//        return right;
//    }
//
//    public int rastojanie(BNode<String> lca, BNode<E> node) {
//        if (lca == null)
//            return 100000;
//        if (lca == node)
//            return 0;
//        else return Math.min((rastojanie(lca.right, node) + 1), (rastojanie(lca.left, node) + 1));
//    }
//
//}
//
//
//interface Stack<E> {
//
//    // Elementi na stekot se objekti od proizvolen tip.
//
//    // Metodi za pristap:
//
//    public boolean isEmpty();
//    // Vrakja true ako i samo ako stekot e prazen.
//
//    public E peek();
//    // Go vrakja elementot na vrvot od stekot.
//
//    // Metodi za transformacija:
//
//    public void clear();
//    // Go prazni stekot.
//
//    public void push(E x);
//    // Go dodava x na vrvot na stekot.
//
//    public E pop();
//    // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
//}
//
//class ArrayStack<E> implements Stack<E> {
//    private E[] elems;
//    private int depth;
//
//    @SuppressWarnings("unchecked")
//    public ArrayStack(int maxDepth) {
//        // Konstrukcija na nov, prazen stek.
//        elems = (E[]) new Object[maxDepth];
//        depth = 0;
//    }
//
//
//    public boolean isEmpty() {
//        // Vrakja true ako i samo ako stekot e prazen.
//        return (depth == 0);
//    }
//
//
//    public E peek() {
//        // Go vrakja elementot na vrvot od stekot.
//        if (depth == 0)
//            throw new NoSuchElementException();
//        return elems[depth - 1];
//    }
//
//
//    public void clear() {
//        // Go prazni stekot.
//        for (int i = 0; i < depth; i++) elems[i] = null;
//        depth = 0;
//    }
//
//
//    public void push(E x) {
//        // Go dodava x na vrvot na stekot.
//        elems[depth++] = x;
//    }
//
//
//    public E pop() {
//        // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
//        if (depth == 0)
//            throw new NoSuchElementException();
//        E topmost = elems[--depth];
//        elems[depth] = null;
//        return topmost;
//    }
//
//}
//
//public class MaximumPathLenght {
//    public static int MaxLenght(BNode<Integer> curr, int value, int prevValue) {
//        if (curr == null)
//            return value;
//        int sumLeft = 0, sumRight = 0;
//        if (curr.left != null && curr.info - curr.left.info == 1)
//            sumLeft = MaxLenght(curr.left, value + 1, prevValue);
//        if (curr.right != null && curr.info - curr.right.info == 1)
//            sumRight = MaxLenght(curr.right, value + 1, prevValue);
//
//        int sum = Math.max(sumLeft, sumRight);
//        prevValue = Math.max(sum, prevValue);
//
//        sumLeft = MaxLenght(curr.left, value, prevValue);
//        sumRight = MaxLenght(curr.right, value, prevValue);
//        sum = Math.max(sumLeft, sumRight);
//        prevValue = Math.max(sum, prevValue);
//        return prevValue;
//    }
//
//    public static void main(String[] args) throws Exception {
//        int i, j, k;
//        int index;
//        String action;
//
//        String line;
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        int N = Integer.parseInt(br.readLine());
//
//        BNode<Integer> nodes[] = new BNode[N];
//        BTree<Integer> tree = new BTree<Integer>();
//
//        for (i = 0; i < N; i++)
//            nodes[i] = new BNode<Integer>();
//
//        for (i = 0; i < N; i++) {
//            line = br.readLine();
//            st = new StringTokenizer(line);
//            index = Integer.parseInt(st.nextToken());
//            nodes[index].info = Integer.parseInt(st.nextToken());
//            action = st.nextToken();
//            if (action.equals("LEFT")) {
//                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.LEFT, nodes[index]);
//            } else if (action.equals("RIGHT")) {
//                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.RIGHT, nodes[index]);
//            } else {
//                // this node is the root
//                tree.makeRootNode(nodes[index]);
//            }
//        }
//        System.out.print("Max lenght is:" + MaxLenght(tree.root, 1, 1));
//    }
//
//}
