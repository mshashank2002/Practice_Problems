/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


 
class Solution {
    public boolean isPalindrome(ListNode head) 
    {
        if(head==null || head.next==null)
        {
            return true;
        }
        ListNode mid=middle(head);
        ListNode last=reverse(mid);
        ListNode cur=head;
        while(last!=null && cur!=null)
        {
            if(last.val == cur.val)
            {
                cur=cur.next;
                last=last.next;
                
            }
            else
            {
                
                return false;
            }
            
        }
        return true;
 
    }
    static ListNode middle(ListNode head)
    {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        
       
        }
        return slow;
    }
    static ListNode reverse(ListNode head)
    {
       ListNode cur=head;
       ListNode prev=null;
       while(cur!=null)
       {
           ListNode temp=cur.next;
           cur.next=prev;
           prev=cur;
           cur=temp;
       }
        return prev;
    }
}


/*
Method used:
    Find the middle of the linked Lidt using fast and slow pointer method;
    Then reverse nodes of the linked list after the midle node
    travrse from the last and first to check if elements are equal or not 

 */