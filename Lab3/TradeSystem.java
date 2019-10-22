package Lab3;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class TradeSystem {
    private Scanner in = new Scanner(System.in);
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<Request> requests = new ArrayList<Request>();

    public void addUser () {
        this.users.add(new Client(in.nextLine(), in.nextLine(), in.nextLine()));
    }

    public User findUser (String login) {
        for (User user : users) {
            if (user.getLogin().equals(login))
                return user;
        }
        return null; //TODO: ПРИ ВЫЗОВЕ ПРОВЕРЯТЬ НА NULL
    }

    public void processRequests () {
        //TODO: Сделать расчет заявок и отправку рез-тов клиентам
    }

    public static class InitialWindow extends JFrame {

        InitialWindow() {
            setTitle("Система"); //TODO: Поменять

            setSize(new Dimension(600, 480));
            Dimension sSize = Toolkit.getDefaultToolkit ().getScreenSize (), fSize = getSize ();
            if (fSize.height > sSize.height) {fSize.height = sSize.height;}
            if (fSize.width  > sSize.width)  {fSize.width = sSize.width;}
            setLocation ((sSize.width - fSize.width)/2, (sSize.height - fSize.height)/2);

            try {
                UIManager.setLookAndFeel(UIManager.getLookAndFeel());
            } catch (UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }

            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        InitialWindow IW = new InitialWindow();
    }
}
