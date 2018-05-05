package Service;

import java.util.ArrayList;
import java.util.List;

import fileService.FileService;
import model.MovieSession;
import model.User;

public class MovieSessionService
{	
	private List<String> movieSessionData = new ArrayList<String>();
	
	public MovieSessionService()
	{	
		FileService fService = new FileService();
		this.movieSessionData = fService.read();
	}
	
	public void list()
	{
		List<MovieSession> movieSessions = new ArrayList();
		System.out.println("Seesion Id, Movie Name, Theater Name, Date, Time");
		for(String sessionData: movieSessionData) {
			String[] data = sessionData.split(",");
			
			String sessionId = data[0].trim();
			String movieName = data[1].trim();
			String theaterName = data[2].trim();
			String date = data[3].trim();
			String time = data[4].trim();
			MovieSession movieSession = new MovieSession(sessionId, movieName, theaterName, date, time);
			System.out.println(movieSession.toString());
			movieSessions.add(movieSession);
		}
	}

	public MovieSession findById(String id) {
		MovieSession movieSession = null;
		for(String sessionData: movieSessionData) {
			String[] data = sessionData.split(",");
			
			String sessionId = data[0].trim();
			if (sessionId.equals(id))
			{
				String movieName = data[1].trim();
				String theaterName = data[2].trim();
				String date = data[3].trim();
				String time = data[4].trim();
				movieSession = new MovieSession(sessionId, movieName, theaterName, date, time);
				System.out.println(movieSession.toString());
				break;
			}
		}
		
		return movieSession;
	}
}
