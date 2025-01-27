package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.CPUNovelAd;
import com.baidu.mobads.sdk.api.CPUWebAdRequestParam;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class cx extends bi {
    public static final String A = "pre_chapter_adstart_countdown";
    public static final String B = "try_get_cuid";
    private static final String J = "cx";

    /* renamed from: a */
    public static final String f7127a = "enter_refresh_bookstore";

    /* renamed from: t */
    public static final String f7128t = "enter_reader";

    /* renamed from: u */
    public static final String f7129u = "notify_impression";

    /* renamed from: v */
    public static final String f7130v = "request_int_ad_view";

    /* renamed from: w */
    public static final String f7131w = "request_banner_ad_view";

    /* renamed from: x */
    public static final String f7132x = "request_bookstore_bottom_view";

    /* renamed from: y */
    public static final String f7133y = "request_shelf_ad_view";

    /* renamed from: z */
    public static final String f7134z = "reader_background_status_change";
    public HashMap<String, Object> C;
    public String D;
    public int E;
    public int F;
    public int G;
    public int H;
    public String I;
    private CPUNovelAd.CpuNovelListener K;
    private SoftReference<RelativeLayout> L;

    public cx(Context context, String str, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        this.E = 5;
        this.F = 60;
        this.G = 0;
        this.H = 10006;
        this.I = "";
        this.D = str;
        this.C = (HashMap) cPUWebAdRequestParam.getParameters();
    }

    public void z() {
        an.b();
    }

    public void e() {
        an.a(this.E);
        an.b(this.F);
        an.a(new da(this));
    }

    public Activity f() {
        return an.c();
    }

    public boolean g() {
        return an.d();
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void h(IOAdEvent iOAdEvent) {
        CPUNovelAd.CpuNovelListener cpuNovelListener = this.K;
        if (cpuNovelListener != null) {
            cpuNovelListener.onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public View w() {
        View a10 = an.a(this.f6880i);
        if (a10 instanceof FrameLayout) {
            RelativeLayout relativeLayout = new RelativeLayout(this.f6880i);
            this.L = new SoftReference<>(relativeLayout);
            relativeLayout.setId(33);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ba.a(this.f6880i, 53.0f));
            layoutParams.gravity = 80;
            ((FrameLayout) a10).addView(relativeLayout, layoutParams);
            if (bm.a((Context) null).a() >= 18) {
                relativeLayout.getViewTreeObserver().addOnWindowFocusChangeListener(new db(this, relativeLayout));
            }
        }
        return a10;
    }

    public boolean x() {
        return an.e();
    }

    public void y() {
        an.g();
    }

    public void c(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("adInnerPageInterval");
            Object obj2 = map.get("adBottomRefreshInterval");
            Object obj3 = map.get("adFrontChapterInterval");
            Object obj4 = map.get("isShowFeeds");
            Object obj5 = map.get("isAdSwitch");
            Object obj6 = map.get("showCount");
            Object obj7 = map.get("clickCount");
            Object obj8 = map.get("motivateDeeplinkAdSwitch");
            Object obj9 = map.get("motivateDeeplinkAdFrequency");
            Object obj10 = map.get("motivateDeeplinkAdExpTime");
            Object obj11 = map.get("motivateDeeplinkNoAdTime");
            Object obj12 = map.get("isStartRewardAdTimer");
            Object obj13 = map.get("temporaryAdDensitySwitch");
            Object obj14 = map.get("temporaryAdDensityTimes");
            Object obj15 = map.get("temporaryAdDensityScreen");
            if (obj != null && obj2 != null) {
                an.a(((Integer) obj).intValue());
                an.b(((Integer) obj2).intValue());
            }
            if ((obj3 instanceof Integer) && (obj4 instanceof Boolean)) {
                an.a(((Integer) obj3).intValue(), ((Boolean) obj4).booleanValue());
            }
            if (obj5 instanceof Integer) {
                an.a(((Integer) obj5).intValue() != 0);
            }
            if ((obj6 instanceof Integer) && (obj7 instanceof Integer)) {
                an.a(((Integer) obj6).intValue(), ((Integer) obj7).intValue());
            }
            if ((obj8 instanceof Boolean) && (obj9 instanceof Integer) && (obj10 instanceof Integer) && (obj11 instanceof Integer)) {
                an.a(((Boolean) obj8).booleanValue(), ((Integer) obj9).intValue(), ((Integer) obj10).intValue(), ((Integer) obj11).intValue());
            }
            if ((obj12 instanceof Boolean) && ((Boolean) obj12).booleanValue()) {
                an.h();
            }
            if ((obj13 instanceof Boolean) && ((Boolean) obj13).booleanValue() && (obj14 instanceof Integer) && (obj15 instanceof Integer)) {
                an.b(((Integer) obj14).intValue(), ((Integer) obj15).intValue());
            } else {
                an.b(0, 0);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a() {
        e();
        if (this.f6884m == null) {
            this.f6885n = false;
            return;
        }
        this.f6885n = true;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, "novel");
            this.f6884m.createProdHandler(jSONObject);
            m();
            this.f6884m.addEventListener("Update_fbReader_Setting", new cy(this));
            this.f6884m.addEventListener("closeInterstitialAd", new cz(this));
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(this.D)) {
                jSONObject2.put("appid", this.D);
            }
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, "novel");
            this.f6884m.loadAd(jSONObject2, m.a(this.C));
        } catch (Throwable th2) {
            this.f6882k.c(J, th2);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void e(IOAdEvent iOAdEvent) {
        CPUNovelAd.CpuNovelListener cpuNovelListener = this.K;
        if (cpuNovelListener != null) {
            cpuNovelListener.onAdImpression();
        }
    }

    public void a(CPUNovelAd.CpuNovelListener cpuNovelListener) {
        this.K = cpuNovelListener;
    }
}
