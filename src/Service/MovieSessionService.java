package Service;

import java.util.ArrayList;
import java.util.List;

import fileService.FileService;
import model.MovieSession;
import model.User;

public class MovieSessionService
{	
	private FileService fService = new FileService();
	
	public void list()
	{
		List<String> movieSessionsData = fService.read();
		List<MovieSession> movieSessions = new ArrayList();
		System.out.println("Seesion Id, Movie Name, Theater Name, Date, Time");
		for(String sessionData: movieSessionsData) {
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
}
