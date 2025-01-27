package com.sigmob.sdk.mraid;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.common.z;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.PlacementType;
import com.sigmob.sdk.base.views.p0;
import com.sigmob.sdk.base.views.q;
import com.sigmob.sdk.base.views.w;
import com.sigmob.sdk.mraid.a;
import com.sigmob.sdk.mraid.d;
import com.sigmob.sdk.mraid.t;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.natives.WindNativeAdData;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class n extends com.sigmob.sdk.videoAd.c implements z {
    public w A;
    public JSONObject B;
    public View.OnClickListener C;

    /* renamed from: i */
    public com.sigmob.sdk.base.common.t f19609i;

    /* renamed from: j */
    public int f19610j;

    /* renamed from: k */
    public com.sigmob.sdk.videoAd.a f19611k;

    /* renamed from: l */
    public int f19612l;

    /* renamed from: m */
    public boolean f19613m;

    /* renamed from: n */
    public BaseAdUnit f19614n;

    /* renamed from: o */
    public com.sigmob.sdk.mraid.d f19615o;

    /* renamed from: p */
    public r f19616p;

    /* renamed from: q */
    public p0 f19617q;

    /* renamed from: r */
    public int f19618r;

    /* renamed from: s */
    public boolean f19619s;

    /* renamed from: t */
    public boolean f19620t;

    /* renamed from: u */
    public boolean f19621u;

    /* renamed from: v */
    public com.sigmob.sdk.base.views.q f19622v;

    /* renamed from: w */
    public boolean f19623w;

    /* renamed from: x */
    public com.sigmob.sdk.mraid2.f f19624x;

    /* renamed from: y */
    public com.sigmob.sdk.mraid.h f19625y;

    /* renamed from: z */
    public com.sigmob.sdk.nativead.a f19626z;

    public class a implements r {
        public a() {
        }

        @Override // com.sigmob.sdk.mraid.r
        public boolean a(String str, JsResult jsResult) {
            return false;
        }

        @Override // com.sigmob.sdk.mraid.r
        public boolean a(ConsoleMessage consoleMessage) {
            if (b.f19628a[consoleMessage.messageLevel().ordinal()] != 1) {
                return false;
            }
            SigmobLog.e("onConsoleMessage " + consoleMessage.message());
            b0.a("h5_error", "mraid1", 0, consoleMessage.message(), (WindAdRequest) null, (LoadAdRequest) null, n.this.f19614n, (b0.g) null);
            return false;
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f19628a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f19629b;

        static {
            int[] iArr = new int[com.sigmob.sdk.base.a.values().length];
            f19629b = iArr;
            try {
                iArr[com.sigmob.sdk.base.a.COMPANION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19629b[com.sigmob.sdk.base.a.VIDEO_CLICK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[ConsoleMessage.MessageLevel.values().length];
            f19628a = iArr2;
            try {
                iArr2[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public class c implements q.g {
        public c() {
        }

        @Override // com.sigmob.sdk.base.views.q.g
        public void a(String str, String str2) {
            n.this.f19614n.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
            n.this.f19614n.getClickCommon().click_scene = "appinfo";
            n.this.f19614n.getClickCommon().is_final_click = true;
        }

        @Override // com.sigmob.sdk.base.views.q.g
        public void b() {
            com.sigmob.sdk.mraid.b l10;
            if (n.this.f19615o == null || n.this.f19615o.i() == null || (l10 = n.this.f19615o.l()) == null) {
                return;
            }
            l10.a("fourElementsDidAppear", (HashMap<String, Object>) null);
        }

        @Override // com.sigmob.sdk.base.views.q.g
        public void a() {
            com.sigmob.sdk.mraid.b l10;
            if (n.this.f19615o == null || n.this.f19615o.i() == null || (l10 = n.this.f19615o.l()) == null) {
                return;
            }
            l10.a("fourElementsDidDisappear", (HashMap<String, Object>) null);
        }
    }

    public class d implements ValueCallback<String> {

        /* renamed from: a */
        public final /* synthetic */ String f19631a;

        /* renamed from: b */
        public final /* synthetic */ Integer f19632b;

        public d(String str, Integer num) {
            this.f19631a = str;
            this.f19632b = num;
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Integer num;
            try {
                if (n.this.f19609i == null) {
                    return;
                }
                if (com.sigmob.sdk.mraid.b.a(str) == null) {
                    if (this.f19631a.equals("show_skip")) {
                        n.this.f19609i.a(false, 0);
                    }
                    n.this.f19609i.a(this.f19631a, 0);
                } else {
                    Float valueOf = Float.valueOf(str);
                    float floatValue = (((double) valueOf.floatValue()) <= 1.0E-7d || (num = this.f19632b) == null || num.intValue() <= 0) ? -1.0f : valueOf.floatValue() * this.f19632b.intValue();
                    if (this.f19631a.equals("show_skip")) {
                        n.this.f19609i.a(false, (int) floatValue);
                    }
                    n.this.f19609i.a(this.f19631a, (int) floatValue);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public class e implements d.l {

        /* renamed from: a */
        public boolean f19634a;

        public e() {
        }

        @Override // com.sigmob.sdk.mraid.d.l
        public void a(Map<String, String> map) {
            SigmobLog.d("adError() called " + map);
        }

        @Override // com.sigmob.sdk.mraid.d.l
        public void b(Map<String, String> map) {
            try {
                map.get("id");
                String str = map.get("url");
                if (!map.get("playerHandles").equalsIgnoreCase("false")) {
                    if (!TextUtils.isEmpty(str)) {
                        if (str.startsWith("http")) {
                            n.this.f19614n.setCustomLandPageUrl(str);
                        } else {
                            n.this.f19614n.setCustomDeeplink(str);
                        }
                    }
                    n.this.f19611k.a(com.sigmob.sdk.base.a.ENDCARD, n.this.f19615o.g(), true);
                }
                SigmobLog.d("adClickThru() called" + map.toString());
            } catch (Throwable th2) {
                SigmobLog.e("adClickThru", th2);
            }
        }

        @Override // com.sigmob.sdk.mraid.d.l
        public void c() {
            SigmobLog.d("adImpression() called");
        }

        @Override // com.sigmob.sdk.mraid.d.l
        public void d() {
            n.this.b("play_three_quarters");
            SigmobLog.d("adVideoThirdQuartile() called");
        }

        @Override // com.sigmob.sdk.mraid.d.l
        public void e() {
            if (this.f19634a) {
                return;
            }
            n.this.b("pause");
        }

        @Override // com.sigmob.sdk.mraid.d.l
        public void f() {
            SigmobLog.d("adPlaying() called");
        }

        @Override // com.sigmob.sdk.mraid.d.l
        public void g() {
            n.this.b(com.sigmob.sdk.base.common.a.P);
            n.this.a(IntentActions.ACTION_REWARDED_VIDEO_PLAY);
            SigmobLog.d("adVideoStart() called");
        }

        @Override // com.sigmob.sdk.mraid.d.l
        public void h() {
            this.f19634a = true;
            n.this.b("complete");
            SigmobLog.d("adVideoComplete() called");
        }

        @Override // com.sigmob.sdk.mraid.d.l
        public void a() {
            n.this.b("play_two_quarters");
            SigmobLog.d("adVideoMidpoint() called");
        }

        @Override // com.sigmob.sdk.mraid.d.l
        public void b() {
            n.this.b("play_quarter");
            SigmobLog.d("adVideoFirstQuartile() called");
        }

        @Override // com.sigmob.sdk.mraid.d.l
        public void a(Integer num) {
            n.this.f19618r = num == null ? -1 : num.intValue();
            n nVar = n.this;
            nVar.f19609i.a(nVar.f19618r, n.this.f19611k.n());
        }
    }

    public class f implements d.g {

        public class a implements ValueCallback<String> {
            public a() {
            }

            @Override // android.webkit.ValueCallback
            /* renamed from: a */
            public void onReceiveValue(String str) {
                if (com.sigmob.sdk.mraid.b.a(str) == null || n.this.f19609i == null) {
                    return;
                }
                Float valueOf = Float.valueOf(str);
                if (valueOf.floatValue() < 0.999f && !n.this.f19619s) {
                    n.this.f19619s = true;
                    n.this.b("skip");
                }
                if (n.this.f19613m || n.this.f19614n.getAd_type() == 4 || valueOf.floatValue() <= n.this.f19614n.getFinishedTime()) {
                    return;
                }
                n.this.f19613m = true;
                n nVar = n.this;
                nVar.f19609i.a("reward", nVar.f19615o.e().intValue());
                n.this.a(IntentActions.ACTION_REWARDED_VIDEO_COMPLETE);
            }
        }

        public class b implements WindNativeAdData.DislikeInteractionCallback {
            public b() {
            }

            @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
            public void onCancel() {
                com.sigmob.sdk.mraid.b l10;
                if (n.this.f19615o != null && n.this.f19615o.i() != null && (l10 = n.this.f19615o.l()) != null) {
                    l10.a("feedbackDidDisappear", (HashMap<String, Object>) null);
                }
                if (n.this.f19626z != null) {
                    n.this.f19626z.dismiss();
                    n.this.f19626z.b();
                    n.this.f19626z = null;
                }
            }

            @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
            public void onSelected(int i10, String str, boolean z10) {
                com.sigmob.sdk.mraid.b l10;
                if (n.this.f19615o != null && n.this.f19615o.i() != null && (l10 = n.this.f19615o.l()) != null) {
                    l10.a("feedbackDidDisappear", (HashMap<String, Object>) null);
                }
                if (n.this.f19626z != null) {
                    n.this.f19626z.dismiss();
                    n.this.f19626z.b();
                    n.this.f19626z = null;
                }
            }

            @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
            public void onShow() {
                com.sigmob.sdk.mraid.b l10;
                if (n.this.f19615o == null || n.this.f19615o.i() == null || (l10 = n.this.f19615o.l()) == null) {
                    return;
                }
                l10.a("feedbackDidAppear", (HashMap<String, Object>) null);
            }
        }

        public class c implements q.g {
            public c() {
            }

            @Override // com.sigmob.sdk.base.views.q.g
            public void a(String str, String str2) {
                if (n.this.f19611k != null) {
                    n.this.f19611k.b(com.sigmob.sdk.base.a.ENDCARD, str, str2, true);
                }
            }

            @Override // com.sigmob.sdk.base.views.q.g
            public void b() {
                com.sigmob.sdk.mraid.b l10;
                com.sigmob.sdk.base.common.t tVar = n.this.f19609i;
                if (tVar != null) {
                    tVar.a(com.sigmob.sdk.base.common.a.f17653f, 0);
                }
                if (n.this.f19615o == null || n.this.f19615o.i() == null || (l10 = n.this.f19615o.l()) == null) {
                    return;
                }
                l10.a("fourElementsDidAppear", (HashMap<String, Object>) null);
            }

            @Override // com.sigmob.sdk.base.views.q.g
            public void a() {
                com.sigmob.sdk.mraid.b l10;
                if (n.this.f19622v != null) {
                    n.this.f19622v.dismiss();
                    n.this.f19622v.b();
                    n.this.f19622v = null;
                    n.this.f19623w = false;
                }
                com.sigmob.sdk.base.common.t tVar = n.this.f19609i;
                if (tVar != null) {
                    tVar.a(com.sigmob.sdk.base.common.a.f17654g, 0);
                }
                if (n.this.f19615o == null || n.this.f19615o.i() == null || (l10 = n.this.f19615o.l()) == null) {
                    return;
                }
                l10.a("fourElementsDidDisappear", (HashMap<String, Object>) null);
            }
        }

        public f() {
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void a(int i10, int i11, int i12, int i13, a.b bVar, boolean z10) {
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void b(float f10) {
            if (n.this.f19619s) {
                return;
            }
            n.this.f19619s = true;
            n.this.b("skip");
            n.this.a(IntentActions.ACTION_REWARDED_VIDEO_SKIP);
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void c() {
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void d() {
            Activity f10 = n.this.f();
            if (f10 == null || n.this.f19614n == null) {
                return;
            }
            n.this.f19626z = new com.sigmob.sdk.nativead.a(f10, n.this.f19614n);
            if (n.this.f19626z != null) {
                n.this.f19626z.a();
            }
            n.this.f19626z.a(new b());
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void e() {
            SigmobLog.d("MraidActivity failed to load. Finishing the activity");
            if (n.this.f17898a != null) {
                n.this.a(IntentActions.ACTION_INTERSTITIAL_FAIL);
            }
            n.this.f17902e.a();
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void f() {
            if (n.this.f19622v == null) {
                n.this.f19622v = new com.sigmob.sdk.base.views.q(n.this.f(), n.this.f19614n);
                n.this.f19622v.a(new c());
            }
            if (n.this.f19622v == null || !n.this.f19622v.e() || n.this.f19623w) {
                return;
            }
            n.this.f19622v.show();
            n.this.f19623w = true;
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void g() {
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void h() {
            n.this.b("show_skip");
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void i() {
            n.this.b("show");
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void a() {
            n.this.f19615o.a(new a());
            n.this.a(IntentActions.ACTION_REWARDED_VIDEO_CLOSE);
            n.this.f19620t = true;
            n.this.f17902e.a();
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void a(String str) {
            boolean z10 = true;
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("type");
                    if (jSONObject.has("x") && jSONObject.has("y")) {
                        n.this.f19615o.a(String.valueOf(jSONObject.optInt("x")), String.valueOf(jSONObject.optInt("y")));
                    }
                    if (optInt != 1) {
                        n.this.B = jSONObject.optJSONObject("log_data");
                    } else {
                        z10 = false;
                    }
                } catch (Exception unused) {
                    n.this.f19615o.a("0", "0");
                }
            }
            n.this.f19611k.a(com.sigmob.sdk.base.a.COMPANION, n.this.f19615o.g(), z10);
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void a(View view) {
            n.this.b("start");
            n.this.a(IntentActions.ACTION_INTERSTITIAL_SHOW);
            SigmobLog.d("onLoaded() called");
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void a(boolean z10) {
            n nVar;
            String str;
            if (z10) {
                nVar = n.this;
                str = com.sigmob.sdk.base.common.a.D;
            } else {
                nVar = n.this;
                str = com.sigmob.sdk.base.common.a.E;
            }
            nVar.b(str);
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void a(URI uri, int i10, String str) {
            boolean z10;
            boolean z11;
            boolean z12;
            JSONObject jSONObject;
            int optInt;
            boolean optBoolean;
            com.sigmob.sdk.videoAd.a aVar;
            com.sigmob.sdk.base.a aVar2;
            String uri2;
            String g10;
            boolean z13 = false;
            if (TextUtils.isEmpty(str)) {
                z12 = true;
                z11 = true;
            } else {
                try {
                    jSONObject = new JSONObject(str);
                    optInt = jSONObject.optInt("type");
                    if (jSONObject.has("x") && jSONObject.has("y")) {
                        n.this.f19615o.a(String.valueOf(jSONObject.optInt("x")), String.valueOf(jSONObject.optInt("y")));
                    }
                    optBoolean = jSONObject.optBoolean("disable_landing");
                    try {
                        z10 = !jSONObject.optBoolean("feDisable");
                    } catch (Exception unused) {
                        z13 = optBoolean;
                        z10 = true;
                        z11 = z10;
                        z12 = true;
                        if (!z13) {
                        }
                        aVar = n.this.f19611k;
                        aVar2 = com.sigmob.sdk.base.a.ENDCARD;
                        uri2 = uri.toString();
                        g10 = n.this.f19615o.g();
                        aVar.a(aVar2, uri2, g10, z12, z11);
                    }
                } catch (Exception unused2) {
                }
                if (optInt != 1) {
                    try {
                        n.this.B = jSONObject.optJSONObject("log_data");
                    } catch (Exception unused3) {
                    }
                    z13 = optBoolean;
                    z11 = z10;
                    z12 = true;
                } else {
                    z13 = optBoolean;
                    z11 = z10;
                    z12 = false;
                }
            }
            if (!z13 || TextUtils.isEmpty(n.this.f19614n.getLanding_page())) {
                aVar = n.this.f19611k;
                aVar2 = com.sigmob.sdk.base.a.ENDCARD;
                uri2 = uri.toString();
                g10 = n.this.f19615o.g();
            } else {
                aVar = n.this.f19611k;
                aVar2 = com.sigmob.sdk.base.a.ENDCARD;
                g10 = n.this.f19615o.g();
                uri2 = null;
            }
            aVar.a(aVar2, uri2, g10, z12, z11);
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void a(WindAdError windAdError) {
            SigmobLog.d("Finishing the activity due to a problem: " + windAdError);
            n.this.b("error");
            if (n.this.f17898a != null) {
                n.this.a(IntentActions.ACTION_INTERSTITIAL_FAIL);
            }
            n.this.f17902e.a();
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void a(float f10) {
            n.this.f19613m = true;
            n.this.b("reward");
            n.this.a(IntentActions.ACTION_REWARDED_VIDEO_COMPLETE);
        }
    }

    public class g implements d.k {
        public g() {
        }

        @Override // com.sigmob.sdk.mraid.d.k
        public void a(boolean z10) {
            if (z10) {
                n.this.r();
            } else {
                n.this.s();
            }
        }
    }

    public class h implements d.h {
        public h() {
        }

        @Override // com.sigmob.sdk.mraid.d.h
        public void a(p pVar, com.sigmob.sdk.base.common.t tVar) {
            n nVar = n.this;
            if (tVar != null) {
                nVar.f19609i = tVar;
                return;
            }
            nVar.f19609i = new com.sigmob.sdk.base.common.t();
            n nVar2 = n.this;
            nVar2.f19609i.a(nVar2.f19614n);
        }
    }

    public class i implements d.h {
        public i() {
        }

        @Override // com.sigmob.sdk.mraid.d.h
        public void a(p pVar, com.sigmob.sdk.base.common.t tVar) {
            n nVar = n.this;
            if (tVar != null) {
                nVar.f19609i = tVar;
                return;
            }
            nVar.f19609i = new com.sigmob.sdk.base.common.t();
            n nVar2 = n.this;
            nVar2.f19609i.a(nVar2.f19614n);
        }
    }

    public class j implements View.OnTouchListener {
        public j() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                n.this.f19620t = true;
                n.this.f19611k.a(n.this.h(), n.this.f19618r, n.this.f19614n);
                n.this.g().a();
            }
            return true;
        }
    }

    public class k implements View.OnClickListener {

        public class a implements WindNativeAdData.DislikeInteractionCallback {
            public a() {
            }

            @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
            public void onCancel() {
                if (n.this.f19626z != null) {
                    n.this.f19626z.dismiss();
                    n.this.f19626z.b();
                    n.this.f19626z = null;
                }
            }

            @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
            public void onSelected(int i10, String str, boolean z10) {
                if (n.this.f19626z != null) {
                    n.this.f19626z.dismiss();
                    n.this.f19626z.b();
                    n.this.f19626z = null;
                }
            }

            @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
            public void onShow() {
            }
        }

        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity f10 = n.this.f();
            if (f10 == null || n.this.f19614n == null) {
                return;
            }
            n.this.f19626z = new com.sigmob.sdk.nativead.a(f10, n.this.f19614n);
            if (n.this.f19626z != null) {
                n.this.f19626z.a();
            }
            n.this.f19626z.a(new a());
        }
    }

    public n(Activity activity, BaseAdUnit baseAdUnit, Bundle bundle, Bundle bundle2, String str, com.sigmob.sdk.base.common.k kVar) {
        super(activity, str, kVar);
        this.f19620t = false;
        this.f19621u = false;
        this.f19623w = false;
        this.C = new k();
        this.f19614n = baseAdUnit;
        com.sigmob.sdk.videoAd.a aVar = (com.sigmob.sdk.videoAd.a) baseAdUnit.getAdConfig();
        this.f19611k = aVar;
        aVar.a(f(), this.f19614n, new c());
        this.f19611k.a(this);
        this.f19612l = ClientMetadata.getInstance().getInsetBottom();
        f().requestWindowFeature(1);
        f().getWindow().addFlags(16778240);
        b(activity, this.f19610j, bundle);
        i().setBackgroundColor(0);
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

    @Override // com.sigmob.sdk.base.common.j
    public void o() {
    }

    public void b(String str) {
        this.f19615o.a(new d(str, this.f19615o.e()));
    }

    @Override // com.sigmob.sdk.videoAd.c, com.sigmob.sdk.base.common.j
    public void k() {
        super.k();
        com.sigmob.sdk.base.common.t tVar = this.f19609i;
        if (tVar != null) {
            tVar.a("show", 0);
        }
        i().addView(q(), new FrameLayout.LayoutParams(-1, -1));
        com.sigmob.sdk.mraid.d dVar = this.f19615o;
        if (dVar != null) {
            dVar.a(f());
        }
        a(IntentActions.ACTION_INTERSTITIAL_VOPEN);
        a(new a());
    }

    @Override // com.sigmob.sdk.base.common.j
    public void l() {
        com.sigmob.sdk.base.common.t tVar = this.f19609i;
        if (tVar != null) {
            tVar.a();
            this.f19609i = null;
        }
        com.sigmob.sdk.mraid.d dVar = this.f19615o;
        if (dVar != null) {
            dVar.b();
        }
        com.sigmob.sdk.nativead.a aVar = this.f19626z;
        if (aVar != null) {
            aVar.dismiss();
            this.f19626z.b();
            this.f19626z = null;
        }
        com.sigmob.sdk.base.views.q qVar = this.f19622v;
        if (qVar != null) {
            qVar.dismiss();
            this.f19622v.b();
            this.f19622v = null;
            this.f19623w = false;
        }
        if (!this.f19620t || !this.f19621u) {
            this.f19621u = true;
            a(IntentActions.ACTION_INTERSTITIAL_DISMISS);
        }
        BaseAdUnit baseAdUnit = this.f19614n;
        if (baseAdUnit != null) {
            baseAdUnit.destroy();
        }
        super.l();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void m() {
        if (!this.f19620t) {
            this.f19615o.w();
        } else {
            this.f19621u = true;
            a(IntentActions.ACTION_INTERSTITIAL_DISMISS);
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void n() {
        this.f19615o.x();
    }

    public View q() {
        String str = this.f17898a;
        t.b a10 = str != null ? t.a(str) : null;
        this.f19615o = (a10 == null || a10.a() == null) ? new com.sigmob.sdk.mraid.d(this.f17899b, this.f19614n, PlacementType.INTERSTITIAL) : a10.a();
        this.f19615o.a(this.f17904g);
        this.f19615o.a(new e());
        this.f19615o.a(new f());
        this.f19615o.a(new g());
        if (a10 != null) {
            this.f19609i = a10.b();
        } else if (!TextUtils.isEmpty(this.f19614n.getHtmlData())) {
            this.f19615o.a(this.f19614n.getHtmlData(), new h());
        } else if (!TextUtils.isEmpty(this.f19614n.getHtmlUrl())) {
            this.f19615o.b(this.f19614n.getHtmlUrl(), new i());
        }
        return this.f19615o.d();
    }

    public final void r() {
        p0 p0Var = this.f19617q;
        if (p0Var != null) {
            p0Var.setVisibility(4);
        }
        w wVar = this.A;
        if (wVar != null) {
            wVar.setVisibility(4);
        }
    }

    public final void s() {
        if (this.f19617q == null) {
            a(this.f17899b, 0);
        }
        this.f19617q.setVisibility(0);
        b(h(), 0);
    }

    public final void b(Context context, int i10) {
        if (this.A == null) {
            w wVar = new w(context);
            this.A = wVar;
            wVar.setText("反馈");
            this.A.setOnClickListener(this.C);
            this.A.setId(ClientMetadata.generateViewId());
            int dipsToIntPixels = Dips.dipsToIntPixels(3.0f, this.f17899b);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(45.0f, context), Dips.dipsToIntPixels(30.0f, context));
            layoutParams.addRule(0, this.f19617q.getId());
            layoutParams.addRule(6, this.f19617q.getId());
            layoutParams.setMargins(0, -dipsToIntPixels, 0, 0);
            i().addView(this.A, layoutParams);
        }
        w wVar2 = this.A;
        if (wVar2 != null) {
            wVar2.setVisibility(i10);
        }
    }

    public final void a(Context context, int i10) {
        if (this.f19617q != null) {
            return;
        }
        p0 p0Var = new p0(context);
        this.f19617q = p0Var;
        p0Var.setVisibility(i10);
        this.f19617q.setId(ClientMetadata.generateViewId());
        int dipsToIntPixels = Dips.dipsToIntPixels(10.0f, this.f17899b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(22.0f, context), Dips.dipsToIntPixels(22.0f, context));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.setMargins(dipsToIntPixels, dipsToIntPixels * 2, dipsToIntPixels, dipsToIntPixels);
        i().addView(this.f19617q, layoutParams);
        this.f19617q.setOnTouchListener(new j());
        this.f19617q.a(this.f19614n);
        String d10 = this.f19611k.d();
        if (d10 != null) {
            this.f19617q.a(d10);
        }
    }

    @Override // com.sigmob.sdk.base.common.z
    public void a(boolean z10, com.sigmob.sdk.base.a aVar) {
        String str;
        a(IntentActions.ACTION_INTERSTITIAL_CLICK);
        if (z10) {
            int i10 = b.f19629b[aVar.ordinal()];
            if (i10 == 1) {
                ClickCommon clickCommon = this.f19614n.getClickCommon();
                b0.a(com.sigmob.sdk.base.a.COMPANION, "click", this.f19614n, clickCommon.isDeeplink, clickCommon.clickUrl, clickCommon.clickCoordinate, this.f19618r, this.B);
                str = com.sigmob.sdk.base.common.a.f17670w;
            } else if (i10 != 2) {
                ClickCommon clickCommon2 = this.f19614n.getClickCommon();
                b0.a(com.sigmob.sdk.base.a.ENDCARD, "click", this.f19614n, clickCommon2.isDeeplink, clickCommon2.clickUrl, clickCommon2.clickCoordinate, this.f19618r, this.B);
                str = "click";
            } else {
                ClickCommon clickCommon3 = this.f19614n.getClickCommon();
                b0.a(com.sigmob.sdk.base.a.VIDEO_CLICK, "click", this.f19614n, clickCommon3.isDeeplink, clickCommon3.clickUrl, clickCommon3.clickCoordinate, this.f19618r, this.B);
                str = "full_video_click";
            }
            b(str);
        }
        this.B = null;
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Configuration configuration) {
        this.f19615o.a(configuration.orientation);
    }

    public void a(r rVar) {
        this.f19616p = rVar;
        com.sigmob.sdk.mraid.d dVar = this.f19615o;
        if (dVar != null) {
            dVar.a(rVar);
        }
    }
}
