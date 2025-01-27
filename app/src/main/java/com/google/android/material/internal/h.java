package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class h extends SparseArray<Parcelable> implements Parcelable {
    public static final Parcelable.Creator<h> CREATOR = new a();

    static class a implements Parcelable.ClassLoaderCreator<h> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public h createFromParcel(@NonNull Parcel parcel) {
            return new h(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public h createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
            return new h(parcel, classLoader);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public h[] newArray(int i2) {
            return new h[i2];
        }
    }

    public h() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        int size = size();
        int[] iArr = new int[size];
        Parcelable[] parcelableArr = new Parcelable[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr[i3] = keyAt(i3);
            parcelableArr[i3] = valueAt(i3);
        }
        parcel.writeInt(size);
        parcel.writeIntArray(iArr);
        parcel.writeParcelableArray(parcelableArr, i2);
    }

    public h(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
        int readInt = parcel.readInt();
        int[] iArr = new int[readInt];
        parcel.readIntArray(iArr);
        Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
        for (int i2 = 0; i2 < readInt; i2++) {
            put(iArr[i2], readParcelableArray[i2]);
        }
    }
}
