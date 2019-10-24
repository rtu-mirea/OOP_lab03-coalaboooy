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
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

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

        resButton.addActionListener(new AddUserEventListener());
        gbl.setConstraints(resButton, lookCon);
        gbl.setConstraints(addButton, addCon);

        container.add(resButton);
        container.add(addButton);
        //TODO: Окно добавления - диалог с полями, расчет - сообщение. По закрытию открыть логин
        this.setVisible(true);
    }

    class AddUserEventListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //TODO: Вызов processRequests()
            JOptionPane.showMessageDialog(null, "Информация по заявкам рассчитана и выслана пользователям",
                    "", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    class CloseEventListener implements WindowListener {

        public void windowOpened(WindowEvent e) {}

        public void windowClosing(WindowEvent e) {
            InitialWindow app = new InitialWindow();
            //TODO: Окно тут же закрывается
        }

        public void windowClosed(WindowEvent e) {
            InitialWindow app = new InitialWindow();
            //TODO: Здесь вообще не открывается
        }

        public void windowIconified(WindowEvent e) {}

        public void windowDeiconified(WindowEvent e) {}

        public void windowActivated(WindowEvent e) {}

        public void windowDeactivated(WindowEvent e) {}
    }
}