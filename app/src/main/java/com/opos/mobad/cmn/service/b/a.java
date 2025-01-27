package com.opos.mobad.cmn.service.b;

import android.content.Context;
import com.opos.cmn.an.j.b;
import com.opos.cmn.d.c;
import com.opos.cmn.i.a;
import com.opos.mobad.e.a.j;
import com.opos.mobad.e.a.m;
import com.opos.mobad.e.a.n;
import com.opos.mobad.service.i.d;
import java.io.File;
import java.util.Map;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static volatile a f20329a;

    /* renamed from: b */
    private Context f20330b;

    /* renamed from: c */
    private com.opos.cmn.i.a f20331c = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.cmn.service.b.a.1
        AnonymousClass1() {
        }

        @Override // com.opos.cmn.i.a.b
        public void a(a.InterfaceC0395a interfaceC0395a) {
            a aVar = a.this;
            aVar.a(c.a(aVar.f20330b));
        }
    }, Integer.MAX_VALUE, Integer.MAX_VALUE);

    /* renamed from: com.opos.mobad.cmn.service.b.a$1 */
    class AnonymousClass1 implements a.b {
        AnonymousClass1() {
        }

        @Override // com.opos.cmn.i.a.b
        public void a(a.InterfaceC0395a interfaceC0395a) {
            a aVar = a.this;
            aVar.a(c.a(aVar.f20330b));
        }
    }

    /* renamed from: com.opos.mobad.cmn.service.b.a$2 */
    static final class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ File f20333a;

        AnonymousClass2(File file) {
            file = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.d(file);
                com.opos.cmn.an.f.a.b("interaction", "clear succ");
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("", "clear temp fail", e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.cmn.service.b.a$a */
    private static class C0436a implements j {
        @Override // com.opos.mobad.e.a.j
        public void a(Context context, String str, String str2, String str3) {
        }

        @Override // com.opos.mobad.e.a.j
        public void a(Context context, Map<String, String> map) {
            try {
                com.opos.cmn.an.f.a.b("interaction", "dy-mat report", map);
                d.a().a(map);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("interaction", "", (Throwable) e2);
            }
        }
    }

    private a() {
    }

    public static final a a() {
        a aVar;
        if (f20329a != null) {
            return f20329a;
        }
        synchronized (a.class) {
            aVar = f20329a;
            if (f20329a == null) {
                aVar = new a();
                f20329a = aVar;
            }
        }
        return aVar;
    }

    private File a(Context context, File file) {
        File file2 = new File(c.a(context));
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return new File(file2, b(file));
    }

    private String b(File file) {
        return file.getName() + "_" + System.currentTimeMillis();
    }

    private static void c(File file) {
        b.c(new Runnable() { // from class: com.opos.mobad.cmn.service.b.a.2

            /* renamed from: a */
            final /* synthetic */ File f20333a;

            AnonymousClass2(File file2) {
                file = file2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.d(file);
                    com.opos.cmn.an.f.a.b("interaction", "clear succ");
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b("", "clear temp fail", e2);
                }
            }
        });
    }

    public static void d(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles.length > 0) {
                for (File file2 : listFiles) {
                    d(file2);
                }
            }
        }
        file.delete();
    }

    public File a(Context context, String str) {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        File a2 = a(context, file);
        if (a2.exists()) {
            return a2;
        }
        a2.mkdirs();
        return a2;
    }

    public void a(Context context, String str, String str2) {
        this.f20330b = context;
        this.f20331c.a();
        n.a(context.getApplicationContext(), str, str2, new m.a().a(new C0436a()).a());
    }

    public void a(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                File file2 = new File(str + "_dirty");
                if (file2.exists()) {
                    com.opos.cmn.an.f.a.b("interaction", "rn but exists");
                } else if (!file.renameTo(file2)) {
                    com.opos.cmn.an.f.a.b("interaction", "rn fail");
                    return;
                }
                c(file2);
            }
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.b("interaction", "clear temp fail", th);
        }
    }
}
