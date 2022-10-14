public class DeleteMidNodeSLL
{
    public ListNode deleteMiddle(ListNode head)
    {
        int count=0;
        ListNode cur;
        cur=head;
        if(head.next==null)
        {
            return null;
        }
        while(cur!=null)
        {
            count++;
            cur=cur.next;
        }

        int mid=(count)/2;
        ListNode prev=head;
        int c=1;
        ListNode p1=head;
        for(int i=0;i<mid-1;i++)
        {

            p1=p1.next;
        }
        p1.next=p1.next.next;

        return head;
    }


}
