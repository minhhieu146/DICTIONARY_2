package ALL.Model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dictionary {
    List<Word> word_List;

    public Dictionary() {
        word_List = new ArrayList<Word>();
    }


    public void addNewWord(Word newWord) {
        word_List.add(newWord);
    }

    public void showAllWords(int c1, int c2, int c3) {
        String l1 = Integer.toString(c1);
        String l2 = Integer.toString(c2);
        String l3 = Integer.toString(c3);
        String outputFormat = "%-" + l1 + "s| %-" + l2 + "s| %-" + l3 + "s%n";
        System.out.printf(outputFormat, "No", "English", "Vietnamese");
        char[] lineBreak = new char[c1+c2+c3+5];
        Arrays.fill(lineBreak, '-');
        System.out.println(lineBreak);
        outputFormat = "%-" + l1 + "d| %-" + l2 + "s| %-" + l3 + "s%n";
        for (int i = 0; i < word_List.size(); i++) {
            System.out.printf(outputFormat, i + 1, word_List.get(i).getWord_target(), word_List.get(i).getWord_explain());
        }
    }

    public String dictionaryLookup(String findWord) {
        for(Word i : word_List) {
            if (i.getWord_target().equals(findWord) == true) {
                return i.getWord_explain();
            }
        }
         return "Khong co tu nay trong tu dien";
    }

    public void dictionarySearcher(String findWord) {
       String result ="";
        int j =0;
        for(Word i : word_List) {
            if(i.getWord_target().contains(findWord) == true) {
               result = i.getWord_target();
               System.out.println(result);
            }
        }
    }

    public void removeWord (String word) {
        int j =0, check =0;
        for(Word i : word_List) {
            if(i.getWord_target().equals(word) == true) {
                check =1;break;
            }
            else {
                j++;
            }
        }
        if(check == 1 ) {
            word_List.remove(j);
        } else System.out.println("Khong co tu day tron tu dien");
    }
/*
    public void editWord(String word1, String word2, String explain) {
        int j=0, check =0;
        for(Module.Word i : word_List) {
            if(i.getWord_target().equals(word1) == true) {
                Module.Word newWord = new Module.Word(word2, explain);

            } else {
                j++;
            }
        }
    }

 */

    public void ExportFile() {
        try {
            FileWriter fileOut = new FileWriter("E:\\algorithm\\BT_OOP\\src\\DictionaryOut.txt");
            for(Word i : word_List) {
                fileOut.write(i.getWord_target());
                fileOut.append(" ");
                fileOut.write(i.getWord_explain());
                fileOut.append("\n");
            }
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
