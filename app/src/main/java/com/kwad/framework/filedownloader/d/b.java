package com.kwad.framework.filedownloader.d;

import android.os.Parcel;
import android.os.Parcelable;
import com.kwad.sdk.utils.au;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.kwad.framework.filedownloader.d.b.1
        private static b b(Parcel parcel) {
            return new b(parcel);
        }

        private static b[] bD(int i10) {
            return new b[i10];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ b createFromParcel(Parcel parcel) {
            return b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ b[] newArray(int i10) {
            return bD(i10);
        }
    };
    private HashMap<String, List<String>> akL;

    /* renamed from: com.kwad.framework.filedownloader.d.b$1 */
    public class AnonymousClass1 implements Parcelable.Creator<b> {
        private static b b(Parcel parcel) {
            return new b(parcel);
        }

        private static b[] bD(int i10) {
            return new b[i10];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ b createFromParcel(Parcel parcel) {
            return b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ b[] newArray(int i10) {
            return bD(i10);
        }
    }

    public b() {
    }

    public final void bq(String str) {
        HashMap<String, List<String>> hashMap = this.akL;
        if (hashMap == null) {
            return;
        }
        hashMap.remove(str);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return this.akL.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeMap(this.akL);
    }

    public final void x(String str, String str2) {
        au.gV(str);
        au.gV(str2);
        if (this.akL == null) {
            this.akL = new HashMap<>();
        }
        List<String> list = this.akL.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.akL.put(str, list);
        }
        if (list.contains(str2)) {
            return;
        }
        list.add(str2);
    }

    public final HashMap<String, List<String>> xs() {
        return this.akL;
    }

    public b(Parcel parcel) {
        this.akL = parcel.readHashMap(String.class.getClassLoader());
    }
}
