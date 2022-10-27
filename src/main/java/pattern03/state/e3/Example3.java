package pattern03.state.e3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class WordInfo {
    public String word;
    public int count;
    public WordInfo(String word, int count) { this.word = word; this.count = count; }
}

class Word {
    StringBuilder sb = new StringBuilder();

    public void AddChar(char ch) { sb.append(ch); }
    public void Clear() { sb = new StringBuilder(); }
    @Override
    public String toString() { return sb.toString(); }
}

class WordList {
    ArrayList<WordInfo> wordList = new ArrayList<WordInfo>();

    public void Add(String word) {
        for (WordInfo wordInfo : wordList)
            if (word.equals(wordInfo.word)) {
                wordInfo.count++;
                return;
            }
        wordList.add( new WordInfo(word, 1) );
    }

    public Iterator<WordInfo> getIterator() { return wordList.iterator(); }
}

enum State { SKIP_SPACE, SKIP_DIGIT, MAKE_WORD, END };

class WordCounter {
    WordList wordList = new WordList();

    void run(String s) {
        Word currentWord = new Word();
        State state = State.SKIP_SPACE;
        int index = 0;
        char ch = 0;

        while (state != State.END){
            while (state == State.SKIP_SPACE) {
                if (index >= s.length()) { state = State.END; break; }
                ch = s.charAt(index++);
                if (Character.isAlphabetic(ch)) { state = State.MAKE_WORD; break; }
                else if (Character.isDigit(ch)) { state = State.SKIP_DIGIT; break; }
                else { state = State.SKIP_SPACE; break; }
            }
            while (state == State.SKIP_DIGIT) {
                if (index >= s.length()) { state = State.END; break; }
                ch = s.charAt(index++);
                if (Character.isAlphabetic(ch)) ;
                else if (Character.isDigit(ch)) ;
                else { state = State.SKIP_SPACE; break; }
            }
            while (state == State.MAKE_WORD) {
                currentWord.AddChar( Character.toLowerCase(ch) );
                if (index >= s.length()) {
                    wordList.Add(currentWord.toString());
                    state = State.END; break;
                }
                ch = s.charAt(index++);
                if (Character.isAlphabetic(ch)) ;
                else if (Character.isDigit(ch)) {
                    currentWord.Clear();
                    state = State.SKIP_DIGIT; break;
                }
                else {
                    wordList.Add(currentWord.toString());
                    currentWord.Clear();
                    state = State.SKIP_SPACE; break;
                }
            }
        }
    }
}

/////

public class Example3 {

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("입력문자열? ");
    String s = scanner.nextLine();

    WordCounter wc = new WordCounter();
    wc.run(s);

    Iterator<WordInfo> it = wc.wordList.getIterator();
    while (it.hasNext()) {
        WordInfo w = it.next();
        System.out.printf("%4d %s\n", w.count, w.word);
    }
}
}


