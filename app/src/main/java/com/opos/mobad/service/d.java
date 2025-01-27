package com.opos.mobad.service;

import android.content.Context;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private static volatile d f23563a;

    /* renamed from: b */
    private Object f23564b = new Object();

    /* renamed from: c */
    private Context f23565c;

    private d() {
    }

    public static final d a() {
        d dVar = f23563a;
        if (dVar == null) {
            synchronized (d.class) {
                dVar = f23563a;
                if (dVar == null) {
                    dVar = new d();
                    f23563a = dVar;
                }
            }
        }
        return dVar;
    }

    public com.opos.cmn.func.b.b.e a(com.opos.cmn.func.b.b.d dVar) {
        return null;
    }

    public void a(Context context) {
        if (context == null) {
            return;
        }
        this.f23565c = context;
    }
}
