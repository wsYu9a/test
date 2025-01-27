package com.ss.android.socialbase.downloader.monitor;

import android.net.Uri;
import android.text.TextUtils;
import com.sigmob.sdk.base.mta.PointCategory;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.depend.AbsDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IMonitorConfig;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.util.List;
import l5.c;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class DownloadMonitorHelper {
    private static final String DEFAULT_MONITOR_SCENE = "default";

    private static JSONObject getMonitorJson(String str, DownloadInfo downloadInfo, BaseException baseException, int i10) {
        JSONObject jSONObject;
        String str2;
        Object obj;
        Object obj2;
        int i11;
        String str3;
        String str4;
        String str5;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e10) {
            e = e10;
        }
        try {
            IMonitorConfig monitorConfig = DownloadComponentManager.getMonitorConfig();
            if (monitorConfig != null) {
                str2 = monitorConfig.getDeviceId();
                obj = parseDevicePostfix(str2);
                obj2 = monitorConfig.getAppId();
                i11 = monitorConfig.getUpdateVersion();
            } else {
                str2 = "";
                obj = str2;
                obj2 = obj;
                i11 = 0;
            }
            Object requestLog = (baseException == null || !(baseException instanceof DownloadTTNetException)) ? "" : ((DownloadTTNetException) baseException).getRequestLog();
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, str);
            jSONObject.put("app_id", obj2);
            jSONObject.put("device_id", str2);
            jSONObject.put(MonitorConstants.EXTRA_DEVICE_ID_POSTFIX, obj);
            jSONObject.put(MonitorConstants.EXTRA_UPDATE_VERSION, i11);
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_STATUS, i10);
            if (downloadInfo != null) {
                jSONObject.put(DownloadSettingKeys.SETTING_TAG, DownloadSetting.obtain(downloadInfo.getId()).optString(DownloadSettingKeys.SETTING_TAG));
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_ID, downloadInfo.getId());
                jSONObject.put("name", downloadInfo.getName());
                jSONObject.put("url", downloadInfo.getUrl());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_SAVE_PATH, downloadInfo.getSavePath());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_TIME, downloadInfo.getDownloadTime());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_BYTES, downloadInfo.getCurBytes());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_TOTAL_BYTES, downloadInfo.getTotalBytes());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_NETWORK_QUALITY, downloadInfo.getNetworkQuality());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_ONLY_WIFI, downloadInfo.isOnlyWifi() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_NEED_HTTPS_DEGRADE, downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_HTTPS_DEGRADE_RETRY_USED, downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                jSONObject.put("md5", downloadInfo.getMd5() == null ? "" : downloadInfo.getMd5());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_CHUNK_COUNT, downloadInfo.getChunkCount());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_IS_FORCE, downloadInfo.isForce() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_RETRY_COUNT, downloadInfo.getRetryCount());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_RETRY_TIME, downloadInfo.getCurRetryTime());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_NEED_RETRY_DELAY, downloadInfo.isNeedRetryDelay() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_NEED_REUSE_FIRST_CONNECTION, downloadInfo.isNeedReuseFirstConnection() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_DEFAULT_HTTP_SERVICE_BACKUP, downloadInfo.isNeedDefaultHttpServiceBackUp() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_RETRY_DELAY_STATUS, downloadInfo.getRetryDelayStatus().ordinal());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL_USED, downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_BYTE_ERROR_RETRY_STATUS, downloadInfo.getByteInvalidRetryStatus().ordinal());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_FORBIDDEN_HANDLER_STATUS, downloadInfo.getAsyncHandleStatus().ordinal());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_NEED_INDEPENDENT_PROCESS, downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_HEAD_CONNECTION_ERROR_MSG, downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                jSONObject.put("extra", downloadInfo.getExtra() != null ? downloadInfo.getExtra() : "");
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_ADD_LISTENER_TO_SAME_TASK, downloadInfo.isAddListenerToSameTask() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL_COUNT, downloadInfo.getBackUpUrls() != null ? downloadInfo.getBackUpUrls().size() : 0);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_BACKUP_URL_INDEX, downloadInfo.getBackUpUrls() != null ? downloadInfo.getCurBackUpUrlIndex() : -1);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_FORBIDDEN_URLS, downloadInfo.getForbiddenBackupUrls() != null ? downloadInfo.getForbiddenBackupUrls().toString() : "");
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_TASK_ID, TextUtils.isEmpty(downloadInfo.getTaskId()) ? "" : downloadInfo.getTaskId());
                try {
                    String url = downloadInfo.getUrl();
                    if (TextUtils.isEmpty(url)) {
                        str3 = "";
                        str4 = str3;
                        str5 = str4;
                    } else {
                        Uri parse = Uri.parse(url);
                        str4 = parse.getHost();
                        str5 = parse.getPath();
                        str3 = parse.getLastPathSegment();
                        if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str3)) {
                            try {
                                str5 = str5.substring(0, str5.length() - str3.length());
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                        }
                    }
                    jSONObject.put(MonitorConstants.URL_HOST, str4);
                    jSONObject.put(MonitorConstants.URL_PATH, str5);
                    jSONObject.put(MonitorConstants.URL_LAST_PATH_SEGMENT, str3);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
            jSONObject.put("error_code", baseException != null ? baseException.getErrorCode() : 0);
            jSONObject.put("error_msg", baseException != null ? baseException.getErrorMessage() : "");
            jSONObject.put(MonitorConstants.REQUEST_LOG, requestLog);
            return jSONObject;
        } catch (JSONException e11) {
            e = e11;
            jSONObject2 = jSONObject;
            e.printStackTrace();
            return jSONObject2;
        }
    }

    private static boolean isMonitorStatus(int[] iArr, int i10) {
        if (iArr != null && iArr.length > 0) {
            for (int i11 : iArr) {
                if (i10 == i11) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:11|(4:71|72|73|(16:75|76|14|(2:52|(1:(2:60|(1:62)(2:63|64)))(1:57))|17|18|(2:22|23)|26|27|28|(1:30)|31|32|(1:44)|35|(2:39|41)(1:38)))|13|14|(0)|52|(1:54)|(0)|17|18|(3:20|22|23)|26|27|28|(0)|31|32|(0)|42|44|35|(0)|39|41) */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00fd, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0119, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00eb A[Catch: all -> 0x003c, JSONException -> 0x00fd, TryCatch #3 {JSONException -> 0x00fd, blocks: (B:28:0x00af, B:30:0x00eb, B:31:0x00ff), top: B:27:0x00af, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x005b A[Catch: all -> 0x003c, TRY_LEAVE, TryCatch #4 {all -> 0x003c, blocks: (B:73:0x002f, B:75:0x0033, B:18:0x0081, B:20:0x0097, B:26:0x00aa, B:28:0x00af, B:30:0x00eb, B:31:0x00ff, B:39:0x0132, B:42:0x0124, B:44:0x012a, B:48:0x0119, B:52:0x004a, B:54:0x0050, B:60:0x005b, B:64:0x0069, B:68:0x006f, B:70:0x007b, B:80:0x002c, B:72:0x0025), top: B:71:0x0025, inners: #0, #2, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void monitorDownloadConnect(@androidx.annotation.Nullable com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection r14, java.lang.String r15, java.lang.String r16, long r17, java.lang.String r19, int r20, java.io.IOException r21, com.ss.android.socialbase.downloader.model.DownloadInfo r22) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadConnect(com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection, java.lang.String, java.lang.String, long, java.lang.String, int, java.io.IOException, com.ss.android.socialbase.downloader.model.DownloadInfo):void");
    }

    public static void monitorDownloadIO(DownloadSetting downloadSetting, DownloadInfo downloadInfo, String str, IDownloadHttpConnection iDownloadHttpConnection, boolean z10, boolean z11, BaseException baseException, long j10, long j11, boolean z12, long j12, long j13, long j14, JSONObject jSONObject) {
        monitorIO(MonitorConstants.DOWNLOAD_IO, downloadSetting.optInt(DownloadSettingKeys.MONITOR_DOWNLOAD_IO), downloadSetting, downloadInfo, str, null, null, iDownloadHttpConnection, z10, z11, baseException, j10, j11, z12, j12, j13, j14, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0072 A[Catch: all -> 0x0043, TryCatch #1 {all -> 0x0043, blocks: (B:6:0x0016, B:8:0x002d, B:18:0x0067, B:20:0x0072, B:22:0x0081, B:23:0x008b, B:27:0x0098, B:29:0x009c, B:30:0x00a2, B:32:0x00a6, B:34:0x00b9, B:36:0x0106, B:37:0x0117, B:39:0x0129, B:41:0x0132, B:42:0x014d, B:51:0x0181, B:54:0x016c, B:56:0x0172, B:63:0x0052, B:66:0x0063, B:67:0x005f), top: B:5:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0106 A[Catch: all -> 0x0043, TryCatch #1 {all -> 0x0043, blocks: (B:6:0x0016, B:8:0x002d, B:18:0x0067, B:20:0x0072, B:22:0x0081, B:23:0x008b, B:27:0x0098, B:29:0x009c, B:30:0x00a2, B:32:0x00a6, B:34:0x00b9, B:36:0x0106, B:37:0x0117, B:39:0x0129, B:41:0x0132, B:42:0x014d, B:51:0x0181, B:54:0x016c, B:56:0x0172, B:63:0x0052, B:66:0x0063, B:67:0x005f), top: B:5:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0129 A[Catch: all -> 0x0043, TryCatch #1 {all -> 0x0043, blocks: (B:6:0x0016, B:8:0x002d, B:18:0x0067, B:20:0x0072, B:22:0x0081, B:23:0x008b, B:27:0x0098, B:29:0x009c, B:30:0x00a2, B:32:0x00a6, B:34:0x00b9, B:36:0x0106, B:37:0x0117, B:39:0x0129, B:41:0x0132, B:42:0x014d, B:51:0x0181, B:54:0x016c, B:56:0x0172, B:63:0x0052, B:66:0x0063, B:67:0x005f), top: B:5:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0132 A[Catch: all -> 0x0043, TryCatch #1 {all -> 0x0043, blocks: (B:6:0x0016, B:8:0x002d, B:18:0x0067, B:20:0x0072, B:22:0x0081, B:23:0x008b, B:27:0x0098, B:29:0x009c, B:30:0x00a2, B:32:0x00a6, B:34:0x00b9, B:36:0x0106, B:37:0x0117, B:39:0x0129, B:41:0x0132, B:42:0x014d, B:51:0x0181, B:54:0x016c, B:56:0x0172, B:63:0x0052, B:66:0x0063, B:67:0x005f), top: B:5:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x017f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0172 A[Catch: all -> 0x0043, TryCatch #1 {all -> 0x0043, blocks: (B:6:0x0016, B:8:0x002d, B:18:0x0067, B:20:0x0072, B:22:0x0081, B:23:0x008b, B:27:0x0098, B:29:0x009c, B:30:0x00a2, B:32:0x00a6, B:34:0x00b9, B:36:0x0106, B:37:0x0117, B:39:0x0129, B:41:0x0132, B:42:0x014d, B:51:0x0181, B:54:0x016c, B:56:0x0172, B:63:0x0052, B:66:0x0063, B:67:0x005f), top: B:5:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b3  */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void monitorIO(java.lang.String r19, int r20, com.ss.android.socialbase.downloader.setting.DownloadSetting r21, com.ss.android.socialbase.downloader.model.DownloadInfo r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, com.ss.android.socialbase.downloader.network.IDownloadHttpConnection r26, boolean r27, boolean r28, com.ss.android.socialbase.downloader.exception.BaseException r29, long r30, long r32, boolean r34, long r35, long r37, long r39, org.json.JSONObject r41) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorIO(java.lang.String, int, com.ss.android.socialbase.downloader.setting.DownloadSetting, com.ss.android.socialbase.downloader.model.DownloadInfo, java.lang.String, java.lang.String, java.lang.String, com.ss.android.socialbase.downloader.network.IDownloadHttpConnection, boolean, boolean, com.ss.android.socialbase.downloader.exception.BaseException, long, long, boolean, long, long, long, org.json.JSONObject):void");
    }

    public static void monitorSegmentIO(DownloadSetting downloadSetting, DownloadInfo downloadInfo, String str, String str2, String str3, boolean z10, IDownloadHttpConnection iDownloadHttpConnection, BaseException baseException, long j10, long j11) {
        monitorIO(MonitorConstants.SEGMENT_IO, downloadSetting.optInt(DownloadSettingKeys.MONITOR_SEGMENT_IO), downloadSetting, downloadInfo, str, str2, str3, iDownloadHttpConnection, z10, false, baseException, j10, j11, false, -1L, -1L, -1L, null);
    }

    public static void monitorSegmentsError(DownloadInfo downloadInfo, List<Segment> list) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DBDefinition.SEGMENT_TABLE_NAME, Segment.toString(list));
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_BYTES, downloadInfo.getCurBytes());
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_TOTAL_BYTES, downloadInfo.getTotalBytes());
            InnerEventListener eventListener = DownloadComponentManager.getEventListener();
            if (eventListener != null) {
                eventListener.onEvent(downloadInfo.getId(), "segments_error", jSONObject);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void monitorSend(DownloadTask downloadTask, BaseException baseException, int i10) {
        if (downloadTask == null) {
            return;
        }
        try {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo == null) {
                return;
            }
            IDownloadMonitorDepend monitorDepend = downloadTask.getMonitorDepend();
            boolean isMonitorStatus = DownloadStatus.isMonitorStatus(i10);
            if (!isMonitorStatus && !(isMonitorStatus = isMonitorStatus(downloadInfo.getExtraMonitorStatus(), i10)) && monitorDepend != null && (monitorDepend instanceof AbsDownloadMonitorDepend)) {
                isMonitorStatus = isMonitorStatus(((AbsDownloadMonitorDepend) monitorDepend).getAdditionalMonitorStatus(), i10);
            }
            if (isMonitorStatus) {
                try {
                    IDownloadDepend depend = downloadTask.getDepend();
                    if (depend != null) {
                        depend.monitorLogSend(downloadInfo, baseException, i10);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                monitorSendWithTaskMonitor(monitorDepend, downloadInfo, baseException, i10);
                monitorSendWithGlobalSdkMonitor(DownloadComponentManager.getDownloadMonitorListener(), downloadInfo, baseException, i10);
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    public static void monitorSendWithGlobalSdkMonitor(IDownloadMonitorListener iDownloadMonitorListener, DownloadInfo downloadInfo, BaseException baseException, int i10) {
        if (iDownloadMonitorListener == null || !downloadInfo.isNeedSDKMonitor() || TextUtils.isEmpty(downloadInfo.getMonitorScene())) {
            return;
        }
        try {
            JSONObject monitorJson = getMonitorJson(downloadInfo.getMonitorScene(), downloadInfo, baseException, i10);
            if (monitorJson == null) {
                monitorJson = new JSONObject();
            }
            if (i10 == -1) {
                monitorJson.put("status", baseException.getErrorCode());
                iDownloadMonitorListener.monitorEvent(PointCategory.DOWNLOAD_FAILED, monitorJson, null, null);
            } else {
                putMonitorJsonStatus(i10, monitorJson, downloadInfo);
                iDownloadMonitorListener.monitorEvent("download_common", monitorJson, null, null);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void monitorSendWithTaskMonitor(IDownloadMonitorDepend iDownloadMonitorDepend, DownloadInfo downloadInfo, BaseException baseException, int i10) {
        if (iDownloadMonitorDepend == null) {
            return;
        }
        try {
            String eventPage = iDownloadMonitorDepend.getEventPage();
            if (TextUtils.isEmpty(eventPage)) {
                eventPage = "default";
            }
            JSONObject monitorJson = getMonitorJson(eventPage, downloadInfo, baseException, i10);
            if (monitorJson == null) {
                monitorJson = new JSONObject();
            }
            iDownloadMonitorDepend.monitorLogSend(monitorJson);
        } catch (Throwable unused) {
        }
    }

    public static String parseDevicePostfix(String str) {
        try {
            return TextUtils.isDigitsOnly(str) ? String.valueOf(Long.valueOf(str).longValue() % 100) : "";
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    private static void putMonitorJsonStatus(int i10, JSONObject jSONObject, DownloadInfo downloadInfo) throws JSONException {
        String str;
        if (i10 == -5) {
            str = "download_uncomplete";
        } else if (i10 == -4) {
            str = "download_cancel";
        } else if (i10 != -3) {
            str = i10 != -2 ? i10 != 0 ? i10 != 2 ? i10 != 6 ? "" : "download_first_start" : "download_start" : "download_create" : "download_pause";
        } else {
            double downloadSpeed = downloadInfo.getDownloadSpeed();
            if (downloadSpeed >= c.f27899e) {
                jSONObject.put(MonitorConstants.DOWNLOAD_SPEED, downloadSpeed);
            }
            str = "download_success";
        }
        jSONObject.put("status", str);
    }
}
