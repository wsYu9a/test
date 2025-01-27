package com.kwad.components.core.page.b;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.b;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.j;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.a.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class a implements com.kwad.components.core.j.kwai.a {
    private b Gj;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private KsVideoPlayConfig mVideoPlayConfig;
    private VideoPlayerStatus mVideoPlayerStatus;
    private boolean nJ;
    private j nL;
    private String xv;
    private boolean xy = false;
    private final List<h.a> xz = new ArrayList();
    private OfflineOnAudioConflictListener xB = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.core.page.b.a.1
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

    /* renamed from: com.kwad.components.core.page.b.a$1 */
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

    /* renamed from: com.kwad.components.core.page.b.a$2 */
    final class AnonymousClass2 extends j {
        final /* synthetic */ AdTemplate eI;

        AnonymousClass2(AdTemplate adTemplate) {
            adTemplate = adTemplate;
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayError(int i2, int i3) {
            super.onVideoPlayError(i2, i3);
            com.kwad.components.core.m.a.pb().b(adTemplate, i2, i3);
        }
    }

    /* renamed from: com.kwad.components.core.page.b.a$3 */
    final class AnonymousClass3 implements c.e {
        AnonymousClass3() {
        }

        @Override // com.kwad.sdk.core.video.kwai.c.e
        public final void a(c cVar) {
            a.this.Gj.start();
        }
    }

    public a(@NonNull AdTemplate adTemplate, @NonNull DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        this.mVideoPlayConfig = ksVideoPlayConfig;
        this.mAdTemplate = adTemplate;
        this.mContext = detailVideoView.getContext();
        this.mVideoPlayerStatus = adTemplate.mVideoPlayerStatus;
        String E = com.kwad.sdk.core.response.a.a.E(d.cb(adTemplate));
        int ux = com.kwad.sdk.core.config.d.ux();
        if (ux < 0) {
            File aX = com.kwad.sdk.core.diskcache.a.a.vs().aX(E);
            if (aX != null && aX.exists()) {
                E = aX.getAbsolutePath();
            }
            this.mDetailVideoView = detailVideoView;
            this.Gj = new b(detailVideoView);
            aT();
            AnonymousClass2 anonymousClass2 = new j() { // from class: com.kwad.components.core.page.b.a.2
                final /* synthetic */ AdTemplate eI;

                AnonymousClass2(AdTemplate adTemplate2) {
                    adTemplate = adTemplate2;
                }

                @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
                public final void onVideoPlayError(int i2, int i3) {
                    super.onVideoPlayError(i2, i3);
                    com.kwad.components.core.m.a.pb().b(adTemplate, i2, i3);
                }
            };
            this.nL = anonymousClass2;
            this.Gj.c(anonymousClass2);
            this.Gj.a(new c.e() { // from class: com.kwad.components.core.page.b.a.3
                AnonymousClass3() {
                }

                @Override // com.kwad.sdk.core.video.kwai.c.e
                public final void a(c cVar) {
                    a.this.Gj.start();
                }
            });
            com.kwad.components.core.r.a.aj(this.mContext).a(this.xB);
        }
        if (ux != 0) {
            E = com.kwad.sdk.core.videocache.b.a.ba(detailVideoView.getContext()).cS(E);
        }
        this.xv = E;
        this.mDetailVideoView = detailVideoView;
        this.Gj = new b(detailVideoView);
        aT();
        AnonymousClass2 anonymousClass22 = new j() { // from class: com.kwad.components.core.page.b.a.2
            final /* synthetic */ AdTemplate eI;

            AnonymousClass2(AdTemplate adTemplate2) {
                adTemplate = adTemplate2;
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayError(int i2, int i3) {
                super.onVideoPlayError(i2, i3);
                com.kwad.components.core.m.a.pb().b(adTemplate, i2, i3);
            }
        };
        this.nL = anonymousClass22;
        this.Gj.c(anonymousClass22);
        this.Gj.a(new c.e() { // from class: com.kwad.components.core.page.b.a.3
            AnonymousClass3() {
            }

            @Override // com.kwad.sdk.core.video.kwai.c.e
            public final void a(c cVar) {
                a.this.Gj.start();
            }
        });
        com.kwad.components.core.r.a.aj(this.mContext).a(this.xB);
    }

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.xy = true;
        return true;
    }

    private void aT() {
        this.Gj.a(new b.a(this.mAdTemplate).bs(this.xv).bt(f.b(d.cc(this.mAdTemplate))).a(this.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.kwai.kwai.a.ak(this.mAdTemplate)).tR(), this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.Gj.prepareAsync();
    }

    private void pause() {
        SceneImpl sceneImpl;
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate.mXiaomiAppStoreDetailViewOpen && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.getAdStyle() == 2) {
            return;
        }
        this.Gj.pause();
    }

    private void resume() {
        this.Gj.resume();
    }

    private void setAudioEnabled(boolean z, boolean z2) {
        this.nJ = z;
        this.Gj.setAudioEnabled(z);
    }

    @Override // com.kwad.components.core.j.kwai.a
    public final void a(com.kwad.components.core.l.d dVar) {
        resume();
    }

    @MainThread
    public final void a(i iVar) {
        if (iVar == null) {
            return;
        }
        this.Gj.c(iVar);
    }

    @Override // com.kwad.components.core.j.kwai.a
    public final void b(com.kwad.components.core.l.d dVar) {
        pause();
    }

    @MainThread
    public final void b(i iVar) {
        if (iVar == null) {
            return;
        }
        this.Gj.d(iVar);
    }

    @Override // com.kwad.components.core.j.kwai.a
    public final void c(com.kwad.components.core.l.d dVar) {
        this.xy = false;
        com.kwad.components.core.video.b bVar = this.Gj;
        if (bVar != null) {
            bVar.d(this.nL);
            this.Gj.release();
        }
    }

    @Override // com.kwad.components.core.j.kwai.a
    public final void fY() {
        this.xy = false;
        if (this.Gj.qe() == null) {
            aT();
        }
    }

    @MainThread
    public final void release() {
        com.kwad.components.core.video.b bVar = this.Gj;
        if (bVar != null) {
            bVar.clear();
            this.Gj.release();
        }
        com.kwad.components.core.r.a.aj(this.mContext).b(this.xB);
    }
}
