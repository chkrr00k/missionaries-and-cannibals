package chkrr00k.ai.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import aima.core.agent.Action;
import aima.core.search.framework.evalfunc.HeuristicFunction;
import aima.core.search.framework.problem.GoalTest;
import aima.core.search.framework.problem.StepCostFunction;

public class State implements GoalTest, StepCostFunction, HeuristicFunction {

	private int wc;
	private int wm;
	private boolean b;
	
	public State(int wc, int wm, boolean b) {
		if(wc > 3 || wc < 0 || wm > 3 || wm < 0){
			throw new IllegalArgumentException();
		}
		this.wc = wc;
		this.wm = wm;
		this.b = b;
	}

	public int getWc() {
		return this.wc;
	}
	public int getWm() {
		return this.wm;
	}
	public boolean isB() {
		return this.b;
	}

	@Override
	public double h(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double c(Object arg0, Action arg1, Object arg2) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public boolean isGoalState(Object arg0) {
		if(arg0 instanceof State){
			State s = (State) arg0;
			return s.getWc() == 0 && s.getWm() == 0 && !s.isB();
		}else{
			return false;
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("State [wc=");
		builder.append(this.wc);
		builder.append(", wm=");
		builder.append(this.wm);
		builder.append(", b=");
		builder.append(this.b);
		builder.append("]");
		return builder.toString();
	}

}
