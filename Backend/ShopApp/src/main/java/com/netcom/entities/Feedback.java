package com.netcom.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Feedback")
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feedbackId;
	private String feebackDescription;
	private int rating;
//	private int productId;
//	private int userId;
//
	
	public Feedback() {
		super();
	}

	public Feedback(int feedbackId, String feebackDescription, int rating) {
		super();
		this.feedbackId = feedbackId;
		this.feebackDescription = feebackDescription;
		this.rating = rating;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeebackDescription() {
		return feebackDescription;
	}

	public void setFeebackDescription(String feebackDescription) {
		this.feebackDescription = feebackDescription;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", feebackDescription=" + feebackDescription + ", rating="
				+ rating + "]";
	}
	
}

