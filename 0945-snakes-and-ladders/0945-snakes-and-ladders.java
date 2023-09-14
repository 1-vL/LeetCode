class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int size=n*n;
        int[] oneDimension = new int[size+1];
        boolean[] visited = new boolean[size+1];
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

        Queue<int[]> q = new ArrayDeque<int[]>();
        q.offer(new int[] {1,0});

        while (!q.isEmpty()) {
            int[] before = q.poll();
            int cur = before[0];
            int move_cnt = before[1];            
            if (visited[cur]) {
                continue;
            }
            if (cur == size) {
                return move_cnt;
            }
            visited[cur] = true;

            int dice_move = Math.min(size, cur+6);
            
            for (int i=cur+1; i<=dice_move; i++) {
                if (oneDimension[i] != -1) {                
                    // 뱀 또는 사다리
                    q.offer(new int[] {oneDimension[i], move_cnt+1});
                } else {
                    q.offer(new int[] {i, move_cnt+1});
                }
            }
        }

        return -1;
    }
}