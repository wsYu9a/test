package com.sigmob.sdk.nativead;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.common.utils.ImageUtils;
import com.martian.libmars.activity.BaseActivity;
import com.sigmob.sdk.base.common.y;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.windad.WindAdError;
import java.io.File;
import java.util.LinkedList;

/* loaded from: classes4.dex */
public class o extends p implements i, com.sigmob.sdk.videoplayer.c {

    /* renamed from: n */
    public static LinkedList<ViewGroup> f20021n = new LinkedList<>();

    /* renamed from: o */
    public static long f20022o = 0;

    /* renamed from: f */
    public com.sigmob.sdk.videoplayer.g f20023f;

    /* renamed from: g */
    public l f20024g;

    /* renamed from: h */
    public q f20025h;

    /* renamed from: i */
    public Bitmap f20026i;

    /* renamed from: j */
    public Bitmap f20027j;

    /* renamed from: k */
    public ViewGroup f20028k;

    /* renamed from: l */
    public Context f20029l;

    /* renamed from: m */
    public long f20030m;

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f20031a;

        static {
            int[] iArr = new int[g.values().length];
            f20031a = iArr;
            try {
                iArr[g.PREVIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20031a[g.DETAIL_PAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20031a[g.DETAIL_PAGE_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public o(Context context) {
        super(context.getApplicationContext());
        this.f20026i = null;
        this.f20027j = null;
        this.f20029l = context.getApplicationContext();
        getVideoAdView().setVideoAdViewListener(this);
        this.f20028k = new RelativeLayout(this.f20029l);
        getVideoAdView().setVideoAdStatusListener(this);
        com.sigmob.sdk.base.blurkit.a.a(this.f20029l);
    }

    public int a(int i10) {
        double adPercent = getVideoAdView().getVideoWidth() == 0 ? getAdUnit().getAdPercent() : (getVideoAdView().getVideoWidth() * 1.0f) / getVideoAdView().getVideoHeight();
        int i11 = ClientMetadata.getInstance().getDisplayMetrics().heightPixels / 2;
        int i12 = (int) (i10 / adPercent);
        return i12 > i11 ? i11 : i12;
    }

    @Override // com.sigmob.sdk.videoplayer.c
    public void b() {
        ViewGroup viewGroup = (ViewGroup) this.f20028k.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.f20028k);
        }
        Activity g10 = com.sigmob.sdk.videoplayer.d.g(f20021n.getLast().getContext());
        if (g10 != null) {
            g10.getWindow().getDecorView().setSystemUiVisibility(0);
        }
        if (getVideoAdView().getVideoHeight() < getVideoAdView().getVideoWidth() && g10 != null) {
            g10.setRequestedOrientation(1);
        }
        f20021n.getLast().removeAllViews();
        f20021n.getLast().addView(this.f20028k, new FrameLayout.LayoutParams(-1, -1));
        f20021n.pop();
    }

    @Override // com.sigmob.sdk.nativead.i
    public void c() {
        if (getSigAdVideoStatusListener() != null) {
            getSigAdVideoStatusListener().c();
        }
    }

    @Override // com.sigmob.sdk.nativead.p, com.sigmob.sdk.nativead.j
    public void d() {
        super.d();
        ImageUtils.recycleBitmap(this.f20026i);
        ImageUtils.recycleBitmap(this.f20027j);
        q sigVideoAdController = getSigVideoAdController();
        if (sigVideoAdController != null) {
            sigVideoAdController.destroy();
        }
        ViewGroup viewGroup = this.f20028k;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            com.sigmob.sdk.base.utils.e.e(this.f20028k);
        }
        com.sigmob.sdk.videoplayer.g gVar = this.f20023f;
        if (gVar != null) {
            com.sigmob.sdk.base.utils.e.e(gVar);
            this.f20023f.setVideoAdViewListener(null);
            this.f20023f.setVideoAdStatusListener(null);
            this.f20023f.setBackClickListener(null);
            this.f20023f.g();
            this.f20023f = null;
        }
    }

    @Override // com.sigmob.sdk.nativead.j
    public void e() {
        super.e();
        if (getVideoAdView() != null) {
            getVideoAdView().v();
        }
    }

    @Override // com.sigmob.sdk.nativead.p
    public void f() {
        super.f();
    }

    @Override // com.sigmob.sdk.nativead.p
    public void g() {
        super.g();
        if (getVideoAdView() != null) {
            getVideoAdView().k();
        }
    }

    public l getAppView() {
        if (this.f20024g == null) {
            this.f20024g = new l(this.f20029l);
        }
        return this.f20024g;
    }

    public i getSigAdVideoStatusListener() {
        q qVar = this.f20025h;
        if (qVar != null) {
            return qVar.f();
        }
        return null;
    }

    @Override // com.sigmob.sdk.nativead.j
    public q getSigVideoAdController() {
        if (this.f20025h == null) {
            this.f20025h = new r(getVideoAdView());
        }
        return this.f20025h;
    }

    public com.sigmob.sdk.videoplayer.g getVideoAdView() {
        if (this.f20023f == null) {
            this.f20023f = new com.sigmob.sdk.videoplayer.g(this.f20029l);
        }
        return this.f20023f;
    }

    public ViewGroup getVideoContainer() {
        return this.f20028k;
    }

    @Override // com.sigmob.sdk.nativead.p
    public double getVideoDuration() {
        return getVideoAdView() != null ? getVideoAdView().getDuration() / 1000.0f : super.getVideoDuration();
    }

    @Override // com.sigmob.sdk.nativead.p
    public double getVideoProgress() {
        return getVideoAdView() != null ? ((getVideoAdView().getCurrentPositionWhenPlaying() * 1.0f) / getVideoAdView().getDuration()) / 100.0f : super.getVideoProgress();
    }

    public int getVideoSurferViewHeight() {
        if (getVideoAdView() != null) {
            return getVideoAdView().getVideoSurferViewHeight();
        }
        return 0;
    }

    @Override // com.sigmob.sdk.nativead.p
    public void h() {
        super.h();
        if (getVideoAdView() != null) {
            getVideoAdView().l();
        }
    }

    public final void i() {
        k appInfoView = getAppInfoView();
        if (appInfoView != null) {
            com.sigmob.sdk.base.utils.e.e(appInfoView);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 0, 0, Dips.asIntPixels(5.0f, this.f20029l));
            layoutParams.addRule(12);
            addView(appInfoView, layoutParams);
        }
    }

    public final void j() {
        if (this.f20024g != null) {
            ViewGroup appContainer = getVideoAdView().getAppContainer();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            appContainer.addView(this.f20024g, layoutParams);
        }
    }

    public void k() {
        if (System.currentTimeMillis() - f20022o > y.f.f18076n && getVideoAdView().f20786y == 4 && getVideoAdView().f20787z == 1) {
            f20022o = System.currentTimeMillis();
            onBackPressed();
        }
    }

    public final void l() {
        Bitmap textureBitmap;
        if (getVideoAdView() == null || (textureBitmap = getVideoAdView().getTextureBitmap()) == null) {
            return;
        }
        Bitmap a10 = com.sigmob.sdk.base.blurkit.a.a().a(textureBitmap, 25);
        getVideoAdView().getBlurImageView().setImageBitmap(a10);
        getVideoAdView().getAppContainer().setVisibility(0);
        this.f20026i = textureBitmap;
        this.f20027j = a10;
    }

    public final void m() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getVideoAdView().getBottomLayoutView().getLayoutParams();
        if (layoutParams != null) {
            layoutParams.setMargins(Dips.asIntPixels(10.0f, this.f20029l), Dips.asIntPixels(0.0f, this.f20029l), Dips.asIntPixels(10.0f, this.f20029l), Dips.asIntPixels(15.0f, this.f20029l));
            getVideoAdView().getBottomLayoutView().setLayoutParams(layoutParams);
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getVideoAdView().getTopLayoutView().getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.setMargins(Dips.asIntPixels(10.0f, this.f20029l), Dips.asIntPixels(15.0f, this.f20029l), Dips.asIntPixels(10.0f, this.f20029l), 0);
            getVideoAdView().getTopLayoutView().setLayoutParams(layoutParams2);
        }
    }

    @Override // com.sigmob.sdk.nativead.j, com.sigmob.sdk.videoplayer.c
    public boolean onBackPressed() {
        if (f20021n.size() != 0 && getVideoAdView() != null) {
            getVideoAdView().n();
            return true;
        }
        if (f20021n.size() != 0 || getVideoAdView() == null || getVideoAdView().f20787z == 0) {
            return false;
        }
        getVideoAdView().f();
        return true;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
    public void onVideoCompleted() {
        if (getSigAdVideoStatusListener() != null) {
            getSigAdVideoStatusListener().onVideoCompleted();
        }
        l();
        g gVar = this.f19965a;
        if (gVar != g.PREVIEW) {
            if (gVar == g.DETAIL_PAGE) {
                setUIStyle(g.DETAIL_PAGE_END);
            }
        } else {
            if (getAppView().getParent() == null) {
                j();
            }
            getAppView().setVisibility(0);
            getVideoAdView().a(com.sigmob.sdk.videoplayer.f.RETRY, true);
        }
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
    public void onVideoError(WindAdError windAdError) {
        if (getSigAdVideoStatusListener() != null) {
            getSigAdVideoStatusListener().onVideoError(windAdError);
        }
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
    public void onVideoLoad() {
        if (getSigAdVideoStatusListener() != null) {
            getSigAdVideoStatusListener().onVideoLoad();
        }
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
    public void onVideoPause() {
        if (getSigAdVideoStatusListener() != null) {
            getSigAdVideoStatusListener().onVideoPause();
        }
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
    public void onVideoResume() {
        if (getSigAdVideoStatusListener() != null) {
            getSigAdVideoStatusListener().onVideoResume();
        }
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
    public void onVideoStart() {
        if (getAdUnit() == null) {
            return;
        }
        l lVar = this.f20024g;
        if (lVar != null) {
            com.sigmob.sdk.base.utils.e.e(lVar);
            getVideoAdView().getAppContainer().setVisibility(4);
        }
        ImageUtils.recycleBitmap(this.f20026i);
        ImageUtils.recycleBitmap(this.f20027j);
        BaseAdUnit adUnit = getAdUnit();
        if (adUnit != null) {
            adUnit.updateRealAdPercent((getVideoAdView().getVideoWidth() * 1.0f) / getVideoAdView().getVideoHeight());
        }
        g gVar = this.f19965a;
        if (gVar == g.DETAIL_PAGE_END) {
            gVar = g.DETAIL_PAGE;
        }
        setUIStyle(gVar);
        if (getSigAdVideoStatusListener() != null) {
            getSigAdVideoStatusListener().onVideoStart();
        }
    }

    public void setBackClickListener(View.OnClickListener onClickListener) {
        if (getVideoAdView() != null) {
            getVideoAdView().setBackClickListener(onClickListener);
        }
    }

    @Override // com.sigmob.sdk.nativead.p
    public void setUIStyle(g gVar) {
        if (getAdUnit() == null) {
            return;
        }
        super.setUIStyle(gVar);
        int i10 = a.f20031a[gVar.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                if (this.f20024g.getParent() != null) {
                    this.f20024g.setVisibility(4);
                }
                if (this.f20028k.getChildCount() > 0) {
                    this.f20028k.removeAllViews();
                }
                removeView(getVideoAdView());
                this.f20028k.addView(getVideoAdView(), new RelativeLayout.LayoutParams(-1, -1));
                getVideoAdView().setSoundChange(getAdConfig().m() || com.sigmob.sdk.a.i());
                getVideoAdView().a(com.sigmob.sdk.videoplayer.f.START, false);
                getVideoAdView().a(com.sigmob.sdk.videoplayer.f.FULLSCREEN, true);
                getVideoAdView().a(com.sigmob.sdk.videoplayer.f.VOLUME, true);
                getVideoAdView().a(com.sigmob.sdk.videoplayer.f.BIGRETRY, false);
                getVideoAdView().a(com.sigmob.sdk.videoplayer.f.RETRY, false);
            } else {
                if (i10 != 3) {
                    return;
                }
                if (this.f20024g.getParent() != null) {
                    this.f20024g.setVisibility(4);
                }
                getVideoAdView().a(com.sigmob.sdk.videoplayer.f.START, false);
                getVideoAdView().a(com.sigmob.sdk.videoplayer.f.FULLSCREEN, false);
                getVideoAdView().a(com.sigmob.sdk.videoplayer.f.VOLUME, false);
                getVideoAdView().a(com.sigmob.sdk.videoplayer.f.RETRY, false);
                getVideoAdView().a(com.sigmob.sdk.videoplayer.f.BIGRETRY, true);
            }
            getVideoAdView().a(com.sigmob.sdk.videoplayer.f.BACK, true);
            return;
        }
        this.f20028k.removeAllViews();
        com.sigmob.sdk.base.utils.e.e(this.f20028k);
        com.sigmob.sdk.base.utils.e.e(getVideoAdView());
        addView(getVideoAdView(), new RelativeLayout.LayoutParams(-1, -1));
        if (getVideoAdView().f20786y == 0) {
            getVideoAdView().a(com.sigmob.sdk.videoplayer.f.START, true);
        } else {
            getVideoAdView().a(com.sigmob.sdk.videoplayer.f.START, false);
        }
        getVideoAdView().a(com.sigmob.sdk.videoplayer.f.FULLSCREEN, false);
        getVideoAdView().a(com.sigmob.sdk.videoplayer.f.VOLUME, false);
        getVideoAdView().a(com.sigmob.sdk.videoplayer.f.BIGRETRY, false);
        com.sigmob.sdk.videoplayer.g videoAdView = getVideoAdView();
        com.sigmob.sdk.videoplayer.f fVar = com.sigmob.sdk.videoplayer.f.RETRY;
        videoAdView.a(fVar, false);
        getVideoAdView().a(com.sigmob.sdk.videoplayer.f.BACK, false);
        getVideoAdView().setSoundChange(getAdConfig().s());
        if (this.f20024g != null && (getVideoAdView().f20786y == 6 || getVideoAdView().f20786y == 7)) {
            if (this.f20024g.getParent() == null) {
                j();
            }
            this.f20024g.setVisibility(0);
            getVideoAdView().a(fVar, true);
        }
        i();
    }

    public final void a(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(BaseActivity.f12020n);
    }

    public final void b(Activity activity) {
        int asIntPixels = Dips.asIntPixels(10.0f, this.f20029l);
        int asIntPixels2 = Dips.asIntPixels(15.0f, this.f20029l);
        int b10 = com.sigmob.sdk.videoplayer.d.b(activity);
        if (getVideoAdView().getVideoHeight() < getVideoAdView().getVideoWidth()) {
            activity.setRequestedOrientation(0);
            asIntPixels += b10;
        } else {
            asIntPixels2 += b10;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getVideoAdView().getBottomLayoutView().getLayoutParams();
        if (layoutParams != null) {
            layoutParams.setMargins(Dips.asIntPixels(10.0f, this.f20029l), 0, asIntPixels, asIntPixels2);
            getVideoAdView().getBottomLayoutView().setLayoutParams(layoutParams);
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getVideoAdView().getTopLayoutView().getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.setMargins(Dips.asIntPixels(10.0f, this.f20029l), Dips.asIntPixels(35.0f, this.f20029l), asIntPixels, 0);
            getVideoAdView().getTopLayoutView().setLayoutParams(layoutParams2);
        }
    }

    @Override // com.sigmob.sdk.nativead.p
    public void a(z zVar) {
        super.a(zVar);
        BaseAdUnit adUnit = getAdUnit();
        if (adUnit != null) {
            a(this);
            File videoProxyFile = adUnit.getVideoProxyFile();
            if (videoProxyFile == null || !videoProxyFile.exists()) {
                getVideoAdView().setUp(adUnit.getProxyVideoUrl());
            } else {
                getVideoAdView().setUp(videoProxyFile.getAbsolutePath());
            }
            setUIStyle(g.PREVIEW);
            if (TextUtils.isEmpty(adUnit.getVideoThumbUrl())) {
                getVideoAdView().a(true);
            } else {
                ImageManager.with(this.f20029l).load(adUnit.getVideoThumbUrl()).into(getVideoAdView().getThumbView());
            }
            getAppView().a(adUnit.getIconUrl(), adUnit.getTitle(), adUnit.getCTAText());
            getVideoAdView().setSoundChange(getAdConfig().s());
        }
    }

    @Override // com.sigmob.sdk.nativead.j
    public boolean a(MotionEvent motionEvent) {
        l lVar = this.f20024g;
        if (lVar == null || lVar.getParent() == null || this.f20024g.getVisibility() != 0) {
            return false;
        }
        return com.sigmob.sdk.base.utils.e.a(this.f20024g.getCtaView(), motionEvent);
    }

    @Override // com.sigmob.sdk.nativead.i
    public void a(long j10, long j11) {
        if (getSigAdVideoStatusListener() != null) {
            getSigAdVideoStatusListener().a(j10, j11);
        }
        if (j10 > 0) {
            this.f20030m = j11;
        }
    }

    @Override // com.sigmob.sdk.videoplayer.c
    public void a() {
        ViewGroup viewGroup = (ViewGroup) this.f20028k.getParent();
        viewGroup.removeView(this.f20028k);
        f20021n.add(viewGroup);
        Activity g10 = com.sigmob.sdk.videoplayer.d.g(viewGroup.getContext());
        if (g10 != null) {
            ((ViewGroup) g10.findViewById(R.id.content)).addView(this.f20028k, new FrameLayout.LayoutParams(-1, -1));
            if (getVideoAdView().getVideoHeight() < getVideoAdView().getVideoWidth()) {
                g10.setRequestedOrientation(6);
            }
        }
    }

    public final void a(ViewGroup viewGroup) {
        k kVar = null;
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt instanceof k) {
                kVar = (k) childAt;
            }
        }
        if (kVar != null) {
            com.sigmob.sdk.base.utils.e.e(kVar);
        }
    }
}
