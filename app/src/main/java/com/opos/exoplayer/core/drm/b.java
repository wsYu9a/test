package com.opos.exoplayer.core.drm;

import android.annotation.TargetApi;
import android.os.Looper;
import com.opos.exoplayer.core.drm.c;

@TargetApi(16)
/* loaded from: classes4.dex */
public interface b<T extends c> {
    a<T> a(Looper looper, DrmInitData drmInitData);

    void a(a<T> aVar);

    boolean a(DrmInitData drmInitData);
}
