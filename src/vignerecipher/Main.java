/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vignerecipher;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;

/**
 *
 * @author Intel
 */
public class Main extends JApplet implements ActionListener {

    @Override
    public void init() {
        makeGUI();
        setName("Vignere Cipher Applet");
    }

    private void makeGUI() {
        Label plaintextLabel = new Label("Plainteks", Label.LEFT);
        Label cipherLabel = new Label("Cipher", Label.LEFT);
        Label keyLabel = new Label("Key", Label.LEFT);
        Panel p = new Panel();
        Panel p1 = new Panel();
        Panel p2 = new Panel();
        Panel p3 = new Panel();
        Panel p4 = new Panel();

        p.setLayout(new GridLayout(4, 1));

        p1.setLayout(new GridLayout(1, 2));
        p1.add(plaintextLabel);
        p1.add(plaintext);

        p2.setLayout(new GridLayout(1, 2));
        p2.add(cipherLabel);
        p2.add(cipher);

        p3.setLayout(new GridLayout(1, 2));
        p3.add(keyLabel);
        p3.add(key);

        p4.setLayout(new GridLayout(1, 2));
        p4.add(encipherButton);
        p4.add(decipherButton);

        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);

        add(p);

        encipherButton.addActionListener(this);
        decipherButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if(cmd.equals("Encipher")) {
            cipher.setText(Vignere.encipher(plaintext.getText(), key.getText()));
        } else if (cmd.equals("Decipher")) {
            plaintext.setText(Vignere.decipher(cipher.getText(), key.getText()));
        }
    }

    // GUI Object
    TextField plaintext = new TextField(15);
    TextField cipher = new TextField(15);
    TextField key = new TextField(15);
    Button encipherButton = new Button("Encipher");
    Button decipherButton = new Button("Decipher");
}

