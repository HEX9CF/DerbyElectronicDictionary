package dict.data;
import dict.model.Word;

import java.sql.*;

/**
 * 查询所有单词
 *
 * @author HEX9CF
 * @date 2023/06/02
 */
public class QueryAllWord {
    public Word[] queryAllWord() {
        // 连接数据库
        Connection con = DatabaseConnector.connect();
        if(null == con) {
            return null;
        }

        Word[] words = null;
        Statement sta;
        ResultSet rs;
        try {
            // 查询所有数据
            String sqlStr = "SELECT * FROM word_tbl";
            sta = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = sta.executeQuery(sqlStr);
            rs.last();
            int recordAmount = rs.getRow();

            // 初始化输出数组
            words = new Word[recordAmount];
            for(int i = 0; i < words.length; i++) {
                words[i] =  new Word();
            }

            // 写入输出数组
            rs.beforeFirst();
            for(int i = 0; rs.next(); i++) {
                words[i].setWord(rs.getString(1));
                words[i].setIpa(rs.getString(2));
                words[i].setMeaning(rs.getString(3));
                words[i].setExample(rs.getString(4));
            }
            con.close();
        } catch(SQLException e) {
            System.out.println(e);
        }
        return words;
    }

}
