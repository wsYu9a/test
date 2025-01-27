package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ab implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b YR;
    private boolean Ze;
    private Handler Zm;
    private boolean Zq;
    private boolean Zr;

    /* renamed from: ee */
    @Nullable
    private com.kwad.sdk.core.webview.d.a.a f11945ee;

    @Nullable
    private final com.kwad.components.core.e.d.c mApkDownloadHelper;

    /* renamed from: com.kwad.components.core.webview.jshandler.ab$1 */
    public class AnonymousClass1 extends com.kwad.sdk.utils.bd {
        final /* synthetic */ com.kwad.sdk.core.webview.d.b.a Zj;

        /* renamed from: com.kwad.components.core.webview.jshandler.ab$1$1 */
        public class C04501 implements a.b {
            public C04501() {
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (ab.this.f11945ee != null) {
                    ab.this.f11945ee.a(aVar);
                }
            }
        }

        public AnonymousClass1(com.kwad.sdk.core.webview.d.b.a aVar) {
            aVar = aVar;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (ab.this.YR.aIf || aVar.aan) {
                ab.this.YR.getAdTemplate();
                com.kwad.components.core.e.d.a.a(ab.this.YR.QI.getContext(), ab.this.YR.getAdTemplate(), new a.b() { // from class: com.kwad.components.core.webview.jshandler.ab.1.1
                    public C04501() {
                    }

                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        if (ab.this.f11945ee != null) {
                            ab.this.f11945ee.a(aVar);
                        }
                    }
                }, ab.this.mApkDownloadHelper, aVar.aan, ab.this.Ze, ab.this.Zq, ab.this.Zr);
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.jshandler.ab$2 */
    public class AnonymousClass2 extends com.kwad.sdk.utils.bd {
        final /* synthetic */ com.kwad.sdk.core.webview.d.b.a Zj;

        public AnonymousClass2(com.kwad.sdk.core.webview.d.b.a aVar) {
            aVar = aVar;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (ab.this.f11945ee != null) {
                ab.this.f11945ee.a(aVar);
            }
        }
    }

    public ab(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, boolean z10, boolean z11, boolean z12) {
        this.Zq = false;
        this.Zr = false;
        this.Ze = z10;
        this.Zm = new Handler(Looper.getMainLooper());
        this.YR = bVar;
        this.mApkDownloadHelper = cVar;
        this.Zq = false;
        if (cVar != null) {
            cVar.at(1);
        }
        this.f11945ee = aVar;
        this.Zr = z12;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "convert";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.Zm.removeCallbacksAndMessages(null);
        this.f11945ee = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.YR.IC()) {
            cVar.onError(-1, "native adTemplate is null");
            return;
        }
        com.kwad.sdk.core.webview.d.b.a aVar = new com.kwad.sdk.core.webview.d.b.a();
        try {
            aVar.parseJson(new JSONObject(str));
            aVar.Ms = true;
        } catch (JSONException e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
        }
        if (this.YR.aIe) {
            this.Zm.post(new com.kwad.sdk.utils.bd() { // from class: com.kwad.components.core.webview.jshandler.ab.1
                final /* synthetic */ com.kwad.sdk.core.webview.d.b.a Zj;

                /* renamed from: com.kwad.components.core.webview.jshandler.ab$1$1 */
                public class C04501 implements a.b {
                    public C04501() {
                    }

                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        if (ab.this.f11945ee != null) {
                            ab.this.f11945ee.a(aVar);
                        }
                    }
                }

                public AnonymousClass1(com.kwad.sdk.core.webview.d.b.a aVar2) {
                    aVar = aVar2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    if (ab.this.YR.aIf || aVar.aan) {
                        ab.this.YR.getAdTemplate();
                        com.kwad.components.core.e.d.a.a(ab.this.YR.QI.getContext(), ab.this.YR.getAdTemplate(), new a.b() { // from class: com.kwad.components.core.webview.jshandler.ab.1.1
                            public C04501() {
                            }

                            @Override // com.kwad.components.core.e.d.a.b
                            public final void onAdClicked() {
                                if (ab.this.f11945ee != null) {
                                    ab.this.f11945ee.a(aVar);
                                }
                            }
                        }, ab.this.mApkDownloadHelper, aVar.aan, ab.this.Ze, ab.this.Zq, ab.this.Zr);
                    }
                }
            });
        } else if (this.f11945ee != null) {
            this.Zm.post(new com.kwad.sdk.utils.bd() { // from class: com.kwad.components.core.webview.jshandler.ab.2
                final /* synthetic */ com.kwad.sdk.core.webview.d.b.a Zj;

                public AnonymousClass2(com.kwad.sdk.core.webview.d.b.a aVar2) {
                    aVar = aVar2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    if (ab.this.f11945ee != null) {
                        ab.this.f11945ee.a(aVar);
                    }
                }
            });
        }
        cVar.a(null);
    }

    public ab(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar) {
        this(bVar, cVar, aVar, false, false, false);
    }

    public ab(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, byte b10) {
        this(bVar, cVar, aVar, false, false, false);
    }
}
