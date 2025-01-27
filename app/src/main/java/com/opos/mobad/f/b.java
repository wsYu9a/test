package com.opos.mobad.f;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.opos.mobad.ad.c;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private static final String f20790a = "b";

    /* renamed from: d */
    private Handler f20793d;

    /* renamed from: b */
    private HashMap<Integer, com.opos.mobad.ad.c> f20791b = new HashMap<>();

    /* renamed from: c */
    private HashMap<Integer, Boolean> f20792c = new HashMap<>();

    /* renamed from: e */
    private boolean f20794e = false;

    /* renamed from: com.opos.mobad.f.b$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f20795a;

        /* renamed from: b */
        final /* synthetic */ com.opos.mobad.service.a.e f20796b;

        /* renamed from: c */
        final /* synthetic */ boolean f20797c;

        AnonymousClass1(Context context, com.opos.mobad.service.a.e eVar, boolean z) {
            context = context;
            eVar = eVar;
            z = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.b(context, eVar, z);
        }
    }

    private void a(Context context) {
        if (this.f20793d != null) {
            return;
        }
        synchronized (this) {
            if (this.f20793d == null) {
                this.f20793d = new Handler(context.getMainLooper());
            }
        }
    }

    private boolean a(int i2, String str) {
        if (i2 == 3 && !TextUtils.isEmpty(str)) {
            return "1200431650".equals(str);
        }
        return false;
    }

    public void b(Context context, com.opos.mobad.service.a.e eVar, boolean z) {
        com.opos.cmn.an.f.a.b("DispatchController", "initCreatorIfNeed done");
        com.opos.cmn.an.f.a.a(f20790a, "init creator size:" + this.f20791b.size() + ".CreateMap:" + this.f20791b.toString());
        String str = context.getApplicationInfo().name;
        if (TextUtils.isEmpty(str)) {
            str = context.getPackageName();
        }
        boolean z2 = true;
        for (Integer num : this.f20791b.keySet()) {
            String b2 = eVar.b(num.intValue());
            String c2 = eVar.c(num.intValue());
            com.opos.mobad.ad.c cVar = this.f20791b.get(num);
            com.opos.cmn.an.f.a.a(f20790a, "init creator channelAppId:" + b2);
            if ((!TextUtils.isEmpty(b2) || num.intValue() == 7) && com.opos.mobad.service.f.b().a(num.intValue()) && !a(num.intValue(), b2)) {
                this.f20792c.put(num, Boolean.TRUE);
                cVar.a(context, b2, str, c2, z);
            } else {
                z2 = false;
            }
        }
        this.f20794e = z2;
    }

    public int a(int i2) {
        if (!this.f20792c.containsKey(Integer.valueOf(i2))) {
            return 2;
        }
        if (com.opos.mobad.service.f.b().a(i2)) {
            return this.f20792c.get(Integer.valueOf(i2)).booleanValue() ? 0 : 1;
        }
        return 3;
    }

    c.a a(Context context, Integer num, com.opos.mobad.ad.c cVar) {
        c.a a2;
        synchronized (this) {
            if (this.f20791b.containsKey(num)) {
                a2 = new c.a(true, "");
            } else {
                a2 = cVar.a(context);
                if (a2 == null) {
                    com.opos.cmn.an.f.a.c(f20790a, "creator check null:" + num);
                    a2 = new c.a(false, "unknown error");
                } else if (a2.f19473a) {
                    this.f20791b.put(num, cVar);
                    this.f20792c.put(num, Boolean.FALSE);
                } else {
                    com.opos.cmn.an.f.a.d(f20790a, "error:" + a2.f19474b);
                }
            }
        }
        return a2;
    }

    void a(Context context, com.opos.mobad.service.a.e eVar, boolean z) {
        com.opos.cmn.an.f.a.b("DispatchController", "initCreatorIfNeed");
        if (context.getMainLooper().getThread() == Thread.currentThread()) {
            b(context, eVar, z);
        } else {
            a(context);
            this.f20793d.post(new Runnable() { // from class: com.opos.mobad.f.b.1

                /* renamed from: a */
                final /* synthetic */ Context f20795a;

                /* renamed from: b */
                final /* synthetic */ com.opos.mobad.service.a.e f20796b;

                /* renamed from: c */
                final /* synthetic */ boolean f20797c;

                AnonymousClass1(Context context2, com.opos.mobad.service.a.e eVar2, boolean z2) {
                    context = context2;
                    eVar = eVar2;
                    z = z2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    b.this.b(context, eVar, z);
                }
            });
        }
    }

    boolean a() {
        return this.f20791b.containsKey(1);
    }

    public com.opos.mobad.ad.c b(int i2) {
        return this.f20791b.get(Integer.valueOf(i2));
    }

    public void b() {
        synchronized (this) {
            Iterator<Integer> it = this.f20791b.keySet().iterator();
            while (it.hasNext()) {
                this.f20791b.get(it.next()).b();
            }
        }
    }
}
