package com.kwai.filedownloader.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.kwad.sdk.utils.ao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.kwai.filedownloader.c.b.1
        AnonymousClass1() {
        }

        private static b b(Parcel parcel) {
            return new b(parcel);
        }

        private static b[] da(int i2) {
            return new b[i2];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ b createFromParcel(Parcel parcel) {
            return b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ b[] newArray(int i2) {
            return da(i2);
        }
    };
    private HashMap<String, List<String>> aIH;

    /* renamed from: com.kwai.filedownloader.c.b$1 */
    static class AnonymousClass1 implements Parcelable.Creator<b> {
        AnonymousClass1() {
        }

        private static b b(Parcel parcel) {
            return new b(parcel);
        }

        private static b[] da(int i2) {
            return new b[i2];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ b createFromParcel(Parcel parcel) {
            return b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ b[] newArray(int i2) {
            return da(i2);
        }
    }

    public b() {
    }

    protected b(Parcel parcel) {
        this.aIH = parcel.readHashMap(String.class.getClassLoader());
    }

    public final HashMap<String, List<String>> IA() {
        return this.aIH;
    }

    public final void an(String str, String str2) {
        ao.eK(str);
        ao.eK(str2);
        if (this.aIH == null) {
            this.aIH = new HashMap<>();
        }
        List<String> list = this.aIH.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.aIH.put(str, list);
        }
        if (list.contains(str2)) {
            return;
        }
        list.add(str2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void fu(String str) {
        HashMap<String, List<String>> hashMap = this.aIH;
        if (hashMap == null) {
            return;
        }
        hashMap.remove(str);
    }

    public final String toString() {
        return this.aIH.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeMap(this.aIH);
    }
}
