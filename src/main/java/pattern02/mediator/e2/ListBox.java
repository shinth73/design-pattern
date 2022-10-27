package pattern02.mediator.e2;

import java.util.ArrayList;

public class ListBox {
    private ArrayList<String> items;
    private int selectedItem;
    private Mediator mediator;

    public ListBox(Mediator m) {
        items = new ArrayList<String>();
        selectedItem = -1;
        mediator = m;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator m) {
        mediator = m;
    }

    public void addItem(String s) {
        items.add(s);
    }

    public void selectItem(int index) {
        if (selectedItem != index) {
            selectedItem = index;
            if (mediator != null)
                mediator.childChanged(this);
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