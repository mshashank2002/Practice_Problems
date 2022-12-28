class Solution {
    public void setZeroes(int[][] matrix) 
    {
        int rows=matrix.length;
        int col=matrix[0].length;
        int [] d1=new int[rows];
        int [] d2=new int[col];
        Arrays.fill(d1,-1);
        Arrays.fill(d2,-1);
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(matrix[i][j]==0)
                {
                    d1[i]=0;
                    d2[j]=0;
                }
            }
        }
        
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(d1[i]==0||d2[j]==0)
                {
                    matrix[i][j]=0;
                }
            }
        }
        
    }
}