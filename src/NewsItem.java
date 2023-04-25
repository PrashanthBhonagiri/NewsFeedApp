import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NewsItem {
    private String id;
    private String title;
    private String description;
    private User author;
    private LocalDateTime publishedDate;
    private List<Comment> comments;
    private List<Vote> votes;

    public NewsItem(String title, String description, User author) {
        this.id = IdGenerator.generateId();
        this.title = title;
        this.description = description;
        this.author = author;
        this.publishedDate = LocalDateTime.now();
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
    }

    // Getter and Setter methods for all the fields

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAuthor() {
        return author;
    }
    public String getId() {
        return id;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }
    
    // Helper methods to add and remove comments

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public void removeComment(Comment comment) {
        this.comments.remove(comment);
    }

    // Helper methods to add and remove votes

    public boolean addVote(Vote newVote) {
        String newVoteId = newVote.getUserId();
        for (Vote vote : this.votes) {
            if(vote.getUserId().equals(newVoteId)) {
                if(vote.isUpvote() == newVote.isUpvote()) {
                    return false;
                }
                else {
                    vote.setUpvote(newVote.isUpvote());
                    return true;
                }
            }
        }
        this.votes.add(newVote);
        return true;
    }

    public void removeVote(Vote vote) {
        this.votes.remove(vote);
    }

    // Methods to get the number of upvotes and downvotes

    public int getUpvotes() {
        int count = 0;
        for (Vote vote : this.votes) {
            if (vote.isUpvote()) {
                count++;
            }
        }
        return count;
    }

    public int getDownvotes() {
        int count = 0;
        for (Vote vote : this.votes) {
            if (!vote.isUpvote()) {
                count++;
            }
        }
        return count;
    }
    public String printComments() {
        StringBuilder allComments = new StringBuilder();
        for (Comment comment:this.comments) {
            allComments.append(comment.toString()).append("\n");
        }
        return allComments.toString();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Post ID: ").append(this.id).append("\n")
                .append("Title: ").append(this.title).append("\n")
                .append("Description: ").append(this.description).append("\n")
                .append("Created At: ").append(TimeAgo.toRelative(this.publishedDate)).append("\n")
                .append("Created By: ").append(this.author.getUsername()).append("\n").append("Author Id : ").append(this.author.getId()).append("\n")
                .append("Upvotes: ").append(getUpvotes()).append("\n")
                .append("Downvotes: ").append(getDownvotes()).append("\n")
                .append("Comments: \n").append(printComments())
                ;
        return sb.toString();
    }
}