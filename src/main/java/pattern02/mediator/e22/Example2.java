package pattern02.mediator.e22;

import java.util.Scanner;

public class Example2 {

    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            Mediator mediator = new Mediator();
            for (;;) {
                System.out.print("\n\n\n");

                mediator.draw();
                System.out.print("ListBox 항목 선택 : s <번호>\n");
                System.out.print("TextBox 입력 : t <문자열>\n");
                System.out.print("Button 클릭  : b\n");

                System.out.print("? ");
                String s = scanner.nextLine();
                switch (s.charAt(0)) {
                case 's':
                    int index = Integer.parseInt(s.substring(2).trim());
                    mediator.getListBox().selectItem(index);
                    break;
                case 't':
                    mediator.getTextBox().setText(s.substring(2).trim());
                    break;
                case 'b':
                    mediator.getButton().onClick();
                    break;
                }
            }
        }
    }
}