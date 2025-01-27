package androidx.navigation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.UUID;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class NavBackStackEntryState implements Parcelable {
    public static final Parcelable.Creator<NavBackStackEntryState> CREATOR = new Parcelable.Creator<NavBackStackEntryState>() { // from class: androidx.navigation.NavBackStackEntryState.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public NavBackStackEntryState createFromParcel(Parcel parcel) {
            return new NavBackStackEntryState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public NavBackStackEntryState[] newArray(int i2) {
            return new NavBackStackEntryState[i2];
        }
    };

    /* renamed from: a */
    private final UUID f2955a;

    /* renamed from: b */
    private final int f2956b;

    /* renamed from: c */
    private final Bundle f2957c;

    /* renamed from: d */
    private final Bundle f2958d;

    /* renamed from: androidx.navigation.NavBackStackEntryState$1 */
    class AnonymousClass1 implements Parcelable.Creator<NavBackStackEntryState> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public NavBackStackEntryState createFromParcel(Parcel parcel) {
            return new NavBackStackEntryState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public NavBackStackEntryState[] newArray(int i2) {
            return new NavBackStackEntryState[i2];
        }
    }

    NavBackStackEntryState(NavBackStackEntry navBackStackEntry) {
        this.f2955a = navBackStackEntry.f2948f;
        this.f2956b = navBackStackEntry.getDestination().getId();
        this.f2957c = navBackStackEntry.getArguments();
        Bundle bundle = new Bundle();
        this.f2958d = bundle;
        navBackStackEntry.e(bundle);
    }

    @Nullable
    Bundle a() {
        return this.f2957c;
    }

    int b() {
        return this.f2956b;
    }

    @NonNull
    Bundle d() {
        return this.f2958d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    UUID e() {
        return this.f2955a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeString(this.f2955a.toString());
        parcel.writeInt(this.f2956b);
        parcel.writeBundle(this.f2957c);
        parcel.writeBundle(this.f2958d);
    }

    NavBackStackEntryState(Parcel parcel) {
        this.f2955a = UUID.fromString(parcel.readString());
        this.f2956b = parcel.readInt();
        this.f2957c = parcel.readBundle(NavBackStackEntryState.class.getClassLoader());
        this.f2958d = parcel.readBundle(NavBackStackEntryState.class.getClassLoader());
    }
}
