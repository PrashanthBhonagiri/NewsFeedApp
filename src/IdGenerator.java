import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class IdGenerator {
    private static final int ID_LENGTH = 5;
    private static final Set<String> usedIds = new HashSet<>();

    public static String generateId() {
        Random random = new Random();
        String id;

        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ID_LENGTH; i++) {
                sb.append(random.nextInt(10));
            }
            id = sb.toString();
        } while (usedIds.contains(id));

        usedIds.add(id);
        return id;
    }
}