package model;

public class Session
{
	private String sessionId;
	private String movieName;
	private String theaterName;
	private String date;
	private String time;
	
	public Session(String sessionId, String movieName, String theaterName, 
			String date, String time)
	{
		
	}

	public String getSessionId()
	{
		return sessionId;
	}

	public void setSessionId(String sessionId)
	{
		this.sessionId = sessionId;
	}

	public String getMovieName()
	{
		return movieName;
	}

	public void setMovieName(String movieName)
	{
		this.movieName = movieName;
	}

	public String getTheaterName()
	{
		return theaterName;
	}

	public void setTheaterName(String theaterName)
	{
		this.theaterName = theaterName;
	}

	public String getDate()
	{
		return date;
	}

	public void setDate(String date)
	{
		this.date = date;
	}

	public String getTime()
	{
		return time;
	}

	public void setTime(String time)
	{
		this.time = time;
	}
	
}
