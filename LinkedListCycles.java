//defination of linkedlist
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
 }
 
public class LinkedListCycle {
    public boolean hasCycle(ListNode head)
    {
        boolean answer=false;
        if(head == null || head.next == null)
        {
            return false;
        }
        
        ListNode cur=head.next.next;
        while(cur!=null && cur.next!=null)
        {
            if(cur==head)
            {
              answer=true;
              break;  
            }
            cur=cur.next.next;
            head=head.next;
        }
        
        return answer;
        
        
    }
}