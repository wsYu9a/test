package com.vivo.ic.dm;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.vivo.ic.VLog;
import com.vivo.ic.dm.Downloads;
import com.vivo.network.okhttp3.OkHttpClient;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: classes4.dex */
public class DownloadInfo {
    private static final long MIN_RETYR_TIME = 500;
    private static final String PARAM_UNCHECK_WIFI = "wifi need auth by vsp id ";
    private static final String TAG = Constants.PRE_TAG + "DownloadInfo";
    private String mActualPath;
    private String mAddress;
    private int mAllowedNetType;
    private String mAppExtraFive;
    private String mAppExtraFour;
    private String mAppExtraOne;
    private String mAppExtraThree;
    private String mAppExtraTwo;
    private String mCheckSum;
    private boolean mCompleteShown;
    private final Context mContext;
    private int mControl;
    private String mCookies;
    private long mCurrentBytes;
    private String mDescription;
    private int mDownloadType;
    private String mETag;
    private String mErrorMsg;
    private String mExtras;
    private String mFileName;
    private int mFuzz;
    private String mHint;
    private long mId;
    private volatile boolean mIsDownloading;
    private boolean mIsModify;
    protected volatile long mLastBytes;
    private long mLastMod;

    @Deprecated
    public int mLastNetwork;
    protected volatile long mLastTime;
    private int mMediaScanned;
    private String mMimeType;
    private Object mModifyLock;
    private int mNetworkChanged;
    private int mNumFailed;
    private String mPackageName;
    private String mProxyAuth;
    private int mRecomNetType;
    private String mRedirectUrl;
    private String mReferer;
    private OkHttpClient mRequestClient;
    private List<Pair<String, String>> mRequestHeaders;
    private volatile String mRequestUri;
    private boolean mResume;
    private int mRetryAfter;
    private boolean mSkipHttpsVerify;
    private long mSpeed;
    private long mStartTime;
    private int mStatus;
    private Future<?> mSubmittedTask;
    private boolean mSupportBreakPoint;
    private String mTitle;
    private long mTotalBytes;
    private String mUri;
    private String mUserAgent;
    private int mVisibility;

    public enum NetworkState {
        OK,
        NO_CONNECTION,
        BLOCKED,
        MOBILE,
        WIFI
    }

    /* synthetic */ DownloadInfo(Context context, AnonymousClass1 anonymousClass1) {
        this(context);
    }

    private ContentValues buildContentValues() {
        if (!this.mIsModify) {
            VLog.i(TAG, "data not changed");
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(Downloads.Column.ETAG, this.mETag);
        contentValues.put("title", this.mTitle);
        contentValues.put(Downloads.Column.DATA, this.mFileName);
        contentValues.put(Downloads.Column.ACTUAL_PATH, this.mActualPath);
        contentValues.put(Downloads.Column.REDIRECT_URL, this.mRedirectUrl);
        contentValues.put("mimetype", this.mMimeType);
        contentValues.put("uri", this.mUri);
        contentValues.put(Downloads.Column.RETRY_AFTER_X_REDIRECT_COUNT, Integer.valueOf(this.mRetryAfter));
        contentValues.put("total_bytes", Long.valueOf(this.mTotalBytes));
        contentValues.put(Downloads.Column.CURRENT_BYTES, Long.valueOf(this.mCurrentBytes));
        contentValues.put(Downloads.Column.CURRENT_SPEED, Long.valueOf(this.mSpeed));
        contentValues.put("status", Integer.valueOf(this.mStatus));
        contentValues.put("error_msg", this.mErrorMsg);
        contentValues.put(Downloads.Column.FAILED_CONNECTIONS, Integer.valueOf(this.mNumFailed));
        contentValues.put(Downloads.Column.DOWNLOAD_TYPE, Integer.valueOf(this.mDownloadType));
        contentValues.put(Downloads.Column.LAST_MODIFICATION, Long.valueOf(System.currentTimeMillis()));
        return contentValues;
    }

    public static int queryDownloadColumnInt(ContentResolver contentResolver, long j2, String str) {
        Cursor cursor = null;
        try {
            try {
                Cursor query = contentResolver.query(ContentUris.withAppendedId(Downloads.Impl.CONTENT_URI, j2), new String[]{str}, null, null, null);
                if (query != null && query.moveToFirst()) {
                    int i2 = query.getInt(0);
                    query.close();
                    return i2;
                }
                VLog.w(TAG, "query column  not in database, return -1");
                if (query != null) {
                    query.close();
                }
                return -1;
            } catch (Exception e2) {
                VLog.w(TAG, "queryDownloadColumnInt error", e2);
                if (0 != 0) {
                    cursor.close();
                }
                return -1;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public static int queryDownloadStatus(ContentResolver contentResolver, long j2) {
        Cursor cursor = null;
        try {
            try {
                Cursor query = contentResolver.query(ContentUris.withAppendedId(Downloads.Impl.CONTENT_URI, j2), new String[]{"status"}, null, null, null);
                if (query != null && query.moveToFirst()) {
                    int i2 = query.getInt(0);
                    query.close();
                    return i2;
                }
                VLog.w(TAG, "queryDownloadStatus not in database, return success!!!");
                if (query != null) {
                    query.close();
                }
                return 200;
            } catch (Exception e2) {
                VLog.w(TAG, "queryDownloadStatus error", e2);
                if (0 != 0) {
                    cursor.close();
                }
                return -1;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public static int updateDownloadColumnInt(ContentResolver contentResolver, long j2, String str, int i2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, Integer.valueOf(i2));
            return contentResolver.update(ContentUris.withAppendedId(Downloads.Impl.CONTENT_URI, j2), contentValues, null, null);
        } catch (Exception unused) {
            VLog.d(TAG, "updateDownloadColumnInt failed");
            return -1;
        }
    }

    public NetworkState checkCanUseNetwork() {
        NetworkInfo a2 = com.vivo.ic.dm.util.b.a();
        return (a2 == null || !a2.isConnected()) ? NetworkState.NO_CONNECTION : NetworkInfo.DetailedState.BLOCKED.equals(a2.getDetailedState()) ? NetworkState.BLOCKED : (a2.getType() != 0 || (l.j().o() && this.mAllowedNetType != 2)) ? NetworkState.OK : NetworkState.MOBILE;
    }

    public boolean checkSelf() {
        int i2 = this.mControl;
        if (i2 == 1) {
            setStatus(Downloads.Impl.STATUS_PAUSED_BY_APP);
            setErrorMsg("download paused by repair");
            VLog.i(TAG, "repair :" + this.mTitle + " to " + this.mStatus);
            return true;
        }
        if (i2 == 0 && this.mStatus == 193) {
            String str = this.mErrorMsg;
            if (str == null || !str.startsWith(PARAM_UNCHECK_WIFI)) {
                setStatus(Downloads.Impl.STATUS_PENDING);
                VLog.i(TAG, "repair run :" + this.mTitle + " to " + this.mStatus);
                return true;
            }
            VLog.i(TAG, "pause by uncheck wifi");
        }
        return false;
    }

    public String getActualPath() {
        return this.mActualPath;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public String getAllowedNetType() {
        int i2 = this.mAllowedNetType;
        return i2 != 0 ? i2 != 2 ? "" : com.alipay.mobilesecuritysdk.constant.a.I : "mobile_and_wifi";
    }

    public String getAppExtraFive() {
        return this.mAppExtraFive;
    }

    public String getAppExtraFour() {
        return this.mAppExtraFour;
    }

    public String getAppExtraOne() {
        return this.mAppExtraOne;
    }

    public String getAppExtraThree() {
        return this.mAppExtraThree;
    }

    public String getAppExtraTwo() {
        return this.mAppExtraTwo;
    }

    public String getCheckSum() {
        return this.mCheckSum;
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getControl() {
        return this.mControl;
    }

    public String getCookies() {
        return this.mCookies;
    }

    public long getCurrentBytes() {
        return this.mCurrentBytes;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public int getDownloadType() {
        return this.mDownloadType;
    }

    public Uri getDownloadsUri() {
        return ContentUris.withAppendedId(Downloads.Impl.CONTENT_URI, this.mId);
    }

    public String getETag() {
        return this.mETag;
    }

    public String getErrorMsg() {
        return this.mErrorMsg;
    }

    public String getExtras() {
        return this.mExtras;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public int getFuzz() {
        return this.mFuzz;
    }

    public Collection<Pair<String, String>> getHeaders() {
        return Collections.unmodifiableList(this.mRequestHeaders);
    }

    public String getHint() {
        return this.mHint;
    }

    public long getId() {
        return this.mId;
    }

    public long getLastBytes() {
        return this.mLastBytes;
    }

    public long getLastMod() {
        return this.mLastMod;
    }

    public long getLastTime() {
        return this.mLastTime;
    }

    public int getMediaScanned() {
        return this.mMediaScanned;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    public int getNumFailed() {
        return this.mNumFailed;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public int getPauseType() {
        return this.mNetworkChanged;
    }

    public String getProxyAuth() {
        return this.mProxyAuth;
    }

    public int getRecomNetType() {
        return this.mRecomNetType;
    }

    public String getRedirectUrl() {
        return this.mRedirectUrl;
    }

    public String getReferer() {
        return this.mReferer;
    }

    public OkHttpClient getRequestClient() {
        return this.mRequestClient;
    }

    public List<Pair<String, String>> getRequestHeaders() {
        return this.mRequestHeaders;
    }

    public String getRequestUri() {
        return this.mRequestUri;
    }

    public int getRetryAfter() {
        return this.mRetryAfter;
    }

    public long getSpeed() {
        return this.mSpeed;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public Future<?> getSubmittedTask() {
        return this.mSubmittedTask;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public long getTotalBytes() {
        return this.mTotalBytes;
    }

    public String getUri() {
        return this.mUri;
    }

    public String getUserAgent() {
        String str = this.mUserAgent;
        return str != null ? str : Constants.DEFAULT_USER_AGENT;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public boolean isCompleteShown() {
        return this.mCompleteShown;
    }

    public boolean isDownloading() {
        return this.mIsDownloading;
    }

    public boolean isDownloadingByUI() {
        if (this.mControl == 1) {
            return false;
        }
        int i2 = this.mStatus;
        if (i2 != 0 && i2 != 190 && i2 != 192 && i2 != 2000) {
            switch (i2) {
                case Downloads.Impl.STATUS_WAITING_TO_RETRY /* 194 */:
                case Downloads.Impl.STATUS_WAITING_FOR_NETWORK /* 195 */:
                case 196:
                    break;
                default:
                    switch (i2) {
                        case Downloads.Impl.STATUS_INSUFFICIENT_SPACE_ERROR /* 198 */:
                            VLog.w(TAG, "download not ready because of STATUS_INSUFFICIENT_SPACE_ERROR " + this.mId);
                            break;
                        case 199:
                            VLog.w(TAG, "download not ready because of STATUS_DEVICE_NOT_FOUND_ERROR " + this.mId);
                            break;
                        default:
                            VLog.w(TAG, "download not ready because of unknow status " + this.mStatus);
                        case 200:
                            return false;
                    }
            }
            return false;
        }
        return true;
    }

    public boolean isModify() {
        return this.mIsModify;
    }

    public boolean isReadyToDownload() {
        String str = TAG;
        VLog.w(str, "isReadyToDownload() mStatus: " + this.mStatus + " mControl: " + this.mControl);
        if (this.mControl == 1) {
            return false;
        }
        int i2 = this.mStatus;
        if (i2 == 0 || i2 == 190 || i2 == 192 || i2 == 2000) {
            return true;
        }
        switch (i2) {
            case Downloads.Impl.STATUS_WAITING_TO_RETRY /* 194 */:
                long currentTimeMillis = System.currentTimeMillis();
                if (restartTime(currentTimeMillis) <= currentTimeMillis) {
                }
                break;
            case Downloads.Impl.STATUS_WAITING_FOR_NETWORK /* 195 */:
            case 196:
                if (checkCanUseNetwork() == NetworkState.OK) {
                }
                break;
            default:
                switch (i2) {
                    case Downloads.Impl.STATUS_INSUFFICIENT_SPACE_ERROR /* 198 */:
                        VLog.w(str, "download not ready because of STATUS_INSUFFICIENT_SPACE_ERROR " + this.mId);
                        break;
                    case 199:
                        VLog.w(str, "download not ready because of STATUS_DEVICE_NOT_FOUND_ERROR " + this.mId);
                        break;
                    default:
                        VLog.w(str, "download not ready because of unknow status " + this.mStatus);
                    case 200:
                        return false;
                }
        }
        return false;
    }

    public boolean isResume() {
        return this.mResume;
    }

    public boolean isSkipHttpsVerify() {
        return this.mSkipHttpsVerify;
    }

    public boolean isSupportBreakPoint() {
        return this.mSupportBreakPoint;
    }

    public void monitorStartTime() {
        if (this.mStartTime == -1 && this.mCurrentBytes == 0) {
            this.mStartTime = SystemClock.elapsedRealtime();
        }
    }

    public long nextActionMillis(long j2) {
        int i2 = this.mStatus;
        if (i2 == 192) {
            VLog.d(TAG, "nextActionMillis() ignore all retry");
            return 0L;
        }
        if (i2 != 194) {
            return Long.MAX_VALUE;
        }
        long restartTime = restartTime(j2);
        VLog.d(TAG, "nextActionMillis() restartTime:" + restartTime + ",now:" + j2);
        if (restartTime <= j2) {
            return 500L;
        }
        return restartTime - j2;
    }

    public long restartTime(long j2) {
        if (this.mNumFailed <= 2) {
            return j2;
        }
        VLog.d(TAG, "restartTime() mRetryAfter:" + this.mRetryAfter);
        int i2 = this.mRetryAfter;
        return i2 > 0 ? this.mLastMod + i2 : this.mLastMod + ((this.mFuzz + 1000) * 5);
    }

    public void setActualPath(String str) {
        synchronized (this.mModifyLock) {
            if (TextUtils.isEmpty(this.mActualPath) && TextUtils.isEmpty(str)) {
                return;
            }
            if (TextUtils.isEmpty(this.mActualPath) || !this.mActualPath.equals(str)) {
                this.mIsModify = true;
            }
            this.mActualPath = str;
        }
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public void setAllowedNetType(int i2) {
        this.mAllowedNetType = i2;
    }

    public void setAppExtraFive(String str) {
        this.mAppExtraFive = str;
    }

    public void setAppExtraFour(String str) {
        this.mAppExtraFour = str;
    }

    public void setAppExtraOne(String str) {
        this.mAppExtraOne = str;
    }

    public void setAppExtraThree(String str) {
        this.mAppExtraThree = str;
    }

    public void setAppExtraTwo(String str) {
        this.mAppExtraTwo = str;
    }

    public void setCompleteShown(boolean z) {
        this.mCompleteShown = z;
    }

    public void setControl(int i2) {
        this.mControl = i2;
    }

    public void setCookies(String str) {
        this.mCookies = str;
    }

    public void setCurrentBytes(long j2) {
        synchronized (this.mModifyLock) {
            if (this.mCurrentBytes != j2) {
                this.mIsModify = true;
            }
            this.mCurrentBytes = j2;
        }
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public void setDownloadType(int i2) {
        synchronized (this.mModifyLock) {
            if (this.mDownloadType != i2) {
                this.mIsModify = true;
            }
            this.mDownloadType = i2;
        }
    }

    public void setDownloading(boolean z) {
        this.mIsDownloading = z;
    }

    public void setETag(String str) {
        synchronized (this.mModifyLock) {
            if (TextUtils.isEmpty(this.mETag) && TextUtils.isEmpty(str)) {
                return;
            }
            if (TextUtils.isEmpty(this.mETag) || !this.mETag.equals(str)) {
                this.mIsModify = true;
            }
            this.mETag = str;
        }
    }

    public void setErrorMsg(String str) {
        synchronized (this.mModifyLock) {
            if (TextUtils.isEmpty(this.mErrorMsg) && TextUtils.isEmpty(str)) {
                return;
            }
            if (TextUtils.isEmpty(this.mErrorMsg) || !this.mErrorMsg.equals(str)) {
                this.mIsModify = true;
            }
            this.mErrorMsg = str;
        }
    }

    public void setExtras(String str) {
        this.mExtras = str;
    }

    public void setFileName(String str) throws IOException {
        synchronized (this.mModifyLock) {
            if (TextUtils.isEmpty(this.mFileName) && TextUtils.isEmpty(str)) {
                return;
            }
            if (TextUtils.isEmpty(this.mFileName) || !this.mFileName.equals(str)) {
                this.mIsModify = true;
            }
            this.mFileName = str;
            setActualPath(m.c(str));
        }
    }

    public void setFuzz(int i2) {
        this.mFuzz = i2;
    }

    public void setHint(String str) {
        this.mHint = str;
    }

    public void setId(long j2) {
        this.mId = j2;
    }

    public void setLastBytes(long j2) {
        this.mLastBytes = j2;
    }

    public void setLastMod(long j2) {
        this.mLastMod = j2;
    }

    public void setLastTime(long j2) {
        this.mLastTime = j2;
    }

    public void setMediaScanned(int i2) {
        this.mMediaScanned = i2;
    }

    public void setMimeType(String str) {
        synchronized (this.mModifyLock) {
            if (TextUtils.isEmpty(this.mMimeType) && TextUtils.isEmpty(str)) {
                return;
            }
            if (TextUtils.isEmpty(this.mMimeType) || !this.mMimeType.equals(str)) {
                this.mIsModify = true;
            }
            this.mMimeType = str;
        }
    }

    public void setNetworkChanged(int i2) {
        this.mNetworkChanged = i2;
    }

    public void setNumFailed(int i2) {
        synchronized (this.mModifyLock) {
            if (this.mNumFailed != i2) {
                this.mIsModify = true;
            }
            this.mNumFailed = i2;
        }
    }

    public void setPackageName(String str) {
        this.mPackageName = str;
    }

    public void setProxyAuth(String str) {
        this.mProxyAuth = str;
    }

    public void setRecomNetType(int i2) {
        this.mRecomNetType = i2;
    }

    public void setRedirectUrl(String str) {
        synchronized (this.mModifyLock) {
            if (TextUtils.isEmpty(this.mRedirectUrl) && TextUtils.isEmpty(str)) {
                return;
            }
            if (TextUtils.isEmpty(this.mRedirectUrl) || !this.mRedirectUrl.equals(str)) {
                this.mIsModify = true;
            }
            this.mRedirectUrl = str;
        }
    }

    public void setReferer(String str) {
        this.mReferer = str;
    }

    public void setRequestClient(OkHttpClient okHttpClient) {
        this.mRequestClient = okHttpClient;
    }

    public void setRequestHeaders(List<Pair<String, String>> list) {
        this.mRequestHeaders = list;
    }

    public void setRequestUri(String str) {
        this.mRequestUri = str;
    }

    public void setResume(boolean z) {
        this.mResume = z;
    }

    public void setRetryAfter(int i2) {
        synchronized (this.mModifyLock) {
            if (this.mRetryAfter != i2) {
                this.mIsModify = true;
            }
            this.mRetryAfter = i2;
        }
    }

    public void setSkipHttpsVerify(boolean z) {
        this.mSkipHttpsVerify = z;
    }

    public void setSpeed(long j2) {
        synchronized (this.mModifyLock) {
            if (this.mSpeed != j2) {
                this.mIsModify = true;
            }
            this.mSpeed = j2;
        }
    }

    public void setStartTime(long j2) {
        this.mStartTime = j2;
    }

    public void setStatus(int i2) {
        synchronized (this.mModifyLock) {
            if (this.mStatus != i2) {
                this.mIsModify = true;
            }
            this.mStatus = i2;
        }
        if (Downloads.Impl.isDownloading(i2)) {
            setErrorMsg(null);
        }
    }

    public void setSubmittedTask(Future<?> future) {
        this.mSubmittedTask = future;
    }

    public void setSupportBreakPoint(boolean z) {
        this.mSupportBreakPoint = z;
    }

    public void setTitle(String str) {
        synchronized (this.mModifyLock) {
            if (TextUtils.isEmpty(this.mTitle) && TextUtils.isEmpty(str)) {
                return;
            }
            if (TextUtils.isEmpty(this.mTitle) || !this.mTitle.equals(str)) {
                this.mIsModify = true;
            }
            this.mTitle = str;
        }
    }

    public void setTotalBytes(long j2) {
        synchronized (this.mModifyLock) {
            if (this.mTotalBytes != j2) {
                this.mIsModify = true;
            }
            this.mTotalBytes = j2;
        }
    }

    void setUnCheckWifiError() {
        setErrorMsg(PARAM_UNCHECK_WIFI + getId());
    }

    public void setUri(String str) {
        synchronized (this.mModifyLock) {
            if (TextUtils.isEmpty(this.mUri) && TextUtils.isEmpty(str)) {
                return;
            }
            if (TextUtils.isEmpty(this.mUri) || !this.mUri.equals(str)) {
                this.mIsModify = true;
            }
            this.mUri = str;
        }
    }

    public void setUserAgent(String str) {
        this.mUserAgent = str;
    }

    public void setVisibility(int i2) {
        this.mVisibility = i2;
    }

    public boolean shouldScanFile() {
        return this.mMediaScanned == 0 && Downloads.Impl.isStatusSuccess(this.mStatus);
    }

    public boolean startDownloadIfReady(ExecutorService executorService, boolean z) {
        synchronized (this) {
            boolean z2 = false;
            if (!z) {
                if (isDownloading()) {
                    VLog.e(TAG, "startDownloadIfReady error " + getTitle() + " by " + getStatus() + " is downloading");
                } else if (getStatus() == 192) {
                    new k(this.mContext, this).a(Downloads.Impl.STATUS_PENDING, "startDownloadIfReady pending");
                    VLog.w(TAG, "startDownloadIfReady error " + getTitle() + " by " + getStatus() + " is pending");
                }
                return false;
            }
            boolean isReadyToDownload = isReadyToDownload();
            Future<?> future = this.mSubmittedTask;
            if (future != null && !future.isDone()) {
                z2 = true;
            }
            String str = TAG;
            VLog.i(str, "startDownloadIfReady() isReady: " + isReadyToDownload + " isActive: " + z2);
            VLog.d(str, "mId:" + this.mId + ",mStatus:" + this.mStatus + ",mControl:" + this.mControl);
            if (isReadyToDownload && (!z2 || !this.mIsDownloading)) {
                this.mSubmittedTask = executorService.submit(new k(this.mContext, this));
            }
            return isReadyToDownload;
        }
    }

    public boolean startScanIfReady(Context context) {
        boolean shouldScanFile;
        synchronized (this) {
            shouldScanFile = shouldScanFile();
            if (shouldScanFile) {
                Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                intent.setData(Uri.parse("file://" + this.mFileName));
                context.sendBroadcast(intent);
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(Downloads.Column.MEDIA_SCANNED, (Integer) 1);
                    this.mContext.getContentResolver().update(ContentUris.withAppendedId(Downloads.Impl.CONTENT_URI, this.mId), contentValues, null, null);
                } catch (NullPointerException e2) {
                    VLog.w(TAG, "handleMessage NullPointerException with uri " + this.mId, e2);
                }
            }
        }
        return shouldScanFile;
    }

    public String toString() {
        return "[mId=" + this.mId + "]";
    }

    public int writeToDatabase(String str) {
        synchronized (this.mModifyLock) {
            ContentValues buildContentValues = buildContentValues();
            if (buildContentValues == null) {
                VLog.d(TAG, str + " not need write");
                return (int) getId();
            }
            int i2 = -1;
            try {
                i2 = this.mContext.getContentResolver().update(getDownloadsUri(), buildContentValues, null, null);
                this.mIsModify = false;
            } catch (Exception e2) {
                VLog.w(TAG, "writeToDatabase error ", e2);
            }
            VLog.d(TAG, "writeToDatabase() in: " + str + " update rows:" + i2);
            return i2;
        }
    }

    private DownloadInfo(Context context) {
        this.mModifyLock = new Object();
        this.mResume = false;
        this.mSupportBreakPoint = true;
        this.mRequestHeaders = new ArrayList();
        this.mStartTime = -1L;
        this.mIsModify = false;
        this.mIsDownloading = false;
        this.mRecomNetType = 0;
        this.mContext = context;
        this.mFuzz = new Random().nextInt(1001);
    }

    public static class Reader {
        private ContentValues mContentValues;
        private Cursor mCursor;
        private ContentValues mHeaderContentValues;
        private ContentResolver mResolver;

        public Reader(ContentResolver contentResolver, Cursor cursor) {
            this.mResolver = contentResolver;
            this.mCursor = cursor;
        }

        private void addHeader(DownloadInfo downloadInfo, String str, String str2) {
            downloadInfo.mRequestHeaders.add(Pair.create(str, str2));
        }

        private Integer getInt(String str) {
            ContentValues contentValues = this.mContentValues;
            if (contentValues == null) {
                Cursor cursor = this.mCursor;
                return Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(str)));
            }
            Integer asInteger = contentValues.getAsInteger(str);
            if (asInteger == null) {
                return -1;
            }
            return asInteger;
        }

        private Long getLong(String str) {
            ContentValues contentValues = this.mContentValues;
            if (contentValues == null) {
                Cursor cursor = this.mCursor;
                return Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(str)));
            }
            Long asLong = contentValues.getAsLong(str);
            if (asLong == null) {
                return -1L;
            }
            return asLong;
        }

        private String getString(String str) {
            ContentValues contentValues = this.mContentValues;
            if (contentValues != null) {
                return contentValues.getAsString(str);
            }
            String string = this.mCursor.getString(this.mCursor.getColumnIndexOrThrow(str));
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return string;
        }

        /* JADX WARN: Code restructure failed: missing block: B:52:0x0091, code lost:
        
            if (0 == 0) goto L92;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void readRequestHeaders(com.vivo.ic.dm.DownloadInfo r9) {
            /*
                r8 = this;
                java.util.List r0 = com.vivo.ic.dm.DownloadInfo.access$3800(r9)
                r0.clear()
                android.content.ContentValues r0 = r8.mHeaderContentValues
                if (r0 == 0) goto L37
                java.util.Set r0 = r0.keySet()
                if (r0 == 0) goto L9d
                java.util.Iterator r0 = r0.iterator()
            L15:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L9d
                java.lang.Object r1 = r0.next()
                java.lang.String r1 = (java.lang.String) r1
                android.content.ContentValues r2 = r8.mHeaderContentValues
                java.lang.String r2 = r2.getAsString(r1)
                boolean r3 = android.text.TextUtils.isEmpty(r1)
                if (r3 != 0) goto L15
                boolean r3 = android.text.TextUtils.isEmpty(r2)
                if (r3 != 0) goto L15
                r8.addHeader(r9, r1, r2)
                goto L15
            L37:
                android.content.ContentResolver r0 = r8.mResolver
                if (r0 == 0) goto L9d
                android.net.Uri r0 = r9.getDownloadsUri()
                java.lang.String r1 = "headers"
                android.net.Uri r3 = android.net.Uri.withAppendedPath(r0, r1)
                r0 = 0
                android.content.ContentResolver r2 = r8.mResolver     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L87
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                android.database.Cursor r0 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L87
                if (r0 != 0) goto L61
                java.lang.String r1 = com.vivo.ic.dm.DownloadInfo.access$3900()     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L87
                java.lang.String r2 = "readRequestHeaders error by cursor is null"
                com.vivo.ic.VLog.w(r1, r2)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L87
                if (r0 == 0) goto L60
                r0.close()
            L60:
                return
            L61:
                java.lang.String r1 = "header"
                int r1 = r0.getColumnIndexOrThrow(r1)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L87
                java.lang.String r2 = "value"
                int r2 = r0.getColumnIndexOrThrow(r2)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L87
                r0.moveToFirst()     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L87
            L70:
                boolean r3 = r0.isAfterLast()     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L87
                if (r3 != 0) goto L93
                java.lang.String r3 = r0.getString(r1)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L87
                java.lang.String r4 = r0.getString(r2)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L87
                r8.addHeader(r9, r3, r4)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L87
                r0.moveToNext()     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L87
                goto L70
            L85:
                r9 = move-exception
                goto L97
            L87:
                r1 = move-exception
                java.lang.String r2 = com.vivo.ic.dm.DownloadInfo.access$3900()     // Catch: java.lang.Throwable -> L85
                java.lang.String r3 = "readRequestHeaders error"
                com.vivo.ic.VLog.w(r2, r3, r1)     // Catch: java.lang.Throwable -> L85
                if (r0 == 0) goto L9d
            L93:
                r0.close()
                goto L9d
            L97:
                if (r0 == 0) goto L9c
                r0.close()
            L9c:
                throw r9
            L9d:
                java.lang.String r0 = com.vivo.ic.dm.DownloadInfo.access$1300(r9)
                if (r0 == 0) goto Lac
                java.lang.String r0 = com.vivo.ic.dm.DownloadInfo.access$1300(r9)
                java.lang.String r1 = "Cookie"
                r8.addHeader(r9, r1, r0)
            Lac:
                java.lang.String r0 = com.vivo.ic.dm.DownloadInfo.access$1500(r9)
                if (r0 == 0) goto Lbb
                java.lang.String r0 = com.vivo.ic.dm.DownloadInfo.access$1500(r9)
                java.lang.String r1 = "Referer"
                r8.addHeader(r9, r1, r0)
            Lbb:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.vivo.ic.dm.DownloadInfo.Reader.readRequestHeaders(com.vivo.ic.dm.DownloadInfo):void");
        }

        public DownloadInfo newDownloadInfo(Context context) {
            DownloadInfo downloadInfo = new DownloadInfo(context);
            updateFromDatabase(downloadInfo);
            readRequestHeaders(downloadInfo);
            return downloadInfo;
        }

        public void updateFromDatabase(DownloadInfo downloadInfo) {
            downloadInfo.mId = getLong("_id").longValue();
            downloadInfo.mUri = getString("uri");
            downloadInfo.mHint = getString(Downloads.Column.FILE_NAME_HINT);
            downloadInfo.mFileName = getString(Downloads.Column.DATA);
            downloadInfo.mMimeType = com.vivo.ic.dm.util.b.b(getString("mimetype"));
            downloadInfo.mVisibility = getInt(Downloads.Column.VISIBILITY).intValue();
            downloadInfo.mStatus = getInt("status").intValue();
            downloadInfo.mNumFailed = getInt(Downloads.Column.FAILED_CONNECTIONS).intValue();
            int intValue = getInt(Downloads.Column.RETRY_AFTER_X_REDIRECT_COUNT).intValue();
            downloadInfo.mErrorMsg = getString("error_msg");
            downloadInfo.mRetryAfter = intValue & 268435455;
            downloadInfo.mLastMod = getLong(Downloads.Column.LAST_MODIFICATION).longValue();
            downloadInfo.mExtras = getString(Downloads.Column.NOTIFICATION_EXTRAS);
            downloadInfo.mCookies = getString(Downloads.Column.COOKIE_DATA);
            downloadInfo.mUserAgent = getString(Downloads.Column.USER_AGENT);
            downloadInfo.mReferer = getString(Downloads.Column.REFERER);
            downloadInfo.mTotalBytes = getLong("total_bytes").longValue();
            downloadInfo.mCurrentBytes = getLong(Downloads.Column.CURRENT_BYTES).longValue();
            downloadInfo.mSpeed = getLong(Downloads.Column.CURRENT_SPEED).longValue();
            downloadInfo.mMediaScanned = getInt(Downloads.Column.MEDIA_SCANNED).intValue();
            downloadInfo.mTitle = getString("title");
            downloadInfo.mETag = getString(Downloads.Column.ETAG);
            downloadInfo.mDescription = getString("description");
            downloadInfo.mNetworkChanged = getInt(Downloads.Column.NETWORK_CHANGED).intValue();
            downloadInfo.mPackageName = getString("package_name");
            downloadInfo.mAllowedNetType = getInt(Downloads.Column.COLUMN_ALLOWED_NETWORK_TYPES).intValue();
            downloadInfo.mSkipHttpsVerify = getInt(Downloads.Column.IGNORE_HTTPS_VERIFY).intValue() == 1;
            downloadInfo.mCompleteShown = getInt(Downloads.Column.COMPLETE_NOTIFICATION_SHOWN).intValue() == 1;
            downloadInfo.mLastNetwork = getInt(Downloads.Column.LAST_NETWORK).intValue();
            downloadInfo.mAppExtraOne = getString(Downloads.Column.APP_EXTRA_ONE);
            downloadInfo.mAppExtraTwo = getString(Downloads.Column.APP_EXTRA_TWO);
            downloadInfo.mAppExtraThree = getString(Downloads.Column.APP_EXTRA_THREE);
            downloadInfo.mAppExtraFour = getString(Downloads.Column.APP_EXTRA_FOUR);
            downloadInfo.mAppExtraFive = getString(Downloads.Column.APP_EXTRA_FIVE);
            downloadInfo.mDownloadType = getInt(Downloads.Column.DOWNLOAD_TYPE).intValue();
            synchronized (this) {
                downloadInfo.mControl = getInt(Downloads.Column.CONTROL).intValue();
            }
            downloadInfo.mCheckSum = getString(Downloads.Column.CHECK_SUM);
            downloadInfo.mActualPath = getString(Downloads.Column.ACTUAL_PATH);
            downloadInfo.mRedirectUrl = getString(Downloads.Column.REDIRECT_URL);
            if (TextUtils.isEmpty(downloadInfo.mActualPath)) {
                downloadInfo.mActualPath = downloadInfo.mFileName;
            }
        }

        public Reader(ContentValues contentValues, ContentValues contentValues2) {
            this.mHeaderContentValues = contentValues;
            this.mContentValues = contentValues2;
        }
    }
}
