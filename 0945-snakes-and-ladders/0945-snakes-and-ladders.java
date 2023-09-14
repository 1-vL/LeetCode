class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] oneDimension = new int[n*n+1];
        boolean[] visited = new boolean[n*n+1];
        int cnt = 1;
        // 1차원 배열로 변환
        for (int i=n-1; i>=0; i--) {
            if ((n-i)%2==1) {
                // 홀수행(좌->우)
                for (int j=0;j<n;j++) {
                    oneDimension[cnt++] = board[i][j];
                }
            } else {     
                // 짝수행(우->좌)
                for (int j=n-1;j>=0;j--) {
                    oneDimension[cnt++] = board[i][j];
                }
            }
        }

        Queue<Integer[]> q = new ArrayDeque<Integer[]>();
        q.offer(new Integer[] {1,0});

        while (!q.isEmpty()) {
            Integer[] before = q.poll();
            int cur = before[0];
            int move_cnt = before[1];            
            if (visited[cur]) {
                continue;
            }

            int now = oneDimension[cur];
            visited[cur] = true;

            if (cur == oneDimension.length-1) {
                return move_cnt;
            }
            int dice_move = Math.min(oneDimension.length-1, cur+6);
            
            for (int i=cur+1; i<=dice_move; i++) {
                if (oneDimension[i] != -1) {                
                    // 뱀 또는 사다리
                    // System.out.println("워프: " + cur + " -> " + i + " -> " + oneDimension[i] + " 횟수 " + (move_cnt+1));
                    q.offer(new Integer[] {oneDimension[i], move_cnt+1});
                } else {
                    // System.out.println("일반이동: " + cur + " -> " + i + " 횟수 " + (move_cnt+1));
                    q.offer(new Integer[] {i, move_cnt+1});
                }
            }
        }

        return -1;
    }
}