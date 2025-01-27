package com.ss.android.socialbase.appdownloader.e;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.RemoteViews;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.appdownloader.e;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;

/* loaded from: classes4.dex */
public class a extends AbsNotificationItem {

    /* renamed from: a */
    private final Context f21824a;

    /* renamed from: b */
    private final Resources f21825b;

    /* renamed from: c */
    private String f21826c;

    /* renamed from: d */
    private String f21827d;

    /* renamed from: e */
    private String f21828e;

    public a(Context context, int i10, String str, String str2, String str3, String str4) {
        super(i10, str);
        this.f21827d = str2;
        this.f21826c = str3;
        this.f21828e = str4;
        Context applicationContext = context.getApplicationContext();
        this.f21824a = applicationContext;
        this.f21825b = applicationContext.getResources();
    }

    /* JADX WARN: Removed duplicated region for block: B:149:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0430  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.app.Notification a(com.ss.android.socialbase.downloader.exception.BaseException r25, boolean r26) {
        /*
            Method dump skipped, instructions count: 1445
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.e.a.a(com.ss.android.socialbase.downloader.exception.BaseException, boolean):android.app.Notification");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:17:0x0044
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    private androidx.core.app.NotificationCompat.Builder b() {
        /*
            r3 = this;
            com.ss.android.socialbase.appdownloader.d r0 = com.ss.android.socialbase.appdownloader.d.j()
            java.lang.String r0 = r0.i()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 >= r2) goto L16
            androidx.core.app.NotificationCompat$Builder r0 = new androidx.core.app.NotificationCompat$Builder
            android.content.Context r1 = r3.f21824a
            r0.<init>(r1)
            goto L4b
        L16:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L22
            android.content.Context r0 = r3.f21824a
            java.lang.String r0 = com.ss.android.socialbase.appdownloader.c.b(r0)
        L22:
            com.ss.android.socialbase.appdownloader.d r1 = com.ss.android.socialbase.appdownloader.d.j()     // Catch: java.lang.NoSuchMethodError -> L44
            com.ss.android.socialbase.appdownloader.c.m r1 = r1.m()     // Catch: java.lang.NoSuchMethodError -> L44
            if (r1 == 0) goto L3b
            com.ss.android.socialbase.appdownloader.d r1 = com.ss.android.socialbase.appdownloader.d.j()     // Catch: java.lang.NoSuchMethodError -> L44
            com.ss.android.socialbase.appdownloader.c.m r1 = r1.m()     // Catch: java.lang.NoSuchMethodError -> L44
            android.content.Context r2 = r3.f21824a     // Catch: java.lang.NoSuchMethodError -> L44
            androidx.core.app.NotificationCompat$Builder r0 = r1.a(r2, r0)     // Catch: java.lang.NoSuchMethodError -> L44
            goto L4b
        L3b:
            androidx.core.app.NotificationCompat$Builder r1 = new androidx.core.app.NotificationCompat$Builder     // Catch: java.lang.NoSuchMethodError -> L44
            android.content.Context r2 = r3.f21824a     // Catch: java.lang.NoSuchMethodError -> L44
            r1.<init>(r2, r0)     // Catch: java.lang.NoSuchMethodError -> L44
            r0 = r1
            goto L4b
        L44:
            androidx.core.app.NotificationCompat$Builder r0 = new androidx.core.app.NotificationCompat$Builder
            android.content.Context r1 = r3.f21824a
            r0.<init>(r1)
        L4b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.e.a.b():androidx.core.app.NotificationCompat$Builder");
    }

    @Override // com.ss.android.socialbase.downloader.notification.AbsNotificationItem
    public void updateNotification(BaseException baseException, boolean z10) {
        if (this.f21824a == null) {
            return;
        }
        try {
            Notification a10 = a(baseException, z10);
            this.notification = a10;
            notify(a10);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.notification.AbsNotificationItem
    public void updateNotificationItem(DownloadInfo downloadInfo) {
        super.updateNotificationItem(downloadInfo);
        this.f21827d = downloadInfo.getSavePath();
        this.f21826c = downloadInfo.getName();
        this.f21828e = downloadInfo.getExtra();
    }

    private boolean a(BaseException baseException, DownloadSetting downloadSetting, DownloadInfo downloadInfo) {
        if (baseException != null) {
            return (baseException.getErrorCode() == 1013 || baseException.getErrorCode() == 1049) && downloadInfo != null && "application/vnd.android.package-archive".contains(downloadInfo.getMimeType()) && downloadSetting.optInt(DownloadSettingKeys.NOTIFICATION_TEXT_OPT, 0) == 1;
        }
        return false;
    }

    private RemoteViews a() {
        RemoteViews remoteViews = new RemoteViews(this.f21824a.getPackageName(), e.a());
        try {
            if (com.ss.android.socialbase.appdownloader.c.a(this.f21824a)) {
                remoteViews.setInt(e.f(), "setBackgroundColor", this.f21824a.getResources().getColor(e.r()));
            }
        } catch (Throwable unused) {
        }
        return remoteViews;
    }

    private int a(int i10, int i11) {
        if (DownloadSetting.obtain(i11).optInt("notification_opt_2") == 1) {
            return e.v();
        }
        if (i10 == 1 || i10 == 4) {
            return e.t();
        }
        if (i10 == 2) {
            return e.u();
        }
        if (i10 == 3) {
            return e.v();
        }
        return 0;
    }

    private PendingIntent a(String str, int i10, int i11) {
        Intent intent = new Intent(this.f21824a, (Class<?>) DownloadHandlerService.class);
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i11);
        intent.putExtra("extra_click_download_type", i10);
        intent.putExtra("extra_from_notification", true);
        return PendingIntent.getService(this.f21824a, i11, intent, 201326592);
    }

    private int a(int i10) {
        if (DownloadSetting.obtain(i10).optInt(DownloadSettingKeys.OPT_NOTIFICATION_UI) >= 1) {
            return e.h();
        }
        return e.g();
    }
}
