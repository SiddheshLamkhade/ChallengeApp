package com.example.ChallengeApp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class ChallengeService {

	private List<Challenge> challenges = new ArrayList<>();
	
	private Long nextId=1L;
	
	public ChallengeService() {
		Challenge challenge1 = new Challenge(1L, "jan", "Learning new programming language");
		challenges.add(challenge1);
	}
	
	public List<Challenge> getAllChallenges() {
		return challenges;
	}
	
	public boolean addChallenge(Challenge challenge) {
		if(challenge != null) {
			challenge.setId(nextId++);
			challenges.add(challenge);
			return true;
		}
		else {
			return false;
		}
	}

	public Challenge getChallenge(String month) {
		for (Challenge challenge : challenges) {
			if(challenge.getMonth().equals(month)) {
				return challenge;
			}
		}
		return null;
	}

	public boolean updateChallenge(Long id, Challenge updatedChallenge) {
		for (Challenge challenge : challenges) {
			if(challenge.getId().equals(id)) {
				challenge.setMonth(updatedChallenge.getMonth());
				challenge.setDescription(updatedChallenge.getDescription());
				return true;
			}
		}
		return false;
	}

	public boolean deleteChallenge(Long id) {
		return challenges.removeIf( challenge-> challenge.getId().equals(id));
		//removeIf is method available in List interface 
		//challenge->challenge.getId().equals(id) ....is Lambda expression (short-cut function)
		//It checks: "For each challenge, check if its id equals the given id"
		//equal method returns true
		//....
		//return challenges.removeIf(true or false);
		//challenge-> challenge.getId().equals(id) ......equals return true or false
	}

}
















