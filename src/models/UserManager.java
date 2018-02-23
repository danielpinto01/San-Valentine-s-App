package models;

import java.util.ArrayList;

public class UserManager {

	private static final double NUMBER_ONE = 33.3;
	private ArrayList<User> userList;

	public UserManager(ArrayList<User> arrayList) {
		this.userList = arrayList;
	}

	public UserManager() {
		this.userList = new ArrayList<>();
	}

	public static User createUser(String nameUser, String genderUser, String ageUser, String favoriteColor, String loveAnimals, String cityLive, String imageUser){
		return new User(nameUser, genderUser, ageUser, favoriteColor, loveAnimals, cityLive, imageUser);
	}

	public User searchId(int id){
		for (User user : userList) {
			if(user.getIdUser() == id){
				return user;
			}
		}
		return null;
	}

	public double matchUserCity(User user, User actualUser){
		if(user.getCityLive().equals(actualUser.getCityLive())){
			return NUMBER_ONE;
		}else{
			return 0;
		}
	}

	public double matchUserLoveAnimals(User user, User actualUser){
		if(user.getLoveAnimals().equals(actualUser.getLoveAnimals())){
			return NUMBER_ONE;
		}else{
			return 0;
		}
	}

	public double matchUserFavoriteColor(User user, User actualUser){
		if(user.getFavoriteColor().equals(actualUser.getFavoriteColor())){
			return NUMBER_ONE;
		}else{
			return 0;
		}
	}

	public double matchUser(User user, User actualUser){
		return matchUserCity(user, actualUser) + matchUserLoveAnimals(user, actualUser) + matchUserFavoriteColor(user, actualUser);
	}

	public void addUserToList(User user){
		userList.add(user);
	}

	public ArrayList<User> getUserList(){
		return userList;
	}
}