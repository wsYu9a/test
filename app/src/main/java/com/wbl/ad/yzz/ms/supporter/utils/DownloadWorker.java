package com.wbl.ad.yzz.ms.supporter.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.OkHttpClient;

/* loaded from: classes5.dex */
public class DownloadWorker {

    /* renamed from: j */
    public static final DownloadWorker f33295j = new DownloadWorker();
    public static final AtomicInteger k = new AtomicInteger(10);

    /* renamed from: d */
    public Handler f33299d;

    /* renamed from: g */
    public DownloadInfo f33302g;

    /* renamed from: h */
    public NotificationManager f33303h;

    /* renamed from: a */
    public final Queue<DownloadInfo> f33296a = new LinkedBlockingQueue();

    /* renamed from: b */
    public final Map<String, DownloadInfo> f33297b = new ConcurrentHashMap();

    /* renamed from: c */
    public HandlerThread f33298c = new HandlerThread("Download.DownloadWorker");

    /* renamed from: e */
    public OkHttpClient f33300e = new OkHttpClient.Builder().build();

    /* renamed from: f */
    public Context f33301f = com.wbl.ad.yzz.ms.f.b.getContext();

    /* renamed from: i */
    public String f33304i = null;

    public static class InstallReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11475, this, context, intent);
        }
    }

    public static class InstallSuccessReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11566, this, context, intent);
        }
    }

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11565, this, message);
        }
    }

    public static class b implements FileFilter {

        /* renamed from: a */
        public final /* synthetic */ long f33306a;

        public b(long j2) {
            this.f33306a = j2;
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-11568, this, file);
        }
    }

    public class c extends Thread {

        /* renamed from: a */
        public final /* synthetic */ String f33307a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, String str2) {
            super(str);
            this.f33307a = str2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11567, this, null);
        }
    }

    public DownloadWorker() {
        this.f33303h = null;
        this.f33298c.start();
        a aVar = new a(this.f33298c.getLooper());
        this.f33299d = aVar;
        aVar.sendEmptyMessage(100);
        this.f33303h = (NotificationManager) this.f33301f.getSystemService("notification");
    }

    public static /* synthetic */ Intent a(Context context, File file) {
        return (Intent) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11562, null, context, file);
    }

    public static /* synthetic */ DownloadInfo a(DownloadWorker downloadWorker, DownloadInfo downloadInfo) {
        return (DownloadInfo) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11561, null, downloadWorker, downloadInfo);
    }

    public static File a() {
        return (File) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11564, null, null);
    }

    public static String a(Context context, String str) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11563, null, context, str);
    }

    public static /* synthetic */ Queue a(DownloadWorker downloadWorker) {
        return (Queue) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11558, null, downloadWorker);
    }

    public static void a(DownloadInfo downloadInfo) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11557, null, downloadInfo);
    }

    public static void a(Closeable closeable) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11559, null, closeable);
    }

    public static synchronized boolean a(Context context) {
        boolean z;
        synchronized (DownloadWorker.class) {
            z = Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-11554, null, context);
        }
        return z;
    }

    public static /* synthetic */ Context b(DownloadWorker downloadWorker) {
        return (Context) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11553, null, downloadWorker);
    }

    public static Intent b(Context context, File file) {
        return (Intent) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11556, null, context, file);
    }

    public static DownloadWorker b() {
        return (DownloadWorker) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11555, null, null);
    }

    public static /* synthetic */ Map c(DownloadWorker downloadWorker) {
        return (Map) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11582, null, downloadWorker);
    }

    public static void c(Context context, File file) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11581, null, context, file);
    }

    public static void h() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11583, null, null);
    }

    public Notification a(String str, String str2, int i2, int i3) {
        return (Notification) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11578, this, str, str2, Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public Notification a(String str, String str2, int i2, int i3, int i4, PendingIntent pendingIntent, boolean z) {
        return (Notification) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11577, this, str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), pendingIntent, Boolean.valueOf(z));
    }

    public Notification a(String str, String str2, int i2, PendingIntent pendingIntent, boolean z) {
        return (Notification) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11580, this, str, str2, Integer.valueOf(i2), pendingIntent, Boolean.valueOf(z));
    }

    public DownloadInfo a(String str) {
        return (DownloadInfo) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11579, this, str);
    }

    public void a(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11574, this, Integer.valueOf(i2));
    }

    public void a(com.wbl.ad.yzz.ms.e.d.a aVar, DownloadInfo downloadInfo) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11573, this, aVar, downloadInfo);
    }

    public final void a(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11576, this, Boolean.valueOf(z));
    }

    public List<DownloadInfo> b(String str) {
        return (List) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11575, this, str);
    }

    public void b(com.wbl.ad.yzz.ms.e.d.a aVar, DownloadInfo downloadInfo) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11570, this, aVar, downloadInfo);
    }

    public final void b(DownloadInfo downloadInfo) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11569, this, downloadInfo);
    }

    public final long c(String str) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.j(-11572, this, str);
    }

    public final void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11571, this, null);
    }

    public final void d() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11534, this, null);
    }

    public final void d(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11533, this, str);
    }

    public final void e() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11536, this, null);
    }

    public final void f() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11535, this, null);
    }

    public final DownloadInfo g() {
        return (DownloadInfo) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11530, this, null);
    }
}
