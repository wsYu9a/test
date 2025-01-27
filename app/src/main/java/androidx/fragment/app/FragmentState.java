package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new Parcelable.Creator<FragmentState>() { // from class: androidx.fragment.app.FragmentState.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public FragmentState[] newArray(int i2) {
            return new FragmentState[i2];
        }
    };

    /* renamed from: a */
    final String f2412a;

    /* renamed from: b */
    final String f2413b;

    /* renamed from: c */
    final boolean f2414c;

    /* renamed from: d */
    final int f2415d;

    /* renamed from: e */
    final int f2416e;

    /* renamed from: f */
    final String f2417f;

    /* renamed from: g */
    final boolean f2418g;

    /* renamed from: h */
    final boolean f2419h;

    /* renamed from: i */
    final boolean f2420i;

    /* renamed from: j */
    final Bundle f2421j;
    final boolean k;
    final int l;
    Bundle m;
    Fragment n;

    /* renamed from: androidx.fragment.app.FragmentState$1 */
    static class AnonymousClass1 implements Parcelable.Creator<FragmentState> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public FragmentState[] newArray(int i2) {
            return new FragmentState[i2];
        }
    }

    FragmentState(Fragment fragment) {
        this.f2412a = fragment.getClass().getName();
        this.f2413b = fragment.mWho;
        this.f2414c = fragment.mFromLayout;
        this.f2415d = fragment.mFragmentId;
        this.f2416e = fragment.mContainerId;
        this.f2417f = fragment.mTag;
        this.f2418g = fragment.mRetainInstance;
        this.f2419h = fragment.mRemoving;
        this.f2420i = fragment.mDetached;
        this.f2421j = fragment.mArguments;
        this.k = fragment.mHidden;
        this.l = fragment.mMaxState.ordinal();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull FragmentFactory fragmentFactory) {
        if (this.n == null) {
            Bundle bundle = this.f2421j;
            if (bundle != null) {
                bundle.setClassLoader(classLoader);
            }
            Fragment instantiate = fragmentFactory.instantiate(classLoader, this.f2412a);
            this.n = instantiate;
            instantiate.setArguments(this.f2421j);
            Bundle bundle2 = this.m;
            if (bundle2 != null) {
                bundle2.setClassLoader(classLoader);
                this.n.mSavedFragmentState = this.m;
            } else {
                this.n.mSavedFragmentState = new Bundle();
            }
            Fragment fragment = this.n;
            fragment.mWho = this.f2413b;
            fragment.mFromLayout = this.f2414c;
            fragment.mRestored = true;
            fragment.mFragmentId = this.f2415d;
            fragment.mContainerId = this.f2416e;
            fragment.mTag = this.f2417f;
            fragment.mRetainInstance = this.f2418g;
            fragment.mRemoving = this.f2419h;
            fragment.mDetached = this.f2420i;
            fragment.mHidden = this.k;
            fragment.mMaxState = Lifecycle.State.values()[this.l];
            if (FragmentManagerImpl.f2354c) {
                Log.v("FragmentManager", "Instantiated fragment " + this.n);
            }
        }
        return this.n;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f2412a);
        sb.append(" (");
        sb.append(this.f2413b);
        sb.append(")}:");
        if (this.f2414c) {
            sb.append(" fromLayout");
        }
        if (this.f2416e != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f2416e));
        }
        String str = this.f2417f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f2417f);
        }
        if (this.f2418g) {
            sb.append(" retainInstance");
        }
        if (this.f2419h) {
            sb.append(" removing");
        }
        if (this.f2420i) {
            sb.append(" detached");
        }
        if (this.k) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f2412a);
        parcel.writeString(this.f2413b);
        parcel.writeInt(this.f2414c ? 1 : 0);
        parcel.writeInt(this.f2415d);
        parcel.writeInt(this.f2416e);
        parcel.writeString(this.f2417f);
        parcel.writeInt(this.f2418g ? 1 : 0);
        parcel.writeInt(this.f2419h ? 1 : 0);
        parcel.writeInt(this.f2420i ? 1 : 0);
        parcel.writeBundle(this.f2421j);
        parcel.writeInt(this.k ? 1 : 0);
        parcel.writeBundle(this.m);
        parcel.writeInt(this.l);
    }

    FragmentState(Parcel parcel) {
        this.f2412a = parcel.readString();
        this.f2413b = parcel.readString();
        this.f2414c = parcel.readInt() != 0;
        this.f2415d = parcel.readInt();
        this.f2416e = parcel.readInt();
        this.f2417f = parcel.readString();
        this.f2418g = parcel.readInt() != 0;
        this.f2419h = parcel.readInt() != 0;
        this.f2420i = parcel.readInt() != 0;
        this.f2421j = parcel.readBundle();
        this.k = parcel.readInt() != 0;
        this.m = parcel.readBundle();
        this.l = parcel.readInt();
    }
}
