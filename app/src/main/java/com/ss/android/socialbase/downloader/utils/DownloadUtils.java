package com.ss.android.socialbase.downloader.utils;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.mobads.sdk.internal.bu;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.j.i;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadHttpException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.impls.DownloadProxy;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.model.RandomAccessOutputStream;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import okhttp3.internal.http2.StreamResetException;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class DownloadUtils {
    public static final String ACCEPT_RANGES = "Accept-Ranges";
    public static final String CACHE_CONTROL = "Cache-Control";
    public static final int CHUNKED_CONTENT_LENGTH = -1;
    public static final String CONTENT_DISPOSITION = "Content-Disposition";
    public static final String CONTENT_LENGTH = "Content-Length";
    public static final String CONTENT_RANGE = "Content-Range";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final int DEFAULT_MIN_TIME_INTERVAL = 1000;
    public static final String ETAG = "Etag";
    private static final String EXTERNAL_STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static final long FILE_COPY_BUFFER_SIZE = 31457280;
    public static final String HEADER_TAG_DOWNLOAD_CACHE = "download-tc21-1-15";
    public static final String IF_MODIFIED_SINCE = "if-modified-since";
    public static final String LAST_MODIFIED = "last-modified";
    public static final String LAST_MODIFIED_CASE = "Last-Modified";
    private static final long ONE_KB = 1024;
    private static final long ONE_MB = 1048576;
    private static final String TAG = "DownloadUtils";
    public static final String TRANSFER_ENCODING = "Transfer-Encoding";
    public static final String VALUE_CHUNKED = "chunked";
    public static final String X_CACHE = "X-Cache";
    private static ConnectivityManager connectivityManager;
    private static Boolean sIsDownloaderProcess;
    private static Boolean sIsMainProcess;
    private static final Pattern CONTENT_RANGE_RIGHT_VALUE = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");
    private static String sCurProcessName = null;
    private static volatile SparseArray<Boolean> saveTempFileStatusMap = new SparseArray<>();
    private static volatile SparseArray<List<ITempFileSaveCompleteCallback>> saveTempFileListeners = new SparseArray<>();
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static Pattern CONTENT_DISPOSITION_QUOTED_PATTERN = null;
    private static Pattern CONTENT_DISPOSITION_NON_QUOTED_PATTERN = null;

    public static List<HttpHeader> add0_0RangeHeader(List<HttpHeader> list, String str) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (HttpHeader httpHeader : list) {
                if (httpHeader != null) {
                    arrayList.add(httpHeader);
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new HttpHeader(HttpHeaders.IF_MATCH, str));
        }
        arrayList.add(new HttpHeader(HttpHeaders.ACCEPT_ENCODING, HTTP.IDENTITY_CODING));
        arrayList.add(new HttpHeader(HttpHeaders.RANGE, "bytes=0-0"));
        return arrayList;
    }

    public static List<HttpHeader> addRangeHeader(List<HttpHeader> list, String str, DownloadChunk downloadChunk) {
        return addRangeHeader(list, str, downloadChunk.getCurOffset(), downloadChunk.getEndOffset());
    }

    public static void addTTNetProtectTimeout(List<HttpHeader> list, DownloadInfo downloadInfo) {
        long ttnetProtectTimeout = downloadInfo.getTtnetProtectTimeout();
        if (ttnetProtectTimeout > 300) {
            list.add(new HttpHeader(DownloadConstants.EXTRA_TTNET_PROTECT_TIMEOUT, String.valueOf(ttnetProtectTimeout)));
        }
    }

    public static void addThrottleNetSpeed(List<HttpHeader> list, DownloadInfo downloadInfo) {
        long throttleNetSpeed = downloadInfo.getThrottleNetSpeed();
        if (throttleNetSpeed > 0) {
            list.add(new HttpHeader(DownloadConstants.EXTRA_THROTTLE_NET_SPEED, String.valueOf(throttleNetSpeed)));
        }
    }

    public static double byteToMb(long j2) {
        double d2 = j2;
        Double.isNaN(d2);
        return d2 / 1048576.0d;
    }

    public static boolean cacheExpired(DownloadInfo downloadInfo) {
        boolean z = false;
        if (downloadInfo.isDeleteCacheIfCheckFailed() || !TextUtils.isEmpty(downloadInfo.getLastModified())) {
            Logger.d(TAG, "dcache::curt=" + System.currentTimeMillis() + " expired=" + downloadInfo.getCacheExpiredTime());
            if (System.currentTimeMillis() > downloadInfo.getCacheExpiredTime()) {
                z = true;
            }
        } else {
            Logger.d(TAG, "dcache::last modify is emtpy, so just return cache");
        }
        Logger.d(TAG, "cacheExpired::dcache::name=" + downloadInfo.getName() + " expired=" + z);
        return z;
    }

    public static boolean canAcceptPartial(int i2, String str) {
        if (DownloadExpSwitchCode.isSwitchEnable(16777216)) {
            return i2 == 206 || i2 == 1;
        }
        if (i2 >= 400) {
            return false;
        }
        return i2 == 206 || i2 == 1 || "bytes".equals(str);
    }

    public static boolean canChunkDowngradeRetry(BaseException baseException, DownloadInfo downloadInfo) {
        if (baseException == null) {
            return false;
        }
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1000 || errorCode == 1032 || errorCode == 1033 || errorCode == 1034 || errorCode == 1008 || errorCode == 1026 || errorCode == 1027 || errorCode == 1044 || errorCode == 1020) {
            return true;
        }
        return (errorCode == 1049 || errorCode == 1055 || errorCode == 1006 || downloadInfo == null || downloadInfo.getCurBytes() >= 8388608) ? false : true;
    }

    public static int checkMd5Status(String str, String str2, String str3) {
        return i.j(str3, new File(str, str2));
    }

    public static boolean checkMd5Valid(String str, String str2, String str3) {
        return isMd5Valid(checkMd5Status(str, str2, str3));
    }

    public static boolean checkPermission(Context context, String str) {
        return (context == null || TextUtils.isEmpty(str) || context.checkCallingOrSelfPermission(str) != 0) ? false : true;
    }

    public static void clearAntiHijackDir(DownloadInfo downloadInfo) {
        DownloadSetting obtain;
        JSONObject optJSONObject;
        if (downloadInfo == null || (optJSONObject = (obtain = DownloadSetting.obtain(downloadInfo.getId())).optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR)) == null) {
            return;
        }
        String optString = optJSONObject.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_INSTALL_DESC);
        if (!TextUtils.isEmpty(optString)) {
            deleteFile(downloadInfo.getSavePath(), optString);
        }
        String title = downloadInfo.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = downloadInfo.getName();
        }
        String redirectSavePath = getRedirectSavePath(title, obtain);
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(redirectSavePath) || TextUtils.isEmpty(savePath)) {
            return;
        }
        File file = new File(redirectSavePath);
        for (File file2 = new File(savePath); file != null && file2 != null && file2.isDirectory() && TextUtils.equals(file.getName(), file2.getName()); file2 = file2.getParentFile()) {
            deleteDirIfEmpty(file2.getPath());
            file = file.getParentFile();
        }
    }

    public static ListenerType convertListenerType(int i2) {
        ListenerType listenerType = ListenerType.MAIN;
        ListenerType listenerType2 = ListenerType.SUB;
        if (i2 != listenerType2.ordinal()) {
            listenerType2 = ListenerType.NOTIFICATION;
            if (i2 != listenerType2.ordinal()) {
                return listenerType;
            }
        }
        return listenerType2;
    }

    public static boolean copyFile(File file, File file2) throws BaseException {
        return copyFile(file, file2, true);
    }

    public static void copyFileFromExistFileWithSameName(DownloadInfo downloadInfo, String str) throws BaseException {
        if (downloadInfo == null || TextUtils.isEmpty(str) || str.equals(downloadInfo.getName())) {
            return;
        }
        File file = new File(downloadInfo.getSavePath(), str);
        File file2 = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        Log.e(TAG, "copyFileFromExistFileWithSameName: existFile:" + file.getPath() + " targetFile:" + file2.getPath());
        if (file2.exists() && !file2.canWrite()) {
            throw new BaseException(1001, "targetPath file exists but read-only");
        }
        if (!copyFile(file, file2)) {
            throw new BaseException(1001, String.format("Can't copy the exist file(%s/%s) to the target file(%s/%s)", downloadInfo.getSavePath(), str, downloadInfo.getSavePath(), downloadInfo.getName()));
        }
    }

    public static long cost(long j2) {
        return System.currentTimeMillis() - j2;
    }

    public static RandomAccessOutputStream createOutputStream(DownloadInfo downloadInfo, String str, String str2, int i2) throws BaseException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new BaseException(1021, new IOException("path must be not empty"));
        }
        File file = new File(str, str2);
        boolean z = false;
        if (file.exists() && file.isDirectory()) {
            throw new BaseException(DownloadErrorCode.ERROR_TEMP_FILE_IS_DIRECTORY, new IOException(String.format("path is :%s, path is directory:%B:", str, Boolean.valueOf(file.isDirectory()))));
        }
        if (!file.exists()) {
            try {
                File file2 = new File(str);
                if (!file2.exists() || !file2.isDirectory()) {
                    if (file2.exists()) {
                        file2.delete();
                        if (file2.mkdirs() || file2.exists()) {
                            throw new BaseException(DownloadErrorCode.ERROR_SAVE_PATH_NOT_DIRECTORY, "download savePath is not directory:" + str);
                        }
                        throw new BaseException(DownloadErrorCode.ERROR_SAVE_PATH_NOT_DIRECTORY, "download savePath is not directory:path=" + str);
                    }
                    if (!file2.mkdirs() && !file2.exists()) {
                        if (DownloadSetting.obtain(downloadInfo).optInt(DownloadSettingKeys.OPT_MKDIR_FAILED, 0) != 1) {
                            throw new BaseException(DownloadErrorCode.ERROR_SAVE_PATH_CREATE_FAILED, "download savePath directory can not created:" + str);
                        }
                        int i3 = 0;
                        while (!z) {
                            int i4 = i3 + 1;
                            if (i3 >= 3) {
                                break;
                            }
                            try {
                                Thread.sleep(10L);
                                z = file2.mkdirs();
                                i3 = i4;
                            } catch (InterruptedException unused) {
                            }
                        }
                        if (!z) {
                            if (getAvailableSpaceBytes(downloadInfo.getSavePath()) < 16384) {
                                throw new BaseException(1006, "download savePath directory can not created:" + str);
                            }
                            throw new BaseException(DownloadErrorCode.ERROR_SAVE_PATH_CREATE_FAILED, "download savePath directory can not created:" + str);
                        }
                    }
                }
                file.createNewFile();
            } catch (IOException e2) {
                throw new BaseException(DownloadErrorCode.ERROR_TEMP_FILE_CREATE_FAILED, e2);
            }
        }
        return new RandomAccessOutputStream(file, i2);
    }

    public static void deleteAllDownloadFiles(DownloadInfo downloadInfo) {
        deleteAllDownloadFiles(downloadInfo, true);
    }

    private static boolean deleteDirIfEmpty(String str) {
        String str2 = TAG;
        Log.w(str2, "deleteDirIfEmpty on thread: " + Thread.currentThread());
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.isDirectory()) {
                if (file.delete()) {
                    return true;
                }
                Log.w(str2, "deleteDirIfEmpty return false");
                return false;
            }
        }
        return false;
    }

    public static void deleteFile(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str, str2);
        if (file.exists()) {
            Log.e(TAG, "deleteFile: " + str + "/" + str2);
            file.delete();
        }
    }

    @TargetApi(19)
    private static void doCopyFile(File file, File file2, boolean z) throws IOException {
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileChannel channel = fileInputStream.getChannel();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    FileChannel channel2 = fileOutputStream.getChannel();
                    try {
                        long size = channel.size();
                        long j2 = 0;
                        while (j2 < size) {
                            long j3 = size - j2;
                            long transferFrom = channel2.transferFrom(channel, j2, j3 > FILE_COPY_BUFFER_SIZE ? 31457280L : j3);
                            if (transferFrom == 0) {
                                break;
                            } else {
                                j2 += transferFrom;
                            }
                        }
                        if (channel2 != null) {
                            channel2.close();
                        }
                        fileOutputStream.close();
                        channel.close();
                        fileInputStream.close();
                        long length = file.length();
                        long length2 = file2.length();
                        if (length == length2) {
                            if (z) {
                                file2.setLastModified(file.lastModified());
                                return;
                            }
                            return;
                        }
                        throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "' Expected length: " + length + " Actual: " + length2);
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (Throwable unused) {
                }
                throw th2;
            }
        }
    }

    public static void ensureDirExists(String str) {
        if (str == null) {
            return;
        }
        ensureDirExists(new File(str));
    }

    public static String generateDistinctDirectory(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String md5Hex = md5Hex(str2);
        return (TextUtils.isEmpty(md5Hex) || str.contains(md5Hex)) ? str : new File(str, md5Hex).getAbsolutePath();
    }

    public static long getAvailableSpaceBytes(String str) throws BaseException {
        try {
            StatFs statFs = new StatFs(str);
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getAvailableBytes();
            }
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (IllegalArgumentException e2) {
            throw new BaseException(DownloadErrorCode.ERROR_NO_SDCARD_PERMISSION, e2);
        } catch (Throwable th) {
            throw new BaseException(DownloadErrorCode.ERROR_GET_AVAILABLE_SPACE, th);
        }
    }

    public static boolean getBoolean(Object obj, boolean z) {
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException unused) {
            return z;
        }
    }

    public static ConnectivityManager getConnectivityManager(Context context) {
        ConnectivityManager connectivityManager2 = connectivityManager;
        if (connectivityManager2 != null) {
            return connectivityManager2;
        }
        ConnectivityManager connectivityManager3 = (ConnectivityManager) context.getSystemService("connectivity");
        connectivityManager = connectivityManager3;
        return connectivityManager3;
    }

    public static long getContentLength(IDownloadHeadHttpConnection iDownloadHeadHttpConnection) {
        if (iDownloadHeadHttpConnection == null) {
            return -1L;
        }
        String respHeadFieldIgnoreCase = getRespHeadFieldIgnoreCase(iDownloadHeadHttpConnection, "Content-Length");
        if (TextUtils.isEmpty(respHeadFieldIgnoreCase) && DownloadExpSwitchCode.isSwitchEnable(1)) {
            return parseContentLengthFromContentRange(iDownloadHeadHttpConnection);
        }
        try {
            return Long.parseLong(respHeadFieldIgnoreCase);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static long getCurByte(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0L;
        }
        List<DownloadChunk> downloadChunk = DownloadComponentManager.getDownloadCache().getDownloadChunk(downloadInfo.getId());
        int chunkCount = downloadInfo.getChunkCount();
        boolean z = chunkCount > 1;
        if (!downloadInfo.isBreakpointAvailable()) {
            return 0L;
        }
        if (!z) {
            return downloadInfo.getCurBytes();
        }
        if (downloadChunk == null || chunkCount != downloadChunk.size()) {
            return 0L;
        }
        return getTotalOffset(downloadChunk);
    }

    public static String getCurProcessName(Context context) {
        String str = sCurProcessName;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String curProcessNameByApplication = getCurProcessNameByApplication();
        sCurProcessName = curProcessNameByApplication;
        if (!TextUtils.isEmpty(curProcessNameByApplication)) {
            return sCurProcessName;
        }
        String curProcessNameByActivityThread = getCurProcessNameByActivityThread();
        sCurProcessName = curProcessNameByActivityThread;
        if (!TextUtils.isEmpty(curProcessNameByActivityThread)) {
            return sCurProcessName;
        }
        String curProcessNameByActivityManager = getCurProcessNameByActivityManager(context);
        sCurProcessName = curProcessNameByActivityManager;
        if (!TextUtils.isEmpty(curProcessNameByActivityManager)) {
            return sCurProcessName;
        }
        String curProcessNameFromProc = getCurProcessNameFromProc();
        sCurProcessName = curProcessNameFromProc;
        return curProcessNameFromProc;
    }

    private static String getCurProcessNameByActivityManager(Context context) {
        if (context == null) {
            return null;
        }
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        if (Logger.debug()) {
                            Logger.d("Process", "processName = " + runningAppProcessInfo.processName);
                        }
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    private static String getCurProcessNameByActivityThread() {
        String str;
        Throwable th;
        Object invoke;
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            invoke = declaredMethod.invoke(null, new Object[0]);
        } catch (Throwable th2) {
            str = null;
            th = th2;
        }
        if (!(invoke instanceof String)) {
            return null;
        }
        str = (String) invoke;
        try {
            if (!TextUtils.isEmpty(str) && Logger.debug()) {
                Logger.d("Process", "processName = " + str);
            }
        } catch (Throwable th3) {
            th = th3;
            th.printStackTrace();
            return str;
        }
        return str;
    }

    private static String getCurProcessNameByApplication() {
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        try {
            String processName = Application.getProcessName();
            if (!TextUtils.isEmpty(processName) && Logger.debug()) {
                Logger.d("Process", "processName = " + processName);
            }
            return processName;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String getCurProcessNameFromProc() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = bufferedReader.read();
                    if (read <= 0) {
                        break;
                    }
                    sb.append((char) read);
                }
                if (Logger.debug()) {
                    Logger.d("Process", "get processName = " + sb.toString());
                }
                String sb2 = sb.toString();
                safeClose(bufferedReader);
                return sb2;
            } catch (Throwable unused) {
                safeClose(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static File getDatabaseFile(Context context, boolean z, String str) {
        String str2 = "";
        try {
            str2 = Environment.getExternalStorageState();
        } catch (IncompatibleClassChangeError | NullPointerException unused) {
        }
        File externalDBFile = (z && "mounted".equals(str2) && hasExternalStoragePermission(context)) ? getExternalDBFile(str) : null;
        if (externalDBFile == null) {
            externalDBFile = context.getDatabasePath(str);
        }
        if (externalDBFile != null) {
            return externalDBFile;
        }
        return new File("/data/data/" + context.getPackageName() + "/database/", str);
    }

    public static String getDownloadPath() {
        return getValidDownloadPath(Downloader.getInstance(DownloadComponentManager.getAppContext()).getGlobalSaveDir(), true);
    }

    public static String getDownloadTempPath() {
        return getValidDownloadPath(Downloader.getInstance(DownloadComponentManager.getAppContext()).getGlobalSaveTempDir(), false);
    }

    public static String getEncodedStr(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static String getErrorMsgWithTagPrefix(Throwable th, String str) {
        if (str == null) {
            return getThrowableMsg(th);
        }
        return str + "-" + getThrowableMsg(th);
    }

    private static File getExternalDBFile(String str) {
        File file = null;
        if (!isSdcardAvailable() || !isSdcardWritable()) {
            return null;
        }
        try {
            File externalFilesDir = DownloadComponentManager.getAppContext().getExternalFilesDir("database" + File.separator + str);
            if (externalFilesDir == null) {
                return null;
            }
            try {
                if (!externalFilesDir.exists()) {
                    externalFilesDir.createNewFile();
                }
                if (!Logger.debug()) {
                    return externalFilesDir;
                }
                Logger.d(TAG, "download db path:" + externalFilesDir.getAbsolutePath());
                return externalFilesDir;
            } catch (Exception e2) {
                e = e2;
                file = externalFilesDir;
                e.printStackTrace();
                return file;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static File getExternalDownloadPath() {
        String str;
        try {
            str = Environment.getExternalStorageState();
        } catch (Exception unused) {
            str = "";
        }
        if ("mounted".equals(str)) {
            return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        }
        return null;
    }

    public static String getFileNameFromConnection(IDownloadHeadHttpConnection iDownloadHeadHttpConnection, String str) {
        String parseContentDisposition = parseContentDisposition(iDownloadHeadHttpConnection.getResponseHeaderField("Content-Disposition"));
        return TextUtils.isEmpty(parseContentDisposition) ? md5Hex(str) : parseContentDisposition;
    }

    private static long getFirstChunkCurOffset(List<DownloadChunk> list) {
        if (list == null || list.isEmpty()) {
            return -1L;
        }
        long j2 = -1;
        for (DownloadChunk downloadChunk : list) {
            if (downloadChunk != null && (downloadChunk.getCurrentOffset() <= downloadChunk.getEndOffset() || downloadChunk.getEndOffset() == 0)) {
                if (j2 == -1 || j2 > downloadChunk.getCurrentOffset()) {
                    j2 = downloadChunk.getCurrentOffset();
                }
            }
        }
        return j2;
    }

    public static long getFirstOffset(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return -1L;
        }
        List<DownloadChunk> downloadChunk = DownloadComponentManager.getDownloadCache().getDownloadChunk(downloadInfo.getId());
        if (downloadInfo.getChunkCount() == 1) {
            return downloadInfo.getCurBytes();
        }
        if (downloadChunk == null || downloadChunk.size() <= 1) {
            return 0L;
        }
        long firstChunkCurOffset = getFirstChunkCurOffset(downloadChunk);
        if (firstChunkCurOffset >= 0) {
            return firstChunkCurOffset;
        }
        return 0L;
    }

    public static String getFixLengthString(String str, int i2) {
        return i2 == 0 ? "" : (TextUtils.isEmpty(str) || str.length() <= i2) ? str : str.substring(0, i2);
    }

    public static int getInt(Object obj, int i2) {
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException unused) {
            return i2;
        }
    }

    public static String getLoggerTag(String str) {
        return Logger.downloaderTag(str);
    }

    public static long getMaxBytesOverMobile() {
        return 2147483648L;
    }

    public static String getMd5StatusMsg(int i2) {
        String str = "ttmd5 check code = " + i2 + ", ";
        if (i2 == 99) {
            return str + "unknown error";
        }
        switch (i2) {
            case 0:
                return str + "md5 match";
            case 1:
                return str + "md5 not match";
            case 2:
                return str + "md5 empty";
            case 3:
                return str + "ttmd5 version not support";
            case 4:
                return str + "ttmd5 tag parser error";
            case 5:
                return str + "file not exist";
            case 6:
                return str + "get file md5 error";
            default:
                return str;
        }
    }

    public static String getRedirectSavePath(String str, DownloadSetting downloadSetting) {
        JSONObject optJSONObject;
        String format;
        if (downloadSetting == null || (optJSONObject = downloadSetting.optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR)) == null) {
            return "";
        }
        String optString = optJSONObject.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME);
        if (!TextUtils.isEmpty(optString) && optString.startsWith("/")) {
            optString = optString.substring(1);
        }
        if (TextUtils.isEmpty(optString)) {
            return optString;
        }
        if (optString.contains("%s")) {
            try {
                format = String.format(optString, str);
            } catch (Throwable unused) {
            }
        } else {
            format = optString + str;
        }
        optString = format;
        return optString.length() > 255 ? optString.substring(optString.length() - 255) : optString;
    }

    public static String getRespHeadFieldIgnoreCase(IDownloadHeadHttpConnection iDownloadHeadHttpConnection, String str) {
        if (iDownloadHeadHttpConnection == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String responseHeaderField = iDownloadHeadHttpConnection.getResponseHeaderField(str);
        if (!DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.BUGFIX_FIX_GET_HTTP_RESP_HEAD_IGNORE_CASE, true)) {
            return responseHeaderField;
        }
        if (TextUtils.isEmpty(responseHeaderField)) {
            responseHeaderField = iDownloadHeadHttpConnection.getResponseHeaderField(str.toLowerCase());
        }
        return TextUtils.isEmpty(responseHeaderField) ? iDownloadHeadHttpConnection.getResponseHeaderField(str.toUpperCase()) : responseHeaderField;
    }

    public static String getString(Object obj, String str) {
        try {
            return (String) obj;
        } catch (ClassCastException unused) {
            return str;
        }
    }

    public static String getTargetFilePath(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return String.format("%s%s%s", str, File.separator, str2);
    }

    public static String getTempFileName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return String.format("%s.tp", str);
    }

    public static String getTempFilePath(String str, String str2, String str3) {
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.isEmpty(str3)) {
            return null;
        }
        String targetFilePath = !TextUtils.isEmpty(str2) ? getTargetFilePath(str2, str3) : getTargetFilePath(str, str3);
        if (TextUtils.isEmpty(targetFilePath)) {
            return null;
        }
        return String.format("%s.tp", targetFilePath);
    }

    public static String getTempFileSavePath(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return null;
        }
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }

    public static String getThrowableMsg(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            return th.toString();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "throwable getMsg error";
        }
    }

    public static long getTotalOffset(List<DownloadChunk> list) {
        Iterator<DownloadChunk> it = list.iterator();
        long j2 = 0;
        while (it.hasNext()) {
            j2 += it.next().getDownloadChunkBytes();
        }
        return j2;
    }

    private static String getValidDownloadPath(File file, boolean z) {
        Context appContext = DownloadComponentManager.getAppContext();
        if (isValidDirectory(file)) {
            return file.getAbsolutePath();
        }
        int i2 = appContext.getApplicationInfo().targetSdkVersion;
        if (Build.VERSION.SDK_INT < 29 || ((i2 != 29 || Environment.isExternalStorageLegacy()) && i2 <= 29)) {
            if (z) {
                File externalDownloadPath = getExternalDownloadPath();
                if (isValidDirectory(externalDownloadPath)) {
                    return externalDownloadPath.getAbsolutePath();
                }
            }
            File externalFilesDir = appContext.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            if (isValidDirectory(externalFilesDir)) {
                return externalFilesDir.getAbsolutePath();
            }
        } else {
            File externalFilesDir2 = appContext.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            if (isValidDirectory(externalFilesDir2)) {
                return externalFilesDir2.getAbsolutePath();
            }
        }
        return appContext.getFilesDir().getAbsolutePath();
    }

    private static void handleTempSaveCallback(int i2, boolean z, BaseException baseException) {
        synchronized (saveTempFileStatusMap) {
            List<ITempFileSaveCompleteCallback> list = saveTempFileListeners.get(i2);
            if (list != null) {
                for (ITempFileSaveCompleteCallback iTempFileSaveCompleteCallback : list) {
                    if (iTempFileSaveCompleteCallback != null) {
                        if (z) {
                            iTempFileSaveCompleteCallback.onSuccess();
                        } else {
                            iTempFileSaveCompleteCallback.onFailed(baseException);
                        }
                    }
                }
            }
            Logger.d(TAG, "handleTempSaveCallback id:" + i2);
            saveTempFileStatusMap.remove(i2);
        }
    }

    public static boolean hasDownloadCacheHeader(List<HttpHeader> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        for (HttpHeader httpHeader : list) {
            if (httpHeader != null && !TextUtils.isEmpty(httpHeader.getName()) && !TextUtils.isEmpty(httpHeader.getValue()) && HEADER_TAG_DOWNLOAD_CACHE.equals(httpHeader.getName()) && HEADER_TAG_DOWNLOAD_CACHE.equals(httpHeader.getValue())) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasExternalStoragePermission(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public static String hexToString(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            try {
                bArr[i2] = (byte) (Integer.parseInt(str.substring(i3, i3 + 2), 16) & 255);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        try {
            return new String(bArr, "utf-8");
        } catch (Exception e3) {
            e3.printStackTrace();
            return str;
        }
    }

    public static boolean isChunkedTask(long j2) {
        return j2 == -1;
    }

    public static boolean isChunkedTask(IDownloadHeadHttpConnection iDownloadHeadHttpConnection) {
        if (iDownloadHeadHttpConnection == null) {
            return false;
        }
        return DownloadExpSwitchCode.isSwitchEnable(8) ? "chunked".equals(iDownloadHeadHttpConnection.getResponseHeaderField("Transfer-Encoding")) || getContentLength(iDownloadHeadHttpConnection) == -1 : getContentLength(iDownloadHeadHttpConnection) == -1;
    }

    public static boolean isConnectionException(Throwable th) {
        if (th == null) {
            return false;
        }
        String throwableMsg = getThrowableMsg(th);
        return !TextUtils.isEmpty(throwableMsg) && throwableMsg.contains("Exception in connect");
    }

    public static boolean isDownloadSuccessAndFileNotExist(int i2, String str, String str2) {
        return i2 == -3 && !isFileExist(str, str2);
    }

    public static boolean isDownloaderProcess() {
        Boolean bool = sIsDownloaderProcess;
        if (bool != null) {
            return bool.booleanValue();
        }
        String curProcessName = getCurProcessName(DownloadComponentManager.getAppContext());
        if (curProcessName != null) {
            if (curProcessName.equals(DownloadComponentManager.getAppContext().getPackageName() + ":downloader")) {
                sIsDownloaderProcess = Boolean.TRUE;
                return sIsDownloaderProcess.booleanValue();
            }
        }
        sIsDownloaderProcess = Boolean.FALSE;
        return sIsDownloaderProcess.booleanValue();
    }

    public static boolean isFileDownloaded(DownloadInfo downloadInfo) {
        return isFileDownloaded(downloadInfo, downloadInfo.isForce(), downloadInfo.getMd5());
    }

    public static boolean isFileExist(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return new File(str, str2).exists();
    }

    public static boolean isForbiddenException(Throwable th) {
        if (th == null) {
            return false;
        }
        String throwableMsg = getThrowableMsg(th);
        if (!(th instanceof DownloadHttpException) || (((DownloadHttpException) th).getHttpStatusCode() != 403 && (TextUtils.isEmpty(throwableMsg) || !throwableMsg.contains("403")))) {
            return !TextUtils.isEmpty(throwableMsg) && throwableMsg.contains("Forbidden");
        }
        return true;
    }

    public static boolean isHeaderEqual(List<HttpHeader> list, List<HttpHeader> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        return new HashSet(list).equals(new HashSet(list2));
    }

    public static boolean isHttpDataDirtyError(BaseException baseException) {
        return baseException != null && baseException.getErrorCode() == 1051;
    }

    public static boolean isHttpsError(BaseException baseException) {
        if (baseException == null) {
            return false;
        }
        return baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException));
    }

    public static boolean isInsufficientSpaceError(Throwable th) {
        if (th == null) {
            return false;
        }
        if (!(th instanceof BaseException)) {
            if (!(th instanceof IOException)) {
                return false;
            }
            String throwableMsg = getThrowableMsg(th);
            return !TextUtils.isEmpty(throwableMsg) && throwableMsg.contains("ENOSPC");
        }
        BaseException baseException = (BaseException) th;
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1006) {
            return true;
        }
        if (!(errorCode == 1023 || errorCode == 1039 || errorCode == 1040 || errorCode == 1054 || errorCode == 1064)) {
            return false;
        }
        String message = baseException.getMessage();
        return !TextUtils.isEmpty(message) && message.contains("ENOSPC");
    }

    public static boolean isMainProcess() {
        Boolean bool = sIsMainProcess;
        if (bool != null) {
            return bool.booleanValue();
        }
        String curProcessName = getCurProcessName(DownloadComponentManager.getAppContext());
        if (curProcessName == null || !curProcessName.contains(":")) {
            sIsMainProcess = Boolean.valueOf(curProcessName != null && curProcessName.equals(DownloadComponentManager.getAppContext().getPackageName()));
        } else {
            sIsMainProcess = Boolean.FALSE;
        }
        return sIsMainProcess.booleanValue();
    }

    public static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static boolean isMd5Valid(int i2) {
        return i2 == 0 || i2 == 2;
    }

    public static boolean isNetNotAvailableException(Throwable th) {
        if (th == null) {
            return false;
        }
        String throwableMsg = getThrowableMsg(th);
        return !TextUtils.isEmpty(throwableMsg) && throwableMsg.contains("network not available");
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager2 = getConnectivityManager(context);
            if (connectivityManager2 == null || (activeNetworkInfo = connectivityManager2.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isNetworkError(Throwable th) {
        if (!(th instanceof BaseException)) {
            return false;
        }
        int errorCode = ((BaseException) th).getErrorCode();
        return errorCode == 1055 || errorCode == 1023 || errorCode == 1041 || errorCode == 1022 || errorCode == 1048 || errorCode == 1056 || errorCode == 1057 || errorCode == 1058 || errorCode == 1059 || errorCode == 1060 || errorCode == 1061 || errorCode == 1067 || errorCode == 1049 || errorCode == 1047 || errorCode == 1051 || errorCode == 1004 || errorCode == 1011 || errorCode == 1002 || errorCode == 1013;
    }

    public static boolean isNoWifiAndInNet() {
        Context appContext = DownloadComponentManager.getAppContext();
        return (appContext == null || isWifi(appContext) || !isNetworkConnected(appContext)) ? false : true;
    }

    public static boolean isProcessNameSame(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String curProcessName = getCurProcessName(DownloadComponentManager.getAppContext());
        return curProcessName != null && curProcessName.equals(str);
    }

    public static boolean isResponseCode304Error(Throwable th) {
        return DownloadComponentManager.getTTNetHandler().isResponseCode304Error(th);
    }

    public static boolean isResponseCode412Error(Throwable th) {
        if (th == null) {
            return false;
        }
        String throwableMsg = getThrowableMsg(th);
        return !TextUtils.isEmpty(throwableMsg) && throwableMsg.contains("Precondition Failed");
    }

    public static boolean isResponseCode416Error(Throwable th) {
        if (th == null) {
            return false;
        }
        String throwableMsg = getThrowableMsg(th);
        return !TextUtils.isEmpty(throwableMsg) && throwableMsg.contains("Requested Range Not Satisfiable");
    }

    public static boolean isResponseCodeError(Throwable th) {
        if (th == null) {
            return false;
        }
        String throwableMsg = getThrowableMsg(th);
        if (TextUtils.isEmpty(throwableMsg)) {
            return false;
        }
        return throwableMsg.contains("Requested Range Not Satisfiable") || throwableMsg.contains("Precondition Failed");
    }

    public static boolean isResponseCodeValid(int i2) {
        return i2 == 206 || i2 == 200;
    }

    public static boolean isResponseDataFromBegin(int i2) {
        return i2 == 200 || i2 == 201 || i2 == 0;
    }

    public static boolean isSavePathSecurity(String str) {
        Context appContext;
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.SAVE_PATH_SECURITY) > 0 && (appContext = DownloadComponentManager.getAppContext()) != null && !TextUtils.isEmpty(str) && !str.startsWith("/data")) {
            if (!str.contains("Android/data/" + appContext.getPackageName())) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSdcardAvailable() {
        String externalStorageState = Environment.getExternalStorageState();
        return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
    }

    private static boolean isSdcardWritable() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isTimeOutException(Throwable th) {
        if (th == null) {
            return false;
        }
        String throwableMsg = getThrowableMsg(th);
        if (!(th instanceof SocketTimeoutException)) {
            if (TextUtils.isEmpty(throwableMsg)) {
                return false;
            }
            if (!throwableMsg.contains("time out") && !throwableMsg.contains("Time-out")) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidDirectory(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.exists() || file.mkdirs()) {
                return file.isDirectory();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isWaitWifiAndInNet(BaseException baseException, DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.isOnlyWifi() && isNetworkConnected(DownloadComponentManager.getAppContext());
    }

    public static boolean isWifi(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager2 = getConnectivityManager(context);
            if (connectivityManager2 != null && (activeNetworkInfo = connectivityManager2.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                return 1 == activeNetworkInfo.getType();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String md5Hex(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance(bu.f5659a);
                    messageDigest.update(str.getBytes("UTF-8"));
                    return toHexString(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static boolean moveFile(File file, File file2) throws BaseException {
        String str = TAG;
        Log.e(str, "moveFile1: src:" + file.getPath() + " dest:" + file2.getPath());
        boolean renameTo = file.renameTo(file2);
        if (!renameTo) {
            renameTo = copyFile(file, file2);
            try {
                Log.e(str, "moveFile2: src:" + file.getPath() + " dest:" + file2.getPath());
                file.delete();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return renameTo;
    }

    public static boolean needNotifyDownloaderProcess() {
        return !isDownloaderProcess() && DownloadComponentManager.isDownloadInMultiProcess() && DownloadProxy.get(true).isServiceAlive();
    }

    private static String parseContentDisposition(String str) {
        Matcher matcher;
        if (str == null) {
            return null;
        }
        try {
            if (CONTENT_DISPOSITION_QUOTED_PATTERN == null) {
                CONTENT_DISPOSITION_QUOTED_PATTERN = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
            }
            matcher = CONTENT_DISPOSITION_QUOTED_PATTERN.matcher(str);
        } catch (Exception unused) {
        }
        if (matcher.find()) {
            return matcher.group(1);
        }
        if (CONTENT_DISPOSITION_NON_QUOTED_PATTERN == null) {
            CONTENT_DISPOSITION_NON_QUOTED_PATTERN = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");
        }
        Matcher matcher2 = CONTENT_DISPOSITION_NON_QUOTED_PATTERN.matcher(str);
        if (matcher2.find()) {
            return matcher2.group(1);
        }
        return null;
    }

    public static long parseContentLengthFromContentRange(IDownloadHeadHttpConnection iDownloadHeadHttpConnection) {
        if (iDownloadHeadHttpConnection == null) {
            return -1L;
        }
        String respHeadFieldIgnoreCase = getRespHeadFieldIgnoreCase(iDownloadHeadHttpConnection, "Content-Range");
        if (TextUtils.isEmpty(respHeadFieldIgnoreCase)) {
            return -1L;
        }
        try {
            Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(respHeadFieldIgnoreCase);
            if (matcher.find()) {
                return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            }
        } catch (Exception e2) {
            Logger.w(TAG, "parse content-length from content-range failed " + e2);
        }
        return -1L;
    }

    public static long parseContentRangeOfInstanceLength(String str) {
        if (str == null) {
            return -1L;
        }
        String[] split = str.split("/");
        if (split.length >= 2) {
            try {
                return Long.parseLong(split[1]);
            } catch (NumberFormatException unused) {
                Logger.w(TAG, "parse instance length failed with " + str);
            }
        }
        return -1L;
    }

    public static void parseException(Throwable th, String str) throws BaseException {
        String str2 = !TextUtils.isEmpty(str) ? str : "";
        if (th instanceof BaseException) {
            BaseException baseException = (BaseException) th;
            baseException.setErrorMsg(str2 + "-" + baseException.getErrorMessage());
            throw baseException;
        }
        if (th instanceof SSLHandshakeException) {
            throw new BaseException(1011, getErrorMsgWithTagPrefix(th, str2));
        }
        if (isTimeOutException(th)) {
            throw new BaseException(DownloadErrorCode.ERROR_TIME_OUT, getErrorMsgWithTagPrefix(th, str2));
        }
        if (isResponseCode412Error(th)) {
            throw new DownloadHttpException(1004, 412, getErrorMsgWithTagPrefix(th, str2));
        }
        if (isResponseCode416Error(th)) {
            throw new DownloadHttpException(1004, 416, getErrorMsgWithTagPrefix(th, str2));
        }
        if (isForbiddenException(th)) {
            throw new BaseException(DownloadErrorCode.ERROR_DOWNLOAD_FORBIDDEN, getErrorMsgWithTagPrefix(th, str2));
        }
        if (isNetNotAvailableException(th)) {
            throw new BaseException(DownloadErrorCode.ERROR_NETWORK_NOT_AVAILABLE, getErrorMsgWithTagPrefix(th, str2));
        }
        if (isConnectionException(th)) {
            throw new BaseException(DownloadErrorCode.ERROR_NETWORK_CONNECTION_IO, getErrorMsgWithTagPrefix(th, str2));
        }
        if (!(th instanceof IOException)) {
            throw new BaseException(1000, getErrorMsgWithTagPrefix(th, str2));
        }
        parseTTNetException(th, str);
        parseIOException((IOException) th, str);
    }

    public static List<DownloadChunk> parseHostChunkList(List<DownloadChunk> list) {
        SparseArray sparseArray = new SparseArray();
        SparseArray sparseArray2 = new SparseArray();
        for (DownloadChunk downloadChunk : list) {
            if (downloadChunk != null) {
                if (downloadChunk.isHostChunk()) {
                    sparseArray.put(downloadChunk.getChunkIndex(), downloadChunk);
                    List<DownloadChunk> list2 = (List) sparseArray2.get(downloadChunk.getChunkIndex());
                    if (list2 != null) {
                        Iterator<DownloadChunk> it = list2.iterator();
                        while (it.hasNext()) {
                            it.next().setHostChunk(downloadChunk);
                        }
                        downloadChunk.setSubChunkList(list2);
                    }
                } else {
                    DownloadChunk downloadChunk2 = (DownloadChunk) sparseArray.get(downloadChunk.getHostChunkIndex());
                    if (downloadChunk2 != null) {
                        List<DownloadChunk> subChunkList = downloadChunk2.getSubChunkList();
                        if (subChunkList == null) {
                            subChunkList = new ArrayList<>();
                            downloadChunk2.setSubChunkList(subChunkList);
                        }
                        downloadChunk.setHostChunk(downloadChunk2);
                        subChunkList.add(downloadChunk);
                    } else {
                        List list3 = (List) sparseArray2.get(downloadChunk.getHostChunkIndex());
                        if (list3 == null) {
                            list3 = new ArrayList();
                            sparseArray2.put(downloadChunk.getHostChunkIndex(), list3);
                        }
                        list3.add(downloadChunk);
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            arrayList.add(sparseArray.get(sparseArray.keyAt(i2)));
        }
        return arrayList.isEmpty() ? list : arrayList;
    }

    public static void parseIOException(IOException iOException, String str) throws BaseException {
        if (str == null) {
            str = "";
        }
        String errorMsgWithTagPrefix = getErrorMsgWithTagPrefix(iOException, str);
        if (iOException instanceof ConnectException) {
            throw new BaseException(DownloadErrorCode.ERROR_NETWORK_CONNECTION_IO, errorMsgWithTagPrefix);
        }
        if (iOException instanceof UnknownHostException) {
            throw new BaseException(DownloadErrorCode.ERROR_UNKNOWN_HOST, errorMsgWithTagPrefix);
        }
        if (iOException instanceof NoRouteToHostException) {
            throw new BaseException(DownloadErrorCode.ERROR_NO_ROUTE_TO_HOST, errorMsgWithTagPrefix);
        }
        if (iOException instanceof UnknownServiceException) {
            throw new BaseException(DownloadErrorCode.ERROR_UNKNOWN_SERVICE, errorMsgWithTagPrefix);
        }
        if (iOException instanceof PortUnreachableException) {
            throw new BaseException(DownloadErrorCode.ERROR_PORT_UNREACHABLE, errorMsgWithTagPrefix);
        }
        if (iOException instanceof SocketTimeoutException) {
            throw new BaseException(DownloadErrorCode.ERROR_TIME_OUT, errorMsgWithTagPrefix);
        }
        if (iOException instanceof SocketException) {
            throw new BaseException(DownloadErrorCode.ERROR_SOCKET, errorMsgWithTagPrefix);
        }
        if (iOException instanceof HttpRetryException) {
            throw new BaseException(DownloadErrorCode.ERROR_HTTP_RETRY, errorMsgWithTagPrefix);
        }
        if (iOException instanceof ProtocolException) {
            throw new BaseException(DownloadErrorCode.ERROR_PROTOCOL, errorMsgWithTagPrefix);
        }
        if (iOException instanceof MalformedURLException) {
            throw new BaseException(DownloadErrorCode.ERROR_MALFORMED_URL, errorMsgWithTagPrefix);
        }
        if (iOException instanceof FileNotFoundException) {
            throw new BaseException(DownloadErrorCode.ERROR_FILE_NOT_FOUND, errorMsgWithTagPrefix);
        }
        if (iOException instanceof InterruptedIOException) {
            throw new BaseException(DownloadErrorCode.ERROR_INTERRUPTED_IO, errorMsgWithTagPrefix);
        }
        if (iOException instanceof UnsupportedEncodingException) {
            throw new BaseException(DownloadErrorCode.ERROR_UNSUPPORTED_ENCODING, errorMsgWithTagPrefix);
        }
        if (iOException instanceof EOFException) {
            throw new BaseException(DownloadErrorCode.ERROR_EOF, errorMsgWithTagPrefix);
        }
        if (iOException instanceof StreamResetException) {
            throw new BaseException(DownloadErrorCode.ERROR_STREAM_RESET, errorMsgWithTagPrefix);
        }
        if (iOException instanceof SSLException) {
            throw new BaseException(1011, errorMsgWithTagPrefix);
        }
        if (!isInsufficientSpaceError(iOException)) {
            throw new BaseException(1023, errorMsgWithTagPrefix);
        }
        throw new BaseException(1006, errorMsgWithTagPrefix);
    }

    private static void parseTTNetException(Throwable th, String str) throws DownloadTTNetException {
        DownloadTTNetException translateTTNetException = DownloadComponentManager.getTTNetHandler().translateTTNetException(th, null);
        if (translateTTNetException == null) {
            translateTTNetException = DownloadComponentManager.getTTNetHandler().translateTTNetException(th.getCause(), null);
        }
        if (translateTTNetException == null) {
            return;
        }
        throw new DownloadTTNetException(translateTTNetException.getErrorCode(), getErrorMsgWithTagPrefix(translateTTNetException, str)).setRequestLog(translateTTNetException.getRequestLog());
    }

    public static long parserMaxAge(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        Matcher matcher = Pattern.compile("max-age=([0-9]+)").matcher(str);
        if (!matcher.find()) {
            return 0L;
        }
        try {
            return Long.parseLong(matcher.group(1));
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    public static void safeClose(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x019c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void saveFileAsTargetName(com.ss.android.socialbase.downloader.model.DownloadInfo r18, com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend r19, com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback r20) {
        /*
            Method dump skipped, instructions count: 622
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.utils.DownloadUtils.saveFileAsTargetName(com.ss.android.socialbase.downloader.model.DownloadInfo, com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend, com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback):void");
    }

    public static <K> void sparseArrayPutAll(SparseArray<K> sparseArray, Map<Integer, K> map) {
        if (map == null || sparseArray == null) {
            return;
        }
        for (Integer num : map.keySet()) {
            if (num != null) {
                sparseArray.put(num.intValue(), map.get(num));
            }
        }
    }

    public static <K> HashMap<Integer, K> sparseArrayToHashMap(SparseArray<K> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        HashMap<Integer, K> hashMap = new HashMap<>();
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            int keyAt = sparseArray.keyAt(i2);
            hashMap.put(Integer.valueOf(keyAt), sparseArray.valueAt(i2));
        }
        return hashMap;
    }

    public static String toHexString(byte[] bArr) {
        if (bArr != null) {
            return toHexString(bArr, 0, bArr.length);
        }
        throw new NullPointerException("bytes is null");
    }

    public static List<HttpHeader> addRangeHeader(List<HttpHeader> list, String str, long j2, long j3) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (HttpHeader httpHeader : list) {
                if (httpHeader != null) {
                    arrayList.add(httpHeader);
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new HttpHeader(HttpHeaders.IF_MATCH, str));
        }
        arrayList.add(new HttpHeader(HttpHeaders.ACCEPT_ENCODING, HTTP.IDENTITY_CODING));
        String format = j3 <= 0 ? String.format("bytes=%s-", String.valueOf(j2)) : String.format("bytes=%s-%s", String.valueOf(j2), String.valueOf(j3));
        arrayList.add(new HttpHeader(HttpHeaders.RANGE, format));
        Logger.d(TAG, " range CurrentOffset:" + j2 + " EndOffset:" + j3 + ", range = " + format);
        return arrayList;
    }

    public static boolean copyFile(File file, File file2, boolean z) throws BaseException {
        if (file != null && file2 != null) {
            try {
                if (file.exists() && !file.isDirectory() && !file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                    File parentFile = file2.getParentFile();
                    if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                        throw new BaseException(DownloadErrorCode.ERROR_TARGET_DIR_MKDIR_FAILED, "Destination '" + parentFile + "' directory cannot be created");
                    }
                    Log.e(TAG, "copyFile: srcFile:" + file.getPath() + " destFile:" + file2.getPath());
                    if (file2.exists() && !file2.canWrite()) {
                        throw new IOException("Destination '" + file2 + "' exists but is read-only");
                    }
                    doCopyFile(file, file2, z);
                    return true;
                }
            } catch (BaseException e2) {
                throw e2;
            } catch (Throwable th) {
                parseException(th, "CopyFile");
                return false;
            }
        }
        return false;
    }

    public static void deleteAllDownloadFiles(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        if (z) {
            try {
                deleteFile(downloadInfo.getSavePath(), downloadInfo.getName());
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        deleteFile(downloadInfo.getTempPath(), downloadInfo.getTempName());
        if (downloadInfo.isSavePathRedirected()) {
            clearAntiHijackDir(downloadInfo);
        }
        if (z) {
            String md5Hex = md5Hex(downloadInfo.getUrl());
            if (TextUtils.isEmpty(md5Hex) || TextUtils.isEmpty(downloadInfo.getSavePath()) || !downloadInfo.getSavePath().contains(md5Hex)) {
                return;
            }
            deleteDirIfEmpty(downloadInfo.getSavePath());
        }
    }

    public static boolean isFileDownloaded(DownloadInfo downloadInfo, boolean z, String str) {
        if (!z && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            try {
                if (new File(downloadInfo.getSavePath(), downloadInfo.getName()).exists()) {
                    if (checkMd5Valid(downloadInfo.getSavePath(), downloadInfo.getName(), str)) {
                        return true;
                    }
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static int checkMd5Status(File file, String str) {
        return i.j(str, file);
    }

    public static boolean checkMd5Valid(File file, String str) {
        return isMd5Valid(i.j(str, file));
    }

    private static void ensureDirExists(File file) {
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static String toHexString(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            if (i2 >= 0 && i2 + i3 <= bArr.length) {
                int i4 = i3 * 2;
                char[] cArr = new char[i4];
                int i5 = 0;
                for (int i6 = 0; i6 < i3; i6++) {
                    int i7 = bArr[i6 + i2] & 255;
                    int i8 = i5 + 1;
                    char[] cArr2 = HEX_CHARS;
                    cArr[i5] = cArr2[i7 >> 4];
                    i5 = i8 + 1;
                    cArr[i8] = cArr2[i7 & 15];
                }
                return new String(cArr, 0, i4);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new NullPointerException("bytes is null");
    }

    public static boolean isResponseCodeError(BaseException baseException) {
        if (baseException instanceof DownloadHttpException) {
            DownloadHttpException downloadHttpException = (DownloadHttpException) baseException;
            if (downloadHttpException.getHttpStatusCode() == 412 || downloadHttpException.getHttpStatusCode() == 416) {
                return true;
            }
        }
        return false;
    }

    public static void safeClose(Cursor... cursorArr) {
        if (cursorArr == null) {
            return;
        }
        for (Cursor cursor : cursorArr) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static boolean isFileDownloaded(String str, String str2, boolean z) {
        if (!z && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                if (new File(str, str2).exists()) {
                    if (checkMd5Valid(str, str2, null)) {
                        return true;
                    }
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static boolean isFileDownloaded(String str, String str2, String str3, boolean z) {
        if (!z && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                if (new File(str, str2).exists()) {
                    if (checkMd5Valid(str, str2, str3)) {
                        return true;
                    }
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }
}
