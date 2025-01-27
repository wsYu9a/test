package com.kwad.components.ad.reward;

import android.os.Looper;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public final class b {
    private final Set<com.kwad.components.ad.reward.e.l> pH;

    /* renamed from: com.kwad.components.ad.reward.b$1 */
    public class AnonymousClass1 extends bd {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            b.this.notifyRewardVerify();
        }
    }

    public static class a {
        private static final b pJ = new b((byte) 0);
    }

    public /* synthetic */ b(byte b10) {
        this();
    }

    public static b fv() {
        return a.pJ;
    }

    private void fw() {
        if (this.pH.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.l> it = this.pH.iterator();
        while (it.hasNext()) {
            it.next().onRewardVerify();
        }
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public final void a(com.kwad.components.ad.reward.e.l lVar) {
        if (lVar != null) {
            this.pH.add(lVar);
        }
    }

    public final void b(com.kwad.components.ad.reward.e.l lVar) {
        this.pH.remove(lVar);
    }

    public final void notifyRewardVerify() {
        if (isMainThread()) {
            fw();
        } else {
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.reward.b.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    b.this.notifyRewardVerify();
                }
            });
        }
    }

    private b() {
        this.pH = new HashSet();
    }
}
