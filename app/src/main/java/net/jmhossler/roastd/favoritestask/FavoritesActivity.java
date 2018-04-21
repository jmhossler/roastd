package net.jmhossler.roastd.favoritestask;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import net.jmhossler.roastd.R;
import net.jmhossler.roastd.data.user.MockUserRepository;
import net.jmhossler.roastd.listfragment.SearchableItemListFragment;
import net.jmhossler.roastd.util.ActivityUtils;

public class FavoritesActivity extends AppCompatActivity implements FavoritesContract.View {
  private FavoritesContract.Presenter mPresenter;

  @Override
  public void setPresenter(FavoritesContract.Presenter presenter) {
    this.mPresenter = presenter;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_favorites);

    SearchableItemListFragment listFragment =
      (SearchableItemListFragment) getSupportFragmentManager().findFragmentById(R.id.listFrame);
    if(listFragment == null) {
      listFragment = SearchableItemListFragment.newInstance();
      ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
        listFragment, R.id.listFrame);
    }
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    MockUserRepository mUserRepository = MockUserRepository.getInstance();

    mPresenter = new FavoritesPresenter(this, mUserRepository);

    // Here, I would update the fragment with UUIDs for the fragment. Incomplete, as of yet
  }
}
