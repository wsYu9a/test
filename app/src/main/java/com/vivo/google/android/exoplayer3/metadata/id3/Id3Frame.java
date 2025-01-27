package com.vivo.google.android.exoplayer3.metadata.id3;

import com.vivo.google.android.exoplayer3.g1;
import com.vivo.google.android.exoplayer3.metadata.Metadata;

/* loaded from: classes4.dex */
public abstract class Id3Frame implements Metadata.Entry {

    /* renamed from: a */
    public final String f27803a;

    public Id3Frame(String str) {
        this.f27803a = (String) g1.a(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
