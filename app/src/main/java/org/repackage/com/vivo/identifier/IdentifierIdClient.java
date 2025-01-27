package org.repackage.com.vivo.identifier;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.shu.priory.config.AdKeys;
import com.sigmob.sdk.base.common.y;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import ke.e;

/* loaded from: classes4.dex */
public class IdentifierIdClient {
    private static int A = 13;
    private static IdentifierIdObserver B = null;
    private static IdentifierIdObserver C = null;
    private static IdentifierIdObserver D = null;
    private static IdentifierIdObserver E = null;
    private static HandlerThread F = null;
    private static Handler G = null;
    private static String H = null;
    private static String I = null;
    private static String J = null;
    private static String K = null;
    private static String L = null;
    private static String M = null;
    private static String N = null;
    private static volatile IdentifierIdClient O = null;
    private static volatile DataBaseOperation P = null;
    private static int R = 0;
    private static int S = 0;
    private static int T = 0;
    private static int U = 0;
    private static int V = 0;
    private static int W = 0;
    private static int X = 0;
    private static int Y = 0;
    private static int Z = 0;

    /* renamed from: a */
    public static final String f29425a = "persist.sys.identifierid";

    /* renamed from: aa */
    private static int f29426aa = 0;

    /* renamed from: ab */
    private static int f29427ab = 0;

    /* renamed from: ac */
    private static int f29428ac = 0;

    /* renamed from: b */
    private static final String f29429b = "VMS_SDK_Client";

    /* renamed from: c */
    private static final String f29430c = "content://com.vivo.vms.IdProvider/IdentifierId";

    /* renamed from: d */
    private static final String f29431d = "persist.sys.identifierid.supported";

    /* renamed from: e */
    private static final String f29432e = "com.vivo.vms";

    /* renamed from: f */
    private static final String f29433f = "appid";

    /* renamed from: g */
    private static final String f29434g = "type";

    /* renamed from: h */
    private static final String f29435h = "OAID";

    /* renamed from: i */
    private static final String f29436i = "VAID";

    /* renamed from: j */
    private static final String f29437j = "OAIDSTATUS";

    /* renamed from: k */
    private static Object f29438k = new Object();

    /* renamed from: l */
    private static final int f29439l = 0;

    /* renamed from: m */
    private static final int f29440m = 1;

    /* renamed from: n */
    private static final int f29441n = 2;

    /* renamed from: o */
    private static final int f29442o = 3;

    /* renamed from: p */
    private static final int f29443p = 4;

    /* renamed from: q */
    private static final int f29444q = 5;

    /* renamed from: r */
    private static final int f29445r = 6;

    /* renamed from: s */
    private static final int f29446s = 7;

    /* renamed from: t */
    private static final int f29447t = 8;

    /* renamed from: u */
    private static final int f29448u = 9;

    /* renamed from: v */
    private static final int f29449v = 10;

    /* renamed from: w */
    private static final int f29450w = 11;

    /* renamed from: x */
    private static final int f29451x = 2000;

    /* renamed from: y */
    private static Context f29452y = null;

    /* renamed from: z */
    private static boolean f29453z = false;
    private final int Q;

    /* renamed from: org.repackage.com.vivo.identifier.IdentifierIdClient$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (IdentifierIdClient.R + IdentifierIdClient.S + IdentifierIdClient.X + IdentifierIdClient.f29426aa + IdentifierIdClient.T + IdentifierIdClient.U + IdentifierIdClient.Z + IdentifierIdClient.f29426aa + IdentifierIdClient.V + IdentifierIdClient.W + IdentifierIdClient.f29427ab + IdentifierIdClient.f29428ac > 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(AdKeys.OAID, IdentifierIdClient.this.a(IdentifierIdClient.R, IdentifierIdClient.S, IdentifierIdClient.X, IdentifierIdClient.Y));
                contentValues.put("vaid", IdentifierIdClient.this.a(IdentifierIdClient.T, IdentifierIdClient.U, IdentifierIdClient.Z, IdentifierIdClient.f29426aa));
                contentValues.put("aaid", IdentifierIdClient.this.a(IdentifierIdClient.V, IdentifierIdClient.W, IdentifierIdClient.f29427ab, IdentifierIdClient.f29428ac));
                IdentifierIdClient.P.a(7, e.f27807e, new ContentValues[]{contentValues});
                int unused = IdentifierIdClient.R = IdentifierIdClient.S = IdentifierIdClient.T = IdentifierIdClient.U = IdentifierIdClient.V = IdentifierIdClient.W = 0;
                int unused2 = IdentifierIdClient.X = IdentifierIdClient.Y = IdentifierIdClient.Z = IdentifierIdClient.f29426aa = IdentifierIdClient.f29427ab = IdentifierIdClient.f29428ac = 0;
            }
        }
    }

    /* renamed from: org.repackage.com.vivo.identifier.IdentifierIdClient$2 */
    public class AnonymousClass2 extends Handler {
        public AnonymousClass2(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 11) {
                Log.e(IdentifierIdClient.f29429b, "message type valid");
                return;
            }
            int i10 = message.getData().getInt("type");
            try {
                String a10 = IdentifierIdClient.P.a(i10, message.getData().getString("appid"));
                if (i10 == 0) {
                    String unused = IdentifierIdClient.H = a10;
                    IdentifierIdClient.c(8, IdentifierIdClient.H);
                } else if (i10 == 1) {
                    if (a10 != null) {
                        String unused2 = IdentifierIdClient.I = a10;
                    } else {
                        Log.e(IdentifierIdClient.f29429b, "get vaid failed");
                    }
                    IdentifierIdClient.c(9, IdentifierIdClient.I);
                } else if (i10 == 2) {
                    if (a10 != null) {
                        String unused3 = IdentifierIdClient.J = a10;
                    } else {
                        Log.e(IdentifierIdClient.f29429b, "get aaid failed");
                    }
                    IdentifierIdClient.c(10, IdentifierIdClient.J);
                } else if (i10 != 3) {
                    if (i10 == 4) {
                        String unused4 = IdentifierIdClient.L = a10;
                    } else if (i10 == 5) {
                        if (a10 != null) {
                            String unused5 = IdentifierIdClient.M = a10;
                        } else {
                            Log.e(IdentifierIdClient.f29429b, "get guid failed");
                        }
                    }
                } else if (a10 != null) {
                    String unused6 = IdentifierIdClient.K = a10;
                } else {
                    Log.e(IdentifierIdClient.f29429b, "get udid failed");
                }
            } catch (Exception e10) {
                Log.e(IdentifierIdClient.f29429b, "readException:" + e10.toString());
            }
            synchronized (IdentifierIdClient.f29438k) {
                IdentifierIdClient.f29438k.notify();
            }
        }
    }

    private IdentifierIdClient() {
        D();
        P = new DataBaseOperation(f29452y);
        this.Q = c(f29452y);
    }

    private void C() {
        Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(new Runnable() { // from class: org.repackage.com.vivo.identifier.IdentifierIdClient.1
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (IdentifierIdClient.R + IdentifierIdClient.S + IdentifierIdClient.X + IdentifierIdClient.f29426aa + IdentifierIdClient.T + IdentifierIdClient.U + IdentifierIdClient.Z + IdentifierIdClient.f29426aa + IdentifierIdClient.V + IdentifierIdClient.W + IdentifierIdClient.f29427ab + IdentifierIdClient.f29428ac > 0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(AdKeys.OAID, IdentifierIdClient.this.a(IdentifierIdClient.R, IdentifierIdClient.S, IdentifierIdClient.X, IdentifierIdClient.Y));
                    contentValues.put("vaid", IdentifierIdClient.this.a(IdentifierIdClient.T, IdentifierIdClient.U, IdentifierIdClient.Z, IdentifierIdClient.f29426aa));
                    contentValues.put("aaid", IdentifierIdClient.this.a(IdentifierIdClient.V, IdentifierIdClient.W, IdentifierIdClient.f29427ab, IdentifierIdClient.f29428ac));
                    IdentifierIdClient.P.a(7, e.f27807e, new ContentValues[]{contentValues});
                    int unused = IdentifierIdClient.R = IdentifierIdClient.S = IdentifierIdClient.T = IdentifierIdClient.U = IdentifierIdClient.V = IdentifierIdClient.W = 0;
                    int unused2 = IdentifierIdClient.X = IdentifierIdClient.Y = IdentifierIdClient.Z = IdentifierIdClient.f29426aa = IdentifierIdClient.f29427ab = IdentifierIdClient.f29428ac = 0;
                }
            }
        }, 600L, 600L, TimeUnit.SECONDS);
    }

    private static void D() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        F = handlerThread;
        handlerThread.start();
        G = new Handler(F.getLooper()) { // from class: org.repackage.com.vivo.identifier.IdentifierIdClient.2
            public AnonymousClass2(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 11) {
                    Log.e(IdentifierIdClient.f29429b, "message type valid");
                    return;
                }
                int i10 = message.getData().getInt("type");
                try {
                    String a10 = IdentifierIdClient.P.a(i10, message.getData().getString("appid"));
                    if (i10 == 0) {
                        String unused = IdentifierIdClient.H = a10;
                        IdentifierIdClient.c(8, IdentifierIdClient.H);
                    } else if (i10 == 1) {
                        if (a10 != null) {
                            String unused2 = IdentifierIdClient.I = a10;
                        } else {
                            Log.e(IdentifierIdClient.f29429b, "get vaid failed");
                        }
                        IdentifierIdClient.c(9, IdentifierIdClient.I);
                    } else if (i10 == 2) {
                        if (a10 != null) {
                            String unused3 = IdentifierIdClient.J = a10;
                        } else {
                            Log.e(IdentifierIdClient.f29429b, "get aaid failed");
                        }
                        IdentifierIdClient.c(10, IdentifierIdClient.J);
                    } else if (i10 != 3) {
                        if (i10 == 4) {
                            String unused4 = IdentifierIdClient.L = a10;
                        } else if (i10 == 5) {
                            if (a10 != null) {
                                String unused5 = IdentifierIdClient.M = a10;
                            } else {
                                Log.e(IdentifierIdClient.f29429b, "get guid failed");
                            }
                        }
                    } else if (a10 != null) {
                        String unused6 = IdentifierIdClient.K = a10;
                    } else {
                        Log.e(IdentifierIdClient.f29429b, "get udid failed");
                    }
                } catch (Exception e10) {
                    Log.e(IdentifierIdClient.f29429b, "readException:" + e10.toString());
                }
                synchronized (IdentifierIdClient.f29438k) {
                    IdentifierIdClient.f29438k.notify();
                }
            }
        };
    }

    private static void E() {
        f29453z = "1".equals(a("persist.sys.identifierid.supported", "0")) || "1".equals(a(f29425a, "0"));
    }

    public String g() {
        String str = J;
        if (str != null) {
            c(2, str);
            return J;
        }
        e(2, e.f27807e);
        if (D == null) {
            a(f29452y, 2, e.f27807e);
        }
        c(2, J);
        return J;
    }

    public String h() {
        String str = J;
        if (str != null) {
            c(2, str);
            return J;
        }
        d(2, e.f27807e);
        if (D == null) {
            a(f29452y, 2, e.f27807e);
        }
        c(2, J);
        return J;
    }

    public String i() {
        e(4, null);
        return L;
    }

    public String j() {
        String str = M;
        if (str != null) {
            return str;
        }
        e(5, e.f27807e);
        return M;
    }

    public String k() {
        String str = M;
        if (str != null) {
            return str;
        }
        d(5, e.f27807e);
        return M;
    }

    private static int c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(f29432e, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public String d() {
        String str = H;
        if (str != null) {
            c(0, str);
            return H;
        }
        d(0, null);
        if (B == null) {
            a(f29452y, 0, null);
        }
        c(0, H);
        return H;
    }

    public String e() {
        String str = I;
        if (str != null) {
            c(1, str);
            return I;
        }
        e(1, e.f27807e);
        if (C == null) {
            a(f29452y, 1, e.f27807e);
        }
        c(1, I);
        return I;
    }

    public String f() {
        String str = I;
        if (str != null) {
            c(1, str);
            return I;
        }
        d(1, e.f27807e);
        if (C == null) {
            a(f29452y, 1, e.f27807e);
        }
        c(1, I);
        return I;
    }

    public String a(int i10, int i11, int i12, int i13) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i10);
        stringBuffer.append(",");
        stringBuffer.append(i11);
        stringBuffer.append(";");
        stringBuffer.append(i12);
        stringBuffer.append(",");
        stringBuffer.append(i13);
        return stringBuffer.toString();
    }

    public static IdentifierIdClient b(Context context) {
        if (a()) {
            return a(context);
        }
        return null;
    }

    public static IdentifierIdClient a(Context context) {
        if (f29452y == null) {
            if (context == null) {
                return null;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            f29452y = context;
        }
        if (O == null) {
            synchronized (IdentifierIdClient.class) {
                try {
                    if (O == null) {
                        O = new IdentifierIdClient();
                        O.C();
                    }
                } finally {
                }
            }
        }
        return O;
    }

    public String b() {
        String str = K;
        if (str != null) {
            return str;
        }
        e(3, null);
        return K;
    }

    public String c() {
        String str = H;
        if (str != null) {
            c(0, str);
            return H;
        }
        e(0, null);
        if (B == null) {
            a(f29452y, 0, null);
        }
        c(0, H);
        return H;
    }

    public List b(List<String> list) {
        if (this.Q < A) {
            return null;
        }
        if (list == null || list.size() == 0) {
            Log.e(f29429b, "List is null when delete OAIDBLACK");
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < list.size(); i10++) {
                String[] split = list.get(i10).split(":");
                if (split.length == 2) {
                    arrayList.add(Boolean.valueOf(P.a(6, e.f27807e, split[0], split[1])));
                }
            }
            return arrayList;
        } catch (Exception unused) {
            Log.e(f29429b, "delete OAIDBLACK failure");
            return null;
        }
    }

    private void d(int i10, String str) {
        a(i10, str);
    }

    private void e(int i10, String str) {
        synchronized (f29438k) {
            a(i10, str);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                f29438k.wait(y.f.f18076n);
            } catch (InterruptedException unused) {
                Log.e(f29429b, "queryId: lock error");
            }
            if (SystemClock.uptimeMillis() - uptimeMillis >= y.f.f18076n) {
                Log.d(f29429b, "query timeout");
            }
        }
    }

    public static boolean a() {
        if (!f29453z) {
            E();
        }
        return f29453z;
    }

    public static void c(int i10, String str) {
        if (i10 == 0) {
            if (str == null) {
                S++;
                return;
            } else {
                R++;
            }
        }
        if (i10 == 1) {
            if (str == null) {
                U++;
                return;
            } else {
                T++;
                return;
            }
        }
        if (i10 == 2) {
            if (str == null) {
                W++;
                return;
            } else {
                V++;
                return;
            }
        }
        switch (i10) {
            case 8:
                if (str != null) {
                    X++;
                    break;
                } else {
                    Y++;
                    break;
                }
            case 9:
                if (str != null) {
                    Z++;
                    break;
                } else {
                    f29426aa++;
                    break;
                }
            case 10:
                if (str != null) {
                    f29427ab++;
                    break;
                } else {
                    f29428ac++;
                    break;
                }
        }
    }

    public boolean a(List<String> list) {
        if (this.Q < A) {
            return false;
        }
        if (list == null || list.size() == 0) {
            Log.e(f29429b, "List is null when insert OAIDBLACK");
            return false;
        }
        try {
            ContentValues[] contentValuesArr = new ContentValues[list.size()];
            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
            for (int i10 = 0; i10 < list.size(); i10++) {
                ContentValues contentValues = new ContentValues();
                String[] split = list.get(i10).split(":");
                if (split.length != 2) {
                    return false;
                }
                String str = split[0];
                String str2 = split[1];
                contentValues.put("packageName", str);
                contentValues.put("uid", str2);
                contentValues.put("value", format);
                contentValuesArr[i10] = contentValues;
            }
            return P.a(6, e.f27807e, contentValuesArr);
        } catch (Exception unused) {
            Log.e(f29429b, "insert OAIDBLACK failure");
            return false;
        }
    }

    public void a(int i10, String str) {
        Message obtainMessage = G.obtainMessage();
        obtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i10);
        if (i10 == 1 || i10 == 2 || i10 == 6) {
            bundle.putString("appid", str);
        }
        obtainMessage.setData(bundle);
        G.sendMessage(obtainMessage);
    }

    private static String a(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, "0");
            } catch (Exception e10) {
                Log.e(f29429b, "getProperty: invoke is error" + e10.getMessage());
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static synchronized void a(Context context, int i10, String str) {
        synchronized (IdentifierIdClient.class) {
            try {
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 == 2) {
                            if (D == null) {
                                D = new IdentifierIdObserver(O, 2, str);
                                context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/" + context.getPackageName()), false, D);
                            }
                        }
                    } else if (C == null) {
                        C = new IdentifierIdObserver(O, 1, str);
                        context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, C);
                    }
                } else if (B == null) {
                    B = new IdentifierIdObserver(O, 0, null);
                    context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, B);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
