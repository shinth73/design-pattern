package pattern02.mediator.e3;

public class Widget {
    private Mediator mediator;

    public Widget() {
        mediator = null;
    }

    public void setMediator(Mediator m) {
        mediator = m;
    }

    public void widgetChanged() {
        if (mediator != null)
            mediator.childChanged(this);
    }
}