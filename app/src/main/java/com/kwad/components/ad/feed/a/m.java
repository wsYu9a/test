package com.kwad.components.ad.feed.a;

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
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.h.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.liveEnd.AdLiveEndCommonResultData;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.video.a;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveMessageListener;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveShopListener;
import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.ao;
import com.kwad.components.core.webview.jshandler.ap;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.t;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.v;
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
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.bl;
import com.kwad.sdk.widget.KSRelativeLayout;
import com.kwad.sdk.widget.RatioFrameLayout;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class m extends com.kwad.components.core.widget.b<AdTemplate> implements View.OnClickListener, com.kwad.sdk.widget.c {
    private static final HashMap<Long, Double> fF = new HashMap<>(8);
    private List<Integer> cI;
    private com.kwad.components.core.webview.a cU;
    private com.kwad.sdk.core.webview.b cV;
    private int cW;
    private ai.b cZ;
    private KsAdVideoPlayConfig dZ;
    private KSRelativeLayout eL;
    private ImageView eM;
    private com.kwad.sdk.core.video.videoview.a eN;
    private com.kwad.components.core.video.e eO;
    private d eP;
    private boolean eQ;
    private final a.InterfaceC0187a eS;
    private IAdLiveOfflineView eT;
    private com.kwad.components.core.offline.api.kwai.a eU;
    private IAdLivePlayModule eV;
    private boolean eW;
    private View eX;
    private a.b eY;
    private OfflineOnAudioConflictListener eZ;
    private d.b ej;
    private long ex;
    private TextView fA;
    private ar fB;
    private an fC;
    private WebCardRegisterLiveMessageListener fD;
    private WebCardRegisterLiveShopListener fE;
    private boolean fG;
    private String fH;
    private ao.b fI;
    private ao.a fJ;
    private boolean fK;
    private com.kwad.components.core.widget.b fL;
    private float fM;
    private float fN;
    private boolean fO;
    private a fP;
    private ViewGroup.MarginLayoutParams fQ;
    private e fR;
    private aj fS;
    private boolean fT;
    private boolean fU;
    private b.a fV;
    private IAdLiveEndRequest fW;
    private RatioFrameLayout fx;
    private double fy;
    private LinearLayout fz;
    private final AdLivePlayStateListener mAdLivePlayStateListener;
    private KsAdWebView mAdWebView;

    @Nullable
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private Handler mHandler;
    private boolean mIsAudioEnable;
    private final com.kwad.sdk.core.network.m<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData> mNetworking;
    private int mWidth;

    /* renamed from: com.kwad.components.ad.feed.a.m$1 */
    final class AnonymousClass1 implements OfflineOnAudioConflictListener {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            m.a(m.this, false);
            if (m.this.eN != null) {
                m.this.eN.setVideoSoundEnable(false);
            }
            if (m.this.eV != null) {
                m.this.eV.setAudioEnabled(false, false);
            }
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeReleased() {
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.m$10 */
    final class AnonymousClass10 implements Runnable {
        final /* synthetic */ View fe;

        AnonymousClass10(View view) {
            view2 = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            m.this.c(view2);
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.m$11 */
    final class AnonymousClass11 implements AdLiveMessageListener {
        AnonymousClass11() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener
        public final void handleAdLiveMessage(List<AdLiveMessageInfo> list) {
            if (m.this.fD != null) {
                m.this.fD.j(list);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.m$12 */
    final class AnonymousClass12 implements Runnable {
        AnonymousClass12() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            m.this.mAdWebView.stopLoading();
            m.this.mAdWebView.setVisibility(8);
            m.this.g("0", 1);
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.m$13 */
    final class AnonymousClass13 implements AdLiveShopListener {
        AnonymousClass13() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener
        public final void handleAdLiveShop(AdLiveShopInfo adLiveShopInfo) {
            if (m.this.fE != null) {
                m.this.fE.a(adLiveShopInfo);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.m$14 */
    final class AnonymousClass14 extends SimpleImageLoadingListener {
        AnonymousClass14() {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
            return true;
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.m$15 */
    final class AnonymousClass15 implements a.b {
        private boolean cJ = false;

        /* renamed from: com.kwad.components.ad.feed.a.m$15$1 */
        final class AnonymousClass1 implements com.kwad.sdk.widget.c {
            AnonymousClass1() {
            }

            @Override // com.kwad.sdk.widget.c
            public final void a(View view) {
                if (com.kwad.sdk.core.response.a.b.bn(m.this.mAdTemplate)) {
                    return;
                }
                m.this.y(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT);
            }

            @Override // com.kwad.sdk.widget.c
            public final void b(View view) {
                if (com.kwad.sdk.core.response.a.b.bn(m.this.mAdTemplate) || !com.kwad.sdk.core.response.a.c.bQ(m.this.mAdTemplate)) {
                    return;
                }
                m.this.y(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND);
            }
        }

        /* renamed from: com.kwad.components.ad.feed.a.m$15$2 */
        final class AnonymousClass2 extends AnimatorListenerAdapter {
            AnonymousClass2() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                m.this.fS.aP(1);
                m.this.eL.removeView(m.this.fR);
            }
        }

        AnonymousClass15() {
        }

        @Override // com.kwad.components.core.video.a.c
        public final void bt() {
            com.kwad.sdk.core.report.a.av(m.this.mAdTemplate);
            m.this.fB.aQ(9);
            m.this.eL.setVisibility(8);
            if (com.kwad.components.ad.feed.kwai.b.be() && m.this.eP == null && !m.this.fT) {
                m.this.eP = new d(m.this.mContext);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                m mVar = m.this;
                mVar.addView(mVar.eP, layoutParams);
                m.this.eP.bu();
            }
        }

        @Override // com.kwad.components.core.video.a.c
        public final void d(long j2) {
            m.this.c(j2);
        }

        @Override // com.kwad.components.core.video.a.b
        public final void onVideoPlayError(int i2, int i3) {
            com.kwad.components.ad.feed.monitor.a.a(m.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.a.a.E(m.this.mAdInfo), i2 + " " + i3, SystemClock.elapsedRealtime() - m.this.ex);
        }

        @Override // com.kwad.components.core.video.a.c
        public final void onVideoPlayStart() {
            com.kwad.components.core.h.a.nC().a(m.this.getCurrentVoiceItem());
            com.kwad.components.ad.feed.monitor.a.a(m.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.a.a.E(m.this.mAdInfo), null, SystemClock.elapsedRealtime() - m.this.ex);
            com.kwad.sdk.core.report.a.h(m.this.mAdTemplate);
            m.this.fB.aQ(3);
            if (m.this.eP != null && (m.this.eP.getParent() instanceof ViewGroup)) {
                ((ViewGroup) m.this.eP.getParent()).removeView(m.this.eP);
                m.this.eP.bv();
                m.this.eP = null;
            }
            if (m.this.fR == null && com.kwad.sdk.core.response.a.b.bm(m.this.mAdTemplate) && m.this.fT) {
                m.this.fR = new e(m.this.mContext);
                m.this.eL.addView(m.this.fR, new FrameLayout.LayoutParams(-1, -1));
                m.this.fR.setOnViewEventListener(new com.kwad.sdk.widget.c() { // from class: com.kwad.components.ad.feed.a.m.15.1
                    AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.widget.c
                    public final void a(View view) {
                        if (com.kwad.sdk.core.response.a.b.bn(m.this.mAdTemplate)) {
                            return;
                        }
                        m.this.y(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT);
                    }

                    @Override // com.kwad.sdk.widget.c
                    public final void b(View view) {
                        if (com.kwad.sdk.core.response.a.b.bn(m.this.mAdTemplate) || !com.kwad.sdk.core.response.a.c.bQ(m.this.mAdTemplate)) {
                            return;
                        }
                        m.this.y(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND);
                    }
                });
                m.this.fR.a(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.a.m.15.2
                    AnonymousClass2() {
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        m.this.fS.aP(1);
                        m.this.eL.removeView(m.this.fR);
                    }
                });
            }
        }

        @Override // com.kwad.components.core.video.a.c
        public final void onVideoPlaying() {
            if (!this.cJ) {
                this.cJ = true;
                com.kwad.components.core.m.a.pb().a(m.this.mAdTemplate, System.currentTimeMillis(), 1);
            }
            com.kwad.sdk.core.video.videoview.a aVar = m.this.eN;
            m mVar = m.this;
            aVar.setVideoSoundEnable(mVar.g(mVar.mIsAudioEnable));
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.m$16 */
    final class AnonymousClass16 implements a.b {
        final /* synthetic */ int eK;

        AnonymousClass16(int i2) {
            i2 = i2;
        }

        @Override // com.kwad.components.core.d.b.a.b
        public final void onAdClicked() {
            m.this.aL(i2);
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.m$17 */
    final class AnonymousClass17 implements a.b {
        final /* synthetic */ int eK;

        AnonymousClass17(int i2) {
            i2 = i2;
        }

        @Override // com.kwad.components.core.d.b.a.b
        public final void onAdClicked() {
            m.this.aL(i2);
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.m$18 */
    final class AnonymousClass18 implements a.InterfaceC0187a {

        /* renamed from: com.kwad.components.ad.feed.a.m$18$1 */
        final class AnonymousClass1 implements a.b {
            AnonymousClass1() {
            }

            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                m.this.eh();
            }
        }

        AnonymousClass18() {
        }

        @Override // com.kwad.components.core.video.a.InterfaceC0187a
        public final void a(int i2, ac.a aVar) {
            int i3;
            int i4 = 2;
            boolean z = false;
            if (i2 == 1) {
                i3 = 13;
            } else if (i2 == 2) {
                i3 = 82;
            } else if (i2 != 3) {
                i3 = 108;
            } else {
                i3 = 83;
                i4 = 1;
                z = true;
            }
            y.b bVar = new y.b();
            bVar.jW = aVar;
            bVar.jU = i3;
            m.this.bD();
            com.kwad.components.core.d.b.a.a(new a.C0172a(m.this.getContext()).I(m.this.mAdTemplate).b(m.this.mApkDownloadHelper).ap(i4).ao(z).aq(true).a(bVar).as(true).a(new a.b() { // from class: com.kwad.components.ad.feed.a.m.18.1
                AnonymousClass1() {
                }

                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    m.this.eh();
                }
            }));
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.m$19 */
    final class AnonymousClass19 implements KsAdWebView.d {
        AnonymousClass19() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.d
        public final void onPageFinished() {
            com.kwad.components.ad.feed.monitor.a.c(com.kwad.sdk.core.response.a.b.bk(m.this.mAdTemplate), System.currentTimeMillis() - m.this.mAdWebView.getLoadTime());
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.d
        public final void onPageStart() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.d
        public final void onReceivedHttpError(int i2, String str, String str2) {
            m.this.g("1", 2);
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.m$2 */
    final class AnonymousClass2 implements ao.c {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ao.c
        public final void a(ao.b bVar) {
            m.this.fI = bVar;
            if (m.this.fJ != null) {
                m.this.fI.a(m.this.fJ);
                m.this.fJ = null;
            }
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.m$20 */
    final class AnonymousClass20 implements b.a {
        AnonymousClass20() {
        }

        @Override // com.kwad.components.core.widget.b.a
        public final void onAdClicked() {
            if (m.this.VS != null) {
                m.this.VS.onAdClicked();
            }
        }

        @Override // com.kwad.components.core.widget.b.a
        public final void onAdShow() {
            if (m.this.VS != null) {
                m.this.VS.onAdShow();
            }
            if (m.this.fK) {
                com.kwad.sdk.core.report.i iVar = new com.kwad.sdk.core.report.i();
                y.a aVar = new y.a();
                FeedType fromInt = FeedType.fromInt(m.this.mAdTemplate.type);
                if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                    fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                }
                aVar.templateId = String.valueOf(fromInt.getType());
                iVar.a(aVar);
                iVar.q((int) Math.ceil(m.this.fy), m.this.mWidth);
                com.kwad.components.core.r.b.pK().a(m.this.mAdTemplate, null, iVar);
                com.kwad.components.ad.feed.monitor.a.a(m.this.mAdTemplate, 1);
            }
        }

        @Override // com.kwad.components.core.widget.b.a
        public final void onDislikeClicked() {
            if (m.this.VS != null) {
                m.this.VS.onDislikeClicked();
            }
        }

        @Override // com.kwad.components.core.widget.b.a
        public final void onDownloadTipsDialogDismiss() {
            if (m.this.VS != null) {
                m.this.VS.onDownloadTipsDialogDismiss();
            }
        }

        @Override // com.kwad.components.core.widget.b.a
        public final void onDownloadTipsDialogShow() {
            if (m.this.VS != null) {
                m.this.VS.onDownloadTipsDialogShow();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.m$21 */
    final class AnonymousClass21 implements ab.b {
        AnonymousClass21() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ab.b
        public final void a(ab.a aVar) {
            if (m.this.fK) {
                return;
            }
            m.this.mAdWebView.setVisibility(0);
            if (m.this.fy == 0.0d) {
                m.this.fy = aVar.height;
                m.this.fx.setRatio((float) r0);
                m.fF.put(Long.valueOf(m.this.mAdTemplate.posId), Double.valueOf(aVar.height / m.this.mWidth));
            }
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.m$22 */
    final class AnonymousClass22 implements WebCardVideoPositionHandler.a {
        AnonymousClass22() {
        }

        @Override // com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler.a
        public final void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
            m mVar;
            boolean bG;
            if (m.this.mAdInfo != null) {
                if (com.kwad.sdk.core.response.a.a.aU(m.this.mAdInfo) || m.this.eW) {
                    m mVar2 = m.this;
                    mVar2.fQ = (ViewGroup.MarginLayoutParams) mVar2.eL.getLayoutParams();
                    int ceil = (int) Math.ceil(m.this.fy);
                    int i2 = m.this.mWidth;
                    if (videoPosition.widthRation == 0.0d) {
                        videoPosition.widthRation = 0.9200000166893005d;
                        videoPosition.leftMarginRation = 0.03999999910593033d;
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams = m.this.fQ;
                    double d2 = videoPosition.topMarginRation;
                    double d3 = ceil;
                    Double.isNaN(d3);
                    marginLayoutParams.topMargin = (int) (d2 * d3);
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = m.this.fQ;
                    double d4 = videoPosition.leftMarginRation;
                    double d5 = i2;
                    Double.isNaN(d5);
                    marginLayoutParams2.leftMargin = (int) (d4 * d5);
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = m.this.fQ;
                    double d6 = videoPosition.widthRation;
                    Double.isNaN(d5);
                    marginLayoutParams3.width = (int) (d5 * d6);
                    ViewGroup.MarginLayoutParams marginLayoutParams4 = m.this.fQ;
                    double d7 = m.this.fQ.width;
                    double d8 = videoPosition.heightWidthRation;
                    Double.isNaN(d7);
                    marginLayoutParams4.height = (int) (d7 * d8);
                    m.this.eL.setRadius(videoPosition.borderRadius);
                    m.this.eL.setLayoutParams(m.this.fQ);
                    if (!(m.this.dZ instanceof KSAdVideoPlayConfigImpl) || ((KSAdVideoPlayConfigImpl) m.this.dZ).getVideoSoundValue() == 0) {
                        mVar = m.this;
                        bG = com.kwad.sdk.core.response.a.a.bG(mVar.mAdInfo);
                    } else {
                        mVar = m.this;
                        bG = mVar.dZ.isVideoSoundEnable();
                    }
                    mVar.mIsAudioEnable = bG;
                    m.this.mAdTemplate.mIsAudioEnable = m.this.mIsAudioEnable;
                    m mVar3 = m.this;
                    mVar3.cI = com.kwad.sdk.core.response.a.a.bd(mVar3.mAdInfo);
                    if (!m.this.eW) {
                        m mVar4 = m.this;
                        mVar4.a(mVar4.dZ);
                    } else if (m.this.eV != null) {
                        IAdLivePlayModule iAdLivePlayModule = m.this.eV;
                        m mVar5 = m.this;
                        iAdLivePlayModule.setAudioEnabled(mVar5.g(mVar5.mIsAudioEnable), false);
                    }
                }
            }
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.m$23 */
    final class AnonymousClass23 implements t.a {

        /* renamed from: com.kwad.components.ad.feed.a.m$23$1 */
        final class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                m.this.ru();
            }
        }

        AnonymousClass23() {
        }

        @Override // com.kwad.components.core.webview.jshandler.t.a
        public final void bI() {
            m.this.mHandler.post(new Runnable() { // from class: com.kwad.components.ad.feed.a.m.23.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    m.this.ru();
                }
            });
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.m$24 */
    final class AnonymousClass24 implements u.b {
        AnonymousClass24() {
        }

        @Override // com.kwad.components.core.webview.jshandler.u.b
        public final void a(u.a aVar) {
            aVar.height = 0;
            aVar.width = m.this.mWidth;
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.m$25 */
    final class AnonymousClass25 implements ap.a {
        AnonymousClass25() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ap.a
        public final void bJ() {
            m.d(m.this, true);
            m.this.bB();
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.m$3 */
    final class AnonymousClass3 extends com.kwad.sdk.core.network.m<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData> {
        AnonymousClass3() {
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: bH */
        public com.kwad.components.core.liveEnd.a createRequest() {
            return new com.kwad.components.core.liveEnd.a(m.this.fW);
        }

        @NonNull
        private static AdLiveEndCommonResultData t(String str) {
            AdLiveEndCommonResultData adLiveEndCommonResultData = new AdLiveEndCommonResultData();
            adLiveEndCommonResultData.parseJson(new JSONObject(str));
            return adLiveEndCommonResultData;
        }

        @Override // com.kwad.sdk.core.network.m
        public final boolean isPostByJson() {
            return false;
        }

        @Override // com.kwad.sdk.core.network.m
        @NonNull
        public final /* synthetic */ AdLiveEndCommonResultData parseData(String str) {
            return t(str);
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.m$4 */
    final class AnonymousClass4 extends AdLivePlayStateListenerAdapter {

        /* renamed from: com.kwad.components.ad.feed.a.m$4$1 */
        final class AnonymousClass1 extends p<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData> {
            AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onStartRequest(@NonNull com.kwad.components.core.liveEnd.a aVar) {
                super.onStartRequest(aVar);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onError(@NonNull com.kwad.components.core.liveEnd.a aVar, int i2, String str) {
                super.onError(aVar, i2, str);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar, @NonNull AdLiveEndCommonResultData adLiveEndCommonResultData) {
                super.onSuccess(aVar, adLiveEndCommonResultData);
                ao.a aVar2 = new ao.a();
                aVar2.status = 9;
                aVar2.totalWatchingDuration = adLiveEndCommonResultData.totalWatchingDuration;
                aVar2.watchingUserCount = adLiveEndCommonResultData.watchingUserCount;
                aVar2.displayWatchingUserCount = adLiveEndCommonResultData.displayWatchingUserCount;
                aVar2.likeUserCount = adLiveEndCommonResultData.likeUserCount;
                aVar2.displayLikeUserCount = adLiveEndCommonResultData.displayLikeUserCount;
                aVar2.liveDuration = adLiveEndCommonResultData.liveDuration;
                if (m.this.fI != null) {
                    m.this.fI.a(aVar2);
                } else {
                    m.this.fJ = aVar2;
                }
            }
        }

        AnonymousClass4() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            String aY = com.kwad.sdk.core.response.a.a.aY(m.this.mAdInfo);
            if (TextUtils.isEmpty(aY)) {
                return;
            }
            com.kwad.components.core.offline.api.kwai.a aVar = (com.kwad.components.core.offline.api.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class);
            if (aVar != null) {
                m.this.fW = aVar.getAdLiveEndRequest(aY);
            }
            m.this.mNetworking.request(new p<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.feed.a.m.4.1
                AnonymousClass1() {
                }

                @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
                /* renamed from: a */
                public void onStartRequest(@NonNull com.kwad.components.core.liveEnd.a aVar2) {
                    super.onStartRequest(aVar2);
                }

                @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
                /* renamed from: a */
                public void onError(@NonNull com.kwad.components.core.liveEnd.a aVar2, int i2, String str) {
                    super.onError(aVar2, i2, str);
                }

                @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
                /* renamed from: a */
                public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar2, @NonNull AdLiveEndCommonResultData adLiveEndCommonResultData) {
                    super.onSuccess(aVar2, adLiveEndCommonResultData);
                    ao.a aVar22 = new ao.a();
                    aVar22.status = 9;
                    aVar22.totalWatchingDuration = adLiveEndCommonResultData.totalWatchingDuration;
                    aVar22.watchingUserCount = adLiveEndCommonResultData.watchingUserCount;
                    aVar22.displayWatchingUserCount = adLiveEndCommonResultData.displayWatchingUserCount;
                    aVar22.likeUserCount = adLiveEndCommonResultData.likeUserCount;
                    aVar22.displayLikeUserCount = adLiveEndCommonResultData.displayLikeUserCount;
                    aVar22.liveDuration = adLiveEndCommonResultData.liveDuration;
                    if (m.this.fI != null) {
                        m.this.fI.a(aVar22);
                    } else {
                        m.this.fJ = aVar22;
                    }
                }
            });
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            m.this.c(j2);
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayResume() {
            com.kwad.components.core.h.a.nC().a(m.this.getCurrentVoiceItem());
            super.onLivePlayResume();
            IAdLivePlayModule iAdLivePlayModule = m.this.eV;
            m mVar = m.this;
            iAdLivePlayModule.setAudioEnabled(mVar.g(mVar.mIsAudioEnable), false);
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayStart() {
            com.kwad.components.core.h.a.nC().a(m.this.getCurrentVoiceItem());
            super.onLivePlayStart();
            IAdLivePlayModule iAdLivePlayModule = m.this.eV;
            m mVar = m.this;
            iAdLivePlayModule.setAudioEnabled(mVar.g(mVar.mIsAudioEnable), false);
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePrepared() {
            super.onLivePrepared();
            m.this.eV.setAudioEnabled(false, false);
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.m$5 */
    final class AnonymousClass5 implements d.b {

        /* renamed from: com.kwad.components.ad.feed.a.m$5$1 */
        final class AnonymousClass1 implements a.b {
            final /* synthetic */ double fZ;

            AnonymousClass1(double d2) {
                d2 = d2;
            }

            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.d.b.d("FeedWebView", "convertEnable End" + com.kwad.sdk.core.response.a.d.cl(m.this.mAdTemplate));
                com.kwad.sdk.core.report.i iVar = new com.kwad.sdk.core.report.i();
                iVar.i(d2);
                iVar.bj(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META);
                m.this.c(iVar);
            }
        }

        AnonymousClass5() {
        }

        @Override // com.kwad.components.ad.feed.d.b
        public final boolean b(double d2) {
            if (!bl.o(m.this.fx, (int) (com.kwad.sdk.core.config.d.uF() * 100.0f))) {
                return false;
            }
            com.kwad.components.core.d.b.a.a(new a.C0172a(m.this.getContext()).I(m.this.mAdTemplate).b(m.this.mApkDownloadHelper).ap(2).ao(false).aq(false).ao(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META).an(5).as(true).a(new a.b() { // from class: com.kwad.components.ad.feed.a.m.5.1
                final /* synthetic */ double fZ;

                AnonymousClass1(double d22) {
                    d2 = d22;
                }

                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    com.kwad.sdk.core.d.b.d("FeedWebView", "convertEnable End" + com.kwad.sdk.core.response.a.d.cl(m.this.mAdTemplate));
                    com.kwad.sdk.core.report.i iVar = new com.kwad.sdk.core.report.i();
                    iVar.i(d2);
                    iVar.bj(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META);
                    m.this.c(iVar);
                }
            }));
            return true;
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.m$6 */
    final class AnonymousClass6 implements ag.a {
        AnonymousClass6() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ag.a
        public final void a(com.kwad.components.core.webview.kwai.b bVar) {
            AdWebViewActivityProxy.launch(m.this.mContext, new AdWebViewActivityProxy.a.C0182a().au(bVar.title).av(bVar.url).aA(true).L(m.this.mAdTemplate).oc());
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.m$7 */
    final class AnonymousClass7 implements com.kwad.sdk.core.webview.c.kwai.a {

        /* renamed from: com.kwad.components.ad.feed.a.m$7$1 */
        final class AnonymousClass1 implements a.b {
            AnonymousClass1() {
            }

            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                if (m.this.VS != null) {
                    m.this.VS.onAdClicked();
                }
            }
        }

        AnonymousClass7() {
        }

        @Override // com.kwad.sdk.core.webview.c.kwai.a
        public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
            m.this.bD();
            int i2 = aVar.TC;
            if (aVar.II) {
                i2 = aVar.TA ? 1 : 2;
            }
            boolean aU = com.kwad.sdk.core.response.a.a.aU(m.this.mAdInfo);
            y.b bVar = new y.b();
            com.kwad.sdk.core.webview.c.a.c cVar = aVar.TD;
            if (cVar != null && !TextUtils.isEmpty(cVar.Ts)) {
                bVar.Ts = aVar.TD.Ts;
            }
            com.kwad.components.core.d.b.a.a(new a.C0172a(m.this.getContext()).I(m.this.mAdTemplate).b(m.this.mApkDownloadHelper).ao(m.a(m.this, aVar)).ap(i2).ao(aVar.jU).an(5).au(aVar.II).as(aU).q(m.this.eV == null ? 0L : m.this.eV.getPlayDuration()).a(bVar).aq(true).a(new a.b() { // from class: com.kwad.components.ad.feed.a.m.7.1
                AnonymousClass1() {
                }

                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    if (m.this.VS != null) {
                        m.this.VS.onAdClicked();
                    }
                }
            }));
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.m$8 */
    final class AnonymousClass8 implements ai.b {
        AnonymousClass8() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ai.b
        public final void a(ai.a aVar) {
            if (m.this.fG) {
                return;
            }
            m.this.cW = aVar.status;
            if (m.this.cW != 1) {
                m.this.g("3", 3);
                return;
            }
            m.this.mHandler.removeCallbacksAndMessages(null);
            if (m.this.fL != null) {
                m.this.fL.setVisibility(8);
            }
            m.this.mAdWebView.setVisibility(0);
            com.kwad.components.core.m.a.pb().N(m.this.mAdTemplate);
            if (m.this.fP != null) {
                m.this.fP.c(2, "");
            }
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.m$9 */
    final class AnonymousClass9 implements a.c {
        AnonymousClass9() {
        }

        @Override // com.kwad.components.core.h.a.c
        public final void bs() {
            if (!m.this.eW) {
                if (m.this.eN != null) {
                    com.kwad.sdk.core.video.videoview.a aVar = m.this.eN;
                    m mVar = m.this;
                    aVar.setVideoSoundEnable(mVar.g(mVar.mIsAudioEnable));
                    return;
                }
                return;
            }
            if (m.this.eV == null) {
                m mVar2 = m.this;
                mVar2.eV = mVar2.bq();
            }
            IAdLivePlayModule iAdLivePlayModule = m.this.eV;
            m mVar3 = m.this;
            iAdLivePlayModule.setAudioEnabled(mVar3.g(mVar3.mIsAudioEnable), false);
        }
    }

    public interface a {
        void c(int i2, String str);
    }

    public m(@NonNull Context context) {
        super(context);
        this.cW = -1;
        this.mIsAudioEnable = false;
        this.fK = false;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.fT = false;
        this.fU = false;
        this.eZ = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.feed.a.m.1
            AnonymousClass1() {
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                m.a(m.this, false);
                if (m.this.eN != null) {
                    m.this.eN.setVideoSoundEnable(false);
                }
                if (m.this.eV != null) {
                    m.this.eV.setAudioEnabled(false, false);
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }
        };
        this.fV = new b.a() { // from class: com.kwad.components.ad.feed.a.m.20
            AnonymousClass20() {
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onAdClicked() {
                if (m.this.VS != null) {
                    m.this.VS.onAdClicked();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onAdShow() {
                if (m.this.VS != null) {
                    m.this.VS.onAdShow();
                }
                if (m.this.fK) {
                    com.kwad.sdk.core.report.i iVar = new com.kwad.sdk.core.report.i();
                    y.a aVar = new y.a();
                    FeedType fromInt = FeedType.fromInt(m.this.mAdTemplate.type);
                    if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                        fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                    }
                    aVar.templateId = String.valueOf(fromInt.getType());
                    iVar.a(aVar);
                    iVar.q((int) Math.ceil(m.this.fy), m.this.mWidth);
                    com.kwad.components.core.r.b.pK().a(m.this.mAdTemplate, null, iVar);
                    com.kwad.components.ad.feed.monitor.a.a(m.this.mAdTemplate, 1);
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDislikeClicked() {
                if (m.this.VS != null) {
                    m.this.VS.onDislikeClicked();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogDismiss() {
                if (m.this.VS != null) {
                    m.this.VS.onDownloadTipsDialogDismiss();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogShow() {
                if (m.this.VS != null) {
                    m.this.VS.onDownloadTipsDialogShow();
                }
            }
        };
        this.mNetworking = new com.kwad.sdk.core.network.m<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.feed.a.m.3
            AnonymousClass3() {
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: bH */
            public com.kwad.components.core.liveEnd.a createRequest() {
                return new com.kwad.components.core.liveEnd.a(m.this.fW);
            }

            @NonNull
            private static AdLiveEndCommonResultData t(String str) {
                AdLiveEndCommonResultData adLiveEndCommonResultData = new AdLiveEndCommonResultData();
                adLiveEndCommonResultData.parseJson(new JSONObject(str));
                return adLiveEndCommonResultData;
            }

            @Override // com.kwad.sdk.core.network.m
            public final boolean isPostByJson() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.m
            @NonNull
            public final /* synthetic */ AdLiveEndCommonResultData parseData(String str) {
                return t(str);
            }
        };
        this.mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.feed.a.m.4

            /* renamed from: com.kwad.components.ad.feed.a.m$4$1 */
            final class AnonymousClass1 extends p<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData> {
                AnonymousClass1() {
                }

                @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
                /* renamed from: a */
                public void onStartRequest(@NonNull com.kwad.components.core.liveEnd.a aVar2) {
                    super.onStartRequest(aVar2);
                }

                @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
                /* renamed from: a */
                public void onError(@NonNull com.kwad.components.core.liveEnd.a aVar2, int i2, String str) {
                    super.onError(aVar2, i2, str);
                }

                @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
                /* renamed from: a */
                public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar2, @NonNull AdLiveEndCommonResultData adLiveEndCommonResultData) {
                    super.onSuccess(aVar2, adLiveEndCommonResultData);
                    ao.a aVar22 = new ao.a();
                    aVar22.status = 9;
                    aVar22.totalWatchingDuration = adLiveEndCommonResultData.totalWatchingDuration;
                    aVar22.watchingUserCount = adLiveEndCommonResultData.watchingUserCount;
                    aVar22.displayWatchingUserCount = adLiveEndCommonResultData.displayWatchingUserCount;
                    aVar22.likeUserCount = adLiveEndCommonResultData.likeUserCount;
                    aVar22.displayLikeUserCount = adLiveEndCommonResultData.displayLikeUserCount;
                    aVar22.liveDuration = adLiveEndCommonResultData.liveDuration;
                    if (m.this.fI != null) {
                        m.this.fI.a(aVar22);
                    } else {
                        m.this.fJ = aVar22;
                    }
                }
            }

            AnonymousClass4() {
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                super.onLivePlayEnd();
                String aY = com.kwad.sdk.core.response.a.a.aY(m.this.mAdInfo);
                if (TextUtils.isEmpty(aY)) {
                    return;
                }
                com.kwad.components.core.offline.api.kwai.a aVar = (com.kwad.components.core.offline.api.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class);
                if (aVar != null) {
                    m.this.fW = aVar.getAdLiveEndRequest(aY);
                }
                m.this.mNetworking.request(new p<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.feed.a.m.4.1
                    AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
                    /* renamed from: a */
                    public void onStartRequest(@NonNull com.kwad.components.core.liveEnd.a aVar2) {
                        super.onStartRequest(aVar2);
                    }

                    @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
                    /* renamed from: a */
                    public void onError(@NonNull com.kwad.components.core.liveEnd.a aVar2, int i2, String str) {
                        super.onError(aVar2, i2, str);
                    }

                    @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
                    /* renamed from: a */
                    public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar2, @NonNull AdLiveEndCommonResultData adLiveEndCommonResultData) {
                        super.onSuccess(aVar2, adLiveEndCommonResultData);
                        ao.a aVar22 = new ao.a();
                        aVar22.status = 9;
                        aVar22.totalWatchingDuration = adLiveEndCommonResultData.totalWatchingDuration;
                        aVar22.watchingUserCount = adLiveEndCommonResultData.watchingUserCount;
                        aVar22.displayWatchingUserCount = adLiveEndCommonResultData.displayWatchingUserCount;
                        aVar22.likeUserCount = adLiveEndCommonResultData.likeUserCount;
                        aVar22.displayLikeUserCount = adLiveEndCommonResultData.displayLikeUserCount;
                        aVar22.liveDuration = adLiveEndCommonResultData.liveDuration;
                        if (m.this.fI != null) {
                            m.this.fI.a(aVar22);
                        } else {
                            m.this.fJ = aVar22;
                        }
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(long j2) {
                super.onLivePlayProgress(j2);
                m.this.c(j2);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                com.kwad.components.core.h.a.nC().a(m.this.getCurrentVoiceItem());
                super.onLivePlayResume();
                IAdLivePlayModule iAdLivePlayModule = m.this.eV;
                m mVar = m.this;
                iAdLivePlayModule.setAudioEnabled(mVar.g(mVar.mIsAudioEnable), false);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                com.kwad.components.core.h.a.nC().a(m.this.getCurrentVoiceItem());
                super.onLivePlayStart();
                IAdLivePlayModule iAdLivePlayModule = m.this.eV;
                m mVar = m.this;
                iAdLivePlayModule.setAudioEnabled(mVar.g(mVar.mIsAudioEnable), false);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePrepared() {
                super.onLivePrepared();
                m.this.eV.setAudioEnabled(false, false);
            }
        };
        this.cZ = new ai.b() { // from class: com.kwad.components.ad.feed.a.m.8
            AnonymousClass8() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ai.b
            public final void a(ai.a aVar) {
                if (m.this.fG) {
                    return;
                }
                m.this.cW = aVar.status;
                if (m.this.cW != 1) {
                    m.this.g("3", 3);
                    return;
                }
                m.this.mHandler.removeCallbacksAndMessages(null);
                if (m.this.fL != null) {
                    m.this.fL.setVisibility(8);
                }
                m.this.mAdWebView.setVisibility(0);
                com.kwad.components.core.m.a.pb().N(m.this.mAdTemplate);
                if (m.this.fP != null) {
                    m.this.fP.c(2, "");
                }
            }
        };
        this.eS = new a.InterfaceC0187a() { // from class: com.kwad.components.ad.feed.a.m.18

            /* renamed from: com.kwad.components.ad.feed.a.m$18$1 */
            final class AnonymousClass1 implements a.b {
                AnonymousClass1() {
                }

                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    m.this.eh();
                }
            }

            AnonymousClass18() {
            }

            @Override // com.kwad.components.core.video.a.InterfaceC0187a
            public final void a(int i2, ac.a aVar) {
                int i3;
                int i4 = 2;
                boolean z = false;
                if (i2 == 1) {
                    i3 = 13;
                } else if (i2 == 2) {
                    i3 = 82;
                } else if (i2 != 3) {
                    i3 = 108;
                } else {
                    i3 = 83;
                    i4 = 1;
                    z = true;
                }
                y.b bVar = new y.b();
                bVar.jW = aVar;
                bVar.jU = i3;
                m.this.bD();
                com.kwad.components.core.d.b.a.a(new a.C0172a(m.this.getContext()).I(m.this.mAdTemplate).b(m.this.mApkDownloadHelper).ap(i4).ao(z).aq(true).a(bVar).as(true).a(new a.b() { // from class: com.kwad.components.ad.feed.a.m.18.1
                    AnonymousClass1() {
                    }

                    @Override // com.kwad.components.core.d.b.a.b
                    public final void onAdClicked() {
                        m.this.eh();
                    }
                }));
            }
        };
    }

    private void a(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return;
        }
        this.fM = motionEvent.getX();
        this.fN = motionEvent.getY();
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        this.fB = new ar();
        an anVar = new an();
        this.fC = anVar;
        aVar.a(anVar);
        aVar.a(new s(this.cV, this.mApkDownloadHelper, getClickListener()));
        aVar.a(new com.kwad.components.core.webview.jshandler.p(this.cV, this.mApkDownloadHelper, getClickListener()));
        aVar.a(new ab(this.cV, new ab.b() { // from class: com.kwad.components.ad.feed.a.m.21
            AnonymousClass21() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ab.b
            public final void a(ab.a aVar2) {
                if (m.this.fK) {
                    return;
                }
                m.this.mAdWebView.setVisibility(0);
                if (m.this.fy == 0.0d) {
                    m.this.fy = aVar2.height;
                    m.this.fx.setRatio((float) r0);
                    m.fF.put(Long.valueOf(m.this.mAdTemplate.posId), Double.valueOf(aVar2.height / m.this.mWidth));
                }
            }
        }));
        aVar.a(new com.kwad.components.core.webview.a.kwai.f());
        aVar.a(new v(this.cV));
        aVar.a(new WebCardVideoPositionHandler(new WebCardVideoPositionHandler.a() { // from class: com.kwad.components.ad.feed.a.m.22
            AnonymousClass22() {
            }

            @Override // com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler.a
            public final void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                m mVar;
                boolean bG;
                if (m.this.mAdInfo != null) {
                    if (com.kwad.sdk.core.response.a.a.aU(m.this.mAdInfo) || m.this.eW) {
                        m mVar2 = m.this;
                        mVar2.fQ = (ViewGroup.MarginLayoutParams) mVar2.eL.getLayoutParams();
                        int ceil = (int) Math.ceil(m.this.fy);
                        int i2 = m.this.mWidth;
                        if (videoPosition.widthRation == 0.0d) {
                            videoPosition.widthRation = 0.9200000166893005d;
                            videoPosition.leftMarginRation = 0.03999999910593033d;
                        }
                        ViewGroup.MarginLayoutParams marginLayoutParams = m.this.fQ;
                        double d2 = videoPosition.topMarginRation;
                        double d3 = ceil;
                        Double.isNaN(d3);
                        marginLayoutParams.topMargin = (int) (d2 * d3);
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = m.this.fQ;
                        double d4 = videoPosition.leftMarginRation;
                        double d5 = i2;
                        Double.isNaN(d5);
                        marginLayoutParams2.leftMargin = (int) (d4 * d5);
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = m.this.fQ;
                        double d6 = videoPosition.widthRation;
                        Double.isNaN(d5);
                        marginLayoutParams3.width = (int) (d5 * d6);
                        ViewGroup.MarginLayoutParams marginLayoutParams4 = m.this.fQ;
                        double d7 = m.this.fQ.width;
                        double d8 = videoPosition.heightWidthRation;
                        Double.isNaN(d7);
                        marginLayoutParams4.height = (int) (d7 * d8);
                        m.this.eL.setRadius(videoPosition.borderRadius);
                        m.this.eL.setLayoutParams(m.this.fQ);
                        if (!(m.this.dZ instanceof KSAdVideoPlayConfigImpl) || ((KSAdVideoPlayConfigImpl) m.this.dZ).getVideoSoundValue() == 0) {
                            mVar = m.this;
                            bG = com.kwad.sdk.core.response.a.a.bG(mVar.mAdInfo);
                        } else {
                            mVar = m.this;
                            bG = mVar.dZ.isVideoSoundEnable();
                        }
                        mVar.mIsAudioEnable = bG;
                        m.this.mAdTemplate.mIsAudioEnable = m.this.mIsAudioEnable;
                        m mVar3 = m.this;
                        mVar3.cI = com.kwad.sdk.core.response.a.a.bd(mVar3.mAdInfo);
                        if (!m.this.eW) {
                            m mVar4 = m.this;
                            mVar4.a(mVar4.dZ);
                        } else if (m.this.eV != null) {
                            IAdLivePlayModule iAdLivePlayModule = m.this.eV;
                            m mVar5 = m.this;
                            iAdLivePlayModule.setAudioEnabled(mVar5.g(mVar5.mIsAudioEnable), false);
                        }
                    }
                }
            }
        }));
        aVar.a(new t(this.cV, new t.a() { // from class: com.kwad.components.ad.feed.a.m.23

            /* renamed from: com.kwad.components.ad.feed.a.m$23$1 */
            final class AnonymousClass1 implements Runnable {
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    m.this.ru();
                }
            }

            AnonymousClass23() {
            }

            @Override // com.kwad.components.core.webview.jshandler.t.a
            public final void bI() {
                m.this.mHandler.post(new Runnable() { // from class: com.kwad.components.ad.feed.a.m.23.1
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        m.this.ru();
                    }
                });
            }
        }));
        aVar.a(new com.kwad.components.core.webview.jshandler.y(this.cV));
        u uVar = new u(this.cV);
        uVar.a(new u.b() { // from class: com.kwad.components.ad.feed.a.m.24
            AnonymousClass24() {
            }

            @Override // com.kwad.components.core.webview.jshandler.u.b
            public final void a(u.a aVar2) {
                aVar2.height = 0;
                aVar2.width = m.this.mWidth;
            }
        });
        aVar.a(uVar);
        aVar.a(new ai(this.cZ, com.kwad.sdk.core.response.a.b.bk(this.mAdTemplate)));
        aVar.a(new aq(this.cV, this.mApkDownloadHelper));
        aVar.a(new com.kwad.components.core.webview.jshandler.ac(this.cV));
        aVar.a(this.fB);
        aVar.a(new ag(getOpenNewPageListener()));
        aVar.a(new ap(new ap.a() { // from class: com.kwad.components.ad.feed.a.m.25
            AnonymousClass25() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ap.a
            public final void bJ() {
                m.d(m.this, true);
                m.this.bB();
            }
        }));
        aj ajVar = new aj();
        this.fS = ajVar;
        aVar.a(ajVar);
        if (this.eW) {
            aVar.a(new com.kwad.components.core.webview.jshandler.c(1, 1));
            this.fE = new WebCardRegisterLiveShopListener();
            this.fD = new WebCardRegisterLiveMessageListener();
            aVar.a(this.fE);
            aVar.a(this.fD);
            aVar.a(new ao(getRegisterLiveListener()));
        }
    }

    private void a(com.kwad.sdk.core.video.videoview.a aVar, int i2) {
        if (aVar != null) {
            String E = com.kwad.sdk.core.response.a.a.E(this.mAdInfo);
            this.eO.setAutoRelease(false);
            AdVideoPlayerViewCache.getInstance().a(E, this.eN);
            FeedType.fromInt(this.mAdTemplate.type);
            bD();
            com.kwad.components.core.d.b.a.a(new a.C0172a(getContext()).I(this.mAdTemplate).b(this.mApkDownloadHelper).ap(2).as(com.kwad.sdk.core.response.a.a.aU(this.mAdInfo)).a(new a.b() { // from class: com.kwad.components.ad.feed.a.m.17
                final /* synthetic */ int eK;

                AnonymousClass17(int i22) {
                    i2 = i22;
                }

                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    m.this.aL(i2);
                }
            }));
        }
    }

    static /* synthetic */ boolean a(m mVar, com.kwad.sdk.core.webview.c.a.a aVar) {
        return enablePauseByActionbar(aVar);
    }

    static /* synthetic */ boolean a(m mVar, boolean z) {
        mVar.eQ = false;
        return false;
    }

    private void aF() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.cV = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.cV;
        bVar2.mScreenOrientation = 0;
        bVar2.app = null;
        bVar2.LD = this.fx;
        bVar2.Lc = this.mAdWebView;
        bVar2.mReportExtData = null;
        bVar2.apr = false;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void aG() {
        aI();
        this.mAdWebView.setClientConfig(this.mAdWebView.getClientConfig().ct(this.mAdTemplate).b(getWebListener()));
        this.mAdWebView.setVisibility(4);
        this.mAdWebView.setBackgroundColor(0);
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.mAdWebView);
        this.cU = aVar;
        a(aVar);
        this.mAdWebView.addJavascriptInterface(this.cU, "KwaiAd");
        this.mAdWebView.loadUrl(com.kwad.sdk.core.response.a.b.bk(this.mAdTemplate));
        com.kwad.components.ad.feed.monitor.a.s(com.kwad.sdk.core.response.a.b.bk(this.mAdTemplate));
        bA();
    }

    private void aI() {
        com.kwad.components.core.webview.a aVar = this.cU;
        if (aVar != null) {
            aVar.destroy();
            this.cU = null;
        }
    }

    private void bA() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.kwad.components.ad.feed.a.m.12
            AnonymousClass12() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                m.this.mAdWebView.stopLoading();
                m.this.mAdWebView.setVisibility(8);
                m.this.g("0", 1);
            }
        }, 2500L);
    }

    public void bB() {
        float bo = com.kwad.sdk.core.response.a.b.bo(this.mAdTemplate);
        AnonymousClass5 anonymousClass5 = new d.b() { // from class: com.kwad.components.ad.feed.a.m.5

            /* renamed from: com.kwad.components.ad.feed.a.m$5$1 */
            final class AnonymousClass1 implements a.b {
                final /* synthetic */ double fZ;

                AnonymousClass1(double d22) {
                    d2 = d22;
                }

                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    com.kwad.sdk.core.d.b.d("FeedWebView", "convertEnable End" + com.kwad.sdk.core.response.a.d.cl(m.this.mAdTemplate));
                    com.kwad.sdk.core.report.i iVar = new com.kwad.sdk.core.report.i();
                    iVar.i(d2);
                    iVar.bj(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META);
                    m.this.c(iVar);
                }
            }

            AnonymousClass5() {
            }

            @Override // com.kwad.components.ad.feed.d.b
            public final boolean b(double d22) {
                if (!bl.o(m.this.fx, (int) (com.kwad.sdk.core.config.d.uF() * 100.0f))) {
                    return false;
                }
                com.kwad.components.core.d.b.a.a(new a.C0172a(m.this.getContext()).I(m.this.mAdTemplate).b(m.this.mApkDownloadHelper).ap(2).ao(false).aq(false).ao(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META).an(5).as(true).a(new a.b() { // from class: com.kwad.components.ad.feed.a.m.5.1
                    final /* synthetic */ double fZ;

                    AnonymousClass1(double d222) {
                        d2 = d222;
                    }

                    @Override // com.kwad.components.core.d.b.a.b
                    public final void onAdClicked() {
                        com.kwad.sdk.core.d.b.d("FeedWebView", "convertEnable End" + com.kwad.sdk.core.response.a.d.cl(m.this.mAdTemplate));
                        com.kwad.sdk.core.report.i iVar = new com.kwad.sdk.core.report.i();
                        iVar.i(d2);
                        iVar.bj(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META);
                        m.this.c(iVar);
                    }
                }));
                return true;
            }
        };
        this.ej = anonymousClass5;
        com.kwad.components.ad.feed.d.a(bo, this.mContext, anonymousClass5);
    }

    public void bD() {
        if (this.fO) {
            return;
        }
        this.fO = true;
        com.kwad.components.ad.feed.monitor.a.a(this.mAdTemplate, 2, getStayTime());
    }

    private boolean bE() {
        return this.cW == 1;
    }

    private void bF() {
        this.eT.registerLiveMessageListener(new AdLiveMessageListener() { // from class: com.kwad.components.ad.feed.a.m.11
            AnonymousClass11() {
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener
            public final void handleAdLiveMessage(List<AdLiveMessageInfo> list) {
                if (m.this.fD != null) {
                    m.this.fD.j(list);
                }
            }
        });
        this.eT.registerLiveShopListener(new AdLiveShopListener() { // from class: com.kwad.components.ad.feed.a.m.13
            AnonymousClass13() {
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener
            public final void handleAdLiveShop(AdLiveShopInfo adLiveShopInfo) {
                if (m.this.fE != null) {
                    m.this.fE.a(adLiveShopInfo);
                }
            }
        });
    }

    private boolean bp() {
        IAdLiveOfflineView iAdLiveOfflineView = this.eT;
        if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || this.eV == null) {
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
            this.eV.setAudioEnabled(g(this.mIsAudioEnable), false);
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
        bi.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.feed.a.m.10
            final /* synthetic */ View fe;

            AnonymousClass10(View view22) {
                view2 = view22;
            }

            @Override // java.lang.Runnable
            public final void run() {
                m.this.c(view2);
            }
        });
        bF();
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
            KSImageLoader.loadImage(this.eM, url, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.feed.a.m.14
                AnonymousClass14() {
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
        int width = this.eL.getWidth();
        int height = this.eL.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (height * 0.5625f), height);
        layoutParams.addRule(13, -1);
        view.setLayoutParams(layoutParams);
    }

    private void c(AdTemplate adTemplate) {
        if (this.fU) {
            return;
        }
        this.mAdWebView = (KsAdWebView) findViewById(com.kwad.sdk.core.response.a.a.cq(com.kwad.sdk.core.response.a.d.cb(adTemplate)) ? R.id.ksad_web_bottom_card_webView : R.id.ksad_web_default_bottom_card_webView);
        this.fU = true;
    }

    private static float d(AdTemplate adTemplate) {
        int i2 = adTemplate.type;
        if (i2 == 1) {
            return 0.6013f;
        }
        return (i2 == 2 || i2 == 3) ? 0.283f : 0.968f;
    }

    static /* synthetic */ boolean d(m mVar, boolean z) {
        mVar.fT = true;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void e(AdTemplate adTemplate) {
        RatioFrameLayout ratioFrameLayout;
        double d2;
        com.kwad.components.core.d.b.c cVar = new com.kwad.components.core.d.b.c(this.mAdTemplate);
        this.mApkDownloadHelper = cVar;
        cVar.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        if (fF.get(Long.valueOf(this.mAdTemplate.posId)) != null) {
            this.fx.setRatio(r5.floatValue());
        } else {
            if (com.kwad.sdk.core.response.a.b.bp(this.mAdTemplate) > 0.0d) {
                ratioFrameLayout = this.fx;
                d2 = com.kwad.sdk.core.response.a.b.bp(this.mAdTemplate);
            } else if (this.fx.getRatio() == 0.0d) {
                ratioFrameLayout = this.fx;
                d2 = d(this.mAdTemplate);
            }
            ratioFrameLayout.setRatio(d2);
        }
        com.kwad.components.core.offline.api.kwai.a aVar = (com.kwad.components.core.offline.api.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class);
        this.eU = aVar;
        if (aVar != null && aVar.hasLiveCompoReady() && com.kwad.sdk.core.response.a.a.cq(this.mAdInfo)) {
            this.eW = true;
        }
        aF();
    }

    private static boolean enablePauseByActionbar(com.kwad.sdk.core.webview.c.a.a aVar) {
        return aVar.II ? aVar.TA : aVar.TC == 1;
    }

    public void g(String str, int i2) {
        com.kwad.sdk.core.d.b.d("FeedWebView", "handleWebViewError " + str);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fG) {
            return;
        }
        this.fG = true;
        if (this.mAdWebView != null) {
            com.kwad.components.ad.feed.monitor.a.a(com.kwad.sdk.core.response.a.b.bk(this.mAdTemplate), System.currentTimeMillis() - this.mAdWebView.getLoadTime(), i2);
        }
        com.kwad.components.core.m.a pb = com.kwad.components.core.m.a.pb();
        AdTemplate adTemplate = this.mAdTemplate;
        pb.b(adTemplate, com.kwad.sdk.core.response.a.b.bk(adTemplate), str);
        a aVar = this.fP;
        if (aVar != null) {
            aVar.c(1, str);
        }
        this.fP = null;
        if (this.fL == null) {
            this.fK = true;
            com.kwad.components.core.widget.b.c(this);
            int aW = com.kwad.sdk.core.response.a.a.aW(this.mAdInfo);
            IAdLivePlayModule iAdLivePlayModule = this.eV;
            if (iAdLivePlayModule != null) {
                iAdLivePlayModule.setAudioEnabled(false, false);
                this.eV.onDestroy();
                this.eV = null;
            }
            IAdLiveOfflineView iAdLiveOfflineView = this.eT;
            if (iAdLiveOfflineView != null) {
                iAdLiveOfflineView.onDestroy();
                this.eT = null;
            }
            com.kwad.components.core.widget.b a2 = com.kwad.components.ad.feed.b.a(this.mContext, FeedType.fromInt(this.mAdTemplate.type), aW);
            this.fL = a2;
            if (a2 != null) {
                this.fL.setMargin(com.kwad.sdk.c.kwai.a.a(this.mContext, 16.0f));
                this.fx.removeAllViews();
                this.fx.setRatio(0.0d);
                KsAdWebView ksAdWebView = this.mAdWebView;
                if (ksAdWebView != null) {
                    ksAdWebView.setVisibility(8);
                }
                this.eL.setVisibility(8);
                this.fL.setInnerAdInteractionListener(this.fV);
                this.fx.addView(this.fL);
                this.fL.bindView(this.mAdTemplate);
                com.kwad.components.core.widget.b bVar = this.fL;
                if (bVar instanceof c) {
                    ((c) bVar).a(this.dZ);
                }
            }
        }
    }

    public boolean g(boolean z) {
        if (!z) {
            return false;
        }
        if (this.eY != null) {
            com.kwad.components.core.h.a.nC();
            if (!com.kwad.components.core.h.a.b(this.eY)) {
                return false;
            }
        }
        if (!com.kwad.sdk.core.config.d.gz()) {
            return !com.kwad.components.core.r.a.aj(this.mContext).pJ() ? com.kwad.components.core.r.a.aj(this.mContext).aL(false) : !com.kwad.components.core.r.a.aj(this.mContext).pI();
        }
        if (!this.eQ) {
            this.eQ = com.kwad.components.core.r.a.aj(this.mContext).aL(true);
        }
        return this.eQ;
    }

    @NonNull
    private com.kwad.sdk.core.webview.c.kwai.a getClickListener() {
        return new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.feed.a.m.7

            /* renamed from: com.kwad.components.ad.feed.a.m$7$1 */
            final class AnonymousClass1 implements a.b {
                AnonymousClass1() {
                }

                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    if (m.this.VS != null) {
                        m.this.VS.onAdClicked();
                    }
                }
            }

            AnonymousClass7() {
            }

            @Override // com.kwad.sdk.core.webview.c.kwai.a
            public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
                m.this.bD();
                int i2 = aVar.TC;
                if (aVar.II) {
                    i2 = aVar.TA ? 1 : 2;
                }
                boolean aU = com.kwad.sdk.core.response.a.a.aU(m.this.mAdInfo);
                y.b bVar = new y.b();
                com.kwad.sdk.core.webview.c.a.c cVar = aVar.TD;
                if (cVar != null && !TextUtils.isEmpty(cVar.Ts)) {
                    bVar.Ts = aVar.TD.Ts;
                }
                com.kwad.components.core.d.b.a.a(new a.C0172a(m.this.getContext()).I(m.this.mAdTemplate).b(m.this.mApkDownloadHelper).ao(m.a(m.this, aVar)).ap(i2).ao(aVar.jU).an(5).au(aVar.II).as(aU).q(m.this.eV == null ? 0L : m.this.eV.getPlayDuration()).a(bVar).aq(true).a(new a.b() { // from class: com.kwad.components.ad.feed.a.m.7.1
                    AnonymousClass1() {
                    }

                    @Override // com.kwad.components.core.d.b.a.b
                    public final void onAdClicked() {
                        if (m.this.VS != null) {
                            m.this.VS.onAdClicked();
                        }
                    }
                }));
            }
        };
    }

    public a.b getCurrentVoiceItem() {
        if (this.eY == null) {
            this.eY = new a.b(new a.c() { // from class: com.kwad.components.ad.feed.a.m.9
                AnonymousClass9() {
                }

                @Override // com.kwad.components.core.h.a.c
                public final void bs() {
                    if (!m.this.eW) {
                        if (m.this.eN != null) {
                            com.kwad.sdk.core.video.videoview.a aVar = m.this.eN;
                            m mVar = m.this;
                            aVar.setVideoSoundEnable(mVar.g(mVar.mIsAudioEnable));
                            return;
                        }
                        return;
                    }
                    if (m.this.eV == null) {
                        m mVar2 = m.this;
                        mVar2.eV = mVar2.bq();
                    }
                    IAdLivePlayModule iAdLivePlayModule = m.this.eV;
                    m mVar3 = m.this;
                    iAdLivePlayModule.setAudioEnabled(mVar3.g(mVar3.mIsAudioEnable), false);
                }
            });
        }
        return this.eY;
    }

    private ag.a getOpenNewPageListener() {
        return new ag.a() { // from class: com.kwad.components.ad.feed.a.m.6
            AnonymousClass6() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ag.a
            public final void a(com.kwad.components.core.webview.kwai.b bVar) {
                AdWebViewActivityProxy.launch(m.this.mContext, new AdWebViewActivityProxy.a.C0182a().au(bVar.title).av(bVar.url).aA(true).L(m.this.mAdTemplate).oc());
            }
        };
    }

    private ao.c getRegisterLiveListener() {
        return new ao.c() { // from class: com.kwad.components.ad.feed.a.m.2
            AnonymousClass2() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ao.c
            public final void a(ao.b bVar) {
                m.this.fI = bVar;
                if (m.this.fJ != null) {
                    m.this.fI.a(m.this.fJ);
                    m.this.fJ = null;
                }
            }
        };
    }

    private a.b getVideoPlayCallback() {
        return new a.b() { // from class: com.kwad.components.ad.feed.a.m.15
            private boolean cJ = false;

            /* renamed from: com.kwad.components.ad.feed.a.m$15$1 */
            final class AnonymousClass1 implements com.kwad.sdk.widget.c {
                AnonymousClass1() {
                }

                @Override // com.kwad.sdk.widget.c
                public final void a(View view) {
                    if (com.kwad.sdk.core.response.a.b.bn(m.this.mAdTemplate)) {
                        return;
                    }
                    m.this.y(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT);
                }

                @Override // com.kwad.sdk.widget.c
                public final void b(View view) {
                    if (com.kwad.sdk.core.response.a.b.bn(m.this.mAdTemplate) || !com.kwad.sdk.core.response.a.c.bQ(m.this.mAdTemplate)) {
                        return;
                    }
                    m.this.y(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND);
                }
            }

            /* renamed from: com.kwad.components.ad.feed.a.m$15$2 */
            final class AnonymousClass2 extends AnimatorListenerAdapter {
                AnonymousClass2() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    m.this.fS.aP(1);
                    m.this.eL.removeView(m.this.fR);
                }
            }

            AnonymousClass15() {
            }

            @Override // com.kwad.components.core.video.a.c
            public final void bt() {
                com.kwad.sdk.core.report.a.av(m.this.mAdTemplate);
                m.this.fB.aQ(9);
                m.this.eL.setVisibility(8);
                if (com.kwad.components.ad.feed.kwai.b.be() && m.this.eP == null && !m.this.fT) {
                    m.this.eP = new d(m.this.mContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    m mVar = m.this;
                    mVar.addView(mVar.eP, layoutParams);
                    m.this.eP.bu();
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j2) {
                m.this.c(j2);
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlayError(int i2, int i3) {
                com.kwad.components.ad.feed.monitor.a.a(m.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.a.a.E(m.this.mAdInfo), i2 + " " + i3, SystemClock.elapsedRealtime() - m.this.ex);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.components.core.h.a.nC().a(m.this.getCurrentVoiceItem());
                com.kwad.components.ad.feed.monitor.a.a(m.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.a.a.E(m.this.mAdInfo), null, SystemClock.elapsedRealtime() - m.this.ex);
                com.kwad.sdk.core.report.a.h(m.this.mAdTemplate);
                m.this.fB.aQ(3);
                if (m.this.eP != null && (m.this.eP.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) m.this.eP.getParent()).removeView(m.this.eP);
                    m.this.eP.bv();
                    m.this.eP = null;
                }
                if (m.this.fR == null && com.kwad.sdk.core.response.a.b.bm(m.this.mAdTemplate) && m.this.fT) {
                    m.this.fR = new e(m.this.mContext);
                    m.this.eL.addView(m.this.fR, new FrameLayout.LayoutParams(-1, -1));
                    m.this.fR.setOnViewEventListener(new com.kwad.sdk.widget.c() { // from class: com.kwad.components.ad.feed.a.m.15.1
                        AnonymousClass1() {
                        }

                        @Override // com.kwad.sdk.widget.c
                        public final void a(View view) {
                            if (com.kwad.sdk.core.response.a.b.bn(m.this.mAdTemplate)) {
                                return;
                            }
                            m.this.y(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT);
                        }

                        @Override // com.kwad.sdk.widget.c
                        public final void b(View view) {
                            if (com.kwad.sdk.core.response.a.b.bn(m.this.mAdTemplate) || !com.kwad.sdk.core.response.a.c.bQ(m.this.mAdTemplate)) {
                                return;
                            }
                            m.this.y(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND);
                        }
                    });
                    m.this.fR.a(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.a.m.15.2
                        AnonymousClass2() {
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            m.this.fS.aP(1);
                            m.this.eL.removeView(m.this.fR);
                        }
                    });
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlaying() {
                if (!this.cJ) {
                    this.cJ = true;
                    com.kwad.components.core.m.a.pb().a(m.this.mAdTemplate, System.currentTimeMillis(), 1);
                }
                com.kwad.sdk.core.video.videoview.a aVar = m.this.eN;
                m mVar = m.this;
                aVar.setVideoSoundEnable(mVar.g(mVar.mIsAudioEnable));
            }
        };
    }

    private KsAdWebView.d getWebListener() {
        return new KsAdWebView.d() { // from class: com.kwad.components.ad.feed.a.m.19
            AnonymousClass19() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                com.kwad.components.ad.feed.monitor.a.c(com.kwad.sdk.core.response.a.b.bk(m.this.mAdTemplate), System.currentTimeMillis() - m.this.mAdWebView.getLoadTime());
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i2, String str, String str2) {
                m.this.g("1", 2);
            }
        };
    }

    public void y(int i2) {
        bD();
        com.kwad.components.core.d.b.a.a(new a.C0172a(getContext()).I(this.mAdTemplate).b(this.mApkDownloadHelper).ap(1).ao(true).ao(i2).an(5).aq(false).as(true).a(new a.b() { // from class: com.kwad.components.ad.feed.a.m.16
            final /* synthetic */ int eK;

            AnonymousClass16(int i22) {
                i2 = i22;
            }

            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                m.this.aL(i2);
            }
        }));
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        if (view != this.eL) {
            if (view == this.fA) {
                a(this.eN, 25);
            }
        } else {
            if (!this.eN.isIdle()) {
                a(this.eN, 100);
                return;
            }
            com.kwad.sdk.utils.l.cv(this.mAdTemplate);
            this.eN.setKsPlayLogParam(com.kwad.sdk.contentalliance.kwai.kwai.a.ak(this.mAdTemplate));
            this.eN.start();
        }
    }

    public final void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        String url = com.kwad.sdk.core.response.a.a.bi(this.mAdInfo).getUrl();
        if (TextUtils.isEmpty(url)) {
            this.eM.setVisibility(8);
        } else {
            this.eM.setImageDrawable(null);
            KSImageLoader.loadImage(this.eM, url, this.mAdTemplate);
            this.eM.setVisibility(0);
        }
        com.kwad.sdk.core.video.videoview.a aVar = new com.kwad.sdk.core.video.videoview.a(this.mContext);
        this.eN = aVar;
        aVar.setTag(this.cI);
        String E = com.kwad.sdk.core.response.a.a.E(this.mAdInfo);
        if (TextUtils.isEmpty(E)) {
            return;
        }
        this.eN.a(new b.a(this.mAdTemplate).bs(E).bt(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.cc(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(new com.kwad.sdk.contentalliance.kwai.kwai.a(this.mAdTemplate, System.currentTimeMillis())).tR(), null);
        this.eN.setVideoSoundEnable(g(this.mIsAudioEnable));
        this.eO = new com.kwad.components.core.video.e(this.mContext, this.mAdTemplate, this.eN, ksAdVideoPlayConfig);
        this.ex = SystemClock.elapsedRealtime();
        this.eO.setVideoPlayCallback(getVideoPlayCallback());
        this.eO.setAdClickListener(this.eS);
        this.eN.setController(this.eO);
        if (this.eL.getTag() != null) {
            KSRelativeLayout kSRelativeLayout = this.eL;
            kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
            this.eL.setTag(null);
        }
        this.eL.addView(this.eN, 1);
        this.eL.setTag(this.eN);
        this.eL.setClickable(true);
        new com.kwad.sdk.widget.f(this.eL, this);
        if (this.mIsAudioEnable) {
            com.kwad.components.core.r.a.aj(this.mContext).a(this.eZ);
        }
        int i2 = this.mAdTemplate.type;
        if (i2 == 1 || i2 == 19) {
            this.fz.setVisibility(0);
            this.fA.setVisibility(0);
            this.fA.setText(com.kwad.components.ad.feed.f.b(this.mAdTemplate));
            new com.kwad.sdk.widget.f(this.fA, this);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.a.c.bQ(this.mAdTemplate)) {
            if (view == this.eL || view == this.fA) {
                a(this.eN, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND);
            }
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bC() {
        an anVar;
        b.a aVar;
        if (!this.mAdTemplate.mPvReported && (aVar = this.VS) != null) {
            aVar.onAdShow();
            com.kwad.components.ad.feed.monitor.a.a(this.mAdTemplate, 2);
        }
        if (this.fK || (anVar = this.fC) == null) {
            return;
        }
        anVar.ra();
    }

    @Override // com.kwad.components.core.widget.b
    public final void bindView(@NonNull AdTemplate adTemplate) {
        c(adTemplate);
        adTemplate.realShowType = 2;
        super.bindView(adTemplate);
        if (this.fG) {
            com.kwad.components.core.widget.b bVar = this.fL;
            if (bVar != null) {
                bVar.bindView(this.mAdTemplate);
                com.kwad.components.core.widget.b bVar2 = this.fL;
                if (bVar2 instanceof c) {
                    ((c) bVar2).a(this.dZ);
                    return;
                }
                return;
            }
            return;
        }
        if (!com.kwad.sdk.core.response.a.b.bq(this.mAdTemplate)) {
            g("0", 0);
            return;
        }
        if (!bE()) {
            e(this.mAdTemplate);
        }
        try {
            String str = this.fH;
            if (str == null || !str.equals(adTemplate.mOriginJString)) {
                if (bE()) {
                    this.mAdWebView.reload();
                } else {
                    aG();
                }
            }
        } catch (Throwable unused) {
            g("0", 0);
        }
        this.fH = adTemplate.mOriginJString;
    }

    @Override // com.kwad.components.core.widget.b
    public final void bk() {
        com.kwad.components.ad.feed.monitor.a.bh();
        this.fx = (RatioFrameLayout) findViewById(R.id.ksad_container);
        this.eL = (KSRelativeLayout) findViewById(R.id.ksad_video_container);
        this.fz = (LinearLayout) findViewById(R.id.ksad_video_immerse_text_container);
        this.fA = (TextView) findViewById(R.id.ksad_video_immerse_text);
        this.eM = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.eX = findViewById(R.id.ksad_live_end_bg_mantle);
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_webview;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0080, code lost:
    
        if ((r0 * r5) < r7) goto L55;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            int r0 = r10.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            boolean r1 = com.kwad.sdk.core.config.d.uI()
            if (r1 == 0) goto L8d
            T extends com.kwad.sdk.core.response.model.AdTemplate r1 = r9.mAdTemplate
            boolean r1 = com.kwad.sdk.core.response.a.c.bQ(r1)
            if (r1 != 0) goto L16
            goto L8d
        L16:
            T extends com.kwad.sdk.core.response.model.AdTemplate r1 = r9.mAdTemplate
            com.kwad.sdk.core.response.model.FeedSlideConf r1 = com.kwad.sdk.core.response.a.b.aK(r1)
            if (r1 != 0) goto L23
            boolean r10 = super.onInterceptTouchEvent(r10)
            return r10
        L23:
            r9.a(r10)
            r2 = 2
            if (r0 == r2) goto L2c
            r2 = 3
            if (r0 != r2) goto L88
        L2c:
            com.kwad.sdk.core.webview.KsAdWebView r0 = r9.mAdWebView
            if (r0 == 0) goto L88
            boolean r0 = r9.fK
            if (r0 != 0) goto L88
            float r0 = r10.getX()
            float r2 = r9.fM
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L88
            com.kwad.sdk.core.webview.KsAdWebView r0 = r9.mAdWebView
            r2 = 1
            r0.requestDisallowInterceptTouchEvent(r2)
            float r0 = r10.getX()
            float r2 = r9.fM
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            float r2 = r10.getY()
            float r3 = r9.fN
            float r2 = r2 - r3
            float r2 = java.lang.Math.abs(r2)
            int r3 = r1.maxRange
            double r3 = (double) r3
            double r3 = java.lang.Math.tan(r3)
            double r5 = (double) r0
            java.lang.Double.isNaN(r5)
            double r3 = r3 * r5
            double r7 = (double) r2
            int r0 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r0 < 0) goto L82
            int r0 = r1.minRange
            double r0 = (double) r0
            double r0 = java.lang.Math.tan(r0)
            java.lang.Double.isNaN(r5)
            double r0 = r0 * r5
            int r2 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r2 >= 0) goto L88
        L82:
            com.kwad.sdk.core.webview.KsAdWebView r0 = r9.mAdWebView
            r1 = 0
            r0.requestDisallowInterceptTouchEvent(r1)
        L88:
            boolean r10 = super.onInterceptTouchEvent(r10)
            return r10
        L8d:
            boolean r10 = super.onInterceptTouchEvent(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.feed.a.m.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.g.c
    public final void onPageInvisible() {
        super.onPageInvisible();
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onPause();
        }
        com.kwad.components.core.h.a.nC().c(this.eY);
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.g.c
    public final void onPageVisible() {
        super.onPageVisible();
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
    public final void onViewAttached() {
        super.onViewAttached();
        if (this.ej != null) {
            com.kwad.components.ad.feed.d.a(com.kwad.sdk.core.response.a.b.bo(this.mAdTemplate), this.mContext, this.ej);
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void onViewDetached() {
        super.onViewDetached();
        this.mHandler.removeCallbacksAndMessages(null);
        com.kwad.sdk.utils.l.cu(this.mAdTemplate);
        d.b bVar = this.ej;
        if (bVar != null) {
            com.kwad.components.ad.feed.d.a(bVar);
        }
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
        this.fI = null;
        this.fJ = null;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        IAdLivePlayModule iAdLivePlayModule;
        ViewGroup viewGroup;
        super.onWindowFocusChanged(z);
        if (!z) {
            IAdLiveOfflineView iAdLiveOfflineView = this.eT;
            if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || (iAdLivePlayModule = this.eV) == null) {
                return;
            }
            iAdLivePlayModule.onPause();
            return;
        }
        if (bp()) {
            return;
        }
        com.kwad.sdk.core.video.videoview.a aVar = this.eN;
        if (aVar != null && (viewGroup = (ViewGroup) aVar.getParent()) != this.eL) {
            viewGroup.removeView(this.eN);
            if (this.eL.getTag() != null) {
                KSRelativeLayout kSRelativeLayout = this.eL;
                kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                this.eL.setTag(null);
            }
            this.eL.addView(this.eN);
            this.eL.setTag(this.eN);
            this.eN.setVideoSoundEnable(this.mIsAudioEnable);
            this.eO.setVideoPlayCallback(getVideoPlayCallback());
            this.eO.setAdClickListener(this.eS);
            this.eO.getAdTemplate().mAdWebVideoPageShowing = false;
            this.eO.qx();
            this.eO.setAutoRelease(true);
        }
        AdVideoPlayerViewCache.getInstance().remove(com.kwad.sdk.core.response.a.a.E(this.mAdInfo));
    }

    @Override // com.kwad.components.core.widget.b
    public final void setMargin(int i2) {
    }

    public final void setPreloadListener(a aVar) {
        a aVar2 = this.fP;
        if (aVar2 != null) {
            aVar2.c(this.cW == 1 ? 2 : 1, "");
        }
        this.fP = aVar;
    }

    public final void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        com.kwad.components.core.video.e eVar;
        IAdLivePlayModule iAdLivePlayModule;
        this.dZ = ksAdVideoPlayConfig;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                boolean isVideoSoundEnable = kSAdVideoPlayConfigImpl.isVideoSoundEnable();
                this.mIsAudioEnable = isVideoSoundEnable;
                this.mAdTemplate.mIsAudioEnable = isVideoSoundEnable;
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
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() == 0 || (eVar = this.eO) == null) {
                return;
            }
            eVar.setDataAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
        }
    }

    public final void setWidth(int i2) {
        if (i2 <= 0) {
            i2 = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        this.mWidth = i2;
    }
}
