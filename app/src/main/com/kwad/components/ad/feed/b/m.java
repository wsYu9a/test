package com.kwad.components.ad.feed.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.feed.d;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.j.a;
import com.kwad.components.core.liveEnd.AdLiveEndCommonResultData;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.video.a;
import com.kwad.components.core.webview.b;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveMessageListener;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveShopListener;
import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.ap;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.bd;
import com.kwad.components.core.widget.b;
import com.kwad.components.model.FeedType;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener;
import com.kwad.components.offline.api.core.adlive.model.AdLiveMessageInfo;
import com.kwad.components.offline.api.core.adlive.model.AdLiveShopInfo;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.widget.KSRelativeLayout;
import com.kwad.sdk.widget.RatioFrameLayout;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class m extends com.kwad.components.core.widget.b<AdResultData, AdTemplate> implements View.OnClickListener, com.kwad.sdk.widget.c {
    private static final HashMap<Long, Double> gW = new HashMap<>(8);
    private KsAdVideoPlayConfig bS;

    /* renamed from: ci */
    private List<Integer> f11481ci;

    /* renamed from: cn */
    private boolean f11482cn;
    private com.kwad.sdk.core.video.videoview.a co;
    private OfflineOnAudioConflictListener cy;

    /* renamed from: ec */
    private int f11483ec;
    private d.InterfaceC0369d fD;
    private long fQ;
    private float fR;
    private float fS;
    private RatioFrameLayout gO;
    private double gP;
    private LinearLayout gQ;
    private TextView gR;
    private bd gS;
    private ay gT;
    private WebCardRegisterLiveMessageListener gU;
    private WebCardRegisterLiveShopListener gV;
    private boolean gX;
    private String gY;
    private az.b gZ;

    /* renamed from: gg */
    private KSRelativeLayout f11484gg;

    /* renamed from: gh */
    private ImageView f11485gh;

    /* renamed from: gi */
    private com.kwad.components.core.video.e f11486gi;

    /* renamed from: gj */
    private d f11487gj;
    private final a.InterfaceC0446a gl;
    private IAdLiveOfflineView gm;
    private com.kwad.components.core.n.a.a.a gn;
    private IAdLivePlayModule go;
    private boolean gp;
    private View gq;
    private a.b gr;
    private final AdLivePlayStateListener gs;

    /* renamed from: ha */
    private az.a f11488ha;

    /* renamed from: hb */
    private com.kwad.components.core.widget.b f11489hb;

    /* renamed from: hc */
    private boolean f11490hc;

    /* renamed from: hd */
    private a f11491hd;

    /* renamed from: he */
    private ViewGroup.MarginLayoutParams f11492he;

    /* renamed from: hf */
    private Handler f11493hf;

    /* renamed from: hg */
    private e f11494hg;

    /* renamed from: hh */
    private as f11495hh;

    /* renamed from: hi */
    private boolean f11496hi;

    /* renamed from: hj */
    private boolean f11497hj;

    /* renamed from: hk */
    private com.kwad.components.core.webview.b f11498hk;
    private com.kwad.components.core.webview.c hl;
    private b.a hm;
    private IAdLiveEndRequest hn;
    private boolean isNative;
    private KsAdWebView mAdWebView;

    @Nullable
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private boolean mIsAudioEnable;
    private final com.kwad.sdk.core.network.l<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData> mNetworking;
    private int mWidth;

    /* renamed from: com.kwad.components.ad.feed.b.m$1 */
    public class AnonymousClass1 implements OfflineOnAudioConflictListener {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            m.a(m.this, false);
            if (m.this.co != null) {
                m.this.co.setVideoSoundEnable(false);
            }
            if (m.this.go != null) {
                m.this.go.setAudioEnabled(false, false);
            }
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeReleased() {
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.m$10 */
    public class AnonymousClass10 implements a.InterfaceC0446a {

        /* renamed from: com.kwad.components.ad.feed.b.m$10$1 */
        public class AnonymousClass1 implements a.b {
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                m.this.ur();
            }
        }

        public AnonymousClass10() {
        }

        @Override // com.kwad.components.core.video.a.InterfaceC0446a
        public final void a(int i10, ag.a aVar) {
            int i11;
            int i12 = 2;
            boolean z10 = false;
            if (i10 == 1) {
                i11 = 13;
            } else if (i10 == 2) {
                i11 = 82;
            } else if (i10 != 3) {
                i11 = 108;
            } else {
                i11 = 83;
                i12 = 1;
                z10 = true;
            }
            m.this.bV();
            com.kwad.components.core.e.d.a.a(new a.C0427a(m.this.getContext()).au(m.this.mAdTemplate).b(m.this.mApkDownloadHelper).ao(i12).ap(z10).ar(true).an(i11).d(aVar).at(true).a(new a.b() { // from class: com.kwad.components.ad.feed.b.m.10.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    m.this.ur();
                }
            }));
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.m$12 */
    public class AnonymousClass12 extends com.kwad.sdk.utils.bd {
        public AnonymousClass12() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            m.this.mAdWebView.stopLoading();
            m.this.mAdWebView.setVisibility(8);
            m.this.a("0", 1, 6);
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.m$13 */
    public class AnonymousClass13 implements b.a {
        public AnonymousClass13() {
        }

        @Override // com.kwad.components.core.widget.b.a
        public final void onAdClicked() {
            if (m.this.aer != null) {
                m.this.aer.onAdClicked();
            }
        }

        @Override // com.kwad.components.core.widget.b.a
        public final void onAdShow() {
            if (m.this.aer != null && m.this.isNative) {
                m.this.aer.onAdShow();
            }
            if (m.this.isNative) {
                com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                a.C0484a c0484a = new a.C0484a();
                FeedType fromInt = FeedType.fromInt(m.this.mAdTemplate.type);
                if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                    fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                }
                c0484a.templateId = String.valueOf(fromInt.getType());
                bVar.b(c0484a);
                bVar.v((int) Math.ceil(m.this.gP), m.this.mWidth);
                com.kwad.components.core.s.b.sc().a(m.this.mAdTemplate, null, bVar);
                com.kwad.components.ad.feed.monitor.b.a(m.this.mAdTemplate, 1, 2);
            }
        }

        @Override // com.kwad.components.core.widget.b.a
        public final void onDislikeClicked() {
            if (m.this.aer != null) {
                m.this.aer.onDislikeClicked();
            }
        }

        @Override // com.kwad.components.core.widget.b.a
        public final void onDownloadTipsDialogDismiss() {
            if (m.this.aer != null) {
                m.this.aer.onDownloadTipsDialogDismiss();
            }
        }

        @Override // com.kwad.components.core.widget.b.a
        public final void onDownloadTipsDialogShow() {
            if (m.this.aer != null) {
                m.this.aer.onDownloadTipsDialogShow();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.m$14 */
    public class AnonymousClass14 implements az.c {
        public AnonymousClass14() {
        }

        @Override // com.kwad.components.core.webview.jshandler.az.c
        public final void a(az.b bVar) {
            m.this.gZ = bVar;
            if (m.this.f11488ha != null) {
                m.this.gZ.a(m.this.f11488ha);
                m.this.f11488ha = null;
            }
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.m$15 */
    public class AnonymousClass15 extends com.kwad.sdk.core.network.l<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData> {
        public AnonymousClass15() {
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: cb */
        public com.kwad.components.core.liveEnd.a createRequest() {
            return new com.kwad.components.core.liveEnd.a(m.this.hn);
        }

        @NonNull
        private static AdLiveEndCommonResultData r(String str) {
            AdLiveEndCommonResultData adLiveEndCommonResultData = new AdLiveEndCommonResultData();
            adLiveEndCommonResultData.parseJson(new JSONObject(str));
            return adLiveEndCommonResultData;
        }

        @Override // com.kwad.sdk.core.network.l
        public final boolean isPostByJson() {
            return false;
        }

        @Override // com.kwad.sdk.core.network.l
        @NonNull
        public final /* synthetic */ AdLiveEndCommonResultData parseData(String str) {
            return r(str);
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.m$16 */
    public class AnonymousClass16 extends AdLivePlayStateListenerAdapter {

        /* renamed from: com.kwad.components.ad.feed.b.m$16$1 */
        public class AnonymousClass1 extends o<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData> {
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onStartRequest(@NonNull com.kwad.components.core.liveEnd.a aVar) {
                super.onStartRequest(aVar);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar, @NonNull AdLiveEndCommonResultData adLiveEndCommonResultData) {
                super.onSuccess(aVar, adLiveEndCommonResultData);
                az.a aVar2 = new az.a();
                aVar2.status = 9;
                aVar2.totalWatchingDuration = adLiveEndCommonResultData.totalWatchingDuration;
                aVar2.watchingUserCount = adLiveEndCommonResultData.watchingUserCount;
                aVar2.displayWatchingUserCount = adLiveEndCommonResultData.displayWatchingUserCount;
                aVar2.likeUserCount = adLiveEndCommonResultData.likeUserCount;
                aVar2.displayLikeUserCount = adLiveEndCommonResultData.displayLikeUserCount;
                aVar2.liveDuration = adLiveEndCommonResultData.liveDuration;
                if (m.this.gZ != null) {
                    m.this.gZ.a(aVar2);
                } else {
                    m.this.f11488ha = aVar2;
                }
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onError(@NonNull com.kwad.components.core.liveEnd.a aVar, int i10, String str) {
                super.onError(aVar, i10, str);
            }
        }

        public AnonymousClass16() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            String bg2 = com.kwad.sdk.core.response.b.a.bg(m.this.mAdInfo);
            if (TextUtils.isEmpty(bg2)) {
                return;
            }
            com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.d.f(com.kwad.components.core.n.a.a.a.class);
            if (aVar != null) {
                m.this.hn = aVar.getAdLiveEndRequest(bg2);
            }
            m.this.mNetworking.request(new o<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.feed.b.m.16.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                /* renamed from: a */
                public void onStartRequest(@NonNull com.kwad.components.core.liveEnd.a aVar2) {
                    super.onStartRequest(aVar2);
                }

                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                /* renamed from: a */
                public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar2, @NonNull AdLiveEndCommonResultData adLiveEndCommonResultData) {
                    super.onSuccess(aVar2, adLiveEndCommonResultData);
                    az.a aVar22 = new az.a();
                    aVar22.status = 9;
                    aVar22.totalWatchingDuration = adLiveEndCommonResultData.totalWatchingDuration;
                    aVar22.watchingUserCount = adLiveEndCommonResultData.watchingUserCount;
                    aVar22.displayWatchingUserCount = adLiveEndCommonResultData.displayWatchingUserCount;
                    aVar22.likeUserCount = adLiveEndCommonResultData.likeUserCount;
                    aVar22.displayLikeUserCount = adLiveEndCommonResultData.displayLikeUserCount;
                    aVar22.liveDuration = adLiveEndCommonResultData.liveDuration;
                    if (m.this.gZ != null) {
                        m.this.gZ.a(aVar22);
                    } else {
                        m.this.f11488ha = aVar22;
                    }
                }

                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                /* renamed from: a */
                public void onError(@NonNull com.kwad.components.core.liveEnd.a aVar2, int i10, String str) {
                    super.onError(aVar2, i10, str);
                }
            });
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j10) {
            super.onLivePlayProgress(j10);
            m.this.c(j10);
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayResume() {
            com.kwad.components.core.j.a.pv().a(m.this.getCurrentVoiceItem());
            super.onLivePlayResume();
            IAdLivePlayModule iAdLivePlayModule = m.this.go;
            m mVar = m.this;
            iAdLivePlayModule.setAudioEnabled(mVar.h(mVar.mIsAudioEnable), false);
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayStart() {
            com.kwad.components.core.j.a.pv().a(m.this.getCurrentVoiceItem());
            super.onLivePlayStart();
            IAdLivePlayModule iAdLivePlayModule = m.this.go;
            m mVar = m.this;
            iAdLivePlayModule.setAudioEnabled(mVar.h(mVar.mIsAudioEnable), false);
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePrepared() {
            super.onLivePrepared();
            m.this.go.setAudioEnabled(false, false);
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.m$17 */
    public class AnonymousClass17 implements d.InterfaceC0369d {

        /* renamed from: com.kwad.components.ad.feed.b.m$17$1 */
        public class AnonymousClass1 implements a.b {
            final /* synthetic */ double hu;

            public AnonymousClass1(double d10) {
                d10 = d10;
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.d.c.d("FeedWebView", "convertEnable End" + com.kwad.sdk.core.response.b.e.el(m.this.mAdTemplate));
                com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                bVar.l(d10);
                bVar.cL(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META);
                m.this.c(bVar);
            }
        }

        public AnonymousClass17() {
        }

        @Override // com.kwad.components.ad.feed.d.InterfaceC0369d
        public final boolean b(double d10) {
            if (!bw.o(m.this.gO, (int) (com.kwad.sdk.core.config.d.DL() * 100.0f)) || !m.this.uq()) {
                return false;
            }
            com.kwad.components.core.e.d.a.a(new a.C0427a(m.this.getContext()).au(m.this.mAdTemplate).b(m.this.mApkDownloadHelper).ao(2).ap(false).ar(false).an(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META).am(5).at(true).a(new a.b() { // from class: com.kwad.components.ad.feed.b.m.17.1
                final /* synthetic */ double hu;

                public AnonymousClass1(double d102) {
                    d10 = d102;
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    com.kwad.sdk.core.d.c.d("FeedWebView", "convertEnable End" + com.kwad.sdk.core.response.b.e.el(m.this.mAdTemplate));
                    com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                    bVar.l(d10);
                    bVar.cL(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META);
                    m.this.c(bVar);
                }
            }));
            return true;
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.m$18 */
    public class AnonymousClass18 implements ap.a {
        public AnonymousClass18() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ap.a
        public final void a(com.kwad.components.core.webview.a.b bVar) {
            AdWebViewActivityProxy.launch(m.this.mContext, new AdWebViewActivityProxy.a.C0438a().au(bVar.title).av(bVar.url).aD(true).aw(m.this.mAdTemplate).qa());
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.m$2 */
    public class AnonymousClass2 implements a.c {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.j.a.c
        public final void bM() {
            if (!m.this.gp) {
                if (m.this.co != null) {
                    com.kwad.sdk.core.video.videoview.a aVar = m.this.co;
                    m mVar = m.this;
                    aVar.setVideoSoundEnable(mVar.h(mVar.mIsAudioEnable));
                    return;
                }
                return;
            }
            if (m.this.go == null) {
                m mVar2 = m.this;
                mVar2.go = mVar2.bK();
            }
            IAdLivePlayModule iAdLivePlayModule = m.this.go;
            m mVar3 = m.this;
            iAdLivePlayModule.setAudioEnabled(mVar3.h(mVar3.mIsAudioEnable), false);
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.m$3 */
    public class AnonymousClass3 extends com.kwad.sdk.utils.bd {
        final /* synthetic */ View gv;

        public AnonymousClass3(View view) {
            view = view;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            m.this.d(view);
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.m$4 */
    public class AnonymousClass4 implements AdLiveMessageListener {
        public AnonymousClass4() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener
        public final void handleAdLiveMessage(List<AdLiveMessageInfo> list) {
            if (m.this.gU != null) {
                m.this.gU.n(list);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.m$5 */
    public class AnonymousClass5 implements AdLiveShopListener {
        public AnonymousClass5() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener
        public final void handleAdLiveShop(AdLiveShopInfo adLiveShopInfo) {
            if (m.this.gV != null) {
                m.this.gV.a(adLiveShopInfo);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.m$6 */
    public class AnonymousClass6 extends SimpleImageLoadingListener {
        public AnonymousClass6() {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
            return true;
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.m$7 */
    public class AnonymousClass7 implements a.b {
        private boolean dP = false;

        /* renamed from: com.kwad.components.ad.feed.b.m$7$1 */
        public class AnonymousClass1 implements com.kwad.sdk.widget.c {
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.widget.c
            public final void a(View view) {
                if (com.kwad.sdk.core.response.b.b.cS(m.this.mAdTemplate)) {
                    return;
                }
                m.this.v(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT);
            }

            @Override // com.kwad.sdk.widget.c
            public final void b(View view) {
                if (com.kwad.sdk.core.response.b.b.cS(m.this.mAdTemplate) || !com.kwad.sdk.core.response.b.d.dQ(m.this.mAdTemplate)) {
                    return;
                }
                m.this.v(153);
            }
        }

        /* renamed from: com.kwad.components.ad.feed.b.m$7$2 */
        public class AnonymousClass2 extends AnimatorListenerAdapter {
            public AnonymousClass2() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                m.this.f11495hh.aQ(1);
                m.this.f11484gg.removeView(m.this.f11494hg);
            }
        }

        public AnonymousClass7() {
        }

        @Override // com.kwad.components.core.video.a.c
        public final void ap() {
            if (!this.dP) {
                this.dP = true;
                com.kwad.components.core.o.a.ri().b(m.this.mAdTemplate, System.currentTimeMillis(), 1);
            }
            com.kwad.sdk.core.video.videoview.a aVar = m.this.co;
            m mVar = m.this;
            aVar.setVideoSoundEnable(mVar.h(mVar.mIsAudioEnable));
        }

        @Override // com.kwad.components.core.video.a.c
        public final void aq() {
            com.kwad.sdk.core.adlog.c.bT(m.this.mAdTemplate);
            m.this.gS.aR(9);
            m.this.f11484gg.setVisibility(8);
            if (com.kwad.components.ad.feed.a.b.by() && m.this.f11487gj == null && !m.this.f11496hi) {
                m.this.f11487gj = new d(m.this.mContext);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                m mVar = m.this;
                mVar.addView(mVar.f11487gj, layoutParams);
                m.this.f11487gj.bN();
            }
        }

        @Override // com.kwad.components.core.video.a.c
        public final void d(long j10) {
            m.this.c(j10);
        }

        @Override // com.kwad.components.core.video.a.b
        public final void onVideoPlayError(int i10, int i11) {
            com.kwad.components.ad.feed.monitor.b.a(m.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.b.a.K(m.this.mAdInfo), i10 + " " + i11, SystemClock.elapsedRealtime() - m.this.fQ);
        }

        @Override // com.kwad.components.core.video.a.c
        public final void onVideoPlayStart() {
            com.kwad.components.core.j.a.pv().a(m.this.getCurrentVoiceItem());
            com.kwad.components.ad.feed.monitor.b.a(m.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.b.a.K(m.this.mAdInfo), null, SystemClock.elapsedRealtime() - m.this.fQ);
            com.kwad.sdk.core.adlog.c.bS(m.this.mAdTemplate);
            m.this.gS.aR(3);
            if (m.this.f11487gj != null && (m.this.f11487gj.getParent() instanceof ViewGroup)) {
                ((ViewGroup) m.this.f11487gj.getParent()).removeView(m.this.f11487gj);
                m.this.f11487gj.bO();
                m.this.f11487gj = null;
            }
            if (m.this.f11494hg == null && com.kwad.sdk.core.response.b.b.cR(m.this.mAdTemplate) && m.this.f11496hi) {
                m.this.f11494hg = new e(m.this.mContext);
                m.this.f11484gg.addView(m.this.f11494hg, new FrameLayout.LayoutParams(-1, -1));
                m.this.f11494hg.setOnViewEventListener(new com.kwad.sdk.widget.c() { // from class: com.kwad.components.ad.feed.b.m.7.1
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.widget.c
                    public final void a(View view) {
                        if (com.kwad.sdk.core.response.b.b.cS(m.this.mAdTemplate)) {
                            return;
                        }
                        m.this.v(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT);
                    }

                    @Override // com.kwad.sdk.widget.c
                    public final void b(View view) {
                        if (com.kwad.sdk.core.response.b.b.cS(m.this.mAdTemplate) || !com.kwad.sdk.core.response.b.d.dQ(m.this.mAdTemplate)) {
                            return;
                        }
                        m.this.v(153);
                    }
                });
                m.this.f11494hg.a(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.b.m.7.2
                    public AnonymousClass2() {
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        m.this.f11495hh.aQ(1);
                        m.this.f11484gg.removeView(m.this.f11494hg);
                    }
                });
            }
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.m$8 */
    public class AnonymousClass8 implements a.b {
        final /* synthetic */ int cO;

        public AnonymousClass8(int i10) {
            i10 = i10;
        }

        @Override // com.kwad.components.core.e.d.a.b
        public final void onAdClicked() {
            m.this.aM(i10);
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.m$9 */
    public class AnonymousClass9 implements a.b {
        final /* synthetic */ int cO;

        public AnonymousClass9(int i10) {
            i10 = i10;
        }

        @Override // com.kwad.components.core.e.d.a.b
        public final void onAdClicked() {
            m.this.aM(i10);
        }
    }

    public interface a {
        void d(int i10, String str);
    }

    public m(@NonNull Context context) {
        super(context);
        this.f11483ec = -1;
        this.mIsAudioEnable = false;
        this.isNative = false;
        this.f11493hf = new Handler(Looper.getMainLooper());
        this.f11496hi = false;
        this.f11497hj = false;
        this.cy = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.feed.b.m.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                m.a(m.this, false);
                if (m.this.co != null) {
                    m.this.co.setVideoSoundEnable(false);
                }
                if (m.this.go != null) {
                    m.this.go.setAudioEnabled(false, false);
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }
        };
        this.hl = new AnonymousClass11();
        this.hm = new b.a() { // from class: com.kwad.components.ad.feed.b.m.13
            public AnonymousClass13() {
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onAdClicked() {
                if (m.this.aer != null) {
                    m.this.aer.onAdClicked();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onAdShow() {
                if (m.this.aer != null && m.this.isNative) {
                    m.this.aer.onAdShow();
                }
                if (m.this.isNative) {
                    com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                    a.C0484a c0484a = new a.C0484a();
                    FeedType fromInt = FeedType.fromInt(m.this.mAdTemplate.type);
                    if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                        fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                    }
                    c0484a.templateId = String.valueOf(fromInt.getType());
                    bVar.b(c0484a);
                    bVar.v((int) Math.ceil(m.this.gP), m.this.mWidth);
                    com.kwad.components.core.s.b.sc().a(m.this.mAdTemplate, null, bVar);
                    com.kwad.components.ad.feed.monitor.b.a(m.this.mAdTemplate, 1, 2);
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDislikeClicked() {
                if (m.this.aer != null) {
                    m.this.aer.onDislikeClicked();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogDismiss() {
                if (m.this.aer != null) {
                    m.this.aer.onDownloadTipsDialogDismiss();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogShow() {
                if (m.this.aer != null) {
                    m.this.aer.onDownloadTipsDialogShow();
                }
            }
        };
        this.mNetworking = new com.kwad.sdk.core.network.l<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.feed.b.m.15
            public AnonymousClass15() {
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: cb */
            public com.kwad.components.core.liveEnd.a createRequest() {
                return new com.kwad.components.core.liveEnd.a(m.this.hn);
            }

            @NonNull
            private static AdLiveEndCommonResultData r(String str) {
                AdLiveEndCommonResultData adLiveEndCommonResultData = new AdLiveEndCommonResultData();
                adLiveEndCommonResultData.parseJson(new JSONObject(str));
                return adLiveEndCommonResultData;
            }

            @Override // com.kwad.sdk.core.network.l
            public final boolean isPostByJson() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ AdLiveEndCommonResultData parseData(String str) {
                return r(str);
            }
        };
        this.gs = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.feed.b.m.16

            /* renamed from: com.kwad.components.ad.feed.b.m$16$1 */
            public class AnonymousClass1 extends o<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData> {
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                /* renamed from: a */
                public void onStartRequest(@NonNull com.kwad.components.core.liveEnd.a aVar2) {
                    super.onStartRequest(aVar2);
                }

                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                /* renamed from: a */
                public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar2, @NonNull AdLiveEndCommonResultData adLiveEndCommonResultData) {
                    super.onSuccess(aVar2, adLiveEndCommonResultData);
                    az.a aVar22 = new az.a();
                    aVar22.status = 9;
                    aVar22.totalWatchingDuration = adLiveEndCommonResultData.totalWatchingDuration;
                    aVar22.watchingUserCount = adLiveEndCommonResultData.watchingUserCount;
                    aVar22.displayWatchingUserCount = adLiveEndCommonResultData.displayWatchingUserCount;
                    aVar22.likeUserCount = adLiveEndCommonResultData.likeUserCount;
                    aVar22.displayLikeUserCount = adLiveEndCommonResultData.displayLikeUserCount;
                    aVar22.liveDuration = adLiveEndCommonResultData.liveDuration;
                    if (m.this.gZ != null) {
                        m.this.gZ.a(aVar22);
                    } else {
                        m.this.f11488ha = aVar22;
                    }
                }

                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                /* renamed from: a */
                public void onError(@NonNull com.kwad.components.core.liveEnd.a aVar2, int i10, String str) {
                    super.onError(aVar2, i10, str);
                }
            }

            public AnonymousClass16() {
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                super.onLivePlayEnd();
                String bg2 = com.kwad.sdk.core.response.b.a.bg(m.this.mAdInfo);
                if (TextUtils.isEmpty(bg2)) {
                    return;
                }
                com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.d.f(com.kwad.components.core.n.a.a.a.class);
                if (aVar != null) {
                    m.this.hn = aVar.getAdLiveEndRequest(bg2);
                }
                m.this.mNetworking.request(new o<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.feed.b.m.16.1
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                    /* renamed from: a */
                    public void onStartRequest(@NonNull com.kwad.components.core.liveEnd.a aVar2) {
                        super.onStartRequest(aVar2);
                    }

                    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                    /* renamed from: a */
                    public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar2, @NonNull AdLiveEndCommonResultData adLiveEndCommonResultData) {
                        super.onSuccess(aVar2, adLiveEndCommonResultData);
                        az.a aVar22 = new az.a();
                        aVar22.status = 9;
                        aVar22.totalWatchingDuration = adLiveEndCommonResultData.totalWatchingDuration;
                        aVar22.watchingUserCount = adLiveEndCommonResultData.watchingUserCount;
                        aVar22.displayWatchingUserCount = adLiveEndCommonResultData.displayWatchingUserCount;
                        aVar22.likeUserCount = adLiveEndCommonResultData.likeUserCount;
                        aVar22.displayLikeUserCount = adLiveEndCommonResultData.displayLikeUserCount;
                        aVar22.liveDuration = adLiveEndCommonResultData.liveDuration;
                        if (m.this.gZ != null) {
                            m.this.gZ.a(aVar22);
                        } else {
                            m.this.f11488ha = aVar22;
                        }
                    }

                    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                    /* renamed from: a */
                    public void onError(@NonNull com.kwad.components.core.liveEnd.a aVar2, int i10, String str) {
                        super.onError(aVar2, i10, str);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(long j10) {
                super.onLivePlayProgress(j10);
                m.this.c(j10);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                com.kwad.components.core.j.a.pv().a(m.this.getCurrentVoiceItem());
                super.onLivePlayResume();
                IAdLivePlayModule iAdLivePlayModule = m.this.go;
                m mVar = m.this;
                iAdLivePlayModule.setAudioEnabled(mVar.h(mVar.mIsAudioEnable), false);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                com.kwad.components.core.j.a.pv().a(m.this.getCurrentVoiceItem());
                super.onLivePlayStart();
                IAdLivePlayModule iAdLivePlayModule = m.this.go;
                m mVar = m.this;
                iAdLivePlayModule.setAudioEnabled(mVar.h(mVar.mIsAudioEnable), false);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePrepared() {
                super.onLivePrepared();
                m.this.go.setAudioEnabled(false, false);
            }
        };
        this.gl = new a.InterfaceC0446a() { // from class: com.kwad.components.ad.feed.b.m.10

            /* renamed from: com.kwad.components.ad.feed.b.m$10$1 */
            public class AnonymousClass1 implements a.b {
                public AnonymousClass1() {
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    m.this.ur();
                }
            }

            public AnonymousClass10() {
            }

            @Override // com.kwad.components.core.video.a.InterfaceC0446a
            public final void a(int i10, ag.a aVar) {
                int i11;
                int i12 = 2;
                boolean z10 = false;
                if (i10 == 1) {
                    i11 = 13;
                } else if (i10 == 2) {
                    i11 = 82;
                } else if (i10 != 3) {
                    i11 = 108;
                } else {
                    i11 = 83;
                    i12 = 1;
                    z10 = true;
                }
                m.this.bV();
                com.kwad.components.core.e.d.a.a(new a.C0427a(m.this.getContext()).au(m.this.mAdTemplate).b(m.this.mApkDownloadHelper).ao(i12).ap(z10).ar(true).an(i11).d(aVar).at(true).a(new a.b() { // from class: com.kwad.components.ad.feed.b.m.10.1
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        m.this.ur();
                    }
                }));
            }
        };
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void aX() {
        com.kwad.components.core.webview.b bVar = this.f11498hk;
        if (bVar != null) {
            bVar.jK();
        }
        this.mAdWebView.setVisibility(4);
        this.mAdWebView.setBackgroundColor(0);
        this.f11498hk = new com.kwad.components.core.webview.b();
        this.f11498hk.a(new b.a().aG(this.mAdTemplate).aI(com.kwad.sdk.core.response.b.b.cO(this.mAdTemplate)).d(this.mAdWebView).k(this.gO).f(this.mApkDownloadHelper).a(this.hl));
        this.mAdWebView.loadUrl(com.kwad.sdk.core.response.b.b.cO(this.mAdTemplate));
        R r10 = this.mAdTemplate;
        com.kwad.components.ad.feed.monitor.b.a(r10, com.kwad.sdk.core.response.b.b.cO(r10));
        bT();
    }

    private boolean bJ() {
        IAdLiveOfflineView iAdLiveOfflineView = this.gm;
        if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || this.go == null) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) this.gm.getView().getParent();
        if (viewGroup != this.f11484gg) {
            viewGroup.removeView(this.gm.getView());
            if (this.f11484gg.getTag() != null) {
                KSRelativeLayout kSRelativeLayout = this.f11484gg;
                kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                this.f11484gg.setTag(null);
            }
            this.f11484gg.addView(this.gm.getView());
            this.f11484gg.setTag(this.gm.getView());
            this.go.setAudioEnabled(h(this.mIsAudioEnable), false);
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
        if (this.f11484gg.getTag() != null) {
            KSRelativeLayout kSRelativeLayout = this.f11484gg;
            kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
            this.f11484gg.setTag(null);
        }
        this.f11484gg.addView(view);
        this.f11484gg.setTag(view);
        bt.postOnUiThread(new com.kwad.sdk.utils.bd() { // from class: com.kwad.components.ad.feed.b.m.3
            final /* synthetic */ View gv;

            public AnonymousClass3(View view2) {
                view = view2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                m.this.d(view);
            }
        });
        bX();
        if (this.mIsAudioEnable) {
            com.kwad.components.core.s.a.av(this.mContext).a(this.cy);
        }
        return adLivePlayModule;
    }

    private void bL() {
        String url = com.kwad.sdk.core.response.b.a.bt(this.mAdInfo).getUrl();
        this.f11485gh.setVisibility(0);
        this.gq.setVisibility(0);
        if (TextUtils.isEmpty(url)) {
            this.f11485gh.setImageResource(R.drawable.ksad_ad_live_end);
        } else {
            this.f11485gh.setImageDrawable(null);
            KSImageLoader.loadImage(this.f11485gh, url, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.feed.b.m.6
                public AnonymousClass6() {
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                    return true;
                }
            });
        }
    }

    private void bT() {
        this.f11493hf.postDelayed(new com.kwad.sdk.utils.bd() { // from class: com.kwad.components.ad.feed.b.m.12
            public AnonymousClass12() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                m.this.mAdWebView.stopLoading();
                m.this.mAdWebView.setVisibility(8);
                m.this.a("0", 1, 6);
            }
        }, 2500L);
    }

    public void bU() {
        float cT = com.kwad.sdk.core.response.b.b.cT(this.mAdTemplate);
        AnonymousClass17 anonymousClass17 = new d.InterfaceC0369d() { // from class: com.kwad.components.ad.feed.b.m.17

            /* renamed from: com.kwad.components.ad.feed.b.m$17$1 */
            public class AnonymousClass1 implements a.b {
                final /* synthetic */ double hu;

                public AnonymousClass1(double d102) {
                    d10 = d102;
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    com.kwad.sdk.core.d.c.d("FeedWebView", "convertEnable End" + com.kwad.sdk.core.response.b.e.el(m.this.mAdTemplate));
                    com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                    bVar.l(d10);
                    bVar.cL(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META);
                    m.this.c(bVar);
                }
            }

            public AnonymousClass17() {
            }

            @Override // com.kwad.components.ad.feed.d.InterfaceC0369d
            public final boolean b(double d102) {
                if (!bw.o(m.this.gO, (int) (com.kwad.sdk.core.config.d.DL() * 100.0f)) || !m.this.uq()) {
                    return false;
                }
                com.kwad.components.core.e.d.a.a(new a.C0427a(m.this.getContext()).au(m.this.mAdTemplate).b(m.this.mApkDownloadHelper).ao(2).ap(false).ar(false).an(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META).am(5).at(true).a(new a.b() { // from class: com.kwad.components.ad.feed.b.m.17.1
                    final /* synthetic */ double hu;

                    public AnonymousClass1(double d1022) {
                        d10 = d1022;
                    }

                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        com.kwad.sdk.core.d.c.d("FeedWebView", "convertEnable End" + com.kwad.sdk.core.response.b.e.el(m.this.mAdTemplate));
                        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                        bVar.l(d10);
                        bVar.cL(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META);
                        m.this.c(bVar);
                    }
                }));
                return true;
            }
        };
        this.fD = anonymousClass17;
        com.kwad.components.ad.feed.d.a(cT, this.mContext, anonymousClass17);
    }

    public void bV() {
        if (this.f11490hc) {
            return;
        }
        this.f11490hc = true;
        com.kwad.components.ad.feed.monitor.b.a(this.mAdTemplate, 2, getStayTime());
    }

    private boolean bW() {
        return this.f11483ec == 1;
    }

    private void bX() {
        this.gm.registerLiveMessageListener(new AdLiveMessageListener() { // from class: com.kwad.components.ad.feed.b.m.4
            public AnonymousClass4() {
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener
            public final void handleAdLiveMessage(List<AdLiveMessageInfo> list) {
                if (m.this.gU != null) {
                    m.this.gU.n(list);
                }
            }
        });
        this.gm.registerLiveShopListener(new AdLiveShopListener() { // from class: com.kwad.components.ad.feed.b.m.5
            public AnonymousClass5() {
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener
            public final void handleAdLiveShop(AdLiveShopInfo adLiveShopInfo) {
                if (m.this.gV != null) {
                    m.this.gV.a(adLiveShopInfo);
                }
            }
        });
    }

    public a.b getCurrentVoiceItem() {
        if (this.gr == null) {
            this.gr = new a.b(new a.c() { // from class: com.kwad.components.ad.feed.b.m.2
                public AnonymousClass2() {
                }

                @Override // com.kwad.components.core.j.a.c
                public final void bM() {
                    if (!m.this.gp) {
                        if (m.this.co != null) {
                            com.kwad.sdk.core.video.videoview.a aVar = m.this.co;
                            m mVar = m.this;
                            aVar.setVideoSoundEnable(mVar.h(mVar.mIsAudioEnable));
                            return;
                        }
                        return;
                    }
                    if (m.this.go == null) {
                        m mVar2 = m.this;
                        mVar2.go = mVar2.bK();
                    }
                    IAdLivePlayModule iAdLivePlayModule = m.this.go;
                    m mVar3 = m.this;
                    iAdLivePlayModule.setAudioEnabled(mVar3.h(mVar3.mIsAudioEnable), false);
                }
            });
        }
        return this.gr;
    }

    public ap.a getOpenNewPageListener() {
        return new ap.a() { // from class: com.kwad.components.ad.feed.b.m.18
            public AnonymousClass18() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ap.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                AdWebViewActivityProxy.launch(m.this.mContext, new AdWebViewActivityProxy.a.C0438a().au(bVar.title).av(bVar.url).aD(true).aw(m.this.mAdTemplate).qa());
            }
        };
    }

    public az.c getRegisterLiveListener() {
        return new az.c() { // from class: com.kwad.components.ad.feed.b.m.14
            public AnonymousClass14() {
            }

            @Override // com.kwad.components.core.webview.jshandler.az.c
            public final void a(az.b bVar) {
                m.this.gZ = bVar;
                if (m.this.f11488ha != null) {
                    m.this.gZ.a(m.this.f11488ha);
                    m.this.f11488ha = null;
                }
            }
        };
    }

    private a.b getVideoPlayCallback() {
        return new a.b() { // from class: com.kwad.components.ad.feed.b.m.7
            private boolean dP = false;

            /* renamed from: com.kwad.components.ad.feed.b.m$7$1 */
            public class AnonymousClass1 implements com.kwad.sdk.widget.c {
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.widget.c
                public final void a(View view) {
                    if (com.kwad.sdk.core.response.b.b.cS(m.this.mAdTemplate)) {
                        return;
                    }
                    m.this.v(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT);
                }

                @Override // com.kwad.sdk.widget.c
                public final void b(View view) {
                    if (com.kwad.sdk.core.response.b.b.cS(m.this.mAdTemplate) || !com.kwad.sdk.core.response.b.d.dQ(m.this.mAdTemplate)) {
                        return;
                    }
                    m.this.v(153);
                }
            }

            /* renamed from: com.kwad.components.ad.feed.b.m$7$2 */
            public class AnonymousClass2 extends AnimatorListenerAdapter {
                public AnonymousClass2() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    m.this.f11495hh.aQ(1);
                    m.this.f11484gg.removeView(m.this.f11494hg);
                }
            }

            public AnonymousClass7() {
            }

            @Override // com.kwad.components.core.video.a.c
            public final void ap() {
                if (!this.dP) {
                    this.dP = true;
                    com.kwad.components.core.o.a.ri().b(m.this.mAdTemplate, System.currentTimeMillis(), 1);
                }
                com.kwad.sdk.core.video.videoview.a aVar = m.this.co;
                m mVar = m.this;
                aVar.setVideoSoundEnable(mVar.h(mVar.mIsAudioEnable));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void aq() {
                com.kwad.sdk.core.adlog.c.bT(m.this.mAdTemplate);
                m.this.gS.aR(9);
                m.this.f11484gg.setVisibility(8);
                if (com.kwad.components.ad.feed.a.b.by() && m.this.f11487gj == null && !m.this.f11496hi) {
                    m.this.f11487gj = new d(m.this.mContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    m mVar = m.this;
                    mVar.addView(mVar.f11487gj, layoutParams);
                    m.this.f11487gj.bN();
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j10) {
                m.this.c(j10);
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlayError(int i10, int i11) {
                com.kwad.components.ad.feed.monitor.b.a(m.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.b.a.K(m.this.mAdInfo), i10 + " " + i11, SystemClock.elapsedRealtime() - m.this.fQ);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.components.core.j.a.pv().a(m.this.getCurrentVoiceItem());
                com.kwad.components.ad.feed.monitor.b.a(m.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.b.a.K(m.this.mAdInfo), null, SystemClock.elapsedRealtime() - m.this.fQ);
                com.kwad.sdk.core.adlog.c.bS(m.this.mAdTemplate);
                m.this.gS.aR(3);
                if (m.this.f11487gj != null && (m.this.f11487gj.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) m.this.f11487gj.getParent()).removeView(m.this.f11487gj);
                    m.this.f11487gj.bO();
                    m.this.f11487gj = null;
                }
                if (m.this.f11494hg == null && com.kwad.sdk.core.response.b.b.cR(m.this.mAdTemplate) && m.this.f11496hi) {
                    m.this.f11494hg = new e(m.this.mContext);
                    m.this.f11484gg.addView(m.this.f11494hg, new FrameLayout.LayoutParams(-1, -1));
                    m.this.f11494hg.setOnViewEventListener(new com.kwad.sdk.widget.c() { // from class: com.kwad.components.ad.feed.b.m.7.1
                        public AnonymousClass1() {
                        }

                        @Override // com.kwad.sdk.widget.c
                        public final void a(View view) {
                            if (com.kwad.sdk.core.response.b.b.cS(m.this.mAdTemplate)) {
                                return;
                            }
                            m.this.v(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT);
                        }

                        @Override // com.kwad.sdk.widget.c
                        public final void b(View view) {
                            if (com.kwad.sdk.core.response.b.b.cS(m.this.mAdTemplate) || !com.kwad.sdk.core.response.b.d.dQ(m.this.mAdTemplate)) {
                                return;
                            }
                            m.this.v(153);
                        }
                    });
                    m.this.f11494hg.a(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.b.m.7.2
                        public AnonymousClass2() {
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            m.this.f11495hh.aQ(1);
                            m.this.f11484gg.removeView(m.this.f11494hg);
                        }
                    });
                }
            }
        };
    }

    @Override // com.kwad.components.core.widget.b
    public final void bE() {
        com.kwad.components.ad.feed.monitor.b.bB();
        this.gO = (RatioFrameLayout) findViewById(R.id.ksad_container);
        this.f11484gg = (KSRelativeLayout) findViewById(R.id.ksad_video_container);
        this.gQ = (LinearLayout) findViewById(R.id.ksad_video_immerse_text_container);
        this.gR = (TextView) findViewById(R.id.ksad_video_immerse_text);
        this.f11485gh = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.gq = findViewById(R.id.ksad_live_end_bg_mantle);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bH() {
        super.bH();
        if (this.f11483ec == 1 || this.gX) {
            return;
        }
        this.mAdWebView.stopLoading();
        this.mAdWebView.setVisibility(8);
        a("0", 1, 3);
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.c
    public final void bl() {
        super.bl();
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

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_webview;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (!com.kwad.sdk.core.config.d.DP() || !com.kwad.sdk.core.response.b.d.dQ(this.mAdTemplate)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (com.kwad.sdk.core.response.b.b.cn(this.mAdTemplate) == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        a(motionEvent);
        if ((action == 2 || action == 3) && this.mAdWebView != null && !this.isNative && Math.abs(motionEvent.getX() - this.fR) > 0.0f) {
            this.mAdWebView.requestDisallowInterceptTouchEvent(true);
            double abs = Math.abs(motionEvent.getX() - this.fR);
            double abs2 = Math.abs(motionEvent.getY() - this.fS);
            if (Math.tan(r1.maxRange) * abs < abs2 || Math.tan(r1.minRange) * abs < abs2) {
                this.mAdWebView.requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public final void onWindowFocusChanged(boolean z10) {
        IAdLivePlayModule iAdLivePlayModule;
        ViewGroup viewGroup;
        super.onWindowFocusChanged(z10);
        if (!z10) {
            IAdLiveOfflineView iAdLiveOfflineView = this.gm;
            if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || (iAdLivePlayModule = this.go) == null) {
                return;
            }
            iAdLivePlayModule.onPause();
            return;
        }
        if (bJ()) {
            return;
        }
        com.kwad.sdk.core.video.videoview.a aVar = this.co;
        if (aVar != null && (viewGroup = (ViewGroup) aVar.getParent()) != this.f11484gg) {
            viewGroup.removeView(this.co);
            if (this.f11484gg.getTag() != null) {
                KSRelativeLayout kSRelativeLayout = this.f11484gg;
                kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                this.f11484gg.setTag(null);
            }
            this.f11484gg.addView(this.co);
            this.f11484gg.setTag(this.co);
            this.co.setVideoSoundEnable(this.mIsAudioEnable);
            this.f11486gi.setVideoPlayCallback(getVideoPlayCallback());
            this.f11486gi.setAdClickListener(this.gl);
            this.f11486gi.getAdTemplate().mAdWebVideoPageShowing = false;
            this.f11486gi.sO();
            this.f11486gi.setAutoRelease(true);
        }
        AdVideoPlayerViewCache.getInstance().remove(com.kwad.sdk.core.response.b.a.K(this.mAdInfo));
    }

    @Override // com.kwad.components.core.widget.b
    public final void setMargin(int i10) {
    }

    public final void setPreloadListener(a aVar) {
        a aVar2 = this.f11491hd;
        if (aVar2 != null) {
            aVar2.d(this.f11483ec == 1 ? 2 : 1, "");
        }
        this.f11491hd = aVar;
    }

    public final void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        com.kwad.components.core.video.e eVar;
        IAdLivePlayModule iAdLivePlayModule;
        this.bS = ksAdVideoPlayConfig;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                boolean isVideoSoundEnable = kSAdVideoPlayConfigImpl.isVideoSoundEnable();
                this.mIsAudioEnable = isVideoSoundEnable;
                R r10 = this.mAdTemplate;
                if (r10 != 0) {
                    r10.mIsAudioEnable = isVideoSoundEnable;
                }
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
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() == 0 || (eVar = this.f11486gi) == null) {
                return;
            }
            eVar.setDataAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
        }
    }

    public final void setWidth(int i10) {
        if (i10 <= 0) {
            i10 = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        this.mWidth = i10;
    }

    public boolean h(boolean z10) {
        if (!z10) {
            return false;
        }
        if (this.gr != null) {
            com.kwad.components.core.j.a.pv();
            if (!com.kwad.components.core.j.a.b(this.gr)) {
                return false;
            }
        }
        if (!com.kwad.sdk.core.config.d.gN()) {
            return !com.kwad.components.core.s.a.av(this.mContext).sb() ? com.kwad.components.core.s.a.av(this.mContext).aO(false) : !com.kwad.components.core.s.a.av(this.mContext).sa();
        }
        if (!this.f11482cn) {
            this.f11482cn = com.kwad.components.core.s.a.av(this.mContext).aO(true);
        }
        return this.f11482cn;
    }

    private void k(AdTemplate adTemplate) {
        if (this.f11497hj) {
            return;
        }
        if (com.kwad.sdk.core.response.b.a.cS(com.kwad.sdk.core.response.b.e.eb(adTemplate))) {
            this.mAdWebView = (KsAdWebView) findViewById(R.id.ksad_web_bottom_card_webView);
        } else {
            this.mAdWebView = (KsAdWebView) findViewById(R.id.ksad_web_default_bottom_card_webView);
        }
        this.f11497hj = true;
    }

    private static float l(AdTemplate adTemplate) {
        int i10 = adTemplate.type;
        if (i10 == 1) {
            return 0.6013f;
        }
        return (i10 == 2 || i10 == 3) ? 0.283f : 0.968f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void m(AdTemplate adTemplate) {
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        this.mApkDownloadHelper = cVar;
        cVar.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        if (gW.get(Long.valueOf(this.mAdTemplate.posId)) != null) {
            this.gO.setRatio(r5.floatValue());
        } else if (com.kwad.sdk.core.response.b.b.cU(this.mAdTemplate) > l5.c.f27899e) {
            this.gO.setRatio(com.kwad.sdk.core.response.b.b.cU(this.mAdTemplate));
        } else if (this.gO.getRatio() == l5.c.f27899e) {
            this.gO.setRatio(l(this.mAdTemplate));
        }
        com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.d.f(com.kwad.components.core.n.a.a.a.class);
        this.gn = aVar;
        if (aVar != null && aVar.pz() && com.kwad.sdk.core.response.b.a.cS(this.mAdInfo)) {
            this.gp = true;
        }
    }

    public void v(int i10) {
        bV();
        com.kwad.components.core.e.d.a.a(new a.C0427a(getContext()).au(this.mAdTemplate).b(this.mApkDownloadHelper).ao(1).ap(true).an(i10).am(5).ar(false).at(true).a(new a.b() { // from class: com.kwad.components.ad.feed.b.m.8
            final /* synthetic */ int cO;

            public AnonymousClass8(int i102) {
                i10 = i102;
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                m.this.aM(i10);
            }
        }));
    }

    @Override // com.kwad.components.core.widget.b
    public final void V() {
        ay ayVar;
        b.a aVar;
        if (!this.mAdTemplate.mPvReported && (aVar = this.aer) != null && this.isNative) {
            aVar.onAdShow();
            com.kwad.components.ad.feed.monitor.b.a((AdTemplate) this.mAdTemplate, 1, 2);
        }
        if (this.isNative || (ayVar = this.gT) == null) {
            return;
        }
        ayVar.tv();
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void Z() {
        super.Z();
        if (this.fD != null) {
            com.kwad.components.ad.feed.d.a(com.kwad.sdk.core.response.b.b.cT(this.mAdTemplate), this.mContext, this.fD);
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        super.aa();
        this.f11493hf.removeCallbacksAndMessages(null);
        com.kwad.sdk.utils.m.ey(this.mAdTemplate);
        d.InterfaceC0369d interfaceC0369d = this.fD;
        if (interfaceC0369d != null) {
            com.kwad.components.ad.feed.d.a(interfaceC0369d);
        }
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
        this.gZ = null;
        this.f11488ha = null;
    }

    public static /* synthetic */ boolean d(m mVar, boolean z10) {
        mVar.f11496hi = true;
        return true;
    }

    public void d(View view) {
        int width = this.f11484gg.getWidth();
        int height = this.f11484gg.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (height * 0.5625f), height);
        layoutParams.addRule(13, -1);
        view.setLayoutParams(layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00a2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(@androidx.annotation.NonNull com.kwad.sdk.api.KsAdVideoPlayConfig r11) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.feed.b.m.b(com.kwad.sdk.api.KsAdVideoPlayConfig):void");
    }

    @Override // com.kwad.components.core.widget.b
    public final void c(@NonNull AdResultData adResultData) {
        AdTemplate o10 = com.kwad.sdk.core.response.b.c.o(adResultData);
        k(o10);
        o10.realShowType = 2;
        super.c((m) adResultData);
        if (this.gX) {
            com.kwad.components.core.widget.b bVar = this.f11489hb;
            if (bVar != null) {
                bVar.c((com.kwad.components.core.widget.b) adResultData);
                com.kwad.components.core.widget.b bVar2 = this.f11489hb;
                if (bVar2 instanceof c) {
                    ((c) bVar2).b(this.bS);
                    return;
                }
                return;
            }
            return;
        }
        if (!com.kwad.sdk.core.response.b.b.cV(this.mAdTemplate)) {
            a("0", 0, 1);
            return;
        }
        if (!bW()) {
            m(this.mAdTemplate);
        }
        try {
            String str = this.gY;
            if (str == null || !str.equals(o10.mOriginJString)) {
                if (bW()) {
                    this.mAdWebView.reload();
                } else {
                    this.f11483ec = -2;
                    aX();
                }
            }
        } catch (Throwable unused) {
            a("0", 0, 2);
        }
        this.gY = o10.mOriginJString;
    }

    /* renamed from: com.kwad.components.ad.feed.b.m$11 */
    public class AnonymousClass11 extends com.kwad.components.core.webview.c {

        /* renamed from: com.kwad.components.ad.feed.b.m$11$1 */
        public class AnonymousClass1 implements WebCardVideoPositionHandler.a {
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler.a
            public final void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                if (m.this.mAdInfo != null) {
                    if (com.kwad.sdk.core.response.b.a.bc(m.this.mAdInfo) || m.this.gp) {
                        m mVar = m.this;
                        mVar.f11492he = (ViewGroup.MarginLayoutParams) mVar.f11484gg.getLayoutParams();
                        int ceil = (int) Math.ceil(m.this.gP);
                        int i10 = m.this.mWidth;
                        if (videoPosition.widthRation == l5.c.f27899e) {
                            videoPosition.widthRation = 0.9200000166893005d;
                            videoPosition.leftMarginRation = 0.03999999910593033d;
                        }
                        m.this.f11492he.topMargin = (int) (videoPosition.topMarginRation * ceil);
                        double d10 = i10;
                        m.this.f11492he.leftMargin = (int) (videoPosition.leftMarginRation * d10);
                        m.this.f11492he.width = (int) (d10 * videoPosition.widthRation);
                        m.this.f11492he.height = (int) (m.this.f11492he.width * videoPosition.heightWidthRation);
                        m.this.f11484gg.setRadius(videoPosition.borderRadius);
                        m.this.f11484gg.setLayoutParams(m.this.f11492he);
                        m.this.f11484gg.setVisibility(0);
                        if (!(m.this.bS instanceof KSAdVideoPlayConfigImpl) || ((KSAdVideoPlayConfigImpl) m.this.bS).getVideoSoundValue() == 0) {
                            m mVar2 = m.this;
                            mVar2.mIsAudioEnable = com.kwad.sdk.core.response.b.a.bZ(mVar2.mAdInfo);
                        } else {
                            m mVar3 = m.this;
                            mVar3.mIsAudioEnable = mVar3.bS.isVideoSoundEnable();
                        }
                        m.this.mAdTemplate.mIsAudioEnable = m.this.mIsAudioEnable;
                        m mVar4 = m.this;
                        mVar4.f11481ci = com.kwad.sdk.core.response.b.a.bo(mVar4.mAdInfo);
                        if (!m.this.gp) {
                            m mVar5 = m.this;
                            mVar5.b(mVar5.bS);
                        } else if (m.this.go != null) {
                            IAdLivePlayModule iAdLivePlayModule = m.this.go;
                            m mVar6 = m.this;
                            iAdLivePlayModule.setAudioEnabled(mVar6.h(mVar6.mIsAudioEnable), false);
                        }
                    }
                }
            }
        }

        /* renamed from: com.kwad.components.ad.feed.b.m$11$2 */
        public class AnonymousClass2 implements ac.a {

            /* renamed from: com.kwad.components.ad.feed.b.m$11$2$1 */
            public class AnonymousClass1 extends com.kwad.sdk.utils.bd {
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    m.this.us();
                }
            }

            public AnonymousClass2() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ac.a
            public final void bZ() {
                m.this.f11493hf.post(new com.kwad.sdk.utils.bd() { // from class: com.kwad.components.ad.feed.b.m.11.2.1
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        m.this.us();
                    }
                });
            }
        }

        /* renamed from: com.kwad.components.ad.feed.b.m$11$3 */
        public class AnonymousClass3 implements ba.a {
            public AnonymousClass3() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ba.a
            public final void ca() {
                m.d(m.this, true);
                m.this.bU();
            }
        }

        /* renamed from: com.kwad.components.ad.feed.b.m$11$4 */
        public class AnonymousClass4 extends com.kwad.sdk.utils.bd {
            public AnonymousClass4() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                if (m.this.aer == null || m.this.isNative) {
                    return;
                }
                m.this.aer.onAdShow();
                com.kwad.components.ad.feed.monitor.b.a(m.this.mAdTemplate, 2, 2);
            }
        }

        /* renamed from: com.kwad.components.ad.feed.b.m$11$5 */
        public class AnonymousClass5 implements a.b {
            public AnonymousClass5() {
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (m.this.aer != null) {
                    m.this.aer.onAdClicked();
                }
            }
        }

        public AnonymousClass11() {
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
            bVar.aIe = false;
            aVar.a(new com.kwad.components.core.webview.jshandler.g(m.this.mAdTemplate.loadType));
            m.this.gS = new bd();
            aVar.a(m.this.gS);
            aVar.a(new ap(m.this.getOpenNewPageListener()));
            aVar.a(new WebCardVideoPositionHandler(new WebCardVideoPositionHandler.a() { // from class: com.kwad.components.ad.feed.b.m.11.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler.a
                public final void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                    if (m.this.mAdInfo != null) {
                        if (com.kwad.sdk.core.response.b.a.bc(m.this.mAdInfo) || m.this.gp) {
                            m mVar = m.this;
                            mVar.f11492he = (ViewGroup.MarginLayoutParams) mVar.f11484gg.getLayoutParams();
                            int ceil = (int) Math.ceil(m.this.gP);
                            int i10 = m.this.mWidth;
                            if (videoPosition.widthRation == l5.c.f27899e) {
                                videoPosition.widthRation = 0.9200000166893005d;
                                videoPosition.leftMarginRation = 0.03999999910593033d;
                            }
                            m.this.f11492he.topMargin = (int) (videoPosition.topMarginRation * ceil);
                            double d10 = i10;
                            m.this.f11492he.leftMargin = (int) (videoPosition.leftMarginRation * d10);
                            m.this.f11492he.width = (int) (d10 * videoPosition.widthRation);
                            m.this.f11492he.height = (int) (m.this.f11492he.width * videoPosition.heightWidthRation);
                            m.this.f11484gg.setRadius(videoPosition.borderRadius);
                            m.this.f11484gg.setLayoutParams(m.this.f11492he);
                            m.this.f11484gg.setVisibility(0);
                            if (!(m.this.bS instanceof KSAdVideoPlayConfigImpl) || ((KSAdVideoPlayConfigImpl) m.this.bS).getVideoSoundValue() == 0) {
                                m mVar2 = m.this;
                                mVar2.mIsAudioEnable = com.kwad.sdk.core.response.b.a.bZ(mVar2.mAdInfo);
                            } else {
                                m mVar3 = m.this;
                                mVar3.mIsAudioEnable = mVar3.bS.isVideoSoundEnable();
                            }
                            m.this.mAdTemplate.mIsAudioEnable = m.this.mIsAudioEnable;
                            m mVar4 = m.this;
                            mVar4.f11481ci = com.kwad.sdk.core.response.b.a.bo(mVar4.mAdInfo);
                            if (!m.this.gp) {
                                m mVar5 = m.this;
                                mVar5.b(mVar5.bS);
                            } else if (m.this.go != null) {
                                IAdLivePlayModule iAdLivePlayModule = m.this.go;
                                m mVar6 = m.this;
                                iAdLivePlayModule.setAudioEnabled(mVar6.h(mVar6.mIsAudioEnable), false);
                            }
                        }
                    }
                }
            }));
            aVar.a(new ac(bVar, new ac.a() { // from class: com.kwad.components.ad.feed.b.m.11.2

                /* renamed from: com.kwad.components.ad.feed.b.m$11$2$1 */
                public class AnonymousClass1 extends com.kwad.sdk.utils.bd {
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        m.this.us();
                    }
                }

                public AnonymousClass2() {
                }

                @Override // com.kwad.components.core.webview.jshandler.ac.a
                public final void bZ() {
                    m.this.f11493hf.post(new com.kwad.sdk.utils.bd() { // from class: com.kwad.components.ad.feed.b.m.11.2.1
                        public AnonymousClass1() {
                        }

                        @Override // com.kwad.sdk.utils.bd
                        public final void doTask() {
                            m.this.us();
                        }
                    });
                }
            }));
            aVar.a(new ba(new ba.a() { // from class: com.kwad.components.ad.feed.b.m.11.3
                public AnonymousClass3() {
                }

                @Override // com.kwad.components.core.webview.jshandler.ba.a
                public final void ca() {
                    m.d(m.this, true);
                    m.this.bU();
                }
            }));
            m.this.f11495hh = new as();
            aVar.a(m.this.f11495hh);
            if (m.this.gp) {
                aVar.a(new com.kwad.components.core.webview.jshandler.f(1, 1));
                m.this.gV = new WebCardRegisterLiveShopListener();
                m.this.gU = new WebCardRegisterLiveMessageListener();
                aVar.a(m.this.gV);
                aVar.a(m.this.gU);
                aVar.a(new az(m.this.getRegisterLiveListener()));
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void b(ad.a aVar) {
            aVar.height = 0;
            aVar.width = m.this.mWidth;
        }

        @Override // com.kwad.components.core.webview.c
        public final void h(int i10, String str) {
            m.this.a("1", 2, 5);
        }

        @Override // com.kwad.components.core.webview.c
        public final void onAdShow() {
            super.onAdShow();
            bt.runOnUiThread(new com.kwad.sdk.utils.bd() { // from class: com.kwad.components.ad.feed.b.m.11.4
                public AnonymousClass4() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    if (m.this.aer == null || m.this.isNative) {
                        return;
                    }
                    m.this.aer.onAdShow();
                    com.kwad.components.ad.feed.monitor.b.a(m.this.mAdTemplate, 2, 2);
                }
            });
        }

        @Override // com.kwad.components.core.webview.c
        public final void onPageFinished() {
            com.kwad.components.ad.feed.monitor.b.a(m.this.mAdTemplate, com.kwad.sdk.core.response.b.b.cO(m.this.mAdTemplate), System.currentTimeMillis() - m.this.mAdWebView.getLoadTime());
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(ay ayVar) {
            m.this.gT = ayVar;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(ak.a aVar) {
            if (m.this.isNative) {
                return;
            }
            m.this.mAdWebView.setVisibility(0);
            if (m.this.gP == l5.c.f27899e) {
                m.this.gP = aVar.height;
                m.this.gO.setRatio((float) r0);
                m.gW.put(Long.valueOf(m.this.mAdTemplate.posId), Double.valueOf(aVar.height / m.this.mWidth));
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            String str;
            m.this.bV();
            int i10 = aVar.aap;
            if (aVar.Ms) {
                i10 = aVar.aan ? 1 : 2;
            }
            boolean bc2 = com.kwad.sdk.core.response.b.a.bc(m.this.mAdInfo);
            com.kwad.sdk.core.webview.d.b.d dVar = aVar.aaq;
            if (dVar != null && !TextUtils.isEmpty(dVar.MI)) {
                str = aVar.aaq.MI;
            } else {
                str = "";
            }
            com.kwad.components.core.e.d.a.a(new a.C0427a(m.this.getContext()).au(m.this.mAdTemplate).b(m.this.mApkDownloadHelper).ap(m.a(m.this, aVar)).ao(i10).an(aVar.lz).ai(str).am(5).av(aVar.Ms).at(bc2).v(m.this.go == null ? 0L : m.this.go.getPlayDuration()).ar(true).a(new a.b() { // from class: com.kwad.components.ad.feed.b.m.11.5
                public AnonymousClass5() {
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    if (m.this.aer != null) {
                        m.this.aer.onAdClicked();
                    }
                }
            }));
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(ar.a aVar) {
            if (m.this.gX) {
                return;
            }
            m.this.f11483ec = aVar.status;
            if (m.this.f11483ec == 1) {
                m.this.f11493hf.removeCallbacksAndMessages(null);
                if (m.this.f11489hb != null) {
                    m.this.f11489hb.setVisibility(8);
                }
                m.this.mAdWebView.setVisibility(0);
                com.kwad.components.core.o.a.ri().aB(m.this.mAdTemplate);
                if (m.this.f11491hd != null) {
                    m.this.f11491hd.d(2, "");
                    return;
                }
                return;
            }
            m.this.a("3", 3, 4);
        }
    }

    public static /* synthetic */ boolean a(m mVar, com.kwad.sdk.core.webview.d.b.a aVar) {
        return b(aVar);
    }

    public static /* synthetic */ boolean a(m mVar, boolean z10) {
        mVar.f11482cn = false;
        return false;
    }

    private void a(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return;
        }
        this.fR = motionEvent.getX();
        this.fS = motionEvent.getY();
    }

    public void c(long j10) {
        int ceil = (int) Math.ceil(j10 / 1000.0f);
        List<Integer> list = this.f11481ci;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.f11481ci.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a((AdTemplate) this.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    public void a(String str, int i10, int i11) {
        int i12;
        com.kwad.sdk.core.d.c.d("FeedWebView", "handleWebViewError " + str);
        this.f11493hf.removeCallbacksAndMessages(null);
        if (this.gX) {
            return;
        }
        this.gX = true;
        if (this.mAdWebView != null) {
            R r10 = this.mAdTemplate;
            com.kwad.components.ad.feed.monitor.b.a(r10, com.kwad.sdk.core.response.b.b.cO(r10), System.currentTimeMillis() - this.mAdWebView.getLoadTime(), i10);
        }
        com.kwad.components.core.o.a ri2 = com.kwad.components.core.o.a.ri();
        AdTemplate adTemplate = this.mAdTemplate;
        ri2.b(adTemplate, com.kwad.sdk.core.response.b.b.cO(adTemplate), str);
        try {
            i12 = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            com.kwad.sdk.core.d.c.d("FeedWebView", "handleWebViewError errorCode exception" + str);
            i12 = 0;
        }
        com.kwad.components.ad.feed.monitor.b.a(i12, com.kwad.sdk.core.response.b.a.be(this.mAdInfo), this.mAdTemplate, i11);
        a aVar = this.f11491hd;
        if (aVar != null) {
            aVar.d(1, str);
        }
        this.f11491hd = null;
        if (this.f11489hb == null) {
            this.isNative = true;
            com.kwad.components.core.widget.b.c(this);
            int be2 = com.kwad.sdk.core.response.b.a.be(this.mAdInfo);
            IAdLivePlayModule iAdLivePlayModule = this.go;
            if (iAdLivePlayModule != null) {
                iAdLivePlayModule.setAudioEnabled(false, false);
                this.go.onDestroy();
                this.go = null;
            }
            IAdLiveOfflineView iAdLiveOfflineView = this.gm;
            if (iAdLiveOfflineView != null) {
                iAdLiveOfflineView.onDestroy();
                this.gm = null;
            }
            com.kwad.components.core.widget.b a10 = com.kwad.components.ad.feed.b.a(this.mContext, FeedType.fromInt(this.mAdTemplate.type), be2);
            this.f11489hb = a10;
            if (a10 != null) {
                this.f11489hb.setMargin(com.kwad.sdk.c.a.a.a(this.mContext, 16.0f));
                this.gO.removeAllViews();
                this.gO.setRatio(l5.c.f27899e);
                KsAdWebView ksAdWebView = this.mAdWebView;
                if (ksAdWebView != null) {
                    ksAdWebView.setVisibility(8);
                }
                this.f11484gg.setVisibility(8);
                this.f11489hb.setInnerAdInteractionListener(this.hm);
                this.gO.addView(this.f11489hb);
                this.f11489hb.c((com.kwad.components.core.widget.b) this.mAdResultData);
                com.kwad.components.core.widget.b bVar = this.f11489hb;
                if (bVar instanceof c) {
                    ((c) bVar).b(this.bS);
                }
            }
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.dQ(this.mAdTemplate)) {
            if (view == this.f11484gg || view == this.gR) {
                a(this.co, 153);
            }
        }
    }

    private static boolean b(com.kwad.sdk.core.webview.d.b.a aVar) {
        if (aVar.Ms) {
            return aVar.aan;
        }
        return aVar.aap == 1;
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        if (view == this.f11484gg) {
            if (this.co.isIdle()) {
                com.kwad.sdk.utils.m.ez(this.mAdTemplate);
                this.co.setKsPlayLogParam(com.kwad.sdk.contentalliance.a.a.a.bL(this.mAdTemplate));
                this.co.start();
                return;
            }
            a(this.co, 100);
            return;
        }
        if (view == this.gR) {
            a(this.co, 25);
        }
    }

    private void a(com.kwad.sdk.core.video.videoview.a aVar, int i10) {
        if (aVar != null) {
            String K = com.kwad.sdk.core.response.b.a.K(this.mAdInfo);
            this.f11486gi.setAutoRelease(false);
            AdVideoPlayerViewCache.getInstance().a(K, this.co);
            FeedType.fromInt(this.mAdTemplate.type);
            bV();
            com.kwad.components.core.e.d.a.a(new a.C0427a(getContext()).au(this.mAdTemplate).b(this.mApkDownloadHelper).ao(2).at(com.kwad.sdk.core.response.b.a.bc(this.mAdInfo)).a(new a.b() { // from class: com.kwad.components.ad.feed.b.m.9
                final /* synthetic */ int cO;

                public AnonymousClass9(int i102) {
                    i10 = i102;
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    m.this.aM(i10);
                }
            }));
        }
    }
}
