package com.example.domain;

public class MuserVO {
	private int userid;
	private String username;
	private String userpw;
	private String content;
	private String mrank;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMrank() {
		return mrank;
	}

	public void setMrank(String mrank) {
		this.mrank = mrank;
	}

	@Override
	public String toString() {
		return "MuserVO [userid=" + userid + ", username=" + username + ", userpw=" + userpw + ", content=" + content
				+ ", mrank=" + mrank + "]";
	}

}
