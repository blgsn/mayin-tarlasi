
import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mayın tarlası oyununa hoş geldiniz !");
        System.out.println("Bayrak dikmek isterseniz koordinattan sonra 'f' harfini giriniz");
        System.out.println("Tarlanın boyutunu en ve boy olarak giriniz. ");
        int x , y ;
        x = scanner.nextInt();
        y = scanner.nextInt();
        MineSweeper mineSweeper = new MineSweeper(x, y);
        //mineSweeper.printMineMap();
        mineSweeper.run();
        scanner.close();
    }
  
}