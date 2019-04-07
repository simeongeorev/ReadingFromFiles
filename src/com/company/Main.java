package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter a phrase.");
        String enterAWord = s.nextLine();
        lookingForAWord(enterAWord);
    }

    public static void lookingForAWord(String searchedWord){
        String fileString = "";
        File file = new File("48320-0.txt");

        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) { // catching the error if the file isn't found
            e.printStackTrace();
        }

        fileString = sc.nextLine();
        while (sc.hasNextLine()) {
            fileString = fileString + "\n" + sc.nextLine(); // reading and converting the file to a string
        }
        int counter=0;
        ArrayList<Integer> theList = new ArrayList<>(); // containing the positions of the found word/phrase
        for(int i=0; i<fileString.length()-searchedWord.length(); i++){ // cycling through the string file
            if(fileString.substring(i,i+searchedWord.length()).equalsIgnoreCase(searchedWord)){
                counter++;
                theList.add(i); // adding the position of the word
            }
        }
        for(int j = 0; j<theList.size(); j++){
            System.out.println("The word is in position " + theList.get(j));
        }
        System.out.println(counter);

    }
}
