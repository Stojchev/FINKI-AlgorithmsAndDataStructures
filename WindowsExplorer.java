//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//import java.util.Iterator;
//import java.util.NoSuchElementException;
//import java.io.IOException;
//
//interface Tree<E> {
//    ////////////Accessors ////////////
//
//    public Node<E> root();
//
//    public Node<E> parent(Node<E> node);
//
//    public int childCount(Node<E> node);
//
//    ////////////Transformers ////////////
//    public void makeRoot(E elem);
//
//    public Node<E> addChild(Node<E> node, E elem);
//
//    public void remove(Node<E> node);
//
//    ////////////Iterator ////////////
//    public Iterator<E> children(Node<E> node);
//
//}
//
//interface Node<E> {
//
//    public E getElement();
//
//    public void setElement(E elem);
//}
//
//
//class SLLTree<E> implements Tree<E> {
//
//    public SLLNode<E> root;
//
//    public SLLTree() {
//        root = null;
//    }
//
//    public Node<E> root() {
//        return root;
//    }
//
//    public Node<E> parent(Node<E> node) {
//        return ((SLLNode<E>) node).parent;
//    }
//
//    public int childCount(Node<E> node) {
//        SLLNode<E> tmp = ((SLLNode<E>) node).firstChild;
//        int num = 0;
//        while (tmp != null) {
//            tmp = tmp.sibling;
//            num++;
//        }
//        return num;
//    }
//
//    public void makeRoot(E elem) {
//        root = new SLLNode<E>(elem);
//    }
//
//    public Node<E> addChild(Node<E> node, E elem) {
//        SLLNode<E> tmp = new SLLNode<E>(elem);
//        SLLNode<E> curr = (SLLNode<E>) node;
//        tmp.sibling = curr.firstChild;
//        curr.firstChild = tmp;
//        tmp.parent = curr;
//        return tmp;
//    }
//
//    public void remove(Node<E> node) {
//        SLLNode<E> curr = (SLLNode<E>) node;
//        if (curr.parent != null) {
//            if (curr.parent.firstChild == curr) {
//                // The node is the first child of its parent
//                // Reconnect the parent to the next sibling
//                curr.parent.firstChild = curr.sibling;
//            } else {
//                // The node is not the first child of its parent
//                // Start from the first and search the node in the sibling list and remove it
//                SLLNode<E> tmp = curr.parent.firstChild;
//                while (tmp.sibling != curr) {
//                    tmp = tmp.sibling;
//                }
//                tmp.sibling = curr.sibling;
//            }
//        } else {
//            root = null;
//        }
//    }
//
//    class SLLTreeIterator<T> implements Iterator<T> {
//
//        SLLNode<T> start, current;
//
//        public SLLTreeIterator(SLLNode<T> node) {
//            start = node;
//            current = node;
//        }
//
//        public boolean hasNext() {
//            return (current != null);
//        }
//
//        public T next() throws NoSuchElementException {
//            if (current != null) {
//                SLLNode<T> tmp = current;
//                current = current.sibling;
//                return tmp.getElement();
//            } else {
//                throw new NoSuchElementException();
//            }
//        }
//
//        public void remove() {
//            if (current != null) {
//                current = current.sibling;
//            }
//        }
//    }
//
//    public Iterator<E> children(Node<E> node) {
//        return new SLLTreeIterator<E>(((SLLNode<E>) node).firstChild);
//    }
//
//    void printTreeRecursive(Node<E> node, int level) {
//        if (node == null)
//            return;
//        int i;
//        SLLNode<E> tmp;
//
//        for (i = 0; i < level; i++)
//            System.out.print(" ");
//        System.out.println(node.getElement().toString());
//        tmp = ((SLLNode<E>) node).firstChild;
//        while (tmp != null) {
//            printTreeRecursive(tmp, level + 1);
//            tmp = tmp.sibling;
//        }
//    }
//
//    public void printTree() {
//        printTreeRecursive(root, 0);
//    }
//
//}
//
//class SLLNode<P> implements Node<P> {
//
//    // Holds the links to the needed nodes
//    public SLLNode<P> parent, sibling, firstChild;
//    // Hold the data
//    public P element;
//
//    public SLLNode(P o) {
//        element = o;
//        parent = sibling = firstChild = null;
//    }
//
//    public P getElement() {
//        return element;
//    }
//
//    public void setElement(P o) {
//        element = o;
//    }
//}
//
//public class WindowsExplorer {
//
//    public static void main(String[] args) throws Exception {
//        int i, j, k;
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//        String commands[] = new String[N];
//
//        for (i = 0; i < N; i++)
//            commands[i] = br.readLine();
//        //commands[i] = br.readLine();
//
//        br.close();
//
//        SLLTree<String> tree = new SLLTree<String>();
//        tree.makeRoot("c:");
//
//        // vasiot kod stoi ovde
//        SLLNode<String> root = tree.root;
//        for (i = 0; i < commands.length; i++) {
//            String add;
//            if (commands[i] == null)
//                return;
//            String[] type = commands[i].split(" ");
//            if (type.length == 2)
//                add = type[1];
//            else add = type[0];
//            switch (type[0]) {
//                case ("CREATE"): {
//                    SLLNode<String> tmp = root.firstChild;
//                    if (tmp == null || (tmp.element.compareTo(add) > 0)) {
//                        tree.addChild(root, add);
//                    } else {
//                        SLLNode<String> insert = new SLLNode<>(add);
//                        while (tmp.sibling != null) {
//                            if (add.compareTo(tmp.sibling.element) < 0) {
//                                insert.sibling = tmp.sibling;
//                                tmp.sibling = insert;
//                                insert.parent = root;
//                                break;
//                            }
//                            tmp = tmp.sibling;
//                        }
//                        tmp.sibling = insert;
//                        insert.parent = root;
//                    }
//                }
//                case ("OPEN"): {
//                    SLLNode<String> open = root.firstChild;
//                    while (open != null) {
//                        if (open.element.compareTo(add) == 0) {
//                            root = open;
//                            break;
//                        }
//                        open = open.sibling;
//                    }
//                }
//                case ("PATH"): {
//                    SLLNode<String> tmp = root;
//                    StringBuilder output = new StringBuilder();
//                    while (tmp != tree.root) {
//                        output.insert(0, "\\");
//                        output.insert(0, tmp.element);
//                        tmp = tmp.parent;
//                    }
//                    output.insert(0, "\\");
//                    output.insert(0, tree.root.element);
//                    System.out.println(output.toString());
//                }
//                case ("BACK"): {
//                    root = root.parent;
//                }
//                case ("PRINT"): {
//                    tree.printTree();
//                }
//                case ("DELETE"): {
//                    root = tree.root;
//                    SLLNode<String> delete = root.firstChild;
//                    if (delete != null && delete.element.compareTo(add) == 0) {
//                        delete.parent.firstChild = delete.sibling;
//                    }
//                    if (delete != null) {
//                        while (delete.sibling != null && delete != null) {
//                            if (delete.sibling.element.compareTo(add) == 0) {
//                                delete.sibling = delete.sibling.sibling;
//                                break;
//                            }
//                            delete = delete.sibling;
//                        }
//                    }
//                }
//            }
//        }
//
//    }
//
//}
