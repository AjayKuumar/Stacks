public class MaximumRectangle {
    static int maximumArea(int[][] arr){
        int res = LargestRectangularArea.greaterArea(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j]==1){
                    arr[i][j]+=arr[i-1][j];
                }
            }
            res = Math.max(res,LargestRectangularArea.greaterArea(arr[i]));
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr ={{1,0,0,1,1},{0,0,0,1,1},{1,1,1,1,1},{0,1,1,1,1}};
        System.out.println(maximumArea(arr));
    }
}
