package xyz.belvi.ciren.models;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;

/**
 * Created by zone2 on 6/27/17.
 */

public class Ciren implements Parcelable {
    int resouceId;
    String name;

    public Ciren(int resouceId, String name) {
        this.resouceId = resouceId;
        this.name = name;
    }

    protected Ciren(Parcel in) {
        resouceId = in.readInt();
        name = in.readString();
    }

    public static final Creator<Ciren> CREATOR = new Creator<Ciren>() {
        @Override
        public Ciren createFromParcel(Parcel in) {
            return new Ciren(in);
        }

        @Override
        public Ciren[] newArray(int size) {
            return new Ciren[size];
        }
    };

    public int getResouceId() {
        return this.resouceId;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(resouceId);
        dest.writeString(name);
    }


}
