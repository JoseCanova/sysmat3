package br.com.connemat.spring.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.web.access.expression.WebExpressionVoter;

public class ConnematAccessDecisionManager {

	private ConnematAccessDecisionManager() {
	}
	
	public static AccessDecisionManager forAffirmativeBased() {
		List<AccessDecisionVoter<?>> decisionVoters = new ArrayList<>();
		decisionVoters.add(new GenericRoleVoter());
		decisionVoters.add(new WebExpressionVoter());
		AffirmativeBased ab = new AffirmativeBased(decisionVoters);
		return ab;		
	}

	public static AccessDecisionManager forUnanimousBased() {
		List<AccessDecisionVoter<?>> decisionVoters = new ArrayList<>();
		decisionVoters.add(new GenericRoleVoter());
		decisionVoters.add(new WebExpressionVoter());
		UnanimousBased ab = new UnanimousBased(decisionVoters);
		return ab;		
	}

	
}
