package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.File;
import java.util.LinkedList;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    public static final int f26259a = 273;

    /* renamed from: b */
    private static Context f26260b = null;

    /* renamed from: c */
    private static HandlerThread f26261c = null;

    /* renamed from: d */
    private static Handler f26262d = null;

    /* renamed from: f */
    private static final int f26264f = 274;

    /* renamed from: g */
    private static final int f26265g = 275;

    /* renamed from: h */
    private static final int f26266h = 512;

    /* renamed from: i */
    private static a f26267i = null;

    /* renamed from: j */
    private static IntentFilter f26268j = null;
    private static volatile boolean k = false;

    /* renamed from: e */
    private static Object f26263e = new Object();
    private static LinkedList<String> l = new LinkedList<>();

    /* renamed from: com.umeng.commonsdk.stateless.b$1 */
    class AnonymousClass1 extends Handler {
        AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 512) {
                switch (i2) {
                    case b.f26259a /* 273 */:
                        b.l();
                        return;
                    case b.f26264f /* 274 */:
                        b.n();
                        return;
                    case b.f26265g /* 275 */:
                        b.p();
                        break;
                    default:
                        return;
                }
            }
            b.q();
        }
    }

    static class a extends FileObserver {
        public a(String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i2, String str) {
            if ((i2 & 8) != 8) {
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
            b.a(b.f26264f);
        }
    }

    public b(Context context) {
        synchronized (f26263e) {
            if (context != null) {
                try {
                    Context applicationContext = context.getApplicationContext();
                    f26260b = applicationContext;
                    if (applicationContext != null && f26261c == null) {
                        HandlerThread handlerThread = new HandlerThread("SL-NetWorkSender");
                        f26261c = handlerThread;
                        handlerThread.start();
                        if (f26267i == null) {
                            String str = f26260b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f26254f;
                            File file = new File(str);
                            if (!file.exists()) {
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓目录不存在，创建之。");
                                file.mkdir();
                            }
                            a aVar = new a(str);
                            f26267i = aVar;
                            aVar.startWatching();
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓File Monitor启动.");
                        }
                        if (f26262d == null) {
                            f26262d = new Handler(f26261c.getLooper()) { // from class: com.umeng.commonsdk.stateless.b.1
                                AnonymousClass1(Looper looper) {
                                    super(looper);
                                }

                                @Override // android.os.Handler
                                public void handleMessage(Message message) {
                                    int i2 = message.what;
                                    if (i2 != 512) {
                                        switch (i2) {
                                            case b.f26259a /* 273 */:
                                                b.l();
                                                return;
                                            case b.f26264f /* 274 */:
                                                b.n();
                                                return;
                                            case b.f26265g /* 275 */:
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
            }
        }
    }

    public static void a(boolean z) {
        k = z;
        if (!z) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>网络断连： 2号数据仓");
        } else {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>网络可用： 触发2号数据仓信封消费动作。");
            b(f26264f);
        }
    }

    public static void b(int i2) {
        Handler handler;
        try {
            if (!k || (handler = f26262d) == null || handler.hasMessages(i2)) {
                return;
            }
            Message obtainMessage = f26262d.obtainMessage();
            obtainMessage.what = i2;
            f26262d.sendMessage(obtainMessage);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f26260b, th);
        }
    }

    public static void c() {
        b(f26265g);
    }

    public static void d() {
        b(512);
    }

    private static void i() {
        File[] c2 = d.c(f26260b);
        if (c2 != null) {
            if (l.size() > 0) {
                l.clear();
            }
            for (File file : c2) {
                l.add(file.getAbsolutePath());
            }
        }
    }

    private static String j() {
        String str = null;
        try {
            String peek = l.peek();
            if (peek == null) {
                return peek;
            }
            try {
                l.removeFirst();
                return peek;
            } catch (Throwable unused) {
                str = peek;
                return str;
            }
        } catch (Throwable unused2) {
        }
    }

    private static void k() {
        String pollFirst;
        if (l.size() <= 0) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> todoList无内容，无需处理。");
            return;
        }
        do {
            pollFirst = Build.VERSION.SDK_INT >= 9 ? l.pollFirst() : j();
            if (!TextUtils.isEmpty(pollFirst)) {
                File file = new File(pollFirst);
                if (file.exists()) {
                    c cVar = new c(f26260b);
                    byte[] bArr = null;
                    try {
                        bArr = d.a(pollFirst);
                    } catch (Exception unused) {
                    }
                    String name = file.getName();
                    String substring = !TextUtils.isEmpty(name) ? name.substring(0, 1) : "u";
                    String c2 = d.c(d.d(name));
                    if (cVar.a(bArr, c2, com.umeng.commonsdk.vchannel.a.f26506c.equalsIgnoreCase(c2) ? com.umeng.commonsdk.vchannel.a.f26504a : "", substring) && !file.delete()) {
                        file.delete();
                    }
                } else {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 信封文件不存在，处理下一个文件。");
                }
            }
        } while (pollFirst != null);
        l.clear();
    }

    public static void l() {
        File a2;
        if (!k || f26260b == null) {
            return;
        }
        do {
            try {
                a2 = d.a(f26260b);
                if (a2 != null && a2.getParentFile() != null && !TextUtils.isEmpty(a2.getParentFile().getName())) {
                    c cVar = new c(f26260b);
                    String str = new String(Base64.decode(a2.getParentFile().getName(), 0));
                    if (!com.umeng.commonsdk.internal.a.f26178a.equalsIgnoreCase(str) && !com.umeng.commonsdk.internal.a.f26179b.equalsIgnoreCase(str) && !com.umeng.commonsdk.internal.a.G.equalsIgnoreCase(str)) {
                        ULog.i("walle", "[stateless] handleProcessNext, pathUrl is " + str);
                        byte[] bArr = null;
                        try {
                            bArr = d.a(a2.getAbsolutePath());
                        } catch (Exception unused) {
                        }
                        String str2 = com.umeng.commonsdk.vchannel.a.f26506c.equalsIgnoreCase(str) ? com.umeng.commonsdk.vchannel.a.f26504a : "";
                        String str3 = UMServerURL.PATH_SHARE.equalsIgnoreCase(str) ? "s" : "u";
                        if (UMServerURL.PATH_PUSH_LAUNCH.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_REGIST.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_LOG.equalsIgnoreCase(str)) {
                            str3 = "p";
                        }
                        if (!cVar.a(bArr, str, str2, str3)) {
                            ULog.i("walle", "[stateless] Send envelope file failed, abandon and wait next trigger!");
                            return;
                        }
                        ULog.i("walle", "[stateless] Send envelope file success, delete it.");
                        File file = new File(a2.getAbsolutePath());
                        if (!file.delete()) {
                            ULog.i("walle", "[stateless] Failed to delete already processed file. We try again after delete failed.");
                            file.delete();
                        }
                    }
                    new File(a2.getAbsolutePath()).delete();
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(f26260b, th);
            }
        } while (a2 != null);
        m();
    }

    private static void m() {
        try {
            File file = new File(f26260b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f26253e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓：删除stateless目录。");
                d.a(file);
            }
        } catch (Throwable unused) {
        }
    }

    public static void n() {
        if (!k || f26260b == null) {
            return;
        }
        i();
        k();
        c();
    }

    private static void o() {
        try {
            File file = new File(f26260b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f26253e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>2号数据仓：检测到stateless目录。");
                b(f26259a);
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
        synchronized (f26263e) {
            return f26267i != null;
        }
    }

    public static void b() {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>信封构建成功： 触发2号数据仓信封消费动作。");
        b(f26264f);
    }

    public static void a(int i2) {
        Handler handler;
        if (!k || (handler = f26262d) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i2;
        f26262d.sendMessage(obtainMessage);
    }
}
