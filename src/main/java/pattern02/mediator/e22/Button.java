package pattern02.mediator.e22;

public class Button extends Widget{
    private boolean enabled;

    public Button(IMediator mediator) {
        super(mediator);
    }

    public void setEnabled(boolean value) {
        enabled = value;
    }

    public boolean getEnabled() {
        return enabled;
    }

    @Override
    public void draw() {
        System.out.print("---- Button ");
        System.out.println(enabled ? "enabled" : "disabled");
        System.out.println();
    }

    public void onClick() {
        if (enabled )
            dataChanged();
    }
}