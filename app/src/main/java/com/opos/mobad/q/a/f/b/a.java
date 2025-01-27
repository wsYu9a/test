package com.opos.mobad.q.a.f.b;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.c.a;
import com.opos.mobad.d.d;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.FloatLayerData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.n.a;
import com.opos.mobad.n.h.f;
import com.opos.mobad.q.a.f.a.b;
import com.opos.mobad.q.a.f.a.c;
import com.opos.mobad.q.a.f.a.e;
import java.io.File;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static a f23303a;

    /* renamed from: b */
    private com.opos.mobad.c.a f23304b = new com.opos.mobad.c.a() { // from class: com.opos.mobad.q.a.f.b.a.1
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.c.a
        public void a(String str, String str2, int i2, int i3, a.InterfaceC0426a interfaceC0426a) {
            d.a().a(str, str2, i2, i3, interfaceC0426a);
        }
    };

    /* renamed from: com.opos.mobad.q.a.f.b.a$1 */
    class AnonymousClass1 implements com.opos.mobad.c.a {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.c.a
        public void a(String str, String str2, int i2, int i3, a.InterfaceC0426a interfaceC0426a) {
            d.a().a(str, str2, i2, i3, interfaceC0426a);
        }
    }

    private a() {
    }

    public static int a(Context context, AdItemData adItemData) {
        MaterialData materialData;
        FloatLayerData U;
        if (context == null || adItemData == null || adItemData.i() == null || (materialData = adItemData.i().get(0)) == null || (U = materialData.U()) == null) {
            return 0;
        }
        int af = materialData.af();
        return (a(U, af) || b(U, af)) ? a(context, adItemData, af) : materialData.af();
    }

    private static int a(Context context, AdItemData adItemData, int i2) {
        int F = adItemData.F();
        boolean a2 = F != 0 ? F != 1 : a(context);
        com.opos.cmn.an.f.a.b("FloatLayerTemplateFactory", "check float endPage but material unused " + i2);
        return a2 ? 1 : 2;
    }

    public static final a a() {
        a aVar = f23303a;
        if (aVar == null) {
            synchronized (a.class) {
                aVar = f23303a;
                if (aVar == null) {
                    aVar = new a();
                    f23303a = aVar;
                }
            }
        }
        return aVar;
    }

    public static boolean a(Context context) {
        int i2;
        return context == null || (i2 = com.opos.cmn.an.h.f.a.i(context)) == 0 || i2 == 180;
    }

    public static final boolean a(FloatLayerData floatLayerData) {
        if (floatLayerData.e() == null || floatLayerData.e().size() <= 0 || floatLayerData.e().get(0) == null || TextUtils.isEmpty(floatLayerData.e().get(0).a())) {
            return true;
        }
        try {
            return true ^ new File(floatLayerData.e().get(0).a()).exists();
        } catch (Exception unused) {
            return true;
        }
    }

    private static boolean a(FloatLayerData floatLayerData, int i2) {
        return (i2 == 4 || i2 == 3) && b(floatLayerData);
    }

    private static final boolean b(FloatLayerData floatLayerData) {
        if (floatLayerData.d() == null || floatLayerData.d().size() <= 0 || floatLayerData.d().get(0) == null || TextUtils.isEmpty(floatLayerData.d().get(0).a())) {
            return true;
        }
        try {
            return true ^ new File(floatLayerData.d().get(0).a()).exists();
        } catch (Exception unused) {
            return true;
        }
    }

    private static boolean b(FloatLayerData floatLayerData, int i2) {
        return i2 == 5 && a(floatLayerData);
    }

    public com.opos.mobad.n.a a(Context context, int i2, a.InterfaceC0458a interfaceC0458a) {
        if (i2 == 3) {
            return new e(context, i2, interfaceC0458a);
        }
        if (i2 == 4) {
            return new com.opos.mobad.q.a.f.a.d(context, i2, interfaceC0458a);
        }
        if (i2 == 5) {
            return new c(context, i2, interfaceC0458a);
        }
        if (i2 != 6) {
            return new b(context, i2, interfaceC0458a);
        }
        f a2 = f.a(context, this.f23304b, i2);
        a2.a(interfaceC0458a);
        return a2;
    }

    public com.opos.mobad.n.a a(Context context, AdItemData adItemData, a.InterfaceC0458a interfaceC0458a) {
        return a(context, a(context, adItemData), interfaceC0458a);
    }
}
