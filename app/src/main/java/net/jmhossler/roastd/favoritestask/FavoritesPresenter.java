package net.jmhossler.roastd.favoritestask;

import android.support.annotation.NonNull;

import net.jmhossler.roastd.data.user.MockUserRepository;

import java.util.ArrayList;
import java.util.UUID;

public class FavoritesPresenter implements FavoritesContract.Presenter {
  private FavoritesContract.View mFavoritesView;
  private MockUserRepository mUserRepository;

  @Override
  public void start() {
    // empty for now
  }

  public FavoritesPresenter(@NonNull FavoritesContract.View favoritesView, MockUserRepository userRepository) {
    mFavoritesView = favoritesView;
    mFavoritesView.setPresenter(this);
    mUserRepository = userRepository;
  }

  @Override
  public ArrayList<UUID> getFavorites() {
    ArrayList<UUID> items = new ArrayList<>();
    return items;
  }
}
