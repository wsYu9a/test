package com.opos.exoplayer.core.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public final class Metadata implements Parcelable {
    public static final Parcelable.Creator<Metadata> CREATOR = new Parcelable.Creator<Metadata>() { // from class: com.opos.exoplayer.core.metadata.Metadata.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Metadata createFromParcel(Parcel parcel) {
            return new Metadata(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Metadata[] newArray(int i2) {
            return new Metadata[0];
        }
    };

    /* renamed from: a */
    private final Entry[] f19095a;

    /* renamed from: com.opos.exoplayer.core.metadata.Metadata$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<Metadata> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Metadata createFromParcel(Parcel parcel) {
            return new Metadata(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Metadata[] newArray(int i2) {
            return new Metadata[0];
        }
    }

    public interface Entry extends Parcelable {
    }

    Metadata(Parcel parcel) {
        this.f19095a = new Entry[parcel.readInt()];
        int i2 = 0;
        while (true) {
            Entry[] entryArr = this.f19095a;
            if (i2 >= entryArr.length) {
                return;
            }
            entryArr[i2] = (Entry) parcel.readParcelable(Entry.class.getClassLoader());
            i2++;
        }
    }

    public Metadata(List<? extends Entry> list) {
        if (list == null) {
            this.f19095a = new Entry[0];
            return;
        }
        Entry[] entryArr = new Entry[list.size()];
        this.f19095a = entryArr;
        list.toArray(entryArr);
    }

    public Metadata(Entry... entryArr) {
        this.f19095a = entryArr == null ? new Entry[0] : entryArr;
    }

    public int a() {
        return this.f19095a.length;
    }

    public Entry a(int i2) {
        return this.f19095a[i2];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Metadata.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f19095a, ((Metadata) obj).f19095a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f19095a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f19095a.length);
        for (Entry entry : this.f19095a) {
            parcel.writeParcelable(entry, 0);
        }
    }
}
