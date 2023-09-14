import java.util.*;
class Solution 
{
    public int snakesAndLadders(int[][] board) 
    {
        int rows = board.length, cols = board[0].length, target = rows * cols, r, c, p;
        boolean[] visited = new boolean[rows * cols + 1]; // cells on board start from 1
        // 1 인덱스에 맞게 1칸 추가
        // queue contains <priority, square> sorted ascending by priority
        // 이동수로 계산한 우선순위 순대로 오름차순 정렬
        // 이동수가 같은 칸들 중에서 보다 결승칸에 가까운 칸들부터 체크한다.
        // prio = #steps * 1000 + (500 - square);
        // 우선도 = #이동수 * 1000 + (500 - 현재 칸)
        // number of steps is critical and adds 1000; 500 is selected as it is higher than the max cell (20*20=400)
        // 
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]); // 우선도 기준 오름차순 정렬
        q.offer(new int[] {0, 1}); // 0 steps to position 1 // 1번 칸에서 이동수 0으로 시작
        visited[1] = true; // 1번칸 방문 체크

        while (!q.isEmpty()) // 다음 칸 남아있으면 방문
        {
            int[] step_pos = q.poll();
            int s = step_pos[0] / 1000 + 1; // s: 이동 횟수
            for (int i = 1; i <= 6; i++) // 주사위 이동
            {
                p = step_pos[1] + i; // 다음 칸
                if (visited[p]) continue; // 방문한 칸이면 스킵
                visited[p] = true; // 방문체크

                r = rows - (p - 1) / cols - 1; // 현재 칸의 행/열 위치 계산
                c = (p - 1) % cols;
                if ((rows - r - 1) % 2 == 1) // 홀수 행에서는 좌우반전
                    c = cols - c - 1; // change direction for odd lines
                int ladder = board[r][c]; // 현재 칸에 적힌 값(-1이면 빈칸, 나머지는 이동칸(뱀/사다리))
                
                if (ladder > 0 && ladder <= target) // 결승점이 아닌 뱀/사다리라면
                    p = ladder; // no update for steps. allow to come here again with a dice
                    // 이동수는 증가하지 않음. 다음에 주사위로 다시 방문 가능
                if (p == target) // 결승 도착
                    return s; // 이동수 리턴
                q.offer(new int[] {s * 1000 + 500 - p, p}); // 다음 칸 이동
            }
        }
        return -1;
    }
}