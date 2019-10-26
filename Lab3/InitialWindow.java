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
    private GridBagLayout gbl = new GridBagLayout();
    private GridBagConstraints logInput = new GridBagConstraints();
    private GridBagConstraints passInput = new GridBagConstraints();
    private GridBagConstraints logLabel = new GridBagConstraints();
    private GridBagConstraints passLabel = new GridBagConstraints();
    private GridBagConstraints button = new GridBagConstraints();

    InitialWindow() {
        this.setTitle("Вход в систему");
        this.setSize(400, 180);
        this.setResizable(false);
        Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize(), fSize = getSize ();
        if (fSize.height > sSize.height) {fSize.height = sSize.height;}
        if (fSize.width  > sSize.width)  {fSize.width = sSize.width;}
        setLocation ((sSize.width - fSize.width)/2, (sSize.height - fSize.height)/2);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(gbl);

        logLabel.gridy = 0;
        logLabel.gridx = 0;
        logLabel.insets = new Insets(0, 10, 5, 10);

        passLabel.gridy = 1;
        passLabel.gridx = 0;
        passLabel.insets = new Insets(5, 10, 5, 10);

        logInput.gridy = 0;
        logInput.gridx = 1;
        logInput.weightx = 0.1;
        logInput.fill = GridBagConstraints.HORIZONTAL;
        logInput.insets = new Insets(5, 10, 5, 10);

        passInput.gridy = 1;
        passInput.gridx = 1;
        passInput.fill = GridBagConstraints.HORIZONTAL;
        passInput.insets = new Insets(5, 10, 5, 10);

        button.gridy = 2;
        button.gridx = 0;
        button.gridwidth = GridBagConstraints.REMAINDER;
        button.insets = new Insets(5, 0, 0, 0);

        gbl.setConstraints(loginLabel, logLabel);
        gbl.setConstraints(loginInput, logInput);
        gbl.setConstraints(passwordLabel, passLabel);
        gbl.setConstraints(passwordInput, passInput);
        gbl.setConstraints(submitButton, button);

        container.add(loginLabel);
        container.add(passwordLabel);
        container.add(loginInput);
        container.add(passwordInput);
        submitButton.addActionListener(new SubmitEventListener());
        container.add(submitButton);
        this.setVisible(true);
    }

    class SubmitEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            Admin A = new Admin();
            A.setLogin();
            A.setPassword();

            if (loginInput.getText().equals(A.getLogin()) && passwordInput.getText().equals(A.getPassword())) {
                dispose();
                new AdminWindow();
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
                        TradeSystem.currentUser = current;
                        dispose();
                        new ClientWindow();
                    }
                }
            }
        }
    }
}