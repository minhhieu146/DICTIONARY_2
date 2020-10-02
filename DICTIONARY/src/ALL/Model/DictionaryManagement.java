package ALL.Model;

import java.io.*;

import java.util.Scanner;

public class DictionaryManagement {
    public static String file_url = "E:\\algorithm\\BT_OOP\\src\\Dictionary.txt";

    public static void insertFromCommandline(Dictionary dict) {
        System.out.print("Nhap so tu muon them: ");
        Scanner sc = new Scanner(System.in);
        int wordCount = sc.nextInt();
        sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for(int i=0; i< wordCount; i++) {
            System.out.println("STT: " + (i+1));
            System.out.print("Nhap tu tieng anh: ");
            String english = sc.nextLine();
            System.out.print("Nhap tu tieng viet: ");
            String vietnam = sc.nextLine();
            Word newWord = new Word(english, vietnam);
            dict.addNewWord(newWord);
        }
    }

    public static void insertFromFile(Dictionary dict) throws IOException {
        File file = new File(file_url);
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String line = "";
        while((line = reader.readLine()) != null) {
            int tab = line.indexOf(9);
            String word = line.substring(0, tab);
            String explain = line.substring(tab + 1);
            Word newWord = new Word(word, explain);
            dict.addNewWord(newWord);
        }
    }

    public static void dictionaryLookup(Dictionary dict) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap tu muon tim: ");
        String findWord = sc.nextLine();
        String result = dict.dictionaryLookup(findWord);
        if(result.equals("Khong co tu nay trong tu dien") == true) {
            System.out.println(result);
        } else {
            System.out.print("Nghia cua tu muon tim la: ");
            System.out.println(result);
        }
    }

    public static void add(Dictionary dict) {
        System.out.print("Tu ma ban muon them la: ");
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        System.out.print("Nghia cua tu ban vua them la: ");
        String explain = sc.nextLine();
        Word newWord = new Word(word, explain);
        dict.addNewWord(newWord);
    }

    public static void remove(Dictionary dict) {
        System.out.print("Tu ma ban muon bo la: ");
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        dict.removeWord(word);
    }

    public static void dictionarySearch(Dictionary dict) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap cac ki tu: ");
        String findChar = sc.nextLine();
        System.out.println("Cac tu lien quan la: ");
        dict.dictionarySearcher(findChar);
    }

    public static void dictionaryExportFile(Dictionary dict) {
        dict.ExportFile();
    }


}
