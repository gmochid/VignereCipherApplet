/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vignerecipher;

import java.awt.Graphics;
import javax.swing.JApplet;

/**
 *
 * @author Intel
 */
public class Main extends JApplet {

    @Override
    public void init() {
        buffer = new StringBuffer();
        addItem("Initializing..\n");
    }

    @Override
    public void start() {
        addItem("Starting..\n");
    }

    @Override
    public void stop() {
        addItem("Stopping..\n");
    }

    @Override
    public void destroy() {
        addItem("Prepare to be boarded..\n");
    }
    
    public void addItem(String word) {
        System.out.println(word);
        buffer.append(word);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawRect(0, 0, getWidth(), getHeight());

        g.drawString(buffer.toString(), 10, 20);
    }

    StringBuffer buffer;
}
