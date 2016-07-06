package VO;

public class UsersTableVO {
		private String user_fname;
		private String user_lname;
		private String user_email;
		private String status;
		private int NUMBER_SENSORS;
		public String getUser_fname() {
			return user_fname;
		}
		public void setUser_fname(String user_fname) {
			this.user_fname = user_fname;
		}
		public String getUser_lname() {
			return user_lname;
		}
		public void setUser_lname(String user_lname) {
			this.user_lname = user_lname;
		}
		public String getUser_email() {
			return user_email;
		}
		public void setUser_email(String user_email) {
			this.user_email = user_email;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public int getNUMBER_SENSOR() {
			return NUMBER_SENSORS;
		}
		public void setNUMBER_SENSOR(int nUMBER_SENSOR) {
			NUMBER_SENSORS = nUMBER_SENSOR;
		}
		
		
}
