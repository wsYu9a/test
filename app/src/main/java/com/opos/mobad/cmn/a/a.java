package com.opos.mobad.cmn.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.view.View;
import com.cdo.oaps.ad.OapsKey;
import com.opos.cmn.i.k;
import com.opos.cmn.i.o;
import com.opos.mobad.cmn.a.b.f;
import com.opos.mobad.cmn.a.d;
import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.data.ActivatingData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.ApkSignerData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.service.event.EventDescription;
import com.opos.mobad.service.g.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static final String f20048a = com.opos.cmn.an.a.b.a("aGV5dGFwX3VuaW9uX3Rva2Vu");

    /* renamed from: b */
    private Context f20049b;

    /* renamed from: c */
    private String f20050c;

    /* renamed from: d */
    private com.opos.mobad.cmn.a.d f20051d;

    /* renamed from: e */
    private b f20052e;

    /* renamed from: com.opos.mobad.cmn.a.a$1 */
    class AnonymousClass1 implements InterfaceC0429a {

        /* renamed from: a */
        final /* synthetic */ AdItemData f20053a;

        /* renamed from: b */
        final /* synthetic */ boolean f20054b;

        /* renamed from: c */
        final /* synthetic */ int[] f20055c;

        /* renamed from: d */
        final /* synthetic */ Map f20056d;

        /* renamed from: e */
        final /* synthetic */ com.opos.mobad.cmn.a.b.a f20057e;

        /* renamed from: f */
        final /* synthetic */ b.InterfaceC0437b f20058f;

        /* renamed from: g */
        final /* synthetic */ com.opos.mobad.cmn.a.b f20059g;

        /* renamed from: h */
        final /* synthetic */ c f20060h;

        AnonymousClass1(AdItemData adItemData, boolean z, int[] iArr, Map map, com.opos.mobad.cmn.a.b.a aVar, b.InterfaceC0437b interfaceC0437b, com.opos.mobad.cmn.a.b bVar, c cVar) {
            adItemData = adItemData;
            z = z;
            iArr = iArr;
            hashMap = map;
            aVar = aVar;
            interfaceC0437b = interfaceC0437b;
            bVar = bVar;
            cVar = cVar;
        }

        @Override // com.opos.mobad.cmn.a.a.InterfaceC0429a
        public void a() {
            com.opos.cmn.an.f.a.b("AdHandler", "download confirm");
            f.a(false);
            a.this.a(adItemData, z, iArr, (Map<String, String>) hashMap, aVar, false, interfaceC0437b, bVar, cVar);
        }

        @Override // com.opos.mobad.cmn.a.a.InterfaceC0429a
        public void b() {
            com.opos.cmn.an.f.a.b("AdHandler", "download cancel");
            a.this.a(adItemData, z, iArr, (Map<String, String>) hashMap, aVar, true, interfaceC0437b, bVar, cVar);
        }
    }

    /* renamed from: com.opos.mobad.cmn.a.a$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AdItemData f20062a;

        /* renamed from: b */
        final /* synthetic */ int f20063b;

        /* renamed from: c */
        final /* synthetic */ MaterialData f20064c;

        /* renamed from: d */
        final /* synthetic */ boolean f20065d;

        /* renamed from: e */
        final /* synthetic */ int[] f20066e;

        /* renamed from: f */
        final /* synthetic */ Map f20067f;

        /* renamed from: g */
        final /* synthetic */ com.opos.mobad.service.g.a f20068g;

        /* renamed from: h */
        final /* synthetic */ com.opos.mobad.cmn.a.b f20069h;

        /* renamed from: i */
        final /* synthetic */ c f20070i;

        /* renamed from: j */
        final /* synthetic */ b.InterfaceC0437b f20071j;
        final /* synthetic */ boolean k;

        AnonymousClass2(AdItemData adItemData, int i2, MaterialData materialData, boolean z, int[] iArr, Map map, com.opos.mobad.service.g.a aVar, com.opos.mobad.cmn.a.b bVar, c cVar, b.InterfaceC0437b interfaceC0437b, boolean z2) {
            adItemData = adItemData;
            i2 = i2;
            materialData = materialData;
            z = z;
            iArr = iArr;
            map = map;
            aVar = aVar;
            bVar = bVar;
            cVar = cVar;
            interfaceC0437b = interfaceC0437b;
            z2 = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.opos.cmn.an.f.a.b("AdHandler", "handleAdClickActionAndSTEvent adItemData=", adItemData);
            adItemData.b();
            switch (i2) {
                case 1:
                    a.this.d(adItemData, materialData, z, iArr, (Map<String, String>) map, aVar, (b.InterfaceC0437b) null, bVar, cVar);
                    break;
                case 2:
                    if (!com.opos.cmn.an.h.d.a.d(a.this.f20049b, materialData.k())) {
                        if (1 != materialData.L()) {
                            if (2 != materialData.L()) {
                                if (3 != materialData.L()) {
                                    a aVar = a.this;
                                    AdItemData adItemData = adItemData;
                                    MaterialData materialData = materialData;
                                    aVar.a(adItemData, materialData, materialData.t(), z, iArr, map, aVar, interfaceC0437b, materialData.R(), materialData.S(), bVar, cVar);
                                    break;
                                } else {
                                    a aVar2 = a.this;
                                    AdItemData adItemData2 = adItemData;
                                    MaterialData materialData2 = materialData;
                                    aVar2.a(adItemData2, materialData2, materialData2.t(), z, iArr, (Map<String, String>) map, aVar, interfaceC0437b, true, cVar);
                                    break;
                                }
                            } else {
                                a.this.a(adItemData, materialData, z, iArr, (Map<String, String>) map, aVar, z2, interfaceC0437b, bVar, cVar);
                                break;
                            }
                        } else {
                            a aVar3 = a.this;
                            AdItemData adItemData3 = adItemData;
                            MaterialData materialData3 = materialData;
                            aVar3.a(adItemData3, materialData3, materialData3.t(), z, iArr, (Map<String, String>) map, aVar, interfaceC0437b, false, cVar);
                            break;
                        }
                    } else {
                        a.this.a(adItemData, materialData, z, iArr, (Map<String, String>) map, aVar, interfaceC0437b, bVar, cVar);
                        break;
                    }
                case 3:
                    if (!com.opos.cmn.an.h.d.a.d(a.this.f20049b, materialData.k())) {
                        a.this.b(adItemData, materialData, z, iArr, (Map<String, String>) map, aVar, interfaceC0437b, bVar, cVar);
                        break;
                    } else {
                        a.this.a(adItemData, materialData, z, iArr, (Map<String, String>) map, aVar, interfaceC0437b, bVar, cVar);
                        break;
                    }
                case 4:
                    a.this.b(adItemData, materialData, z, iArr, (Map<String, String>) map, aVar, bVar, cVar);
                    break;
                case 5:
                    a.this.c(adItemData, materialData, z, iArr, map, aVar, bVar, cVar);
                    break;
                case 6:
                    a.this.c(adItemData, materialData, z, iArr, (Map<String, String>) map, aVar, (b.InterfaceC0437b) null, bVar, cVar);
                    break;
                case 7:
                    a.this.e(adItemData, materialData, z, iArr, (Map<String, String>) map, aVar, (b.InterfaceC0437b) null, bVar, cVar);
                    break;
                default:
                    a.this.a(0, -2, cVar);
                    break;
            }
        }
    }

    /* renamed from: com.opos.mobad.cmn.a.a$3 */
    class AnonymousClass3 implements d.a {

        /* renamed from: a */
        final /* synthetic */ Map f20072a;

        /* renamed from: b */
        final /* synthetic */ AdItemData f20073b;

        /* renamed from: c */
        final /* synthetic */ MaterialData f20074c;

        /* renamed from: d */
        final /* synthetic */ boolean f20075d;

        /* renamed from: e */
        final /* synthetic */ int[] f20076e;

        /* renamed from: f */
        final /* synthetic */ com.opos.mobad.service.g.a f20077f;

        /* renamed from: g */
        final /* synthetic */ c f20078g;

        /* renamed from: h */
        final /* synthetic */ b.InterfaceC0437b f20079h;

        /* renamed from: i */
        final /* synthetic */ com.opos.mobad.cmn.a.b f20080i;

        AnonymousClass3(Map map, AdItemData adItemData, MaterialData materialData, boolean z, int[] iArr, com.opos.mobad.service.g.a aVar, c cVar, b.InterfaceC0437b interfaceC0437b, com.opos.mobad.cmn.a.b bVar) {
            hashMap = map;
            adItemData = adItemData;
            materialData = materialData;
            z = z;
            iArr = iArr;
            aVar = aVar;
            cVar = cVar;
            interfaceC0437b = interfaceC0437b;
            bVar = bVar;
        }

        @Override // com.opos.mobad.cmn.a.d.a
        public void a() {
            hashMap.put("jumpRet", "1");
            com.opos.mobad.cmn.a.b.d.a(a.this.f20049b, a.this.f20050c, adItemData, materialData, z, iArr, (Map<String, String>) hashMap);
            aVar.a(a.b.INSTANT).a("1");
            aVar.a(a.this.f20049b);
            a.this.a(6, cVar);
            com.opos.cmn.an.f.a.a("AdHandler", "handleInstantAndSTEvent open instant success.");
        }

        @Override // com.opos.mobad.cmn.a.d.a
        public void a(int i2, String str) {
            a.this.a(materialData.m(), adItemData, z, iArr, aVar, interfaceC0437b, bVar, cVar);
            hashMap.put("jumpRet", i2 + "");
            com.opos.mobad.cmn.a.b.d.a(a.this.f20049b, a.this.f20050c, adItemData, materialData, z, iArr, (Map<String, String>) hashMap);
            com.opos.cmn.an.f.a.a("AdHandler", "handleInstantAndSTEvent open instant fail.open web, code:" + i2 + ",msg:" + str);
        }
    }

    /* renamed from: com.opos.mobad.cmn.a.a$4 */
    class AnonymousClass4 implements b.InterfaceC0437b {

        /* renamed from: a */
        final /* synthetic */ b.InterfaceC0437b f20082a;

        /* renamed from: b */
        final /* synthetic */ MaterialData f20083b;

        AnonymousClass4(b.InterfaceC0437b interfaceC0437b, MaterialData materialData) {
            interfaceC0437b = interfaceC0437b;
            materialData = materialData;
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void a(AdItemData adItemData, String str) {
            com.opos.cmn.an.f.a.b("AdHandler", "notifyInstallCompletedEvent pkgName = " + str);
            b.InterfaceC0437b interfaceC0437b = interfaceC0437b;
            if (interfaceC0437b != null) {
                interfaceC0437b.a(adItemData, str);
            }
            if (materialData.Q() != null && materialData.Q().size() > 0) {
                com.opos.mobad.service.g.b.a().a(materialData.Q()).a(a.this.f20049b);
            }
            com.opos.mobad.cmn.service.a.a.a(a.this.f20049b).c(str);
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void b(AdItemData adItemData, String str) {
            b.InterfaceC0437b interfaceC0437b = interfaceC0437b;
            if (interfaceC0437b != null) {
                interfaceC0437b.b(adItemData, str);
            }
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void c(AdItemData adItemData, String str) {
            b.InterfaceC0437b interfaceC0437b = interfaceC0437b;
            if (interfaceC0437b != null) {
                interfaceC0437b.c(adItemData, str);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj || (obj != null && obj.hashCode() == hashCode())) {
                return true;
            }
            return super.equals(obj);
        }

        public int hashCode() {
            String aa = materialData.aa();
            return TextUtils.isEmpty(aa) ? super.hashCode() : aa.hashCode();
        }
    }

    /* renamed from: com.opos.mobad.cmn.a.a$5 */
    class AnonymousClass5 implements com.opos.mobad.cmn.service.a.c {

        /* renamed from: a */
        final /* synthetic */ AdItemData f20085a;

        /* renamed from: b */
        final /* synthetic */ MaterialData f20086b;

        AnonymousClass5(AdItemData adItemData, MaterialData materialData) {
            adItemData = adItemData;
            materialData = materialData;
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void a(int i2, int i3, String str, String str2) {
            if (adItemData.L()) {
                return;
            }
            adItemData.f(true);
            Context context = a.this.f20049b;
            AdItemData adItemData = adItemData;
            com.opos.mobad.cmn.a.b.d.b(context, adItemData, adItemData.i().get(0));
            if (materialData.O() == null || materialData.O().size() <= 0) {
                return;
            }
            com.opos.mobad.service.g.b.a().a(materialData.O()).a(a.this.f20049b);
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void a(int i2, int i3, String str, String str2, String str3) {
            Context context = a.this.f20049b;
            AdItemData adItemData = adItemData;
            com.opos.mobad.cmn.a.b.d.a(context, adItemData, adItemData.i().get(0), str3);
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void b(int i2, int i3, String str, String str2) {
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void c(int i2, int i3, String str, String str2) {
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void d(int i2, int i3, String str, String str2) {
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void e(int i2, int i3, String str, String str2) {
        }

        public boolean equals(Object obj) {
            if (this == obj || (obj != null && obj.hashCode() == hashCode())) {
                return true;
            }
            return super.equals(obj);
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void f(int i2, int i3, String str, String str2) {
            if (adItemData.M()) {
                return;
            }
            adItemData.g(true);
            Context context = a.this.f20049b;
            AdItemData adItemData = adItemData;
            com.opos.mobad.cmn.a.b.d.c(context, adItemData, adItemData.i().get(0));
            if (materialData.P() == null || materialData.P().size() <= 0) {
                return;
            }
            com.opos.mobad.service.g.b.a().a(materialData.P()).a(a.this.f20049b);
        }

        public int hashCode() {
            String aa = materialData.aa();
            return TextUtils.isEmpty(aa) ? super.hashCode() : aa.hashCode();
        }
    }

    /* renamed from: com.opos.mobad.cmn.a.a$6 */
    static /* synthetic */ class AnonymousClass6 {

        /* renamed from: a */
        static final /* synthetic */ int[] f20088a;

        static {
            int[] iArr = new int[com.opos.mobad.cmn.a.b.a.values().length];
            f20088a = iArr;
            try {
                iArr[com.opos.mobad.cmn.a.b.a.Video.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20088a[com.opos.mobad.cmn.a.b.a.ClickBt.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20088a[com.opos.mobad.cmn.a.b.a.NonClickBt.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20088a[com.opos.mobad.cmn.a.b.a.FloatLayerClickBt.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f20088a[com.opos.mobad.cmn.a.b.a.FloatLayerNonClickBt.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f20088a[com.opos.mobad.cmn.a.b.a.Pendant.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: com.opos.mobad.cmn.a.a$a */
    public interface InterfaceC0429a {
        void a();

        void b();
    }

    public interface b {
        void a();

        void a(InterfaceC0429a interfaceC0429a);
    }

    public interface c {
        void a(int i2);

        void a(int i2, int i3);
    }

    private static class d {

        /* renamed from: a */
        private String f20089a;

        /* renamed from: b */
        private String f20090b;

        /* renamed from: c */
        private String f20091c;

        /* renamed from: d */
        private Signature f20092d;

        public d(Signature signature) {
            this.f20092d = signature;
        }

        public String a() {
            if (TextUtils.isEmpty(this.f20089a)) {
                try {
                    this.f20089a = k.a("md5", this.f20092d);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b("AdHandler", "", e2);
                }
            }
            return this.f20089a;
        }

        public String b() {
            if (TextUtils.isEmpty(this.f20090b)) {
                try {
                    this.f20090b = k.a("sha1", this.f20092d);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b("AdHandler", "", e2);
                }
            }
            return this.f20090b;
        }

        public String c() {
            if (TextUtils.isEmpty(this.f20091c)) {
                try {
                    this.f20091c = k.a("sha256", this.f20092d);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b("AdHandler", "", e2);
                }
            }
            return this.f20091c;
        }
    }

    public a(Context context, String str, com.opos.mobad.cmn.a.d dVar) {
        this.f20049b = com.opos.mobad.service.b.a(context);
        this.f20050c = str;
        this.f20051d = dVar;
    }

    private int a(ApkSignerData apkSignerData, List<d> list) {
        if (TextUtils.isEmpty(apkSignerData.f21698a) && TextUtils.isEmpty(apkSignerData.f21699b) && TextUtils.isEmpty(apkSignerData.f21700c)) {
            return -1;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            d dVar = list.get(i2);
            if ((TextUtils.isEmpty(apkSignerData.f21698a) || apkSignerData.f21698a.equals(dVar.a())) && ((TextUtils.isEmpty(apkSignerData.f21699b) || apkSignerData.f21699b.equals(dVar.b())) && (TextUtils.isEmpty(apkSignerData.f21700c) || apkSignerData.f21700c.equals(dVar.c())))) {
                return i2;
            }
        }
        return -1;
    }

    private int a(MaterialData materialData) {
        int D = materialData != null ? materialData.D() : 0;
        com.opos.cmn.an.f.a.b("AdHandler", "getSurfingType=" + D);
        return D;
    }

    public void a(int i2, int i3, c cVar) {
        if (cVar != null) {
            cVar.a(i2, i3);
        }
    }

    public void a(int i2, c cVar) {
        if (cVar != null) {
            cVar.a(i2);
        }
    }

    private void a(int i2, AdItemData adItemData, MaterialData materialData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, boolean z2, b.InterfaceC0437b interfaceC0437b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        com.opos.cmn.an.j.b.d(new Runnable() { // from class: com.opos.mobad.cmn.a.a.2

            /* renamed from: a */
            final /* synthetic */ AdItemData f20062a;

            /* renamed from: b */
            final /* synthetic */ int f20063b;

            /* renamed from: c */
            final /* synthetic */ MaterialData f20064c;

            /* renamed from: d */
            final /* synthetic */ boolean f20065d;

            /* renamed from: e */
            final /* synthetic */ int[] f20066e;

            /* renamed from: f */
            final /* synthetic */ Map f20067f;

            /* renamed from: g */
            final /* synthetic */ com.opos.mobad.service.g.a f20068g;

            /* renamed from: h */
            final /* synthetic */ com.opos.mobad.cmn.a.b f20069h;

            /* renamed from: i */
            final /* synthetic */ c f20070i;

            /* renamed from: j */
            final /* synthetic */ b.InterfaceC0437b f20071j;
            final /* synthetic */ boolean k;

            AnonymousClass2(AdItemData adItemData2, int i22, MaterialData materialData2, boolean z3, int[] iArr2, Map map2, com.opos.mobad.service.g.a aVar2, com.opos.mobad.cmn.a.b bVar2, c cVar2, b.InterfaceC0437b interfaceC0437b2, boolean z22) {
                adItemData = adItemData2;
                i2 = i22;
                materialData = materialData2;
                z = z3;
                iArr = iArr2;
                map = map2;
                aVar = aVar2;
                bVar = bVar2;
                cVar = cVar2;
                interfaceC0437b = interfaceC0437b2;
                z2 = z22;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.an.f.a.b("AdHandler", "handleAdClickActionAndSTEvent adItemData=", adItemData);
                adItemData.b();
                switch (i2) {
                    case 1:
                        a.this.d(adItemData, materialData, z, iArr, (Map<String, String>) map, aVar, (b.InterfaceC0437b) null, bVar, cVar);
                        break;
                    case 2:
                        if (!com.opos.cmn.an.h.d.a.d(a.this.f20049b, materialData.k())) {
                            if (1 != materialData.L()) {
                                if (2 != materialData.L()) {
                                    if (3 != materialData.L()) {
                                        a aVar2 = a.this;
                                        AdItemData adItemData2 = adItemData;
                                        MaterialData materialData2 = materialData;
                                        aVar2.a(adItemData2, materialData2, materialData2.t(), z, iArr, map, aVar, interfaceC0437b, materialData.R(), materialData.S(), bVar, cVar);
                                        break;
                                    } else {
                                        a aVar22 = a.this;
                                        AdItemData adItemData22 = adItemData;
                                        MaterialData materialData22 = materialData;
                                        aVar22.a(adItemData22, materialData22, materialData22.t(), z, iArr, (Map<String, String>) map, aVar, interfaceC0437b, true, cVar);
                                        break;
                                    }
                                } else {
                                    a.this.a(adItemData, materialData, z, iArr, (Map<String, String>) map, aVar, z2, interfaceC0437b, bVar, cVar);
                                    break;
                                }
                            } else {
                                a aVar3 = a.this;
                                AdItemData adItemData3 = adItemData;
                                MaterialData materialData3 = materialData;
                                aVar3.a(adItemData3, materialData3, materialData3.t(), z, iArr, (Map<String, String>) map, aVar, interfaceC0437b, false, cVar);
                                break;
                            }
                        } else {
                            a.this.a(adItemData, materialData, z, iArr, (Map<String, String>) map, aVar, interfaceC0437b, bVar, cVar);
                            break;
                        }
                    case 3:
                        if (!com.opos.cmn.an.h.d.a.d(a.this.f20049b, materialData.k())) {
                            a.this.b(adItemData, materialData, z, iArr, (Map<String, String>) map, aVar, interfaceC0437b, bVar, cVar);
                            break;
                        } else {
                            a.this.a(adItemData, materialData, z, iArr, (Map<String, String>) map, aVar, interfaceC0437b, bVar, cVar);
                            break;
                        }
                    case 4:
                        a.this.b(adItemData, materialData, z, iArr, (Map<String, String>) map, aVar, bVar, cVar);
                        break;
                    case 5:
                        a.this.c(adItemData, materialData, z, iArr, map, aVar, bVar, cVar);
                        break;
                    case 6:
                        a.this.c(adItemData, materialData, z, iArr, (Map<String, String>) map, aVar, (b.InterfaceC0437b) null, bVar, cVar);
                        break;
                    case 7:
                        a.this.e(adItemData, materialData, z, iArr, (Map<String, String>) map, aVar, (b.InterfaceC0437b) null, bVar, cVar);
                        break;
                    default:
                        a.this.a(0, -2, cVar);
                        break;
                }
            }
        });
    }

    private void a(AdItemData adItemData, MaterialData materialData, b.InterfaceC0437b interfaceC0437b) {
        if (adItemData == null || materialData == null) {
            return;
        }
        com.opos.cmn.an.f.a.b("AdHandler", "pkgInstallListener :" + interfaceC0437b);
        if (interfaceC0437b == null) {
            com.opos.mobad.cmn.service.pkginstall.b.a(this.f20049b).a(materialData.k(), adItemData);
        } else {
            com.opos.mobad.cmn.service.pkginstall.b.a(this.f20049b).a(materialData.k(), interfaceC0437b, adItemData);
        }
    }

    public void a(AdItemData adItemData, MaterialData materialData, String str, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, b.InterfaceC0437b interfaceC0437b, String str2, String str3, com.opos.mobad.cmn.a.b bVar, c cVar) {
        if (adItemData == null || materialData == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("handleDLApkAndSTEvent pkgName=");
        sb.append(materialData.k());
        sb.append(",posId=");
        sb.append(this.f20050c);
        sb.append(",channelPkg=");
        sb.append(str != null ? str : "null");
        sb.append(",trackContent=");
        sb.append(str2 != null ? str2 : "null");
        sb.append(",trackReference=");
        sb.append(str3 != null ? str3 : "null");
        com.opos.cmn.an.f.a.b("AdHandler", sb.toString());
        HashMap hashMap = new HashMap();
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        if (!com.opos.cmn.an.c.a.a(str)) {
            hashMap.put("dlChannel", str);
        }
        if (this.f20051d.a(this.f20049b, materialData.k(), this.f20050c, str, materialData.q(), str2, str3)) {
            a(adItemData, materialData, interfaceC0437b);
            hashMap.put("jumpRet", "1");
            aVar.a(a.b.MARKET).a("1");
            com.opos.cmn.an.f.a.a("AdHandler", "handleDLApkAndSTEvent pkgName" + materialData.k() + " = true");
            a(1, cVar);
        } else {
            hashMap.put("jumpRet", "0");
            aVar.a(a.b.MARKET).a("0");
            com.opos.cmn.an.f.a.a("AdHandler", "handleDLApkAndSTEvent pkgName=" + materialData.k() + " = false");
            a(1, -2, cVar);
        }
        com.opos.mobad.cmn.a.b.d.a(this.f20049b, this.f20050c, adItemData, materialData, z, iArr, hashMap);
        aVar.a(this.f20049b);
    }

    public void a(AdItemData adItemData, MaterialData materialData, String str, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, b.InterfaceC0437b interfaceC0437b, boolean z2, c cVar) {
        if (adItemData == null || materialData == null) {
            return;
        }
        com.opos.cmn.an.f.a.b("AdHandler", "handleDeeplinkDLApkAndSTEvent pkgName=" + materialData.k() + ",posId=" + this.f20050c + ",isSafeJump = " + z2);
        HashMap hashMap = new HashMap();
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        if (!com.opos.cmn.an.c.a.a(str)) {
            hashMap.put("dlChannel", str);
        }
        com.opos.mobad.cmn.a.d dVar = this.f20051d;
        if (z2 ? dVar.e(this.f20049b, materialData.M()) : dVar.d(this.f20049b, materialData.M())) {
            a(adItemData, materialData, interfaceC0437b);
            hashMap.put("jumpRet", "1");
            aVar.a(a.b.MARKET).a("1");
            com.opos.cmn.an.f.a.b("AdHandler", "handleDeeplinkDLApkAndSTEvent pkgName" + materialData.k() + " = true");
            a(1, cVar);
        } else {
            hashMap.put("jumpRet", "0");
            aVar.a(a.b.MARKET).a("0");
            com.opos.cmn.an.f.a.b("AdHandler", "handleDeeplinkDLApkAndSTEvent pkgName=" + materialData.k() + " = false");
            a(1, -1, cVar);
        }
        com.opos.mobad.cmn.a.b.d.a(this.f20049b, this.f20050c, adItemData, materialData, z, iArr, hashMap);
        aVar.a(this.f20049b);
    }

    public void a(AdItemData adItemData, MaterialData materialData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, b.InterfaceC0437b interfaceC0437b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        int I = materialData.I();
        if (!(I != 1 ? I != 2 ? false : a(adItemData, materialData, z, iArr, map, aVar, bVar, cVar) : b(adItemData, materialData, z, iArr, map, aVar, bVar, cVar)) || interfaceC0437b == null) {
            return;
        }
        interfaceC0437b.b(adItemData, materialData.k());
    }

    public void a(AdItemData adItemData, MaterialData materialData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, boolean z2, b.InterfaceC0437b interfaceC0437b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        if (adItemData == null || materialData == null) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            if (map != null && map.size() > 0) {
                hashMap.putAll(map);
            }
            if (materialData.N() == null) {
                return;
            }
            String a2 = materialData.N().a();
            String c2 = materialData.N().c();
            String d2 = materialData.N().d();
            String b2 = materialData.N().b();
            com.opos.cmn.an.f.a.b("AdHandler", "handleDownloaderAndSTEvent pkgName=" + c2 + ",appName=" + d2 + ",md5=" + b2 + ",url=" + a2);
            if (!com.opos.cmn.an.c.a.a(materialData.t())) {
                hashMap.put("dlChannel", materialData.t());
            }
            if (z2 || TextUtils.isEmpty(a2) || TextUtils.isEmpty(c2)) {
                hashMap.put("jumpRet", "0");
                aVar.a(a.b.DOWNLOADER).a("0");
                com.opos.mobad.cmn.a.b.d.d(this.f20049b, this.f20050c, adItemData, materialData, z, iArr, hashMap);
                a(7, -1, cVar);
            } else {
                a(adItemData, materialData, new b.InterfaceC0437b() { // from class: com.opos.mobad.cmn.a.a.4

                    /* renamed from: a */
                    final /* synthetic */ b.InterfaceC0437b f20082a;

                    /* renamed from: b */
                    final /* synthetic */ MaterialData f20083b;

                    AnonymousClass4(b.InterfaceC0437b interfaceC0437b2, MaterialData materialData2) {
                        interfaceC0437b = interfaceC0437b2;
                        materialData = materialData2;
                    }

                    @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
                    public void a(AdItemData adItemData2, String str) {
                        com.opos.cmn.an.f.a.b("AdHandler", "notifyInstallCompletedEvent pkgName = " + str);
                        b.InterfaceC0437b interfaceC0437b2 = interfaceC0437b;
                        if (interfaceC0437b2 != null) {
                            interfaceC0437b2.a(adItemData2, str);
                        }
                        if (materialData.Q() != null && materialData.Q().size() > 0) {
                            com.opos.mobad.service.g.b.a().a(materialData.Q()).a(a.this.f20049b);
                        }
                        com.opos.mobad.cmn.service.a.a.a(a.this.f20049b).c(str);
                    }

                    @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
                    public void b(AdItemData adItemData2, String str) {
                        b.InterfaceC0437b interfaceC0437b2 = interfaceC0437b;
                        if (interfaceC0437b2 != null) {
                            interfaceC0437b2.b(adItemData2, str);
                        }
                    }

                    @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
                    public void c(AdItemData adItemData2, String str) {
                        b.InterfaceC0437b interfaceC0437b2 = interfaceC0437b;
                        if (interfaceC0437b2 != null) {
                            interfaceC0437b2.c(adItemData2, str);
                        }
                    }

                    public boolean equals(Object obj) {
                        if (this == obj || (obj != null && obj.hashCode() == hashCode())) {
                            return true;
                        }
                        return super.equals(obj);
                    }

                    public int hashCode() {
                        String aa = materialData.aa();
                        return TextUtils.isEmpty(aa) ? super.hashCode() : aa.hashCode();
                    }
                });
                com.opos.mobad.cmn.service.a.a.a(this.f20049b).a(com.opos.mobad.service.f.b().d(), com.opos.mobad.service.f.b().e());
                com.opos.mobad.cmn.service.a.a.a(this.f20049b).a(a2, c2, b2, d2, new com.opos.mobad.cmn.service.a.c() { // from class: com.opos.mobad.cmn.a.a.5

                    /* renamed from: a */
                    final /* synthetic */ AdItemData f20085a;

                    /* renamed from: b */
                    final /* synthetic */ MaterialData f20086b;

                    AnonymousClass5(AdItemData adItemData2, MaterialData materialData2) {
                        adItemData = adItemData2;
                        materialData = materialData2;
                    }

                    @Override // com.opos.mobad.cmn.service.a.c
                    public void a(int i2, int i3, String str, String str2) {
                        if (adItemData.L()) {
                            return;
                        }
                        adItemData.f(true);
                        Context context = a.this.f20049b;
                        AdItemData adItemData2 = adItemData;
                        com.opos.mobad.cmn.a.b.d.b(context, adItemData2, adItemData2.i().get(0));
                        if (materialData.O() == null || materialData.O().size() <= 0) {
                            return;
                        }
                        com.opos.mobad.service.g.b.a().a(materialData.O()).a(a.this.f20049b);
                    }

                    @Override // com.opos.mobad.cmn.service.a.c
                    public void a(int i2, int i3, String str, String str2, String str3) {
                        Context context = a.this.f20049b;
                        AdItemData adItemData2 = adItemData;
                        com.opos.mobad.cmn.a.b.d.a(context, adItemData2, adItemData2.i().get(0), str3);
                    }

                    @Override // com.opos.mobad.cmn.service.a.c
                    public void b(int i2, int i3, String str, String str2) {
                    }

                    @Override // com.opos.mobad.cmn.service.a.c
                    public void c(int i2, int i3, String str, String str2) {
                    }

                    @Override // com.opos.mobad.cmn.service.a.c
                    public void d(int i2, int i3, String str, String str2) {
                    }

                    @Override // com.opos.mobad.cmn.service.a.c
                    public void e(int i2, int i3, String str, String str2) {
                    }

                    public boolean equals(Object obj) {
                        if (this == obj || (obj != null && obj.hashCode() == hashCode())) {
                            return true;
                        }
                        return super.equals(obj);
                    }

                    @Override // com.opos.mobad.cmn.service.a.c
                    public void f(int i2, int i3, String str, String str2) {
                        if (adItemData.M()) {
                            return;
                        }
                        adItemData.g(true);
                        Context context = a.this.f20049b;
                        AdItemData adItemData2 = adItemData;
                        com.opos.mobad.cmn.a.b.d.c(context, adItemData2, adItemData2.i().get(0));
                        if (materialData.P() == null || materialData.P().size() <= 0) {
                            return;
                        }
                        com.opos.mobad.service.g.b.a().a(materialData.P()).a(a.this.f20049b);
                    }

                    public int hashCode() {
                        String aa = materialData.aa();
                        return TextUtils.isEmpty(aa) ? super.hashCode() : aa.hashCode();
                    }
                });
                hashMap.put("jumpRet", "1");
                aVar.a(a.b.DOWNLOADER).a("1");
                com.opos.mobad.cmn.a.b.d.a(this.f20049b, this.f20050c, adItemData2, materialData2, z, iArr, hashMap);
                a(7, cVar);
            }
            aVar.a(this.f20049b);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("AdHandler", "", (Throwable) e2);
        }
    }

    private void a(AdItemData adItemData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.cmn.a.b.a aVar, com.opos.mobad.service.g.a aVar2, boolean z2, b.InterfaceC0437b interfaceC0437b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        switch (AnonymousClass6.f20088a[aVar.ordinal()]) {
            case 1:
                d(adItemData, z, iArr, map, aVar2, z2, interfaceC0437b, bVar, cVar);
                break;
            case 2:
                b(adItemData, z, iArr, map, aVar2, z2, interfaceC0437b, bVar, cVar);
                break;
            case 3:
                c(adItemData, z, iArr, map, aVar2, z2, interfaceC0437b, bVar, cVar);
                break;
            case 4:
                e(adItemData, z, iArr, map, aVar2, z2, interfaceC0437b, bVar, cVar);
                break;
            case 5:
                f(adItemData, z, iArr, map, aVar2, z2, interfaceC0437b, bVar, cVar);
                break;
            case 6:
                a(adItemData, z, iArr, map, aVar2, z2, interfaceC0437b, bVar, cVar);
                break;
        }
    }

    public void a(AdItemData adItemData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.cmn.a.b.a aVar, boolean z2, b.InterfaceC0437b interfaceC0437b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        com.opos.mobad.service.g.a a2 = com.opos.mobad.service.g.b.a();
        if (adItemData != null) {
            try {
                MaterialData materialData = adItemData.i().get(0);
                if (materialData != null) {
                    if (materialData.p() != null && materialData.p().size() > 0) {
                        if (bVar != null && bVar.f20094b) {
                            a2.a(bVar.f20095c);
                        } else if (map != null && map.size() > 0) {
                            if (!TextUtils.isEmpty(map.get("vPlyPos"))) {
                                try {
                                    a2.a(Integer.parseInt(r0));
                                } catch (NumberFormatException e2) {
                                    com.opos.cmn.an.f.a.a("AdHandler", "", (Throwable) e2);
                                }
                            }
                        }
                    }
                    a2.a(materialData.p());
                }
            } catch (Exception e3) {
                com.opos.cmn.an.f.a.a("AdHandler", "", (Throwable) e3);
            }
        }
        a(adItemData, z, iArr, map, aVar, a2, z2, interfaceC0437b, bVar, cVar);
    }

    private void a(AdItemData adItemData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, boolean z2, b.InterfaceC0437b interfaceC0437b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        MaterialData materialData;
        com.opos.cmn.an.f.a.b("AdHandler", "handlePendantAdClickActionAndStEvent adItemData=", adItemData);
        if (adItemData == null || (materialData = adItemData.i().get(0)) == null) {
            return;
        }
        aVar.a(a.EnumC0486a.PENDANT).a(iArr);
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(map);
        }
        com.opos.mobad.cmn.a.b.d.a(hashMap, "6", String.valueOf(materialData.ab().b()));
        a(materialData.ab().b(), adItemData, materialData, z, iArr, hashMap, aVar, z2, interfaceC0437b, bVar, cVar);
    }

    private void a(String str, AdItemData adItemData, boolean z, b.InterfaceC0437b interfaceC0437b, EventDescription eventDescription) {
        if (com.opos.cmn.an.c.a.a(str) || adItemData == null || adItemData.i() == null || adItemData.i().size() <= 0) {
            return;
        }
        try {
            com.opos.cmn.an.f.a.b("AdHandler", "loadWebPage url=" + str);
            String a2 = -1 != f.c(str) ? f.a(adItemData, str, this.f20050c) : "";
            String a3 = f.a(this.f20049b, str, (int[]) null, 0L);
            if (interfaceC0437b != null) {
                f.a(interfaceC0437b);
            }
            this.f20051d.a(this.f20049b, this.f20050c, a3, adItemData, a2, eventDescription);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("AdHandler", "", (Throwable) e2);
        }
    }

    public void a(String str, AdItemData adItemData, boolean z, int[] iArr, com.opos.mobad.service.g.a aVar, b.InterfaceC0437b interfaceC0437b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        if (com.opos.cmn.an.c.a.a(str) || adItemData == null || adItemData.i() == null || adItemData.i().size() <= 0) {
            return;
        }
        try {
            int a2 = a(adItemData.i().get(0));
            if (a2 == 0) {
                aVar.a(a.b.WEB_VIEW).a("1");
            } else {
                if (a2 == 1) {
                    aVar.a(a.b.BROWSER).a("1");
                    a(str, aVar, cVar);
                    aVar.a(this.f20049b);
                }
                aVar.a(a.b.WEB_VIEW).a("1");
            }
            b(str, adItemData, z, iArr, aVar, interfaceC0437b, bVar, cVar);
            aVar.a(this.f20049b);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("AdHandler", "", (Throwable) e2);
        }
    }

    private void a(String str, com.opos.mobad.service.g.a aVar, c cVar) {
        if (com.opos.cmn.an.c.a.a(str)) {
            a(2, -1, cVar);
            return;
        }
        String a2 = com.opos.mobad.service.g.b.a(this.f20049b, str, aVar);
        com.opos.cmn.an.f.a.b("AdHandler", "loadWebPageByBrowser url=" + a2);
        this.f20051d.c(this.f20049b, a2);
        a(2, cVar);
    }

    private void a(String str, String str2) {
        try {
            Intent intent = new Intent(str);
            intent.setPackage(str2);
            List<ResolveInfo> queryIntentServices = this.f20049b.getPackageManager().queryIntentServices(intent, 128);
            if (queryIntentServices != null && queryIntentServices.size() == 1) {
                intent.putExtra(OapsKey.KEY_FROM, this.f20049b.getPackageName());
                this.f20049b.startService(intent);
                com.opos.mobad.cmn.a.b.d.a(this.f20049b, this.f20050c, str2, 0);
            }
            com.opos.mobad.cmn.a.b.d.a(this.f20049b, this.f20050c, str2, 6);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("AdHandler", "", e2);
            com.opos.mobad.cmn.a.b.d.a(this.f20049b, this.f20050c, str2, 7);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(com.opos.mobad.model.data.ActivatingData r10) {
        /*
            r9 = this;
            java.lang.String r0 = "AdHandler"
            android.content.Context r1 = r9.f20049b
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            r2 = 1
            r3 = 3
            r4 = 0
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> La6 android.content.pm.PackageManager.NameNotFoundException -> Lb6
            r6 = 28
            if (r5 < r6) goto L30
            java.lang.String r5 = r10.f21671a     // Catch: java.lang.Exception -> La6 android.content.pm.PackageManager.NameNotFoundException -> Lb6
            r6 = 134217856(0x8000080, float:3.8519187E-34)
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r5, r6)     // Catch: java.lang.Exception -> La6 android.content.pm.PackageManager.NameNotFoundException -> Lb6
            if (r1 != 0) goto L27
            android.content.Context r1 = r9.f20049b     // Catch: java.lang.Exception -> La6 android.content.pm.PackageManager.NameNotFoundException -> Lb6
            java.lang.String r5 = r9.f20050c     // Catch: java.lang.Exception -> La6 android.content.pm.PackageManager.NameNotFoundException -> Lb6
            java.lang.String r6 = r10.f21671a     // Catch: java.lang.Exception -> La6 android.content.pm.PackageManager.NameNotFoundException -> Lb6
        L22:
            com.opos.mobad.cmn.a.b.d.a(r1, r5, r6, r3)     // Catch: java.lang.Exception -> La6 android.content.pm.PackageManager.NameNotFoundException -> Lb6
            goto Lc4
        L27:
            android.content.pm.SigningInfo r5 = r1.signingInfo     // Catch: java.lang.Exception -> La6 android.content.pm.PackageManager.NameNotFoundException -> Lb6
            android.content.pm.Signature[] r5 = r5.getApkContentsSigners()     // Catch: java.lang.Exception -> La6 android.content.pm.PackageManager.NameNotFoundException -> Lb6
        L2d:
            int r0 = r1.versionCode     // Catch: java.lang.Exception -> La6 android.content.pm.PackageManager.NameNotFoundException -> Lb6
            goto L44
        L30:
            java.lang.String r5 = r10.f21671a     // Catch: java.lang.Exception -> La6 android.content.pm.PackageManager.NameNotFoundException -> Lb6
            r6 = 192(0xc0, float:2.69E-43)
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r5, r6)     // Catch: java.lang.Exception -> La6 android.content.pm.PackageManager.NameNotFoundException -> Lb6
            if (r1 != 0) goto L41
            android.content.Context r1 = r9.f20049b     // Catch: java.lang.Exception -> La6 android.content.pm.PackageManager.NameNotFoundException -> Lb6
            java.lang.String r5 = r9.f20050c     // Catch: java.lang.Exception -> La6 android.content.pm.PackageManager.NameNotFoundException -> Lb6
            java.lang.String r6 = r10.f21671a     // Catch: java.lang.Exception -> La6 android.content.pm.PackageManager.NameNotFoundException -> Lb6
            goto L22
        L41:
            android.content.pm.Signature[] r5 = r1.signatures     // Catch: java.lang.Exception -> La6 android.content.pm.PackageManager.NameNotFoundException -> Lb6
            goto L2d
        L44:
            int r1 = r10.f21674d
            if (r1 <= r0) goto L50
            android.content.Context r0 = r9.f20049b
            java.lang.String r1 = r9.f20050c
            java.lang.String r10 = r10.f21671a
            r2 = 4
            goto Lb2
        L50:
            java.util.List<com.opos.mobad.model.data.ApkSignerData> r0 = r10.f21673c
            r1 = 5
            if (r0 == 0) goto L9c
            if (r5 != 0) goto L58
            goto L9c
        L58:
            int r0 = r0.size()
            if (r0 <= 0) goto L9c
            java.util.List<com.opos.mobad.model.data.ApkSignerData> r0 = r10.f21673c
            int r0 = r0.size()
            int r3 = r5.length
            if (r0 == r3) goto L68
            goto L9c
        L68:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r3 = r5.length
            r0.<init>(r3)
            int r3 = r5.length
            r6 = 0
        L70:
            if (r6 >= r3) goto L7f
            com.opos.mobad.cmn.a.a$d r7 = new com.opos.mobad.cmn.a.a$d
            r8 = r5[r6]
            r7.<init>(r8)
            r0.add(r7)
            int r6 = r6 + 1
            goto L70
        L7f:
            java.util.List<com.opos.mobad.model.data.ApkSignerData> r3 = r10.f21673c
            java.util.Iterator r3 = r3.iterator()
        L85:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto Lc5
            java.lang.Object r5 = r3.next()
            com.opos.mobad.model.data.ApkSignerData r5 = (com.opos.mobad.model.data.ApkSignerData) r5
            int r5 = r9.a(r5, r0)
            if (r5 >= 0) goto L98
            goto L9c
        L98:
            r0.remove(r5)
            goto L85
        L9c:
            android.content.Context r0 = r9.f20049b
            java.lang.String r2 = r9.f20050c
            java.lang.String r10 = r10.f21671a
            com.opos.mobad.cmn.a.b.d.a(r0, r2, r10, r1)
            goto Lc4
        La6:
            r1 = move-exception
            java.lang.String r3 = "activation fail"
            com.opos.cmn.an.f.a.b(r0, r3, r1)
            android.content.Context r0 = r9.f20049b
            java.lang.String r1 = r9.f20050c
            java.lang.String r10 = r10.f21671a
        Lb2:
            com.opos.mobad.cmn.a.b.d.a(r0, r1, r10, r2)
            goto Lc4
        Lb6:
            java.lang.String r1 = "activation fail not install"
            com.opos.cmn.an.f.a.b(r0, r1)
            android.content.Context r0 = r9.f20049b
            java.lang.String r1 = r9.f20050c
            java.lang.String r10 = r10.f21671a
            com.opos.mobad.cmn.a.b.d.a(r0, r1, r10, r3)
        Lc4:
            r2 = 0
        Lc5:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.cmn.a.a.a(com.opos.mobad.model.data.ActivatingData):boolean");
    }

    private boolean a(AdItemData adItemData, MaterialData materialData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, com.opos.mobad.cmn.a.b bVar, c cVar) {
        boolean z2 = true;
        if (adItemData == null || materialData == null) {
            return false;
        }
        try {
            String s = materialData.s();
            try {
                if (com.opos.cmn.an.c.a.a(s) || !this.f20051d.b(this.f20049b, s)) {
                    z2 = b(adItemData, materialData, z, iArr, map, aVar, bVar, cVar);
                    com.opos.cmn.an.f.a.b("AdHandler", "handleDeepLinkAndSTEvent open deeplink fail.open homepage");
                } else {
                    com.opos.mobad.cmn.a.b.d.c(this.f20049b, this.f20050c, adItemData, materialData, z, iArr, map);
                    aVar.a(a.b.DEEP_LINK).a("1");
                    aVar.a(this.f20049b);
                    com.opos.cmn.an.f.a.b("AdHandler", "handleDeepLinkAndSTEvent open deeplink success.extraUrl = " + s);
                    a(5, cVar);
                }
                return z2;
            } catch (Exception e2) {
                e = e2;
                com.opos.cmn.an.f.a.a("AdHandler", "", (Throwable) e);
                return z2;
            }
        } catch (Exception e3) {
            e = e3;
            z2 = false;
        }
    }

    public void b(AdItemData adItemData, MaterialData materialData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, b.InterfaceC0437b interfaceC0437b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        if (adItemData == null || materialData == null) {
            return;
        }
        com.opos.cmn.an.f.a.b("AdHandler", "handleMiddlePageDLApkAndSTEvent");
        a(materialData.m(), adItemData, z, iArr, aVar, interfaceC0437b, bVar, cVar);
        HashMap hashMap = new HashMap();
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        if (!com.opos.cmn.an.c.a.a(materialData.t())) {
            hashMap.put("dlChannel", materialData.t());
        }
        com.opos.mobad.cmn.a.b.d.b(this.f20049b, this.f20050c, adItemData, materialData, z, iArr, hashMap);
    }

    private void b(AdItemData adItemData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, boolean z2, b.InterfaceC0437b interfaceC0437b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        MaterialData materialData;
        com.opos.cmn.an.f.a.b("AdHandler", "handleButtonAdClickActionAndSTEvent adItemData=", adItemData);
        if (adItemData == null || (materialData = adItemData.i().get(0)) == null) {
            return;
        }
        aVar.a(a.EnumC0486a.BUTTON).a(iArr);
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(map);
        }
        com.opos.mobad.cmn.a.b.d.a(hashMap, "1", String.valueOf(materialData.e()));
        a(materialData.e(), adItemData, materialData, z, iArr, hashMap, aVar, z2, interfaceC0437b, bVar, cVar);
    }

    private void b(String str, AdItemData adItemData, boolean z, int[] iArr, com.opos.mobad.service.g.a aVar, b.InterfaceC0437b interfaceC0437b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        if (com.opos.cmn.an.c.a.a(str) || adItemData == null || adItemData.i() == null || adItemData.i().size() <= 0) {
            a(3, -1, cVar);
            return;
        }
        try {
            com.opos.cmn.an.f.a.b("AdHandler", "loadWebPage url=" + str);
            String a2 = -1 != f.c(str) ? f.a(adItemData, str, this.f20050c) : "";
            String a3 = com.opos.mobad.service.g.b.a(this.f20049b, str, aVar);
            if (interfaceC0437b != null) {
                f.a(interfaceC0437b);
            }
            if (bVar != null && adItemData.i().get(0).d() == 13) {
                this.f20051d.a(this.f20049b, this.f20050c, a3, adItemData, a2, bVar.f20093a, bVar.f20096d);
            } else {
                if (adItemData.R() == 1) {
                    if (com.opos.mobad.o.e.b.a(adItemData.i().get(0).b())) {
                        a(8, cVar);
                        return;
                    }
                    this.f20051d.a(this.f20049b, this.f20050c, a3, adItemData, a2, (EventDescription) null);
                    a(3, cVar);
                    if (adItemData.V() == 2) {
                        com.opos.mobad.service.i.d.a().c().c(adItemData.i().get(0).aa(), 2);
                        return;
                    }
                    return;
                }
                this.f20051d.a(this.f20049b, this.f20050c, a3, adItemData, a2, (EventDescription) null);
            }
            a(3, cVar);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("AdHandler", "", (Throwable) e2);
        }
    }

    public boolean b(AdItemData adItemData, MaterialData materialData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, com.opos.mobad.cmn.a.b bVar, c cVar) {
        boolean z2 = false;
        if (adItemData != null && materialData != null) {
            try {
                HashMap hashMap = new HashMap();
                if (map != null && map.size() > 0) {
                    hashMap.putAll(map);
                }
                String k = materialData.k();
                if (com.opos.cmn.an.c.a.a(k) || !this.f20051d.a(this.f20049b, k)) {
                    hashMap.put("jumpRet", "0");
                    aVar.a(a.b.APP_HOME).a("0");
                    StringBuilder sb = new StringBuilder();
                    sb.append("handleHomePageAndSTEvent pkgName=");
                    if (k == null) {
                        k = "null";
                    }
                    sb.append(k);
                    sb.append(" fail.");
                    com.opos.cmn.an.f.a.b("AdHandler", sb.toString());
                    a(4, -1, cVar);
                } else {
                    hashMap.put("jumpRet", "1");
                    aVar.a(a.b.APP_HOME).a("1");
                    try {
                        a(4, cVar);
                        com.opos.cmn.an.f.a.b("AdHandler", "handleHomePageAndSTEvent pkgName=" + k + " success.");
                        z2 = true;
                    } catch (Exception e2) {
                        e = e2;
                        z2 = true;
                        com.opos.cmn.an.f.a.a("AdHandler", "", (Throwable) e);
                        return z2;
                    }
                }
                com.opos.mobad.cmn.a.b.d.a(this.f20049b, adItemData, materialData, z, iArr, hashMap);
                aVar.a(this.f20049b);
            } catch (Exception e3) {
                e = e3;
            }
        }
        return z2;
    }

    public void c(AdItemData adItemData, MaterialData materialData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, com.opos.mobad.cmn.a.b bVar, c cVar) {
        if (adItemData == null || materialData == null) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            if (map != null && map.size() > 0) {
                hashMap.putAll(map);
            }
            String m = materialData.m();
            if (com.opos.cmn.an.c.a.a(m) || !this.f20051d.b(this.f20049b, m)) {
                hashMap.put("jumpRet", "0");
                aVar.a(a.b.DEEP_LINK).a("0");
                StringBuilder sb = new StringBuilder();
                sb.append("handleDetailPageAndSTEvent targetUrl=");
                if (m == null) {
                    m = "null";
                }
                sb.append(m);
                sb.append(" fail.");
                com.opos.cmn.an.f.a.b("AdHandler", sb.toString());
                a(5, -1, cVar);
            } else {
                aVar.a(a.b.DEEP_LINK).a("1");
                hashMap.put("jumpRet", "1");
                com.opos.cmn.an.f.a.b("AdHandler", "handleDetailPageAndSTEvent targetUrl=" + m + " success.");
                a(5, cVar);
            }
            com.opos.mobad.cmn.a.b.d.a(this.f20049b, this.f20050c, adItemData, materialData, z, iArr, hashMap);
            aVar.a(this.f20049b);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("AdHandler", "", (Throwable) e2);
        }
    }

    public void c(AdItemData adItemData, MaterialData materialData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, b.InterfaceC0437b interfaceC0437b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        if (adItemData == null || materialData == null) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            if (map != null && map.size() > 0) {
                hashMap.putAll(map);
            }
            if (!com.opos.cmn.an.c.a.a(materialData.s())) {
                this.f20051d.a(this.f20049b, adItemData.d(), adItemData.e(), materialData.s(), new d.a() { // from class: com.opos.mobad.cmn.a.a.3

                    /* renamed from: a */
                    final /* synthetic */ Map f20072a;

                    /* renamed from: b */
                    final /* synthetic */ AdItemData f20073b;

                    /* renamed from: c */
                    final /* synthetic */ MaterialData f20074c;

                    /* renamed from: d */
                    final /* synthetic */ boolean f20075d;

                    /* renamed from: e */
                    final /* synthetic */ int[] f20076e;

                    /* renamed from: f */
                    final /* synthetic */ com.opos.mobad.service.g.a f20077f;

                    /* renamed from: g */
                    final /* synthetic */ c f20078g;

                    /* renamed from: h */
                    final /* synthetic */ b.InterfaceC0437b f20079h;

                    /* renamed from: i */
                    final /* synthetic */ com.opos.mobad.cmn.a.b f20080i;

                    AnonymousClass3(Map hashMap2, AdItemData adItemData2, MaterialData materialData2, boolean z2, int[] iArr2, com.opos.mobad.service.g.a aVar2, c cVar2, b.InterfaceC0437b interfaceC0437b2, com.opos.mobad.cmn.a.b bVar2) {
                        hashMap = hashMap2;
                        adItemData = adItemData2;
                        materialData = materialData2;
                        z = z2;
                        iArr = iArr2;
                        aVar = aVar2;
                        cVar = cVar2;
                        interfaceC0437b = interfaceC0437b2;
                        bVar = bVar2;
                    }

                    @Override // com.opos.mobad.cmn.a.d.a
                    public void a() {
                        hashMap.put("jumpRet", "1");
                        com.opos.mobad.cmn.a.b.d.a(a.this.f20049b, a.this.f20050c, adItemData, materialData, z, iArr, (Map<String, String>) hashMap);
                        aVar.a(a.b.INSTANT).a("1");
                        aVar.a(a.this.f20049b);
                        a.this.a(6, cVar);
                        com.opos.cmn.an.f.a.a("AdHandler", "handleInstantAndSTEvent open instant success.");
                    }

                    @Override // com.opos.mobad.cmn.a.d.a
                    public void a(int i2, String str) {
                        a.this.a(materialData.m(), adItemData, z, iArr, aVar, interfaceC0437b, bVar, cVar);
                        hashMap.put("jumpRet", i2 + "");
                        com.opos.mobad.cmn.a.b.d.a(a.this.f20049b, a.this.f20050c, adItemData, materialData, z, iArr, (Map<String, String>) hashMap);
                        com.opos.cmn.an.f.a.a("AdHandler", "handleInstantAndSTEvent open instant fail.open web, code:" + i2 + ",msg:" + str);
                    }
                }, materialData2.q());
            } else {
                a(materialData2.m(), adItemData2, z2, iArr2, aVar2, interfaceC0437b2, bVar2, cVar2);
                hashMap2.put("jumpRet", "0");
                com.opos.mobad.cmn.a.b.d.a(this.f20049b, this.f20050c, adItemData2, materialData2, z2, iArr2, hashMap2);
                com.opos.cmn.an.f.a.b("AdHandler", "handleInstantAndSTEvent open instant fail.open web");
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("AdHandler", "", (Throwable) e2);
        }
    }

    private void c(AdItemData adItemData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, boolean z2, b.InterfaceC0437b interfaceC0437b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        MaterialData materialData;
        com.opos.cmn.an.f.a.b("AdHandler", "handleExtraAdClickActionAndStEvent adItemData=", adItemData);
        if (adItemData == null || (materialData = adItemData.i().get(0)) == null) {
            return;
        }
        aVar.a(a.EnumC0486a.EXTRA).a(iArr);
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(map);
        }
        com.opos.mobad.cmn.a.b.d.a(hashMap, "2", String.valueOf(materialData.J()));
        a(materialData.J(), adItemData, materialData, z, iArr, hashMap, aVar, z2, interfaceC0437b, bVar, cVar);
    }

    public void d(AdItemData adItemData, MaterialData materialData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, b.InterfaceC0437b interfaceC0437b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        String str;
        if (adItemData == null || materialData == null) {
            return;
        }
        try {
            String s = materialData.s();
            if (com.opos.cmn.an.c.a.a(s) || !this.f20051d.b(this.f20049b, s)) {
                a(materialData.m(), adItemData, z, iArr, aVar, interfaceC0437b, bVar, cVar);
                com.opos.mobad.cmn.a.b.d.a(this.f20049b, this.f20050c, adItemData, materialData, z, iArr, map);
                str = "handleDeepLinkAndSTEvent open deeplink fail.open web";
            } else {
                com.opos.mobad.cmn.a.b.d.c(this.f20049b, this.f20050c, adItemData, materialData, z, iArr, map);
                aVar.a(a.b.DEEP_LINK).a("1");
                aVar.a(this.f20049b);
                a(5, cVar);
                str = "handleDeepLinkAndSTEvent open deeplink success.extraUrl = " + s;
            }
            com.opos.cmn.an.f.a.b("AdHandler", str);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("AdHandler", "", (Throwable) e2);
        }
    }

    private void d(AdItemData adItemData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, boolean z2, b.InterfaceC0437b interfaceC0437b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        MaterialData materialData;
        com.opos.cmn.an.f.a.b("AdHandler", "handleVideoAdClickActionAndSTEvent adItemData=", adItemData);
        if (adItemData == null || (materialData = adItemData.i().get(0)) == null) {
            return;
        }
        aVar.a(a.EnumC0486a.VIDEO).a(iArr);
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(map);
        }
        com.opos.mobad.cmn.a.b.d.a(hashMap, "3", String.valueOf(materialData.K()));
        a(materialData.K(), adItemData, materialData, z, iArr, hashMap, aVar, z2, interfaceC0437b, bVar, cVar);
    }

    public void e(AdItemData adItemData, MaterialData materialData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, b.InterfaceC0437b interfaceC0437b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        String str;
        if (adItemData == null || materialData == null) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            if (map != null && map.size() > 0) {
                hashMap.putAll(map);
            }
            if (TextUtils.isEmpty(adItemData.Z()) || TextUtils.isEmpty(materialData.ag())) {
                a(materialData.m(), adItemData, z, iArr, aVar, interfaceC0437b, bVar, cVar);
                hashMap.put("jumpRet", "0");
                com.opos.mobad.cmn.a.b.d.a(this.f20049b, this.f20050c, adItemData, materialData, z, iArr, hashMap);
                com.opos.cmn.an.f.a.b("AdHandler", "handleMiniProgramAndSTEvent error param instant fail.open web");
                return;
            }
            if (this.f20051d.a(this.f20049b, adItemData.Z(), materialData.ag(), materialData.ah())) {
                hashMap.put("jumpRet", "1");
                com.opos.mobad.cmn.a.b.d.a(this.f20049b, this.f20050c, adItemData, materialData, z, iArr, hashMap);
                aVar.a(a.b.MINI_PROGRAM).a("1");
                aVar.a(this.f20049b);
                a(9, cVar);
                str = "handleMiniProgramAndSTEvent open success.";
            } else {
                a(materialData.m(), adItemData, z, iArr, aVar, interfaceC0437b, bVar, cVar);
                hashMap.put("jumpRet", "0");
                com.opos.mobad.cmn.a.b.d.a(this.f20049b, this.f20050c, adItemData, materialData, z, iArr, hashMap);
                str = "handleMiniProgramAndSTEvent open fail.open web";
            }
            com.opos.cmn.an.f.a.a("AdHandler", str);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("AdHandler", "", (Throwable) e2);
        }
    }

    private void e(AdItemData adItemData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, boolean z2, b.InterfaceC0437b interfaceC0437b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        MaterialData materialData;
        com.opos.cmn.an.f.a.b("AdHandler", "handleFloatLayerAdClickActionAndStEvent adItemData=", adItemData);
        if (adItemData == null || (materialData = adItemData.i().get(0)) == null) {
            return;
        }
        aVar.a(a.EnumC0486a.FLOATLAYER_BUTTON).a(iArr);
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(map);
        }
        com.opos.mobad.cmn.a.b.d.a(hashMap, "4", String.valueOf(materialData.V()));
        a(materialData.V(), adItemData, materialData, z, iArr, hashMap, aVar, z2, interfaceC0437b, bVar, cVar);
    }

    private void f(AdItemData adItemData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.service.g.a aVar, boolean z2, b.InterfaceC0437b interfaceC0437b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        MaterialData materialData;
        com.opos.cmn.an.f.a.b("AdHandler", "handleFloatLayerExtraAdClickActionAndStEvent adItemData=", adItemData);
        if (adItemData == null || (materialData = adItemData.i().get(0)) == null) {
            return;
        }
        aVar.a(a.EnumC0486a.FLOATLAYER_EXTRA).a(iArr);
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(map);
        }
        com.opos.mobad.cmn.a.b.d.a(hashMap, "5", String.valueOf(materialData.W()));
        a(materialData.W(), adItemData, materialData, z, iArr, hashMap, aVar, z2, interfaceC0437b, bVar, cVar);
    }

    public void a() {
        this.f20052e = null;
    }

    public void a(b bVar) {
        this.f20052e = bVar;
    }

    public void a(AdItemData adItemData) {
        if (adItemData == null || adItemData.G() == null) {
            return;
        }
        ActivatingData G = adItemData.G();
        if (G == null || TextUtils.isEmpty(G.f21672b) || TextUtils.isEmpty(G.f21671a)) {
            com.opos.mobad.cmn.a.b.d.a(this.f20049b, this.f20050c, (String) null, 2);
        } else if (a(G)) {
            a(G.f21672b, G.f21671a);
        }
    }

    public void a(AdItemData adItemData, boolean z, b.InterfaceC0437b interfaceC0437b, EventDescription eventDescription) {
        if (adItemData != null) {
            try {
                if (adItemData.i() == null || adItemData.i().size() <= 0) {
                    return;
                }
                a(adItemData.i().get(0).w(), adItemData, z, interfaceC0437b, eventDescription);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("AdHandler", "", (Throwable) e2);
            }
        }
    }

    public void a(AdItemData adItemData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.cmn.a.b.a aVar, View view, b.InterfaceC0437b interfaceC0437b, com.opos.mobad.cmn.a.b bVar) {
        a(adItemData, z, iArr, map, aVar, view, interfaceC0437b, bVar, (c) null);
    }

    public void a(AdItemData adItemData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.cmn.a.b.a aVar, View view, b.InterfaceC0437b interfaceC0437b, com.opos.mobad.cmn.a.b bVar, c cVar) {
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(map);
        }
        com.opos.mobad.cmn.a.b.d.b(hashMap, o.a(this.f20049b, view) ? "1" : "2");
        if (!f.a(this.f20049b, adItemData, aVar)) {
            a(adItemData, z, iArr, (Map<String, String>) hashMap, aVar, false, interfaceC0437b, bVar, cVar);
            return;
        }
        b bVar2 = this.f20052e;
        if (bVar2 != null) {
            bVar2.a(new InterfaceC0429a() { // from class: com.opos.mobad.cmn.a.a.1

                /* renamed from: a */
                final /* synthetic */ AdItemData f20053a;

                /* renamed from: b */
                final /* synthetic */ boolean f20054b;

                /* renamed from: c */
                final /* synthetic */ int[] f20055c;

                /* renamed from: d */
                final /* synthetic */ Map f20056d;

                /* renamed from: e */
                final /* synthetic */ com.opos.mobad.cmn.a.b.a f20057e;

                /* renamed from: f */
                final /* synthetic */ b.InterfaceC0437b f20058f;

                /* renamed from: g */
                final /* synthetic */ com.opos.mobad.cmn.a.b f20059g;

                /* renamed from: h */
                final /* synthetic */ c f20060h;

                AnonymousClass1(AdItemData adItemData2, boolean z2, int[] iArr2, Map hashMap2, com.opos.mobad.cmn.a.b.a aVar2, b.InterfaceC0437b interfaceC0437b2, com.opos.mobad.cmn.a.b bVar3, c cVar2) {
                    adItemData = adItemData2;
                    z = z2;
                    iArr = iArr2;
                    hashMap = hashMap2;
                    aVar = aVar2;
                    interfaceC0437b = interfaceC0437b2;
                    bVar = bVar3;
                    cVar = cVar2;
                }

                @Override // com.opos.mobad.cmn.a.a.InterfaceC0429a
                public void a() {
                    com.opos.cmn.an.f.a.b("AdHandler", "download confirm");
                    f.a(false);
                    a.this.a(adItemData, z, iArr, (Map<String, String>) hashMap, aVar, false, interfaceC0437b, bVar, cVar);
                }

                @Override // com.opos.mobad.cmn.a.a.InterfaceC0429a
                public void b() {
                    com.opos.cmn.an.f.a.b("AdHandler", "download cancel");
                    a.this.a(adItemData, z, iArr, (Map<String, String>) hashMap, aVar, true, interfaceC0437b, bVar, cVar);
                }
            });
        } else {
            a(adItemData2, z2, iArr2, (Map<String, String>) hashMap2, aVar2, false, interfaceC0437b2, bVar3, cVar2);
        }
    }

    public void b(AdItemData adItemData) {
        List<MaterialData> i2;
        MaterialData materialData;
        if (adItemData == null || (i2 = adItemData.i()) == null || i2.size() <= 0 || (materialData = i2.get(0)) == null || materialData.e() != 6) {
            return;
        }
        this.f20051d.a(this.f20049b, adItemData.d(), adItemData.e(), materialData.s(), materialData.q());
    }
}
