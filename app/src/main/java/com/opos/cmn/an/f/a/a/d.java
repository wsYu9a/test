package com.opos.cmn.an.f.a.a;

import android.text.TextUtils;
import b.h.a.c;
import b.h.a.d;
import b.h.a.j.c;
import com.usertrace.cdo.usertrace.domain.dto.UserTraceConfigDto;
import java.io.File;

/* loaded from: classes4.dex */
public class d implements b {

    /* renamed from: a */
    private com.opos.cmn.an.f.b.b f16411a;

    /* renamed from: b */
    private b.h.a.c f16412b;

    /* renamed from: com.opos.cmn.an.f.a.a.d$1 */
    class AnonymousClass1 implements d.c {
        AnonymousClass1() {
        }

        @Override // b.h.a.d.c
        public String a() {
            return "";
        }

        @Override // b.h.a.d.c
        public String b() {
            return d.this.f16411a.f16458i.a();
        }

        @Override // b.h.a.d.c
        public String c() {
            return "";
        }
    }

    /* renamed from: com.opos.cmn.an.f.a.a.d$2 */
    class AnonymousClass2 implements d.b {
        AnonymousClass2() {
        }

        @Override // b.h.a.d.b
        public String a() {
            return d.this.f16411a.f16457h.a();
        }
    }

    /* renamed from: com.opos.cmn.an.f.a.a.d$3 */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ com.opos.cmn.an.f.b.c f16415a;

        /* renamed from: b */
        final /* synthetic */ com.opos.cmn.an.f.b.a f16416b;

        /* renamed from: com.opos.cmn.an.f.a.a.d$3$1 */
        class AnonymousClass1 implements c.g {

            /* renamed from: com.opos.cmn.an.f.a.a.d$3$1$1 */
            class C03691 implements c.i {
                C03691() {
                }

                @Override // b.h.a.j.c.i
                public void a() {
                    com.opos.cmn.an.f.b.a aVar = AnonymousClass3.this.f16416b;
                    if (aVar != null) {
                        aVar.onUploaderSuccess();
                    }
                }

                @Override // b.h.a.j.c.i
                public void a(String str) {
                    com.opos.cmn.an.f.b.a aVar = AnonymousClass3.this.f16416b;
                    if (aVar != null) {
                        aVar.onUploaderFailed(str);
                    }
                }
            }

            AnonymousClass1() {
            }

            @Override // b.h.a.j.c.g
            public void a(UserTraceConfigDto userTraceConfigDto) {
                try {
                    if (userTraceConfigDto == null) {
                        com.opos.cmn.an.f.b.a aVar = AnonymousClass3.this.f16416b;
                        if (aVar != null) {
                            aVar.onDontNeedUpload("userTraceConfigDto is null");
                        }
                    } else {
                        d.this.f16412b.d(new c.i() { // from class: com.opos.cmn.an.f.a.a.d.3.1.1
                            C03691() {
                            }

                            @Override // b.h.a.j.c.i
                            public void a() {
                                com.opos.cmn.an.f.b.a aVar2 = AnonymousClass3.this.f16416b;
                                if (aVar2 != null) {
                                    aVar2.onUploaderSuccess();
                                }
                            }

                            @Override // b.h.a.j.c.i
                            public void a(String str) {
                                com.opos.cmn.an.f.b.a aVar2 = AnonymousClass3.this.f16416b;
                                if (aVar2 != null) {
                                    aVar2.onUploaderFailed(str);
                                }
                            }
                        });
                        d.this.f16412b.e("advertise_sdk", String.valueOf(userTraceConfigDto.getTraceId()), userTraceConfigDto.getBeginTime(), userTraceConfigDto.getEndTime(), userTraceConfigDto.getForce() == 1, AnonymousClass3.this.f16415a.f16470a);
                    }
                } catch (Exception unused) {
                }
            }

            @Override // b.h.a.j.c.g
            public void a(String str) {
                com.opos.cmn.an.f.b.a aVar = AnonymousClass3.this.f16416b;
                if (aVar != null) {
                    aVar.onDontNeedUpload(str);
                }
            }
        }

        AnonymousClass3(com.opos.cmn.an.f.b.c cVar, com.opos.cmn.an.f.b.a aVar) {
            this.f16415a = cVar;
            this.f16416b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.this.f16412b.f("advertise_sdk", this.f16415a.f16470a, new c.g() { // from class: com.opos.cmn.an.f.a.a.d.3.1

                    /* renamed from: com.opos.cmn.an.f.a.a.d$3$1$1 */
                    class C03691 implements c.i {
                        C03691() {
                        }

                        @Override // b.h.a.j.c.i
                        public void a() {
                            com.opos.cmn.an.f.b.a aVar2 = AnonymousClass3.this.f16416b;
                            if (aVar2 != null) {
                                aVar2.onUploaderSuccess();
                            }
                        }

                        @Override // b.h.a.j.c.i
                        public void a(String str) {
                            com.opos.cmn.an.f.b.a aVar2 = AnonymousClass3.this.f16416b;
                            if (aVar2 != null) {
                                aVar2.onUploaderFailed(str);
                            }
                        }
                    }

                    AnonymousClass1() {
                    }

                    @Override // b.h.a.j.c.g
                    public void a(UserTraceConfigDto userTraceConfigDto) {
                        try {
                            if (userTraceConfigDto == null) {
                                com.opos.cmn.an.f.b.a aVar = AnonymousClass3.this.f16416b;
                                if (aVar != null) {
                                    aVar.onDontNeedUpload("userTraceConfigDto is null");
                                }
                            } else {
                                d.this.f16412b.d(new c.i() { // from class: com.opos.cmn.an.f.a.a.d.3.1.1
                                    C03691() {
                                    }

                                    @Override // b.h.a.j.c.i
                                    public void a() {
                                        com.opos.cmn.an.f.b.a aVar2 = AnonymousClass3.this.f16416b;
                                        if (aVar2 != null) {
                                            aVar2.onUploaderSuccess();
                                        }
                                    }

                                    @Override // b.h.a.j.c.i
                                    public void a(String str) {
                                        com.opos.cmn.an.f.b.a aVar2 = AnonymousClass3.this.f16416b;
                                        if (aVar2 != null) {
                                            aVar2.onUploaderFailed(str);
                                        }
                                    }
                                });
                                d.this.f16412b.e("advertise_sdk", String.valueOf(userTraceConfigDto.getTraceId()), userTraceConfigDto.getBeginTime(), userTraceConfigDto.getEndTime(), userTraceConfigDto.getForce() == 1, AnonymousClass3.this.f16415a.f16470a);
                            }
                        } catch (Exception unused) {
                        }
                    }

                    @Override // b.h.a.j.c.g
                    public void a(String str) {
                        com.opos.cmn.an.f.b.a aVar = AnonymousClass3.this.f16416b;
                        if (aVar != null) {
                            aVar.onDontNeedUpload(str);
                        }
                    }
                });
            } catch (Exception unused) {
                com.opos.cmn.an.f.b.a aVar = this.f16416b;
                if (aVar != null) {
                    aVar.onUploaderFailed("unkown error");
                }
            }
        }
    }

    private void a(int i2, String str, String str2) {
        b.h.a.c cVar = this.f16412b;
        if (cVar == null || cVar.a() == null) {
            return;
        }
        if (i2 == 1) {
            this.f16412b.a().a(str, str2, com.opos.cmn.an.f.a.c.b());
            return;
        }
        if (i2 == 2) {
            this.f16412b.a().e(str, str2, com.opos.cmn.an.f.a.c.b());
            return;
        }
        if (i2 == 3) {
            this.f16412b.a().b(str, str2, com.opos.cmn.an.f.a.c.b());
        } else if (i2 == 4) {
            this.f16412b.a().c(str, str2, com.opos.cmn.an.f.a.c.b());
        } else {
            if (i2 != 5) {
                return;
            }
            this.f16412b.a().d(str, str2, com.opos.cmn.an.f.a.c.b());
        }
    }

    private String b() {
        try {
            if (com.opos.cmn.an.f.c.b.b()) {
                return this.f16411a.f16456g.getExternalFilesDir(null) + File.separator + ".opos_ad_log";
            }
        } catch (Exception unused) {
        }
        return "";
    }

    private String c() {
        try {
            if (com.opos.cmn.an.f.c.b.b()) {
                return this.f16411a.f16456g.getExternalFilesDir(null) + File.separator + ".opos_ad_mmap_cache_log";
            }
        } catch (Exception unused) {
        }
        return "";
    }

    @Override // com.opos.cmn.an.f.a.a.b
    public void a() {
        b.h.a.c cVar = this.f16412b;
        if (cVar == null) {
            return;
        }
        cVar.h();
    }

    @Override // com.opos.cmn.an.f.a.a.b
    public void a(int i2) {
        b.h.a.c cVar = this.f16412b;
        if (cVar != null) {
            cVar.b(i2);
        }
    }

    @Override // com.opos.cmn.an.f.a.a.b
    public void a(com.opos.cmn.an.f.a.b.d dVar) {
        b.h.a.c cVar;
        if (dVar == null || dVar.f16424b == null || dVar.f16423a == null || (cVar = this.f16412b) == null || cVar.a() == null) {
            return;
        }
        int i2 = dVar.f16426d;
        try {
            String a2 = com.opos.cmn.an.f.c.b.a(dVar);
            if (a2.length() > 3072 && com.opos.cmn.an.f.a.c.b()) {
                int length = a2.length();
                int i3 = 0;
                while (length > i3) {
                    int i4 = i3 + 3072;
                    if (length <= i4) {
                        i4 = length;
                    }
                    a(i2, this.f16411a.f16450a, a2.substring(i3, i4));
                    i3 = i4;
                }
                return;
            }
            a(i2, this.f16411a.f16450a, a2);
        } catch (Throwable unused) {
        }
    }

    @Override // com.opos.cmn.an.f.a.a.b
    public void a(com.opos.cmn.an.f.b.b bVar) {
        int i2;
        this.f16411a = bVar;
        try {
            if (com.opos.cmn.an.f.c.b.a()) {
                com.opos.cmn.an.f.a.c.a();
                i2 = 1;
            } else {
                i2 = this.f16411a.f16452c;
            }
            c.b c2 = b.h.a.c.l().d(new c()).l("ad").k(b()).i(c()).j(this.f16411a.f16453d).a(this.f16411a.f16451b).h(i2).e(this.f16411a.f16455f).b(new d.b() { // from class: com.opos.cmn.an.f.a.a.d.2
                AnonymousClass2() {
                }

                @Override // b.h.a.d.b
                public String a() {
                    return d.this.f16411a.f16457h.a();
                }
            }).c(new d.c() { // from class: com.opos.cmn.an.f.a.a.d.1
                AnonymousClass1() {
                }

                @Override // b.h.a.d.c
                public String a() {
                    return "";
                }

                @Override // b.h.a.d.c
                public String b() {
                    return d.this.f16411a.f16458i.a();
                }

                @Override // b.h.a.d.c
                public String c() {
                    return "";
                }
            });
            String c3 = com.opos.cmn.an.f.c.b.c();
            if (!TextUtils.isEmpty(c3)) {
                c2.m(c3);
            }
            this.f16412b = c2.f(this.f16411a.f16456g);
            b.h.a.c.i(false);
        } catch (Exception unused) {
        }
    }

    @Override // com.opos.cmn.an.f.a.a.b
    public void a(com.opos.cmn.an.f.b.c cVar, com.opos.cmn.an.f.b.a aVar) {
        String str;
        if (cVar == null) {
            if (aVar == null) {
                return;
            } else {
                str = "uploadParams is null";
            }
        } else if (com.opos.cmn.an.c.a.a(cVar.f16470a)) {
            if (aVar == null) {
                return;
            } else {
                str = "businessType is null";
            }
        } else if (this.f16412b != null) {
            com.opos.cmn.an.f.b.b bVar = this.f16411a;
            if (bVar == null || com.opos.cmn.an.f.a.a.a(bVar.f16456g)) {
                new Thread(new AnonymousClass3(cVar, aVar)).start();
                return;
            } else if (aVar == null) {
                return;
            } else {
                str = "log buried point switch is closed, cannot upload log";
            }
        } else if (aVar == null) {
            return;
        } else {
            str = "mLogger is null";
        }
        aVar.onUploaderFailed(str);
    }

    @Override // com.opos.cmn.an.f.a.a.b
    public void a(boolean z) {
        b.h.a.c cVar = this.f16412b;
        if (cVar == null) {
            return;
        }
        try {
            cVar.g(z);
        } catch (Exception unused) {
        }
    }
}
