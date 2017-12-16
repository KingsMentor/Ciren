package xyz.belvi.ciren.controllers.interfaces;

import xyz.belvi.ciren.models.Ciren;
import xyz.belvi.ciren.views.adapters.CirenAdapter;

/**
 * Created by zone2 on 6/27/17.
 */

public interface CirenBinder {

    void deliverAdapter(CirenAdapter cirenAdapter);

    void onItemCirenSelected(Ciren ciren);
}
