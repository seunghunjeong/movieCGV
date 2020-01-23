package com.example.domain;

public class MovieVO {
	private String title;
	private String rank;
	private String image;
	private String percent;
	private String link;
	private String ticketing;
	
	public String getTicketing() {
		return ticketing;
	}
	public void setTicketing(String ticketing) {
		this.ticketing = ticketing;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPercent() {
		return percent;
	}
	public void setPercent(String percent) {
		this.percent = percent;
	}

	@Override
	public String toString() {
		return "MovieVO [title=" + title + ", rank=" + rank + ", image=" + image + ", percent=" + percent + "]";
	}
}

