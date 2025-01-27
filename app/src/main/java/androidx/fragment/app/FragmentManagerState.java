package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new Parcelable.Creator<FragmentManagerState>() { // from class: androidx.fragment.app.FragmentManagerState.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public FragmentManagerState[] newArray(int i2) {
            return new FragmentManagerState[i2];
        }
    };

    /* renamed from: a */
    ArrayList<FragmentState> f2394a;

    /* renamed from: b */
    ArrayList<String> f2395b;

    /* renamed from: c */
    BackStackState[] f2396c;

    /* renamed from: d */
    String f2397d;

    /* renamed from: e */
    int f2398e;

    /* renamed from: androidx.fragment.app.FragmentManagerState$1 */
    static class AnonymousClass1 implements Parcelable.Creator<FragmentManagerState> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public FragmentManagerState[] newArray(int i2) {
            return new FragmentManagerState[i2];
        }
    }

    public FragmentManagerState() {
        this.f2397d = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.f2394a);
        parcel.writeStringList(this.f2395b);
        parcel.writeTypedArray(this.f2396c, i2);
        parcel.writeString(this.f2397d);
        parcel.writeInt(this.f2398e);
    }

    public FragmentManagerState(Parcel parcel) {
        this.f2397d = null;
        this.f2394a = parcel.createTypedArrayList(FragmentState.CREATOR);
        this.f2395b = parcel.createStringArrayList();
        this.f2396c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
        this.f2397d = parcel.readString();
        this.f2398e = parcel.readInt();
    }
}
