package model;

public class Session
{
	private String _sessionId;
	private String _movieName;
	private String _theaterName;
	private String _date;
	private String _time;
	
	public Session(String sessionId) {
		this._sessionId = sessionId;
	}
	
	public Session(String sessionId, String movieName, String theaterName, 
			String date, String time)
	{
		this._sessionId = sessionId;
		this._movieName = movieName;
		this._theaterName = theaterName;
		this._date = date;
		this._time = time;
	}

	public String getSessionId()
	{
		return _sessionId;
	}

	public void setSessionId(String sessionId)
	{
		this._sessionId = sessionId;
	}

	public String getMovieName()
	{
		return _movieName;
	}

	public void setMovieName(String movieName)
	{
		this._movieName = movieName;
	}

	public String getTheaterName()
	{
		return _theaterName;
	}

	public void setTheaterName(String theaterName)
	{
		this._theaterName = theaterName;
	}

	public String getDate()
	{
		return _date;
	}

	public void setDate(String date)
	{
		this._date = date;
	}

	public String getTime()
	{
		return _time;
	}

	public void setTime(String time)
	{
		this._time = time;
	}
	
}
