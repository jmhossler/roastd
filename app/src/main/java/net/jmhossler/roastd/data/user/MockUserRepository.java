package net.jmhossler.roastd.data.user;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.UUID;

import static net.jmhossler.roastd.data.MockDataSourceUtils.deepClone;

public class MockUserRepository implements UserDataSource {

  private static MockUserRepository sInstance = null;
  private static User sTheUser = null;

  private MockUserRepository() {

  }

  public static MockUserRepository getInstance() {
    if (sInstance == null) {
      sInstance = new MockUserRepository();
    }
    return sInstance;
  }

  @Override
  public void getUser(String userId, GetUserCallback callback) {
    ArrayList<UUID> favorites = new ArrayList<UUID>();
    favorites.add(UUID.fromString("111"));
    favorites.add(UUID.fromString("222"));
    favorites.add(UUID.fromString("333"));
    ArrayList<UUID> shops = new ArrayList<UUID>();
    callback.onUserLoaded(deepClone(new User(userId, "foobar@gmail.com",
                                             "Foo Bar, Jr.", null, shops,
                                             false, Calendar.getInstance().getTime(),
                                             favorites)));
    return;
    /* commenting out because the purpose of a mock is to return data, not actually implement the logic.
    if (sTheUser != null && userId.equals(sTheUser.getUuid())) {
      // Using cloning to try to emulate repository behavior
      callback.onUserLoaded(deepClone(sTheUser));
    } else {
      callback.onDataNotAvailable();
    }
    */
  }

  @Override
  public void saveUser(User user) {
    // Using cloning to try to emulate repository behavior
    sTheUser = deepClone(user);
  }
}
