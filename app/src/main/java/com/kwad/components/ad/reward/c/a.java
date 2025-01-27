package com.kwad.components.ad.reward.c;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.z;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class a {
    private static volatile a sH;
    private g rO;

    @Nullable
    private b sI;
    private volatile boolean sJ = false;
    private volatile boolean sK = false;
    private List<WeakReference<i>> sL = new CopyOnWriteArrayList();

    private a() {
    }

    public static a hg() {
        if (sH == null) {
            synchronized (a.class) {
                try {
                    if (sH == null) {
                        sH = new a();
                    }
                } finally {
                }
            }
        }
        return sH;
    }

    private synchronized boolean hi() {
        b bVar = this.sI;
        if (bVar != null) {
            if (bVar.sP == b.sM) {
                return true;
            }
        }
        return false;
    }

    private boolean isNeoScan() {
        AdGlobalConfigInfo adGlobalConfigInfo = this.rO.mAdResultData.adGlobalConfigInfo;
        return adGlobalConfigInfo != null && adGlobalConfigInfo.neoPageType == 1;
    }

    public final void O(Context context) {
        boolean hi2 = hi();
        com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "checkStatusAndToast isCurrentHadExtra: " + hi2 + ", hadToast: " + this.sK);
        if (this.sK || !hi2) {
            return;
        }
        this.sK = true;
        z.P(context, "恭喜获得第2份奖励");
    }

    public final synchronized void a(AdTemplate adTemplate, b bVar) {
        if (adTemplate == null) {
            return;
        }
        try {
            com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "updateExtraReward: " + bVar.toJson().toString());
            this.sI = bVar;
            if (bVar.sP == b.sM && !this.sJ) {
                this.sJ = true;
                c.a(this.sI, com.kwad.components.ad.reward.e.f.J(adTemplate.getUniqueId()));
                com.kwad.sdk.core.adlog.c.j(adTemplate, isNeoScan());
            }
            for (WeakReference<i> weakReference : this.sL) {
                if (weakReference.get() == null) {
                    this.sL.remove(weakReference);
                } else {
                    b hh2 = hh();
                    com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "GetNativeDataHandler callback: " + hh2.toJson().toString());
                    weakReference.get().a(hh2);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void c(AdTemplate adTemplate, int i10) {
        com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "updateExtraReward: " + i10);
        g gVar = this.rO;
        if (gVar != null && gVar.gh() && i10 == b.STATUS_NONE) {
            com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "updateExtraReward: cant update to status 2");
            return;
        }
        b hh2 = hg().hh();
        hh2.N(i10);
        hg().a(adTemplate, hh2);
    }

    @NonNull
    public final synchronized b hh() {
        try {
            if (this.sI == null) {
                b hk2 = c.hk();
                this.sI = hk2;
                hk2.sP = 0;
            }
            com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "getCurrentExtraReward: " + this.sI.sP);
        } catch (Throwable th2) {
            throw th2;
        }
        return this.sI;
    }

    public final synchronized void reset() {
        this.sI = null;
        this.sK = false;
        this.sJ = false;
        this.rO = null;
    }

    public final void setCallerContext(g gVar) {
        this.rO = gVar;
    }

    public final void a(i iVar) {
        com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "addGetNativeHandler: " + iVar);
        if (iVar != null) {
            this.sL.add(new WeakReference<>(iVar));
        }
    }
}
