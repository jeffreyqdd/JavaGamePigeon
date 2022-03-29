package utils;

import java.util.List;

/** A fast way to figure out if a word exists or not.
 *
 * @author Jeffrey Qian */
public class SuffixTree {

    Node root;

    public SuffixTree() {
        root= new Node(false);
    }

    public SuffixTree(List<String> wordArr) {
        this();

        for (String s : wordArr) {
            add(s);
        }
    }

    /** Adds string s to the suffix tree <br>
     * s must be lowercase <br>
     * s cannot be null <br>
     *
     * @param s */
    public void add(String s) {
        // honestly it's better to redo this and prevent breaking later!
        // I literally don't care about efficiency here
        assert s != null;
        add(s.toLowerCase(), root);
    }

    /** adds string s to node n, recursive in nature <br>
     * preconditions: s and n are not null! <br>
     * precondition: s is lowercase <br>
     *
     * @param s string left to be appended
     * @param n current node */
    private void add(String s, Node n) {
        // note, the method signature can be optimized to increase runtime complexity
        // but I don't care since this is being performed only once at the init
        // phase

        if (s == "") {
            n.markEnd();
        } else {
            char letter= s.charAt(0);
            Node child= n.getChild(letter);

            if (child == null) {
                child= new Node();
                n.addNode(child, letter);
            }
            add(s.substring(1), child);

        }
    }

    /** determines if word exists in current suffix tree
     *
     * @param s is the word to check
     * @return true if s exists in tree, else false */
    public boolean contains(String s) {
        return contains(s, root);
    }

    /** determines if string s in in node n
     *
     * @param s string to check
     * @param n node
     * @return true if string exists else false */
    private boolean contains(String s, Node n) {
        if (n == null) return false;
        if (s == "") return n.isWordEnd();
        return contains(s.substring(1), n.getChild(s.charAt(0)));
    }

    private class Node {
        /** true if there is a word at this point (doesn't need to go further) */
        private boolean isWord;

        /** children[0] == 'a' and children[25] == 'z' guarantees O(1) time traversal. */
        private Node[] children;

        public Node() {
            children= new Node[26];
        }

        public Node(boolean isWord) {
            this();
            this.isWord= isWord;
        }

        /** Adds a node <br>
         * Precondition is that letter is lowercase. <br>
         * Precondition is that the node partition is null <br>
         *
         * @param n      node
         * @param letter the node corresponds to */
        public void addNode(Node n, char letter) {
            assert letter >= 'a';
            assert letter <= 'z';
            assert children[letter - 'a'] == null;

            children[letter - 'a']= n;
        }

        /** returns true if this can be considered a word. */
        public boolean isWordEnd() {
            return isWord;
        }

        /** marks this as a end of word */
        public void markEnd() {
            isWord= true;
        }

        /** Gets node associated with letter <br>
         * Precondition is that letter is lowercase <br>
         *
         * @param letter used to get the next node
         * @return node if there exists a node under that partition, else null, */
        public Node getChild(char letter) {
            assert letter >= 'a';
            assert letter <= 'z';

            return children[letter - 'a'];
        }

    }
}
