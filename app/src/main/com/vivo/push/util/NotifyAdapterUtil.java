package com.vivo.push.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.vivo.push.d.r;
import com.vivo.push.model.InsideNotificationItem;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import q.a0;
import q.s2;

/* loaded from: classes4.dex */
public class NotifyAdapterUtil {
    private static final int HIDE_TITLE = 1;
    public static final int NOTIFY_MULTITERM_STYLE = 1;
    public static final int NOTIFY_SINGLE_STYLE = 0;
    public static final String PRIMARY_CHANNEL = "vivo_push_channel";
    private static final String PUSH_EN = "PUSH";
    private static final String PUSH_ID = "pushId";
    private static final String PUSH_ZH = "推送通知";
    private static final String TAG = "NotifyManager";
    private static NotificationManager sNotificationManager = null;
    private static int sNotifyId = 20000000;

    private static boolean cancelNotify(Context context, int i10) {
        initAdapter(context);
        NotificationManager notificationManager = sNotificationManager;
        if (notificationManager == null) {
            return false;
        }
        notificationManager.cancel(i10);
        return true;
    }

    private static synchronized void initAdapter(Context context) {
        NotificationManager notificationManager;
        NotificationChannel notificationChannel;
        CharSequence name;
        synchronized (NotifyAdapterUtil.class) {
            try {
                if (sNotificationManager == null) {
                    sNotificationManager = (NotificationManager) context.getSystemService("notification");
                }
                if (Build.VERSION.SDK_INT >= 26 && (notificationManager = sNotificationManager) != null) {
                    notificationChannel = notificationManager.getNotificationChannel(DownloadSettingKeys.BugFix.DEFAULT);
                    if (notificationChannel != null) {
                        name = notificationChannel.getName();
                        if (PUSH_ZH.equals(name) || PUSH_EN.equals(name)) {
                            sNotificationManager.deleteNotificationChannel(DownloadSettingKeys.BugFix.DEFAULT);
                        }
                    }
                    String str = isZh(context) ? PUSH_ZH : PUSH_EN;
                    a0.a();
                    NotificationChannel a10 = q.z.a(PRIMARY_CHANNEL, str, 4);
                    a10.setLightColor(-16711936);
                    a10.enableVibration(true);
                    a10.setLockscreenVisibility(1);
                    sNotificationManager.createNotificationChannel(a10);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static boolean isZh(Context context) {
        return context.getResources().getConfiguration().locale.getLanguage().endsWith("zh");
    }

    public static void pushNotification(Context context, List<Bitmap> list, InsideNotificationItem insideNotificationItem, long j10, int i10, r.a aVar) {
        p.d(TAG, "pushNotification");
        initAdapter(context);
        int notifyMode = NotifyUtil.getNotifyDataAdapter(context).getNotifyMode(insideNotificationItem);
        if (!TextUtils.isEmpty(insideNotificationItem.getPurePicUrl()) && list != null && list.size() > 1 && list.get(1) != null) {
            notifyMode = 1;
        }
        if (notifyMode == 2) {
            pushNotificationBySystem(context, list, insideNotificationItem, j10, i10, aVar);
        } else if (notifyMode == 1) {
            pushNotificationByCustom(context, list, insideNotificationItem, j10, aVar);
        }
    }

    private static void pushNotificationByCustom(Context context, List<Bitmap> list, InsideNotificationItem insideNotificationItem, long j10, r.a aVar) {
        Notification build;
        int i10;
        Bitmap bitmap;
        Resources resources = context.getResources();
        String packageName = context.getPackageName();
        String title = insideNotificationItem.getTitle();
        int defaultNotifyIcon = NotifyUtil.getNotifyDataAdapter(context).getDefaultNotifyIcon();
        int i11 = context.getApplicationInfo().icon;
        Bundle bundle = new Bundle();
        bundle.putLong(PUSH_ID, j10);
        if (Build.VERSION.SDK_INT >= 26) {
            Notification.Builder a10 = s2.a(context, PRIMARY_CHANNEL);
            if (defaultNotifyIcon > 0) {
                bundle.putInt("vivo.summaryIconRes", defaultNotifyIcon);
            }
            a10.setExtras(bundle);
            build = a10.build();
        } else {
            Notification.Builder builder = new Notification.Builder(context);
            builder.setExtras(bundle);
            build = builder.build();
        }
        build.priority = 2;
        build.flags = 16;
        build.tickerText = title;
        int defaultSmallIconId = NotifyUtil.getNotifyDataAdapter(context).getDefaultSmallIconId();
        if (defaultSmallIconId <= 0) {
            defaultSmallIconId = i11;
        }
        build.icon = defaultSmallIconId;
        RemoteViews remoteViews = new RemoteViews(packageName, NotifyUtil.getNotifyLayoutAdapter(context).getNotificationLayout());
        remoteViews.setTextViewText(resources.getIdentifier("notify_title", "id", packageName), title);
        remoteViews.setTextColor(resources.getIdentifier("notify_title", "id", packageName), NotifyUtil.getNotifyLayoutAdapter(context).getTitleColor());
        remoteViews.setTextViewText(resources.getIdentifier("notify_msg", "id", packageName), insideNotificationItem.getContent());
        if (insideNotificationItem.isShowTime()) {
            remoteViews.setTextViewText(resources.getIdentifier("notify_when", "id", packageName), new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date()));
            i10 = 0;
            remoteViews.setViewVisibility(resources.getIdentifier("notify_when", "id", packageName), 0);
        } else {
            i10 = 0;
            remoteViews.setViewVisibility(resources.getIdentifier("notify_when", "id", packageName), 8);
        }
        int suitIconId = NotifyUtil.getNotifyLayoutAdapter(context).getSuitIconId();
        remoteViews.setViewVisibility(suitIconId, i10);
        if (list == null || list.isEmpty() || (bitmap = list.get(i10)) == null) {
            if (defaultNotifyIcon <= 0) {
                defaultNotifyIcon = i11;
            }
            remoteViews.setImageViewResource(suitIconId, defaultNotifyIcon);
        } else {
            remoteViews.setImageViewBitmap(suitIconId, bitmap);
        }
        Bitmap bitmap2 = (list == null || list.size() <= 1) ? null : list.get(1);
        if (bitmap2 == null) {
            remoteViews.setViewVisibility(resources.getIdentifier("notify_cover", "id", packageName), 8);
        } else if (TextUtils.isEmpty(insideNotificationItem.getPurePicUrl())) {
            remoteViews.setViewVisibility(resources.getIdentifier("notify_cover", "id", packageName), 0);
            remoteViews.setImageViewBitmap(resources.getIdentifier("notify_cover", "id", packageName), bitmap2);
        } else {
            remoteViews.setViewVisibility(resources.getIdentifier("notify_content", "id", packageName), 8);
            remoteViews.setViewVisibility(resources.getIdentifier("notify_cover", "id", packageName), 8);
            remoteViews.setViewVisibility(resources.getIdentifier("notify_pure_cover", "id", packageName), 0);
            remoteViews.setImageViewBitmap(resources.getIdentifier("notify_pure_cover", "id", packageName), bitmap2);
        }
        build.contentView = remoteViews;
        if (TextUtils.isEmpty(insideNotificationItem.getPurePicUrl())) {
            build.bigContentView = remoteViews;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        int ringerMode = audioManager.getRingerMode();
        int vibrateSetting = audioManager.getVibrateSetting(0);
        p.d(TAG, "ringMode=" + ringerMode + " callVibrateSetting=" + vibrateSetting);
        int notifyType = insideNotificationItem.getNotifyType();
        if (notifyType != 2) {
            if (notifyType != 3) {
                if (notifyType == 4) {
                    if (ringerMode == 2) {
                        build.defaults = 1;
                    }
                    if (vibrateSetting == 1) {
                        build.defaults |= 2;
                        build.vibrate = new long[]{0, 100, 200, 300};
                    }
                }
            } else if (vibrateSetting == 1) {
                build.defaults = 2;
                build.vibrate = new long[]{0, 100, 200, 300};
            }
        } else if (ringerMode == 2) {
            build.defaults = 1;
        }
        Intent intent = new Intent("com.vivo.pushservice.action.RECEIVE");
        intent.setPackage(context.getPackageName());
        intent.setClassName(context.getPackageName(), "com.vivo.push.sdk.service.CommandService");
        intent.putExtra("command_type", "reflect_receiver");
        try {
            intent.putExtra("security_avoid_pull", a.a(context).a("com.vivo.pushservice"));
            intent.putExtra("security_avoid_pull_rsa", com.vivo.push.c.d.a(context).a().a("com.vivo.pushservice"));
            intent.putExtra("security_avoid_rsa_public_key", u.a(com.vivo.push.c.d.a(context).a().a()));
        } catch (Exception e10) {
            p.a(TAG, "pushNotificationByCustom encrypt ：" + e10.getMessage());
        }
        new com.vivo.push.b.p(packageName, j10, insideNotificationItem).b(intent);
        build.contentIntent = PendingIntent.getService(context, (int) SystemClock.uptimeMillis(), intent, 268435456);
        if (sNotificationManager != null) {
            int k10 = com.vivo.push.e.a().k();
            try {
                if (k10 == 0) {
                    sNotificationManager.notify(sNotifyId, build);
                    if (aVar != null) {
                        aVar.a();
                        return;
                    }
                    return;
                }
                if (k10 != 1) {
                    p.a(TAG, "unknow notify style ".concat(String.valueOf(k10)));
                    return;
                }
                sNotificationManager.notify((int) j10, build);
                if (aVar != null) {
                    aVar.a();
                }
            } catch (Exception e11) {
                p.a(TAG, e11);
                if (aVar != null) {
                    aVar.b();
                }
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(23:0|1|(1:95)(2:5|(1:94)(1:10))|11|(3:13|(1:15)|(1:17))(3:87|(1:89)(2:91|(1:93))|90)|18|(1:20)|21|(1:23)|24|(1:26)(1:86)|27|(2:29|(2:31|(1:(1:77)(2:78|(1:80))))(2:81|(1:83)))(1:(10:85|(1:37)|38|(1:40)|(1:42)|43|44|45|46|(2:48|(2:50|(2:52|53)(1:55))(2:56|(2:58|(2:60|61)(1:62))(2:63|64)))(1:72)))|33|(2:35|37)|38|(0)|(0)|43|44|45|46|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01af, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01b0, code lost:
    
        com.vivo.push.util.p.a(com.vivo.push.util.NotifyAdapterUtil.TAG, "pushNotificationBySystem encrypt ：" + r0.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void pushNotificationBySystem(android.content.Context r20, java.util.List<android.graphics.Bitmap> r21, com.vivo.push.model.InsideNotificationItem r22, long r23, int r25, com.vivo.push.d.r.a r26) {
        /*
            Method dump skipped, instructions count: 606
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.NotifyAdapterUtil.pushNotificationBySystem(android.content.Context, java.util.List, com.vivo.push.model.InsideNotificationItem, long, int, com.vivo.push.d.r$a):void");
    }

    public static boolean repealNotifyById(Context context, long j10) {
        int k10 = com.vivo.push.e.a().k();
        if (k10 != 0) {
            if (k10 == 1) {
                return cancelNotify(context, (int) j10);
            }
            p.a(TAG, "unknow cancle notify style ".concat(String.valueOf(k10)));
            return false;
        }
        long b10 = w.b().b("com.vivo.push.notify_key", -1L);
        if (b10 == j10) {
            p.d(TAG, "undo showed message ".concat(String.valueOf(j10)));
            p.a(context, "回收已展示的通知： ".concat(String.valueOf(j10)));
            return cancelNotify(context, sNotifyId);
        }
        p.d(TAG, "current showing message id " + b10 + " not match " + j10);
        p.a(context, "与已展示的通知" + b10 + "与待回收的通知" + j10 + "不匹配");
        return false;
    }

    public static void setNotifyId(int i10) {
        sNotifyId = i10;
    }

    public static void cancelNotify(Context context) {
        cancelNotify(context, sNotifyId);
    }
}
