import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ilość argumentów");
        String argNumber;
        argNumber=scanner.nextLine();
        int k = 0;
        List<Iris> irisList = new LinkedList<>();

        try{
            k=Integer.parseInt(argNumber);

        }catch(NumberFormatException e){
            System.out.println("Niepoprawna ilość argumentów");
        }

        System.out.println("Liczba agrumentów: " + k);
        scanner.close();

        try{
            String path = "C:\\Users\\Mikołaj\\Desktop\\K-Means s18840\\iris.data";
            Scanner scan = new Scanner(new File(path));
            String str;
            String[] strTab;
            double[] arg = new double[4];
            while (scan.hasNext()) {
                str = scan.nextLine();
                strTab = str.split(",");
                for (int i = 0; i < 4; i++) {
                    arg[i] = Double.parseDouble(strTab[i]);
                }
                irisList.add(new Iris(arg, strTab[4]));
            }
        }catch(IOException e){
            System.out.println("Problem z odczytem pliku");
        }
        scanner.close();

        KMeans kMeans = new KMeans();
        kMeans.kMeans(irisList,k);
    }
}
