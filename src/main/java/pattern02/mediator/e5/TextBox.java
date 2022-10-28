package pattern02.mediator.e5;

import java.util.ArrayList;
import java.util.List;

public class TextBox {
    public interface OnTextChangeListener {
        void onTextChanged(TextBox textBox, String text);
    }

    private String text;
    private List<OnTextChangeListener> onTextChangedListeners = new ArrayList<>();

    public void addOnTextChangedListener(OnTextChangeListener listener) {
        onTextChangedListeners.add(listener);
    }

    public String getText() {
        return text;
    }

    public void setText(String s) {
        if (s.equals(text) == false) {
            text = s;
            for (OnTextChangeListener listener : onTextChangedListeners)
                listener.onTextChanged(this, text);
        }
    }

    public void draw() {
        System.out.print("---- TextBox\n");
        System.out.print(text);
        System.out.print("\n\n");
    }
}