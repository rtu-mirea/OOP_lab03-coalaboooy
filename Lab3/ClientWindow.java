package Lab3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ClientWindow extends JFrame{

    private JButton addButton = new JButton("Добавить заявку");
    private JButton lookButton = new JButton("Посмотреть статус заявок");
    private JLabel welcome = new JLabel("Добро пожаловать, " + TradeSystem.currentUser.name);
    private GridBagLayout gbl = new GridBagLayout();

    ClientWindow () {
        this.setTitle("Пользователь");
        this.setSize(300, 200);
        this.setResizable(false);
        Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize(), fSize = getSize ();
        if (fSize.height > sSize.height) {fSize.height = sSize.height;}
        if (fSize.width  > sSize.width)  {fSize.width = sSize.width;}
        setLocation ((sSize.width - fSize.width)/2, (sSize.height - fSize.height)/3);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(gbl);

        GridBagConstraints lookCon = new GridBagConstraints();
        GridBagConstraints addCon = new GridBagConstraints();
        GridBagConstraints welCon = new GridBagConstraints();

        welCon.gridx = 0;
        welCon.gridy = 1;
        welCon.gridwidth = GridBagConstraints.REMAINDER;
        welCon.fill = GridBagConstraints.BOTH;
        welCon.insets = new Insets(0, 0, 10, 0);
        lookCon.gridx = 0;
        lookCon.gridy = GridBagConstraints.RELATIVE;
        lookCon.fill = GridBagConstraints.BOTH;
        lookCon.insets = new Insets(10, 0, 10, 0);
        addCon.gridx = 0;
        addCon.gridy = GridBagConstraints.RELATIVE;
        addCon.fill = GridBagConstraints.BOTH;
        addCon.insets = new Insets(10, 0, 0, 0);

        gbl.setConstraints(lookButton, lookCon);
        gbl.setConstraints(addButton, addCon);
        gbl.setConstraints(welcome, welCon);

        container.add(welcome);
        container.add(lookButton);
        container.add(addButton);
        //TODO: Обе кнопки вызывают диалоговое окно с полями для ввода, добавить - по закрытию открытие окна логина

        this.setVisible(true);
    }
}