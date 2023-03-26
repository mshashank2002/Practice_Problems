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
    public ListNode sortList(ListNode head)
    {
        if(head==null||head.next==null)
        {
            return head;
            
        }
        ListNode mid=middle(head);
        ListNode left=head;
        ListNode right=mid.next;
        mid.next=null;
        
        left=sortList(left);
        right=sortList(right);
        ListNode res=merge(left,right);
        return res;
   }
   
 public   ListNode middle(ListNode head)
   {
       ListNode fast=head;
       ListNode slow=head;
       while(fast.next!=null&&fast.next.next!=null)
       {
           fast=fast.next.next;
           slow=slow.next;
       }
       return slow;
   }
     public ListNode merge(ListNode left,ListNode right)
     {
         if(left==null)
         {
             return right;
         }
         if(right==null)
         {
             return left;
         }
         
         ListNode ans=new ListNode(-1);
         ListNode temp=ans;
         while(left!=null && right!=null)
         {
             if(left.val<right.val)
             {
                 temp.next=left;
                 temp=left;
                 left=left.next;
             }
             else
             {
                 temp.next=right;
                 temp=right;
                 right=right.next;
             }
         }
         
         while(left!=null)
         {
             temp.next=left;
                 temp=left;
                 left=left.next;
         }
         
         while(right!=null)
         {
              temp.next=right;
                 temp=right;
                 right=right.next;
         }
         
         return ans.next;
         }
    }
