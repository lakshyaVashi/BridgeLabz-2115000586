import java.util.*;

class User {
    int userId;
    String name;
    int age;
    List<Integer> friends;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    private User head;

    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    public void addFriend(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        if (user1 != null && user2 != null && userId1 != userId2) {
            if (!user1.friends.contains(userId2)) user1.friends.add(userId2);
            if (!user2.friends.contains(userId1)) user2.friends.add(userId1);
        }
    }

    public void removeFriend(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        if (user1 != null && user2 != null) {
            user1.friends.remove(Integer.valueOf(userId2));
            user2.friends.remove(Integer.valueOf(userId1));
        }
    }

    public List<Integer> findMutualFriends(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        List<Integer> mutualFriends = new ArrayList<>();
        if (user1 != null && user2 != null) {
            for (int friendId : user1.friends) {
                if (user2.friends.contains(friendId)) {
                    mutualFriends.add(friendId);
                }
            }
        }
        return mutualFriends;
    }

    public void displayFriends(int userId) {
        User user = findUser(userId);
        if (user != null) {
            System.out.println("Friends of " + user.name + ": " + user.friends);
        }
    }

    public User findUser(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    public User searchUser(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) return temp;
            temp = temp.next;
        }
        return null;
    }

    public int countFriends(int userId) {
        User user = findUser(userId);
        return user != null ? user.friends.size() : 0;
    }
}

public class SocialMediaApp {
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();
        sm.addUser(1, "Alice", 25);
        sm.addUser(2, "Bob", 27);
        sm.addUser(3, "Charlie", 23);
        sm.addFriend(1, 2);
        sm.addFriend(1, 3);
        sm.displayFriends(1);
        sm.displayFriends(2);
        System.out.println("Mutual Friends: " + sm.findMutualFriends(1, 2));
        sm.removeFriend(1, 2);
        sm.displayFriends(1);
        System.out.println("Bob has " + sm.countFriends(2) + " friends.");
    }
}
