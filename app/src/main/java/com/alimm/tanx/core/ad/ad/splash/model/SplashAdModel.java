package com.alimm.tanx.core.ad.ad.splash.model;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.ad.splash.DownloadCacheCallback;
import com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager;
import com.alimm.tanx.core.ad.ad.splash.TanxSplashAd;
import com.alimm.tanx.core.ad.bean.AdInfo;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import com.alimm.tanx.core.ad.loader.TanxRequestLoader;
import com.alimm.tanx.core.ad.model.BaseModel;
import com.alimm.tanx.core.common.AdTask;
import com.alimm.tanx.core.common.tanxc_do;
import com.alimm.tanx.core.constant.TanxAdType;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.request.TopCreative;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.ut.impl.TanxSplashUt;
import com.alimm.tanx.core.utils.FileUtils;
import com.alimm.tanx.core.utils.LogUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class SplashAdModel extends BaseModel {
    private static final String TAG = "SplashAdModel";
    private int fromType;
    private boolean isSyncReq;
    private int mLoadDataCode;
    private String mRequestId = "";
    private volatile boolean isCallback = false;
    private final Context mContext = TanxCoreSdk.getApplication();

    /* renamed from: com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ TanxAdSlot tanxc_do;
        final /* synthetic */ ITanxRequestLoader.ITanxRequestListener tanxc_if;

        public AnonymousClass1(TanxAdSlot tanxAdSlot, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener) {
            tanxAdSlot = tanxAdSlot;
            iTanxRequestListener = iTanxRequestListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            String[] split;
            long currentTimeMillis = System.currentTimeMillis();
            LogUtils.d(SplashAdModel.TAG, "开始获取本地缓存数据 ---" + currentTimeMillis);
            if (!tanxAdSlot.isBrandAd()) {
                SplashAdModel.this.chooseRtbAd(iTanxRequestListener);
                return;
            }
            if (!tanxAdSlot.isRtSelection()) {
                SplashAdModel.this.chooseBrandAd(null, null, iTanxRequestListener);
                return;
            }
            tanxAdSlot.setRealtimeRequest(Boolean.TRUE);
            String advIds = SplashAdCacheManager.getInstance().getAdvIds(currentTimeMillis);
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(advIds) && (split = advIds.split(",")) != null && split.length > 0) {
                for (String str : split) {
                    arrayList.add(new TopCreative(str));
                }
            }
            tanxAdSlot.setTopCreatives(arrayList);
            SplashAdModel.super.sendRequest(tanxAdSlot, iTanxRequestListener, 0L);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel$2 */
    public class AnonymousClass2 implements AdTask.onErrorListener {
        final /* synthetic */ ITanxRequestLoader.ITanxRequestListener tanxc_do;

        public AnonymousClass2(ITanxRequestLoader.ITanxRequestListener iTanxRequestListener) {
            iTanxRequestListener = iTanxRequestListener;
        }

        @Override // com.alimm.tanx.core.common.AdTask.onErrorListener
        public void onError(String str) {
            SplashAdModel.this.callBack2Error(null, iTanxRequestListener, new TanxError(str));
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel$3 */
    public class AnonymousClass3 implements DownloadCacheCallback {
        final /* synthetic */ BidInfo tanxc_do;
        final /* synthetic */ ITanxRequestLoader.ITanxRequestListener tanxc_for;
        final /* synthetic */ AdInfo tanxc_if;

        public AnonymousClass3(BidInfo bidInfo, AdInfo adInfo, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener) {
            bidInfo = bidInfo;
            adInfo = adInfo;
            iTanxRequestListener = iTanxRequestListener;
        }

        @Override // com.alimm.tanx.core.ad.ad.splash.DownloadCacheCallback
        public void onFail(int i10, String str) {
            LogUtils.d(SplashAdModel.TAG, "chooseBrandAd--------实时接口返回的素材未准备好，触发下载，但失败" + System.currentTimeMillis());
            SplashAdModel splashAdModel = SplashAdModel.this;
            AdInfo adInfo = adInfo;
            ITanxRequestLoader.ITanxRequestListener iTanxRequestListener = iTanxRequestListener;
            AdInfo adInfo2 = adInfo;
            splashAdModel.callBack2Error(adInfo, iTanxRequestListener, new TanxError(adInfo2 != null ? adInfo2.getRequestId() : "", i10, str));
        }

        @Override // com.alimm.tanx.core.ad.ad.splash.DownloadCacheCallback
        public void onSuccess(File file) {
            LogUtils.d(SplashAdModel.TAG, "chooseBrandAd--------实时接口返回的素材未准备好，触发下载并成功下完" + System.currentTimeMillis());
            if (SplashAdModel.this.isAssetExists(bidInfo)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new TanxSplashAd(((BaseModel) SplashAdModel.this).adSlot, bidInfo, adInfo.getRequestId(), 1, SplashAdModel.this.getScene()));
                SplashAdModel.this.callBack2Succ(adInfo, iTanxRequestListener, arrayList);
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel$4 */
    public class AnonymousClass4 implements Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SplashAdCacheManager.getInstance().deleteCachedResponseJson();
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel$5 */
    public class AnonymousClass5 implements Runnable {
        final /* synthetic */ AdInfo tanxc_do;

        public AnonymousClass5(AdInfo adInfo) {
            adInfo = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!SplashAdModel.this.isSyncReq) {
                SplashAdModel.this.cacheAdInfo(adInfo.getDecrypt());
                if (adInfo != null) {
                    SplashAdCacheManager.getInstance().setPreRequestId(adInfo.getRequestId());
                }
            }
            AdInfo adInfo = adInfo;
            if (adInfo != null && adInfo.getBidInfoList() != null && adInfo.getBidInfoList().size() > 0) {
                Iterator<BidInfo> it = adInfo.getBidInfoList().iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
            SplashAdCacheManager.getInstance().trimLocalCache();
            SplashAdCacheManager.getInstance().downloadAd2Cache(((BaseModel) SplashAdModel.this).adSlot, adInfo.getBidInfoList(), null);
        }
    }

    public void cacheAdInfo(String str) {
        TanxAdSlot tanxAdSlot;
        try {
            if (!TextUtils.isEmpty(str) && (tanxAdSlot = this.adSlot) != null && !TextUtils.isEmpty(tanxAdSlot.getPid())) {
                String splashAdResponseFile = SplashAdCacheManager.getSplashAdResponseFile(this.mContext, this.adSlot.getPid());
                LogUtils.d(TAG, "cacheAdInfo fileName= " + splashAdResponseFile);
                FileUtils.saveStr2File(splashAdResponseFile, str);
            }
        } catch (Exception e10) {
            LogUtils.e(TAG, "cacheAdInfo error", e10);
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), TAG, "cacheAdInfo error" + LogUtils.getStackTraceMessage(e10), "");
        }
    }

    private void cacheAndManageAsset(AdInfo adInfo) {
        if (adInfo == null) {
            return;
        }
        tanxc_do.tanxc_do(new AdTask(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel.5
            final /* synthetic */ AdInfo tanxc_do;

            public AnonymousClass5(AdInfo adInfo2) {
                adInfo = adInfo2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!SplashAdModel.this.isSyncReq) {
                    SplashAdModel.this.cacheAdInfo(adInfo.getDecrypt());
                    if (adInfo != null) {
                        SplashAdCacheManager.getInstance().setPreRequestId(adInfo.getRequestId());
                    }
                }
                AdInfo adInfo2 = adInfo;
                if (adInfo2 != null && adInfo2.getBidInfoList() != null && adInfo.getBidInfoList().size() > 0) {
                    Iterator<BidInfo> it = adInfo.getBidInfoList().iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
                SplashAdCacheManager.getInstance().trimLocalCache();
                SplashAdCacheManager.getInstance().downloadAd2Cache(((BaseModel) SplashAdModel.this).adSlot, adInfo.getBidInfoList(), null);
            }
        }, "handleRequestResponse"));
    }

    public void callBack2Error(AdInfo adInfo, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener, TanxError tanxError) {
        if (!this.hasTimeOut) {
            cancel();
            timerCancelNotify(adInfo, false, tanxError != null ? tanxError.getCode() : -9999);
            if (iTanxRequestListener != null && !this.isCallback) {
                iTanxRequestListener.onError(tanxError);
                this.isCallback = true;
            }
        }
        TanxAdSlot tanxAdSlot = this.adSlot;
        if (tanxAdSlot == null || !tanxAdSlot.isBrandAd()) {
            return;
        }
        new TanxRequestLoader().preRequest(this.adSlot, null);
    }

    public void callBack2Succ(AdInfo adInfo, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener, List<TanxSplashAd> list) {
        if (this.hasTimeOut) {
            return;
        }
        cancel();
        timerCancelNotify(adInfo, true, 0);
        if (iTanxRequestListener == null || this.isCallback) {
            return;
        }
        iTanxRequestListener.onSuccess(list);
        this.isCallback = true;
    }

    public void chooseBrandAd(AdInfo adInfo, BidInfo bidInfo, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener) {
        String str;
        String str2;
        TanxAdSlot tanxAdSlot;
        str = "";
        if (bidInfo != null) {
            LogUtils.d(TAG, "chooseBrandAd--------开始判断并替换实时请求返回的素材" + System.currentTimeMillis());
            if (isAssetExists(bidInfo)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new TanxSplashAd(this.adSlot, bidInfo, adInfo.getRequestId(), 1, getScene()));
                callBack2Succ(adInfo, iTanxRequestListener, arrayList);
                return;
            }
            LogUtils.d(TAG, "chooseBrandAd--------实时接口返回的素材未准备好，需要启动下载" + System.currentTimeMillis());
            if (bidInfo.getCreativeType() != 4 || (tanxAdSlot = this.adSlot) == null || tanxAdSlot.isRtDownloadVideo()) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(bidInfo);
                SplashAdCacheManager.getInstance().downloadAd2Cache(this.adSlot, arrayList2, new DownloadCacheCallback() { // from class: com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel.3
                    final /* synthetic */ BidInfo tanxc_do;
                    final /* synthetic */ ITanxRequestLoader.ITanxRequestListener tanxc_for;
                    final /* synthetic */ AdInfo tanxc_if;

                    public AnonymousClass3(BidInfo bidInfo2, AdInfo adInfo2, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener2) {
                        bidInfo = bidInfo2;
                        adInfo = adInfo2;
                        iTanxRequestListener = iTanxRequestListener2;
                    }

                    @Override // com.alimm.tanx.core.ad.ad.splash.DownloadCacheCallback
                    public void onFail(int i10, String str3) {
                        LogUtils.d(SplashAdModel.TAG, "chooseBrandAd--------实时接口返回的素材未准备好，触发下载，但失败" + System.currentTimeMillis());
                        SplashAdModel splashAdModel = SplashAdModel.this;
                        AdInfo adInfo2 = adInfo;
                        ITanxRequestLoader.ITanxRequestListener iTanxRequestListener2 = iTanxRequestListener;
                        AdInfo adInfo22 = adInfo;
                        splashAdModel.callBack2Error(adInfo2, iTanxRequestListener2, new TanxError(adInfo22 != null ? adInfo22.getRequestId() : "", i10, str3));
                    }

                    @Override // com.alimm.tanx.core.ad.ad.splash.DownloadCacheCallback
                    public void onSuccess(File file) {
                        LogUtils.d(SplashAdModel.TAG, "chooseBrandAd--------实时接口返回的素材未准备好，触发下载并成功下完" + System.currentTimeMillis());
                        if (SplashAdModel.this.isAssetExists(bidInfo)) {
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(new TanxSplashAd(((BaseModel) SplashAdModel.this).adSlot, bidInfo, adInfo.getRequestId(), 1, SplashAdModel.this.getScene()));
                            SplashAdModel.this.callBack2Succ(adInfo, iTanxRequestListener, arrayList3);
                        }
                    }
                });
                return;
            } else {
                str = adInfo2 != null ? adInfo2.getRequestId() : "";
                UtErrorCode utErrorCode = UtErrorCode.VIDEO_RT_SWITCH_FALSE;
                callBack2Error(adInfo2, iTanxRequestListener2, new TanxError(str, utErrorCode.getIntCode(), utErrorCode.getMsg()));
                return;
            }
        }
        LogUtils.d(TAG, "chooseBrandAd--------开始走缓存" + System.currentTimeMillis());
        AdInfo adInfo2Pid = getAdInfo2Pid();
        if (adInfo2Pid == null) {
            String requestId = adInfo2 != null ? adInfo2.getRequestId() : "";
            UtErrorCode utErrorCode2 = UtErrorCode.LOCAL_CACHE_RETURN_1;
            callBack2Error(adInfo2, iTanxRequestListener2, new TanxError(requestId, utErrorCode2.getIntCode(), utErrorCode2.getMsg()));
            str2 = "";
        } else {
            this.mRequestId = adInfo2Pid.getRequestId();
            boolean z10 = false;
            for (BidInfo bidInfo2 : adInfo2Pid.getBidInfoList()) {
                String str3 = str;
                TanxSplashAd tanxSplashAd = new TanxSplashAd(this.adSlot, bidInfo2, adInfo2Pid.getRequestId(), 0, getScene());
                if (isDuringRelease(bidInfo2)) {
                    z10 = true;
                    TanxSplashUt.utSplashJsonCheck(tanxSplashAd, 0, true, 0);
                    if (isAssetExists(bidInfo2)) {
                        LogUtils.d(TAG, "chooseBrandAd: isAssetExists bidInfo = " + bidInfo2);
                        if (this.hasTimeOut) {
                            int intCode = UtErrorCode.ERROR_AD_TIME_OUT.getIntCode();
                            this.mLoadDataCode = intCode;
                            TanxSplashUt.utSplashCacheExist(tanxSplashAd, 0, false, intCode);
                            return;
                        } else {
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(new TanxSplashAd(this.adSlot, bidInfo2, this.mRequestId, 0, getScene()));
                            callBack2Succ(adInfo2Pid, iTanxRequestListener2, arrayList3);
                            TanxSplashUt.utSplashTimer(tanxSplashAd, 0, true, 0);
                            TanxSplashUt.utSplashCacheExist(tanxSplashAd, 0, true, 0);
                            return;
                        }
                    }
                } else {
                    LogUtils.d(TAG, "chooseAd: 不在投放期 bidInfo = " + bidInfo2);
                    int intCode2 = UtErrorCode.ERROR_AD_NOT_IN_DURING_RELEASE.getIntCode();
                    this.mLoadDataCode = intCode2;
                    TanxSplashUt.utSplashJsonCheck(tanxSplashAd, 0, false, intCode2);
                }
                str = str3;
            }
            str2 = str;
            this.mLoadDataCode = (z10 ? UtErrorCode.ERROR_NO_CACHED_ASSET : UtErrorCode.ERROR_NO_AD_DURING_RELEASE).getIntCode();
            TanxSplashUt.utSplashCacheExist(new TanxSplashAd(this.adSlot, null, adInfo2Pid.getRequestId(), 0, getScene()), 0, false, this.mLoadDataCode);
        }
        String requestId2 = adInfo2 != null ? adInfo2.getRequestId() : str2;
        UtErrorCode utErrorCode3 = UtErrorCode.LOCAL_CACHE_RETURN_1;
        callBack2Error(adInfo2, iTanxRequestListener2, new TanxError(requestId2, utErrorCode3.getIntCode(), utErrorCode3.getMsg()));
    }

    public void chooseRtbAd(ITanxRequestLoader.ITanxRequestListener iTanxRequestListener) {
        AdInfo adInfo2Pid = getAdInfo2Pid();
        if (adInfo2Pid != null) {
            this.mRequestId = adInfo2Pid.getRequestId();
            boolean z10 = false;
            for (BidInfo bidInfo : adInfo2Pid.getBidInfoList()) {
                TanxSplashAd tanxSplashAd = new TanxSplashAd(this.adSlot, bidInfo, adInfo2Pid.getRequestId(), 0, getScene());
                if (isDuringRelease(bidInfo)) {
                    TanxSplashUt.utSplashJsonCheck(tanxSplashAd, 0, true, 0);
                    if (isAssetExists(bidInfo)) {
                        LogUtils.d(TAG, "chooseAd: isAssetExists bidInfo = " + bidInfo);
                        if (this.hasTimeOut) {
                            int intCode = UtErrorCode.ERROR_AD_TIME_OUT.getIntCode();
                            this.mLoadDataCode = intCode;
                            TanxSplashUt.utSplashCacheExist(tanxSplashAd, 0, false, intCode);
                            return;
                        } else {
                            callBack2Succ(adInfo2Pid, iTanxRequestListener, Arrays.asList(tanxSplashAd));
                            TanxSplashUt.utSplashTimer(tanxSplashAd, 0, true, 0);
                            TanxSplashUt.utSplashCacheExist(tanxSplashAd, 0, true, 0);
                            return;
                        }
                    }
                    z10 = true;
                } else {
                    LogUtils.d(TAG, "chooseAd: 不在投放期 bidInfo = " + bidInfo);
                    int intCode2 = UtErrorCode.ERROR_AD_NOT_IN_DURING_RELEASE.getIntCode();
                    this.mLoadDataCode = intCode2;
                    TanxSplashUt.utSplashJsonCheck(tanxSplashAd, 0, false, intCode2);
                }
            }
            this.mLoadDataCode = (z10 ? UtErrorCode.ERROR_NO_CACHED_ASSET : UtErrorCode.ERROR_NO_AD_DURING_RELEASE).getIntCode();
            TanxSplashUt.utSplashCacheExist(new TanxSplashAd(this.adSlot, null, adInfo2Pid.getRequestId(), 0, getScene()), 0, false, this.mLoadDataCode);
        }
        if (this.hasTimeOut) {
            return;
        }
        this.fromType = 1;
        LogUtils.d(TAG, "获取本地缓存无缓存 开始走实时请求逻辑---------" + System.currentTimeMillis());
        super.sendRequest(this.adSlot, iTanxRequestListener, 0L);
    }

    private void deleteCachedAdInBackground() {
        tanxc_do.tanxc_do(new AdTask(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel.4
            public AnonymousClass4() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SplashAdCacheManager.getInstance().deleteCachedResponseJson();
            }
        }, "deleteCachedAdInBackground"));
    }

    private void executeBrandAdError(AdInfo adInfo, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener) {
        LogUtils.d(TAG, "executeBrandAdError: adInfo = " + adInfo);
        if (iTanxRequestListener == null) {
            LogUtils.e(TAG, "executeBrandAdError: requestListener ==null");
        } else {
            chooseBrandAd(adInfo, null, iTanxRequestListener);
        }
    }

    private void executeBrandAdSucc(AdInfo adInfo, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener) {
        for (int i10 = 0; i10 < adInfo.getSeatList().size(); i10++) {
            List<BidInfo> bidList = adInfo.getSeatList().get(i10).getBidList();
            if (bidList != null && bidList.size() > 0) {
                BidInfo bidInfo = bidList.get(0);
                LogUtils.d(TAG, "executeBrandAdSucc: rtBidInfo = " + bidInfo + "");
                if (bidInfo != null) {
                    LogUtils.d(TAG, "executeBrandAdSucc: 素材地址 = " + bidInfo.getCreativePath() + "");
                }
                chooseBrandAd(adInfo, bidInfo, iTanxRequestListener);
            }
        }
    }

    private void executeRtbAdSucc(AdInfo adInfo, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < adInfo.getSeatList().size(); i10++) {
            List<BidInfo> bidList = adInfo.getSeatList().get(i10).getBidList();
            if (bidList != null && bidList.size() > 0) {
                for (BidInfo bidInfo : bidList) {
                    LogUtils.d(TAG, "handleRequestCallback: bidInfo = " + bidInfo + "");
                    if (bidInfo != null) {
                        LogUtils.d(TAG, "handleRequestCallback: 素材地址 = " + bidInfo.getCreativePath() + "");
                    }
                    arrayList.add(new TanxSplashAd(this.adSlot, bidInfo, adInfo.getRequestId(), 1, getScene()));
                }
            }
        }
        callBack2Succ(adInfo, iTanxRequestListener, arrayList);
    }

    private AdInfo getAdInfo2Pid() {
        SplashAdCacheManager.getInstance().trimLocalCache2Json();
        TanxAdSlot tanxAdSlot = this.adSlot;
        AdInfo adInfoFromCache = getAdInfoFromCache(tanxAdSlot != null ? tanxAdSlot.getPid() : "");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("chooseAd:  hasAdInfo = ");
        sb2.append(adInfoFromCache != null);
        LogUtils.d(TAG, sb2.toString());
        if (adInfoFromCache != null && adInfoFromCache.getAdCount() > 0) {
            return adInfoFromCache;
        }
        this.mLoadDataCode = UtErrorCode.ERROR_NO_AD_ITEM.getIntCode();
        LogUtils.e("chooseAd", "chooseAd无广告节点");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.alimm.tanx.core.ad.bean.AdInfo getAdInfoFromCache(java.lang.String r11) {
        /*
            r10 = this;
            java.lang.String r0 = "SplashAdModel"
            long r1 = java.lang.System.currentTimeMillis()
            r3 = 0
            r4 = 0
            android.content.Context r5 = r10.mContext     // Catch: java.lang.Exception -> L2f
            java.lang.String r11 = com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager.getSplashAdResponseFile(r5, r11)     // Catch: java.lang.Exception -> L2f
            java.lang.String r11 = com.alimm.tanx.core.utils.FileUtils.getStrFromFile(r11)     // Catch: java.lang.Exception -> L2f
            boolean r5 = android.text.TextUtils.isEmpty(r11)     // Catch: java.lang.Exception -> L2f
            if (r5 != 0) goto L2d
            r5 = 1
            java.lang.Class<com.alimm.tanx.core.ad.bean.AdInfo> r6 = com.alimm.tanx.core.ad.bean.AdInfo.class
            java.lang.Object r11 = com.alibaba.fastjson.JSON.parseObject(r11, r6)     // Catch: java.lang.Exception -> L28
            com.alimm.tanx.core.ad.bean.AdInfo r11 = (com.alimm.tanx.core.ad.bean.AdInfo) r11     // Catch: java.lang.Exception -> L28
            com.alimm.tanx.core.ad.bean.AdInfo r3 = com.alimm.tanx.core.request.AdParse.tanxc_do(r11)     // Catch: java.lang.Exception -> L26
            goto L56
        L26:
            r3 = move-exception
            goto L32
        L28:
            r11 = move-exception
        L29:
            r9 = r3
            r3 = r11
            r11 = r9
            goto L32
        L2d:
            r5 = 0
            goto L56
        L2f:
            r11 = move-exception
            r5 = 0
            goto L29
        L32:
            java.lang.String r6 = "getAdInfoFromCache exception."
            com.alimm.tanx.core.utils.LogUtils.e(r0, r6, r3)
            com.alimm.tanx.core.ut.UtErrorCode r7 = com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR
            int r7 = r7.getIntCode()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r6)
            java.lang.String r3 = com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(r3)
            r8.append(r3)
            java.lang.String r3 = r8.toString()
            java.lang.String r6 = ""
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(r7, r0, r3, r6)
            r3 = r11
        L56:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r6 = "getAdInfoFromCache: time = "
            r11.append(r6)
            long r6 = java.lang.System.currentTimeMillis()
            long r6 = r6 - r1
            r11.append(r6)
            java.lang.String r1 = ",hasContent = "
            r11.append(r1)
            r11.append(r5)
            java.lang.String r1 = ", count = "
            r11.append(r1)
            if (r3 == 0) goto L7b
            int r4 = r3.getAdCount()
        L7b:
            r11.append(r4)
            java.lang.String r11 = r11.toString()
            com.alimm.tanx.core.utils.LogUtils.d(r0, r11)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel.getAdInfoFromCache(java.lang.String):com.alimm.tanx.core.ad.bean.AdInfo");
    }

    private void handleRequestResponse(AdInfo adInfo) {
        try {
            LogUtils.d(TAG, "handleRequestCallback: adInfo = " + adInfo + "");
            if (this.isSyncReq && !this.hasTimeOut) {
                if (adInfo != null && adInfo.getSeatList() != null && adInfo.getSeatList().size() > 0 && adInfo.getSeatList().get(0) != null && adInfo.getSeatList().get(0).getBidList() != null && adInfo.getSeatList().get(0).getBidList().size() > 0) {
                    if (this.adSlot.isBrandAd()) {
                        executeBrandAdSucc(adInfo, this.requestListener);
                    } else {
                        executeRtbAdSucc(adInfo, this.requestListener);
                    }
                }
                if (this.adSlot.isBrandAd()) {
                    executeBrandAdError(adInfo, this.requestListener);
                } else {
                    callBack2Error(adInfo, this.requestListener, new TanxError(adInfo != null ? adInfo.getRequestId() : "", TanxError.ERROR_ADINFO_ADCOUNT_NULL));
                }
            }
            if (this.adSlot.isBrandAd() && this.isSyncReq) {
                return;
            }
            cacheAndManageAsset(adInfo);
        } catch (Exception e10) {
            LogUtils.e(e10);
            callBack2Error(adInfo, this.requestListener, new TanxError(adInfo != null ? adInfo.getRequestId() : "", "handleRequestResponse" + UtErrorCode.CRASH_ERROR.getMsg()));
        }
    }

    public boolean isAssetExists(@NonNull BidInfo bidInfo) {
        return SplashAdCacheManager.getInstance().isAssetCached(bidInfo, true);
    }

    private boolean isDuringRelease(@NonNull BidInfo bidInfo) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return bidInfo.getReleaseStartTime() <= currentTimeMillis && bidInfo.getReleaseEndTime() >= currentTimeMillis;
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel
    public void callBackError(ITanxRequestLoader.ITanxRequestListener iTanxRequestListener, TanxError tanxError) {
        TanxAdSlot tanxAdSlot = this.adSlot;
        if (tanxAdSlot != null && tanxAdSlot.isBrandAd() && this.isSyncReq) {
            executeBrandAdError(null, iTanxRequestListener);
        } else {
            super.callBackError(iTanxRequestListener, tanxError);
        }
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel
    public String getScene() {
        return TanxAdType.SPLASH_STRING;
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel
    public void onSuccess(AdInfo adInfo) {
        handleRequestResponse(adInfo);
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel
    public void requestSucc(AdInfo adInfo) {
        if (this.isCancel) {
            return;
        }
        checkSuccess(adInfo);
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel, com.alimm.tanx.core.ad.listener.model.IModel
    public void sendRequest(boolean z10, TanxAdSlot tanxAdSlot, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener) {
        sendRequest(z10, tanxAdSlot, iTanxRequestListener, 0L);
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel
    public void timerCancelNotify(AdInfo adInfo, boolean z10, int i10) {
        TanxSplashAd tanxSplashAd = null;
        r0 = null;
        BidInfo bidInfo = null;
        if (adInfo != null) {
            if (adInfo.getBidInfoList() != null && adInfo.getBidInfoList().size() > 0) {
                bidInfo = adInfo.getBidInfoList().get(0);
            }
            tanxSplashAd = new TanxSplashAd(this.adSlot, bidInfo, adInfo.getRequestId(), 0, getScene());
        }
        TanxSplashUt.utSplashTimer(tanxSplashAd, this.fromType, z10, i10);
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel, com.alimm.tanx.core.ad.listener.model.IModel
    public void sendRequest(boolean z10, TanxAdSlot tanxAdSlot, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener, long j10) {
        this.adSlot = tanxAdSlot;
        this.isSyncReq = z10;
        this.requestListener = iTanxRequestListener;
        if (z10) {
            startTimer(j10);
            tanxc_do.tanxc_do(new AdTask(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel.1
                final /* synthetic */ TanxAdSlot tanxc_do;
                final /* synthetic */ ITanxRequestLoader.ITanxRequestListener tanxc_if;

                public AnonymousClass1(TanxAdSlot tanxAdSlot2, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener2) {
                    tanxAdSlot = tanxAdSlot2;
                    iTanxRequestListener = iTanxRequestListener2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    String[] split;
                    long currentTimeMillis = System.currentTimeMillis();
                    LogUtils.d(SplashAdModel.TAG, "开始获取本地缓存数据 ---" + currentTimeMillis);
                    if (!tanxAdSlot.isBrandAd()) {
                        SplashAdModel.this.chooseRtbAd(iTanxRequestListener);
                        return;
                    }
                    if (!tanxAdSlot.isRtSelection()) {
                        SplashAdModel.this.chooseBrandAd(null, null, iTanxRequestListener);
                        return;
                    }
                    tanxAdSlot.setRealtimeRequest(Boolean.TRUE);
                    String advIds = SplashAdCacheManager.getInstance().getAdvIds(currentTimeMillis);
                    ArrayList arrayList = new ArrayList();
                    if (!TextUtils.isEmpty(advIds) && (split = advIds.split(",")) != null && split.length > 0) {
                        for (String str : split) {
                            arrayList.add(new TopCreative(str));
                        }
                    }
                    tanxAdSlot.setTopCreatives(arrayList);
                    SplashAdModel.super.sendRequest(tanxAdSlot, iTanxRequestListener, 0L);
                }
            }, "sendRequest", new AdTask.onErrorListener() { // from class: com.alimm.tanx.core.ad.ad.splash.model.SplashAdModel.2
                final /* synthetic */ ITanxRequestLoader.ITanxRequestListener tanxc_do;

                public AnonymousClass2(ITanxRequestLoader.ITanxRequestListener iTanxRequestListener2) {
                    iTanxRequestListener = iTanxRequestListener2;
                }

                @Override // com.alimm.tanx.core.common.AdTask.onErrorListener
                public void onError(String str) {
                    SplashAdModel.this.callBack2Error(null, iTanxRequestListener, new TanxError(str));
                }
            }));
            return;
        }
        tanxAdSlot2.setRealtimeRequest(Boolean.FALSE);
        super.sendRequest(tanxAdSlot2, iTanxRequestListener2, j10);
        LogUtils.d(TAG, "发起预请求 timeOut=" + j10);
    }
}
