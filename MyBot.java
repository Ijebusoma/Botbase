import twitter4j.*;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import java.util.ArrayList;
import java.util.List;



public class MyBot {


    //if something goes wrong, we might see a TwitterException
    public static void main(String args[]) throws TwitterException {
	//onStatus();

        //access the twitter API using your twitter4j.properties file
		//put a forloop here and add a thread
		//onStatus();
        
		MyBot bee = new MyBot();
		bee.paymentOnline();
		
    }
 void paymentOnline() throws TwitterException
	{
	
	Twitter twitter = TwitterFactory.getSingleton();
		    twitter = new TwitterFactory().getInstance();

	List<String> searches = new ArrayList<>();
        searches.add("\"payment solution\"");
        searches.add("\"transfer solution \"");
        searches.add("\"Nigeria payment solutions \"");
		//List<String> mentions = new ArrayList<>();
        //mentions.add("\" payment \"");
        //mentions.add("\"transfer \"");
        //mentions.add("\" transaction\"");

        List<String> replies = new ArrayList<>();
        replies.add("\" KongaPay");
        replies.add("\" PayStack");
        replies.add("\" SimplePay ");

       //create a new search, choose from random searches
        Query query = new Query(searches.get((int)(searches.size()*Math.random())));
		// Query query = new Query(mentions.get((int)(mentions.size()*Math.random())));

        //get the results from that search
       QueryResult result = twitter.search(query);
		  //QueryResult result = twitter.mentions(query);

        //get the first tweet from those results
        Status tweetResult = result.getTweets().get(0);

        //reply to that tweet, choose from random replies
        StatusUpdate statusUpdate = new StatusUpdate("@" + tweetResult.getUser().getScreenName() + "\"" 
		+ replies.get((int)(replies.size()*Math.random())));
        statusUpdate.inReplyToStatusId(tweetResult.getId());
        Status status = twitter.updateStatus(statusUpdate); 

        System.out.println("Yo,search Completed!");
	}
	void lodgePlaces() throws TwitterException
	{
	
	
	
	}
//still fixing this part, it may throw some errors on the commandline
	/*public static void onStatus(Status status) 
	{
	
  System.out.println("onStatus @" + status.getUser().getScreenName() + " - "+ status.getText());
  System.out.println(status.getInReplyToUserId());
  Twitter tf = new TwitterFactory().getInstance();
  StatusUpdate st = new StatusUpdate("Yo!");
  st.inReplyToStatusId(status.getId());
  try {
    tf.updateStatus(st);
  } catch (TwitterException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
  } 
} 
*/
	}
	
	