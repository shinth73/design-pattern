package pattern02.mediator.e5;

import java.util.ArrayList;
import java.util.List;

public class ListBox {
    public interface OnItemSelectListener {
        void onItemSelected(ListBox listBox, int index);
    }

    private ArrayList<String> items;
    private int selectedItem;
    private List<OnItemSelectListener> onItemSelectListeners = new ArrayList<>();

    public void addOnItemSelectListener(OnItemSelectListener listener) {
        onItemSelectListeners.add(listener);
    }

    public ListBox() {
        items = new ArrayList<String>();
        selectedItem = -1;
    }

    public void addItem(String s) {
        items.add(s);
    }

    public void selectItem(int index) {
        if (selectedItem != index) {
            selectedItem = index;
            for (OnItemSelectListener listener : onItemSelectListeners)
                listener.onItemSelected(this, index);
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
            System.out.printf("%d: %s %s\n", i, items.get(i), (i == selectedItem) ? " SELECTED" : "");
        System.out.print('\n');
    }
}