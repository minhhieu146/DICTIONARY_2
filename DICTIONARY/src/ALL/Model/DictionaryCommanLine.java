package ALL.Model;

import java.io.IOException;

public class DictionaryCommanLine {

    public static Dictionary wordList = new Dictionary();
   // static List<Module.Word> wordlist;
    public static void showAllWords() {
        int listWidth = 5;
        int EngWidth = 20;
        int VieWidth = 25;
        wordList.showAllWords(listWidth, EngWidth, VieWidth);
    }


    public static void dictionaryBasis() {
        DictionaryManagement.insertFromCommandline(wordList);
        showAllWords();
    }

    public static void dictionaryAdvanced() throws IOException {
        DictionaryManagement.insertFromFile(wordList);
        showAllWords();
        //DictionaryManagement.dictionaryLookup(wordList);
        //DictionaryManagement.add(wordList);
        //showAllWords();
        DictionaryManagement.remove(wordList);
        showAllWords();
    }
    public static void dictionarySearch() {
        DictionaryManagement.dictionarySearch(wordList);
    }

    public static void main(String[] args) throws IOException {
      //  dictionaryAdvanced();
      //  DictionaryManagement.dictionaryExportFile(wordList);
       // dictionarySearch();
       // DictionaryManagement.insertFromFile(wordList);
    }

}
