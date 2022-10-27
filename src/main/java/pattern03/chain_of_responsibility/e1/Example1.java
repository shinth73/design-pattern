package pattern03.chain_of_responsibility.e1;

import java.util.Scanner;

enum Request {
    CLOSE, COPY, CUT, EXIT, DELETE, LOAD_RESOURCE, OPEN_FILE, PASTE, SAVE_FILE, TILE_VERTICALLY, TILE_HORIZONTALLY,
    UNDO, ZOOM
}

interface RequestHandler {
    void handleRequest(Request req);
}

class Application implements RequestHandler {
    @Override
    public void handleRequest(Request req) {
        switch (req) {
        case EXIT:
            System.out.printf("Application - Exit\n");
            break;
        case LOAD_RESOURCE:
            System.out.printf("Application - LoadResource\n");
            break;
        default:
            System.out.printf("Application - Unknown Request\n");
            break;
        }
    }
}

class MainWindow implements RequestHandler {
    Application app;

    public MainWindow(Application a) {
        app = a;
    }

    @Override
    public void handleRequest(Request req) {
        switch (req) {
        case OPEN_FILE:
            System.out.printf("MainWindow - Open File\n");
            break;
        case TILE_VERTICALLY:
            System.out.printf("MainWindow - Tile Vertically\n");
            break;
        case TILE_HORIZONTALLY:
            System.out.printf("MainWindow - Tile Horizontally\n");
            break;
        default:
            app.handleRequest(req);
            break;
        }
    }
}

class Window implements RequestHandler {
    MainWindow mainWnd;

    public Window(MainWindow m) {
        mainWnd = m;
    }

    @Override
    public void handleRequest(Request req) {
        switch (req) {
        case CLOSE:
            System.out.printf("Window - Close\n");
            break;
        default:
            mainWnd.handleRequest(req);
            break;
        }
    }
}

class Document implements RequestHandler {
    Window win;

    public Document(Window w) {
        win = w;
    }

    @Override
    public void handleRequest(Request req) {
        switch (req) {
        case SAVE_FILE:
            System.out.printf("Document1 - Save File\n");
            break;
        case UNDO:
            System.out.printf("Document1 - Undo\n");
            break;
        default:
            win.handleRequest(req);
            break;
        }
    }
}

class View implements RequestHandler {
    Document doc;
    Window win;
    static View topView;

    public View(Document d) {
        doc = d;
    }

    public void activate() {
        topView = this;
    }

    public static View getTopView() {
        return topView;
    }

    @Override
    public void handleRequest(Request req) {
        switch (req) {
        case ZOOM:
            System.out.printf("View - Zoom\n");
            break;
        default:
            doc.handleRequest(req);
            break;
        }
    }
}

class View1 extends View {
    public View1(Document d) {
        super(d);
    }

    @Override
    public void handleRequest(Request req) {
        switch (req) {
        case COPY:
            System.out.printf("View1 - Copy\n");
            break;
        case CUT:
            System.out.printf("View1 - Cut\n");
            break;
        case PASTE:
            System.out.printf("View1 - Paste\n");
            break;
        case DELETE:
            System.out.printf("View1 - Delete\n");
            break;
        default:
            super.handleRequest(req);
            break;
        }
    }
}

class View2 extends View {
    public View2(Document d) {
        super(d);
    }

    @Override
    public void handleRequest(Request req) {
        switch (req) {
        case COPY:
            System.out.printf("View2 - Copy\n");
            break;
        case CUT:
            System.out.printf("View2 - Cut\n");
            break;
        case PASTE:
            System.out.printf("View2 - Paste\n");
            break;
        case DELETE:
            System.out.printf("View2 - Delete\n");
            break;
        default:
            super.handleRequest(req);
            break;
        }
    }
}

public class Example1 {
    static View view1, view2;

    public static void createApplication() {
        Application app = new Application();
        MainWindow mainWin = new MainWindow(app);
        Window win = new Window(mainWin);
        Document doc = new Document(win);
        view1 = new View1(doc);
        view2 = new View2(doc);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            createApplication();
            Request[] requests = Request.values();
            while (true) {
                for (int i = 0; i < requests.length; ++i)
                    System.out.printf("%d) %s\n", i, requests[i]);
                System.out.printf("Choice? ");
                int index = Integer.parseInt(scanner.next());

                if (index % 2 == 1)
                    view1.activate();
                else
                    view2.activate();

                System.out.println();
                View.getTopView().handleRequest(requests[index]);
                System.out.println();

                if (requests[index] == Request.EXIT)
                    break;
            }
        }
    }
}

