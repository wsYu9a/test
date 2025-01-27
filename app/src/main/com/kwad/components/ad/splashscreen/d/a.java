package com.kwad.components.ad.splashscreen.d;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.ad.l.b;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.h.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class a extends b implements c {
    private boolean Hf;
    private Context mContext;
    private KsVideoPlayConfig mVideoPlayConfig;
    private VideoPlayerStatus mVideoPlayerStatus;
    private boolean oI;
    private String zo;
    private final List<i.a> zr;
    private OfflineOnAudioConflictListener zt;

    /* renamed from: com.kwad.components.ad.splashscreen.d.a$1 */
    public class AnonymousClass1 implements OfflineOnAudioConflictListener {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            synchronized (a.this.zr) {
                try {
                    Iterator it = a.this.zr.iterator();
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
            synchronized (a.this.zr) {
                try {
                    Iterator it = a.this.zr.iterator();
                    while (it.hasNext()) {
                        ((i.a) it.next()).onAudioBeReleased();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.d.a$2 */
    public class AnonymousClass2 implements c.e {
        final /* synthetic */ DetailVideoView Hh;

        /* renamed from: com.kwad.components.ad.splashscreen.d.a$2$1 */
        public class AnonymousClass1 extends bd {
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                boolean a10 = bw.a(detailVideoView, 50, true);
                com.kwad.sdk.core.d.c.d("SplashPlayModule", " onPrepared" + a10);
                if (a10) {
                    a.this.Js.start();
                }
            }
        }

        public AnonymousClass2(DetailVideoView detailVideoView) {
            detailVideoView = detailVideoView;
        }

        @Override // com.kwad.sdk.core.video.a.c.e
        public final void a(com.kwad.sdk.core.video.a.c cVar) {
            com.kwad.sdk.core.d.c.d("SplashPlayModule", " onPrepared");
            detailVideoView.post(new bd() { // from class: com.kwad.components.ad.splashscreen.d.a.2.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    boolean a10 = bw.a(detailVideoView, 50, true);
                    com.kwad.sdk.core.d.c.d("SplashPlayModule", " onPrepared" + a10);
                    if (a10) {
                        a.this.Js.start();
                    }
                }
            });
        }
    }

    public a(@NonNull AdTemplate adTemplate, @NonNull DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        super(adTemplate, detailVideoView);
        this.zr = new ArrayList();
        this.zt = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.splashscreen.d.a.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                synchronized (a.this.zr) {
                    try {
                        Iterator it = a.this.zr.iterator();
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
                synchronized (a.this.zr) {
                    try {
                        Iterator it = a.this.zr.iterator();
                        while (it.hasNext()) {
                            ((i.a) it.next()).onAudioBeReleased();
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        };
        this.mVideoPlayConfig = ksVideoPlayConfig;
        this.mContext = detailVideoView.getContext();
        String aZ = com.kwad.sdk.core.response.b.a.aZ(e.eb(adTemplate));
        this.mVideoPlayerStatus = adTemplate.mVideoPlayerStatus;
        File ca2 = com.kwad.sdk.core.diskcache.b.a.EG().ca(aZ);
        if (ca2 != null && ca2.exists()) {
            this.zo = ca2.getAbsolutePath();
        }
        this.Js.a(new c.e() { // from class: com.kwad.components.ad.splashscreen.d.a.2
            final /* synthetic */ DetailVideoView Hh;

            /* renamed from: com.kwad.components.ad.splashscreen.d.a$2$1 */
            public class AnonymousClass1 extends bd {
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    boolean a10 = bw.a(detailVideoView, 50, true);
                    com.kwad.sdk.core.d.c.d("SplashPlayModule", " onPrepared" + a10);
                    if (a10) {
                        a.this.Js.start();
                    }
                }
            }

            public AnonymousClass2(DetailVideoView detailVideoView2) {
                detailVideoView = detailVideoView2;
            }

            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                com.kwad.sdk.core.d.c.d("SplashPlayModule", " onPrepared");
                detailVideoView.post(new bd() { // from class: com.kwad.components.ad.splashscreen.d.a.2.1
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        boolean a10 = bw.a(detailVideoView, 50, true);
                        com.kwad.sdk.core.d.c.d("SplashPlayModule", " onPrepared" + a10);
                        if (a10) {
                            a.this.Js.start();
                        }
                    }
                });
            }
        });
        com.kwad.components.core.s.a.av(this.mContext).a(this.zt);
    }

    private void bk() {
        this.Js.a(new b.a(this.mAdTemplate).a(this.mVideoPlayerStatus).dc(this.zo).dd(h.b(e.ec(this.mAdTemplate))).b(com.kwad.sdk.contentalliance.a.a.a.bL(this.mAdTemplate)).Cz(), this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.Js.prepareAsync();
    }

    public final void af(boolean z10) {
        this.Hf = true;
    }

    @Override // com.kwad.sdk.core.h.c
    public final void bl() {
        resume();
    }

    @Override // com.kwad.sdk.core.h.c
    public final void bm() {
        pause();
    }

    public final long getCurrentPosition() {
        return this.Js.getCurrentPosition();
    }

    public final void mx() {
        if (this.Js.sv() == null) {
            bk();
        }
        this.Js.start();
    }

    @Override // com.kwad.components.ad.l.b, com.kwad.components.ad.l.a
    public final void release() {
        super.release();
        com.kwad.components.core.s.a.av(this.mContext).b(this.zt);
    }

    @Override // com.kwad.components.ad.l.b, com.kwad.components.ad.l.a
    public final void resume() {
        super.resume();
        if (this.oI && this.Hf) {
            com.kwad.components.core.s.a.av(this.mContext).aO(false);
            if (com.kwad.components.core.s.a.av(this.mContext).sa()) {
                this.oI = false;
                setAudioEnabled(false, false);
            }
        }
    }

    @Override // com.kwad.components.ad.l.a
    public final void setAudioEnabled(boolean z10, boolean z11) {
        this.oI = z10;
        if (z10 && z11) {
            com.kwad.components.core.s.a.av(this.mContext).aO(true);
        }
        this.Js.setAudioEnabled(z10);
    }

    public final void a(i.a aVar) {
        this.zr.add(aVar);
    }

    public final void b(i.a aVar) {
        this.zr.remove(aVar);
    }
}
