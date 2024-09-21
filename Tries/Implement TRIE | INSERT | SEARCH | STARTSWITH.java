class Node {
    Node[] arr;
    boolean flag;

    Node() {
        arr = new Node[26];
        flag = false;
    }
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.arr[word.charAt(i) - 'a'] == null) {
                Node temp = new Node();
                curr.arr[word.charAt(i) - 'a'] = temp;
            }
            curr = curr.arr[word.charAt(i) - 'a'];
        }
        curr.flag = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.arr[word.charAt(i) - 'a'] == null)
                return false;

            curr = curr.arr[word.charAt(i) - 'a'];
        }

        return curr.flag;

    }

    public boolean startsWith(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.arr[word.charAt(i) - 'a'] == null)
                return false;

            curr = curr.arr[word.charAt(i) - 'a'];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
