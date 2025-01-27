package com.martian.mibook.application;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import b8.e;
import b8.j;
import ba.l;
import ba.m;
import com.martian.ads.ad.AdConfig;
import com.martian.ads.ad.DefaultAd;
import com.martian.ads.ad.GroMoreAd;
import com.martian.ads.data.AdSlots;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.martian.apptask.data.ComplianceInfo;
import com.martian.apptask.data.ViewWrapper;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.application.BannerAdManager;
import com.martian.mibook.databinding.AdBannerComplianceInfoViewBinding;
import com.martian.mibook.databinding.ReadingAdsBookBinding;
import com.martian.mibook.databinding.ReadingBannerBinding;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.mvvm.read.adapter.ReaderSlidingAdapter;
import com.martian.mibook.ui.BannerAdFrameLayout;
import com.martian.mibook.ui.reader.ReaderThemeButton;
import i8.g;
import je.i;
import l9.t0;
import ya.e0;

/* loaded from: classes3.dex */
public class BannerAdManager extends com.martian.mibook.application.b {
    public static final int X = 1200000;
    public static final int Y = 3000;
    public static final int Z = 60000;

    /* renamed from: a0 */
    public static final int f13194a0 = ConfigSingleton.i(64.0f);
    public Status G;
    public final String H;
    public final int I;
    public int J;
    public int K;
    public int L;
    public final int M;
    public final int N;
    public boolean O;
    public Handler P;
    public Handler Q;
    public ReaderSlidingAdapter R;
    public ViewStub S;
    public ReadingBannerBinding T;
    public AppTaskList U;
    public final Runnable V;
    public final Runnable W;

    public enum Status {
        IDLE,
        LOADING,
        SHOW
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BannerAdManager.this.J > 0) {
                BannerAdManager bannerAdManager = BannerAdManager.this;
                bannerAdManager.H0(bannerAdManager.J);
                BannerAdManager.this.J = 0;
                return;
            }
            if (BannerAdManager.this.R0() && !BannerAdManager.this.O) {
                BannerAdManager.this.H0(3000);
                return;
            }
            BannerAdManager bannerAdManager2 = BannerAdManager.this;
            bannerAdManager2.H0(bannerAdManager2.L);
            if (BannerAdManager.this.P0()) {
                return;
            }
            if (BannerAdManager.this.G().isEmpty()) {
                BannerAdManager.this.J0(0);
            } else if (!BannerAdManager.this.Q0() || BannerAdManager.this.O) {
                BannerAdManager.this.i1();
            }
        }
    }

    public class b extends d8.b {

        /* renamed from: a */
        public final /* synthetic */ GroMoreAd.AdViewHolder f13196a;

        /* renamed from: b */
        public final /* synthetic */ AppTask f13197b;

        /* renamed from: c */
        public final /* synthetic */ boolean f13198c;

        /* renamed from: d */
        public final /* synthetic */ Activity f13199d;

        public b(GroMoreAd.AdViewHolder adViewHolder, AppTask appTask, boolean z10, Activity activity) {
            this.f13196a = adViewHolder;
            this.f13197b = appTask;
            this.f13198c = z10;
            this.f13199d = activity;
        }

        @Override // d8.b, d8.a
        public void b(AdConfig adConfig) {
            if (MiConfigSingleton.b2().B0()) {
                this.f13196a.mAdLogoDesc.setText(String.valueOf(this.f13197b.getEcpm()));
            }
        }

        @Override // d8.b, d8.a
        public void d(AdConfig adConfig) {
            BannerAdManager.this.j1();
        }

        @Override // d8.b, d8.a
        public void l(AdConfig adConfig) {
            BannerAdManager.this.d0();
            if (this.f13198c) {
                ac.a.n(this.f13199d, "底通-误点-点击");
            }
            BannerAdManager.this.J();
        }
    }

    public class c implements xb.b {

        /* renamed from: a */
        public final /* synthetic */ Activity f13201a;

        /* renamed from: b */
        public final /* synthetic */ TYBookItem f13202b;

        public c(Activity activity, TYBookItem tYBookItem) {
            this.f13201a = activity;
            this.f13202b = tYBookItem;
        }

        @Override // xb.b
        public void a(Book book) {
            if (book == null) {
                t0.b(this.f13201a, "加入失败，请重试");
                return;
            }
            MiConfigSingleton.b2().M1().g(this.f13201a, book);
            t0.b(this.f13201a, "已加入书架");
            MiConfigSingleton.b2().V1().g(3, book.getSourceName(), book.getSourceId(), this.f13202b.getRecommendId(), this.f13202b.getRecommend(), "广告加书架");
        }

        @Override // xb.b
        public void onLoading(boolean z10) {
        }

        @Override // xb.b
        public void onResultError(x8.c cVar) {
            t0.b(this.f13201a, "加入失败，请重试");
        }
    }

    public BannerAdManager(Activity activity, String str, ViewStub viewStub, ReaderSlidingAdapter readerSlidingAdapter, boolean z10, j jVar) {
        super(activity, str, jVar, z10);
        this.G = Status.IDLE;
        this.H = "AD_BLOCK";
        this.V = new a();
        this.W = new Runnable() { // from class: ya.b0
            public /* synthetic */ b0() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                BannerAdManager.this.R();
            }
        };
        this.S = viewStub;
        this.R = readerSlidingAdapter;
        this.I = MiConfigSingleton.b2().c2().getBannerOptimizeFirstEcpm();
        this.L = MiConfigSingleton.b2().c2().getBannerAdInterval().intValue() * 1000;
        this.M = MiConfigSingleton.b2().c2().getBannerOptimizeBaseEcpm();
        this.N = MiConfigSingleton.b2().c2().getBannerMaxExtraDelay() * 1000;
        this.P = e.s().r();
        this.Q = new Handler(activity.getMainLooper());
    }

    private void I0() {
        com.martian.mibook.application.a.G(this.U);
        this.U = null;
    }

    public static /* synthetic */ void T0(Activity activity, ComplianceInfo complianceInfo, View view) {
        MiWebViewActivity.startWebViewActivity(activity, complianceInfo.getAppPermissionUrl());
    }

    public static /* synthetic */ void U0(Activity activity, ComplianceInfo complianceInfo, View view) {
        MiWebViewActivity.startWebViewActivity(activity, complianceInfo.getAppPrivacyUrl());
    }

    public static /* synthetic */ void V0(Activity activity, ComplianceInfo complianceInfo, View view) {
        MiWebViewActivity.startWebViewActivity(activity, complianceInfo.getAppFunctionDescUrl());
    }

    public static /* synthetic */ void a1(TYBookItem tYBookItem, Activity activity, View view) {
        String deeplink = tYBookItem.getDeeplink();
        if (l.q(deeplink) || !g.h(activity, deeplink)) {
            ac.a.s(activity, "Banner-阅读");
            i.R(activity, tYBookItem);
        } else {
            ac.a.s(activity, "Banner-deeplink");
            g.z(activity, deeplink);
        }
    }

    @Override // com.martian.mibook.application.b
    public int A() {
        return MiConfigSingleton.b2().c2().getMisClickExtraBlockSeconds() * 1000;
    }

    @Override // com.martian.mibook.application.b
    public int B() {
        return MiConfigSingleton.b2().c2().getBannerKsMisClickBaseEcpmV2();
    }

    @Override // com.martian.mibook.application.b
    public int C() {
        return MiConfigSingleton.b2().c2().getBannerMisClickPlatform();
    }

    @Override // com.martian.mibook.application.b
    public int D() {
        return MiConfigSingleton.b2().c2().getBannerYlhMisClickBaseEcpmV2();
    }

    @Override // com.martian.mibook.application.b
    public String E() {
        return e0.Q;
    }

    @Override // com.martian.mibook.application.b
    public String F() {
        return e0.Q;
    }

    public boolean G0() {
        return !G().isEmpty();
    }

    public final void H0(int i10) {
        if (this.P == null) {
            return;
        }
        c1();
        this.P.postDelayed(this.V, i10);
    }

    public final void J0(int i10) {
        Handler handler = this.P;
        if (handler == null) {
            return;
        }
        if (i10 > 0) {
            handler.postDelayed(this.W, i10);
        } else {
            handler.post(this.W);
        }
    }

    public AppTask K0() {
        AppTask appTask = new AppTask();
        appTask.source = "AD_BLOCK";
        return appTask;
    }

    public final int L0(int i10) {
        int i11 = this.M;
        if (i11 <= 0 || i10 <= i11) {
            return 0;
        }
        int i12 = this.L;
        return Math.min(((i10 * i12) / i11) - i12, this.N);
    }

    public final int M0() {
        AdSlots adSlots = this.f13483d;
        if (adSlots == null) {
            return 20;
        }
        return adSlots.getTimeout();
    }

    public void N0() {
        super.m();
        m1();
        f1(Status.IDLE);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void O0(Context context) {
        if (this.T == null) {
            this.S.setLayoutResource(R.layout.reading_banner);
            ReadingBannerBinding bind = ReadingBannerBinding.bind(this.S.inflate());
            this.T = bind;
            bind.readingBannerLayout.getLayoutParams().width = ReadingInstance.z().O(context) ? m.i(context) : m.h(context);
        }
        if (this.T.getRoot().getVisibility() != 0) {
            l9.a.a(context, this.T.getRoot(), true, l9.a.f27955a);
        }
    }

    public final boolean P0() {
        return this.G == Status.IDLE;
    }

    public final boolean Q0() {
        return this.G == Status.LOADING;
    }

    public final boolean R0() {
        return this.G == Status.SHOW;
    }

    public final /* synthetic */ void S0(View view) {
        i0(getActivity(), "-点击免广告-点击");
    }

    public final /* synthetic */ void W0(View view) {
        j1();
    }

    public final /* synthetic */ void X0(Activity activity, AppTask appTask, BannerAdFrameLayout bannerAdFrameLayout, View view, GroMoreAd.AdViewHolder adViewHolder, boolean z10) {
        MiConfigSingleton.b2().H1().A(activity, appTask, bannerAdFrameLayout, view.findViewById(R.id.reading_ad_banner), adViewHolder, new b(adViewHolder, appTask, z10, activity));
    }

    @Override // com.martian.mibook.application.b
    public void Y(AppTaskList appTaskList) {
        ReaderSlidingAdapter readerSlidingAdapter;
        super.Y(appTaskList);
        if (!Q0() || (readerSlidingAdapter = this.R) == null) {
            return;
        }
        readerSlidingAdapter.u();
    }

    public final /* synthetic */ void Y0() {
        AppTaskList p10;
        Activity activity = getActivity();
        if (activity == null || (p10 = p()) == null || p10.isEmpty()) {
            return;
        }
        AppTask appTask = p10.getApps().get(0);
        n1(appTask);
        O0(activity);
        f1(Status.SHOW);
        boolean I = I(appTask);
        boolean z10 = p10.getApps().size() > 1;
        if (I) {
            ac.a.n(activity, "底通-误点-曝光");
        }
        K();
        h1(activity, appTask, this.T.readingBanner, z10, !z10, I);
        this.T.readingBannerJoint.setVisibility(z10 ? 0 : 8);
        if (z10) {
            AppTask appTask2 = p10.getApps().get(1);
            h1(activity, appTask2, this.T.readingBannerJoint, true, true, I && appTask2.customView == null);
        }
        I0();
        this.U = p10;
    }

    public final /* synthetic */ void Z0(TYBookItem tYBookItem, Activity activity, ReadingAdsBookBinding readingAdsBookBinding, View view) {
        String deeplink = tYBookItem.getDeeplink();
        if (!l.q(deeplink) && g.h(activity, deeplink)) {
            ac.a.s(activity, "Banner-deeplink");
            g.z(activity, deeplink);
            return;
        }
        ac.a.s(activity, "Banner-加入书架");
        if (!MiConfigSingleton.b2().M1().i0(tYBookItem.getSourceString())) {
            MiConfigSingleton.b2().M1().k(tYBookItem.getSource(), new c(activity, tYBookItem));
        }
        readingAdsBookBinding.ivBookCreative.setText(ConfigSingleton.D().s("已在书架"));
        readingAdsBookBinding.ivBookCreative.setEnabled(false);
        readingAdsBookBinding.ivBookCreative.setBackgroundResource(com.martian.appwall.R.drawable.border_button_bonus_mission_item_checked);
    }

    public final void b1() {
        Handler handler = this.P;
        if (handler == null) {
            return;
        }
        handler.removeCallbacks(this.W);
    }

    public void c1() {
        Handler handler = this.P;
        if (handler == null) {
            return;
        }
        handler.removeCallbacks(this.V);
    }

    public void d1(boolean z10) {
        if (P0()) {
            return;
        }
        H0(z10 ? 60000 : 3000);
    }

    public void e1() {
        this.J = 60000;
    }

    public final void f1(Status status) {
        this.G = status;
    }

    public void g1(Context context, boolean z10) {
        this.O = z10;
        ReadingBannerBinding readingBannerBinding = this.T;
        if (readingBannerBinding != null) {
            l9.a.a(context, readingBannerBinding.getRoot(), z10, l9.a.f27955a);
        } else if (z10) {
            i1();
        }
    }

    public final void h1(Activity activity, AppTask appTask, BannerAdFrameLayout bannerAdFrameLayout, boolean z10, boolean z11, boolean z12) {
        ViewStub viewStub;
        if (appTask == null) {
            return;
        }
        bannerAdFrameLayout.removeAllViews();
        int i10 = this.K;
        this.K = i10 + 1;
        appTask.setAdTag(String.valueOf(i10));
        if (MiBookManager.V1(appTask)) {
            k1(activity, (TYBookItem) appTask.origin, bannerAdFrameLayout, z10);
            return;
        }
        ViewWrapper viewWrapper = appTask.customView;
        if (viewWrapper != null) {
            viewWrapper.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, f13194a0));
        }
        View inflate = activity.getLayoutInflater().inflate(R.layout.reading_ads_banner, bannerAdFrameLayout);
        GroMoreAd.AdViewHolder adViewHolder = new GroMoreAd.AdViewHolder();
        adViewHolder.mTitle = (TextView) inflate.findViewById(R.id.tv_native_ad_title);
        adViewHolder.mDescription = (TextView) inflate.findViewById(R.id.tv_native_ad_desc);
        adViewHolder.mPoster = (ImageView) inflate.findViewById(R.id.iv_native_image);
        adViewHolder.videoView = (FrameLayout) inflate.findViewById(R.id.iv_ads_video);
        adViewHolder.mCreativeButton = (Button) inflate.findViewById(R.id.btn_native_creative);
        adViewHolder.mCreativeButtonView = inflate.findViewById(R.id.btn_native_creative_view);
        adViewHolder.mAdLogo = (ImageView) inflate.findViewById(R.id.iv_native_logo);
        adViewHolder.mAdLogoDesc = (TextView) inflate.findViewById(R.id.tv_ads_logo_desc);
        adViewHolder.mClickGuide = (TextView) inflate.findViewById(R.id.banner_click_guide);
        adViewHolder.mDislike = inflate.findViewById(R.id.iv_native_close_icon);
        adViewHolder.textView = inflate.findViewById(R.id.desc_text_view);
        adViewHolder.complianceView = (ViewStub) inflate.findViewById(R.id.tv_native_ad_compliance_view);
        if ("AD_BLOCK".equalsIgnoreCase(appTask.source)) {
            View findViewById = inflate.findViewById(R.id.pic_view);
            adViewHolder.mCreativeButtonView.setVisibility(8);
            adViewHolder.textView.setVisibility(8);
            adViewHolder.mPoster.setImageResource(R.drawable.banner_ad_block);
            adViewHolder.mDislike.setVisibility(8);
            ac.a.p(activity, F() + "-点击免广告-曝光");
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: ya.t
                public /* synthetic */ t() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BannerAdManager.this.S0(view);
                }
            });
            return;
        }
        adViewHolder.mAdLogo.setImageResource(appTask.adsIconRes());
        adViewHolder.mDislike.setVisibility(!z10 || z11 ? 0 : 8);
        adViewHolder.mCreativeButton.setText(ConfigSingleton.D().s(appTask.buttonText));
        if (z10) {
            adViewHolder.mCreativeButtonView.setVisibility(8);
            adViewHolder.mDescription.setLines(2);
            adViewHolder.mDescription.setText(ConfigSingleton.D().s(String.format("%s-%s", appTask.getDesc(), appTask.getTitle())));
            adViewHolder.mTitle.setVisibility(8);
        } else {
            adViewHolder.mCreativeButtonView.setVisibility(0);
            adViewHolder.mTitle.setText(ConfigSingleton.D().s(appTask.getTitle()));
            adViewHolder.mDescription.setLines(1);
            adViewHolder.mDescription.setText(ConfigSingleton.D().s(appTask.getDesc()));
        }
        MiConfigSingleton.b2().H1().Q0(activity, adViewHolder.mPoster, null, appTask);
        if (!z10 && DefaultAd.isDefaultAd(appTask)) {
            Button button = adViewHolder.mCreativeButton;
            if (button instanceof ReaderThemeButton) {
                ((ReaderThemeButton) button).setFollowTheme(false);
            }
            adViewHolder.mCreativeButton.setBackgroundResource(com.martian.libmars.R.drawable.button_gold);
            adViewHolder.mCreativeButton.setTextColor(ContextCompat.getColor(activity, com.martian.libmars.R.color.bonus_gold_text));
            l9.a.d(adViewHolder.mCreativeButton);
            View findViewById2 = inflate.findViewById(R.id.tv_ads_logo_view);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
        } else if (TextUtils.isEmpty(appTask.posterUrl) && TextUtils.isEmpty(appTask.iconUrl)) {
            inflate.findViewById(R.id.pic_view).setVisibility(8);
            adViewHolder.textView.setPadding(ConfigSingleton.i(4.0f), 0, 0, 0);
        }
        ComplianceInfo complianceInfo = appTask.getComplianceInfo();
        if (complianceInfo != null && (viewStub = adViewHolder.complianceView) != null) {
            viewStub.setLayoutResource(R.layout.ad_banner_compliance_info_view);
            AdBannerComplianceInfoViewBinding bind = AdBannerComplianceInfoViewBinding.bind(adViewHolder.complianceView.inflate());
            bind.tvNativeAdPermission.setOnClickListener(new View.OnClickListener() { // from class: ya.u

                /* renamed from: b */
                public final /* synthetic */ Activity f33400b;

                /* renamed from: c */
                public final /* synthetic */ ComplianceInfo f33401c;

                public /* synthetic */ u(Activity activity2, ComplianceInfo complianceInfo2) {
                    activity = activity2;
                    complianceInfo = complianceInfo2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BannerAdManager.T0(activity, complianceInfo, view);
                }
            });
            bind.tvNativeAdPrivacy.setOnClickListener(new View.OnClickListener() { // from class: ya.v

                /* renamed from: b */
                public final /* synthetic */ Activity f33403b;

                /* renamed from: c */
                public final /* synthetic */ ComplianceInfo f33404c;

                public /* synthetic */ v(Activity activity2, ComplianceInfo complianceInfo2) {
                    activity = activity2;
                    complianceInfo = complianceInfo2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BannerAdManager.U0(activity, complianceInfo, view);
                }
            });
            bind.tvNativeAdFunction.setOnClickListener(new View.OnClickListener() { // from class: ya.w

                /* renamed from: b */
                public final /* synthetic */ Activity f33411b;

                /* renamed from: c */
                public final /* synthetic */ ComplianceInfo f33412c;

                public /* synthetic */ w(Activity activity2, ComplianceInfo complianceInfo2) {
                    activity = activity2;
                    complianceInfo = complianceInfo2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BannerAdManager.V0(activity, complianceInfo, view);
                }
            });
            if (!l.q(complianceInfo2.getAppVersion())) {
                bind.tvNativeAdVersion.setText(appTask.getComplianceInfo().getAppVersion());
            }
            if (!l.q(complianceInfo2.getAppDeveloperName())) {
                adViewHolder.mTitle.setText(ConfigSingleton.D().s(complianceInfo2.getAppDeveloperName()));
            }
            if (!l.q(complianceInfo2.getAppName())) {
                adViewHolder.mDescription.setText(ConfigSingleton.D().s(complianceInfo2.getAppName()));
            }
            adViewHolder.mTitle.setPadding(0, ConfigSingleton.i(2.0f), 0, ConfigSingleton.i(2.0f));
            adViewHolder.mTitle.setTextSize(10.0f);
            if (z12) {
                adViewHolder.complianceView = null;
            }
        }
        if (z12) {
            View findViewById3 = inflate.findViewById(R.id.mis_click_view);
            findViewById3.setVisibility(0);
            bannerAdFrameLayout.setTouched(false);
            if (ConfigSingleton.D().B0()) {
                findViewById3.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.half_transparent));
            }
        } else if (!z10 && appTask.getEcpm() >= this.I) {
            l9.a.d(adViewHolder.mCreativeButton);
        }
        if (appTask.isHorizontalPicAd()) {
            View findViewById4 = inflate.findViewById(R.id.pic_view);
            adViewHolder.mCreativeButtonView.setVisibility(8);
            adViewHolder.textView.setVisibility(8);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById4.getLayoutParams();
            layoutParams2.width = 0;
            layoutParams2.weight = 1.0f;
            layoutParams2.leftMargin = ConfigSingleton.i(12.0f);
        }
        adViewHolder.mDislike.setOnClickListener(new View.OnClickListener() { // from class: ya.x
            public /* synthetic */ x() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BannerAdManager.this.W0(view);
            }
        });
        bannerAdFrameLayout.post(new Runnable() { // from class: ya.y

            /* renamed from: c */
            public final /* synthetic */ Activity f33420c;

            /* renamed from: d */
            public final /* synthetic */ AppTask f33421d;

            /* renamed from: e */
            public final /* synthetic */ BannerAdFrameLayout f33422e;

            /* renamed from: f */
            public final /* synthetic */ View f33423f;

            /* renamed from: g */
            public final /* synthetic */ GroMoreAd.AdViewHolder f33424g;

            /* renamed from: h */
            public final /* synthetic */ boolean f33425h;

            public /* synthetic */ y(Activity activity2, AppTask appTask2, BannerAdFrameLayout bannerAdFrameLayout2, View inflate2, GroMoreAd.AdViewHolder adViewHolder2, boolean z122) {
                activity = activity2;
                appTask = appTask2;
                bannerAdFrameLayout = bannerAdFrameLayout2;
                inflate = inflate2;
                adViewHolder = adViewHolder2;
                z12 = z122;
            }

            @Override // java.lang.Runnable
            public final void run() {
                BannerAdManager.this.X0(activity, appTask, bannerAdFrameLayout, inflate, adViewHolder, z12);
            }
        });
    }

    public final void i1() {
        Handler handler = this.Q;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: ya.c0
            public /* synthetic */ c0() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                BannerAdManager.this.Y0();
            }
        });
    }

    @Override // com.martian.mibook.application.b
    public boolean j0() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j1() {
        Activity activity = getActivity();
        if (activity == 0) {
            return;
        }
        if (MiConfigSingleton.b2().C2()) {
            g1(activity, false);
        } else if (activity instanceof gd.a) {
            ((gd.a) activity).Z();
        }
    }

    public final void k1(Activity activity, TYBookItem tYBookItem, ViewGroup viewGroup, boolean z10) {
        View inflate = activity.getLayoutInflater().inflate(R.layout.reading_ads_book, (ViewGroup) null);
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-1, f13194a0));
        ReadingAdsBookBinding bind = ReadingAdsBookBinding.bind(inflate);
        MiBookManager.s1(activity, tYBookItem, bind.ivBookCover);
        MiBookManager.s1(activity, tYBookItem, bind.ivBookCoverBg);
        bind.ivBookTitle.setText(ConfigSingleton.D().s(tYBookItem.getTitle()));
        bind.ivBookDesc.setText(ConfigSingleton.D().s(tYBookItem.getRecDesc()));
        if (l.q(tYBookItem.getDeeplink())) {
            bind.ivBookCreative.setText(activity.getString(R.string.add_to_book_store));
        } else {
            bind.ivBookCreative.setText(activity.getString(R.string.free_read));
        }
        bind.ivBookCreative.setVisibility(z10 ? 8 : 0);
        bind.ivBookCreative.setOnClickListener(new View.OnClickListener() { // from class: ya.z

            /* renamed from: c */
            public final /* synthetic */ TYBookItem f33432c;

            /* renamed from: d */
            public final /* synthetic */ Activity f33433d;

            /* renamed from: e */
            public final /* synthetic */ ReadingAdsBookBinding f33434e;

            public /* synthetic */ z(TYBookItem tYBookItem2, Activity activity2, ReadingAdsBookBinding bind2) {
                tYBookItem = tYBookItem2;
                activity = activity2;
                bind = bind2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BannerAdManager.this.Z0(tYBookItem, activity, bind, view);
            }
        });
        bind2.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ya.a0

            /* renamed from: c */
            public final /* synthetic */ Activity f33113c;

            public /* synthetic */ a0(Activity activity2) {
                activity = activity2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BannerAdManager.a1(TYBookItem.this, activity, view);
            }
        });
        viewGroup.addView(bind2.getRoot());
        MiConfigSingleton.b2().V1().g(0, tYBookItem2.getSourceName(), tYBookItem2.getSourceId(), tYBookItem2.getRecommendId(), "", "展示");
        ac.a.s(activity2, "Banner-曝光");
    }

    public void l1() {
        if (P0()) {
            f1(Status.LOADING);
            H0(100);
        }
    }

    @Override // com.martian.mibook.application.b
    public void m() {
        super.m();
        m1();
        this.R = null;
        this.P = null;
        this.Q = null;
        this.S = null;
        this.T = null;
    }

    public final void m1() {
        I0();
        c1();
        b1();
    }

    public final void n1(@NonNull AppTask appTask) {
        if (G().isEmpty()) {
            this.J = L0(appTask.getEcpm());
            J0(Math.max(5000, (this.L - (M0() * 1000)) + this.J));
        }
    }

    @Override // com.martian.mibook.application.b
    public AppTask r() {
        if (MiConfigSingleton.b2().H1().U()) {
            return K0();
        }
        MiConfigSingleton.b2().H1().E(getActivity(), 0, true, null);
        return MiConfigSingleton.b2().H1().S(E());
    }

    @Override // com.martian.mibook.application.b
    public int t() {
        return MiConfigSingleton.b2().c2().getBannerJointEcpm();
    }

    @Override // com.martian.mibook.application.b
    public int u() {
        return 2;
    }

    @Override // com.martian.mibook.application.b
    public int w() {
        return MiConfigSingleton.b2().c2().getBannerMisClickBaseRate();
    }

    @Override // com.martian.mibook.application.b
    public int x() {
        return MiConfigSingleton.b2().c2().getBannerBqtMisClickBaseEcpmV2();
    }

    @Override // com.martian.mibook.application.b
    public int y() {
        return MiConfigSingleton.b2().c2().getBannerCsjMisClickBaseEcpmV2();
    }
}
