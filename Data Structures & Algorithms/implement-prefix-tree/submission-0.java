class PrefixTree {

    static class TreeNode{
        TreeNode[] charArray;
        boolean end;
        // char charValue;

        TreeNode(TreeNode[] charArray){
            this.charArray = charArray;
        }

    }

    TreeNode rootNode;

    public PrefixTree() {
         TreeNode[] charArray = new TreeNode[26];
         TreeNode rootNode = new TreeNode(charArray); 
         this.rootNode = rootNode;
    }

    public void insert(String word) {
        // if(rootNode.charValue == '0'){
        //     rootNode.charValue = word.charAt(0);
        // }
        TreeNode traverseNode = rootNode;

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(traverseNode.charArray[ch - 'a']==null){
                TreeNode newNode = new TreeNode(new TreeNode[26]);
                traverseNode.charArray[ch - 'a'] = newNode;
            }
            traverseNode = traverseNode.charArray[ch - 'a'];
        }

        traverseNode.end = true;

    }

    public boolean search(String word) {
        TreeNode traverseNode = rootNode;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(traverseNode.charArray[ch - 'a']==null) return false;
            traverseNode = traverseNode.charArray[ch - 'a'];
        }
        if(traverseNode.end) return true;
        return false;
    }

    public boolean startsWith(String prefix) {
        TreeNode traverseNode = rootNode;
        for(int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(traverseNode.charArray[ch - 'a']==null) return false;
            traverseNode = traverseNode.charArray[ch - 'a'];
        }
        return true;
    }
}
