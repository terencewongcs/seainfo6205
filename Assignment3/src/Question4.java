public class Question4 {
    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int n,m;
    char[] w;
    int wordLength;

    public boolean exist(char[][] board, String word) {
        List<int[]> firstCharList = new ArrayList<>();
        char first = word.charAt(0);
        n = board.length;
        m = board[0].length;
        w = word.toCharArray();
        wordLength = word.length();

        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                if(board[i][j] == first)firstCharList.add(new int[]{i, j});

        for(int[] pos : firstCharList){
            boolean isPossible = bfs(board, pos[0], pos[1]);
            if(isPossible) return true;
        }

        return false;
    }

    private boolean bfs(char[][] a, int x, int y){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        vis[x][y] = true;
        q.add(new int[]{x, y, 0}); // x, y, wordlength till now

        while(!q.isEmpty()){
            int[] cur = q.poll();
            vis[cur[0]][cur[1]] = true;
            if(cur[2] == wordLength-1) return true;

            for(int[] d : dir){
                int nx = cur[0]+d[0], ny = cur[1]+d[1];

                if(nx>=0 && nx<n && ny>=0 && ny<m
                        && !vis[nx][ny] && a[nx][ny]==w[cur[2]+1]){
                    // vis[nx][ny] = true;
                    q.add(new int[]{nx, ny, cur[2]+1});
                }
            }
        }
        return false;
    }
}
