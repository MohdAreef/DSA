/*
Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, and is able to see the 10 most recent tweets in the user's news feed.

Implement the Twitter class:

Twitter() Initializes your twitter object.
void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId. Each call to this function will be made with a unique tweetId.
List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user themself. 
Tweets must be ordered from most recent to least recent.
void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.
void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId.
*/

class Pair
{
    int time,tweetId;
    Pair(int tweetId,int time )
    {
        this.time=time;
        this.tweetId=tweetId;
    }
}

class Twitter {
    int time=0;
    HashMap<Integer,List<Pair>> usermap;
    HashMap<Integer,List<Integer>> followmap;
    public Twitter() {
         usermap= new HashMap<>();
         followmap=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(usermap.containsKey(userId))
        {
            usermap.get(userId).add(new Pair(tweetId,time));
        }
        else 
        {
            usermap.put(userId,new ArrayList<Pair>());
            usermap.get(userId).add(new Pair(tweetId,time) );
        }
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {

    
        PriorityQueue<Pair> feed=new PriorityQueue<>((a,b)-> b.time-a.time);
       
        if(usermap.containsKey(userId))
        {
        for(Pair p:usermap.get(userId))
        {
            feed.add(p);
        }
        }
        if(followmap.containsKey(userId))
        {
        for(int i: followmap.get(userId))
        {
            if(usermap.containsKey(i))
            {
            for(Pair p:usermap.get(i))
            {
                feed.add(p);
            }
            }
        }
        }
        List<Integer> result=new ArrayList<>();
        int len=feed.size();
        for(int i=0;i<Math.min(len,10);i++)
        {
            result.add(feed.poll().tweetId);
        }
        return result;


        
    }
    
    public void follow(int followerId, int followeeId) {
        if(followmap.containsKey(followerId))
        {
            if(followmap.get(followerId).contains(followeeId))
            {

            }
            else
            followmap.get(followerId).add(followeeId);
        }
        else
        {
            followmap.put(followerId,new ArrayList<Integer>());
            followmap.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followmap.containsKey(followerId))
        {
        followmap.get(followerId).remove(Integer.valueOf(followeeId));
        }
        
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
