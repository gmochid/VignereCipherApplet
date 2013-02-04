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
import vignerecipher.Vignere;

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
        Label inputLabel = new Label("Input", Label.LEFT);
        Label outputLabel = new Label("Output", Label.LEFT);
        Label keyLabel = new Label("Key", Label.LEFT);
        Label judul = new Label("Vignere Cipher Applet");
        Panel p = new Panel();
        Panel p0 = new Panel();
        Panel p1 = new Panel();
        Panel p2 = new Panel();
        Panel p3 = new Panel();
        Panel p4 = new Panel();

        p.setLayout(new GridLayout(5, 1));

        p0.setLayout(new GridLayout(1, 1));
        p0.add(judul);

        p1.setLayout(new GridLayout(1, 2));
        p1.add(inputLabel);
        p1.add(input);

        p2.setLayout(new GridLayout(1, 2));
        p2.add(outputLabel);
        p2.add(output);

        p3.setLayout(new GridLayout(1, 2));
        p3.add(keyLabel);
        p3.add(key);

        p4.setLayout(new GridLayout(1, 4));
        p4.add(encipherButton);
        p4.add(decipherButton);
        p4.add(encipher256Button);
        p4.add(decipher256Button);

        p.add(p0);
        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);

        add(p);

        encipherButton.addActionListener(this);
        decipherButton.addActionListener(this);
        encipher256Button.addActionListener(this);
        decipher256Button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if(cmd.equals("Encipher")) {
            if(key.getText().equals("")) {
                output.setText(Vignere.encipher(input.getText()));
            } else {
                output.setText(Vignere.encipher(input.getText(), key.getText()));
            }
        } else if (cmd.equals("Decipher")) {
            if(key.getText().equals("")) {
                output.setText(Vignere.decipher(input.getText()));
            } else {
                output.setText(Vignere.decipher(input.getText(), key.getText()));
            }
        } else if(cmd.equals("Encipher256")) {
            if(key.getText().equals("")) {
                output.setText(Vignere.encipher256(input.getText()));
            } else {
                output.setText(Vignere.encipher256(input.getText(), key.getText()));
            }
        } else if (cmd.equals("Decipher256")) {
            if(key.getText().equals("")) {
                output.setText(Vignere.decipher256(input.getText()));
            } else {
                output.setText(Vignere.decipher256(input.getText(), key.getText()));
            }
        }
    }

    // GUI Object
    TextField input = new TextField(15);
    TextField output = new TextField(15);
    TextField key = new TextField(15);
    Button encipherButton = new Button("Encipher");
    Button decipherButton = new Button("Decipher");
    Button encipher256Button = new Button("Encipher256");
    Button decipher256Button = new Button("Decipher256");
}

