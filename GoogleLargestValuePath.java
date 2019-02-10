import java.util.*;

class LVP {

	public String s;

	public Map<Integer, Character> nodes;
	public Map<Integer, HashSet<Integer>> edges;
	public Set<Integer> visitedNodes;

	public LVP(String s, int[][] path){
		this.s = s;

		this.nodes = new HashMap<Integer, Character>();
		for(int i = 0; i < s.length(); i++){
			this.nodes.put(i, s.charAt(i));
		}

		this.edges = new HashMap<Integer, HashSet<Integer>>();
		for(int j = 0; j < path.length; j++){
			int start = path[j][0];
			int end = path[j][1];
			if(this.edges.containsKey(start)){
				this.edges.get(start).add(end);
			}else{
				this.edges.put(start, new HashSet<Integer>(Collections.singletonList(end)));
			}
		}
	}

	public int numNodes(){
		return this.nodes.size();
	}

	public int numEdges(){
		return this.edges.size();
	}

	public int getPaths(int n, Set<Integer> visited, Map<Character, Integer> values){
		if(visited.contains(n)){
			return -1;
		}
		
		visited.add(n);

		char c = nodes.get(n);
		if(values.containsKey(c)){
			values.put(c, values.get(c)+1);
		}else{
			values.put(c, 1);
		}

		int max = 0;
		if(!this.edges.containsKey(n)){ 
			Iterator<Integer> iterValues = values.values().iterator();
			while(iterValues.hasNext()){
				int value = iterValues.next();
				if(value > max){
					max = value;
				}
			}
		}else{
			Iterator<Integer> outs = this.edges.get(n).iterator();
			while(outs.hasNext()){
				int out = outs.next();
				int val = getPaths(out, visited, values);
				if(val == -1){
					return -1;
				}
				if(val > max){
					max = val;
				}
			}

		}
		values.put(c, values.get(c)-1);
		visited.remove(n);
		return max;
	}

	public int getLargestValuePath(){
		//initialize visitedNodes
		this.visitedNodes = new HashSet<Integer>();

		// Set<Integer> remainingNodes = new HashSet<Integer>(this.nodes);

		int start = 0;
		int max = 0;
		// while(!remainingNodes.isEmpty()){
			int value = getPaths(start, new HashSet<Integer>(), new HashMap<Character, Integer>());
			if(value == -1){
				return -1;
			}
			if(value > max){
				max = value;
			}
		// }
		return max;

	}
}


public class GoogleLargestValuePath {
	public static void main(String[] args){
		String s = "ABACA";
		int[][] path = {{0, 1}, {0, 2}, {2, 3}, {3, 4}};

		LVP lvp = new LVP(s, path);
		System.out.println(lvp.getLargestValuePath());

		int[][] path2 = {{0, 0}};
		LVP lvp2 = new LVP("A", path2);
		System.out.println(lvp2.getLargestValuePath());
	}
}