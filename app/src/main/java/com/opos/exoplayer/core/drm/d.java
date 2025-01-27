package com.opos.exoplayer.core.drm;

import android.annotation.TargetApi;
import android.media.MediaCrypto;

@TargetApi(16)
/* loaded from: classes4.dex */
public final class d implements c {

    /* renamed from: a */
    private final MediaCrypto f18376a;

    /* renamed from: b */
    private final boolean f18377b;

    public MediaCrypto a() {
        return this.f18376a;
    }

    public boolean a(String str) {
        return !this.f18377b && this.f18376a.requiresSecureDecoderComponent(str);
    }
}
