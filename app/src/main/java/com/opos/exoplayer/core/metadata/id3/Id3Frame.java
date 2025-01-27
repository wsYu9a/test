package com.opos.exoplayer.core.metadata.id3;

import com.opos.exoplayer.core.metadata.Metadata;

/* loaded from: classes4.dex */
public abstract class Id3Frame implements Metadata.Entry {

    /* renamed from: f */
    public final String f19138f;

    public Id3Frame(String str) {
        this.f19138f = (String) com.opos.exoplayer.core.i.a.a(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
