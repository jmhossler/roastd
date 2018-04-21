package net.jmhossler.roastd.listfragment;

import net.jmhossler.roastd.data.bean.Bean;
import net.jmhossler.roastd.data.bean.BeanDataSource;
import net.jmhossler.roastd.data.bean.MockBeanRepository;
import net.jmhossler.roastd.data.drink.Drink;
import net.jmhossler.roastd.data.drink.DrinkDataSource;
import net.jmhossler.roastd.data.drink.MockDrinkRepository;
import net.jmhossler.roastd.data.searchableItem.SearchableItem;
import net.jmhossler.roastd.data.shop.MockShopRepository;
import net.jmhossler.roastd.data.shop.Shop;
import net.jmhossler.roastd.data.shop.ShopDataSource;

import java.util.ArrayList;
import java.util.UUID;

public class SearchableItemListPresenter implements SearchableItemListContract.Presenter {
  private SearchableItemListContract.View mView;
  private MockShopRepository shopRepository;
  private MockBeanRepository beanRepository;
  private MockDrinkRepository drinkRepository;

  public void start() {
    // Empty start
  }

  public SearchableItemListPresenter(SearchableItemListContract.View view, MockBeanRepository beanRepo, MockDrinkRepository drinkRepo,
                                     MockShopRepository shopRepo) {
    mView = view;
    mView.setPresenter(this);
  }

  @Override
  public ArrayList<SearchableItem> getItems(ArrayList<UUID> items) {
    ArrayList<SearchableItem> ret = new ArrayList<>();
    for(int i = 0; i < items.size(); i++) {
      shopRepository.getShop(items.get(i), new ShopDataSource.GetShopCallback() {
        @Override
        public void onShopLoaded(Shop x) {
          ret.add(x);
        }

        @Override
        public void onDataNotAvailable() {
          //nothing
        }
      });
      drinkRepository.getDrink(items.get(i), new DrinkDataSource.GetDrinkCallback() {
        @Override
        public void onDrinkLoaded(Drink x) {
          ret.add(x);
        }

        @Override
        public void onDataNotAvailable() {
          //nothing
        }
      });
      beanRepository.getBean(items.get(i), new BeanDataSource.GetBeanCallback() {
        @Override
        public void onBeanLoaded(Bean x) {
          ret.add(x);
        }

        @Override
        public void onDataNotAvailable() {
          //nothing
        }
      });
    }

    return ret;
  }
}
