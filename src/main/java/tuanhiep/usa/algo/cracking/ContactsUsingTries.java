package tuanhiep.usa.algo.cracking;

public class ContactsUsingTries {
    public static void main(String[] args) {


    }


}

class NodeTrie {
    private static int NUMBER_OF_CHARACTER = 26;
    // Each node in Trie may have maximum 26 children because we have 26 characters in alphabet
    // So for each node we store an array of length 26, if the node doesn't have a child of any character,
    // in the array, it's corresponding index is null
    NodeTrie[] children = new NodeTrie[NUMBER_OF_CHARACTER];
    int size = 0;
    private static int getCharIndex(char c) {
        return c - 'a';
    }

    private NodeTrie getNodeTrie(char c) {
        return children[getCharIndex(c)];
    }

    private void setNodeTrie(char c, NodeTrie node) {
        children[getCharIndex(c)] = node;
    }
    // For root mostly
    public void add(String s) {
        add(s,0);
    }

    /**
     * Here the index is the position of character in string s that we want to starting add to the Trie
     * @param s
     * @param index
     */
    private void add(String s, int index) {
        if (index == s.length()) {
            return;
        }
        // Each time we have a string who pass this way, we increment 1 to mark the event
        size++;

        char current = s.charAt(index);
        NodeTrie child = getNodeTrie(current);
        if (child == null) {
            child = new NodeTrie();
            setNodeTrie(current,child);
        }
        child.add(s, index + 1);
    }

    public int findCount(String s, int index) {
        if (index == s.length()) {
            return size;
        }
        NodeTrie child = getNodeTrie(s.charAt(index));
        if (child == null) {
            return 0;
        }
        return findCount(s, index + 1);
    }

}
