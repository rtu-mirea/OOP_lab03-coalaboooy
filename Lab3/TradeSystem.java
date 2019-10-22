package Lab3;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TradeSystem {
    private Scanner in = new Scanner(System.in);
    private static ArrayList<User> users = new ArrayList<User>();
    private ArrayList<Request> requests = new ArrayList<Request>();

    public void addUser () {
        users.add(new Client(in.nextLine(), in.nextLine(), in.nextLine()));
    }

    public static User findUser (String login) {
        for (User user : users) {
            if (user.getLogin().equals(login))
                return user;
        }
        return null;
    }

    public void processRequests () {
        //TODO: Сделать расчет заявок и отправку рез-тов клиентам
    }

    public static class InitialWindow extends JFrame {
        private JButton button = new JButton("Вход");
        private JTextField loginInput = new JTextField("", 5);
        private JPasswordField passwordInput = new JPasswordField("", 5);
        private JLabel loginLabel = new JLabel("Логин:");
        private JLabel passwordLabel = new JLabel("Пароль:");

        InitialWindow() {
            this.setTitle("1ХБЕТ - СТАВКИ НА СПОРТ");
            this.setSize(400, 200);
            this.setResizable(false);
            Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize(), fSize = getSize ();
            if (fSize.height > sSize.height) {fSize.height = sSize.height;}
            if (fSize.width  > sSize.width)  {fSize.width = sSize.width;}
            setLocation ((sSize.width - fSize.width)/2, (sSize.height - fSize.height)/2);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);

            Container container = this.getContentPane();
            container.setLayout(new GridLayout(0, 1, 0, 5));
            container.add(loginLabel);
            container.add(loginInput);
            container.add(passwordLabel);
            container.add(passwordInput);
            button.addActionListener(new ButtonEventListener());
            container.add(button);
        }

        class ButtonEventListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                User current = findUser(loginInput.getText());
                if (current == null) {
                    String msg = "Пользователя с таким логином нет, обратитесь к системному администратору!";
                    JOptionPane.showMessageDialog(null, msg, "Ошибка!", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    if (!current.Enter(current.login, passwordInput.getText())) {
                        String msg = "Неправильно введен пароль!";
                        JOptionPane.showMessageDialog(null, msg, "Ошибка!", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        //TODO: Вызов окна пользователя/админа
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        TradeSystem TS = new TradeSystem();
        TS.addUser(); //TODO: Убрать это
        InitialWindow app = new InitialWindow();
        app.setVisible(true);
    }
}
