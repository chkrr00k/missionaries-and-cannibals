package chkrr00k.ai;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;
import aima.core.search.framework.problem.ResultFunction;
import chkrr00k.ai.model.State;

public class RF implements ResultFunction {

	@Override
	public Object result(Object arg0, Action arg1) {
		if(arg0 instanceof State && arg1 instanceof DynamicAction){
			State s = (State) arg0;
//			System.out.println(s);
			switch(((DynamicAction)arg1).getName()){
			case "MM":
				if(s.isB()){//west
					return new State(s.getWc(), s.getWm() - 2, false);
				}else{//east
					return new State(s.getWc(), s.getWm() + 2, true);
				}
			case "CC":
				if(s.isB()){//west
					return new State(s.getWc() - 2, s.getWm(), false);
				}else{//east
					return new State(s.getWc() + 2, s.getWm(), true);
				}
			case "M":
				if(s.isB()){//west
					return new State(s.getWc(), s.getWm() - 1, false);
				}else{//east
					return new State(s.getWc(), s.getWm() + 1, true);
				}
			case "C":
				if(s.isB()){//west
					return new State(s.getWc() - 1, s.getWm(), false);
				}else{//east
					return new State(s.getWc() + 1, s.getWm(), true);
				}
			case "MC":
				if(s.isB()){//west
					return new State(s.getWc() - 1, s.getWm() - 1, false);
				}else{//east
					return new State(s.getWc() + 1, s.getWm() + 1, true);
				}
			default:
				return null;
			}
		}else{
			throw new IllegalArgumentException();
		}
	}



}
