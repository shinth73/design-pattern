package pattern02.mediator.e4;

public class FileOpenDialog implements Observer {
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

        listBox.addObserver(this);
        textBox.addObserver(this);
        button.addObserver(this);
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
    public void update(Observable child) {
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
        }
    }
}