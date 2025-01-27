package com.sigmob.sdk.mraid;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.mta.DeviceContext;
import com.czhj.sdk.common.utils.IntentUtil;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.CurrentAppOrientation;
import com.sigmob.sdk.base.models.ExposureChange;
import com.sigmob.sdk.base.models.ExtensionEvent;
import com.sigmob.sdk.base.models.MraidEnv;
import com.sigmob.sdk.base.models.PlacementType;
import com.sigmob.sdk.base.models.VideoItem;
import com.sigmob.sdk.base.models.ViewState;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.mraid.a;
import com.sigmob.sdk.mraid.b;
import com.sigmob.sdk.mraid.o;
import com.sigmob.sdk.nativead.APKStatusBroadcastReceiver;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAds;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class d {
    public APKStatusBroadcastReceiver A;
    public boolean B;
    public com.sigmob.sdk.base.common.g C;

    /* renamed from: a */
    public final PlacementType f19507a;

    /* renamed from: b */
    public final BaseAdUnit f19508b;

    /* renamed from: c */
    public final FrameLayout f19509c;

    /* renamed from: d */
    public final j f19510d;

    /* renamed from: e */
    public final com.sigmob.sdk.mraid.l f19511e;

    /* renamed from: f */
    public final com.sigmob.sdk.mraid.b f19512f;

    /* renamed from: g */
    public final com.sigmob.sdk.mraid.i f19513g;

    /* renamed from: h */
    public boolean f19514h;

    /* renamed from: i */
    public Integer f19515i;

    /* renamed from: j */
    public String f19516j;

    /* renamed from: k */
    public ViewGroup f19517k;

    /* renamed from: l */
    public ViewState f19518l;

    /* renamed from: m */
    public g f19519m;

    /* renamed from: n */
    public k f19520n;

    /* renamed from: o */
    public r f19521o;

    /* renamed from: p */
    public l f19522p;

    /* renamed from: q */
    public p f19523q;

    /* renamed from: r */
    public i f19524r;

    /* renamed from: s */
    public Integer f19525s;

    /* renamed from: t */
    public boolean f19526t;

    /* renamed from: u */
    public com.sigmob.sdk.mraid.k f19527u;

    /* renamed from: v */
    public boolean f19528v;

    /* renamed from: w */
    public HashMap<String, com.sigmob.sdk.mraid.j> f19529w;

    /* renamed from: x */
    public com.sigmob.sdk.mraid2.f f19530x;

    /* renamed from: y */
    public final b.i f19531y;

    /* renamed from: z */
    public final b.h f19532z;

    public class a implements b.i {

        /* renamed from: com.sigmob.sdk.mraid.d$a$a */
        public class C0595a implements o.c {
            public C0595a() {
            }

            @Override // com.sigmob.sdk.mraid.o.c
            public void a(String str, int i10, String str2) {
                if (d.this.f19512f != null) {
                    d.this.f19512f.a(str, "code:" + i10 + ", msg:" + str2);
                }
                b0.a("video", i10, str2, d.this.f19508b);
            }

            @Override // com.sigmob.sdk.mraid.o.c
            public void b(String str, int i10) {
                if (d.this.f19512f != null) {
                    d.this.f19512f.a(str, i10);
                }
            }

            @Override // com.sigmob.sdk.mraid.o.c
            public void a(String str, long j10) {
                if (d.this.f19512f != null) {
                    d.this.f19512f.b(str, (int) j10);
                }
            }

            @Override // com.sigmob.sdk.mraid.o.c
            public void a(String str, int i10) {
                if (d.this.f19512f != null) {
                    d.this.f19512f.c(str, i10);
                }
            }

            @Override // com.sigmob.sdk.mraid.o.c
            public void a(String str, long j10, long j11) {
                if (d.this.f19512f != null) {
                    d.this.f19512f.a(str, (int) j10, (int) j11);
                }
            }

            @Override // com.sigmob.sdk.mraid.o.c
            public void a(String str, long j10, int i10, int i11) {
                if (d.this.f19512f != null) {
                    d.this.f19512f.a(str, (int) j10, i10, i11);
                }
            }
        }

        public class b implements com.sigmob.sdk.mraid2.i {
            public b() {
            }

            @Override // com.sigmob.sdk.mraid2.i
            public void a(String str, String str2, String str3, HashMap<String, Object> hashMap) {
                if (d.this.f19512f != null) {
                    d.this.f19512f.a(str, str2, str3, hashMap);
                }
            }
        }

        public class c implements com.sigmob.sdk.mraid2.i {
            public c() {
            }

            @Override // com.sigmob.sdk.mraid2.i
            public void a(String str, String str2, String str3, HashMap<String, Object> hashMap) {
                if (d.this.f19512f != null) {
                    d.this.f19512f.a(str, str2, str3, hashMap);
                }
            }
        }

        /* renamed from: com.sigmob.sdk.mraid.d$a$d */
        public class C0596d implements com.sigmob.sdk.mraid2.i {
            public C0596d() {
            }

            @Override // com.sigmob.sdk.mraid2.i
            public void a(String str, String str2, String str3, HashMap<String, Object> hashMap) {
                if (d.this.f19512f != null) {
                    d.this.f19512f.a(str, str2, str3, hashMap);
                }
            }
        }

        public a() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.sigmob.sdk.mraid.b.i
        public void a(String str, JSONObject jSONObject) {
            char c10;
            SigmobLog.d(" handleVpaidEvent event:" + str);
            SigmobLog.d(" postMessage args:" + jSONObject);
            String optString = jSONObject.optString("uniqueId");
            if (TextUtils.isEmpty(optString) || d.this.f19523q == null) {
                SigmobLog.e(" handleVpaidEvent uniqueId is null:" + jSONObject);
                return;
            }
            com.sigmob.sdk.mraid.j jVar = (com.sigmob.sdk.mraid.j) d.this.f19529w.get(optString);
            o oVar = (jVar == null || !(jVar instanceof o)) ? null : (o) jVar;
            str.hashCode();
            switch (str.hashCode()) {
                case -934524953:
                    if (str.equals("replay")) {
                        c10 = 0;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -373213089:
                    if (str.equals("assetURL")) {
                        c10 = 1;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 3237136:
                    if (str.equals(PointCategory.INIT)) {
                        c10 = 2;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 3443508:
                    if (str.equals("play")) {
                        c10 = 3;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 3526264:
                    if (str.equals("seek")) {
                        c10 = 4;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 3540994:
                    if (str.equals(id.c.f26966c)) {
                        c10 = 5;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 97692013:
                    if (str.equals(TypedValues.AttributesType.S_FRAME)) {
                        c10 = 6;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 104264043:
                    if (str.equals("muted")) {
                        c10 = 7;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 106440182:
                    if (str.equals("pause")) {
                        c10 = '\b';
                        break;
                    }
                    c10 = 65535;
                    break;
                default:
                    c10 = 65535;
                    break;
            }
            switch (c10) {
                case 0:
                    if (oVar != null) {
                        oVar.h(jSONObject);
                        break;
                    }
                    break;
                case 1:
                    if (oVar != null) {
                        oVar.d(jSONObject);
                        break;
                    }
                    break;
                case 2:
                    o oVar2 = new o(optString);
                    oVar2.a(new C0595a());
                    d.this.f19529w.put(optString, oVar2);
                    oVar2.a(d.this.f19523q.getContext(), jSONObject);
                    View c11 = oVar2.c();
                    if (c11 != null) {
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(1, 1);
                        layoutParams.topMargin = -1;
                        layoutParams.rightMargin = -1;
                        d.this.f19509c.addView(c11, layoutParams);
                        break;
                    }
                    break;
                case 3:
                    if (oVar != null) {
                        oVar.a(jSONObject);
                        break;
                    }
                    break;
                case 4:
                    if (oVar != null) {
                        oVar.f(jSONObject);
                        break;
                    }
                    break;
                case 5:
                    if (oVar != null) {
                        oVar.b(jSONObject);
                        oVar.a();
                        d.this.f19529w.remove(optString);
                        break;
                    }
                    break;
                case 6:
                    if (oVar != null) {
                        oVar.e(jSONObject);
                        break;
                    }
                    break;
                case 7:
                    if (oVar != null) {
                        oVar.c(jSONObject);
                        break;
                    }
                    break;
                case '\b':
                    if (oVar != null) {
                        oVar.g(jSONObject);
                        break;
                    }
                    break;
            }
        }

        @Override // com.sigmob.sdk.mraid.b.i
        public void b(String str, JSONObject jSONObject) {
            com.sigmob.sdk.mraid2.f fVar;
            int i10 = 2;
            SigmobLog.d(" postMessage subEvent data:" + jSONObject);
            String optString = jSONObject.optString("uniqueId");
            if (TextUtils.isEmpty(optString)) {
                SigmobLog.e(" onMotionViewEvent uniqueId is null:" + jSONObject);
            }
            com.sigmob.sdk.mraid.j jVar = (com.sigmob.sdk.mraid.j) d.this.f19529w.get(optString);
            fVar = jVar instanceof com.sigmob.sdk.mraid2.f ? (com.sigmob.sdk.mraid2.f) jVar : null;
            str.hashCode();
            switch (str) {
                case "init_sensitivity_raw":
                    String optString2 = jSONObject.optString("type", "");
                    int optInt = jSONObject.optInt("sensitivity_raw", 0);
                    com.sigmob.sdk.mraid2.f fVar2 = new com.sigmob.sdk.mraid2.f(optString, optString2);
                    fVar2.a(new c());
                    fVar2.b(optInt);
                    fVar2.h();
                    d.this.f19529w.put(optString, fVar2);
                    break;
                case "init":
                    String optString3 = jSONObject.optString("type", "");
                    int optInt2 = jSONObject.optInt("sensitivity", 0);
                    com.sigmob.sdk.mraid2.f fVar3 = new com.sigmob.sdk.mraid2.f(optString, optString3);
                    fVar3.a(new b());
                    if (optInt2 == 0) {
                        i10 = 3;
                    } else if (optInt2 == 2) {
                        i10 = 1;
                    } else if (optInt2 != 1) {
                        i10 = optInt2;
                    }
                    fVar3.a(i10);
                    fVar3.h();
                    d.this.f19529w.put(optString, fVar3);
                    break;
                case "destroy":
                    if (fVar != null) {
                        fVar.a();
                    }
                    d.this.f19529w.remove(optString);
                    break;
            }
        }

        @Override // com.sigmob.sdk.mraid.b.i
        public void c(String str, JSONObject jSONObject) {
            com.sigmob.sdk.mraid.j jVar;
            String optString = jSONObject.optString("uniqueId");
            if (TextUtils.isEmpty(optString) || (jVar = (com.sigmob.sdk.mraid.j) d.this.f19529w.get(optString)) == null || jVar.c() == null) {
                return;
            }
            d.this.f19509c.bringChildToFront(d.this.f19523q);
        }

        @Override // com.sigmob.sdk.mraid.b.i
        public void d(String str, JSONObject jSONObject) {
            com.sigmob.sdk.mraid.j jVar;
            View c10;
            String optString = jSONObject.optString("uniqueId");
            if (TextUtils.isEmpty(optString) || (jVar = (com.sigmob.sdk.mraid.j) d.this.f19529w.get(optString)) == null || (c10 = jVar.c()) == null) {
                return;
            }
            com.sigmob.sdk.base.utils.e.e(c10);
            d.this.f19509c.addView(c10);
        }

        @Override // com.sigmob.sdk.mraid.b.i
        public void e(String str, JSONObject jSONObject) {
            com.sigmob.sdk.mraid.h hVar;
            SigmobLog.d(" onMotionViewEvent event:" + str);
            SigmobLog.d(" postMessage args:" + jSONObject);
            String optString = jSONObject.optString("uniqueId");
            if (TextUtils.isEmpty(optString)) {
                SigmobLog.e(" onMotionViewEvent uniqueId is null:" + jSONObject);
            }
            com.sigmob.sdk.mraid.j jVar = (com.sigmob.sdk.mraid.j) d.this.f19529w.get(optString);
            hVar = (jVar == null || !(jVar instanceof com.sigmob.sdk.mraid.h)) ? null : (com.sigmob.sdk.mraid.h) jVar;
            str.hashCode();
            switch (str) {
                case "hidden":
                    if (hVar != null) {
                        hVar.a(jSONObject.optBoolean("hidden"));
                        break;
                    }
                    break;
                case "init":
                    com.sigmob.sdk.mraid.h hVar2 = new com.sigmob.sdk.mraid.h(com.sigmob.sdk.a.c(), optString, jSONObject.optInt("type"));
                    hVar2.a(new C0596d());
                    d.this.f19529w.put(optString, hVar2);
                    break;
                case "frame":
                    if (hVar != null) {
                        hVar.i(jSONObject);
                        break;
                    }
                    break;
                case "start":
                    if (hVar != null) {
                        hVar.d();
                        break;
                    }
                    break;
                case "sensitivity":
                    if (hVar != null) {
                        hVar.a(jSONObject.optInt("sensitivity"));
                        break;
                    }
                    break;
                case "destroy":
                    if (hVar != null) {
                        hVar.a();
                    }
                    d.this.f19529w.remove(optString);
                    break;
                case "sensitivity_raw":
                    if (hVar != null) {
                        hVar.b(jSONObject.optInt("sensitivity_raw"));
                        break;
                    }
                    break;
            }
        }
    }

    public class b implements b.h {
        public b() {
        }

        @Override // com.sigmob.sdk.mraid.b.h
        public void a() {
            d.this.q();
            d.this.f19519m.a();
        }

        @Override // com.sigmob.sdk.mraid.b.h
        public void b(boolean z10) {
            d.this.a(z10);
        }

        @Override // com.sigmob.sdk.mraid.b.h
        public void c() {
            if (d.this.f19519m != null) {
                d.this.f19519m.c();
            }
        }

        @Override // com.sigmob.sdk.mraid.b.h
        public void d() {
            if (d.this.f19519m != null) {
                d.this.f19519m.d();
            }
        }

        @Override // com.sigmob.sdk.mraid.b.h
        public void f() {
            if (d.this.f19519m != null) {
                d.this.f19519m.f();
            }
        }

        @Override // com.sigmob.sdk.mraid.b.h
        public void g() {
            d.this.s();
            if (d.this.f19519m != null) {
                d.this.f19519m.a(d.this.f19509c);
            }
        }

        @Override // com.sigmob.sdk.mraid.b.h
        public void h() {
            d.this.r();
        }

        @Override // com.sigmob.sdk.mraid.b.h
        public void i() {
            if (d.this.f19519m != null) {
                d.this.f19519m.e();
            }
        }

        @Override // com.sigmob.sdk.mraid.b.h
        public boolean a(ConsoleMessage consoleMessage) {
            return d.this.a(consoleMessage);
        }

        @Override // com.sigmob.sdk.mraid.b.h
        public void b(String str, Map<String, String> map) {
            d.this.b(str, map);
        }

        @Override // com.sigmob.sdk.mraid.b.h
        public void a(URI uri, boolean z10) throws com.sigmob.sdk.mraid.c {
            d.this.a(uri, z10);
        }

        @Override // com.sigmob.sdk.mraid.b.h
        public void a(String str, Map<String, String> map) {
            d.this.a(str, map);
        }

        @Override // com.sigmob.sdk.mraid.b.h
        public boolean a(String str, JsResult jsResult) {
            return d.this.a(str, jsResult);
        }

        @Override // com.sigmob.sdk.mraid.b.h
        public void a(URI uri, int i10, String str) {
            d.this.a(uri, i10, str);
        }

        @Override // com.sigmob.sdk.mraid.b.h
        public void a(URI uri) {
            d.this.a(uri.toString());
        }

        @Override // com.sigmob.sdk.mraid.b.h
        public void a(WindAdError windAdError) {
            d.this.a(windAdError);
        }

        @Override // com.sigmob.sdk.mraid.b.h
        public void a(int i10, int i11, int i12, int i13, a.b bVar, boolean z10) {
            if (d.this.f19519m != null) {
                d.this.f19519m.a(i10, i11, i12, i13, bVar, z10);
            }
        }

        @Override // com.sigmob.sdk.mraid.b.h
        public void a(boolean z10, com.sigmob.sdk.mraid.k kVar) throws com.sigmob.sdk.mraid.c {
            d.this.a(z10, kVar);
        }

        @Override // com.sigmob.sdk.mraid.b.h
        public void a(boolean z10) {
            d.this.f19512f.a(z10);
        }
    }

    public class c implements View.OnTouchListener {
        public c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* renamed from: com.sigmob.sdk.mraid.d$d */
    public class RunnableC0597d implements Runnable {
        public RunnableC0597d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f19520n != null) {
                d.this.f19520n.a(d.this.f19514h);
            }
        }
    }

    public class e implements ValueCallback<String> {
        public e() {
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Float valueOf;
            try {
                if (str.equalsIgnoreCase("null") || str.equalsIgnoreCase("undefined") || (valueOf = Float.valueOf(str)) == null || valueOf.floatValue() <= 1.0E-5d) {
                    return;
                }
                d.this.f19515i = Integer.valueOf((int) (valueOf.floatValue() * 1000.0f));
                if (d.this.f19522p != null) {
                    d.this.f19522p.a(d.this.f19515i);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.this.f19512f.a(new MraidEnv());
                d.this.f19512f.a(d.this.f19513g.b(d.this.h()), d.this.f19513g.d(d.this.h()), com.sigmob.sdk.mraid.i.a(d.this.h()), com.sigmob.sdk.mraid.i.c(d.this.h()), d.this.t(), true, true);
                d.this.f19512f.a(d.this.f19507a);
                d.this.f19512f.a(d.this.f19508b.getRvAdSetting());
                if (!TextUtils.isEmpty(d.this.f19508b.getVideo_url())) {
                    String proxyVideoUrl = d.this.f19508b.getProxyVideoUrl();
                    d.this.f19512f.a(d.this.f19508b.getMaterial().video_size != null ? new VideoItem(proxyVideoUrl, d.this.f19508b.getMaterial().video_size.width.intValue(), d.this.f19508b.getMaterial().video_size.height.intValue()) : new VideoItem(proxyVideoUrl, 0, 0));
                    d.this.e();
                }
                MaterialMeta.Builder newBuilder = d.this.f19508b.getMaterial().newBuilder();
                if (!d.this.f19508b.getMaterial().has_companion_endcard.booleanValue()) {
                    newBuilder = newBuilder.companion(null);
                }
                d.this.f19512f.a(newBuilder.html_snippet(null).html_url(null).deeplink_url(null).landing_page(null).web_event_handle(null).endcard_url(null).build());
                d.this.f19512f.a(d.this.f19508b.getAd().newBuilder().materials(new LinkedList()).ad_tracking(new LinkedList()).build(), d.this.f19508b.getSlotAdSetting());
            } catch (Throwable th2) {
                SigmobLog.e("handleMraidLoad", th2);
            }
            if (d.this.B) {
                d.this.s();
            }
        }
    }

    public interface g {
        void a();

        void a(float f10);

        void a(int i10, int i11, int i12, int i13, a.b bVar, boolean z10);

        void a(View view);

        void a(WindAdError windAdError);

        void a(String str);

        void a(URI uri, int i10, String str);

        void a(boolean z10);

        void b(float f10);

        void c();

        void d();

        void e();

        void f();

        void g();

        void h();

        void i();
    }

    public interface h {
        void a(p pVar, com.sigmob.sdk.base.common.t tVar);
    }

    public class i extends BroadcastReceiver {

        /* renamed from: a */
        public Context f19543a;

        /* renamed from: b */
        public int f19544b = -1;

        public i() {
        }

        public void a(Context context) {
            Preconditions.checkNotNull(context);
            Context applicationContext = context.getApplicationContext();
            this.f19543a = applicationContext;
            if (applicationContext != null) {
                IntentUtil.registerReceiver(applicationContext, this, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int j10;
            if (this.f19543a == null || d.this.f19528v || !"android.intent.action.CONFIGURATION_CHANGED".equals(intent.getAction()) || (j10 = d.this.j()) == this.f19544b) {
                return;
            }
            this.f19544b = j10;
            d.this.a(j10);
        }

        public void a() {
            Context context = this.f19543a;
            if (context != null) {
                context.unregisterReceiver(this);
                this.f19543a = null;
            }
        }
    }

    public static class j {

        /* renamed from: a */
        public final Handler f19546a = new Handler();

        /* renamed from: b */
        public a f19547b;

        public static class a {

            /* renamed from: a */
            public final View[] f19548a;

            /* renamed from: b */
            public final Handler f19549b;

            /* renamed from: c */
            public int f19550c;

            /* renamed from: d */
            public Runnable f19551d;

            /* renamed from: e */
            public final Runnable f19552e;

            /* renamed from: com.sigmob.sdk.mraid.d$j$a$a */
            public class RunnableC0598a implements Runnable {

                /* renamed from: com.sigmob.sdk.mraid.d$j$a$a$a */
                public class ViewTreeObserverOnPreDrawListenerC0599a implements ViewTreeObserver.OnPreDrawListener {

                    /* renamed from: a */
                    public final /* synthetic */ View f19554a;

                    public ViewTreeObserverOnPreDrawListenerC0599a(View view) {
                        this.f19554a = view;
                    }

                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        this.f19554a.getViewTreeObserver().removeOnPreDrawListener(this);
                        a.this.b();
                        return true;
                    }
                }

                public RunnableC0598a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    for (View view : a.this.f19548a) {
                        if (view.getHeight() > 0 || view.getWidth() > 0) {
                            a.this.b();
                        } else {
                            view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC0599a(view));
                        }
                    }
                }
            }

            public a(Handler handler, View[] viewArr) {
                this.f19552e = new RunnableC0598a();
                this.f19549b = handler;
                this.f19548a = viewArr;
            }

            public /* synthetic */ a(Handler handler, View[] viewArr, a aVar) {
                this(handler, viewArr);
            }

            public void a() {
                this.f19549b.removeCallbacks(this.f19552e);
                this.f19551d = null;
            }

            public final void b() {
                Runnable runnable;
                int i10 = this.f19550c - 1;
                this.f19550c = i10;
                if (i10 != 0 || (runnable = this.f19551d) == null) {
                    return;
                }
                runnable.run();
                this.f19551d = null;
            }

            public void a(Runnable runnable) {
                this.f19551d = runnable;
                this.f19550c = this.f19548a.length;
                this.f19549b.post(this.f19552e);
            }
        }

        public void a() {
            a aVar = this.f19547b;
            if (aVar != null) {
                aVar.a();
                this.f19547b = null;
            }
        }

        public a a(View... viewArr) {
            a aVar = new a(this.f19546a, viewArr, null);
            this.f19547b = aVar;
            return aVar;
        }
    }

    public interface k {
        void a(boolean z10);
    }

    public interface l {
        void a();

        void a(Integer num);

        void a(Map<String, String> map);

        void b();

        void b(Map<String, String> map);

        void c();

        void d();

        void e();

        void f();

        void g();

        void h();
    }

    public d(Context context, BaseAdUnit baseAdUnit, PlacementType placementType) {
        this(context, baseAdUnit, placementType, new com.sigmob.sdk.mraid.b(baseAdUnit, placementType), null, new j());
    }

    public void a(int i10, int i11, int i12, int i13, a.b bVar, boolean z10) throws com.sigmob.sdk.mraid.c {
    }

    public void q() {
        ViewState viewState;
        ViewState viewState2;
        if (this.f19523q == null || (viewState = this.f19518l) == ViewState.LOADING || viewState == (viewState2 = ViewState.HIDDEN)) {
            return;
        }
        ViewState viewState3 = ViewState.EXPANDED;
        if (viewState == viewState3 || this.f19507a == PlacementType.INTERSTITIAL) {
            z();
        }
        ViewState viewState4 = this.f19518l;
        if (viewState4 == ViewState.RESIZED || viewState4 == viewState3) {
            this.f19509c.addView(this.f19523q, new FrameLayout.LayoutParams(-1, -1));
            this.f19509c.setVisibility(0);
            a(ViewState.DEFAULT);
        } else if (viewState4 == ViewState.DEFAULT) {
            this.f19509c.setVisibility(4);
            a(viewState2);
        }
    }

    @SuppressLint({"JavascriptInterface"})
    public void r() {
        WindAds.sharedAds().getHandler().post(new f());
    }

    @SuppressLint({"JavascriptInterface"})
    public void s() {
        try {
            this.B = true;
            u();
            a(ViewState.DEFAULT);
            v();
            this.f19512f.n();
            this.f19512f.a(true);
            try {
                this.f19512f.o();
                a();
                DeviceContext e10 = com.sigmob.sdk.a.e();
                this.f19512f.a(e10 != null ? e10.getLocation() : ClientMetadata.getInstance().getLocation());
            } catch (Throwable unused) {
                SigmobLog.e("Failed to apply orientation.");
            }
        } catch (Throwable th2) {
            SigmobLog.e("handlePageLoad error", th2);
        }
    }

    public boolean t() {
        Activity b10 = com.sigmob.sdk.base.utils.e.b(this.f19509c);
        if (b10 == null || i() == null) {
            return false;
        }
        if (this.f19507a != PlacementType.INLINE) {
            return true;
        }
        return this.f19513g.a(b10, i());
    }

    public void u() {
        String str = ClientMetadata.getInstance().getOrientationInt().intValue() == 1 ? "portrait" : "landscape";
        DisplayMetrics displayMetrics = h().getResources().getDisplayMetrics();
        com.sigmob.sdk.base.common.g gVar = this.C;
        if (gVar != null) {
            this.f19511e.a(gVar.b(), this.C.a());
        } else {
            this.f19511e.a(displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        ViewGroup o10 = o();
        this.f19511e.c(0, 0, o10.getMeasuredWidth(), o10.getMeasuredHeight());
        this.f19511e.b(0, 0, o10.getMeasuredWidth(), o10.getMeasuredHeight());
        this.f19511e.a(0, 0, o10.getMeasuredWidth(), o10.getMeasuredHeight());
        this.f19512f.a(new CurrentAppOrientation(str, true));
        this.f19512f.a(this.f19511e);
    }

    public void v() {
        this.f19512f.a(new ExposureChange(100.0f, new Rect(0, 0, o().getWidth(), o().getHeight()), null));
    }

    public void w() {
        this.f19528v = true;
        this.f19512f.a(false);
    }

    public void x() {
        p pVar = this.f19523q;
        if (pVar != null) {
            pVar.resumeTimers();
        }
        if (this.f19528v) {
            this.f19512f.a(true);
        }
        this.f19528v = false;
    }

    public void y() {
        this.f19528v = false;
        p pVar = this.f19523q;
        if (pVar != null) {
            pVar.onResume();
        }
    }

    public void z() {
        Integer num;
        try {
            Activity b10 = com.sigmob.sdk.base.utils.e.b(this.f19509c);
            if (b10 != null && (num = this.f19525s) != null) {
                b10.setRequestedOrientation(num.intValue());
            }
            this.f19525s = null;
        } catch (Exception e10) {
            SigmobLog.e("unApplyOrientation: " + e10.getMessage());
        }
    }

    public d(Context context, BaseAdUnit baseAdUnit, PlacementType placementType, com.sigmob.sdk.mraid.b bVar, com.sigmob.sdk.mraid.b bVar2, j jVar) {
        this.f19514h = false;
        ViewState viewState = ViewState.LOADING;
        this.f19518l = viewState;
        this.f19524r = new i();
        this.f19526t = true;
        this.f19527u = com.sigmob.sdk.mraid.k.NONE;
        this.f19528v = false;
        this.f19529w = new HashMap<>();
        a aVar = new a();
        this.f19531y = aVar;
        b bVar3 = new b();
        this.f19532z = bVar3;
        Preconditions.checkNotNull(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.f19509c = frameLayout;
        this.f19508b = baseAdUnit;
        this.f19507a = placementType;
        this.f19512f = bVar;
        this.f19510d = jVar;
        this.f19518l = viewState;
        this.f19511e = new com.sigmob.sdk.mraid.l(context, context.getResources().getDisplayMetrics().density);
        frameLayout.setBackgroundColor(0);
        new View(context).setOnTouchListener(new c());
        this.f19524r.a(context);
        bVar.a(bVar3);
        bVar.a(aVar);
        this.f19513g = new com.sigmob.sdk.mraid.i();
    }

    public void a(String str) {
    }

    public final void c() {
        this.f19512f.a();
        this.f19523q = null;
    }

    public FrameLayout d() {
        return this.f19509c;
    }

    public Integer e() {
        Integer num = this.f19515i;
        if (num != null) {
            return num;
        }
        this.f19512f.a(new e());
        return 0;
    }

    @Deprecated
    public boolean f() {
        return this.f19526t;
    }

    public String g() {
        return this.f19512f.b();
    }

    public final Context h() {
        FrameLayout frameLayout = this.f19509c;
        if (frameLayout != null) {
            return frameLayout.getContext();
        }
        return null;
    }

    public p i() {
        return this.f19523q;
    }

    public final int j() {
        return ClientMetadata.getInstance().getScreenOrientation(h());
    }

    @Deprecated
    public com.sigmob.sdk.mraid.k k() {
        return this.f19527u;
    }

    public com.sigmob.sdk.mraid.b l() {
        return this.f19512f;
    }

    @Deprecated
    public p m() {
        return this.f19523q;
    }

    @Deprecated
    public Integer n() {
        return this.f19525s;
    }

    public final ViewGroup o() {
        ViewGroup viewGroup = this.f19517k;
        if (viewGroup != null) {
            return viewGroup;
        }
        View a10 = com.sigmob.sdk.base.utils.e.a(h(), this.f19509c);
        ViewGroup viewGroup2 = a10 instanceof ViewGroup ? (ViewGroup) a10 : this.f19509c;
        this.f19517k = viewGroup2;
        return viewGroup2;
    }

    @Deprecated
    public ViewState p() {
        return this.f19518l;
    }

    public void a(URI uri, boolean z10) throws com.sigmob.sdk.mraid.c {
    }

    public void b() {
        this.f19510d.a();
        this.f19520n = null;
        this.f19519m = null;
        Iterator<com.sigmob.sdk.mraid.j> it = this.f19529w.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f19529w.clear();
        try {
            this.f19524r.a();
        } catch (Throwable unused) {
        }
        try {
            APKStatusBroadcastReceiver aPKStatusBroadcastReceiver = this.A;
            if (aPKStatusBroadcastReceiver != null) {
                aPKStatusBroadcastReceiver.b(aPKStatusBroadcastReceiver);
            }
        } catch (Throwable unused2) {
        }
        if (!this.f19528v) {
            e(true);
        }
        c();
        z();
    }

    public void c(boolean z10) {
        if (z10) {
            this.f19512f.k();
        } else {
            this.f19512f.i();
        }
    }

    public void d(boolean z10) {
        if (z10) {
            this.f19512f.j();
        }
    }

    public void e(boolean z10) {
        this.f19528v = true;
        p pVar = this.f19523q;
        if (pVar != null) {
            pVar.b(z10);
        }
    }

    public void b(String str, h hVar) {
        p pVar = new p(h());
        this.f19523q = pVar;
        pVar.a(true);
        this.f19523q.setBackgroundColor(0);
        if (hVar != null) {
            hVar.a(this.f19523q, null);
        }
        this.f19512f.a(this.f19523q);
        this.f19509c.addView(this.f19523q, new FrameLayout.LayoutParams(-1, -1));
        this.f19512f.i(str);
    }

    public final void b(String str, Map<String, String> map) {
        if (this.f19522p == null) {
        }
        str.hashCode();
        switch (str) {
            case "AdPaused":
                this.f19522p.e();
                break;
            case "AdImpression":
                this.f19522p.c();
                break;
            case "AdVideoThirdQuartile":
                this.f19522p.d();
                break;
            case "AdVideoMidpoint":
                this.f19522p.a();
                break;
            case "AdVideoComplete":
                this.f19522p.h();
                break;
            case "AdVideoFirstQuartile":
                this.f19522p.b();
                break;
            case "AdError":
                this.f19522p.a(map);
                break;
            case "AdVideoStart":
                this.f19522p.g();
                break;
            case "AdClickThru":
                this.f19522p.b(map);
                break;
            case "AdPlaying":
                this.f19522p.f();
                break;
        }
    }

    public void b(String str) {
        this.f19512f.c(str);
    }

    public void a() throws com.sigmob.sdk.mraid.c {
        int b10;
        com.sigmob.sdk.mraid.k kVar = this.f19527u;
        if (kVar != com.sigmob.sdk.mraid.k.NONE) {
            b10 = kVar.b();
        } else {
            if (this.f19526t) {
                z();
                return;
            }
            Activity b11 = com.sigmob.sdk.base.utils.e.b(this.f19509c);
            if (b11 == null) {
                throw new com.sigmob.sdk.mraid.c("Unable to set MRAID expand orientation to 'none'; expected passed in Activity Context.");
            }
            b10 = ClientMetadata.getInstance().getScreenOrientation(b11);
        }
        b(b10);
    }

    public void b(int i10) throws com.sigmob.sdk.mraid.c {
        Activity b10 = com.sigmob.sdk.base.utils.e.b(this.f19509c);
        if (b10 == null || !a(this.f19527u)) {
            throw new com.sigmob.sdk.mraid.c("Attempted to lock orientation to unsupported value: " + this.f19527u.name());
        }
        if (this.f19525s == null) {
            this.f19525s = Integer.valueOf(b10.getRequestedOrientation());
        }
        try {
            b10.setRequestedOrientation(i10);
        } catch (Exception e10) {
            SigmobLog.e("lockOrientation: " + e10.getMessage());
        }
    }

    public static void a(g gVar, ViewState viewState, ViewState viewState2) {
        Preconditions.checkNotNull(gVar);
        Preconditions.checkNotNull(viewState);
        Preconditions.checkNotNull(viewState2);
    }

    public void b(boolean z10) {
        if (z10) {
            this.f19512f.h();
        } else {
            this.f19512f.i();
        }
    }

    public int a(int i10, int i11, int i12) {
        return Math.max(i10, Math.min(i11, i12));
    }

    @Deprecated
    public void b(ViewState viewState) {
        this.f19518l = viewState;
    }

    public void a(String str, h hVar) {
        p pVar = new p(h());
        this.f19523q = pVar;
        pVar.a(true);
        this.f19523q.setBackgroundColor(0);
        if (hVar != null) {
            hVar.a(this.f19523q, null);
        }
        this.f19512f.a(this.f19523q);
        this.f19509c.addView(this.f19523q, new FrameLayout.LayoutParams(-1, -1));
        this.f19512f.a(h(), str);
    }

    public void a(ValueCallback valueCallback) {
        this.f19512f.b(valueCallback);
    }

    public boolean a(ConsoleMessage consoleMessage) {
        r rVar = this.f19521o;
        if (rVar != null) {
            return rVar.a(consoleMessage);
        }
        return true;
    }

    public void a(boolean z10) {
        this.f19514h = z10;
        k kVar = this.f19520n;
        if (kVar != null) {
            kVar.a(z10);
        }
    }

    public final void a(String str, Map<String, String> map) {
        char c10;
        if (this.f19519m == null) {
            return;
        }
        try {
            String a10 = com.sigmob.sdk.mraid.b.a(map.get("ext"));
            String a11 = com.sigmob.sdk.mraid.b.a(map.get("ctime"));
            String a12 = com.sigmob.sdk.mraid.b.a(map.get("state"));
            switch (str.hashCode()) {
                case -1610203128:
                    if (str.equals(ExtensionEvent.AD_ENDCARD_SHOW)) {
                        c10 = 3;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -1102513700:
                    if (str.equals(ExtensionEvent.AD_COMPANION_CLICK)) {
                        c10 = 4;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -934326481:
                    if (str.equals("reward")) {
                        c10 = 1;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -900560382:
                    if (str.equals(ExtensionEvent.AD_SKIP)) {
                        c10 = 0;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 112386354:
                    if (str.equals(ExtensionEvent.AD_MUTE)) {
                        c10 = 2;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1293469449:
                    if (str.equals(ExtensionEvent.AD_SHOE_SKIP_TIME)) {
                        c10 = 5;
                        break;
                    }
                    c10 = 65535;
                    break;
                default:
                    c10 = 65535;
                    break;
            }
            if (c10 == 0) {
                Float valueOf = Float.valueOf(0.0f);
                try {
                    valueOf = Float.valueOf(a11);
                } catch (Throwable unused) {
                }
                this.f19519m.b(valueOf.floatValue());
                return;
            }
            if (c10 == 1) {
                Float valueOf2 = Float.valueOf(0.0f);
                try {
                    valueOf2 = Float.valueOf(a11);
                } catch (Throwable unused2) {
                }
                this.f19519m.a(valueOf2.floatValue());
            } else {
                if (c10 == 2) {
                    this.f19519m.a(a12.equalsIgnoreCase("true") || a12.equalsIgnoreCase("1"));
                    return;
                }
                if (c10 == 3) {
                    this.f19519m.i();
                } else if (c10 == 4) {
                    this.f19519m.a(a10);
                } else {
                    if (c10 != 5) {
                        return;
                    }
                    this.f19519m.h();
                }
            }
        } catch (Throwable unused3) {
        }
    }

    public boolean a(String str, JsResult jsResult) {
        r rVar = this.f19521o;
        if (rVar != null) {
            return rVar.a(str, jsResult);
        }
        jsResult.confirm();
        return true;
    }

    public void a(URI uri, int i10, String str) {
        g gVar = this.f19519m;
        if (gVar != null) {
            gVar.a(uri, i10, str);
        }
    }

    public void a(int i10) {
        SigmobLog.i("handleOrientationChange " + i10);
        a((Runnable) null);
    }

    public void a(WindAdError windAdError) {
        g gVar = this.f19519m;
        if (gVar != null) {
            gVar.a(windAdError);
        }
    }

    public void a(boolean z10, com.sigmob.sdk.mraid.k kVar) throws com.sigmob.sdk.mraid.c {
        if (!a(kVar)) {
            throw new com.sigmob.sdk.mraid.c("Unable to force orientation to " + kVar);
        }
        this.f19526t = z10;
        this.f19527u = kVar;
        if (this.f19518l == ViewState.EXPANDED || (this.f19507a == PlacementType.INTERSTITIAL && !this.f19528v)) {
            a();
        }
    }

    public void a(String str, String str2, String str3, HashMap<String, Object> hashMap) {
        this.f19512f.a(str, str2, str3, hashMap);
    }

    public void a(Activity activity) {
        new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0597d(), 5000);
    }

    public void a(com.sigmob.sdk.base.common.g gVar) {
        this.C = gVar;
    }

    public void a(r rVar) {
        this.f19521o = rVar;
    }

    public void a(g gVar) {
        this.f19519m = gVar;
    }

    @Deprecated
    public void a(i iVar) {
        this.f19524r = iVar;
    }

    @Deprecated
    public void a(int i10, int i11) {
        this.f19511e.c(0, 0, i10, i11);
    }

    public void a(k kVar) {
        this.f19520n = kVar;
    }

    public final void a(ViewState viewState) {
        SigmobLog.d("MRAID state set to " + viewState);
        ViewState viewState2 = this.f19518l;
        this.f19518l = viewState;
        this.f19512f.a(viewState);
        g gVar = this.f19519m;
        if (gVar != null) {
            a(gVar, viewState2, viewState);
        }
        SigmobLog.e("setViewState state set to " + viewState);
        a((Runnable) null);
    }

    public void a(l lVar) {
        this.f19522p = lVar;
    }

    public boolean a(com.sigmob.sdk.mraid.k kVar) {
        if (kVar == com.sigmob.sdk.mraid.k.NONE) {
            return true;
        }
        Activity b10 = com.sigmob.sdk.base.utils.e.b(this.f19509c);
        if (b10 == null) {
            return false;
        }
        try {
            int i10 = b10.getPackageManager().getActivityInfo(new ComponentName(b10, b10.getClass()), 0).screenOrientation;
            return i10 == -1 || i10 == kVar.b();
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public void a(String str, String str2) {
        this.f19512f.c(str, str2);
    }

    public final void a(Runnable runnable) {
        this.f19510d.a();
        p i10 = i();
        if (i10 == null || this.f19528v) {
            return;
        }
        DisplayMetrics displayMetrics = h().getResources().getDisplayMetrics();
        com.sigmob.sdk.base.common.g gVar = this.C;
        if (gVar != null) {
            this.f19511e.a(gVar.b(), this.C.a());
        } else {
            this.f19511e.a(displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        int[] iArr = new int[2];
        ViewGroup o10 = o();
        o10.getLocationOnScreen(iArr);
        this.f19511e.c(iArr[0], iArr[1], o10.getWidth(), o10.getHeight());
        this.f19511e.b(iArr[0], iArr[1], o10.getWidth(), o10.getHeight());
        i10.getLocationOnScreen(iArr);
        this.f19511e.a(iArr[0], iArr[1], i10.getWidth(), i10.getHeight());
        this.f19512f.a(new CurrentAppOrientation(ClientMetadata.getInstance().getOrientationInt().intValue() == 1 ? "portrait" : "landscape", true));
        this.f19512f.a(this.f19511e);
        if (runnable != null) {
            runnable.run();
        }
    }
}
