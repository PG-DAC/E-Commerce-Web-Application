package com.netcom.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netcom.entities.Feedback;

public interface FeedbackDao extends JpaRepository<Feedback, Integer>{

	Feedback findByRating(Feedback newFeedback);
	
}
