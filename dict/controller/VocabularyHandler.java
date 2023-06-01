package dict.controller;

import dict.data.QueryAllWord;
import dict.model.Word;
import dict.view.VocabularyView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 词汇表处理程序
 *
 * @author HEX9CF
 * @date 2023/06/01
 */
public class VocabularyHandler implements ActionListener {
    VocabularyView view;
    QueryAllWord queryAllWord;
    Word[] words;
    final int COLUMN = 4;
    int row = 0;
    private Object[][] tbl = {};
    private final Object[] HEADER = {"单词", "音标", "释义", "例句"};
    public VocabularyHandler() {
        queryWord();
    }

    public void actionPerformed(ActionEvent ae) {
        queryWord();
        updateTable();
    }

    public void queryWord() {
        queryAllWord = new QueryAllWord();
        words = queryAllWord.queryAllWord();
        row = words.length;
        tbl = new Object[row][COLUMN];
        for(int i = 0; i < row; i++) {
            tbl[i][0] = words[i].getWord();
            tbl[i][1] = words[i].getIpa();
            tbl[i][2] = words[i].getMeaning();
            tbl[i][3] = words[i].getExample();
        }
    }

    public void updateTable() {
        view.getTableModel().setDataVector(tbl, HEADER);
    }

    public Object[][] getTbl() {
        return tbl;
    }

    public void setView(VocabularyView v) {
        this.view = v;
    }

    public Object[] getHEADER() {
        return HEADER;
    }
}
