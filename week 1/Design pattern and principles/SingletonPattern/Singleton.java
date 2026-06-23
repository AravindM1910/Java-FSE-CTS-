package module1.SingletonpatternExample;

class logger {
    private static logger instance;

    private logger() {
        System.out.println("Object for logger is created");
    }

    public static logger getInstance() {
        if (instance == null) {
            instance = new logger();
        }
        return instance;   // Corrected line
    }

    public void display() {
        System.out.println("hi from logger");
    }
}
public class Singleton {
    public static void main(String[] args) {
        logger s1 = logger.getInstance();
        logger s2 = logger.getInstance();
        s1.display();
        s2.display();
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);

        System.out.println("Object same: " + (s1 == s2));
    }
}