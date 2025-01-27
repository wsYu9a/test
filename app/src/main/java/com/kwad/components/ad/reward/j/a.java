package com.kwad.components.ad.reward.j;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import com.kwad.components.ad.reward.j;
import com.kwad.components.core.video.i;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.a.f;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.utils.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class a extends com.kwad.components.ad.h.a implements j.a {
    private boolean li;
    private Context mContext;
    private KsVideoPlayConfig mVideoPlayConfig;
    private VideoPlayerStatus mVideoPlayerStatus;
    private boolean nJ;
    private com.kwad.components.core.video.j nL;
    private j qt;
    private final List<InterfaceC0147a> xA;
    private OfflineOnAudioConflictListener xB;
    private String xv;
    private AtomicBoolean xw;
    private boolean xx;
    private boolean xy;
    private final List<h.a> xz;

    /* renamed from: com.kwad.components.ad.reward.j.a$1 */
    final class AnonymousClass1 implements OfflineOnAudioConflictListener {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            a.a(a.this, true);
            if (a.this.Gj != null) {
                a.this.Gj.setAudioEnabled(false);
            }
            synchronized (a.this.xz) {
                Iterator it = a.this.xz.iterator();
                while (it.hasNext()) {
                    ((h.a) it.next()).onAudioBeOccupied();
                }
            }
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeReleased() {
            synchronized (a.this.xz) {
                Iterator it = a.this.xz.iterator();
                while (it.hasNext()) {
                    ((h.a) it.next()).onAudioBeReleased();
                }
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.j.a$2 */
    final class AnonymousClass2 extends com.kwad.components.core.video.j {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayError(int i2, int i3) {
            super.onVideoPlayError(i2, i3);
            com.kwad.components.core.m.a.pb().b(a.this.mAdTemplate, i2, i3);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.j.a$3 */
    final class AnonymousClass3 implements c.e {
        AnonymousClass3() {
        }

        @Override // com.kwad.sdk.core.video.kwai.c.e
        public final void a(c cVar) {
            com.kwad.sdk.core.b.b.vS();
            if (com.kwad.sdk.core.b.b.isAppOnForeground()) {
                a.this.Gj.start();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.j.a$a */
    public interface InterfaceC0147a {
        void iX();
    }

    public a(j jVar, boolean z) {
        super(jVar.mAdTemplate, jVar.oM);
        this.xw = new AtomicBoolean(false);
        this.xx = false;
        this.xy = false;
        this.li = false;
        this.xz = new ArrayList();
        this.xA = new ArrayList();
        this.xB = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.reward.j.a.1
            AnonymousClass1() {
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                a.a(a.this, true);
                if (a.this.Gj != null) {
                    a.this.Gj.setAudioEnabled(false);
                }
                synchronized (a.this.xz) {
                    Iterator it = a.this.xz.iterator();
                    while (it.hasNext()) {
                        ((h.a) it.next()).onAudioBeOccupied();
                    }
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
                synchronized (a.this.xz) {
                    Iterator it = a.this.xz.iterator();
                    while (it.hasNext()) {
                        ((h.a) it.next()).onAudioBeReleased();
                    }
                }
            }
        };
        this.qt = jVar;
        this.mContext = jVar.mContext;
        this.mVideoPlayConfig = jVar.mVideoPlayConfig;
        this.mVideoPlayerStatus = this.mAdTemplate.mVideoPlayerStatus;
        this.xx = z;
        this.xv = getVideoUrl();
    }

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.xy = true;
        return true;
    }

    private void aT() {
        if (jE()) {
            return;
        }
        this.Gj.a(new b.a(this.mAdTemplate).bs(this.xv).bt(f.b(d.cc(this.mAdTemplate))).a(this.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.kwai.kwai.a.ak(this.mAdTemplate)).tR(), this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.Gj.prepareAsync();
    }

    private String getVideoUrl() {
        if (jE()) {
            return "";
        }
        String E = com.kwad.sdk.core.response.a.a.E(d.cb(this.mAdTemplate));
        File aX = com.kwad.sdk.core.diskcache.a.a.vs().aX(E);
        return (aX == null || !aX.exists()) ? com.kwad.sdk.core.config.d.ux() > 0 ? com.kwad.sdk.core.videocache.b.a.ba(this.mContext).cS(E) : E : aX.getAbsolutePath();
    }

    private boolean jE() {
        return com.kwad.sdk.core.response.a.a.cq(d.cb(this.mAdTemplate));
    }

    private void stop() {
        pause();
        this.li = true;
    }

    public final void a(InterfaceC0147a interfaceC0147a) {
        this.xA.add(interfaceC0147a);
    }

    @MainThread
    public final void a(i iVar) {
        com.kwad.components.core.video.b bVar;
        if (iVar == null || (bVar = this.Gj) == null) {
            return;
        }
        bVar.c(iVar);
    }

    public final void a(h.a aVar) {
        this.xz.add(aVar);
    }

    public final void b(InterfaceC0147a interfaceC0147a) {
        this.xA.remove(interfaceC0147a);
    }

    @MainThread
    public final void b(i iVar) {
        com.kwad.components.core.video.b bVar;
        if (iVar == null || (bVar = this.Gj) == null) {
            return;
        }
        bVar.d(iVar);
    }

    public final void b(h.a aVar) {
        this.xz.remove(aVar);
    }

    @Override // com.kwad.components.ad.reward.j.a
    public final void gb() {
        this.xy = false;
    }

    @Override // com.kwad.components.ad.reward.j.a
    public final void gc() {
        if (this.li) {
            return;
        }
        resume();
        if (this.nJ || (com.kwad.components.ad.reward.kwai.b.gz() && this.xy)) {
            com.kwad.components.core.r.a.aj(this.mContext).aL(com.kwad.components.ad.reward.kwai.b.gz());
            if (com.kwad.components.ad.reward.kwai.b.gz() && this.xy) {
                this.xy = false;
                this.nJ = true;
                setAudioEnabled(true, false);
            } else {
                if (this.xx || !com.kwad.components.core.r.a.aj(this.mContext).pI()) {
                    return;
                }
                this.nJ = false;
                setAudioEnabled(false, false);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.j.a
    public final void gd() {
        pause();
    }

    @Override // com.kwad.components.ad.reward.j.a
    public final void ge() {
        com.kwad.components.core.video.b bVar;
        this.xy = false;
        if (!this.xw.get() || (bVar = this.Gj) == null) {
            return;
        }
        bVar.d(this.nL);
        this.Gj.release();
    }

    public final long getPlayDuration() {
        com.kwad.components.core.video.b bVar;
        if (!this.xw.get() || (bVar = this.Gj) == null) {
            return 0L;
        }
        return bVar.getPlayDuration();
    }

    public final void jB() {
        if (this.xw.get()) {
            return;
        }
        this.xw.set(true);
        aT();
        AnonymousClass2 anonymousClass2 = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.reward.j.a.2
            AnonymousClass2() {
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayError(int i2, int i3) {
                super.onVideoPlayError(i2, i3);
                com.kwad.components.core.m.a.pb().b(a.this.mAdTemplate, i2, i3);
            }
        };
        this.nL = anonymousClass2;
        this.Gj.c(anonymousClass2);
        this.Gj.a(new c.e() { // from class: com.kwad.components.ad.reward.j.a.3
            AnonymousClass3() {
            }

            @Override // com.kwad.sdk.core.video.kwai.c.e
            public final void a(c cVar) {
                com.kwad.sdk.core.b.b.vS();
                if (com.kwad.sdk.core.b.b.isAppOnForeground()) {
                    a.this.Gj.start();
                }
            }
        });
        com.kwad.components.core.r.a.aj(this.mContext).a(this.xB);
    }

    public final boolean jC() {
        return this.xx;
    }

    public final void jD() {
        Iterator<InterfaceC0147a> it = this.xA.iterator();
        while (it.hasNext()) {
            it.next().iX();
        }
    }

    public final void pause() {
        if (!this.xw.get() || this.Gj == null || jE() || j.e(this.qt)) {
            return;
        }
        this.Gj.pause();
    }

    @Override // com.kwad.components.ad.h.a
    @MainThread
    public final void release() {
        super.release();
        com.kwad.components.core.video.b bVar = this.Gj;
        if (bVar != null) {
            bVar.clear();
            this.Gj.release();
        }
        com.kwad.components.core.r.a.aj(this.mContext).b(this.xB);
    }

    @Override // com.kwad.components.ad.h.a
    @WorkerThread
    public final void releaseSync() {
        super.releaseSync();
        com.kwad.components.core.video.b bVar = this.Gj;
        if (bVar != null) {
            bVar.clear();
            this.Gj.releaseSync();
        }
        com.kwad.components.core.r.a.aj(this.mContext).b(this.xB);
    }

    public final void resume() {
        this.li = false;
        if (!this.xw.get() || this.Gj == null || jE() || j.e(this.qt)) {
            return;
        }
        this.Gj.resume();
    }

    public final void setAudioEnabled(boolean z, boolean z2) {
        this.nJ = z;
        if (!this.xw.get() || this.Gj == null) {
            return;
        }
        if (z && z2) {
            com.kwad.components.core.r.a.aj(this.mContext).aL(true);
        }
        this.Gj.setAudioEnabled(z);
    }

    @Deprecated
    public final void skipToEnd() {
        com.kwad.components.core.video.b bVar;
        if (!this.xw.get() || (bVar = this.Gj) == null) {
            return;
        }
        bVar.onPlayStateChanged(9);
        stop();
    }
}
