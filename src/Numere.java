import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Numere {
    

    private Set<Double> numbers;

    public Numere() {
        numbers = new HashSet<>();
    }

    public void citireFisier(String numeFisier) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(numeFisier));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] numStrings = line.split("\\s+");
            for (String num : numStrings) {
                Double value = Double.parseDouble(num);
                if (!numbers.add(value)) {
                    System.out.println("Se repeta numarul:  " + value);
                }
            }
        }
        reader.close();
    }

    public Set<Double> getNumbers() {
        return numbers;
    }


    // public void scriereFisier() {
    //     try {
    //         BufferedWriter writer = new BufferedWriter(new FileWriter("intervale.dat"));
    //         writer.write("Writing to a file. \nagain");
    //         writer.close();
    //     }
    //     catch (IOException e){
    //         e.printStackTrace();
    //     }
    // }

    // public void citireFisier() {
    //     try {
    //         BufferedReader reader = new BufferedReader(new FileReader("intervale.dat"));
    //         String line;
    //         while ((line = reader.readLine()) != null) {
    //             System.out.print(line + "\n");
    //         }
    //         reader.close();
    //     }
    //     catch(IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    


}
