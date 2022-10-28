package pattern02.mediator.e22;

import java.util.ArrayList;

public class ListBox extends Widget{
    private ArrayList<String> items;
    private int selectedItem;

    public ListBox(IMediator mediator) {
        super(mediator);
        items = new ArrayList<String>();
        selectedItem = -1;
    }

    public void addItem(String s) {
        items.add(s);
    }

    public void selectItem(int index) {
        if (selectedItem != index) {
            selectedItem = index;
            dataChanged();
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

    @Override
    public void draw() {
        System.out.print("---- ListBox\n");
        for (int i = 0; i < items.size(); ++i)
            System.out.printf("   %d: %s %s\n", i, items.get(i), (i == selectedItem) ? " SELECTED" : "");
    }
}