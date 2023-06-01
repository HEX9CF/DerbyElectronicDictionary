package dict.controller;

import dict.view.QueryWordView;
import dict.view.UpdateWordView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QueryWordHandler implements ActionListener {
    QueryWordView view;
    public void actionPerformed(ActionEvent ae) {

    }
    public void setView(QueryWordView v) {
        this.view = v;
    }
}
