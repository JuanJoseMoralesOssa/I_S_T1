package tarea1;

import java.io.File;

public class Folder {
    private int totalWord;

    Folder(String path, String word) {
        this.totalWord = 0;
        File folder = new File(path);
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        try {
                            MyFile myFile = new MyFile(file);
                            setTotalWord(myFile.countWord(word));

                        } catch (Exception e) {
                            System.err.println(e);
                        }
                    }
                }
            }
        } else {
            System.err.println("No se encuentra la carpeta indicada.");
        }
    }

    public int getTotalWord() {
        return totalWord;
    }

    public void setTotalWord(int count) {
        this.totalWord += count;
    }

    public void showTotalCount() {
        if (getTotalWord() > 0) {
            System.out.println("Total: " + getTotalWord());
        }
    }

}
