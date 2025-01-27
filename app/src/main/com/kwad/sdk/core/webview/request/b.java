package com.kwad.sdk.core.webview.request;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.webview.d.b;
import com.kwad.sdk.utils.bd;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: hf */
    private static final Handler f11977hf = new Handler(Looper.getMainLooper());

    /* renamed from: com.kwad.sdk.core.webview.request.b$1 */
    public class AnonymousClass1 extends l<com.kwad.sdk.core.webview.request.a, WebCardGetDataResponse> {
        final /* synthetic */ b.a aJl;

        /* renamed from: com.kwad.sdk.core.webview.request.b$1$1 */
        public class C05031 extends com.kwad.sdk.core.webview.request.a {
            public C05031(String str, String str2, String str3) {
                super(str, str2, str3);
            }

            @Override // com.kwad.sdk.core.webview.request.a, com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
            public final String getUrl() {
                return aVar.url;
            }
        }

        public AnonymousClass1(b.a aVar) {
            aVar = aVar;
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: IS */
        public com.kwad.sdk.core.webview.request.a createRequest() {
            b.a aVar = aVar;
            return new com.kwad.sdk.core.webview.request.a(aVar.url, aVar.method, aVar.params) { // from class: com.kwad.sdk.core.webview.request.b.1.1
                public C05031(String str, String str2, String str3) {
                    super(str, str2, str3);
                }

                @Override // com.kwad.sdk.core.webview.request.a, com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
                public final String getUrl() {
                    return aVar.url;
                }
            };
        }

        @NonNull
        private static WebCardGetDataResponse fk(String str) {
            JSONObject jSONObject = new JSONObject(str);
            WebCardGetDataResponse webCardGetDataResponse = new WebCardGetDataResponse();
            webCardGetDataResponse.parseJson(jSONObject);
            return webCardGetDataResponse;
        }

        @Override // com.kwad.sdk.core.network.l
        @NonNull
        public final /* synthetic */ WebCardGetDataResponse parseData(String str) {
            return fk(str);
        }
    }

    /* renamed from: com.kwad.sdk.core.webview.request.b$2 */
    public class AnonymousClass2 extends o<com.kwad.sdk.core.webview.request.a, WebCardGetDataResponse> {
        final /* synthetic */ a aJo;

        /* renamed from: com.kwad.sdk.core.webview.request.b$2$1 */
        public class AnonymousClass1 extends bd {
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
            }
        }

        /* renamed from: com.kwad.sdk.core.webview.request.b$2$2 */
        public class C05042 extends bd {
            final /* synthetic */ WebCardGetDataResponse aJq;

            public C05042(WebCardGetDataResponse webCardGetDataResponse) {
                webCardGetDataResponse = webCardGetDataResponse;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                aVar2.a(webCardGetDataResponse);
            }
        }

        /* renamed from: com.kwad.sdk.core.webview.request.b$2$3 */
        public class AnonymousClass3 extends bd {
            final /* synthetic */ int Lw;
            final /* synthetic */ String Lx;

            public AnonymousClass3(int i10, String str) {
                i10 = i10;
                str = str;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                c.d("WebCardGetDataRequestManager", "load onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                aVar2.onError(i10, str);
            }
        }

        public AnonymousClass2(a aVar) {
            aVar2 = aVar;
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        /* renamed from: a */
        public void onStartRequest(@NonNull com.kwad.sdk.core.webview.request.a aVar) {
            super.onStartRequest(aVar);
            c.d("WebCardGetDataRequestManager", "onStartRequest");
            b.f11977hf.post(new bd() { // from class: com.kwad.sdk.core.webview.request.b.2.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                }
            });
        }

        private void b(@NonNull WebCardGetDataResponse webCardGetDataResponse) {
            c.d("WebCardGetDataRequestManager", "onSuccess");
            b.f11977hf.post(new bd() { // from class: com.kwad.sdk.core.webview.request.b.2.2
                final /* synthetic */ WebCardGetDataResponse aJq;

                public C05042(WebCardGetDataResponse webCardGetDataResponse2) {
                    webCardGetDataResponse = webCardGetDataResponse2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    aVar2.a(webCardGetDataResponse);
                }
            });
        }

        private void u(int i10, String str) {
            c.d("WebCardGetDataRequestManager", "onError errorCode=" + i10 + " errorMsg=" + str);
            b.f11977hf.post(new bd() { // from class: com.kwad.sdk.core.webview.request.b.2.3
                final /* synthetic */ int Lw;
                final /* synthetic */ String Lx;

                public AnonymousClass3(int i102, String str2) {
                    i10 = i102;
                    str = str2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    c.d("WebCardGetDataRequestManager", "load onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                    aVar2.onError(i10, str);
                }
            });
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        public final /* synthetic */ void onError(@NonNull f fVar, int i10, String str) {
            u(i10, str);
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
            b((WebCardGetDataResponse) baseResultData);
        }
    }

    public interface a {
        @MainThread
        void a(@NonNull WebCardGetDataResponse webCardGetDataResponse);

        @MainThread
        void onError(int i10, String str);
    }

    public final void a(b.a aVar, @NonNull a aVar2) {
        new l<com.kwad.sdk.core.webview.request.a, WebCardGetDataResponse>() { // from class: com.kwad.sdk.core.webview.request.b.1
            final /* synthetic */ b.a aJl;

            /* renamed from: com.kwad.sdk.core.webview.request.b$1$1 */
            public class C05031 extends com.kwad.sdk.core.webview.request.a {
                public C05031(String str, String str2, String str3) {
                    super(str, str2, str3);
                }

                @Override // com.kwad.sdk.core.webview.request.a, com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
                public final String getUrl() {
                    return aVar.url;
                }
            }

            public AnonymousClass1(b.a aVar3) {
                aVar = aVar3;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: IS */
            public com.kwad.sdk.core.webview.request.a createRequest() {
                b.a aVar3 = aVar;
                return new com.kwad.sdk.core.webview.request.a(aVar3.url, aVar3.method, aVar3.params) { // from class: com.kwad.sdk.core.webview.request.b.1.1
                    public C05031(String str, String str2, String str3) {
                        super(str, str2, str3);
                    }

                    @Override // com.kwad.sdk.core.webview.request.a, com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
                    public final String getUrl() {
                        return aVar.url;
                    }
                };
            }

            @NonNull
            private static WebCardGetDataResponse fk(String str) {
                JSONObject jSONObject = new JSONObject(str);
                WebCardGetDataResponse webCardGetDataResponse = new WebCardGetDataResponse();
                webCardGetDataResponse.parseJson(jSONObject);
                return webCardGetDataResponse;
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ WebCardGetDataResponse parseData(String str) {
                return fk(str);
            }
        }.request(new o<com.kwad.sdk.core.webview.request.a, WebCardGetDataResponse>() { // from class: com.kwad.sdk.core.webview.request.b.2
            final /* synthetic */ a aJo;

            /* renamed from: com.kwad.sdk.core.webview.request.b$2$1 */
            public class AnonymousClass1 extends bd {
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                }
            }

            /* renamed from: com.kwad.sdk.core.webview.request.b$2$2 */
            public class C05042 extends bd {
                final /* synthetic */ WebCardGetDataResponse aJq;

                public C05042(WebCardGetDataResponse webCardGetDataResponse2) {
                    webCardGetDataResponse = webCardGetDataResponse2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    aVar2.a(webCardGetDataResponse);
                }
            }

            /* renamed from: com.kwad.sdk.core.webview.request.b$2$3 */
            public class AnonymousClass3 extends bd {
                final /* synthetic */ int Lw;
                final /* synthetic */ String Lx;

                public AnonymousClass3(int i102, String str2) {
                    i10 = i102;
                    str = str2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    c.d("WebCardGetDataRequestManager", "load onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                    aVar2.onError(i10, str);
                }
            }

            public AnonymousClass2(a aVar22) {
                aVar2 = aVar22;
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onStartRequest(@NonNull com.kwad.sdk.core.webview.request.a aVar3) {
                super.onStartRequest(aVar3);
                c.d("WebCardGetDataRequestManager", "onStartRequest");
                b.f11977hf.post(new bd() { // from class: com.kwad.sdk.core.webview.request.b.2.1
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                    }
                });
            }

            private void b(@NonNull WebCardGetDataResponse webCardGetDataResponse2) {
                c.d("WebCardGetDataRequestManager", "onSuccess");
                b.f11977hf.post(new bd() { // from class: com.kwad.sdk.core.webview.request.b.2.2
                    final /* synthetic */ WebCardGetDataResponse aJq;

                    public C05042(WebCardGetDataResponse webCardGetDataResponse22) {
                        webCardGetDataResponse = webCardGetDataResponse22;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        aVar2.a(webCardGetDataResponse);
                    }
                });
            }

            private void u(int i102, String str2) {
                c.d("WebCardGetDataRequestManager", "onError errorCode=" + i102 + " errorMsg=" + str2);
                b.f11977hf.post(new bd() { // from class: com.kwad.sdk.core.webview.request.b.2.3
                    final /* synthetic */ int Lw;
                    final /* synthetic */ String Lx;

                    public AnonymousClass3(int i1022, String str22) {
                        i10 = i1022;
                        str = str22;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        c.d("WebCardGetDataRequestManager", "load onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                        aVar2.onError(i10, str);
                    }
                });
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull f fVar, int i10, String str) {
                u(i10, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                b((WebCardGetDataResponse) baseResultData);
            }
        });
    }
}
