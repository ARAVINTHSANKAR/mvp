package com.irctc.dao;

import java.util.List;

import org.codehaus.jettison.json.JSONException;

import com.irctc.model.TrainList;
import com.irctc.model.TravellerDetails;
import com.irctc.model.TravellerDetailsCpy;
import com.irctc.model.User;

public interface UserDao<Employee_details> {

	public String loginUser(User userModel) throws Exception;

	public List<TrainList> getTrainDetails(TrainList trainListModel);
	
	public String addUser(User adduser);

	public List<TravellerDetails> travellerDetails();

//	public String saveTravellerDetails(TravellerDetails traveller) throws JSONException;
	
//	public String saveTravellerDetails(TravellerDetailsCpy travellercpy) throws JSONException;
	
	public String saveTravellerDetails(TravellerDetails traveller) throws JSONException;

	public List<TravellerDetails> getBookedTickets(TravellerDetails userObj);

	public String cancelTicket(TravellerDetailsCpy travellerDetailsDelete) throws JSONException;
}
