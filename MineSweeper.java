
import java.util.Scanner;
public class MineSweeper {
    int row;
    int col;

    public MineSweeper(int rowNum, int colNum) {

        row = rowNum;
        col = colNum;
    }

    public void put(String [][][] _arr) {

        int mineCount = (int)(row * col / 4);
        while (mineCount > 0){
            int location = (int) (Math.random() * row * col);
            int x = location / col;
            int y = location % col;
            if (x < row && y < col){
                _arr[x][y][0] = "*";
                _arr[x][y][1] = "0";
                mineCount--;
            }
        }
    }

    public int control(int x, int y, String[][][] _arr) {

        int sum = 0;
        for(int i = - 1; i < 2; i++) {
            for(int j = - 1; j < 2; j++) {
                if (x + i < 0 || y +j < 0) continue;
                if (x + i >= row || y +j >= col) continue;
                if (i == 0 && j == 0) continue;
                if (_arr[x + i][y + j][0] == "*") sum++;
            }
        }
        return sum;
    }

    public void placeNumber(String[][][] _arr) {
        for(int i = 0; i < row; i++){
            for(int j = 0;j < col; j++){
                if( _arr[i][j][0] == null) {
                    _arr[i][j][0] = String.valueOf(control(i, j, _arr));
                    _arr[i][j][1] = "0";
                }
            }
        }
    }

    public void print(String[][][] _arr) {
        for(int i = 0;  i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (_arr[i][j][1] == "0") {
                    System.out.print("- ");
                } else {
                    System.out.print(_arr[i][j][0] + " ");
                }
            }
            System.out.print("\n");
        }
    }

    public void dataEntry(int x, int y , String[][][] _arr) {
        _arr[x][y][1]="1";
    }


    public void run() {

        String[][][] arr = new String[row][col][2];

        Scanner input = new Scanner(System.in);
        put(arr);
        placeNumber(arr);
        int entrance = 0;
        int rowNumber;
        int colNumber;
        while(row * col - entrance>(int)(col * row / 4)) {
            print(arr);
            System.out.print("Satir sayisini giriniz : ");
            rowNumber = input.nextInt();
            System.out.print("Sutun sayisini giriniz : ");
            colNumber = input.nextInt();
            if (arr[rowNumber][colNumber][0].equals("*")) {
                dataEntry(rowNumber,colNumber,arr);
                print(arr);
                System.out.println("...Game Over...");
                break;
            } else {
                dataEntry(rowNumber, colNumber, arr);
            }
            System.out.println("-----------------------------------------------------------");
        }
    }
}