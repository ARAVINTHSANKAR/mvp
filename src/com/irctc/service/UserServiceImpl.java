package com.irctc.service;

import java.util.List;

import org.codehaus.jettison.json.JSONException;

import com.irctc.dao.UserDao;
import com.irctc.dao.UserDaoImpl;
import com.irctc.model.TrainList;
import com.irctc.model.TravellerDetails;
import com.irctc.model.TravellerDetailsCpy;
import com.irctc.model.User;

public class UserServiceImpl implements UserService{
	
	UserDao userDao = new UserDaoImpl();

	@Override
	public String loginUser(User userModel) throws Exception {
	
		return userDao.loginUser(userModel);
	}

	@Override
	public List<TrainList> getTrainDetails(TrainList trainListModel) {
		
		return userDao.getTrainDetails(trainListModel);
	}

	@Override
	public String addUser(User adduser) {
		
		return userDao.addUser(adduser);
	}

	@Override
	public List<TravellerDetails> travellerDetails() {
		
		return userDao.travellerDetails();
	}

/*	@Override
	public String saveTravellerDetails(TravellerDetails traveller) throws JSONException {
		
		return userDao.saveTravellerDetails(traveller);
	}*/

/*	@Override
	public String saveTravellerDetails(TravellerDetailsCpy travellercpy) throws JSONException {
		
		return userDao.saveTravellerDetails(travellercpy);
	}*/
	
	@Override
	public String saveTravellerDetails(TravellerDetails traveller) throws JSONException {
		
		return userDao.saveTravellerDetails(traveller);
	}
	
	
	@Override
	public List<TravellerDetails> getBookedTickets(TravellerDetails userObj) {

		return userDao.getBookedTickets(userObj);
	}

	@Override
	public String cancelTicket(TravellerDetailsCpy travellerDetailsDelete) throws JSONException {
		
		return userDao.cancelTicket(travellerDetailsDelete);
	}

	}

