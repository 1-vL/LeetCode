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
        // 전체 요소 저장용
        ArrayList<ListNode> list = new ArrayList<>();
        // 시작 노드
        ListNode next = head;
        // [] 빈 노드 받는 경우 예외처리
        if (head==null || head.next == null) { return head; }
        // Node 순회하며 list에 추가
        while (next != null) {
            list.add(next);            
            next = next.next;
        }

        // 정렬용 배열
        ListNode[] result = new ListNode[list.size()];
        // 배열로 값 복사
        for (int i=0;i<list.size();i++) {
           result[i] = list.get(i);
        }

        //정렬(재귀) 호출
        sort(result, 0, result.length-1);

        // 정렬 결과 Node에 반영
        for (int i=0;i<result.length-1;i++) {
           result[i].next = result[i+1];
        }
        result[result.length-1].next=null;

        return result[0];
    }

    public void sort(ListNode[] array, int start, int end) {
        // 정렬 범위
        if (start < end) {
            int half = (end+start)/2;
            
            sort(array,start,half); // 절반씩 정렬
            sort(array,half+1,end); // 머지 정렬
            merge(array,start,half,end); // 정렬된 배열 2개 병합
        }
    }

    public void merge(ListNode[] array, int start, int half, int end) {
        int i = start, j = half+1, k = start;
        ListNode[] tmp = new ListNode[array.length];

        while(i<=half && j<=end) { // 두 배열 모두 범위 체크
            // 좌측 배열 값이 더 작으면
            if(array[i].val <= array[j].val) {
                tmp[k++] = array[i++]; // 임시배열에 좌측 값 복사
            }
            else tmp[k++] = array[j++]; // 임시배열에 우측 값 복사
        }
        // 좌측 배열에 아직 복사할 값이 남은 경우 복사
        while(i<=half) tmp[k++] = array[i++];
        // 우측 배열에 아직 복사할 값이 남은 경우 복사
        while(j<=end) tmp[k++] = array[j++];
        // 임시 배열에 있던 값 가져오기
        for(int a = start; a<=end; a++) array[a] = tmp[a];
    }
}