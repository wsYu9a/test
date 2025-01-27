package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class j extends SparseIntArray implements Parcelable {
    public static final Parcelable.Creator<j> CREATOR = new a();

    static class a implements Parcelable.Creator<j> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public j createFromParcel(@NonNull Parcel parcel) {
            int readInt = parcel.readInt();
            j jVar = new j(readInt);
            int[] iArr = new int[readInt];
            int[] iArr2 = new int[readInt];
            parcel.readIntArray(iArr);
            parcel.readIntArray(iArr2);
            for (int i2 = 0; i2 < readInt; i2++) {
                jVar.put(iArr[i2], iArr2[i2]);
            }
            return jVar;
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public j[] newArray(int i2) {
            return new j[i2];
        }
    }

    public j() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        int[] iArr = new int[size()];
        int[] iArr2 = new int[size()];
        for (int i3 = 0; i3 < size(); i3++) {
            iArr[i3] = keyAt(i3);
            iArr2[i3] = valueAt(i3);
        }
        parcel.writeInt(size());
        parcel.writeIntArray(iArr);
        parcel.writeIntArray(iArr2);
    }

    public j(int i2) {
        super(i2);
    }

    public j(@NonNull SparseIntArray sparseIntArray) {
        for (int i2 = 0; i2 < sparseIntArray.size(); i2++) {
            put(sparseIntArray.keyAt(i2), sparseIntArray.valueAt(i2));
        }
    }
}
