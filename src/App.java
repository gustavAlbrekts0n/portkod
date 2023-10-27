import java.util.*;

class KeyLogger {

    private String password;
    private Queue<Integer> keys;
    private Scanner input = new Scanner(System.in);

    public KeyLogger(String password) {
        this.password = password;
        keys = new ArrayDeque<Integer>(password.length());
    }

    public void run() {
        while (true) {
            addKey();
        }
    }

    private void addKey() {
        try {
            int key = Integer.parseInt(input.nextLine());
            if (keys.size() >= password.length()) {
                keys.poll();
            }
            keys.offer(key);
        } catch (NumberFormatException e) {}
        checkKeys();
    }

    private String keys() {
        String result = "";
        for (int key : keys) {
            result += String.valueOf(key);
        }
        return result;
    }

    private void checkKeys() {
        if (keys().equals(password)) {
            System.out.println("Öppet!");
        }
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        new App().run();
    }

    void run() {
        new KeyLogger("1234").run();
    }
}
