package com.kwad.components.ad.reward.m;

import android.content.Context;
import androidx.annotation.MainThread;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.j;
import com.kwad.components.core.video.l;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class d extends com.kwad.components.ad.l.b implements g.a {
    private boolean lX;
    private Context mContext;
    private KsVideoPlayConfig mVideoPlayConfig;
    private VideoPlayerStatus mVideoPlayerStatus;
    private boolean oI;
    private l oK;
    private g rO;
    private String zo;
    private AtomicBoolean zp;
    private boolean zq;
    private final List<i.a> zr;
    private final List<Object> zs;
    private OfflineOnAudioConflictListener zt;

    /* renamed from: com.kwad.components.ad.reward.m.d$1 */
    public class AnonymousClass1 implements OfflineOnAudioConflictListener {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            d.a(d.this, true);
            if (d.this.Js != null) {
                d.this.Js.setAudioEnabled(false);
            }
            synchronized (d.this.zr) {
                try {
                    Iterator it = d.this.zr.iterator();
                    while (it.hasNext()) {
                        ((i.a) it.next()).onAudioBeOccupied();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeReleased() {
            synchronized (d.this.zr) {
                try {
                    Iterator it = d.this.zr.iterator();
                    while (it.hasNext()) {
                        ((i.a) it.next()).onAudioBeReleased();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.m.d$2 */
    public class AnonymousClass2 extends l {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i10, int i11) {
            super.onMediaPlayError(i10, i11);
            com.kwad.components.core.o.a.ri().d(d.this.mAdTemplate, i10, i11);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.m.d$3 */
    public class AnonymousClass3 implements c.e {
        public AnonymousClass3() {
        }

        @Override // com.kwad.sdk.core.video.a.c.e
        public final void a(com.kwad.sdk.core.video.a.c cVar) {
            try {
                com.kwad.sdk.core.c.b.Fi();
                if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                    d.this.Js.start();
                }
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }
    }

    public d(g gVar, DetailVideoView detailVideoView) {
        super(gVar.mAdTemplate, detailVideoView);
        this.zp = new AtomicBoolean(false);
        this.zq = false;
        this.lX = false;
        this.zr = new ArrayList();
        this.zs = new ArrayList();
        this.zt = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.reward.m.d.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                d.a(d.this, true);
                if (d.this.Js != null) {
                    d.this.Js.setAudioEnabled(false);
                }
                synchronized (d.this.zr) {
                    try {
                        Iterator it = d.this.zr.iterator();
                        while (it.hasNext()) {
                            ((i.a) it.next()).onAudioBeOccupied();
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
                synchronized (d.this.zr) {
                    try {
                        Iterator it = d.this.zr.iterator();
                        while (it.hasNext()) {
                            ((i.a) it.next()).onAudioBeReleased();
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        };
        this.rO = gVar;
        this.mContext = gVar.mContext;
        this.mVideoPlayConfig = gVar.mVideoPlayConfig;
        this.mVideoPlayerStatus = this.mAdTemplate.mVideoPlayerStatus;
        this.zo = getVideoUrl();
    }

    private void bk() {
        if (kf()) {
            return;
        }
        this.Js.a(new b.a(this.mAdTemplate).dc(this.zo).dd(h.b(com.kwad.sdk.core.response.b.e.ec(this.mAdTemplate))).a(this.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.a.a.a.bL(this.mAdTemplate)).Cz(), this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.Js.prepareAsync();
    }

    private String getVideoUrl() {
        return kf() ? "" : j.g(this.mContext, this.mAdTemplate);
    }

    private boolean kf() {
        return com.kwad.sdk.core.response.b.a.cS(com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate));
    }

    private void stop() {
        pause();
        this.lX = true;
    }

    @Override // com.kwad.components.ad.l.b, com.kwad.components.ad.l.a
    public final long getPlayDuration() {
        if (this.zp.get()) {
            return super.getPlayDuration();
        }
        return 0L;
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void go() {
        this.zq = false;
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void gp() {
        if (this.lX) {
            return;
        }
        resume();
        if (this.oI || (com.kwad.components.ad.reward.a.b.gN() && this.zq)) {
            com.kwad.components.core.s.a.av(this.mContext).aO(com.kwad.components.ad.reward.a.b.gN());
            if (com.kwad.components.ad.reward.a.b.gN() && this.zq) {
                this.zq = false;
                this.oI = true;
                setAudioEnabled(true, false);
            } else {
                if (this.rO.f11687qd || !com.kwad.components.core.s.a.av(this.mContext).sa()) {
                    return;
                }
                this.oI = false;
                setAudioEnabled(false, false);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void gq() {
        pause();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void gr() {
        com.kwad.components.core.video.b bVar;
        this.zq = false;
        if (!this.zp.get() || (bVar = this.Js) == null) {
            return;
        }
        bVar.d(this.oK);
        this.Js.release();
    }

    public final void kd() {
        if (this.zp.get()) {
            return;
        }
        this.zp.set(true);
        bk();
        AnonymousClass2 anonymousClass2 = new l() { // from class: com.kwad.components.ad.reward.m.d.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i10, int i11) {
                super.onMediaPlayError(i10, i11);
                com.kwad.components.core.o.a.ri().d(d.this.mAdTemplate, i10, i11);
            }
        };
        this.oK = anonymousClass2;
        this.Js.c(anonymousClass2);
        this.Js.a(new c.e() { // from class: com.kwad.components.ad.reward.m.d.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    com.kwad.sdk.core.c.b.Fi();
                    if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                        d.this.Js.start();
                    }
                } catch (Throwable th2) {
                    ServiceProvider.reportSdkCaughtException(th2);
                }
            }
        });
        this.Js.start();
        com.kwad.components.core.s.a.av(this.mContext).a(this.zt);
    }

    public final void ke() {
        Iterator<Object> it = this.zs.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.kwad.components.ad.l.b, com.kwad.components.ad.l.a
    public final void pause() {
        if (!this.zp.get() || this.Js == null || kf()) {
            return;
        }
        super.pause();
    }

    @Override // com.kwad.components.ad.l.b, com.kwad.components.ad.l.a
    @MainThread
    public final void release() {
        super.release();
        com.kwad.components.core.s.a.av(this.mContext).b(this.zt);
    }

    @Override // com.kwad.components.ad.l.b, com.kwad.components.ad.l.a
    public final void resume() {
        this.lX = false;
        if (!this.zp.get() || this.Js == null || kf() || g.b(this.rO)) {
            return;
        }
        super.resume();
    }

    @Override // com.kwad.components.ad.l.a
    public final void setAudioEnabled(boolean z10, boolean z11) {
        this.oI = z10;
        if (!this.zp.get() || this.Js == null) {
            return;
        }
        if (z10 && z11) {
            com.kwad.components.core.s.a.av(this.mContext).aO(true);
        }
        this.Js.setAudioEnabled(z10);
    }

    @Override // com.kwad.components.ad.l.a
    @Deprecated
    public final void skipToEnd() {
        com.kwad.components.core.video.b bVar;
        if (!this.zp.get() || (bVar = this.Js) == null) {
            return;
        }
        bVar.onPlayStateChanged(9);
        stop();
    }

    public static /* synthetic */ boolean a(d dVar, boolean z10) {
        dVar.zq = true;
        return true;
    }

    public final void b(i.a aVar) {
        this.zr.remove(aVar);
    }

    public final void a(i.a aVar) {
        this.zr.add(aVar);
    }
}
