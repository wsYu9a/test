package com.kwad.sdk.collector;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.collector.d;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bo;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: com.kwad.sdk.collector.c$1 */
    public class AnonymousClass1 implements d.a {
        final /* synthetic */ a aqX;
        final /* synthetic */ Context hB;

        public AnonymousClass1(Context context, a aVar) {
            context = context;
            aVar = aVar;
        }

        @Override // com.kwad.sdk.collector.d.a
        public final void cx(String str) {
            com.kwad.sdk.core.d.c.e("AppStatusFetchConfigManager", "onLoadError: " + str);
        }

        @Override // com.kwad.sdk.collector.d.a
        public final void onLoaded() {
            c.b(context, aVar);
        }
    }

    /* renamed from: com.kwad.sdk.collector.c$2 */
    public class AnonymousClass2 extends l<com.kwad.sdk.collector.a.a, AppStatusRules> {
        final /* synthetic */ Context hB;

        public AnonymousClass2(Context context) {
            context = context;
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: BT */
        public com.kwad.sdk.collector.a.a createRequest() {
            return new com.kwad.sdk.collector.a.a(bo.dB(context));
        }

        @NonNull
        private static AppStatusRules cy(String str) {
            return AppStatusRules.createFromJson(str);
        }

        @Override // com.kwad.sdk.core.network.l
        @NonNull
        public final /* synthetic */ AppStatusRules parseData(String str) {
            return cy(str);
        }
    }

    /* renamed from: com.kwad.sdk.collector.c$3 */
    public class AnonymousClass3 extends o<com.kwad.sdk.collector.a.a, AppStatusRules> {
        public AnonymousClass3() {
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        /* renamed from: a */
        public void onStartRequest(@NonNull com.kwad.sdk.collector.a.a aVar) {
            super.onStartRequest(aVar);
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
            a((AppStatusRules) baseResultData);
        }

        private void a(@NonNull AppStatusRules appStatusRules) {
            a aVar = a.this;
            if (aVar != null) {
                aVar.b(appStatusRules);
            }
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        /* renamed from: a */
        public void onError(@NonNull com.kwad.sdk.collector.a.a aVar, int i10, String str) {
            super.onError(aVar, i10, str);
            a aVar2 = a.this;
            if (aVar2 != null) {
                aVar2.s(i10, str);
            }
        }
    }

    public interface a {
        void b(AppStatusRules appStatusRules);

        void s(int i10, String str);
    }

    public static void a(Context context, a aVar) {
        if (context == null) {
            return;
        }
        d.a(context, new d.a() { // from class: com.kwad.sdk.collector.c.1
            final /* synthetic */ a aqX;
            final /* synthetic */ Context hB;

            public AnonymousClass1(Context context2, a aVar2) {
                context = context2;
                aVar = aVar2;
            }

            @Override // com.kwad.sdk.collector.d.a
            public final void cx(String str) {
                com.kwad.sdk.core.d.c.e("AppStatusFetchConfigManager", "onLoadError: " + str);
            }

            @Override // com.kwad.sdk.collector.d.a
            public final void onLoaded() {
                c.b(context, aVar);
            }
        });
    }

    public static void b(Context context, a aVar) {
        new l<com.kwad.sdk.collector.a.a, AppStatusRules>() { // from class: com.kwad.sdk.collector.c.2
            final /* synthetic */ Context hB;

            public AnonymousClass2(Context context2) {
                context = context2;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: BT */
            public com.kwad.sdk.collector.a.a createRequest() {
                return new com.kwad.sdk.collector.a.a(bo.dB(context));
            }

            @NonNull
            private static AppStatusRules cy(String str) {
                return AppStatusRules.createFromJson(str);
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ AppStatusRules parseData(String str) {
                return cy(str);
            }
        }.request(new o<com.kwad.sdk.collector.a.a, AppStatusRules>() { // from class: com.kwad.sdk.collector.c.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onStartRequest(@NonNull com.kwad.sdk.collector.a.a aVar2) {
                super.onStartRequest(aVar2);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
                a((AppStatusRules) baseResultData);
            }

            private void a(@NonNull AppStatusRules appStatusRules) {
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.b(appStatusRules);
                }
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onError(@NonNull com.kwad.sdk.collector.a.a aVar2, int i10, String str) {
                super.onError(aVar2, i10, str);
                a aVar22 = a.this;
                if (aVar22 != null) {
                    aVar22.s(i10, str);
                }
            }
        });
    }
}
