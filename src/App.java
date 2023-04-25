import java.util.Scanner;

public class App {
    private static User currentUser  = null;
    private static NewsFeed newsFeed = new NewsFeed();

    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter command (signup/signin/shownewsfeed/post/comment/upvote/downvote/quit): ");
                String command = scanner.nextLine();

                switch(command) {
                    case "signup":
                        System.out.print("Creating New Account\n");
                        System.out.print("Enter username: ");
                        String username = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String password = scanner.nextLine();
                        boolean creatingUser = User.signUp(username, password);
                        if(creatingUser) {
                            System.out.println("user created successfully ");
                        }
                        break;
                    
                    case "signin":
                        System.out.print("Enter username: ");
                        username = scanner.nextLine();
                        System.out.print("Enter password: ");
                        password = scanner.nextLine();
                        User user = User.signIn(username,password);
                        if(user != null) {
                            currentUser = user;
                            System.out.println("Logged in successfully");
                        }
                        else {
                            System.out.println("Invalid username or password");
                        }
                        break;
                    case "post":
                        if (currentUser == null) {
                            System.out.println("Please signin to create a post.");
                            break;
                        }
                        System.out.print("Enter post title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter post description: ");
                        String description = scanner.nextLine();
                        NewsItem newsItem = new NewsItem(title, description, currentUser);
                        newsFeed.addPost(newsItem);
                        System.out.println("News Item created successfully.");
                        System.out.println(newsItem.toString());
                        break;
                    case "upvote":
                        if (currentUser == null) {
                            System.out.println("Please sign in to vote.");
                            break;
                        }
                        System.out.print("Enter the ID of the News item to upvote: ");
                        String upVotePostId = scanner.nextLine();
                        NewsItem upVotePost = newsFeed.getNewsItemById(upVotePostId);
                        if (upVotePost == null) {
                            System.out.println("News item not found");
                            break;
                        }
                        boolean isSuccessfulUpVote = upVotePost.addVote(new Vote(currentUser.getId(), true));
                        if(isSuccessfulUpVote) {
                            System.out.println("Upvoted successfully!!");
                        }
                        else {
                            System.out.println("Already Upvoted!!");
                        }
                        break;
                    case "downvote":
                        if (currentUser == null) {
                            System.out.println("Please sign in to vote.");
                            break;
                        }
                        System.out.print("Enter the ID of the News item to downvote: ");
                        String downVotePostId = scanner.nextLine();
                        NewsItem downVotePost = newsFeed.getNewsItemById(downVotePostId);
                        if (downVotePost == null) {
                            System.out.println("News item not found");
                            break;
                        }
                        boolean isSuccessfulDownVote = downVotePost.addVote(new Vote(currentUser.getId(), false));
                        if(isSuccessfulDownVote) {
                            System.out.println("Downvoted successfully!!");
                        }
                        else {
                            System.out.println("Already Downvoted!!");
                        }
                        break;
                    case "comment":
                        if (currentUser == null) {
                            System.out.println("Please sign in to create a comment.");
                            break;
                        }
                        System.out.print("Enter post ID to comment on: ");
                        String commentPostId = scanner.nextLine();
                        System.out.print("Enter comment text: ");
                        String commentText = scanner.nextLine();
                        NewsItem commentPost = newsFeed.getNewsItemById(commentPostId);
                        if (commentPost == null) {
                            System.out.println("News item not found");
                            break;
                        }
                        commentPost.addComment(new Comment(currentUser, commentText));
                        System.out.println("Comment added sucessfully!! ");
                        break;

                    case "shownewsfeed":
                        newsFeed.printFeed();
                        break;
                    case "printUsers":
                        Users.printUsers();
                        break;
                    case "quit":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid command. Please try again.");
                        break;
                }
            }
        }
        
    }
}
