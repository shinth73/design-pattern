package pattern02.mediator.e22;

public class TextBox extends Widget {
    private String text;

    public TextBox(IMediator mediator) {
        super(mediator);
    }


    public String getText() {
        return text;
    }

    public void setText(String s) {
        if (s.equals(text) == false) {
            text = s;
            dataChanged();
        }
    }

    @Override
    public void draw() {
        System.out.println("---- TextBox " + text);
    }
}