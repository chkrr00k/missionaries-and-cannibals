package chkrr00k.ai;

import aima.core.search.framework.SearchAgent;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.qsearch.GraphSearch;
import aima.core.search.framework.qsearch.TreeSearch;
import aima.core.search.uninformed.BreadthFirstSearch;
import aima.core.search.uninformed.DepthFirstSearch;
import chkrr00k.ai.model.State;

public class Main {
	public static void main(String[] args) {
		State s = new State(3, 3, true);
		Problem p = new Problem(s, new AF(), new RF(), s, s);
		SearchAgent sa = null;
		
		BreadthFirstSearch bfs = new BreadthFirstSearch(new GraphSearch());
		try{
			sa = new SearchAgent(p, bfs);		
			System.out.println(sa.getActions());
			System.out.println(sa.getInstrumentation());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		bfs = new BreadthFirstSearch(new TreeSearch());
		try{
			sa = new SearchAgent(p, bfs);		
			System.out.println(sa.getActions());
			System.out.println(sa.getInstrumentation());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
