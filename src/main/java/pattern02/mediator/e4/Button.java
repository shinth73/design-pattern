package pattern02.mediator.e4;

public class Button extends Observable {
    private boolean enabled;

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
        notifyObservers();
    }
}