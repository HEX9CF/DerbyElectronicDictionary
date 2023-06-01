package dict.view;

import dict.controller.UpdateWordHandler;

import javax.swing.*;

public class UpdateWordView {
    private JPanel mainPanel;
    private JTextField textWord;
    private JTextField textIpa;
    private JTextArea textMeaning;
    private JTextArea textExample;
    private JButton buttonUpdate;
    private JButton buttonQuery;
    private JButton buttonDelete;
    private JTextField textInput;
    private UpdateWordHandler handler;
    UpdateWordView() {
        setHandler(new UpdateWordHandler());
        regListener();
    }
    private void setHandler(UpdateWordHandler h) {
        this.handler = h;
        handler.setView(this);
    }
    private void regListener() {
        buttonDelete.addActionListener(handler);
        buttonQuery.addActionListener(handler);
        buttonUpdate.addActionListener(handler);
    }

    public JPanel getMainPanel() {
        return mainPanel;
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

    public JButton getButtonUpdate() {
        return buttonUpdate;
    }

    public JButton getButtonQuery() {
        return buttonQuery;
    }

    public JButton getButtonDelete() {
        return buttonDelete;
    }

    public JTextField getTextInput() {
        return textInput;
    }
}
