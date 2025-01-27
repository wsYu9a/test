package com.kwad.components.ad.reward.k;

import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public final class q extends y {

    /* renamed from: xc */
    private long f11723xc;
    private WeakReference<com.kwad.components.ad.reward.g> yR;

    public q(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.components.ad.reward.g gVar, long j10, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, @Nullable DialogInterface.OnDismissListener onDismissListener) {
        super(bVar, cVar, aVar, onDismissListener);
        this.f11723xc = j10;
        if (gVar != null) {
            this.yR = new WeakReference<>(gVar);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.y
    public final a.C0427a a(a.C0427a c0427a, com.kwad.sdk.core.webview.d.b.a aVar, AdTemplate adTemplate) {
        long j10;
        WeakReference<com.kwad.components.ad.reward.g> weakReference = this.yR;
        if (weakReference == null || weakReference.get() == null) {
            j10 = this.f11723xc;
            if (j10 <= 0) {
                j10 = 0;
            }
        } else {
            j10 = this.yR.get().f11689qf.getPlayDuration();
        }
        return super.a(c0427a, aVar, adTemplate).w(j10);
    }

    @Override // com.kwad.components.core.webview.jshandler.y
    public final void jC() {
        super.jC();
        if (this.YR != null) {
            com.kwad.components.ad.reward.c.a.hg().c(this.YR.getAdTemplate(), com.kwad.components.ad.reward.c.b.STATUS_NONE);
        }
    }
}
