package test;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

public class Twitterbot extends HttpServlet{
	static Logger logger = Logger.getLogger("SenyaBot");

	static String consumerKey = "2o01rCpPZNu2JkkQFnUD0Lzgo";
	static String consumerSecret = "XVt9OrqeiPrWwro353OV8wtBhVA7oOmfThlBMw3ontlvTHm7FR";

	static String accessToken = "1197325210606653441-HEYuetvu0xVtnyUIUKa2hrKyCAU87R";
	static String accessTokenSecret = "DVSs1dHhXj2uYXVycLbopMIql4TkPjvOauctk4BAK9qZb";


	private static final String tweet = "このブログ超面白いww→";

	private static final String getTweet(){
		String tweets[] = {
				"龍泉洞",
				"小岩井農場",
				"さんさ踊り",
				"盛岡美術館",
				"水曜は定休日なんだよな",
				"とりあえず千家行こうぜ",
				"ユー、ライス付けちゃう？",
				"ミニカレーも意外と美味しいぜ",
				"ネギうますぎ",
				"あのネギ盛見るとテンションあがっちゃうよねー",
				"大将まじかっけぇ",
				"ここは食券制です"
		};
		int randint = (int)(Math.random()*tweets.length);
		return tweets[randint];
	}





	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		//http://twitter4j.org/ja/configuration.html
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
			.setOAuthAccessToken(accessToken)
			.setOAuthAccessTokenSecret(accessTokenSecret)
			.setOAuthConsumerKey(consumerKey)
			.setOAuthConsumerSecret(consumerSecret);
		String message = getTweet();
		Twitter twitter = new TwitterFactory(cb.build()).getInstance();
		try {
			//Twitterに書き出し
			twitter.updateStatus(message);
		} catch (TwitterException e) {
			logger.log(Level.SEVERE, "Twitter error", e);
		}
	}

			public static void main(String[] args){

				Twitter twitter = new TwitterFactory().getInstance();
				twitter.setOAuthConsumer(consumerKey, consumerSecret);
				twitter.setOAuthAccessToken(new AccessToken(accessToken,accessTokenSecret));
				try{
					twitter.updateStatus(tweet);
					System.out.println("ツイートしたよｗ");
				} catch(TwitterException e){
					System.err.println("ツイート失敗"+e.getMessage());
				}

			try{
				twitter.updateStatus(getTweet());
				System.out.println("ツイートしたよｗ");
			} catch(TwitterException d){
					System.err.println("ツイート失敗"+d.getMessage());

			}
			}
	}
