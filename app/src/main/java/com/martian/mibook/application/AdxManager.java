package com.martian.mibook.application;

import android.content.Context;
import androidx.annotation.NonNull;
import com.martian.ads.ad.AdConfig;
import com.martian.libugrowth.adx.request.FinishAdsParams;
import com.martian.libugrowth.adx.request.GetAdsParams;
import com.martian.libugrowth.adx.response.LmAd;
import com.martian.libugrowth.adx.response.LmAds;
import com.martian.libugrowth.adx.response.LmEnv;
import com.martian.libugrowth.adx.response.LmUdef;
import com.martian.libugrowth.adx.response.ReportEvent;
import com.martian.libugrowth.adx.response.ReportEventInfo;
import com.martian.mibook.activity.AdxActivity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes.dex */
public class AdxManager {

    /* renamed from: a */
    private static final String f11234a = "pref_next_request_time";

    /* renamed from: b */
    private final Context f11235b;

    /* renamed from: c */
    private OkHttpClient f11236c;

    /* renamed from: d */
    private ThreadPoolExecutor f11237d;

    /* renamed from: e */
    private String f11238e;

    /* renamed from: g */
    private c f11240g;

    /* renamed from: i */
    private boolean f11242i;
    private long k;

    /* renamed from: h */
    private boolean f11241h = true;

    /* renamed from: f */
    private long f11239f = com.martian.libmars.d.h.F().a0(f11234a);

    /* renamed from: j */
    private final d f11243j = new d();

    /* loaded from: classes3.dex */
    class a extends com.martian.libmars.c.e<GetAdsParams, LmAds> {
        a(Class x0, Class x1, Context x2) {
            super(x0, x1, x2);
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(List<LmAds> lmAdsList) {
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    /* loaded from: classes3.dex */
    class b extends com.martian.libmars.c.e<FinishAdsParams, Boolean> {

        /* renamed from: f */
        final /* synthetic */ boolean f11245f;

        /* renamed from: g */
        final /* synthetic */ String f11246g;

        /* renamed from: h */
        final /* synthetic */ String f11247h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Class x0, Class x1, Context x2, final boolean val$adIds, final String val$planId, final String val$retry) {
            super(x0, x1, x2);
            this.f11245f = val$adIds;
            this.f11246g = val$planId;
            this.f11247h = val$retry;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            if (errorResult != null && errorResult.c() == 10000) {
                com.martian.mibook.lib.model.g.b.s(AdxManager.this.f11235b, "上报-失败-ip漂移");
                AdxManager.this.f11242i = true;
            } else if (this.f11245f) {
                AdxManager.this.l(this.f11246g, this.f11247h, false);
            } else {
                com.martian.mibook.lib.model.g.b.s(AdxManager.this.f11235b, "上报-失败");
            }
        }

        @Override // b.d.c.c.i, b.d.c.c.c
        public void onUDDataReceived(List<Boolean> lmAdsList) {
            Context context = AdxManager.this.f11235b;
            StringBuilder sb = new StringBuilder();
            sb.append("上报-成功");
            sb.append(this.f11245f ? "-重试" : "");
            com.martian.mibook.lib.model.g.b.s(context, sb.toString());
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    /* loaded from: classes3.dex */
    public class c extends Thread {
        public c() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                long k = AdxManager.this.k();
                if (k < 0) {
                    com.martian.mibook.lib.model.g.b.s(AdxManager.this.f11235b, "请求-成功-今日用尽");
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(5, 1);
                    calendar.set(11, 0);
                    calendar.set(12, 0);
                    calendar.set(13, 0);
                    calendar.set(14, 0);
                    AdxManager.this.w((calendar.getTimeInMillis() - System.currentTimeMillis()) / 1000);
                    AdxManager.this.f11240g = null;
                    return;
                }
                if (k >= 1800) {
                    try {
                        AdxManager.this.f11237d = null;
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                AdxManager.this.w(k);
                Thread.sleep(k * 1000);
                if (AdxManager.this.f11241h) {
                    synchronized (AdxManager.this.f11243j) {
                        try {
                            AdxManager.this.f11243j.wait();
                        } catch (InterruptedException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class d {

        /* renamed from: a */
        private String f11250a;

        public d() {
            b(null);
        }

        public String a() {
            return this.f11250a;
        }

        public void b(String flag) {
            this.f11250a = flag;
        }
    }

    public AdxManager(Context context) {
        this.f11235b = context;
    }

    private boolean j() {
        return MiConfigSingleton.V3().C2() && this.f11239f < System.currentTimeMillis();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public long k() {
        com.martian.mibook.lib.model.g.b.s(this.f11235b, AdConfig.ActionString.REQUEST);
        this.f11238e = com.martian.libmars.d.h.F().G();
        a aVar = new a(GetAdsParams.class, LmAds.class, this.f11235b);
        ((GetAdsParams) aVar.k()).setOaid(com.martian.libmars.d.h.F().V());
        ((GetAdsParams) aVar.k()).setImei(com.martian.libmars.d.h.F().z());
        ((GetAdsParams) aVar.k()).setUseCache(Boolean.valueOf(com.martian.libmars.d.h.F().J0()));
        try {
            b.d.c.b.m mVar = (b.d.c.b.m) aVar.i();
            if (mVar.k()) {
                com.martian.mibook.lib.model.g.b.s(this.f11235b, "请求-失败");
                return mVar.e();
            }
            LmAds lmAds = (LmAds) mVar.i();
            if (lmAds == null) {
                return 1800L;
            }
            y(lmAds);
            return lmAds.getInternal().intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1L;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void l(String planId, String adIds, boolean retry) {
        b bVar = new b(FinishAdsParams.class, Boolean.class, this.f11235b, retry, planId, adIds);
        if (!com.martian.libsupport.k.p(planId)) {
            ((FinishAdsParams) bVar.k()).setPlanId(planId);
        }
        if (!com.martian.libsupport.k.p(adIds)) {
            ((FinishAdsParams) bVar.k()).setAdIds(adIds);
        }
        bVar.i();
    }

    private long m(long baseLineTime, LmAds lmAds, LmAd ad2) {
        if (lmAds == null || lmAds.getClickRate().doubleValue() <= 0.0d || ad2 == null || ad2.getEvent() == null || ad2.getEvent().getClk() == null || ad2.getEvent().getClk().isEmpty()) {
            return -1L;
        }
        if (new Random().nextInt(10000) > ((int) (lmAds.getClickRate().doubleValue() * 100.0d))) {
            return -1L;
        }
        return baseLineTime + ((new Random().nextInt(Math.max(1, ad2.getDuration() - 2)) + 2) * 1000);
    }

    private LmEnv n(LmAds lmAds, LmAd ad2) {
        if (ad2 != null && ad2.getExt() != null) {
            return ad2.getExt();
        }
        if (lmAds != null) {
            return lmAds.getEnv();
        }
        return null;
    }

    private boolean o(LmAds lmAds) {
        return (lmAds == null || !lmAds.getIpControl() || com.martian.libsupport.k.p(this.f11238e) || this.f11238e.equalsIgnoreCase(com.martian.libmars.d.h.F().G())) ? false : true;
    }

    static /* synthetic */ Thread p(Runnable r) {
        return new Thread(r, "schema_task_pool_" + r.hashCode());
    }

    /* renamed from: q */
    public /* synthetic */ Boolean r(final String url, final LmAds lmAds, final LmAd ad2) throws Exception {
        return Boolean.valueOf(v(url, lmAds, ad2));
    }

    static /* synthetic */ int s(ReportEventInfo lefInfo, ReportEventInfo rightInfo) {
        return (lefInfo.getReportTime() > rightInfo.getReportTime() ? 1 : (lefInfo.getReportTime() == rightInfo.getReportTime() ? 0 : -1));
    }

    private boolean t(ReportEventInfo reportEventInfo, LmAds lmAds) {
        Float f2;
        if (lmAds == null || lmAds.getExposeRate() == null) {
            return false;
        }
        List<Float> exposeRate = lmAds.getExposeRate();
        if (ReportEvent.FIRST.equals(reportEventInfo.getReportEvent()) && exposeRate.size() > 0) {
            f2 = exposeRate.get(0);
        } else if (ReportEvent.MID.equals(reportEventInfo.getReportEvent()) && exposeRate.size() > 1) {
            f2 = exposeRate.get(1);
        } else if (ReportEvent.THIRD.equals(reportEventInfo.getReportEvent()) && exposeRate.size() > 2) {
            f2 = exposeRate.get(2);
        } else {
            if (!ReportEvent.COM.equals(reportEventInfo.getReportEvent()) || exposeRate.size() <= 3) {
                return false;
            }
            f2 = exposeRate.get(3);
        }
        if (f2 == null || f2.floatValue() <= 0.0f) {
            return false;
        }
        return new Random().nextInt(10000) > ((int) (f2.floatValue() * 100.0f));
    }

    private boolean u(@NonNull ReportEventInfo reportEventInfo, final LmAds lmAds, final LmAd ad2, boolean firstAd) {
        if (reportEventInfo.getReportTime() + lmAds.getReportTimeout() < System.currentTimeMillis()) {
            com.martian.mibook.lib.model.g.b.s(this.f11235b, "上报-超时");
            return false;
        }
        if (reportEventInfo.getReportEvent().equals(ReportEvent.FINISH)) {
            l(lmAds.getPlanId(), ad2 == null ? "" : String.valueOf(ad2.getMid()), true);
            return true;
        }
        if (o(lmAds)) {
            return false;
        }
        if (firstAd && t(reportEventInfo, lmAds)) {
            return false;
        }
        if (reportEventInfo.getReportEvent().equals(ReportEvent.CLK) && ad2 != null && !com.martian.libsupport.k.p(ad2.getPage())) {
            AdxActivity.b(this.f11235b, ad2.getPage(), n(lmAds, ad2), lmAds.getPageRate());
        }
        if (this.f11237d == null) {
            this.f11237d = new ThreadPoolExecutor(5, 20, 300L, TimeUnit.SECONDS, new ArrayBlockingQueue(20), new ThreadFactory() { // from class: com.martian.mibook.application.k
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    return AdxManager.p(runnable);
                }
            });
        }
        ArrayList arrayList = new ArrayList();
        for (final String str : reportEventInfo.getUrls()) {
            arrayList.add(this.f11237d.submit(new Callable() { // from class: com.martian.mibook.application.l
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return AdxManager.this.r(str, lmAds, ad2);
                }
            }));
        }
        Iterator it = arrayList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            try {
                Boolean bool = (Boolean) ((Future) it.next()).get();
                if (bool != null && bool.booleanValue()) {
                    i2++;
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            } catch (ExecutionException e3) {
                e3.printStackTrace();
            }
        }
        boolean z = i2 >= ((int) (((float) reportEventInfo.getUrls().size()) * 0.6f)) + 1;
        if (!z) {
            com.martian.mibook.lib.model.g.b.s(this.f11235b, "上报-失败-" + reportEventInfo.getReportEvent());
        }
        return z;
    }

    private boolean v(String url, LmAds lmAds, LmAd ad2) {
        Request.Builder url2 = new Request.Builder().url(url);
        LmEnv n = n(lmAds, ad2);
        if (n != null) {
            if (!com.martian.libsupport.k.p(n.getUa())) {
                url2.removeHeader("User-Agent");
                url2.addHeader("User-Agent", n.getUa());
            }
            if (n.getHeader() != null) {
                for (String str : n.getHeader().keySet()) {
                    url2.addHeader(str, n.getHeader().get(str));
                }
            }
        }
        try {
            Response execute = this.f11236c.newCall(url2.build()).execute();
            boolean isSuccessful = execute.isSuccessful();
            execute.close();
            return isSuccessful;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void w(long delay) {
        this.f11239f = System.currentTimeMillis() + (delay * 1000);
        com.martian.libmars.d.h.F().x1(f11234a, this.f11239f);
    }

    private void x(LmAds lmAds, LmAd ad2, boolean firstAd) {
        int i2;
        int i3;
        long j2;
        int i4;
        com.martian.mibook.lib.model.g.b.s(this.f11235b, "上报");
        ArrayList<ReportEventInfo> arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        if (ad2.getEvent().getImp() != null && !ad2.getEvent().getImp().isEmpty()) {
            arrayList.add(new ReportEventInfo().setReportTime(currentTimeMillis).setUrls(ad2.getEvent().getImp()).setReportEvent(ReportEvent.IMP));
        }
        if (ad2.getDuration() > 0) {
            int validEvents = ad2.getEvent().getValidEvents() - 1;
            if (validEvents > 0) {
                i2 = ad2.getDuration() / validEvents;
                i3 = ad2.getDuration() % validEvents;
            } else {
                i2 = 3;
                i3 = 0;
            }
            List<String> first = ad2.getEvent().getFirst();
            if (first == null || first.isEmpty()) {
                j2 = currentTimeMillis;
            } else {
                j2 = (i2 * 1000) + currentTimeMillis;
                arrayList.add(new ReportEventInfo().setReportTime(j2).setUrls(first).setReportEvent(ReportEvent.FIRST));
            }
            List<String> mid = ad2.getEvent().getMid();
            if (mid == null || mid.isEmpty()) {
                i4 = i2;
            } else {
                i4 = i2;
                j2 += (((i3 <= 0 || i3 <= validEvents + (-2)) ? 0 : 1) + i2) * 1000;
                arrayList.add(new ReportEventInfo().setReportTime(j2).setUrls(mid).setReportEvent(ReportEvent.MID));
            }
            List<String> third = ad2.getEvent().getThird();
            if (third != null && !third.isEmpty()) {
                j2 += (i4 + ((i3 <= 0 || i3 <= validEvents + (-3)) ? 0 : 1)) * 1000;
                arrayList.add(new ReportEventInfo().setReportTime(j2).setUrls(third).setReportEvent(ReportEvent.THIRD));
            }
            List<String> com2 = ad2.getEvent().getCom();
            if (com2 != null && !com2.isEmpty()) {
                arrayList.add(new ReportEventInfo().setReportTime(j2 + ((i4 + ((i3 <= 0 || i3 <= validEvents + (-4)) ? 0 : 1)) * 1000)).setUrls(com2).setReportEvent(ReportEvent.COM));
            }
        }
        if (ad2.getEvent().getUdef() != null && !ad2.getEvent().getUdef().isEmpty()) {
            for (LmUdef lmUdef : ad2.getEvent().getUdef()) {
                if (lmUdef == null || lmUdef.getT() < 0 || lmUdef.getUrl() == null || lmUdef.getUrl().isEmpty()) {
                    return;
                } else {
                    arrayList.add(new ReportEventInfo().setReportTime((lmUdef.getT() * 1000) + currentTimeMillis).setUrls(lmUdef.getUrl()).setReportEvent(ReportEvent.UDEF));
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        long m = m(currentTimeMillis, lmAds, ad2);
        if (m > 0) {
            com.martian.mibook.lib.model.g.b.s(this.f11235b, "上报-点击");
            int minPageDuration = com.martian.libsupport.k.p(ad2.getPage()) ? 0 : lmAds.getMinPageDuration() + new Random().nextInt(Math.max(1, lmAds.getMaxPageDuration() - lmAds.getMinPageDuration()));
            if (minPageDuration > 0) {
                com.martian.mibook.lib.model.g.b.s(this.f11235b, "上报-落地页");
                for (ReportEventInfo reportEventInfo : arrayList) {
                    if (reportEventInfo.getReportTime() >= m) {
                        reportEventInfo.setReportTime(reportEventInfo.getReportTime() + (minPageDuration * 1000));
                    }
                }
            }
            arrayList.add(new ReportEventInfo().setReportTime(m).setUrls(ad2.getEvent().getClk()).setReportEvent(ReportEvent.CLK));
        }
        Collections.sort(arrayList, new Comparator() { // from class: com.martian.mibook.application.j
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AdxManager.s((ReportEventInfo) obj, (ReportEventInfo) obj2);
            }
        });
        long reportTime = ((ReportEventInfo) arrayList.get(arrayList.size() - 1)).getReportTime();
        arrayList.add(new ReportEventInfo().setReportTime(reportTime).setReportEvent(ReportEvent.FINISH));
        for (ReportEventInfo reportEventInfo2 : arrayList) {
            long reportTime2 = reportEventInfo2.getReportTime() - System.currentTimeMillis();
            if (reportTime2 > 0) {
                try {
                    Thread.sleep(reportTime2);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            if (!u(reportEventInfo2, lmAds, ad2, firstAd)) {
                this.k = Math.max(10000L, reportTime - System.currentTimeMillis());
                return;
            }
        }
    }

    private void y(LmAds lmAds) {
        if (lmAds.getAds() == null || lmAds.getAds().isEmpty()) {
            return;
        }
        this.f11242i = false;
        try {
            com.martian.mibook.lib.model.g.b.s(this.f11235b, "请求-成功");
            if (this.f11236c == null) {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                this.f11236c = builder.connectTimeout(5L, timeUnit).readTimeout(5L, timeUnit).build();
            }
            int i2 = 0;
            for (LmAd lmAd : lmAds.getAds()) {
                if (this.f11242i) {
                    return;
                }
                x(lmAds, lmAd, i2 == 0);
                i2++;
                if (lmAd.getDelay().intValue() > 0 || this.k > 0) {
                    try {
                        Thread.sleep((lmAd.getDelay().intValue() * 1000) + this.k);
                        this.k = 0L;
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void A() {
        this.f11241h = true;
    }

    public void z() {
        if (j()) {
            try {
                if (this.f11241h && this.f11240g != null) {
                    this.f11241h = false;
                    synchronized (this.f11243j) {
                        this.f11243j.notify();
                    }
                    return;
                }
                if (this.f11240g == null) {
                    this.f11241h = false;
                    c cVar = new c();
                    this.f11240g = cVar;
                    cVar.start();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
