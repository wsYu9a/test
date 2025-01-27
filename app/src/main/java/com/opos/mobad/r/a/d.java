package com.opos.mobad.r.a;

import android.content.Context;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private static final com.opos.mobad.n.j.a f23429a = new com.opos.mobad.n.j.a() { // from class: com.opos.mobad.r.a.d.1
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.j.a
        public com.opos.mobad.c.c.a a(Context context) {
            return new b(context, null);
        }
    };

    /* renamed from: b */
    private static final com.opos.mobad.n.j.a f23430b = new com.opos.mobad.n.j.a() { // from class: com.opos.mobad.r.a.d.2
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.n.j.a
        public com.opos.mobad.c.c.a a(Context context) {
            return new a(context, null);
        }
    };

    /* renamed from: com.opos.mobad.r.a.d$1 */
    static final class AnonymousClass1 implements com.opos.mobad.n.j.a {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.j.a
        public com.opos.mobad.c.c.a a(Context context) {
            return new b(context, null);
        }
    }

    /* renamed from: com.opos.mobad.r.a.d$2 */
    static final class AnonymousClass2 implements com.opos.mobad.n.j.a {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.n.j.a
        public com.opos.mobad.c.c.a a(Context context) {
            return new a(context, null);
        }
    }

    public static final com.opos.mobad.c.c.a a(Context context, int i2, com.opos.mobad.c.c.b bVar) {
        return 1 == i2 ? new b(context, bVar) : new a(context, bVar);
    }

    public static final com.opos.mobad.n.j.a a(int i2) {
        return 1 == i2 ? f23429a : f23430b;
    }
}
