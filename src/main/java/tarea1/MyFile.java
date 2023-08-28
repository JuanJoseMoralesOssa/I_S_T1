package tarea1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyFile {
    private File file;

    MyFile(File file) throws Exception {
        if (isValidFile(file)) {
            this.file = file;
        } else {
            throw new Exception("No se encontraron archivos de texto en la carpeta.");
        }
    }

    public File getFile() {
        return file;
    }

    public boolean isValidFile(File file) {
        if (file.getName().endsWith(".txt") || file.getName().endsWith(".xml")
                || file.getName().endsWith(".json") || file.getName().endsWith(".csv")){
            return true;
        }
        return false;
    }

    public int countWord(String word) {
        int count = 0;
        Scanner reader;
		try {
			reader = new Scanner(getFile());

            while (reader.hasNext()) {
                String line = reader.next();
                if (checkLine(line, word)) {
                    count++;
                }
            }

            System.out.println(getFile().getName() + " " + count + " veces");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return count;
    }

    public boolean checkLine(String line, String word) {
        line = line.toLowerCase();
        word = word.toLowerCase();
        if (line.contains(word) &&
        (line.length() == word.length() || checkFirstLast(line, word)) ){
            return true;
        }
        return false;
    }

    public boolean checkFirstLast(String line, String word) {
        String[] arr = { "(", ",", ".", ")", ";", "\"", "¿", "?", "!", "¡"};

        for (String charArr : arr) {
            if ( (line.startsWith(charArr) || line.endsWith(charArr)) &&
            (line.length() != word.length()) ) {
                return true;
            }
        }
        return false;
    }

}
