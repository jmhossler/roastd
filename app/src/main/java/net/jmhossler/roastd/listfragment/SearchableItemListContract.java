package net.jmhossler.roastd.listfragment;

import net.jmhossler.roastd.BasePresenter;
import net.jmhossler.roastd.data.searchableItem.SearchableItem;

import java.util.ArrayList;
import java.util.UUID;

public interface SearchableItemListContract {
  interface Presenter extends BasePresenter {
    ArrayList<SearchableItem> getItems(ArrayList<UUID> items);
  }
}
