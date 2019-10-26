package Lab3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class AdminWindow extends JFrame{

    private JButton addButton = new JButton("Добавить участника");
    private JButton resButton = new JButton("Выслать результаты участникам");
    private GridBagLayout gbl = new GridBagLayout();

    AdminWindow () {
        this.setTitle("Администратор");
        this.setSize(300, 200);
        this.setResizable(false);
        Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize(), fSize = getSize ();
        if (fSize.height > sSize.height) {fSize.height = sSize.height;}
        if (fSize.width  > sSize.width)  {fSize.width = sSize.width;}
        setLocation ((sSize.width - fSize.width)/2, (sSize.height - fSize.height)/3);

        addWindowListener(new CloseEventListener());

        Container container = this.getContentPane();
        container.setLayout(gbl);

        GridBagConstraints lookCon = new GridBagConstraints();
        GridBagConstraints addCon = new GridBagConstraints();

        lookCon.gridx = 0;
        lookCon.gridy = GridBagConstraints.RELATIVE;
        lookCon.fill = GridBagConstraints.BOTH;
        lookCon.insets = new Insets(10, 0, 10, 0);
        addCon.gridx = 0;
        addCon.gridy = GridBagConstraints.RELATIVE;
        addCon.fill = GridBagConstraints.BOTH;
        addCon.insets = new Insets(10, 0, 0, 0);

        resButton.addActionListener(new ResultEventListener());
        addButton.addActionListener(new AddUserEventListener());
        gbl.setConstraints(resButton, lookCon);
        gbl.setConstraints(addButton, addCon);

        container.add(resButton);
        container.add(addButton);
        this.setVisible(true);
    }

    private static class AddUserWindow extends JFrame {

        private GridBagLayout gbl = new GridBagLayout();
        static JTextField loginInput = new JTextField("Логин");
        static JTextField passwordInput = new JTextField("Пароль");
        static JTextField nameInput = new JTextField("Имя");
        private JButton addButton = new JButton("Зарегестрировать пользователя");
        private GridBagConstraints firstInput = new GridBagConstraints();
        private GridBagConstraints otherInput = new GridBagConstraints();
        private GridBagConstraints button = new GridBagConstraints();

        AddUserWindow() {
            this.setTitle("Добавление пользвателя в систему");
            this.setSize(400, 200);
            Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize(), fSize = getSize ();
            if (fSize.height > sSize.height) {fSize.height = sSize.height;}
            if (fSize.width  > sSize.width)  {fSize.width = sSize.width;}
            setLocation ((sSize.width - fSize.width)/3, (sSize.height - fSize.height)/3);
            this.addWindowListener(new UserCloseEventListener());

            Container container = this.getContentPane();
            container.setLayout(gbl);

            firstInput.gridx = 0;
            firstInput.gridy = 0;
            firstInput.fill = GridBagConstraints.BOTH;
            firstInput.insets = new Insets(0, 0, 10, 0);
            otherInput.gridx = 0;
            otherInput.gridy = GridBagConstraints.RELATIVE;
            otherInput.fill = GridBagConstraints.BOTH;
            otherInput.insets = new Insets(10, 0, 10, 0);
            button.gridx = 0;
            button.gridy = GridBagConstraints.RELATIVE;
            button.insets = new Insets(10, 10, 10, 10);

            gbl.setConstraints(nameInput, firstInput);
            gbl.setConstraints(loginInput, otherInput);
            gbl.setConstraints(passwordInput, otherInput);
            gbl.setConstraints(addButton, button);

            container.add(nameInput);
            container.add(loginInput);
            container.add(passwordInput);
            addButton.addActionListener(new AddUserButtonListener());
            container.add(addButton);
            this.setVisible(true);
        }
    }

    private static class AddUserButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String name = AddUserWindow.loginInput.getText();
            if (TradeSystem.findUser(name) == null)
                TradeSystem.addUser(AddUserWindow.nameInput.getText(), name, AddUserWindow.passwordInput.getText());
            else
                JOptionPane.showMessageDialog(null, "Такой пользователь уже зарегестрирован!",
                        "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static class ResultEventListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            TradeSystem.processRequests();
            JOptionPane.showMessageDialog(null, "Информация по заявкам рассчитана и выслана пользователям",
                    "", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static class AddUserEventListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            new AddUserWindow();
        }
    }

    private static class UserCloseEventListener implements WindowListener {

        public void windowOpened(WindowEvent e) {}

        public void windowClosing(WindowEvent e) {
            AddUserWindow.nameInput.setText("Имя");
            AddUserWindow.loginInput.setText("Логин");
            AddUserWindow.passwordInput.setText("Пароль");
        }

        public void windowClosed(WindowEvent e) {}

        public void windowIconified(WindowEvent e) {}

        public void windowDeiconified(WindowEvent e) {}

        public void windowActivated(WindowEvent e) {}

        public void windowDeactivated(WindowEvent e) {}
    }

    static class CloseEventListener implements WindowListener {

        public void windowOpened(WindowEvent e) {}

        public void windowClosing(WindowEvent e) {
            InitialWindow app = new InitialWindow();
        }

        public void windowClosed(WindowEvent e) {}

        public void windowIconified(WindowEvent e) {}

        public void windowDeiconified(WindowEvent e) {}

        public void windowActivated(WindowEvent e) {}

        public void windowDeactivated(WindowEvent e) {}
    }
}