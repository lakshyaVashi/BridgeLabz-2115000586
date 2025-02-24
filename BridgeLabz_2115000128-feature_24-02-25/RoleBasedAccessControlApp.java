import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class User {
    private String username;
    private String role;

    public User(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }
}

class AccessControlManager {
    private User user;

    public AccessControlManager(User user) {
        this.user = user;
    }

    @RoleAllowed("ADMIN")
    public void accessAdminPanel() {
        System.out.println("Access granted to admin panel for user: " + user.getUsername());
    }

    @RoleAllowed("USER")
    public void accessUserDashboard() {
        System.out.println("Access granted to user dashboard for user: " + user.getUsername());
    }

    public void checkAccess(String methodName) {
        try {
            Method method = this.getClass().getDeclaredMethod(methodName);
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
                if (roleAllowed.value().equals(user.getRole())) {
                    method.invoke(this);
                } else {
                    System.out.println("Access Denied! User " + user.getUsername() + " does not have " + roleAllowed.value() + " privileges.");
                }
            } else {
                method.invoke(this);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

public class RoleBasedAccessControlApp {
    public static void main(String[] args) {
        User adminUser = new User("AdminUser", "ADMIN");
        User normalUser = new User("NormalUser", "USER");

        AccessControlManager adminManager = new AccessControlManager(adminUser);
        AccessControlManager userManager = new AccessControlManager(normalUser);

        System.out.println("--- Admin Access Attempt ---");
        adminManager.checkAccess("accessAdminPanel");
        adminManager.checkAccess("accessUserDashboard");

        System.out.println("--- User Access Attempt ---");
        userManager.checkAccess("accessAdminPanel");
        userManager.checkAccess("accessUserDashboard");
    }
}
