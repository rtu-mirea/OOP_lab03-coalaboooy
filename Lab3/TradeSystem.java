package Lab3;

import java.util.*;

public class TradeSystem {
    private static ArrayList<User> users = new ArrayList<User>();
    private static ArrayList<Request> requests = new ArrayList<Request>();
    private static ArrayList<Request> approvedRequests = new ArrayList<Request>();
    static User currentUser;

    static void addUser(String name, String login, String password) {
        users.add(new Client(name, login, password));
    }

    static void addRequest(Client requester, String product, int price, int count, int type) {
        requests.add(new Request(requester, product, price, count, type));
    }

    static User findUser(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login))
                return user;
        }
        return null;
    }

    public void processRequests () {
        //TODO: Описание в тетради матлога -> конец
    }

    public static void main(String[] args) {
        TradeSystem TS = new TradeSystem();
        InitialWindow app = new InitialWindow();
    }
}