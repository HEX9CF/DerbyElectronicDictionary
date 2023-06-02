package dict.view;

import dict.controller.RandomWordHandler;

import javax.swing.*;

/**
 * 随机单词视图
 *
 * @author HEX9CF
 * @date 2023/06/02
 */
public class RandomWordView extends View{
    private JPanel mainPanel;
    private JTextField textGuess;
    private JTextArea textExample;
    private JTextArea textMeaning;
    private JTextField textWord;
    private JTextField textIpa;
    private JButton buttonQuery;
    private JButton buttonDisplay;
    private RandomWordHandler handler;

    RandomWordView() {
        setHandler(new RandomWordHandler());
        regListener();
    }

    private void setHandler(RandomWordHandler h) {
        this.handler = h;
        handler.setView(this);
    }

    private void regListener() {
        buttonQuery.addActionListener(handler);
        buttonDisplay.addActionListener(handler);
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

    public JTextField getTextGuess() {
        return textGuess;
    }

    public JButton getButtonDisplay() {
        return buttonDisplay;
    }
}
