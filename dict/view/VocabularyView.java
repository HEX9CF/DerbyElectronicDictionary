package dict.view;

import dict.controller.VocabularyHandler;

import javax.swing.*;

/**
 * 词汇表视图
 *
 * @author HEX9CF
 * @date 2023/06/01
 */
public class VocabularyView extends View{
    private JTable tableVocab;
    private JPanel mainPanel;
    private JButton buttonQuery;
    private VocabularyHandler handler;
    private VocabTableModel tableModel = null;
    VocabularyView() {
//        setHandler(new VocabularyHandler());
        regListener();
    }
    private void setHandler(VocabularyHandler h) {
        this.handler = h;
        handler.setView(this);
    }

    private void regListener() {
        buttonQuery.addActionListener(handler);
    }

    private void createUIComponents() {
        setHandler(new VocabularyHandler());
        tableModel = new VocabTableModel();
        tableModel.setDataVector(handler.getTbl(), handler.getHEADER());
        tableVocab = new JTable(tableModel);
    }

    public VocabTableModel getTableModel() {
        return tableModel;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
