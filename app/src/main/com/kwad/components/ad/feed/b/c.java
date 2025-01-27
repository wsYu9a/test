package com.kwad.components.ad.feed.b;

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
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.j.a;
import com.kwad.components.core.video.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.widget.KSRelativeLayout;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class c extends a implements View.OnClickListener, com.kwad.sdk.widget.c {
    private KsAdVideoPlayConfig bS;

    /* renamed from: ci */
    private List<Integer> f11467ci;

    /* renamed from: cn */
    private boolean f11468cn;
    private com.kwad.sdk.core.video.videoview.a co;
    private a.b cx;
    private OfflineOnAudioConflictListener cy;
    private volatile boolean dP;
    private com.kwad.sdk.widget.j dQ;
    private ImageView eT;
    private TextView eU;
    private TextView fX;
    private ImageView fZ;

    /* renamed from: fb */
    private TextView f11469fb;

    /* renamed from: gb */
    private TextView f11470gb;

    /* renamed from: gc */
    private TextView f11471gc;

    /* renamed from: gd */
    private View f11472gd;

    /* renamed from: ge */
    private DownloadProgressView f11473ge;

    /* renamed from: gg */
    private KSRelativeLayout f11474gg;

    /* renamed from: gh */
    private ImageView f11475gh;

    /* renamed from: gi */
    private com.kwad.components.core.video.e f11476gi;

    /* renamed from: gj */
    private d f11477gj;

    /* renamed from: gk */
    private TextView f11478gk;
    private final a.InterfaceC0446a gl;
    private IAdLiveOfflineView gm;
    private com.kwad.components.core.n.a.a.a gn;
    private IAdLivePlayModule go;
    private boolean gp;
    private View gq;
    private a.b gr;
    private final AdLivePlayStateListener gs;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private boolean mIsAudioEnable;
    private KsLogoView mLogoView;

    /* renamed from: com.kwad.components.ad.feed.b.c$1 */
    public class AnonymousClass1 implements com.kwad.sdk.widget.j {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.widget.j
        public final void aN() {
            com.kwad.sdk.utils.m.eA(c.this.mAdTemplate);
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.c$10 */
    public class AnonymousClass10 implements a.b {
        public AnonymousClass10() {
        }

        @Override // com.kwad.components.core.video.a.c
        public final void ap() {
            com.kwad.sdk.core.video.videoview.a aVar = c.this.co;
            c cVar = c.this;
            aVar.setVideoSoundEnable(cVar.h(cVar.mIsAudioEnable));
        }

        @Override // com.kwad.components.core.video.a.c
        public final void aq() {
            if (com.kwad.components.ad.feed.a.b.by() && c.this.f11477gj == null) {
                c.this.f11477gj = new d(c.this.getContext());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                c cVar = c.this;
                cVar.addView(cVar.f11477gj, layoutParams);
                c.this.f11477gj.bN();
            }
            com.kwad.sdk.core.adlog.c.bT(c.this.mAdTemplate);
        }

        @Override // com.kwad.components.core.video.a.c
        public final void d(long j10) {
            c.this.c(j10);
        }

        @Override // com.kwad.components.core.video.a.b
        public final void onVideoPlayError(int i10, int i11) {
            com.kwad.components.ad.feed.monitor.b.a(c.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.b.a.K(c.this.mAdInfo), i10 + " " + i11, SystemClock.elapsedRealtime() - c.this.fQ);
        }

        @Override // com.kwad.components.core.video.a.c
        public final void onVideoPlayStart() {
            com.kwad.components.core.j.a.pv().a(c.this.getCurrentVoiceItem());
            if (c.this.f11477gj != null && (c.this.f11477gj.getParent() instanceof ViewGroup)) {
                ((ViewGroup) c.this.f11477gj.getParent()).removeView(c.this.f11477gj);
                c.this.f11477gj.bO();
                c.this.f11477gj = null;
            }
            com.kwad.components.ad.feed.monitor.b.a(c.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.b.a.K(c.this.mAdInfo), null, SystemClock.elapsedRealtime() - c.this.fQ);
            com.kwad.sdk.core.adlog.c.bS(c.this.mAdTemplate);
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.c$2 */
    public class AnonymousClass2 implements a.c {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.j.a.c
        public final void bM() {
            if (!c.this.gp) {
                if (c.this.co != null) {
                    com.kwad.sdk.core.video.videoview.a aVar = c.this.co;
                    c cVar = c.this;
                    aVar.setVideoSoundEnable(cVar.h(cVar.mIsAudioEnable));
                    return;
                }
                return;
            }
            if (c.this.go == null) {
                c cVar2 = c.this;
                cVar2.go = cVar2.bK();
            }
            IAdLivePlayModule iAdLivePlayModule = c.this.go;
            c cVar3 = c.this;
            iAdLivePlayModule.setAudioEnabled(cVar3.h(cVar3.mIsAudioEnable), false);
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.c$3 */
    public class AnonymousClass3 implements a.InterfaceC0446a {

        /* renamed from: com.kwad.components.ad.feed.b.c$3$1 */
        public class AnonymousClass1 implements a.b {
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                c.this.ur();
            }
        }

        public AnonymousClass3() {
        }

        @Override // com.kwad.components.core.video.a.InterfaceC0446a
        public final void a(int i10, ag.a aVar) {
            int i11;
            int i12 = 2;
            boolean z10 = false;
            if (i10 == 1) {
                i11 = 15;
            } else if (i10 == 2) {
                i11 = 16;
            } else if (i10 != 3) {
                i11 = 35;
            } else {
                i11 = 39;
                i12 = 1;
                z10 = true;
            }
            c.this.bC();
            com.kwad.components.core.e.d.a.a(new a.C0427a(c.this.getContext()).au(c.this.mAdTemplate).b(c.this.mApkDownloadHelper).ao(i12).ap(z10).ar(true).am(5).an(i11).d(aVar).at(true).a(new a.b() { // from class: com.kwad.components.ad.feed.b.c.3.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    c.this.ur();
                }
            }));
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.c$4 */
    public class AnonymousClass4 extends bd {
        final /* synthetic */ View gv;

        public AnonymousClass4(View view) {
            view = view;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            c.this.d(view);
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.c$5 */
    public class AnonymousClass5 extends SimpleImageLoadingListener {
        public AnonymousClass5() {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
            return true;
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.c$6 */
    public class AnonymousClass6 extends bd {
        final /* synthetic */ View gv;

        public AnonymousClass6(View view) {
            view = view;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            int width = c.this.f11474gg.getWidth();
            int height = c.this.f11474gg.getHeight();
            if (width == 0 || height == 0) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (height * 0.5625f), height);
            layoutParams.addRule(13, -1);
            view.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.c$7 */
    public class AnonymousClass7 extends AdLivePlayStateListenerAdapter {
        public AnonymousClass7() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            c.this.f11478gk.setVisibility(0);
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j10) {
            super.onLivePlayProgress(j10);
            c.this.c(j10);
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayResume() {
            super.onLivePlayResume();
            com.kwad.components.core.j.a.pv().a(c.this.getCurrentVoiceItem());
            IAdLivePlayModule iAdLivePlayModule = c.this.go;
            c cVar = c.this;
            iAdLivePlayModule.setAudioEnabled(cVar.h(cVar.mIsAudioEnable), false);
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayStart() {
            super.onLivePlayStart();
            com.kwad.components.core.j.a.pv().a(c.this.getCurrentVoiceItem());
            IAdLivePlayModule iAdLivePlayModule = c.this.go;
            c cVar = c.this;
            iAdLivePlayModule.setAudioEnabled(cVar.h(cVar.mIsAudioEnable), false);
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.c$8 */
    public class AnonymousClass8 implements OfflineOnAudioConflictListener {
        public AnonymousClass8() {
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            c.b(c.this, false);
            if (c.this.co != null) {
                c.this.co.setVideoSoundEnable(false);
            }
            if (c.this.go != null) {
                c.this.go.setAudioEnabled(false, false);
            }
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeReleased() {
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.c$9 */
    public class AnonymousClass9 implements a.b {
        final /* synthetic */ int cO;

        public AnonymousClass9(int i10) {
            i10 = i10;
        }

        @Override // com.kwad.components.core.e.d.a.b
        public final void onAdClicked() {
            c.this.aM(i10);
        }
    }

    public c(@NonNull Context context) {
        super(context);
        this.mIsAudioEnable = false;
        this.dP = false;
        this.dQ = new com.kwad.sdk.widget.j() { // from class: com.kwad.components.ad.feed.b.c.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.widget.j
            public final void aN() {
                com.kwad.sdk.utils.m.eA(c.this.mAdTemplate);
            }
        };
        this.gl = new a.InterfaceC0446a() { // from class: com.kwad.components.ad.feed.b.c.3

            /* renamed from: com.kwad.components.ad.feed.b.c$3$1 */
            public class AnonymousClass1 implements a.b {
                public AnonymousClass1() {
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    c.this.ur();
                }
            }

            public AnonymousClass3() {
            }

            @Override // com.kwad.components.core.video.a.InterfaceC0446a
            public final void a(int i10, ag.a aVar) {
                int i11;
                int i12 = 2;
                boolean z10 = false;
                if (i10 == 1) {
                    i11 = 15;
                } else if (i10 == 2) {
                    i11 = 16;
                } else if (i10 != 3) {
                    i11 = 35;
                } else {
                    i11 = 39;
                    i12 = 1;
                    z10 = true;
                }
                c.this.bC();
                com.kwad.components.core.e.d.a.a(new a.C0427a(c.this.getContext()).au(c.this.mAdTemplate).b(c.this.mApkDownloadHelper).ao(i12).ap(z10).ar(true).am(5).an(i11).d(aVar).at(true).a(new a.b() { // from class: com.kwad.components.ad.feed.b.c.3.1
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        c.this.ur();
                    }
                }));
            }
        };
        this.gs = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.feed.b.c.7
            public AnonymousClass7() {
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                super.onLivePlayEnd();
                c.this.f11478gk.setVisibility(0);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(long j10) {
                super.onLivePlayProgress(j10);
                c.this.c(j10);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                super.onLivePlayResume();
                com.kwad.components.core.j.a.pv().a(c.this.getCurrentVoiceItem());
                IAdLivePlayModule iAdLivePlayModule = c.this.go;
                c cVar = c.this;
                iAdLivePlayModule.setAudioEnabled(cVar.h(cVar.mIsAudioEnable), false);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                super.onLivePlayStart();
                com.kwad.components.core.j.a.pv().a(c.this.getCurrentVoiceItem());
                IAdLivePlayModule iAdLivePlayModule = c.this.go;
                c cVar = c.this;
                iAdLivePlayModule.setAudioEnabled(cVar.h(cVar.mIsAudioEnable), false);
            }
        };
        this.cy = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.feed.b.c.8
            public AnonymousClass8() {
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                c.b(c.this, false);
                if (c.this.co != null) {
                    c.this.co.setVideoSoundEnable(false);
                }
                if (c.this.go != null) {
                    c.this.go.setAudioEnabled(false, false);
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }
        };
        this.cx = new a.b() { // from class: com.kwad.components.ad.feed.b.c.10
            public AnonymousClass10() {
            }

            @Override // com.kwad.components.core.video.a.c
            public final void ap() {
                com.kwad.sdk.core.video.videoview.a aVar = c.this.co;
                c cVar = c.this;
                aVar.setVideoSoundEnable(cVar.h(cVar.mIsAudioEnable));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void aq() {
                if (com.kwad.components.ad.feed.a.b.by() && c.this.f11477gj == null) {
                    c.this.f11477gj = new d(c.this.getContext());
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    c cVar = c.this;
                    cVar.addView(cVar.f11477gj, layoutParams);
                    c.this.f11477gj.bN();
                }
                com.kwad.sdk.core.adlog.c.bT(c.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j10) {
                c.this.c(j10);
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlayError(int i10, int i11) {
                com.kwad.components.ad.feed.monitor.b.a(c.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.b.a.K(c.this.mAdInfo), i10 + " " + i11, SystemClock.elapsedRealtime() - c.this.fQ);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.components.core.j.a.pv().a(c.this.getCurrentVoiceItem());
                if (c.this.f11477gj != null && (c.this.f11477gj.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) c.this.f11477gj.getParent()).removeView(c.this.f11477gj);
                    c.this.f11477gj.bO();
                    c.this.f11477gj = null;
                }
                com.kwad.components.ad.feed.monitor.b.a(c.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.b.a.K(c.this.mAdInfo), null, SystemClock.elapsedRealtime() - c.this.fQ);
                com.kwad.sdk.core.adlog.c.bS(c.this.mAdTemplate);
            }
        };
    }

    private void bF() {
        findViewById(R.id.ksad_ad_h5_container).setVisibility(0);
        findViewById(R.id.ksad_ad_download_container).setVisibility(8);
        this.f11471gc = (TextView) findViewById(R.id.ksad_h5_desc);
        this.f11469fb = (TextView) findViewById(R.id.ksad_h5_open_btn);
        this.f11472gd = findViewById(R.id.ksad_h5_open_cover);
        this.f11471gc.setText(com.kwad.components.ad.feed.f.g(this.mAdTemplate));
        this.f11469fb.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
        this.f11472gd.setOnClickListener(this);
        this.f11471gc.setOnClickListener(this);
        this.f11469fb.setOnClickListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.f11472gd, this);
        new com.kwad.sdk.widget.f(getContext(), this.f11471gc, this);
        new com.kwad.sdk.widget.f(getContext(), this.f11469fb, this);
    }

    private void bG() {
        findViewById(R.id.ksad_ad_download_container).setVisibility(0);
        findViewById(R.id.ksad_ad_h5_container).setVisibility(8);
        this.eT = (ImageView) findViewById(R.id.ksad_app_icon);
        this.eU = (TextView) findViewById(R.id.ksad_app_title);
        TextView textView = (TextView) findViewById(R.id.ksad_app_desc);
        this.f11470gb = textView;
        com.kwad.sdk.c.a.a.a(this, this.eT, this.eU, textView);
        new com.kwad.sdk.widget.f(getContext(), this.eT, this);
        new com.kwad.sdk.widget.f(getContext(), this.eU, this);
        new com.kwad.sdk.widget.f(getContext(), this.f11470gb, this);
        this.eU.setText(com.kwad.sdk.core.response.b.a.av(this.mAdInfo));
        this.eT.setImageResource(R.drawable.ksad_default_app_icon);
        KSImageLoader.loadAppIcon(this.eT, com.kwad.sdk.core.response.b.a.cm(this.mAdInfo), this.mAdTemplate, 8);
        this.f11470gb.setText(com.kwad.components.ad.feed.f.g(this.mAdTemplate));
        bD();
        this.f11473ge.am(this.mAdTemplate);
        this.f11473ge.setOnClickListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.f11473ge, this);
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, this.f11473ge.getAppDownloadListener());
        this.mApkDownloadHelper = cVar;
        cVar.d(this.f11473ge.getAppDownloadListener());
        this.mApkDownloadHelper.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
    }

    private void bI() {
        com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.d.f(com.kwad.components.core.n.a.a.a.class);
        this.gn = aVar;
        if (aVar != null && aVar.pz() && com.kwad.sdk.core.response.b.a.cS(this.mAdInfo)) {
            this.gp = true;
        }
    }

    private boolean bJ() {
        IAdLiveOfflineView iAdLiveOfflineView = this.gm;
        if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || !this.gp) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) this.gm.getView().getParent();
        if (viewGroup != this.f11474gg) {
            viewGroup.removeView(this.gm.getView());
            if (this.f11474gg.getTag() != null) {
                KSRelativeLayout kSRelativeLayout = this.f11474gg;
                kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                this.f11474gg.setTag(null);
            }
            this.f11474gg.addView(this.gm.getView());
            this.f11474gg.setTag(this.gm.getView());
            this.go.setAudioEnabled(this.mIsAudioEnable, false);
            IAdLivePlayModule adLivePlayModule = this.gn.getAdLivePlayModule(this.gm, ServiceProvider.getAppId(), String.valueOf(com.kwad.sdk.core.response.b.a.cn(this.mAdInfo)), com.kwad.sdk.core.response.b.a.co(this.mAdInfo), com.kwad.sdk.core.response.b.a.cp(this.mAdInfo));
            this.go = adLivePlayModule;
            adLivePlayModule.registerAdLivePlayStateListener(this.gs);
        }
        this.go.onResume();
        return true;
    }

    public IAdLivePlayModule bK() {
        bL();
        IAdLiveOfflineView a10 = com.kwad.components.ad.k.b.a(this.gn, this.mContext, 3);
        this.gm = a10;
        if (a10 == null) {
            return null;
        }
        IAdLivePlayModule adLivePlayModule = this.gn.getAdLivePlayModule(a10, ServiceProvider.MB().appId, String.valueOf(com.kwad.sdk.core.response.b.a.cn(this.mAdInfo)), com.kwad.sdk.core.response.b.a.co(this.mAdInfo), com.kwad.sdk.core.response.b.a.cp(this.mAdInfo));
        adLivePlayModule.setAudioEnabled(h(this.mIsAudioEnable), false);
        adLivePlayModule.registerAdLivePlayStateListener(this.gs);
        View view = this.gm.getView();
        if (this.f11474gg.getTag() != null) {
            KSRelativeLayout kSRelativeLayout = this.f11474gg;
            kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
            this.f11474gg.setTag(null);
        }
        this.f11474gg.addView(view);
        this.f11474gg.setTag(view);
        bt.postOnUiThread(new bd() { // from class: com.kwad.components.ad.feed.b.c.4
            final /* synthetic */ View gv;

            public AnonymousClass4(View view2) {
                view = view2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                c.this.d(view);
            }
        });
        if (this.mIsAudioEnable) {
            com.kwad.components.core.s.a.av(this.mContext).a(this.cy);
        }
        return adLivePlayModule;
    }

    private void bL() {
        String url = com.kwad.sdk.core.response.b.a.bt(this.mAdInfo).getUrl();
        this.f11475gh.setVisibility(0);
        this.gq.setVisibility(0);
        if (TextUtils.isEmpty(url)) {
            this.f11475gh.setImageResource(R.drawable.ksad_ad_live_end);
        } else {
            this.f11475gh.setImageDrawable(null);
            KSImageLoader.loadImage(this.f11475gh, url, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.feed.b.c.5
                public AnonymousClass5() {
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                    return true;
                }
            });
        }
    }

    public a.b getCurrentVoiceItem() {
        if (this.gr == null) {
            this.gr = new a.b(new a.c() { // from class: com.kwad.components.ad.feed.b.c.2
                public AnonymousClass2() {
                }

                @Override // com.kwad.components.core.j.a.c
                public final void bM() {
                    if (!c.this.gp) {
                        if (c.this.co != null) {
                            com.kwad.sdk.core.video.videoview.a aVar = c.this.co;
                            c cVar = c.this;
                            aVar.setVideoSoundEnable(cVar.h(cVar.mIsAudioEnable));
                            return;
                        }
                        return;
                    }
                    if (c.this.go == null) {
                        c cVar2 = c.this;
                        cVar2.go = cVar2.bK();
                    }
                    IAdLivePlayModule iAdLivePlayModule = c.this.go;
                    c cVar3 = c.this;
                    iAdLivePlayModule.setAudioEnabled(cVar3.h(cVar3.mIsAudioEnable), false);
                }
            });
        }
        return this.gr;
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void Z() {
        DownloadProgressView downloadProgressView;
        super.Z();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (downloadProgressView = this.f11473ge) == null) {
            return;
        }
        cVar.b(downloadProgressView.getAppDownloadListener());
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        super.aa();
        com.kwad.sdk.utils.m.ey(this.mAdTemplate);
        IAdLivePlayModule iAdLivePlayModule = this.go;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onDestroy();
            this.go = null;
        }
        IAdLiveOfflineView iAdLiveOfflineView = this.gm;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.onDestroy();
            this.gm = null;
        }
        com.kwad.components.core.j.a.pv().c(this.gr);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bE() {
        this.fX = (TextView) findViewById(R.id.ksad_ad_desc);
        KSRelativeLayout kSRelativeLayout = (KSRelativeLayout) findViewById(R.id.ksad_video_container);
        this.f11474gg = kSRelativeLayout;
        kSRelativeLayout.setRatio(0.56f);
        this.fZ = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.f11475gh = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
        this.f11473ge = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
        this.f11478gk = (TextView) findViewById(R.id.ksad_live_end_text);
        this.gq = findViewById(R.id.ksad_live_end_bg_mantle);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bH() {
        super.bH();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.f11473ge.getAppDownloadListener());
        }
        if (this.mIsAudioEnable) {
            com.kwad.components.core.s.a.av(this.mContext).b(this.cy);
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.c
    public final void bl() {
        super.bl();
        com.kwad.components.core.video.e eVar = this.f11476gi;
        if (eVar != null) {
            eVar.setVideoPlayCallback(this.cx);
        }
        com.kwad.components.core.j.a.pv().a(getCurrentVoiceItem());
        if (this.gp) {
            IAdLivePlayModule iAdLivePlayModule = this.go;
            if (iAdLivePlayModule == null) {
                this.go = bK();
            } else {
                iAdLivePlayModule.onResume();
            }
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.c
    public final void bm() {
        super.bm();
        IAdLivePlayModule iAdLivePlayModule = this.go;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onPause();
        }
        com.kwad.components.core.j.a.pv().c(this.gr);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i10;
        com.kwad.sdk.core.video.videoview.a aVar;
        if (view == this.fZ) {
            us();
            return;
        }
        if (view == this.f11474gg && (aVar = this.co) != null && aVar.isIdle()) {
            com.kwad.sdk.utils.m.ez(this.mAdTemplate);
            this.co.setKsPlayLogParam(com.kwad.sdk.contentalliance.a.a.a.bL(this.mAdTemplate));
            this.co.start();
            return;
        }
        if (view == this.fX) {
            i10 = 25;
        } else {
            if (view != this.f11474gg) {
                if (view == this.f11473ge || view == this.f11469fb || view == this.f11472gd) {
                    i10 = 1;
                } else if (view == this.eT) {
                    i10 = 13;
                } else if (view == this.eU) {
                    i10 = 14;
                } else if (view == this.f11470gb || view == this.f11471gc) {
                    i10 = 101;
                } else if (view != this.co) {
                    i10 = 35;
                }
            }
            i10 = 100;
        }
        a(this.co, view == this.f11473ge, i10);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (!z10) {
            IAdLiveOfflineView iAdLiveOfflineView = this.gm;
            if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null) {
                return;
            }
            this.go.onPause();
            return;
        }
        if (bJ()) {
            return;
        }
        com.kwad.sdk.core.video.videoview.a aVar = this.co;
        if (aVar != null && this.f11476gi != null) {
            ViewGroup viewGroup = (ViewGroup) aVar.getParent();
            if (this.co.getParent() != this.f11474gg) {
                viewGroup.removeView(this.co);
                if (this.f11474gg.getTag() != null) {
                    KSRelativeLayout kSRelativeLayout = this.f11474gg;
                    kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                    this.f11474gg.setTag(null);
                }
                this.f11474gg.addView(this.co);
                this.f11474gg.setTag(this.co);
                com.kwad.sdk.core.response.b.a.K(this.mAdInfo);
                this.co.setVideoSoundEnable(this.mIsAudioEnable);
                this.mAdTemplate.mIsAudioEnable = this.mIsAudioEnable;
                this.f11476gi.setAdClickListener(this.gl);
                this.f11476gi.getAdTemplate().mAdWebVideoPageShowing = false;
                this.f11476gi.sO();
                this.f11476gi.setAutoRelease(true);
            }
        }
        AdVideoPlayerViewCache.getInstance().remove(com.kwad.sdk.core.response.b.a.K(this.mAdInfo));
    }

    public void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        com.kwad.components.core.video.e eVar;
        IAdLivePlayModule iAdLivePlayModule;
        this.bS = ksAdVideoPlayConfig;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                this.mIsAudioEnable = kSAdVideoPlayConfigImpl.isVideoSoundEnable();
            } else {
                this.mIsAudioEnable = com.kwad.sdk.core.response.b.a.bZ(this.mAdInfo);
            }
            this.mAdTemplate.mIsAudioEnable = this.mIsAudioEnable;
            IAdLiveOfflineView iAdLiveOfflineView = this.gm;
            if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || (iAdLivePlayModule = this.go) == null) {
                com.kwad.sdk.core.video.videoview.a aVar = this.co;
                if (aVar != null) {
                    aVar.setVideoSoundEnable(h(this.mIsAudioEnable));
                }
            } else {
                iAdLivePlayModule.setAudioEnabled(h(this.mIsAudioEnable), false);
            }
            if (this.mIsAudioEnable) {
                com.kwad.components.core.s.a.av(this.mContext).a(this.cy);
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() == 0 || (eVar = this.f11476gi) == null) {
                return;
            }
            eVar.setDataAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
        }
    }

    public static /* synthetic */ boolean b(c cVar, boolean z10) {
        cVar.f11468cn = false;
        return false;
    }

    public void d(View view) {
        view.post(new bd() { // from class: com.kwad.components.ad.feed.b.c.6
            final /* synthetic */ View gv;

            public AnonymousClass6(View view2) {
                view = view2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                int width = c.this.f11474gg.getWidth();
                int height = c.this.f11474gg.getHeight();
                if (width == 0 || height == 0) {
                    return;
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (height * 0.5625f), height);
                layoutParams.addRule(13, -1);
                view.setLayoutParams(layoutParams);
            }
        });
    }

    public boolean h(boolean z10) {
        if (!z10) {
            return false;
        }
        if (!com.kwad.sdk.core.config.d.gN()) {
            return !com.kwad.components.core.s.a.av(this.mContext).sb() ? com.kwad.components.core.s.a.av(this.mContext).aO(false) : !com.kwad.components.core.s.a.av(this.mContext).sa();
        }
        if (!this.f11468cn) {
            this.f11468cn = com.kwad.components.core.s.a.av(this.mContext).aO(true);
        }
        return this.f11468cn;
    }

    @Override // com.kwad.components.core.widget.b
    public final void c(@NonNull AdResultData adResultData) {
        super.c((c) adResultData);
        this.fX.setText(com.kwad.components.ad.feed.f.g(this.mAdTemplate));
        this.mLogoView.aK(this.mAdTemplate);
        bI();
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            bG();
        } else {
            bF();
        }
        this.fX.setOnClickListener(this);
        this.f11474gg.setOnClickListener(this);
        this.fZ.setOnClickListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.fX, this);
        new com.kwad.sdk.widget.f(getContext(), this.f11474gg, this);
        new com.kwad.sdk.widget.f(getContext(), this.fZ, this);
        setOnClickListener(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00f1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(@androidx.annotation.NonNull com.kwad.sdk.api.KsAdVideoPlayConfig r10) {
        /*
            Method dump skipped, instructions count: 419
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.feed.b.c.b(com.kwad.sdk.api.KsAdVideoPlayConfig):void");
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        onClick(view);
    }

    private void a(com.kwad.sdk.core.video.videoview.a aVar, boolean z10, int i10) {
        com.kwad.components.core.video.e eVar;
        if (aVar != null || this.gp) {
            String K = com.kwad.sdk.core.response.b.a.K(this.mAdInfo);
            if (!this.gp && (eVar = this.f11476gi) != null) {
                eVar.setAutoRelease(false);
            }
            int i11 = z10 ? 1 : 2;
            if (!this.gp) {
                AdVideoPlayerViewCache.getInstance().a(K, this.co);
            }
            bC();
            a.C0427a ap = new a.C0427a(getContext()).au(this.mAdTemplate).b(this.mApkDownloadHelper).ap(z10);
            IAdLivePlayModule iAdLivePlayModule = this.go;
            com.kwad.components.core.e.d.a.a(ap.v(iAdLivePlayModule == null ? 0L : iAdLivePlayModule.getPlayDuration()).ao(i11).at(true).a(new a.b() { // from class: com.kwad.components.ad.feed.b.c.9
                final /* synthetic */ int cO;

                public AnonymousClass9(int i102) {
                    i10 = i102;
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    c.this.aM(i10);
                }
            }));
        }
    }

    public void c(long j10) {
        int ceil = (int) Math.ceil(j10 / 1000.0f);
        List<Integer> list = this.f11467ci;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.f11467ci.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a((AdTemplate) this.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.dQ(this.mAdTemplate)) {
            a(this.co, view == this.f11473ge, 153);
        }
    }
}
