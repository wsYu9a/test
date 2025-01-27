package cn.vlion.ad.inland.base;

import android.text.TextUtils;
import cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class s0 {

    /* renamed from: a */
    public static ConcurrentHashMap<Long, DownloadApkData> f3359a = new ConcurrentHashMap<>();

    public static DownloadApkData a(String str) {
        try {
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        LogVlion.e("VlionApkDownUtils pkg=" + str);
        for (Map.Entry<Long, DownloadApkData> entry : f3359a.entrySet()) {
            Long key = entry.getKey();
            DownloadApkData value = entry.getValue();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("VlionApkDownUtils (null != value)=");
            sb2.append(value != null);
            LogVlion.e(sb2.toString());
            if (value != null) {
                LogVlion.e("VlionApkDownUtils key=" + key + " value.getPackageName()=" + value.getPackageName());
                if (str.equals(value.getPackageName())) {
                    return value;
                }
            }
        }
        return null;
    }

    public static void a(long j10) {
        try {
            LogVlion.e("VlionApkDownUtils remove" + j10);
            f3359a.remove(Long.valueOf(j10));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
