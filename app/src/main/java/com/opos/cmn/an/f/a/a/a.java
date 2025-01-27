package com.opos.cmn.an.f.a.a;

import android.util.Log;

/* loaded from: classes4.dex */
public class a implements b {

    /* renamed from: a */
    private com.opos.cmn.an.f.b.b f16409a;

    /* renamed from: b */
    private int f16410b = -1;

    private void a(int i2, String str, String str2) {
        if (i2 == 1) {
            Log.v(str, str2);
            return;
        }
        if (i2 == 2) {
            Log.d(str, str2);
            return;
        }
        if (i2 == 3) {
            Log.i(str, str2);
        } else if (i2 == 4) {
            Log.w(str, str2);
        } else {
            if (i2 != 5) {
                return;
            }
            Log.e(str, str2);
        }
    }

    @Override // com.opos.cmn.an.f.a.a.b
    public void a() {
    }

    @Override // com.opos.cmn.an.f.a.a.b
    public void a(int i2) {
        this.f16410b = i2;
    }

    @Override // com.opos.cmn.an.f.a.a.b
    public void a(com.opos.cmn.an.f.a.b.d dVar) {
        int i2;
        if (dVar == null || dVar.f16424b == null || dVar.f16423a == null) {
            return;
        }
        int i3 = dVar.f16426d;
        try {
            if (!com.opos.cmn.an.f.a.c.b() || (i2 = this.f16410b) == -1 || i3 < i2) {
                return;
            }
            String a2 = com.opos.cmn.an.f.c.b.a(dVar);
            if (a2.length() <= 3072) {
                a(i3, this.f16409a.f16450a, a2);
                return;
            }
            int length = a2.length();
            int i4 = 0;
            while (length > i4) {
                int i5 = i4 + 3072;
                if (length <= i5) {
                    i5 = length;
                }
                a(i3, this.f16409a.f16450a, a2.substring(i4, i5));
                i4 = i5;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.opos.cmn.an.f.a.a.b
    public void a(com.opos.cmn.an.f.b.b bVar) {
        int i2;
        this.f16409a = bVar;
        try {
            if (com.opos.cmn.an.f.c.b.a()) {
                com.opos.cmn.an.f.a.c.a();
                i2 = 1;
            } else {
                i2 = this.f16409a.f16452c;
            }
            this.f16410b = i2;
        } catch (Throwable unused) {
        }
    }

    @Override // com.opos.cmn.an.f.a.a.b
    public void a(com.opos.cmn.an.f.b.c cVar, com.opos.cmn.an.f.b.a aVar) {
        if (aVar != null) {
            aVar.onDontNeedUpload("basicLog cannot support upload log!");
        }
    }

    @Override // com.opos.cmn.an.f.a.a.b
    public void a(boolean z) {
    }
}
