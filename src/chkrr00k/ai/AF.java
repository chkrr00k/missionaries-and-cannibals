package chkrr00k.ai;

import java.util.HashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;
import aima.core.search.framework.problem.ActionsFunction;
import chkrr00k.ai.model.State;

public class AF implements ActionsFunction {

	@Override
	public Set<Action> actions(Object arg0) {
		if(arg0 instanceof State){
			State s = (State) arg0;
			Set<Action> result = new HashSet<Action>();
			int wc = s.getWc(), wm = s.getWm(), ec = 3 - s.getWc(), em = 3 - s.getWm(), tc = 3, tm = 3;
			if(s.isB()){ // boat on west
				// MM
				if(wc >= 2 && (wm == 2 || wm - 2 >= wc) && em + 2 >= ec){ // there are at least 2 missionars
					result.add(new DynamicAction("MM"));
				}
				// CC
				if(wc >= 2 && (em == 0 || em >= ec + 2)){ // there are at least 2 canniablas
					result.add(new DynamicAction("CC"));
				}
				// M
				if(wm >= 1 && (wm == 1 || wm - 1 >= wc) && em + 1 >= ec){ // there are at least 1 missionars
					result.add(new DynamicAction("M"));
				}
				// C
				if(wc >= 1 && (em == 0 || em >= ec + 1)){ // there are at least 1 canniablas
					result.add(new DynamicAction("C"));
				}
				// MC
				if(wc >= 1 && wm >= 1){ // there are at least 2 missionars
					result.add(new DynamicAction("MC"));
				}
			}else{//boat on east
				// MM
				if(em >= 2 && (em == 2 || em - 2 >= ec) && wm + 2 >= wc){ // there are at least 2 missionars
					result.add(new DynamicAction("MM"));
				}
				// CC
				if(ec >= 2 && (wm == 0 || wm >= wc + 2)){ // there are at least 2 canniablas
					result.add(new DynamicAction("CC"));
				}
				// M
				if(em >= 1 && (em == 1 || em - 1 >= ec) && wm + 1 >= wc){ // there are at least 1 missionars
					result.add(new DynamicAction("M"));
				}
				// C
				if(ec >= 1 && (wm == 0 || wm >= wc + 1)){ // there are at least 1 canniablas
					result.add(new DynamicAction("C"));
				}
				// MC
				if(em >= 1 && wm >= 1){ // there are at least 2 missionars
					result.add(new DynamicAction("MC"));
				}
			}
//			System.out.println(s.isB() + " " + result);
			return result;
		}else{
			throw new IllegalArgumentException();
		}
	}

}
