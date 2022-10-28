package pattern02.mediator.e5;

import java.util.ArrayList;
import java.util.List;

public class Button {
    public interface OnClickListener {
        void onClick(Button button);
    }

    private boolean enabled;
    private List<OnClickListener> onClickListeners = new ArrayList<>();

    public void addOnClickListener(OnClickListener listener) {
        onClickListeners.add(listener);
    }

    public void setEnabled(boolean value) {
        enabled = value;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void draw() {
        System.out.print("---- Button ");
        System.out.println(enabled ? "enabled" : "disabled");
        System.out.println();
    }

    public void onClick() {
        for (OnClickListener listener : onClickListeners)
            listener.onClick(this);
    }
}