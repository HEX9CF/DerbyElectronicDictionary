package dict.data;
import dict.model.Word;

import java.sql.*;
import java.util.*;

/**
 * 随机查询单词
 *
 * @author HEX9CF
 * @date 2023/05/31
 */
public class QueryRandomWords {
    int count = 0;  // 随机抽取条数
    public void setCount(int n) {
        this.count = n;
    }
    public Word[] queryRandomWords() {
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
            // 抽取条数必须小于等于记录条数
            count = Math.min(count, recordAmount);
            // 初始化输出数组
            words = new Word[count];
            for(int i = 0; i < words.length; i++) {
                words[i] = new Word();
            }
            // 获取随机数数组
            int[] indexs = getRandomNumber(recordAmount, count);
            // 随机读取结果集，写入到输出数组
            int m = 0;
            for(int index : indexs) {
                rs.absolute(index);
                words[m].setWord(rs.getString(1));
                words[m].setIpa(rs.getString(2));
                words[m].setMeaning(rs.getString(3));
                words[m].setExample(rs.getString(4));
                m++;
            }
            con.close();
        } catch(SQLException e) {
            System.out.println(e);
        }
        return words;
    }

    /**
     * 获取随机数数组
     * 范围：[1,max]
     *
     * @param max   最大值
     * @param count 数量
     * @return {@link int[]}
     */
    private int[] getRandomNumber(int max, int count) {
        int[] randomNumbers = new int[count];
        // 生成随机数，使用集合去重
        Set<Integer> set = new HashSet<Integer>();
        Random random = new Random();
        for (int s = 0; s < count; s = set.size()) {
            int r = random.nextInt(max) + 1;
            set.add(r);
        }
        // 使用迭代器读取集合，写入输出数组
        Iterator<Integer> iter = set.iterator();
        for(int i = 0; iter.hasNext(); i++) {
            Integer n = iter.next();
            randomNumbers[i] = n;
        }
        return randomNumbers;
    }
}
