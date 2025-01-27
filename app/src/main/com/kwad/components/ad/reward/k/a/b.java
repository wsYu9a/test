package com.kwad.components.ad.reward.k.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.webview.tachikoma.c.e;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public final class b extends com.kwad.components.core.webview.tachikoma.c.e {
    private static WeakReference<b> yW;
    private g yT;
    private long yV;

    public static b a(g gVar, e.b bVar) {
        b bVar2 = new b();
        bVar2.yT = gVar;
        bVar2.mAdResultData = bVar.hF();
        bVar2.yP = bVar.getTemplateId();
        bVar2.adH = bVar.kz();
        bVar2.adR = bVar.ue();
        Bundle bundle = new Bundle();
        bundle.putString("templateId", bVar.getTemplateId());
        bVar2.setArguments(bundle);
        return bVar2;
    }

    private static boolean jE() {
        WeakReference<b> weakReference = yW;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    private void l(long j10) {
        this.yV = j10;
        com.kwad.components.core.webview.tachikoma.c.b bVar = this.adD;
        if (bVar != null) {
            bVar.yV = j10;
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.e
    public final com.kwad.components.core.webview.tachikoma.c.b jF() {
        return new a(this.yT);
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.e
    public final com.kwad.components.core.webview.tachikoma.c.c jG() {
        return new c();
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.e
    public final void jH() {
        super.jH();
        this.adD.yV = this.yV;
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.e, android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.yT = null;
        yW = null;
    }

    @Nullable
    public static b a(b bVar, Activity activity, long j10, com.kwad.components.core.webview.tachikoma.e.c cVar, e.a aVar) {
        if (activity == null || activity.isFinishing() || jE()) {
            return null;
        }
        bVar.Vf = cVar;
        bVar.adI = aVar;
        bVar.show(activity.getFragmentManager(), "tkCloseDialog");
        if (j10 > 0) {
            bVar.l(j10);
        }
        yW = new WeakReference<>(bVar);
        return bVar;
    }

    @Nullable
    public static b a(g gVar, Activity activity, long j10, DialogInterface.OnDismissListener onDismissListener, com.kwad.components.core.webview.tachikoma.e.c cVar) {
        if (activity == null || activity.isFinishing() || jE()) {
            return null;
        }
        e.b bVar = new e.b();
        bVar.a(gVar.mAdResultData);
        bVar.aZ(com.kwad.sdk.core.response.b.b.dG(gVar.mAdTemplate));
        b a10 = a(gVar, bVar);
        a10.Vf = cVar;
        a10.d(onDismissListener);
        a10.l(j10);
        a10.show(activity.getFragmentManager(), "tkExtraReward");
        yW = new WeakReference<>(a10);
        return a10;
    }
}
