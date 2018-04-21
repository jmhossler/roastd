package net.jmhossler.roastd.listfragment;

import android.content.Context;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import net.jmhossler.roastd.R;
import net.jmhossler.roastd.data.searchableItem.SearchableItem;

import java.util.ArrayList;
import java.util.UUID;

public class SearchableItemListFragment extends ListFragment {

  private ArrayList<SearchableItem> items;
  private SearchableItemArrayAdapter adapter;
  private SearchableItemListContract.Presenter mPresenter;

  public SearchableItemListFragment() {
    // Empty default constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.items = new ArrayList<>();
    this.adapter = new SearchableItemArrayAdapter(getContext(), items);
    this.mPresenter = new SearchableItemListPresenter();
    setListAdapter(adapter);
  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    this.mPresenter = new SearchableItemListPresenter();
    this.items = mPresenter.getItems(new ArrayList<UUID>());
    this.adapter = new SearchableItemArrayAdapter(getContext(), items);
    setListAdapter(adapter);
  }

  public void setItems(ArrayList<UUID> items) {
    if(mPresenter == null) {
      mPresenter = new SearchableItemListPresenter();
    }
    this.items = mPresenter.getItems(items);
    adapter.notifyDataSetChanged();
  }


  public static SearchableItemListFragment newInstance() {
    return new SearchableItemListFragment();
  }

  @Override
  public void onListItemClick(ListView l, View v, int position, long id) {
    // nothing
  }

  public class SearchableItemArrayAdapter  extends ArrayAdapter<SearchableItem> {
    private final Context context;
    private final ArrayList<SearchableItem> values;

    public SearchableItemArrayAdapter(Context context, ArrayList<SearchableItem> values) {
      super(context, R.layout.rowlayout, values);
      this.context = context;
      this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      View rowView = inflater.inflate(R.layout.rowlayout, parent, false);
      TextView textView = (TextView) rowView.findViewById(R.id.label);
      ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

      textView.setText(values.get(position).getName());

      imageView.setImageResource(R.drawable.roastd_logo);

      return rowView;
    }
  }
}
