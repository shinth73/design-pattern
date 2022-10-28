package pattern02.mediator.e3;

public class TextBox extends Widget {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String s) {
        if (s.equals(text) == false) {
            text = s;
            widgetChanged();
        }
    }

    public void draw() {
        System.out.print("---- TextBox\n");
        System.out.print(text);
        System.out.print("\n\n");
    }
}