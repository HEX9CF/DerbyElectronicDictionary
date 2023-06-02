package dict.controller;

import dict.data.QueryRandomWord;
import dict.model.Word;
import dict.view.RandomWordView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 随机单词处理器
 *
 * @author HEX9CF
 * @date 2023/06/02
 */
public class RandomWordHandler implements ActionListener {
    RandomWordView view;
    QueryRandomWord queryRandomWord;

    Word result = null;
    String lastWord = "";
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == view.getButtonQuery()) {
            // 清空输出
            clearOutput();

            // 随机获取单词
            queryRandomWord = new QueryRandomWord();
            result = queryRandomWord.queryRandomWord();
            // 减少重复
            if(lastWord.equals(result.getWord())) {
                result = queryRandomWord.queryRandomWord();
            }

            // 返回查询结果
            lastWord = result.getWord();
            view.getTextGuess().setText(result.getWord());
        } else if(ae.getSource() == view.getButtonDisplay()) {
            // 输出结果
            view.getTextWord().setText(result.getWord());
            view.getTextIpa().setText(result.getIpa());
            view.getTextMeaning().setText(result.getMeaning());
            view.getTextExample().setText(result.getExample());
        }
    }

    /**
     * 清空输出
     */
    private void clearOutput() {
        view.getTextWord().setText(null);
        view.getTextIpa().setText(null);
        view.getTextMeaning().setText(null);
        view.getTextExample().setText(null);
    }

    public void setView(RandomWordView v) {
        this.view = v;
    }
}
