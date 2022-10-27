package pattern02.mediator.e1;

import java.util.Scanner;

public class Example1 {

    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            TextBox textBox = new TextBox();
            ListBox listBox = new ListBox();
            Button button = new Button();
            textBox.setListBox(listBox);
            textBox.setButton(button);
            listBox.setTextBox(textBox);
            listBox.setButton(button);
            button.setTextBox(textBox);

            listBox.addItem("one");
            listBox.addItem("two");
            listBox.addItem("three");
            for (;;) {
                System.out.print("\n\n\n");

                listBox.draw();
                textBox.draw();
                button.draw();

                System.out.print("ListBox 항목 선택 : s <번호>\n");
                System.out.print("TextBox 입력 : t <문자열>\n");
                System.out.print("Button 클릭  : b\n");
                System.out.print("? ");
                String s = scanner.nextLine();
                switch (s.charAt(0)) {
                case 's':
                    listBox.selectItem(Integer.parseInt(s.substring(2).trim()));
                    break;
                case 't':
                    textBox.setText(s.substring(2).trim());
                    break;
                case 'b':
                    button.onClick();
                    break;
                }
            }
        }
    }
}