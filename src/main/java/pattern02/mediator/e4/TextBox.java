package pattern02.mediator.e4;

public class TextBox extends Observable {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String s) {
        if (s.equals(text) == false) {
            text = s;
            notifyObservers();
        }
    }

    public void draw() {
        System.out.print("---- TextBox\n");
        System.out.print(text);
        System.out.print("\n\n");
    }
}