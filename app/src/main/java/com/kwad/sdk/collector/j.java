package com.kwad.sdk.collector;

import android.content.Context;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.collector.model.jni.UploadEntryNative;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.utils.x;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class j {

    /* renamed from: com.kwad.sdk.collector.j$1 */
    public class AnonymousClass1 extends l<com.kwad.sdk.collector.a.b, CollectResponse> {
        final /* synthetic */ List arb;

        public AnonymousClass1(List list) {
            list = list;
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: BX */
        public com.kwad.sdk.collector.a.b createRequest() {
            return new com.kwad.sdk.collector.a.b(list);
        }

        @NonNull
        private static CollectResponse cA(String str) {
            CollectResponse collectResponse = new CollectResponse();
            collectResponse.parseJson(new JSONObject(str));
            return collectResponse;
        }

        @Override // com.kwad.sdk.core.network.l
        public final boolean enableMonitorReport() {
            return false;
        }

        @Override // com.kwad.sdk.core.network.l
        @NonNull
        public final /* synthetic */ CollectResponse parseData(String str) {
            return cA(str);
        }
    }

    /* renamed from: com.kwad.sdk.collector.j$2 */
    public class AnonymousClass2 extends o<com.kwad.sdk.collector.a.b, CollectResponse> {
        final /* synthetic */ Context hB;

        public AnonymousClass2(Context context) {
            context = context;
        }

        private synchronized void BY() {
            j.be(context);
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        /* renamed from: a */
        public void onStartRequest(@NonNull com.kwad.sdk.collector.a.b bVar) {
            super.onStartRequest(bVar);
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        /* renamed from: a */
        public void onSuccess(@NonNull com.kwad.sdk.collector.a.b bVar, @NonNull CollectResponse collectResponse) {
            super.onSuccess(bVar, collectResponse);
            BY();
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        /* renamed from: a */
        public void onError(@NonNull com.kwad.sdk.collector.a.b bVar, int i10, String str) {
            super.onError(bVar, i10, str);
        }
    }

    @WorkerThread
    public static void a(Context context, AppStatusRules appStatusRules) {
        long obtainUploadConfigFileMaxSize = appStatusRules.obtainUploadConfigFileMaxSize();
        List<com.kwad.sdk.collector.model.d> uploadTargets = appStatusRules.getUploadTargets();
        if (uploadTargets == null) {
            return;
        }
        List<com.kwad.sdk.collector.model.e> a10 = b.BS().a(uploadTargets, obtainUploadConfigFileMaxSize, new File(Environment.getExternalStorageDirectory(), "/Android/data/").getAbsolutePath() + "/");
        List<UploadEntryNative> bd2 = bd(context);
        if (bd2 != null) {
            a10.addAll(bd2);
            HashSet hashSet = new HashSet(a10);
            a10.clear();
            a10.addAll(hashSet);
        }
        d(context, a10);
    }

    private static List<UploadEntryNative> bd(Context context) {
        File file = new File(context.getApplicationInfo().dataDir, "LOCAL_TEMP_UPLOAD_FAILURE_JSON");
        if (!file.exists()) {
            return null;
        }
        try {
            return x.gK(com.kwad.sdk.crash.utils.h.J(file));
        } catch (IOException unused) {
            return null;
        }
    }

    public static void be(Context context) {
        try {
            File file = new File(context.getApplicationInfo().dataDir, "LOCAL_TEMP_UPLOAD_FAILURE_JSON");
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable unused) {
        }
    }

    @RequiresApi(api = 19)
    private static void d(Context context, List<com.kwad.sdk.collector.model.e> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        new l<com.kwad.sdk.collector.a.b, CollectResponse>() { // from class: com.kwad.sdk.collector.j.1
            final /* synthetic */ List arb;

            public AnonymousClass1(List list2) {
                list = list2;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: BX */
            public com.kwad.sdk.collector.a.b createRequest() {
                return new com.kwad.sdk.collector.a.b(list);
            }

            @NonNull
            private static CollectResponse cA(String str) {
                CollectResponse collectResponse = new CollectResponse();
                collectResponse.parseJson(new JSONObject(str));
                return collectResponse;
            }

            @Override // com.kwad.sdk.core.network.l
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ CollectResponse parseData(String str) {
                return cA(str);
            }
        }.request(new o<com.kwad.sdk.collector.a.b, CollectResponse>() { // from class: com.kwad.sdk.collector.j.2
            final /* synthetic */ Context hB;

            public AnonymousClass2(Context context2) {
                context = context2;
            }

            private synchronized void BY() {
                j.be(context);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onStartRequest(@NonNull com.kwad.sdk.collector.a.b bVar) {
                super.onStartRequest(bVar);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onSuccess(@NonNull com.kwad.sdk.collector.a.b bVar, @NonNull CollectResponse collectResponse) {
                super.onSuccess(bVar, collectResponse);
                BY();
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onError(@NonNull com.kwad.sdk.collector.a.b bVar, int i10, String str) {
                super.onError(bVar, i10, str);
            }
        });
    }
}
