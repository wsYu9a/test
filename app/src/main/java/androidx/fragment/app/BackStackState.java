package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator<BackStackState>() { // from class: androidx.fragment.app.BackStackState.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public BackStackState[] newArray(int i2) {
            return new BackStackState[i2];
        }
    };

    /* renamed from: a */
    final int[] f2318a;

    /* renamed from: b */
    final ArrayList<String> f2319b;

    /* renamed from: c */
    final int[] f2320c;

    /* renamed from: d */
    final int[] f2321d;

    /* renamed from: e */
    final int f2322e;

    /* renamed from: f */
    final int f2323f;

    /* renamed from: g */
    final String f2324g;

    /* renamed from: h */
    final int f2325h;

    /* renamed from: i */
    final int f2326i;

    /* renamed from: j */
    final CharSequence f2327j;
    final int k;
    final CharSequence l;
    final ArrayList<String> m;
    final ArrayList<String> n;
    final boolean o;

    /* renamed from: androidx.fragment.app.BackStackState$1 */
    static class AnonymousClass1 implements Parcelable.Creator<BackStackState> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public BackStackState[] newArray(int i2) {
            return new BackStackState[i2];
        }
    }

    public BackStackState(BackStackRecord backStackRecord) {
        int size = backStackRecord.l.size();
        this.f2318a = new int[size * 5];
        if (!backStackRecord.s) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f2319b = new ArrayList<>(size);
        this.f2320c = new int[size];
        this.f2321d = new int[size];
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            FragmentTransaction.Op op = backStackRecord.l.get(i2);
            int i4 = i3 + 1;
            this.f2318a[i3] = op.f2454a;
            ArrayList<String> arrayList = this.f2319b;
            Fragment fragment = op.f2455b;
            arrayList.add(fragment != null ? fragment.mWho : null);
            int[] iArr = this.f2318a;
            int i5 = i4 + 1;
            iArr[i4] = op.f2456c;
            int i6 = i5 + 1;
            iArr[i5] = op.f2457d;
            int i7 = i6 + 1;
            iArr[i6] = op.f2458e;
            iArr[i7] = op.f2459f;
            this.f2320c[i2] = op.f2460g.ordinal();
            this.f2321d[i2] = op.f2461h.ordinal();
            i2++;
            i3 = i7 + 1;
        }
        this.f2322e = backStackRecord.q;
        this.f2323f = backStackRecord.r;
        this.f2324g = backStackRecord.u;
        this.f2325h = backStackRecord.G;
        this.f2326i = backStackRecord.v;
        this.f2327j = backStackRecord.w;
        this.k = backStackRecord.x;
        this.l = backStackRecord.y;
        this.m = backStackRecord.z;
        this.n = backStackRecord.A;
        this.o = backStackRecord.B;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BackStackRecord instantiate(FragmentManagerImpl fragmentManagerImpl) {
        BackStackRecord backStackRecord = new BackStackRecord(fragmentManagerImpl);
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f2318a.length) {
            FragmentTransaction.Op op = new FragmentTransaction.Op();
            int i4 = i2 + 1;
            op.f2454a = this.f2318a[i2];
            if (FragmentManagerImpl.f2354c) {
                Log.v("FragmentManager", "Instantiate " + backStackRecord + " op #" + i3 + " base fragment #" + this.f2318a[i4]);
            }
            String str = this.f2319b.get(i3);
            if (str != null) {
                op.f2455b = fragmentManagerImpl.p.get(str);
            } else {
                op.f2455b = null;
            }
            op.f2460g = Lifecycle.State.values()[this.f2320c[i3]];
            op.f2461h = Lifecycle.State.values()[this.f2321d[i3]];
            int[] iArr = this.f2318a;
            int i5 = i4 + 1;
            int i6 = iArr[i4];
            op.f2456c = i6;
            int i7 = i5 + 1;
            int i8 = iArr[i5];
            op.f2457d = i8;
            int i9 = i7 + 1;
            int i10 = iArr[i7];
            op.f2458e = i10;
            int i11 = iArr[i9];
            op.f2459f = i11;
            backStackRecord.m = i6;
            backStackRecord.n = i8;
            backStackRecord.o = i10;
            backStackRecord.p = i11;
            backStackRecord.a(op);
            i3++;
            i2 = i9 + 1;
        }
        backStackRecord.q = this.f2322e;
        backStackRecord.r = this.f2323f;
        backStackRecord.u = this.f2324g;
        backStackRecord.G = this.f2325h;
        backStackRecord.s = true;
        backStackRecord.v = this.f2326i;
        backStackRecord.w = this.f2327j;
        backStackRecord.x = this.k;
        backStackRecord.y = this.l;
        backStackRecord.z = this.m;
        backStackRecord.A = this.n;
        backStackRecord.B = this.o;
        backStackRecord.c(1);
        return backStackRecord;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeIntArray(this.f2318a);
        parcel.writeStringList(this.f2319b);
        parcel.writeIntArray(this.f2320c);
        parcel.writeIntArray(this.f2321d);
        parcel.writeInt(this.f2322e);
        parcel.writeInt(this.f2323f);
        parcel.writeString(this.f2324g);
        parcel.writeInt(this.f2325h);
        parcel.writeInt(this.f2326i);
        TextUtils.writeToParcel(this.f2327j, parcel, 0);
        parcel.writeInt(this.k);
        TextUtils.writeToParcel(this.l, parcel, 0);
        parcel.writeStringList(this.m);
        parcel.writeStringList(this.n);
        parcel.writeInt(this.o ? 1 : 0);
    }

    public BackStackState(Parcel parcel) {
        this.f2318a = parcel.createIntArray();
        this.f2319b = parcel.createStringArrayList();
        this.f2320c = parcel.createIntArray();
        this.f2321d = parcel.createIntArray();
        this.f2322e = parcel.readInt();
        this.f2323f = parcel.readInt();
        this.f2324g = parcel.readString();
        this.f2325h = parcel.readInt();
        this.f2326i = parcel.readInt();
        this.f2327j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.k = parcel.readInt();
        this.l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.m = parcel.createStringArrayList();
        this.n = parcel.createStringArrayList();
        this.o = parcel.readInt() != 0;
    }
}
