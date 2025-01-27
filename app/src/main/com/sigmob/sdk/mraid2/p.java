package com.sigmob.sdk.mraid2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.Sigmob;
import com.sigmob.sdk.base.common.AdActivity;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.common.j0;
import com.sigmob.sdk.base.common.l0;
import com.sigmob.sdk.base.common.u;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.views.p0;
import com.sigmob.sdk.base.views.w;
import com.sigmob.sdk.mraid2.d;
import com.sigmob.sdk.videoAd.BaseAdActivity;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.natives.WindNativeAdData;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class p extends com.sigmob.sdk.videoAd.c {

    /* renamed from: i */
    public int f19840i;

    /* renamed from: j */
    public boolean f19841j;

    /* renamed from: k */
    public com.sigmob.sdk.mraid2.d f19842k;

    /* renamed from: l */
    public p0 f19843l;

    /* renamed from: m */
    public com.sigmob.sdk.nativead.a f19844m;

    /* renamed from: n */
    public boolean f19845n;

    /* renamed from: o */
    public List<BaseAdUnit> f19846o;

    /* renamed from: p */
    public boolean f19847p;

    /* renamed from: q */
    public boolean f19848q;

    /* renamed from: r */
    public boolean f19849r;

    /* renamed from: s */
    public w f19850s;

    /* renamed from: t */
    public View.OnClickListener f19851t;

    public class a implements d.InterfaceC0605d {

        /* renamed from: com.sigmob.sdk.mraid2.p$a$a */
        public class C0610a implements WindNativeAdData.DislikeInteractionCallback {
            public C0610a() {
            }

            @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
            public void onCancel() {
                com.sigmob.sdk.mraid2.g d10;
                com.sigmob.sdk.mraid2.c mraidBridge;
                if (p.this.f19842k != null && (d10 = p.this.f19842k.d()) != null && (mraidBridge = d10.getMraidBridge()) != null) {
                    mraidBridge.a("feedbackDidDisappear", (HashMap<String, Object>) null);
                }
                if (p.this.f19844m != null) {
                    p.this.f19844m.dismiss();
                    p.this.f19844m.b();
                    p.this.f19844m = null;
                }
            }

            @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
            public void onSelected(int i10, String str, boolean z10) {
                com.sigmob.sdk.mraid2.g d10;
                com.sigmob.sdk.mraid2.c mraidBridge;
                if (p.this.f19842k != null && (d10 = p.this.f19842k.d()) != null && (mraidBridge = d10.getMraidBridge()) != null) {
                    mraidBridge.a("feedbackDidDisappear", (HashMap<String, Object>) null);
                }
                if (p.this.f19844m != null) {
                    p.this.f19844m.dismiss();
                    p.this.f19844m.b();
                    p.this.f19844m = null;
                }
            }

            @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
            public void onShow() {
                com.sigmob.sdk.mraid2.g d10;
                com.sigmob.sdk.mraid2.c mraidBridge;
                if (p.this.f19842k == null || (d10 = p.this.f19842k.d()) == null || (mraidBridge = d10.getMraidBridge()) == null) {
                    return;
                }
                mraidBridge.a("feedbackDidAppear", (HashMap<String, Object>) null);
            }
        }

        public a() {
        }

        @Override // com.sigmob.sdk.mraid2.d.InterfaceC0605d
        public boolean a(String str, JsResult jsResult) {
            return false;
        }

        @Override // com.sigmob.sdk.mraid2.d.InterfaceC0605d
        public void b() {
            p.this.d();
        }

        @Override // com.sigmob.sdk.mraid2.d.InterfaceC0605d
        public void a(int i10, int i11, int i12, int i13) {
            try {
                p.this.f19842k.b();
                if (i13 == 0) {
                    p.this.i().setBackgroundColor(0);
                } else {
                    p.this.i().setBackgroundColor(Color.argb((int) ((i13 / 100.0f) * 255.0f), i10, i11, i12));
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }

        @Override // com.sigmob.sdk.mraid2.d.InterfaceC0605d
        public void a() {
            p.this.c();
        }

        @Override // com.sigmob.sdk.mraid2.d.InterfaceC0605d
        public boolean a(ConsoleMessage consoleMessage) {
            if (h.f19883a[consoleMessage.messageLevel().ordinal()] == 1) {
                SigmobLog.e("onConsoleMessage " + consoleMessage.message());
                b0.a("h5_error", "mraid2", 0, consoleMessage.message(), (WindAdRequest) null, (LoadAdRequest) null, p.this.f19846o.get(0), (b0.g) null);
            }
            return false;
        }

        @Override // com.sigmob.sdk.mraid2.d.InterfaceC0605d
        public void a(BaseAdUnit baseAdUnit) {
            List<BaseAdUnit> list;
            if (baseAdUnit == null && (list = p.this.f19846o) != null) {
                baseAdUnit = list.get(0);
            }
            Activity f10 = p.this.f();
            if (f10 == null || baseAdUnit == null) {
                return;
            }
            p.this.f19844m = new com.sigmob.sdk.nativead.a(f10, baseAdUnit);
            if (p.this.f19844m != null) {
                p.this.f19844m.a();
            }
            p.this.f19844m.a(new C0610a());
        }
    }

    public class b implements d.e {

        public class a implements l0.a {

            /* renamed from: a */
            public final /* synthetic */ com.sigmob.sdk.mraid2.g f19855a;

            /* renamed from: b */
            public final /* synthetic */ BaseAdUnit f19856b;

            /* renamed from: c */
            public final /* synthetic */ String f19857c;

            /* renamed from: d */
            public final /* synthetic */ JSONObject f19858d;

            /* renamed from: e */
            public final /* synthetic */ String f19859e;

            /* renamed from: f */
            public final /* synthetic */ boolean f19860f;

            /* renamed from: g */
            public final /* synthetic */ String f19861g;

            public a(com.sigmob.sdk.mraid2.g gVar, BaseAdUnit baseAdUnit, String str, JSONObject jSONObject, String str2, boolean z10, String str3) {
                this.f19855a = gVar;
                this.f19856b = baseAdUnit;
                this.f19857c = str;
                this.f19858d = jSONObject;
                this.f19859e = str2;
                this.f19860f = z10;
                this.f19861g = str3;
            }

            @Override // com.sigmob.sdk.base.common.l0.a
            public void a(String str, Throwable th2) {
                p.this.a(this.f19855a, this.f19856b, this.f19857c, this.f19861g, this.f19858d, this.f19859e, this.f19860f);
            }

            @Override // com.sigmob.sdk.base.common.l0.a
            public void a(String str) {
                p.this.a(this.f19855a, this.f19856b, this.f19857c, str, this.f19858d, this.f19859e, this.f19860f);
            }
        }

        /* renamed from: com.sigmob.sdk.mraid2.p$b$b */
        public class C0611b implements b0.g {

            /* renamed from: a */
            public final /* synthetic */ String f19863a;

            /* renamed from: b */
            public final /* synthetic */ BaseAdUnit f19864b;

            /* renamed from: c */
            public final /* synthetic */ String f19865c;

            /* renamed from: d */
            public final /* synthetic */ String f19866d;

            public C0611b(String str, BaseAdUnit baseAdUnit, String str2, String str3) {
                this.f19863a = str;
                this.f19864b = baseAdUnit;
                this.f19865c = str2;
                this.f19866d = str3;
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                    pointEntitySigmob.setFinal_url(this.f19863a);
                    HashMap hashMap = new HashMap();
                    if (this.f19864b.getAndroidMarket() != null) {
                        hashMap.put("app_package_name", this.f19865c);
                        hashMap.put("store_package_name", this.f19866d);
                    }
                    pointEntitySigmob.setOptions(hashMap);
                }
            }
        }

        public class c implements b0.g {

            /* renamed from: a */
            public final /* synthetic */ String f19868a;

            public c(String str) {
                this.f19868a = str;
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    ((PointEntitySigmob) obj).setFinal_url(this.f19868a);
                }
            }
        }

        public class d implements b0.g {

            /* renamed from: a */
            public final /* synthetic */ String f19870a;

            /* renamed from: b */
            public final /* synthetic */ BaseAdUnit f19871b;

            public d(String str, BaseAdUnit baseAdUnit) {
                this.f19870a = str;
                this.f19871b = baseAdUnit;
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                    pointEntitySigmob.setFinal_url(this.f19870a);
                    HashMap hashMap = new HashMap();
                    if (this.f19871b.getAndroidMarket() != null) {
                        hashMap.put("fast_pkg", com.sigmob.sdk.a.f());
                    }
                    pointEntitySigmob.setOptions(hashMap);
                }
            }
        }

        public b() {
        }

        @Override // com.sigmob.sdk.mraid2.d.e
        public void a() {
            p.this.a(IntentActions.ACTION_REWARDED_VIDEO_CLOSE);
            p.this.f19847p = true;
            p.this.f17902e.a();
        }

        @Override // com.sigmob.sdk.mraid2.d.e
        public void b() {
            p.this.f19848q = true;
        }

        @Override // com.sigmob.sdk.mraid2.d.e
        public void d() {
            if (p.this.f19841j) {
                return;
            }
            p.this.f19841j = true;
            p.this.a(IntentActions.ACTION_REWARDED_VIDEO_COMPLETE);
        }

        @Override // com.sigmob.sdk.mraid2.d.e
        public void e() {
            SigmobLog.d("MraidActivity failed to load. Finishing the activity");
            if (p.this.f17898a != null) {
                p.this.a(IntentActions.ACTION_INTERSTITIAL_FAIL);
            }
            p.this.f17902e.a();
        }

        @Override // com.sigmob.sdk.mraid2.d.e
        public void a(View view) {
            p.this.a(IntentActions.ACTION_INTERSTITIAL_SHOW);
            SigmobLog.d("onLoaded() called");
        }

        @Override // com.sigmob.sdk.mraid2.d.e
        public void a(WindAdError windAdError) {
            SigmobLog.d("Finishing the activity due to a problem: " + windAdError);
            if (p.this.f17898a != null) {
                p.this.a(IntentActions.ACTION_INTERSTITIAL_FAIL);
            }
            p.this.f17902e.a();
        }

        /* JADX WARN: Can't wrap try/catch for region: R(10:63|(10:109|110|111|66|(3:102|103|(1:105))|68|69|(3:71|(1:73)|(1:75)(1:97))(1:98)|76|77)|65|66|(0)|68|69|(0)(0)|76|77) */
        /* JADX WARN: Code restructure failed: missing block: B:101:0x024a, code lost:
        
            r6 = r0.getMessage();
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:0x023e, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Removed duplicated region for block: B:102:0x01ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0222  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x0250 A[Catch: all -> 0x023e, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x023e, blocks: (B:75:0x023a, B:97:0x0240, B:98:0x0250), top: B:69:0x0220 }] */
        @Override // com.sigmob.sdk.mraid2.d.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(com.sigmob.sdk.mraid2.g r21, com.sigmob.sdk.base.models.BaseAdUnit r22, org.json.JSONObject r23) {
            /*
                Method dump skipped, instructions count: 764
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.mraid2.p.b.a(com.sigmob.sdk.mraid2.g, com.sigmob.sdk.base.models.BaseAdUnit, org.json.JSONObject):void");
        }

        @Override // com.sigmob.sdk.mraid2.d.e
        public void a(boolean z10) {
            if (z10) {
                p.this.s();
            } else {
                p.this.t();
            }
        }
    }

    public class c implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ BaseAdUnit f19873a;

        /* renamed from: b */
        public final /* synthetic */ ClickCommon f19874b;

        /* renamed from: c */
        public final /* synthetic */ JSONObject f19875c;

        public c(BaseAdUnit baseAdUnit, ClickCommon clickCommon, JSONObject jSONObject) {
            this.f19873a = baseAdUnit;
            this.f19874b = clickCommon;
            this.f19875c = jSONObject;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                pointEntitySigmob.setScene_id(this.f19873a.getAd_scene_id());
                pointEntitySigmob.setScene_desc(this.f19873a.getAd_scene_desc());
                pointEntitySigmob.setIs_deeplink(this.f19874b.isDeeplink);
                pointEntitySigmob.setFinal_url(this.f19874b.clickUrl);
                pointEntitySigmob.setCoordinate(this.f19874b.clickCoordinate);
                pointEntitySigmob.setVtime(String.format("%.2f", Float.valueOf(0.0f)));
                if (this.f19875c != null) {
                    HashMap hashMap = new HashMap();
                    Iterator<String> keys = this.f19875c.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, this.f19875c.optString(next));
                    }
                    pointEntitySigmob.setOptions(hashMap);
                }
                Map<String, String> options = pointEntitySigmob.getOptions();
                options.put("cwidth", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealWidthDip()));
                options.put("cheight", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealHeightDip()));
            }
        }
    }

    public class d implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ String f19877a;

        public d(String str) {
            this.f19877a = str;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).setFinal_url(this.f19877a);
            }
        }
    }

    public class e implements View.OnClickListener {

        public class a implements WindNativeAdData.DislikeInteractionCallback {
            public a() {
            }

            @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
            public void onCancel() {
                if (p.this.f19844m != null) {
                    p.this.f19844m.dismiss();
                    p.this.f19844m.b();
                    p.this.f19844m = null;
                }
            }

            @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
            public void onSelected(int i10, String str, boolean z10) {
                if (p.this.f19844m != null) {
                    p.this.f19844m.dismiss();
                    p.this.f19844m.b();
                    p.this.f19844m = null;
                }
            }

            @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
            public void onShow() {
            }
        }

        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            List<BaseAdUnit> list;
            Activity f10 = p.this.f();
            if (f10 == null || (list = p.this.f19846o) == null || list.get(0) == null) {
                return;
            }
            p.this.f19844m = new com.sigmob.sdk.nativead.a(f10, p.this.f19846o.get(0));
            if (p.this.f19844m != null) {
                p.this.f19844m.a();
            }
            p.this.f19844m.a(new a());
        }
    }

    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                p.this.f19847p = true;
                p.this.f19845n = true;
                p.this.g().a();
            }
            return true;
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            p.this.r();
        }
    }

    public static /* synthetic */ class h {

        /* renamed from: a */
        public static final /* synthetic */ int[] f19883a;

        static {
            int[] iArr = new int[ConsoleMessage.MessageLevel.values().length];
            f19883a = iArr;
            try {
                iArr[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public p(Activity activity, BaseAdUnit baseAdUnit, Bundle bundle, Bundle bundle2, String str, com.sigmob.sdk.base.common.k kVar) {
        super(activity, str, kVar);
        this.f19847p = false;
        this.f19848q = false;
        this.f19849r = true;
        this.f19851t = new e();
        this.f19846o = com.sigmob.sdk.base.common.h.c(baseAdUnit.getUuid());
        com.sigmob.sdk.mraid2.d b10 = com.sigmob.sdk.mraid2.b.a().b(baseAdUnit.getUuid());
        this.f19842k = b10;
        if (b10 == null) {
            this.f19842k = new com.sigmob.sdk.mraid2.d(com.sigmob.sdk.a.d(), this.f19846o);
        }
        f().requestWindowFeature(1);
        f().getWindow().addFlags(16778240);
        b(activity, this.f19840i, bundle);
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Bundle bundle) {
    }

    @Override // com.sigmob.sdk.base.common.j
    public boolean b() {
        return false;
    }

    @Override // com.sigmob.sdk.base.common.j
    public void j() {
    }

    @Override // com.sigmob.sdk.videoAd.c, com.sigmob.sdk.base.common.j
    public void k() {
        super.k();
        BaseAdUnit baseAdUnit = this.f19846o.get(0);
        if (baseAdUnit != null && (baseAdUnit.getMaterial().theme_data.intValue() == 1 || baseAdUnit.getTemplateType() == 1)) {
            p();
            i().setBackgroundColor(Color.argb(127, 0, 0, 0));
        }
        i().addView(q(), new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.sigmob.sdk.base.common.j
    public void l() {
        BaseAdUnit baseAdUnit;
        com.sigmob.sdk.mraid2.d dVar = this.f19842k;
        if (dVar != null) {
            dVar.a();
        }
        com.sigmob.sdk.nativead.a aVar = this.f19844m;
        if (aVar != null) {
            aVar.dismiss();
            this.f19844m.b();
            this.f19844m = null;
        }
        List<BaseAdUnit> list = this.f19846o;
        if (list != null) {
            if (this.f19845n && (baseAdUnit = list.get(0)) != null) {
                com.sigmob.sdk.base.network.f.a(baseAdUnit, "ad_close");
                b0.a("ad_close", (String) null, baseAdUnit);
            }
            for (BaseAdUnit baseAdUnit2 : this.f19846o) {
                if (baseAdUnit2 != null) {
                    baseAdUnit2.destroy();
                }
            }
        }
        if (!this.f19847p || !this.f19849r) {
            this.f19849r = true;
            a(IntentActions.ACTION_INTERSTITIAL_DISMISS);
        }
        List<BaseAdUnit> list2 = this.f19846o;
        if (list2 != null) {
            for (BaseAdUnit baseAdUnit3 : list2) {
                if (baseAdUnit3 != null) {
                    baseAdUnit3.destroy();
                }
            }
            this.f19846o.clear();
        }
        Sigmob.getInstance().getMacroCommon().clearMacro();
        super.l();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void m() {
        if (!this.f19847p) {
            this.f19842k.e();
        } else {
            this.f19849r = true;
            a(IntentActions.ACTION_INTERSTITIAL_DISMISS);
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void n() {
        this.f19842k.f();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void o() {
        com.sigmob.sdk.mraid2.d dVar = this.f19842k;
        if (dVar != null) {
            dVar.a(this.f19846o.get(0));
        }
        new Handler().postDelayed(new g(), 5000L);
        a(IntentActions.ACTION_INTERSTITIAL_VOPEN);
    }

    public View q() {
        if (this.f19842k == null) {
            this.f19842k = new com.sigmob.sdk.mraid2.d(this.f17899b, this.f19846o);
        }
        this.f19842k.a(this.f17904g);
        this.f19842k.a(new a());
        this.f19842k.a(new b());
        return this.f19842k.b();
    }

    public final void r() {
        if (this.f19848q) {
            return;
        }
        b0.b("h5_state", "0", this.f19846o.get(0));
    }

    public final void s() {
        p0 p0Var = this.f19843l;
        if (p0Var != null) {
            p0Var.setVisibility(4);
        }
        w wVar = this.f19850s;
        if (wVar != null) {
            wVar.setVisibility(4);
        }
    }

    public final void t() {
        if (this.f19843l == null) {
            a(this.f17899b, 0);
        }
        this.f19843l.setVisibility(0);
        b(h(), 0);
    }

    public final void b(Context context, int i10) {
        if (this.f19850s == null) {
            w wVar = new w(context);
            this.f19850s = wVar;
            wVar.setText("反馈");
            this.f19850s.setOnClickListener(this.f19851t);
            this.f19850s.setId(ClientMetadata.generateViewId());
            int dipsToIntPixels = Dips.dipsToIntPixels(3.0f, this.f17899b);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(45.0f, context), Dips.dipsToIntPixels(30.0f, context));
            layoutParams.addRule(0, this.f19843l.getId());
            layoutParams.addRule(6, this.f19843l.getId());
            layoutParams.setMargins(0, -dipsToIntPixels, 0, 0);
            i().addView(this.f19850s, layoutParams);
        }
        w wVar2 = this.f19850s;
        if (wVar2 != null) {
            wVar2.setVisibility(i10);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void a(Context context, int i10) {
        if (this.f19843l != null) {
            return;
        }
        p0 p0Var = new p0(context);
        this.f19843l = p0Var;
        p0Var.setVisibility(i10);
        this.f19843l.setId(ClientMetadata.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(22.0f, context), Dips.dipsToIntPixels(22.0f, context));
        a(3, layoutParams);
        i().addView(this.f19843l, layoutParams);
        this.f19843l.setOnTouchListener(new f());
        this.f19843l.a(this.f19846o.get(0));
    }

    public final void a(int i10, RelativeLayout.LayoutParams layoutParams) {
        int i11;
        int dipsToIntPixels = Dips.dipsToIntPixels(10.0f, this.f17899b);
        if (i10 == 1 || i10 == 2) {
            layoutParams.addRule(10);
            i11 = 9;
        } else {
            if (i10 != 3 && i10 != 4) {
                return;
            }
            layoutParams.addRule(10);
            i11 = 11;
        }
        layoutParams.addRule(i11);
        layoutParams.setMargins(dipsToIntPixels, dipsToIntPixels * 2, dipsToIntPixels, dipsToIntPixels);
    }

    public final void a(com.sigmob.sdk.mraid2.g gVar, BaseAdUnit baseAdUnit, String str, JSONObject jSONObject, String str2) {
        try {
            if (!TextUtils.isEmpty(str2)) {
                if (gVar.getMraidBridge() != null) {
                    gVar.getMraidBridge().a(str + "_failed", str2);
                    return;
                }
                return;
            }
            a(IntentActions.ACTION_INTERSTITIAL_CLICK);
            if (gVar.getMraidBridge() != null) {
                gVar.getMraidBridge().a(str + "_success", "");
            }
            if (baseAdUnit == null || !baseAdUnit.isRecord()) {
                return;
            }
            b0.a(com.sigmob.sdk.base.a.ENDCARD.name().toLowerCase(), "click", baseAdUnit, new c(baseAdUnit, baseAdUnit.getClickCommon(), jSONObject));
            com.sigmob.sdk.base.network.f.a(baseAdUnit, "click");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Configuration configuration) {
        com.sigmob.sdk.mraid2.d dVar = this.f19842k;
        if (dVar != null) {
            dVar.a(configuration.orientation);
        }
    }

    public final void a(com.sigmob.sdk.mraid2.g gVar, BaseAdUnit baseAdUnit, String str, String str2, JSONObject jSONObject, String str3, boolean z10) {
        String str4;
        BaseAdUnit baseAdUnit2;
        ClickCommon clickCommon;
        String str5;
        BaseAdUnit baseAdUnit3;
        String str6;
        String str7 = "open_deeplink";
        String str8 = "";
        if (j0.f17912h.a(Uri.parse(str2), 0)) {
            try {
                if (z10) {
                    if (baseAdUnit != null) {
                        baseAdUnit.setRecord(true);
                        baseAdUnit2 = baseAdUnit;
                    } else {
                        baseAdUnit2 = gVar.getAdUnitList().get(0);
                        baseAdUnit2.setRecord(false);
                    }
                    baseAdUnit2.setUrl(str2);
                    com.sigmob.sdk.base.common.h.a(baseAdUnit2);
                    BaseAdActivity.a(h(), (Class<? extends BaseAdActivity>) AdActivity.class, baseAdUnit2);
                } else {
                    u.b(h(), new Intent("android.intent.action.VIEW", Uri.parse(str2)));
                }
            } catch (Exception e10) {
                String message = e10.getMessage();
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        u.b(h(), new Intent("android.intent.action.VIEW", Uri.parse(str3)));
                    } catch (Exception e11) {
                        e11.printStackTrace();
                        message = e10.getMessage();
                        str4 = message;
                        a(gVar, baseAdUnit, str, jSONObject, str4);
                    }
                }
                str4 = message;
            }
        } else {
            try {
                u.a(h(), Uri.parse(str2));
            } catch (Exception e12) {
                str8 = e12.getMessage();
            }
            if (baseAdUnit != null) {
                try {
                    if (TextUtils.isEmpty(str8)) {
                        com.sigmob.sdk.base.network.f.a(baseAdUnit, "open_deeplink");
                        clickCommon = baseAdUnit.getClickCommon();
                        str5 = "1";
                    } else {
                        com.sigmob.sdk.base.network.f.a(baseAdUnit, "open_deeplink_failed");
                        clickCommon = baseAdUnit.getClickCommon();
                        str7 = "open_deeplink_failed";
                        str5 = "0";
                    }
                    clickCommon.isDeeplink = str5;
                } catch (Exception e13) {
                    e = e13;
                }
                try {
                    b0.a(str7, (String) null, baseAdUnit, new d(str2));
                } catch (Exception e14) {
                    e = e14;
                    String message2 = e.getMessage();
                    e.printStackTrace();
                    str4 = message2;
                    a(gVar, baseAdUnit, str, jSONObject, str4);
                }
            }
            if (!TextUtils.isEmpty(str8) && !TextUtils.isEmpty(str3)) {
                if (z10) {
                    if (baseAdUnit != null) {
                        baseAdUnit.setRecord(true);
                        str6 = str3;
                        baseAdUnit3 = baseAdUnit;
                    } else {
                        baseAdUnit3 = gVar.getAdUnitList().get(0);
                        baseAdUnit3.setRecord(false);
                        str6 = str3;
                    }
                    baseAdUnit3.setUrl(str6);
                    com.sigmob.sdk.base.common.h.a(baseAdUnit3);
                    BaseAdActivity.a(h(), (Class<? extends BaseAdActivity>) AdActivity.class, baseAdUnit3);
                } else {
                    u.b(h(), new Intent("android.intent.action.VIEW", Uri.parse(str3)));
                }
                str4 = null;
                a(gVar, baseAdUnit, str, jSONObject, str4);
            }
        }
        str4 = str8;
        a(gVar, baseAdUnit, str, jSONObject, str4);
    }
}
