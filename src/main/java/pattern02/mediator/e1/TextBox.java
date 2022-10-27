package pattern02.mediator.e1;

public class TextBox {
    private String text;
    private ListBox listBox;
    private Button button;

    public TextBox() {
        text = "";
    }

    public void setListBox(ListBox listBox) {
        this.listBox = listBox;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public String getText() {
        return text;
    }

    public void setText(String s) {
        if (s.equals(text) == false) {
            if (listBox != null) {
                text = s;
                int index = listBox.find(text);
                if (index >= 0)
                    listBox.selectItem(index);
            }
            if (button != null)
                button.setEnabled(true);
        }
    }

    public void draw() {
        System.out.println("---- TextBox " + text);
    }
}