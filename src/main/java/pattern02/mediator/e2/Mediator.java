package pattern02.mediator.e2;

public class Mediator {
    private ListBox listBox;
    private TextBox textBox;
    private Button button;

    public Mediator() {
        listBox = new ListBox(this);
        textBox = new TextBox(this);
        button = new Button(this);

        listBox.addItem("one");
        listBox.addItem("two");
        listBox.addItem("three");
    }

    public ListBox getListBox() {
        return listBox;
    }

    public TextBox getTextBox() {
        return textBox;
    }

    public Button getButton() {
        return button;
    }

    public void draw() {
        listBox.draw();
        textBox.draw();
        button.draw();
    }

    public void childChanged(Object child) {
        if (child == listBox) {
            textBox.setText(listBox.selectedText());
            button.setEnabled(true);
        }
        else if (child == textBox) {
            int index = listBox.find(textBox.getText());
            if (index >= 0)
                listBox.selectItem(index);
            button.setEnabled(true);
        } else if (child == button) {
            String fileName = textBox.getText();
            System.out.println("File Open (" + fileName + ")");
            System.exit(0);
        }
    }
}