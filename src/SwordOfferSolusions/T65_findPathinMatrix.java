package SwordOfferSolusions;

public class T65_findPathinMatrix {
        public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
        {
            boolean [] flags = new boolean[matrix.length]; // gone position is true
            int position = 0;
            for(int i =0; i<rows; i++){
                for(int j =0; j < cols; j++){
                    if(findPath(matrix,rows,cols,i,j,position,str,flags))
                        return true;
                }
            }
            return false;
        }
        public boolean findPath(char[] matrix, int rows, int cols, int i, int j,int position,char[] str,boolean[] flags){
            int curIndex = i*cols+j;
            if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[i * cols + j] != str[position] || flags[i * cols + j])
                return false;
            if(position == str.length -1)
                return true;
            flags[curIndex] = true; // mark (i,j) as true
            if(findPath(matrix,rows,cols,i+1,j,position+1,str,flags)||
                    findPath(matrix,rows,cols,i-1,j,position+1,str,flags)||
                    findPath(matrix,rows,cols,i,j+1,position+1,str,flags)||
                    findPath(matrix,rows,cols,i,j-1,position+1,str,flags))
            return true;
            // no possibility to find path at current index, so mark flags[curIndex] = false
            flags[curIndex] = false;
            return false;
        }

    public static void main(String[] args) {
        char[] matrix = {'a','b','c','d'};
        int rows =2;
        int cols = 2;
        char[] str = {'a','b','e'};
        T65_findPathinMatrix t65 = new T65_findPathinMatrix();
        System.out.println(t65.hasPath(matrix,rows,cols,str));
    }

}