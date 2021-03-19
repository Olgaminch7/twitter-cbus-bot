package com.olgamelnichenko;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.olgamelnichenko.model.ArticleNotFoundException;
import com.olgamelnichenko.model.News;
import com.olgamelnichenko.property.reader.PropertyReader;
import com.olgamelnichenko.service.NewsService;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

@Component
public class TwitterBot{ 
	
	private final static String URL = "https://newsapi.org/";
	private final NewsService NEWS_SERVICE = new NewsService(URL, new PropertyReader());
	
	@Scheduled(cron = "0 0 7 * * *")
    private void tweetArticle() throws ArticleNotFoundException {
		try {
			News todayNews = NEWS_SERVICE.getNews();
			String title = todayNews.getArticles()[0].getTitle();
			String url = todayNews.getArticles()[0].getUrl();
			sendTweet(title + "\n" + url);
		} catch (Exception e) {
			throw new ArticleNotFoundException();
		}
		
    }
    
    private void sendTweet(String line) {
        Twitter twitter = TwitterFactory.getSingleton();
        Status status;
        try {
            status = twitter.updateStatus(line);
            System.out.println(status);
        } catch (TwitterException e) {;
            e.printStackTrace();
        }
    } 
}