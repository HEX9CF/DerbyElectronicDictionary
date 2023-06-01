package dict.view;

import dict.controller.QueryWordHandler;

import javax.swing.*;

/**
 * 查询单词视图
 *
 * @author HEX9CF
 * @date 2023/06/01
 */
public class QueryWordView {
    private JPanel mainPanel;
    private JButton buttonQuery;
    private JTextField textWord;
    private JTextField textIpa;
    private JTextArea textMeaning;
    private JTextArea textExample;
    private QueryWordHandler handler;

    QueryWordView() {
        setHandler(new QueryWordHandler());
        regListener();
    }

    private void setHandler(QueryWordHandler h) {
        this.handler = h;
        handler.setView(this);
    }

    private void regListener() {
        buttonQuery.addActionListener(handler);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JButton getButtonQuery() {
        return buttonQuery;
    }

    public JTextField getTextWord() {
        return textWord;
    }

    public JTextField getTextIpa() {
        return textIpa;
    }

    public JTextArea getTextMeaning() {
        return textMeaning;
    }

    public JTextArea getTextExample() {
        return textExample;
    }
}
