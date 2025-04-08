package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

class L212Test {

    @Test
    public void findWords() {
        L212 algo = new L212();
        List<String> ans = algo.findWords(new char[][]{
                        {'o', 'a', 'a', 'n'},
                        {'e', 't', 'a', 'e'},
                        {'i', 'h', 'k', 'r'},
                        {'i', 'f', 'l', 'v'}},
                new String[]{"oath", "pea", "eat", "rain"}
        );
        System.out.println(ans);
    }

}