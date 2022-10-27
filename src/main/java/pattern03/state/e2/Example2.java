package pattern03.state.e2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class WordInfo {
    public String word;
    public int count;

    public WordInfo(String word, int count) {
        this.word = word;
        this.count = count;
    }
}

class Word {
    StringBuilder sb = new StringBuilder();

    public void AddChar(char ch) {
        sb.append(ch);
    }

    public void Clear() {
        sb = new StringBuilder();
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}

class WordList {
    ArrayList<WordInfo> wordList = new ArrayList<WordInfo>();

    public void Add(String word) {
        for (WordInfo wordInfo : wordList)
            if (word.equals(wordInfo.word)) {
                wordInfo.count++;
                return;
            }
        wordList.add(new WordInfo(word, 1));
    }

    public Iterator<WordInfo> getIterator() {
        return wordList.iterator();
    }
}

abstract class WCState {
    WordCounter wc;

    WCState(WordCounter wc) {
        this.wc = wc;
    }

    abstract void Alphabet(char c);

    abstract void Space();

    abstract void Digit();

    abstract void Eof();
}

class StateSkipSpace extends WCState {
    StateSkipSpace(WordCounter wc) {
        super(wc);
    }

    @Override
    void Alphabet(char c) {
        wc.currentWord.AddChar(c);
        wc.SetState(wc.stMakeWord);
    }

    @Override
    void Space() {
    }

    @Override
    void Digit() {
        wc.SetState(wc.stSkipDigit);
    }

    @Override
    void Eof() {
        wc.SetState(wc.stEnd);
    }
}

class StateSkipDigit extends WCState {
    StateSkipDigit(WordCounter wc) {
        super(wc);
    }

    @Override
    void Alphabet(char c) {
    }

    @Override
    void Space() {
        wc.SetState(wc.stSkipSpace);
    }

    @Override
    void Digit() {
    }

    @Override
    void Eof() {
        wc.SetState(wc.stEnd);
    }
}

class StateMakeWord extends WCState {
    StateMakeWord(WordCounter wc) {
        super(wc);
    }

    @Override
    void Alphabet(char c) {
        wc.currentWord.AddChar(c);
    }

    @Override
    void Space() {
        wc.wordList.Add(wc.currentWord.toString());
        wc.currentWord.Clear();
        wc.SetState(wc.stSkipSpace);
    }

    @Override
    void Digit() {
        wc.currentWord.Clear();
        wc.SetState(wc.stSkipDigit);
    }

    @Override
    void Eof() {
        wc.wordList.Add(wc.currentWord.toString());
        wc.SetState(wc.stEnd);
    }
}

class StateEnd extends WCState {
    StateEnd(WordCounter wc) {
        super(wc);
    }

    @Override
    void Alphabet(char c) {
    }

    @Override
    void Space() {
    }

    @Override
    void Digit() {
    }

    @Override
    void Eof() {
    }
}

class WordCounter {
    WordList wordList = new WordList();
    Word currentWord = new Word();

    WCState state;
    StateSkipSpace stSkipSpace = new StateSkipSpace(this);
    StateSkipDigit stSkipDigit = new StateSkipDigit(this);
    StateMakeWord stMakeWord = new StateMakeWord(this);
    StateEnd stEnd = new StateEnd(this);

    WordCounter() {
        state = stSkipSpace;
    }

    void Alphabet(char c) {
        state.Alphabet(c);
    }

    void Space() {
        state.Space();
    }

    void Digit() {
        state.Digit();
    }

    void Eof() {
        state.Eof();
    }

    void SetState(WCState st) {
        state = st;
    }
}

/////

public class Example2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력문자열? ");
        String s = scanner.nextLine();

        WordCounter wc = new WordCounter();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c) || Character.isUpperCase(c))
                wc.Alphabet(c);
            else if (Character.isDigit(c))
                wc.Digit();
            else
                wc.Space();
        }
        wc.Eof();

        Iterator<WordInfo> it = wc.wordList.getIterator();
        while (it.hasNext()) {
            WordInfo w = it.next();
            System.out.printf("%4d %s\n", w.count, w.word);
        }
    }
}
