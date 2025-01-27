package com.martian.mibook.application;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import b8.j;
import ba.l;
import ba.m;
import com.martian.ads.ad.AdConfig;
import com.martian.ads.ad.DefaultAd;
import com.martian.ads.ad.GDTAd;
import com.martian.ads.ad.GroMoreAd;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.martian.apptask.data.ComplianceInfo;
import com.martian.libmars.activity.BaseActivity;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libsliding.SlidingLayout;
import com.martian.mibook.R;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.application.ReadingInstance;
import com.martian.mibook.application.RewardVideoAdManager;
import com.martian.mibook.application.a;
import com.martian.mibook.data.book.MiReadingContent;
import com.martian.mibook.databinding.AdComplianceInfoViewBinding;
import com.martian.mibook.databinding.ReadingAdsItemBookBinding;
import com.martian.mibook.databinding.ReadingAdsItemBookPosterBinding;
import com.martian.mibook.databinding.ReadingAdsLayoutBinding;
import com.martian.mibook.databinding.ReadingLinkAdBinding;
import com.martian.mibook.lib.model.data.BookCreative;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.ui.AutoScrollView;
import com.martian.mibook.ui.FlowAdFrameLayout;
import hf.e;
import i8.g;
import java.util.Locale;
import java.util.Random;
import je.i;
import l9.m0;
import l9.t0;
import ya.e0;
import ya.t1;

/* loaded from: classes3.dex */
public class d extends com.martian.mibook.application.b {
    public C0528d G;
    public C0528d H;
    public C0528d I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public Long Q;
    public int R;
    public int S;
    public long T;
    public AppTask U;
    public boolean V;

    public class a extends d8.b {
        public a() {
        }

        @Override // d8.b, d8.a
        public void a() {
            d.this.V = false;
        }

        @Override // d8.b, d8.a
        public void i(AdConfig adConfig, AppTaskList appTaskList) {
            d.this.V = false;
            d.this.U = appTaskList.getApps().get(0);
            d.this.U.linkType = ReadingInstance.LinkAd.Ad.getType();
        }
    }

    public class b extends d8.b {

        /* renamed from: a */
        public final /* synthetic */ GroMoreAd.AdViewHolder f13574a;

        /* renamed from: b */
        public final /* synthetic */ AppTask f13575b;

        /* renamed from: c */
        public final /* synthetic */ boolean f13576c;

        /* renamed from: d */
        public final /* synthetic */ boolean f13577d;

        /* renamed from: e */
        public final /* synthetic */ ReadingAdsLayoutBinding f13578e;

        /* renamed from: f */
        public final /* synthetic */ a.p f13579f;

        /* renamed from: g */
        public final /* synthetic */ SlidingLayout f13580g;

        /* renamed from: h */
        public final /* synthetic */ Activity f13581h;

        public b(GroMoreAd.AdViewHolder adViewHolder, AppTask appTask, boolean z10, boolean z11, ReadingAdsLayoutBinding readingAdsLayoutBinding, a.p pVar, SlidingLayout slidingLayout, Activity activity) {
            this.f13574a = adViewHolder;
            this.f13575b = appTask;
            this.f13576c = z10;
            this.f13577d = z11;
            this.f13578e = readingAdsLayoutBinding;
            this.f13579f = pVar;
            this.f13580g = slidingLayout;
            this.f13581h = activity;
        }

        @Override // d8.b, d8.a
        public void b(AdConfig adConfig) {
            if (MiConfigSingleton.b2().B0()) {
                this.f13574a.mAdLogoDesc.setText(String.valueOf(this.f13575b.getEcpm()));
            }
            if (this.f13576c) {
                if (this.f13577d) {
                    d.this.s1(this.f13578e, this.f13579f, this.f13580g);
                    ac.a.n(this.f13581h, "插页-误点-曝光");
                } else if (this.f13575b.getEcpm() >= d.this.O) {
                    l9.a.d(this.f13574a.mCreativeButtonView);
                }
                d.this.K();
            }
        }

        @Override // d8.b, d8.a
        public void l(AdConfig adConfig) {
            d.this.d0();
            if (this.f13577d) {
                ac.a.n(this.f13581h, "插页-误点-点击");
            }
            d.this.J();
        }
    }

    public class c implements xb.b {

        /* renamed from: a */
        public final /* synthetic */ Activity f13583a;

        /* renamed from: b */
        public final /* synthetic */ TYBookItem f13584b;

        public c(Activity activity, TYBookItem tYBookItem) {
            this.f13583a = activity;
            this.f13584b = tYBookItem;
        }

        @Override // xb.b
        public void a(Book book) {
            if (book == null) {
                t0.b(this.f13583a, "加入失败，请重试");
                return;
            }
            MiConfigSingleton.b2().M1().g(this.f13583a, book);
            t0.b(this.f13583a, "已加入书架");
            MiConfigSingleton.b2().V1().g(3, book.getSourceName(), book.getSourceId(), this.f13584b.getRecommendId(), this.f13584b.getRecommend(), "广告加书架");
        }

        @Override // xb.b
        public void onLoading(boolean z10) {
        }

        @Override // xb.b
        public void onResultError(x8.c cVar) {
            t0.b(this.f13583a, "加入失败，请重试");
        }
    }

    /* renamed from: com.martian.mibook.application.d$d */
    public static class C0528d extends MiReadingContent.MiCursor {

        /* renamed from: a */
        public final AppTaskList f13586a;

        /* renamed from: b */
        public final String f13587b;

        /* renamed from: c */
        public AppTask f13588c;

        /* renamed from: d */
        public final int f13589d;

        /* renamed from: e */
        public boolean f13590e;

        public C0528d(AppTaskList appTaskList, int i10, int i11) {
            this.f13586a = appTaskList;
            this.f13587b = i10 + e.f26694a + i11;
            this.f13589d = i11;
        }

        public void a() {
            com.martian.mibook.application.a.G(this.f13586a);
            com.martian.mibook.application.a.F(this.f13588c);
        }

        public String b() {
            return this.f13587b;
        }

        public AppTaskList c() {
            return this.f13586a;
        }

        public AppTask d() {
            return this.f13588c;
        }

        public boolean e() {
            return this.f13590e;
        }

        public void f(AppTask appTask) {
            this.f13588c = appTask;
        }

        public void g(boolean z10) {
            this.f13590e = z10;
        }

        public int getContentIndex() {
            return this.f13589d;
        }

        @Override // com.martian.mibook.data.book.MiReadingContent.MiCursor
        public boolean notAdCursor() {
            return false;
        }

        @Override // com.martian.mibook.data.book.MiReadingContent.MiCursor
        public boolean withFloatMenu() {
            return false;
        }
    }

    public d(Activity activity, String str, j jVar, boolean z10) {
        super(activity, str, jVar, z10);
        this.N = 1;
    }

    public static /* synthetic */ void Z0(TYBookItem tYBookItem, Activity activity, View view) {
        String deeplink = tYBookItem.getDeeplink();
        if (l.q(deeplink) || !g.h(activity, deeplink)) {
            ac.a.s(activity, "书籍-阅读");
            i.R(activity, tYBookItem);
        } else {
            ac.a.s(activity, "书籍-deeplink");
            g.A(activity, deeplink, "", "其他应用", false);
        }
    }

    public static /* synthetic */ void a1(TYBookItem tYBookItem, Activity activity, View view) {
        String deeplink = tYBookItem.getDeeplink();
        if (l.q(deeplink) || !g.h(activity, deeplink)) {
            ac.a.s(activity, "书籍-阅读");
            i.R(activity, tYBookItem);
        } else {
            ac.a.s(activity, "书籍-deeplink");
            g.A(activity, deeplink, "", "其他应用", false);
        }
    }

    public static /* synthetic */ void d1(TYBookItem tYBookItem, Activity activity, View view) {
        String deeplink = tYBookItem.getDeeplink();
        if (l.q(deeplink) || !g.h(activity, deeplink)) {
            ac.a.s(activity, "投放素材-阅读");
            i.R(activity, tYBookItem);
        } else {
            ac.a.s(activity, "投放素材-deeplink");
            g.A(activity, deeplink, "", "其他应用", false);
        }
    }

    public static /* synthetic */ void e1(ReadingAdsItemBookPosterBinding readingAdsItemBookPosterBinding, View view) {
        readingAdsItemBookPosterBinding.bookAdTextView.a();
    }

    public static /* synthetic */ void f1(TYBookItem tYBookItem, Activity activity, View view) {
        String deeplink = tYBookItem.getDeeplink();
        if (l.q(deeplink) || !g.h(activity, deeplink)) {
            ac.a.s(activity, "投放素材-卡片阅读");
            i.R(activity, tYBookItem);
        } else {
            ac.a.s(activity, "投放素材-deeplink");
            g.A(activity, deeplink, "", "其他应用", false);
        }
    }

    public static /* synthetic */ void g1(Activity activity, ComplianceInfo complianceInfo, View view) {
        MiWebViewActivity.startWebViewActivity(activity, complianceInfo.getAppPermissionUrl());
    }

    public static /* synthetic */ void h1(Activity activity, ComplianceInfo complianceInfo, View view) {
        MiWebViewActivity.startWebViewActivity(activity, complianceInfo.getAppPrivacyUrl());
    }

    public static /* synthetic */ void i1(Activity activity, ComplianceInfo complianceInfo, View view) {
        MiWebViewActivity.startWebViewActivity(activity, complianceInfo.getAppFunctionDescUrl());
    }

    public static /* synthetic */ void k1(SlidingLayout slidingLayout) {
        slidingLayout.setBlockType(SlidingLayout.TouchBlockType.DEFAULT);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void l1(AppTask appTask, Activity activity, String str, View view) {
        if (ReadingInstance.LinkAd.Video.getType().equalsIgnoreCase(appTask.linkType)) {
            ac.a.C(activity, "视频免广告-点击");
            if (activity instanceof gd.a) {
                ((gd.a) activity).J0(RewardVideoAdManager.VideoType.BLOCK_AD_MANUAL);
                return;
            }
            return;
        }
        if (ReadingInstance.LinkAd.Vip.getType().equalsIgnoreCase(appTask.linkType)) {
            ac.a.C(activity, "vip-点击");
            i.e0(activity, "文字链", vb.e.e(str), vb.e.d(str));
        }
    }

    @Override // com.martian.mibook.application.b
    public int A() {
        return 0;
    }

    @Override // com.martian.mibook.application.b
    public int B() {
        return MiConfigSingleton.b2().c2().getFlowKsMisClickBaseEcpmV2();
    }

    @Override // com.martian.mibook.application.b
    public int C() {
        return MiConfigSingleton.b2().c2().getFlowMisClickPlatform();
    }

    @Override // com.martian.mibook.application.b
    public int D() {
        return MiConfigSingleton.b2().c2().getFlowYlhMisClickBaseEcpmV2();
    }

    @Override // com.martian.mibook.application.b
    public String E() {
        return e0.R;
    }

    @Override // com.martian.mibook.application.b
    public String F() {
        return e0.R;
    }

    public final void G0(Activity activity, TYBookItem tYBookItem) {
        if (MiConfigSingleton.b2().M1().i0(tYBookItem.getSourceString())) {
            return;
        }
        MiConfigSingleton.b2().M1().k(tYBookItem.getSource(), new c(activity, tYBookItem));
    }

    @SuppressLint({"SetTextI18n"})
    public final void H0(View view, TYBookItem tYBookItem) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        ReadingAdsItemBookBinding bind = ReadingAdsItemBookBinding.bind(view);
        bind.bookAdName.setText(ConfigSingleton.D().s(tYBookItem.getBookName()));
        bind.bookAdAuthor.setText(ConfigSingleton.D().s(tYBookItem.getAuthor()));
        bind.bookAdInfo.setText(ConfigSingleton.D().s(tYBookItem.getTagInfo()));
        if (tYBookItem.getScore() > 0) {
            bind.bookAdScoreView.setVisibility(0);
            bind.bookAdScore.setText(String.format(Locale.CHINA, "%.1f", Float.valueOf(tYBookItem.getScore() / 10.0f)));
        } else {
            bind.bookAdScoreView.setVisibility(8);
        }
        if (l.q(tYBookItem.getRankDesc())) {
            bind.bookAdRank.setVisibility(4);
        } else {
            bind.bookAdRank.setVisibility(0);
            bind.bookAdRank.setText(ConfigSingleton.D().s(tYBookItem.getRankDesc()));
        }
        bind.bookAdContent.setText(ConfigSingleton.D().s(tYBookItem.getIntro()));
        bind.bookAdRecommend.setText("“" + ConfigSingleton.D().s(tYBookItem.getRecTitle()) + "”");
        MiBookManager.s1(activity, tYBookItem, bind.bookAdCover);
        if (l.q(tYBookItem.getDeeplink())) {
            bind.bookAdAddBookrack.setText(activity.getString(R.string.add_to_book_store));
        } else {
            bind.bookAdAddBookrack.setText(activity.getString(R.string.free_read));
        }
        bind.bookAdAddBookrack.setOnClickListener(new View.OnClickListener() { // from class: ya.q1

            /* renamed from: c */
            public final /* synthetic */ TYBookItem f33350c;

            /* renamed from: d */
            public final /* synthetic */ Activity f33351d;

            /* renamed from: e */
            public final /* synthetic */ ReadingAdsItemBookBinding f33352e;

            public /* synthetic */ q1(TYBookItem tYBookItem2, Activity activity2, ReadingAdsItemBookBinding bind2) {
                tYBookItem = tYBookItem2;
                activity = activity2;
                bind = bind2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                com.martian.mibook.application.d.this.b1(tYBookItem, activity, bind, view2);
            }
        });
        bind2.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ya.r1

            /* renamed from: c */
            public final /* synthetic */ Activity f33358c;

            public /* synthetic */ r1(Activity activity2) {
                activity = activity2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                com.martian.mibook.application.d.Z0(TYBookItem.this, activity, view2);
            }
        });
        bind2.bookAdContent.setOnClickListener(new View.OnClickListener() { // from class: ya.s1

            /* renamed from: c */
            public final /* synthetic */ Activity f33393c;

            public /* synthetic */ s1(Activity activity2) {
                activity = activity2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                com.martian.mibook.application.d.a1(TYBookItem.this, activity, view2);
            }
        });
    }

    public final void I0(View view, TYBookItem tYBookItem, float f10) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        ReadingAdsItemBookPosterBinding bind = ReadingAdsItemBookPosterBinding.bind(view);
        BookCreative creative = tYBookItem.getCreative();
        int textRectBottom = (int) (creative.getTextRectBottom() * f10);
        m0.k(activity, creative.getBgImg(), bind.bookAdBg);
        if (l.q(creative.getTitle())) {
            bind.bookAdTextTitle.setVisibility(8);
        } else {
            bind.bookAdTextTitle.setText(ConfigSingleton.D().s(creative.getTitle()));
        }
        bind.bookAdTextContent.setText(ConfigSingleton.D().s(creative.getContent()));
        bind.bookAdTextContent.setPadding(0, 0, 0, ConfigSingleton.i(134.0f) - textRectBottom);
        bind.bookAdTextView.setPadding(0, (int) (creative.getTextRectTop() * f10), 0, textRectBottom);
        m0.k(activity, tYBookItem.getCoverUrl(), bind.bookAdCardCover);
        bind.bookAdCardAuthor.setText(ConfigSingleton.D().s(tYBookItem.getTitle()));
        bind.bookAdCardInfo.setText(ConfigSingleton.D().s(tYBookItem.getTagInfo()));
        try {
            bind.bookAdTextTitle.setTextColor(Color.parseColor(creative.getTitleColor()));
            bind.bookAdTextContent.setTextColor(Color.parseColor(creative.getFontColor()));
        } catch (Exception unused) {
        }
        if (l.q(tYBookItem.getDeeplink())) {
            bind.bookAdCardRead.setVisibility(0);
            bind.bookAdCardAddBookrack.setText(activity.getString(R.string.add_to_book_store));
        } else {
            bind.bookAdCardRead.setVisibility(8);
            bind.bookAdCardAddBookrack.setText(activity.getString(R.string.free_read));
        }
        bind.bookAdCardAddBookrack.setOnClickListener(new View.OnClickListener() { // from class: ya.z1

            /* renamed from: c */
            public final /* synthetic */ TYBookItem f33437c;

            /* renamed from: d */
            public final /* synthetic */ Activity f33438d;

            /* renamed from: e */
            public final /* synthetic */ ReadingAdsItemBookPosterBinding f33439e;

            public /* synthetic */ z1(TYBookItem tYBookItem2, Activity activity2, ReadingAdsItemBookPosterBinding bind2) {
                tYBookItem = tYBookItem2;
                activity = activity2;
                bind = bind2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                com.martian.mibook.application.d.this.c1(tYBookItem, activity, bind, view2);
            }
        });
        bind2.bookAdCardRead.setOnClickListener(new View.OnClickListener() { // from class: ya.a2

            /* renamed from: c */
            public final /* synthetic */ Activity f33118c;

            public /* synthetic */ a2(Activity activity2) {
                activity = activity2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                com.martian.mibook.application.d.d1(TYBookItem.this, activity, view2);
            }
        });
        bind2.bookAdTextContent.setOnClickListener(new View.OnClickListener() { // from class: ya.b2
            public /* synthetic */ b2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                com.martian.mibook.application.d.e1(ReadingAdsItemBookPosterBinding.this, view2);
            }
        });
        bind2.bookAdCardView.setOnClickListener(new View.OnClickListener() { // from class: ya.o1

            /* renamed from: c */
            public final /* synthetic */ Activity f33327c;

            public /* synthetic */ o1(Activity activity2) {
                activity = activity2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                com.martian.mibook.application.d.f1(TYBookItem.this, activity, view2);
            }
        });
    }

    @SuppressLint({"SetTextI18n"})
    public final void J0(View view, AppTask appTask) {
        ViewStub viewStub;
        View findViewById;
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (GDTAd.isGdtTemplateFlowAd(appTask)) {
            view.setVisibility(8);
            return;
        }
        GroMoreAd.AdViewHolder adViewHolder = new GroMoreAd.AdViewHolder();
        adViewHolder.mTitle = (TextView) view.findViewById(R.id.tv_ads_title);
        adViewHolder.mDescription = (TextView) view.findViewById(R.id.tv_ads_desc);
        adViewHolder.mPoster = (ImageView) view.findViewById(R.id.iv_ads_image);
        adViewHolder.videoView = (FrameLayout) view.findViewById(R.id.iv_ads_video);
        adViewHolder.mCreativeButton = (Button) view.findViewById(R.id.btn_native_creative);
        adViewHolder.mCreativeButtonView = view.findViewById(R.id.btn_native_creative_view);
        adViewHolder.mAdLogo = (ImageView) view.findViewById(R.id.tv_ads_logo);
        adViewHolder.mAdLogoDesc = (TextView) view.findViewById(R.id.tv_ads_logo_desc);
        adViewHolder.mClickGuide = (TextView) view.findViewById(R.id.ad_click_guide);
        adViewHolder.mIcon = (ImageView) view.findViewById(R.id.tv_ads_icon);
        adViewHolder.complianceView = (ViewStub) view.findViewById(R.id.ad_compliance_info_view);
        adViewHolder.mTitle.setText(ConfigSingleton.D().s(appTask.getTitle()));
        adViewHolder.mDescription.setText(ConfigSingleton.D().s(appTask.getDesc()));
        adViewHolder.mAdLogo.setImageResource(appTask.adsIconRes());
        adViewHolder.mCreativeButton.setText(ConfigSingleton.D().s(appTask.buttonText));
        MiConfigSingleton.b2().H1().Q0(activity, adViewHolder.mPoster, adViewHolder.mIcon, appTask);
        if (appTask.isShakeStyle() && AdConfig.UnionType.CSJ.equalsIgnoreCase(appTask.source) && (findViewById = view.findViewById(R.id.tv_ads_shake_view)) != null) {
            findViewById.setVisibility(0);
        }
        ComplianceInfo complianceInfo = appTask.getComplianceInfo();
        if (complianceInfo != null && (viewStub = adViewHolder.complianceView) != null) {
            viewStub.setLayoutResource(R.layout.ad_compliance_info_view);
            AdComplianceInfoViewBinding bind = AdComplianceInfoViewBinding.bind(adViewHolder.complianceView.inflate());
            bind.adCompliancePermission.setOnClickListener(new View.OnClickListener() { // from class: ya.w1

                /* renamed from: b */
                public final /* synthetic */ Activity f33413b;

                /* renamed from: c */
                public final /* synthetic */ ComplianceInfo f33414c;

                public /* synthetic */ w1(Activity activity2, ComplianceInfo complianceInfo2) {
                    activity = activity2;
                    complianceInfo = complianceInfo2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    com.martian.mibook.application.d.g1(activity, complianceInfo, view2);
                }
            });
            bind.adCompliancePrivacy.setOnClickListener(new View.OnClickListener() { // from class: ya.x1

                /* renamed from: b */
                public final /* synthetic */ Activity f33417b;

                /* renamed from: c */
                public final /* synthetic */ ComplianceInfo f33418c;

                public /* synthetic */ x1(Activity activity2, ComplianceInfo complianceInfo2) {
                    activity = activity2;
                    complianceInfo = complianceInfo2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    com.martian.mibook.application.d.h1(activity, complianceInfo, view2);
                }
            });
            bind.adComplianceFunction.setOnClickListener(new View.OnClickListener() { // from class: ya.y1

                /* renamed from: b */
                public final /* synthetic */ Activity f33429b;

                /* renamed from: c */
                public final /* synthetic */ ComplianceInfo f33430c;

                public /* synthetic */ y1(Activity activity2, ComplianceInfo complianceInfo2) {
                    activity = activity2;
                    complianceInfo = complianceInfo2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    com.martian.mibook.application.d.i1(activity, complianceInfo, view2);
                }
            });
            bind.adComplianceCompany.setText(ConfigSingleton.D().s(complianceInfo2.getAppDeveloperName()));
            if (!l.q(complianceInfo2.getAppVersion())) {
                bind.adComplianceVersion.setText(appTask.getComplianceInfo().getAppVersion());
            }
            if (!l.q(complianceInfo2.getAppName())) {
                adViewHolder.mTitle.setText(ConfigSingleton.D().s(complianceInfo2.getAppName()));
            }
        }
        if (DefaultAd.isDefaultAd(appTask)) {
            View findViewById2 = view.findViewById(R.id.tv_ads_icon_view);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.btn_native_creative_more);
            if (imageView != null) {
                adViewHolder.mCreativeButtonView.setBackgroundResource(com.martian.libmars.R.drawable.button_gold);
                int color = ContextCompat.getColor(activity2, com.martian.libmars.R.color.bonus_gold_text);
                adViewHolder.mCreativeButton.setTextColor(color);
                imageView.setColorFilter(color);
                l9.a.d(adViewHolder.mCreativeButtonView);
            }
        }
    }

    public final a.p K0(Activity activity, AppTaskList appTaskList, boolean z10) {
        a.p pVar = new a.p(activity, z10);
        AppTask appTask = appTaskList.getApps().get(0);
        double picRatio = appTask.getPicRatio();
        pVar.k(z10 ? 0 : ConfigSingleton.i(96.0f));
        if (appTaskList.getApps().size() != 1) {
            pVar.i(R.layout.reading_ads_item_large);
            int d10 = ((int) (pVar.d() * picRatio)) + ConfigSingleton.i(90.0f);
            pVar.h(Math.min((appTaskList.getApps().size() > 2 ? ((int) (((pVar.d() / 2) - ConfigSingleton.i(6.0f)) * picRatio)) + ConfigSingleton.i(90.0f) : d10) + d10 + ConfigSingleton.i(12.0f), pVar.e()));
        } else if (picRatio > 1.0d) {
            pVar.i(R.layout.reading_ads_item_fullscreen_portrait);
            if (GDTAd.isGdtTemplateFlowAd(appTask)) {
                pVar.k(0);
                boolean O = ReadingInstance.z().O(activity);
                int i10 = m.i(activity);
                if (!O) {
                    i10 /= 2;
                }
                pVar.j(i10);
            }
            int d11 = (int) (pVar.d() * picRatio);
            int e10 = pVar.e();
            if (d11 > e10) {
                pVar.h(e10);
                pVar.j((int) (e10 / picRatio));
            } else {
                pVar.h(d11);
            }
        } else {
            int e11 = pVar.e();
            if (!MiBookManager.V1(appTask)) {
                pVar.i(R.layout.reading_ads_item_fullscreen);
                pVar.h(Math.min(((int) (pVar.d() * picRatio)) + ConfigSingleton.i(190.0f), e11));
            } else if (appTask.isCoverView()) {
                pVar.i(R.layout.reading_ads_item_book_poster);
                int d12 = (pVar.d() * 16) / 9;
                if (d12 > e11) {
                    pVar.h(e11);
                    pVar.j((e11 * 9) / 16);
                } else {
                    pVar.h(d12);
                }
            } else {
                pVar.i(R.layout.reading_ads_item_book);
                pVar.h(e11);
            }
        }
        return pVar;
    }

    public final boolean L0() {
        if (System.currentTimeMillis() - V0() < this.P || this.N < S0()) {
            return false;
        }
        Activity activity = getActivity();
        if (!(activity instanceof BaseActivity) || ((BaseActivity) activity).s1()) {
            return !G().isEmpty();
        }
        return false;
    }

    public boolean M0(boolean z10, int i10, int i11) {
        this.N++;
        C0528d c0528d = this.G;
        if (c0528d != null) {
            O0(c0528d);
            this.G = null;
        } else {
            C0528d c0528d2 = this.H;
            if (c0528d2 != null) {
                this.G = c0528d2;
                c0528d2.setCurrentPage(false);
                this.H = null;
            } else {
                C0528d c0528d3 = this.I;
                if (c0528d3 != null) {
                    this.H = c0528d3;
                    c0528d3.setCurrentPage(true);
                    this.I = null;
                } else if (z10 && L0()) {
                    AppTaskList p10 = p();
                    if (p10 == null || p10.isEmpty()) {
                        return false;
                    }
                    this.I = new C0528d(p10, i10, i11);
                    this.I.g(I(p10.getApps().get(0)));
                    AppTask appTask = this.U;
                    if (appTask != null) {
                        this.I.f(appTask);
                        this.U = null;
                    } else {
                        this.I.f(U0());
                    }
                }
            }
        }
        w1();
        return this.H != null;
    }

    public boolean N0() {
        int i10 = this.N;
        if (i10 >= 0) {
            this.N = i10 - 1;
        }
        C0528d c0528d = this.I;
        if (c0528d != null) {
            O0(c0528d);
            this.I = null;
        } else {
            C0528d c0528d2 = this.H;
            if (c0528d2 != null) {
                this.I = c0528d2;
                c0528d2.setCurrentPage(false);
                this.H = null;
            } else {
                C0528d c0528d3 = this.G;
                if (c0528d3 != null) {
                    this.H = c0528d3;
                    c0528d3.setCurrentPage(true);
                    this.G = null;
                }
            }
        }
        return this.I != null;
    }

    public final void O0(C0528d c0528d) {
        if (c0528d == null) {
            return;
        }
        AppTaskList c10 = c0528d.c();
        if (c10.getApps().get(0).exposed) {
            c0528d.a();
        } else {
            Y(c10);
        }
    }

    public void P0() {
        C0528d c0528d = this.G;
        if (c0528d != null) {
            c0528d.a();
            this.G = null;
        }
        C0528d c0528d2 = this.H;
        if (c0528d2 != null) {
            c0528d2.a();
            this.H = null;
        }
        C0528d c0528d3 = this.I;
        if (c0528d3 != null) {
            c0528d3.a();
            this.I = null;
        }
    }

    public final void Q0(ReadingAdsLayoutBinding readingAdsLayoutBinding, AppTask appTask, ViewGroup viewGroup, View view, a.p pVar, SlidingLayout slidingLayout, boolean z10, boolean z11) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        GroMoreAd.AdViewHolder adViewHolder = new GroMoreAd.AdViewHolder();
        adViewHolder.mTitle = (TextView) view.findViewById(R.id.tv_ads_title);
        adViewHolder.mDescription = (TextView) view.findViewById(R.id.tv_ads_desc);
        adViewHolder.mPoster = (ImageView) view.findViewById(R.id.iv_ads_image);
        adViewHolder.videoView = (FrameLayout) view.findViewById(R.id.iv_ads_video);
        adViewHolder.shakeViewContainer = (FrameLayout) view.findViewById(R.id.fl_shakeview_container);
        adViewHolder.mCreativeButton = (Button) view.findViewById(R.id.btn_native_creative);
        adViewHolder.mCreativeButtonView = view.findViewById(R.id.btn_native_creative_view);
        adViewHolder.mAdLogo = (ImageView) view.findViewById(R.id.tv_ads_logo);
        adViewHolder.mAdLogoDesc = (TextView) view.findViewById(R.id.tv_ads_logo_desc);
        adViewHolder.mClickGuide = (TextView) view.findViewById(R.id.ad_click_guide);
        adViewHolder.mIcon = (ImageView) view.findViewById(R.id.tv_ads_icon);
        adViewHolder.textView = view.findViewById(R.id.tv_ads_text_view);
        adViewHolder.logoView = view.findViewById(R.id.tv_ads_logo_view);
        if (!z11) {
            adViewHolder.complianceView = new ViewStub(activity);
        }
        MiConfigSingleton.b2().H1().A(activity, appTask, viewGroup, view.findViewById(R.id.reading_ads_flow), adViewHolder, new b(adViewHolder, appTask, z10, z11, readingAdsLayoutBinding, pVar, slidingLayout, activity));
    }

    public final void R0(AppTask appTask, ReadingLinkAdBinding readingLinkAdBinding, C0528d c0528d) {
        if (!appTask.exposed && c0528d.isCurrentPage() && ReadingInstance.LinkAd.Ad.getType().equalsIgnoreCase(appTask.linkType)) {
            readingLinkAdBinding.readingLinkAdView.post(new Runnable() { // from class: ya.v1

                /* renamed from: c */
                public final /* synthetic */ ReadingLinkAdBinding f33409c;

                /* renamed from: d */
                public final /* synthetic */ AppTask f33410d;

                public /* synthetic */ v1(ReadingLinkAdBinding readingLinkAdBinding2, AppTask appTask2) {
                    readingLinkAdBinding = readingLinkAdBinding2;
                    appTask = appTask2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.martian.mibook.application.d.this.j1(readingLinkAdBinding, appTask);
                }
            });
        }
    }

    public final int S0() {
        return this.J + this.M;
    }

    public C0528d T0() {
        return this.H;
    }

    public final AppTask U0() {
        AppTask appTask = new AppTask();
        appTask.linkType = ReadingInstance.LinkAd.Vip.getType();
        appTask.source = AdConfig.UnionType.DEFAULT;
        return appTask;
    }

    public final long V0() {
        if (this.Q == null) {
            if (ConfigSingleton.D().B0()) {
                this.Q = Long.valueOf(System.currentTimeMillis() - this.P);
            } else {
                this.Q = Long.valueOf((System.currentTimeMillis() - this.P) + 10000);
            }
        }
        return this.Q.longValue();
    }

    public C0528d W0() {
        return this.I;
    }

    public C0528d X0() {
        return this.G;
    }

    public boolean Y0() {
        return this.T > System.currentTimeMillis();
    }

    public final /* synthetic */ void b1(TYBookItem tYBookItem, Activity activity, ReadingAdsItemBookBinding readingAdsItemBookBinding, View view) {
        String deeplink = tYBookItem.getDeeplink();
        if (!l.q(deeplink) && g.h(activity, deeplink)) {
            ac.a.s(activity, "书籍-deeplink");
            g.A(activity, deeplink, "", "其他应用", false);
            return;
        }
        ac.a.s(activity, "书籍-加入书架");
        G0(activity, tYBookItem);
        readingAdsItemBookBinding.bookAdAddBookrack.setText(ConfigSingleton.D().s("已在书架"));
        readingAdsItemBookBinding.bookAdAddBookrack.setEnabled(false);
        readingAdsItemBookBinding.bookAdAddBookrack.setBackgroundResource(com.martian.appwall.R.drawable.border_button_bonus_mission_item_checked);
    }

    public final /* synthetic */ void c1(TYBookItem tYBookItem, Activity activity, ReadingAdsItemBookPosterBinding readingAdsItemBookPosterBinding, View view) {
        String deeplink = tYBookItem.getDeeplink();
        if (!l.q(deeplink) && g.h(activity, deeplink)) {
            ac.a.s(activity, "投放素材-deeplink");
            g.A(activity, deeplink, "", "其他应用", false);
            return;
        }
        ac.a.s(activity, "投放素材-加入书架");
        G0(activity, tYBookItem);
        readingAdsItemBookPosterBinding.bookAdCardAddBookrack.setText(ConfigSingleton.D().s("已在书架"));
        readingAdsItemBookPosterBinding.bookAdCardAddBookrack.setEnabled(false);
        readingAdsItemBookPosterBinding.bookAdCardAddBookrack.setAlpha(0.5f);
    }

    @Override // com.martian.mibook.application.b
    public boolean j0() {
        return true;
    }

    public final /* synthetic */ void j1(ReadingLinkAdBinding readingLinkAdBinding, AppTask appTask) {
        Activity activity;
        if (!readingLinkAdBinding.readingLinkAdView.getGlobalVisibleRect(new Rect()) || (activity = getActivity()) == null) {
            return;
        }
        com.martian.mibook.application.a H1 = MiConfigSingleton.b2().H1();
        ThemeLinearLayout themeLinearLayout = readingLinkAdBinding.readingLinkAdView;
        H1.A(activity, appTask, themeLinearLayout, themeLinearLayout, null, null);
    }

    @Override // com.martian.mibook.application.b
    public void k0() {
        super.k0();
        int minIntervalSeconds = MiConfigSingleton.b2().c2().getMinIntervalSeconds();
        e0(Math.max(8, minIntervalSeconds));
        this.P = minIntervalSeconds * 1000;
        this.K = MiConfigSingleton.b2().c2().getBaseIntervalEcpm();
        this.L = MiConfigSingleton.b2().c2().getMaxIntervalEcpm();
        this.J = MiConfigSingleton.b2().u2().w(getActivity()) ? MiConfigSingleton.b2().c2().getFreshReadingAdsInterval() : MiConfigSingleton.b2().c2().getReadingAdsInterval();
        this.O = MiConfigSingleton.b2().c2().getFlowOptimizeEcpm();
        this.R = MiConfigSingleton.b2().c2().getLinkAdWeight().intValue();
        this.S = MiConfigSingleton.b2().c2().getVipAdWeight().intValue();
    }

    @Override // com.martian.mibook.application.b
    public void m() {
        super.m();
        P0();
    }

    public final /* synthetic */ void m1(ReadingAdsLayoutBinding readingAdsLayoutBinding, AppTask appTask, Activity activity, C0528d c0528d, a.p pVar, SlidingLayout slidingLayout, ViewGroup viewGroup, View view, boolean z10) {
        if (readingAdsLayoutBinding.getRoot().getGlobalVisibleRect(new Rect())) {
            p1(appTask.getEcpm());
            if (!MiBookManager.V1(appTask)) {
                Q0(readingAdsLayoutBinding, appTask, viewGroup, view, pVar, slidingLayout, z10, c0528d.e());
                return;
            }
            appTask.exposed = true;
            if (appTask.isCoverView()) {
                ac.a.s(activity, "投放素材-曝光");
                AutoScrollView autoScrollView = (AutoScrollView) readingAdsLayoutBinding.getRoot().findViewById(R.id.book_ad_text_view);
                if (autoScrollView != null) {
                    autoScrollView.postDelayed(new t1(autoScrollView), qe.a.f30009d);
                }
            } else {
                ac.a.s(activity, "书籍-曝光");
                AutoScrollView autoScrollView2 = (AutoScrollView) readingAdsLayoutBinding.getRoot().findViewById(R.id.book_ad_content_view);
                if (autoScrollView2 != null) {
                    autoScrollView2.postDelayed(new t1(autoScrollView2), qe.a.f30009d);
                }
            }
            if (c0528d.e()) {
                s1(readingAdsLayoutBinding, pVar, slidingLayout);
            }
        }
    }

    public final void n1() {
        if (this.U != null || this.V || MiConfigSingleton.b2().C2()) {
            return;
        }
        this.V = true;
        int nextInt = new Random().nextInt(100) + 1;
        int i10 = this.R;
        if (nextInt <= i10) {
            MiConfigSingleton.b2().H1().T(getActivity(), e0.T, new a());
            return;
        }
        if (nextInt <= i10 + this.S) {
            AppTask appTask = new AppTask();
            this.U = appTask;
            appTask.linkType = ReadingInstance.LinkAd.Vip.getType();
            this.U.source = AdConfig.UnionType.DEFAULT;
            this.V = false;
            return;
        }
        AppTask appTask2 = new AppTask();
        this.U = appTask2;
        appTask2.linkType = ReadingInstance.LinkAd.Video.getType();
        this.U.source = AdConfig.UnionType.DEFAULT;
        this.V = false;
    }

    public void o1(ReadingAdsLayoutBinding readingAdsLayoutBinding) {
        if (readingAdsLayoutBinding != null && readingAdsLayoutBinding.flAdsContainer.getChildCount() > 0) {
            readingAdsLayoutBinding.flAdsContainer.removeAllViews();
            if (readingAdsLayoutBinding.flAdsContainer2.getChildCount() <= 0) {
                return;
            }
            readingAdsLayoutBinding.flAdsContainer2.removeAllViews();
            if (readingAdsLayoutBinding.flAdsContainerJoint2.getChildCount() <= 0) {
                return;
            }
            readingAdsLayoutBinding.flAdsContainerJoint2.removeAllViews();
            readingAdsLayoutBinding.flAdsContainerJoint3.removeAllViews();
        }
    }

    public void p1(int i10) {
        q1();
        r1(10L);
        this.N = 0;
        int i11 = this.K;
        if (i11 <= 0 || i10 <= 0) {
            return;
        }
        if (i11 > i10) {
            this.M = Math.min(16, i11 / i10);
            return;
        }
        int i12 = this.L;
        if (i12 <= 0 || i10 < i12) {
            this.M = 0;
        } else if (this.M < 0) {
            this.M = 0;
        } else {
            this.M = 3 - this.J;
        }
    }

    public final void q1() {
        this.Q = Long.valueOf(System.currentTimeMillis());
    }

    @Override // com.martian.mibook.application.b
    public AppTask r() {
        AppTask A1 = MiConfigSingleton.b2().M1().A1(E());
        return A1 != null ? A1 : MiConfigSingleton.b2().H1().S(E());
    }

    public void r1(long j10) {
        this.T = j10 > 0 ? System.currentTimeMillis() + (j10 * 1000) : 0L;
    }

    public final void s1(ReadingAdsLayoutBinding readingAdsLayoutBinding, a.p pVar, SlidingLayout slidingLayout) {
        int b10 = pVar.b(false);
        slidingLayout.A(ConfigSingleton.i(32.0f) + b10, b10 + pVar.a() + pVar.f());
        readingAdsLayoutBinding.flAdsContainer.setTouched(false);
        readingAdsLayoutBinding.flAdsContainer.setAdTouchListener(new FlowAdFrameLayout.a() { // from class: ya.u1
            public /* synthetic */ u1() {
            }

            @Override // com.martian.mibook.ui.FlowAdFrameLayout.a
            public final void a() {
                com.martian.mibook.application.d.k1(SlidingLayout.this);
            }
        });
    }

    @Override // com.martian.mibook.application.b
    public int t() {
        return MiConfigSingleton.b2().c2().getFlowJointEcpm();
    }

    @SuppressLint({"InflateParams"})
    public void t1(ReadingAdsLayoutBinding readingAdsLayoutBinding, C0528d c0528d, SlidingLayout slidingLayout, boolean z10) {
        View findViewById;
        AutoScrollView autoScrollView;
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        String str = (String) readingAdsLayoutBinding.getRoot().getTag();
        readingAdsLayoutBinding.getRoot().setTag(c0528d.b());
        readingAdsLayoutBinding.getRoot().setVisibility(0);
        AppTask appTask = c0528d.c().getApps().get(0);
        boolean equalsIgnoreCase = c0528d.b().equalsIgnoreCase(str);
        if (equalsIgnoreCase && appTask.exposed) {
            if (appTask.isCoverView() && (autoScrollView = (AutoScrollView) readingAdsLayoutBinding.getRoot().findViewById(R.id.book_ad_text_view)) != null) {
                autoScrollView.b();
            }
            readingAdsLayoutBinding.flAdsContainer.setVisibility(0);
            if (c0528d.c().getApps().size() == 2) {
                readingAdsLayoutBinding.flAdsContainer2.setVisibility(0);
            }
            if (c0528d.c().getApps().size() > 2) {
                readingAdsLayoutBinding.flAdsContainer3.setVisibility(0);
                readingAdsLayoutBinding.flAdsContainerJoint2.setVisibility(0);
                readingAdsLayoutBinding.flAdsContainerJoint3.setVisibility(0);
                return;
            }
            return;
        }
        boolean z11 = MiBookManager.V1(appTask) || DefaultAd.isDefaultAd(appTask);
        boolean z12 = z11 || MiConfigSingleton.b2().C2();
        View findViewById2 = readingAdsLayoutBinding.getRoot().findViewById(R.id.fl_close_ads_icon);
        View findViewById3 = readingAdsLayoutBinding.getRoot().findViewById(R.id.fl_close_ads_video);
        TextView textView = (TextView) readingAdsLayoutBinding.getRoot().findViewById(R.id.fl_close_ads_video_title);
        findViewById2.setVisibility(z11 ? 8 : 0);
        findViewById3.setVisibility(z12 ? 8 : 0);
        textView.setText(ConfigSingleton.D().s("免" + MiConfigSingleton.b2().c2().getAdsHideIntervalMinutes() + "分钟广告"));
        a.p K0 = K0(activity, c0528d.c(), z10);
        int f10 = c0528d.e() ? K0.f() : 0;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) readingAdsLayoutBinding.getRoot().getLayoutParams();
        marginLayoutParams.height = K0.a() + f10;
        marginLayoutParams.width = K0.d();
        marginLayoutParams.setMargins(0, K0.b(z10), 0, 0);
        readingAdsLayoutBinding.getRoot().setLayoutParams(marginLayoutParams);
        int size = c0528d.c().getApps().size();
        readingAdsLayoutBinding.flAdsContainer.setVisibility(0);
        readingAdsLayoutBinding.flAdsContainerLayout.setPadding(0, 0, 0, 0);
        int i10 = f10;
        v1(readingAdsLayoutBinding, readingAdsLayoutBinding.flAdsContainer, appTask, K0, slidingLayout, equalsIgnoreCase, true, c0528d);
        if (i10 > 0 && (findViewById = readingAdsLayoutBinding.flAdsContainer.findViewById(R.id.mis_click_view)) != null) {
            findViewById.getLayoutParams().height = i10;
            findViewById.setVisibility(0);
            if (ConfigSingleton.D().B0()) {
                findViewById.setBackgroundColor(ContextCompat.getColor(activity, R.color.half_transparent));
            }
            if (size > 1) {
                float a10 = (K0.a() - ConfigSingleton.i(12.0f)) * (size == 2 ? 0.5f : 0.61f);
                if (a10 > 0.0f) {
                    ((LinearLayout.LayoutParams) readingAdsLayoutBinding.flAdsContainerLayout.getLayoutParams()).weight = ((i10 + a10) * 20.0f) / a10;
                }
            }
        }
        if (c0528d.c().getApps().size() == 1) {
            readingAdsLayoutBinding.flAdsContainer2.setVisibility(8);
            readingAdsLayoutBinding.flAdsContainer3.setVisibility(8);
            return;
        }
        if (c0528d.c().getApps().size() == 2) {
            readingAdsLayoutBinding.flAdsContainer2.setVisibility(0);
            readingAdsLayoutBinding.flAdsContainer3.setVisibility(8);
            v1(readingAdsLayoutBinding, readingAdsLayoutBinding.flAdsContainer2, c0528d.c().getApps().get(1), K0, slidingLayout, equalsIgnoreCase, false, c0528d);
        } else {
            readingAdsLayoutBinding.flAdsContainer2.setVisibility(8);
            readingAdsLayoutBinding.flAdsContainer3.setVisibility(0);
            readingAdsLayoutBinding.flAdsContainerJoint2.setVisibility(0);
            readingAdsLayoutBinding.flAdsContainerJoint3.setVisibility(0);
            v1(readingAdsLayoutBinding, readingAdsLayoutBinding.flAdsContainerJoint2, c0528d.c().getApps().get(1), K0, slidingLayout, equalsIgnoreCase, false, c0528d);
            v1(readingAdsLayoutBinding, readingAdsLayoutBinding.flAdsContainerJoint3, c0528d.c().getApps().get(2), K0, slidingLayout, equalsIgnoreCase, false, c0528d);
        }
    }

    @Override // com.martian.mibook.application.b
    public int u() {
        return 3;
    }

    @SuppressLint({"SetTextI18n"})
    public void u1(ReadingLinkAdBinding readingLinkAdBinding, C0528d c0528d, String str, boolean z10) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        AppTask d10 = c0528d.d();
        if (d10 == null) {
            readingLinkAdBinding.readingLinkAdView.setVisibility(4);
            return;
        }
        readingLinkAdBinding.readingLinkAdView.setVisibility(0);
        String str2 = (String) readingLinkAdBinding.readingLinkAdView.getTag();
        readingLinkAdBinding.readingLinkAdView.setTag(c0528d.b());
        if (c0528d.b().equalsIgnoreCase(str2)) {
            R0(d10, readingLinkAdBinding, c0528d);
            return;
        }
        if (readingLinkAdBinding.readingAdsCloseTitle.getType() < 0 && !ReadingInstance.LinkAd.Vip.getType().equalsIgnoreCase(d10.linkType)) {
            readingLinkAdBinding.readingAdsCloseTitle.setType(2);
            readingLinkAdBinding.readingAdsCloseTitle.p();
            readingLinkAdBinding.readingAdsCloseMore.setVisibility(0);
            readingLinkAdBinding.readingAdsCloseIcon.setEnableColorFilter(true);
            readingLinkAdBinding.readingAdsCloseIcon.p();
            readingLinkAdBinding.readingLinkAdView.setBackgroundResource(R.drawable.transparent_res);
        }
        if (ReadingInstance.LinkAd.Video.getType().equalsIgnoreCase(d10.linkType)) {
            ac.a.C(activity, "视频免广告-曝光");
            readingLinkAdBinding.readingAdsCloseTitle.setText(activity.getString(R.string.watch_video_for) + MiConfigSingleton.b2().I1(z10) + activity.getString(R.string.minute_ad));
            readingLinkAdBinding.readingAdsCloseIcon.setImageResource(R.drawable.reader_icon_video_ad);
        } else if (ReadingInstance.LinkAd.Vip.getType().equalsIgnoreCase(d10.linkType)) {
            ac.a.C(activity, "vip-曝光");
            if (MiConfigSingleton.b2().M2()) {
                readingLinkAdBinding.readingAdsCloseTitle.setText(activity.getString(R.string.vip_for_one_yuan));
            } else {
                readingLinkAdBinding.readingAdsCloseTitle.setText(activity.getString(R.string.open_vip_for_ad_free));
            }
            readingLinkAdBinding.readingAdsCloseTitle.setType(-1);
            readingLinkAdBinding.readingAdsCloseTitle.setTextColor(ContextCompat.getColor(activity, com.martian.libmars.R.color.vip_text_color_primary));
            readingLinkAdBinding.readingAdsCloseMore.setVisibility(8);
            readingLinkAdBinding.readingAdsCloseIcon.setEnableColorFilter(false);
            readingLinkAdBinding.readingAdsCloseIcon.setColorFilter(ContextCompat.getColor(activity, com.martian.libmars.R.color.vip_text_color_primary));
            readingLinkAdBinding.readingAdsCloseIcon.setImageResource(R.drawable.reader_icon_vip_member);
            readingLinkAdBinding.readingLinkAdView.setBackgroundResource(R.drawable.shape_vip_button);
        } else {
            String desc = d10.getDesc();
            if (desc.length() > 16) {
                desc = desc.substring(0, 15);
            }
            readingLinkAdBinding.readingAdsCloseTitle.setText(ConfigSingleton.D().s(desc));
            readingLinkAdBinding.readingAdsCloseIcon.setImageResource(R.drawable.vote_upcount);
        }
        readingLinkAdBinding.readingLinkAdView.setOnClickListener(new View.OnClickListener() { // from class: ya.n1

            /* renamed from: c */
            public final /* synthetic */ Activity f33317c;

            /* renamed from: d */
            public final /* synthetic */ String f33318d;

            public /* synthetic */ n1(Activity activity2, String str3) {
                activity = activity2;
                str = str3;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.martian.mibook.application.d.l1(AppTask.this, activity, str, view);
            }
        });
        R0(d10, readingLinkAdBinding, c0528d);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: ya.p1.<init>(com.martian.mibook.application.d, com.martian.mibook.databinding.ReadingAdsLayoutBinding, com.martian.apptask.data.AppTask, android.app.Activity, com.martian.mibook.application.d$d, com.martian.mibook.application.a$p, com.martian.libsliding.SlidingLayout, android.view.ViewGroup, android.view.View, boolean):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    public final void v1(com.martian.mibook.databinding.ReadingAdsLayoutBinding r15, android.view.ViewGroup r16, com.martian.apptask.data.AppTask r17, com.martian.mibook.application.a.p r18, com.martian.libsliding.SlidingLayout r19, boolean r20, boolean r21, com.martian.mibook.application.d.C0528d r22) {
        /*
            r14 = this;
            r11 = r14
            r8 = r16
            r3 = r17
            android.app.Activity r4 = r14.getActivity()
            if (r4 != 0) goto Lc
            return
        Lc:
            if (r3 != 0) goto Lf
            return
        Lf:
            int r0 = r22.getContentIndex()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            android.view.View r0 = r8.findViewWithTag(r0)
            if (r20 == 0) goto L22
            if (r0 != 0) goto L20
            goto L22
        L20:
            r9 = r0
            goto L67
        L22:
            r0 = 0
            r3.exposed = r0
            r16.removeAllViews()
            android.view.LayoutInflater r0 = r4.getLayoutInflater()
            int r1 = r18.c()
            r2 = 0
            android.view.View r0 = r0.inflate(r1, r2)
            int r1 = r22.getContentIndex()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.setTag(r1)
            r8.addView(r0)
            boolean r1 = com.martian.mibook.application.MiBookManager.V1(r17)
            if (r1 == 0) goto L63
            java.lang.Object r1 = r3.origin
            com.martian.mibook.lib.model.data.TYBookItem r1 = (com.martian.mibook.lib.model.data.TYBookItem) r1
            boolean r2 = r17.isCoverView()
            if (r2 == 0) goto L5f
            int r2 = r18.a()
            float r2 = (float) r2
            r5 = 1151336448(0x44a00000, float:1280.0)
            float r2 = r2 / r5
            r14.I0(r0, r1, r2)
            goto L20
        L5f:
            r14.H0(r0, r1)
            goto L20
        L63:
            r14.J0(r0, r3)
            goto L20
        L67:
            boolean r0 = r22.isCurrentPage()
            if (r0 != 0) goto L6e
            return
        L6e:
            android.widget.RelativeLayout r12 = r15.getRoot()
            ya.p1 r13 = new ya.p1
            r0 = r13
            r1 = r14
            r2 = r15
            r3 = r17
            r5 = r22
            r6 = r18
            r7 = r19
            r8 = r16
            r10 = r21
            r0.<init>()
            r12.post(r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.application.d.v1(com.martian.mibook.databinding.ReadingAdsLayoutBinding, android.view.ViewGroup, com.martian.apptask.data.AppTask, com.martian.mibook.application.a$p, com.martian.libsliding.SlidingLayout, boolean, boolean, com.martian.mibook.application.d$d):void");
    }

    @Override // com.martian.mibook.application.b
    public int w() {
        return MiConfigSingleton.b2().c2().getFlowMisClickBaseRate();
    }

    public final void w1() {
        if (this.N >= S0() - 2 && G().isEmpty() && this.H == null && this.I == null) {
            R();
            n1();
        }
    }

    @Override // com.martian.mibook.application.b
    public int x() {
        return MiConfigSingleton.b2().c2().getFlowBqtMisClickBaseEcpmV2();
    }

    @Override // com.martian.mibook.application.b
    public int y() {
        return MiConfigSingleton.b2().c2().getFlowCsjMisClickBaseEcpmV2();
    }
}
