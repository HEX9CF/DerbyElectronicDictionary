package dict.controller;

import dict.data.DeleteWord;
import dict.data.QueryWord;
import dict.data.UpdateWord;
import dict.model.Word;
import dict.view.UpdateWordView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 更新单词处理器
 *
 * @author HEX9CF
 * @date 2023/06/02
 */
public class UpdateWordHandler extends Handler{
    UpdateWordView view;
    QueryWord queryWord;
    UpdateWord updateWord;
    DeleteWord deleteWord;
    boolean isFound;
    public void actionPerformed(ActionEvent ae) {
        if(view.getButtonQuery() == ae.getSource()) {
            queryAction();
        } else if (view.getButtonUpdate() == ae.getSource()) {
            updateAction();
        } else if (view.getButtonDelete() == ae.getSource()) {
            deleteAction();
        }
    }

    /**
     * 查询操作
     */
    private void queryAction() {
        isFound = false;

        // 清空输出
        clearOutput();

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
        Word result = queryWord.query(word);
        if(null == result) {
            JOptionPane.showMessageDialog(null, "未找到该单词", "警告", JOptionPane.WARNING_MESSAGE);
            return;
        }

        isFound = true;

        // 输出结果
        view.getTextWord().setText(result.getWord());
        view.getTextIpa().setText(result.getIpa());
        view.getTextMeaning().setText(result.getMeaning());
        view.getTextExample().setText(result.getExample());
    }

    /**
     * 更新操作
     */
    private void updateAction() {
        int isOK = 0;
        if(!isFound) {
            JOptionPane.showMessageDialog(null, "单词未读取，请先读取单词！", "警告", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 读取输入
        String wordStr = view.getTextWord().getText();
        String ipa = view.getTextIpa().getText();
        String meaning = view.getTextMeaning().getText();
        String example = view.getTextExample().getText();
        if(0 == wordStr.length() || 0 == meaning.length()) {
            JOptionPane.showMessageDialog(null, "修改单词失败，单词和释义不允许为空！", "警告", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 初始化单词对象
        Word word = new Word();
        word.setWord(wordStr);
        word.setIpa(ipa);
        word.setMeaning(meaning);
        word.setExample(example);

        // 更新数据库
        updateWord = new UpdateWord();
        isOK = updateWord.update(word);
        if(0 != isOK) {
            JOptionPane.showMessageDialog(null, "修改单词成功^_^", "提示", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "修改单词失败", "警告", JOptionPane.WARNING_MESSAGE);
        }
        queryAction();
    }

    /**
     * 删除操作
     */
    private void deleteAction() {
        int isOK = 0;
        if(!isFound) {
            JOptionPane.showMessageDialog(null, "单词未读取，请先读取单词！", "警告", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 读取输入
        String wordStr = view.getTextWord().getText();
        String ipa = view.getTextIpa().getText();
        String meaning = view.getTextMeaning().getText();
        String example = view.getTextExample().getText();
        if(0 == wordStr.length() || 0 == meaning.length()) {
            JOptionPane.showMessageDialog(null, "修改单词失败，单词和释义不允许为空！", "警告", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 初始化单词对象
        Word word = new Word();
        word.setWord(wordStr);
        word.setIpa(ipa);
        word.setMeaning(meaning);
        word.setExample(example);

        // 更新数据库
        deleteWord = new DeleteWord();
        int isConfirm = JOptionPane.showConfirmDialog(null, "确定要删除此单词吗？单词删除后不可恢复！", "提示", JOptionPane.YES_NO_OPTION);
        if(JOptionPane.YES_OPTION == isConfirm) {
            isOK = deleteWord.delete(word);
            if(0 != isOK) {
                JOptionPane.showMessageDialog(null, "删除单词成功^_^", "提示", JOptionPane.INFORMATION_MESSAGE);
                clearOutput();
                return;
            } else {
                JOptionPane.showMessageDialog(null, "删除单词失败", "警告", JOptionPane.WARNING_MESSAGE);
            }
        } else if(JOptionPane.NO_OPTION == isConfirm) {
            JOptionPane.showMessageDialog(null, "操作取消", "提示", JOptionPane.INFORMATION_MESSAGE);
        }
        queryAction();
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

    public void setView(UpdateWordView v) {
        this.view = v;
    }
}
