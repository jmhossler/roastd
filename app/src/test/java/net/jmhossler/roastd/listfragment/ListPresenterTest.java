/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.jmhossler.roastd.listfragment;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.google.firebase.auth.FirebaseAuth;

import net.jmhossler.roastd.data.bean.MockBeanRepository;
import net.jmhossler.roastd.data.drink.MockDrinkRepository;
import net.jmhossler.roastd.data.searchableItem.SearchableItem;
import net.jmhossler.roastd.data.shop.MockShopRepository;
import net.jmhossler.roastd.listfragment.SearchableItemListContract;
import net.jmhossler.roastd.listfragment.SearchableItemListPresenter;

import java.util.ArrayList;
import java.util.UUID;

import static org.mockito.Mockito.verify;

/**
 * Unit tests for the implementation of {@link SearchableItemListPresenter}
 */
public class ListPresenterTest {

  @Mock
  private SearchableItemListContract.View mListView;

  @Mock
  private MockBeanRepository mockBeanRepository;

  @Mock
  private MockShopRepository mockShopRepository;

  @Mock
  private MockDrinkRepository mockDrinkRepository;

  private SearchableItemListPresenter mListPresenter;

  @Before
  public void setupTasksPresenter() {
    // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
    // inject the mocks in the test the initMocks method needs to be called.
    MockitoAnnotations.initMocks(this);

    // Get a reference to the class under test
    mListPresenter = new SearchableItemListPresenter(mListView, mockBeanRepository, mockDrinkRepository, mockShopRepository);
  }

  @Test
  public void createPresenter_setsThePresenterToView() {
    // Get a reference to the class under test
    mListPresenter = new SearchableItemListPresenter(mListView,  mockBeanRepository, mockDrinkRepository, mockShopRepository);

    // Then the presenter is set to the view
    verify(mListView).setPresenter(mListPresenter);
  }

  @Test
  public void getItems_returnsArray() {
    // This test would need to be updated when logic for getting the items is added
    ArrayList<SearchableItem> items = mListPresenter.getItems(new ArrayList<UUID>());
    Assert.assertEquals(items.size(), 0);
  }
}
