package com.opos.mobad.cmn.service.a;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.d.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static volatile a f20320a;

    /* renamed from: b */
    private static final byte[] f20321b = new byte[0];

    /* renamed from: c */
    private Context f20322c;

    /* renamed from: d */
    private final int f20323d = 100;

    /* renamed from: e */
    private Map<Integer, C0435a> f20324e = new ConcurrentHashMap();

    /* renamed from: com.opos.mobad.cmn.service.a.a$a */
    class C0435a implements e {

        /* renamed from: b */
        private c f20326b;

        public C0435a(c cVar) {
            this.f20326b = cVar;
        }

        @Override // com.opos.mobad.d.e
        public void a(int i2, int i3, String str, String str2) {
            c cVar = this.f20326b;
            if (cVar != null) {
                cVar.a(i2, i3, str, str2);
            }
        }

        @Override // com.opos.mobad.d.e
        public void a(int i2, int i3, String str, String str2, String str3) {
            c cVar = this.f20326b;
            if (cVar != null) {
                cVar.a(i2, i3, str, str2, str3);
            }
        }

        @Override // com.opos.mobad.d.e
        public void b(int i2, int i3, String str, String str2) {
            c cVar = this.f20326b;
            if (cVar != null) {
                cVar.b(i2, i3, str, str2);
            }
        }

        @Override // com.opos.mobad.d.e
        public void c(int i2, int i3, String str, String str2) {
            c cVar = this.f20326b;
            if (cVar != null) {
                cVar.c(i2, i3, str, str2);
            }
        }

        @Override // com.opos.mobad.d.e
        public void d(int i2, int i3, String str, String str2) {
            c cVar = this.f20326b;
            if (cVar != null) {
                cVar.d(i2, i3, str, str2);
            }
        }

        @Override // com.opos.mobad.d.e
        public void e(int i2, int i3, String str, String str2) {
            c cVar = this.f20326b;
            if (cVar != null) {
                cVar.e(i2, i3, str, str2);
                a.this.f20324e.remove(Integer.valueOf(this.f20326b.hashCode()));
            }
        }

        @Override // com.opos.mobad.d.e
        public void f(int i2, int i3, String str, String str2) {
            c cVar = this.f20326b;
            if (cVar != null) {
                cVar.f(i2, i3, str, str2);
            }
        }
    }

    private a(Context context) {
        this.f20322c = context.getApplicationContext();
    }

    public static a a(Context context) {
        a aVar = f20320a;
        if (aVar == null) {
            synchronized (f20321b) {
                aVar = f20320a;
                if (aVar == null) {
                    aVar = new a(context);
                    f20320a = aVar;
                }
            }
        }
        return aVar;
    }

    public b a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (com.opos.cmn.an.d.b.a.a(com.opos.cmn.d.a.a(this.f20322c, str))) {
            return new b(105, 100);
        }
        int[] a2 = com.opos.mobad.d.b.a(this.f20322c).a(str, str2);
        return new b(a2[0], a2[1]);
    }

    public void a() {
        com.opos.mobad.d.b.a(this.f20322c).a();
    }

    public void a(int i2, boolean z) {
        com.opos.mobad.d.b.a(this.f20322c).a(i2, z);
    }

    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        com.opos.mobad.d.b.a(this.f20322c).a(this.f20324e.remove(Integer.valueOf(cVar.hashCode())));
    }

    public void a(String str) {
        com.opos.mobad.d.b.a(this.f20322c).a(str);
    }

    public void a(String str, String str2, String str3, String str4, c cVar) {
        C0435a c0435a;
        if (cVar != null) {
            c0435a = new C0435a(cVar);
            this.f20324e.put(Integer.valueOf(cVar.hashCode()), c0435a);
        } else {
            c0435a = null;
        }
        com.opos.mobad.d.b.a(this.f20322c).a(str, str2, str3, str4, c0435a);
    }

    public void b(String str) {
        com.opos.mobad.d.b.a(this.f20322c).b(str);
    }

    public void c(String str) {
        com.opos.mobad.d.b.a(this.f20322c).c(str);
    }
}
