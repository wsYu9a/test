package com.umeng.commonsdk.framework;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.kuaishou.weapon.p0.g;
import com.sigmob.sdk.base.common.y;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.by;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.b;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.c;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes4.dex */
public class a implements UMImprintChangeCallback {

    /* renamed from: a */
    private static HandlerThread f24439a = null;

    /* renamed from: b */
    private static Handler f24440b = null;

    /* renamed from: c */
    private static Handler f24441c = null;

    /* renamed from: d */
    private static final int f24442d = 200;

    /* renamed from: e */
    private static final int f24443e = 273;

    /* renamed from: f */
    private static final int f24444f = 274;

    /* renamed from: g */
    private static final int f24445g = 512;

    /* renamed from: h */
    private static final int f24446h = 769;

    /* renamed from: i */
    private static FileObserverC0672a f24447i = null;

    /* renamed from: j */
    private static ConnectivityManager f24448j = null;

    /* renamed from: k */
    private static IntentFilter f24449k = null;

    /* renamed from: l */
    private static volatile boolean f24450l = false;

    /* renamed from: m */
    private static ArrayList<UMSenderStateNotify> f24451m = null;

    /* renamed from: p */
    private static final String f24454p = "report_policy";

    /* renamed from: q */
    private static final String f24455q = "report_interval";

    /* renamed from: s */
    private static final int f24457s = 15;

    /* renamed from: t */
    private static final int f24458t = 3;

    /* renamed from: u */
    private static final int f24459u = 90;

    /* renamed from: x */
    private static BroadcastReceiver f24462x;

    /* renamed from: n */
    private static Object f24452n = new Object();

    /* renamed from: o */
    private static ReentrantLock f24453o = new ReentrantLock();

    /* renamed from: r */
    private static boolean f24456r = false;

    /* renamed from: v */
    private static int f24460v = 15;

    /* renamed from: w */
    private static Object f24461w = new Object();

    /* renamed from: com.umeng.commonsdk.framework.a$1 */
    public static class AnonymousClass1 extends ConnectivityManager.NetworkCallback {

        /* renamed from: a */
        final /* synthetic */ Context f24463a;

        public AnonymousClass1(Context context) {
            applicationContext = context;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            Context context = applicationContext;
            UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.E, b.a(context).a(), null);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onLost");
            Context context = applicationContext;
            UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.E, b.a(context).a(), null, y.f.f18076n);
        }
    }

    /* renamed from: com.umeng.commonsdk.framework.a$2 */
    public static class AnonymousClass2 extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.E, b.a(context).a(), null);
            }
        }
    }

    /* renamed from: com.umeng.commonsdk.framework.a$3 */
    public class AnonymousClass3 extends Handler {
        public AnonymousClass3(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 273) {
                ULog.d("--->>> handleMessage: recv MSG_PROCESS_NEXT msg.");
                try {
                    a.f24453o.tryLock(1L, TimeUnit.SECONDS);
                    try {
                        a.n();
                    } catch (Throwable unused) {
                    }
                    a.f24453o.unlock();
                    return;
                } catch (Throwable unused2) {
                    return;
                }
            }
            if (i10 == a.f24444f) {
                a.l();
            } else {
                if (i10 != 512) {
                    return;
                }
                a.m();
            }
        }
    }

    /* renamed from: com.umeng.commonsdk.framework.a$a */
    public static class FileObserverC0672a extends FileObserver {
        public FileObserverC0672a(String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i10, String str) {
            if ((i10 & 8) != 8) {
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
            f24448j = (ConnectivityManager) appContext.getSystemService("connectivity");
        }
        f24462x = new BroadcastReceiver() { // from class: com.umeng.commonsdk.framework.a.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.E, b.a(context).a(), null);
                }
            }
        };
    }

    public a(Context context, Handler handler) {
        if (f24448j == null) {
            Context appContext = UMGlobalContext.getAppContext();
            if (f24448j != null) {
                f24448j = (ConnectivityManager) appContext.getSystemService("connectivity");
            }
        }
        f24441c = handler;
        try {
            if (f24439a == null) {
                HandlerThread handlerThread = new HandlerThread("NetWorkSender");
                f24439a = handlerThread;
                handlerThread.start();
                if (f24447i == null) {
                    FileObserverC0672a fileObserverC0672a = new FileObserverC0672a(UMFrUtils.getEnvelopeDirPath(context));
                    f24447i = fileObserverC0672a;
                    fileObserverC0672a.startWatching();
                    ULog.d("--->>> FileMonitor has already started!");
                }
                j();
                if (f24440b == null) {
                    f24440b = new Handler(f24439a.getLooper()) { // from class: com.umeng.commonsdk.framework.a.3
                        public AnonymousClass3(Looper looper) {
                            super(looper);
                        }

                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            int i10 = message.what;
                            if (i10 == 273) {
                                ULog.d("--->>> handleMessage: recv MSG_PROCESS_NEXT msg.");
                                try {
                                    a.f24453o.tryLock(1L, TimeUnit.SECONDS);
                                    try {
                                        a.n();
                                    } catch (Throwable unused) {
                                    }
                                    a.f24453o.unlock();
                                    return;
                                } catch (Throwable unused2) {
                                    return;
                                }
                            }
                            if (i10 == a.f24444f) {
                                a.l();
                            } else {
                                if (i10 != 512) {
                                    return;
                                }
                                a.m();
                            }
                        }
                    };
                }
                ImprintHandler.getImprintService(context).registImprintCallback(f24454p, this);
                ImprintHandler.getImprintService(context).registImprintCallback(f24455q, this);
            }
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context, th2);
        }
    }

    public static int b() {
        int i10;
        synchronized (f24461w) {
            i10 = f24460v;
        }
        return i10;
    }

    public static void c() {
    }

    public static void d() {
        if (f24453o.tryLock()) {
            try {
                b(273);
            } finally {
                f24453o.unlock();
            }
        }
    }

    public static void e() {
        a(f24444f, 3000);
    }

    private void j() {
        synchronized (f24461w) {
            try {
                if (Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE.equals(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), f24454p, ""))) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> switch to report_policy 11");
                    f24456r = true;
                    f24460v = 15;
                    int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), f24455q, Constants.VIA_REPORT_TYPE_WPA_STATE)).intValue();
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> set report_interval value to: " + intValue);
                    if (intValue >= 3 && intValue <= 90) {
                        f24460v = intValue * 1000;
                    }
                    f24460v = 15;
                } else {
                    f24456r = false;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static void k() {
        if (f24439a != null) {
            f24439a = null;
        }
        if (f24440b != null) {
            f24440b = null;
        }
        if (f24441c != null) {
            f24441c = null;
        }
    }

    public static void l() {
        int size;
        synchronized (f24452n) {
            try {
                ArrayList<UMSenderStateNotify> arrayList = f24451m;
                if (arrayList != null && (size = arrayList.size()) > 0) {
                    for (int i10 = 0; i10 < size; i10++) {
                        f24451m.get(i10).onSenderIdle();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void m() {
    }

    public static void n() {
        ULog.d("--->>> handleProcessNext: Enter...");
        if (f24450l) {
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
            } catch (Throwable th2) {
                UMCrashManager.reportCrash(appContext, th2);
            }
        }
    }

    @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
    public void onImprintValueChanged(String str, String str2) {
        synchronized (f24461w) {
            try {
                if (f24454p.equals(str)) {
                    if (Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE.equals(str2)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> switch to report_policy 11");
                        f24456r = true;
                    } else {
                        f24456r = false;
                    }
                }
                if (f24455q.equals(str)) {
                    int intValue = Integer.valueOf(str2).intValue();
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> set report_interval value to: " + intValue);
                    if (intValue >= 3 && intValue <= 90) {
                        f24460v = intValue * 1000;
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> really set report_interval value to: " + f24460v);
                    }
                    f24460v = by.f23697b;
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> really set report_interval value to: " + f24460v);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void a(Context context) {
        if (f24448j != null || context == null) {
            return;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        f24448j = connectivityManager;
        if (connectivityManager != null) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> createCMIfNeeded:注册网络状态监听器。");
            b(context);
        }
    }

    public static void c(int i10) {
        Handler handler;
        if (!f24450l || (handler = f24440b) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i10;
        f24440b.sendMessage(obtainMessage);
    }

    @SuppressLint({"NewApi", "MissingPermission"})
    public static void b(Context context) {
        if (context == null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> registerNetReceiver: context is null, registerNetReceiver failed.");
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            if (DeviceConfig.checkPermission(context, g.f11101b)) {
                NetworkRequest build = new NetworkRequest.Builder().addTransportType(0).addTransportType(1).build();
                if (f24448j != null) {
                    Context applicationContext = context.getApplicationContext();
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 注册网络状态监听器:registerNetworkCallback");
                    f24448j.registerNetworkCallback(build, new ConnectivityManager.NetworkCallback() { // from class: com.umeng.commonsdk.framework.a.1

                        /* renamed from: a */
                        final /* synthetic */ Context f24463a;

                        public AnonymousClass1(Context applicationContext2) {
                            applicationContext = applicationContext2;
                        }

                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onAvailable(Network network) {
                            Context context2 = applicationContext;
                            UMWorkDispatch.sendEvent(context2, com.umeng.commonsdk.internal.a.E, b.a(context2).a(), null);
                        }

                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                            super.onCapabilitiesChanged(network, networkCapabilities);
                        }

                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onLost(Network network) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onLost");
                            Context context2 = applicationContext;
                            UMWorkDispatch.sendEvent(context2, com.umeng.commonsdk.internal.a.E, b.a(context2).a(), null, y.f.f18076n);
                        }
                    });
                    return;
                }
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> ACCESS_NETWORK_STATE permission access denied.");
            return;
        }
        if (DeviceConfig.checkPermission(context, g.f11101b)) {
            if (f24448j == null || f24449k != null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            f24449k = intentFilter;
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            if (f24462x != null) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 注册网络状态监听器:registerReceiver");
                context.registerReceiver(f24462x, f24449k);
                return;
            }
            return;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> ACCESS_NETWORK_STATE permission access denied.");
    }

    public static void a(UMSenderStateNotify uMSenderStateNotify) {
        synchronized (f24452n) {
            try {
                if (f24451m == null) {
                    f24451m = new ArrayList<>();
                }
                if (uMSenderStateNotify != null) {
                    for (int i10 = 0; i10 < f24451m.size(); i10++) {
                        if (uMSenderStateNotify == f24451m.get(i10)) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> addConnStateObserver: input item has exist.");
                            return;
                        }
                    }
                    f24451m.add(uMSenderStateNotify);
                }
            } catch (Throwable th2) {
                UMCrashManager.reportCrash(UMModuleRegister.getAppContext(), th2);
            }
        }
    }

    public static boolean a() {
        boolean z10;
        synchronized (f24461w) {
            z10 = f24456r;
        }
        return z10;
    }

    public static void a(boolean z10) {
        int size;
        f24450l = z10;
        if (z10) {
            synchronized (f24452n) {
                try {
                    ArrayList<UMSenderStateNotify> arrayList = f24451m;
                    if (arrayList != null && (size = arrayList.size()) > 0) {
                        for (int i10 = 0; i10 < size; i10++) {
                            f24451m.get(i10).onConnectionAvailable();
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "网络状态通知：尝试发送 MSG_PROCESS_NEXT");
            d();
            return;
        }
        ULog.i("--->>> network disconnected.");
        f24450l = false;
    }

    private static void b(int i10) {
        Handler handler;
        if (!f24450l || (handler = f24440b) == null || handler.hasMessages(i10)) {
            return;
        }
        Message obtainMessage = f24440b.obtainMessage();
        obtainMessage.what = i10;
        f24440b.sendMessage(obtainMessage);
    }

    private static void a(int i10, long j10) {
        Handler handler;
        if (!f24450l || (handler = f24440b) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i10;
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> sendMsgDelayed: " + j10);
        f24440b.sendMessageDelayed(obtainMessage, j10);
    }

    private static void a(int i10, int i11) {
        Handler handler;
        if (!f24450l || (handler = f24440b) == null) {
            return;
        }
        handler.removeMessages(i10);
        Message obtainMessage = f24440b.obtainMessage();
        obtainMessage.what = i10;
        f24440b.sendMessageDelayed(obtainMessage, i11);
    }
}
