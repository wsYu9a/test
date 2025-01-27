package com.kwad.components.splash;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.components.core.video.h;
import com.kwad.components.splash.monitor.SplashMonitorInfo;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.network.kwai.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.i;
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
    private HashMap<String, PreLoadItem> Ya;
    private List<String> Yb;
    private volatile SharedPreferences Yc;
    private final Object mLock;

    @KsJson
    public static class PreLoadItem extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public long cacheTime;
        public long expiredTime;
        public String preloadId;
    }

    static class a {
        private static final SplashPreloadManager Yd = new SplashPreloadManager((byte) 0);
    }

    private SplashPreloadManager() {
        this.mLock = new Object();
        this.Ya = new HashMap<>();
        this.Yb = new ArrayList();
        init();
    }

    /* synthetic */ SplashPreloadManager(byte b2) {
        this();
    }

    @AnyThread
    private static boolean aV(String str) {
        if (str != null) {
            File aX = com.kwad.sdk.core.diskcache.a.a.vs().aX(str);
            StringBuilder sb = new StringBuilder("check preloadId ");
            sb.append(str);
            sb.append(" file exists ");
            sb.append(aX == null ? "null" : Boolean.valueOf(aX.exists()));
            b.d("PreloadManager", sb.toString());
            if (aX != null && aX.exists()) {
                return true;
            }
        }
        return false;
    }

    public static File aW(String str) {
        if (str == null) {
            return null;
        }
        b.d("PreloadManager", "getVideoFile preloadId " + str + "  url " + str);
        File aX = com.kwad.sdk.core.diskcache.a.a.vs().aX(str);
        if (aX == null || !aX.exists()) {
            return null;
        }
        return aX;
    }

    @AnyThread
    public static boolean g(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                return com.kwad.sdk.core.response.a.a.aV(adTemplate.adInfoList.get(0));
            }
        }
        return false;
    }

    private void init() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null) {
            this.Yc = context.getSharedPreferences("ksadsdk_splash_preload_id_list", 0);
            initData();
        }
    }

    private void initData() {
        Map<String, ?> all = this.Yc.getAll();
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
                            File aX = com.kwad.sdk.core.diskcache.a.a.vs().aX(preLoadItem.preloadId);
                            if (aX == null || !aX.exists()) {
                                arrayList.add(preLoadItem.preloadId);
                                b.d("PreloadManager", "Remove null file list " + preLoadItem.preloadId);
                            } else {
                                synchronized (this.mLock) {
                                    this.Ya.put(str, preLoadItem);
                                    if (!this.Yb.contains(str)) {
                                        this.Yb.add(str);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    continue;
                }
            } catch (Exception e2) {
                b.printStackTrace(e2);
            }
        }
        SharedPreferences.Editor edit = this.Yc.edit();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            edit.remove((String) it.next());
        }
        edit.apply();
    }

    private void rU() {
        int size;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.mLock) {
            ArrayList<String> arrayList = new ArrayList();
            for (String str : this.Ya.keySet()) {
                PreLoadItem preLoadItem = this.Ya.get(str);
                if (preLoadItem != null && preLoadItem.expiredTime < currentTimeMillis) {
                    arrayList.add(str);
                }
            }
            SharedPreferences.Editor edit = this.Yc.edit();
            for (String str2 : arrayList) {
                this.Yb.remove(str2);
                this.Ya.remove(str2);
                edit.remove(str2);
                com.kwad.sdk.core.diskcache.a.a.vs().remove(str2);
            }
            edit.apply();
            size = this.Yb.size();
        }
        if (size > 30) {
            b.d("PreloadManager", "大于 30 按失效日期远近顺序移除");
            int i2 = size - 15;
            for (int i3 = 0; i3 < i2; i3++) {
                long j2 = Long.MAX_VALUE;
                String str3 = "";
                synchronized (this.mLock) {
                    for (PreLoadItem preLoadItem2 : this.Ya.values()) {
                        long j3 = preLoadItem2.expiredTime;
                        if (j3 < j2) {
                            str3 = preLoadItem2.preloadId;
                            j2 = j3;
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        this.Yb.remove(str3);
                        this.Ya.remove(str3);
                        this.Yc.edit().remove(str3).apply();
                        b.d("PreloadManager", "移除 preloadId = " + str3 + " expiredTime =  " + j2);
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    com.kwad.sdk.core.diskcache.a.a.vs().remove(str3);
                }
            }
        }
    }

    @AnyThread
    public static SplashPreloadManager rV() {
        SplashPreloadManager splashPreloadManager = a.Yd;
        if (splashPreloadManager.Yc == null) {
            splashPreloadManager.init();
        }
        return splashPreloadManager;
    }

    @AnyThread
    private void y(AdInfo adInfo) {
        PreLoadItem preLoadItem = new PreLoadItem();
        preLoadItem.cacheTime = System.currentTimeMillis();
        preLoadItem.expiredTime = System.currentTimeMillis() + (adInfo.adPreloadInfo.validityPeriod * 1000);
        preLoadItem.preloadId = com.kwad.sdk.core.response.a.a.aS(adInfo);
        synchronized (this.mLock) {
            this.Ya.put(adInfo.adPreloadInfo.preloadId, preLoadItem);
            if (!this.Yb.contains(adInfo.adPreloadInfo.preloadId)) {
                this.Yb.add(adInfo.adPreloadInfo.preloadId);
            }
        }
        if (this.Yc != null) {
            SharedPreferences.Editor edit = this.Yc.edit();
            edit.putString(adInfo.adPreloadInfo.preloadId, preLoadItem.toJson().toString());
            edit.apply();
        }
    }

    @AnyThread
    public final int b(AdResultData adResultData, boolean z) {
        int i2;
        long j2;
        String str;
        Iterator<AdTemplate> it = adResultData.getAdTemplateList().iterator();
        com.kwad.components.splash.monitor.a.rY();
        com.kwad.components.splash.monitor.a.h(adResultData);
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdTemplate next = it.next();
            if (next != null) {
                for (AdInfo adInfo : next.adInfoList) {
                    if (adInfo.adPreloadInfo == null || this.Yc == null) {
                        com.kwad.components.splash.monitor.a.rY();
                        i2 = 3;
                        j2 = next.posId;
                        str = SplashMonitorInfo.ERROR_PRELOAD_ID_INVALID_MSG;
                    } else {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (aV(adInfo.adPreloadInfo.preloadId)) {
                            com.kwad.components.splash.monitor.a.rY();
                            com.kwad.components.splash.monitor.a.a(adInfo, SystemClock.elapsedRealtime() - elapsedRealtime, 2, next.posId);
                            y(adInfo);
                            i3++;
                        } else {
                            String E = com.kwad.sdk.core.response.a.a.aU(adInfo) ? com.kwad.sdk.core.response.a.a.E(adInfo) : com.kwad.sdk.core.response.a.a.aV(adInfo) ? com.kwad.sdk.core.response.a.a.aM(adInfo).materialUrl : null;
                            if (TextUtils.isEmpty(E)) {
                                com.kwad.components.splash.monitor.a.rY();
                                i2 = 2;
                                j2 = next.posId;
                                str = SplashMonitorInfo.ERROR_URL_INVALID_MSG;
                            } else {
                                String aS = com.kwad.sdk.core.response.a.a.aS(adInfo);
                                if (adInfo.adPreloadInfo.preloadType != 1 || ag.isWifiConnected(KsAdSDKImpl.get().getContext()) || z) {
                                    b.d("PreloadManager", "start Download preloadId " + aS + " true url " + E);
                                    rU();
                                    a.C0217a c0217a = new a.C0217a();
                                    if (h.a(E, aS, c0217a)) {
                                        y(adInfo);
                                        i3++;
                                        com.kwad.components.splash.monitor.a.rY();
                                        com.kwad.components.splash.monitor.a.a(adInfo, SystemClock.elapsedRealtime() - elapsedRealtime, 1, next.posId);
                                    } else {
                                        com.kwad.components.splash.monitor.a.rY();
                                        com.kwad.components.splash.monitor.a.a(adInfo, 4, c0217a.msg, next.posId);
                                        com.kwad.components.core.m.a.pb().b(next, 1, c0217a.msg);
                                    }
                                } else {
                                    com.kwad.components.splash.monitor.a.rY();
                                    com.kwad.components.splash.monitor.a.a(adInfo, 1, SplashMonitorInfo.ERROR_NET_MSG, next.posId);
                                }
                            }
                        }
                    }
                    com.kwad.components.splash.monitor.a.a(adInfo, i2, str, j2);
                }
            }
        }
        AdTemplate adTemplate = adResultData.getAdTemplateList().size() > 0 ? adResultData.getAdTemplateList().get(0) : null;
        if (i3 > 0) {
            i.Z("splashAd_", "onSplashVideoAdCacheSuccess");
            com.kwad.components.core.m.a.pb().f(adTemplate, i3);
        } else {
            i.Z("splashAd_", "onSplashVideoAdCacheFailed");
        }
        return i3;
    }

    @AnyThread
    public final boolean f(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                AdInfo adInfo = adTemplate.adInfoList.get(0);
                if (adInfo.adPreloadInfo != null) {
                    return aV(com.kwad.sdk.core.response.a.a.aS(adInfo));
                }
            }
        }
        return false;
    }

    public final List<String> rW() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            b.d("PreloadManager", "getPreloadIdList start ");
            for (int i2 = 0; i2 < this.Yb.size(); i2++) {
                String str = this.Yb.get(i2);
                File aX = com.kwad.sdk.core.diskcache.a.a.vs().aX(str);
                if (aX != null && aX.exists()) {
                    arrayList.add(str);
                }
            }
            b.d("PreloadManager", "getPreloadIdList end ");
        }
        b.d("PreloadManager", "getPreloadIdList " + this.Yb.size());
        return arrayList;
    }
}
