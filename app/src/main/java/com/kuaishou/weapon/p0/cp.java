package com.kuaishou.weapon.p0;

import android.os.Build;

/* loaded from: classes.dex */
public class cp {

    /* renamed from: a */
    static cp f9216a;

    /* renamed from: b */
    static cp f9217b;

    /* renamed from: c */
    static cp f9218c;

    /* renamed from: d */
    private long f9219d;

    /* renamed from: e */
    private a f9220e;

    enum a {
        DWORD(4),
        QWORD(8);


        /* renamed from: c */
        int f9224c;

        a(int i2) {
            this.f9224c = i2;
        }
    }

    static {
        c();
    }

    private static void c() {
        f9216a = new cp();
        f9217b = new cp();
        f9218c = new cp();
        cp cpVar = f9217b;
        a aVar = a.DWORD;
        cpVar.a(aVar);
        int i2 = Build.VERSION.SDK_INT;
        if (cq.a()) {
            cp cpVar2 = f9216a;
            a aVar2 = a.QWORD;
            cpVar2.a(aVar2);
            f9218c.a(aVar2);
            switch (i2) {
                case 19:
                    f9216a.a(32L);
                    f9217b.a(28L);
                    return;
                case 20:
                default:
                    throw new RuntimeException("API LEVEL: " + i2 + " is not supported now : (");
                case 21:
                    f9216a.a(40L);
                    f9216a.a(aVar2);
                    f9218c.a(32L);
                    f9218c.a(aVar2);
                    f9217b.a(56L);
                    return;
                case 22:
                    f9216a.a(52L);
                    f9218c.a(44L);
                    f9217b.a(20L);
                    return;
                case 23:
                    f9216a.a(48L);
                    f9218c.a(40L);
                    f9217b.a(12L);
                    return;
                case 24:
                case 25:
                    f9216a.a(48L);
                    f9218c.a(40L);
                    f9217b.a(4L);
                    return;
                case 26:
                case 27:
                    f9216a.a(40L);
                    f9218c.a(32L);
                    f9217b.a(4L);
                    return;
                case 28:
                case 29:
                    f9216a.a(32L);
                    f9218c.a(24L);
                    f9217b.a(4L);
                    return;
            }
        }
        f9216a.a(aVar);
        f9218c.a(aVar);
        switch (i2) {
            case 19:
                f9216a.a(32L);
                f9217b.a(28L);
                return;
            case 20:
            default:
                throw new RuntimeException("API LEVEL: " + i2 + " is not supported now : (");
            case 21:
                f9216a.a(40L);
                cp cpVar3 = f9216a;
                a aVar3 = a.QWORD;
                cpVar3.a(aVar3);
                f9218c.a(32L);
                f9218c.a(aVar3);
                f9217b.a(56L);
                return;
            case 22:
                f9216a.a(44L);
                f9218c.a(40L);
                f9217b.a(20L);
                return;
            case 23:
                f9216a.a(36L);
                f9218c.a(32L);
                f9217b.a(12L);
                return;
            case 24:
            case 25:
                f9216a.a(32L);
                f9218c.a(28L);
                f9217b.a(4L);
                return;
            case 26:
            case 27:
                f9216a.a(28L);
                f9218c.a(24L);
                f9217b.a(4L);
                return;
            case 28:
            case 29:
                f9216a.a(24L);
                f9218c.a(20L);
                f9217b.a(4L);
                return;
        }
    }

    public long a() {
        return this.f9219d;
    }

    public void a(long j2) {
        this.f9219d = j2;
    }

    public void a(a aVar) {
        this.f9220e = aVar;
    }

    public a b() {
        return this.f9220e;
    }
}
