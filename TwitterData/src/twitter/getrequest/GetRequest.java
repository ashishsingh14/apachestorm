package twitter.getrequest;
import java.util.List;

import twitter4j.DirectMessage;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.*;
import twitter4j.Status;

public class GetRequest {
	
	public static void main(String [] args) throws TwitterException
	{
		try
		{
			ConfigurationBuilder b = new ConfigurationBuilder();
			b.setDebugEnabled(true)	
			 .setOAuthConsumerKey("sGftoZs6mZGrkYJyYrzAsXNSK")
		     .setOAuthConsumerSecret("3eEZ5xHMejfGK1l8iMkE05dYyQwxFQbkA2u3P6SCOmlmCAnX1F")
			 .setOAuthAccessToken("756814340-a2MzSnPo3GKb3q7WmtADZuEwXU1B7AeLBnD9unnT")	
			 .setOAuthAccessTokenSecret("WH0sLUokkcz7RXMFbK7sxbDmQ7T1nd1fFYmiKRbYmAE1g");
			
			TwitterFactory t = new TwitterFactory(b.build());
			Twitter tw = t.getInstance();
			//Status st = tw.updateStatus("Hello How are you");		
			//System.out.println("Updated Status to " + st.getText());
			List<Status> statuses = tw.getUserTimeline("rishabh1jain");
			System.out.println("Showing the latest tweets");
			for (Status status : statuses) {
		        System.out.println(status.getUser().getName() + ":" +status.getText());
		                           
		    }
			
			/*System.out.println("\nSending message to myself");
			DirectMessage message = tw.sendDirectMessage("ashish_singh14", "This is the message6");
			System.out.println("\nSent: " + message.getRecipientScreenName());*/
			
			
			System.out.println("\nVerify Credentials");
			User user = tw.verifyCredentials();
            System.out.println("Successfully verified credentials of " + user.getScreenName());
            
            System.out.println("\nShowing the message from the timeline");
            
                    
            System.exit(0);
		}
		catch(TwitterException te)
		{
			te.printStackTrace();
            System.out.println("Failed to update profile: " + te.getMessage());
            System.exit(-1);
		}
		
	}

}
