package pattern02.mediator.e2;

public class TextBox {
    private String text;
    private Mediator mediator;

    public TextBox(Mediator m) {
        mediator = m;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator m) {
        mediator = m;
    }

    public String getText() {
        return text;
    }

    public void setText(String s) {
        if (s.equals(text) == false) {
            text = s;
            if (mediator != null)
                mediator.childChanged(this);
        }
    }

    public void draw() {
        System.out.println("---- TextBox " + text);
    }
}