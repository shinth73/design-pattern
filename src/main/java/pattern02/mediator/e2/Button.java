package pattern02.mediator.e2;

public class Button {
    private boolean enabled;
    private Mediator mediator;

    public Button(Mediator mediator) {
        this.mediator = mediator;
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
        if (enabled && mediator != null)
            mediator.childChanged(this);
    }
}