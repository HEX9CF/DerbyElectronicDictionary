package dict.data;

import dict.model.Word;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

/**
 * 随机查询单词
 *
 * @author HEX9CF
 * @date 2023/06/02
 */
public class QueryRandomWord {
    public Word queryRandomWord() {
        // 连接数据库
        Connection con = DatabaseConnector.connect();
        if(null == con) {
            return null;
        }
        Word word = null;
        Statement sta;
        ResultSet rs;
        try {
            // 查询所有数据
            String sqlStr = "SELECT * FROM word_tbl";
            sta = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = sta.executeQuery(sqlStr);
            rs.last();
            int recordAmount = rs.getRow();

            // 随机定位单词
            int m = getRandomNumber(recordAmount);
            rs.absolute(m);

            // 初始化输出
            word = new Word();
            word.setWord(rs.getString(1));
            word.setIpa(rs.getString(2));
            word.setMeaning(rs.getString(3));
            word.setExample(rs.getString(4));
            con.close();
        } catch(SQLException e) {
            System.out.println(e);
        }
        return word;
    }

    private int getRandomNumber(int max) {
        Random random = new Random();
        int num = random.nextInt(max) + 1;
        return num;
    }
}
