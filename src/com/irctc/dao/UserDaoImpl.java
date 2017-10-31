package com.irctc.dao;

import com.irctc.model.TrainList;
import com.irctc.model.TravellerDetails;
import com.irctc.model.TravellerDetailsCpy;
import com.irctc.model.User;
import com.irctc.util.HibernateUtil;

import sun.util.calendar.BaseCalendar.Date;

import java.lang.reflect.Array;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

//import javax.ws.rs.core.Response;

import java.util.List;

import com.irctc.dao.UserDao;

public class UserDaoImpl implements UserDao {

	String loginEmail;
	String loginPassword;
	String dbPasswords;
	
	HibernateUtil hibernateUtil = new HibernateUtil();
	
	@Override
	public String loginUser(User userModel) throws Exception {
		
		loginEmail = userModel.getEmail();
		loginPassword = userModel.getPassword().toString().trim();
		hibernateUtil.openCurrentSession();
		List<User> user_records =(List<User>)hibernateUtil.getCurrentSession().createQuery("from User where email=  '"+loginEmail+"'").list();
		
		
		dbPasswords = user_records.get(0).getPassword().trim().toString();
		int dbId = user_records.get(0).getLogin_id();
		String dbName = user_records.get(0).getName().toString();
		String dbEmail =user_records.get(0).getEmail().toString();
		String dbPassword =user_records.get(0).getPassword().toString();
		
		
		hibernateUtil.closeCurrentSession();
		String response="";
		JSONObject jsonObject = new JSONObject();
		
		 if(loginPassword.equalsIgnoreCase(dbPasswords)) {

			jsonObject.put("Status", "Success");
			jsonObject.put("x", "0");
			jsonObject.put("dbName", dbName);
			jsonObject.put("dbId", dbId);
			jsonObject.put("dbEmail" , dbEmail);
			jsonObject.put("dbPassword" , dbPassword);
			response = jsonObject.toString();
		}
		else {
			jsonObject.put("Status","Failure");		
			jsonObject.put("x", 1);
			jsonObject.put("dbName", dbName);
			jsonObject.put("dbId", dbId);
			jsonObject.put("dbEmail" , dbEmail);
			jsonObject.put("dbPassword" , dbPassword);
			response = jsonObject.toString();
		}
		return response;
	}	

	@Override
	public List<TrainList> getTrainDetails(TrainList trainListModel) {
		
		String fromStation = trainListModel.getFrom_station();
		String toStation = trainListModel.getTo_station();
		String journeyDate = trainListModel.getJourney_date();
		
		System.out.println(journeyDate);
		
		hibernateUtil.openCurrentSession();
		List<TrainList> train_records = (List<TrainList>)hibernateUtil.getCurrentSession().createQuery("from TrainList where from_station= '"+fromStation+"' and to_station = '"+toStation+"' and journey_date= '"+journeyDate+"'").list();
		hibernateUtil.closeCurrentSession();	
		return train_records;	
	}

	@Override
	public String addUser(User adduser) {
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().save(adduser);
		hibernateUtil.closeCurrentSessionwithTransaction();
		return "User record saved successfully";
	}

	@Override
	public List<TravellerDetails> travellerDetails() {
		hibernateUtil.openCurrentSession();
		List<TravellerDetails> travelDetails = (List<TravellerDetails>)hibernateUtil.getCurrentSession().createQuery("from TravellerDetails where gender = 'Male'").list();
		hibernateUtil.closeCurrentSession();	
		return travelDetails;
	}

	/*@Override
	public String saveTravellerDetails(TravellerDetails traveller) throws JSONException {
		
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().saveOrUpdate(traveller);
		
//		String trainId = traveller.getTrain_id().toString();
		

//		hibernateUtil.getCurrentSession().createQuery("from TrainList SET first_class_ac = first_class_ac + 1 WHERE train_id = '"+trainId+"'");
//		hibernateUtil.getCurrentSession().createSQLQuery("UPDATE trin_details_table SET first_class_ac = first_class_ac+1 WHERE train_id = '"+trainId+"'");
		hibernateUtil.closeCurrentSessionwithTransaction();
		
		String response="";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Status", "Success");
		response = jsonObject.toString();
		return response;
	}*/

	
/*	@Override
	public String saveTravellerDetails(TravellerDetailsCpy travellercpy) throws JSONException {
		
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().save(travellercpy);
		hibernateUtil.closeCurrentSessionwithTransaction();
		
		String response="";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Status", "Success");
		response = jsonObject.toString();
		return response;
	}*/
	
	@Override
	public String saveTravellerDetails(TravellerDetails traveller) throws JSONException {
		
		TravellerDetails newTraveller = new TravellerDetails();
		
		newTraveller.setUser_id(traveller.getUser_id());
		newTraveller.setLogin_id(traveller.getLogin_id());
		newTraveller.setTrain_id(traveller.getTrain_id());
		newTraveller.setUser_name(traveller.getUser_name());
		newTraveller.setAge(traveller.getAge());
		newTraveller.setGender(traveller.getGender());
		newTraveller.setContact(traveller.getContact());
		newTraveller.setNationality(traveller.getNationality());		
		
		hibernateUtil.openCurrentSessionwithTransaction();
		
		String loginid = traveller.getLogin_id().toString();
		loginid.trim();
		int loginId = Integer.parseInt(loginid);
		
		String trainid = traveller.getTrain_id().toString();
		trainid.trim();
		int trainId = Integer.parseInt(trainid);
		
		User user;
		user = (User) hibernateUtil.getCurrentSession().createQuery("from User where login_id = '"+loginId+"'");
		
		newTraveller.setLogin_id(user);
			
		TrainList train;
		train = (TrainList) hibernateUtil.getCurrentSession().createQuery("from TrainList where train_id = '"+trainId+"'");
		newTraveller.setTrain_id(train);
		
		hibernateUtil.getCurrentSession().save(newTraveller);
		hibernateUtil.closeCurrentSessionwithTransaction();
		
		String response="";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Status", "Success");
		response = jsonObject.toString();
		return response;
	}
	
	
	
	
	
	@Override
	public List<TravellerDetails> getBookedTickets(TravellerDetails userObj) {
		int id = userObj.getAge();
		hibernateUtil.openCurrentSession();
		List<TravellerDetails> ticket_records =(List<TravellerDetails>)hibernateUtil.getCurrentSession().createQuery("from TravellerDetails where login_id = '"+id+"'").list();
		hibernateUtil.closeCurrentSession();
		return ticket_records;

	}

	@Override
	public String cancelTicket(TravellerDetailsCpy travellerDetailsDelete) throws JSONException {
		int id = travellerDetailsDelete.getUser_id();
		hibernateUtil.openCurrentSessionwithTransaction();
		
//		hibernateUtil.getCurrentSession().update("delete from TravellerDetails where user_id = '5'");
//		hibernateUtil.getCurrentSession().executeUpdate("delete from TravellerDetailsCpy where user_id = '5'");

		TravellerDetails cancelTraveller = new TravellerDetails(); 
		
		cancelTraveller = (TravellerDetails) hibernateUtil.getCurrentSession().createQuery("from TravellerDetails where user_id = '"+id+"'");
		
		hibernateUtil.getCurrentSession().delete(cancelTraveller);
		deleteById(cancelTraveller.class, new Long(41));
		hibernateUtil.closeCurrentSessionwithTransaction();
		String response="";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Status", "Success");
		response = jsonObject.toString();
		return response;
	}
}
