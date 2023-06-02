package dict.controller;
import dict.data.AddWord;
import dict.model.Word;
import dict.view.AddWordView;

import javax.swing.*;
import java.awt.event.*;

/**
 * 添加单词处理器
 *
 * @author HEX9CF
 * @date 2023/06/01
 */
public class AddWordHandler extends Handler{
    AddWordView view;
    public void actionPerformed(ActionEvent ae) {
        int isOK;

        // 读取输入
        String wordStr = view.getTextWord().getText();
        String ipa = view.getTextIpa().getText();
        String meaning = view.getTextMeaning().getText();
        String example = view.getTextExample().getText();
        if(0 == wordStr.length() || 0 == meaning.length()) {
            JOptionPane.showMessageDialog(null, "添加单词失败，单词和释义不允许为空！", "警告", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 初始化单词对象
        Word word = new Word();
        word.setWord(wordStr);
        word.setIpa(ipa);
        word.setMeaning(meaning);
        word.setExample(example);

        // 写入数据库
        AddWord addWord = new AddWord();
        isOK = addWord.add(word);
        if(0 != isOK) {
            JOptionPane.showMessageDialog(null, "添加单词成功^_^", "提示", JOptionPane.INFORMATION_MESSAGE);
            clearInput();
        } else {
            JOptionPane.showMessageDialog(null, "添加单词失败，可能添加了重复单词", "警告", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * 清空输入
     */
    private void clearInput() {
        view.getTextWord().setText(null);
        view.getTextIpa().setText(null);
        view.getTextMeaning().setText(null);
        view.getTextExample().setText(null);
    }

    public void setView(AddWordView v) {
        this.view = v;
    }
}
