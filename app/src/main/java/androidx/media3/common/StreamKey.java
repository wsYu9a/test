package androidx.media3.common;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import p1.b;

@UnstableApi
/* loaded from: classes.dex */
public final class StreamKey implements Comparable<StreamKey>, Parcelable, Bundleable {
    public final int groupIndex;
    public final int periodIndex;
    public final int streamIndex;
    public static final Parcelable.Creator<StreamKey> CREATOR = new Parcelable.Creator<StreamKey>() { // from class: androidx.media3.common.StreamKey.1
        @Override // android.os.Parcelable.Creator
        public StreamKey createFromParcel(Parcel parcel) {
            return new StreamKey(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public StreamKey[] newArray(int i10) {
            return new StreamKey[i10];
        }
    };
    private static final String FIELD_PERIOD_INDEX = Util.intToStringMaxRadix(0);
    private static final String FIELD_GROUP_INDEX = Util.intToStringMaxRadix(1);
    private static final String FIELD_STREAM_INDEX = Util.intToStringMaxRadix(2);

    /* renamed from: androidx.media3.common.StreamKey$1 */
    public class AnonymousClass1 implements Parcelable.Creator<StreamKey> {
        @Override // android.os.Parcelable.Creator
        public StreamKey createFromParcel(Parcel parcel) {
            return new StreamKey(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public StreamKey[] newArray(int i10) {
            return new StreamKey[i10];
        }
    }

    public StreamKey(int i10, int i11) {
        this(0, i10, i11);
    }

    public static StreamKey fromBundle(Bundle bundle) {
        return new StreamKey(bundle.getInt(FIELD_PERIOD_INDEX, 0), bundle.getInt(FIELD_GROUP_INDEX, 0), bundle.getInt(FIELD_STREAM_INDEX, 0));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || StreamKey.class != obj.getClass()) {
            return false;
        }
        StreamKey streamKey = (StreamKey) obj;
        return this.periodIndex == streamKey.periodIndex && this.groupIndex == streamKey.groupIndex && this.streamIndex == streamKey.streamIndex;
    }

    public int hashCode() {
        return (((this.periodIndex * 31) + this.groupIndex) * 31) + this.streamIndex;
    }

    @Override // androidx.media3.common.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        int i10 = this.periodIndex;
        if (i10 != 0) {
            bundle.putInt(FIELD_PERIOD_INDEX, i10);
        }
        int i11 = this.groupIndex;
        if (i11 != 0) {
            bundle.putInt(FIELD_GROUP_INDEX, i11);
        }
        int i12 = this.streamIndex;
        if (i12 != 0) {
            bundle.putInt(FIELD_STREAM_INDEX, i12);
        }
        return bundle;
    }

    public String toString() {
        return this.periodIndex + b.f29697h + this.groupIndex + b.f29697h + this.streamIndex;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.periodIndex);
        parcel.writeInt(this.groupIndex);
        parcel.writeInt(this.streamIndex);
    }

    public StreamKey(int i10, int i11, int i12) {
        this.periodIndex = i10;
        this.groupIndex = i11;
        this.streamIndex = i12;
    }

    @Override // java.lang.Comparable
    public int compareTo(StreamKey streamKey) {
        int i10 = this.periodIndex - streamKey.periodIndex;
        if (i10 != 0) {
            return i10;
        }
        int i11 = this.groupIndex - streamKey.groupIndex;
        return i11 == 0 ? this.streamIndex - streamKey.streamIndex : i11;
    }

    public StreamKey(Parcel parcel) {
        this.periodIndex = parcel.readInt();
        this.groupIndex = parcel.readInt();
        this.streamIndex = parcel.readInt();
    }
}
