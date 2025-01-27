package com.kwad.components.splash.monitor;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class a {
    private static volatile a Ye;

    public static void B(long j2) {
        KSLoggerReporter.l(new SplashMonitorInfo(j2).setStatus(1).toJson());
    }

    public static void C(long j2) {
        KSLoggerReporter.m(new SplashMonitorInfo(j2).setStatus(1).toJson());
    }

    public static void T(@NonNull AdTemplate adTemplate) {
        KSLoggerReporter.l(new SplashMonitorInfo(adTemplate.posId).setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(2).setLoadDataTime(adTemplate.loadDataTime).setPreloadId(com.kwad.sdk.core.response.a.a.aS(d.cb(adTemplate))).toJson());
    }

    public static void U(@NonNull AdTemplate adTemplate) {
        KSLoggerReporter.p(new SplashMonitorInfo(adTemplate.posId).setStatus(1).setType(com.kwad.sdk.core.response.a.a.aV(d.cb(adTemplate)) ? 2 : 1).toJson());
    }

    public static void V(@NonNull AdTemplate adTemplate) {
        AdInfo cb = d.cb(adTemplate);
        KSLoggerReporter.p(new SplashMonitorInfo(adTemplate.posId).setStatus(4).setCreativeId(com.kwad.sdk.core.response.a.a.D(cb)).setType(com.kwad.sdk.core.response.a.a.aV(cb) ? 2 : 1).toJson());
    }

    public static void a(@NonNull AdInfo adInfo, int i2, String str, long j2) {
        KSLoggerReporter.n(new SplashMonitorInfo(j2).setStatus(2).setPreloadId(com.kwad.sdk.core.response.a.a.aS(adInfo)).setCreativeId(com.kwad.sdk.core.response.a.a.D(adInfo)).setFailUrl(com.kwad.sdk.core.response.a.a.aU(adInfo) ? com.kwad.sdk.core.response.a.a.E(adInfo) : com.kwad.sdk.core.response.a.a.aM(adInfo).materialUrl).setErrorCode(i2).setErrorMsg(str).setMaterialType(com.kwad.sdk.core.response.a.a.aU(adInfo) ? 1 : 2).setType(1).toJson());
    }

    public static void a(@NonNull AdInfo adInfo, long j2, int i2, long j3) {
        File aX = com.kwad.sdk.core.diskcache.a.a.vs().aX(com.kwad.sdk.core.response.a.a.aU(adInfo) ? com.kwad.sdk.core.response.a.a.E(adInfo) : com.kwad.sdk.core.response.a.a.aM(adInfo).materialUrl);
        KSLoggerReporter.n(new SplashMonitorInfo(j3).setStatus(1).setPreloadId(com.kwad.sdk.core.response.a.a.aS(adInfo)).setCostTime(j2).setCacheValidTime(adInfo.adPreloadInfo.validityPeriod * 1000).setSize((aX == null || !aX.exists()) ? 0L : aX.length()).setMaterialType(com.kwad.sdk.core.response.a.a.aU(adInfo) ? 1 : 2).setType(i2).setCreativeId(com.kwad.sdk.core.response.a.a.D(adInfo)).toJson());
    }

    public static void a(String str, boolean z, int i2, String str2, long j2) {
        KSLoggerReporter.l(new SplashMonitorInfo(j2).setStatus(4).setType(z ? 2 : 1).setErrorCode(i2).setPreloadId(str).setErrorMsg(str2).toJson());
    }

    public static void a(@NonNull List<AdTemplate> list, long j2, long j3) {
        ArrayList arrayList = new ArrayList();
        Iterator<AdTemplate> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(com.kwad.sdk.core.response.a.a.aS(d.cb(it.next())));
        }
        KSLoggerReporter.m(new SplashMonitorInfo(j3).setStatus(2).setIds(arrayList).setLoadDataTime(j2).setCount(list.size()).toJson());
    }

    public static void b(int i2, String str, long j2) {
        KSLoggerReporter.m(new SplashMonitorInfo(j2).setStatus(3).setErrorCode(i2).setErrorMsg(str).toJson());
    }

    public static void b(@NonNull AdTemplate adTemplate, int i2, long j2) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j2;
        KSLoggerReporter.l(new SplashMonitorInfo(adTemplate.posId).setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(3).setLoadDataTime(adTemplate.loadDataTime).setCheckStatus(i2).setCheckDataTime(elapsedRealtime).setLoadAndCheckDataTime(adTemplate.loadDataTime + elapsedRealtime).setPreloadId(com.kwad.sdk.core.response.a.a.aS(d.cb(adTemplate))).toJson());
    }

    public static void c(@NonNull AdTemplate adTemplate, int i2, long j2) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j2;
        KSLoggerReporter.l(new SplashMonitorInfo(adTemplate.posId).setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(5).setCheckStatus(i2).setLoadDataTime(adTemplate.loadDataTime).setCheckDataTime(elapsedRealtime).setLoadAndCheckDataTime(adTemplate.loadDataTime + elapsedRealtime).setPreloadId(com.kwad.sdk.core.response.a.a.aS(d.cb(adTemplate))).toJson());
    }

    public static void d(@NonNull AdTemplate adTemplate, int i2, String str) {
        AdInfo cb = d.cb(adTemplate);
        boolean aV = com.kwad.sdk.core.response.a.a.aV(cb);
        KSLoggerReporter.p(new SplashMonitorInfo(adTemplate.posId).setStatus(3).setCreativeId(com.kwad.sdk.core.response.a.a.D(cb)).setPreloadId(com.kwad.sdk.core.response.a.a.aS(cb)).setType(aV ? 2 : 1).setFailUrl(aV ? com.kwad.sdk.core.response.a.a.aM(cb).materialUrl : com.kwad.sdk.core.response.a.a.E(cb)).setErrorCode(i2).setErrorMsg(str).toJson());
    }

    public static void f(@NonNull AdTemplate adTemplate, long j2) {
        AdInfo cb = d.cb(adTemplate);
        KSLoggerReporter.p(new SplashMonitorInfo(adTemplate.posId).setStatus(5).setType(com.kwad.sdk.core.response.a.a.aV(cb) ? 2 : 1).setCostTime(j2).setCreativeId(com.kwad.sdk.core.response.a.a.D(cb)).setPreloadId(com.kwad.sdk.core.response.a.a.aS(cb)).toJson());
    }

    public static void g(@NonNull AdTemplate adTemplate, long j2) {
        AdInfo cb = d.cb(adTemplate);
        KSLoggerReporter.p(new SplashMonitorInfo(adTemplate.posId).setStatus(2).setType(com.kwad.sdk.core.response.a.a.aV(cb) ? 2 : 1).setCostTime(j2).setCreativeId(com.kwad.sdk.core.response.a.a.D(cb)).setPreloadId(com.kwad.sdk.core.response.a.a.aS(cb)).toJson());
    }

    public static void h(@NonNull AdResultData adResultData) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
            arrayList.add(String.valueOf(com.kwad.sdk.core.response.a.a.D(d.cb(adTemplate))));
            arrayList2.add(com.kwad.sdk.core.response.a.a.aS(d.cb(adTemplate)));
        }
        KSLoggerReporter.o(new SplashMonitorInfo(adResultData.getPosId()).setTotalCount(adResultData.getAdTemplateList().size()).setCreativeIds(arrayList).setPreloadIds(arrayList2).toJson());
    }

    public static void h(@NonNull AdTemplate adTemplate, long j2) {
        if (j2 <= 0) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - j2;
        AdInfo cb = d.cb(adTemplate);
        KSLoggerReporter.p(new SplashMonitorInfo(adTemplate.posId).setStatus(6).setCreativeId(com.kwad.sdk.core.response.a.a.D(cb)).setLoadDataTime(elapsedRealtime).setType(com.kwad.sdk.core.response.a.a.aV(cb) ? 2 : 1).toJson());
    }

    public static a rY() {
        if (Ye == null) {
            synchronized (a.class) {
                if (Ye == null) {
                    Ye = new a();
                }
            }
        }
        return Ye;
    }
}
