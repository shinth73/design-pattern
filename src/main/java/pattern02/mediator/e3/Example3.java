package pattern02.mediator.e3;

import java.util.Scanner;

public class Example3 {

    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            FileOpenDialog dialog = new FileOpenDialog();
            for (;;) {
                System.out.print("\n\n\n");

                dialog.draw();

                System.out.print("ListBox 항목 선택 : s <번호>\n");
                System.out.print("TextBox 입력 : t <문자열>\n");
                System.out.print("Button 클릭  : b\n");

                System.out.print("? ");
                String s = scanner.nextLine();
                switch (s.charAt(0)) {
                case 's':
                    int index = Integer.parseInt(s.substring(2).trim());
                    dialog.getListBox().selectItem(index);
                    break;
                case 't':
                    dialog.getTextBox().setText(s.substring(2).trim());
                    break;
                case 'b':
                    dialog.getButton().onClick();
                    break;
                }
            }
        }
    }
}