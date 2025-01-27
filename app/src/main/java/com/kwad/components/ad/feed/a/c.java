package com.kwad.components.ad.feed.a;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.h.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.video.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.widget.KSRelativeLayout;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class c extends a implements View.OnClickListener, com.kwad.sdk.widget.c {
    private List<Integer> cI;
    private volatile boolean cJ;
    private com.kwad.sdk.widget.j cK;
    private ImageView dJ;
    private TextView dK;
    private TextView dR;
    private KsAdVideoPlayConfig dZ;
    private TextView eA;
    private ImageView eC;
    private TextView eE;
    private TextView eF;
    private View eG;
    private DownloadProgressView eH;
    private KSRelativeLayout eL;
    private ImageView eM;
    private com.kwad.sdk.core.video.videoview.a eN;
    private com.kwad.components.core.video.e eO;
    private d eP;
    private boolean eQ;
    private TextView eR;
    private final a.InterfaceC0187a eS;
    private IAdLiveOfflineView eT;
    private com.kwad.components.core.offline.api.kwai.a eU;
    private IAdLivePlayModule eV;
    private boolean eW;
    private View eX;
    private a.b eY;
    private OfflineOnAudioConflictListener eZ;
    private a.b fa;
    private final AdLivePlayStateListener mAdLivePlayStateListener;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private boolean mIsAudioEnable;
    private KsLogoView mLogoView;

    /* renamed from: com.kwad.components.ad.feed.a.c$1 */
    final class AnonymousClass1 implements com.kwad.sdk.widget.j {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.widget.j
        public final void aw() {
            com.kwad.sdk.utils.l.cw(c.this.mAdTemplate);
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.c$10 */
    final class AnonymousClass10 implements a.b {
        AnonymousClass10() {
        }

        @Override // com.kwad.components.core.video.a.c
        public final void bt() {
            if (com.kwad.components.ad.feed.kwai.b.be() && c.this.eP == null) {
                c.this.eP = new d(c.this.getContext());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                c cVar = c.this;
                cVar.addView(cVar.eP, layoutParams);
                c.this.eP.bu();
            }
            com.kwad.sdk.core.report.a.av(c.this.mAdTemplate);
        }

        @Override // com.kwad.components.core.video.a.c
        public final void d(long j2) {
            c.this.c(j2);
        }

        @Override // com.kwad.components.core.video.a.b
        public final void onVideoPlayError(int i2, int i3) {
            com.kwad.components.ad.feed.monitor.a.a(c.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.a.a.E(c.this.mAdInfo), i2 + " " + i3, SystemClock.elapsedRealtime() - c.this.ex);
        }

        @Override // com.kwad.components.core.video.a.c
        public final void onVideoPlayStart() {
            com.kwad.components.core.h.a.nC().a(c.this.getCurrentVoiceItem());
            if (c.this.eP != null && (c.this.eP.getParent() instanceof ViewGroup)) {
                ((ViewGroup) c.this.eP.getParent()).removeView(c.this.eP);
                c.this.eP.bv();
                c.this.eP = null;
            }
            com.kwad.components.ad.feed.monitor.a.a(c.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.a.a.E(c.this.mAdInfo), null, SystemClock.elapsedRealtime() - c.this.ex);
            com.kwad.sdk.core.report.a.h(c.this.mAdTemplate);
        }

        @Override // com.kwad.components.core.video.a.c
        public final void onVideoPlaying() {
            com.kwad.sdk.core.video.videoview.a aVar = c.this.eN;
            c cVar = c.this;
            aVar.setVideoSoundEnable(cVar.g(cVar.mIsAudioEnable));
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.c$2 */
    final class AnonymousClass2 implements a.c {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.h.a.c
        public final void bs() {
            if (!c.this.eW) {
                if (c.this.eN != null) {
                    com.kwad.sdk.core.video.videoview.a aVar = c.this.eN;
                    c cVar = c.this;
                    aVar.setVideoSoundEnable(cVar.g(cVar.mIsAudioEnable));
                    return;
                }
                return;
            }
            if (c.this.eV == null) {
                c cVar2 = c.this;
                cVar2.eV = cVar2.bq();
            }
            IAdLivePlayModule iAdLivePlayModule = c.this.eV;
            c cVar3 = c.this;
            iAdLivePlayModule.setAudioEnabled(cVar3.g(cVar3.mIsAudioEnable), false);
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.c$3 */
    final class AnonymousClass3 implements a.InterfaceC0187a {

        /* renamed from: com.kwad.components.ad.feed.a.c$3$1 */
        final class AnonymousClass1 implements a.b {
            AnonymousClass1() {
            }

            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                c.this.eh();
            }
        }

        AnonymousClass3() {
        }

        @Override // com.kwad.components.core.video.a.InterfaceC0187a
        public final void a(int i2, ac.a aVar) {
            int i3;
            int i4 = 2;
            boolean z = false;
            if (i2 == 1) {
                i3 = 15;
            } else if (i2 == 2) {
                i3 = 16;
            } else if (i2 != 3) {
                i3 = 35;
            } else {
                i3 = 39;
                i4 = 1;
                z = true;
            }
            y.b bVar = new y.b();
            bVar.jW = aVar;
            bVar.jU = i3;
            c.this.bi();
            com.kwad.components.core.d.b.a.a(new a.C0172a(c.this.getContext()).I(c.this.mAdTemplate).b(c.this.mApkDownloadHelper).ap(i4).ao(z).aq(true).an(5).ao(i3).as(true).a(bVar).a(new a.b() { // from class: com.kwad.components.ad.feed.a.c.3.1
                AnonymousClass1() {
                }

                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    c.this.eh();
                }
            }));
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.c$4 */
    final class AnonymousClass4 implements Runnable {
        final /* synthetic */ View fe;

        AnonymousClass4(View view) {
            view2 = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.this.c(view2);
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.c$5 */
    final class AnonymousClass5 extends SimpleImageLoadingListener {
        AnonymousClass5() {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
            return true;
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.c$6 */
    final class AnonymousClass6 implements Runnable {
        final /* synthetic */ View fe;

        AnonymousClass6(View view) {
            view = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int width = c.this.eL.getWidth();
            int height = c.this.eL.getHeight();
            if (width == 0 || height == 0) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (height * 0.5625f), height);
            layoutParams.addRule(13, -1);
            view.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.c$7 */
    final class AnonymousClass7 extends AdLivePlayStateListenerAdapter {
        AnonymousClass7() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            c.this.eR.setVisibility(0);
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            c.this.c(j2);
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayResume() {
            super.onLivePlayResume();
            com.kwad.components.core.h.a.nC().a(c.this.getCurrentVoiceItem());
            IAdLivePlayModule iAdLivePlayModule = c.this.eV;
            c cVar = c.this;
            iAdLivePlayModule.setAudioEnabled(cVar.g(cVar.mIsAudioEnable), false);
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayStart() {
            super.onLivePlayStart();
            com.kwad.components.core.h.a.nC().a(c.this.getCurrentVoiceItem());
            IAdLivePlayModule iAdLivePlayModule = c.this.eV;
            c cVar = c.this;
            iAdLivePlayModule.setAudioEnabled(cVar.g(cVar.mIsAudioEnable), false);
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.c$8 */
    final class AnonymousClass8 implements OfflineOnAudioConflictListener {
        AnonymousClass8() {
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            c.b(c.this, false);
            if (c.this.eN != null) {
                c.this.eN.setVideoSoundEnable(false);
            }
            if (c.this.eV != null) {
                c.this.eV.setAudioEnabled(false, false);
            }
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeReleased() {
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.c$9 */
    final class AnonymousClass9 implements a.b {
        final /* synthetic */ int eK;

        AnonymousClass9(int i2) {
            i2 = i2;
        }

        @Override // com.kwad.components.core.d.b.a.b
        public final void onAdClicked() {
            c.this.aL(i2);
        }
    }

    public c(@NonNull Context context) {
        super(context);
        this.mIsAudioEnable = false;
        this.cJ = false;
        this.cK = new com.kwad.sdk.widget.j() { // from class: com.kwad.components.ad.feed.a.c.1
            AnonymousClass1() {
            }

            @Override // com.kwad.sdk.widget.j
            public final void aw() {
                com.kwad.sdk.utils.l.cw(c.this.mAdTemplate);
            }
        };
        this.eS = new a.InterfaceC0187a() { // from class: com.kwad.components.ad.feed.a.c.3

            /* renamed from: com.kwad.components.ad.feed.a.c$3$1 */
            final class AnonymousClass1 implements a.b {
                AnonymousClass1() {
                }

                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    c.this.eh();
                }
            }

            AnonymousClass3() {
            }

            @Override // com.kwad.components.core.video.a.InterfaceC0187a
            public final void a(int i2, ac.a aVar) {
                int i3;
                int i4 = 2;
                boolean z = false;
                if (i2 == 1) {
                    i3 = 15;
                } else if (i2 == 2) {
                    i3 = 16;
                } else if (i2 != 3) {
                    i3 = 35;
                } else {
                    i3 = 39;
                    i4 = 1;
                    z = true;
                }
                y.b bVar = new y.b();
                bVar.jW = aVar;
                bVar.jU = i3;
                c.this.bi();
                com.kwad.components.core.d.b.a.a(new a.C0172a(c.this.getContext()).I(c.this.mAdTemplate).b(c.this.mApkDownloadHelper).ap(i4).ao(z).aq(true).an(5).ao(i3).as(true).a(bVar).a(new a.b() { // from class: com.kwad.components.ad.feed.a.c.3.1
                    AnonymousClass1() {
                    }

                    @Override // com.kwad.components.core.d.b.a.b
                    public final void onAdClicked() {
                        c.this.eh();
                    }
                }));
            }
        };
        this.mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.feed.a.c.7
            AnonymousClass7() {
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                super.onLivePlayEnd();
                c.this.eR.setVisibility(0);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(long j2) {
                super.onLivePlayProgress(j2);
                c.this.c(j2);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                super.onLivePlayResume();
                com.kwad.components.core.h.a.nC().a(c.this.getCurrentVoiceItem());
                IAdLivePlayModule iAdLivePlayModule = c.this.eV;
                c cVar = c.this;
                iAdLivePlayModule.setAudioEnabled(cVar.g(cVar.mIsAudioEnable), false);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                super.onLivePlayStart();
                com.kwad.components.core.h.a.nC().a(c.this.getCurrentVoiceItem());
                IAdLivePlayModule iAdLivePlayModule = c.this.eV;
                c cVar = c.this;
                iAdLivePlayModule.setAudioEnabled(cVar.g(cVar.mIsAudioEnable), false);
            }
        };
        this.eZ = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.feed.a.c.8
            AnonymousClass8() {
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                c.b(c.this, false);
                if (c.this.eN != null) {
                    c.this.eN.setVideoSoundEnable(false);
                }
                if (c.this.eV != null) {
                    c.this.eV.setAudioEnabled(false, false);
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }
        };
        this.fa = new a.b() { // from class: com.kwad.components.ad.feed.a.c.10
            AnonymousClass10() {
            }

            @Override // com.kwad.components.core.video.a.c
            public final void bt() {
                if (com.kwad.components.ad.feed.kwai.b.be() && c.this.eP == null) {
                    c.this.eP = new d(c.this.getContext());
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    c cVar = c.this;
                    cVar.addView(cVar.eP, layoutParams);
                    c.this.eP.bu();
                }
                com.kwad.sdk.core.report.a.av(c.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j2) {
                c.this.c(j2);
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlayError(int i2, int i3) {
                com.kwad.components.ad.feed.monitor.a.a(c.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.a.a.E(c.this.mAdInfo), i2 + " " + i3, SystemClock.elapsedRealtime() - c.this.ex);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.components.core.h.a.nC().a(c.this.getCurrentVoiceItem());
                if (c.this.eP != null && (c.this.eP.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) c.this.eP.getParent()).removeView(c.this.eP);
                    c.this.eP.bv();
                    c.this.eP = null;
                }
                com.kwad.components.ad.feed.monitor.a.a(c.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.a.a.E(c.this.mAdInfo), null, SystemClock.elapsedRealtime() - c.this.ex);
                com.kwad.sdk.core.report.a.h(c.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlaying() {
                com.kwad.sdk.core.video.videoview.a aVar = c.this.eN;
                c cVar = c.this;
                aVar.setVideoSoundEnable(cVar.g(cVar.mIsAudioEnable));
            }
        };
    }

    private void a(com.kwad.sdk.core.video.videoview.a aVar, boolean z, int i2) {
        if (aVar != null || this.eW) {
            String E = com.kwad.sdk.core.response.a.a.E(this.mAdInfo);
            if (!this.eW) {
                this.eO.setAutoRelease(false);
            }
            int i3 = z ? 1 : 2;
            if (!this.eW) {
                AdVideoPlayerViewCache.getInstance().a(E, this.eN);
            }
            bi();
            a.C0172a ao = new a.C0172a(getContext()).I(this.mAdTemplate).b(this.mApkDownloadHelper).ao(z);
            IAdLivePlayModule iAdLivePlayModule = this.eV;
            com.kwad.components.core.d.b.a.a(ao.q(iAdLivePlayModule == null ? 0L : iAdLivePlayModule.getPlayDuration()).ap(i3).as(true).a(new a.b() { // from class: com.kwad.components.ad.feed.a.c.9
                final /* synthetic */ int eK;

                AnonymousClass9(int i22) {
                    i2 = i22;
                }

                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    c.this.aL(i2);
                }
            }));
        }
    }

    static /* synthetic */ boolean b(c cVar, boolean z) {
        cVar.eQ = false;
        return false;
    }

    private void bl() {
        findViewById(R.id.ksad_ad_h5_container).setVisibility(0);
        findViewById(R.id.ksad_ad_download_container).setVisibility(8);
        this.eF = (TextView) findViewById(R.id.ksad_h5_desc);
        this.dR = (TextView) findViewById(R.id.ksad_h5_open_btn);
        this.eG = findViewById(R.id.ksad_h5_open_cover);
        this.eF.setText(com.kwad.components.ad.feed.f.b(this.mAdTemplate));
        this.dR.setText(com.kwad.sdk.core.response.a.a.aw(this.mAdInfo));
        this.eG.setOnClickListener(this);
        this.eF.setOnClickListener(this);
        this.dR.setOnClickListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.eG, this);
        new com.kwad.sdk.widget.f(getContext(), this.eF, this);
        new com.kwad.sdk.widget.f(getContext(), this.dR, this);
    }

    private void bm() {
        findViewById(R.id.ksad_ad_download_container).setVisibility(0);
        findViewById(R.id.ksad_ad_h5_container).setVisibility(8);
        this.dJ = (ImageView) findViewById(R.id.ksad_app_icon);
        this.dK = (TextView) findViewById(R.id.ksad_app_title);
        TextView textView = (TextView) findViewById(R.id.ksad_app_desc);
        this.eE = textView;
        com.kwad.sdk.c.kwai.a.a(this, this.dJ, this.dK, textView);
        new com.kwad.sdk.widget.f(getContext(), this.dJ, this);
        new com.kwad.sdk.widget.f(getContext(), this.dK, this);
        new com.kwad.sdk.widget.f(getContext(), this.eE, this);
        this.dK.setText(com.kwad.sdk.core.response.a.a.ao(this.mAdInfo));
        this.dJ.setImageResource(R.drawable.ksad_default_app_icon);
        KSImageLoader.loadAppIcon(this.dJ, com.kwad.sdk.core.response.a.a.bM(this.mAdInfo), this.mAdTemplate, 8);
        this.eE.setText(com.kwad.components.ad.feed.f.b(this.mAdTemplate));
        bj();
        this.eH.D(this.mAdTemplate);
        this.eH.setOnClickListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.eH, this);
        com.kwad.components.core.d.b.c cVar = new com.kwad.components.core.d.b.c(this.mAdTemplate, null, this.eH.getAppDownloadListener());
        this.mApkDownloadHelper = cVar;
        cVar.d(this.eH.getAppDownloadListener());
        this.mApkDownloadHelper.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
    }

    private void bo() {
        com.kwad.components.core.offline.api.kwai.a aVar = (com.kwad.components.core.offline.api.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class);
        this.eU = aVar;
        if (aVar != null && aVar.hasLiveCompoReady() && com.kwad.sdk.core.response.a.a.cq(this.mAdInfo)) {
            this.eW = true;
        }
    }

    private boolean bp() {
        IAdLiveOfflineView iAdLiveOfflineView = this.eT;
        if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || !this.eW) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) this.eT.getView().getParent();
        if (viewGroup != this.eL) {
            viewGroup.removeView(this.eT.getView());
            if (this.eL.getTag() != null) {
                KSRelativeLayout kSRelativeLayout = this.eL;
                kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                this.eL.setTag(null);
            }
            this.eL.addView(this.eT.getView());
            this.eL.setTag(this.eT.getView());
            this.eV.setAudioEnabled(this.mIsAudioEnable, false);
            IAdLivePlayModule adLivePlayModule = this.eU.getAdLivePlayModule(this.eT, KsAdSDKImpl.get().getAppId(), String.valueOf(com.kwad.sdk.core.response.a.a.bN(this.mAdInfo)));
            this.eV = adLivePlayModule;
            adLivePlayModule.registerAdLivePlayStateListener(this.mAdLivePlayStateListener);
        }
        this.eV.onResume();
        return true;
    }

    public IAdLivePlayModule bq() {
        br();
        IAdLiveOfflineView view = this.eU.getView(this.mContext, 3);
        this.eT = view;
        IAdLivePlayModule adLivePlayModule = this.eU.getAdLivePlayModule(view, ServiceProvider.CB().appId, String.valueOf(com.kwad.sdk.core.response.a.a.bN(this.mAdInfo)));
        adLivePlayModule.setAudioEnabled(g(this.mIsAudioEnable), false);
        adLivePlayModule.registerAdLivePlayStateListener(this.mAdLivePlayStateListener);
        View view2 = this.eT.getView();
        if (this.eL.getTag() != null) {
            KSRelativeLayout kSRelativeLayout = this.eL;
            kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
            this.eL.setTag(null);
        }
        this.eL.addView(view2);
        this.eL.setTag(view2);
        bi.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.feed.a.c.4
            final /* synthetic */ View fe;

            AnonymousClass4(View view22) {
                view2 = view22;
            }

            @Override // java.lang.Runnable
            public final void run() {
                c.this.c(view2);
            }
        });
        if (this.mIsAudioEnable) {
            com.kwad.components.core.r.a.aj(this.mContext).a(this.eZ);
        }
        return adLivePlayModule;
    }

    private void br() {
        String url = com.kwad.sdk.core.response.a.a.bi(this.mAdInfo).getUrl();
        this.eM.setVisibility(0);
        this.eX.setVisibility(0);
        if (TextUtils.isEmpty(url)) {
            this.eM.setImageResource(R.drawable.ksad_ad_live_end);
        } else {
            this.eM.setImageDrawable(null);
            KSImageLoader.loadImage(this.eM, url, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.feed.a.c.5
                AnonymousClass5() {
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                    return true;
                }
            });
        }
    }

    public void c(long j2) {
        int ceil = (int) Math.ceil(j2 / 1000.0f);
        List<Integer> list = this.cI;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.cI.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.report.a.a((AdTemplate) this.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    public void c(View view) {
        view.post(new Runnable() { // from class: com.kwad.components.ad.feed.a.c.6
            final /* synthetic */ View fe;

            AnonymousClass6(View view2) {
                view = view2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int width = c.this.eL.getWidth();
                int height = c.this.eL.getHeight();
                if (width == 0 || height == 0) {
                    return;
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (height * 0.5625f), height);
                layoutParams.addRule(13, -1);
                view.setLayoutParams(layoutParams);
            }
        });
    }

    public boolean g(boolean z) {
        if (!z) {
            return false;
        }
        if (!com.kwad.sdk.core.config.d.gz()) {
            return !com.kwad.components.core.r.a.aj(this.mContext).pJ() ? com.kwad.components.core.r.a.aj(this.mContext).aL(false) : !com.kwad.components.core.r.a.aj(this.mContext).pI();
        }
        if (!this.eQ) {
            this.eQ = com.kwad.components.core.r.a.aj(this.mContext).aL(true);
        }
        return this.eQ;
    }

    public a.b getCurrentVoiceItem() {
        if (this.eY == null) {
            this.eY = new a.b(new a.c() { // from class: com.kwad.components.ad.feed.a.c.2
                AnonymousClass2() {
                }

                @Override // com.kwad.components.core.h.a.c
                public final void bs() {
                    if (!c.this.eW) {
                        if (c.this.eN != null) {
                            com.kwad.sdk.core.video.videoview.a aVar = c.this.eN;
                            c cVar = c.this;
                            aVar.setVideoSoundEnable(cVar.g(cVar.mIsAudioEnable));
                            return;
                        }
                        return;
                    }
                    if (c.this.eV == null) {
                        c cVar2 = c.this;
                        cVar2.eV = cVar2.bq();
                    }
                    IAdLivePlayModule iAdLivePlayModule = c.this.eV;
                    c cVar3 = c.this;
                    iAdLivePlayModule.setAudioEnabled(cVar3.g(cVar3.mIsAudioEnable), false);
                }
            });
        }
        return this.eY;
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        onClick(view);
    }

    public final void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        ImageView imageView;
        int i2;
        this.dZ = ksAdVideoPlayConfig;
        this.mIsAudioEnable = (!(ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) || ((KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig).getVideoSoundValue() == 0) ? com.kwad.sdk.core.response.a.a.bG(this.mAdInfo) : ksAdVideoPlayConfig.isVideoSoundEnable();
        this.mAdTemplate.mIsAudioEnable = this.mIsAudioEnable;
        this.cI = com.kwad.sdk.core.response.a.a.bd(this.mAdInfo);
        if (this.eW) {
            return;
        }
        String url = com.kwad.sdk.core.response.a.a.bi(this.mAdInfo).getUrl();
        if (TextUtils.isEmpty(url)) {
            imageView = this.eM;
            i2 = 8;
        } else {
            this.eM.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.eM.setImageDrawable(null);
            KSImageLoader.loadImage(this.eM, url, this.mAdTemplate);
            imageView = this.eM;
            i2 = 0;
        }
        imageView.setVisibility(i2);
        com.kwad.sdk.core.video.videoview.a aVar = new com.kwad.sdk.core.video.videoview.a(this.mContext);
        this.eN = aVar;
        aVar.setVisibleListener(this.cK);
        this.eN.setOnClickListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.eN, this);
        this.eN.setTag(this.cI);
        String E = com.kwad.sdk.core.response.a.a.E(this.mAdInfo);
        if (TextUtils.isEmpty(E)) {
            return;
        }
        this.eN.a(new b.a(this.mAdTemplate).bs(E).bt(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.cc(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.kwai.kwai.a.ak(this.mAdTemplate)).tR(), null);
        this.eN.setVideoSoundEnable(g(this.mIsAudioEnable));
        com.kwad.components.core.video.e eVar = new com.kwad.components.core.video.e(this.mContext, this.mAdTemplate, this.eN, ksAdVideoPlayConfig);
        this.eO = eVar;
        eVar.setAdClickListener(this.eS);
        this.ex = SystemClock.elapsedRealtime();
        this.eO.setVideoPlayCallback(this.fa);
        this.eN.setController(this.eO);
        if (this.eL.getTag() != null) {
            KSRelativeLayout kSRelativeLayout = this.eL;
            kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
            this.eL.setTag(null);
        }
        this.eL.addView(this.eN);
        this.eL.setTag(this.eN);
        this.eL.setClickable(true);
        this.eL.setOnClickListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.eL, this);
        if (this.mIsAudioEnable) {
            com.kwad.components.core.r.a.aj(this.mContext).a(this.eZ);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.a.c.bQ(this.mAdTemplate)) {
            a(this.eN, view == this.eH, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bindView(@NonNull AdTemplate adTemplate) {
        super.bindView(adTemplate);
        this.eA.setText(com.kwad.components.ad.feed.f.b(this.mAdTemplate));
        this.mLogoView.S(adTemplate);
        bo();
        if (com.kwad.sdk.core.response.a.a.ax(this.mAdInfo)) {
            bm();
        } else {
            bl();
        }
        this.eA.setOnClickListener(this);
        this.eL.setOnClickListener(this);
        this.eC.setOnClickListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.eA, this);
        new com.kwad.sdk.widget.f(getContext(), this.eL, this);
        new com.kwad.sdk.widget.f(getContext(), this.eC, this);
        setOnClickListener(this);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bk() {
        this.eA = (TextView) findViewById(R.id.ksad_ad_desc);
        KSRelativeLayout kSRelativeLayout = (KSRelativeLayout) findViewById(R.id.ksad_video_container);
        this.eL = kSRelativeLayout;
        kSRelativeLayout.setRatio(0.56f);
        this.eC = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.eM = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
        this.eH = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
        this.eR = (TextView) findViewById(R.id.ksad_live_end_text);
        this.eX = findViewById(R.id.ksad_live_end_bg_mantle);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bn() {
        super.bn();
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.eH.getAppDownloadListener());
        }
        if (this.mIsAudioEnable) {
            com.kwad.components.core.r.a.aj(this.mContext).b(this.eZ);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0065, code lost:
    
        if (r5 == r4.eN) goto L68;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onClick(android.view.View r5) {
        /*
            r4 = this;
            android.widget.ImageView r0 = r4.eC
            if (r5 != r0) goto L8
            r4.ru()
            return
        L8:
            com.kwad.sdk.widget.KSRelativeLayout r0 = r4.eL
            if (r5 != r0) goto L2c
            com.kwad.sdk.core.video.videoview.a r0 = r4.eN
            if (r0 == 0) goto L2c
            boolean r0 = r0.isIdle()
            if (r0 == 0) goto L2c
            T extends com.kwad.sdk.core.response.model.AdTemplate r5 = r4.mAdTemplate
            com.kwad.sdk.utils.l.cv(r5)
            T extends com.kwad.sdk.core.response.model.AdTemplate r5 = r4.mAdTemplate
            com.kwad.sdk.contentalliance.kwai.kwai.a r5 = com.kwad.sdk.contentalliance.kwai.kwai.a.ak(r5)
            com.kwad.sdk.core.video.videoview.a r0 = r4.eN
            r0.setKsPlayLogParam(r5)
            com.kwad.sdk.core.video.videoview.a r5 = r4.eN
            r5.start()
            return
        L2c:
            r0 = 35
            android.widget.TextView r1 = r4.eA
            r2 = 1
            r3 = 100
            if (r5 != r1) goto L38
            r0 = 25
            goto L6c
        L38:
            com.kwad.sdk.widget.KSRelativeLayout r1 = r4.eL
            if (r5 != r1) goto L3f
        L3c:
            r0 = 100
            goto L6c
        L3f:
            com.kwad.components.ad.widget.DownloadProgressView r1 = r4.eH
            if (r5 == r1) goto L6b
            android.widget.TextView r1 = r4.dR
            if (r5 == r1) goto L6b
            android.view.View r1 = r4.eG
            if (r5 != r1) goto L4c
            goto L6b
        L4c:
            android.widget.ImageView r1 = r4.dJ
            if (r5 != r1) goto L53
            r0 = 13
            goto L6c
        L53:
            android.widget.TextView r1 = r4.dK
            if (r5 != r1) goto L5a
            r0 = 14
            goto L6c
        L5a:
            android.widget.TextView r1 = r4.eE
            if (r5 == r1) goto L68
            android.widget.TextView r1 = r4.eF
            if (r5 != r1) goto L63
            goto L68
        L63:
            com.kwad.sdk.core.video.videoview.a r1 = r4.eN
            if (r5 != r1) goto L6c
            goto L3c
        L68:
            r0 = 101(0x65, float:1.42E-43)
            goto L6c
        L6b:
            r0 = 1
        L6c:
            com.kwad.sdk.core.video.videoview.a r1 = r4.eN
            com.kwad.components.ad.widget.DownloadProgressView r3 = r4.eH
            if (r5 != r3) goto L73
            goto L74
        L73:
            r2 = 0
        L74:
            r4.a(r1, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.feed.a.c.onClick(android.view.View):void");
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.g.c
    public void onPageInvisible() {
        super.onPageInvisible();
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onPause();
        }
        com.kwad.components.core.h.a.nC().c(this.eY);
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.g.c
    public void onPageVisible() {
        super.onPageVisible();
        com.kwad.components.core.video.e eVar = this.eO;
        if (eVar != null) {
            eVar.setVideoPlayCallback(this.fa);
        }
        com.kwad.components.core.h.a.nC().a(getCurrentVoiceItem());
        if (this.eW) {
            IAdLivePlayModule iAdLivePlayModule = this.eV;
            if (iAdLivePlayModule == null) {
                this.eV = bq();
            } else {
                iAdLivePlayModule.onResume();
            }
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public void onViewAttached() {
        super.onViewAttached();
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public void onViewDetached() {
        super.onViewDetached();
        com.kwad.sdk.utils.l.cu(this.mAdTemplate);
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onDestroy();
            this.eV = null;
        }
        IAdLiveOfflineView iAdLiveOfflineView = this.eT;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.onDestroy();
            this.eT = null;
        }
        com.kwad.components.core.h.a.nC().c(this.eY);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!z) {
            IAdLiveOfflineView iAdLiveOfflineView = this.eT;
            if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null) {
                return;
            }
            this.eV.onPause();
            return;
        }
        if (bp()) {
            return;
        }
        com.kwad.sdk.core.video.videoview.a aVar = this.eN;
        if (aVar != null && this.eO != null) {
            ViewGroup viewGroup = (ViewGroup) aVar.getParent();
            if (this.eN.getParent() != this.eL) {
                viewGroup.removeView(this.eN);
                if (this.eL.getTag() != null) {
                    KSRelativeLayout kSRelativeLayout = this.eL;
                    kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                    this.eL.setTag(null);
                }
                this.eL.addView(this.eN);
                this.eL.setTag(this.eN);
                com.kwad.sdk.core.response.a.a.E(this.mAdInfo);
                this.eN.setVideoSoundEnable(this.mIsAudioEnable);
                this.mAdTemplate.mIsAudioEnable = this.mIsAudioEnable;
                this.eO.setAdClickListener(this.eS);
                this.eO.getAdTemplate().mAdWebVideoPageShowing = false;
                this.eO.qx();
                this.eO.setAutoRelease(true);
            }
        }
        AdVideoPlayerViewCache.getInstance().remove(com.kwad.sdk.core.response.a.a.E(this.mAdInfo));
    }

    public void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        com.kwad.components.core.video.e eVar;
        IAdLivePlayModule iAdLivePlayModule;
        this.dZ = ksAdVideoPlayConfig;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            this.mIsAudioEnable = kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0 ? kSAdVideoPlayConfigImpl.isVideoSoundEnable() : com.kwad.sdk.core.response.a.a.bG(this.mAdInfo);
            this.mAdTemplate.mIsAudioEnable = this.mIsAudioEnable;
            IAdLiveOfflineView iAdLiveOfflineView = this.eT;
            if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || (iAdLivePlayModule = this.eV) == null) {
                com.kwad.sdk.core.video.videoview.a aVar = this.eN;
                if (aVar != null) {
                    aVar.setVideoSoundEnable(g(this.mIsAudioEnable));
                }
            } else {
                iAdLivePlayModule.setAudioEnabled(g(this.mIsAudioEnable), false);
            }
            if (this.mIsAudioEnable) {
                com.kwad.components.core.r.a.aj(this.mContext).a(this.eZ);
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() == 0 || (eVar = this.eO) == null) {
                return;
            }
            eVar.setDataAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
        }
    }
}
