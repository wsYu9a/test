package com.kwad.components.ad.reward;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public final class a {
    private final Set<com.kwad.components.ad.reward.e.j> pC;

    /* renamed from: com.kwad.components.ad.reward.a$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ PlayableSource pD;
        final /* synthetic */ com.kwad.components.ad.reward.e.n pE;

        public AnonymousClass1(PlayableSource playableSource, com.kwad.components.ad.reward.e.n nVar) {
            playableSource = playableSource;
            nVar = nVar;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            a.this.b(playableSource, nVar);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.a$2 */
    public class AnonymousClass2 extends bd {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            a.this.fs();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.a$3 */
    public class AnonymousClass3 extends bd {
        final /* synthetic */ PlayableSource pD;

        public AnonymousClass3(PlayableSource playableSource) {
            playableSource = playableSource;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            a.this.c(playableSource);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.a$a */
    public static class C0391a {
        private static final a pG = new a((byte) 0);
    }

    public /* synthetic */ a(byte b10) {
        this();
    }

    public static a fr() {
        return C0391a.pG;
    }

    private void ft() {
        if (this.pC.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.j> it = this.pC.iterator();
        while (it.hasNext()) {
            it.next().cu();
        }
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public final void b(com.kwad.components.ad.reward.e.j jVar) {
        this.pC.remove(jVar);
    }

    public final void c(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.e.n nVar) {
        if (isMainThread()) {
            b(playableSource, nVar);
        } else {
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.reward.a.1
                final /* synthetic */ PlayableSource pD;
                final /* synthetic */ com.kwad.components.ad.reward.e.n pE;

                public AnonymousClass1(PlayableSource playableSource2, com.kwad.components.ad.reward.e.n nVar2) {
                    playableSource = playableSource2;
                    nVar = nVar2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    a.this.b(playableSource, nVar);
                }
            });
        }
    }

    public final void fs() {
        if (isMainThread()) {
            ft();
        } else {
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.reward.a.2
                public AnonymousClass2() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    a.this.fs();
                }
            });
        }
    }

    private a() {
        this.pC = new HashSet();
    }

    public void b(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.e.n nVar) {
        if (this.pC.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.j> it = this.pC.iterator();
        while (it.hasNext()) {
            it.next().a(playableSource, nVar);
        }
    }

    public final void a(com.kwad.components.ad.reward.e.j jVar) {
        if (jVar != null) {
            this.pC.add(jVar);
        }
    }

    public void c(PlayableSource playableSource) {
        if (this.pC.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.j> it = this.pC.iterator();
        while (it.hasNext()) {
            it.next().cv();
        }
    }

    public final void a(PlayableSource playableSource) {
        c(playableSource, null);
    }

    public final void b(PlayableSource playableSource) {
        if (isMainThread()) {
            c(playableSource);
        } else {
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.reward.a.3
                final /* synthetic */ PlayableSource pD;

                public AnonymousClass3(PlayableSource playableSource2) {
                    playableSource = playableSource2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    a.this.c(playableSource);
                }
            });
        }
    }
}
