package com.vivo.ic.dm.datareport;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.alipay.mobilesecuritysdk.deviceID.c;
import com.alipay.sdk.util.g;
import com.cdo.oaps.ad.OapsKey;
import com.martian.mibook.application.MiConfigSingleton;
import com.vivo.ic.BaseLib;
import com.vivo.ic.NetUtils;
import com.vivo.ic.VLog;
import com.vivo.ic.dm.Constants;
import com.vivo.ic.dm.DownloadInfo;
import com.vivo.ic.dm.Downloads;
import com.vivo.ic.dm.l;
import com.vivo.ic.dm.network.d;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;

/* loaded from: classes4.dex */
public class a extends b {
    private static final long G = 1;
    private static final long H = 2;
    private static DataReportListener J;
    private static final String F = Constants.PRE_TAG + "DataReporterManager";
    private static a I = null;

    private a() {
        J = l.j().f();
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (I == null) {
                I = new a();
            }
            aVar = I;
        }
        return aVar;
    }

    private boolean a(long j2, long j3) {
        return j2 < 1 || j3 < 2;
    }

    public void b(DownloadInfo downloadInfo, int i2) {
        if (J != null) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("status", String.valueOf(i2));
            long startTime = downloadInfo.getStartTime();
            hashMap.put("zone", String.valueOf(downloadInfo.getDownloadType()));
            hashMap.put("id", String.valueOf(downloadInfo.getId()));
            if (startTime != -1) {
                hashMap.put(c.y, String.valueOf(SystemClock.elapsedRealtime() - startTime));
            }
            hashMap.put("totalbytes", String.valueOf(downloadInfo.getTotalBytes()));
            String errorMsg = downloadInfo.getErrorMsg();
            if (!TextUtils.isEmpty(errorMsg)) {
                hashMap.put("error", errorMsg);
            }
            int numFailed = downloadInfo.getNumFailed();
            if (numFailed > 0) {
                hashMap.put(g.f5460a, String.valueOf(numFailed));
            }
            a(hashMap);
            J.reportDownloadSuccess("00003|079", downloadInfo, hashMap);
            VLog.d(F, "reportDownloadSuccess:" + hashMap);
        }
    }

    public void c(List<Long> list, int i2) {
        if (J != null) {
            HashMap<String, String> hashMap = new HashMap<>();
            if (list != null && list.size() > 0) {
                hashMap.put(OapsKey.KEY_IDS, new JSONArray((Collection) list).toString());
            }
            hashMap.put("reason", String.valueOf(i2));
            a(hashMap);
            J.reportDownloadPause("00006|079", hashMap);
            VLog.d(F, "reportDownloadPause:" + hashMap);
        }
    }

    public void a(DownloadInfo downloadInfo, String str) {
        if (J != null) {
            HashMap<String, String> hashMap = new HashMap<>();
            a(hashMap);
            String uri = downloadInfo.getUri();
            long id = downloadInfo.getId();
            String a2 = a(downloadInfo);
            if (!TextUtils.isEmpty(a2)) {
                hashMap.put("dtype", a2);
            }
            if (!TextUtils.isEmpty(uri)) {
                hashMap.put("url", uri);
            }
            if (!TextUtils.isEmpty(str)) {
                hashMap.put(MiConfigSingleton.t0, str);
            }
            hashMap.put("id", String.valueOf(id));
            J.reportNewDownloadTask("00001|079", downloadInfo, hashMap);
            VLog.d(F, "reportNewDownloadTask:" + hashMap);
        }
    }

    public void b(List<Long> list, int i2) {
        if (J != null) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("delcount", String.valueOf(i2));
            if (list != null && list.size() > 0) {
                hashMap.put(OapsKey.KEY_IDS, new JSONArray((Collection) list).toString());
            }
            a(hashMap);
            J.reportDownloadDelete("00002|079", hashMap);
            VLog.d(F, "reportDownloadDelete:" + hashMap);
        }
    }

    private String a(DownloadInfo downloadInfo) {
        Collection<Pair<String, String>> headers = downloadInfo.getHeaders();
        if (headers == null) {
            return null;
        }
        for (Pair<String, String> pair : headers) {
            String str = (String) pair.first;
            if (!TextUtils.isEmpty(str) && str.startsWith(Downloads.RequestHeaders.INSERT_KEY_PREFIX)) {
                String str2 = (String) pair.second;
                if (!TextUtils.isEmpty(str) && str2.contains(":")) {
                    String[] split = str2.split(":", 2);
                    if (d.f28529b.equalsIgnoreCase(split[0].trim())) {
                        return split[1].trim();
                    }
                }
            }
        }
        return null;
    }

    public void a(DownloadInfo downloadInfo, int i2) {
        if (J != null) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("status", String.valueOf(i2));
            hashMap.put("id", String.valueOf(downloadInfo.getId()));
            hashMap.put(MiConfigSingleton.t0, downloadInfo.getFileName());
            hashMap.put("dpath", downloadInfo.getActualPath());
            String uri = downloadInfo.getUri();
            if (!TextUtils.isEmpty(uri)) {
                hashMap.put("url", uri);
            }
            String requestUri = downloadInfo.getRequestUri();
            if (!TextUtils.isEmpty(requestUri) && !requestUri.equals(uri)) {
                hashMap.put(Downloads.Column.REDIRECT_URL, requestUri);
            }
            String redirectUrl = downloadInfo.getRedirectUrl();
            if (!TextUtils.isEmpty(redirectUrl) && !redirectUrl.equals(requestUri)) {
                hashMap.put("old_redirect_url", redirectUrl);
            }
            hashMap.put("mimetype", downloadInfo.getMimeType());
            int numFailed = downloadInfo.getNumFailed();
            if (numFailed > 0) {
                hashMap.put(g.f5460a, String.valueOf(numFailed));
            }
            String errorMsg = downloadInfo.getErrorMsg();
            if (!TextUtils.isEmpty(errorMsg)) {
                hashMap.put("error", errorMsg);
            }
            hashMap.put("zone", String.valueOf(downloadInfo.getDownloadType()));
            String address = downloadInfo.getAddress();
            if (!TextUtils.isEmpty(address)) {
                hashMap.put("territory", address);
            }
            hashMap.put("etime", String.valueOf(System.currentTimeMillis()));
            a(hashMap);
            J.reportDownloadFailed("00004|079", downloadInfo, hashMap);
            VLog.d(F, "reportDownloadFailed:" + hashMap);
        }
    }

    public void a(DownloadInfo downloadInfo, long j2, long j3, long j4, long j5, DownloadInfo downloadInfo2, int i2) {
        if (J != null) {
            String str = F;
            VLog.d(str, "reportDownloadInterrupt startBytes:" + j2 + ",endBytes:" + j3 + ",startTime:" + j4 + ",endTime:" + j5);
            long j6 = (j3 - j2) / 1024;
            long j7 = (j5 - j4) / 1000;
            StringBuilder sb = new StringBuilder();
            sb.append("reportDownloadInterrupt downloadSize:");
            sb.append(j6);
            sb.append(",timeConsume:");
            sb.append(j7);
            VLog.d(str, sb.toString());
            if (a(j6, j7)) {
                return;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("status", String.valueOf(i2));
            hashMap.put("id", String.valueOf(downloadInfo2.getId()));
            a(hashMap);
            J.reportDownloadInterrupt("00005|079", downloadInfo, hashMap);
            VLog.d(str, "reportDownloadInterrupt:" + hashMap);
        }
    }

    public void a(DownloadInfo downloadInfo, long j2, long j3, long j4, long j5, int i2) {
        if (J != null) {
            String str = F;
            VLog.d(str, "reportDownloadSpeed startBytes:" + j2 + ",endBytes:" + j3 + ",startTime:" + j4 + ",endTime:" + j5);
            long j6 = (j3 - j2) / 1024;
            long j7 = (j5 - j4) / 1000;
            StringBuilder sb = new StringBuilder();
            sb.append("reportDownloadSpeed downloadSize:");
            sb.append(j6);
            sb.append(",timeConsume:");
            sb.append(j7);
            VLog.d(str, sb.toString());
            if (j7 <= 0) {
                VLog.d(str, "reportDownloadSpeed timeConsume <= 0, return");
                return;
            }
            long j8 = j6 / j7;
            if (a(j6, j7) || j8 <= 1) {
                return;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("id", String.valueOf(downloadInfo.getId()));
            hashMap.put("speed", String.valueOf(j8));
            hashMap.put("status", String.valueOf(i2));
            hashMap.put("zone", String.valueOf(downloadInfo.getDownloadType()));
            a(hashMap);
            J.reportDownloadSpeed("00007|079", downloadInfo, hashMap);
            VLog.d(str, "reportDownloadSpeed:" + hashMap);
        }
    }

    public void a(List<Long> list, int i2) {
        if (J != null) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("reason", String.valueOf(i2));
            if (list != null && list.size() > 0) {
                hashMap.put(OapsKey.KEY_IDS, new JSONArray((Collection) list).toString());
            }
            a(hashMap);
            J.reportDownloadContinue("00008|079", hashMap);
            VLog.d(F, "reportDownloadContinue:" + hashMap);
        }
    }

    public void a(String str, HashMap<String, String> hashMap) {
        if (J != null) {
            a(hashMap);
            J.reportNetWorkEvent(str, hashMap);
            VLog.d(F, "reportNetWorkEvent");
        }
    }

    private void a(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return;
        }
        hashMap.put("nt", NetUtils.getConnectionTypeName(BaseLib.getContext()));
        hashMap.put("downSdkversion", com.vivo.ic.dm.b.f28402f);
        hashMap.put("an", Build.VERSION.RELEASE);
        hashMap.put("av", String.valueOf(Build.VERSION.SDK_INT));
    }
}
