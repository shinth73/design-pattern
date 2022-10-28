package pattern02.mediator.e22;

abstract public class Widget {
    private IMediator mediator;

    public Widget(IMediator mediator) {
        this.mediator = mediator;
    }

    public IMediator getMediator() {
        return mediator;
    }

    public void setMediator(IMediator m) {
        mediator = m;
    }

    public void dataChanged(){
        if (mediator != null)
            mediator.childChanged(this);
    }

    abstract public void draw();
}
