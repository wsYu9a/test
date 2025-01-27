package com.ss.android.socialbase.appdownloader.q;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.widget.RemoteViews;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.appdownloader.q;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;

/* loaded from: classes4.dex */
public class j extends AbsNotificationItem {

    /* renamed from: g */
    private String f24488g;

    /* renamed from: i */
    private String f24489i;

    /* renamed from: j */
    private final Context f24490j;
    private String q;
    private final Resources zx;

    public j(Context context, int i2, String str, String str2, String str3, String str4) {
        super(i2, str);
        this.f24488g = str2;
        this.f24489i = str3;
        this.q = str4;
        Context applicationContext = context.getApplicationContext();
        this.f24490j = applicationContext;
        this.zx = applicationContext.getResources();
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0495  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x05ab  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x05b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.app.Notification j(com.ss.android.socialbase.downloader.exception.BaseException r26, boolean r27) {
        /*
            Method dump skipped, instructions count: 1467
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.q.j.j(com.ss.android.socialbase.downloader.exception.BaseException, boolean):android.app.Notification");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:17:0x0044
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    private androidx.core.app.NotificationCompat.Builder zx() {
        /*
            r3 = this;
            com.ss.android.socialbase.appdownloader.g r0 = com.ss.android.socialbase.appdownloader.g.pa()
            java.lang.String r0 = r0.k()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 >= r2) goto L16
            androidx.core.app.NotificationCompat$Builder r0 = new androidx.core.app.NotificationCompat$Builder
            android.content.Context r1 = r3.f24490j
            r0.<init>(r1)
            goto L4b
        L16:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L22
            android.content.Context r0 = r3.f24490j
            java.lang.String r0 = com.ss.android.socialbase.appdownloader.i.zx(r0)
        L22:
            com.ss.android.socialbase.appdownloader.g r1 = com.ss.android.socialbase.appdownloader.g.pa()     // Catch: java.lang.NoSuchMethodError -> L44
            com.ss.android.socialbase.appdownloader.i.p r1 = r1.t()     // Catch: java.lang.NoSuchMethodError -> L44
            if (r1 == 0) goto L3b
            com.ss.android.socialbase.appdownloader.g r1 = com.ss.android.socialbase.appdownloader.g.pa()     // Catch: java.lang.NoSuchMethodError -> L44
            com.ss.android.socialbase.appdownloader.i.p r1 = r1.t()     // Catch: java.lang.NoSuchMethodError -> L44
            android.content.Context r2 = r3.f24490j     // Catch: java.lang.NoSuchMethodError -> L44
            androidx.core.app.NotificationCompat$Builder r0 = r1.j(r2, r0)     // Catch: java.lang.NoSuchMethodError -> L44
            goto L4b
        L3b:
            androidx.core.app.NotificationCompat$Builder r1 = new androidx.core.app.NotificationCompat$Builder     // Catch: java.lang.NoSuchMethodError -> L44
            android.content.Context r2 = r3.f24490j     // Catch: java.lang.NoSuchMethodError -> L44
            r1.<init>(r2, r0)     // Catch: java.lang.NoSuchMethodError -> L44
            r0 = r1
            goto L4b
        L44:
            androidx.core.app.NotificationCompat$Builder r0 = new androidx.core.app.NotificationCompat$Builder
            android.content.Context r1 = r3.f24490j
            r0.<init>(r1)
        L4b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.q.j.zx():androidx.core.app.NotificationCompat$Builder");
    }

    @Override // com.ss.android.socialbase.downloader.notification.AbsNotificationItem
    public void updateNotification(BaseException baseException, boolean z) {
        if (this.f24490j == null) {
            return;
        }
        try {
            Notification j2 = j(baseException, z);
            this.notification = j2;
            notify(j2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.notification.AbsNotificationItem
    public void updateNotificationItem(DownloadInfo downloadInfo) {
        super.updateNotificationItem(downloadInfo);
        this.f24488g = downloadInfo.getSavePath();
        this.f24489i = downloadInfo.getName();
        this.q = downloadInfo.getExtra();
    }

    private boolean j(BaseException baseException, DownloadSetting downloadSetting, DownloadInfo downloadInfo) {
        return baseException != null && (baseException.getErrorCode() == 1013 || baseException.getErrorCode() == 1049) && downloadInfo != null && AdBaseConstants.MIME_APK.contains(downloadInfo.getMimeType()) && downloadSetting.optInt(DownloadSettingKeys.NOTIFICATION_TEXT_OPT, 0) == 1;
    }

    private RemoteViews j() {
        RemoteViews remoteViews = new RemoteViews(this.f24490j.getPackageName(), q.j());
        if (Build.VERSION.SDK_INT > 20) {
            try {
                if (com.ss.android.socialbase.appdownloader.i.j(this.f24490j)) {
                    remoteViews.setInt(q.gv(), "setBackgroundColor", this.f24490j.getResources().getColor(q.e()));
                }
            } catch (Throwable unused) {
            }
        }
        return remoteViews;
    }

    private int j(int i2, int i3) {
        if (DownloadSetting.obtain(i3).optInt("notification_opt_2") == 1) {
            return q.f();
        }
        if (i2 == 1 || i2 == 4) {
            return q.gm();
        }
        if (i2 == 2) {
            return q.hm();
        }
        if (i2 == 3) {
            return q.f();
        }
        return 0;
    }

    private PendingIntent j(String str, int i2, int i3) {
        Intent intent = new Intent(this.f24490j, (Class<?>) DownloadHandlerService.class);
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i3);
        intent.putExtra("extra_click_download_type", i2);
        intent.putExtra("extra_from_notification", true);
        return PendingIntent.getService(this.f24490j, i3, intent, 201326592);
    }

    private int j(int i2) {
        if (DownloadSetting.obtain(i2).optInt(DownloadSettingKeys.OPT_NOTIFICATION_UI) >= 1) {
            return q.y();
        }
        return q.lg();
    }
}
