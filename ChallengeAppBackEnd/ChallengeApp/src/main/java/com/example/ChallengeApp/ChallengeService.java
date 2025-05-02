package com.example.ChallengeApp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ChallengeService {
	private Long nextId=1L;
	
	//private List<Challenge> challenges = new ArrayList<>();
	@Autowired
	private ChallengeRepository repo; //migrating to database(with the Challenge class) not using list anymore
	
	
	
	public List<Challenge> getAllChallenges() {
		return repo.findAll();
	}
	
	public boolean addChallenge(Challenge challenge) {
		if(challenge != null) {
			challenge.setId(nextId++);
			repo.save(challenge);
			return true;
		}
		else {
			return false;
		}
	}

	public Challenge getChallenge(String month) {
		Optional<Challenge> challenge=repo.findByMonthIgnoreCase(month);
		return challenge.orElse(null);
		
	}

	public boolean updateChallenge(Long id, Challenge updatedChallenge) {
		Optional<Challenge> challenge=repo.findById(id);
		if(challenge.isPresent()) {//isPresent() this is a jpa method
			Challenge challengeToUpdate=challenge.get();//jpa methods
			challengeToUpdate.setMonth(updatedChallenge.getMonth());
			challengeToUpdate.setDescription(updatedChallenge.getDescription());
			repo.save(challengeToUpdate);
			return true;
		} else { //isPresent() this is a jpa method
			return false;
		}
	}

	public boolean deleteChallenge(Long id) {
		Optional<Challenge> challenge=repo.findById(id);
		if(challenge.isPresent()) {
			repo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
















