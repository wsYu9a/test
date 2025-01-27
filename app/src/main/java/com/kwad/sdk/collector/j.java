package com.kwad.sdk.collector;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.collector.model.jni.UploadEntryNative;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.utils.t;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class j {

    /* renamed from: com.kwad.sdk.collector.j$1 */
    static class AnonymousClass1 extends m<com.kwad.sdk.collector.kwai.b, CollectResponse> {
        final /* synthetic */ List abh;

        AnonymousClass1(List list) {
            list = list;
        }

        @NonNull
        private static CollectResponse br(String str) {
            CollectResponse collectResponse = new CollectResponse();
            collectResponse.parseJson(new JSONObject(str));
            return collectResponse;
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: tI */
        public com.kwad.sdk.collector.kwai.b createRequest() {
            return new com.kwad.sdk.collector.kwai.b(list);
        }

        @Override // com.kwad.sdk.core.network.m
        public final boolean enableMonitorReport() {
            return false;
        }

        @Override // com.kwad.sdk.core.network.m
        @NonNull
        public final /* synthetic */ CollectResponse parseData(String str) {
            return br(str);
        }
    }

    /* renamed from: com.kwad.sdk.collector.j$2 */
    static class AnonymousClass2 extends p<com.kwad.sdk.collector.kwai.b, CollectResponse> {
        final /* synthetic */ Context jN;

        AnonymousClass2(Context context) {
            context = context;
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        /* renamed from: a */
        public void onStartRequest(@NonNull com.kwad.sdk.collector.kwai.b bVar) {
            super.onStartRequest(bVar);
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        /* renamed from: a */
        public void onError(@NonNull com.kwad.sdk.collector.kwai.b bVar, int i2, String str) {
            super.onError(bVar, i2, str);
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        /* renamed from: a */
        public void onSuccess(@NonNull com.kwad.sdk.collector.kwai.b bVar, @NonNull CollectResponse collectResponse) {
            super.onSuccess(bVar, collectResponse);
            tJ();
        }

        private synchronized void tJ() {
            j.aB(context);
        }
    }

    @WorkerThread
    public static void a(Context context, AppStatusRules appStatusRules) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        long obtainUploadConfigFileMaxSize = appStatusRules.obtainUploadConfigFileMaxSize();
        List<com.kwad.sdk.collector.model.d> uploadTargets = appStatusRules.getUploadTargets();
        if (uploadTargets == null) {
            return;
        }
        List<com.kwad.sdk.collector.model.e> a2 = b.tD().a(uploadTargets, obtainUploadConfigFileMaxSize, new File(Environment.getExternalStorageDirectory(), "/Android/data/").getAbsolutePath() + "/");
        List<UploadEntryNative> aA = aA(context);
        if (aA != null) {
            a2.addAll(aA);
            HashSet hashSet = new HashSet(a2);
            a2.clear();
            a2.addAll(hashSet);
        }
        b(context, a2);
    }

    private static List<UploadEntryNative> aA(Context context) {
        File file = new File(context.getApplicationInfo().dataDir, "LOCAL_TEMP_UPLOAD_FAILURE_JSON");
        if (!file.exists()) {
            return null;
        }
        try {
            return t.eB(com.kwad.sdk.crash.utils.h.D(file));
        } catch (IOException unused) {
            return null;
        }
    }

    public static void aB(Context context) {
        try {
            File file = new File(context.getApplicationInfo().dataDir, "LOCAL_TEMP_UPLOAD_FAILURE_JSON");
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable unused) {
        }
    }

    @RequiresApi(api = 19)
    private static void b(Context context, List<com.kwad.sdk.collector.model.e> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        new m<com.kwad.sdk.collector.kwai.b, CollectResponse>() { // from class: com.kwad.sdk.collector.j.1
            final /* synthetic */ List abh;

            AnonymousClass1(List list2) {
                list = list2;
            }

            @NonNull
            private static CollectResponse br(String str) {
                CollectResponse collectResponse = new CollectResponse();
                collectResponse.parseJson(new JSONObject(str));
                return collectResponse;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: tI */
            public com.kwad.sdk.collector.kwai.b createRequest() {
                return new com.kwad.sdk.collector.kwai.b(list);
            }

            @Override // com.kwad.sdk.core.network.m
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.m
            @NonNull
            public final /* synthetic */ CollectResponse parseData(String str) {
                return br(str);
            }
        }.request(new p<com.kwad.sdk.collector.kwai.b, CollectResponse>() { // from class: com.kwad.sdk.collector.j.2
            final /* synthetic */ Context jN;

            AnonymousClass2(Context context2) {
                context = context2;
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onStartRequest(@NonNull com.kwad.sdk.collector.kwai.b bVar) {
                super.onStartRequest(bVar);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onError(@NonNull com.kwad.sdk.collector.kwai.b bVar, int i2, String str) {
                super.onError(bVar, i2, str);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onSuccess(@NonNull com.kwad.sdk.collector.kwai.b bVar, @NonNull CollectResponse collectResponse) {
                super.onSuccess(bVar, collectResponse);
                tJ();
            }

            private synchronized void tJ() {
                j.aB(context);
            }
        });
    }
}
