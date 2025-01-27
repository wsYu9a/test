package com.vivo.mobilead.unified.base.callback;

import com.vivo.mobilead.model.VivoAdError;

/* loaded from: classes4.dex */
public interface l extends com.vivo.mobilead.unified.base.view.u.b {
    void a();

    void a(com.vivo.ad.model.b bVar, int i2, int i3, int i4, int i5, boolean z);

    void a(com.vivo.ad.model.b bVar, int i2, int i3, int i4, int i5, boolean z, boolean z2);

    void a(VivoAdError vivoAdError);

    void b();

    void onAdShow();
}
