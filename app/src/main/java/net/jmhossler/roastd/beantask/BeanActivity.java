package net.jmhossler.roastd.beantask;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import net.jmhossler.roastd.R;
import net.jmhossler.roastd.data.bean.BeanDataSource;
import net.jmhossler.roastd.data.bean.FirebaseRTBeanRepository;
import net.jmhossler.roastd.data.review.FirebaseRTReviewRepository;
import net.jmhossler.roastd.data.shop.FirebaseRTShopRepository;
import net.jmhossler.roastd.shoptask.ShopActivity;
import net.jmhossler.roastd.shoptask.ShopContract;

import java.util.List;

public class BeanActivity extends AppCompatActivity implements BeanContract.View {

  private BeanContract.Presenter mBeanPresenter;
  private TextView mName;
  private TextView mDescription;
  private TextView mRoast;
  private TextView mOrigin;

  public static Intent createIntent(String beanId, Context context) {
    Intent intent = new Intent(context, BeanActivity.class);
    intent.putExtra("BEAN_ID", beanId);
    return intent;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_bean);

    String beanId = getIntent().getStringExtra("BEAN_ID");

    mName = (TextView) findViewById(R.id.name);
    mDescription = (TextView) findViewById(R.id.description);
    mRoast = (TextView) findViewById(R.id.roast);
    mOrigin = (TextView) findViewById(R.id.origin);

    BeanPresenter presenter = new BeanPresenter(this, beanId, FirebaseRTBeanRepository.getInstance(),
      FirebaseRTShopRepository.getInstance(), FirebaseRTReviewRepository.getInstance());

    presenter.setName();
    presenter.setDescription();
    presenter.setRoast();
    presenter.setOrigin();
  }

  @Override
  public void displayName(String name) {
    mName.setText(name);
  }

  @Override
  public void displayDescription(String description) {
    mDescription.setText(description);
  }

  @Override
  public void displayShop(String shopId) {

  }

  @Override
  public void displayRoast(String roast) {
    mRoast.setText("Roast: " + roast);
  }

  @Override
  public void displayOrigin(String origin) {
    mOrigin.setText("Origin: " + origin);
  }

  @Override
  public void displayReview(List<String> reviewIds) {

  }

  @Override
  public void displayImage(String imageUrl) {

  }

  @Override
  public void setPresenter(BeanContract.Presenter presenter) {
    mBeanPresenter = presenter;
  }
}
