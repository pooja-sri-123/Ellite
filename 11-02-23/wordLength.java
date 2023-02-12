class Pair{
    String first;
    int second;
    Pair(String first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q =new LinkedList<>();
        q.add(new Pair(beginWord,1));
        Set<String> st = new HashSet<String>();
        int n= wordList.size();
        for(int i=0;i<n;i++){
            st.add(wordList.get(i));
        }
        st.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int count = q.peek().second;
            q.remove();
            if(word.equals(endWord)== true) return count;
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch <= 'z';ch++){
                    char original[] = word.toCharArray();
                    original[i] = ch;
                    String replacedWord = new String(original);
                    
                    if(st.contains(replacedWord) == true){
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord,count+1));
                    }
                }
            }
        }
        return 0;
    }
}
