package com.kwad.sdk.collector;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.collector.d;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.utils.bd;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: com.kwad.sdk.collector.c$1 */
    static class AnonymousClass1 implements d.a {
        final /* synthetic */ a abd;
        final /* synthetic */ Context jN;

        AnonymousClass1(Context context, a aVar) {
            context = context;
            aVar = aVar;
        }

        @Override // com.kwad.sdk.collector.d.a
        public final void bo(String str) {
            com.kwad.sdk.core.d.b.e("AppStatusFetchConfigManager", "onLoadError: " + str);
        }

        @Override // com.kwad.sdk.collector.d.a
        public final void onLoaded() {
            c.b(context, aVar);
        }
    }

    /* renamed from: com.kwad.sdk.collector.c$2 */
    static class AnonymousClass2 extends m<com.kwad.sdk.collector.kwai.a, AppStatusRules> {
        final /* synthetic */ Context jN;

        AnonymousClass2(Context context) {
            context = context;
        }

        @NonNull
        private static AppStatusRules bp(String str) {
            return AppStatusRules.createFromJson(str);
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: tE */
        public com.kwad.sdk.collector.kwai.a createRequest() {
            return new com.kwad.sdk.collector.kwai.a(bd.db(context));
        }

        @Override // com.kwad.sdk.core.network.m
        @NonNull
        public final /* synthetic */ AppStatusRules parseData(String str) {
            return bp(str);
        }
    }

    /* renamed from: com.kwad.sdk.collector.c$3 */
    static class AnonymousClass3 extends p<com.kwad.sdk.collector.kwai.a, AppStatusRules> {
        AnonymousClass3() {
        }

        private void a(@NonNull AppStatusRules appStatusRules) {
            a aVar = a.this;
            if (aVar != null) {
                aVar.b(appStatusRules);
            }
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        /* renamed from: a */
        public void onStartRequest(@NonNull com.kwad.sdk.collector.kwai.a aVar) {
            super.onStartRequest(aVar);
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        /* renamed from: a */
        public void onError(@NonNull com.kwad.sdk.collector.kwai.a aVar, int i2, String str) {
            super.onError(aVar, i2, str);
            a aVar2 = a.this;
            if (aVar2 != null) {
                aVar2.h(i2, str);
            }
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
            a((AppStatusRules) baseResultData);
        }
    }

    public interface a {
        void b(AppStatusRules appStatusRules);

        void h(int i2, String str);
    }

    public static void a(Context context, a aVar) {
        if (context == null) {
            return;
        }
        d.a(context, new d.a() { // from class: com.kwad.sdk.collector.c.1
            final /* synthetic */ a abd;
            final /* synthetic */ Context jN;

            AnonymousClass1(Context context2, a aVar2) {
                context = context2;
                aVar = aVar2;
            }

            @Override // com.kwad.sdk.collector.d.a
            public final void bo(String str) {
                com.kwad.sdk.core.d.b.e("AppStatusFetchConfigManager", "onLoadError: " + str);
            }

            @Override // com.kwad.sdk.collector.d.a
            public final void onLoaded() {
                c.b(context, aVar);
            }
        });
    }

    public static void b(Context context, a aVar) {
        new m<com.kwad.sdk.collector.kwai.a, AppStatusRules>() { // from class: com.kwad.sdk.collector.c.2
            final /* synthetic */ Context jN;

            AnonymousClass2(Context context2) {
                context = context2;
            }

            @NonNull
            private static AppStatusRules bp(String str) {
                return AppStatusRules.createFromJson(str);
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: tE */
            public com.kwad.sdk.collector.kwai.a createRequest() {
                return new com.kwad.sdk.collector.kwai.a(bd.db(context));
            }

            @Override // com.kwad.sdk.core.network.m
            @NonNull
            public final /* synthetic */ AppStatusRules parseData(String str) {
                return bp(str);
            }
        }.request(new p<com.kwad.sdk.collector.kwai.a, AppStatusRules>() { // from class: com.kwad.sdk.collector.c.3
            AnonymousClass3() {
            }

            private void a(@NonNull AppStatusRules appStatusRules) {
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.b(appStatusRules);
                }
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onStartRequest(@NonNull com.kwad.sdk.collector.kwai.a aVar2) {
                super.onStartRequest(aVar2);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onError(@NonNull com.kwad.sdk.collector.kwai.a aVar2, int i2, String str) {
                super.onError(aVar2, i2, str);
                a aVar22 = a.this;
                if (aVar22 != null) {
                    aVar22.h(i2, str);
                }
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
                a((AppStatusRules) baseResultData);
            }
        });
    }
}
