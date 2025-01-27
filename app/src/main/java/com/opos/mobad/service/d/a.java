package com.opos.mobad.service.d;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.LruCache;
import com.opos.mobad.b.a.ae;
import com.opos.mobad.b.a.af;
import com.opos.mobad.service.h.b;
import java.io.IOException;
import okio.BufferedSource;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private Context f23566a;

    /* renamed from: b */
    private ae.a f23567b;

    /* renamed from: c */
    private LruCache<String, C0482a> f23568c = new LruCache<>(100);

    /* renamed from: com.opos.mobad.service.d.a$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f23569a;

        /* renamed from: com.opos.mobad.service.d.a$1$1 */
        class C04811 implements b.a<af> {
            C04811() {
            }

            @Override // com.opos.mobad.service.h.b.a
            /* renamed from: a */
            public af b(BufferedSource bufferedSource) throws IOException {
                return af.f19572c.a(bufferedSource);
            }
        }

        AnonymousClass1(String str) {
            str = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            T t;
            a aVar;
            String str;
            boolean z;
            b.C0487b a2 = com.opos.mobad.service.h.b.a(a.this.f23566a, "https://adx.ads.heytapmobi.com/show/frequency/req/check", a.this.f23567b.a(com.opos.mobad.service.h.a.a(a.this.f23566a)).a(com.opos.mobad.service.h.a.a()).a(com.opos.mobad.service.h.a.b()).a(com.opos.mobad.service.h.a.b(a.this.f23566a)).c(str).b().b(), new b.a<af>() { // from class: com.opos.mobad.service.d.a.1.1
                C04811() {
                }

                @Override // com.opos.mobad.service.h.b.a
                /* renamed from: a */
                public af b(BufferedSource bufferedSource) throws IOException {
                    return af.f19572c.a(bufferedSource);
                }
            });
            com.opos.cmn.an.f.a.b("StateManager", "refresh:" + a2.f23682a + "," + a2.f23684c);
            if (a2.f23682a != 200 || (t = a2.f23684c) == 0) {
                return;
            }
            if (((af) t).f19575f.intValue() == 0) {
                aVar = a.this;
                str = str;
                z = true;
            } else {
                if (((af) a2.f23684c).f19575f.intValue() != 1035) {
                    return;
                }
                aVar = a.this;
                str = str;
                z = false;
            }
            aVar.b(str, z, ((af) a2.f23684c).f19576g.intValue());
        }
    }

    /* renamed from: com.opos.mobad.service.d.a$a */
    private static class C0482a {

        /* renamed from: a */
        private final boolean f23572a;

        /* renamed from: b */
        private final long f23573b;

        public C0482a(boolean z, long j2) {
            this.f23572a = z;
            this.f23573b = j2;
        }
    }

    private void a(String str, C0482a c0482a) {
        if (c0482a == null || a(c0482a)) {
            b(str);
        }
    }

    private boolean a(C0482a c0482a) {
        return c0482a == null || SystemClock.elapsedRealtime() >= c0482a.f23573b;
    }

    private void b(String str) {
        if (this.f23567b == null || TextUtils.isEmpty("https://adx.ads.heytapmobi.com/show/frequency/req/check")) {
            return;
        }
        com.opos.cmn.an.j.b.b(new Runnable() { // from class: com.opos.mobad.service.d.a.1

            /* renamed from: a */
            final /* synthetic */ String f23569a;

            /* renamed from: com.opos.mobad.service.d.a$1$1 */
            class C04811 implements b.a<af> {
                C04811() {
                }

                @Override // com.opos.mobad.service.h.b.a
                /* renamed from: a */
                public af b(BufferedSource bufferedSource) throws IOException {
                    return af.f19572c.a(bufferedSource);
                }
            }

            AnonymousClass1(String str2) {
                str = str2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                T t;
                a aVar;
                String str2;
                boolean z;
                b.C0487b a2 = com.opos.mobad.service.h.b.a(a.this.f23566a, "https://adx.ads.heytapmobi.com/show/frequency/req/check", a.this.f23567b.a(com.opos.mobad.service.h.a.a(a.this.f23566a)).a(com.opos.mobad.service.h.a.a()).a(com.opos.mobad.service.h.a.b()).a(com.opos.mobad.service.h.a.b(a.this.f23566a)).c(str).b().b(), new b.a<af>() { // from class: com.opos.mobad.service.d.a.1.1
                    C04811() {
                    }

                    @Override // com.opos.mobad.service.h.b.a
                    /* renamed from: a */
                    public af b(BufferedSource bufferedSource) throws IOException {
                        return af.f19572c.a(bufferedSource);
                    }
                });
                com.opos.cmn.an.f.a.b("StateManager", "refresh:" + a2.f23682a + "," + a2.f23684c);
                if (a2.f23682a != 200 || (t = a2.f23684c) == 0) {
                    return;
                }
                if (((af) t).f19575f.intValue() == 0) {
                    aVar = a.this;
                    str2 = str;
                    z = true;
                } else {
                    if (((af) a2.f23684c).f19575f.intValue() != 1035) {
                        return;
                    }
                    aVar = a.this;
                    str2 = str;
                    z = false;
                }
                aVar.b(str2, z, ((af) a2.f23684c).f19576g.intValue());
            }
        });
    }

    public void b(String str, boolean z, int i2) {
        com.opos.cmn.an.f.a.b("StateManager", "update, " + str + ", " + z + "," + i2);
        this.f23568c.put(str, new C0482a(z, SystemClock.elapsedRealtime() + ((long) i2)));
    }

    public void a(Context context, String str, String str2, int i2, int i3) {
        synchronized (this) {
            if (context != null) {
                if (!TextUtils.isEmpty(str) && this.f23566a == null) {
                    this.f23566a = context;
                    this.f23567b = new ae.a().a(str).b(str2).a(Integer.valueOf(i2)).b(Integer.valueOf(i3)).d(context.getPackageName());
                }
            }
        }
    }

    public void a(String str, boolean z, int i2) {
        b(str, z, i2);
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        C0482a c0482a = this.f23568c.get(str);
        if (c0482a != null) {
            if (c0482a.f23572a) {
                a(str, c0482a);
                return true;
            }
            if (!a(c0482a)) {
                return false;
            }
        }
        b(str);
        return true;
    }
}
