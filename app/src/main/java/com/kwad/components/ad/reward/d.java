package com.kwad.components.ad.reward;

import androidx.annotation.Nullable;
import com.kwad.components.core.webview.a.a.r;
import com.kwad.sdk.utils.bi;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class d {
    private final Set<com.kwad.components.ad.reward.d.k> oi;

    /* renamed from: com.kwad.components.ad.reward.d$1 */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ r oj;

        AnonymousClass1(r rVar) {
            rVar = rVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.this.b(rVar);
        }
    }

    static class a {
        private static final d ol = new d((byte) 0);
    }

    private d() {
        this.oi = new HashSet();
    }

    /* synthetic */ d(byte b2) {
        this();
    }

    public void b(@Nullable r rVar) {
        if (this.oi.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.d.k> it = this.oi.iterator();
        while (it.hasNext()) {
            it.next().a(rVar);
        }
    }

    public static d fm() {
        return a.ol;
    }

    public final void a(com.kwad.components.ad.reward.d.k kVar) {
        if (kVar != null) {
            this.oi.add(kVar);
        }
    }

    public final void b(com.kwad.components.ad.reward.d.k kVar) {
        this.oi.remove(kVar);
    }

    public final void c(@Nullable r rVar) {
        bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.d.1
            final /* synthetic */ r oj;

            AnonymousClass1(r rVar2) {
                rVar = rVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                d.this.b(rVar);
            }
        });
    }
}
