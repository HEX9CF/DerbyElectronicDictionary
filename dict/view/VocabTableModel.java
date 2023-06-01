package dict.view;

import javax.swing.table.DefaultTableModel;

/**
 * 词汇表模型
 *
 * @author HEX9CF
 * @date 2023/06/01
 */
public class VocabTableModel extends DefaultTableModel {
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
