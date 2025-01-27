package com.kwad.components.ad.splashscreen.monitor;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class b {
    private static volatile b Ew;

    public static void a(@NonNull AdTemplate adTemplate, int i10, long j10, long j11) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j10;
        com.kwad.sdk.commercial.b.i(new SplashMonitorInfo().setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(3).setLoadDataTime(adTemplate.loadDataTime).setCheckStatus(i10).setCheckDataTime(elapsedRealtime).setBeforeLoadDataTime(j11).setLoadProcessType(d.a(com.kwad.components.ad.splashscreen.b.a.Et) ? 1L : 2L).setLoadAndCheckDataTime(adTemplate.loadDataTime + elapsedRealtime).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(e.eb(adTemplate))).setAdTemplate(adTemplate));
    }

    public static void ad(@NonNull AdTemplate adTemplate) {
        com.kwad.sdk.commercial.b.l(new SplashMonitorInfo().setStatus(1).setType(com.kwad.sdk.core.response.b.a.bd(e.eb(adTemplate)) ? 2 : 1).setLoadProcessType(d.a(com.kwad.components.ad.splashscreen.b.a.Et) ? 1L : 2L).setAdTemplate(adTemplate));
    }

    public static void ae(@NonNull AdTemplate adTemplate) {
        AdInfo eb2 = e.eb(adTemplate);
        com.kwad.sdk.commercial.b.l(new SplashMonitorInfo().setStatus(4).setCreativeId(com.kwad.sdk.core.response.b.a.J(eb2)).setType(com.kwad.sdk.core.response.b.a.bd(eb2) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void af(@Nullable AdTemplate adTemplate) {
        String str;
        boolean z10;
        int i10;
        AdMatrixInfo.SplashPlayCardTKInfo dm = com.kwad.sdk.core.response.b.b.dm(adTemplate);
        boolean z11 = true;
        if (TextUtils.isEmpty(dm.templateId)) {
            str = SplashMonitorInfo.TEMPLATE_ID_EMPTY;
            z10 = true;
        } else {
            str = "";
            z10 = false;
        }
        if (dm.renderType != 1) {
            str = str + SplashMonitorInfo.TEMPLATE_RENER_TYPE_ERROR;
            i10 = dm.renderType;
        } else {
            i10 = -1;
            z11 = z10;
        }
        if (z11) {
            com.kwad.sdk.commercial.b.n(new SplashMonitorInfo().setErrorMsg(str).setErrorCode(i10).setAdTemplate(adTemplate));
        }
    }

    public static void ag(AdTemplate adTemplate) {
        AdInfo eb2 = e.eb(adTemplate);
        com.kwad.sdk.commercial.b.l(new SplashMonitorInfo().setStatus(3001).setMaterialType(2).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(eb2)).setCreativeId(com.kwad.sdk.core.response.b.a.J(eb2)).setUrl(com.kwad.sdk.core.response.b.a.aU(eb2).materialUrl).setAdTemplate(adTemplate));
    }

    public static void ah(AdTemplate adTemplate) {
        AdInfo eb2 = e.eb(adTemplate);
        com.kwad.sdk.commercial.b.l(new SplashMonitorInfo().setStatus(3002).setMaterialType(2).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(eb2)).setCreativeId(com.kwad.sdk.core.response.b.a.J(eb2)).setUrl(com.kwad.sdk.core.response.b.a.aU(eb2).materialUrl).setAdTemplate(adTemplate));
    }

    public static void ai(AdTemplate adTemplate) {
        AdInfo eb2 = e.eb(adTemplate);
        com.kwad.sdk.commercial.b.l(new SplashMonitorInfo().setStatus(3003).setMaterialType(2).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(eb2)).setCreativeId(com.kwad.sdk.core.response.b.a.J(eb2)).setUrl(com.kwad.sdk.core.response.b.a.aU(eb2).materialUrl).setAdTemplate(adTemplate));
    }

    public static void b(@NonNull AdTemplate adTemplate, int i10, long j10, long j11) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j10;
        AdInfo eb2 = e.eb(adTemplate);
        com.kwad.sdk.commercial.b.i(new SplashMonitorInfo().setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(5).setCheckStatus(i10).setLoadDataTime(adTemplate.loadDataTime).setCheckDataTime(elapsedRealtime).setBeforeLoadDataTime(j11).setLoadAndCheckDataTime(adTemplate.loadDataTime + elapsedRealtime).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(eb2)).setUrl(com.kwad.sdk.core.response.b.a.bc(eb2) ? com.kwad.sdk.core.response.b.a.K(eb2) : com.kwad.sdk.core.response.b.a.aU(eb2).materialUrl).setAdTemplate(adTemplate));
    }

    public static void c(boolean z10, int i10, String str, long j10) {
        com.kwad.sdk.commercial.b.i(new SplashMonitorInfo().setStatus(4).setType(z10 ? 2 : 1).setErrorCode(i10).setErrorMsg(str).setPosId(j10));
    }

    public static void d(@NonNull AdTemplate adTemplate, long j10) {
        com.kwad.sdk.commercial.b.i(new SplashMonitorInfo().setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(2).setBeforeLoadDataTime(j10).setLoadDataTime(adTemplate.loadDataTime).setLoadProcessType(d.a(com.kwad.components.ad.splashscreen.b.a.Et) ? 1L : 2L).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(e.eb(adTemplate))).setAdTemplate(adTemplate));
    }

    public static void e(@NonNull AdTemplate adTemplate, long j10) {
        AdInfo eb2 = e.eb(adTemplate);
        com.kwad.sdk.commercial.b.l(new SplashMonitorInfo().setStatus(5).setType(com.kwad.sdk.core.response.b.a.bd(eb2) ? 2 : 1).setCostTime(j10).setCreativeId(com.kwad.sdk.core.response.b.a.J(eb2)).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(eb2)).setAdTemplate(adTemplate));
    }

    public static void f(long j10, long j11) {
        com.kwad.sdk.commercial.b.i(new SplashMonitorInfo().setStatus(11).setBeforeLoadDataTime(j11).setLoadProcessType(d.a(com.kwad.components.ad.splashscreen.b.a.Et) ? 1L : 2L).setPosId(j10));
    }

    public static void i(@NonNull AdResultData adResultData) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
            arrayList.add(String.valueOf(com.kwad.sdk.core.response.b.a.J(e.eb(adTemplate))));
            arrayList2.add(com.kwad.sdk.core.response.b.a.aZ(e.eb(adTemplate)));
        }
        com.kwad.sdk.commercial.b.k(new SplashMonitorInfo().setTotalCount(adResultData.getAdTemplateList().size()).setCreativeIds(arrayList).setPreloadIds(arrayList2).setPosId(adResultData.getPosId()));
    }

    public static b lm() {
        if (Ew == null) {
            synchronized (b.class) {
                try {
                    if (Ew == null) {
                        Ew = new b();
                    }
                } finally {
                }
            }
        }
        return Ew;
    }

    public static void p(long j10) {
        com.kwad.sdk.commercial.b.i(new SplashMonitorInfo().setStatus(1).setLoadProcessType(d.a(com.kwad.components.ad.splashscreen.b.a.Et) ? 1L : 2L).setPosId(j10));
    }

    public static void q(long j10) {
        com.kwad.sdk.commercial.b.j(new SplashMonitorInfo().setStatus(1).setPosId(j10));
    }

    public static void f(@NonNull AdTemplate adTemplate, long j10) {
        AdInfo eb2 = e.eb(adTemplate);
        com.kwad.sdk.commercial.b.l(new SplashMonitorInfo().setStatus(2).setType(com.kwad.sdk.core.response.b.a.bd(eb2) ? 2 : 1).setCostTime(j10).setCreativeId(com.kwad.sdk.core.response.b.a.J(eb2)).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(eb2)).setLoadProcessType(d.a(com.kwad.components.ad.splashscreen.b.a.Et) ? 1L : 2L).setAdTemplate(adTemplate));
    }

    public final void c(AdTemplate adTemplate, String str) {
        long dC;
        StyleTemplate b10 = b(adTemplate);
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(103).setTkRenderType(com.kwad.sdk.core.response.b.b.m38do(adTemplate)).setTemplateId(b10.templateId).setTemplateVersionCode(b10.templateVersionCode);
        e.eb(adTemplate);
        if (h.X(adTemplate)) {
            dC = com.kwad.sdk.core.response.b.b.dn(adTemplate);
        } else {
            dC = com.kwad.sdk.core.response.b.b.dC(e.eb(adTemplate));
        }
        com.kwad.sdk.commercial.b.l(templateVersionCode.setTkDefaultTimeout(dC).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    public static void e(@NonNull AdTemplate adTemplate, int i10, String str) {
        String K;
        AdInfo eb2 = e.eb(adTemplate);
        boolean bd2 = com.kwad.sdk.core.response.b.a.bd(eb2);
        SplashMonitorInfo type = new SplashMonitorInfo().setStatus(3).setCreativeId(com.kwad.sdk.core.response.b.a.J(eb2)).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(eb2)).setType(bd2 ? 2 : 1);
        if (bd2) {
            K = com.kwad.sdk.core.response.b.a.aU(eb2).materialUrl;
        } else {
            K = com.kwad.sdk.core.response.b.a.K(eb2);
        }
        com.kwad.sdk.commercial.b.l(type.setUrl(K).setErrorCode(i10).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    public static void d(@NonNull AdTemplate adTemplate, int i10, String str) {
        String str2;
        AdInfo eb2 = e.eb(adTemplate);
        if (com.kwad.sdk.core.response.b.a.bc(eb2)) {
            str2 = com.kwad.sdk.core.response.b.a.K(eb2);
        } else {
            str2 = com.kwad.sdk.core.response.b.a.aU(eb2).materialUrl;
        }
        com.kwad.sdk.commercial.b.g(true, new SplashMonitorInfo().setStatus(2).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(eb2)).setCreativeId(com.kwad.sdk.core.response.b.a.J(eb2)).setUrl(str2).setErrorCode(i10).setErrorMsg(str).setMaterialType(com.kwad.sdk.core.response.b.a.bc(eb2) ? 1 : 2).setType(1).setAdTemplate(adTemplate));
    }

    public static void a(@NonNull List<AdTemplate> list, long j10, long j11) {
        ArrayList arrayList = new ArrayList();
        Iterator<AdTemplate> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(com.kwad.sdk.core.response.b.a.aZ(e.eb(it.next())));
        }
        com.kwad.sdk.commercial.b.j(new SplashMonitorInfo().setStatus(2).setIds(arrayList).setLoadDataTime(j10).setCount(list.size()).setPosId(j11));
    }

    public static void b(int i10, String str, long j10) {
        com.kwad.sdk.commercial.b.j(new SplashMonitorInfo().setStatus(3).setErrorCode(i10).setErrorMsg(str).setPosId(j10));
    }

    public static void c(AdTemplate adTemplate, StyleTemplate styleTemplate) {
        long dC;
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(106).setTkRenderType(com.kwad.sdk.core.response.b.b.m38do(adTemplate)).setTemplateId(styleTemplate.templateId).setTemplateVersionCode(styleTemplate.templateVersionCode);
        e.eb(adTemplate);
        if (h.X(adTemplate)) {
            dC = com.kwad.sdk.core.response.b.b.dn(adTemplate);
        } else {
            dC = com.kwad.sdk.core.response.b.b.dC(e.eb(adTemplate));
        }
        com.kwad.sdk.commercial.b.l(templateVersionCode.setTkDefaultTimeout(dC).setAdTemplate(adTemplate));
    }

    public static void b(boolean z10, int i10, String str, long j10) {
        com.kwad.sdk.commercial.b.o(new SplashMonitorInfo().setStatus(4).setType(z10 ? 2 : 1).setErrorCode(i10).setErrorMsg(str).setPosId(j10));
    }

    public static void a(@NonNull AdTemplate adTemplate, long j10, int i10) {
        String str;
        AdInfo eb2 = e.eb(adTemplate);
        if (com.kwad.sdk.core.response.b.a.bc(eb2)) {
            str = com.kwad.sdk.core.response.b.a.K(eb2);
        } else {
            str = com.kwad.sdk.core.response.b.a.aU(eb2).materialUrl;
        }
        File ca2 = com.kwad.sdk.core.diskcache.b.a.EG().ca(com.kwad.sdk.core.response.b.a.aZ(eb2));
        com.kwad.sdk.commercial.b.g(false, new SplashMonitorInfo().setStatus(1).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(eb2)).setCostTime(j10).setCacheValidTime(eb2.adPreloadInfo.validityPeriod * 1000).setSize((ca2 == null || !ca2.exists()) ? 0L : ca2.length()).setUrl(str).setMaterialType(com.kwad.sdk.core.response.b.a.bc(eb2) ? 1 : 2).setType(i10).setAdTemplate(adTemplate));
    }

    public final void d(AdTemplate adTemplate, String str) {
        long dC;
        StyleTemplate b10 = b(adTemplate);
        SplashMonitorInfo errorMsg = new SplashMonitorInfo().setStatus(105).setTemplateId(b10.templateId).setTemplateVersionCode(b10.templateVersionCode).setTkRenderType(com.kwad.sdk.core.response.b.b.m38do(adTemplate)).setErrorMsg(str);
        e.eb(adTemplate);
        if (h.X(adTemplate)) {
            dC = com.kwad.sdk.core.response.b.b.dn(adTemplate);
        } else {
            dC = com.kwad.sdk.core.response.b.b.dC(e.eb(adTemplate));
        }
        com.kwad.sdk.commercial.b.l(errorMsg.setTkDefaultTimeout(dC).setAdTemplate(adTemplate));
    }

    public static void b(AdTemplate adTemplate, StyleTemplate styleTemplate) {
        long dC;
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(102).setTemplateId(styleTemplate.templateId).setTkRenderType(com.kwad.sdk.core.response.b.b.m38do(adTemplate)).setTemplateVersionCode(styleTemplate.templateVersionCode);
        e.eb(adTemplate);
        if (h.X(adTemplate)) {
            dC = com.kwad.sdk.core.response.b.b.dn(adTemplate);
        } else {
            dC = com.kwad.sdk.core.response.b.b.dC(e.eb(adTemplate));
        }
        com.kwad.sdk.commercial.b.l(templateVersionCode.setTkDefaultTimeout(dC).setAdTemplate(adTemplate));
    }

    private static StyleTemplate b(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k10 = com.kwad.sdk.core.response.b.b.k(adTemplate, com.kwad.sdk.core.response.b.b.dB(adTemplate));
        StyleTemplate styleTemplate = new StyleTemplate();
        if (k10 != null) {
            styleTemplate.templateId = k10.templateId;
            styleTemplate.templateMd5 = k10.templateMd5;
            styleTemplate.templateUrl = k10.templateUrl;
            styleTemplate.templateVersionCode = (int) k10.templateVersionCode;
        }
        return styleTemplate;
    }

    public static void a(@NonNull AdTemplate adTemplate, long j10, boolean z10) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j10;
        AdInfo eb2 = e.eb(adTemplate);
        com.kwad.sdk.commercial.b.l(new SplashMonitorInfo().setStatus(6).setCreativeId(com.kwad.sdk.core.response.b.a.J(eb2)).setViewSource(z10 ? 1 : 2).setLoadDataTime(elapsedRealtime).setType(com.kwad.sdk.core.response.b.a.bd(eb2) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void a(@Nullable AdTemplate adTemplate, String str, boolean z10) {
        if (adTemplate == null) {
            com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setErrorMsg(str).setViewSource(z10 ? 1 : 2));
        } else {
            com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setCreativeId(com.kwad.sdk.core.response.b.a.J(e.eb(adTemplate))).setErrorMsg(str).setViewSource(z10 ? 1 : 2).setAdTemplate(adTemplate));
        }
    }

    public static void a(AdTemplate adTemplate, StyleTemplate styleTemplate) {
        long dC;
        SplashMonitorInfo tkRenderType = new SplashMonitorInfo().setStatus(101).setTemplateId(styleTemplate.templateId).setTemplateVersionCode(styleTemplate.templateVersionCode).setTkRenderType(com.kwad.sdk.core.response.b.b.m38do(adTemplate));
        e.eb(adTemplate);
        if (h.X(adTemplate)) {
            dC = com.kwad.sdk.core.response.b.b.dn(adTemplate);
        } else {
            dC = com.kwad.sdk.core.response.b.b.dC(e.eb(adTemplate));
        }
        com.kwad.sdk.commercial.b.l(tkRenderType.setTkDefaultTimeout(dC).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, StyleTemplate styleTemplate, int i10, long j10, int i11, long j11, long j12, long j13, long j14, long j15) {
        long dC;
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(104).setTemplateId(styleTemplate.templateId).setTkRenderType(com.kwad.sdk.core.response.b.b.m38do(adTemplate)).setTemplateVersionCode(styleTemplate.templateVersionCode);
        e.eb(adTemplate);
        if (h.X(adTemplate)) {
            dC = com.kwad.sdk.core.response.b.b.dn(adTemplate);
        } else {
            dC = com.kwad.sdk.core.response.b.b.dC(e.eb(adTemplate));
        }
        com.kwad.sdk.commercial.b.l(templateVersionCode.setTkDefaultTimeout(dC).setSoSource(i10).setSoLoadTime(j10).setOfflineSource(i11).setOfflineLoadTime(j11).setTkFileLoadTime(j12).setTkInitTime(j13).setTkRenderTime(j14).setTkTotalTime(j15).setAdTemplate(adTemplate));
    }
}
