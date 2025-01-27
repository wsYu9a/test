package com.opos.mobad.model.e;

import android.os.SystemClock;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import java.util.List;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: com.opos.mobad.model.e.a$a */
    public static class C0457a {

        /* renamed from: a */
        public final AdData f21743a;

        /* renamed from: b */
        public final AdItemData f21744b;

        /* renamed from: c */
        public final MaterialData f21745c;

        /* renamed from: d */
        public final MaterialFileData f21746d;

        /* renamed from: e */
        public final long f21747e;

        private C0457a(AdData adData, AdItemData adItemData, MaterialData materialData) {
            this(adData, adItemData, materialData, (MaterialFileData) null);
        }

        private C0457a(AdData adData, AdItemData adItemData, MaterialData materialData, MaterialFileData materialFileData) {
            this.f21743a = adData;
            this.f21744b = adItemData;
            this.f21745c = materialData;
            this.f21746d = materialFileData;
            this.f21747e = SystemClock.elapsedRealtime();
        }

        /* synthetic */ C0457a(AdData adData, AdItemData adItemData, MaterialData materialData, MaterialFileData materialFileData, AnonymousClass1 anonymousClass1) {
            this(adData, adItemData, materialData, materialFileData);
        }

        /* synthetic */ C0457a(AdData adData, AdItemData adItemData, MaterialData materialData, AnonymousClass1 anonymousClass1) {
            this(adData, adItemData, materialData);
        }
    }

    public static final C0457a a(AdData adData) {
        List<AdItemData> f2;
        MaterialData materialData;
        MaterialFileData materialFileData;
        if (adData == null || (f2 = adData.f()) == null || f2.size() <= 0) {
            return null;
        }
        for (int i2 = 0; i2 < f2.size(); i2++) {
            AdItemData adItemData = f2.get(i2);
            if (adItemData != null && adItemData.i() != null && adItemData.i().size() > 0 && (materialData = adItemData.i().get(0)) != null) {
                int d2 = materialData.d();
                if ((d2 == 4 || d2 == 9 || d2 == 10 || d2 == 11 || d2 == 12 || d2 == 13) ? false : true) {
                    return new C0457a(adData, adItemData, materialData);
                }
                if (materialData.F() != null && materialData.F().size() > 0 && (materialFileData = materialData.F().get(0)) != null) {
                    return new C0457a(adData, adItemData, materialData, materialFileData);
                }
            }
        }
        return null;
    }
}
