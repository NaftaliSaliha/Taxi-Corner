package session;

public class AppSession {
    private static AppSession instance;
    private String role;

    private AppSession() {
        // Private constructor to prevent instantiation
    }

    public static synchronized AppSession getInstance() {
        if (instance == null) {
            instance = new AppSession();
        }
        return instance;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void clearSession() {
        role = null;
        // Clear other session data if needed
    }
}
