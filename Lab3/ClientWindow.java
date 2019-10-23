package Lab3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ClientWindow extends JFrame{

    private JButton addButton = new JButton("Добавить заявку");

    ClientWindow () {
        this.setTitle("Добро пожаловать, " + TradeSystem.currentUser.name);
        this.setSize(400, 200);
        this.setResizable(false);
        Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize(), fSize = getSize ();
        if (fSize.height > sSize.height) {fSize.height = sSize.height;}
        if (fSize.width  > sSize.width)  {fSize.width = sSize.width;}
        setLocation ((sSize.width - fSize.width)/2, (sSize.height - fSize.height)/3);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);



        this.setVisible(true);
    }
}