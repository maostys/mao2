import java.io.BufferedReader;
import java.io.InputStreamReader;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class TwitterAuth {
	static String consumerKey = "xxxxx";
	static String consumerSecret = "xxxxx";
	public static void main(String args[]){
		try{
			Twitter twitter = new TwitterFactory().getInstance();
			twitter.setOAuthConsumer(consumerKey, consumerSecret);
			RequestToken requestToken = twitter.getOAuthRequestToken();
			AccessToken accessToken = null;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while(null==accessToken){
				System.out.println("open following URL");
				System.out.println(requestToken.getAuthenticationURL());
				System.out.println("hit enter:");
				String line = br.readLine();
				try{
					accessToken = twitter.getOAuthAccessToken();
				}catch(Exception e){

				}
			}
			System.out.println("token= " + accessToken.getToken());
			System.out.println("tokenSecret= " + accessToken.getTokenSecret());
		}catch(Exception e){
			System.err.print(e);
		}
	}
}