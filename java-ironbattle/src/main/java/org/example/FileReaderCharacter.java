package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReaderCharacter {
    private String fileName;


    public FileReaderCharacter(String fileName) {
        setFileName(fileName);
    }

//    public List<Character> readCharacters() throws FileNotFoundException {
//        File file = new File(fileName);
//
//        Scanner scanner = new Scanner(file);
//
//        // columns:
//        // Character | Name | stamina/mana | strength/intelligence
//        // warrior:
//        // warrior, name, hp, stamina, strength
//        // ----------------------
//        // wizard:
//        // wizard, name, hp, mana, intelligence
//
//        List<Character> list = new ArrayList<>();
//
//        // Skip first line, columns
//        String data = scanner.nextLine();
//
//        while(scanner.hasNextLine()) {
//            data = scanner.nextLine();
//
//            String[] dataSplited = data.split(",");
//
//            if(dataSplited[0].equalsIgnoreCase("warrior")) {
////                list.add(new Warrior(dataSplited[1],Integer.parseInt(dataSplited[2])))
//            } else if (dataSplited[0].equalsIgnoreCase("wizard")) {
//
//            }
//        }
//    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
