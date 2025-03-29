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

            System.out.println("Succes!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}