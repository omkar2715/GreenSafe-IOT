package food.com.services;

public class UserInfo {
	
	static String Email,vehicle_no;
	
	public static String getVehicle_no() {
		return vehicle_no;
	}

	public static void setVehicle_no(String vehicle_no) {
		UserInfo.vehicle_no = vehicle_no;
	}

	static int Id;

	public static String getEmail() {
		return Email;
	}

	public static void setEmail(String email) {
		Email = email;
	}

	public static int getId() {
		return Id;
	}

	public static void setId(int id) {
		Id = id;
	}
	
	
	

}
