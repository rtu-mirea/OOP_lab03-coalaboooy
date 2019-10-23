package Lab3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class InitialWindow extends JFrame {
    private JButton submitButton = new JButton("Вход");
    private JTextField loginInput = new JTextField();
    private JPasswordField passwordInput = new JPasswordField();
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
        submitButton.addActionListener(new ButtonEventListener());
        container.add(submitButton);
        this.setVisible(true);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            Admin A = new Admin();
            A.setLogin();
            A.setPassword();

            if (loginInput.getText().equals(A.getLogin()) && passwordInput.getText().equals(A.getPassword())) {
                //TODO: Вызов окна администратора
                dispose();
            }
            else {
                User current = TradeSystem.findUser(loginInput.getText());
                if (current == null) {
                    String msg = "Пользователя с таким логином нет, обратитесь к системному администратору!";
                    JOptionPane.showMessageDialog(null, msg, "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    if (!current.Enter(current.login, passwordInput.getText())) {
                        String msg = "Неправильно введен пароль!";
                        JOptionPane.showMessageDialog(null, msg, "Ошибка", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        //TODO: Вызов окна пользователя
                        TradeSystem.currentUser = current;
                        dispose();
                        ClientWindow CW = new ClientWindow();
                    }
                }
            }
        }
    }
}