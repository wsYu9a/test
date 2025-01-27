package com.kwad.sdk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.d.a;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.config.item.p;
import com.kwad.sdk.core.imageloader.ImageLoaderProxy;
import com.kwad.sdk.core.report.s;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class j {

    /* renamed from: com.kwad.sdk.j$1 */
    public class AnonymousClass1 implements com.kwad.sdk.service.a.e {

        /* renamed from: com.kwad.sdk.j$1$1 */
        public class C05101 implements a.b {
            final /* synthetic */ com.kwad.sdk.service.a.c anX;

            public C05101(com.kwad.sdk.service.a.c cVar) {
                cVar = cVar;
            }

            @Override // com.kwad.components.core.d.a.b
            public final String getKey() {
                com.kwad.sdk.service.a.c cVar = cVar;
                if (cVar != null) {
                    return cVar.getKey();
                }
                return null;
            }

            @Override // com.kwad.components.core.d.a.b
            public final JSONObject getValue() {
                com.kwad.sdk.service.a.c cVar = cVar;
                if (cVar != null) {
                    return cVar.getValue();
                }
                return null;
            }
        }

        /* renamed from: com.kwad.sdk.j$1$2 */
        public class AnonymousClass2 implements a.c {
            final /* synthetic */ com.kwad.sdk.service.a.g anZ;

            public AnonymousClass2(com.kwad.sdk.service.a.g gVar) {
                gVar = gVar;
            }

            @Override // com.kwad.components.core.d.a.c
            public final void onCrashOccur(int i10, String str) {
                com.kwad.sdk.service.a.g gVar = gVar;
                if (gVar != null) {
                    gVar.l(i10, str);
                }
            }
        }

        @Override // com.kwad.sdk.service.a.e
        public final void G(String str, String str2) {
            com.kwad.components.core.d.a.j(str, str2);
        }

        @Override // com.kwad.sdk.service.a.e
        public final void a(com.kwad.sdk.service.a.c cVar) {
            com.kwad.components.core.d.a.a(new a.b() { // from class: com.kwad.sdk.j.1.1
                final /* synthetic */ com.kwad.sdk.service.a.c anX;

                public C05101(com.kwad.sdk.service.a.c cVar2) {
                    cVar = cVar2;
                }

                @Override // com.kwad.components.core.d.a.b
                public final String getKey() {
                    com.kwad.sdk.service.a.c cVar2 = cVar;
                    if (cVar2 != null) {
                        return cVar2.getKey();
                    }
                    return null;
                }

                @Override // com.kwad.components.core.d.a.b
                public final JSONObject getValue() {
                    com.kwad.sdk.service.a.c cVar2 = cVar;
                    if (cVar2 != null) {
                        return cVar2.getValue();
                    }
                    return null;
                }
            });
        }

        @Override // com.kwad.sdk.service.a.e
        public final void gatherException(Throwable th2) {
            com.kwad.components.core.d.a.reportSdkCaughtException(th2);
        }

        @Override // com.kwad.sdk.service.a.e
        public final void a(com.kwad.sdk.service.a.g gVar) {
            com.kwad.components.core.d.a.a(new a.c() { // from class: com.kwad.sdk.j.1.2
                final /* synthetic */ com.kwad.sdk.service.a.g anZ;

                public AnonymousClass2(com.kwad.sdk.service.a.g gVar2) {
                    gVar = gVar2;
                }

                @Override // com.kwad.components.core.d.a.c
                public final void onCrashOccur(int i10, String str) {
                    com.kwad.sdk.service.a.g gVar2 = gVar;
                    if (gVar2 != null) {
                        gVar2.l(i10, str);
                    }
                }
            });
        }
    }

    /* renamed from: com.kwad.sdk.j$2 */
    public class AnonymousClass2 implements com.kwad.sdk.service.a.d {
        @Override // com.kwad.sdk.service.a.d
        public final void a(boolean z10, String str, String str2, String str3) {
            com.kwad.sdk.core.diskcache.b.a.EG().dD(str);
        }

        @Override // com.kwad.sdk.service.a.d
        public final File ca(String str) {
            return com.kwad.sdk.core.diskcache.b.a.EG().ca(str);
        }
    }

    /* renamed from: com.kwad.sdk.j$3 */
    public class AnonymousClass3 implements com.kwad.sdk.service.a.j {
        @Override // com.kwad.sdk.service.a.j
        public final boolean rD() {
            com.kwad.components.core.p.b.rC();
            return com.kwad.components.core.p.b.rD();
        }

        @Override // com.kwad.sdk.service.a.j
        public final int rE() {
            com.kwad.components.core.p.b.rC();
            return com.kwad.components.core.p.b.rE();
        }

        @Override // com.kwad.sdk.service.a.j
        public final int rF() {
            return com.kwad.components.core.p.b.rC().rF();
        }

        @Override // com.kwad.sdk.service.a.j
        public final InputStream wrapInputStream(InputStream inputStream) {
            com.kwad.components.core.p.b.rC();
            return com.kwad.components.core.p.b.wrapInputStream(inputStream);
        }
    }

    /* renamed from: com.kwad.sdk.j$4 */
    public class AnonymousClass4 implements com.kwad.sdk.core.network.k {
        @Override // com.kwad.sdk.core.network.k
        public final void a(com.kwad.sdk.core.network.j jVar) {
            com.kwad.sdk.commercial.b.b(jVar);
        }

        @Override // com.kwad.sdk.core.network.k
        public final com.kwad.sdk.core.b zw() {
            return com.kwad.components.core.request.model.b.rB();
        }

        @Override // com.kwad.sdk.core.network.k
        public final void a(com.kwad.sdk.core.network.i iVar) {
            com.kwad.sdk.commercial.b.b(iVar);
        }
    }

    /* renamed from: com.kwad.sdk.j$5 */
    public class AnonymousClass5 implements com.kwad.sdk.service.a.b {
        @Override // com.kwad.sdk.service.a.b
        public final void H(String str, String str2) {
            com.kwad.sdk.core.d.c.e("image_load_failed_info", "errorMsg:" + str2 + "\nurl:" + str);
        }

        @Override // com.kwad.sdk.service.a.b
        public final void aL(AdTemplate adTemplate) {
            com.kwad.components.core.o.a.ri().f(adTemplate, 21007);
        }

        @Override // com.kwad.sdk.service.a.b
        public final void e(@NonNull JSONObject jSONObject, int i10) {
            com.kwad.components.core.o.a.ri().e(jSONObject, i10);
        }

        @Override // com.kwad.sdk.service.a.b
        public final void zx() {
            com.kwad.components.core.o.a.ri().as(ServiceProvider.getContext());
        }
    }

    /* renamed from: com.kwad.sdk.j$6 */
    public class AnonymousClass6 implements s {
        @Override // com.kwad.sdk.core.report.s
        public final boolean ab(long j10) {
            p pVar = com.kwad.sdk.core.config.c.auP;
            return p.ab(j10);
        }

        @Override // com.kwad.sdk.core.report.s
        public final int uI() {
            com.kwad.components.a.a.a aVar = (com.kwad.components.a.a.a) com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
            if (aVar != null) {
                return aVar.uI();
            }
            return 0;
        }

        @Override // com.kwad.sdk.core.report.s
        public final int zy() {
            return com.kwad.sdk.core.config.d.zy();
        }
    }

    /* renamed from: com.kwad.sdk.j$7 */
    public class AnonymousClass7 implements com.kwad.sdk.core.video.a.f {
        @Override // com.kwad.sdk.core.video.a.f
        public final boolean uJ() {
            return ((com.kwad.components.a.a.a) com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class)).uJ();
        }

        @Override // com.kwad.sdk.core.video.a.f
        public final boolean zA() {
            return com.kwad.sdk.core.config.d.zA();
        }

        @Override // com.kwad.sdk.core.video.a.f
        public final boolean zz() {
            return com.kwad.sdk.core.config.d.zz();
        }
    }

    /* renamed from: com.kwad.sdk.j$8 */
    public class AnonymousClass8 implements com.kwad.sdk.utils.b.b {
        @Override // com.kwad.sdk.utils.b.b
        public final void a(com.kwad.sdk.utils.b.a aVar) {
            if (aVar == null) {
                return;
            }
            com.kwad.sdk.commercial.b.b(aVar);
        }
    }

    public static class a implements com.kwad.sdk.service.a.a {
        private a() {
        }

        @Override // com.kwad.sdk.service.a.a
        public final void h(Context context, AdTemplate adTemplate) {
            com.kwad.components.core.e.d.a.a(new a.C0427a(context).au(adTemplate).ar(true));
        }

        public /* synthetic */ a(byte b10) {
            this();
        }
    }

    public static class b implements com.kwad.sdk.service.a.f {
        private b() {
        }

        @Override // com.kwad.sdk.service.a.f
        public final void a(String str, Map<String, String> map, String str2) {
            com.kwad.sdk.core.a.d.a(str, map, str2);
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean aM(AdTemplate adTemplate) {
            com.kwad.components.a.a.a aVar = (com.kwad.components.a.a.a) com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
            return aVar != null && aVar.uK();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String an(String str) {
            return com.kwad.sdk.core.a.d.an(str);
        }

        @Override // com.kwad.sdk.service.a.f
        public final String getApiVersion() {
            return l.At().getApiVersion();
        }

        @Override // com.kwad.sdk.service.a.f
        public final int getApiVersionCode() {
            return l.At().getApiVersionCode();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String getAppId() {
            return ServiceProvider.getAppId();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String getAppName() {
            return ServiceProvider.getAppName();
        }

        @Override // com.kwad.sdk.service.a.f
        public final Context getContext() {
            return ServiceProvider.getContext();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String getSDKVersion() {
            l.At();
            return l.getSDKVersion();
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean pz() {
            com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.d.f(com.kwad.components.core.n.a.a.a.class);
            if (aVar != null) {
                return aVar.pz();
            }
            return false;
        }

        @Override // com.kwad.sdk.service.a.f
        public final com.kwad.sdk.core.response.b.g uL() {
            com.kwad.components.a.a.a aVar = (com.kwad.components.a.a.a) com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
            if (aVar != null) {
                return aVar.uL();
            }
            return null;
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean zB() {
            return l.At().zB();
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean zC() {
            return l.At().zC();
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean zD() {
            return l.At().zD();
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean zE() {
            return l.At().zE();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String zF() {
            return com.kwad.sdk.kgeo.a.zF();
        }

        @Override // com.kwad.sdk.service.a.f
        public final com.kwad.sdk.core.b zG() {
            return com.kwad.sdk.kgeo.a.KH();
        }

        @Override // com.kwad.sdk.service.a.f
        public final List<AdTemplate> zH() {
            return com.kwad.sdk.core.download.b.EI().zH();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String zI() {
            return h.zj();
        }

        @Override // com.kwad.sdk.service.a.f
        public final JSONObject zJ() {
            return com.kwad.components.core.o.a.ri().m("", "").toJson();
        }

        @Override // com.kwad.sdk.service.a.f
        public final JSONObject zK() {
            return new com.kwad.sdk.core.report.f((List<com.kwad.sdk.core.report.n>) null).getBodyParams();
        }

        @Override // com.kwad.sdk.service.a.f
        public final Map<String, String> zL() {
            return new com.kwad.sdk.core.report.f((List<com.kwad.sdk.core.report.n>) null).getHeader();
        }

        public /* synthetic */ b(byte b10) {
            this();
        }
    }

    public static class c implements com.kwad.sdk.service.a.h {
        private c() {
        }

        @Override // com.kwad.sdk.service.a.h
        public final double Aa() {
            return com.kwad.sdk.core.config.d.Aa();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean Ab() {
            return com.kwad.sdk.core.config.d.Ab();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean Ac() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.awC);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean Ad() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.awD);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean Ae() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.awE);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean Af() {
            return com.kwad.sdk.core.config.d.Af();
        }

        @Override // com.kwad.sdk.service.a.h
        public final int Ag() {
            return com.kwad.sdk.core.config.d.Ag();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean Ah() {
            return com.kwad.sdk.core.config.d.Ah();
        }

        @Override // com.kwad.sdk.service.a.h
        public final String Ai() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.awM);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean Aj() {
            return com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.awQ);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean Ak() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.avp);
        }

        @Override // com.kwad.sdk.service.a.h
        public final String Al() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.avq);
        }

        @Override // com.kwad.sdk.service.a.h
        public final String Am() {
            return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.awW);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean An() {
            return com.kwad.sdk.core.config.c.axc.getValue().booleanValue();
        }

        @Override // com.kwad.sdk.service.a.h
        public final int Ao() {
            return com.kwad.sdk.core.config.c.axd.getValue().intValue();
        }

        @Override // com.kwad.sdk.service.a.h
        public final int aH(Context context) {
            return com.kwad.sdk.core.config.item.c.bk(context);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean ac(long j10) {
            return com.kwad.sdk.core.config.d.ac(j10);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean cb(String str) {
            return com.kwad.sdk.core.config.a.cb(str);
        }

        @Override // com.kwad.sdk.service.a.h
        public final int cc(String str) {
            return com.kwad.sdk.core.config.d.cc(str);
        }

        @Override // com.kwad.sdk.service.a.h
        public final int cd(String str) {
            return com.kwad.sdk.core.config.d.cd(str);
        }

        @Override // com.kwad.sdk.service.a.h
        public final <T> T getAppConfigData(T t10, com.kwad.sdk.f.b<JSONObject, T> bVar) {
            return (T) com.kwad.sdk.core.config.d.DA().getAppConfigData(null, bVar);
        }

        @Override // com.kwad.sdk.service.a.h
        public final String getAppId() {
            return ServiceProvider.getAppId();
        }

        @Override // com.kwad.sdk.service.a.h
        public final String getUserAgent() {
            return com.kwad.sdk.core.config.d.getUserAgent();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean xR() {
            return com.kwad.sdk.core.config.d.xR();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean zM() {
            return com.kwad.sdk.core.config.d.zM();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean zN() {
            return com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.avc);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean zO() {
            return com.kwad.sdk.core.config.d.zO();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean zP() {
            return com.kwad.sdk.core.config.d.zP();
        }

        @Override // com.kwad.sdk.service.a.h
        public final String zQ() {
            return com.kwad.sdk.core.config.d.zQ();
        }

        @Override // com.kwad.sdk.service.a.h
        public final String zR() {
            return com.kwad.sdk.core.config.d.zR();
        }

        @Override // com.kwad.sdk.service.a.h
        public final List<String> zS() {
            return com.kwad.sdk.core.config.d.zS();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean zT() {
            return com.kwad.sdk.core.config.d.zT();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean zU() {
            return com.kwad.sdk.core.config.d.zU();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean zV() {
            return com.kwad.sdk.core.config.d.DF();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean zW() {
            return com.kwad.sdk.core.config.d.zW();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean zX() {
            return com.kwad.sdk.core.config.d.zX();
        }

        @Override // com.kwad.sdk.service.a.h
        public final int zY() {
            return com.kwad.sdk.core.config.d.zY();
        }

        @Override // com.kwad.sdk.service.a.h
        public final int zZ() {
            return com.kwad.sdk.core.config.d.zZ();
        }

        public /* synthetic */ c(byte b10) {
            this();
        }
    }

    public static void zv() {
        ServiceProvider.put(com.kwad.sdk.service.a.f.class, new b((byte) 0));
        ServiceProvider.put(com.kwad.sdk.service.a.h.class, new c((byte) 0));
        ServiceProvider.put(com.kwad.sdk.service.a.e.class, new com.kwad.sdk.service.a.e() { // from class: com.kwad.sdk.j.1

            /* renamed from: com.kwad.sdk.j$1$1 */
            public class C05101 implements a.b {
                final /* synthetic */ com.kwad.sdk.service.a.c anX;

                public C05101(com.kwad.sdk.service.a.c cVar2) {
                    cVar = cVar2;
                }

                @Override // com.kwad.components.core.d.a.b
                public final String getKey() {
                    com.kwad.sdk.service.a.c cVar2 = cVar;
                    if (cVar2 != null) {
                        return cVar2.getKey();
                    }
                    return null;
                }

                @Override // com.kwad.components.core.d.a.b
                public final JSONObject getValue() {
                    com.kwad.sdk.service.a.c cVar2 = cVar;
                    if (cVar2 != null) {
                        return cVar2.getValue();
                    }
                    return null;
                }
            }

            /* renamed from: com.kwad.sdk.j$1$2 */
            public class AnonymousClass2 implements a.c {
                final /* synthetic */ com.kwad.sdk.service.a.g anZ;

                public AnonymousClass2(com.kwad.sdk.service.a.g gVar2) {
                    gVar = gVar2;
                }

                @Override // com.kwad.components.core.d.a.c
                public final void onCrashOccur(int i10, String str) {
                    com.kwad.sdk.service.a.g gVar2 = gVar;
                    if (gVar2 != null) {
                        gVar2.l(i10, str);
                    }
                }
            }

            @Override // com.kwad.sdk.service.a.e
            public final void G(String str, String str2) {
                com.kwad.components.core.d.a.j(str, str2);
            }

            @Override // com.kwad.sdk.service.a.e
            public final void a(com.kwad.sdk.service.a.c cVar2) {
                com.kwad.components.core.d.a.a(new a.b() { // from class: com.kwad.sdk.j.1.1
                    final /* synthetic */ com.kwad.sdk.service.a.c anX;

                    public C05101(com.kwad.sdk.service.a.c cVar22) {
                        cVar = cVar22;
                    }

                    @Override // com.kwad.components.core.d.a.b
                    public final String getKey() {
                        com.kwad.sdk.service.a.c cVar22 = cVar;
                        if (cVar22 != null) {
                            return cVar22.getKey();
                        }
                        return null;
                    }

                    @Override // com.kwad.components.core.d.a.b
                    public final JSONObject getValue() {
                        com.kwad.sdk.service.a.c cVar22 = cVar;
                        if (cVar22 != null) {
                            return cVar22.getValue();
                        }
                        return null;
                    }
                });
            }

            @Override // com.kwad.sdk.service.a.e
            public final void gatherException(Throwable th2) {
                com.kwad.components.core.d.a.reportSdkCaughtException(th2);
            }

            @Override // com.kwad.sdk.service.a.e
            public final void a(com.kwad.sdk.service.a.g gVar2) {
                com.kwad.components.core.d.a.a(new a.c() { // from class: com.kwad.sdk.j.1.2
                    final /* synthetic */ com.kwad.sdk.service.a.g anZ;

                    public AnonymousClass2(com.kwad.sdk.service.a.g gVar22) {
                        gVar = gVar22;
                    }

                    @Override // com.kwad.components.core.d.a.c
                    public final void onCrashOccur(int i10, String str) {
                        com.kwad.sdk.service.a.g gVar22 = gVar;
                        if (gVar22 != null) {
                            gVar22.l(i10, str);
                        }
                    }
                });
            }
        });
        ServiceProvider.put(com.kwad.sdk.service.a.d.class, new com.kwad.sdk.service.a.d() { // from class: com.kwad.sdk.j.2
            @Override // com.kwad.sdk.service.a.d
            public final void a(boolean z10, String str, String str2, String str3) {
                com.kwad.sdk.core.diskcache.b.a.EG().dD(str);
            }

            @Override // com.kwad.sdk.service.a.d
            public final File ca(String str) {
                return com.kwad.sdk.core.diskcache.b.a.EG().ca(str);
            }
        });
        ServiceProvider.put(com.kwad.sdk.service.a.j.class, new com.kwad.sdk.service.a.j() { // from class: com.kwad.sdk.j.3
            @Override // com.kwad.sdk.service.a.j
            public final boolean rD() {
                com.kwad.components.core.p.b.rC();
                return com.kwad.components.core.p.b.rD();
            }

            @Override // com.kwad.sdk.service.a.j
            public final int rE() {
                com.kwad.components.core.p.b.rC();
                return com.kwad.components.core.p.b.rE();
            }

            @Override // com.kwad.sdk.service.a.j
            public final int rF() {
                return com.kwad.components.core.p.b.rC().rF();
            }

            @Override // com.kwad.sdk.service.a.j
            public final InputStream wrapInputStream(InputStream inputStream) {
                com.kwad.components.core.p.b.rC();
                return com.kwad.components.core.p.b.wrapInputStream(inputStream);
            }
        });
        ServiceProvider.put(com.kwad.sdk.core.network.k.class, new com.kwad.sdk.core.network.k() { // from class: com.kwad.sdk.j.4
            @Override // com.kwad.sdk.core.network.k
            public final void a(com.kwad.sdk.core.network.j jVar) {
                com.kwad.sdk.commercial.b.b(jVar);
            }

            @Override // com.kwad.sdk.core.network.k
            public final com.kwad.sdk.core.b zw() {
                return com.kwad.components.core.request.model.b.rB();
            }

            @Override // com.kwad.sdk.core.network.k
            public final void a(com.kwad.sdk.core.network.i iVar) {
                com.kwad.sdk.commercial.b.b(iVar);
            }
        });
        ImageLoaderProxy imageLoaderProxy = ImageLoaderProxy.INSTANCE;
        ServiceProvider.put(com.kwad.sdk.service.a.i.class, imageLoaderProxy);
        int a10 = com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.aws);
        if (a10 > 0) {
            imageLoaderProxy.setCacheSize(a10);
        }
        ServiceProvider.put(com.kwad.sdk.service.a.b.class, new com.kwad.sdk.service.a.b() { // from class: com.kwad.sdk.j.5
            @Override // com.kwad.sdk.service.a.b
            public final void H(String str, String str2) {
                com.kwad.sdk.core.d.c.e("image_load_failed_info", "errorMsg:" + str2 + "\nurl:" + str);
            }

            @Override // com.kwad.sdk.service.a.b
            public final void aL(AdTemplate adTemplate) {
                com.kwad.components.core.o.a.ri().f(adTemplate, 21007);
            }

            @Override // com.kwad.sdk.service.a.b
            public final void e(@NonNull JSONObject jSONObject, int i10) {
                com.kwad.components.core.o.a.ri().e(jSONObject, i10);
            }

            @Override // com.kwad.sdk.service.a.b
            public final void zx() {
                com.kwad.components.core.o.a.ri().as(ServiceProvider.getContext());
            }
        });
        ServiceProvider.put(s.class, new s() { // from class: com.kwad.sdk.j.6
            @Override // com.kwad.sdk.core.report.s
            public final boolean ab(long j10) {
                p pVar = com.kwad.sdk.core.config.c.auP;
                return p.ab(j10);
            }

            @Override // com.kwad.sdk.core.report.s
            public final int uI() {
                com.kwad.components.a.a.a aVar = (com.kwad.components.a.a.a) com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
                if (aVar != null) {
                    return aVar.uI();
                }
                return 0;
            }

            @Override // com.kwad.sdk.core.report.s
            public final int zy() {
                return com.kwad.sdk.core.config.d.zy();
            }
        });
        ServiceProvider.put(com.kwad.sdk.core.video.a.f.class, new com.kwad.sdk.core.video.a.f() { // from class: com.kwad.sdk.j.7
            @Override // com.kwad.sdk.core.video.a.f
            public final boolean uJ() {
                return ((com.kwad.components.a.a.a) com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class)).uJ();
            }

            @Override // com.kwad.sdk.core.video.a.f
            public final boolean zA() {
                return com.kwad.sdk.core.config.d.zA();
            }

            @Override // com.kwad.sdk.core.video.a.f
            public final boolean zz() {
                return com.kwad.sdk.core.config.d.zz();
            }
        });
        ServiceProvider.put(com.kwad.sdk.utils.b.b.class, new com.kwad.sdk.utils.b.b() { // from class: com.kwad.sdk.j.8
            @Override // com.kwad.sdk.utils.b.b
            public final void a(com.kwad.sdk.utils.b.a aVar) {
                if (aVar == null) {
                    return;
                }
                com.kwad.sdk.commercial.b.b(aVar);
            }
        });
        ServiceProvider.put(com.kwad.sdk.service.a.a.class, new a((byte) 0));
    }
}
