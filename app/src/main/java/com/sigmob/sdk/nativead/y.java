package com.sigmob.sdk.nativead;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.h;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.SigImage;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.views.q;
import com.sigmob.sdk.nativead.d;
import com.sigmob.sdk.nativead.m;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.natives.NativeADEventListener;
import com.sigmob.windad.natives.WindNativeAdData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/* loaded from: classes4.dex */
public class y implements m.b, View.OnTouchListener, z, d.b, View.OnClickListener, WindNativeAdData.DislikeInteractionCallback {

    /* renamed from: a */
    public static final int f20104a = 1;

    /* renamed from: b */
    public static final int f20105b = 2;

    /* renamed from: c */
    public static final int f20106c = 3;

    /* renamed from: d */
    public static final int f20107d = 4;

    /* renamed from: e */
    public static Stack<u> f20108e = new Stack<>();
    public boolean A;
    public int B;
    public boolean E;
    public boolean F;
    public boolean G;
    public List<View> H;
    public long I;
    public View K;
    public boolean L;
    public WindNativeAdData.DislikeInteractionCallback M;
    public boolean N;
    public u O;

    /* renamed from: f */
    public WindNativeAdData f20109f;

    /* renamed from: g */
    public BaseAdUnit f20110g;

    /* renamed from: h */
    public h f20111h;

    /* renamed from: i */
    public o f20112i;

    /* renamed from: j */
    public m f20113j;

    /* renamed from: m */
    public com.sigmob.sdk.nativead.d f20116m;

    /* renamed from: n */
    public k f20117n;

    /* renamed from: o */
    public MotionEvent f20118o;

    /* renamed from: p */
    public com.sigmob.sdk.nativead.c f20119p;

    /* renamed from: q */
    public NativeADEventListener f20120q;

    /* renamed from: r */
    public boolean f20121r;

    /* renamed from: s */
    public boolean f20122s;

    /* renamed from: t */
    public ViewGroup f20123t;

    /* renamed from: u */
    public ViewGroup.LayoutParams f20124u;

    /* renamed from: v */
    public Bitmap f20125v;

    /* renamed from: w */
    public com.sigmob.sdk.base.views.q f20126w;

    /* renamed from: x */
    public boolean f20127x;

    /* renamed from: y */
    public s f20128y;

    /* renamed from: z */
    public boolean f20129z;

    /* renamed from: k */
    public List<View> f20114k = new ArrayList();

    /* renamed from: l */
    public HashSet<View> f20115l = new HashSet<>();
    public boolean C = true;
    public boolean D = false;
    public List<View> J = new ArrayList();
    public q.g P = new f();

    public class a implements ImageManager.BitmapLoadedListener {
        public a() {
        }

        @Override // com.czhj.sdk.common.utils.ImageManager.BitmapLoadedListener
        public void onBitmapLoadFailed() {
        }

        @Override // com.czhj.sdk.common.utils.ImageManager.BitmapLoadedListener
        public void onBitmapLoaded(Bitmap bitmap) {
            y.this.f20125v = bitmap;
        }
    }

    public class b implements i {

        /* renamed from: a */
        public final /* synthetic */ WindNativeAdData.NativeADMediaListener f20131a;

        /* renamed from: b */
        public final /* synthetic */ q f20132b;

        public b(WindNativeAdData.NativeADMediaListener nativeADMediaListener, q qVar) {
            this.f20131a = nativeADMediaListener;
            this.f20132b = qVar;
        }

        @Override // com.sigmob.sdk.nativead.i
        public void a(long j10, long j11) {
            y.this.f20110g.getVideoCommon().end_time = this.f20132b.getCurrentPosition();
            com.sigmob.sdk.nativead.c d10 = y.this.d();
            if (d10 != null) {
                for (com.sigmob.sdk.videoAd.f fVar : d10.a(j10, j11)) {
                    y.this.z().a(fVar.getEvent(), this.f20132b.getCurrentPosition());
                    fVar.setTracked();
                }
            }
        }

        @Override // com.sigmob.sdk.nativead.i
        public void c() {
            y.this.z().a("video_restart", 0);
        }

        @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
        public void onVideoCompleted() {
            WindNativeAdData.NativeADMediaListener nativeADMediaListener = this.f20131a;
            if (nativeADMediaListener != null) {
                nativeADMediaListener.onVideoCompleted();
            }
            y.this.f20110g.getVideoCommon().end_time = this.f20132b.a();
            y.this.f20110g.getVideoCommon().is_last = 1;
            y.this.z().a("complete", this.f20132b.getCurrentPosition());
            y.this.z().a("video_link", 0);
            y.this.D = false;
            y.this.A = false;
        }

        @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
        public void onVideoError(WindAdError windAdError) {
            y.this.A = false;
            y.this.D = false;
            WindNativeAdData.NativeADMediaListener nativeADMediaListener = this.f20131a;
            if (nativeADMediaListener != null) {
                nativeADMediaListener.onVideoError(windAdError);
            }
        }

        @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
        public void onVideoLoad() {
            WindNativeAdData.NativeADMediaListener nativeADMediaListener = this.f20131a;
            if (nativeADMediaListener != null) {
                nativeADMediaListener.onVideoLoad();
            }
        }

        @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
        public void onVideoPause() {
            WindNativeAdData.NativeADMediaListener nativeADMediaListener = this.f20131a;
            if (nativeADMediaListener != null) {
                nativeADMediaListener.onVideoPause();
            }
            y.this.D = true;
            y.this.z().a("video_pause", 0);
            y.this.z().a("video_link", 0);
        }

        @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
        public void onVideoResume() {
            WindNativeAdData.NativeADMediaListener nativeADMediaListener = this.f20131a;
            if (nativeADMediaListener != null) {
                nativeADMediaListener.onVideoResume();
            }
            y.this.D = false;
            y.this.f20110g.getVideoCommon().type = 2;
            y.this.f20110g.getVideoCommon().is_first = 0;
            y.this.f20110g.getVideoCommon().begin_time = this.f20132b.getCurrentPosition();
            y.this.A = false;
            y.this.z().a("video_start", this.f20132b.getCurrentPosition());
        }

        @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
        public void onVideoStart() {
            View q10 = y.this.q();
            if (q10 != null) {
                y.this.f20110g.setAdSize(q10.getWidth(), q10.getHeight());
            }
            y.this.f20110g.getVideoCommon().video_time = this.f20132b.a();
            y.this.f20110g.getVideoCommon().is_first = 1;
            y.this.f20110g.getVideoCommon().is_last = 0;
            y.this.f20110g.getVideoCommon().end_time = 0;
            y.this.f20110g.getVideoCommon().is_auto_play = y.this.d().u() ? 1 : 2;
            if (y.this.f20122s) {
                y.this.f20110g.getVideoCommon().scene = 3;
            } else {
                y.this.f20110g.getVideoCommon().scene = 1;
            }
            if (y.this.C) {
                y.this.f20110g.getVideoCommon().type = 1;
                y.this.C = false;
            } else {
                y.this.f20110g.getVideoCommon().type = 3;
            }
            WindNativeAdData.NativeADMediaListener nativeADMediaListener = this.f20131a;
            if (nativeADMediaListener != null) {
                nativeADMediaListener.onVideoStart();
            }
            y.this.A = false;
            y.this.D = false;
            y.this.z().a("video_start", 0);
        }
    }

    public class c implements View.OnTouchListener {
        public c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1 && y.this.f20128y != null) {
                y.this.f20128y.a();
            }
            return true;
        }
    }

    public class d implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a */
        public final /* synthetic */ ViewGroup f20135a;

        public d(ViewGroup viewGroup) {
            this.f20135a = viewGroup;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f20135a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (y.this.f20110g != null) {
                this.f20135a.getLocationOnScreen(new int[2]);
                y.this.f20110g.getClickCommon().adarea_x = String.valueOf(Dips.pixelsToIntDips(r0[0], y.this.w()));
                y.this.f20110g.getClickCommon().adarea_y = String.valueOf(Dips.pixelsToIntDips(r0[1], y.this.w()));
                y.this.f20110g.getClickCommon().adarea_w = String.valueOf(Dips.pixelsToIntDips(this.f20135a.getWidth(), y.this.w()));
                y.this.f20110g.getClickCommon().adarea_h = String.valueOf(Dips.pixelsToIntDips(this.f20135a.getHeight(), y.this.w()));
            }
        }
    }

    public class e implements com.sigmob.sdk.base.common.z {
        public e() {
        }

        @Override // com.sigmob.sdk.base.common.z
        public void a(boolean z10, com.sigmob.sdk.base.a aVar) {
            com.sigmob.sdk.base.common.d0 z11;
            if (y.this.f20120q != null) {
                y.this.f20120q.onAdClicked();
            }
            if (z10 && (z11 = y.this.z()) != null) {
                z11.a("click", 0);
            }
        }
    }

    public class f implements q.g {
        public f() {
        }

        @Override // com.sigmob.sdk.base.views.q.g
        public void a(String str, String str2) {
            BaseAdUnit baseAdUnit = y.this.f20110g;
            if (baseAdUnit != null) {
                baseAdUnit.getClickCommon().sld = "0";
                y.this.f20110g.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
                y.this.f20110g.getClickCommon().click_scene = "appinfo";
                y.this.f20110g.getClickCommon().is_final_click = true;
                if (y.this.f20127x) {
                    y.this.d().b(com.sigmob.sdk.base.a.PREVIEW, str, str2, true);
                }
            }
        }

        @Override // com.sigmob.sdk.base.views.q.g
        public void b() {
            if (y.this.f20112i != null) {
                y.this.A().pause();
            }
            y.this.z().a(com.sigmob.sdk.base.common.a.f17653f, 0);
        }

        @Override // com.sigmob.sdk.base.views.q.g
        public void a() {
            if (y.this.f20126w != null) {
                y.this.f20126w.dismiss();
                y.this.f20126w.b();
                y.this.f20126w = null;
            }
            y.this.f20127x = false;
            y.this.f20110g.getClickCommon().click_scene = "preview";
            if (y.this.f20112i != null) {
                y.this.A().start();
            }
            y.this.z().a(com.sigmob.sdk.base.common.a.f17654g, 0);
        }
    }

    public class g implements com.sigmob.sdk.nativead.b {
        public g() {
        }

        @Override // com.sigmob.sdk.nativead.b
        public void a() {
            y.this.a(4, (MotionEvent) null);
        }
    }

    public q A() {
        if (s() != null) {
            return this.f20112i.getSigVideoAdController();
        }
        return null;
    }

    public double B() {
        return A() != null ? r0.a() : l5.c.f27899e;
    }

    public double C() {
        return A() != null ? r0.c() : l5.c.f27899e;
    }

    public final boolean D() {
        return this.f20110g.getAd().expired_time.intValue() != 0 && System.currentTimeMillis() - this.f20110g.getCreate_time() > ((long) this.f20110g.getAdExpiredTime().intValue());
    }

    public final boolean E() {
        return false;
    }

    public boolean F() {
        com.sigmob.sdk.nativead.d dVar = this.f20116m;
        if (dVar != null) {
            return dVar.a(this.f20110g);
        }
        return false;
    }

    public final void G() {
        try {
            Activity a10 = com.sigmob.sdk.base.utils.e.a(q());
            if (this.f20126w == null && a10 != null) {
                com.sigmob.sdk.base.views.q qVar = new com.sigmob.sdk.base.views.q(a10, this.f20110g);
                this.f20126w = qVar;
                qVar.a(this.P);
            }
            com.sigmob.sdk.base.views.q qVar2 = this.f20126w;
            if (qVar2 == null || !qVar2.e() || this.f20127x) {
                return;
            }
            this.f20110g.getClickCommon().click_area = "appinfo";
            this.f20126w.show();
            this.f20127x = true;
        } catch (Exception e10) {
            SigmobLog.e("openFourElements fail:" + e10.getMessage());
        }
    }

    public void H() {
        q A;
        if (this.f20122s || (A = A()) == null) {
            return;
        }
        this.A = true;
        A.pause();
    }

    public void I() {
        q A;
        if (this.f20122s || (A = A()) == null) {
            return;
        }
        A.d();
    }

    public void J() {
        o oVar;
        if (this.f20123t != null && (oVar = this.f20112i) != null) {
            ViewParent parent = oVar.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(this.f20112i);
            }
            this.f20123t.removeAllViews();
            ViewGroup.LayoutParams layoutParams = this.f20124u;
            if (layoutParams != null) {
                this.f20123t.addView(this.f20112i, layoutParams);
            } else {
                this.f20123t.addView(this.f20112i);
            }
            if (!this.f20115l.contains(this.f20112i)) {
                this.f20115l.add(this.f20112i);
            }
        }
        this.f20123t = null;
        this.f20124u = null;
    }

    public void K() {
        Bundle bundle = new Bundle();
        if (this.f20112i != null && d().v()) {
            b0 b0Var = new b0();
            int[] iArr = new int[2];
            this.f20112i.getLocationOnScreen(iArr);
            b0Var.c(iArr[0]);
            b0Var.d(iArr[1]);
            b0Var.b(this.f20112i.getMeasuredWidth());
            b0Var.a(this.f20112i.getMeasuredHeight());
            bundle.putParcelable("attr", b0Var);
            this.f20123t = (ViewGroup) this.f20112i.getParent();
            this.f20124u = this.f20112i.getLayoutParams();
            w.a(this.f20112i);
            SigMacroCommon macroCommon = this.f20110g.getMacroCommon();
            if (macroCommon != null) {
                macroCommon.addMarcoKey(SigMacroCommon._SCENE_, "3");
            }
            this.f20122s = true;
        }
        k kVar = this.f20117n;
        if (kVar != null) {
            kVar.setVisibility(4);
        }
        y().a(this.f20110g, bundle);
    }

    public void L() {
        q A;
        if (this.f20122s || (A = A()) == null) {
            return;
        }
        A.start();
    }

    public void M() {
        q A;
        if (this.f20122s || (A = A()) == null) {
            return;
        }
        A.b();
    }

    public void N() {
        a(this.f20115l, (View.OnTouchListener) null);
        a(this.f20114k, (View.OnTouchListener) null);
        HashSet<View> hashSet = this.f20115l;
        if (hashSet != null) {
            hashSet.clear();
        }
        List<View> list = this.f20114k;
        if (list != null) {
            list.clear();
        }
        List<View> list2 = this.J;
        if (list2 != null) {
            list2.clear();
        }
        this.f20120q = null;
        this.f20111h = null;
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void a(BaseAdUnit baseAdUnit) {
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void b(BaseAdUnit baseAdUnit, String str) {
    }

    @Override // com.sigmob.sdk.nativead.d.b
    public void g() {
    }

    @Override // com.sigmob.sdk.nativead.m.b
    public void k() {
        if (this.f20122s || w() == null || !this.F) {
            return;
        }
        HashSet<View> hashSet = this.f20115l;
        if (hashSet != null) {
            hashSet.clear();
        }
        this.F = false;
        u uVar = this.O;
        if (uVar != null) {
            uVar.d();
            f20108e.remove(this.O);
        }
        SigmobLog.d("------------onAdViewRemoved----------" + hashCode());
        q A = A();
        if (A != null) {
            A.pause();
        }
        this.E = false;
        m mVar = this.f20113j;
        if (mVar != null && mVar.hasWindowFocus()) {
            this.f20129z = false;
        }
        com.sigmob.sdk.base.common.d0 z10 = z();
        if (z10 != null) {
            z10.a("ad_hide", 0);
        }
        if (this.C || this.D || z10 == null) {
            return;
        }
        z10.a("video_link", 0);
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void l(BaseAdUnit baseAdUnit) {
    }

    @Override // com.sigmob.sdk.base.common.o.c
    public void m() {
        if (d() != null) {
            d().b(w(), this.f20110g);
        }
    }

    @Override // com.sigmob.sdk.base.common.o.c
    public void n() {
        if (d() != null) {
            d().a(w(), this.f20110g);
        }
    }

    @Override // com.sigmob.sdk.nativead.m.b
    public void o() {
        if (this.F || this.f20122s) {
            return;
        }
        this.F = true;
        SigmobLog.d("----------onAdViewShow------------" + hashCode());
        this.A = false;
        this.E = false;
        View q10 = q();
        if (q10 != null) {
            d().a(com.sigmob.sdk.base.utils.e.b(q10), this.f20110g, this.P);
            q10.setOnTouchListener(this);
        }
        o oVar = this.f20112i;
        if (oVar != null && !this.f20115l.contains(oVar)) {
            this.f20115l.add(this.f20112i);
        } else if (this.H != null) {
            if (this.f20115l.isEmpty()) {
                this.f20115l.addAll(this.H);
            } else {
                for (View view : this.H) {
                    if (!this.f20115l.contains(view)) {
                        this.f20115l.add(view);
                    }
                }
            }
        }
        u uVar = this.O;
        if (uVar != null && !this.f20115l.contains(uVar)) {
            this.f20115l.add(this.O);
        }
        this.f20115l.addAll(this.J);
        a(this.f20114k, this);
        com.sigmob.sdk.base.common.d0 z10 = z();
        if (z10 != null) {
            z10.a("start", 0);
        }
    }

    @Override // com.sigmob.sdk.nativead.d.b
    public void onAdDetailDismiss() {
        this.f20122s = false;
        NativeADEventListener nativeADEventListener = this.f20120q;
        if (nativeADEventListener != null) {
            nativeADEventListener.onAdDetailDismiss();
        }
        if (d() != null) {
            d().d(w(), this.f20110g);
        }
        J();
        k kVar = this.f20117n;
        if (kVar != null) {
            kVar.setVisibility(0);
        }
        com.sigmob.sdk.nativead.d dVar = this.f20116m;
        if (dVar != null) {
            dVar.b(this.f20110g);
        }
        View q10 = q();
        if (q10 != null) {
            d().a(com.sigmob.sdk.base.utils.e.b(q10), this.f20110g, this.P);
        }
    }

    @Override // com.sigmob.sdk.nativead.d.b
    public void onAdDetailShow() {
        SigmobLog.d("----------onAdDetailShow----------");
        if (d() != null) {
            d().e(w(), this.f20110g);
        }
        this.f20122s = true;
        NativeADEventListener nativeADEventListener = this.f20120q;
        if (nativeADEventListener != null) {
            nativeADEventListener.onAdDetailShow();
        }
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
    public void onCancel() {
        WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback = this.M;
        if (dislikeInteractionCallback != null) {
            dislikeInteractionCallback.onCancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
    public void onSelected(int i10, String str, boolean z10) {
        WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback = this.M;
        if (dislikeInteractionCallback != null) {
            dislikeInteractionCallback.onSelected(i10, str, z10);
        }
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
    public void onShow() {
        WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback = this.M;
        if (dislikeInteractionCallback != null) {
            dislikeInteractionCallback.onShow();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        if ((motionEvent.getAction() != 0 || this.I <= 0 || System.currentTimeMillis() - this.I >= 500) && this.f20110g != null) {
            try {
                if (motionEvent.getAction() != 1) {
                    this.I = System.currentTimeMillis();
                    this.f20118o = motionEvent;
                    return true;
                }
                this.f20110g.getClickCommon().click_scene = "preview";
                this.f20110g.getClickCommon().sld = "0";
                if (view == this.f20117n) {
                    SigmobLog.d("click mSigAppInfoView");
                    a(1, motionEvent);
                    return true;
                }
                SigmobLog.d("click " + view);
                List<View> list = this.f20114k;
                int i10 = 3;
                if (list != null) {
                    if ((list.contains(view) ? view : a(this.f20114k, motionEvent)) != null) {
                        SigmobLog.d("click ctaClickView");
                        this.f20110g.getClickCommon().click_scene = "preview";
                        this.f20110g.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
                        a(3, motionEvent);
                        return true;
                    }
                }
                HashSet<View> hashSet = this.f20115l;
                if (hashSet != null) {
                    if (!hashSet.contains(view)) {
                        view = a(this.f20115l, motionEvent);
                    }
                    if (view != null) {
                        SigmobLog.d("click mCreativeViews");
                        o oVar = this.f20112i;
                        if (oVar == null || !oVar.a(motionEvent)) {
                            i10 = 2;
                        }
                        a(i10, motionEvent);
                        return true;
                    }
                }
            } catch (Throwable th2) {
                SigmobLog.e("onTouch error", th2);
            }
        }
        return false;
    }

    public void p() {
        BaseAdUnit baseAdUnit = this.f20110g;
        SigmobLog.i(String.format("native ad data %s is Destroy", baseAdUnit != null ? baseAdUnit.getVid() : "null"));
        N();
        List<View> list = this.H;
        if (list != null) {
            list.clear();
        }
        o oVar = this.f20112i;
        if (oVar != null) {
            com.sigmob.sdk.base.utils.e.e(oVar);
            this.f20112i.d();
            this.f20112i = null;
        }
        BaseAdUnit baseAdUnit2 = this.f20110g;
        if (baseAdUnit2 != null && baseAdUnit2.getSessionManager() != null) {
            z().a("ad_hide", 0);
            z().a();
        }
        u uVar = this.O;
        if (uVar != null) {
            uVar.a();
            f20108e.remove(this.O);
            com.sigmob.sdk.base.utils.e.e(this.O);
            this.O = null;
        }
        com.sigmob.sdk.base.common.h.s().e(this.f20110g);
        com.sigmob.sdk.base.common.h.d(this.f20110g);
        com.sigmob.sdk.base.views.q qVar = this.f20126w;
        if (qVar != null) {
            qVar.dismiss();
            this.f20126w.b();
            this.f20126w = null;
        }
        s sVar = this.f20128y;
        if (sVar != null && (sVar instanceof com.sigmob.sdk.nativead.a)) {
            sVar.a(null);
            com.sigmob.sdk.nativead.a aVar = (com.sigmob.sdk.nativead.a) this.f20128y;
            aVar.dismiss();
            aVar.b();
            this.f20128y = null;
        }
        this.M = null;
        this.P = null;
        m mVar = this.f20113j;
        if (mVar != null) {
            mVar.setAdVisibilityStatusChangeListener(null);
            com.sigmob.sdk.base.utils.e.e(this.f20113j);
            this.f20113j = null;
        }
        com.sigmob.sdk.nativead.d dVar = this.f20116m;
        if (dVar != null) {
            dVar.b(this.f20110g);
            this.f20116m = null;
        }
        BaseAdUnit baseAdUnit3 = this.f20110g;
        if (baseAdUnit3 != null) {
            baseAdUnit3.destroy();
            this.f20110g = null;
        }
    }

    public final View q() {
        View view;
        m mVar = this.f20113j;
        if (mVar == null || (view = (View) mVar.getParent()) == null) {
            return null;
        }
        return view;
    }

    public Bitmap r() {
        return this.f20125v;
    }

    public View s() {
        return this.f20112i;
    }

    public int t() {
        View q10 = q();
        if (s() == null || q10 == null || q10.getWidth() <= 0) {
            return 720;
        }
        return (int) (q10.getWidth() / this.f20110g.getAdPercent());
    }

    public int u() {
        int width;
        View q10 = q();
        if (this.f20112i == null || q10 == null || (width = q10.getWidth()) <= 0) {
            return 1280;
        }
        return width;
    }

    public String v() {
        return a().getCTAText();
    }

    public final Context w() {
        return com.sigmob.sdk.a.d();
    }

    public String x() {
        BiddingResponse biddingResponse;
        BaseAdUnit baseAdUnit = this.f20110g;
        return (baseAdUnit == null || (biddingResponse = baseAdUnit.bidding_response) == null) ? "" : String.valueOf(biddingResponse.ecpm);
    }

    public com.sigmob.sdk.nativead.d y() {
        if (this.f20116m == null) {
            this.f20116m = new com.sigmob.sdk.nativead.d(this);
        }
        return this.f20116m;
    }

    public com.sigmob.sdk.base.common.d0 z() {
        BaseAdUnit baseAdUnit = this.f20110g;
        if (baseAdUnit == null) {
            return null;
        }
        com.sigmob.sdk.base.common.d0 sessionManager = baseAdUnit.getSessionManager();
        if (sessionManager != null) {
            return sessionManager;
        }
        com.sigmob.sdk.nativead.f fVar = new com.sigmob.sdk.nativead.f();
        fVar.a(this.f20110g);
        return fVar;
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void g(BaseAdUnit baseAdUnit) {
    }

    @Override // com.sigmob.sdk.nativead.z
    public WindNativeAdData h() {
        return this.f20109f;
    }

    @Override // com.sigmob.sdk.nativead.m.b
    public void i() {
        if (this.E) {
            u uVar = this.O;
            if (uVar != null) {
                uVar.d();
                f20108e.remove(this.O);
            }
            q A = A();
            if (A != null) {
                A.pause();
            }
            SigmobLog.d("-----------onAdViewPauseImpression---------");
            this.E = false;
        }
    }

    @Override // com.sigmob.sdk.nativead.m.b
    public void l() {
        u lastElement;
        u uVar;
        if (this.O != null && !f20108e.isEmpty() && (lastElement = f20108e.lastElement()) != null && lastElement == (uVar = this.O)) {
            uVar.e();
        }
        if (this.f20122s || this.E) {
            return;
        }
        this.E = true;
        u uVar2 = this.O;
        if (uVar2 != null && !f20108e.contains(uVar2)) {
            f20108e.push(this.O);
            this.O.e();
        }
        o oVar = this.f20112i;
        if (oVar == null || oVar.getParent() == null) {
            return;
        }
        if (!this.A && d().u()) {
            A().start();
        }
        SigmobLog.d("------------onAdViewStartImpression------------");
    }

    @Override // com.sigmob.sdk.nativead.z
    public com.sigmob.sdk.nativead.c d() {
        if (this.f20119p == null) {
            this.f20119p = (com.sigmob.sdk.nativead.c) this.f20110g.getAdConfig();
        }
        return this.f20119p;
    }

    public void b(ViewGroup viewGroup, WindNativeAdData.NativeADMediaListener nativeADMediaListener) {
        this.N = true;
        a(viewGroup, nativeADMediaListener);
    }

    @Override // com.sigmob.sdk.base.common.o.b
    public void d(BaseAdUnit baseAdUnit) {
        o oVar = this.f20112i;
        if (oVar != null) {
            ViewGroup.LayoutParams layoutParams = ((View) oVar.getParent()).getLayoutParams();
            SigmobLog.d("visibilityStatusChange() called with: isVisible = [" + layoutParams.width + ":" + layoutParams.height + "]");
        }
    }

    @Override // com.sigmob.sdk.nativead.z
    public k b() {
        if (!this.N && this.f20117n == null && this.f20110g.getadPrivacy() != null) {
            k kVar = new k(w());
            this.f20117n = kVar;
            kVar.setOnTouchListener(this);
            this.f20117n.a(this.f20110g.getAppVersion(), this.f20110g.getCompanyName());
        }
        return this.f20117n;
    }

    public final m b(ViewGroup viewGroup) {
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt instanceof m) {
                return (m) childAt;
            }
        }
        return null;
    }

    public void a(List<ImageView> list, int i10) {
        List<SigImage> imageUrlList = a().getImageUrlList();
        if (list == null || imageUrlList == null) {
            return;
        }
        int min = Math.min(list.size(), imageUrlList.size());
        for (int i11 = 0; i11 < min; i11++) {
            SigImage sigImage = imageUrlList.get(i11);
            ImageView imageView = list.get(i11);
            if (!this.f20115l.contains(imageView)) {
                this.f20115l.add(imageView);
            }
            List<View> list2 = this.H;
            if (list2 == null) {
                this.H = new ArrayList();
            } else {
                list2.clear();
            }
            this.H.add(imageView);
            com.sigmob.sdk.base.common.h.o().load(sigImage.getImageUrl()).placeholder(i10).error(i10).into(imageView);
        }
    }

    public void b(boolean z10) {
        q A;
        if (this.f20122s || (A = A()) == null) {
            return;
        }
        A.a(z10);
    }

    public void a(ViewGroup viewGroup, WindNativeAdData.NativeADMediaListener nativeADMediaListener) {
        if (viewGroup == null) {
            return;
        }
        o oVar = (o) com.sigmob.sdk.base.utils.e.a(viewGroup, o.class);
        if (oVar != null) {
            this.f20112i = oVar;
        } else {
            com.sigmob.sdk.base.utils.e.e(this.f20112i);
            this.f20112i = new o(viewGroup.getContext().getApplicationContext());
        }
        if (oVar == null) {
            com.sigmob.sdk.base.utils.e.e(this.f20112i);
            viewGroup.addView(this.f20112i, new ViewGroup.LayoutParams(-1, -2));
        }
        if (!this.f20115l.contains(this.f20112i)) {
            this.f20115l.add(this.f20112i);
        }
        if (!this.f20110g.equals(this.f20112i.getAdUnit())) {
            this.f20112i.a(this);
        }
        q sigVideoAdController = this.f20112i.getSigVideoAdController();
        if (sigVideoAdController != null) {
            sigVideoAdController.a(new b(nativeADMediaListener, sigVideoAdController));
        }
    }

    @Override // com.sigmob.sdk.nativead.z
    public BaseAdUnit a() {
        return this.f20110g;
    }

    public final View a(HashSet<View> hashSet, MotionEvent motionEvent) {
        if (hashSet == null) {
            return null;
        }
        Iterator<View> it = hashSet.iterator();
        while (it.hasNext()) {
            View next = it.next();
            if (com.sigmob.sdk.base.utils.e.a(next, motionEvent)) {
                return next;
            }
        }
        return null;
    }

    public final View a(List<View> list, MotionEvent motionEvent) {
        if (list == null) {
            return null;
        }
        for (View view : list) {
            if (com.sigmob.sdk.base.utils.e.a(view, motionEvent)) {
                return view;
            }
        }
        return null;
    }

    public final o a(ViewGroup viewGroup) {
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt instanceof o) {
                return (o) childAt;
            }
        }
        return null;
    }

    public View a(int i10, int i11) {
        if (this.O == null) {
            u uVar = new u(w());
            if (!uVar.a((int) this.f20110g.getWidgetId(0), this.f20110g.getSensitivity(), this.f20110g.getClickCommon())) {
                return null;
            }
            uVar.setMotionActionListener(new g());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(Dips.dipsToIntPixels(i10, w()), Dips.dipsToIntPixels(i11, w()));
            layoutParams.gravity = 17;
            uVar.setLayoutParams(layoutParams);
            this.O = uVar;
        }
        return this.O;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(int r8, android.view.MotionEvent r9) {
        /*
            r7 = this;
            com.sigmob.sdk.base.models.BaseAdUnit r0 = r7.f20110g
            com.sigmob.sdk.base.common.h.a(r0)
            if (r9 == 0) goto L2c
            android.view.View r0 = r7.q()
            com.czhj.sdk.common.utils.TouchLocation r9 = com.czhj.sdk.common.utils.TouchLocation.getTouchLocation(r0, r9)
            android.view.View r0 = r7.q()
            android.view.MotionEvent r1 = r7.f20118o
            com.czhj.sdk.common.utils.TouchLocation r0 = com.czhj.sdk.common.utils.TouchLocation.getTouchLocation(r0, r1)
            com.sigmob.sdk.base.models.BaseAdUnit r1 = r7.f20110g
            com.sigmob.sdk.base.models.ClickCommon r1 = r1.getClickCommon()
            r1.down = r0
            com.sigmob.sdk.base.models.BaseAdUnit r1 = r7.f20110g
            com.sigmob.sdk.base.models.ClickCommon r1 = r1.getClickCommon()
            r1.up = r0
            r3 = r9
            r2 = r0
            goto L2f
        L2c:
            r9 = 0
            r2 = r9
            r3 = r2
        L2f:
            com.sigmob.sdk.base.models.BaseAdUnit r9 = r7.f20110g
            com.sigmob.sdk.base.models.ClickCommon r9 = r9.getClickCommon()
            java.lang.String r0 = "preview"
            r9.click_scene = r0
            java.lang.String r9 = "click"
            r0 = 1
            r1 = 0
            if (r8 == r0) goto Lc2
            r4 = 2
            if (r8 == r4) goto L4e
            r9 = 3
            if (r8 == r9) goto L4c
            r9 = 4
            if (r8 == r9) goto L4a
            goto Lc1
        L4a:
            r8 = 0
            goto L72
        L4c:
            r8 = 0
            goto L7f
        L4e:
            boolean r8 = r7.E()
            com.sigmob.sdk.base.models.BaseAdUnit r5 = r7.f20110g
            com.sigmob.sdk.base.models.ClickCommon r5 = r5.getClickCommon()
            java.lang.String r6 = "material"
            r5.click_area = r6
            if (r8 == 0) goto L71
            com.sigmob.sdk.base.models.BaseAdUnit r8 = r7.f20110g
            com.sigmob.sdk.base.models.ClickCommon r8 = r8.getClickCommon()
            r8.is_final_click = r1
            com.sigmob.sdk.base.common.d0 r8 = r7.z()
            r8.a(r9, r1)
            r7.K()
            return
        L71:
            r8 = 1
        L72:
            if (r8 != 0) goto L7f
            com.sigmob.sdk.base.models.BaseAdUnit r8 = r7.f20110g
            com.sigmob.sdk.base.models.ClickCommon r8 = r8.getClickCommon()
            java.lang.String r9 = "component"
            r8.click_area = r9
            r8 = 1
        L7f:
            if (r8 != 0) goto L8b
            com.sigmob.sdk.base.models.BaseAdUnit r8 = r7.f20110g
            com.sigmob.sdk.base.models.ClickCommon r8 = r8.getClickCommon()
            java.lang.String r9 = "btn"
            r8.click_area = r9
        L8b:
            boolean r8 = r7.N
            if (r8 != 0) goto L98
            com.sigmob.windad.natives.WindNativeAdData r8 = r7.f20109f
            int r8 = r8.getAdPatternType()
            if (r8 != r0) goto L98
            goto Lb8
        L98:
            com.sigmob.sdk.base.models.BaseAdUnit r8 = r7.f20110g
            int r8 = r8.getInteractionType()
            if (r8 != r4) goto Lb8
            com.sigmob.sdk.base.models.BaseAdUnit r8 = r7.f20110g
            com.sigmob.sdk.base.models.ClickCommon r8 = r8.getClickCommon()
            r8.is_final_click = r1
        La8:
            com.sigmob.sdk.nativead.c r0 = r7.d()
            android.content.Context r1 = r7.w()
            com.sigmob.sdk.base.a r4 = com.sigmob.sdk.base.a.PREVIEW
            com.sigmob.sdk.base.models.BaseAdUnit r5 = r7.f20110g
            r0.a(r1, r2, r3, r4, r5)
            goto Lc1
        Lb8:
            com.sigmob.sdk.base.models.BaseAdUnit r8 = r7.f20110g
            com.sigmob.sdk.base.models.ClickCommon r8 = r8.getClickCommon()
            r8.is_final_click = r0
            goto La8
        Lc1:
            return
        Lc2:
            com.sigmob.sdk.base.models.BaseAdUnit r8 = r7.f20110g
            com.sigmob.sdk.base.models.ClickCommon r8 = r8.getClickCommon()
            java.lang.String r0 = "appinfo"
            r8.click_area = r0
            com.sigmob.sdk.base.models.BaseAdUnit r8 = r7.f20110g
            com.sigmob.sdk.base.models.ClickCommon r8 = r8.getClickCommon()
            r8.is_final_click = r1
            com.sigmob.sdk.base.common.d0 r8 = r7.z()
            if (r8 == 0) goto Ldd
            r8.a(r9, r1)
        Ldd:
            r7.G()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.nativead.y.a(int, android.view.MotionEvent):void");
    }

    public void a(BaseAdUnit baseAdUnit, WindNativeAdData windNativeAdData) {
        this.f20110g = baseAdUnit;
        this.f20109f = windNativeAdData;
        com.sigmob.sdk.base.common.h.o().getBitmap(a().getAd_source_logo(), new a());
    }

    public final boolean a(MotionEvent motionEvent) {
        o oVar = this.f20112i;
        if (oVar != null) {
            return oVar.a(motionEvent);
        }
        return false;
    }

    @Override // com.sigmob.sdk.nativead.m.b
    public void a(boolean z10) {
        if (this.f20129z) {
            return;
        }
        if (!this.f20122s) {
            com.sigmob.sdk.base.common.h.s().e(this.f20110g);
            if (z10) {
                NativeADEventListener nativeADEventListener = this.f20120q;
                if (nativeADEventListener != null) {
                    nativeADEventListener.onAdExposed();
                }
                z().a("ad_show", 0);
            }
        }
        this.f20129z = z10;
    }

    public void a(View view, List<View> list, List<View> list2, View view2, NativeADEventListener nativeADEventListener) {
        m mVar;
        ViewGroup.LayoutParams layoutParams;
        if (view == null) {
            if (nativeADEventListener != null) {
                nativeADEventListener.onAdError(WindAdError.ERROR_SIGMOB_ADCONTAINER_IS_NULL);
                return;
            }
            return;
        }
        if (!(view instanceof ViewGroup)) {
            if (nativeADEventListener != null) {
                nativeADEventListener.onAdError(WindAdError.ERROR_SIGMOB_ADCONTAINER_NOT_VIEWGROUP);
                return;
            }
            return;
        }
        if (com.sigmob.sdk.a.h() == null) {
            com.sigmob.sdk.a.a(com.sigmob.sdk.base.utils.e.a(view));
        }
        if (view2 != null) {
            if (this.f20128y == null) {
                com.sigmob.sdk.nativead.a aVar = new com.sigmob.sdk.nativead.a(view2.getContext(), this.f20110g);
                this.f20128y = aVar;
                aVar.a(this);
            }
            view2.setOnTouchListener(new c());
        }
        ViewGroup viewGroup = (ViewGroup) view;
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new d(viewGroup));
        u uVar = (u) com.sigmob.sdk.base.utils.e.a(viewGroup, u.class);
        if (uVar != null && uVar != this.O) {
            com.sigmob.sdk.base.utils.e.e(uVar);
        }
        d().a(new e());
        if (list2 != null) {
            this.f20114k = list2;
        }
        List<View> list3 = this.J;
        if (list3 != null) {
            this.f20115l.removeAll(list3);
        }
        if (list != null) {
            this.J = list;
        }
        this.f20120q = nativeADEventListener;
        y().a((Map<String, Object>) null, this.f20110g);
        com.sigmob.sdk.base.common.h.s().a(this.f20110g, (h.f) null);
        m mVar2 = this.f20113j;
        if (mVar2 == null) {
            m b10 = b(viewGroup);
            this.f20113j = b10;
            if (b10 == null) {
                mVar = new m(w());
                this.f20113j = mVar;
                layoutParams = new ViewGroup.LayoutParams(0, 0);
            }
            this.f20115l.addAll(this.J);
            this.f20113j.setAdVisibilityStatusChangeListener(this);
            this.f20113j.a(d().o(), d().p());
        }
        com.sigmob.sdk.base.utils.e.e(mVar2);
        mVar = this.f20113j;
        layoutParams = new ViewGroup.LayoutParams(0, 0);
        viewGroup.addView(mVar, layoutParams);
        this.f20115l.addAll(this.J);
        this.f20113j.setAdVisibilityStatusChangeListener(this);
        this.f20113j.a(d().o(), d().p());
    }

    public void a(WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback) {
        this.M = dislikeInteractionCallback;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(View view, int i10, int i11) {
        LinearLayout.LayoutParams layoutParams;
        if (view.getParent() instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams2.width = i10;
            layoutParams2.height = i11;
            layoutParams = layoutParams2;
        } else if (view.getParent() instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams3.width = i10;
            layoutParams3.height = i11;
            layoutParams = layoutParams3;
        } else {
            if (!(view.getParent() instanceof LinearLayout)) {
                return;
            }
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams4.width = i10;
            layoutParams4.height = i11;
            layoutParams = layoutParams4;
        }
        view.setLayoutParams(layoutParams);
        view.requestLayout();
    }

    public void a(HashSet<View> hashSet, View.OnTouchListener onTouchListener) {
        if (hashSet != null) {
            Iterator<View> it = hashSet.iterator();
            while (it.hasNext()) {
                View next = it.next();
                if (next != null) {
                    next.setOnClickListener(null);
                    next.setOnTouchListener(null);
                    next.setOnTouchListener(onTouchListener);
                }
            }
        }
    }

    public void a(List<View> list, View.OnTouchListener onTouchListener) {
        if (list != null) {
            for (View view : list) {
                if (view != null) {
                    view.setOnClickListener(null);
                    view.setOnTouchListener(null);
                    view.setOnTouchListener(onTouchListener);
                }
            }
        }
    }
}
