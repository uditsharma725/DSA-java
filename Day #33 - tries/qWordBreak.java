import java.util.*;

public class qWordBreak {

    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        Node() {
            for(int i=0; i<26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();
    public static void insert(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static boolean search(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null) return false;
            curr = curr.children[idx];
        }

        return curr.eow == true;
    }

    public static boolean wordBreak(String key) {
        if(key.length() == 0) return true;

        for(int i=1; i<=key.length(); i++) {
            if(search(key.substring(0,i))
            && wordBreak(key.substring(i))) return true;
        }

        return false;
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        try {

            String words[] = {"i", "like", "sam", "samsung", "mobile", "ice"};
            for(int i=0; i<words.length; i++) insert(words[i]);

            String key1 = "ilikesamsung";
            String key2 = "ilikesamsun";
            System.out.println(wordBreak(key1));
            System.out.println(wordBreak(key2));

        } finally {
            sc.close();
        }

    }
}