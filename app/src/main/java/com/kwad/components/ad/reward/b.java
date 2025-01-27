package com.kwad.components.ad.reward;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.utils.bi;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class b {
    private final Set<com.kwad.components.ad.reward.d.h> oa;

    /* renamed from: com.kwad.components.ad.reward.b$1 */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ PlayableSource ob;
        final /* synthetic */ com.kwad.components.ad.reward.d.l oc;

        AnonymousClass1(PlayableSource playableSource, com.kwad.components.ad.reward.d.l lVar) {
            playableSource = playableSource;
            lVar = lVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.this.b(playableSource, lVar);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.b$2 */
    final class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.this.fg();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.b$3 */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ PlayableSource ob;

        AnonymousClass3(PlayableSource playableSource) {
            playableSource = playableSource;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.this.c(playableSource);
        }
    }

    static class a {
        private static final b oe = new b((byte) 0);
    }

    private b() {
        this.oa = new HashSet();
    }

    /* synthetic */ b(byte b2) {
        this();
    }

    public void b(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.d.l lVar) {
        if (this.oa.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.d.h> it = this.oa.iterator();
        while (it.hasNext()) {
            it.next().a(playableSource, lVar);
        }
    }

    public void c(PlayableSource playableSource) {
        if (this.oa.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.d.h> it = this.oa.iterator();
        while (it.hasNext()) {
            it.next().cb();
        }
    }

    public static b ff() {
        return a.oe;
    }

    private void fh() {
        if (this.oa.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.d.h> it = this.oa.iterator();
        while (it.hasNext()) {
            it.next().ca();
        }
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public final void a(com.kwad.components.ad.reward.d.h hVar) {
        if (hVar != null) {
            this.oa.add(hVar);
        }
    }

    public final void a(PlayableSource playableSource) {
        c(playableSource, null);
    }

    public final void b(com.kwad.components.ad.reward.d.h hVar) {
        this.oa.remove(hVar);
    }

    public final void b(PlayableSource playableSource) {
        if (isMainThread()) {
            c(playableSource);
        } else {
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.b.3
                final /* synthetic */ PlayableSource ob;

                AnonymousClass3(PlayableSource playableSource2) {
                    playableSource = playableSource2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    b.this.c(playableSource);
                }
            });
        }
    }

    public final void c(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.d.l lVar) {
        if (isMainThread()) {
            b(playableSource, lVar);
        } else {
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.b.1
                final /* synthetic */ PlayableSource ob;
                final /* synthetic */ com.kwad.components.ad.reward.d.l oc;

                AnonymousClass1(PlayableSource playableSource2, com.kwad.components.ad.reward.d.l lVar2) {
                    playableSource = playableSource2;
                    lVar = lVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    b.this.b(playableSource, lVar);
                }
            });
        }
    }

    public final void fg() {
        if (isMainThread()) {
            fh();
        } else {
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.b.2
                AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    b.this.fg();
                }
            });
        }
    }
}
