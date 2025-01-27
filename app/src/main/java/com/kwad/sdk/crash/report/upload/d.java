package com.kwad.sdk.crash.report.upload;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.crash.utils.g;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.utils.u;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: com.kwad.sdk.crash.report.upload.d$1 */
    public class AnonymousClass1 extends l<c, GetUploadTokenResult> {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: JS */
        public c createRequest() {
            return new c(ba.getDeviceId(), f.this.aMg, com.sigmob.sdk.archives.d.f17516f);
        }

        @NonNull
        private static GetUploadTokenResult fW(String str) {
            JSONObject jSONObject = new JSONObject(str);
            GetUploadTokenResult getUploadTokenResult = new GetUploadTokenResult();
            getUploadTokenResult.parseJson(jSONObject);
            return getUploadTokenResult;
        }

        @Override // com.kwad.sdk.core.network.l
        public final boolean isPostByJson() {
            return false;
        }

        @Override // com.kwad.sdk.core.network.l
        @NonNull
        public final /* synthetic */ GetUploadTokenResult parseData(String str) {
            return fW(str);
        }
    }

    public static void a(@NonNull File file, boolean z10, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "upload()" + Thread.currentThread());
        f fVar = new f();
        fVar.aMi = ba.getDeviceId();
        HashMap hashMap = new HashMap();
        hashMap.put("mLogUUID", g.fX(file.getName()));
        fVar.aMk = new JSONObject(hashMap).toString();
        fVar.aMl = u.getExtension(file.getName());
        fVar.aMn = file;
        new l<c, GetUploadTokenResult>() { // from class: com.kwad.sdk.crash.report.upload.d.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: JS */
            public c createRequest() {
                return new c(ba.getDeviceId(), f.this.aMg, com.sigmob.sdk.archives.d.f17516f);
            }

            @NonNull
            private static GetUploadTokenResult fW(String str) {
                JSONObject jSONObject = new JSONObject(str);
                GetUploadTokenResult getUploadTokenResult = new GetUploadTokenResult();
                getUploadTokenResult.parseJson(jSONObject);
                return getUploadTokenResult;
            }

            @Override // com.kwad.sdk.core.network.l
            public final boolean isPostByJson() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ GetUploadTokenResult parseData(String str) {
                return fW(str);
            }
        }.request(new o<c, GetUploadTokenResult>() { // from class: com.kwad.sdk.crash.report.upload.d.2
            final /* synthetic */ CountDownLatch aLN;
            final /* synthetic */ File aLR;
            final /* synthetic */ boolean aLS;

            /* renamed from: com.kwad.sdk.crash.report.upload.d$2$1 */
            public class AnonymousClass1 implements a {
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.crash.report.upload.a
                public final void JQ() {
                    CountDownLatch countDownLatch = countDownLatch;
                    if (countDownLatch != null) {
                        countDownLatch.countDown();
                    }
                }

                @Override // com.kwad.sdk.crash.report.upload.a
                public final void JR() {
                    com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploadLogFile onSuccess " + Thread.currentThread() + " delete file:" + file.getPath());
                    CountDownLatch countDownLatch = countDownLatch;
                    if (countDownLatch != null) {
                        countDownLatch.countDown();
                    }
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    if (z11) {
                        u.delete(file.getPath());
                    }
                }
            }

            public AnonymousClass2(File file2, CountDownLatch countDownLatch2, boolean z11) {
                file = file2;
                countDownLatch = countDownLatch2;
                z11 = z11;
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onSuccess(@NonNull c cVar, @NonNull GetUploadTokenResult getUploadTokenResult) {
                com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "onSuccess url=" + cVar.getUrl() + " ---{" + getUploadTokenResult.uploadToken);
                if (getUploadTokenResult.isResultOk()) {
                    f fVar2 = f.this;
                    fVar2.aMm = getUploadTokenResult.uploadToken;
                    b.a(file, fVar2, new a() { // from class: com.kwad.sdk.crash.report.upload.d.2.1
                        public AnonymousClass1() {
                        }

                        @Override // com.kwad.sdk.crash.report.upload.a
                        public final void JQ() {
                            CountDownLatch countDownLatch2 = countDownLatch;
                            if (countDownLatch2 != null) {
                                countDownLatch2.countDown();
                            }
                        }

                        @Override // com.kwad.sdk.crash.report.upload.a
                        public final void JR() {
                            com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploadLogFile onSuccess " + Thread.currentThread() + " delete file:" + file.getPath());
                            CountDownLatch countDownLatch2 = countDownLatch;
                            if (countDownLatch2 != null) {
                                countDownLatch2.countDown();
                            }
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            if (z11) {
                                u.delete(file.getPath());
                            }
                        }
                    });
                }
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull com.kwad.sdk.core.network.f fVar2, int i10, String str) {
                a((c) fVar2, i10, str);
            }

            private static void a(@NonNull c cVar, int i10, String str) {
                com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "onError errorCode=" + i10 + "errorMsg=" + str + "url=" + cVar.getUrl());
            }
        });
    }

    /* renamed from: com.kwad.sdk.crash.report.upload.d$2 */
    public class AnonymousClass2 extends o<c, GetUploadTokenResult> {
        final /* synthetic */ CountDownLatch aLN;
        final /* synthetic */ File aLR;
        final /* synthetic */ boolean aLS;

        /* renamed from: com.kwad.sdk.crash.report.upload.d$2$1 */
        public class AnonymousClass1 implements a {
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.crash.report.upload.a
            public final void JQ() {
                CountDownLatch countDownLatch2 = countDownLatch;
                if (countDownLatch2 != null) {
                    countDownLatch2.countDown();
                }
            }

            @Override // com.kwad.sdk.crash.report.upload.a
            public final void JR() {
                com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploadLogFile onSuccess " + Thread.currentThread() + " delete file:" + file.getPath());
                CountDownLatch countDownLatch2 = countDownLatch;
                if (countDownLatch2 != null) {
                    countDownLatch2.countDown();
                }
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                if (z11) {
                    u.delete(file.getPath());
                }
            }
        }

        public AnonymousClass2(File file2, CountDownLatch countDownLatch2, boolean z11) {
            file = file2;
            countDownLatch = countDownLatch2;
            z11 = z11;
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        /* renamed from: a */
        public void onSuccess(@NonNull c cVar, @NonNull GetUploadTokenResult getUploadTokenResult) {
            com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "onSuccess url=" + cVar.getUrl() + " ---{" + getUploadTokenResult.uploadToken);
            if (getUploadTokenResult.isResultOk()) {
                f fVar2 = f.this;
                fVar2.aMm = getUploadTokenResult.uploadToken;
                b.a(file, fVar2, new a() { // from class: com.kwad.sdk.crash.report.upload.d.2.1
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.crash.report.upload.a
                    public final void JQ() {
                        CountDownLatch countDownLatch2 = countDownLatch;
                        if (countDownLatch2 != null) {
                            countDownLatch2.countDown();
                        }
                    }

                    @Override // com.kwad.sdk.crash.report.upload.a
                    public final void JR() {
                        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploadLogFile onSuccess " + Thread.currentThread() + " delete file:" + file.getPath());
                        CountDownLatch countDownLatch2 = countDownLatch;
                        if (countDownLatch2 != null) {
                            countDownLatch2.countDown();
                        }
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        if (z11) {
                            u.delete(file.getPath());
                        }
                    }
                });
            }
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        public final /* synthetic */ void onError(@NonNull com.kwad.sdk.core.network.f fVar2, int i10, String str) {
            a((c) fVar2, i10, str);
        }

        private static void a(@NonNull c cVar, int i10, String str) {
            com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "onError errorCode=" + i10 + "errorMsg=" + str + "url=" + cVar.getUrl());
        }
    }
}
