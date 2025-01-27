package com.kwad.components.ad.reward;

import androidx.annotation.Nullable;
import com.kwad.components.core.webview.tachikoma.b.q;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public final class c {
    private final Set<com.kwad.components.ad.reward.e.m> pK;

    /* renamed from: com.kwad.components.ad.reward.c$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ q pL;

        public AnonymousClass1(q qVar) {
            qVar = qVar;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            c.this.b(qVar);
        }
    }

    public static class a {
        private static final c pN = new c((byte) 0);
    }

    public /* synthetic */ c(byte b10) {
        this();
    }

    public static c fy() {
        return a.pN;
    }

    public final void b(com.kwad.components.ad.reward.e.m mVar) {
        this.pK.remove(mVar);
    }

    public final void c(@Nullable q qVar) {
        bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.reward.c.1
            final /* synthetic */ q pL;

            public AnonymousClass1(q qVar2) {
                qVar = qVar2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                c.this.b(qVar);
            }
        });
    }

    private c() {
        this.pK = new HashSet();
    }

    public void b(@Nullable q qVar) {
        if (this.pK.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.m> it = this.pK.iterator();
        while (it.hasNext()) {
            it.next().a(qVar);
        }
    }

    public final void a(com.kwad.components.ad.reward.e.m mVar) {
        if (mVar != null) {
            this.pK.add(mVar);
        }
    }
}
