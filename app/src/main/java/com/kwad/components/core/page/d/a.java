package com.kwad.components.core.page.d;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.components.core.proxy.f;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.b;
import com.kwad.components.core.video.j;
import com.kwad.components.core.video.k;
import com.kwad.components.core.video.l;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class a implements com.kwad.components.core.l.a.a {
    private b Js;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private KsVideoPlayConfig mVideoPlayConfig;
    private VideoPlayerStatus mVideoPlayerStatus;
    private boolean oI;
    private l oK;
    private String zo;
    private boolean zq = false;
    private final List<i.a> zr = new ArrayList();
    private OfflineOnAudioConflictListener zt = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.core.page.d.a.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            a.a(a.this, true);
            if (a.this.Js != null) {
                a.this.Js.setAudioEnabled(false);
            }
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

    /* renamed from: com.kwad.components.core.page.d.a$1 */
    public class AnonymousClass1 implements OfflineOnAudioConflictListener {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            a.a(a.this, true);
            if (a.this.Js != null) {
                a.this.Js.setAudioEnabled(false);
            }
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

    /* renamed from: com.kwad.components.core.page.d.a$2 */
    public class AnonymousClass2 extends l {
        final /* synthetic */ AdTemplate cP;

        public AnonymousClass2(AdTemplate adTemplate) {
            adTemplate = adTemplate;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i10, int i11) {
            super.onMediaPlayError(i10, i11);
            com.kwad.components.core.o.a.ri().d(adTemplate, i10, i11);
        }
    }

    /* renamed from: com.kwad.components.core.page.d.a$3 */
    public class AnonymousClass3 implements c.e {
        public AnonymousClass3() {
        }

        @Override // com.kwad.sdk.core.video.a.c.e
        public final void a(c cVar) {
            try {
                a.this.Js.start();
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }
    }

    public a(@NonNull AdTemplate adTemplate, @NonNull DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        this.mVideoPlayConfig = ksVideoPlayConfig;
        this.mAdTemplate = adTemplate;
        Context context = detailVideoView.getContext();
        this.mContext = context;
        this.mVideoPlayerStatus = adTemplate.mVideoPlayerStatus;
        this.zo = j.g(context, adTemplate);
        this.mDetailVideoView = detailVideoView;
        this.Js = new b(detailVideoView, adTemplate);
        bk();
        AnonymousClass2 anonymousClass2 = new l() { // from class: com.kwad.components.core.page.d.a.2
            final /* synthetic */ AdTemplate cP;

            public AnonymousClass2(AdTemplate adTemplate2) {
                adTemplate = adTemplate2;
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i10, int i11) {
                super.onMediaPlayError(i10, i11);
                com.kwad.components.core.o.a.ri().d(adTemplate, i10, i11);
            }
        };
        this.oK = anonymousClass2;
        this.Js.c(anonymousClass2);
        this.Js.a(new c.e() { // from class: com.kwad.components.core.page.d.a.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(c cVar) {
                try {
                    a.this.Js.start();
                } catch (Throwable th2) {
                    ServiceProvider.reportSdkCaughtException(th2);
                }
            }
        });
        com.kwad.components.core.s.a.av(this.mContext).a(this.zt);
    }

    private void bk() {
        this.Js.a(new b.a(this.mAdTemplate).dc(this.zo).dd(h.b(e.ec(this.mAdTemplate))).a(this.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.a.a.a.bL(this.mAdTemplate)).Cz(), this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.Js.prepareAsync();
    }

    private void pause() {
        SceneImpl sceneImpl;
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate.mXiaomiAppStoreDetailViewOpen && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.getAdStyle() == 2) {
            return;
        }
        this.Js.pause();
    }

    private void resume() {
        this.Js.resume();
    }

    private void setAudioEnabled(boolean z10, boolean z11) {
        this.oI = z10;
        this.Js.setAudioEnabled(z10);
    }

    @Override // com.kwad.components.core.l.a.a
    public final void c(f fVar) {
        resume();
    }

    @Override // com.kwad.components.core.l.a.a
    public final void d(f fVar) {
        pause();
    }

    @Override // com.kwad.components.core.l.a.a
    public final void gj() {
        this.zq = false;
        if (this.Js.sv() == null) {
            bk();
        }
    }

    @Override // com.kwad.components.core.l.a.a
    public final void gk() {
        this.zq = false;
        com.kwad.components.core.video.b bVar = this.Js;
        if (bVar != null) {
            bVar.d(this.oK);
            this.Js.release();
        }
    }

    @MainThread
    public final void release() {
        com.kwad.components.core.video.b bVar = this.Js;
        if (bVar != null) {
            bVar.clear();
            this.Js.release();
        }
        com.kwad.components.core.s.a.av(this.mContext).b(this.zt);
    }

    public static /* synthetic */ boolean a(a aVar, boolean z10) {
        aVar.zq = true;
        return true;
    }

    @MainThread
    public final void b(k kVar) {
        if (kVar == null) {
            return;
        }
        this.Js.d(kVar);
    }

    @MainThread
    public final void a(k kVar) {
        if (kVar == null) {
            return;
        }
        this.Js.c(kVar);
    }
}
