package dict.view;

import dict.controller.AddWordHandler;
import javax.swing.*;

/**
 * 添加单词视图
 *
 * @author HEX9CF
 * @date 2023/06/01
 */
public class AddWordView {
    private JPanel mainPanel;
    private JTextField textWord;
    private JTextField textIpa;
    private JTextArea textMeaning;
    private JTextArea textExample;
    private JButton buttonSubmit;
    private AddWordHandler handler;
    AddWordView() {
        setHandler(new AddWordHandler());
        regListener();
    }
    private void setHandler(AddWordHandler h) {
        this.handler = h;
        handler.setView(this);
    }
    private void regListener() {
        buttonSubmit.addActionListener(handler);
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

    public JButton getButtonSubmit() {
        return buttonSubmit;
    }
}
