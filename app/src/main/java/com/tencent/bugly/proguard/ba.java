package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes4.dex */
public class ba {

    /* renamed from: a */
    public static boolean f22688a = true;

    /* renamed from: b */
    private static SimpleDateFormat f22689b = null;

    /* renamed from: c */
    public static boolean f22690c = true;

    /* renamed from: d */
    private static int f22691d = 30720;

    /* renamed from: e */
    private static StringBuilder f22692e = null;

    /* renamed from: f */
    private static StringBuilder f22693f = null;

    /* renamed from: g */
    private static boolean f22694g = false;

    /* renamed from: h */
    private static a f22695h = null;

    /* renamed from: i */
    private static String f22696i = null;

    /* renamed from: j */
    private static String f22697j = null;

    /* renamed from: k */
    private static Context f22698k = null;

    /* renamed from: l */
    private static String f22699l = null;

    /* renamed from: m */
    private static boolean f22700m = false;

    /* renamed from: n */
    private static boolean f22701n = false;

    /* renamed from: o */
    private static ExecutorService f22702o;

    /* renamed from: p */
    private static int f22703p;

    /* renamed from: q */
    private static final Object f22704q = new Object();

    public static class a {

        /* renamed from: a */
        private boolean f22705a;

        /* renamed from: b */
        private File f22706b;

        /* renamed from: c */
        private String f22707c;

        /* renamed from: d */
        private long f22708d;

        /* renamed from: e */
        private long f22709e = 30720;

        public a(String str) {
            if (str == null || str.equals("")) {
                return;
            }
            this.f22707c = str;
            this.f22705a = a();
        }

        public boolean a() {
            try {
                File file = new File(this.f22707c);
                this.f22706b = file;
                if (file.exists() && !this.f22706b.delete()) {
                    this.f22705a = false;
                    return false;
                }
                if (this.f22706b.createNewFile()) {
                    return true;
                }
                this.f22705a = false;
                return false;
            } catch (Throwable th2) {
                X.b(th2);
                this.f22705a = false;
                return false;
            }
        }

        public boolean a(String str) {
            FileOutputStream fileOutputStream;
            if (!this.f22705a) {
                return false;
            }
            try {
                fileOutputStream = new FileOutputStream(this.f22706b, true);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
            try {
                fileOutputStream.write(str.getBytes("UTF-8"));
                fileOutputStream.flush();
                fileOutputStream.close();
                this.f22708d += r9.length;
                this.f22705a = true;
                try {
                    fileOutputStream.close();
                } catch (IOException unused) {
                }
                return true;
            } catch (Throwable th3) {
                th = th3;
                try {
                    X.b(th);
                    this.f22705a = false;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return false;
                } catch (Throwable th4) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th4;
                }
            }
        }
    }

    static {
        try {
            f22689b = new SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (Throwable th2) {
            X.a(th2.getCause());
        }
    }

    public static synchronized void c(String str, String str2, String str3) {
        synchronized (ba.class) {
            try {
                if (f22700m && f22690c) {
                    try {
                        if (f22701n) {
                            f22702o.execute(new Z(str, str2, str3));
                        } else {
                            f22702o.execute(new aa(str, str2, str3));
                        }
                    } catch (Exception e10) {
                        X.a(e10);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static String d() {
        com.tencent.bugly.crashreport.b bVar;
        try {
            com.tencent.bugly.crashreport.common.info.a m10 = com.tencent.bugly.crashreport.common.info.a.m();
            if (m10 == null || (bVar = m10.f22313pa) == null) {
                return null;
            }
            return bVar.getLogFromNative();
        } catch (Throwable th2) {
            if (X.b(th2)) {
                return null;
            }
            th2.printStackTrace();
            return null;
        }
    }

    private static synchronized void e(String str, String str2, String str3) {
        synchronized (ba.class) {
            String a10 = a(str, str2, str3, Process.myTid());
            synchronized (f22704q) {
                try {
                    f22693f.append(a10);
                    if (f22693f.length() >= f22691d) {
                        StringBuilder sb2 = f22693f;
                        f22693f = sb2.delete(0, sb2.indexOf("\u0001\r\n") + 1);
                    }
                } finally {
                    try {
                    } catch (Throwable th2) {
                    }
                }
            }
        }
    }

    public static boolean f(String str, String str2, String str3) {
        com.tencent.bugly.crashreport.b bVar;
        try {
            com.tencent.bugly.crashreport.common.info.a m10 = com.tencent.bugly.crashreport.common.info.a.m();
            if (m10 == null || (bVar = m10.f22313pa) == null) {
                return false;
            }
            return bVar.appendLogToNative(str, str2, str3);
        } catch (Throwable th2) {
            if (X.b(th2)) {
                return false;
            }
            th2.printStackTrace();
            return false;
        }
    }

    private static synchronized void g(String str, String str2, String str3) {
        synchronized (ba.class) {
            String a10 = a(str, str2, str3, Process.myTid());
            synchronized (f22704q) {
                try {
                    f22693f.append(a10);
                } catch (Throwable unused) {
                }
                if (f22693f.length() <= f22691d) {
                    return;
                }
                if (f22694g) {
                    return;
                }
                f22694g = true;
                a aVar = f22695h;
                if (aVar == null) {
                    f22695h = new a(f22699l);
                } else if (aVar.f22706b == null || f22695h.f22706b.length() + f22693f.length() > f22695h.f22709e) {
                    f22695h.a();
                }
                if (f22695h.a(f22693f.toString())) {
                    f22693f.setLength(0);
                    f22694g = false;
                }
            }
        }
    }

    public static synchronized void a(Context context) {
        synchronized (ba.class) {
            if (f22700m || context == null || !f22690c) {
                return;
            }
            try {
                f22702o = Executors.newSingleThreadExecutor();
                f22693f = new StringBuilder(0);
                f22692e = new StringBuilder(0);
                f22698k = context;
                f22696i = com.tencent.bugly.crashreport.common.info.a.a(context).f22296h;
                f22697j = "";
                StringBuilder sb2 = new StringBuilder();
                sb2.append(f22698k.getFilesDir().getPath());
                sb2.append("/");
                sb2.append("buglylog_");
                sb2.append(f22696i);
                sb2.append(hf.e.f26694a);
                sb2.append(f22697j);
                sb2.append(rb.b.f30387c);
                f22699l = sb2.toString();
                f22703p = Process.myPid();
            } catch (Throwable unused) {
            }
            f22700m = true;
        }
    }

    public static byte[] b() {
        return f22688a ? a() : c();
    }

    public static byte[] c() {
        if (!f22690c) {
            return null;
        }
        if (f22701n) {
            X.c("[LogUtil] Get user log from native.", new Object[0]);
            String d10 = d();
            if (d10 != null) {
                X.c("[LogUtil] Got user log from native: %d bytes", Integer.valueOf(d10.length()));
                return ca.a((File) null, d10, "BuglyNativeLog.txt");
            }
        }
        StringBuilder sb2 = new StringBuilder();
        synchronized (f22704q) {
            try {
                a aVar = f22695h;
                if (aVar != null && aVar.f22705a && f22695h.f22706b != null && f22695h.f22706b.length() > 0) {
                    sb2.append(ca.a(f22695h.f22706b, 30720, true));
                }
                StringBuilder sb3 = f22693f;
                if (sb3 != null && sb3.length() > 0) {
                    sb2.append(f22693f.toString());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return ca.a((File) null, sb2.toString(), "BuglyLog.txt");
    }

    public static synchronized void d(String str, String str2, String str3) {
        synchronized (ba.class) {
            try {
                if (f22688a) {
                    e(str, str2, str3);
                } else {
                    g(str, str2, str3);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void a(int i10) {
        synchronized (f22704q) {
            try {
                f22691d = i10;
                if (i10 < 0) {
                    f22691d = 0;
                } else if (i10 > 30720) {
                    f22691d = 30720;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void a(String str, String str2, Throwable th2) {
        if (th2 == null) {
            return;
        }
        String message = th2.getMessage();
        if (message == null) {
            message = "";
        }
        c(str, str2, message + '\n' + ca.a(th2));
    }

    private static String a(String str, String str2, String str3, long j10) {
        String date;
        f22692e.setLength(0);
        if (str3.length() > 30720) {
            str3 = str3.substring(str3.length() - 30720, str3.length() - 1);
        }
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat = f22689b;
        if (simpleDateFormat != null) {
            date = simpleDateFormat.format(date2);
        } else {
            date = date2.toString();
        }
        StringBuilder sb2 = f22692e;
        sb2.append(date);
        sb2.append(" ");
        sb2.append(f22703p);
        sb2.append(" ");
        sb2.append(j10);
        sb2.append(" ");
        sb2.append(str);
        sb2.append(" ");
        sb2.append(str2);
        sb2.append(": ");
        sb2.append(str3);
        sb2.append("\u0001\r\n");
        return f22692e.toString();
    }

    public static byte[] a() {
        if (f22690c) {
            return ca.a((File) null, f22693f.toString(), "BuglyLog.txt");
        }
        return null;
    }
}
