package pattern03.state.e1;

import java.util.*;

enum State { SKIP_SPACE, SKIP_DIGIT, MAKE_WORD, END };

class WordInfo {
	public String word;
	public int count;
	public WordInfo(String word, int count) { this.word = word; this.count = count; }
}

class Word {
	StringBuilder sb = new StringBuilder();
	
	public void AddChar(char ch) { sb.append(ch); }
	public void Clear() { sb = new StringBuilder(); }
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

class WordCounter {
	WordList wordList = new WordList();
    Word currentWord = new Word();
    State state = State.SKIP_SPACE;
 
    public void Alphabet(char c) {
        switch (state) {
        case SKIP_SPACE:
        	currentWord.AddChar(Character.toLowerCase(c));
            state = State.MAKE_WORD;
            break;
        case SKIP_DIGIT:
            break;
        case MAKE_WORD:
        	currentWord.AddChar(Character.toLowerCase(c));
            break;
        case END:
        	break;
        }
    }

    public void Space() {
        switch (state) {
        case SKIP_SPACE:
            break;
        case SKIP_DIGIT:
            state = State.SKIP_SPACE;
            break;
        case MAKE_WORD:
        	wordList.Add(currentWord.toString());
        	currentWord.Clear();
            state = State.SKIP_SPACE;
            break;
        case END:
        	break;
        }
    }

    public void Digit() {
        switch (state) {
        case SKIP_SPACE:
            state = State.SKIP_DIGIT;
            break;
        case SKIP_DIGIT:
            break;
        case MAKE_WORD:
            currentWord.Clear();
            state = State.SKIP_DIGIT;
            break;
        case END:
        	break;
        }
    }
    public void Eof() {
        switch (state) {
        case SKIP_SPACE:
            state = State.END;
            break;
        case SKIP_DIGIT:
            state = State.END;
            break;
        case MAKE_WORD:
        	wordList.Add(currentWord.toString());
        	currentWord.Clear();
            state = State.END;
            break;
        case END:
        	break;
        }
    }
}

public class Example1 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력문자열? ");
        String s = scanner.nextLine();

        WordCounter wc = new WordCounter();
        for (int i=0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c) || Character.isUpperCase(c)) wc.Alphabet(c);
            else if (Character.isDigit(c)) wc.Digit();
            else wc.Space();
        }
        wc.Eof();
        
        Iterator<WordInfo> it = wc.wordList.getIterator();
        while (it.hasNext()) {
        	WordInfo w = it.next();
            System.out.printf("%4d %s\n", w.count, w.word);
        }
    }

}
