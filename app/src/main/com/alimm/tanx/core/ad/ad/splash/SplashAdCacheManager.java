package com.alimm.tanx.core.ad.ad.splash;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.listener.bean.IBidInfo;
import com.alimm.tanx.core.net.NetWorkManager;
import com.alimm.tanx.core.net.bean.DownLoadRequestBean;
import com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.FileUtils;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.MD5Utils;
import com.alimm.tanx.core.utils.NetWorkUtil;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.utils.Utils;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class SplashAdCacheManager implements NotConfused {
    private static final String MAIN_PAGE = "index.html";
    private static final String PREF_KEY_PRE_REQUEST_ID = "pre_request_id";
    private static final String PREF_LOCAL_ADV_IDS = "tanx_adsdk_local_adv_ids";
    private static final String SPLASH_AD_CACHE_PATH = "ad/splash";
    private static final String SPLASH_AD_RESPONSE_CACHE_PATH = "ad/response";
    private static final String SPLASH_AD_ZIP_PATH = "zip";
    private static final String TAG = "SplashAdCacheManager";
    private static String sSplashAdCachePath;
    private static String sSplashAdResponseDir;
    private static String sSplashAdResponseFile;
    private static String sSplashAdZipCachePath;
    private final int DEFAULT_AD_EXPIRED_DAYS;
    private final int DEFAULT_EXPIRED_DAYS;
    private final int DEFAULT_MAX_AD_COUNT;
    private final Context mContext;

    /* renamed from: com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager$1 */
    public static class AnonymousClass1 implements Comparator<File> {
        @Override // java.util.Comparator
        /* renamed from: tanxc_do */
        public int compare(File file, File file2) {
            if (file == null && file2 == null) {
                return 0;
            }
            if (file == null && file2 != null) {
                return -1;
            }
            if (file != null && file2 == null) {
                return 1;
            }
            if (file.lastModified() < file2.lastModified()) {
                return -1;
            }
            return file.lastModified() == file2.lastModified() ? 0 : 1;
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager$2 */
    public class AnonymousClass2 implements OnDownloadListener {
        final /* synthetic */ AssetDownloadCallback tanxc_do;

        public AnonymousClass2(AssetDownloadCallback assetDownloadCallback) {
            assetDownloadCallback = assetDownloadCallback;
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener
        public void onDownLoadTotal(long j10) {
            LogUtils.d("onDownLoadTotal", j10 + "");
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener
        public void onDownloadFailed(int i10, String str) {
            AssetDownloadCallback assetDownloadCallback = assetDownloadCallback;
            if (assetDownloadCallback != null) {
                assetDownloadCallback.onFail(i10, str);
            }
            LogUtils.d("onDownloadFailed", "code:" + i10 + "  msg:" + str);
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener
        public void onDownloadSuccess(File file) {
            LogUtils.d("onDownloadSuccess" + file.getAbsolutePath(), new String[0]);
            AssetDownloadCallback assetDownloadCallback = assetDownloadCallback;
            if (assetDownloadCallback != null) {
                assetDownloadCallback.onSuccess(file);
            }
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener
        public void onDownloading(int i10) {
            LogUtils.d("onDownloading", i10 + "");
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager$3 */
    public class AnonymousClass3 implements AssetDownloadCallback {
        final /* synthetic */ List tanxc_do;
        final /* synthetic */ DownloadCacheCallback tanxc_if;

        public AnonymousClass3(List list, DownloadCacheCallback downloadCacheCallback) {
            list = list;
            downloadCacheCallback = downloadCacheCallback;
        }

        @Override // com.alimm.tanx.core.ad.ad.splash.AssetDownloadCallback
        public void onFail(int i10, String str) {
            LogUtils.e(SplashAdCacheManager.TAG, "下载失败 code:" + i10 + " msg:" + str);
            DownloadCacheCallback downloadCacheCallback = downloadCacheCallback;
            if (downloadCacheCallback != null) {
                downloadCacheCallback.onFail(i10, str);
            }
        }

        @Override // com.alimm.tanx.core.ad.ad.splash.AssetDownloadCallback
        public void onSuccess(File file) {
            SplashAdCacheManager splashAdCacheManager = SplashAdCacheManager.this;
            splashAdCacheManager.handleAssetDownloadFinished(splashAdCacheManager.mContext, list);
            DownloadCacheCallback downloadCacheCallback = downloadCacheCallback;
            if (downloadCacheCallback != null) {
                downloadCacheCallback.onSuccess(file);
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager$4 */
    public class AnonymousClass4 implements FileUtils.FileKeepRule {
        public AnonymousClass4() {
        }

        @Override // com.alimm.tanx.core.utils.FileUtils.FileKeepRule
        public boolean needKept(String str) {
            return false;
        }
    }

    public static class SingletonHolder implements NotConfused {
        static final SplashAdCacheManager INSTANCE = new SplashAdCacheManager();

        private SingletonHolder() {
        }
    }

    public /* synthetic */ SplashAdCacheManager(AnonymousClass1 anonymousClass1) {
        this();
    }

    private void deleteAssetForExpired(@NonNull Context context, int i10) {
        try {
            FileUtils.deleteExpiredFiles(getSplashAdCacheDirPath(context), i10, new FileUtils.FileKeepRule() { // from class: com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager.4
                public AnonymousClass4() {
                }

                @Override // com.alimm.tanx.core.utils.FileUtils.FileKeepRule
                public boolean needKept(String str) {
                    return false;
                }
            });
        } catch (Exception e10) {
            LogUtils.e(TAG, "deleteAssetForExpired: exception.", e10);
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), TAG, "deleteAssetForExpired: exception." + LogUtils.getStackTraceMessage(e10), "");
        }
    }

    private void deleteFileForCacheFull(@NonNull Context context, int i10, boolean z10) {
        List<File> files = FileUtils.getFiles(z10 ? getSplashAdResponseDir(context) : getSplashAdCacheDirPath(context));
        int size = files.size();
        LogUtils.d(TAG, "deleteFileForCacheFull: maxCacheNum = " + i10 + ", fileCount = " + size);
        if (size >= i10) {
            sortFilesByModifyTime(files);
            int i11 = size - (i10 / 2);
            LogUtils.d(TAG, "deleteFileForCacheFull: deleteFileCount = " + i11);
            for (int i12 = 0; i12 < i11; i12++) {
                File file = files.get(i12);
                LogUtils.d(TAG, "deleteFileForCacheFull: deleteFile = " + file.getName());
                FileUtils.deleteFile(file);
            }
        }
    }

    private void downLoadItem(String str, String str2, String str3, boolean z10, boolean z11, AssetDownloadCallback assetDownloadCallback) {
        LogUtils.d(TAG, "下载素材 downLoadItem: rs = " + str3 + ", name = " + str2 + ", videoType = " + z10);
        if (!z10 || !z11 || NetWorkUtil.getNetworkType(TanxCoreSdk.getApplication()).getKey() == 1) {
            NetWorkManager.getInstance().sendHttpDownload(new DownLoadRequestBean().setPath(str).setFileName(str2).setTag(str2).setUrl(str3), new OnDownloadListener() { // from class: com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager.2
                final /* synthetic */ AssetDownloadCallback tanxc_do;

                public AnonymousClass2(AssetDownloadCallback assetDownloadCallback2) {
                    assetDownloadCallback = assetDownloadCallback2;
                }

                @Override // com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener
                public void onDownLoadTotal(long j10) {
                    LogUtils.d("onDownLoadTotal", j10 + "");
                }

                @Override // com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener
                public void onDownloadFailed(int i10, String str4) {
                    AssetDownloadCallback assetDownloadCallback2 = assetDownloadCallback;
                    if (assetDownloadCallback2 != null) {
                        assetDownloadCallback2.onFail(i10, str4);
                    }
                    LogUtils.d("onDownloadFailed", "code:" + i10 + "  msg:" + str4);
                }

                @Override // com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener
                public void onDownloadSuccess(File file) {
                    LogUtils.d("onDownloadSuccess" + file.getAbsolutePath(), new String[0]);
                    AssetDownloadCallback assetDownloadCallback2 = assetDownloadCallback;
                    if (assetDownloadCallback2 != null) {
                        assetDownloadCallback2.onSuccess(file);
                    }
                }

                @Override // com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener
                public void onDownloading(int i10) {
                    LogUtils.d("onDownloading", i10 + "");
                }
            });
        } else if (assetDownloadCallback2 != null) {
            assetDownloadCallback2.onFail(UtErrorCode.NETWORK_DOWNLOAD_EXCEPTION.getIntCode(), "当前不是wifi环境");
        }
    }

    public static SplashAdCacheManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static String getSplashAdCacheDirPath(@NonNull Context context) {
        if (TextUtils.isEmpty(sSplashAdCachePath)) {
            File externalDir = FileUtils.getExternalDir(context, 0);
            if (externalDir != null) {
                sSplashAdCachePath = FileUtils.joinPath(externalDir.getAbsolutePath(), SPLASH_AD_CACHE_PATH);
            } else {
                File externalDir2 = FileUtils.getExternalDir(context, 1);
                if (externalDir2 != null) {
                    sSplashAdCachePath = FileUtils.joinPath(externalDir2.getAbsolutePath(), SPLASH_AD_CACHE_PATH);
                }
            }
            LogUtils.d(TAG, "getSplashAdCacheDirPath: path = " + sSplashAdCachePath);
        }
        return sSplashAdCachePath;
    }

    public static String getSplashAdResponseDir(@NonNull Context context) {
        try {
            if (TextUtils.isEmpty(sSplashAdResponseDir)) {
                File externalDir = FileUtils.getExternalDir(context, 0);
                if (externalDir != null) {
                    sSplashAdResponseDir = FileUtils.joinPath(externalDir.getAbsolutePath(), SPLASH_AD_RESPONSE_CACHE_PATH);
                } else {
                    File externalDir2 = FileUtils.getExternalDir(context, 1);
                    if (externalDir2 != null) {
                        sSplashAdResponseDir = FileUtils.joinPath(externalDir2.getAbsolutePath(), SPLASH_AD_RESPONSE_CACHE_PATH);
                    }
                }
                LogUtils.d(TAG, "getSplashAdResponseDir: sSplashAdResponseDir = " + sSplashAdResponseDir);
            }
        } catch (Exception e10) {
            LogUtils.e(e10);
        }
        return sSplashAdResponseDir;
    }

    public static String getSplashAdResponseFile(@NonNull Context context, String str) {
        try {
        } catch (Exception e10) {
            LogUtils.e(e10);
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(sSplashAdResponseFile) || !sSplashAdResponseFile.contains(str)) {
            if (TextUtils.isEmpty(sSplashAdResponseDir)) {
                getSplashAdResponseDir(context);
            }
            sSplashAdResponseFile = FileUtils.joinPath(sSplashAdResponseDir, str);
            LogUtils.d(TAG, "getSplashAdResponseFile: fileName = " + sSplashAdResponseFile);
        }
        return sSplashAdResponseFile;
    }

    public static String getSplashAdZipCacheDirPath(@NonNull Context context) {
        if (TextUtils.isEmpty(sSplashAdZipCachePath)) {
            sSplashAdZipCachePath = FileUtils.joinPath(getSplashAdCacheDirPath(context), "zip");
        }
        return sSplashAdZipCachePath;
    }

    public static String getSplashCacheFile(@NonNull Context context, String str) {
        if (!FileUtils.exists(getSplashAdCacheDirPath(context))) {
            return null;
        }
        String joinPath = FileUtils.joinPath(getSplashAdCacheDirPath(context), str);
        if (FileUtils.exists(joinPath)) {
            return joinPath;
        }
        return null;
    }

    public void handleAssetDownloadFinished(@NonNull Context context, @NonNull List<? extends IBidInfo> list) {
        HashMap hashMap = new HashMap(16);
        for (IBidInfo iBidInfo : list) {
            if (iBidInfo != null && isAssetCached(iBidInfo)) {
                String formatTimeInMillis = Utils.formatTimeInMillis(iBidInfo.getReleaseStartTime() * 1000, "yyyy-MM-dd");
                String str = hashMap.get(formatTimeInMillis);
                if (TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(iBidInfo.getCacheCreativeId())) {
                        hashMap.put(formatTimeInMillis, iBidInfo.getCacheCreativeId());
                    }
                } else if (!TextUtils.isEmpty(iBidInfo.getCacheCreativeId())) {
                    hashMap.put(formatTimeInMillis, str + "," + iBidInfo.getCacheCreativeId());
                }
            }
        }
        setCacheAdvIds(hashMap);
    }

    private void setCacheAdvIds(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        SharedPreferences.Editor edit = this.mContext.getSharedPreferences(PREF_LOCAL_ADV_IDS, 0).edit();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            edit.putString(entry.getKey(), entry.getValue());
            LogUtils.d(TAG, "setCacheAdvIds: date = " + entry.getKey() + ", cached_ids = " + entry.getValue());
        }
        edit.apply();
    }

    private static void sortFilesByModifyTime(List<File> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        try {
            Collections.sort(list, new Comparator<File>() { // from class: com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager.1
                @Override // java.util.Comparator
                /* renamed from: tanxc_do */
                public int compare(File file, File file2) {
                    if (file == null && file2 == null) {
                        return 0;
                    }
                    if (file == null && file2 != null) {
                        return -1;
                    }
                    if (file != null && file2 == null) {
                        return 1;
                    }
                    if (file.lastModified() < file2.lastModified()) {
                        return -1;
                    }
                    return file.lastModified() == file2.lastModified() ? 0 : 1;
                }
            });
        } catch (IllegalArgumentException e10) {
            LogUtils.d(TAG, "sortFilesByModifyTime: exception.", e10);
        }
    }

    public void clearAllCachedAsset() {
        LogUtils.d(TAG, "clearAllCachedAsset.");
        FileUtils.delete(getSplashAdCacheDirPath(this.mContext));
    }

    public void clearCachedAdvIds() {
        LogUtils.d(TAG, "clearCachedAdvIds.");
        SharedPreferences.Editor edit = this.mContext.getSharedPreferences(PREF_LOCAL_ADV_IDS, 0).edit();
        edit.clear();
        edit.apply();
    }

    public void deleteAllCachedFiles() {
        LogUtils.d(TAG, "deleteAllCachedFiles.");
        deleteCachedResponseJson();
        clearAllCachedAsset();
        clearCachedAdvIds();
    }

    public void deleteCachedResponseJson() {
        LogUtils.d(TAG, "deleteCachedResponseJson.");
        FileUtils.delete(getSplashAdCacheDirPath(this.mContext));
    }

    public void downloadAd2Cache(TanxAdSlot tanxAdSlot, List<? extends IBidInfo> list, DownloadCacheCallback downloadCacheCallback) {
        downloadAdAsset(tanxAdSlot, list, new AssetDownloadCallback() { // from class: com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager.3
            final /* synthetic */ List tanxc_do;
            final /* synthetic */ DownloadCacheCallback tanxc_if;

            public AnonymousClass3(List list2, DownloadCacheCallback downloadCacheCallback2) {
                list = list2;
                downloadCacheCallback = downloadCacheCallback2;
            }

            @Override // com.alimm.tanx.core.ad.ad.splash.AssetDownloadCallback
            public void onFail(int i10, String str) {
                LogUtils.e(SplashAdCacheManager.TAG, "下载失败 code:" + i10 + " msg:" + str);
                DownloadCacheCallback downloadCacheCallback2 = downloadCacheCallback;
                if (downloadCacheCallback2 != null) {
                    downloadCacheCallback2.onFail(i10, str);
                }
            }

            @Override // com.alimm.tanx.core.ad.ad.splash.AssetDownloadCallback
            public void onSuccess(File file) {
                SplashAdCacheManager splashAdCacheManager = SplashAdCacheManager.this;
                splashAdCacheManager.handleAssetDownloadFinished(splashAdCacheManager.mContext, list);
                DownloadCacheCallback downloadCacheCallback2 = downloadCacheCallback;
                if (downloadCacheCallback2 != null) {
                    downloadCacheCallback2.onSuccess(file);
                }
            }
        });
    }

    public void downloadAdAsset(TanxAdSlot tanxAdSlot, List<? extends IBidInfo> list, AssetDownloadCallback assetDownloadCallback) {
        if (list == null || list.isEmpty()) {
            LogUtils.d(TAG, "downloadAdAsset no adv information.");
            return;
        }
        String splashAdCacheDirPath = getSplashAdCacheDirPath(this.mContext);
        LogUtils.d(TAG, "downloadAdAsset cachePath=." + splashAdCacheDirPath);
        for (IBidInfo iBidInfo : list) {
            if (iBidInfo != null && !isAssetCached(iBidInfo)) {
                if (iBidInfo.getCreativeType() == 4) {
                    String creativeVideoPath = iBidInfo.getCreativeVideoPath();
                    String creativeVideoName = iBidInfo.getCreativeVideoName();
                    if (TextUtils.isEmpty(creativeVideoPath) || TextUtils.isEmpty(creativeVideoName)) {
                        String creativePath = iBidInfo.getCreativePath();
                        String creativeName = iBidInfo.getCreativeName();
                        if (!TextUtils.isEmpty(creativePath) && !TextUtils.isEmpty(creativeName)) {
                            downLoadItem(splashAdCacheDirPath, creativeName, creativePath, false, false, assetDownloadCallback);
                        }
                    } else {
                        downLoadItem(splashAdCacheDirPath, creativeVideoName, creativeVideoPath, true, tanxAdSlot.isCacheUnderWifi(), assetDownloadCallback);
                        String creativePath2 = iBidInfo.getCreativePath();
                        String creativeName2 = iBidInfo.getCreativeName();
                        if (!TextUtils.isEmpty(creativePath2)) {
                            downLoadItem(splashAdCacheDirPath, creativeName2, creativePath2, false, false, null);
                        }
                    }
                } else {
                    String creativePath3 = iBidInfo.getCreativePath();
                    String creativeName3 = iBidInfo.getCreativeName();
                    if (!TextUtils.isEmpty(creativePath3) && !TextUtils.isEmpty(creativeName3)) {
                        downLoadItem(splashAdCacheDirPath, creativeName3, creativePath3, true, tanxAdSlot.isCacheUnderWifi(), assetDownloadCallback);
                    }
                }
            }
        }
    }

    public String getAdvIds(long j10) {
        String formatTimeInMillis = Utils.formatTimeInMillis(j10, "yyyy-MM-dd");
        String string = this.mContext.getSharedPreferences(PREF_LOCAL_ADV_IDS, 0).getString(formatTimeInMillis, "");
        LogUtils.d(TAG, "getAdvIds: date = " + formatTimeInMillis + ", advIds = " + string);
        return string;
    }

    public String getPreRequestId() {
        return this.mContext.getSharedPreferences(PREF_LOCAL_ADV_IDS, 0).getString(PREF_KEY_PRE_REQUEST_ID, "");
    }

    public boolean isAssetCached(@NonNull IBidInfo iBidInfo) {
        return isAssetCached(iBidInfo, false);
    }

    public boolean isFileMd5Matched(BidInfo bidInfo, String str) {
        if (bidInfo != null && !TextUtils.isEmpty(bidInfo.getCreativeMd5()) && !TextUtils.isEmpty(str)) {
            LogUtils.d(TAG, "isFileMd5Matched bidInfo.getCreativeMd5= " + bidInfo.getCreativeMd5() + " ---getFilePathMD5String= " + MD5Utils.getFilePathMD5String(str));
            return bidInfo.getCreativeMd5().equalsIgnoreCase(MD5Utils.getFilePathMD5String(str));
        }
        LogUtils.d(TAG, "isFileMd5Matched MD5校验是否通过:false ---bidInfo = " + bidInfo);
        if (bidInfo != null && TextUtils.isEmpty(bidInfo.getCreativeMd5())) {
            LogUtils.d(TAG, "isFileMd5Matched MD5校验是否通过:bidInfo.getCreativeMd5() 为空");
        }
        if (!TextUtils.isEmpty(str)) {
            return false;
        }
        LogUtils.d(TAG, "isFileMd5Matched MD5校验是否通过:本地缓存文件名称MD5 为空");
        return false;
    }

    public void setPreRequestId(String str) {
        LogUtils.d(TAG, "setPreRequestId: preRequestId = " + str);
        SharedPreferences.Editor edit = this.mContext.getSharedPreferences(PREF_LOCAL_ADV_IDS, 0).edit();
        edit.putString(PREF_KEY_PRE_REQUEST_ID, str);
        edit.apply();
    }

    public void trimLocalCache() {
        deleteAssetForExpired(this.mContext, 7);
        deleteFileForCacheFull(this.mContext, 18, false);
        deleteFileForCacheFull(this.mContext, 18, true);
    }

    public void trimLocalCache2Json() {
        FileUtils.deleteExpiredFile(getSplashAdResponseDir(this.mContext), 7, (FileUtils.FileKeepRule) null);
    }

    private SplashAdCacheManager() {
        this.DEFAULT_EXPIRED_DAYS = 7;
        this.DEFAULT_AD_EXPIRED_DAYS = 7;
        this.DEFAULT_MAX_AD_COUNT = 18;
        this.mContext = TanxCoreSdk.getApplication();
    }

    public boolean isAssetCached(@NonNull IBidInfo iBidInfo, boolean z10) {
        if (iBidInfo == null) {
            return false;
        }
        try {
            if (iBidInfo.getCreativeType() != 4) {
                String creativeName = iBidInfo.getCreativeName();
                String splashCacheFile = getSplashCacheFile(this.mContext, creativeName);
                LogUtils.d(TAG, "isAssetCached: filePath = " + splashCacheFile + ", replaceAssetPath = " + z10 + ", creativeName = " + creativeName);
                if (TextUtils.isEmpty(splashCacheFile)) {
                    return false;
                }
                if (z10) {
                    iBidInfo.setCreativePath(splashCacheFile);
                }
                iBidInfo.setCreativeType(2);
                return true;
            }
            String creativeVideoName = iBidInfo.getCreativeVideoName();
            String splashCacheFile2 = getSplashCacheFile(this.mContext, creativeVideoName);
            LogUtils.d(TAG, "isAssetCached: filePath = " + splashCacheFile2 + ", replaceAssetPath = " + z10 + ", creativeName = " + creativeVideoName);
            if (!TextUtils.isEmpty(splashCacheFile2)) {
                if (z10) {
                    iBidInfo.setCreativeVideoPath(splashCacheFile2);
                }
                return true;
            }
            String creativeName2 = iBidInfo.getCreativeName();
            String splashCacheFile3 = getSplashCacheFile(this.mContext, creativeName2);
            LogUtils.d(TAG, "isAssetCached: filePath = " + splashCacheFile3 + ", replaceAssetPath = " + z10 + ", creativeName = " + creativeName2);
            if (TextUtils.isEmpty(splashCacheFile3)) {
                return false;
            }
            if (z10) {
                iBidInfo.setCreativePath(splashCacheFile3);
            }
            iBidInfo.setCreativeType(2);
            return true;
        } catch (Exception e10) {
            LogUtils.e(e10);
            return false;
        }
    }
}
