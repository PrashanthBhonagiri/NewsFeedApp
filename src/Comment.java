import java.time.LocalDateTime;

public class Comment {
    private String id;
    private User author;
    private LocalDateTime commentDate;
    private String text;

    public Comment(User author, String text) {
        this.id = IdGenerator.generateId();
        this.author = author;
        this.commentDate = LocalDateTime.now();;
        this.text = text;
    }

    // Getter and Setter methods for all the fields

    public String getAuthor() {
        return author.getUsername();
    }

    public void setAuthor(User author) {
        this.author = author;
    }
    public String getId() {
        return id;
    }
    public LocalDateTime getPublishedDate() {
        return commentDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Comment ID: ").append(this.id).append("\n")
            .append("---------------\n")
            .append(this.text)
        ;
        return sb.toString();
    }
}
