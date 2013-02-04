/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vignerecipher;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JOptionPane;
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
        Panel p5 = new Panel();

        p.setLayout(new GridLayout(6, 1));

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

        p4.setLayout(new GridLayout(1, 3));
        p4.add(asPlaintextCB);
        p4.add(noSpaceCB);
        p4.add(fiveCharacterCB);

        p5.setLayout(new GridLayout(1, 4));
        p5.add(encipherButton);
        p5.add(decipherButton);
        p5.add(encipher256Button);
        p5.add(decipher256Button);

        p.add(p0);
        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        p.add(p5);

        add(p);

        encipherButton.addActionListener(this);
        decipherButton.addActionListener(this);
        encipher256Button.addActionListener(this);
        decipher256Button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if(key.getText().length() > 25) {
            JOptionPane.showMessageDialog(this, "Panjang key harus kurang dari 25");
            return;
        }

        if((cmd.equals("Encipher")) || (cmd.equals("Decipher"))) {
            for (char i = '0'; i <= '9'; i++) {
                StringBuffer tmp = new StringBuffer();
                tmp.append(i);
                if(input.getText().contains(tmp)) {
                    JOptionPane.showMessageDialog(this, "Tidak boleh ada karakter angka dalam perintah 'Encipher dan 'Decipher'");
                    return;
                }
            }
        }

        String tmpOutput = null;
        StringBuilder buffOutput = new StringBuilder();
        if(cmd.equals("Encipher")) {
            if(key.getText().equals("")) {
                tmpOutput = Vignere.encipher(input.getText());
            } else {
                tmpOutput = Vignere.encipher(input.getText(), key.getText());
            }
        } else if (cmd.equals("Decipher")) {
            if(key.getText().equals("")) {
                tmpOutput = Vignere.decipher(input.getText());
            } else {
                tmpOutput = Vignere.decipher(input.getText(), key.getText());
            }
        } else if(cmd.equals("Encipher256")) {
            if(key.getText().equals("")) {
                tmpOutput = Vignere.encipher256(input.getText());
            } else {
                tmpOutput = Vignere.encipher256(input.getText(), key.getText());
            }
        } else if (cmd.equals("Decipher256")) {
            if(key.getText().equals("")) {
                tmpOutput = Vignere.decipher256(input.getText());
            } else {
                tmpOutput = Vignere.decipher256(input.getText(), key.getText());
            }
        }
        if(outputChoice.getSelectedCheckbox().getLabel().equals("As Plaintext")) {
            String tmpInput = input.getText();
            int j = 0;
            for (int i = 0; i < tmpInput.length(); i++) {
                if(tmpInput.charAt(i) == ' ') {
                    buffOutput.append(' ');
                } else {
                    buffOutput.append(tmpOutput.charAt(j++));
                }
            }
            tmpOutput = buffOutput.toString();
        } else if(outputChoice.getSelectedCheckbox().getLabel().equals("Five Character")) {
            for (int i = 0; i < tmpOutput.length(); i++) {
                if((i != 0) && (i % 5 == 0)) {
                    buffOutput.append(" ");
                }
                buffOutput.append(tmpOutput.charAt(i));
            }
            tmpOutput = buffOutput.toString();
        }
        output.setText(tmpOutput);
    }

    // GUI Object
    TextField input = new TextField(15);
    TextField output = new TextField(15);
    TextField key = new TextField(15);
    Button encipherButton = new Button("Encipher");
    Button decipherButton = new Button("Decipher");
    Button encipher256Button = new Button("Encipher256");
    Button decipher256Button = new Button("Decipher256");
    CheckboxGroup outputChoice = new CheckboxGroup();
    Checkbox asPlaintextCB = new Checkbox("As Plaintext", outputChoice, true);
    Checkbox noSpaceCB = new Checkbox("No Space", outputChoice, false);
    Checkbox fiveCharacterCB = new Checkbox("Five Character", outputChoice, false);


}

