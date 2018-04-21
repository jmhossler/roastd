package net.jmhossler.roastd.listfragment;

import net.jmhossler.roastd.data.bean.Bean;
import net.jmhossler.roastd.data.drink.Drink;
import net.jmhossler.roastd.data.searchableItem.SearchableItem;
import net.jmhossler.roastd.data.shop.Shop;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.UUID;

public class SearchableItemListPresenter implements SearchableItemListContract.Presenter {
  public void start() {
    // Empty start
  }

  public SearchableItemListPresenter() {
    // Empty constructor
  }

  @Override
  public ArrayList<SearchableItem> getItems(ArrayList<UUID> items) {
    URL shopURL;
    try {
      shopURL = new URL("https://roastd.github.io/roastd");
    } catch( MalformedURLException e) {
      return new ArrayList<>();
    }
    ArrayList<SearchableItem> ret = new ArrayList<>();
    ret.add(new Bean(UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d"), "California Crush", "From the depths of the Indian ocean, a package of this rare ...",
      null, new ArrayList<String>(), "dark roast", "Russia"));
    ret.add(new Shop(UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4efddd"), "Monarch", "A cool hipster place that only REAL coffee snobs like",
      null, new ArrayList<String>(), "800 Energy Center Blvd", shopURL));
    ret.add(new Drink(UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef0fd"), "caramel macchiato", "The worst of the worst", null,
      new ArrayList<>(), "macchiato", BigDecimal.ZERO));

    return ret;
  }
}
