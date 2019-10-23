package Lab3;

import java.util.*;

public class TradeSystem {
    private Scanner in = new Scanner(System.in);
    private static ArrayList<User> users = new ArrayList<User>();
    private ArrayList<Request> requests = new ArrayList<Request>();
    public static User currentUser;

    private void addUser() {
        users.add(new Client(in.nextLine(), in.nextLine(), in.nextLine()));
    }

    static User findUser(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login))
                return user;
        }
        return null;
    }

    public void processRequests () {
        //TODO: Сделать расчет заявок и отправку рез-тов клиентам
    }

    public static void main(String[] args) {
        TradeSystem TS = new TradeSystem();
        TS.addUser(); //TODO: Убрать это
        InitialWindow app = new InitialWindow();
    }
}
