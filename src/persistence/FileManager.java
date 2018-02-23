package persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import models.User;
import models.UserManager;

public class FileManager {
	
	public Element createElement(Document document, User user){
		Element element = document.createElement("user");
		Element name = document.createElement("name");
		name.setTextContent(user.getNameUser());
		element.appendChild(name);
		Element gender = document.createElement("gender");
		gender.setTextContent(user.getGenderUser());
		element.appendChild(gender);
		Element age = document.createElement("age");
		age.setTextContent(user.getAgeUser());
		element.appendChild(age);
		Element favoriteColor = document.createElement("favoriteColor");
		favoriteColor.setTextContent(user.getFavoriteColor());
		element.appendChild(favoriteColor);
		Element loveAnimals = document.createElement("loveAnimals");
		loveAnimals.setTextContent(user.getLoveAnimals());
		element.appendChild(loveAnimals);
		Element cityLive = document.createElement("cityLive");
		cityLive.setTextContent(user.getCityLive());
		element.appendChild(cityLive);
		Element image = document.createElement("image");
		image.setTextContent(user.getImageUser());
		element.appendChild(image);
		return element;
	}

	public void write(ArrayList<User> userList)  throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException{
		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		Element users = document.createElement("User");
		for (User user : userList) {
			Element element = createElement(document, user);
			users.appendChild(element);
		}
		document.appendChild(users);
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		transformer.transform(new DOMSource(document),new StreamResult("userlist.xml"));
	}

	public ArrayList<User> read() throws SAXException, IOException, ParserConfigurationException{
		ArrayList<User> userList = new ArrayList<>();
		File file = new File("userList.xml");
		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
		Element root = document.getDocumentElement();
		NodeList list = root.getElementsByTagName("user");
		for (int i = 0; i < list.getLength(); i++) {
			Element element = (Element) list.item(i);
			String nameUser = element.getElementsByTagName("name").item(0).getTextContent();
			String genderUser = element.getElementsByTagName("gender").item(0).getTextContent();
			String ageUser = element.getElementsByTagName("age").item(0).getTextContent();
			
			String favoriteColor = element.getElementsByTagName("favoriteColor").item(0).getTextContent();
			String loveAnimals = element.getElementsByTagName("loveAnimals").item(0).getTextContent();
			String cityLive = element.getElementsByTagName("cityLive").item(0).getTextContent();
			String imageUser = element.getElementsByTagName("image").item(0).getTextContent();
			userList.add(UserManager.createUser(nameUser, genderUser, ageUser, favoriteColor, loveAnimals, cityLive, imageUser));
		}
		return userList;
	}
}