import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;

public class StringTransformation {
    static String[] string_transformation(String[] words, String start, String stop) {
        
        Set<String> allWords = new HashSet<>();
        Collections.addAll(allWords, words);
        allWords.add(start);
        allWords.add(stop);
        Map<String, List<String>> map = createGraph(allWords);
        
        List<String> path = findPath(map, start, stop);
        
        if(path.size()==0)
            return new String[]{"-1"};
        String[] result = new String[path.size()];
        int i=0;
        for(String s : path)
            result[i++]=s;
        return result;
    }
    static List<String> findPath(Map<String,List<String>> map, String start, String stop){
        List<String> path = new LinkedList<>();
        Stack<String> st = new Stack<>();
        Map<String, Integer> visited = new HashMap<>();
        int min = Integer.MAX_VALUE;
        st.push(start);
        visited.put(start,0);
        while(!st.isEmpty()) {
        	String top = st.peek();
        	List<String> neighbors = map.get(top);
        	if(neighbors.contains(stop)) {
        		st.push(stop);
        		if(st.size()<min) {
        			path = readStack(st);
        			min = path.size();
        		}
        		st.pop();
        	}
        	else if(st.size()<min) {
        		for(String s : neighbors) {
        			if(visited.getOrDefault(s, Integer.MAX_VALUE) > st.size()) {
        				st.push(s);
        				visited.put(s, st.size()-1);
        				break;
        			}	
        		}
        	}
        	if(st.peek().equals(top)) 
        		st.pop();
        }
        return path;
    }
    static List<String> readStack(Stack<String> stack){
    	List<String> list = new ArrayList<>();
    	for(int i=0;i<stack.size();i++) {
    		list.add(stack.get(i));
    	}
    	return list;
    }
    static Map<String,List<String>> createGraph(Set<String> words){
        Map<String,List<String>> map = new HashMap<>();
        for(String key: words){
            if(!map.containsKey(key)){
                List<String> list = new LinkedList<>();
                //for(int j=0;j<words.size();j++){
                	//String w = words.get(j);
                for(String w : words) {
                    if(!w.equals(key) && difference(key, w)==1 && !list.contains(w))
                        list.add(w);
                }
                map.put(key,list);
            }
        }
        return map;
    }
    static int difference(String s1, String s2){
        int dif = 0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i))
                dif++;
        }
        return dif;
    }
    
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
        int wordsSize = Integer.parseInt(scan.nextLine().trim());
        String[] words = new String[wordsSize];

        for (int wordsItr = 0; wordsItr < wordsSize; wordsItr++) {
            String wordsItem = scan.nextLine();
            words[wordsItr] = wordsItem;

        }
        String start = scan.nextLine();
        String stop = scan.nextLine();
    	String[] path  = string_transformation(words,start, stop);
    	for(String s: path) {
    		System.out.println(s);
    	}
    }
    

}
