package com.shu.priory.a;

import android.media.AudioRecord;

/* loaded from: classes3.dex */
final class d {

    /* renamed from: a */
    private final int f16803a;

    public d(c cVar) {
        this.f16803a = AudioRecord.getMinBufferSize(cVar.c(), cVar.a(), cVar.d());
    }

    public int a() {
        return this.f16803a;
    }
}
