class l002{

    public static void printMazePath(int sourcex, int sourcey, int destinationx,int destinationy ,String ans){
        if(sourcex > destinationx ||  sourcey > destinationy ) {
            return;
        } 

        if(sourcex == destinationx && sourcey == destinationy){
            System.out.println(ans);
            return;
        }


        if(sourcey + 1 <= destinationy)
            printMazePath(sourcex, sourcey + 1, destinationx, destinationy, ans + "H");
        if(sourcex + 1 <= destinationx)
            printMazePath(sourcex + 1, sourcey, destinationx, destinationy, ans + "V");
        if(sourcex + 1 <= destinationx && sourcey + 1 <= destinationy)
            printMazePath(sourcex + 1, sourcey + 1, destinationx, destinationy, ans + "D");

    }

    public static void printMazePathMultiJumps(int sourcex, int sourcey, int destinationx,int destinationy ,String ans){

        if(sourcex == destinationx && sourcey == destinationy){
            System.out.println(ans);
            return;
        }


        for(int x = 1; sourcey + x <= destinationy; ++x)
            printMazePathMultiJumps(sourcex, sourcey + x, destinationx, destinationy, ans + "H" + x);
        for(int z =1; sourcex + z <= destinationx && sourcey + z <= destinationy;++z)
            printMazePathMultiJumps(sourcex + z, sourcey + z, destinationx, destinationy, ans + "D" + z);

        for(int y =1; sourcex + y <= destinationx;++y)
            printMazePathMultiJumps(sourcex + y, sourcey, destinationx, destinationy, ans + "V" + y);
       
    }

    // Direction array approach
    public static int floodFill(int sr, int sc, int dr, int dc,boolean [][] vis ,int[][] dir, String [] dirS, String ans){

        if(sr == dr && sc == dc){
            System.out.println(ans);
            return 1;
        }
        int n = vis.length; //Row length
        int m = vis[0].length;

        vis[sr][sc] = true; //mark
        
        int count = 0;
        for(int i = 0; i < dir.length; ++i) {
            int nr = sr + dir[i][0];
            int nc = sc + dir[i][1];

            if( nr >= 0 && nc >= 0 && nr < n && nc < m && !vis[nr][nc]){ // Coded considering 8 directions where -1 can be a possible value
                count += floodFill(nr, nc, dr, dc, vis, dir, dirS, ans + dirS[i]);
            }
        }
        vis[sr][sc] = false;
        return count;
    }

    public static void main(String [] args){
        // printMazePathMultiJumps(0, 0, 3,3 , "");
        int [][] dir = {{1,0},{-1,0},{-1,1},{-1,-1},{0,1},{0,-1},{-1,1},{1,-1}};
        boolean [] [] vis = new boolean[3][3];
        String [] dirS = {"D","U","S","N","R","L","E","W"};
        System.out.println(floodFill(0,0,2,2,vis, dir,dirS, ""));
    }
}