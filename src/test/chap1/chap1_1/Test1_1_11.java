package test.chap1.chap1_1;

public class Test1_1_11 {
    public static void main(String[] args) {
        boolean[][] arr = new boolean[3][4];
        arr[0][0] = true;
        arr[2][2] = true;
        arr[1][3] = true;
        arr[2][1] = true;
        for(int i = 0; i < arr.length; i++){
            if ( i == 0){
                System.out.print(" ");
                for (int j = 0; j < arr[i].length; j++){
                    System.out.print(j);
                }
                System.out.println();
            }
            System.out.print(i);
            for (int j = 0; j < arr[i].length; j++){
                if (arr[i][j] == true){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
