package com.sigmob.sdk.newInterstitial;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.czhj.sdk.common.utils.ViewUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.common.d0;
import com.sigmob.sdk.base.common.z;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.InterstitialSetting;
import com.sigmob.sdk.base.views.q;
import com.sigmob.sdk.newInterstitial.NewInterstitialHeaderView;
import com.sigmob.windad.natives.WindNativeAdData;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class h extends com.sigmob.sdk.videoAd.c {
    public int A;
    public Handler B;
    public boolean C;
    public boolean D;
    public q E;
    public boolean F;
    public boolean G;
    public boolean H;
    public com.sigmob.sdk.nativead.a I;
    public View.OnClickListener J;

    /* renamed from: i */
    public final BaseAdUnit f20215i;

    /* renamed from: j */
    public com.sigmob.sdk.base.common.i f20216j;

    /* renamed from: k */
    public com.sigmob.sdk.newInterstitial.f f20217k;

    /* renamed from: l */
    public RelativeLayout f20218l;

    /* renamed from: m */
    public List<String> f20219m;

    /* renamed from: n */
    public List<String> f20220n;

    /* renamed from: o */
    public com.sigmob.sdk.videoplayer.a f20221o;

    /* renamed from: p */
    public ImageView f20222p;

    /* renamed from: q */
    public com.sigmob.sdk.newInterstitial.g f20223q;

    /* renamed from: r */
    public InterstitialSetting f20224r;

    /* renamed from: s */
    public boolean f20225s;

    /* renamed from: t */
    public ViewGroup f20226t;

    /* renamed from: u */
    public View f20227u;

    /* renamed from: v */
    public NewInterstitialHeaderView f20228v;

    /* renamed from: w */
    public SigAdInfoView f20229w;

    /* renamed from: x */
    public int f20230x;

    /* renamed from: y */
    public String f20231y;

    /* renamed from: z */
    public long f20232z;

    public class a implements q.g {

        /* renamed from: a */
        public final /* synthetic */ com.sigmob.sdk.base.a f20233a;

        public a(com.sigmob.sdk.base.a aVar) {
            this.f20233a = aVar;
        }

        @Override // com.sigmob.sdk.base.views.q.g
        public void a(String str, String str2) {
            if (h.this.f20215i != null) {
                h.this.f20215i.getClickCommon().is_final_click = true;
                h.this.f20215i.getAdConfig().b(this.f20233a, str, str2, true);
            }
        }

        @Override // com.sigmob.sdk.base.views.q.g
        public void b() {
            if (h.this.f20221o != null) {
                h.this.f20221o.g();
            }
            if (h.this.r() != null) {
                h.this.r().a(com.sigmob.sdk.base.common.a.f17653f, 0);
            }
        }

        @Override // com.sigmob.sdk.base.views.q.g
        public void a() {
            if (h.this.f20221o != null) {
                h.this.f20221o.h();
            }
            if (h.this.E != null) {
                h.this.E.dismiss();
                h.this.E.b();
                h.this.E = null;
            }
            h.this.F = false;
            if (h.this.r() != null) {
                h.this.r().a(com.sigmob.sdk.base.common.a.f17654g, 0);
            }
        }
    }

    public class b implements com.sigmob.sdk.videoplayer.l {

        /* renamed from: a */
        public boolean f20235a;

        public class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ com.sigmob.sdk.videoplayer.e f20237a;

            public a(com.sigmob.sdk.videoplayer.e eVar) {
                this.f20237a = eVar;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // java.lang.Runnable
            public void run() {
                SigmobLog.i("video player state change " + this.f20237a);
                switch (f.f20243a[this.f20237a.ordinal()]) {
                    case 1:
                        if (h.this.f20221o != null) {
                            h hVar = h.this;
                            hVar.f20230x = (int) hVar.f20221o.getDuration();
                            if (h.this.f20230x == 0) {
                                h hVar2 = h.this;
                                hVar2.f20230x = hVar2.f20215i.getDuration();
                            }
                            h.this.f20215i.getVideoCommon().video_time = (int) (h.this.f20230x / 1000.0f);
                        }
                        h.this.f20215i.getVideoCommon().is_first = 1;
                        h.this.f20215i.getVideoCommon().type = 1;
                        h.this.f20215i.getVideoCommon().scene = 1;
                        h.this.f20215i.getVideoCommon().is_auto_play = 1;
                        h.this.f20215i.getVideoCommon().is_last = 0;
                        h.this.f20215i.getVideoCommon().end_time = 0;
                        h hVar3 = h.this;
                        hVar3.C = hVar3.f20215i.getIsMute() != 0;
                        if (h.this.f20221o != null) {
                            h.this.f20221o.setMute(h.this.C);
                            h.this.f20228v.setSoundStatus(h.this.C);
                            h.this.f20228v.showSoundIcon();
                            break;
                        }
                        break;
                    case 2:
                        if (b.this.f20235a) {
                            h.this.f20215i.getVideoCommon().type = 2;
                        }
                        b.this.f20235a = false;
                        if (h.this.r() != null) {
                            h.this.r().a("video_start", 0);
                        }
                        if (h.this.f20221o != null) {
                            h.this.f20215i.getVideoCommon().begin_time = (int) (h.this.f20221o.getCurrentPositionWhenPlaying() / 1000.0f);
                            break;
                        }
                        break;
                    case 3:
                        if (h.this.f20221o != null) {
                            b0.a("video", h.this.f20221o.getErrorCode(), h.this.f20221o.getErrorMessage(), h.this.f20215i);
                        }
                        h.this.C();
                        break;
                    case 4:
                        if (h.this.r() != null) {
                            h.this.r().a("complete", 0);
                        }
                        if (!h.this.f20215i.hasEndCard()) {
                            h.this.f20215i.getVideoCommon().type = 3;
                            if (h.this.f20221o == null) {
                            }
                            h.this.f20221o.h();
                            break;
                        }
                        h.this.C();
                        break;
                    case 5:
                        h.this.C();
                        break;
                    case 6:
                        h.this.B();
                        if (h.this.f20221o != null) {
                            h.this.f20221o.g();
                            break;
                        }
                        break;
                    case 7:
                        h.this.q();
                        if (h.this.f20221o == null) {
                        }
                        h.this.f20221o.h();
                        break;
                    case 8:
                        if (h.this.r() != null) {
                            h.this.r().a("video_pause", 0);
                        }
                        b.this.f20235a = true;
                        break;
                }
            }
        }

        public b() {
        }

        @Override // com.sigmob.sdk.videoplayer.l
        public void a(long j10, long j11) {
            SigmobLog.d("position " + j10 + " duration " + j11);
            for (com.sigmob.sdk.videoAd.f fVar : h.this.f20216j.a(j10, (long) h.this.f20230x)) {
                h.this.b(fVar.getEvent());
                fVar.setTracked();
            }
            if (j10 > h.this.f20230x) {
                h.this.C();
            }
        }

        @Override // com.sigmob.sdk.videoplayer.l
        public void a(com.sigmob.sdk.videoplayer.e eVar) {
            if (h.this.f20221o == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new a(eVar));
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.B.removeCallbacksAndMessages(null);
        }
    }

    public class d implements View.OnClickListener {

        public class a implements WindNativeAdData.DislikeInteractionCallback {
            public a() {
            }

            @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
            public void onCancel() {
                h.this.n();
                if (h.this.I != null) {
                    h.this.I.dismiss();
                    h.this.I.b();
                    h.this.I = null;
                }
            }

            @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
            public void onSelected(int i10, String str, boolean z10) {
                h.this.n();
                if (h.this.I != null) {
                    h.this.I.dismiss();
                    h.this.I.b();
                    h.this.I = null;
                }
            }

            @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
            public void onShow() {
                h.this.m();
            }
        }

        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity f10 = h.this.f();
            if (f10 == null || h.this.f20215i == null) {
                return;
            }
            h.this.I = new com.sigmob.sdk.nativead.a(f10, h.this.f20215i);
            if (h.this.I != null) {
                h.this.I.a();
            }
            h.this.I.a(new a());
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.x();
        }
    }

    public static /* synthetic */ class f {

        /* renamed from: a */
        public static final /* synthetic */ int[] f20243a;

        static {
            int[] iArr = new int[com.sigmob.sdk.videoplayer.e.values().length];
            f20243a = iArr;
            try {
                iArr[com.sigmob.sdk.videoplayer.e.STATE_PREPARED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20243a[com.sigmob.sdk.videoplayer.e.STATE_PLAYING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20243a[com.sigmob.sdk.videoplayer.e.STATE_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20243a[com.sigmob.sdk.videoplayer.e.STATE_AUTO_COMPLETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f20243a[com.sigmob.sdk.videoplayer.e.STATE_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f20243a[com.sigmob.sdk.videoplayer.e.STATE_BUFFERING_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f20243a[com.sigmob.sdk.videoplayer.e.STATE_BUFFERING_END.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f20243a[com.sigmob.sdk.videoplayer.e.STATE_PAUSE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public class g implements q.g {
        public g() {
        }

        @Override // com.sigmob.sdk.base.views.q.g
        public void a(String str, String str2) {
            h.this.f20215i.getClickCommon().click_area = "appinfo";
            h.this.f20215i.getClickCommon().is_final_click = true;
            h.this.a(IntentActions.ACTION_INTERSTITIAL_CLICK);
            if (h.this.r() != null) {
                h.this.r().a("click", 0);
            }
        }

        @Override // com.sigmob.sdk.base.views.q.g
        public void b() {
            h.this.F = true;
            if (h.this.f20221o != null) {
                h.this.f20221o.g();
            }
        }

        @Override // com.sigmob.sdk.base.views.q.g
        public void a() {
            h.this.F = false;
            if (h.this.f20221o != null) {
                h.this.f20221o.h();
            }
        }
    }

    /* renamed from: com.sigmob.sdk.newInterstitial.h$h */
    public class RunnableC0618h implements Runnable {
        public RunnableC0618h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.w();
        }
    }

    public class i implements View.OnTouchListener {

        /* renamed from: a */
        public MotionEvent f20246a;

        /* renamed from: b */
        public final /* synthetic */ com.sigmob.sdk.base.a f20247b;

        public i(com.sigmob.sdk.base.a aVar) {
            this.f20247b = aVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            String str;
            if (motionEvent.getAction() == 0) {
                this.f20246a = motionEvent;
            } else if (motionEvent.getAction() == 1) {
                SigMacroCommon macroCommon = h.this.f20215i.getMacroCommon();
                if (macroCommon != null) {
                    macroCommon.updateClickMarco(this.f20246a, motionEvent, false);
                    str = macroCommon.getCoordinate();
                } else {
                    str = "";
                }
                h.this.f20215i.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
                h.this.f20215i.getClickCommon().click_scene = this.f20247b == com.sigmob.sdk.base.a.AD ? "ad" : "endcard";
                h.this.f20215i.getClickCommon().is_final_click = h.this.f20215i.noHasDownloadDialog();
                h.this.f20215i.getAdConfig().a(this.f20247b, str, true);
            }
            return false;
        }
    }

    public class j implements z {
        public j() {
        }

        @Override // com.sigmob.sdk.base.common.z
        public void a(boolean z10, com.sigmob.sdk.base.a aVar) {
            if (h.this.f20215i.getClickCommon().is_final_click) {
                h.this.a(IntentActions.ACTION_INTERSTITIAL_CLICK);
            }
            if (h.this.r() != null) {
                h.this.r().a("click", 0);
            }
        }
    }

    public class k implements NewInterstitialHeaderView.b {
        public k() {
        }

        @Override // com.sigmob.sdk.newInterstitial.NewInterstitialHeaderView.b
        public void a() {
            h.this.w();
            if (h.this.r() != null) {
                h.this.r().a("show_close", 0);
            }
        }

        @Override // com.sigmob.sdk.newInterstitial.NewInterstitialHeaderView.b
        public void b() {
            h.this.w();
            if (h.this.r() != null) {
                h.this.r().a("show_skip", 0);
            }
        }
    }

    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.C = !r2.C;
            h.this.f20228v.setSoundStatus(h.this.C);
            if (h.this.f20221o != null) {
                h.this.f20221o.setMute(h.this.C);
            }
        }
    }

    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.x();
        }
    }

    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.y();
        }
    }

    public class o implements View.OnTouchListener {

        /* renamed from: a */
        public MotionEvent f20254a;

        /* renamed from: b */
        public final /* synthetic */ com.sigmob.sdk.base.a f20255b;

        public o(com.sigmob.sdk.base.a aVar) {
            this.f20255b = aVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.f20254a = motionEvent;
            } else if (motionEvent.getAction() == 1) {
                SigMacroCommon macroCommon = h.this.f20215i.getMacroCommon();
                if (macroCommon != null) {
                    macroCommon.updateClickMarco(this.f20254a, motionEvent, false);
                }
                h.this.a(this.f20255b);
            }
            return true;
        }
    }

    public h(Activity activity, BaseAdUnit baseAdUnit, Bundle bundle, Bundle bundle2, String str, com.sigmob.sdk.base.common.k kVar) throws IllegalStateException {
        super(activity, str, kVar);
        this.f20219m = new ArrayList();
        this.f20220n = new ArrayList();
        this.f20225s = false;
        this.J = new d();
        this.f20215i = baseAdUnit;
        this.B = new Handler(Looper.getMainLooper());
        com.sigmob.sdk.base.common.i adConfig = baseAdUnit.getAdConfig();
        this.f20216j = adConfig;
        adConfig.a(f(), baseAdUnit, new g());
        g().a(7);
        f().requestWindowFeature(1);
        f().getWindow().addFlags(1024);
        this.f20225s = baseAdUnit.getTemplateType() == 0;
        b(activity, 7, bundle);
    }

    public final void A() {
        View privacyLl;
        if (this.D) {
            return;
        }
        com.sigmob.sdk.videoplayer.a aVar = this.f20221o;
        if (aVar != null) {
            aVar.f();
            this.f20221o = null;
        }
        this.D = true;
        if (this.f20223q == null) {
            com.sigmob.sdk.newInterstitial.g gVar = new com.sigmob.sdk.newInterstitial.g(this.f17899b);
            this.f20223q = gVar;
            gVar.a(this.J);
            Button cTAButton = this.f20223q.getCTAButton();
            com.sigmob.sdk.base.a aVar2 = com.sigmob.sdk.base.a.ENDCARD;
            a(cTAButton, aVar2);
            this.f20223q.a(this.f20215i.getIconUrl(), this.f20215i.getEndCardImageUrl(), this.f20215i.getAppName(), this.f20215i.getCreativeTitle(), this.f20215i.getCTAText());
            SigAdPrivacyInfoView adPrivacyInfo = this.f20223q.getAdPrivacyInfo();
            if (adPrivacyInfo != null && (privacyLl = adPrivacyInfo.getPrivacyLl()) != null) {
                privacyLl.setBackgroundColor(0);
                a(adPrivacyInfo, aVar2);
            }
            this.f20223q.getCloseButton().setOnClickListener(new e());
        }
        this.f20228v.hideSoundIcon();
        ViewUtil.removeFromParent(this.f20217k);
        i().addView(this.f20223q, new ViewGroup.LayoutParams(-1, -1));
    }

    public final void B() {
        RelativeLayout relativeLayout = this.f20218l;
        if (relativeLayout == null || relativeLayout.getVisibility() == 0) {
            return;
        }
        this.f20232z = System.currentTimeMillis();
        this.f20218l.setVisibility(0);
        this.f20231y = "loading";
        int i10 = this.A + 1;
        this.A = i10;
        if (i10 > 2) {
            return;
        }
        this.B.postDelayed(new c(), 5000L);
    }

    public void C() {
        q();
        A();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Configuration configuration) {
    }

    @Override // com.sigmob.sdk.base.common.j
    public void j() {
    }

    @Override // com.sigmob.sdk.base.common.j
    public void o() {
    }

    @SuppressLint({"DefaultLocale"})
    public final void q() {
        RelativeLayout relativeLayout = this.f20218l;
        if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
            return;
        }
        this.f20219m.add(String.format("%d", Long.valueOf(System.currentTimeMillis() - this.f20232z)));
        this.f20220n.add(String.format("%.2f", Float.valueOf(((int) this.f20221o.getCurrentPositionWhenPlaying()) / 1000.0f)));
        this.f20231y = "play";
        this.B.removeCallbacksAndMessages(null);
        this.f20218l.setVisibility(4);
    }

    public d0 r() {
        BaseAdUnit baseAdUnit = this.f20215i;
        if (baseAdUnit == null) {
            return null;
        }
        d0 sessionManager = baseAdUnit.getSessionManager();
        if (sessionManager != null) {
            return sessionManager;
        }
        com.sigmob.sdk.newInterstitial.c cVar = new com.sigmob.sdk.newInterstitial.c();
        cVar.a(this.f20215i);
        return cVar;
    }

    public final com.sigmob.sdk.videoplayer.a s() {
        if (this.f20221o == null) {
            com.sigmob.sdk.videoplayer.a aVar = new com.sigmob.sdk.videoplayer.a(h());
            this.f20221o = aVar;
            aVar.setVideoPlayerStatusListener(new b());
            v();
        }
        this.f20221o.setUp(this.f20215i.getProxyVideoUrl());
        return this.f20221o;
    }

    public final void t() {
        SigAdInfoView adInfView = this.f20217k.getAdInfView();
        if (adInfView != null) {
            adInfView.setAppInfoView(this.f20215i.getIconUrl(), this.f20215i.getAppName(), this.f20215i.getCreativeTitle());
            SigAdPrivacyInfoView adPrivacyInfo = adInfView.getAdPrivacyInfo();
            if (adPrivacyInfo != null) {
                adPrivacyInfo.getPrivacyAdText().setTextColor(-1);
                a(adInfView.getAdPrivacyInfo(), com.sigmob.sdk.base.a.AD);
            }
        }
    }

    public final void u() {
        NewInterstitialHeaderView headerView = this.f20217k.getHeaderView();
        this.f20228v = headerView;
        headerView.showFeedback(this.f20221o != null, this.J);
        this.f20228v.setAdHeaderViewStateListener(new k());
        this.f20228v.setSoundClickListener(new l());
        this.f20228v.setCloseClickListener(new m());
        this.f20228v.setSkipClickListener(new n());
        InterstitialSetting interstitialSetting = this.f20224r;
        if (interstitialSetting != null) {
            this.f20228v.startAdTimer(this.f20224r.show_skip_seconds.intValue(), interstitialSetting.skip_close_ad.booleanValue() || !this.f20215i.hasEndCard());
        }
    }

    public final void v() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.sigmob.sdk.videoAd.f("play_quarter", 0.25f));
        arrayList.add(new com.sigmob.sdk.videoAd.f("play_two_quarters", 0.5f));
        arrayList.add(new com.sigmob.sdk.videoAd.f("play_three_quarters", 0.75f));
        this.f20216j.a(arrayList);
    }

    public final void w() {
        if (this.H) {
            return;
        }
        this.H = true;
        if (r() != null) {
            r().a("charge", 0);
        }
    }

    public final void x() {
        g().a();
    }

    public final void y() {
        if (r() != null) {
            r().a("skip", 0);
        }
        A();
    }

    public final void z() {
        Context context;
        String str;
        this.f20217k = new com.sigmob.sdk.newInterstitial.f(this.f17899b);
        int screenHeightAsIntDips = Dips.screenHeightAsIntDips(this.f17899b);
        int screenWidthAsIntDips = Dips.screenWidthAsIntDips(this.f17899b);
        if (this.f20225s) {
            context = this.f17899b;
            str = "sig_new_interstitial_full_layout";
        } else if (screenHeightAsIntDips * 0.8f <= 553.0f || screenWidthAsIntDips * 0.8f <= 287.0f) {
            context = this.f17899b;
            str = "sig_new_interstitial_small_layout";
        } else {
            context = this.f17899b;
            str = "sig_new_interstitial_layout";
        }
        this.f20217k.a(ResourceUtil.getLayoutId(context, str));
        a(IntentActions.ACTION_INTERSTITIAL_VOPEN);
        this.f20226t = this.f20217k.getMainAdContainer();
        this.f20224r = this.f20215i.getNewInterstitialSetting();
        i().addView(this.f20217k, new ViewGroup.LayoutParams(-1, -1));
        a(this.f20226t);
        t();
        u();
        a(this.f20217k.getCTAButton(), com.sigmob.sdk.base.a.AD);
        if (this.f20224r != null) {
            i().postDelayed(new RunnableC0618h(), this.f20224r.charge_time.intValue() * 1000);
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Bundle bundle) {
    }

    @Override // com.sigmob.sdk.videoAd.c, com.sigmob.sdk.base.common.j
    public void k() {
        super.k();
        p();
        z();
        if (r() != null) {
            r().a("start", 0);
        }
        a(IntentActions.ACTION_INTERSTITIAL_SHOW);
    }

    @Override // com.sigmob.sdk.base.common.j
    public void l() {
        a(IntentActions.ACTION_INTERSTITIAL_DISMISS);
        com.sigmob.sdk.videoplayer.a aVar = this.f20221o;
        if (aVar != null) {
            aVar.f();
            this.f20221o = null;
        }
        q qVar = this.E;
        if (qVar != null) {
            qVar.dismiss();
            this.E.b();
            this.E = null;
        }
        com.sigmob.sdk.nativead.a aVar2 = this.I;
        if (aVar2 != null) {
            aVar2.dismiss();
            this.I.b();
            this.I = null;
        }
        this.f20215i.destroy();
        super.l();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void m() {
        com.sigmob.sdk.videoplayer.a aVar = this.f20221o;
        if (aVar == null || this.F) {
            return;
        }
        aVar.g();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void n() {
        com.sigmob.sdk.videoplayer.a aVar = this.f20221o;
        if (aVar == null || this.F) {
            return;
        }
        aVar.h();
    }

    public void b(String str) {
        if (r() != null) {
            r().a(str, (int) this.f20221o.getCurrentPositionWhenPlaying());
        }
    }

    public final void a(Button button, com.sigmob.sdk.base.a aVar) {
        button.setText(this.f20215i.getCTAText());
        button.setOnTouchListener(new i(aVar));
        this.f20215i.getAdConfig().a(new j());
    }

    public final void a(ViewGroup viewGroup) {
        int templateId = this.f20215i.getTemplateId();
        if (templateId == 6001) {
            com.sigmob.sdk.videoplayer.a s10 = s();
            this.f20221o = s10;
            viewGroup.addView(s10, new ViewGroup.LayoutParams(-1, -1));
            this.f20221o.r();
            return;
        }
        if (templateId != 6002) {
            return;
        }
        ImageView imageView = new ImageView(this.f17899b);
        this.f20222p = imageView;
        viewGroup.addView(imageView, new ViewGroup.LayoutParams(-1, -1));
        com.sigmob.sdk.base.common.h.o().load(this.f20215i.getMainImage()).into(this.f20222p);
    }

    public final void a(SigAdPrivacyInfoView sigAdPrivacyInfoView, com.sigmob.sdk.base.a aVar) {
        if (sigAdPrivacyInfoView != null) {
            sigAdPrivacyInfoView.a(this.f20215i.getAd_source_logo(), this.f20215i.getadPrivacy() != null);
            sigAdPrivacyInfoView.setOnTouchListener(new o(aVar));
        }
    }

    public final boolean a(com.sigmob.sdk.base.a aVar) {
        try {
            Activity f10 = f();
            if (this.E == null && f10 != null) {
                q qVar = new q(f(), this.f20215i);
                this.E = qVar;
                qVar.a(new a(aVar));
            }
            q qVar2 = this.E;
            if (qVar2 == null || !qVar2.e() || this.F) {
                return false;
            }
            this.f20215i.getClickCommon().click_area = "appinfo";
            this.f20215i.getClickCommon().click_scene = aVar == com.sigmob.sdk.base.a.AD ? "ad" : "endcard";
            this.f20215i.getClickCommon().is_final_click = false;
            if (r() != null) {
                r().a("click", 0);
            }
            this.E.show();
            this.F = true;
            return true;
        } catch (Exception e10) {
            SigmobLog.e("openFourElements fail:" + e10.getMessage());
            return false;
        }
    }
}
