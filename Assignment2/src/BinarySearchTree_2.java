<<<<<<< HEAD
import java.util.Scanner;

// ����Ʈ���� ��带 ����
class Node<E extends Comparable<E>> {
   private E item;
   private Node<E> left, right;
   // ������
   public Node(E newItem, Node<E> l, Node<E> r) {
      item = newItem; left = l; right = r;}
   public E get() {return item;}
   public void set(E newItem) {item = newItem;}
   public Node<E> getLeft() {return left;}
   public Node<E> getRight() {return right;}
   public void setLeft(Node<E> l) {left = l;}
   public void setRight(Node<E> r) {right = r;}  }

// ����Ʈ�� Ŭ����
class BinaryTree<E extends Comparable<E>> {
   private Node<E> root;
   //   ������
   public BinaryTree() {root = null;}
   public Node<E> getRoot() {return root;}
   
   // ������ȸ
   public void InTrav() {InTrav(root);}
   public void InTrav(Node<E> r) {
      if (r == null) return;
      InTrav(r.getLeft());
      System.out.println(r.get());
      InTrav(r.getRight()); }   
   
   // ����
   public void Insert(E newItem) {root = Insert(root, newItem);}
   public Node<E> Insert(Node<E> r, E newItem) {
      if (r == null)  { r = new Node<E>(newItem, null, null);
         return r; }
      if (newItem.compareTo(r.get()) < 0) r.setLeft(Insert(r.getLeft(), newItem));
      else r.setRight(Insert(r.getRight(), newItem));
      return r; }

   // ��������
   public void Remove(E item) {root = Remove(root, item);}
   public Node<E> Remove(Node<E> r, E item) {
      if (r == null) return null; // item�� ���� �� ã�� ���� ���
      int t = item.compareTo(r.get()); // item�� ��带 ���ؼ� ������ ���� �ٸ��� ��ȸ
      if (t == 0) {
         // case 0 : �ڽ��� �ϳ��� ���� ���,
         if (r.getLeft() == null && r.getRight() == null) return null;
         // case 1 : �ڽ��� �ϳ� �ִ� ���
         if (r.getLeft() == null) return r.getRight();
         if (r.getRight() == null) return r.getLeft();
         // case 2 : �ڽ��� �ΰ��� ���
         Node<E> min = GetMin(r.getRight());
         min.setRight(RemoveMin(r.getRight()));
         return min; }
      if (t < 0) { //������<���
         r.setLeft(Remove(r.getLeft(), item));
         ; return r; }
      else { //������>���
         r.setRight(Remove(r.getRight(), item));
         ; return r; }
      }
      // �ּڰ� �����ϱ�
      public void RemoveMin() {
         if (root == null) return; // Ʈ���� ����ִ� ��� �ּڰ� ���� 
         root = RemoveMin(root); }
      public Node<E> RemoveMin(Node<E> r) {
         if (r.getLeft() == null)  return r.getRight();
         r.setLeft(RemoveMin(r.getLeft()));
         return r; }
   
   // ã��
   public E Find(E item) {return Find(root, item);}
   public E Find(Node<E> r, E item) {
      if (r == null) {return null;}  // ã�� �����Ͱ� ���� ���
      int t = item.compareTo(r.get());
      if (t == 0)  return r.get();
      if (t < 0)  return Find(r.getLeft(), item);
      return Find(r.getRight(), item); }
   // �ּڰ� ã��
   public Node<E> GetMin() {
      if (root == null)  return null; // Ʈ���� ����ִ� ��� �ּڰ� ����
      return GetMin(root); }
   public Node<E> GetMin(Node<E> r) {
      if (r.getLeft() == null)  return r;
      return GetMin(r.getLeft()); }
   
   //   Ʈ���� �ִ� ����� ����
   public int Size() { return Size(root); }
   public int Size(Node<E> r) {
      if(r==null) return 0;
      return Size(r.getLeft())+Size(r.getRight())+1;
   }
   
   public void InTrav1(E item1, E item2) {InTrav1(root, item1, item2);}
   public void InTrav1(Node<E> r, E item1, E item2) {
      if (r == null) return;
      InTrav1(r.getLeft(), item1, item2);
      int v1 = item1.compareTo(r.get()); 
      int v2 = item2.compareTo(r.get());
      if (v1 <= 0 && v2 >= 0)
         System.out.println(r.get());
      InTrav1(r.getRight(), item1, item2);
      }
}

public class BinarySearchTree_2 {
   public static void main(String[] args) throws Exception {
      BinaryTree<String> tree = new BinaryTree<String>();
      Scanner s=new Scanner(System.in);
      while (true) {
         System.out.print("��� �� : ");
         String cmd = s.next();

         if (cmd.equals("q")) break; //���α׷� ����
         
         if (cmd.equals("i")) { //Ʈ���� �߰�
            String x = s.next();
            tree.Insert(x); }
         
         else if (cmd.equals("d")) { //�׸� �����ϴ� ��� Ʈ������ ����
            String x = s.next();
            tree.Remove(x);}
         
         else if (cmd.equals("f")) { //�ִ��� �˻��ϰ� ������ true, ������ false
            String x = s.next();
            String res = tree.Find(x);
            if (res != null) System.out.println("true");
            else System.out.println("false");
            }
         
         else if (cmd.equals("s")) { //a<=�׸�<=b ������� ���
            String a=s.next();
            String b=s.next();
            tree.InTrav1(a, b);}
      }
   }
=======
import java.util.Scanner;

// ����Ʈ���� ��带 ����
class Node<E extends Comparable<E>> {
   private E item;
   private Node<E> left, right;
   // ������
   public Node(E newItem, Node<E> l, Node<E> r) {
      item = newItem; left = l; right = r;}
   public E get() {return item;}
   public void set(E newItem) {item = newItem;}
   public Node<E> getLeft() {return left;}
   public Node<E> getRight() {return right;}
   public void setLeft(Node<E> l) {left = l;}
   public void setRight(Node<E> r) {right = r;}  }

// ����Ʈ�� Ŭ����
class BinaryTree<E extends Comparable<E>> {
   private Node<E> root;
   //   ������
   public BinaryTree() {root = null;}
   public Node<E> getRoot() {return root;}
   
   // ������ȸ
   public void InTrav() {InTrav(root);}
   public void InTrav(Node<E> r) {
      if (r == null) return;
      InTrav(r.getLeft());
      System.out.println(r.get());
      InTrav(r.getRight()); }   
   
   // ����
   public void Insert(E newItem) {root = Insert(root, newItem);}
   public Node<E> Insert(Node<E> r, E newItem) {
      if (r == null)  { r = new Node<E>(newItem, null, null);
         return r; }
      if (newItem.compareTo(r.get()) < 0) r.setLeft(Insert(r.getLeft(), newItem));
      else r.setRight(Insert(r.getRight(), newItem));
      return r; }

   // ��������
   public void Remove(E item) {root = Remove(root, item);}
   public Node<E> Remove(Node<E> r, E item) {
      if (r == null) return null; // item�� ���� �� ã�� ���� ���
      int t = item.compareTo(r.get()); // item�� ��带 ���ؼ� ������ ���� �ٸ��� ��ȸ
      if (t == 0) {
         // case 0 : �ڽ��� �ϳ��� ���� ���,
         if (r.getLeft() == null && r.getRight() == null) return null;
         // case 1 : �ڽ��� �ϳ� �ִ� ���
         if (r.getLeft() == null) return r.getRight();
         if (r.getRight() == null) return r.getLeft();
         // case 2 : �ڽ��� �ΰ��� ���
         Node<E> min = GetMin(r.getRight());
         min.setRight(RemoveMin(r.getRight()));
         return min; }
      if (t < 0) { //������<���
         r.setLeft(Remove(r.getLeft(), item));
         ; return r; }
      else { //������>���
         r.setRight(Remove(r.getRight(), item));
         ; return r; }
      }
      // �ּڰ� �����ϱ�
      public void RemoveMin() {
         if (root == null) return; // Ʈ���� ����ִ� ��� �ּڰ� ���� 
         root = RemoveMin(root); }
      public Node<E> RemoveMin(Node<E> r) {
         if (r.getLeft() == null)  return r.getRight();
         r.setLeft(RemoveMin(r.getLeft()));
         return r; }
   
   // ã��
   public E Find(E item) {return Find(root, item);}
   public E Find(Node<E> r, E item) {
      if (r == null) {return null;}  // ã�� �����Ͱ� ���� ���
      int t = item.compareTo(r.get());
      if (t == 0)  return r.get();
      if (t < 0)  return Find(r.getLeft(), item);
      return Find(r.getRight(), item); }
   // �ּڰ� ã��
   public Node<E> GetMin() {
      if (root == null)  return null; // Ʈ���� ����ִ� ��� �ּڰ� ����
      return GetMin(root); }
   public Node<E> GetMin(Node<E> r) {
      if (r.getLeft() == null)  return r;
      return GetMin(r.getLeft()); }
   
   //   Ʈ���� �ִ� ����� ����
   public int Size() { return Size(root); }
   public int Size(Node<E> r) {
      if(r==null) return 0;
      return Size(r.getLeft())+Size(r.getRight())+1;
   }
   
   public void InTrav1(E item1, E item2) {InTrav1(root, item1, item2);}
   public void InTrav1(Node<E> r, E item1, E item2) {
      if (r == null) return;
      InTrav1(r.getLeft(), item1, item2);
      int v1 = item1.compareTo(r.get()); 
      int v2 = item2.compareTo(r.get());
      if (v1 <= 0 && v2 >= 0)
         System.out.println(r.get());
      InTrav1(r.getRight(), item1, item2);
      }
}

public class BinarySearchTree_2 {
   public static void main(String[] args) throws Exception {
      BinaryTree<String> tree = new BinaryTree<String>();
      Scanner s=new Scanner(System.in);
      while (true) {
         System.out.print("��� �� : ");
         String cmd = s.next();

         if (cmd.equals("q")) break; //���α׷� ����
         
         if (cmd.equals("i")) { //Ʈ���� �߰�
            String x = s.next();
            tree.Insert(x); }
         
         else if (cmd.equals("d")) { //�׸� �����ϴ� ��� Ʈ������ ����
            String x = s.next();
            tree.Remove(x);}
         
         else if (cmd.equals("f")) { //�ִ��� �˻��ϰ� ������ true, ������ false
            String x = s.next();
            String res = tree.Find(x);
            if (res != null) System.out.println("true");
            else System.out.println("false");
            }
         
         else if (cmd.equals("s")) { //a<=�׸�<=b ������� ���
            String a=s.next();
            String b=s.next();
            tree.InTrav1(a, b);}
      }
   }
>>>>>>> 768f6c28ffa311d15c0b9041d04c965883263bb3
}