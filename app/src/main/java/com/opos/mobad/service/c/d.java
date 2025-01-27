package com.opos.mobad.service.c;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.i.a;
import com.opos.mobad.c.a.a;
import com.opos.mobad.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private Context f23552a;

    /* renamed from: b */
    private f f23553b;

    /* renamed from: c */
    private com.opos.cmn.i.a f23554c;

    /* renamed from: d */
    private volatile List<a.b> f23555d;

    /* renamed from: com.opos.mobad.service.c.d$1 */
    class AnonymousClass1 implements a.b {

        /* renamed from: com.opos.mobad.service.c.d$1$1 */
        class RunnableC04791 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ List f23557a;

            /* renamed from: b */
            final /* synthetic */ a.InterfaceC0395a f23558b;

            /* renamed from: com.opos.mobad.service.c.d$1$1$1 */
            class C04801 implements a.InterfaceC0427a {
                C04801() {
                }

                @Override // com.opos.mobad.c.a.a.InterfaceC0427a
                public void a() {
                    com.opos.cmn.an.f.a.b("Dynamic-Loader", "FileLoader onComplete");
                    RunnableC04791 runnableC04791 = RunnableC04791.this;
                    d.this.a((List<a.b>) list);
                    a.InterfaceC0395a interfaceC0395a = interfaceC0395a;
                    if (interfaceC0395a != null) {
                        interfaceC0395a.a();
                    }
                }

                @Override // com.opos.mobad.c.a.a.InterfaceC0427a
                public void a(String str) {
                }

                @Override // com.opos.mobad.c.a.a.InterfaceC0427a
                public void a(String str, int i2) {
                    com.opos.cmn.an.f.a.b("Dynamic-Loader", "FileLoader info =", str, Integer.valueOf(i2));
                }
            }

            RunnableC04791(List list, a.InterfaceC0395a interfaceC0395a) {
                list = list;
                interfaceC0395a = interfaceC0395a;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.opos.mobad.d.d.a().a(list, new a.InterfaceC0427a() { // from class: com.opos.mobad.service.c.d.1.1.1
                        C04801() {
                        }

                        @Override // com.opos.mobad.c.a.a.InterfaceC0427a
                        public void a() {
                            com.opos.cmn.an.f.a.b("Dynamic-Loader", "FileLoader onComplete");
                            RunnableC04791 runnableC04791 = RunnableC04791.this;
                            d.this.a((List<a.b>) list);
                            a.InterfaceC0395a interfaceC0395a = interfaceC0395a;
                            if (interfaceC0395a != null) {
                                interfaceC0395a.a();
                            }
                        }

                        @Override // com.opos.mobad.c.a.a.InterfaceC0427a
                        public void a(String str) {
                        }

                        @Override // com.opos.mobad.c.a.a.InterfaceC0427a
                        public void a(String str, int i2) {
                            com.opos.cmn.an.f.a.b("Dynamic-Loader", "FileLoader info =", str, Integer.valueOf(i2));
                        }
                    }, com.opos.mobad.c.a(f.a(d.this.f23552a)));
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.d("Dynamic-Loader", "", e2);
                }
            }
        }

        AnonymousClass1() {
        }

        @Override // com.opos.cmn.i.a.b
        public void a(a.InterfaceC0395a interfaceC0395a) {
            List list = d.this.f23555d;
            if (list != null && list.size() > 0) {
                com.opos.cmn.an.f.a.b("Dynamic-Loader", "start to load action");
                com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.c.d.1.1

                    /* renamed from: a */
                    final /* synthetic */ List f23557a;

                    /* renamed from: b */
                    final /* synthetic */ a.InterfaceC0395a f23558b;

                    /* renamed from: com.opos.mobad.service.c.d$1$1$1 */
                    class C04801 implements a.InterfaceC0427a {
                        C04801() {
                        }

                        @Override // com.opos.mobad.c.a.a.InterfaceC0427a
                        public void a() {
                            com.opos.cmn.an.f.a.b("Dynamic-Loader", "FileLoader onComplete");
                            RunnableC04791 runnableC04791 = RunnableC04791.this;
                            d.this.a((List<a.b>) list);
                            a.InterfaceC0395a interfaceC0395a = interfaceC0395a;
                            if (interfaceC0395a != null) {
                                interfaceC0395a.a();
                            }
                        }

                        @Override // com.opos.mobad.c.a.a.InterfaceC0427a
                        public void a(String str) {
                        }

                        @Override // com.opos.mobad.c.a.a.InterfaceC0427a
                        public void a(String str, int i2) {
                            com.opos.cmn.an.f.a.b("Dynamic-Loader", "FileLoader info =", str, Integer.valueOf(i2));
                        }
                    }

                    RunnableC04791(List list2, a.InterfaceC0395a interfaceC0395a2) {
                        list = list2;
                        interfaceC0395a = interfaceC0395a2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            com.opos.mobad.d.d.a().a(list, new a.InterfaceC0427a() { // from class: com.opos.mobad.service.c.d.1.1.1
                                C04801() {
                                }

                                @Override // com.opos.mobad.c.a.a.InterfaceC0427a
                                public void a() {
                                    com.opos.cmn.an.f.a.b("Dynamic-Loader", "FileLoader onComplete");
                                    RunnableC04791 runnableC04791 = RunnableC04791.this;
                                    d.this.a((List<a.b>) list);
                                    a.InterfaceC0395a interfaceC0395a2 = interfaceC0395a;
                                    if (interfaceC0395a2 != null) {
                                        interfaceC0395a2.a();
                                    }
                                }

                                @Override // com.opos.mobad.c.a.a.InterfaceC0427a
                                public void a(String str) {
                                }

                                @Override // com.opos.mobad.c.a.a.InterfaceC0427a
                                public void a(String str, int i2) {
                                    com.opos.cmn.an.f.a.b("Dynamic-Loader", "FileLoader info =", str, Integer.valueOf(i2));
                                }
                            }, com.opos.mobad.c.a(f.a(d.this.f23552a)));
                        } catch (Exception e2) {
                            com.opos.cmn.an.f.a.d("Dynamic-Loader", "", e2);
                        }
                    }
                });
            } else {
                com.opos.cmn.an.f.a.b("Dynamic-Loader", "load action but empty load info");
                if (interfaceC0395a2 != null) {
                    interfaceC0395a2.b();
                }
            }
        }
    }

    public d(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f23552a = applicationContext;
        this.f23553b = new f(applicationContext);
        this.f23554c = new com.opos.cmn.i.a(new AnonymousClass1(), Integer.MAX_VALUE, 10000);
    }

    public static void a(Context context) {
        try {
            com.opos.mobad.c a2 = com.opos.mobad.c.a(f.a(context));
            if (a2 != null) {
                try {
                    try {
                        if (h.a(a2, 6, 70)) {
                            c.a(new File(f.a(context)), 134217728L, 20);
                            c.b(new File(f.b(context)), 268435456L, 20);
                        }
                    } catch (Throwable th) {
                        a2.b();
                        throw th;
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("Dynamic-Loader", "", (Throwable) e2);
                }
            }
            if (a2 == null) {
                return;
            }
            a2.b();
        } catch (Exception e3) {
            com.opos.cmn.an.f.a.a("Dynamic-Loader", "", (Throwable) e3);
        }
    }

    public void a(List<a.b> list) {
        for (a.b bVar : list) {
            if (bVar != null && !TextUtils.isEmpty(bVar.f20031a)) {
                String b2 = this.f23553b.b(bVar.f20031a);
                e.a(this.f23552a, b2);
                File file = new File(b2);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    private List<a.b> b(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (int i3 = 0; i3 < strArr.length && i2 < 3; i3++) {
            String str = strArr[i3];
            if (!TextUtils.isEmpty(str) && !a(str)) {
                arrayList.add(new a.b(str, "", ".dynamic"));
                i2++;
            }
        }
        com.opos.cmn.an.f.a.a("Dynamic-Loader", "load info list =", arrayList);
        return arrayList;
    }

    public void a(String[] strArr) {
        String str;
        if (strArr == null || strArr.length <= 0) {
            str = "loadMaterialList fail ";
        } else {
            if (com.opos.cmn.an.h.c.a.e(this.f23552a)) {
                this.f23555d = b(strArr);
                if (this.f23555d == null || this.f23555d.size() < 0) {
                    return;
                }
                this.f23554c.a();
                return;
            }
            str = "is not wifi do not download zip ";
        }
        com.opos.cmn.an.f.a.b("Dynamic-Loader", str);
    }

    public boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            File a2 = f.a(this.f23552a, this.f23553b.b(str));
            if (a2 == null) {
                com.opos.cmn.an.f.a.a("Dynamic-Loader", "check file exit but not exit: " + str);
            } else {
                if (a2.exists()) {
                    com.opos.cmn.an.f.a.b("Dynamic-Loader", "check file exit: ", str, a2.getAbsolutePath());
                    return true;
                }
                com.opos.cmn.an.f.a.b("Dynamic-Loader", "check file exit but not exit: " + str + ", file =" + a2.getAbsolutePath());
            }
        }
        return false;
    }

    public String b(String str) {
        File a2;
        return (TextUtils.isEmpty(str) || (a2 = f.a(this.f23552a, this.f23553b.b(str))) == null) ? "" : a2.getAbsolutePath();
    }

    public void c(String str) {
        StringBuilder sb;
        String str2;
        if (TextUtils.isEmpty(str)) {
            sb = new StringBuilder();
            str2 = "no need load template empty url = ";
        } else {
            if (com.opos.cmn.an.h.c.a.e(this.f23552a)) {
                if (a(str)) {
                    return;
                }
                com.opos.cmn.an.f.a.b("Dynamic-Loader", "loadMaterial url = " + str);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new a.b(str, "", ".dynamic"));
                this.f23555d = arrayList;
                this.f23554c.a();
                return;
            }
            sb = new StringBuilder();
            str2 = "is not wifi do not download zip ";
        }
        sb.append(str2);
        sb.append(str);
        com.opos.cmn.an.f.a.b("Dynamic-Loader", sb.toString());
    }
}
