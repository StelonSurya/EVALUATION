package zoho;

public class LinkedList {
   Node head =null;
   Node tail = null;
	class  Node {
		Node next ;
		Node prev ;
		int  val ;
		
		private Node(int data) {
			next=null;
			prev=null;
			val =data;
		}
	}
	
	LinkedList(int data){
		head = new Node(data);
		tail =head;
	}
	
	public void print(Node node) {
		while(node != null ) {
			System.out.print (node.val +" ");
			node = node.next;
		}
	}
	
	public void addLast(Node node ,int data) {
		Node temp = new Node (data);
		node.next=temp;
		temp.prev =node;
		tail=tail.next;
	}
	public void addFirst(int data) {
		Node temp = new Node (data);
		head.prev = temp;
		head = head.prev;
	}
	
	public int findLength(Node node) {
		int count = 0;
		while(node != null) {
			count++;
			node =node.next;
		}
		return count;
	}

	public int[] convert(Node head) {
		int length = findLength(head);
		int nums[] = new int [length];
		int index = 0;
		while(head != null) {
			nums[index++] = head.val;
			head=head.next;
		}
		return nums;
	}
	
}
