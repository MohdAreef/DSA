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


//CLEAN CODE 
class Node {
    Node[] arr;
    boolean flag;

    Node() {
        arr = new Node[26];
        flag = false;
    }

    boolean containsKey(char c) {
        return arr[c - 'a'] == null ? false : true;
    }

    Node getNext(char c) {
        return arr[c - 'a'];
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
            if (curr.containsKey(word.charAt(i)) == false) {
                Node temp = new Node();
                curr.arr[word.charAt(i) - 'a'] = temp;
            }
            curr = curr.getNext(word.charAt(i));
        }
        curr.flag = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.containsKey(word.charAt(i)) == false)
                return false;

            curr = curr.getNext(word.charAt(i));
        }

        return curr.flag;

    }

    public boolean startsWith(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.containsKey(word.charAt(i)) == false)
                return false;
            curr = curr.getNext(word.charAt(i));
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
