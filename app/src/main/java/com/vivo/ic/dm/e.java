package com.vivo.ic.dm;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import com.vivo.mobad.R;

/* loaded from: classes4.dex */
public class e extends DownloadNotifier {

    /* renamed from: a */
    private static final String f28454a = "dm_chanel_suspend";

    /* renamed from: b */
    private static final String f28455b = "dm_chanel_common";

    /* renamed from: c */
    private boolean f28456c;

    public e(Context context) {
        super(context);
        this.f28456c = false;
    }

    private void a(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            NotificationChannel notificationChannel = new NotificationChannel(f28455b, f28455b, 2);
            notificationChannel.setDescription("test_chanel_id_des");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(-65536);
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            NotificationChannel notificationChannel2 = new NotificationChannel(f28454a, f28454a, 4);
            notificationManager.createNotificationChannel(notificationChannel);
            notificationManager.createNotificationChannel(notificationChannel2);
        }
    }

    @Deprecated
    public String a() {
        return null;
    }

    @Override // com.vivo.ic.dm.a
    public int getIconIdDownloadFailed() {
        return R.drawable.dm_noti_icon_error;
    }

    @Override // com.vivo.ic.dm.a
    public int getIconIdDownloadSuccess() {
        return R.drawable.dm_noti_icon_done;
    }

    @Override // com.vivo.ic.dm.a
    public int getIconIdDownloadWarn() {
        return R.drawable.dm_noti_stat_sys_warning;
    }

    @Override // com.vivo.ic.dm.a
    public int getIconIdDownloading() {
        return R.drawable.dm_noti_icon_download;
    }

    @Override // com.vivo.ic.dm.a
    public int getNotiIdDownloadFinished(int i2) {
        return i2 + 20000;
    }

    @Override // com.vivo.ic.dm.a
    public int getNotiIdDownloadWarn() {
        return Constants.NOTI_ID_NET_CHANGE_WARNING;
    }

    @Override // com.vivo.ic.dm.a
    public int getNotiIdDownloading() {
        return 10000;
    }

    @Override // com.vivo.ic.dm.DownloadNotifier, com.vivo.ic.dm.a
    public String getNotificationChannel() {
        return f28455b;
    }

    @Override // com.vivo.ic.dm.DownloadNotifier, com.vivo.ic.dm.a
    public String[] getNotificationChannels() {
        if (!this.f28456c) {
            this.f28456c = true;
            a(this.mContext);
        }
        return new String[]{f28455b, f28454a};
    }

    @Override // com.vivo.ic.dm.a
    public String getStringDownloadFailed() {
        return this.mRes.getString(R.string.dm_noti_download_failed);
    }

    @Override // com.vivo.ic.dm.a
    public String getStringDownloadSuccess() {
        return this.mRes.getString(R.string.dm_noti_download_complete);
    }

    @Override // com.vivo.ic.dm.a
    public String getStringDownloadWarnContent() {
        return this.mRes.getString(R.string.dm_noti_wlan_disconnected);
    }

    @Override // com.vivo.ic.dm.a
    public String getStringDownloadWarnTitle() {
        return this.mRes.getString(R.string.dm_noti_download_paused);
    }

    @Override // com.vivo.ic.dm.a
    public String getStringMultiDownloading(int i2) {
        return this.mRes.getString(R.string.dm_noti_download_N, Integer.valueOf(i2));
    }

    @Override // com.vivo.ic.dm.a
    public String getStringUnknownTitle() {
        return this.mRes.getString(R.string.dm_noti_unknown_title);
    }
}
