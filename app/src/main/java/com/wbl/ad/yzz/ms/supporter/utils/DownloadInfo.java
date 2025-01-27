package com.wbl.ad.yzz.ms.supporter.utils;

import android.content.Context;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.ms.e.d.a;
import com.wbl.ad.yzz.ms.f.b;
import com.wbl.ad.yzz.ms.f.m.c;
import java.io.File;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class DownloadInfo implements Serializable {
    public static final int STATUS_COMPLETE = 2;
    public static final int STATUS_INTERRUPTED = 1;
    public static final int STATUS_NONE = 0;
    public String cacheFile;
    public String deeplinkUrl;
    public String displayName;
    public String downloadFile;
    public String fileName;
    public String key;
    public int notificationId;
    public String packageName;
    public String[] reportDownloadStart;
    public String[] reportDownloadSuccess;
    public String[] reportInstallStart;
    public String[] reportInstallSucc;
    public String url;
    public int retryTime = 0;
    private Context context = b.getContext();
    public boolean downloadStartReported = false;
    public boolean downloadSuccessReported = false;
    public boolean installStartReported = false;
    public boolean installSuccessReported = false;
    public boolean hasNotifiedOpen = false;

    public DownloadInfo(String str, File file, String str2, a aVar) {
        this.url = null;
        this.fileName = null;
        this.downloadFile = null;
        this.cacheFile = null;
        this.packageName = null;
        int i2 = 0;
        this.displayName = null;
        this.key = aVar.toString();
        this.packageName = aVar.c().q();
        this.url = str;
        this.displayName = str2;
        this.fileName = a(str);
        this.cacheFile = new File(file, this.fileName + ".TempFile").getAbsolutePath();
        this.downloadFile = new File(file, this.fileName).getAbsolutePath();
        String[] n = aVar.c().n();
        this.reportDownloadStart = n;
        if (n != null) {
            int i3 = 0;
            while (true) {
                String[] strArr = this.reportDownloadStart;
                if (i3 >= strArr.length) {
                    break;
                }
                strArr[i3] = c.a(strArr[i3], aVar);
                i3++;
            }
        }
        String[] l = aVar.c().l();
        this.reportDownloadSuccess = l;
        if (l != null) {
            int i4 = 0;
            while (true) {
                String[] strArr2 = this.reportDownloadSuccess;
                if (i4 >= strArr2.length) {
                    break;
                }
                strArr2[i4] = c.a(strArr2[i4], aVar);
                i4++;
            }
        }
        String[] k = aVar.c().k();
        this.reportInstallStart = k;
        if (k != null) {
            int i5 = 0;
            while (true) {
                String[] strArr3 = this.reportInstallStart;
                if (i5 >= strArr3.length) {
                    break;
                }
                strArr3[i5] = c.a(strArr3[i5], aVar);
                i5++;
            }
        }
        String[] e2 = aVar.c().e();
        this.reportInstallSucc = e2;
        if (e2 != null) {
            while (true) {
                String[] strArr4 = this.reportInstallSucc;
                if (i2 >= strArr4.length) {
                    break;
                }
                strArr4[i2] = c.a(strArr4[i2], aVar);
                i2++;
            }
        }
        this.deeplinkUrl = aVar.c().j();
    }

    public static final String a(String str) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11484, null, str);
    }

    public int downloadStatus() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-11483, this, null);
    }

    public String getDisplayName() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11478, this, null);
    }

    public void onDownloadFailed() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11477, this, null);
    }

    public void onDownloadStart() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11480, this, null);
    }

    public void onDownloaded() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11479, this, null);
    }

    public void onInstallStart() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11474, this, null);
    }

    public void onInstallSucc() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11473, this, null);
    }

    public String toString() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11476, this, null);
    }
}
