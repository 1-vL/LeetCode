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
    public ListNode sortList(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode next = head;
        if (head==null || head.next == null) { return head; }
        while (next != null) {
            list.add(next);            
            next = next.next;
        }
        
        ListNode[] result = new ListNode[list.size()];
        for (int i=0;i<list.size();i++) {
           result[i] = list.get(i);
        }
        sort(result, 0, result.length-1);
        for (int i=0;i<result.length-1;i++) {
           result[i].next = result[i+1];
        }
        result[result.length-1].next=null;
        return result[0];
    }

    public void sort(ListNode[] array, int start, int end) {
        if (start < end) {
            int half = (end+start)/2;
            
            sort(array,start,half);
            sort(array,half+1,end);
            merge(array,start,half,end);
        }
    }

    public void merge(ListNode[] array, int start, int half, int end) {
        int i = start, j = half+1, k = start;
        ListNode[] tmp = new ListNode[array.length];
        while(i<=half && j<=end) {
            if(array[i].val <= array[j].val) {
                tmp[k++] = array[i++];
            }
            else tmp[k++] = array[j++];
        }
        while(i<=half) tmp[k++] = array[i++];
        while(j<=end) tmp[k++] = array[j++];
        for(int a = start; a<=end; a++) array[a] = tmp[a];
    }
}