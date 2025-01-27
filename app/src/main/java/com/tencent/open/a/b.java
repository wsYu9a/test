package com.tencent.open.a;

import com.tencent.open.a.d;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private static SimpleDateFormat f25407a = d.C0531d.a("yy.MM.dd.HH");

    /* renamed from: g */
    private File f25413g;

    /* renamed from: b */
    private String f25408b = "Tracer.File";

    /* renamed from: c */
    private int f25409c = Integer.MAX_VALUE;

    /* renamed from: d */
    private int f25410d = Integer.MAX_VALUE;

    /* renamed from: e */
    private int f25411e = 4096;

    /* renamed from: f */
    private long f25412f = 10000;

    /* renamed from: h */
    private int f25414h = 10;

    /* renamed from: i */
    private String f25415i = ".log";

    /* renamed from: j */
    private long f25416j = Long.MAX_VALUE;

    public b(File file, int i2, int i3, int i4, String str, long j2, int i5, String str2, long j3) {
        a(file);
        b(i2);
        a(i3);
        c(i4);
        a(str);
        a(j2);
        d(i5);
        b(str2);
        b(j3);
    }

    private File c(long j2) {
        File b2 = b();
        try {
            return new File(b2, c(d(j2)));
        } catch (Throwable th) {
            th.printStackTrace();
            return b2;
        }
    }

    private String d(long j2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j2);
        return new SimpleDateFormat("yy.MM.dd.HH").format(calendar.getTime());
    }

    public File a() {
        return c(System.currentTimeMillis());
    }

    public File b() {
        File e2 = e();
        e2.mkdirs();
        return e2;
    }

    public File e() {
        return this.f25413g;
    }

    public int f() {
        return this.f25414h;
    }

    public void a(String str) {
        this.f25408b = str;
    }

    public void a(int i2) {
        this.f25409c = i2;
    }

    public void b(int i2) {
        this.f25410d = i2;
    }

    public void a(long j2) {
        this.f25412f = j2;
    }

    public void b(String str) {
        this.f25415i = str;
    }

    private String c(String str) {
        return "com.tencent.mobileqq_connectSdk." + str + ".log";
    }

    public void a(File file) {
        this.f25413g = file;
    }

    public void b(long j2) {
        this.f25416j = j2;
    }

    public int d() {
        return this.f25411e;
    }

    public String c() {
        return this.f25408b;
    }

    public void d(int i2) {
        this.f25414h = i2;
    }

    public void c(int i2) {
        this.f25411e = i2;
    }
}
