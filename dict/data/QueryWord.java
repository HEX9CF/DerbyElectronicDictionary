package dict.data;
import dict.model.Word;

import java.sql.*;

/**
 * 查询一个单词
 *
 * @author HEX9CF
 * @date 2023/05/31
 */
public class QueryWord {
    public Word query(Word word) {
        // 连接数据库
        Connection con = DatabaseConnector.connect();
        if(null == con) {
            return null;
        }

        Word foundWord = null;
        PreparedStatement preSta;
        ResultSet rs;
        try {
            // 查询数据
            String sqlStr = "SELECT * FROM word_tbl WHERE word=?";
            preSta = con.prepareStatement(sqlStr);
            preSta.setString(1, word.getWord());
            rs = preSta.executeQuery();
            if(rs.next()) {
                foundWord = new Word();
                foundWord.setWord(rs.getString(1));
                foundWord.setIpa(rs.getString(2));
                foundWord.setMeaning(rs.getString(3));
                foundWord.setExample(rs.getString(4));
            }
            con.close();
        } catch(SQLException e) {
            System.out.println(e);
        }
        return foundWord;
    }
}
