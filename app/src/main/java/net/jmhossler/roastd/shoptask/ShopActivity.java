package net.jmhossler.roastd.shoptask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.jmhossler.roastd.R;
import net.jmhossler.roastd.data.bean.FirebaseRTBeanRepository;
import net.jmhossler.roastd.data.drink.FirebaseRTDrinkRepository;
import net.jmhossler.roastd.data.searchableItem.FirebaseRTSearchableItemRepository;
import net.jmhossler.roastd.data.searchableItem.SearchableItem;
import net.jmhossler.roastd.data.shop.FirebaseRTShopRepository;
import net.jmhossler.roastd.data.user.FirebaseRTUserRepository;

import java.util.List;

public class ShopActivity extends AppCompatActivity implements ShopContract.View {

  private ShopContract.Presenter mShopPresenter;

  @Override
  public void setPresenter(ShopContract.Presenter shopPresenter) {
    mShopPresenter = shopPresenter;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_shop);
    String shopId = getIntent().getStringExtra("SHOP_ID");



    mShopPresenter = new ShopPresenter(this, shopId, FirebaseRTUserRepository.getsInstance(),
      FirebaseRTShopRepository.getInstance(), FirebaseRTSearchableItemRepository.getInstance());
  }

  @Override
  public void displayName(String name) {

  }

  @Override
  public void displayDescription(String description) {

  }

  @Override
  public void displayAddress(String address) {

  }

  @Override
  public void displayMapsUrl(String url) {

  }

  @Override
  public void displayConsumeables(List<SearchableItem> items) {

  }
}
