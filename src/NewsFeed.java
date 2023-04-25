import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NewsFeed {
    private ArrayList<NewsItem> newsItems;

    public NewsFeed() {
        newsItems = new ArrayList<>();
    }

    public void addPost(NewsItem newsItem) {
        newsItems.add(newsItem);
    }

    public NewsItem getNewsItemById(String newsItemId) {
        for (NewsItem newsItem : newsItems) {
            if(newsItem.getId().equals(newsItemId)) {
                return newsItem;
            }
        }
        return null;
    }

    public void printFeed() {
        //[TODO] sorting has to be updated 
        // Sorting the news items based on creation time in descending order
        Collections.sort(newsItems, Comparator.comparing(NewsItem::getPublishedDate).reversed());

        // Print each news item with details
        for (NewsItem newsItem : newsItems) {
            System.out.println(newsItem.toString());
            System.out.println("------------------------------------------------------");
        }
    }
}