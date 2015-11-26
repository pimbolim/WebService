package org.nuno.teste.messenger.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.nuno.teste.messenger.database.DatabaseClass;
import org.nuno.teste.messenger.model.Profile;


public class ProfileService {

	
	private Map<String,Profile> profiles = DatabaseClass.getProfiles();

	public ProfileService(){
		profiles.put("Nuno", new Profile(1L,"Nuno","Nuno","Alves"));
		profiles.put("teste", new Profile(2L,"teste","teste","teste"));
	}
	
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	 
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty()){return null;}
		
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName){
		
		return profiles.remove(profileName);
	}
}
