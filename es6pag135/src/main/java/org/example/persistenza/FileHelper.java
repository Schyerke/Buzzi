package org.example.persistenza;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import org.example.model.Contatore;

import java.io.*;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum FileHelper {
    INSTANCE;
    //dataLettura, matricolaContatore, valoreLettura.
    private final String FILENAME = "area.csv";

    public void salvaContatore(Contatore contatore) {
        Instant date = Instant.now();
        File file = new File(FILENAME);
        try {
            FileWriter outputfile = new FileWriter(file);

            CSVWriter writer = new CSVWriter(outputfile);

            String[] header = { date.toString() ,
                    String.valueOf(contatore.getMatricola()),
                    String.valueOf(contatore.getValoreLettura())
            };
            writer.writeNext(header);

            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Contatore readContatoreByMatricola(int matricola) {
        Contatore contatore = null;
        try (CSVReader reader = new CSVReader(new FileReader("file.csv"))) {
            List<String[]> r = reader.readAll();
            contatore = (Contatore) r.stream()
                    .filter( s -> s[1].equals(String.valueOf(matricola)) )
                    .map( s -> new Contatore(Integer.parseInt(s[1]), Integer.parseInt(s[2])));
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return contatore;
    }


}
