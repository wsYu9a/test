package com.kwad.sdk.core.download.a;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.download.DownloadTask;
import com.ksad.download.d;
import com.kwad.sdk.api.push.KsNotificationCompat;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.e;
import com.kwad.sdk.utils.ar;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class a implements d {
    private static c afn;
    private static HashMap<String, WeakReference<Bitmap>> afm = new HashMap<>();
    private static final Handler afo = new HandlerC0213a();

    /* renamed from: com.kwad.sdk.core.download.a.a$a */
    static class HandlerC0213a extends Handler {
        private final SparseArray<Long> afp;

        HandlerC0213a() {
            super(Looper.getMainLooper());
            this.afp = new SparseArray<>();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            boolean z = message.arg1 == 1;
            int i2 = message.arg2;
            boolean z2 = i2 == 1;
            boolean z3 = i2 == 2;
            Long l = this.afp.get(message.what);
            NotificationManager notificationManager = (NotificationManager) com.ksad.download.c.M().getContext().getSystemService("notification");
            if (notificationManager == null) {
                return;
            }
            if (com.ksad.download.c.M().s(message.what) == null && !z3) {
                removeMessages(message.what);
                notificationManager.cancel(message.what);
            } else {
                if (!z && l != null && System.currentTimeMillis() - l.longValue() < 110) {
                    sendMessageDelayed(Message.obtain(message), (l.longValue() + 110) - System.currentTimeMillis());
                    return;
                }
                if (z2) {
                    notificationManager.cancel(message.what);
                }
                a.a(message.what, (Notification) message.obj);
                this.afp.put(message.what, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    static class b {
        private static String afq = "ksad_notification_default_icon";
        private String Vp;
        private String afr;
        private String afs;
        private String afu;
        private String name;
        private int progress;
        private File aft = null;
        private boolean afv = false;

        private b() {
        }

        public static b a(DownloadTask downloadTask, String str, String str2) {
            b bVar = new b();
            Object tag = downloadTask.getTag();
            if (tag instanceof DownloadParams) {
                DownloadParams downloadParams = (DownloadParams) tag;
                File aX = ((com.kwad.sdk.service.kwai.c) ServiceProvider.get(com.kwad.sdk.service.kwai.c.class)).aX(downloadParams.mAppIcon);
                if (aX != null && aX.exists()) {
                    bVar.aft = aX;
                }
                bVar.name = downloadParams.mAppName;
            }
            bVar.afv = downloadTask.isPaused();
            bVar.Vp = str;
            bVar.afu = str2;
            bVar.afr = a.J(downloadTask.getSmallFileSoFarBytes()) + " / " + a.J(downloadTask.getSmallFileTotalBytes());
            bVar.afs = a.J((long) downloadTask.getSmallFileTotalBytes());
            bVar.progress = (int) ((((float) downloadTask.getSmallFileSoFarBytes()) * 100.0f) / ((float) downloadTask.getSmallFileTotalBytes()));
            return bVar;
        }

        public static b a(DownloadParams downloadParams, String str, String str2) {
            File aX;
            b bVar = new b();
            bVar.name = downloadParams.mAppName;
            if (!TextUtils.isEmpty(downloadParams.mAppIcon) && (aX = ((com.kwad.sdk.service.kwai.c) ServiceProvider.get(com.kwad.sdk.service.kwai.c.class)).aX(downloadParams.mAppIcon)) != null && aX.exists()) {
                bVar.aft = aX;
            }
            bVar.Vp = str;
            bVar.afs = a.J(downloadParams.mAppSize);
            bVar.afu = str2;
            return bVar;
        }

        public static String vz() {
            return afq;
        }

        public final String getName() {
            String str = this.name;
            return str == null ? "" : str;
        }

        public final int getProgress() {
            return this.progress;
        }

        public final boolean isPaused() {
            return this.afv;
        }

        public final String vA() {
            return this.afr;
        }

        public final String vB() {
            return this.afs;
        }

        public final String vC() {
            return this.Vp;
        }

        public final File vD() {
            return this.aft;
        }

        public final String vE() {
            return "正在下载 " + this.progress + "%";
        }

        public final String vF() {
            return this.afu;
        }
    }

    static class c extends BroadcastReceiver {
        private static void f(@NonNull Intent intent) {
            DownloadTask h2 = h(intent);
            if (h2 == null) {
                return;
            }
            com.ksad.download.c.M().u(h2.getId());
        }

        private static void g(@NonNull Intent intent) {
            DownloadTask h2 = h(intent);
            if (h2 == null) {
                return;
            }
            h2.setNotificationRemoved(true);
        }

        @Nullable
        private static DownloadTask h(Intent intent) {
            int i2 = intent.getExtras().getInt(DBDefinition.TASK_ID, 0);
            if (i2 == 0) {
                return null;
            }
            return com.ksad.download.c.M().s(i2);
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getExtras() == null) {
                return;
            }
            String action = intent.getAction();
            if ("com.ksad.action.ACTION_NOTIFICATION_CLICK_CONTROL_BTN".equals(action)) {
                f(intent);
            } else if ("com.ksad.action.ACTION_NOTIFICATION_REMOVED".equals(action)) {
                g(intent);
            }
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static String J(long j2) {
        return String.format("%.2fMB", Float.valueOf((j2 / 1000.0f) / 1000.0f));
    }

    public static void a(int i2, Notification notification) {
        vy();
        NotificationManager notificationManager = (NotificationManager) ServiceProvider.CA().getSystemService("notification");
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel("download_channel", "ksad", 3);
                notificationChannel.enableLights(false);
                notificationChannel.enableVibration(false);
                notificationChannel.setSound(null, null);
                notificationChannel.setShowBadge(false);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            notificationManager.notify(i2, notification);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }

    private static void a(Context context, RemoteViews remoteViews, boolean z, boolean z2, @Nullable PendingIntent pendingIntent, int i2, int i3, int i4) {
        KsNotificationCompat.Builder builder = new KsNotificationCompat.Builder(context, "download_channel");
        builder.setContent(remoteViews).setWhen(System.currentTimeMillis()).setOngoing(false).setAutoCancel(false).setOnlyAlertOnce(true).setPriority(-1).setContentIntent(pendingIntent).setSmallIcon(ar.ao(context, "ksad_notification_small_icon"));
        if (z2) {
            builder.setDeleteIntent(b(context, "com.ksad.action.ACTION_NOTIFICATION_REMOVED", i2));
        }
        Handler handler = afo;
        handler.removeMessages(i2);
        handler.obtainMessage(i2, i3, i4, builder.build()).sendToTarget();
    }

    private void a(Context context, com.kwad.sdk.core.download.a.b bVar, b bVar2) {
        bVar.setName(bVar2.getName());
        File vD = bVar2.vD();
        if (!((vD == null || !vD.exists()) ? false : a(bVar, vD))) {
            a(context, bVar, b.vz());
        }
        bVar.setStatus(bVar2.vC());
        bVar.setSize(bVar2.vB());
        bVar.setInstallText(bVar2.vF());
    }

    private void a(Context context, com.kwad.sdk.core.download.a.c cVar, b bVar) {
        cVar.setName(bVar.getName());
        File vD = bVar.vD();
        if (!((vD == null || !vD.exists()) ? false : a(cVar, vD))) {
            a(context, cVar, b.vz());
        }
        cVar.setStatus(bVar.vC());
        cVar.setSize(bVar.vA());
        cVar.setPercentNum(bVar.vE());
        cVar.setProgress(100, bVar.getProgress(), false);
        cVar.setControlBtnPaused(bVar.isPaused());
    }

    private boolean a(Context context, com.kwad.sdk.core.download.a.b bVar, String str) {
        try {
            bVar.setIcon(w(context, str));
            return true;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            com.kwad.sdk.service.b.gatherException(e2);
            return false;
        }
    }

    private boolean a(Context context, com.kwad.sdk.core.download.a.c cVar, String str) {
        try {
            cVar.setIcon(w(context, str));
            return true;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            com.kwad.sdk.service.b.gatherException(e2);
            return false;
        }
    }

    private boolean a(com.kwad.sdk.core.download.a.b bVar, File file) {
        try {
            bVar.setIcon(l(file));
            return true;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            com.kwad.sdk.service.b.gatherException(e2);
            return false;
        }
    }

    private boolean a(com.kwad.sdk.core.download.a.c cVar, File file) {
        try {
            cVar.setIcon(l(file));
            return true;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            com.kwad.sdk.service.b.gatherException(e2);
            return false;
        }
    }

    private static PendingIntent b(Context context, String str, int i2) {
        Intent intent = new Intent(str);
        intent.putExtra(DBDefinition.TASK_ID, i2);
        return PendingIntent.getBroadcast(context, i2, intent, 0);
    }

    private static Bitmap l(File file) {
        String absolutePath = file.getAbsolutePath();
        WeakReference<Bitmap> weakReference = afm.get(absolutePath);
        Bitmap bitmap = weakReference != null ? weakReference.get() : null;
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap decodeFile = BitmapFactory.decodeFile(absolutePath);
        afm.put(absolutePath, new WeakReference<>(decodeFile));
        return decodeFile;
    }

    private static DownloadParams n(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return null;
        }
        Object tag = downloadTask.getTag();
        DownloadParams downloadParams = tag instanceof DownloadParams ? (DownloadParams) tag : new DownloadParams();
        downloadParams.mAppSize = downloadTask.getSmallFileTotalBytes();
        downloadParams.mTaskId = downloadTask.getId();
        downloadParams.filePath = downloadTask.getTargetFilePath();
        return downloadParams;
    }

    private static void vy() {
        if (afn != null) {
            return;
        }
        afn = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.ksad.action.ACTION_NOTIFICATION_CLICK_CONTROL_BTN");
        intentFilter.addAction("com.ksad.action.ACTION_NOTIFICATION_REMOVED");
        ServiceProvider.CA().registerReceiver(afn, intentFilter);
    }

    private static Bitmap w(Context context, String str) {
        WeakReference<Bitmap> weakReference = afm.get(str);
        Bitmap bitmap = weakReference != null ? weakReference.get() : null;
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap decodeResource = BitmapFactory.decodeResource(ar.ck(context), ar.ao(context, str));
        afm.put(str, new WeakReference<>(decodeResource));
        return decodeResource;
    }

    @Override // com.ksad.download.d
    public final void a(DownloadTask downloadTask, boolean z) {
        com.kwad.sdk.core.download.a.c a2;
        Context context = ((e) ServiceProvider.get(e.class)).getContext();
        if (context == null || downloadTask.isNotificationRemoved() || (a2 = com.kwad.sdk.core.download.a.c.a(context, downloadTask.getId(), downloadTask.downloadEnablePause)) == null) {
            return;
        }
        a(context, a2, b.a(downloadTask, "正在下载", (String) null));
        a(context, a2.build(), false, true, null, downloadTask.getId(), z ? 1 : 0, downloadTask.isCompleted() ? 1 : 0);
    }

    @Override // com.ksad.download.d
    public final void b(File file) {
        Context context = ((e) ServiceProvider.get(e.class)).getContext();
        DownloadParams bu = com.kwad.sdk.core.a.tS().bu(file.getAbsolutePath());
        com.kwad.sdk.core.a.tS().bv(file.getAbsolutePath());
        if (context == null || bu == null) {
            return;
        }
        AdTemplate bw = com.kwad.sdk.core.a.tS().bw(bu.mDownloadid);
        if (bw != null) {
            bw.installFrom = "recall";
            com.kwad.sdk.core.download.c.vu().al(bw);
        }
        b a2 = b.a(bu, "下载完成", "立即安装");
        com.kwad.sdk.core.download.a.b aN = com.kwad.sdk.core.download.a.b.aN(context);
        if (aN == null) {
            return;
        }
        a(context, aN, a2);
        a(context, aN.build(), false, false, com.ksad.download.e.a(file, bu.mTaskId, bu.requestInstallPermission), bu.mTaskId, 1, 2);
    }

    @Override // com.ksad.download.d
    public final void i(DownloadTask downloadTask) {
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            String str = ((DownloadParams) tag).mAppIcon;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File aX = ((com.kwad.sdk.service.kwai.c) ServiceProvider.get(com.kwad.sdk.service.kwai.c.class)).aX(str);
            if (aX == null || !aX.exists()) {
                ((com.kwad.sdk.service.kwai.c) ServiceProvider.get(com.kwad.sdk.service.kwai.c.class)).a(true, str, "", "");
            }
        }
    }

    @Override // com.ksad.download.d
    public final void j(DownloadTask downloadTask) {
        Context context = ((e) ServiceProvider.get(e.class)).getContext();
        if (context == null || downloadTask.isNotificationRemoved()) {
            return;
        }
        b a2 = b.a(downloadTask, downloadTask.getSmallFileSoFarBytes() > 0 && downloadTask.getSmallFileTotalBytes() > 0 ? "正在下载" : "准备下载", (String) null);
        com.kwad.sdk.core.download.a.c a3 = com.kwad.sdk.core.download.a.c.a(context, downloadTask.getId(), downloadTask.downloadEnablePause);
        if (a3 == null) {
            return;
        }
        a(context, a3, a2);
        a(context, a3.build(), false, true, null, downloadTask.getId(), 1, downloadTask.isCompleted() ? 1 : 0);
    }

    @Override // com.ksad.download.d
    public final void k(DownloadTask downloadTask) {
        Context context = ((e) ServiceProvider.get(e.class)).getContext();
        if (context == null) {
            return;
        }
        DownloadParams n = n(downloadTask);
        com.kwad.sdk.core.download.a.b aN = com.kwad.sdk.core.download.a.b.aN(context);
        if (aN == null) {
            return;
        }
        a(context, aN, b.a(downloadTask, "下载完成", "立即安装"));
        com.kwad.sdk.core.a.tS().a(downloadTask.getTargetFilePath(), n);
        com.kwad.sdk.core.a.tS().a(n.mPkgname, n);
        a(context, aN.build(), false, false, com.ksad.download.e.l(downloadTask), downloadTask.getId(), 1, 1);
    }

    @Override // com.ksad.download.d
    public final void n(String str) {
        Context context = ((e) ServiceProvider.get(e.class)).getContext();
        DownloadParams bu = com.kwad.sdk.core.a.tS().bu(str);
        com.kwad.sdk.core.a.tS().bv(str);
        if (context == null || bu == null) {
            return;
        }
        com.kwad.sdk.core.a.tS().bv(bu.filePath);
        b a2 = b.a(bu, "安装完成", "立刻打开");
        com.kwad.sdk.core.download.a.b aN = com.kwad.sdk.core.download.a.b.aN(context);
        if (aN == null) {
            return;
        }
        a(context, aN, a2);
        a(context, aN.build(), false, false, com.ksad.download.e.e(bu.mPkgname, bu.mTaskId), bu.mTaskId, 1, 2);
    }

    @Override // com.ksad.download.d
    public final void v(int i2) {
        Context context = ((e) ServiceProvider.get(e.class)).getContext();
        if (context == null) {
            return;
        }
        ((NotificationManager) context.getSystemService("notification")).cancel(i2);
    }
}
