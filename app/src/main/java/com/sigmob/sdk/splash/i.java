package com.sigmob.sdk.splash;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.wire.Wire;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.common.d0;
import com.sigmob.sdk.base.common.j0;
import com.sigmob.sdk.base.common.k0;
import com.sigmob.sdk.base.common.y;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.AndroidMarket;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.views.a0;
import com.sigmob.sdk.base.views.c0;
import com.sigmob.sdk.base.views.e0;
import com.sigmob.sdk.base.views.g0;
import com.sigmob.sdk.base.views.i0;
import com.sigmob.sdk.base.views.n0;
import com.sigmob.sdk.base.views.o0;
import com.sigmob.sdk.base.views.q;
import com.sigmob.sdk.base.views.u0;
import com.sigmob.sdk.base.views.v;
import com.sigmob.sdk.base.views.x;
import com.sigmob.windad.WindAdError;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class i extends RelativeLayout {

    /* renamed from: t */
    public static float f20334t = 25.0f;

    /* renamed from: u */
    public static float f20335u = 13.0f;

    /* renamed from: a */
    public final RelativeLayout f20336a;

    /* renamed from: b */
    public com.sigmob.sdk.splash.d f20337b;

    /* renamed from: c */
    public Context f20338c;

    /* renamed from: d */
    public BaseAdUnit f20339d;

    /* renamed from: e */
    public com.sigmob.sdk.splash.c f20340e;

    /* renamed from: f */
    public String f20341f;

    /* renamed from: g */
    public boolean f20342g;

    /* renamed from: h */
    public RelativeLayout f20343h;

    /* renamed from: i */
    public RelativeLayout f20344i;

    /* renamed from: j */
    public View.OnTouchListener f20345j;

    /* renamed from: k */
    public float f20346k;

    /* renamed from: l */
    public volatile boolean f20347l;

    /* renamed from: m */
    public boolean f20348m;

    /* renamed from: n */
    public boolean f20349n;

    /* renamed from: o */
    public e0 f20350o;

    /* renamed from: p */
    public y.b f20351p;

    /* renamed from: q */
    public com.sigmob.sdk.splash.k f20352q;

    /* renamed from: r */
    public v f20353r;

    /* renamed from: s */
    public boolean f20354s;

    public class a implements View.OnTouchListener {

        /* renamed from: a */
        public MotionEvent f20355a;

        /* renamed from: b */
        public final /* synthetic */ int f20356b;

        public a(int i10) {
            this.f20356b = i10;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (i.this.f20339d == null) {
                return false;
            }
            if (motionEvent.getAction() == 0) {
                this.f20355a = MotionEvent.obtain(motionEvent);
                i.this.f20347l = false;
            } else {
                if ((motionEvent.getAction() != 2 && motionEvent.getAction() != 1) || i.this.f20347l) {
                    return true;
                }
                float x10 = motionEvent.getX();
                float y10 = motionEvent.getY();
                if (((float) Math.sqrt(Math.pow(Math.abs(x10 - this.f20355a.getX()), 2.0d) + Math.pow(Math.abs(y10 - this.f20355a.getY()), 2.0d))) >= this.f20356b) {
                    i.this.f20347l = true;
                    SigMacroCommon macroCommon = i.this.f20339d.getMacroCommon();
                    if (macroCommon != null) {
                        macroCommon.updateClickMarco(this.f20355a, motionEvent, false);
                    }
                    i.this.a((String) null);
                }
            }
            return true;
        }
    }

    public class b implements View.OnTouchListener {

        /* renamed from: a */
        public MotionEvent f20358a;

        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (i.this.f20339d == null) {
                return false;
            }
            if (motionEvent.getAction() == 0) {
                this.f20358a = MotionEvent.obtain(motionEvent);
            } else if (motionEvent.getAction() == 1) {
                i.this.f20339d.getClickCommon().click_area = "appinfo";
                i.this.f20339d.getClickCommon().click_scene = "ad";
                if (this.f20358a == null) {
                    this.f20358a = motionEvent;
                }
                try {
                    i.this.f20339d.getMacroCommon().updateClickMarco(this.f20358a, motionEvent, false);
                } catch (Throwable th2) {
                    SigmobLog.e("splash click macro set " + th2.getMessage());
                }
                i.this.f20340e.k();
            }
            return true;
        }
    }

    public class c implements y.c {

        /* renamed from: a */
        public final /* synthetic */ u0 f20360a;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                i.this.a((String) null);
            }
        }

        public c(u0 u0Var) {
            this.f20360a = u0Var;
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a(float f10) {
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a(Map<String, Number> map) {
            if (map == null || i.this.f20339d == null || i.this.f20347l) {
                return;
            }
            i.this.f20347l = true;
            Number number = map.get("turn_x");
            Number number2 = map.get("turn_y");
            Number number3 = map.get("turn_z");
            Number number4 = map.get("turn_time");
            if (number != null) {
                i.this.f20339d.getClickCommon().turn_x = String.valueOf(number.intValue());
            }
            if (number2 != null) {
                i.this.f20339d.getClickCommon().turn_y = String.valueOf(number2.intValue());
            }
            if (number3 != null) {
                i.this.f20339d.getClickCommon().turn_z = String.valueOf(number3.intValue());
            }
            i.this.f20339d.getClickCommon().turn_time = String.valueOf(number4);
            i.this.f20339d.getClickCommon().sld = "5";
            i.this.f20339d.getClickCommon().click_area = ClickCommon.CLICK_AREA_COMPONENT;
            i.this.f20339d.getClickCommon().click_scene = "ad";
            this.f20360a.postDelayed(new a(), 400L);
        }
    }

    public static /* synthetic */ class d {

        /* renamed from: a */
        public static final /* synthetic */ int[] f20363a;

        static {
            int[] iArr = new int[j0.values().length];
            f20363a = iArr;
            try {
                iArr[j0.f17909e.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20363a[j0.f17906b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20363a[j0.f17907c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20363a[j0.f17908d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f20363a[j0.f17910f.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f20363a[j0.f17911g.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f20363a[j0.f17912h.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f20363a[j0.f17913i.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public class e implements q.g {
        public e() {
        }

        @Override // com.sigmob.sdk.base.views.q.g
        public void a(String str, String str2) {
            if (i.this.f20339d != null) {
                i.this.f20339d.getClickCommon().click_scene = "appinfo";
                i.this.f20339d.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
                i.this.f20339d.getClickCommon().is_final_click = true;
                d0 sessionManager = i.this.f20339d.getSessionManager();
                if (sessionManager != null) {
                    sessionManager.a("click", 0);
                }
            }
        }

        @Override // com.sigmob.sdk.base.views.q.g
        public void b() {
            if (i.this.f20351p != null) {
                i.this.f20351p.b();
            }
            i.this.f20348m = true;
        }

        @Override // com.sigmob.sdk.base.views.q.g
        public void a() {
            i.this.f20348m = false;
            i.this.f20347l = false;
            if (i.this.f20349n) {
                i.this.a(true);
            } else if (i.this.f20351p != null) {
                i.this.f20351p.c();
            }
        }
    }

    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public class g implements View.OnTouchListener {

        /* renamed from: a */
        public MotionEvent f20366a;

        public g() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (i.this.f20339d == null) {
                SigmobLog.e("adUnit is null");
                return false;
            }
            if (motionEvent.getAction() == 0) {
                this.f20366a = MotionEvent.obtain(motionEvent);
            } else if (motionEvent.getAction() == 1) {
                if (this.f20366a == null) {
                    this.f20366a = motionEvent;
                }
                try {
                    i.this.f20339d.getClickCommon().sld = "0";
                    i.this.f20339d.getClickCommon().click_area = "companion";
                    i.this.f20339d.getClickCommon().click_scene = "ad";
                    i.this.f20339d.getMacroCommon().updateClickMarco(this.f20366a, motionEvent, false);
                } catch (Throwable th2) {
                    SigmobLog.e("splash click macro set " + th2.getMessage());
                }
                i.this.a((String) null);
            }
            return true;
        }
    }

    public class h implements k0.f {

        /* renamed from: a */
        public final /* synthetic */ BaseAdUnit f20368a;

        public class a implements b0.g {

            /* renamed from: a */
            public final /* synthetic */ String f20370a;

            public a(String str) {
                this.f20370a = str;
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                    pointEntitySigmob.setFinal_url(this.f20370a);
                    if (i.this.f20339d.getInteractionType() == 8) {
                        pointEntitySigmob.getOptions().put("fast_pkg", com.sigmob.sdk.a.f());
                    }
                }
            }
        }

        public class b implements b0.g {

            /* renamed from: a */
            public final /* synthetic */ String f20372a;

            public b(String str) {
                this.f20372a = str;
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                    pointEntitySigmob.setFinal_url(this.f20372a);
                    HashMap hashMap = new HashMap();
                    hashMap.put("app_package_name", i.this.f20339d.getAndroidMarket().app_package_name);
                    hashMap.put("store_package_name", i.this.f20339d.getAndroidMarket().appstore_package_name);
                    pointEntitySigmob.setOptions(hashMap);
                }
            }
        }

        public class c implements b0.g {

            /* renamed from: a */
            public final /* synthetic */ String f20374a;

            public c(String str) {
                this.f20374a = str;
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                    pointEntitySigmob.setFinal_url(this.f20374a);
                    if (i.this.f20339d.getInteractionType() == 8) {
                        pointEntitySigmob.getOptions().put("fast_pkg", com.sigmob.sdk.a.f());
                    }
                }
            }
        }

        public class d implements b0.g {

            /* renamed from: a */
            public final /* synthetic */ String f20376a;

            public d(String str) {
                this.f20376a = str;
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                    pointEntitySigmob.setFinal_url(this.f20376a);
                    HashMap hashMap = new HashMap();
                    hashMap.put("app_package_name", i.this.f20339d.getAndroidMarket().app_package_name);
                    hashMap.put("store_package_name", i.this.f20339d.getAndroidMarket().appstore_package_name);
                    pointEntitySigmob.setOptions(hashMap);
                }
            }
        }

        public h(BaseAdUnit baseAdUnit) {
            this.f20368a = baseAdUnit;
        }

        @Override // com.sigmob.sdk.base.common.k0.f
        public void a(String str, j0 j0Var) {
            SigmobLog.i("urlHandlingSucceeded: " + j0Var.name() + " url: " + str);
            if (i.this.f20339d == null) {
                SigmobLog.e("adUnit is null");
                return;
            }
            i.this.f20339d.getClickCommon().is_final_click = true;
            if (!this.f20368a.getAd().forbiden_parse_landingpage.booleanValue()) {
                b0.a(this.f20368a, j0Var.name(), str);
            }
            BaseBroadcastReceiver.a(i.this.f20338c, i.this.f20339d.getUuid(), IntentActions.ACTION_INTERSTITIAL_CLICK);
            int i10 = d.f20363a[j0Var.ordinal()];
            if (i10 == 3 || i10 == 4) {
                Log.d("lance", "打开小程序成功:" + j0Var);
                com.sigmob.sdk.base.network.f.a(this.f20368a, "open_deeplink");
                b0.a("open_deeplink", (String) null, this.f20368a, new a(str));
            } else if (i10 == 5) {
                AndroidMarket androidMarket = i.this.f20339d.getAndroidMarket();
                if (androidMarket != null) {
                    b0.a(PointCategory.APK_CLICK, ((Integer) Wire.get(androidMarket.type, 0)).intValue() == 0 ? "market" : "mimarket", i.this.f20339d);
                    if (!TextUtils.isEmpty(androidMarket.app_package_name)) {
                        try {
                            FileUtil.writeToCache(i.this.f20339d, new File(com.sigmob.sdk.base.utils.d.f(), androidMarket.app_package_name + ".log").getAbsolutePath());
                        } catch (Throwable th2) {
                            SigmobLog.e("write ad info with package error " + th2.getMessage());
                        }
                    }
                }
                b0.a(PointCategory.OPEN_MARKET, (String) null, i.this.f20339d, new b(str));
            } else if (i10 == 6) {
                if (i.this.f20340e.l()) {
                    i.this.f20339d.getClickCommon().is_final_click = false;
                } else {
                    i.this.a(true);
                    i.this.f20340e.a(str);
                }
            }
            d0 sessionManager = this.f20368a.getSessionManager();
            if (sessionManager != null) {
                sessionManager.a("click", 0);
            }
        }

        @Override // com.sigmob.sdk.base.common.k0.f
        public void b(String str, j0 j0Var) {
            SigmobLog.i("urlHandlingFailed: " + j0Var.name() + " url: " + str);
            if (i.this.f20339d == null) {
                return;
            }
            i.this.f20339d.getClickCommon().is_final_click = true;
            int i10 = d.f20363a[j0Var.ordinal()];
            if (i10 == 3 || i10 == 4) {
                Log.d("lance", "打开小程序失败:" + j0Var);
                com.sigmob.sdk.base.network.f.a(this.f20368a, "open_deeplink_failed");
                b0.a("open_deeplink_failed", (String) null, this.f20368a, new c(str));
                return;
            }
            if (i10 == 5) {
                b0.a(PointCategory.OPEN_MARKET_FAILED, (String) null, i.this.f20339d, new d(str));
                return;
            }
            if (i10 != 8) {
                return;
            }
            if (!this.f20368a.getAd().forbiden_parse_landingpage.booleanValue()) {
                b0.a(this.f20368a, j0Var.name(), str);
            }
            i.this.f20339d.getClickCommon().is_final_click = true;
            d0 sessionManager = this.f20368a.getSessionManager();
            if (sessionManager != null) {
                sessionManager.a("click", 0);
            }
        }
    }

    /* renamed from: com.sigmob.sdk.splash.i$i */
    public class ViewOnClickListenerC0621i implements View.OnClickListener {
        public ViewOnClickListenerC0621i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.f20354s = true;
            if (i.this.f20339d == null) {
                return;
            }
            d0 sessionManager = i.this.f20339d.getSessionManager();
            if (sessionManager != null) {
                sessionManager.a("skip", 0);
            }
            BaseBroadcastReceiver.a(i.this.f20338c, i.this.f20339d.getUuid(), IntentActions.ACTION_SPLAH_SKIP);
        }
    }

    public class j implements y.c {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (i.this.f20347l) {
                    return;
                }
                i.this.a((String) null);
            }
        }

        public j() {
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a(float f10) {
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a(Map<String, Number> map) {
            if (map == null || i.this.f20339d == null) {
                return;
            }
            Number number = map.get("x_max_acc");
            Number number2 = map.get("y_max_acc");
            Number number3 = map.get("z_max_acc");
            i.this.f20339d.getClickCommon().sld = "2";
            i.this.f20339d.getClickCommon().click_area = ClickCommon.CLICK_AREA_COMPONENT;
            i.this.f20339d.getClickCommon().click_scene = "ad";
            if (number != null) {
                i.this.f20339d.getClickCommon().x_max_acc = String.valueOf(number.intValue());
            }
            if (number2 != null) {
                i.this.f20339d.getClickCommon().y_max_acc = String.valueOf(number2.intValue());
            }
            if (number3 != null) {
                i.this.f20339d.getClickCommon().z_max_acc = String.valueOf(number3.intValue());
            }
            i.this.f20353r.postDelayed(new a(), 400L);
        }
    }

    public class k implements y.c {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (i.this.f20347l) {
                    return;
                }
                i.this.a((String) null);
            }
        }

        public k() {
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a(Map<String, Number> map) {
            if (map == null || i.this.f20339d == null) {
                return;
            }
            Number number = map.get("x_max_acc");
            Number number2 = map.get("y_max_acc");
            Number number3 = map.get("z_max_acc");
            i.this.f20339d.getClickCommon().sld = "2";
            i.this.f20339d.getClickCommon().click_area = ClickCommon.CLICK_AREA_COMPONENT;
            i.this.f20339d.getClickCommon().click_scene = "ad";
            if (number != null) {
                i.this.f20339d.getClickCommon().x_max_acc = String.valueOf(number.intValue());
            }
            if (number2 != null) {
                i.this.f20339d.getClickCommon().y_max_acc = String.valueOf(number2.intValue());
            }
            if (number3 != null) {
                i.this.f20339d.getClickCommon().z_max_acc = String.valueOf(number3.intValue());
            }
            i.this.f20353r.postDelayed(new a(), 400L);
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a(float f10) {
            if (i.this.f20353r instanceof com.sigmob.sdk.base.views.k0) {
                ((com.sigmob.sdk.base.views.k0) i.this.f20353r).a(f10);
            }
        }
    }

    public class l implements ViewTreeObserver.OnGlobalLayoutListener {
        public l() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            i.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (i.this.f20339d != null) {
                i.this.getLocationOnScreen(new int[2]);
                i.this.f20339d.getClickCommon().adarea_x = String.valueOf(Dips.pixelsToIntDips(r0[0], i.this.getContext()));
                i.this.f20339d.getClickCommon().adarea_y = String.valueOf(Dips.pixelsToIntDips(r0[1], i.this.getContext()));
                i.this.f20339d.getClickCommon().adarea_w = String.valueOf(Dips.pixelsToIntDips(i.this.getWidth(), i.this.getContext()));
                i.this.f20339d.getClickCommon().adarea_h = String.valueOf(Dips.pixelsToIntDips(i.this.getHeight(), i.this.getContext()));
            }
        }
    }

    public class m implements y.c {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                i.this.a((String) null);
            }
        }

        public m() {
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a(Map<String, Number> map) {
            if (map == null || i.this.f20339d == null || i.this.f20347l) {
                return;
            }
            i.this.f20347l = true;
            Number number = map.get("x_max_acc");
            Number number2 = map.get("y_max_acc");
            Number number3 = map.get("z_max_acc");
            if (number != null) {
                i.this.f20339d.getClickCommon().x_max_acc = String.valueOf(number.intValue());
            }
            if (number2 != null) {
                i.this.f20339d.getClickCommon().y_max_acc = String.valueOf(number2.intValue());
            }
            if (number3 != null) {
                i.this.f20339d.getClickCommon().z_max_acc = String.valueOf(number3.intValue());
            }
            i.this.f20339d.getClickCommon().sld = "2";
            i.this.f20339d.getClickCommon().click_area = ClickCommon.CLICK_AREA_COMPONENT;
            i.this.f20339d.getClickCommon().click_scene = "ad";
            i.this.f20353r.postDelayed(new a(), 400L);
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a(float f10) {
            if (i.this.f20353r instanceof n0) {
                ((n0) i.this.f20353r).a(f10);
            }
        }
    }

    public i(Context context) {
        super(context);
        this.f20346k = 1.0f;
        Context applicationContext = context.getApplicationContext();
        this.f20338c = applicationContext;
        RelativeLayout relativeLayout = new RelativeLayout(applicationContext);
        this.f20336a = relativeLayout;
        addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
    }

    public int getDuration() {
        return this.f20337b.getDuration();
    }

    public final void h() {
        this.f20353r = new com.sigmob.sdk.base.views.k0(getContext());
        int dipsToIntPixels = Dips.dipsToIntPixels(92.0f, getContext());
        int dipsToIntPixels2 = Dips.dipsToIntPixels(145.0f, getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, dipsToIntPixels2);
        if (this.f20339d.getClickType() == 1) {
            this.f20353r.setOnTouchListener(this.f20345j);
        }
        y.d dVar = new y.d(getContext(), new k(), y.e.SLOPE);
        this.f20351p = dVar;
        dVar.a(this.f20339d.getSensitivity());
        this.f20351p.c();
        addView(this.f20353r, layoutParams);
    }

    public final void i() {
        this.f20353r = new n0(getContext());
        int dipsToIntPixels = Dips.dipsToIntPixels(100.0f, getContext());
        int dipsToIntPixels2 = Dips.dipsToIntPixels(145.0f, getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, dipsToIntPixels2);
        if (this.f20339d.getClickType() == 1) {
            this.f20353r.setOnTouchListener(this.f20345j);
        }
        y.d dVar = new y.d(getContext(), new m(), y.e.SWING);
        this.f20351p = dVar;
        dVar.a(this.f20339d.getSensitivity());
        this.f20351p.c();
        addView(this.f20353r, layoutParams);
    }

    public final void j() {
        int dipsToIntPixels = Dips.dipsToIntPixels(10.0f, getContext());
        Dips.dipsToIntPixels(75.0f, getContext());
        int dipsToIntPixels2 = Dips.dipsToIntPixels(25.0f, getContext());
        TextView textView = new TextView(getContext());
        textView.setText("互动广告");
        textView.setTextSize(2, 12.0f);
        textView.setTextColor(Color.parseColor("#ccffffff"));
        textView.setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, dipsToIntPixels2);
        layoutParams.addRule(0, this.f20350o.getId());
        layoutParams.setMargins(0, dipsToIntPixels * 2, dipsToIntPixels, 0);
        addView(textView, layoutParams);
    }

    public final void k() {
        u0 u0Var = new u0(getContext());
        int dipsToIntPixels = Dips.dipsToIntPixels(100.0f, getContext());
        int dipsToIntPixels2 = Dips.dipsToIntPixels(145.0f, getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, dipsToIntPixels2);
        if (this.f20339d.getClickType() == 1) {
            u0Var.setOnTouchListener(this.f20345j);
        }
        y.d dVar = new y.d(getContext(), new c(u0Var), y.e.WRING);
        this.f20351p = dVar;
        dVar.a(this.f20339d.getSensitivity());
        this.f20351p.c();
        addView(u0Var, layoutParams);
    }

    public void l() {
        super.setVisibility(8);
        com.sigmob.sdk.splash.d dVar = this.f20337b;
        if (dVar != null) {
            dVar.setVisibility(8);
        }
    }

    public void m() {
        super.setVisibility(4);
    }

    public boolean n() {
        BaseAdUnit baseAdUnit = this.f20339d;
        if (baseAdUnit != null && baseAdUnit.getSplashFilePath() != null) {
            return this.f20337b.a(this.f20339d);
        }
        SigmobLog.e("adUnit or splashFilePath is null");
        return false;
    }

    public final void o() {
        getViewTreeObserver().addOnGlobalLayoutListener(new l());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f20339d == null) {
            SigmobLog.e("adUnit is null");
            return;
        }
        com.sigmob.sdk.splash.c cVar = this.f20340e;
        if (cVar == null) {
            return;
        }
        cVar.a(com.sigmob.sdk.base.utils.e.b(this), this.f20339d, new e());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        y.b bVar = this.f20351p;
        if (bVar != null) {
            bVar.a();
        }
        v vVar = this.f20353r;
        if (vVar != null) {
            vVar.b();
        }
        removeAllViews();
    }

    public void p() {
        this.f20347l = false;
        y.b bVar = this.f20351p;
        if (bVar != null) {
            bVar.b();
        }
        this.f20337b.a();
    }

    public void q() {
        y.b bVar = this.f20351p;
        if (bVar != null) {
            bVar.c();
        }
        v vVar = this.f20353r;
        if (vVar != null) {
            vVar.a();
        }
        this.f20337b.b();
    }

    public void setDuration(int i10) {
        e0 e0Var;
        if (this.f20339d == null) {
            return;
        }
        if (i10 > 0 && (e0Var = this.f20350o) != null) {
            e0Var.a(i10);
            return;
        }
        this.f20349n = true;
        if (!this.f20348m || this.f20354s) {
            a(true);
        }
        b0.a("complete", (String) null, this.f20339d);
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        com.sigmob.sdk.splash.d dVar = this.f20337b;
        if (dVar != null) {
            dVar.setOnTouchListener(onTouchListener);
        }
    }

    public void setShowAppLogo(boolean z10) {
        this.f20342g = z10;
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        d0 sessionManager;
        if (i10 == 0) {
            this.f20350o.setVisibility(0);
            this.f20337b.c();
            BaseAdUnit baseAdUnit = this.f20339d;
            if (baseAdUnit != null && (sessionManager = baseAdUnit.getSessionManager()) != null) {
                sessionManager.a("start", 0);
            }
            super.setVisibility(i10);
            return;
        }
        try {
            b0.a(PointCategory.SPLASHADBLOCK, WindAdError.ERROR_SPLASH_ADBLOCK.getErrorCode(), Preconditions.NoThrow.getLineInfo(), this.f20339d);
            SigmobLog.e("debug " + Preconditions.NoThrow.getLineInfo());
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
        }
    }

    public final void d() {
        this.f20353r = new c0(getContext());
        int dipsToIntPixels = Dips.dipsToIntPixels(100.0f, getContext());
        int dipsToIntPixels2 = Dips.dipsToIntPixels(145.0f, getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, dipsToIntPixels2);
        if (this.f20339d.getClickType() == 1) {
            this.f20353r.setOnTouchListener(this.f20345j);
        }
        y.f fVar = new y.f(getContext(), new j());
        this.f20351p = fVar;
        fVar.a(this.f20339d.getSensitivity());
        this.f20351p.c();
        addView(this.f20353r, layoutParams);
    }

    public final void e() {
        View i0Var = new i0(getContext());
        int dipsToIntPixels = Dips.dipsToIntPixels(100.0f, getContext());
        if (this.f20339d.getClickType() == 1) {
            i0Var.setOnTouchListener(this.f20345j);
        }
        int sensitivity = this.f20339d.getSensitivity();
        this.f20344i.setOnTouchListener(new a(Dips.dipsToIntPixels(sensitivity == 10 ? 0 : (sensitivity <= 0 || sensitivity >= 10) ? 50 : (11 - sensitivity) * 10, com.sigmob.sdk.a.d())));
        int dipsToIntPixels2 = Dips.dipsToIntPixels(145.0f, getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, dipsToIntPixels2);
        addView(i0Var, layoutParams);
    }

    public final void f() {
        int dipsToIntPixels = Dips.dipsToIntPixels(10.0f, getContext());
        int dipsToIntPixels2 = Dips.dipsToIntPixels(68.0f, getContext());
        int dipsToIntPixels3 = Dips.dipsToIntPixels(25.0f, getContext());
        e0 e0Var = new e0(getContext());
        this.f20350o = e0Var;
        e0Var.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels2, dipsToIntPixels3);
        layoutParams.addRule(11);
        this.f20350o.setOnClickListener(new ViewOnClickListenerC0621i());
        layoutParams.setMargins(0, dipsToIntPixels * 2, dipsToIntPixels, 0);
        addView(this.f20350o, layoutParams);
    }

    public final void g() {
        g0 g0Var = new g0(getContext());
        String title = this.f20339d.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = "点击查看详情";
        }
        g0Var.a(title, this.f20339d.getDesc());
        int dipsToIntPixels = Dips.dipsToIntPixels(100.0f, getContext());
        int dipsToIntPixels2 = Dips.dipsToIntPixels(40.0f, getContext());
        g0Var.setOnTouchListener(this.f20345j);
        int dipsToIntPixels3 = Dips.dipsToIntPixels(100.0f, getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, dipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(dipsToIntPixels2, 0, dipsToIntPixels2, dipsToIntPixels3);
        addView(g0Var, layoutParams);
    }

    public final void b() {
        x xVar = new x(getContext());
        int dipsToIntPixels = Dips.dipsToIntPixels(20.0f, getContext());
        boolean z10 = this.f20339d.getadPrivacy() != null;
        if (z10) {
            xVar.setOnTouchListener(new b());
        }
        xVar.a(this.f20339d.getAd_source_logo(), z10);
        xVar.setAlpha(0.5f);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(5.0f, getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, dipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(dipsToIntPixels2, 0, dipsToIntPixels2, dipsToIntPixels2);
        addView(xVar, layoutParams);
    }

    public final void c() {
        a0 a0Var = new a0(getContext());
        a0Var.setButtonColor(this.f20339d.getButtonColor());
        a0Var.a(this.f20339d.getDesc(), null);
        int dipsToIntPixels = Dips.dipsToIntPixels(100.0f, getContext());
        a0Var.setOnTouchListener(this.f20345j);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(100.0f, getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, dipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, dipsToIntPixels2);
        addView(a0Var, layoutParams);
    }

    public final void a() {
        View iVar = new com.sigmob.sdk.base.views.i(getContext());
        int dipsToIntPixels = Dips.dipsToIntPixels(183.0f, getContext());
        int dipsToIntPixels2 = Dips.dipsToIntPixels(40.0f, getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, dipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        addView(iVar, layoutParams);
        iVar.setOnTouchListener(this.f20345j);
        String title = this.f20339d.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = "点击前往";
        }
        o0 o0Var = new o0(getContext());
        o0Var.setTitle(title);
        o0Var.setDescription(this.f20339d.getDesc());
        o0Var.setOnTouchListener(this.f20345j);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(12);
        layoutParams2.setMargins(0, 0, 0, dipsToIntPixels2);
        addView(o0Var, layoutParams2);
    }

    public final void a(String str, String str2) {
        o0 o0Var = new o0(getContext());
        o0Var.setTitle(str);
        o0Var.setDescription(str2);
        int dipsToIntPixels = Dips.dipsToIntPixels(82.0f, getContext());
        if (this.f20339d.getClickType() == 1) {
            o0Var.setOnTouchListener(this.f20345j);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, dipsToIntPixels);
        addView(o0Var, layoutParams);
    }

    public void a(boolean z10) {
        if (z10) {
            BaseBroadcastReceiver.a(this.f20338c, this.f20339d.getUuid(), IntentActions.ACTION_INTERSTITIAL_DISMISS);
            this.f20350o.setOnClickListener(null);
            com.sigmob.sdk.base.common.h.d(this.f20339d);
            this.f20339d.destroy();
            this.f20339d = null;
        }
        y.b bVar = this.f20351p;
        if (bVar != null) {
            bVar.a();
            this.f20351p = null;
        }
        v vVar = this.f20353r;
        if (vVar != null) {
            vVar.b();
        }
        this.f20337b.setOnTouchListener(null);
    }

    public final void a(String str) {
        SigmobLog.d("handleClick: ");
        if (this.f20339d == null) {
            SigmobLog.e("adUnit is null");
            return;
        }
        this.f20347l = true;
        if (com.sigmob.sdk.a.h() == null) {
            com.sigmob.sdk.a.a(com.sigmob.sdk.base.utils.e.b(this));
        }
        a(this.f20339d, str);
    }

    public final void a(BaseAdUnit baseAdUnit, String str) {
        SigmobLog.d("handleUrlAction: ");
        if (baseAdUnit == null) {
            SigmobLog.e("adUnit is null");
        } else {
            new k0.e().a(j0.f17906b, j0.f17911g, j0.f17910f, j0.f17912h, j0.f17909e, j0.f17908d, j0.f17907c).b(new h(baseAdUnit)).b(baseAdUnit.isSkipSigmobBrowser()).a(baseAdUnit).a(baseAdUnit.getAd().forbiden_parse_landingpage.booleanValue()).a().b(com.sigmob.sdk.a.d(), null);
        }
    }

    public final void a(Context context) {
        this.f20337b = com.sigmob.sdk.splash.d.a(context, this.f20339d);
        this.f20336a.addView(this.f20337b, new RelativeLayout.LayoutParams(-1, -1));
        this.f20344i = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int dipsToIntPixels = Dips.dipsToIntPixels(f20334t, this.f20338c);
        layoutParams.setMargins(dipsToIntPixels, (int) (dipsToIntPixels * 2.5d), dipsToIntPixels, dipsToIntPixels);
        this.f20344i.setClickable(true);
        this.f20344i.setOnTouchListener(new f());
        this.f20336a.addView(this.f20344i, layoutParams);
        this.f20345j = new g();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0117 A[Catch: all -> 0x0037, TryCatch #0 {all -> 0x0037, blocks: (B:3:0x0001, B:6:0x0031, B:9:0x003a, B:10:0x0113, B:12:0x0117, B:13:0x011a, B:15:0x0057, B:16:0x0074, B:17:0x0091, B:20:0x00a3, B:21:0x00bf, B:22:0x0110, B:23:0x00c4, B:26:0x00d7, B:29:0x00ea, B:32:0x00fd), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(com.sigmob.sdk.base.models.BaseAdUnit r6) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.splash.i.a(com.sigmob.sdk.base.models.BaseAdUnit):boolean");
    }
}
