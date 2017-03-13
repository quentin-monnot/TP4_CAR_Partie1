package interfaceRMI;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.io.Serializable;

public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2165406439522671908L;

	public String time;
	public String msg;
	public String exp;

	public Message(String msg,String exp) {
		this.msg = msg;
		this.time = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE).format(new Date());
		this.exp = exp;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getExp(){
		return this.exp;
	}

}
