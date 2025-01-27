package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import com.kwad.components.core.video.j;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.al;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class SplashPreloadManager {
    private HashMap<String, PreLoadItem> DP;
    private List<String> DQ;
    private volatile SharedPreferences DR;
    private final Object mLock;

    @KsJson
    public static class PreLoadItem extends com.kwad.sdk.core.response.a.a implements Serializable {
        public long cacheTime;
        public long expiredTime;
        public String preloadId;
    }

    public static class a {
        private static final SplashPreloadManager DS = new SplashPreloadManager((byte) 0);
    }

    public /* synthetic */ SplashPreloadManager(byte b10) {
        this();
    }

    public static File W(String str) {
        if (str == null) {
            return null;
        }
        com.kwad.sdk.core.d.c.d("PreloadManager", "getVideoFile preloadId " + str + "  url " + str);
        File ca2 = com.kwad.sdk.core.diskcache.b.a.EG().ca(str);
        if (ca2 == null || !ca2.exists()) {
            return null;
        }
        return ca2;
    }

    @AnyThread
    public static boolean g(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                return com.kwad.sdk.core.response.b.a.bd(adTemplate.adInfoList.get(0));
            }
        }
        return false;
    }

    @AnyThread
    public static boolean h(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                return com.kwad.sdk.core.response.b.a.bc(adTemplate.adInfoList.get(0));
            }
        }
        return false;
    }

    private void init() {
        Context context = ServiceProvider.getContext();
        if (context != null) {
            this.DR = context.getSharedPreferences("ksadsdk_splash_preload_id_list", 0);
            initData();
        }
    }

    private void initData() {
        Map<String, ?> all = this.DR.getAll();
        ArrayList arrayList = new ArrayList();
        for (String str : all.keySet()) {
            PreLoadItem preLoadItem = new PreLoadItem();
            try {
                Object obj = all.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (TextUtils.isEmpty(str2)) {
                        continue;
                    } else {
                        preLoadItem.parseJson(new JSONObject(str2));
                        if (TextUtils.isEmpty(preLoadItem.preloadId)) {
                            continue;
                        } else {
                            File ca2 = com.kwad.sdk.core.diskcache.b.a.EG().ca(preLoadItem.preloadId);
                            if (ca2 == null || !ca2.exists()) {
                                arrayList.add(preLoadItem.preloadId);
                                com.kwad.sdk.core.d.c.d("PreloadManager", "Remove null file list " + preLoadItem.preloadId);
                            } else {
                                synchronized (this.mLock) {
                                    try {
                                        this.DP.put(str, preLoadItem);
                                        if (!this.DQ.contains(str)) {
                                            this.DQ.add(str);
                                        }
                                    } catch (Throwable th2) {
                                        throw th2;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    continue;
                }
            } catch (Exception e10) {
                com.kwad.sdk.core.d.c.printStackTrace(e10);
            }
        }
        SharedPreferences.Editor edit = this.DR.edit();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            edit.remove((String) it.next());
        }
        edit.apply();
    }

    private void kP() {
        int size;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.mLock) {
            try {
                ArrayList<String> arrayList = new ArrayList();
                for (String str : this.DP.keySet()) {
                    PreLoadItem preLoadItem = this.DP.get(str);
                    if (preLoadItem != null && preLoadItem.expiredTime < currentTimeMillis) {
                        arrayList.add(str);
                    }
                }
                SharedPreferences.Editor edit = this.DR.edit();
                for (String str2 : arrayList) {
                    this.DQ.remove(str2);
                    this.DP.remove(str2);
                    edit.remove(str2);
                    com.kwad.sdk.core.diskcache.b.a.EG().remove(str2);
                }
                edit.apply();
                size = this.DQ.size();
            } finally {
            }
        }
        if (size > 30) {
            com.kwad.sdk.core.d.c.d("PreloadManager", "大于 30 按失效日期远近顺序移除");
            int i10 = size - 15;
            for (int i11 = 0; i11 < i10; i11++) {
                String str3 = "";
                synchronized (this.mLock) {
                    try {
                        long j10 = Long.MAX_VALUE;
                        for (PreLoadItem preLoadItem2 : this.DP.values()) {
                            long j11 = preLoadItem2.expiredTime;
                            if (j11 < j10) {
                                str3 = preLoadItem2.preloadId;
                                j10 = j11;
                            }
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            this.DQ.remove(str3);
                            this.DP.remove(str3);
                            this.DR.edit().remove(str3).apply();
                            com.kwad.sdk.core.d.c.d("PreloadManager", "移除 preloadId = " + str3 + " expiredTime =  " + j10);
                        }
                    } finally {
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    com.kwad.sdk.core.diskcache.b.a.EG().remove(str3);
                }
            }
        }
    }

    @AnyThread
    public static SplashPreloadManager kQ() {
        SplashPreloadManager splashPreloadManager = a.DS;
        if (splashPreloadManager.DR == null) {
            splashPreloadManager.init();
        }
        return splashPreloadManager;
    }

    @AnyThread
    private void o(AdInfo adInfo) {
        PreLoadItem preLoadItem = new PreLoadItem();
        preLoadItem.cacheTime = System.currentTimeMillis();
        preLoadItem.expiredTime = System.currentTimeMillis() + (adInfo.adPreloadInfo.validityPeriod * 1000);
        preLoadItem.preloadId = com.kwad.sdk.core.response.b.a.aZ(adInfo);
        synchronized (this.mLock) {
            try {
                this.DP.put(adInfo.adPreloadInfo.preloadId, preLoadItem);
                if (!this.DQ.contains(adInfo.adPreloadInfo.preloadId)) {
                    this.DQ.add(adInfo.adPreloadInfo.preloadId);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (this.DR != null) {
            SharedPreferences.Editor edit = this.DR.edit();
            edit.putString(adInfo.adPreloadInfo.preloadId, preLoadItem.toJson().toString());
            edit.apply();
        }
    }

    private static boolean p(AdInfo adInfo) {
        return com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.Et) && com.kwad.sdk.core.response.b.a.bd(adInfo);
    }

    @AnyThread
    private boolean q(AdInfo adInfo) {
        if (p(adInfo)) {
            return KSImageLoader.isImageExist(com.kwad.sdk.core.response.b.a.aU(adInfo).materialUrl);
        }
        String str = adInfo.adPreloadInfo.preloadId;
        if (str != null) {
            File ca2 = com.kwad.sdk.core.diskcache.b.a.EG().ca(str);
            StringBuilder sb2 = new StringBuilder("check preloadId ");
            sb2.append(str);
            sb2.append(" file exists ");
            sb2.append(ca2 == null ? "null" : Boolean.valueOf(ca2.exists()));
            com.kwad.sdk.core.d.c.d("PreloadManager", sb2.toString());
            if (ca2 != null && ca2.exists()) {
                return true;
            }
        }
        return false;
    }

    public final List<String> R() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            try {
                com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdList start ");
                for (int i10 = 0; i10 < this.DQ.size(); i10++) {
                    String str = this.DQ.get(i10);
                    File ca2 = com.kwad.sdk.core.diskcache.b.a.EG().ca(str);
                    if (ca2 != null && ca2.exists()) {
                        arrayList.add(str);
                    }
                }
                com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdList end ");
            } catch (Throwable th2) {
                throw th2;
            }
        }
        com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdList " + this.DQ.size());
        return arrayList;
    }

    @AnyThread
    public final int b(AdResultData adResultData, boolean z10) {
        Iterator<AdTemplate> it = adResultData.getAdTemplateList().iterator();
        com.kwad.components.ad.splashscreen.monitor.b.lm();
        com.kwad.components.ad.splashscreen.monitor.b.i(adResultData);
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdTemplate next = it.next();
            if (next != null) {
                for (AdInfo adInfo : next.adInfoList) {
                    if (adInfo.adPreloadInfo == null || this.DR == null) {
                        com.kwad.components.ad.splashscreen.monitor.b.lm();
                        com.kwad.components.ad.splashscreen.monitor.b.d(next, 3, SplashMonitorInfo.ERROR_PRELOAD_ID_INVALID_MSG);
                    } else {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (q(adInfo)) {
                            com.kwad.components.ad.splashscreen.monitor.b.lm();
                            com.kwad.components.ad.splashscreen.monitor.b.a(next, SystemClock.elapsedRealtime() - elapsedRealtime, 2);
                            o(adInfo);
                            i10++;
                        } else {
                            String K = com.kwad.sdk.core.response.b.a.bc(adInfo) ? com.kwad.sdk.core.response.b.a.K(adInfo) : com.kwad.sdk.core.response.b.a.bd(adInfo) ? com.kwad.sdk.core.response.b.a.aU(adInfo).materialUrl : null;
                            if (TextUtils.isEmpty(K)) {
                                com.kwad.components.ad.splashscreen.monitor.b.lm();
                                com.kwad.components.ad.splashscreen.monitor.b.d(next, 2, SplashMonitorInfo.ERROR_URL_INVALID_MSG);
                            } else {
                                String aZ = com.kwad.sdk.core.response.b.a.aZ(adInfo);
                                if (adInfo.adPreloadInfo.preloadType != 1 || al.isWifiConnected(ServiceProvider.getContext()) || z10) {
                                    com.kwad.sdk.core.d.c.d("PreloadManager", "start Download preloadId " + aZ + " true url " + K);
                                    kP();
                                    a.C0497a c0497a = new a.C0497a();
                                    if (p(adInfo) ? KSImageLoader.loadImageSync(K) != null : j.a(K, aZ, c0497a)) {
                                        o(adInfo);
                                        i10++;
                                        com.kwad.components.ad.splashscreen.monitor.b.lm();
                                        com.kwad.components.ad.splashscreen.monitor.b.a(next, SystemClock.elapsedRealtime() - elapsedRealtime, 1);
                                    } else {
                                        com.kwad.components.ad.splashscreen.monitor.b.lm();
                                        com.kwad.components.ad.splashscreen.monitor.b.d(next, 4, c0497a.msg);
                                        com.kwad.components.core.o.a.ri().f(next, 1, c0497a.msg);
                                    }
                                } else {
                                    com.kwad.components.ad.splashscreen.monitor.b.lm();
                                    com.kwad.components.ad.splashscreen.monitor.b.d(next, 1, SplashMonitorInfo.ERROR_NET_MSG);
                                }
                            }
                        }
                    }
                }
            }
        }
        AdTemplate adTemplate = adResultData.getAdTemplateList().size() > 0 ? adResultData.getAdTemplateList().get(0) : null;
        if (i10 > 0) {
            com.kwad.sdk.utils.j.ao("splashAd_", "onSplashVideoAdCacheSuccess");
            com.kwad.components.core.o.a.ri().e(adTemplate, i10);
        } else {
            com.kwad.sdk.utils.j.ao("splashAd_", "onSplashVideoAdCacheFailed");
        }
        return i10;
    }

    @AnyThread
    public final boolean f(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                AdInfo adInfo = adTemplate.adInfoList.get(0);
                if (adInfo.adPreloadInfo != null) {
                    return p(adInfo) ? KSImageLoader.isImageExist(com.kwad.sdk.core.response.b.a.aU(adInfo).materialUrl) : q(adInfo);
                }
            }
        }
        return false;
    }

    private SplashPreloadManager() {
        this.mLock = new Object();
        this.DP = new HashMap<>();
        this.DQ = new ArrayList();
        init();
    }
}
