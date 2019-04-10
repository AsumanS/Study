	
public class RemoveKFromList {
	
  static class ListNode {
   public ListNode(int x) {
    value = x;
  }
  int value;
  ListNode next;
}

public static ListNode removeKFromList(ListNode l, int k) {
    while(l!=null){
       if(l.value==k)
           l=l.next;
       else
           break;
   }
   if(l==null || l.next==null)
       return l;

   ListNode check = l;
   while(check.next!=null){
       if(check.next.value==k)
           check.next=check.next.next;
       else
           check=check.next;
   }
   return l;
}

public static void main(String[] args) {
	ListNode node = new ListNode(0);
	node.next = new ListNode(1);
	node.next.next=new ListNode(2);
	node.next.next.next = new ListNode(0);
	node.next.next.next.next = new ListNode(2);
	
	ListNode result = removeKFromList(node, 2);
	while(result!=null) {
		System.out.println(result.value);
		result=result.next;
	}
	
	
}
}
