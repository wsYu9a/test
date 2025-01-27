package com.wbl.ad.yzz.adit;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.bean.AdPageNeedData;
import com.wbl.ad.yzz.config.AdInitConfig;
import com.wbl.ad.yzz.config.CheckNextChapterCallback;
import com.wbl.ad.yzz.config.IAdEventListener;
import com.wbl.ad.yzz.config.IConfigAdFilter;
import com.wbl.ad.yzz.config.IPersonalAdSettingListener;
import com.wbl.ad.yzz.config.OnAdClickListener;
import com.wbl.ad.yzz.config.PageOptions;
import com.wbl.ad.yzz.network.b.b.u;
import com.wbl.ad.yzz.network.b.b.v;
import com.wbl.ad.yzz.network.bean.request.GetPageMsgReq;
import com.wbl.ad.yzz.network.c.a;
import com.wbl.ad.yzz.network.c.d;
import java.util.List;

/* loaded from: classes5.dex */
public final class g implements com.wbl.ad.yzz.adit.f {
    public static String k = "-1002";
    public static String l = "-1008";
    public static boolean m = false;

    /* renamed from: a */
    public final com.wbl.ad.yzz.adit.a f31488a;

    /* renamed from: b */
    public final com.wbl.ad.yzz.innerconfig.d.g f31489b;

    /* renamed from: c */
    public CountDownTimer f31490c;

    /* renamed from: d */
    public AdInitConfig f31491d;

    /* renamed from: e */
    public int f31492e;

    /* renamed from: f */
    public final Object f31493f;

    /* renamed from: g */
    public int f31494g;

    /* renamed from: h */
    public Handler f31495h;

    /* renamed from: i */
    public boolean f31496i;

    /* renamed from: j */
    public String f31497j;

    public class a implements d.b0<com.wbl.ad.yzz.network.b.b.a> {

        /* renamed from: a */
        public final /* synthetic */ Application f31498a;

        /* renamed from: b */
        public final /* synthetic */ boolean f31499b;

        public a(Application application, boolean z) {
            this.f31498a = application;
            this.f31499b = z;
        }

        public void a(String str, com.wbl.ad.yzz.network.b.b.a aVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15575, this, str, aVar);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public void onFailed(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15570, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public /* bridge */ /* synthetic */ void onSuccess(String str, com.wbl.ad.yzz.network.b.b.a aVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15569, this, str, aVar);
        }
    }

    public class b implements Runnable {
        public b(g gVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15572, this, null);
        }
    }

    public class c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Application f31501a;

        public c(Application application) {
            this.f31501a = application;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15571, this, null);
        }
    }

    public class d implements d.b0<u> {

        /* renamed from: a */
        public final /* synthetic */ CheckNextChapterCallback f31503a;

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d f31504b;

        /* renamed from: c */
        public final /* synthetic */ PageOptions f31505c;

        /* renamed from: d */
        public final /* synthetic */ Activity f31506d;

        public d(CheckNextChapterCallback checkNextChapterCallback, com.wbl.ad.yzz.innerconfig.d.d dVar, PageOptions pageOptions, Activity activity) {
            this.f31503a = checkNextChapterCallback;
            this.f31504b = dVar;
            this.f31505c = pageOptions;
            this.f31506d = activity;
        }

        public void a(String str, u uVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15662, this, str, uVar);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public void onFailed(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15661, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public /* bridge */ /* synthetic */ void onSuccess(String str, u uVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15664, this, str, uVar);
        }
    }

    public class e implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Activity f31508a;

        /* renamed from: b */
        public final /* synthetic */ PageOptions f31509b;

        public e(Activity activity, PageOptions pageOptions) {
            this.f31508a = activity;
            this.f31509b = pageOptions;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15663, this, null);
        }
    }

    public class f implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Activity f31511a;

        /* renamed from: b */
        public final /* synthetic */ PageOptions f31512b;

        public f(Activity activity, PageOptions pageOptions) {
            this.f31511a = activity;
            this.f31512b = pageOptions;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15658, this, null);
        }
    }

    /* renamed from: com.wbl.ad.yzz.adit.g$g */
    public class CountDownTimerC0687g extends CountDownTimer {
        public CountDownTimerC0687g(long j2, long j3) {
            super(j2, j3);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15657, this, null);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15660, this, Long.valueOf(j2));
        }
    }

    public class h implements d.b0<u> {

        /* renamed from: a */
        public final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d f31515a;

        /* renamed from: b */
        public final /* synthetic */ Activity f31516b;

        /* renamed from: c */
        public final /* synthetic */ boolean f31517c;

        /* renamed from: d */
        public final /* synthetic */ PageOptions f31518d;

        /* renamed from: e */
        public final /* synthetic */ GetPageMsgReq f31519e;

        /* renamed from: f */
        public final /* synthetic */ AdPageNeedData f31520f;

        public class a implements d.b0<v> {

            /* renamed from: a */
            public final /* synthetic */ u f31522a;

            public a(u uVar) {
                this.f31522a = uVar;
            }

            public void a(String str, v vVar) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15659, this, str, vVar);
            }

            @Override // com.wbl.ad.yzz.network.c.d.b0
            public void onFailed(String str, String str2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15654, this, str, str2);
            }

            @Override // com.wbl.ad.yzz.network.c.d.b0
            public /* bridge */ /* synthetic */ void onSuccess(String str, v vVar) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15653, this, str, vVar);
            }
        }

        public h(com.wbl.ad.yzz.innerconfig.d.d dVar, Activity activity, boolean z, PageOptions pageOptions, GetPageMsgReq getPageMsgReq, AdPageNeedData adPageNeedData) {
            this.f31515a = dVar;
            this.f31516b = activity;
            this.f31517c = z;
            this.f31518d = pageOptions;
            this.f31519e = getPageMsgReq;
            this.f31520f = adPageNeedData;
        }

        public final void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15655, this, null);
        }

        public void a(String str, u uVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15650, this, str, uVar);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public void onFailed(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15649, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public /* bridge */ /* synthetic */ void onSuccess(String str, u uVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15652, this, str, uVar);
        }
    }

    public class i implements a.InterfaceC0770a {

        /* renamed from: a */
        public final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.e f31524a;

        /* renamed from: b */
        public final /* synthetic */ long f31525b;

        public i(com.wbl.ad.yzz.innerconfig.d.e eVar, long j2) {
            this.f31524a = eVar;
            this.f31525b = j2;
        }

        @Override // com.wbl.ad.yzz.network.c.a.InterfaceC0770a
        public void loadAdError(int i2, String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15651, this, Integer.valueOf(i2), str);
        }

        @Override // com.wbl.ad.yzz.network.c.a.InterfaceC0770a
        public void loadAdSuccess(List<com.wbl.ad.yzz.adapter.d.b> list) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15678, this, list);
        }
    }

    public g() {
        com.wbl.ad.yzz.adit.a aVar = new com.wbl.ad.yzz.adit.a();
        this.f31488a = aVar;
        this.f31489b = new com.wbl.ad.yzz.innerconfig.d.g();
        this.f31492e = -1;
        this.f31493f = new Object();
        this.f31494g = 0;
        Handler handler = new Handler(Looper.getMainLooper());
        this.f31495h = handler;
        this.f31496i = false;
        this.f31497j = "WBLDebugSDK";
        try {
            aVar.a(handler);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static /* synthetic */ com.wbl.ad.yzz.innerconfig.d.g d(g gVar) {
        return (com.wbl.ad.yzz.innerconfig.d.g) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15630, null, gVar);
    }

    public static /* synthetic */ String d() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15629, null, null);
    }

    public static /* synthetic */ String e() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15632, null, null);
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void a(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15631, this, Integer.valueOf(i2));
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void a(Activity activity, PageOptions pageOptions) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15626, this, activity, pageOptions);
    }

    public final void a(Activity activity, u uVar, PageOptions pageOptions, com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15625, this, activity, uVar, pageOptions, dVar);
    }

    public final void a(Activity activity, u uVar, String str, com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15628, this, activity, uVar, str, dVar);
    }

    public final void a(Activity activity, GetPageMsgReq getPageMsgReq, AdPageNeedData adPageNeedData, PageOptions pageOptions, com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15627, this, activity, getPageMsgReq, adPageNeedData, pageOptions, dVar);
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void a(Activity activity, String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15622, this, activity, str);
    }

    public final void a(Application application) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15621, this, application);
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void a(Application application, AdInitConfig adInitConfig) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15624, this, application, adInitConfig);
    }

    public final void a(Application application, com.wbl.ad.yzz.network.b.b.a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15623, this, application, aVar);
    }

    public final void a(Application application, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15618, this, application, Boolean.valueOf(z));
    }

    public final void a(Application application, boolean z, boolean z2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15617, this, application, Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void a(Context context) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15620, this, context);
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void a(IAdEventListener iAdEventListener) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15619, this, iAdEventListener);
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void a(IConfigAdFilter iConfigAdFilter) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15646, this, iConfigAdFilter);
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void a(IPersonalAdSettingListener iPersonalAdSettingListener) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15645, this, iPersonalAdSettingListener);
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void a(OnAdClickListener onAdClickListener) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15648, this, onAdClickListener);
    }

    public final void a(PageOptions pageOptions) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15647, this, pageOptions);
    }

    public final void a(com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15642, this, dVar);
    }

    public final void a(com.wbl.ad.yzz.innerconfig.d.d dVar, String str, String str2, String str3) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15641, this, dVar, str, str2, str3);
    }

    public final void a(com.wbl.ad.yzz.innerconfig.d.e eVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15644, this, eVar);
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void a(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15643, this, str);
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void a(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15638, this, Boolean.valueOf(z));
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void a(boolean z, String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15637, this, Boolean.valueOf(z), str);
    }

    @Override // com.wbl.ad.yzz.adit.f
    public boolean a() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-15640, this, null);
    }

    public final boolean a(Context context, com.wbl.ad.yzz.innerconfig.d.d dVar) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-15639, this, context, dVar);
    }

    public final boolean a(com.wbl.ad.yzz.innerconfig.d.d dVar, PageOptions pageOptions) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-15634, this, dVar, pageOptions);
    }

    public final String b(Context context) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15633, this, context);
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void b(Activity activity, PageOptions pageOptions) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15636, this, activity, pageOptions);
    }

    public final void b(PageOptions pageOptions) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15635, this, pageOptions);
    }

    public final void b(com.wbl.ad.yzz.innerconfig.d.e eVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15726, this, eVar);
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void b(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15725, this, str);
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void b(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15728, this, Boolean.valueOf(z));
    }

    @Override // com.wbl.ad.yzz.adit.f
    public boolean b() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-15727, this, null);
    }

    public final boolean b(int i2) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-15722, this, Integer.valueOf(i2));
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15721, this, null);
    }

    public final void c(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15724, this, Integer.valueOf(i2));
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void c(Activity activity, PageOptions pageOptions) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15723, this, activity, pageOptions);
    }

    public final void c(Context context) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15718, this, context);
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void c(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15717, this, str);
    }

    @Override // com.wbl.ad.yzz.adit.f
    public void c(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15720, this, Boolean.valueOf(z));
    }

    public final void d(Activity activity, PageOptions pageOptions) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15719, this, activity, pageOptions);
    }

    public final void d(Context context) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15714, this, context);
    }

    public final void e(Activity activity, PageOptions pageOptions) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15713, this, activity, pageOptions);
    }

    public final void e(Context context) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15716, this, context);
    }

    public final void f() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15715, this, null);
    }

    public final void f(Activity activity, PageOptions pageOptions) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15742, this, activity, pageOptions);
    }

    public final int g() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-15741, this, null);
    }

    public final boolean h() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-15744, this, null);
    }
}
