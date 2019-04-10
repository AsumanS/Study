
public class ColoringHouses {
	
	public static int minCost(int[][] costs) {
	    if(costs==null||costs.length==0)
	        return 0;
	 
	    for(int i=1; i<costs.length; i++){
	        costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
	        costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
	        costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
	    }
	 
	    int m = costs.length-1;
	    return Math.min(Math.min(costs[m][0], costs[m][1]), costs[m][2]);
	}
	
	public static void main(String[] args) {
		int[][] arr  = {{17,2,17},{16,16,5},{14,3,19},{3,5,7},{12,1,12}};
		
		System.out.println(minCost(arr));
	}

}
