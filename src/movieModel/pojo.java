package movieModel;

public class pojo {
	private int id;
	private String movieN;
	private String actor;
	private String director;
	private String price;
	
	public pojo(int id, String movieN, String actor, String director, String price) {
		super();
		this.id = id;
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
	public int getid() {
		return id;
	}
	public void setUid(int id) {
		this.id = id;
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
