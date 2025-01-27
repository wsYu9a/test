package com.tencent.open.a;

import com.tencent.open.a.d;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private static SimpleDateFormat f23136a = d.C0660d.a("yy.MM.dd.HH");

    /* renamed from: g */
    private File f23142g;

    /* renamed from: b */
    private String f23137b = "Tracer.File";

    /* renamed from: c */
    private int f23138c = Integer.MAX_VALUE;

    /* renamed from: d */
    private int f23139d = Integer.MAX_VALUE;

    /* renamed from: e */
    private int f23140e = 4096;

    /* renamed from: f */
    private long f23141f = 10000;

    /* renamed from: h */
    private int f23143h = 10;

    /* renamed from: i */
    private String f23144i = ".log";

    /* renamed from: j */
    private long f23145j = Long.MAX_VALUE;

    public b(File file, int i10, int i11, int i12, String str, long j10, int i13, String str2, long j11) {
        a(file);
        b(i10);
        a(i11);
        c(i12);
        a(str);
        a(j10);
        d(i13);
        b(str2);
        b(j11);
    }

    private File c(long j10) {
        File b10 = b();
        try {
            return new File(b10, c(d(j10)));
        } catch (Throwable th2) {
            th2.printStackTrace();
            return b10;
        }
    }

    private String d(long j10) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        return new SimpleDateFormat("yy.MM.dd.HH").format(calendar.getTime());
    }

    public File a() {
        return c(System.currentTimeMillis());
    }

    public File b() {
        File e10 = e();
        e10.mkdirs();
        return e10;
    }

    public File e() {
        return this.f23142g;
    }

    public int f() {
        return this.f23143h;
    }

    public void a(String str) {
        this.f23137b = str;
    }

    public void a(int i10) {
        this.f23138c = i10;
    }

    public void b(int i10) {
        this.f23139d = i10;
    }

    public void a(long j10) {
        this.f23141f = j10;
    }

    public void b(String str) {
        this.f23144i = str;
    }

    private String c(String str) {
        return "com.tencent.mobileqq_connectSdk." + str + ".log";
    }

    public void a(File file) {
        this.f23142g = file;
    }

    public void b(long j10) {
        this.f23145j = j10;
    }

    public int d() {
        return this.f23140e;
    }

    public String c() {
        return this.f23137b;
    }

    public void d(int i10) {
        this.f23143h = i10;
    }

    public void c(int i10) {
        this.f23140e = i10;
    }
}
