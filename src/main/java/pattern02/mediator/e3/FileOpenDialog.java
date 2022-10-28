package pattern02.mediator.e3;

public class FileOpenDialog implements Mediator {
    private ListBox listBox;
    private TextBox textBox;
    private Button button;

    public FileOpenDialog() {
        listBox = new ListBox();
        textBox = new TextBox();
        button = new Button();

        listBox.addItem("one");
        listBox.addItem("two");
        listBox.addItem("three");

        listBox.setMediator(this);
        textBox.setMediator(this);
        button.setMediator(this);
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

    @Override
    public void childChanged(Widget child) {
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