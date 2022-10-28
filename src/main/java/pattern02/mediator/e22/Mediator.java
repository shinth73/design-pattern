package pattern02.mediator.e22;


// 의존성 역전 원칙에 따라 하위 레벨이 Mediator Concrete class를 직접 참조 하지 않도록 수정하자
// 모든 코드중복을 제거하는 방향으로 진행하면 자동적으롤 DIP 를 적용 가능 하다

public class Mediator implements IMediator{
    private ListBox listBox;
    private TextBox textBox;
    private Button button;

    public Mediator() {
        listBox = new ListBox(this);
        textBox = new TextBox(this);
        button = new Button(this);

        listBox.addItem("one");
        listBox.addItem("two");
        listBox.addItem("three");
    }

    public ListBox getListBox() {
        return listBox;
    }

    public TextBox getTextBox() {
        return textBox;
    }

    public Button getButton() {
        return button;
    }

    public void draw() {
        listBox.draw();
        textBox.draw();
        button.draw();
    }

    @Override
    public void childChanged(Object child) {
        if (child == listBox) {
            textBox.setText(listBox.selectedText());
            button.setEnabled(true);
        }
        else if (child == textBox) {
            int index = listBox.find(textBox.getText());
            if (index >= 0)
                listBox.selectItem(index);
            button.setEnabled(true);
        } else if (child == button) {
            String fileName = textBox.getText();
            System.out.println("File Open (" + fileName + ")");
            System.exit(0);
        }
    }
}