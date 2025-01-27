package com.umeng.commonsdk.framework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.kuaishou.weapon.p0.g;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.b;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.c;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.vivo.ic.dm.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes4.dex */
public class a implements UMImprintChangeCallback {

    /* renamed from: a */
    private static HandlerThread f26167a = null;

    /* renamed from: b */
    private static Handler f26168b = null;

    /* renamed from: c */
    private static Handler f26169c = null;

    /* renamed from: d */
    private static final int f26170d = 200;

    /* renamed from: e */
    private static final int f26171e = 273;

    /* renamed from: f */
    private static final int f26172f = 274;

    /* renamed from: g */
    private static final int f26173g = 512;

    /* renamed from: h */
    private static final int f26174h = 769;

    /* renamed from: i */
    private static FileObserverC0542a f26175i = null;

    /* renamed from: j */
    private static ConnectivityManager f26176j = null;
    private static IntentFilter k = null;
    private static volatile boolean l = false;
    private static ArrayList<UMSenderStateNotify> m = null;
    private static final String p = "report_policy";
    private static final String q = "report_interval";
    private static final int s = 15;
    private static final int t = 3;
    private static final int u = 90;
    private static BroadcastReceiver x;
    private static Object n = new Object();
    private static ReentrantLock o = new ReentrantLock();
    private static boolean r = false;
    private static int v = 15;
    private static Object w = new Object();

    /* renamed from: com.umeng.commonsdk.framework.a$1 */
    static class AnonymousClass1 extends BroadcastReceiver {
        AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.E, b.a(context).a(), null);
            }
        }
    }

    /* renamed from: com.umeng.commonsdk.framework.a$2 */
    class AnonymousClass2 extends Handler {
        AnonymousClass2(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 273) {
                ULog.d("--->>> handleMessage: recv MSG_PROCESS_NEXT msg.");
                try {
                    a.o.tryLock(1L, TimeUnit.SECONDS);
                    try {
                        a.n();
                    } catch (Throwable unused) {
                    }
                    a.o.unlock();
                    return;
                } catch (Throwable unused2) {
                    return;
                }
            }
            if (i2 == a.f26172f) {
                a.l();
            } else {
                if (i2 != 512) {
                    return;
                }
                a.m();
            }
        }
    }

    /* renamed from: com.umeng.commonsdk.framework.a$a */
    static class FileObserverC0542a extends FileObserver {
        public FileObserverC0542a(String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i2, String str) {
            if ((i2 & 8) != 8) {
                return;
            }
            ULog.d("--->>> envelope file created >>> " + str);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
            a.c(273);
        }
    }

    static {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            f26176j = (ConnectivityManager) appContext.getSystemService("connectivity");
        }
        x = new BroadcastReceiver() { // from class: com.umeng.commonsdk.framework.a.1
            AnonymousClass1() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.E, b.a(context).a(), null);
                }
            }
        };
    }

    public a(Context context, Handler handler) {
        if (f26176j == null) {
            Context appContext = UMGlobalContext.getAppContext();
            if (f26176j != null) {
                f26176j = (ConnectivityManager) appContext.getSystemService("connectivity");
            }
        }
        f26169c = handler;
        try {
            if (f26167a == null) {
                HandlerThread handlerThread = new HandlerThread("NetWorkSender");
                f26167a = handlerThread;
                handlerThread.start();
                if (f26175i == null) {
                    FileObserverC0542a fileObserverC0542a = new FileObserverC0542a(UMFrUtils.getEnvelopeDirPath(context));
                    f26175i = fileObserverC0542a;
                    fileObserverC0542a.startWatching();
                    ULog.d("--->>> FileMonitor has already started!");
                }
                j();
                if (f26168b == null) {
                    f26168b = new Handler(f26167a.getLooper()) { // from class: com.umeng.commonsdk.framework.a.2
                        AnonymousClass2(Looper looper) {
                            super(looper);
                        }

                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            int i2 = message.what;
                            if (i2 == 273) {
                                ULog.d("--->>> handleMessage: recv MSG_PROCESS_NEXT msg.");
                                try {
                                    a.o.tryLock(1L, TimeUnit.SECONDS);
                                    try {
                                        a.n();
                                    } catch (Throwable unused) {
                                    }
                                    a.o.unlock();
                                    return;
                                } catch (Throwable unused2) {
                                    return;
                                }
                            }
                            if (i2 == a.f26172f) {
                                a.l();
                            } else {
                                if (i2 != 512) {
                                    return;
                                }
                                a.m();
                            }
                        }
                    };
                }
                ImprintHandler.getImprintService(context).registImprintCallback(p, this);
                ImprintHandler.getImprintService(context).registImprintCallback(q, this);
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static int b() {
        int i2;
        synchronized (w) {
            i2 = v;
        }
        return i2;
    }

    public static void c() {
    }

    public static void c(int i2) {
        Handler handler;
        if (!l || (handler = f26168b) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i2;
        f26168b.sendMessage(obtainMessage);
    }

    public static void d() {
        if (o.tryLock()) {
            try {
                b(273);
            } finally {
                o.unlock();
            }
        }
    }

    public static void e() {
        a(f26172f, 3000);
    }

    private void j() {
        synchronized (w) {
            if ("11".equals(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), p, ""))) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> switch to report_policy 11");
                r = true;
                v = 15;
                int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), q, "15")).intValue();
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> set report_interval value to: " + intValue);
                if (intValue >= 3 && intValue <= 90) {
                    v = intValue * 1000;
                }
                v = 15;
            } else {
                r = false;
            }
        }
    }

    private static void k() {
        if (f26167a != null) {
            f26167a = null;
        }
        if (f26168b != null) {
            f26168b = null;
        }
        if (f26169c != null) {
            f26169c = null;
        }
    }

    public static void l() {
        int size;
        synchronized (n) {
            ArrayList<UMSenderStateNotify> arrayList = m;
            if (arrayList != null && (size = arrayList.size()) > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    m.get(i2).onSenderIdle();
                }
            }
        }
    }

    public static void m() {
    }

    public static void n() {
        ULog.d("--->>> handleProcessNext: Enter...");
        if (l) {
            Context appContext = UMModuleRegister.getAppContext();
            try {
                if (UMFrUtils.envelopeFileNumber(appContext) > 0) {
                    ULog.d("--->>> The envelope file exists.");
                    if (UMFrUtils.envelopeFileNumber(appContext) > 200) {
                        ULog.d("--->>> Number of envelope files is greater than 200, remove old files first.");
                        UMFrUtils.removeRedundantEnvelopeFiles(appContext, 200);
                    }
                    File envelopeFile = UMFrUtils.getEnvelopeFile(appContext);
                    if (envelopeFile != null) {
                        String path = envelopeFile.getPath();
                        ULog.d("--->>> Ready to send envelope file [" + path + "].");
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send envelope file [ " + path + "].");
                        if (!new c(appContext).a(envelopeFile)) {
                            ULog.d("--->>> Send envelope file failed, abandon and wait next trigger!");
                            return;
                        }
                        ULog.d("--->>> Send envelope file success, delete it.");
                        if (!UMFrUtils.removeEnvelopeFile(envelopeFile)) {
                            ULog.d("--->>> Failed to delete already processed file. We try again after delete failed.");
                            UMFrUtils.removeEnvelopeFile(envelopeFile);
                        }
                        c(273);
                        return;
                    }
                }
                e();
            } catch (Throwable th) {
                UMCrashManager.reportCrash(appContext, th);
            }
        }
    }

    @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
    public void onImprintValueChanged(String str, String str2) {
        synchronized (w) {
            if (p.equals(str)) {
                if ("11".equals(str2)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> switch to report_policy 11");
                    r = true;
                } else {
                    r = false;
                }
            }
            if (q.equals(str)) {
                int intValue = Integer.valueOf(str2).intValue();
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> set report_interval value to: " + intValue);
                if (intValue >= 3 && intValue <= 90) {
                    v = intValue * 1000;
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> really set report_interval value to: " + v);
                }
                v = Constants.DEFAULT_READ_TIMEOUT;
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> really set report_interval value to: " + v);
            }
        }
    }

    public static void a(Context context) {
        if (f26176j != null || context == null) {
            return;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        f26176j = connectivityManager;
        if (connectivityManager != null) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> createCMIfNeeded:注册网络状态监听器。");
            b(context);
        }
    }

    public static void b(Context context) {
        if (DeviceConfig.checkPermission(context, g.f9317b) && f26176j != null && k == null) {
            IntentFilter intentFilter = new IntentFilter();
            k = intentFilter;
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            if (x != null) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 注册网络状态监听器。");
                context.registerReceiver(x, k);
            }
        }
    }

    public static void a(UMSenderStateNotify uMSenderStateNotify) {
        synchronized (n) {
            try {
                if (m == null) {
                    m = new ArrayList<>();
                }
                if (uMSenderStateNotify != null) {
                    for (int i2 = 0; i2 < m.size(); i2++) {
                        if (uMSenderStateNotify == m.get(i2)) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> addConnStateObserver: input item has exist.");
                            return;
                        }
                    }
                    m.add(uMSenderStateNotify);
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(UMModuleRegister.getAppContext(), th);
            }
        }
    }

    private static void b(int i2) {
        Handler handler;
        if (!l || (handler = f26168b) == null || handler.hasMessages(i2)) {
            return;
        }
        Message obtainMessage = f26168b.obtainMessage();
        obtainMessage.what = i2;
        f26168b.sendMessage(obtainMessage);
    }

    public static boolean a() {
        boolean z;
        synchronized (w) {
            z = r;
        }
        return z;
    }

    public static void a(boolean z) {
        int size;
        l = z;
        if (z) {
            synchronized (n) {
                ArrayList<UMSenderStateNotify> arrayList = m;
                if (arrayList != null && (size = arrayList.size()) > 0) {
                    for (int i2 = 0; i2 < size; i2++) {
                        m.get(i2).onConnectionAvailable();
                    }
                }
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "网络状态通知：尝试发送 MSG_PROCESS_NEXT");
            d();
            return;
        }
        ULog.i("--->>> network disconnected.");
        l = false;
    }

    private static void a(int i2, long j2) {
        Handler handler;
        if (!l || (handler = f26168b) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i2;
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> sendMsgDelayed: " + j2);
        f26168b.sendMessageDelayed(obtainMessage, j2);
    }

    private static void a(int i2, int i3) {
        Handler handler;
        if (!l || (handler = f26168b) == null) {
            return;
        }
        handler.removeMessages(i2);
        Message obtainMessage = f26168b.obtainMessage();
        obtainMessage.what = i2;
        f26168b.sendMessageDelayed(obtainMessage, i3);
    }
}
