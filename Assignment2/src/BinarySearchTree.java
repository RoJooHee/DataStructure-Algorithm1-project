import java.util.Scanner;
// 이진트리의 노드를 설정
class Node<E extends Comparable<E>> {
	private E item;
	private Node<E> left, right;
	// 생성자
	public Node(E newItem, Node<E> l, Node<E> r) {
		item = newItem; left = l; right = r;}
	public E get() {return item;}
	public void set(E newItem) {item = newItem;}
	public Node<E> getLeft() {return left;}
	public Node<E> getRight() {return right;}
	public void setLeft(Node<E> l) {left = l;}
	public void setRight(Node<E> r) {right = r;}  }

// 이진트리 클래스
class BinaryTree<E extends Comparable<E>> {
	private Node<E> root;
	//	생성자
	public BinaryTree() {root = null;}
	public Node<E> getRoot() {return root;}
	
	// 중위순회
	public void InTrav() {InTrav(root);}
	public void InTrav(Node<E> r) {
		if (r == null) return;
		InTrav(r.getLeft());
		System.out.println(r.get());
		InTrav(r.getRight()); }
	
	// 삽입
	public void Insert(E newItem) {root = Insert(root, newItem);}
	public Node<E> Insert(Node<E> r, E newItem) {
		if (r == null)  { r = new Node<E>(newItem, null, null);
			return r; }
		if (newItem.compareTo(r.get()) < 0) r.setLeft(Insert(r.getLeft(), newItem));
		else r.setRight(Insert(r.getRight(), newItem));
		return r; }

	// 삭제연산
	public void Remove(E item) {root = Remove(root, item);}
	public Node<E> Remove(Node<E> r, E item) {
		if (r == null) return null; // item과 같은 것 찾지 못한 경우
		int t = item.compareTo(r.get()); // item과 노드를 비교해서 같으면 삭제 다르면 순회
		if (t == 0) {
			// case 0 : 자식이 하나도 없는 경우,
			if (r.getLeft() == null && r.getRight() == null) return null;
			// case 1 : 자식이 하나 있는 경우
			if (r.getLeft() == null) return r.getRight();
			if (r.getRight() == null) return r.getLeft();
			// case 2 : 자식이 두개인 경우
			Node<E> min = GetMin(r.getRight());
			min.setRight(RemoveMin(r.getRight()));
			return min; }
		if (t < 0) { //아이템<노드
			r.setLeft(Remove(r.getLeft(), item));
			; return r; }
		else { //아이템>노드
			r.setRight(Remove(r.getRight(), item));
			; return r; }
		}
		// 최솟값 삭제하기
		public void RemoveMin() {
			if (root == null) return; // 트리가 비어있는 경우 최솟값 없음 
			root = RemoveMin(root); }
		public Node<E> RemoveMin(Node<E> r) {
			if (r.getLeft() == null)  return r.getRight();
			r.setLeft(RemoveMin(r.getLeft()));
			return r; }
	
	// 찾기
	public E Find(E item) {return Find(root, item);}
	public E Find(Node<E> r, E item) {
		if (r == null) {return null;}  // 찾는 데이터가 없는 경우
		int t = item.compareTo(r.get());
		if (t == 0)  return r.get();
		if (t < 0)  return Find(r.getLeft(), item);
		return Find(r.getRight(), item); }
	// 최솟값 찾기
	public Node<E> GetMin() {
		if (root == null)  return null; // 트리가 비어있는 경우 최솟값 없음
		return GetMin(root); }
	public Node<E> GetMin(Node<E> r) {
		if (r.getLeft() == null)  return r;
		return GetMin(r.getLeft()); }
	
	//	트리에 있는 노드의 갯수
	public int Size() { return Size(root); }
	public int Size(Node<E> r) {
		if(r==null) return 0;
		return Size(r.getLeft())+Size(r.getRight())+1;
	}
	
	/*  item1보다 크거나 같고, item2보다 작거나 같은 항목을 순서대로 출력한다.
	public E Compare(E item1, E item2) { return Compare(root, item1, item2); }
	public Node<E> Compare(Node<E> r, E item1, E item2) {
		if (r == null) {return null;}  // 찾는 데이터가 없는 경우
		int t = item1.compareTo(r.get());
		if (t == 0)  (r.getRight());
		else if (t < 0)  return r.getLeft();
		else return r.getRight();}
		//트리에 있는 노드 중에서 item1보다 같거나 크교, item2보다 같거나 작도록.
		//비교하면서 for문?으로 해당범위만 출력되게??
		//중위순회??
	*/
	
	/* 중위순회하면서 찾기??
		public void Com(E item1, E item2) {Com(root, item1, item2);}
		public void Com(Node<E> r, E item1, E item2) {
			if (r == null) return;
			if (r.get().compareTo(item1)>=0) {
				InTrav(r.getLeft());
				System.out.println(r.get());
				InTrav(r.getRight()); }
	}
	*/
}

public class BinarySearchTree {
	public static void main(String[] args) throws Exception {
		BinaryTree<String> tree = new BinaryTree<String>();
		Scanner s=new Scanner(System.in);
		while (true) {
			System.out.print("Enter command : ");
			String cmd = s.next();
			if (cmd.equals("q")) break;
			
			if (cmd.equals("i")) {
				System.out.print("넣을 항목 입력 : ");
				String x = s.next();
				tree.Insert(x); }
			
			else if (cmd.equals("d")) {
				System.out.print("삭제할 항목 입력 : ");
				String x = s.next();
				tree.Remove(x);}
			
			else if (cmd.equals("f")) {
				System.out.print("찾을 항목 입력 : ");
				String x = s.next();
				String res = tree.Find(x);
				if (res != null) System.out.println("true");
				else System.out.println("false"); }
			
			else if (cmd.equals("s")) { //입력 s a b : a 보다 크거나 같고, b 보다 작거나 같은 항목을 순서대로 출력한다.
				String a= s.next();
				String b= s.next();
				/*for(int i=0; i<tree.Size(); i++) {
					tree.Com(a, b);
						} */
				}
			tree.InTrav();
		}
	}
}