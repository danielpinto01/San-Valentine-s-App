package models;

public class User {

	private String nameUser;
	private String genderUser;
	private String ageUser;
	private String favoriteColor;
	private String loveAnimals;
	private String cityLive;
	private int idUser;
	private static int countUser;
	private String imageUser;

	public User(String nameUser, String genderUser, String ageUser, String favoriteColor, String loveAnimals, String cityLive, String imageUser) {
		this.idUser = ++countUser;
		this.nameUser = nameUser;
		this.genderUser = genderUser;
		this.ageUser = ageUser;
		this.favoriteColor = favoriteColor;
		this.loveAnimals = loveAnimals;
		this.cityLive = cityLive;
		this.imageUser = imageUser;
	}		
	
	public String getImageUser() {
		return imageUser;
	}

	public int getIdUser() {
		return idUser;
	}

	public String getNameUser() {
		return nameUser;
	}

	public String getGenderUser() {
		return genderUser;
	}

	public String getAgeUser() {
		return ageUser;
	}

	public String getFavoriteColor() {
		return favoriteColor;
	}

	public String getLoveAnimals() {
		return loveAnimals;
	}

	public String getCityLive() {
		return cityLive;
	}

	@Override
	public String toString() {
		return "User [nameUser=" + nameUser + ", genderUser=" + genderUser + ", ageUser=" + ageUser + ", favoriteColor="
				+ favoriteColor + ", loveAnimals=" + loveAnimals + ", cityLive=" + cityLive + ", idUser=" + idUser
				+ ", imageUser=" + imageUser + "]";
	}
}