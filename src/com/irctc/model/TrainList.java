package com.irctc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="train_details_table")
public class TrainList {
	
	@Id
	@GeneratedValue
	@JoinColumn(name="train_id") 
	private int train_id;
	
	@Column(name="from_station")	
	private String from_station;
	
	@Column(name="to_station")	
	private String to_station;
	
	@Column(name="journey_date")	
	private String journey_date;
	
	@Column(name="train_no")	
	private String train_no;
	
	@Column(name="train_name")	
	private String train_name;
	
	@Column(name="distance")	
	private String distance;
	
	@Column(name="first_class_ac" )	
	private int oneA;
	
	@Column(name="second_class_ac")	
	private int twoA;
	
	@Column(name="third_class_ac")	
	private int threeA;
	
	@Column(name="SL")	
	private int sl;
	
	@Column(name="first_class_ac_wl")	
	private int oneAWL;
	
	@Column(name="second_class_ac_wl")	
	private int twoAWL;
	
	@Column(name="third_class_ac_wl")	
	private int threeAWL;
	
	@Column(name="SL_WL")	
	private int slWL;

	public int getTrain_id() {
		return train_id;
	}

	public void setTrain_id(int train_id) {
		this.train_id = train_id;
	}

	public String getFrom_station() {
		return from_station;
	}

	public void setFrom_station(String from_station) {
		this.from_station = from_station;
	}

	public String getTo_station() {
		return to_station;
	}

	public void setTo_station(String to_station) {
		this.to_station = to_station;
	}

	public String getJourney_date() {
		return journey_date;
	}

	public void setJourney_date(String journey_date) {
		this.journey_date = journey_date;
	}

	public String getTrain_no() {
		return train_no;
	}

	public void setTrain_no(String train_no) {
		this.train_no = train_no;
	}

	public String getTrain_name() {
		return train_name;
	}

	public void setTrain_name(String train_name) {
		this.train_name = train_name;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public int getOneA() {
		return oneA;
	}

	public void setOneA(int oneA) {
		this.oneA = oneA;
	}

	public int getTwoA() {
		return twoA;
	}

	public void setTwoA(int twoA) {
		this.twoA = twoA;
	}

	public int getThreeA() {
		return threeA;
	}

	public void setThreeA(int threeA) {
		this.threeA = threeA;
	}

	public int getSl() {
		return sl;
	}

	public void setSl(int sl) {
		this.sl = sl;
	}

	public int getOneAWL() {
		return oneAWL;
	}

	public void setOneAWL(int oneAWL) {
		this.oneAWL = oneAWL;
	}

	public int getTwoAWL() {
		return twoAWL;
	}

	public void setTwoAWL(int twoAWL) {
		this.twoAWL = twoAWL;
	}

	public int getThreeAWL() {
		return threeAWL;
	}

	public void setThreeAWL(int threeAWL) {
		this.threeAWL = threeAWL;
	}

	public int getSlWL() {
		return slWL;
	}

	public void setSlWL(int slWL) {
		this.slWL = slWL;
	}
	
	
}


