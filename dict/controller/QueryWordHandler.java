package dict.controller;

import dict.data.QueryWord;
import dict.model.Word;
import dict.view.QueryWordView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QueryWordHandler implements ActionListener {
    QueryWordView view;
    QueryWord queryWord;
    public void actionPerformed(ActionEvent ae) {
        // 清空输出
        view.getTextWord().setText(null);
        view.getTextIpa().setText(null);
        view.getTextMeaning().setText(null);
        view.getTextExample().setText(null);

        // 读取输入
        String wordStr = view.getTextInput().getText();
        if(0 == wordStr.length()) {
            JOptionPane.showMessageDialog(null, "查询失败，单词不能为空！", "警告", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 查询单词
        Word word = new Word();
        word.setWord(wordStr);
        queryWord = new QueryWord();
        Word result = queryWord.queryWord(word);
        if(null == result) {
            JOptionPane.showMessageDialog(null, "未找到该单词", "警告", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 输出结果
        view.getTextWord().setText(result.getWord());
        view.getTextIpa().setText(result.getIpa());
        view.getTextMeaning().setText(result.getMeaning());
        view.getTextExample().setText(result.getExample());
    }
    public void setView(QueryWordView v) {
        this.view = v;
    }
}
