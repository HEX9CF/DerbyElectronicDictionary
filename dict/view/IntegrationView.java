package dict.view;
import java.awt.*;
import javax.swing.*;

/**
 * 集成视图
 *
 * @author HEX9CF
 * @date 2023/06/01
 */
public class IntegrationView extends JFrame{
    JTabbedPane tabbedPane;
    AddWordView addWordView;
    UpdateWordView updateWordView;
    QueryWordView queryWordView;
    VocabularyView vocabularyView;
    RandomWordView randomWordView;
    public IntegrationView() {
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        addWordView = new AddWordView();
        updateWordView = new UpdateWordView();
        queryWordView = new QueryWordView();
        vocabularyView = new VocabularyView();
        randomWordView = new RandomWordView();
        tabbedPane.add("查询单词", queryWordView.getMainPanel());
        tabbedPane.add("词汇表", vocabularyView.getMainPanel());
        tabbedPane.add("随机单词", randomWordView.getMainPanel());
        tabbedPane.add("添加单词", addWordView.getMainPanel());
        tabbedPane.add("修改单词", updateWordView.getMainPanel());
        tabbedPane.validate();
        add(tabbedPane, BorderLayout.CENTER);
        validate();
        setBounds(400,200,800, 500);
        setVisible(true);
        setTitle("电子词典");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
