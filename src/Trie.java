import java.util.*;
class Node{
    Node[] links = new Node[26];
    boolean flag=false;
    Node(){

    }
    //Check if node contains key ch
    public boolean containsKey(char ch){
        return (links[ch-'a']!=null);
    }
    //Put the character in trie
    void put(char ch,Node node){
        links[ch-'a'] = node;
    }
    //Return where the character node  is pointing to.
    Node get(char ch){
        return links[ch-'a'];
    }
    void setEnd(){
        flag=true;
    }
    boolean IsEnd(){
        return flag;
    }

}
    public class Trie{
        private  Node root;
        Trie(){
            root = new Node();
        }
        public void insertWord(String word){
            Node node = root;
            for(int i=0;i<word.length();i++){
                if(!node.containsKey(word.charAt(i))){
                    node.put(word.charAt(i),new Node());
                }
                //Move to the reference trie
                node.get(word.charAt(i));
            }
            //Mark the end of the word
            node.setEnd();
        }

        public boolean searchWord(String word){
            Node node = root;
            for(int i=0;i<word.length();i++){
                if(!node.containsKey(word.charAt(i))){
                    return false;
                }
                node.get(word.charAt(i));
            }
            if(node.IsEnd()==true){
                return true;
            }
            return false;
        }

        public boolean startsWith(String prefix){
            Node node = root;
            for(int i=0;i<prefix.length();i++){
                if(!node.containsKey(prefix.charAt(i))){
                    return false;
                }
                node.get(prefix.charAt(i));
            }
            return true;
        }


    public static void main(String[] args) throws Exception {
        boolean var=true;
        Trie trie = new Trie();
        while(var){
            System.out.println("1 : Insert\n 2 : Search a word\n 3 : StartsWith \n");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter choice : ");
            int choice = Integer.parseInt(sc.nextLine());
            System.out.println("Enter word: ");
            String word = sc.nextLine();
            switch(choice){
                case 1: 
                    trie.insertWord(word);
                    System.out.println("Word inserted successfully!");
                    break;
                case 2:
                    System.out.println("Is word in trie ? "+trie.searchWord(word));
                    break;
                case 3:
                    System.out.println(trie.startsWith(word));
                    break;
                default:
                    System.out.println("Wrong choice.");
                    var=false;
                    sc.close();
                    
    
            }
        }
        
    }
}
