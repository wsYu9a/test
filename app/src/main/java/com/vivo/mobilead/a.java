package com.vivo.mobilead;

import android.app.Activity;
import com.vivo.mobilead.g.b;
import com.vivo.mobilead.util.g0;
import com.vivo.mobilead.util.l0;
import com.vivo.mobilead.util.x;
import java.util.HashMap;

/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a */
    protected Activity f28640a;

    /* renamed from: b */
    protected b f28641b;

    /* renamed from: c */
    protected String f28642c;

    /* renamed from: d */
    protected String f28643d = x.b();

    /* renamed from: e */
    protected String f28644e = x.b();

    /* renamed from: f */
    protected String f28645f;

    /* renamed from: g */
    protected HashMap<Integer, String> f28646g;

    public a(Activity activity, String str, com.vivo.mobilead.g.a aVar) {
        this.f28646g = new HashMap<>();
        this.f28640a = activity;
        this.f28642c = str;
        this.f28646g = g0.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l0 l0Var) {
        b bVar = this.f28641b;
        if (bVar != null) {
            bVar.a(l0Var);
        }
    }

    public void b(String str) {
        this.f28644e = str;
    }

    public void c(String str) {
        this.f28643d = str;
    }

    public void a(b bVar) {
        this.f28641b = bVar;
    }

    public void a(String str) {
        this.f28645f = str;
    }
}
