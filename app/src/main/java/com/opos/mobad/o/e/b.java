package com.opos.mobad.o.e;

import android.content.Context;
import com.opos.mobad.c.a;
import com.opos.mobad.d.d;
import com.opos.mobad.n.a;
import com.opos.mobad.n.a.m;
import com.opos.mobad.n.g.aj;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private static b f23113a;

    /* renamed from: b */
    private com.opos.mobad.n.b f23114b;

    /* renamed from: c */
    private com.opos.mobad.c.a f23115c = new com.opos.mobad.c.a() { // from class: com.opos.mobad.o.e.b.1
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.c.a
        public void a(String str, String str2, int i2, int i3, a.InterfaceC0426a interfaceC0426a) {
            d.a().a(str, str2, i2, i3, interfaceC0426a);
        }
    };

    /* renamed from: com.opos.mobad.o.e.b$1 */
    class AnonymousClass1 implements com.opos.mobad.c.a {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.c.a
        public void a(String str, String str2, int i2, int i3, a.InterfaceC0426a interfaceC0426a) {
            d.a().a(str, str2, i2, i3, interfaceC0426a);
        }
    }

    private b() {
    }

    private static aj a(Context context) {
        int b2 = com.opos.cmn.an.h.f.a.b(context);
        double d2 = b2;
        Double.isNaN(d2);
        return new aj(b2, (int) (d2 * 0.6d));
    }

    public static final b a() {
        b bVar = f23113a;
        if (bVar == null) {
            synchronized (b.class) {
                bVar = f23113a;
                if (bVar == null) {
                    bVar = new b();
                    f23113a = bVar;
                }
            }
        }
        return bVar;
    }

    public static final boolean a(int i2) {
        if (i2 != 5 && i2 != 48 && i2 != 7 && i2 != 8 && i2 != 9) {
            switch (i2) {
                default:
                    switch (i2) {
                        case 50:
                        case 51:
                        case 52:
                            break;
                        default:
                            return false;
                    }
                case 12:
                case 13:
                case 14:
                case 15:
                    return true;
            }
        }
        return true;
    }

    private static final m b(int i2) {
        switch (i2) {
            case 54:
            case 57:
            case 60:
            case 63:
            case 66:
            case 69:
            case 72:
            case 75:
                return m.SPLASH;
            case 55:
            case 58:
            case 61:
            case 64:
            case 67:
            case 70:
            case 73:
            case 76:
                return m.BREATH;
            case 56:
            case 59:
            case 62:
            case 65:
            case 68:
            case 71:
            case 74:
            case 77:
                return m.SHAKE;
            default:
                return m.NONE;
        }
    }

    private int c(int i2) {
        if (i2 != 2) {
            return i2 != 3 ? 1 : 2;
        }
        return 3;
    }

    public final com.opos.mobad.n.a a(Context context, int i2, int i3, a.InterfaceC0458a interfaceC0458a) {
        return a(context, i2, i3, interfaceC0458a, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0300  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.opos.mobad.n.a a(android.content.Context r4, int r5, int r6, com.opos.mobad.n.a.InterfaceC0458a r7, int r8) {
        /*
            Method dump skipped, instructions count: 1150
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.o.e.b.a(android.content.Context, int, int, com.opos.mobad.n.a$a, int):com.opos.mobad.n.a");
    }

    public void a(com.opos.mobad.n.b bVar) {
        this.f23114b = bVar;
    }

    public final com.opos.mobad.n.a b(Context context, int i2, int i3, a.InterfaceC0458a interfaceC0458a) {
        return a(context, i2, i3, interfaceC0458a, 1);
    }
}
