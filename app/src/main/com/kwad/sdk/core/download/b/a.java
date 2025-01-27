package com.kwad.sdk.core.download.b;

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
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.api.push.KsNotificationCompat;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.d;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.r;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import q.a0;
import q.z;

/* loaded from: classes3.dex */
public final class a implements d {
    private static c ayy;
    private boolean ayA = false;
    private boolean ayB = false;
    private int ayC = 0;
    private static HashMap<String, WeakReference<Bitmap>> ayx = new HashMap<>();
    private static final Handler ayz = new HandlerC0492a();

    /* renamed from: com.kwad.sdk.core.download.b.a$a */
    public static class HandlerC0492a extends Handler {
        private final SparseArray<Long> ayD;

        public HandlerC0492a() {
            super(Looper.getMainLooper());
            this.ayD = new SparseArray<>();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            boolean z10 = message.arg1 == 1;
            int i10 = message.arg2;
            boolean z11 = i10 == 1;
            boolean z12 = i10 == 2;
            Long l10 = this.ayD.get(message.what);
            NotificationManager notificationManager = (NotificationManager) com.kwad.sdk.c.yU().getContext().getSystemService("notification");
            if (notificationManager == null) {
                return;
            }
            if (com.kwad.sdk.c.yU().bT(message.what) == null && !z12) {
                removeMessages(message.what);
                notificationManager.cancel(message.what);
            } else {
                if (!z10 && l10 != null && System.currentTimeMillis() - l10.longValue() < 110) {
                    sendMessageDelayed(Message.obtain(message), (l10.longValue() + 110) - System.currentTimeMillis());
                    return;
                }
                if (z11) {
                    notificationManager.cancel(message.what);
                }
                a.a(message.what, (Notification) message.obj);
                this.ayD.put(message.what, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    public static class b {
        private static String ayE = "ksad_notification_default_icon";
        private String adB;
        private String ayF;
        private String ayG;
        private String ayI;
        private String name;
        private int progress;
        private File ayH = null;
        private boolean ayJ = false;

        private b() {
        }

        public static String EO() {
            return ayE;
        }

        public static b a(DownloadTask downloadTask, String str, String str2, boolean z10, int i10) {
            b bVar = new b();
            Object tag = downloadTask.getTag();
            if (tag instanceof DownloadParams) {
                DownloadParams downloadParams = (DownloadParams) tag;
                File ca2 = ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).ca(downloadParams.mAppIcon);
                if (ca2 != null && ca2.exists()) {
                    bVar.ayH = ca2;
                }
                bVar.name = downloadParams.mAppName;
            }
            bVar.ayJ = downloadTask.isPaused();
            bVar.adB = str;
            bVar.ayI = str2;
            bVar.ayG = a.ar(downloadTask.getSmallFileTotalBytes());
            int a10 = r.a(downloadTask.getSmallFileSoFarBytes(), downloadTask.getSmallFileTotalBytes(), z10, i10);
            bVar.progress = a10;
            bVar.ayF = a.ar((long) (downloadTask.getSmallFileTotalBytes() * ((a10 * 1.0d) / 100.0d))) + " / " + a.ar(downloadTask.getSmallFileTotalBytes());
            return bVar;
        }

        public final String EP() {
            return this.ayF;
        }

        public final String EQ() {
            return this.ayG;
        }

        public final String ER() {
            return this.adB;
        }

        public final File ES() {
            return this.ayH;
        }

        public final String ET() {
            return "正在下载 " + this.progress + "%";
        }

        public final String EU() {
            return this.ayI;
        }

        public final String getName() {
            String str = this.name;
            return str == null ? "" : str;
        }

        public final int getProgress() {
            return this.progress;
        }

        public final boolean isPaused() {
            return this.ayJ;
        }

        public static b a(DownloadParams downloadParams, String str, String str2) {
            File ca2;
            b bVar = new b();
            bVar.name = downloadParams.mAppName;
            if (!TextUtils.isEmpty(downloadParams.mAppIcon) && (ca2 = ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).ca(downloadParams.mAppIcon)) != null && ca2.exists()) {
                bVar.ayH = ca2;
            }
            bVar.adB = str;
            bVar.ayG = a.ar(downloadParams.mAppSize);
            bVar.ayI = str2;
            return bVar;
        }
    }

    public static class c extends BroadcastReceiver {
        private static void e(@NonNull Intent intent) {
            DownloadTask g10 = g(intent);
            if (g10 == null) {
                return;
            }
            com.kwad.sdk.c.yU().bV(g10.getId());
        }

        private static void f(@NonNull Intent intent) {
            DownloadTask g10 = g(intent);
            if (g10 == null) {
                return;
            }
            g10.setNotificationRemoved(true);
        }

        @Nullable
        private static DownloadTask g(Intent intent) {
            int i10 = intent.getExtras().getInt(DBDefinition.TASK_ID, 0);
            if (i10 == 0) {
                return null;
            }
            return com.kwad.sdk.c.yU().bT(i10);
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getExtras() == null) {
                return;
            }
            String action = intent.getAction();
            if ("com.ksad.action.ACTION_NOTIFICATION_CLICK_CONTROL_BTN".equals(action)) {
                e(intent);
            } else if ("com.ksad.action.ACTION_NOTIFICATION_REMOVED".equals(action)) {
                f(intent);
            }
        }
    }

    private static void EN() {
        if (ayy != null) {
            return;
        }
        ayy = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.ksad.action.ACTION_NOTIFICATION_CLICK_CONTROL_BTN");
        intentFilter.addAction("com.ksad.action.ACTION_NOTIFICATION_REMOVED");
        if (Build.VERSION.SDK_INT >= 33) {
            ServiceProvider.MA().registerReceiver(ayy, intentFilter, 2);
        } else {
            ServiceProvider.MA().registerReceiver(ayy, intentFilter);
        }
    }

    private static Bitmap F(Context context, String str) {
        WeakReference<Bitmap> weakReference = ayx.get(str);
        Bitmap bitmap = weakReference != null ? weakReference.get() : null;
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap decodeResource = BitmapFactory.decodeResource(ax.cM(context), ax.au(context, str));
        ayx.put(str, new WeakReference<>(decodeResource));
        return decodeResource;
    }

    public static void a(int i10, Notification notification) {
        EN();
        NotificationManager notificationManager = (NotificationManager) ServiceProvider.MA().getSystemService("notification");
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                a0.a();
                NotificationChannel a10 = z.a("download_channel", "ksad", 3);
                a10.enableLights(false);
                a10.enableVibration(false);
                a10.setSound(null, null);
                a10.setShowBadge(false);
                notificationManager.createNotificationChannel(a10);
            }
            notificationManager.notify(i10, notification);
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static String ar(long j10) {
        return String.format("%.2fMB", Float.valueOf((j10 / 1000.0f) / 1000.0f));
    }

    private static DownloadParams m(DownloadTask downloadTask) {
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

    private static Bitmap q(File file) {
        String absolutePath = file.getAbsolutePath();
        WeakReference<Bitmap> weakReference = ayx.get(absolutePath);
        Bitmap bitmap = weakReference != null ? weakReference.get() : null;
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap decodeFile = BitmapFactory.decodeFile(absolutePath);
        ayx.put(absolutePath, new WeakReference<>(decodeFile));
        return decodeFile;
    }

    @Override // com.kwad.sdk.d
    public final void bW(int i10) {
        Context MA = ServiceProvider.MA();
        if (MA == null) {
            return;
        }
        ((NotificationManager) MA.getSystemService("notification")).cancel(i10);
    }

    @Override // com.kwad.sdk.d
    public final void bY(String str) {
        Context MA = ServiceProvider.MA();
        DownloadParams de2 = com.kwad.sdk.core.a.CA().de(str);
        com.kwad.sdk.core.a.CA().df(str);
        if (MA == null || de2 == null) {
            return;
        }
        com.kwad.sdk.core.a.CA().df(de2.filePath);
        b a10 = b.a(de2, "安装完成", "立刻打开");
        com.kwad.sdk.core.download.b.b bp = com.kwad.sdk.core.download.b.b.bp(MA);
        if (bp == null) {
            return;
        }
        a(MA, bp, a10);
        a(MA, bp.build(), false, false, aq.e(MA, de2.mPkgname, de2.mTaskId), de2.mTaskId, 1, 2);
    }

    @Override // com.kwad.sdk.d
    public final void g(File file) {
        Context MA = ServiceProvider.MA();
        if (MA == null) {
            return;
        }
        DownloadParams de2 = com.kwad.sdk.core.a.CA().de(file.getAbsolutePath());
        com.kwad.sdk.core.a.CA().df(file.getAbsolutePath());
        if (de2 == null) {
            return;
        }
        AdTemplate dg2 = com.kwad.sdk.core.a.CA().dg(de2.mDownloadid);
        if (dg2 != null) {
            dg2.installFrom = "recall";
        }
        b a10 = b.a(de2, "下载完成", "立即安装");
        com.kwad.sdk.core.download.b.b bp = com.kwad.sdk.core.download.b.b.bp(MA);
        if (bp == null) {
            return;
        }
        a(MA, bp, a10);
        a(MA, bp.build(), false, false, aq.a(MA, file, de2.mTaskId, de2.requestInstallPermission), de2.mTaskId, 1, 2);
    }

    @Override // com.kwad.sdk.d
    public final void i(DownloadTask downloadTask) {
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            String str = ((DownloadParams) tag).mAppIcon;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File ca2 = ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).ca(str);
            if (ca2 == null || !ca2.exists()) {
                ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).a(true, str, "", "");
            }
        }
    }

    @Override // com.kwad.sdk.d
    public final void j(DownloadTask downloadTask) {
        Context MA = ServiceProvider.MA();
        if (MA == null || downloadTask.isNotificationRemoved()) {
            return;
        }
        String str = (downloadTask.getSmallFileSoFarBytes() <= 0 || downloadTask.getSmallFileTotalBytes() <= 0) ? "准备下载" : "正在下载";
        if (!this.ayA) {
            this.ayA = true;
            this.ayB = ((h) ServiceProvider.get(h.class)).An();
            this.ayC = ((h) ServiceProvider.get(h.class)).Ao();
        }
        com.kwad.sdk.core.d.c.d("AdDownloadNotificationPerformer", "DownloadProgressTransformUtil in notifyDownloadError");
        b a10 = b.a(downloadTask, str, null, this.ayB, this.ayC);
        com.kwad.sdk.core.download.b.c a11 = com.kwad.sdk.core.download.b.c.a(MA, downloadTask.getId(), downloadTask.downloadEnablePause);
        if (a11 == null) {
            return;
        }
        a(MA, a11, a10);
        a(MA, a11.build(), false, true, null, downloadTask.getId(), 1, downloadTask.isCompleted() ? 1 : 0);
    }

    @Override // com.kwad.sdk.d
    public final void k(DownloadTask downloadTask) {
        DownloadParams m10;
        com.kwad.sdk.core.download.b.b bp;
        Context MA = ServiceProvider.MA();
        if (MA == null || (m10 = m(downloadTask)) == null || (bp = com.kwad.sdk.core.download.b.b.bp(MA)) == null) {
            return;
        }
        if (!this.ayA) {
            this.ayA = true;
            this.ayB = ((h) ServiceProvider.get(h.class)).An();
            this.ayC = ((h) ServiceProvider.get(h.class)).Ao();
        }
        com.kwad.sdk.core.d.c.d("AdDownloadNotificationPerformer", "DownloadProgressTransformUtil in notifyDownloadCompleted");
        a(MA, bp, b.a(downloadTask, "下载完成", "立即安装", this.ayB, this.ayC));
        com.kwad.sdk.core.a.CA().a(downloadTask.getTargetFilePath(), m10);
        com.kwad.sdk.core.a.CA().a(m10.mPkgname, m10);
        a(MA, bp.build(), false, false, aq.a(MA, new File(downloadTask.getTargetFilePath()), m10.mTaskId, m10.requestInstallPermission), downloadTask.getId(), 1, 1);
    }

    @Override // com.kwad.sdk.d
    public final void a(DownloadTask downloadTask, boolean z10) {
        com.kwad.sdk.core.download.b.c a10;
        Context MA = ServiceProvider.MA();
        if (MA == null || downloadTask.isNotificationRemoved() || (a10 = com.kwad.sdk.core.download.b.c.a(MA, downloadTask.getId(), downloadTask.downloadEnablePause)) == null) {
            return;
        }
        if (!this.ayA) {
            this.ayA = true;
            this.ayB = ((h) ServiceProvider.get(h.class)).An();
            this.ayC = ((h) ServiceProvider.get(h.class)).Ao();
        }
        com.kwad.sdk.core.d.c.d("AdDownloadNotificationPerformer", "DownloadProgressTransformUtil in notifyDownloadProgress");
        a(MA, a10, b.a(downloadTask, "正在下载", null, this.ayB, this.ayC));
        a(MA, a10.build(), false, true, null, downloadTask.getId(), z10 ? 1 : 0, downloadTask.isCompleted() ? 1 : 0);
    }

    private boolean a(com.kwad.sdk.core.download.b.c cVar, File file) {
        try {
            cVar.setIcon(q(file));
            return true;
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
            com.kwad.sdk.service.c.gatherException(e10);
            return false;
        }
    }

    private boolean a(Context context, com.kwad.sdk.core.download.b.c cVar, String str) {
        try {
            cVar.setIcon(F(context, str));
            return true;
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
            com.kwad.sdk.service.c.gatherException(e10);
            return false;
        }
    }

    private boolean a(com.kwad.sdk.core.download.b.b bVar, File file) {
        try {
            bVar.setIcon(q(file));
            return true;
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
            com.kwad.sdk.service.c.gatherException(e10);
            return false;
        }
    }

    private boolean a(Context context, com.kwad.sdk.core.download.b.b bVar, String str) {
        try {
            bVar.setIcon(F(context, str));
            return true;
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
            com.kwad.sdk.service.c.gatherException(e10);
            return false;
        }
    }

    private void a(Context context, RemoteViews remoteViews, boolean z10, boolean z11, @Nullable PendingIntent pendingIntent, int i10, int i11, int i12) {
        KsNotificationCompat.Builder builder = new KsNotificationCompat.Builder(context, "download_channel");
        builder.setWhen(System.currentTimeMillis()).setOngoing(false).setAutoCancel(false).setOnlyAlertOnce(true).setPriority(-1).setContentIntent(pendingIntent).setSmallIcon(ax.getAppIconId(context));
        a(builder, remoteViews);
        if (z11) {
            Intent intent = new Intent("com.ksad.action.ACTION_NOTIFICATION_REMOVED");
            intent.putExtra(DBDefinition.TASK_ID, i10);
            builder.setDeleteIntent(aq.a(context, i10, intent));
        }
        Handler handler = ayz;
        handler.removeMessages(i10);
        handler.obtainMessage(i10, i11, i12, builder.build()).sendToTarget();
    }

    private static void a(KsNotificationCompat.Builder builder, RemoteViews remoteViews) {
        try {
            builder.setDecoratedCustomStyle().setCustomBigContentView(remoteViews).setCustomContentView(remoteViews);
        } catch (Throwable unused) {
            builder.setContent(remoteViews);
        }
    }

    private void a(Context context, com.kwad.sdk.core.download.b.c cVar, b bVar) {
        cVar.setName(bVar.getName());
        File ES = bVar.ES();
        if (!((ES == null || !ES.exists()) ? false : a(cVar, ES))) {
            a(context, cVar, b.EO());
        }
        cVar.setStatus(bVar.ER());
        cVar.setSize(bVar.EP());
        cVar.setPercentNum(bVar.ET());
        cVar.setProgress(100, bVar.getProgress(), false);
        cVar.setControlBtnPaused(bVar.isPaused());
    }

    private void a(Context context, com.kwad.sdk.core.download.b.b bVar, b bVar2) {
        bVar.setName(bVar2.getName());
        File ES = bVar2.ES();
        if (!((ES == null || !ES.exists()) ? false : a(bVar, ES))) {
            a(context, bVar, b.EO());
        }
        bVar.setStatus(bVar2.ER());
        bVar.setSize(bVar2.EQ());
        bVar.setInstallText(bVar2.EU());
    }
}
