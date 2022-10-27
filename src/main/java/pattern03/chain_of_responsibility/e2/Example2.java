package pattern03.chain_of_responsibility.e2;

abstract class Logger {

    public static final int DEBUG = 1;
    public static final int INFO = 2;
    public static final int ERROR = 3;

    protected int mask;
    protected Logger next;
    protected static Logger head;

    protected void setNext(Logger l) {
        next = l;
    }

    protected void handleMessage(String msg, int priority) {
        if (priority >= mask)
            logMessage(msg, priority);
        if (next != null)
            next.handleMessage(msg, priority);
    }

    protected abstract void logMessage(String msg, int priority);

    public Logger(int priority) {
        this.mask = priority;
    }

    public static void addLogger(Logger logger) {
        logger.setNext(head);
        head = logger;
    };

    public static void handle(String msg, int priority) {
        head.handleMessage(msg, priority);
    }
}

class ConsoleLogger extends Logger {
    public ConsoleLogger(int priority) {
        super(priority);
    }

    @Override
    public void logMessage(String msg, int priority) {
        System.out.printf("Writing to console: %d, %s\n", priority, msg);
    }
}

class EMailLogger extends Logger {
    public EMailLogger(int priority) {
        super(priority);
    }

    @Override
    public void logMessage(String msg, int priority) {
        System.out.printf("Sending via e-mail: %d, %s\n", priority, msg);
    }
}

class StderrLogger extends Logger {
    public StderrLogger(int priority) {
        super(priority);
    }

    @Override
    public void logMessage(String msg, int priority) {
        System.out.printf("Writing to stderr: %d, %s\n", priority, msg);
    }
}

//----

public class Example2 {

    static void createLogger() {
        // ERROR 등급 이상의 메시지를 이메일로 전송
        Logger.addLogger(new EMailLogger(Logger.ERROR));

        // INFO 등급 이상의 메시지를 stderr 스트림에 출력
        Logger.addLogger(new StderrLogger(Logger.INFO));

        // DEBUG 등급 이상의 메시지를 console에 출력
        Logger.addLogger(new ConsoleLogger(Logger.DEBUG));
    }

    public static void main(String[] args) {
        createLogger();

        // ERROR 등급의 메시지 출력
        Logger.handle("An error has occurred.", Logger.ERROR);

        // INFO 등급의 메시지 출력
        Logger.handle("Step1 completed.", Logger.INFO);

        // DEBUG 등급의 메시지 출력
        Logger.handle("Entering function y.", Logger.DEBUG);
    }

}