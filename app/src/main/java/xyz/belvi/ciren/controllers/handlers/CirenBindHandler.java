package xyz.belvi.ciren.controllers.handlers;

import android.content.Context;
import android.content.res.TypedArray;

import java.util.ArrayList;

import xyz.belvi.ciren.R;
import xyz.belvi.ciren.controllers.app.CirenApplication;
import xyz.belvi.ciren.controllers.interfaces.CirenBinder;
import xyz.belvi.ciren.models.Ciren;
import xyz.belvi.ciren.views.adapters.CirenAdapter;

/**
 * Created by zone2 on 6/27/17.
 */

public class CirenBindHandler {
    private CirenBinder cirenBinder;
    private CirenAdapter mCirenAdapter;

    public CirenBindHandler bind(CirenBinder cirenBinder) {
        this.cirenBinder = cirenBinder;
        return this;

    }

    public void load() {
        if (mCirenAdapter == null) {
            mCirenAdapter = new CirenAdapter(getCirens(CirenApplication.getInstance().getApplicationContext())) {
                @Override
                protected void onItemSelected(Ciren ciren) {
                    if (cirenBinder != null)
                        cirenBinder.onItemCirenSelected(ciren);
                }
            };
        }
        deliverAdapter();


    }

    private ArrayList<Ciren> getCirens(Context context) {
        String cirenNames[] = context.getResources().getStringArray(R.array.cirens);
        TypedArray array = context.getResources().obtainTypedArray(R.array.cirens_icons);
        ArrayList<Ciren> cirens = new ArrayList<>();
        for (int i = 0; i < cirenNames.length; i++) {
            cirens.add(new Ciren(array.getResourceId(i, R.drawable.car_theft), cirenNames[i]));
        }
        return cirens;
    }

    private void deliverAdapter() {
        if (cirenBinder != null) {
            cirenBinder.deliverAdapter(mCirenAdapter);
        }
    }
}
