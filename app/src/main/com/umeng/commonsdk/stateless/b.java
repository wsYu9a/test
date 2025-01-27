package com.umeng.commonsdk.stateless;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.IntentFilter;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.File;
import java.util.LinkedList;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    public static final int f24569a = 273;

    /* renamed from: b */
    private static Context f24570b = null;

    /* renamed from: c */
    private static HandlerThread f24571c = null;

    /* renamed from: d */
    private static Handler f24572d = null;

    /* renamed from: f */
    private static final int f24574f = 274;

    /* renamed from: g */
    private static final int f24575g = 275;

    /* renamed from: h */
    private static final int f24576h = 512;

    /* renamed from: i */
    private static a f24577i = null;

    /* renamed from: j */
    private static IntentFilter f24578j = null;

    /* renamed from: k */
    private static volatile boolean f24579k = false;

    /* renamed from: e */
    private static Object f24573e = new Object();

    /* renamed from: l */
    private static LinkedList<String> f24580l = new LinkedList<>();

    /* renamed from: com.umeng.commonsdk.stateless.b$1 */
    public class AnonymousClass1 extends Handler {
        public AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != 512) {
                switch (i10) {
                    case b.f24569a /* 273 */:
                        b.l();
                        return;
                    case b.f24574f /* 274 */:
                        b.n();
                        return;
                    case b.f24575g /* 275 */:
                        b.p();
                        break;
                    default:
                        return;
                }
            }
            b.q();
        }
    }

    public static class a extends FileObserver {
        public a(String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i10, String str) {
            if ((i10 & 8) != 8) {
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
            b.a(b.f24574f);
        }
    }

    public b(Context context) {
        synchronized (f24573e) {
            if (context != null) {
                try {
                    try {
                        Context applicationContext = context.getApplicationContext();
                        f24570b = applicationContext;
                        if (applicationContext != null && f24571c == null) {
                            HandlerThread handlerThread = new HandlerThread("SL-NetWorkSender");
                            f24571c = handlerThread;
                            handlerThread.start();
                            if (f24577i == null) {
                                String str = f24570b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f24564f;
                                File file = new File(str);
                                if (!file.exists()) {
                                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓目录不存在，创建之。");
                                    file.mkdir();
                                }
                                a aVar = new a(str);
                                f24577i = aVar;
                                aVar.startWatching();
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓File Monitor启动.");
                            }
                            if (f24572d == null) {
                                f24572d = new Handler(f24571c.getLooper()) { // from class: com.umeng.commonsdk.stateless.b.1
                                    public AnonymousClass1(Looper looper) {
                                        super(looper);
                                    }

                                    @Override // android.os.Handler
                                    public void handleMessage(Message message) {
                                        int i10 = message.what;
                                        if (i10 != 512) {
                                            switch (i10) {
                                                case b.f24569a /* 273 */:
                                                    b.l();
                                                    return;
                                                case b.f24574f /* 274 */:
                                                    b.n();
                                                    return;
                                                case b.f24575g /* 275 */:
                                                    b.p();
                                                    break;
                                                default:
                                                    return;
                                            }
                                        }
                                        b.q();
                                    }
                                };
                            }
                        }
                    } finally {
                    }
                } catch (Throwable th2) {
                }
            }
        }
    }

    public static void a(boolean z10) {
        f24579k = z10;
        if (!z10) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>网络断连： 2号数据仓");
        } else {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>网络可用： 触发2号数据仓信封消费动作。");
            b(f24574f);
        }
    }

    public static void b(int i10) {
        Handler handler;
        try {
            if (!f24579k || (handler = f24572d) == null || handler.hasMessages(i10)) {
                return;
            }
            Message obtainMessage = f24572d.obtainMessage();
            obtainMessage.what = i10;
            f24572d.sendMessage(obtainMessage);
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(f24570b, th2);
        }
    }

    public static void c() {
        b(f24575g);
    }

    public static void d() {
        b(512);
    }

    private static void i() {
        File[] c10 = d.c(f24570b);
        if (c10 != null) {
            if (f24580l.size() > 0) {
                f24580l.clear();
            }
            for (File file : c10) {
                f24580l.add(file.getAbsolutePath());
            }
        }
    }

    private static String j() {
        String str = null;
        try {
            String peek = f24580l.peek();
            if (peek == null) {
                return peek;
            }
            try {
                f24580l.removeFirst();
                return peek;
            } catch (Throwable unused) {
                str = peek;
                return str;
            }
        } catch (Throwable unused2) {
        }
    }

    @TargetApi(9)
    private static void k() {
        String pollFirst;
        byte[] bArr;
        if (f24580l.size() <= 0) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> todoList无内容，无需处理。");
            return;
        }
        do {
            pollFirst = f24580l.pollFirst();
            if (!TextUtils.isEmpty(pollFirst)) {
                File file = new File(pollFirst);
                if (file.exists()) {
                    c cVar = new c(f24570b);
                    try {
                        bArr = d.a(pollFirst);
                    } catch (Exception unused) {
                        bArr = null;
                    }
                    String name = file.getName();
                    String substring = !TextUtils.isEmpty(name) ? name.substring(0, 1) : "u";
                    String c10 = d.c(d.d(name));
                    if (SdkVersion.SDK_TYPE == 0) {
                        cVar.a();
                    } else {
                        com.umeng.commonsdk.stateless.a.f24565g = com.umeng.commonsdk.stateless.a.f24568j;
                        cVar.b();
                    }
                    if (cVar.a(bArr, c10, com.umeng.commonsdk.vchannel.a.f24872c.equalsIgnoreCase(c10) ? com.umeng.commonsdk.vchannel.a.f24870a : com.umeng.commonsdk.stateless.a.f24566h, substring) && !file.delete()) {
                        file.delete();
                    }
                } else {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 信封文件不存在，处理下一个文件。");
                }
            }
        } while (pollFirst != null);
        f24580l.clear();
    }

    public static void l() {
        File a10;
        byte[] bArr;
        if (!f24579k || f24570b == null) {
            return;
        }
        do {
            try {
                a10 = d.a(f24570b);
                if (a10 != null && a10.getParentFile() != null && !TextUtils.isEmpty(a10.getParentFile().getName())) {
                    c cVar = new c(f24570b);
                    String str = new String(Base64.decode(a10.getParentFile().getName(), 0));
                    if (!com.umeng.commonsdk.internal.a.f24465a.equalsIgnoreCase(str) && !com.umeng.commonsdk.internal.a.f24466b.equalsIgnoreCase(str) && !com.umeng.commonsdk.internal.a.H.equalsIgnoreCase(str)) {
                        ULog.i("walle", "[stateless] handleProcessNext, pathUrl is " + str);
                        try {
                            bArr = d.a(a10.getAbsolutePath());
                        } catch (Exception unused) {
                            bArr = null;
                        }
                        String str2 = UMServerURL.PATH_SHARE.equalsIgnoreCase(str) ? "s" : "u";
                        if (UMServerURL.PATH_PUSH_LAUNCH.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_REGIST.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_LOG.equalsIgnoreCase(str)) {
                            str2 = "p";
                        }
                        if (SdkVersion.SDK_TYPE == 0) {
                            cVar.a();
                        } else {
                            com.umeng.commonsdk.stateless.a.f24565g = com.umeng.commonsdk.stateless.a.f24568j;
                            cVar.b();
                        }
                        if (!cVar.a(bArr, str, com.umeng.commonsdk.vchannel.a.f24872c.equalsIgnoreCase(str) ? com.umeng.commonsdk.vchannel.a.f24870a : com.umeng.commonsdk.stateless.a.f24566h, str2)) {
                            ULog.i("walle", "[stateless] Send envelope file failed, abandon and wait next trigger!");
                            return;
                        }
                        ULog.i("walle", "[stateless] Send envelope file success, delete it.");
                        File file = new File(a10.getAbsolutePath());
                        if (!file.delete()) {
                            ULog.i("walle", "[stateless] Failed to delete already processed file. We try again after delete failed.");
                            file.delete();
                        }
                    }
                    new File(a10.getAbsolutePath()).delete();
                }
            } catch (Throwable th2) {
                UMCrashManager.reportCrash(f24570b, th2);
            }
        } while (a10 != null);
        m();
    }

    private static void m() {
        try {
            File file = new File(f24570b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f24563e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓：删除stateless目录。");
                d.a(file);
            }
        } catch (Throwable unused) {
        }
    }

    public static void n() {
        if (!f24579k || f24570b == null) {
            return;
        }
        i();
        k();
        c();
    }

    private static void o() {
        try {
            File file = new File(f24570b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f24563e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>2号数据仓：检测到stateless目录。");
                b(f24569a);
            }
        } catch (Throwable unused) {
        }
    }

    public static void p() {
        o();
    }

    public static void q() {
    }

    public static boolean a() {
        synchronized (f24573e) {
            try {
                return f24577i != null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void b() {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>信封构建成功： 触发2号数据仓信封消费动作。");
        b(f24574f);
    }

    public static void a(int i10) {
        Handler handler;
        if (!f24579k || (handler = f24572d) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i10;
        f24572d.sendMessage(obtainMessage);
    }
}
