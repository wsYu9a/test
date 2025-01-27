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
    public static boolean f25028a = true;

    /* renamed from: b */
    private static SimpleDateFormat f25029b = null;

    /* renamed from: c */
    public static boolean f25030c = true;

    /* renamed from: d */
    private static int f25031d = 30720;

    /* renamed from: e */
    private static StringBuilder f25032e = null;

    /* renamed from: f */
    private static StringBuilder f25033f = null;

    /* renamed from: g */
    private static boolean f25034g = false;

    /* renamed from: h */
    private static a f25035h = null;

    /* renamed from: i */
    private static String f25036i = null;

    /* renamed from: j */
    private static String f25037j = null;
    private static Context k = null;
    private static String l = null;
    private static boolean m = false;
    private static boolean n = false;
    private static ExecutorService o;
    private static int p;
    private static final Object q = new Object();

    public static class a {

        /* renamed from: a */
        private boolean f25038a;

        /* renamed from: b */
        private File f25039b;

        /* renamed from: c */
        private String f25040c;

        /* renamed from: d */
        private long f25041d;

        /* renamed from: e */
        private long f25042e = 30720;

        public a(String str) {
            if (str == null || str.equals("")) {
                return;
            }
            this.f25040c = str;
            this.f25038a = a();
        }

        public boolean a() {
            try {
                File file = new File(this.f25040c);
                this.f25039b = file;
                if (file.exists() && !this.f25039b.delete()) {
                    this.f25038a = false;
                    return false;
                }
                if (this.f25039b.createNewFile()) {
                    return true;
                }
                this.f25038a = false;
                return false;
            } catch (Throwable th) {
                X.b(th);
                this.f25038a = false;
                return false;
            }
        }

        public boolean a(String str) {
            FileOutputStream fileOutputStream;
            if (!this.f25038a) {
                return false;
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(this.f25039b, true);
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(str.getBytes("UTF-8"));
                fileOutputStream.flush();
                fileOutputStream.close();
                this.f25041d += r10.length;
                this.f25038a = true;
                try {
                    fileOutputStream.close();
                } catch (IOException unused) {
                }
                return true;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                try {
                    X.b(th);
                    this.f25038a = false;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return false;
                } catch (Throwable th3) {
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    static {
        try {
            f25029b = new SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (Throwable th) {
            X.a(th.getCause());
        }
    }

    public static synchronized void c(String str, String str2, String str3) {
        synchronized (ba.class) {
            if (m && f25030c) {
                try {
                    if (n) {
                        o.execute(new Z(str, str2, str3));
                    } else {
                        o.execute(new aa(str, str2, str3));
                    }
                } catch (Exception e2) {
                    X.a(e2);
                }
            }
        }
    }

    private static String d() {
        com.tencent.bugly.crashreport.b bVar;
        try {
            com.tencent.bugly.crashreport.common.info.a m2 = com.tencent.bugly.crashreport.common.info.a.m();
            if (m2 == null || (bVar = m2.pa) == null) {
                return null;
            }
            return bVar.getLogFromNative();
        } catch (Throwable th) {
            if (X.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    private static synchronized void e(String str, String str2, String str3) {
        synchronized (ba.class) {
            String a2 = a(str, str2, str3, Process.myTid());
            synchronized (q) {
                try {
                    f25033f.append(a2);
                    if (f25033f.length() >= f25031d) {
                        StringBuilder sb = f25033f;
                        f25033f = sb.delete(0, sb.indexOf("\u0001\r\n") + 1);
                    }
                } finally {
                }
            }
        }
    }

    public static boolean f(String str, String str2, String str3) {
        com.tencent.bugly.crashreport.b bVar;
        try {
            com.tencent.bugly.crashreport.common.info.a m2 = com.tencent.bugly.crashreport.common.info.a.m();
            if (m2 == null || (bVar = m2.pa) == null) {
                return false;
            }
            return bVar.appendLogToNative(str, str2, str3);
        } catch (Throwable th) {
            if (X.b(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    private static synchronized void g(String str, String str2, String str3) {
        synchronized (ba.class) {
            String a2 = a(str, str2, str3, Process.myTid());
            synchronized (q) {
                try {
                    f25033f.append(a2);
                } catch (Throwable unused) {
                }
                if (f25033f.length() <= f25031d) {
                    return;
                }
                if (f25034g) {
                    return;
                }
                f25034g = true;
                a aVar = f25035h;
                if (aVar == null) {
                    f25035h = new a(l);
                } else if (aVar.f25039b == null || f25035h.f25039b.length() + f25033f.length() > f25035h.f25042e) {
                    f25035h.a();
                }
                if (f25035h.a(f25033f.toString())) {
                    f25033f.setLength(0);
                    f25034g = false;
                }
            }
        }
    }

    public static synchronized void a(Context context) {
        synchronized (ba.class) {
            if (m || context == null || !f25030c) {
                return;
            }
            try {
                o = Executors.newSingleThreadExecutor();
                f25033f = new StringBuilder(0);
                f25032e = new StringBuilder(0);
                k = context;
                f25036i = com.tencent.bugly.crashreport.common.info.a.a(context).f24755h;
                f25037j = "";
                StringBuilder sb = new StringBuilder();
                sb.append(k.getFilesDir().getPath());
                sb.append("/");
                sb.append("buglylog_");
                sb.append(f25036i);
                sb.append("_");
                sb.append(f25037j);
                sb.append(com.martian.mibook.lib.local.c.b.b.f13935b);
                l = sb.toString();
                p = Process.myPid();
            } catch (Throwable unused) {
            }
            m = true;
        }
    }

    public static byte[] b() {
        return f25028a ? a() : c();
    }

    public static byte[] c() {
        if (!f25030c) {
            return null;
        }
        if (n) {
            X.c("[LogUtil] Get user log from native.", new Object[0]);
            String d2 = d();
            if (d2 != null) {
                X.c("[LogUtil] Got user log from native: %d bytes", Integer.valueOf(d2.length()));
                return ca.a((File) null, d2, "BuglyNativeLog.txt");
            }
        }
        StringBuilder sb = new StringBuilder();
        synchronized (q) {
            a aVar = f25035h;
            if (aVar != null && aVar.f25038a && f25035h.f25039b != null && f25035h.f25039b.length() > 0) {
                sb.append(ca.a(f25035h.f25039b, 30720, true));
            }
            StringBuilder sb2 = f25033f;
            if (sb2 != null && sb2.length() > 0) {
                sb.append(f25033f.toString());
            }
        }
        return ca.a((File) null, sb.toString(), "BuglyLog.txt");
    }

    public static synchronized void d(String str, String str2, String str3) {
        synchronized (ba.class) {
            if (f25028a) {
                e(str, str2, str3);
            } else {
                g(str, str2, str3);
            }
        }
    }

    public static void a(int i2) {
        synchronized (q) {
            f25031d = i2;
            if (i2 < 0) {
                f25031d = 0;
            } else if (i2 > 30720) {
                f25031d = 30720;
            }
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (th == null) {
            return;
        }
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        c(str, str2, message + '\n' + ca.a(th));
    }

    private static String a(String str, String str2, String str3, long j2) {
        String date;
        f25032e.setLength(0);
        if (str3.length() > 30720) {
            str3 = str3.substring(str3.length() - 30720, str3.length() - 1);
        }
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat = f25029b;
        if (simpleDateFormat != null) {
            date = simpleDateFormat.format(date2);
        } else {
            date = date2.toString();
        }
        StringBuilder sb = f25032e;
        sb.append(date);
        sb.append(" ");
        sb.append(p);
        sb.append(" ");
        sb.append(j2);
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        sb.append(": ");
        sb.append(str3);
        sb.append("\u0001\r\n");
        return f25032e.toString();
    }

    public static byte[] a() {
        if (f25030c) {
            return ca.a((File) null, f25033f.toString(), "BuglyLog.txt");
        }
        return null;
    }
}
