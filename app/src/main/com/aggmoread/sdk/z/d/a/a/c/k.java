package com.aggmoread.sdk.z.d.a.a.c;

import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.e.b;
import com.aggmoread.sdk.z.d.a.a.e.d;
import com.aggmoread.sdk.z.d.a.a.e.m;
import com.baidu.mobads.sdk.internal.am;
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class k {

    public static class a implements d {

        /* renamed from: a */
        final /* synthetic */ Map f5235a;

        /* renamed from: b */
        final /* synthetic */ e f5236b;

        public a(Map map, e eVar) {
            this.f5235a = map;
            this.f5236b = eVar;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.c.k.d
        public void a(com.aggmoread.sdk.z.d.a.a.d.b.e eVar, byte[] bArr, com.aggmoread.sdk.z.d.a.a.d.b.i iVar) {
            if (iVar == null && eVar != null) {
                com.aggmoread.sdk.z.d.a.a.e.e.b("S2S_TAG", "callback success ");
                this.f5236b.callback(k.b(this.f5235a, eVar));
            } else {
                com.aggmoread.sdk.z.d.a.a.e.e.b("S2S_TAG", "callback fail " + iVar);
                this.f5236b.callback(null);
            }
        }
    }

    public static class b implements d.c {

        /* renamed from: a */
        final /* synthetic */ d f5237a;

        /* renamed from: b */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.d f5238b;

        public b(d dVar, com.aggmoread.sdk.z.d.a.a.d.b.d dVar2) {
            this.f5237a = dVar;
            this.f5238b = dVar2;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.e.d.c
        public void a(int i10, byte[] bArr, com.aggmoread.sdk.z.d.a.a.d.b.i iVar) {
            if (iVar != null) {
                this.f5237a.a(null, bArr, iVar);
                return;
            }
            if (i10 != 200) {
                this.f5237a.a(null, bArr, new com.aggmoread.sdk.z.d.a.a.d.b.i(1001002001, "HTTP error，statusCode=" + i10));
                return;
            }
            if (bArr == null) {
                this.f5237a.a(null, bArr, new com.aggmoread.sdk.z.d.a.a.d.b.i(1001002002, "HTTP error，response parse error."));
                return;
            }
            try {
                Map<Object, Object> b10 = com.aggmoread.sdk.z.d.a.a.b.b(new String(bArr, "UTF-8"));
                if (b10 == null) {
                    this.f5237a.a(null, bArr, new com.aggmoread.sdk.z.d.a.a.d.b.i(1001002006, "HTTP error, response parse error, parse json."));
                    return;
                }
                com.aggmoread.sdk.z.d.a.a.d.b.e eVar = new com.aggmoread.sdk.z.d.a.a.d.b.e(this.f5238b, b10);
                com.aggmoread.sdk.z.d.a.a.d.b.i c10 = eVar.c();
                if (c10 != null) {
                    this.f5237a.a(null, bArr, c10);
                } else {
                    this.f5237a.a(eVar, bArr, null);
                }
            } catch (UnsupportedEncodingException unused) {
                this.f5237a.a(null, bArr, new com.aggmoread.sdk.z.d.a.a.d.b.i(1001002002, "HTTP error，response parse error, encodeing error."));
            }
        }
    }

    public static class c implements b.c {

        /* renamed from: a */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.d f5239a;

        /* renamed from: b */
        final /* synthetic */ d f5240b;

        public class a implements d {

            /* renamed from: a */
            final /* synthetic */ com.aggmoread.sdk.z.d.a.a.e.b f5241a;

            public a(c cVar, com.aggmoread.sdk.z.d.a.a.e.b bVar) {
                this.f5241a = bVar;
            }

            @Override // com.aggmoread.sdk.z.d.a.a.c.k.d
            public void a(com.aggmoread.sdk.z.d.a.a.d.b.e eVar, byte[] bArr, com.aggmoread.sdk.z.d.a.a.d.b.i iVar) {
                if (bArr != null) {
                    this.f5241a.a(bArr);
                }
            }
        }

        public class b implements d {

            /* renamed from: a */
            final /* synthetic */ com.aggmoread.sdk.z.d.a.a.e.b f5242a;

            public class a implements d {
                public a() {
                }

                @Override // com.aggmoread.sdk.z.d.a.a.c.k.d
                public void a(com.aggmoread.sdk.z.d.a.a.d.b.e eVar, byte[] bArr, com.aggmoread.sdk.z.d.a.a.d.b.i iVar) {
                    if (bArr != null) {
                        b.this.f5242a.a(bArr);
                    }
                }
            }

            public b(com.aggmoread.sdk.z.d.a.a.e.b bVar) {
                this.f5242a = bVar;
            }

            @Override // com.aggmoread.sdk.z.d.a.a.c.k.d
            public void a(com.aggmoread.sdk.z.d.a.a.d.b.e eVar, byte[] bArr, com.aggmoread.sdk.z.d.a.a.d.b.i iVar) {
                c.this.f5240b.a(eVar, bArr, iVar);
                k.b(c.this.f5239a, new a());
            }
        }

        public c(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, d dVar2) {
            this.f5239a = dVar;
            this.f5240b = dVar2;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.e.b.c
        public void a(com.aggmoread.sdk.z.d.a.a.e.b bVar) {
            Map<Object, Object> b10;
            com.aggmoread.sdk.z.d.a.a.d.b.e eVar;
            com.aggmoread.sdk.z.d.a.a.d.b.d dVar;
            d bVar2;
            byte[] b11 = bVar != null ? bVar.b() : null;
            if (b11 != null) {
                try {
                    String str = new String(b11, "UTF-8");
                    com.aggmoread.sdk.z.d.a.a.e.e.b("S2S_TAG", "ch data = " + str);
                    b10 = com.aggmoread.sdk.z.d.a.a.b.b(str);
                } catch (UnsupportedEncodingException e10) {
                    e10.printStackTrace();
                }
                if (b10 != null) {
                    eVar = new com.aggmoread.sdk.z.d.a.a.d.b.e(this.f5239a, b10);
                    if (eVar == null && eVar.c() == null) {
                        this.f5240b.a(eVar, b11, null);
                        long b12 = k.b(eVar) * 1000;
                        long currentTimeMillis = System.currentTimeMillis() - bVar.c();
                        com.aggmoread.sdk.z.d.a.a.e.e.a("ct " + currentTimeMillis + ", pct " + b12 + ", db " + bVar.c());
                        if (currentTimeMillis < b12) {
                            return;
                        }
                        bVar.a((byte[]) null);
                        dVar = this.f5239a;
                        bVar2 = new a(this, bVar);
                    } else {
                        dVar = this.f5239a;
                        bVar2 = new b(bVar);
                    }
                    k.b(dVar, bVar2);
                }
            }
            eVar = null;
            if (eVar == null) {
            }
            dVar = this.f5239a;
            bVar2 = new b(bVar);
            k.b(dVar, bVar2);
        }
    }

    public interface d {
        void a(com.aggmoread.sdk.z.d.a.a.d.b.e eVar, byte[] bArr, com.aggmoread.sdk.z.d.a.a.d.b.i iVar);
    }

    public interface e {
        void callback(f fVar);
    }

    public static class f {

        /* renamed from: a */
        public String f5245a;

        /* renamed from: b */
        public String f5246b;
    }

    public static int b(com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        int b10 = eVar.f5908d.b(e.c.D);
        return b10 > 3600 ? SdkConfigData.DEFAULT_REQUEST_INTERVAL : b10;
    }

    public static f b(Map map, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        f fVar = new f();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(1);
        eVar.d();
        String a10 = eVar.f5907c.a(e.c.T, "");
        String a11 = eVar.f5907c.a(e.c.X, "");
        int b10 = eVar.f5907c.b(e.c.Y);
        if (m.k(eVar)) {
            eVar.f5907c.b(e.c.f5919a0);
        }
        if (b10 == 100) {
            String a12 = com.aggmoread.sdk.z.d.a.a.d.a.d.u.b.a().a(a10, a11);
            String a13 = com.aggmoread.sdk.z.d.a.a.d.a.d.u.b.a().a((Map<String, Object>) map, a11);
            sb2.append(a12);
            fVar.f5245a = sb2.toString();
            fVar.f5246b = a13;
        }
        return fVar;
    }

    public static void b(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, d dVar2) {
        com.aggmoread.sdk.z.d.a.a.e.f fVar = new com.aggmoread.sdk.z.d.a.a.e.f(com.aggmoread.sdk.z.d.a.a.e.d.b(null));
        fVar.b(d.C0183d.f5893a, dVar.f5857c);
        fVar.b(d.C0183d.f5894b, dVar.f5863i);
        String a10 = com.aggmoread.sdk.z.d.a.a.b.a(fVar.f6092a);
        HashMap hashMap = new HashMap();
        hashMap.put("Content-type", am.f6738d);
        try {
            com.aggmoread.sdk.z.d.a.a.e.d.a(com.aggmoread.sdk.z.d.a.a.d.b.j.a(), a10.getBytes("UTF-8"), hashMap, new b(dVar2, dVar));
        } catch (UnsupportedEncodingException unused) {
            dVar2.a(null, null, new com.aggmoread.sdk.z.d.a.a.d.b.i(1001002004, "HTTP error, request error"));
        }
    }

    private static void a(String str, d dVar) {
        com.aggmoread.sdk.z.d.a.a.d.b.d dVar2 = new com.aggmoread.sdk.z.d.a.a.d.b.d();
        dVar2.f5863i = str;
        com.aggmoread.sdk.z.d.a.a.e.b a10 = com.aggmoread.sdk.z.d.a.a.e.b.a("sc_" + dVar2.f5863i);
        c cVar = new c(dVar2, dVar);
        if (a10 != null) {
            a10.a(cVar);
        } else {
            cVar.a(null);
        }
    }

    public static void a(String str, Map<String, Object> map, e eVar) {
        if (com.aggmoread.sdk.z.d.a.a.d.b.j.f6029s.booleanValue()) {
            a(str, new a(map, eVar));
        } else {
            eVar.callback(null);
        }
    }
}
