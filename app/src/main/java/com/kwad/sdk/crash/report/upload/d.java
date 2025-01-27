package com.kwad.sdk.crash.report.upload;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: com.kwad.sdk.crash.report.upload.d$1 */
    static class AnonymousClass1 extends m<c, GetUploadTokenResult> {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: Ah */
        public c createRequest() {
            return new c(au.getDeviceId(), f.this.asU, "zip");
        }

        @NonNull
        private static GetUploadTokenResult dV(String str) {
            JSONObject jSONObject = new JSONObject(str);
            GetUploadTokenResult getUploadTokenResult = new GetUploadTokenResult();
            getUploadTokenResult.parseJson(jSONObject);
            return getUploadTokenResult;
        }

        @Override // com.kwad.sdk.core.network.m
        public final boolean isPostByJson() {
            return false;
        }

        @Override // com.kwad.sdk.core.network.m
        @NonNull
        public final /* synthetic */ GetUploadTokenResult parseData(String str) {
            return dV(str);
        }
    }

    /* renamed from: com.kwad.sdk.crash.report.upload.d$2 */
    static class AnonymousClass2 extends p<c, GetUploadTokenResult> {
        final /* synthetic */ CountDownLatch asB;
        final /* synthetic */ File asF;
        final /* synthetic */ boolean asG;

        /* renamed from: com.kwad.sdk.crash.report.upload.d$2$1 */
        final class AnonymousClass1 implements a {
            AnonymousClass1() {
            }

            @Override // com.kwad.sdk.crash.report.upload.a
            public final void Af() {
                CountDownLatch countDownLatch = countDownLatch;
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }

            @Override // com.kwad.sdk.crash.report.upload.a
            public final void Ag() {
                com.kwad.sdk.core.d.b.d("ExceptionCollector", "uploadLogFile onSuccess " + Thread.currentThread() + " delete file:" + file.getPath());
                CountDownLatch countDownLatch = countDownLatch;
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                if (z2) {
                    q.delete(file.getPath());
                }
            }
        }

        AnonymousClass2(File file, CountDownLatch countDownLatch, boolean z) {
            file = file;
            countDownLatch = countDownLatch;
            z2 = z;
        }

        private static void a(@NonNull c cVar, int i2, String str) {
            com.kwad.sdk.core.d.b.d("ExceptionCollector", "onError errorCode=" + i2 + "errorMsg=" + str + "url=" + cVar.getUrl());
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        /* renamed from: a */
        public void onSuccess(@NonNull c cVar, @NonNull GetUploadTokenResult getUploadTokenResult) {
            com.kwad.sdk.core.d.b.d("ExceptionCollector", "onSuccess url=" + cVar.getUrl() + " ---{" + getUploadTokenResult.uploadToken);
            if (getUploadTokenResult.isResultOk()) {
                f fVar = f.this;
                fVar.ata = getUploadTokenResult.uploadToken;
                b.a(file, fVar, new a() { // from class: com.kwad.sdk.crash.report.upload.d.2.1
                    AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.crash.report.upload.a
                    public final void Af() {
                        CountDownLatch countDownLatch = countDownLatch;
                        if (countDownLatch != null) {
                            countDownLatch.countDown();
                        }
                    }

                    @Override // com.kwad.sdk.crash.report.upload.a
                    public final void Ag() {
                        com.kwad.sdk.core.d.b.d("ExceptionCollector", "uploadLogFile onSuccess " + Thread.currentThread() + " delete file:" + file.getPath());
                        CountDownLatch countDownLatch = countDownLatch;
                        if (countDownLatch != null) {
                            countDownLatch.countDown();
                        }
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        if (z2) {
                            q.delete(file.getPath());
                        }
                    }
                });
            }
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        public final /* synthetic */ void onError(@NonNull g gVar, int i2, String str) {
            a((c) gVar, i2, str);
        }
    }

    public static void a(@NonNull File file, boolean z, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.core.d.b.d("ExceptionCollector", "upload()" + Thread.currentThread());
        f fVar = new f();
        fVar.asW = au.getDeviceId();
        HashMap hashMap = new HashMap();
        hashMap.put("mLogUUID", com.kwad.sdk.crash.utils.g.dW(file.getName()));
        fVar.asY = new JSONObject(hashMap).toString();
        fVar.asZ = q.getExtension(file.getName());
        fVar.atb = file;
        new m<c, GetUploadTokenResult>() { // from class: com.kwad.sdk.crash.report.upload.d.1
            AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: Ah */
            public c createRequest() {
                return new c(au.getDeviceId(), f.this.asU, "zip");
            }

            @NonNull
            private static GetUploadTokenResult dV(String str) {
                JSONObject jSONObject = new JSONObject(str);
                GetUploadTokenResult getUploadTokenResult = new GetUploadTokenResult();
                getUploadTokenResult.parseJson(jSONObject);
                return getUploadTokenResult;
            }

            @Override // com.kwad.sdk.core.network.m
            public final boolean isPostByJson() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.m
            @NonNull
            public final /* synthetic */ GetUploadTokenResult parseData(String str) {
                return dV(str);
            }
        }.request(new p<c, GetUploadTokenResult>() { // from class: com.kwad.sdk.crash.report.upload.d.2
            final /* synthetic */ CountDownLatch asB;
            final /* synthetic */ File asF;
            final /* synthetic */ boolean asG;

            /* renamed from: com.kwad.sdk.crash.report.upload.d$2$1 */
            final class AnonymousClass1 implements a {
                AnonymousClass1() {
                }

                @Override // com.kwad.sdk.crash.report.upload.a
                public final void Af() {
                    CountDownLatch countDownLatch = countDownLatch;
                    if (countDownLatch != null) {
                        countDownLatch.countDown();
                    }
                }

                @Override // com.kwad.sdk.crash.report.upload.a
                public final void Ag() {
                    com.kwad.sdk.core.d.b.d("ExceptionCollector", "uploadLogFile onSuccess " + Thread.currentThread() + " delete file:" + file.getPath());
                    CountDownLatch countDownLatch = countDownLatch;
                    if (countDownLatch != null) {
                        countDownLatch.countDown();
                    }
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    if (z2) {
                        q.delete(file.getPath());
                    }
                }
            }

            AnonymousClass2(File file2, CountDownLatch countDownLatch2, boolean z2) {
                file = file2;
                countDownLatch = countDownLatch2;
                z2 = z2;
            }

            private static void a(@NonNull c cVar, int i2, String str) {
                com.kwad.sdk.core.d.b.d("ExceptionCollector", "onError errorCode=" + i2 + "errorMsg=" + str + "url=" + cVar.getUrl());
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onSuccess(@NonNull c cVar, @NonNull GetUploadTokenResult getUploadTokenResult) {
                com.kwad.sdk.core.d.b.d("ExceptionCollector", "onSuccess url=" + cVar.getUrl() + " ---{" + getUploadTokenResult.uploadToken);
                if (getUploadTokenResult.isResultOk()) {
                    f fVar2 = f.this;
                    fVar2.ata = getUploadTokenResult.uploadToken;
                    b.a(file, fVar2, new a() { // from class: com.kwad.sdk.crash.report.upload.d.2.1
                        AnonymousClass1() {
                        }

                        @Override // com.kwad.sdk.crash.report.upload.a
                        public final void Af() {
                            CountDownLatch countDownLatch2 = countDownLatch;
                            if (countDownLatch2 != null) {
                                countDownLatch2.countDown();
                            }
                        }

                        @Override // com.kwad.sdk.crash.report.upload.a
                        public final void Ag() {
                            com.kwad.sdk.core.d.b.d("ExceptionCollector", "uploadLogFile onSuccess " + Thread.currentThread() + " delete file:" + file.getPath());
                            CountDownLatch countDownLatch2 = countDownLatch;
                            if (countDownLatch2 != null) {
                                countDownLatch2.countDown();
                            }
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            if (z2) {
                                q.delete(file.getPath());
                            }
                        }
                    });
                }
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onError(@NonNull g gVar, int i2, String str) {
                a((c) gVar, i2, str);
            }
        });
    }
}
