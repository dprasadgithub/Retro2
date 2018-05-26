package com.developer.retro.interfaces;

import com.developer.retro.models.ChangeItem;

import java.util.List;

/**
 * Created by SDL on 5/25/2018.
 */

public interface RVListener {

    void onDataFetch(List<ChangeItem> listChangeItems);
}
