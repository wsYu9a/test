package com.kwad.components.ad.reward.h.kwai;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.j;
import com.kwad.components.core.webview.a.b.d;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class b extends com.kwad.components.core.webview.a.b.d {
    private static WeakReference<b> xf;
    private long mPlayedDuration;
    private j xc;

    @Nullable
    public static b a(b bVar, Activity activity, long j2, com.kwad.components.core.webview.a.d.c cVar, d.a aVar) {
        if (activity == null || activity.isFinishing() || je()) {
            return null;
        }
        bVar.Pv = cVar;
        bVar.Vw = aVar;
        bVar.show(activity.getFragmentManager(), "tkCloseDialog");
        if (j2 > 0) {
            bVar.k(j2);
        }
        xf = new WeakReference<>(bVar);
        return bVar;
    }

    @Nullable
    public static b a(j jVar, Activity activity, long j2, DialogInterface.OnDismissListener onDismissListener, com.kwad.components.core.webview.a.d.c cVar) {
        if (activity == null || activity.isFinishing() || je()) {
            return null;
        }
        d.b bVar = new d.b();
        bVar.setAdTemplate(jVar.mAdTemplate);
        bVar.aP("ksad-video-secondclick-card");
        b a2 = a(jVar, bVar);
        a2.Pv = cVar;
        a2.d(onDismissListener);
        a2.k(j2);
        a2.show(activity.getFragmentManager(), "tkExtraReward");
        xf = new WeakReference<>(a2);
        return a2;
    }

    public static b a(j jVar, d.b bVar) {
        b bVar2 = new b();
        bVar2.xc = jVar;
        bVar2.mAdTemplate = bVar.getAdTemplate();
        bVar2.Vt = bVar.getTemplateId();
        bVar2.Vv = bVar.rl();
        bVar2.VD = bVar.rm();
        Bundle bundle = new Bundle();
        bundle.putString("templateId", bVar.getTemplateId());
        bVar2.setArguments(bundle);
        return bVar2;
    }

    private static boolean je() {
        WeakReference<b> weakReference = xf;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    private void k(long j2) {
        this.mPlayedDuration = j2;
        com.kwad.components.core.webview.a.b.b bVar = this.Vr;
        if (bVar != null) {
            bVar.mPlayedDuration = j2;
        }
    }

    @Override // com.kwad.components.core.webview.a.b.d
    public final com.kwad.components.core.webview.a.b.b jf() {
        return new a(this.xc);
    }

    @Override // com.kwad.components.core.webview.a.b.d
    public final com.kwad.components.core.webview.a.b.c jg() {
        return new c();
    }

    @Override // com.kwad.components.core.webview.a.b.d
    public final void jh() {
        super.jh();
        this.Vr.mPlayedDuration = this.mPlayedDuration;
    }

    @Override // com.kwad.components.core.webview.a.b.d, android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.xc = null;
        xf = null;
    }
}
