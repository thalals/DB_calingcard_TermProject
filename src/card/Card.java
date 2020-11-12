package card;

import java.sql.Timestamp;
import java.util.Date;

public class Card {
	private int CardNumber;
	private int UserNumber;
	private int OrgNumber;
	private String Name;
	private String PhoneNumber;
	private String Team;
	private String Position;
	private String Email;
	private String Career;
	private String SaveDate;
	
	public int getCardNumber() {
		return CardNumber;
	}
	public void setCardNumber(int cardNumber) {
		CardNumber = cardNumber;
	}
	public int getUserNumber() {
		return UserNumber;
	}
	public void setUserNumber(int userNumber) {
		UserNumber = userNumber;
	}
	public int getOrgNumber() {
		return OrgNumber;
	}
	public void setOrgNumber(int orgNumber) {
		OrgNumber = orgNumber;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getTeam() {
		return Team;
	}
	public void setTeam(String team) {
		Team = team;
	}
	public String getPosition() {
		return Position;
	}
	public void setPosition(String position) {
		Position = position;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getCareer() {
		return Career;
	}
	public void setCareer(String career) {
		Career = career;
	}
	public String getSaveDate() {
		return SaveDate;
	}
	public void setSaveDate(String saveDate) {
		SaveDate = saveDate;
	}
	
}
