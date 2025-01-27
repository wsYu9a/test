package com.kwad.sdk.core.webview.request;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.webview.c.b;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b {
    private static final Handler mHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.kwad.sdk.core.webview.request.b$1 */
    final class AnonymousClass1 extends m<com.kwad.sdk.core.webview.request.a, WebCardGetDataResponse> {
        final /* synthetic */ b.a aqs;

        /* renamed from: com.kwad.sdk.core.webview.request.b$1$1 */
        final class C02231 extends com.kwad.sdk.core.webview.request.a {
            C02231(String str, String str2, String str3) {
                super(str, str2, str3);
            }

            @Override // com.kwad.sdk.core.webview.request.a, com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
            public final String getUrl() {
                return aVar.url;
            }
        }

        AnonymousClass1(b.a aVar) {
            aVar = aVar;
        }

        @NonNull
        private static WebCardGetDataResponse dp(String str) {
            JSONObject jSONObject = new JSONObject(str);
            WebCardGetDataResponse webCardGetDataResponse = new WebCardGetDataResponse();
            webCardGetDataResponse.parseJson(jSONObject);
            return webCardGetDataResponse;
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: zh */
        public com.kwad.sdk.core.webview.request.a createRequest() {
            b.a aVar = aVar;
            return new com.kwad.sdk.core.webview.request.a(aVar.url, aVar.method, aVar.params) { // from class: com.kwad.sdk.core.webview.request.b.1.1
                C02231(String str, String str2, String str3) {
                    super(str, str2, str3);
                }

                @Override // com.kwad.sdk.core.webview.request.a, com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
                public final String getUrl() {
                    return aVar.url;
                }
            };
        }

        @Override // com.kwad.sdk.core.network.m
        @NonNull
        public final /* synthetic */ WebCardGetDataResponse parseData(String str) {
            return dp(str);
        }
    }

    /* renamed from: com.kwad.sdk.core.webview.request.b$2 */
    final class AnonymousClass2 extends p<com.kwad.sdk.core.webview.request.a, WebCardGetDataResponse> {
        final /* synthetic */ a aqv;

        /* renamed from: com.kwad.sdk.core.webview.request.b$2$1 */
        final class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
            }
        }

        /* renamed from: com.kwad.sdk.core.webview.request.b$2$2 */
        final class RunnableC02242 implements Runnable {
            final /* synthetic */ WebCardGetDataResponse aqx;

            RunnableC02242(WebCardGetDataResponse webCardGetDataResponse) {
                webCardGetDataResponse = webCardGetDataResponse;
            }

            @Override // java.lang.Runnable
            public final void run() {
                aVar2.a(webCardGetDataResponse);
            }
        }

        /* renamed from: com.kwad.sdk.core.webview.request.b$2$3 */
        final class AnonymousClass3 implements Runnable {
            final /* synthetic */ int HY;
            final /* synthetic */ String HZ;

            AnonymousClass3(int i2, String str) {
                i2 = i2;
                str = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.b.d("WebCardGetDataRequestManager", "load onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                aVar2.onError(i2, str);
            }
        }

        AnonymousClass2(a aVar) {
            aVar2 = aVar;
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        /* renamed from: a */
        public void onStartRequest(@NonNull com.kwad.sdk.core.webview.request.a aVar) {
            super.onStartRequest(aVar);
            com.kwad.sdk.core.d.b.d("WebCardGetDataRequestManager", "onStartRequest");
            b.mHandler.post(new Runnable() { // from class: com.kwad.sdk.core.webview.request.b.2.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                }
            });
        }

        private void b(@NonNull WebCardGetDataResponse webCardGetDataResponse) {
            com.kwad.sdk.core.d.b.d("WebCardGetDataRequestManager", "onSuccess");
            b.mHandler.post(new Runnable() { // from class: com.kwad.sdk.core.webview.request.b.2.2
                final /* synthetic */ WebCardGetDataResponse aqx;

                RunnableC02242(WebCardGetDataResponse webCardGetDataResponse2) {
                    webCardGetDataResponse = webCardGetDataResponse2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    aVar2.a(webCardGetDataResponse);
                }
            });
        }

        private void j(int i2, String str) {
            com.kwad.sdk.core.d.b.d("WebCardGetDataRequestManager", "onError errorCode=" + i2 + " errorMsg=" + str);
            b.mHandler.post(new Runnable() { // from class: com.kwad.sdk.core.webview.request.b.2.3
                final /* synthetic */ int HY;
                final /* synthetic */ String HZ;

                AnonymousClass3(int i22, String str2) {
                    i2 = i22;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.d.b.d("WebCardGetDataRequestManager", "load onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                    aVar2.onError(i2, str);
                }
            });
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        public final /* synthetic */ void onError(@NonNull g gVar, int i2, String str) {
            j(i2, str);
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        public final /* synthetic */ void onSuccess(@NonNull g gVar, @NonNull BaseResultData baseResultData) {
            b((WebCardGetDataResponse) baseResultData);
        }
    }

    public interface a {
        @MainThread
        void a(@NonNull WebCardGetDataResponse webCardGetDataResponse);

        @MainThread
        void onError(int i2, String str);
    }

    public final void a(b.a aVar, @NonNull a aVar2) {
        new m<com.kwad.sdk.core.webview.request.a, WebCardGetDataResponse>() { // from class: com.kwad.sdk.core.webview.request.b.1
            final /* synthetic */ b.a aqs;

            /* renamed from: com.kwad.sdk.core.webview.request.b$1$1 */
            final class C02231 extends com.kwad.sdk.core.webview.request.a {
                C02231(String str, String str2, String str3) {
                    super(str, str2, str3);
                }

                @Override // com.kwad.sdk.core.webview.request.a, com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
                public final String getUrl() {
                    return aVar.url;
                }
            }

            AnonymousClass1(b.a aVar3) {
                aVar = aVar3;
            }

            @NonNull
            private static WebCardGetDataResponse dp(String str) {
                JSONObject jSONObject = new JSONObject(str);
                WebCardGetDataResponse webCardGetDataResponse = new WebCardGetDataResponse();
                webCardGetDataResponse.parseJson(jSONObject);
                return webCardGetDataResponse;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: zh */
            public com.kwad.sdk.core.webview.request.a createRequest() {
                b.a aVar3 = aVar;
                return new com.kwad.sdk.core.webview.request.a(aVar3.url, aVar3.method, aVar3.params) { // from class: com.kwad.sdk.core.webview.request.b.1.1
                    C02231(String str, String str2, String str3) {
                        super(str, str2, str3);
                    }

                    @Override // com.kwad.sdk.core.webview.request.a, com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
                    public final String getUrl() {
                        return aVar.url;
                    }
                };
            }

            @Override // com.kwad.sdk.core.network.m
            @NonNull
            public final /* synthetic */ WebCardGetDataResponse parseData(String str) {
                return dp(str);
            }
        }.request(new p<com.kwad.sdk.core.webview.request.a, WebCardGetDataResponse>() { // from class: com.kwad.sdk.core.webview.request.b.2
            final /* synthetic */ a aqv;

            /* renamed from: com.kwad.sdk.core.webview.request.b$2$1 */
            final class AnonymousClass1 implements Runnable {
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                }
            }

            /* renamed from: com.kwad.sdk.core.webview.request.b$2$2 */
            final class RunnableC02242 implements Runnable {
                final /* synthetic */ WebCardGetDataResponse aqx;

                RunnableC02242(WebCardGetDataResponse webCardGetDataResponse2) {
                    webCardGetDataResponse = webCardGetDataResponse2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    aVar2.a(webCardGetDataResponse);
                }
            }

            /* renamed from: com.kwad.sdk.core.webview.request.b$2$3 */
            final class AnonymousClass3 implements Runnable {
                final /* synthetic */ int HY;
                final /* synthetic */ String HZ;

                AnonymousClass3(int i22, String str2) {
                    i2 = i22;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.d.b.d("WebCardGetDataRequestManager", "load onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                    aVar2.onError(i2, str);
                }
            }

            AnonymousClass2(a aVar22) {
                aVar2 = aVar22;
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onStartRequest(@NonNull com.kwad.sdk.core.webview.request.a aVar3) {
                super.onStartRequest(aVar3);
                com.kwad.sdk.core.d.b.d("WebCardGetDataRequestManager", "onStartRequest");
                b.mHandler.post(new Runnable() { // from class: com.kwad.sdk.core.webview.request.b.2.1
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                    }
                });
            }

            private void b(@NonNull WebCardGetDataResponse webCardGetDataResponse2) {
                com.kwad.sdk.core.d.b.d("WebCardGetDataRequestManager", "onSuccess");
                b.mHandler.post(new Runnable() { // from class: com.kwad.sdk.core.webview.request.b.2.2
                    final /* synthetic */ WebCardGetDataResponse aqx;

                    RunnableC02242(WebCardGetDataResponse webCardGetDataResponse22) {
                        webCardGetDataResponse = webCardGetDataResponse22;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        aVar2.a(webCardGetDataResponse);
                    }
                });
            }

            private void j(int i22, String str2) {
                com.kwad.sdk.core.d.b.d("WebCardGetDataRequestManager", "onError errorCode=" + i22 + " errorMsg=" + str2);
                b.mHandler.post(new Runnable() { // from class: com.kwad.sdk.core.webview.request.b.2.3
                    final /* synthetic */ int HY;
                    final /* synthetic */ String HZ;

                    AnonymousClass3(int i222, String str22) {
                        i2 = i222;
                        str = str22;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.b.d("WebCardGetDataRequestManager", "load onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                        aVar2.onError(i2, str);
                    }
                });
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onError(@NonNull g gVar, int i2, String str) {
                j(i2, str);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(@NonNull g gVar, @NonNull BaseResultData baseResultData) {
                b((WebCardGetDataResponse) baseResultData);
            }
        });
    }
}
