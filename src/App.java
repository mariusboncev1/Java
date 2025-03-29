import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {

        try {
            Numere numere = new Numere();
            numere.citireFisier("numere.dat");
            Set<Double> numbers = numere.getNumbers();

            List<Interval> intervale = new ArrayList<>();
            BufferedReader intervalReader = new BufferedReader(new FileReader("intervale.dat"));
            String line;
            while ((line = intervalReader.readLine()) != null) {
                line = line.replace("[", "").replace("]", "");
                String[] parts = line.split(",");
                double lower = Double.parseDouble(parts[0]);
                double upper = Double.parseDouble(parts[1]);
                intervale.add(new Interval(lower, upper));
            }
            intervalReader.close();

            for (Double number : numbers) {
                for (Interval interval : intervale) {
                    interval.testNumber(number);
                }
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter("statistica.dat"));
            for (Interval interval : intervale) {
                writer.write(interval.getResult());
                writer.newLine();
            }
            writer.close();

            System.out.println("Procesare finalizată. Rezultatele au fost salvate în statistica.dat.");
        } catch (IOException e) {
            e.printStackTrace();
        }



        // Numere pix = new Numere();
        // pix.citireFisier();

        // try {
        //     BufferedReader numereReader = new BufferedReader(new FileReader("numere.dat"));
        //     String linie;
        //     while((linie = numereReader.readLine()) != null) {
        //         String[] numere = linie.split("\s");

        //         for(String nr : numere) {
        //             double out = Double.parseDouble(nr);
        //             System.out.println(out);
        //         }

        //         numereReader.close();
        //     }
        // }
        // catch (IOException e){
        //     e.printStackTrace();
        //     System.out.println("Eroare numere");
        // }

        // // Citire Interval
        // try {
        //     BufferedReader intervalReader = new BufferedReader(new FileReader("intervale.dat"));
        //     String line;
        //     while ((line = intervalReader.readLine()) != null) {

        //         String[] valori = line.split("\s");

        //         for(String val : valori) {
        //             double numar = Double.parseDouble(val);
        //             System.out.println(numar);
        //         }
        //     }
        //     intervalReader.close();
        // }
        // catch(IOException e) {
        //     e.printStackTrace();
        //     System.out.println("Interval error");
        // }

    }
}