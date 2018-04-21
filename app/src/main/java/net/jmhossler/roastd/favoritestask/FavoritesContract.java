package net.jmhossler.roastd.favoritestask;

import net.jmhossler.roastd.BasePresenter;
import net.jmhossler.roastd.BaseView;
import net.jmhossler.roastd.data.searchableItem.SearchableItem;

import java.util.ArrayList;
import java.util.UUID;

public interface FavoritesContract {
  interface View extends BaseView<Presenter> {

  }

  interface Presenter extends BasePresenter {
    ArrayList<UUID> getFavorites();
  }
}
