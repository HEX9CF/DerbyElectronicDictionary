package project.model;

/**
 * 单词
 *
 * @author HEX9CF
 * @date 2023/05/31
 */
public class Word {
    String word;    // 单词
    String ipa;     // 音标
    String meaning; // 释义
    String example; // 例句

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getIpa() {
        return ipa;
    }

    public void setIpa(String ipa) {
        this.ipa = ipa;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }
}
