package pattern02.mediator.e5;

public class FileOpenDialog {
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

        listBox.addOnItemSelectListener((listBox, index) -> {
            textBox.setText(listBox.selectedText());
            button.setEnabled(true);
        });
        textBox.addOnTextChangedListener((textBox, text) -> {
            int index = listBox.find(textBox.getText());
            if (index >= 0)
                listBox.selectItem(index);
            button.setEnabled(true);
        });
        button.addOnClickListener((button) -> {
            String fileName = textBox.getText();
            System.out.println("File Open (" + fileName + ")");
            System.exit(0);
        });

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
}