package dict.controller;

import javax.swing.text.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Handler implements ActionListener {
    View view;
    public abstract void actionPerformed(ActionEvent ae);
    public void setView(View v) {
        this.view = v;
    };
}
