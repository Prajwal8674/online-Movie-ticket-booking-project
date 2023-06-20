package movieModel;

public class pojo {
	private String uid;
	private String movieN;
	private String actor;
	private String director;
	private String price;
	public pojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public pojo(String uid, String movieN, String actor, String director, String price) {
		super();
		this.uid = uid;
		this.movieN = movieN;
		this.actor = actor;
		this.director = director;
		this.price = price;
	}
	public pojo( String movieN, String actor, String director, String price) {
		super();
		this.movieN = movieN;
		this.actor = actor;
		this.director = director;
		this.price = price;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getMovieN() {
		return movieN;
	}
	public void setMovieN(String movieN) {
		this.movieN = movieN;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
