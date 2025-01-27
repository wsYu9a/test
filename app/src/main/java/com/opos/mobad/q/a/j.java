package com.opos.mobad.q.a;

import android.content.Context;
import android.view.View;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class j {

    /* renamed from: a */
    private a f23345a;

    /* renamed from: b */
    private Context f23346b;

    /* renamed from: c */
    private String f23347c;

    /* renamed from: d */
    private AdItemData f23348d;

    /* renamed from: e */
    private MaterialData f23349e;

    /* renamed from: h */
    private long f23352h;
    private int k;

    /* renamed from: f */
    private long f23350f = -1;

    /* renamed from: g */
    private boolean f23351g = false;

    /* renamed from: i */
    private boolean f23353i = false;

    /* renamed from: j */
    private boolean f23354j = false;

    /* renamed from: com.opos.mobad.q.a.j$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j.this.f23345a != null) {
                j.this.f23345a.b();
            }
        }
    }

    /* renamed from: com.opos.mobad.q.a.j$2 */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j.this.f23345a != null) {
                j.this.f23345a.c();
            }
        }
    }

    /* renamed from: com.opos.mobad.q.a.j$3 */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f23357a;

        /* renamed from: b */
        final /* synthetic */ String f23358b;

        AnonymousClass3(int i2, String str) {
            i2 = i2;
            a2 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j.this.f23351g || j.this.f23345a == null) {
                return;
            }
            a aVar = j.this.f23345a;
            StringBuilder sb = new StringBuilder();
            sb.append("code=");
            sb.append(i2);
            sb.append(",msg=");
            String str = a2;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            aVar.b(sb.toString());
        }
    }

    /* renamed from: com.opos.mobad.q.a.j$4 */
    class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ long f23360a;

        AnonymousClass4(long j2) {
            j2 = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j.this.f23351g || j.this.f23345a == null) {
                return;
            }
            j.this.f23345a.b(j2);
        }
    }

    public interface a {
        void b();

        void b(long j2);

        void b(String str);

        void c();
    }

    public j(Context context, String str, a aVar) {
        this.f23345a = aVar;
        this.f23346b = context;
        this.f23347c = str;
    }

    private Map<String, String> a(String str, long j2, long j3) {
        HashMap hashMap = new HashMap();
        try {
            return !com.opos.cmn.an.c.a.a(str) ? com.opos.mobad.cmn.a.b.d.a(str, j2, j3) : hashMap;
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("VideoPlayPresenter", "", (Throwable) e2);
            return hashMap;
        }
    }

    private void a(List<String> list, long j2) {
        if (list == null || list.size() <= 0) {
            return;
        }
        com.opos.mobad.service.g.b.a().a(list).a(j2).a(this.f23346b);
    }

    private void a(boolean z, String str, int i2, long j2) {
        com.opos.mobad.cmn.a.b.d.b(this.f23346b, this.f23347c, this.f23348d, this.f23349e, z, a(str, i2, j2));
    }

    private boolean a(long j2, long j3, float f2) {
        boolean z;
        if (0 != j2) {
            try {
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("VideoPlayPresenter", "", (Throwable) e2);
            }
            if (b(j2, this.f23350f) < f2) {
                if (b(j2, j3) >= f2) {
                    z = true;
                    com.opos.cmn.an.f.a.b("VideoPlayPresenter", "meetVideoPercent percent=" + f2 + ",result=" + z);
                    return z;
                }
            }
        }
        z = false;
        com.opos.cmn.an.f.a.b("VideoPlayPresenter", "meetVideoPercent percent=" + f2 + ",result=" + z);
        return z;
    }

    private float b(long j2, long j3) {
        float f2 = 0 != j2 ? j3 / (j2 * 1.0f) : 0.0f;
        com.opos.cmn.an.f.a.b("VideoPlayPresenter", "getVideoPercent=" + f2);
        return f2;
    }

    private void b() {
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.q.a.j.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (j.this.f23345a != null) {
                    j.this.f23345a.b();
                }
            }
        });
    }

    private void b(long j2) {
        try {
            if (this.f23351g) {
                return;
            }
            a(true, "0", 0, j2);
            e(0L);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("VideoPlayPresenter", "", (Throwable) e2);
        }
    }

    private long c(long j2) {
        return j2 > 0 ? j2 : this.f23352h;
    }

    private void d(long j2) {
        if (this.f23349e.B() == null || this.f23349e.B().size() <= 0) {
            return;
        }
        com.opos.mobad.service.g.b.a().a(this.f23349e.B()).a(j2).a(this.f23346b);
    }

    private void e(long j2) {
        if (this.f23349e.x() == null || this.f23349e.x().size() <= 0) {
            return;
        }
        com.opos.mobad.service.g.b.a().a(this.f23349e.x()).a(j2).a(this.f23346b);
    }

    public void a() {
        this.f23351g = true;
    }

    public void a(int i2, String str) {
        com.opos.cmn.an.f.a.b("VideoPlayPresenter", "code=" + i2);
        try {
            if (this.f23351g) {
                return;
            }
            com.opos.mobad.cmn.a.b.d.a(this.f23346b, this.f23347c, this.f23348d, this.f23349e, true, String.valueOf(this.k), i2);
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.q.a.j.3

                /* renamed from: a */
                final /* synthetic */ int f23357a;

                /* renamed from: b */
                final /* synthetic */ String f23358b;

                AnonymousClass3(int i22, String str2) {
                    i2 = i22;
                    a2 = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.f23351g || j.this.f23345a == null) {
                        return;
                    }
                    a aVar = j.this.f23345a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("code=");
                    sb.append(i2);
                    sb.append(",msg=");
                    String str2 = a2;
                    if (str2 == null) {
                        str2 = "";
                    }
                    sb.append(str2);
                    aVar.b(sb.toString());
                }
            });
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("VideoPlayPresenter", "", (Throwable) e2);
        }
    }

    public void a(long j2) {
        try {
            if (!this.f23351g) {
                if (this.f23353i) {
                    com.opos.cmn.an.f.a.b("VideoPlayPresenter", "video has complete");
                } else {
                    long c2 = c(j2);
                    a(true, "100", (int) c2, c2);
                    d(c2);
                    com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.q.a.j.2
                        AnonymousClass2() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (j.this.f23345a != null) {
                                j.this.f23345a.c();
                            }
                        }
                    });
                    this.f23353i = true;
                }
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("VideoPlayPresenter", "", (Throwable) e2);
        }
    }

    public void a(long j2, long j3) {
        MaterialData materialData;
        List<String> A;
        try {
            if (this.f23351g) {
                return;
            }
            if (this.f23353i) {
                com.opos.cmn.an.f.a.b("VideoPlayPresenter", "onProcess but has completed");
                return;
            }
            if (j3 <= 0) {
                j3 = this.f23352h;
            } else if (!this.f23354j && (materialData = this.f23349e) != null && materialData.F() != null && this.f23349e.F().size() > 0 && Math.abs(this.f23349e.u() - j3) >= 2000) {
                this.f23354j = true;
                com.opos.mobad.service.i.d.a().c().a(this.f23349e.aa(), this.f23349e.F().get(0).a(), this.f23349e.u(), j3);
            }
            if (this.f23350f == -1) {
                b();
            }
            if (a(j3, j2, 0.25f)) {
                a(true, "25", (int) j2, j3);
                A = this.f23349e.y();
            } else if (a(j3, j2, 0.5f)) {
                a(true, "50", (int) j2, j3);
                A = this.f23349e.z();
            } else {
                if (!a(j3, j2, 0.75f)) {
                    if (this.f23350f == -1) {
                        b(j3);
                    }
                    this.f23350f = j2;
                }
                a(true, "75", (int) j2, j3);
                A = this.f23349e.A();
            }
            a(A, j2);
            this.f23350f = j2;
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("VideoPlayPresenter", "", (Throwable) e2);
        }
    }

    public void a(View view, int[] iArr, long j2) {
        try {
            if (this.f23351g) {
                return;
            }
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.q.a.j.4

                /* renamed from: a */
                final /* synthetic */ long f23360a;

                AnonymousClass4(long j22) {
                    j2 = j22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.f23351g || j.this.f23345a == null) {
                        return;
                    }
                    j.this.f23345a.b(j2);
                }
            });
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("VideoPlayPresenter", "", (Throwable) e2);
        }
    }

    public void a(AdItemData adItemData, MaterialData materialData, long j2, int i2) {
        this.f23348d = adItemData;
        this.f23349e = materialData;
        this.f23350f = -1L;
        this.f23353i = false;
        if (j2 <= 0) {
            this.f23352h = materialData.u();
        } else {
            this.f23352h = j2;
        }
        this.f23354j = false;
        this.k = i2;
    }
}
