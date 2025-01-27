package com.shu.priory.f;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.shu.priory.f.a.f;
import com.shu.priory.f.c;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes3.dex */
public class d {

    /* renamed from: a */
    protected final Set<String> f17061a;

    /* renamed from: b */
    protected final c.b f17062b;

    /* renamed from: c */
    protected final c.a f17063c;

    /* renamed from: d */
    protected boolean f17064d;

    /* renamed from: e */
    protected boolean f17065e;

    /* renamed from: f */
    protected c.d f17066f;

    /* renamed from: com.shu.priory.f.d$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f17067a;

        /* renamed from: b */
        final /* synthetic */ String f17068b;

        /* renamed from: c */
        final /* synthetic */ String f17069c;

        /* renamed from: d */
        final /* synthetic */ c.InterfaceC0556c f17070d;

        public AnonymousClass1(Context context, String str, String str2, c.InterfaceC0556c interfaceC0556c) {
            context = context;
            str = str;
            str2 = str2;
            interfaceC0556c = interfaceC0556c;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.this.c(context, str, str2);
                interfaceC0556c.a();
            } catch (b | UnsatisfiedLinkError e10) {
                interfaceC0556c.a(e10);
            }
        }
    }

    /* renamed from: com.shu.priory.f.d$2 */
    public class AnonymousClass2 implements FilenameFilter {

        /* renamed from: a */
        final /* synthetic */ String f17072a;

        public AnonymousClass2(String str) {
            c10 = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(c10);
        }
    }

    public d() {
        this(new e(), new a());
    }

    public void c(Context context, String str, String str2) {
        f fVar;
        if (this.f17061a.contains(str) && !this.f17064d) {
            a("%s already loaded previously!", str);
            return;
        }
        try {
            this.f17062b.a(str);
            this.f17061a.add(str);
            a("%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e10) {
            a("Loading the library normally failed: %s", Log.getStackTraceString(e10));
            a("%s (%s) was not loaded normally, re-linking...", str, str2);
            File a10 = a(context, str, str2);
            if (!a10.exists() || this.f17064d) {
                if (this.f17064d) {
                    a("Forcing a re-link of %s (%s)...", str, str2);
                }
                b(context, str, str2);
                this.f17063c.a(context, this.f17062b.a(), this.f17062b.c(str), a10, this);
            }
            try {
                if (this.f17065e) {
                    f fVar2 = null;
                    try {
                        fVar = new f(a10);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        List<String> b10 = fVar.b();
                        fVar.close();
                        Iterator<String> it = b10.iterator();
                        while (it.hasNext()) {
                            a(context, this.f17062b.d(it.next()));
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fVar2 = fVar;
                        fVar2.close();
                        throw th;
                    }
                }
            } catch (IOException unused) {
            }
            this.f17062b.b(a10.getAbsolutePath());
            this.f17061a.add(str);
            a("%s (%s) was re-linked!", str, str2);
        }
    }

    public File a(Context context) {
        return context.getDir("lib", 0);
    }

    public void b(Context context, String str, String str2) {
        File a10 = a(context);
        File a11 = a(context, str, str2);
        File[] listFiles = a10.listFiles(new FilenameFilter() { // from class: com.shu.priory.f.d.2

            /* renamed from: a */
            final /* synthetic */ String f17072a;

            public AnonymousClass2(String str3) {
                c10 = str3;
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str3) {
                return str3.startsWith(c10);
            }
        });
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (this.f17064d || !file.getAbsolutePath().equals(a11.getAbsolutePath())) {
                file.delete();
            }
        }
    }

    public d(c.b bVar, c.a aVar) {
        this.f17061a = new HashSet();
        if (bVar == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Cannot pass null library installer");
        }
        this.f17062b = bVar;
        this.f17063c = aVar;
    }

    public File a(Context context, String str, String str2) {
        String c10 = this.f17062b.c(str);
        if (TextUtils.isEmpty(str2)) {
            return new File(a(context), c10);
        }
        return new File(a(context), c10 + p1.b.f29697h + str2);
    }

    public void a(Context context, String str) {
        a(context, str, (String) null, (c.InterfaceC0556c) null);
    }

    public void a(Context context, String str, String str2, c.InterfaceC0556c interfaceC0556c) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        a("Beginning load of %s...", str);
        if (interfaceC0556c == null) {
            c(context, str, str2);
        } else {
            new Thread(new Runnable() { // from class: com.shu.priory.f.d.1

                /* renamed from: a */
                final /* synthetic */ Context f17067a;

                /* renamed from: b */
                final /* synthetic */ String f17068b;

                /* renamed from: c */
                final /* synthetic */ String f17069c;

                /* renamed from: d */
                final /* synthetic */ c.InterfaceC0556c f17070d;

                public AnonymousClass1(Context context2, String str3, String str22, c.InterfaceC0556c interfaceC0556c2) {
                    context = context2;
                    str = str3;
                    str2 = str22;
                    interfaceC0556c = interfaceC0556c2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        d.this.c(context, str, str2);
                        interfaceC0556c.a();
                    } catch (b | UnsatisfiedLinkError e10) {
                        interfaceC0556c.a(e10);
                    }
                }
            }).start();
        }
    }

    public void a(String str) {
        c.d dVar = this.f17066f;
        if (dVar != null) {
            dVar.a(str);
        }
    }

    public void a(String str, Object... objArr) {
        a(String.format(Locale.US, str, objArr));
    }
}
