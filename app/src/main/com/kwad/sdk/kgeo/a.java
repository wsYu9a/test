package com.kwad.sdk.kgeo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.b;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.kgeo.c;
import com.kwad.sdk.service.ServiceProvider;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class a {
    private static String aNp;
    private static KGeoInfo aNq;
    private static final AtomicBoolean aNr = new AtomicBoolean();

    /* renamed from: com.kwad.sdk.kgeo.a$1 */
    public class AnonymousClass1 implements b.a {
        @Override // com.kwad.components.core.request.b.a
        public final void rp() {
            com.kwad.components.core.request.b.rn().b(this);
            a.KI();
        }
    }

    /* renamed from: com.kwad.sdk.kgeo.a$2 */
    public class AnonymousClass2 implements c.a {
        @Override // com.kwad.sdk.kgeo.c.a
        public final void Je() {
            a.KJ();
        }

        @Override // com.kwad.sdk.kgeo.c.a
        public final void onSuccess(String str) {
            String unused = a.aNp = str;
            a.KJ();
        }
    }

    /* renamed from: com.kwad.sdk.kgeo.a$3 */
    public class AnonymousClass3 extends l<f, KGeoResultData> {
        @NonNull
        private static KGeoResultData gd(String str) {
            KGeoResultData kGeoResultData = new KGeoResultData();
            kGeoResultData.parseJson(new JSONObject(str));
            return kGeoResultData;
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        public final f createRequest() {
            return new b();
        }

        @Override // com.kwad.sdk.core.network.l
        @NonNull
        public final /* synthetic */ KGeoResultData parseData(String str) {
            return gd(str);
        }
    }

    /* renamed from: com.kwad.sdk.kgeo.a$4 */
    public class AnonymousClass4 extends o<f, KGeoResultData> {
        private static void a(@NonNull KGeoResultData kGeoResultData) {
            KGeoInfo unused = a.aNq = kGeoResultData.kGeoInfo;
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
            a((KGeoResultData) baseResultData);
        }
    }

    @Nullable
    public static KGeoInfo KH() {
        return aNq;
    }

    public static void KI() {
        try {
            if (aNr.getAndSet(true)) {
                return;
            }
            c.a(ServiceProvider.MA(), new c.a() { // from class: com.kwad.sdk.kgeo.a.2
                @Override // com.kwad.sdk.kgeo.c.a
                public final void Je() {
                    a.KJ();
                }

                @Override // com.kwad.sdk.kgeo.c.a
                public final void onSuccess(String str) {
                    String unused = a.aNp = str;
                    a.KJ();
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static void KJ() {
        try {
            new l<f, KGeoResultData>() { // from class: com.kwad.sdk.kgeo.a.3
                @NonNull
                private static KGeoResultData gd(String str) {
                    KGeoResultData kGeoResultData = new KGeoResultData();
                    kGeoResultData.parseJson(new JSONObject(str));
                    return kGeoResultData;
                }

                @Override // com.kwad.sdk.core.network.a
                @NonNull
                public final f createRequest() {
                    return new b();
                }

                @Override // com.kwad.sdk.core.network.l
                @NonNull
                public final /* synthetic */ KGeoResultData parseData(String str) {
                    return gd(str);
                }
            }.request(new o<f, KGeoResultData>() { // from class: com.kwad.sdk.kgeo.a.4
                private static void a(@NonNull KGeoResultData kGeoResultData) {
                    KGeoInfo unused = a.aNq = kGeoResultData.kGeoInfo;
                }

                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                    a((KGeoResultData) baseResultData);
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static void dG(int i10) {
        if (i10 == 0) {
            return;
        }
        if (i10 == 1) {
            KI();
        } else if (i10 == 2) {
            com.kwad.components.core.request.b.rn().a(new b.a() { // from class: com.kwad.sdk.kgeo.a.1
                @Override // com.kwad.components.core.request.b.a
                public final void rp() {
                    com.kwad.components.core.request.b.rn().b(this);
                    a.KI();
                }
            });
        }
    }

    @Nullable
    public static String zF() {
        return aNp;
    }
}
