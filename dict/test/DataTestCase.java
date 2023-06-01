package dict.test;
import dict.data.DatabaseInitializer;
import dict.model.Word;
import dict.data.*;

/**
 * 数据测试用例
 *
 * @author HEX9CF
 * @date 2023/05/31
 */
public class DataTestCase {
    public static void main(String[] args) {
        new DatabaseInitializer();
        Word word = null;

        String[][] a = {
                {"empathy", "/ˈɛmpəθi/", "n.移情", "The money will be used to fund an initiative designed to help offenders develop _____ with their victims."},
                {"crawl", "", "v.爬行", ""},
                {"retrieve", "", "v.取回，检索", ""},
                {"trace", "", "v.查出，痕迹", ""}
        };
        AddWord addWord = new AddWord();
        word = new Word();
        for(int i = 0; i < a.length; i++) {
            word.setWord(a[i][0]);
            word.setIpa(a[i][1]);
            word.setMeaning(a[i][2]);
            word.setExample(a[i][3]);
            addWord.addWord(word);
//            System.out.printf("%-10s %-10s %-10s %-10s\n", word.getWord(), word.getIpa(), word.getMeaning(), word.getExample());
        }

        QueryWord queryWord = new QueryWord();
        word = new Word();
        word.setWord("empathy");
        Word result = queryWord.queryWord(word);
        System.out.printf("%-10s %-10s %-10s %-10s\n", result.getWord(), result.getIpa(), result.getMeaning(), result.getExample());
        System.out.println();

        Word[] results;

        QueryAllWord queryAllWord = new QueryAllWord();
        results = queryAllWord.queryAllWord();
        for(int i = 0; i < results.length; i++) {
            System.out.printf("%d %-10s %-10s %-10s %-10s\n", i, results[i].getWord(), results[i].getIpa(), results[i].getMeaning(), results[i].getExample());
        }
        System.out.println();

        QueryRandomWord queryRandomWord = new QueryRandomWord();
        queryRandomWord.setCount(3);
        results = queryRandomWord.queryRandomWord();
        for(int i = 0; i < results.length; i++) {
            System.out.printf("%d %-10s %-10s %-10s %-10s\n", i, results[i].getWord(), results[i].getIpa(), results[i].getMeaning(), results[i].getExample());
        }
        System.out.println();

        UpdateWord updateWord = new UpdateWord();
        word = new Word();
        word.setWord("crawl");
        word.setIpa("/krɔːl/");
        updateWord.updateWord(word);

        queryAllWord = new QueryAllWord();
        results = queryAllWord.queryAllWord();
        for(int i = 0; i < results.length; i++) {
            System.out.printf("%d %-10s %-10s %-10s %-10s\n", i, results[i].getWord(), results[i].getIpa(), results[i].getMeaning(), results[i].getExample());
        }
        System.out.println();

        DeleteWord deleteWord = new DeleteWord();
        word = new Word();
        word.setWord("crawl");
        deleteWord.deleteWord(word);

        queryAllWord = new QueryAllWord();
        results = queryAllWord.queryAllWord();
        for(int i = 0; i < results.length; i++) {
            System.out.printf("%d %-10s %-10s %-10s %-10s\n", i, results[i].getWord(), results[i].getIpa(), results[i].getMeaning(), results[i].getExample());
        }
        System.out.println();
    }
}
