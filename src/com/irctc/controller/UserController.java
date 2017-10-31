package com.irctc.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.multipart.FormDataParam;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.irctc.model.TrainList;
import com.irctc.model.TravellerDetails;
import com.irctc.model.TravellerDetailsCpy;
import com.irctc.model.User;
import com.irctc.service.UserService;
import com.irctc.service.UserServiceImpl;


@Path("/booking")
public class UserController {
	
	UserService userService = new UserServiceImpl();
	
	@Path("/login")
	@GET
	@Produces("application/json")
	public String loginUser(
			@QueryParam("Email") String email,
			@QueryParam("Password") String password) throws Exception 
	{
		User userModel =new User();
		
		userModel.setEmail(email);
		userModel.setPassword(password);
		
		return userService.loginUser(userModel);
	}
	
	
	@Path("/add")
	@GET
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces("text/html")
	public String add(
			@QueryParam("Name")String name,
			@QueryParam("Email") String email,
			@QueryParam("Password") String password) 
	{
		User adduser=new User();
		
		adduser.setName(name);
		adduser.setEmail(email);
		adduser.setPassword(password);
		
		return userService.addUser(adduser);
	}
	
	
	@Path("/getTrainDetails")
	@GET
	@Produces("application/json")
	public List<TrainList> trainDetails(
			@QueryParam("From") String from_station,
			@QueryParam("To") String to_station,
			@QueryParam("Date") String date)
	{
		TrainList trainListModel =new TrainList();
		
		trainListModel.setFrom_station(from_station);
		trainListModel.setTo_station(to_station);
		trainListModel.setJourney_date(date);
		
		return userService.getTrainDetails(trainListModel);
	}
	
	
/*	@Path("/addTravellerDetails")
	@POST
	@Consumes("application/json")
	public String saveTravellerDetails(TravellerDetails traveller) throws JSONException 
	{	
		return userService.saveTravellerDetails(traveller);
	}DElete the package name
	*/
	
/*	@Path("/addTravellerDetails")
	@POST
	@Consumes("application/json")
	public String saveTravellerDetails(TravellerDetailsCpy travellercpy) throws JSONException 
	{	
		return userService.saveTravellerDetails(travellercpy);
	}*/
	
	@Path("/addTravellerDetails")
	@POST
	@Consumes("application/json")
	public String saveTravellerDetails(TravellerDetails traveller) throws JSONException 
	{	
		return userService.saveTravellerDetails(traveller);
	}
	
	
	@Path("/getBookedTickets")
	@GET
	@Produces("application/json")
	public List<TravellerDetails> getBookedTickets(
			@QueryParam("id") int age
			)
				
	{
		TravellerDetails userObj = new TravellerDetails();
		userObj.setAge(age);
		return userService.getBookedTickets(userObj);
	}
	
	@Path("/cancelTicket")
	@GET
	@Produces("application/json")
	public String cancelTicket(@QueryParam("id") int user_id) throws JSONException
	{
		TravellerDetailsCpy travellerDetailsDelete = new TravellerDetailsCpy();
		travellerDetailsDelete.setUser_id(user_id);
		return userService.cancelTicket(travellerDetailsDelete);
	}
	

}
