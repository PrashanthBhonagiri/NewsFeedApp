public class Vote {
    
    private String userId;
    private boolean isUpvote;

    public Vote(String userId, boolean isUpvote) {
        this.userId = userId;
        this.isUpvote = isUpvote;
    }

    // Getter and Setter methods for all the fields

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isUpvote() {
        return isUpvote;
    }

    public void setUpvote(boolean upvote) {
        isUpvote = upvote;
    }
}
