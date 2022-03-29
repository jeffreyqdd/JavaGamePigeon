package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import utils.SuffixTree;

/** A test for Suffix Trees...not too rigorous...just want to make sure it works
 *
 * @author Jeffrey Qian */
class SuffixTreeTest {

    @Test
    void test1() {
        SuffixTree st= new SuffixTree();
        st.add("potato");

        assertEquals(true, st.contains("potato"));
        assertEquals(false, st.contains("potatoe"));
        assertEquals(false, st.contains("potat"));

        st.add("potatoe");
        st.add("potata");
        assertEquals(true, st.contains("potatoe"));
        assertEquals(true, st.contains("potata"));
        assertEquals(false, st.contains("vb"));
        assertEquals(false, st.contains("pot"));

        assertEquals(false, st.contains(""));

        st.add("abby");
        assertEquals(false, st.contains("abbx"));
        assertEquals(false, st.contains("abb"));
        assertEquals(true, st.contains("abby"));
    }

}
