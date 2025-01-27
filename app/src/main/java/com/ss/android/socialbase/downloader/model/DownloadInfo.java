package com.ss.android.socialbase.downloader.model;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import b.b.a.b.b;
import com.ss.android.socialbase.downloader.constants.AsyncHandleStatus;
import com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.constants.RetryDelayStatus;
import com.ss.android.socialbase.downloader.constants.SpJsonConstants;
import com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class DownloadInfo implements Parcelable {
    public static final Parcelable.Creator<DownloadInfo> CREATOR = new Parcelable.Creator<DownloadInfo>() { // from class: com.ss.android.socialbase.downloader.model.DownloadInfo.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public DownloadInfo createFromParcel(Parcel parcel) {
            return new DownloadInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DownloadInfo[] newArray(int i2) {
            return new DownloadInfo[i2];
        }
    };
    private static final int DEFAULT_MAX_PROCESS_POST_COUNT = 100;
    private static final long DEFAULT_MIN_BYTES_INTERVAL = 1048576;
    private static final int RESERVE_STATUS_NEVER = 0;
    private static final int RESERVE_STATUS_NOW = 2;
    private static final int RESERVE_STATUS_ONCE = 1;
    private static final String TAG = "DownloadInfo";
    private boolean addListenerToSameTask;
    private AtomicLong allConnectTime;
    private int appVersionCode;
    private AsyncHandleStatus asyncHandleStatus;
    private boolean autoResumed;
    private int backUpUrlRetryCount;
    private boolean backUpUrlUsed;
    private List<String> backUpUrls;
    private String backUpUrlsStr;
    private int bindValueCount;
    private ByteInvalidRetryStatus byteInvalidRetryStatus;
    private int chunkCount;
    private boolean chunkDowngradeRetryUsed;
    private int curBackUpUrlIndex;
    private AtomicLong curBytes;
    private int curRetryTime;
    private JSONObject dbJsonData;
    private String dbJsonDataString;
    private boolean deleteCacheIfCheckFailed;
    private boolean distinctDirectory;
    private long downloadTime;
    private String eTag;
    private EnqueueType enqueueType;
    private StringBuffer errorBytesLog;
    private boolean expiredRedownload;
    private String extra;
    private List<HttpHeader> extraHeaders;
    private int[] extraMonitorStatus;
    private BaseException failedException;
    private String filePackageName;
    private List<String> forbiddenBackupUrls;
    private boolean force;
    private boolean forceIgnoreRecommendSize;
    private boolean headConnectionAvailable;
    private String headConnectionException;
    private int httpStatusCode;
    private String httpStatusMessage;
    private boolean httpsToHttpRetryUsed;
    private String iconUrl;
    private int id;
    private boolean ignoreDataVerify;
    private Boolean isAutoInstallWithoutNotification;
    private boolean isFirstDownload;
    private boolean isFirstSuccess;
    private boolean isForbiddenRetryed;
    private volatile boolean isSaveTempFile;
    private AtomicLong lastNotifyProgressTime;
    private boolean mDownloadFromReserveWifi;
    private int maxBytes;
    private int maxProgressCount;
    private String md5;
    private String mimeType;
    private int minProgressTimeMsInterval;
    private String monitorScene;
    private String name;
    private boolean needChunkDowngradeRetry;
    private boolean needDefaultHttpServiceBackUp;
    private boolean needHttpsToHttpRetry;
    private boolean needIndependentProcess;
    private boolean needPostProgress;
    private boolean needRetryDelay;
    private boolean needReuseChunkRunnable;
    private boolean needReuseFirstConnection;
    private boolean needSDKMonitor;
    private String networkQuality;
    private int notificationVisibility;
    private boolean onlyWifi;
    private boolean openLimitSpeed;
    private String[] outIp;
    private int[] outSize;
    private SoftReference<PackageInfo> packageInfoRef;
    private String packageName;
    private long realDownloadTime;
    private long realStartDownloadTime;
    private int retryCount;
    private RetryDelayStatus retryDelayStatus;
    private String retryDelayTimeArray;

    @Deprecated
    private int retryScheduleMinutes;
    private String savePath;
    private boolean showNotification;
    private boolean showNotificationForAutoResumed;
    private boolean showNotificationForNetworkResumed;
    private JSONObject spData;
    private long startDownloadTime;
    private AtomicInteger status;
    private int statusAtDbInit;
    private boolean successByCache;
    private boolean supportPartial;
    private String taskId;
    private ConcurrentHashMap<String, Object> tempCacheData;
    private volatile List<ITempFileSaveCompleteCallback> tempFileSaveCompleteCallbacks;
    private String tempPath;
    private long throttleNetSpeed;
    private String title;
    private long totalBytes;
    private long ttnetProtectTimeout;
    private String url;

    /* renamed from: com.ss.android.socialbase.downloader.model.DownloadInfo$1 */
    static class AnonymousClass1 implements Parcelable.Creator<DownloadInfo> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public DownloadInfo createFromParcel(Parcel parcel) {
            return new DownloadInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DownloadInfo[] newArray(int i2) {
            return new DownloadInfo[i2];
        }
    }

    /* synthetic */ DownloadInfo(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private void convertEnqueueType(int i2) {
        EnqueueType enqueueType = EnqueueType.ENQUEUE_HEAD;
        if (i2 == enqueueType.ordinal()) {
            this.enqueueType = enqueueType;
            return;
        }
        EnqueueType enqueueType2 = EnqueueType.ENQUEUE_TAIL;
        if (i2 == enqueueType2.ordinal()) {
            this.enqueueType = enqueueType2;
        } else {
            this.enqueueType = EnqueueType.ENQUEUE_NONE;
        }
    }

    private void convertRetryDelayStatus(int i2) {
        RetryDelayStatus retryDelayStatus = RetryDelayStatus.DELAY_RETRY_WAITING;
        if (i2 == retryDelayStatus.ordinal()) {
            this.retryDelayStatus = retryDelayStatus;
            return;
        }
        RetryDelayStatus retryDelayStatus2 = RetryDelayStatus.DELAY_RETRY_DOWNLOADING;
        if (i2 == retryDelayStatus2.ordinal()) {
            this.retryDelayStatus = retryDelayStatus2;
            return;
        }
        RetryDelayStatus retryDelayStatus3 = RetryDelayStatus.DELAY_RETRY_DOWNLOADED;
        if (i2 == retryDelayStatus3.ordinal()) {
            this.retryDelayStatus = retryDelayStatus3;
        } else {
            this.retryDelayStatus = RetryDelayStatus.DELAY_RETRY_NONE;
        }
    }

    private JSONObject convertStrToJson(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new JSONObject(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private void ensureDBJsonData() {
        if (this.dbJsonData == null) {
            synchronized (this) {
                if (this.dbJsonData == null) {
                    try {
                        if (TextUtils.isEmpty(this.dbJsonDataString)) {
                            this.dbJsonData = new JSONObject();
                        } else {
                            this.dbJsonData = new JSONObject(this.dbJsonDataString);
                            this.dbJsonDataString = null;
                        }
                    } catch (Throwable unused) {
                        this.dbJsonData = new JSONObject();
                    }
                }
            }
        }
    }

    private void ensureSpData() {
        if (this.spData == null) {
            Context appContext = DownloadComponentManager.getAppContext();
            if (appContext != null) {
                String string = appContext.getSharedPreferences(DownloadConstants.SP_DOWNLOAD_INFO, 0).getString(Long.toString(getId()), "");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        this.spData = new JSONObject(string);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            if (this.spData == null) {
                this.spData = new JSONObject();
            }
        }
    }

    private void ensureTempCacheData() {
        if (this.tempCacheData == null) {
            synchronized (this) {
                if (this.tempCacheData == null) {
                    this.tempCacheData = new ConcurrentHashMap<>();
                }
            }
        }
    }

    private String getBackUpUrlsStr() {
        List<String> list;
        if (this.backUpUrlsStr == null && (list = this.backUpUrls) != null && !list.isEmpty()) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (String str : this.backUpUrls) {
                    if (!TextUtils.isEmpty(str)) {
                        jSONArray.put(str);
                    }
                }
                this.backUpUrlsStr = jSONArray.toString();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (this.backUpUrlsStr == null) {
            this.backUpUrlsStr = "";
        }
        return this.backUpUrlsStr;
    }

    private String getDBJsonDataString() {
        String jSONObject;
        String str = this.dbJsonDataString;
        if (str != null) {
            return str;
        }
        ensureDBJsonData();
        synchronized (this.dbJsonData) {
            jSONObject = this.dbJsonData.toString();
            this.dbJsonDataString = jSONObject;
        }
        return jSONObject;
    }

    private int getReserveWifiStatus() {
        ensureSpData();
        try {
            return this.spData.optInt("pause_reserve_on_wifi", 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    private void mergeAuxiliaryJSONObject(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        ensureDBJsonData();
        synchronized (this.dbJsonData) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object opt = jSONObject.opt(next);
                    if (!this.dbJsonData.has(next) && opt != null) {
                        this.dbJsonData.put(next, opt);
                    }
                }
            } catch (Exception unused) {
            }
            this.dbJsonDataString = null;
        }
        parseMonitorSetting();
    }

    private void parseMonitorSetting() {
        ensureDBJsonData();
        this.needSDKMonitor = this.dbJsonData.optBoolean(DbJsonConstants.NEED_SDK_MONITOR, false);
        this.monitorScene = this.dbJsonData.optString(DbJsonConstants.MONITOR_SCENE, "");
        JSONArray optJSONArray = this.dbJsonData.optJSONArray(DbJsonConstants.EXTRA_MONITOR_STATUS);
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        this.extraMonitorStatus = new int[optJSONArray.length()];
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            this.extraMonitorStatus[i2] = optJSONArray.optInt(i2);
        }
    }

    private void putMonitorSetting() {
        safePutToDBJsonData(DbJsonConstants.NEED_SDK_MONITOR, Boolean.valueOf(this.needSDKMonitor));
        safePutToDBJsonData(DbJsonConstants.MONITOR_SCENE, this.monitorScene);
        try {
            JSONArray jSONArray = new JSONArray();
            int[] iArr = this.extraMonitorStatus;
            if (iArr != null && iArr.length > 0) {
                int i2 = 0;
                while (true) {
                    int[] iArr2 = this.extraMonitorStatus;
                    if (i2 >= iArr2.length) {
                        break;
                    }
                    jSONArray.put(iArr2[i2]);
                    i2++;
                }
            }
            safePutToDBJsonData(DbJsonConstants.EXTRA_MONITOR_STATUS, jSONArray);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void refreshBackupUrls(boolean z) {
        List<String> list = this.forbiddenBackupUrls;
        if (list == null || list.size() <= z) {
            return;
        }
        List<String> list2 = this.backUpUrls;
        if (list2 == null) {
            this.backUpUrls = new ArrayList();
        } else {
            list2.clear();
        }
        this.backUpUrlUsed = false;
        this.curBackUpUrlIndex = 0;
        for (int i2 = z; i2 < this.forbiddenBackupUrls.size(); i2++) {
            this.backUpUrls.add(this.forbiddenBackupUrls.get(i2));
        }
    }

    private void setBackUpUrlsStr(String str) {
        if (TextUtils.isEmpty(str) || getStatus() == -3) {
            return;
        }
        this.backUpUrlsStr = str;
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    String optString = jSONArray.optString(i2);
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList.add(optString);
                    }
                }
                this.backUpUrls = arrayList;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void addErrorBytesLog(long j2, int i2, String str) {
        try {
            if (Logger.debug()) {
                if (this.errorBytesLog == null) {
                    this.errorBytesLog = new StringBuffer();
                }
                if (this.errorBytesLog.length() != 0) {
                    this.errorBytesLog.append(",");
                }
                StringBuffer stringBuffer = this.errorBytesLog;
                stringBuffer.append("[type:");
                stringBuffer.append(i2);
                stringBuffer.append(",bytes:");
                stringBuffer.append(j2);
                stringBuffer.append(",method:");
                stringBuffer.append(str);
                stringBuffer.append("]");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void bindValue(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        this.bindValueCount = 0;
        sQLiteStatement.clearBindings();
        int i2 = this.bindValueCount + 1;
        this.bindValueCount = i2;
        sQLiteStatement.bindLong(i2, this.id);
        int i3 = this.bindValueCount + 1;
        this.bindValueCount = i3;
        String str = this.url;
        if (str == null) {
            str = "";
        }
        sQLiteStatement.bindString(i3, str);
        int i4 = this.bindValueCount + 1;
        this.bindValueCount = i4;
        String str2 = this.savePath;
        if (str2 == null) {
            str2 = "";
        }
        sQLiteStatement.bindString(i4, str2);
        int i5 = this.bindValueCount + 1;
        this.bindValueCount = i5;
        String str3 = this.tempPath;
        if (str3 == null) {
            str3 = "";
        }
        sQLiteStatement.bindString(i5, str3);
        int i6 = this.bindValueCount + 1;
        this.bindValueCount = i6;
        String str4 = this.name;
        if (str4 == null) {
            str4 = "";
        }
        sQLiteStatement.bindString(i6, str4);
        int i7 = this.bindValueCount + 1;
        this.bindValueCount = i7;
        sQLiteStatement.bindLong(i7, this.chunkCount);
        int i8 = this.bindValueCount + 1;
        this.bindValueCount = i8;
        sQLiteStatement.bindLong(i8, getStatus());
        int i9 = this.bindValueCount + 1;
        this.bindValueCount = i9;
        sQLiteStatement.bindLong(i9, getCurBytes());
        int i10 = this.bindValueCount + 1;
        this.bindValueCount = i10;
        sQLiteStatement.bindLong(i10, this.totalBytes);
        int i11 = this.bindValueCount + 1;
        this.bindValueCount = i11;
        String str5 = this.eTag;
        if (str5 == null) {
            str5 = "";
        }
        sQLiteStatement.bindString(i11, str5);
        int i12 = this.bindValueCount + 1;
        this.bindValueCount = i12;
        sQLiteStatement.bindLong(i12, this.onlyWifi ? 1L : 0L);
        int i13 = this.bindValueCount + 1;
        this.bindValueCount = i13;
        sQLiteStatement.bindLong(i13, this.force ? 1L : 0L);
        int i14 = this.bindValueCount + 1;
        this.bindValueCount = i14;
        sQLiteStatement.bindLong(i14, this.retryCount);
        int i15 = this.bindValueCount + 1;
        this.bindValueCount = i15;
        String str6 = this.extra;
        if (str6 == null) {
            str6 = "";
        }
        sQLiteStatement.bindString(i15, str6);
        int i16 = this.bindValueCount + 1;
        this.bindValueCount = i16;
        String str7 = this.mimeType;
        if (str7 == null) {
            str7 = "";
        }
        sQLiteStatement.bindString(i16, str7);
        int i17 = this.bindValueCount + 1;
        this.bindValueCount = i17;
        String str8 = this.title;
        if (str8 == null) {
            str8 = "";
        }
        sQLiteStatement.bindString(i17, str8);
        int i18 = this.bindValueCount + 1;
        this.bindValueCount = i18;
        sQLiteStatement.bindLong(i18, this.showNotification ? 1L : 0L);
        int i19 = this.bindValueCount + 1;
        this.bindValueCount = i19;
        sQLiteStatement.bindLong(i19, this.notificationVisibility);
        int i20 = this.bindValueCount + 1;
        this.bindValueCount = i20;
        sQLiteStatement.bindLong(i20, this.isFirstDownload ? 1L : 0L);
        int i21 = this.bindValueCount + 1;
        this.bindValueCount = i21;
        sQLiteStatement.bindLong(i21, this.isFirstSuccess ? 1L : 0L);
        int i22 = this.bindValueCount + 1;
        this.bindValueCount = i22;
        sQLiteStatement.bindLong(i22, this.needHttpsToHttpRetry ? 1L : 0L);
        int i23 = this.bindValueCount + 1;
        this.bindValueCount = i23;
        sQLiteStatement.bindLong(i23, this.downloadTime);
        int i24 = this.bindValueCount + 1;
        this.bindValueCount = i24;
        String str9 = this.packageName;
        if (str9 == null) {
            str9 = "";
        }
        sQLiteStatement.bindString(i24, str9);
        int i25 = this.bindValueCount + 1;
        this.bindValueCount = i25;
        String str10 = this.md5;
        if (str10 == null) {
            str10 = "";
        }
        sQLiteStatement.bindString(i25, str10);
        int i26 = this.bindValueCount + 1;
        this.bindValueCount = i26;
        sQLiteStatement.bindLong(i26, this.needRetryDelay ? 1L : 0L);
        int i27 = this.bindValueCount + 1;
        this.bindValueCount = i27;
        sQLiteStatement.bindLong(i27, this.curRetryTime);
        int i28 = this.bindValueCount + 1;
        this.bindValueCount = i28;
        sQLiteStatement.bindLong(i28, this.retryDelayStatus.ordinal());
        int i29 = this.bindValueCount + 1;
        this.bindValueCount = i29;
        sQLiteStatement.bindLong(i29, this.needDefaultHttpServiceBackUp ? 1L : 0L);
        int i30 = this.bindValueCount + 1;
        this.bindValueCount = i30;
        sQLiteStatement.bindLong(i30, this.needReuseChunkRunnable ? 1L : 0L);
        int i31 = this.bindValueCount + 1;
        this.bindValueCount = i31;
        String str11 = this.retryDelayTimeArray;
        if (str11 == null) {
            str11 = "";
        }
        sQLiteStatement.bindString(i31, str11);
        int i32 = this.bindValueCount + 1;
        this.bindValueCount = i32;
        sQLiteStatement.bindLong(i32, this.needChunkDowngradeRetry ? 1L : 0L);
        int i33 = this.bindValueCount + 1;
        this.bindValueCount = i33;
        sQLiteStatement.bindString(i33, getBackUpUrlsStr());
        int i34 = this.bindValueCount + 1;
        this.bindValueCount = i34;
        sQLiteStatement.bindLong(i34, this.backUpUrlRetryCount);
        int i35 = this.bindValueCount + 1;
        this.bindValueCount = i35;
        sQLiteStatement.bindLong(i35, this.realDownloadTime);
        int i36 = this.bindValueCount + 1;
        this.bindValueCount = i36;
        sQLiteStatement.bindLong(i36, this.retryScheduleMinutes);
        int i37 = this.bindValueCount + 1;
        this.bindValueCount = i37;
        sQLiteStatement.bindLong(i37, this.needIndependentProcess ? 1L : 0L);
        int i38 = this.bindValueCount + 1;
        this.bindValueCount = i38;
        sQLiteStatement.bindString(i38, getDBJsonDataString());
        int i39 = this.bindValueCount + 1;
        this.bindValueCount = i39;
        String str12 = this.iconUrl;
        if (str12 == null) {
            str12 = "";
        }
        sQLiteStatement.bindString(i39, str12);
        int i40 = this.bindValueCount + 1;
        this.bindValueCount = i40;
        sQLiteStatement.bindLong(i40, this.appVersionCode);
        int i41 = this.bindValueCount + 1;
        this.bindValueCount = i41;
        String str13 = this.taskId;
        sQLiteStatement.bindString(i41, str13 != null ? str13 : "");
    }

    public boolean cacheExpierd() {
        if (isDownloaded()) {
            return DownloadUtils.cacheExpired(this);
        }
        return true;
    }

    public boolean canNotifyProgress() {
        long j2 = this.lastNotifyProgressTime.get();
        return j2 == 0 || SystemClock.uptimeMillis() - j2 > 20;
    }

    public boolean canReStartAsyncTask() {
        return getStatus() != -3 && this.asyncHandleStatus == AsyncHandleStatus.ASYNC_HANDLE_WAITING;
    }

    public boolean canReplaceHttpForRetry() {
        return !TextUtils.isEmpty(this.url) && this.url.startsWith(b.f4198a) && this.needHttpsToHttpRetry && !this.httpsToHttpRetryUsed;
    }

    public boolean canShowNotification() {
        boolean z = this.autoResumed;
        return (!z && this.showNotification) || (z && (this.showNotificationForAutoResumed || this.showNotificationForNetworkResumed));
    }

    public boolean canSkipStatusHandler() {
        AsyncHandleStatus asyncHandleStatus;
        int status = getStatus();
        return status == 7 || this.retryDelayStatus == RetryDelayStatus.DELAY_RETRY_WAITING || status == 8 || (asyncHandleStatus = this.asyncHandleStatus) == AsyncHandleStatus.ASYNC_HANDLE_WAITING || asyncHandleStatus == AsyncHandleStatus.ASYNC_HANDLE_RESTART || this.byteInvalidRetryStatus == ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_RESTART;
    }

    public boolean canStartRetryDelayTask() {
        return isNeedRetryDelay() && getStatus() != -3 && this.retryDelayStatus == RetryDelayStatus.DELAY_RETRY_WAITING;
    }

    public void changeSkipStatus() {
        AsyncHandleStatus asyncHandleStatus;
        int status = getStatus();
        if (status == 7 || this.retryDelayStatus == RetryDelayStatus.DELAY_RETRY_WAITING) {
            setRetryDelayStatus(RetryDelayStatus.DELAY_RETRY_DOWNLOADING);
        }
        if (status == 8 || (asyncHandleStatus = this.asyncHandleStatus) == AsyncHandleStatus.ASYNC_HANDLE_WAITING || asyncHandleStatus == AsyncHandleStatus.ASYNC_HANDLE_RESTART) {
            setAsyncHandleStatus(AsyncHandleStatus.ASYNC_HANDLE_DOWNLOADING);
        }
        if (this.byteInvalidRetryStatus == ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_RESTART) {
            setByteInvalidRetryStatus(ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_DOWNLOADING);
        }
    }

    public int checkMd5Status() {
        return DownloadUtils.checkMd5Status(getSavePath(), getName(), this.md5);
    }

    public boolean checkMd5Valid() {
        return DownloadUtils.checkMd5Valid(getSavePath(), getName(), this.md5);
    }

    public void clearSpData() {
        Context appContext = DownloadComponentManager.getAppContext();
        if (appContext != null) {
            try {
                appContext.getSharedPreferences(DownloadConstants.SP_DOWNLOAD_INFO, 0).edit().remove(Integer.toString(getId())).apply();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void copyFromCacheData(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        setChunkCount(downloadInfo.getChunkCount());
        setTotalBytes(downloadInfo.getTotalBytes());
        setCurBytes(downloadInfo.getCurBytes(), true);
        this.realDownloadTime = downloadInfo.realDownloadTime;
        if (downloadInfo.canSkipStatusHandler() || canSkipStatusHandler()) {
            this.curRetryTime = downloadInfo.getCurRetryTime();
        } else {
            this.curRetryTime = 0;
            this.isForbiddenRetryed = false;
            this.backUpUrlUsed = false;
            this.curBackUpUrlIndex = 0;
            this.httpsToHttpRetryUsed = false;
        }
        seteTag(downloadInfo.geteTag());
        if (z) {
            setStatus(downloadInfo.getStatus());
        }
        this.isFirstDownload = downloadInfo.getIsFirstDownload();
        this.isFirstSuccess = downloadInfo.isFirstSuccess();
        this.retryDelayStatus = downloadInfo.getRetryDelayStatus();
        mergeAuxiliaryJSONObject(downloadInfo.dbJsonData);
    }

    public void copyTaskIdFromCacheData(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.taskId = downloadInfo.getTaskId();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equalsTask(DownloadInfo downloadInfo) {
        String str;
        String str2;
        return (downloadInfo == null || (str = this.url) == null || !str.equals(downloadInfo.getUrl()) || (str2 = this.savePath) == null || !str2.equals(downloadInfo.getSavePath())) ? false : true;
    }

    public void erase() {
        setCurBytes(0L, true);
        this.totalBytes = 0L;
        this.chunkCount = 1;
        this.downloadTime = 0L;
        this.realStartDownloadTime = 0L;
        this.realDownloadTime = 0L;
        this.curRetryTime = 0;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.backUpUrlUsed = false;
        this.httpsToHttpRetryUsed = false;
        this.eTag = null;
        this.failedException = null;
        this.tempCacheData = null;
        this.packageInfoRef = null;
    }

    public void generateTaskId() {
        this.taskId = UUID.randomUUID().toString();
    }

    public long getAllConnectTime() {
        ensureDBJsonData();
        if (this.allConnectTime == null) {
            this.allConnectTime = new AtomicLong(this.dbJsonData.optLong(DbJsonConstants.DBJSON_KEY_ALL_CONNECT_TIME));
        }
        return this.allConnectTime.get();
    }

    public int getAntiHijackErrorCode(int i2) {
        ensureDBJsonData();
        return this.dbJsonData.optInt(DbJsonConstants.DBJSON_KEY_ANTI_HIJACK_ERROR_CODE, i2);
    }

    public int getAppVersionCode() {
        return this.appVersionCode;
    }

    public AsyncHandleStatus getAsyncHandleStatus() {
        return this.asyncHandleStatus;
    }

    public String getBackUpUrl() {
        List<String> list;
        int i2;
        if (this.backUpUrlUsed && (list = this.backUpUrls) != null && list.size() > 0 && (i2 = this.curBackUpUrlIndex) >= 0 && i2 < this.backUpUrls.size()) {
            String str = this.backUpUrls.get(this.curBackUpUrlIndex);
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }

    public int getBackUpUrlRetryCount() {
        return this.backUpUrlRetryCount;
    }

    public List<String> getBackUpUrls() {
        return this.backUpUrls;
    }

    public int getBindValueCount() {
        return this.bindValueCount;
    }

    public ByteInvalidRetryStatus getByteInvalidRetryStatus() {
        return this.byteInvalidRetryStatus;
    }

    public String getCacheControl() {
        ensureSpData();
        try {
            return this.spData.optString(SpJsonConstants.CACHE_CONTROL, null);
        } catch (Exception unused) {
            return null;
        }
    }

    public long getCacheExpiredTime() {
        ensureSpData();
        try {
            return this.spData.optLong(SpJsonConstants.CACHE_CONTROL_EXPIRED_TIME, -1L);
        } catch (Exception unused) {
            return -1L;
        }
    }

    public int getChunkCount() {
        return this.chunkCount;
    }

    public String getConnectionUrl() {
        List<String> list;
        int i2;
        List<String> list2;
        String str = this.url;
        if (getStatus() == 8 && (list2 = this.forbiddenBackupUrls) != null && !list2.isEmpty() && !this.backUpUrlUsed) {
            return this.forbiddenBackupUrls.get(0);
        }
        if (!this.backUpUrlUsed || (list = this.backUpUrls) == null || list.size() <= 0 || (i2 = this.curBackUpUrlIndex) < 0 || i2 >= this.backUpUrls.size()) {
            return (!TextUtils.isEmpty(this.url) && this.url.startsWith(b.f4198a) && this.needHttpsToHttpRetry && this.httpsToHttpRetryUsed) ? this.url.replaceFirst(b.f4198a, HttpHost.DEFAULT_SCHEME_NAME) : str;
        }
        String str2 = this.backUpUrls.get(this.curBackUpUrlIndex);
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }

    public int getCurBackUpUrlIndex() {
        return this.curBackUpUrlIndex;
    }

    public long getCurBytes() {
        AtomicLong atomicLong = this.curBytes;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public int getCurRetryTime() {
        return this.curRetryTime;
    }

    public int getCurRetryTimeInTotal() {
        int i2 = this.curRetryTime;
        if (!this.backUpUrlUsed) {
            return i2;
        }
        int i3 = i2 + this.retryCount;
        int i4 = this.curBackUpUrlIndex;
        return i4 > 0 ? i3 + (i4 * this.backUpUrlRetryCount) : i3;
    }

    public int getDBJsonInt(String str) {
        ensureDBJsonData();
        return this.dbJsonData.optInt(str);
    }

    public String getDBJsonString(String str) {
        ensureDBJsonData();
        return this.dbJsonData.optString(str);
    }

    public long getDownloadPrepareTime() {
        ensureDBJsonData();
        return this.dbJsonData.optLong(DbJsonConstants.DBJSON_KEY_DOWNLOAD_PREPARE_TIME);
    }

    public int getDownloadProcess() {
        if (this.totalBytes <= 0) {
            return 0;
        }
        if (getCurBytes() > this.totalBytes) {
            return 100;
        }
        return (int) ((getCurBytes() * 100) / this.totalBytes);
    }

    public String getDownloadSettingString() {
        ensureDBJsonData();
        return this.dbJsonData.optString(DbJsonConstants.DOWNLOAD_SETTING);
    }

    public double getDownloadSpeed() {
        double curBytes = getCurBytes();
        Double.isNaN(curBytes);
        double d2 = curBytes / 1048576.0d;
        double realDownloadTime = getRealDownloadTime();
        Double.isNaN(realDownloadTime);
        double d3 = realDownloadTime / 1000.0d;
        if (d2 <= 0.0d || d3 <= 0.0d) {
            return -1.0d;
        }
        return d2 / d3;
    }

    public long getDownloadTime() {
        return this.downloadTime;
    }

    public EnqueueType getEnqueueType() {
        return this.enqueueType;
    }

    public String getErrorBytesLog() {
        StringBuffer stringBuffer = this.errorBytesLog;
        return (stringBuffer == null || stringBuffer.length() == 0) ? "" : this.errorBytesLog.toString();
    }

    public int getExecutorGroup() {
        ensureDBJsonData();
        return this.dbJsonData.optInt(DbJsonConstants.DBJSON_KEY_EXECUTOR, 2);
    }

    public long getExpectFileLength() {
        ensureDBJsonData();
        return this.dbJsonData.optLong(DbJsonConstants.DBJSON_KEY_EXPECT_FILE_LENGTH);
    }

    public String getExtra() {
        return this.extra;
    }

    public List<HttpHeader> getExtraHeaders() {
        return this.extraHeaders;
    }

    public int[] getExtraMonitorStatus() {
        return this.extraMonitorStatus;
    }

    public BaseException getFailedException() {
        return this.failedException;
    }

    public int getFailedResumeCount() {
        ensureSpData();
        return this.spData.optInt("failed_resume_count", 0);
    }

    public String getFilePackageName() {
        return this.filePackageName;
    }

    public long getFirstSpeedTime() {
        ensureDBJsonData();
        return this.dbJsonData.optLong(DbJsonConstants.DBJSON_KEY_FIRST_SPEED_TIME);
    }

    public List<String> getForbiddenBackupUrls() {
        return this.forbiddenBackupUrls;
    }

    public String getHeadConnectionException() {
        return this.headConnectionException;
    }

    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }

    public String getHttpStatusMessage() {
        return this.httpStatusMessage;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public int getId() {
        if (this.id == 0) {
            this.id = DownloadComponentManager.getDownloadId(this);
        }
        return this.id;
    }

    public boolean getIsFirstDownload() {
        return this.isFirstDownload;
    }

    public long getLastDownloadTime() {
        ensureDBJsonData();
        return this.dbJsonData.optLong(DbJsonConstants.DBJSON_KEY_LAST_START_DOWNLOAD_TIME, 0L);
    }

    public long getLastFailedResumeTime() {
        ensureSpData();
        return this.spData.optLong(SpJsonConstants.KEY_LAST_FAILED_RESUME_TIME, 0L);
    }

    public String getLastModified() {
        ensureSpData();
        try {
            return this.spData.optString("last-modified", null);
        } catch (Exception unused) {
            return null;
        }
    }

    public long getLastUninstallResumeTime() {
        ensureSpData();
        return this.spData.optLong(SpJsonConstants.KEY_LAST_UNINSTALL_RESUME_TIME, 0L);
    }

    public int getLinkMode() {
        ensureDBJsonData();
        return this.dbJsonData.optInt(DbJsonConstants.DBJSON_KEY_LINK_MODE);
    }

    public int getMaxBytes() {
        return this.maxBytes;
    }

    public int getMaxProgressCount() {
        return this.maxProgressCount;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public long getMinByteIntervalForPostToMainThread(long j2) {
        int i2 = this.maxProgressCount;
        if (i2 <= 0) {
            i2 = 100;
        }
        long j3 = j2 / (i2 + 1);
        if (j3 <= 0) {
            return 1048576L;
        }
        return j3;
    }

    public int getMinProgressTimeMsInterval() {
        int i2 = this.minProgressTimeMsInterval;
        if (i2 < 1000) {
            return 1000;
        }
        return i2;
    }

    public String getMonitorScene() {
        return this.monitorScene;
    }

    public String getName() {
        return this.name;
    }

    public String getNetworkQuality() {
        return this.networkQuality;
    }

    public int getNotificationVisibility() {
        return this.notificationVisibility;
    }

    public boolean getOpenLimitSpeed() {
        return this.openLimitSpeed;
    }

    public String[] getOutIp() {
        return this.outIp;
    }

    public int[] getOutSize() {
        return this.outSize;
    }

    public PackageInfo getPackageInfo() {
        SoftReference<PackageInfo> softReference = this.packageInfoRef;
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getPausedResumeCount() {
        ensureSpData();
        return this.spData.optInt(DownloadConstants.KEY_PAUSED_RESUME_COUNT, 0);
    }

    public int getPreconnectLevel() {
        ensureDBJsonData();
        return this.dbJsonData.optInt(DbJsonConstants.DBJSON_KEY_PRECONNECT_LEVEL, 0);
    }

    public long getRealDownloadTime() {
        return TimeUnit.NANOSECONDS.toMillis(this.realDownloadTime);
    }

    public int getRealStatus() {
        AtomicInteger atomicInteger = this.status;
        if (atomicInteger != null) {
            return atomicInteger.get();
        }
        return 0;
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public RetryDelayStatus getRetryDelayStatus() {
        return this.retryDelayStatus;
    }

    public String getRetryDelayTimeArray() {
        return this.retryDelayTimeArray;
    }

    public int getRetryScheduleCount() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("retry_schedule_count", 0);
    }

    public String getSavePath() {
        return this.savePath;
    }

    public int getSpIntVal(String str) {
        ensureSpData();
        return this.spData.optInt(str, 0);
    }

    public long getSpLongVal(String str) {
        ensureSpData();
        return this.spData.optLong(str, 0L);
    }

    public String getSpStringVal(String str) {
        ensureSpData();
        return this.spData.optString(str, null);
    }

    public int getStatus() {
        AtomicInteger atomicInteger = this.status;
        if (atomicInteger == null) {
            return 0;
        }
        int i2 = atomicInteger.get();
        if (i2 == -5) {
            return -2;
        }
        return i2;
    }

    public int getStatusAtDbInit() {
        return this.statusAtDbInit;
    }

    public int getTTMd5CheckStatus() {
        ensureDBJsonData();
        return this.dbJsonData.optInt(DbJsonConstants.DBJSON_KEY_TTMD5_CHECK_STATUS, -1);
    }

    public String getTargetFilePath() {
        return DownloadUtils.getTargetFilePath(this.savePath, this.name);
    }

    public String getTaskId() {
        return this.taskId;
    }

    public ConcurrentHashMap<String, Object> getTempCacheData() {
        ensureTempCacheData();
        return this.tempCacheData;
    }

    public String getTempFilePath() {
        return DownloadUtils.getTempFilePath(this.savePath, this.tempPath, this.name);
    }

    public String getTempName() {
        return DownloadUtils.getTempFileName(this.name);
    }

    public String getTempPath() {
        return DownloadUtils.getTempFileSavePath(this.savePath, this.tempPath);
    }

    public long getThrottleNetSpeed() {
        return this.throttleNetSpeed;
    }

    public String getTitle() {
        return TextUtils.isEmpty(this.title) ? this.name : this.title;
    }

    public long getTotalBytes() {
        return this.totalBytes;
    }

    public int getTotalRetryCount() {
        int i2 = this.retryCount;
        List<String> list = this.backUpUrls;
        return (list == null || list.isEmpty()) ? i2 : i2 + (this.backUpUrlRetryCount * this.backUpUrls.size());
    }

    public long getTtnetProtectTimeout() {
        return this.ttnetProtectTimeout;
    }

    public int getUninstallResumeCount() {
        ensureSpData();
        return this.spData.optInt(SpJsonConstants.KEY_UNINSTALL_RESUME_COUNT, 0);
    }

    public String getUrl() {
        return this.url;
    }

    public String geteTag() {
        return this.eTag;
    }

    public synchronized void handleTempSaveCallback(boolean z, BaseException baseException) {
        this.isSaveTempFile = false;
        if (this.tempFileSaveCompleteCallbacks == null) {
            return;
        }
        Logger.d(TAG, "handleTempSaveCallback isSuccess " + z + " callback size:" + this.tempFileSaveCompleteCallbacks.size());
        for (ITempFileSaveCompleteCallback iTempFileSaveCompleteCallback : this.tempFileSaveCompleteCallbacks) {
            if (iTempFileSaveCompleteCallback != null) {
                if (z) {
                    iTempFileSaveCompleteCallback.onSuccess();
                } else {
                    iTempFileSaveCompleteCallback.onFailed(baseException);
                }
            }
        }
    }

    public boolean hasNextBackupUrl() {
        List<String> list = this.backUpUrls;
        if (list != null && list.size() > 0) {
            if (!this.backUpUrlUsed) {
                return true;
            }
            int i2 = this.curBackUpUrlIndex;
            if (i2 >= 0 && i2 < this.backUpUrls.size() - 1) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPauseReservedOnWifi() {
        return (getReserveWifiStatus() & 1) > 0;
    }

    public void increaseAllConnectTime(long j2) {
        if (j2 > 0) {
            getAllConnectTime();
            safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_ALL_CONNECT_TIME, Long.valueOf(this.allConnectTime.addAndGet(j2)));
        }
    }

    public void increaseCurBytes(long j2) {
        this.curBytes.addAndGet(j2);
    }

    public void increaseDownloadPrepareTime(long j2) {
        if (j2 > 0) {
            safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_DOWNLOAD_PREPARE_TIME, Long.valueOf(getDownloadPrepareTime() + j2));
        }
    }

    public boolean isAddListenerToSameTask() {
        return this.addListenerToSameTask;
    }

    public boolean isAutoInstall() {
        ensureDBJsonData();
        return this.dbJsonData.optInt(DbJsonConstants.AUTO_INSTALL, 1) == 1;
    }

    public boolean isAutoInstallWithoutNotification() {
        if (this.isAutoInstallWithoutNotification == null) {
            if (TextUtils.isEmpty(this.extra)) {
                this.isAutoInstallWithoutNotification = Boolean.FALSE;
            } else {
                try {
                    this.isAutoInstallWithoutNotification = Boolean.valueOf(new JSONObject(this.extra).optBoolean(DownloadConstants.AUTO_INSTALL_WITHOUT_NOTIFICATION, false));
                } catch (JSONException unused) {
                    this.isAutoInstallWithoutNotification = Boolean.FALSE;
                }
            }
        }
        return this.isAutoInstallWithoutNotification.booleanValue();
    }

    public boolean isAutoResumed() {
        return this.autoResumed;
    }

    public boolean isBackUpUrlUsed() {
        return this.backUpUrlUsed;
    }

    public boolean isBreakpointAvailable() {
        if (isFileDataValid()) {
            return isChunkBreakpointAvailable();
        }
        return false;
    }

    public boolean isCanResumeFromBreakPointStatus() {
        int status = getStatus();
        if (status == 4 || status == 3 || status == -1 || status == 5 || status == 8) {
            return true;
        }
        return (status == 1 || status == 2) && getCurBytes() > 0;
    }

    public boolean isChunkBreakpointAvailable() {
        IDownloadCache downloadCache;
        if (this.chunkCount > 1 && (downloadCache = DownloadComponentManager.getDownloadCache()) != null) {
            List<DownloadChunk> downloadChunk = downloadCache.getDownloadChunk(getId());
            if (downloadChunk == null || downloadChunk.size() != this.chunkCount) {
                return false;
            }
            long j2 = 0;
            for (DownloadChunk downloadChunk2 : downloadChunk) {
                if (downloadChunk2 != null) {
                    j2 += downloadChunk2.getDownloadChunkBytes();
                }
            }
            if (j2 != getCurBytes()) {
                setCurBytes(j2);
            }
        }
        return true;
    }

    public boolean isChunkDowngradeRetryUsed() {
        return this.chunkDowngradeRetryUsed;
    }

    public boolean isChunked() {
        return DownloadUtils.isChunkedTask(this.totalBytes);
    }

    public boolean isDeleteCacheIfCheckFailed() {
        return this.deleteCacheIfCheckFailed;
    }

    public boolean isDownloadFromReserveWifi() {
        return this.mDownloadFromReserveWifi;
    }

    public boolean isDownloadOverStatus() {
        return DownloadStatus.isDownloadOver(getStatus());
    }

    public boolean isDownloadWithWifiValid() {
        return !isOnlyWifi() || DownloadUtils.isWifi(DownloadComponentManager.getAppContext());
    }

    public boolean isDownloaded() {
        return DownloadUtils.isFileDownloaded(this);
    }

    public boolean isDownloadingStatus() {
        return DownloadStatus.isDownloading(getStatus());
    }

    public boolean isEntityInvalid() {
        return TextUtils.isEmpty(this.url) || TextUtils.isEmpty(this.name) || TextUtils.isEmpty(this.savePath);
    }

    public boolean isExpiredRedownload() {
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.FORCE_CLOSE_DOWNLOAD_CACHE_CHECK, 0) != 1) {
            return this.expiredRedownload;
        }
        Logger.w("isExpiredRedownload force to false, reason(global setting) id=" + getId() + " name=" + getName());
        return false;
    }

    public boolean isFileDataExists() {
        if (isEntityInvalid()) {
            return false;
        }
        File file = new File(getTempPath(), getTempName());
        return file.exists() && !file.isDirectory();
    }

    public boolean isFileDataValid() {
        if (isEntityInvalid()) {
            return false;
        }
        File file = new File(getTempPath(), getTempName());
        boolean exists = file.exists();
        boolean isDirectory = file.isDirectory();
        if (exists && !isDirectory) {
            long length = file.length();
            long curBytes = getCurBytes();
            if (DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.FIX_FILE_DATA_VALID)) {
                if (curBytes > 0) {
                    long j2 = this.totalBytes;
                    if (j2 > 0 && this.chunkCount > 0 && length >= curBytes && length <= j2) {
                        return true;
                    }
                }
                Logger.w(TAG, "isFileDataValid: cur = " + curBytes + ",totalBytes =" + this.totalBytes + ",fileLength=" + length);
                return false;
            }
            if (length > 0 && curBytes > 0) {
                long j3 = this.totalBytes;
                if (j3 > 0 && this.chunkCount > 0 && length >= curBytes && length <= j3 && curBytes < j3) {
                    return true;
                }
            }
            Logger.w(TAG, "isFileDataValid: cur = " + curBytes + ",totalBytes =" + this.totalBytes + ",fileLength=" + length);
        }
        return false;
    }

    public boolean isFirstDownload() {
        if (!this.isFirstDownload || TextUtils.isEmpty(getTempPath()) || TextUtils.isEmpty(getTempName())) {
            return false;
        }
        return !new File(getTempPath(), getTempName()).exists();
    }

    public boolean isFirstSuccess() {
        return this.isFirstSuccess;
    }

    public boolean isForbiddenRetryed() {
        return this.isForbiddenRetryed;
    }

    public boolean isForce() {
        return this.force;
    }

    public boolean isForceIgnoreRecommendSize() {
        return this.forceIgnoreRecommendSize;
    }

    public boolean isHeadConnectionAvailable() {
        return this.headConnectionAvailable;
    }

    public boolean isHttpsToHttpRetryUsed() {
        return this.httpsToHttpRetryUsed;
    }

    public boolean isIgnoreDataVerify() {
        return this.ignoreDataVerify;
    }

    public boolean isNeedChunkDowngradeRetry() {
        return this.needChunkDowngradeRetry;
    }

    public boolean isNeedDefaultHttpServiceBackUp() {
        return this.needDefaultHttpServiceBackUp;
    }

    public boolean isNeedHttpsToHttpRetry() {
        return this.needHttpsToHttpRetry;
    }

    public boolean isNeedIndependentProcess() {
        return this.needIndependentProcess;
    }

    public boolean isNeedPostProgress() {
        return this.needPostProgress;
    }

    public boolean isNeedRetryDelay() {
        return false;
    }

    public boolean isNeedReuseChunkRunnable() {
        return this.needReuseChunkRunnable;
    }

    public boolean isNeedReuseFirstConnection() {
        return this.needReuseFirstConnection;
    }

    public boolean isNeedSDKMonitor() {
        return this.needSDKMonitor;
    }

    public boolean isNewTask() {
        return getStatus() == 0;
    }

    public boolean isOnlyWifi() {
        return this.onlyWifi;
    }

    public boolean isPauseReserveOnWifi() {
        return (getReserveWifiStatus() & 2) > 0;
    }

    public boolean isPauseReserveWithWifiValid() {
        if (this.mDownloadFromReserveWifi) {
            return isPauseReserveOnWifi() && DownloadUtils.isWifi(DownloadComponentManager.getAppContext());
        }
        return true;
    }

    public boolean isRwConcurrent() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("rw_concurrent", 0) == 1;
    }

    public boolean isSavePathRedirected() {
        ensureDBJsonData();
        return this.dbJsonData.optBoolean(DbJsonConstants.DBJSON_KEY_IS_SAVE_PATH_REDIRECTED, false);
    }

    public synchronized boolean isSaveTempFile() {
        return this.isSaveTempFile;
    }

    public boolean isShowNotification() {
        return this.showNotification;
    }

    public boolean isShowNotificationForAutoResumed() {
        return this.showNotificationForAutoResumed;
    }

    public boolean isShowNotificationForNetworkResumed() {
        return this.showNotificationForNetworkResumed;
    }

    public boolean isSuccessByCache() {
        return this.successByCache;
    }

    public boolean isSupportPartial() {
        return this.supportPartial;
    }

    public boolean isWaitingWifiStatus() {
        BaseException baseException = this.failedException;
        return baseException != null && baseException.getErrorCode() == 1013;
    }

    public void readFromParcel(Parcel parcel) {
        this.id = parcel.readInt();
        this.name = parcel.readString();
        this.title = parcel.readString();
        this.url = parcel.readString();
        this.savePath = parcel.readString();
        this.tempPath = parcel.readString();
        this.onlyWifi = parcel.readByte() != 0;
        this.extra = parcel.readString();
        this.extraHeaders = parcel.createTypedArrayList(HttpHeader.CREATOR);
        this.maxBytes = parcel.readInt();
        this.outIp = parcel.createStringArray();
        this.outSize = parcel.createIntArray();
        this.retryCount = parcel.readInt();
        this.backUpUrlRetryCount = parcel.readInt();
        this.force = parcel.readByte() != 0;
        this.needPostProgress = parcel.readByte() != 0;
        this.maxProgressCount = parcel.readInt();
        this.minProgressTimeMsInterval = parcel.readInt();
        this.backUpUrls = parcel.createStringArrayList();
        this.showNotification = parcel.readByte() != 0;
        this.mimeType = parcel.readString();
        this.needHttpsToHttpRetry = parcel.readByte() != 0;
        this.packageName = parcel.readString();
        this.md5 = parcel.readString();
        this.needRetryDelay = parcel.readByte() != 0;
        this.needDefaultHttpServiceBackUp = parcel.readByte() != 0;
        this.needReuseChunkRunnable = parcel.readByte() != 0;
        this.retryDelayTimeArray = parcel.readString();
        this.eTag = parcel.readString();
        this.curRetryTime = parcel.readInt();
        convertRetryDelayStatus(parcel.readInt());
        this.needReuseFirstConnection = parcel.readByte() != 0;
        this.forceIgnoreRecommendSize = parcel.readByte() != 0;
        this.networkQuality = parcel.readString();
        this.curBackUpUrlIndex = parcel.readInt();
        this.notificationVisibility = parcel.readInt();
        this.chunkCount = parcel.readInt();
        setCurBytes(parcel.readLong());
        this.totalBytes = parcel.readLong();
        setStatus(parcel.readInt());
        this.downloadTime = parcel.readLong();
        this.realDownloadTime = parcel.readLong();
        this.backUpUrlUsed = parcel.readByte() != 0;
        this.httpsToHttpRetryUsed = parcel.readByte() != 0;
        try {
            StringBuffer stringBuffer = this.errorBytesLog;
            if (stringBuffer == null) {
                this.errorBytesLog = new StringBuffer(parcel.readString());
            } else {
                stringBuffer.delete(0, stringBuffer.length()).append(parcel.readString());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.autoResumed = parcel.readByte() != 0;
        this.showNotificationForAutoResumed = parcel.readByte() != 0;
        this.showNotificationForNetworkResumed = parcel.readByte() != 0;
        this.forbiddenBackupUrls = parcel.createStringArrayList();
        this.needIndependentProcess = parcel.readByte() != 0;
        convertEnqueueType(parcel.readInt());
        this.headConnectionAvailable = parcel.readByte() != 0;
        this.httpStatusCode = parcel.readInt();
        this.httpStatusMessage = parcel.readString();
        this.isSaveTempFile = parcel.readByte() != 0;
        this.isForbiddenRetryed = parcel.readByte() != 0;
        this.addListenerToSameTask = parcel.readByte() != 0;
        this.needChunkDowngradeRetry = parcel.readByte() != 0;
        this.chunkDowngradeRetryUsed = parcel.readByte() != 0;
        this.failedException = (BaseException) parcel.readParcelable(BaseException.class.getClassLoader());
        this.retryScheduleMinutes = parcel.readInt();
        this.dbJsonDataString = parcel.readString();
        this.supportPartial = parcel.readByte() != 0;
        this.iconUrl = parcel.readString();
        this.appVersionCode = parcel.readInt();
        this.taskId = parcel.readString();
        this.expiredRedownload = parcel.readByte() != 0;
        this.deleteCacheIfCheckFailed = parcel.readByte() != 0;
        this.successByCache = parcel.readByte() != 0;
        parseMonitorSetting();
    }

    public synchronized void registerTempFileSaveCallback(ITempFileSaveCompleteCallback iTempFileSaveCompleteCallback) {
        if (iTempFileSaveCompleteCallback == null) {
            return;
        }
        try {
            Logger.d(TAG, "registerTempFileSaveCallback");
            if (this.tempFileSaveCompleteCallbacks == null) {
                this.tempFileSaveCompleteCallbacks = new ArrayList();
            }
            if (!this.tempFileSaveCompleteCallbacks.contains(iTempFileSaveCompleteCallback)) {
                this.tempFileSaveCompleteCallbacks.add(iTempFileSaveCompleteCallback);
            }
        } finally {
        }
    }

    public void reset() {
        setCurBytes(0L, true);
        this.totalBytes = 0L;
        this.chunkCount = 1;
        this.downloadTime = 0L;
        this.realStartDownloadTime = 0L;
        this.realDownloadTime = 0L;
    }

    public void resetDataForEtagEndure(String str) {
        setCurBytes(0L, true);
        setTotalBytes(0L);
        seteTag(str);
        setChunkCount(1);
        this.downloadTime = 0L;
        this.realStartDownloadTime = 0L;
        this.realDownloadTime = 0L;
    }

    public void resetRealStartDownloadTime() {
        this.realStartDownloadTime = 0L;
    }

    public void safePutToDBJsonData(String str, Object obj) {
        ensureDBJsonData();
        synchronized (this.dbJsonData) {
            try {
                this.dbJsonData.put(str, obj);
            } catch (Exception unused) {
            }
            this.dbJsonDataString = null;
        }
    }

    public void setAddListenerToSameTask(boolean z) {
        this.addListenerToSameTask = z;
    }

    public void setAntiHijackErrorCode(int i2) {
        safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_ANTI_HIJACK_ERROR_CODE, Integer.valueOf(i2));
    }

    public void setAppVersionCode(int i2) {
        this.appVersionCode = i2;
    }

    public void setAsyncHandleStatus(AsyncHandleStatus asyncHandleStatus) {
        this.asyncHandleStatus = asyncHandleStatus;
    }

    public void setAutoResumed(boolean z) {
        this.autoResumed = z;
    }

    public void setByteInvalidRetryStatus(ByteInvalidRetryStatus byteInvalidRetryStatus) {
        this.byteInvalidRetryStatus = byteInvalidRetryStatus;
    }

    public void setCacheControl(String str) {
        ensureSpData();
        try {
            this.spData.put(SpJsonConstants.CACHE_CONTROL, str);
            updateSpData();
        } catch (Exception unused) {
        }
    }

    public void setCacheExpiredTime(long j2) {
        ensureSpData();
        try {
            this.spData.put(SpJsonConstants.CACHE_CONTROL_EXPIRED_TIME, j2);
            updateSpData();
        } catch (Exception unused) {
        }
    }

    public void setChunkCount(int i2) {
        this.chunkCount = i2;
    }

    public void setChunkDowngradeRetryUsed(boolean z) {
        this.chunkDowngradeRetryUsed = z;
    }

    public void setCurBytes(long j2) {
        AtomicLong atomicLong = this.curBytes;
        if (atomicLong != null) {
            atomicLong.set(j2);
        } else {
            this.curBytes = new AtomicLong(j2);
        }
    }

    public void setDeleteCacheIfCheckFailed() {
        this.deleteCacheIfCheckFailed = true;
    }

    public void setDownloadFromReserveWifi(boolean z) {
        this.mDownloadFromReserveWifi = z;
    }

    public void setDownloadTime(long j2) {
        if (j2 >= 0) {
            this.downloadTime = j2;
        }
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setFailedException(BaseException baseException) {
        this.failedException = baseException;
    }

    public void setFailedResumeCount(int i2) {
        ensureSpData();
        try {
            this.spData.put("failed_resume_count", i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setFilePackageName(String str) {
        this.filePackageName = str;
    }

    public void setFirstDownload(boolean z) {
        this.isFirstDownload = z;
    }

    public void setFirstSpeedTime(long j2) {
        safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_FIRST_SPEED_TIME, Long.valueOf(j2));
    }

    public void setFirstSuccess(boolean z) {
        this.isFirstSuccess = z;
    }

    public void setForbiddenBackupUrls(List<String> list, boolean z) {
        this.forbiddenBackupUrls = list;
        refreshBackupUrls(z);
    }

    public void setForbiddenRetryed() {
        this.isForbiddenRetryed = true;
    }

    public void setForceIgnoreRecommendSize(boolean z) {
        this.forceIgnoreRecommendSize = z;
    }

    public void setHeadConnectionException(String str) {
        this.headConnectionException = str;
    }

    public void setHttpStatusCode(int i2) {
        this.httpStatusCode = i2;
    }

    public void setHttpStatusMessage(String str) {
        this.httpStatusMessage = str;
    }

    public void setHttpsToHttpRetryUsed(boolean z) {
        this.httpsToHttpRetryUsed = z;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public void setIsRwConcurrent(boolean z) {
        safePutToDBJsonData("rw_concurrent", Integer.valueOf(z ? 1 : 0));
    }

    public synchronized void setIsSaveTempFile(boolean z) {
        this.isSaveTempFile = z;
    }

    public void setLastFailedResumeTime(long j2) {
        ensureSpData();
        try {
            this.spData.put(SpJsonConstants.KEY_LAST_FAILED_RESUME_TIME, j2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setLastModified(String str) {
        ensureSpData();
        try {
            this.spData.put("last-modified", str);
            updateSpData();
        } catch (Exception unused) {
        }
    }

    public void setLastNotifyProgressTime() {
        this.lastNotifyProgressTime.set(SystemClock.uptimeMillis());
    }

    public void setLastUninstallResumeTime(long j2) {
        ensureSpData();
        try {
            this.spData.put(SpJsonConstants.KEY_LAST_UNINSTALL_RESUME_TIME, j2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setLinkMode(int i2) {
        safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_LINK_MODE, Integer.valueOf(i2));
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNetworkQuality(String str) {
        this.networkQuality = str;
    }

    public void setNotificationVisibility(int i2) {
        this.notificationVisibility = i2;
    }

    public void setOnlyWifi(boolean z) {
        this.onlyWifi = z;
    }

    public void setOpenLimitSpeed(boolean z) {
        this.openLimitSpeed = z;
    }

    public void setPackageInfo(PackageInfo packageInfo) {
        this.packageInfoRef = new SoftReference<>(packageInfo);
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setPausedResumeCount(int i2) {
        ensureSpData();
        try {
            this.spData.put(DownloadConstants.KEY_PAUSED_RESUME_COUNT, i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setPreconnectLevel(int i2) {
        ensureDBJsonData();
        safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_PRECONNECT_LEVEL, Integer.valueOf(i2));
    }

    public void setRetryDelayStatus(RetryDelayStatus retryDelayStatus) {
        this.retryDelayStatus = retryDelayStatus;
    }

    public void setRetryScheduleCount(int i2) {
        safePutToDBJsonData("retry_schedule_count", Integer.valueOf(i2));
    }

    public void setSavePath(String str) {
        this.savePath = str;
    }

    public void setSavePathRedirected(boolean z) {
        safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_IS_SAVE_PATH_REDIRECTED, Boolean.valueOf(z));
    }

    public void setShowNotification(boolean z) {
        this.showNotification = z;
    }

    public void setShowNotificationForAutoResumed(boolean z) {
        this.showNotificationForAutoResumed = z;
    }

    public void setShowNotificationForNetworkResumed(boolean z) {
        this.showNotificationForNetworkResumed = z;
    }

    public void setSpValue(String str, String str2) {
        ensureSpData();
        try {
            this.spData.put(str, str2);
            updateSpData();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setStatus(int i2) {
        AtomicInteger atomicInteger = this.status;
        if (atomicInteger != null) {
            atomicInteger.set(i2);
        } else {
            this.status = new AtomicInteger(i2);
        }
    }

    public void setStatusAtDbInit(int i2) {
        this.statusAtDbInit = i2;
    }

    public void setSuccessByCache(boolean z) {
        this.successByCache = z;
    }

    public void setSupportPartial(boolean z) {
        this.supportPartial = z;
    }

    public void setTTMd5CheckStatus(int i2) {
        safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_TTMD5_CHECK_STATUS, Integer.valueOf(i2));
    }

    public void setThrottleNetSpeed(long j2) {
        this.throttleNetSpeed = j2;
    }

    public void setTotalBytes(long j2) {
        this.totalBytes = j2;
    }

    public void setUninstallResumeCount(int i2) {
        ensureSpData();
        try {
            this.spData.put(SpJsonConstants.KEY_UNINSTALL_RESUME_COUNT, i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void seteTag(String str) {
        this.eTag = str;
    }

    public void startPauseReserveOnWifi() {
        ensureSpData();
        try {
            this.spData.put("pause_reserve_on_wifi", 3);
            updateSpData();
        } catch (Exception unused) {
        }
    }

    public boolean statusInPause() {
        return getRealStatus() == -2 || getRealStatus() == -5;
    }

    public void stopPauseReserveOnWifi() {
        ensureSpData();
        try {
            this.spData.put("pause_reserve_on_wifi", 1);
            updateSpData();
        } catch (Exception unused) {
        }
    }

    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(this.id));
        contentValues.put("url", this.url);
        contentValues.put(DBDefinition.SAVE_PATH, this.savePath);
        contentValues.put(DBDefinition.TEMP_PATH, this.tempPath);
        contentValues.put("name", this.name);
        contentValues.put(DBDefinition.CHUNK_COUNT, Integer.valueOf(this.chunkCount));
        contentValues.put("status", Integer.valueOf(getStatus()));
        contentValues.put(DBDefinition.CUR_BYTES, Long.valueOf(getCurBytes()));
        contentValues.put(DBDefinition.TOTAL_BYTES, Long.valueOf(this.totalBytes));
        contentValues.put(DBDefinition.ETAG, this.eTag);
        contentValues.put(DBDefinition.ONLY_WIFI, Integer.valueOf(this.onlyWifi ? 1 : 0));
        contentValues.put("force", Integer.valueOf(this.force ? 1 : 0));
        contentValues.put(DBDefinition.RETRY_COUNT, Integer.valueOf(this.retryCount));
        contentValues.put("extra", this.extra);
        contentValues.put(DBDefinition.MIME_TYPE, this.mimeType);
        contentValues.put("title", this.title);
        contentValues.put(DBDefinition.NOTIFICATION_ENABLE, Integer.valueOf(this.showNotification ? 1 : 0));
        contentValues.put(DBDefinition.NOTIFICATION_VISIBILITY, Integer.valueOf(this.notificationVisibility));
        contentValues.put(DBDefinition.FIRST_DOWNLOAD, Integer.valueOf(this.isFirstDownload ? 1 : 0));
        contentValues.put(DBDefinition.FIRST_SUCCESS, Integer.valueOf(this.isFirstSuccess ? 1 : 0));
        contentValues.put(DBDefinition.NEED_HTTPS_TO_HTTP_RETRY, Integer.valueOf(this.needHttpsToHttpRetry ? 1 : 0));
        contentValues.put(DBDefinition.DOWNLOAD_TIME, Long.valueOf(this.downloadTime));
        contentValues.put(DBDefinition.PACKAGE_NAME, this.packageName);
        contentValues.put("md5", this.md5);
        contentValues.put(DBDefinition.RETRY_DELAY, Integer.valueOf(this.needRetryDelay ? 1 : 0));
        contentValues.put(DBDefinition.CUR_RETRY_TIME, Integer.valueOf(this.curRetryTime));
        contentValues.put(DBDefinition.RETRY_DELAY_STATUS, Integer.valueOf(this.retryDelayStatus.ordinal()));
        contentValues.put(DBDefinition.DEFAULT_HTTP_SERVICE_BACKUP, Integer.valueOf(this.needDefaultHttpServiceBackUp ? 1 : 0));
        contentValues.put(DBDefinition.CHUNK_RUNNABLE_REUSE, Integer.valueOf(this.needReuseChunkRunnable ? 1 : 0));
        contentValues.put(DBDefinition.RETRY_DELAY_TIME_ARRAY, this.retryDelayTimeArray);
        contentValues.put(DBDefinition.CHUNK_DOWNGRADE_RETRY, Integer.valueOf(this.needChunkDowngradeRetry ? 1 : 0));
        contentValues.put(DBDefinition.BACKUP_URLS_STR, getBackUpUrlsStr());
        contentValues.put(DBDefinition.BACKUP_URL_RETRY_COUNT, Integer.valueOf(this.backUpUrlRetryCount));
        contentValues.put(DBDefinition.REAL_DOWNLOAD_TIME, Long.valueOf(this.realDownloadTime));
        contentValues.put(DBDefinition.RETRY_SCHEDULE_MINUTES, Integer.valueOf(this.retryScheduleMinutes));
        contentValues.put(DBDefinition.INDEPENDENT_PROCESS, Integer.valueOf(this.needIndependentProcess ? 1 : 0));
        contentValues.put(DBDefinition.AUXILIARY_JSONOBJECT_STRING, getDBJsonDataString());
        contentValues.put(DBDefinition.ICON_URL, this.iconUrl);
        contentValues.put(DBDefinition.APP_VERSION_CODE, Integer.valueOf(this.appVersionCode));
        contentValues.put(DBDefinition.TASK_ID, this.taskId);
        return contentValues;
    }

    public String toString() {
        return "DownloadInfo{id=" + this.id + ", name='" + this.name + "', title='" + this.title + "', url='" + this.url + "', savePath='" + this.savePath + "'}";
    }

    public boolean trySwitchToNextBackupUrl() {
        if (this.backUpUrlUsed) {
            this.curBackUpUrlIndex++;
        }
        List<String> list = this.backUpUrls;
        if (list != null && list.size() != 0 && this.curBackUpUrlIndex >= 0) {
            while (this.curBackUpUrlIndex < this.backUpUrls.size()) {
                if (!TextUtils.isEmpty(this.backUpUrls.get(this.curBackUpUrlIndex))) {
                    this.backUpUrlUsed = true;
                    return true;
                }
                this.curBackUpUrlIndex++;
            }
        }
        return false;
    }

    public void updateCurRetryTime(int i2) {
        int i3 = (this.backUpUrlUsed ? this.backUpUrlRetryCount : this.retryCount) - i2;
        this.curRetryTime = i3;
        if (i3 < 0) {
            this.curRetryTime = 0;
        }
    }

    public void updateDownloadTime() {
        if (this.startDownloadTime == 0) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.startDownloadTime;
        if (this.downloadTime < 0) {
            this.downloadTime = 0L;
        }
        if (uptimeMillis > 0) {
            this.downloadTime = uptimeMillis;
        }
    }

    public void updateRealDownloadTime(boolean z) {
        long nanoTime = System.nanoTime();
        long j2 = this.realStartDownloadTime;
        if (j2 <= 0) {
            if (z) {
                this.realStartDownloadTime = nanoTime;
                return;
            }
            return;
        }
        long j3 = nanoTime - j2;
        if (z) {
            this.realStartDownloadTime = nanoTime;
        } else {
            this.realStartDownloadTime = 0L;
        }
        if (j3 > 0) {
            this.realDownloadTime += j3;
        }
    }

    public void updateRealStartDownloadTime() {
        if (this.realStartDownloadTime == 0) {
            this.realStartDownloadTime = System.nanoTime();
        }
    }

    public void updateSpData() {
        Context appContext;
        if (this.spData == null || (appContext = DownloadComponentManager.getAppContext()) == null) {
            return;
        }
        appContext.getSharedPreferences(DownloadConstants.SP_DOWNLOAD_INFO, 0).edit().putString(Integer.toString(getId()), this.spData.toString()).apply();
    }

    public void updateStartDownloadTime() {
        this.startDownloadTime = SystemClock.uptimeMillis();
        safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_LAST_START_DOWNLOAD_TIME, Long.valueOf(System.currentTimeMillis()));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.title);
        parcel.writeString(this.url);
        parcel.writeString(this.savePath);
        parcel.writeString(this.tempPath);
        parcel.writeByte(this.onlyWifi ? (byte) 1 : (byte) 0);
        parcel.writeString(this.extra);
        parcel.writeTypedList(this.extraHeaders);
        parcel.writeInt(this.maxBytes);
        parcel.writeStringArray(this.outIp);
        parcel.writeIntArray(this.outSize);
        parcel.writeInt(this.retryCount);
        parcel.writeInt(this.backUpUrlRetryCount);
        parcel.writeByte(this.force ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.needPostProgress ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.maxProgressCount);
        parcel.writeInt(this.minProgressTimeMsInterval);
        parcel.writeStringList(this.backUpUrls);
        parcel.writeByte(this.showNotification ? (byte) 1 : (byte) 0);
        parcel.writeString(this.mimeType);
        parcel.writeByte(this.needHttpsToHttpRetry ? (byte) 1 : (byte) 0);
        parcel.writeString(this.packageName);
        parcel.writeString(this.md5);
        parcel.writeByte(this.needRetryDelay ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.needDefaultHttpServiceBackUp ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.needReuseChunkRunnable ? (byte) 1 : (byte) 0);
        parcel.writeString(this.retryDelayTimeArray);
        parcel.writeString(this.eTag);
        parcel.writeInt(this.curRetryTime);
        parcel.writeInt(this.retryDelayStatus.ordinal());
        parcel.writeByte(this.needReuseFirstConnection ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.forceIgnoreRecommendSize ? (byte) 1 : (byte) 0);
        parcel.writeString(this.networkQuality);
        parcel.writeInt(this.curBackUpUrlIndex);
        parcel.writeInt(this.notificationVisibility);
        parcel.writeInt(this.chunkCount);
        parcel.writeLong(getCurBytes());
        parcel.writeLong(this.totalBytes);
        parcel.writeInt(getRealStatus());
        parcel.writeLong(this.downloadTime);
        parcel.writeLong(this.realDownloadTime);
        parcel.writeByte(this.backUpUrlUsed ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.httpsToHttpRetryUsed ? (byte) 1 : (byte) 0);
        StringBuffer stringBuffer = this.errorBytesLog;
        parcel.writeString(stringBuffer != null ? stringBuffer.toString() : "");
        parcel.writeByte(this.autoResumed ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.showNotificationForAutoResumed ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.showNotificationForNetworkResumed ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.forbiddenBackupUrls);
        parcel.writeByte(this.needIndependentProcess ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.enqueueType.ordinal());
        parcel.writeByte(this.headConnectionAvailable ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.httpStatusCode);
        parcel.writeString(this.httpStatusMessage);
        parcel.writeByte(this.isSaveTempFile ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isForbiddenRetryed ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.addListenerToSameTask ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.needChunkDowngradeRetry ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.chunkDowngradeRetryUsed ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.failedException, i2);
        parcel.writeInt(this.retryScheduleMinutes);
        parcel.writeString(getDBJsonDataString());
        parcel.writeByte(this.supportPartial ? (byte) 1 : (byte) 0);
        parcel.writeString(this.iconUrl);
        parcel.writeInt(this.appVersionCode);
        parcel.writeString(this.taskId);
        parcel.writeByte(this.expiredRedownload ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.deleteCacheIfCheckFailed ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.successByCache ? (byte) 1 : (byte) 0);
    }

    public DownloadInfo() {
        this.needDefaultHttpServiceBackUp = true;
        this.retryDelayStatus = RetryDelayStatus.DELAY_RETRY_NONE;
        this.needReuseFirstConnection = false;
        this.asyncHandleStatus = AsyncHandleStatus.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.lastNotifyProgressTime = new AtomicLong(0L);
        this.isAutoInstallWithoutNotification = null;
    }

    public void setCurBytes(long j2, boolean z) {
        if (z) {
            setCurBytes(j2);
        } else if (j2 > getCurBytes()) {
            setCurBytes(j2);
        }
    }

    public static class Builder {
        private boolean addListenerToSameTask;
        private int appVersionCode;
        private boolean autoResumed;
        private int backUpUrlRetryCount;
        private List<String> backUpUrls;
        private boolean deleteCacheIfCheckFailed;
        private boolean distinctDirectory;
        private JSONObject downloadSetting;
        private int executorGroup;
        private long expectFileLength;
        private boolean expiredRedownload;
        private String extra;
        private List<HttpHeader> extraHeaders;
        private int[] extraMonitorStatus;
        private boolean force;
        private boolean headConnectionAvailable;
        private String iconUrl;
        private boolean ignoreDataVerify;
        private int maxBytes;
        private int maxProgressCount;
        private String md5;
        private String mimeType;
        private int minProgressTimeMsInterval;
        private String monitorScene;
        private String name;
        private boolean needChunkDowngradeRetry;
        private boolean needHttpsToHttpRetry;
        private boolean needIndependentProcess;
        private boolean needRetryDelay;
        private boolean needReuseChunkRunnable;
        private boolean needReuseFirstConnection;
        private boolean onlyWifi;
        private boolean openLimitSpeed;
        private String[] outIp;
        private int[] outSize;
        private String packageName;
        private int retryCount;
        private String retryDelayTimeArray;
        private String savePath;
        private boolean showNotification;
        private boolean showNotificationForAutoResumed;
        private String tempPath;
        private long throttleNetSpeed;
        private String title;
        private long ttnetProtectTimeout;
        private String url;
        private boolean needPostProgress = true;
        private boolean autoInstall = true;
        private boolean needDefaultHttpServiceBackUp = true;
        private EnqueueType enqueueType = EnqueueType.ENQUEUE_NONE;
        private boolean needSDKMonitor = true;

        public Builder() {
        }

        public Builder addListenerToSameTask(boolean z) {
            this.addListenerToSameTask = z;
            return this;
        }

        public Builder autoResumed(boolean z) {
            this.autoResumed = z;
            return this;
        }

        public Builder backUpUrlRetryCount(int i2) {
            this.backUpUrlRetryCount = i2;
            return this;
        }

        public Builder backUpUrls(List<String> list) {
            this.backUpUrls = list;
            return this;
        }

        public DownloadInfo build() {
            return new DownloadInfo(this);
        }

        public Builder deleteCacheIfCheckFailed(boolean z) {
            this.deleteCacheIfCheckFailed = z;
            return this;
        }

        public Builder distinctDirectory(boolean z) {
            this.distinctDirectory = z;
            return this;
        }

        public Builder downloadSetting(JSONObject jSONObject) {
            this.downloadSetting = jSONObject;
            return this;
        }

        public Builder enqueueType(EnqueueType enqueueType) {
            this.enqueueType = enqueueType;
            return this;
        }

        public Builder executorGroup(int i2) {
            this.executorGroup = i2;
            return this;
        }

        public Builder expectFileLength(long j2) {
            this.expectFileLength = j2;
            return this;
        }

        public Builder expiredRedownload(boolean z) {
            this.expiredRedownload = z;
            return this;
        }

        public Builder extra(String str) {
            this.extra = str;
            return this;
        }

        public Builder extraHeaders(List<HttpHeader> list) {
            this.extraHeaders = list;
            return this;
        }

        public Builder extraMonitorStatus(int[] iArr) {
            this.extraMonitorStatus = iArr;
            return this;
        }

        public Builder force(boolean z) {
            this.force = z;
            return this;
        }

        public Builder headConnectionAvailable(boolean z) {
            this.headConnectionAvailable = z;
            return this;
        }

        public Builder iconUrl(String str) {
            this.iconUrl = str;
            return this;
        }

        public Builder ignoreDataVerify(boolean z) {
            this.ignoreDataVerify = z;
            return this;
        }

        public Builder isOpenLimitSpeed(boolean z) {
            this.openLimitSpeed = z;
            return this;
        }

        public Builder maxBytes(int i2) {
            this.maxBytes = i2;
            return this;
        }

        public Builder maxProgressCount(int i2) {
            this.maxProgressCount = i2;
            return this;
        }

        public Builder md5(String str) {
            this.md5 = str;
            return this;
        }

        public Builder mimeType(String str) {
            this.mimeType = str;
            return this;
        }

        public Builder minProgressTimeMsInterval(int i2) {
            this.minProgressTimeMsInterval = i2;
            return this;
        }

        public Builder monitorScene(String str) {
            this.monitorScene = str;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder needChunkDowngradeRetry(boolean z) {
            this.needChunkDowngradeRetry = z;
            return this;
        }

        public Builder needDefaultHttpServiceBackUp(boolean z) {
            this.needDefaultHttpServiceBackUp = z;
            return this;
        }

        public Builder needHttpsToHttpRetry(boolean z) {
            this.needHttpsToHttpRetry = z;
            return this;
        }

        public Builder needIndependentProcess(boolean z) {
            this.needIndependentProcess = z;
            return this;
        }

        public Builder needPostProgress(boolean z) {
            this.needPostProgress = z;
            return this;
        }

        public Builder needRetryDelay(boolean z) {
            this.needRetryDelay = z;
            return this;
        }

        public Builder needReuseChunkRunnable(boolean z) {
            this.needReuseChunkRunnable = z;
            return this;
        }

        public Builder needReuseFirstConnection(boolean z) {
            this.needReuseFirstConnection = z;
            return this;
        }

        public Builder needSDKMonitor(boolean z) {
            this.needSDKMonitor = z;
            return this;
        }

        public Builder onlyWifi(boolean z) {
            this.onlyWifi = z;
            return this;
        }

        public Builder outIp(String[] strArr) {
            this.outIp = strArr;
            return this;
        }

        public Builder outSize(int[] iArr) {
            this.outSize = iArr;
            return this;
        }

        public Builder packageName(String str) {
            this.packageName = str;
            return this;
        }

        public Builder retryCount(int i2) {
            this.retryCount = i2;
            return this;
        }

        public Builder retryDelayTimeArray(String str) {
            this.retryDelayTimeArray = str;
            return this;
        }

        public Builder savePath(String str) {
            this.savePath = str;
            return this;
        }

        public Builder setAutoInstall(boolean z) {
            this.autoInstall = z;
            return this;
        }

        public Builder showNotification(boolean z) {
            this.showNotification = z;
            return this;
        }

        public Builder showNotificationForAutoResumed(boolean z) {
            this.showNotificationForAutoResumed = z;
            return this;
        }

        public Builder tempPath(String str) {
            this.tempPath = str;
            return this;
        }

        public Builder throttleNetSpeed(long j2) {
            this.throttleNetSpeed = j2;
            return this;
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public Builder ttnetProtectTimeout(long j2) {
            this.ttnetProtectTimeout = j2;
            return this;
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }

        public Builder(String str) {
            this.url = str;
        }
    }

    private DownloadInfo(Builder builder) {
        this.needDefaultHttpServiceBackUp = true;
        this.retryDelayStatus = RetryDelayStatus.DELAY_RETRY_NONE;
        this.needReuseFirstConnection = false;
        this.asyncHandleStatus = AsyncHandleStatus.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.lastNotifyProgressTime = new AtomicLong(0L);
        this.isAutoInstallWithoutNotification = null;
        if (builder == null) {
            return;
        }
        this.name = builder.name;
        this.title = builder.title;
        this.url = builder.url;
        String str = builder.savePath;
        if (TextUtils.isEmpty(str)) {
            try {
                str = DownloadUtils.getDownloadPath();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.savePath = str;
        String str2 = builder.tempPath;
        this.tempPath = str2;
        if (TextUtils.isEmpty(str2) && !DownloadUtils.isSavePathSecurity(str)) {
            this.tempPath = DownloadUtils.getDownloadTempPath();
        }
        if (builder.distinctDirectory) {
            if (DownloadComponentManager.getDownloadCache().getDownloadInfo(getId()) == null) {
                this.savePath = DownloadUtils.generateDistinctDirectory(this.savePath, this.url);
                this.tempPath = DownloadUtils.generateDistinctDirectory(this.tempPath, this.url);
            }
        } else {
            Logger.e(TAG, "The distinct directory option is not set, which may cause 1005 problems and file downloads being covered");
        }
        this.status = new AtomicInteger(0);
        this.curBytes = new AtomicLong(0L);
        this.extra = builder.extra;
        this.onlyWifi = builder.onlyWifi;
        this.extraHeaders = builder.extraHeaders;
        this.maxBytes = builder.maxBytes;
        this.retryCount = builder.retryCount;
        this.backUpUrlRetryCount = builder.backUpUrlRetryCount;
        this.force = builder.force;
        this.outIp = builder.outIp;
        this.outSize = builder.outSize;
        this.needPostProgress = builder.needPostProgress;
        this.maxProgressCount = builder.maxProgressCount;
        this.minProgressTimeMsInterval = builder.minProgressTimeMsInterval;
        this.backUpUrls = builder.backUpUrls;
        this.showNotification = builder.showNotification;
        this.mimeType = builder.mimeType;
        this.needHttpsToHttpRetry = builder.needHttpsToHttpRetry;
        this.needRetryDelay = builder.needRetryDelay;
        this.retryDelayTimeArray = builder.retryDelayTimeArray;
        this.autoResumed = builder.autoResumed;
        this.showNotificationForAutoResumed = builder.showNotificationForAutoResumed;
        this.needDefaultHttpServiceBackUp = builder.needDefaultHttpServiceBackUp;
        this.needReuseChunkRunnable = builder.needReuseChunkRunnable;
        this.packageName = builder.packageName;
        this.md5 = builder.md5;
        this.needReuseFirstConnection = builder.needReuseFirstConnection;
        this.needIndependentProcess = builder.needIndependentProcess;
        this.enqueueType = builder.enqueueType;
        this.headConnectionAvailable = builder.headConnectionAvailable;
        this.ignoreDataVerify = builder.ignoreDataVerify;
        this.addListenerToSameTask = builder.addListenerToSameTask;
        this.needChunkDowngradeRetry = builder.needChunkDowngradeRetry;
        this.iconUrl = builder.iconUrl;
        this.throttleNetSpeed = builder.throttleNetSpeed;
        this.openLimitSpeed = builder.openLimitSpeed;
        JSONObject jSONObject = builder.downloadSetting;
        if (jSONObject != null) {
            safePutToDBJsonData(DbJsonConstants.DOWNLOAD_SETTING, jSONObject.toString());
        }
        safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_EXPECT_FILE_LENGTH, Long.valueOf(builder.expectFileLength));
        safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_EXECUTOR, Integer.valueOf(builder.executorGroup));
        safePutToDBJsonData(DbJsonConstants.AUTO_INSTALL, Integer.valueOf(builder.autoInstall ? 1 : 0));
        this.needSDKMonitor = builder.needSDKMonitor;
        this.monitorScene = builder.monitorScene;
        this.extraMonitorStatus = builder.extraMonitorStatus;
        this.expiredRedownload = builder.expiredRedownload;
        this.deleteCacheIfCheckFailed = builder.deleteCacheIfCheckFailed;
        this.ttnetProtectTimeout = builder.ttnetProtectTimeout;
        this.distinctDirectory = builder.distinctDirectory;
        if (this.expiredRedownload && this.retryCount <= 0) {
            this.retryCount = 1;
        }
        putMonitorSetting();
    }

    protected DownloadInfo(Parcel parcel) {
        this.needDefaultHttpServiceBackUp = true;
        this.retryDelayStatus = RetryDelayStatus.DELAY_RETRY_NONE;
        this.needReuseFirstConnection = false;
        this.asyncHandleStatus = AsyncHandleStatus.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.lastNotifyProgressTime = new AtomicLong(0L);
        this.isAutoInstallWithoutNotification = null;
        readFromParcel(parcel);
    }

    public DownloadInfo(Cursor cursor) {
        boolean z = true;
        this.needDefaultHttpServiceBackUp = true;
        RetryDelayStatus retryDelayStatus = RetryDelayStatus.DELAY_RETRY_NONE;
        this.retryDelayStatus = retryDelayStatus;
        this.needReuseFirstConnection = false;
        this.asyncHandleStatus = AsyncHandleStatus.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.lastNotifyProgressTime = new AtomicLong(0L);
        this.isAutoInstallWithoutNotification = null;
        if (cursor == null) {
            return;
        }
        try {
            int columnIndex = cursor.getColumnIndex("_id");
            if (columnIndex != -1) {
                this.id = cursor.getInt(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex("name");
            if (columnIndex2 != -1) {
                this.name = cursor.getString(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("title");
            if (columnIndex3 != -1) {
                this.title = cursor.getString(columnIndex3);
            }
            int columnIndex4 = cursor.getColumnIndex("url");
            if (columnIndex4 != -1) {
                this.url = cursor.getString(columnIndex4);
            }
            int columnIndex5 = cursor.getColumnIndex(DBDefinition.SAVE_PATH);
            if (columnIndex5 != -1) {
                this.savePath = cursor.getString(columnIndex5);
            }
            int columnIndex6 = cursor.getColumnIndex(DBDefinition.TEMP_PATH);
            if (columnIndex6 != -1) {
                this.tempPath = cursor.getString(columnIndex6);
            }
            int columnIndex7 = cursor.getColumnIndex(DBDefinition.CHUNK_COUNT);
            if (columnIndex7 != -1) {
                this.chunkCount = cursor.getInt(columnIndex7);
            }
            int columnIndex8 = cursor.getColumnIndex("status");
            if (columnIndex8 != -1) {
                this.status = new AtomicInteger(cursor.getInt(columnIndex8));
            } else {
                this.status = new AtomicInteger(0);
            }
            int columnIndex9 = cursor.getColumnIndex(DBDefinition.CUR_BYTES);
            if (columnIndex9 != -1) {
                this.curBytes = new AtomicLong(cursor.getLong(columnIndex9));
            } else {
                this.curBytes = new AtomicLong(0L);
            }
            int columnIndex10 = cursor.getColumnIndex(DBDefinition.TOTAL_BYTES);
            if (columnIndex10 != -1) {
                this.totalBytes = cursor.getLong(columnIndex10);
            }
            int columnIndex11 = cursor.getColumnIndex(DBDefinition.ETAG);
            if (columnIndex11 != -1) {
                this.eTag = cursor.getString(columnIndex11);
            }
            int columnIndex12 = cursor.getColumnIndex(DBDefinition.ONLY_WIFI);
            if (columnIndex12 != -1) {
                this.onlyWifi = cursor.getInt(columnIndex12) != 0;
            }
            int columnIndex13 = cursor.getColumnIndex("force");
            if (columnIndex13 != -1) {
                this.force = cursor.getInt(columnIndex13) != 0;
            }
            int columnIndex14 = cursor.getColumnIndex(DBDefinition.RETRY_COUNT);
            if (columnIndex14 != -1) {
                this.retryCount = cursor.getInt(columnIndex14);
            }
            int columnIndex15 = cursor.getColumnIndex("extra");
            if (columnIndex15 != -1) {
                this.extra = cursor.getString(columnIndex15);
            }
            int columnIndex16 = cursor.getColumnIndex(DBDefinition.MIME_TYPE);
            if (columnIndex16 != -1) {
                this.mimeType = cursor.getString(columnIndex16);
            }
            int columnIndex17 = cursor.getColumnIndex(DBDefinition.NOTIFICATION_ENABLE);
            if (columnIndex17 != -1) {
                this.showNotification = cursor.getInt(columnIndex17) != 0;
            }
            int columnIndex18 = cursor.getColumnIndex(DBDefinition.NOTIFICATION_VISIBILITY);
            if (columnIndex18 != -1) {
                this.notificationVisibility = cursor.getInt(columnIndex18);
            }
            int columnIndex19 = cursor.getColumnIndex(DBDefinition.FIRST_DOWNLOAD);
            if (columnIndex19 != -1) {
                this.isFirstDownload = cursor.getInt(columnIndex19) == 1;
            }
            int columnIndex20 = cursor.getColumnIndex(DBDefinition.FIRST_SUCCESS);
            if (columnIndex20 != -1) {
                this.isFirstSuccess = cursor.getInt(columnIndex20) == 1;
            }
            int columnIndex21 = cursor.getColumnIndex(DBDefinition.NEED_HTTPS_TO_HTTP_RETRY);
            if (columnIndex21 != -1) {
                this.needHttpsToHttpRetry = cursor.getInt(columnIndex21) == 1;
            }
            int columnIndex22 = cursor.getColumnIndex(DBDefinition.DOWNLOAD_TIME);
            if (columnIndex22 != -1) {
                this.downloadTime = cursor.getLong(columnIndex22);
            }
            int columnIndex23 = cursor.getColumnIndex(DBDefinition.PACKAGE_NAME);
            if (columnIndex23 != -1) {
                this.packageName = cursor.getString(columnIndex23);
            }
            int columnIndex24 = cursor.getColumnIndex("md5");
            if (columnIndex24 != -1) {
                this.md5 = cursor.getString(columnIndex24);
            }
            int columnIndex25 = cursor.getColumnIndex(DBDefinition.RETRY_DELAY);
            if (columnIndex25 != -1) {
                this.needRetryDelay = cursor.getInt(columnIndex25) == 1;
            }
            int columnIndex26 = cursor.getColumnIndex(DBDefinition.CUR_RETRY_TIME);
            if (columnIndex26 != -1) {
                this.curRetryTime = cursor.getInt(columnIndex26);
            }
            int columnIndex27 = cursor.getColumnIndex(DBDefinition.RETRY_DELAY_STATUS);
            if (columnIndex27 != -1) {
                int i2 = cursor.getInt(columnIndex27);
                RetryDelayStatus retryDelayStatus2 = RetryDelayStatus.DELAY_RETRY_WAITING;
                if (i2 == retryDelayStatus2.ordinal()) {
                    this.retryDelayStatus = retryDelayStatus2;
                } else {
                    RetryDelayStatus retryDelayStatus3 = RetryDelayStatus.DELAY_RETRY_DOWNLOADING;
                    if (i2 == retryDelayStatus3.ordinal()) {
                        this.retryDelayStatus = retryDelayStatus3;
                    } else {
                        RetryDelayStatus retryDelayStatus4 = RetryDelayStatus.DELAY_RETRY_DOWNLOADED;
                        if (i2 == retryDelayStatus4.ordinal()) {
                            this.retryDelayStatus = retryDelayStatus4;
                        } else {
                            this.retryDelayStatus = retryDelayStatus;
                        }
                    }
                }
            }
            int columnIndex28 = cursor.getColumnIndex(DBDefinition.DEFAULT_HTTP_SERVICE_BACKUP);
            if (columnIndex28 != -1) {
                this.needDefaultHttpServiceBackUp = cursor.getInt(columnIndex28) == 1;
            }
            int columnIndex29 = cursor.getColumnIndex(DBDefinition.CHUNK_RUNNABLE_REUSE);
            if (columnIndex29 != -1) {
                this.needReuseChunkRunnable = cursor.getInt(columnIndex29) == 1;
            }
            int columnIndex30 = cursor.getColumnIndex(DBDefinition.RETRY_DELAY_TIME_ARRAY);
            if (columnIndex30 != -1) {
                this.retryDelayTimeArray = cursor.getString(columnIndex30);
            }
            int columnIndex31 = cursor.getColumnIndex(DBDefinition.CHUNK_DOWNGRADE_RETRY);
            if (columnIndex31 != -1) {
                this.needChunkDowngradeRetry = cursor.getInt(columnIndex31) == 1;
            }
            int columnIndex32 = cursor.getColumnIndex(DBDefinition.BACKUP_URLS_STR);
            if (columnIndex32 != -1) {
                setBackUpUrlsStr(cursor.getString(columnIndex32));
            }
            int columnIndex33 = cursor.getColumnIndex(DBDefinition.BACKUP_URL_RETRY_COUNT);
            if (columnIndex33 != -1) {
                this.backUpUrlRetryCount = cursor.getInt(columnIndex33);
            }
            int columnIndex34 = cursor.getColumnIndex(DBDefinition.REAL_DOWNLOAD_TIME);
            if (columnIndex34 != -1) {
                this.realDownloadTime = cursor.getLong(columnIndex34);
            }
            int columnIndex35 = cursor.getColumnIndex(DBDefinition.RETRY_SCHEDULE_MINUTES);
            if (columnIndex35 != -1) {
                this.retryScheduleMinutes = cursor.getInt(columnIndex35);
            }
            int columnIndex36 = cursor.getColumnIndex(DBDefinition.INDEPENDENT_PROCESS);
            if (columnIndex36 != -1) {
                if (cursor.getInt(columnIndex36) != 1) {
                    z = false;
                }
                this.needIndependentProcess = z;
            }
            int columnIndex37 = cursor.getColumnIndex(DBDefinition.AUXILIARY_JSONOBJECT_STRING);
            if (columnIndex37 != -1) {
                this.dbJsonDataString = cursor.getString(columnIndex37);
            }
            int columnIndex38 = cursor.getColumnIndex(DBDefinition.ICON_URL);
            if (columnIndex38 != -1) {
                this.iconUrl = cursor.getString(columnIndex38);
            }
            int columnIndex39 = cursor.getColumnIndex(DBDefinition.APP_VERSION_CODE);
            if (columnIndex39 != -1) {
                this.appVersionCode = cursor.getInt(columnIndex39);
            }
            int columnIndex40 = cursor.getColumnIndex(DBDefinition.TASK_ID);
            if (columnIndex40 != -1) {
                this.taskId = cursor.getString(columnIndex40);
            }
            parseMonitorSetting();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
