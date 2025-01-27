package com.kuaishou.weapon.p0;

import android.os.Build;

/* loaded from: classes2.dex */
public class cq {

    /* renamed from: a */
    static cq f10952a;

    /* renamed from: b */
    static cq f10953b;

    /* renamed from: c */
    static cq f10954c;

    /* renamed from: d */
    private long f10955d;

    /* renamed from: e */
    private a f10956e;

    public enum a {
        DWORD(4),
        QWORD(8);


        /* renamed from: c */
        int f10960c;

        a(int i10) {
            this.f10960c = i10;
        }
    }

    static {
        c();
    }

    private static void c() {
        f10952a = new cq();
        f10953b = new cq();
        f10954c = new cq();
        cq cqVar = f10953b;
        a aVar = a.DWORD;
        cqVar.a(aVar);
        int i10 = Build.VERSION.SDK_INT;
        if (cr.a()) {
            cq cqVar2 = f10952a;
            a aVar2 = a.QWORD;
            cqVar2.a(aVar2);
            f10954c.a(aVar2);
            switch (i10) {
                case 21:
                    f10952a.a(40L);
                    f10952a.a(aVar2);
                    f10954c.a(32L);
                    f10954c.a(aVar2);
                    f10953b.a(56L);
                    return;
                case 22:
                    f10952a.a(52L);
                    f10954c.a(44L);
                    f10953b.a(20L);
                    return;
                case 23:
                    f10952a.a(48L);
                    f10954c.a(40L);
                    f10953b.a(12L);
                    return;
                case 24:
                case 25:
                    f10952a.a(48L);
                    f10954c.a(40L);
                    f10953b.a(4L);
                    return;
                case 26:
                case 27:
                    f10952a.a(40L);
                    f10954c.a(32L);
                    f10953b.a(4L);
                    return;
                case 28:
                case 29:
                    f10952a.a(32L);
                    f10954c.a(24L);
                    f10953b.a(4L);
                    return;
                default:
                    throw new RuntimeException("API LEVEL: " + i10 + " is not supported now : (");
            }
        }
        f10952a.a(aVar);
        f10954c.a(aVar);
        switch (i10) {
            case 21:
                f10952a.a(40L);
                cq cqVar3 = f10952a;
                a aVar3 = a.QWORD;
                cqVar3.a(aVar3);
                f10954c.a(32L);
                f10954c.a(aVar3);
                f10953b.a(56L);
                return;
            case 22:
                f10952a.a(44L);
                f10954c.a(40L);
                f10953b.a(20L);
                return;
            case 23:
                f10952a.a(36L);
                f10954c.a(32L);
                f10953b.a(12L);
                return;
            case 24:
            case 25:
                f10952a.a(32L);
                f10954c.a(28L);
                f10953b.a(4L);
                return;
            case 26:
            case 27:
                f10952a.a(28L);
                f10954c.a(24L);
                f10953b.a(4L);
                return;
            case 28:
            case 29:
                f10952a.a(24L);
                f10954c.a(20L);
                f10953b.a(4L);
                return;
            default:
                throw new RuntimeException("API LEVEL: " + i10 + " is not supported now : (");
        }
    }

    public long a() {
        return this.f10955d;
    }

    public a b() {
        return this.f10956e;
    }

    public void a(long j10) {
        this.f10955d = j10;
    }

    public void a(a aVar) {
        this.f10956e = aVar;
    }
}
