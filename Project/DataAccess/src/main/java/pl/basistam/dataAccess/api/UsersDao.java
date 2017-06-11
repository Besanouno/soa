package pl.basistam.dataAccess.api;

public interface UsersDao {
    public boolean validateUser(String id, String password) ;
    public boolean changePassword(String id, String newPassword) ;
    public boolean changePassword(String id, String oldPassword, String newPassword) ;
    public int getAreaForUser(String id);
}
