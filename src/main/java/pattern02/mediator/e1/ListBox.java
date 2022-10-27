package pattern02.mediator.e1;

import java.util.ArrayList;

public class ListBox {
    private ArrayList<String> items;
    private TextBox textBox;
    private Button button;
    private int selectedItem;

    public ListBox() {
        items = new ArrayList<String>();
        selectedItem = -1;
    }

    public void setTextBox(TextBox textBox) {
        this.textBox = textBox;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public void addItem(String s) {
        items.add(s);
    }

    public void selectItem(int index) {
        if (selectedItem != index) {
            selectedItem = index;
            if (textBox != null)
                textBox.setText(items.get(selectedItem));
            if (button != null)
                button.setEnabled(true);
        }
    }

    public String selectedText() {
        return items.get(selectedItem);
    }

    public int find(String s) {
        for (int i = 0; i < items.size(); ++i)
            if (s.equals(items.get(i)))
                return i;
        return -1;
    }

    public void draw() {
        System.out.print("---- ListBox\n");
        for (int i = 0; i < items.size(); ++i)
            System.out.printf("   %d: %s %s\n", i, items.get(i), (i == selectedItem) ? " SELECTED" : "");
    }
}