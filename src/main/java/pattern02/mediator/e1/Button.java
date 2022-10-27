package pattern02.mediator.e1;

public class Button {
    private boolean enabled;
    private TextBox textBox;

    public void setTextBox(TextBox textBox) {
        this.textBox = textBox;
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
        if (enabled) {
            String fileName = textBox.getText();
            System.out.println("File Open (" + fileName + ")");
            System.exit(0);
        }
    }
}
