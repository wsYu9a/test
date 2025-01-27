package com.kwad.components.core.webview.jshandler;

import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bt;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class y implements com.kwad.sdk.core.webview.c.a {
    protected final com.kwad.sdk.core.webview.b YR;
    private int Zd;
    private boolean Ze;
    private final boolean Zf;
    private boolean Zg;
    private List<com.kwad.components.core.e.d.c> Zh;
    private boolean Zi;

    /* renamed from: ee */
    @Nullable
    private com.kwad.sdk.core.webview.d.a.a f11956ee;

    /* renamed from: ze */
    @Nullable
    private DialogInterface.OnDismissListener f11957ze;

    /* renamed from: com.kwad.components.core.webview.jshandler.y$1 */
    public class AnonymousClass1 extends com.kwad.sdk.utils.bd {
        final /* synthetic */ com.kwad.sdk.core.webview.d.b.a Zj;

        /* renamed from: com.kwad.components.core.webview.jshandler.y$1$1 */
        public class C04541 implements a.b {
            public C04541() {
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                y.this.jC();
                if (y.this.f11956ee != null) {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    if (aVar.aJh) {
                        return;
                    }
                    y.this.f11956ee.a(aVar);
                }
            }
        }

        public AnonymousClass1(com.kwad.sdk.core.webview.d.b.a aVar) {
            aVar = aVar;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            String str;
            TKAdLiveShopItemInfo tKAdLiveShopItemInfo;
            com.kwad.sdk.core.webview.b bVar = y.this.YR;
            if (bVar.aIf) {
                com.kwad.sdk.core.webview.d.b.a aVar = aVar;
                AdTemplate adTemplate = aVar.adTemplate;
                if (adTemplate != null) {
                    y.this.Zh.add(new com.kwad.components.core.e.d.c(adTemplate));
                } else if (aVar.creativeId >= 0) {
                    List<AdTemplate> IB = bVar.IB();
                    com.kwad.sdk.core.webview.d.b.a aVar2 = aVar;
                    adTemplate = com.kwad.sdk.core.response.b.e.a(IB, aVar2.creativeId, aVar2.adStyle);
                } else {
                    adTemplate = bVar.getAdTemplate();
                    aVar.creativeId = com.kwad.sdk.core.response.b.e.el(adTemplate);
                    aVar.adStyle = com.kwad.sdk.core.response.b.e.dW(adTemplate);
                }
                com.kwad.components.core.e.d.c K = y.this.K(aVar.creativeId);
                if (y.this.f11957ze != null && K != null) {
                    K.setOnDismissListener(y.this.f11957ze);
                }
                if (TextUtils.isEmpty(aVar.MU)) {
                    str = (adTemplate == null || (tKAdLiveShopItemInfo = adTemplate.tkLiveShopItemInfo) == null) ? null : tKAdLiveShopItemInfo.itemId;
                } else {
                    try {
                        str = com.kwad.components.core.e.b.a.t(Long.parseLong(aVar.MU));
                    } catch (Exception unused) {
                        str = aVar.MU;
                    }
                }
                y.this.L(com.kwad.components.core.e.d.a.a(y.this.a(new a.C0427a(y.this.YR.QI.getContext()).au(adTemplate).b(K).ah(str).ap(y.a(y.this, aVar)).aq(y.this.Ze).c(y.this.YR.mReportExtData).ao(aVar.aap).am(aVar.aJf).an(aVar.lz).ar(y.this.Zf || aVar.MG).as(y.this.Zd).am(y.this.Zi).at(y.this.Zg).ax(true).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.y.1.1
                    public C04541() {
                    }

                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        y.this.jC();
                        if (y.this.f11956ee != null) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            if (aVar.aJh) {
                                return;
                            }
                            y.this.f11956ee.a(aVar);
                        }
                    }
                }), aVar, adTemplate)));
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.jshandler.y$2 */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ com.kwad.sdk.core.webview.d.b.a Zj;

        public AnonymousClass2(com.kwad.sdk.core.webview.d.b.a aVar) {
            aVar = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (y.this.f11956ee == null || aVar.aJh) {
                return;
            }
            y.this.f11956ee.a(aVar);
        }
    }

    public y(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, boolean z10, int i10, boolean z11, boolean z12) {
        this.Ze = false;
        this.Zh = new ArrayList();
        this.Ze = z10;
        this.YR = bVar;
        this.Zd = i10;
        if (cVar != null) {
            cVar.at(1);
            this.Zh.add(cVar);
        }
        this.f11956ee = aVar;
        this.Zf = z11;
        this.Zi = z12;
    }

    @Nullable
    public final com.kwad.components.core.e.d.c K(long j10) {
        List<com.kwad.components.core.e.d.c> list = this.Zh;
        if (list == null) {
            return null;
        }
        if (j10 < 0 && list.size() == 1) {
            return this.Zh.get(0);
        }
        for (com.kwad.components.core.e.d.c cVar : this.Zh) {
            if (com.kwad.sdk.core.response.b.e.el(cVar.oQ()) == j10) {
                return cVar;
            }
        }
        return null;
    }

    public void L(int i10) {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "clickAction";
    }

    public void jC() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.f11956ee = null;
    }

    public static /* synthetic */ boolean a(y yVar, com.kwad.sdk.core.webview.d.b.a aVar) {
        return b(aVar);
    }

    private static boolean b(com.kwad.sdk.core.webview.d.b.a aVar) {
        return aVar.aap == 1;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.core.webview.d.b.a aVar = new com.kwad.sdk.core.webview.d.b.a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (JSONException e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
        }
        if (this.YR.IC() && aVar.adTemplate == null) {
            cVar.onError(-1, "native adTemplate is null");
            return;
        }
        if (this.YR.aIe && !aVar.aJg) {
            bt.runOnUiThread(new com.kwad.sdk.utils.bd() { // from class: com.kwad.components.core.webview.jshandler.y.1
                final /* synthetic */ com.kwad.sdk.core.webview.d.b.a Zj;

                /* renamed from: com.kwad.components.core.webview.jshandler.y$1$1 */
                public class C04541 implements a.b {
                    public C04541() {
                    }

                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        y.this.jC();
                        if (y.this.f11956ee != null) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            if (aVar.aJh) {
                                return;
                            }
                            y.this.f11956ee.a(aVar);
                        }
                    }
                }

                public AnonymousClass1(com.kwad.sdk.core.webview.d.b.a aVar2) {
                    aVar = aVar2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    String str2;
                    TKAdLiveShopItemInfo tKAdLiveShopItemInfo;
                    com.kwad.sdk.core.webview.b bVar = y.this.YR;
                    if (bVar.aIf) {
                        com.kwad.sdk.core.webview.d.b.a aVar2 = aVar;
                        AdTemplate adTemplate = aVar2.adTemplate;
                        if (adTemplate != null) {
                            y.this.Zh.add(new com.kwad.components.core.e.d.c(adTemplate));
                        } else if (aVar2.creativeId >= 0) {
                            List<AdTemplate> IB = bVar.IB();
                            com.kwad.sdk.core.webview.d.b.a aVar22 = aVar;
                            adTemplate = com.kwad.sdk.core.response.b.e.a(IB, aVar22.creativeId, aVar22.adStyle);
                        } else {
                            adTemplate = bVar.getAdTemplate();
                            aVar.creativeId = com.kwad.sdk.core.response.b.e.el(adTemplate);
                            aVar.adStyle = com.kwad.sdk.core.response.b.e.dW(adTemplate);
                        }
                        com.kwad.components.core.e.d.c K = y.this.K(aVar.creativeId);
                        if (y.this.f11957ze != null && K != null) {
                            K.setOnDismissListener(y.this.f11957ze);
                        }
                        if (TextUtils.isEmpty(aVar.MU)) {
                            str2 = (adTemplate == null || (tKAdLiveShopItemInfo = adTemplate.tkLiveShopItemInfo) == null) ? null : tKAdLiveShopItemInfo.itemId;
                        } else {
                            try {
                                str2 = com.kwad.components.core.e.b.a.t(Long.parseLong(aVar.MU));
                            } catch (Exception unused) {
                                str2 = aVar.MU;
                            }
                        }
                        y.this.L(com.kwad.components.core.e.d.a.a(y.this.a(new a.C0427a(y.this.YR.QI.getContext()).au(adTemplate).b(K).ah(str2).ap(y.a(y.this, aVar)).aq(y.this.Ze).c(y.this.YR.mReportExtData).ao(aVar.aap).am(aVar.aJf).an(aVar.lz).ar(y.this.Zf || aVar.MG).as(y.this.Zd).am(y.this.Zi).at(y.this.Zg).ax(true).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.y.1.1
                            public C04541() {
                            }

                            @Override // com.kwad.components.core.e.d.a.b
                            public final void onAdClicked() {
                                y.this.jC();
                                if (y.this.f11956ee != null) {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    if (aVar.aJh) {
                                        return;
                                    }
                                    y.this.f11956ee.a(aVar);
                                }
                            }
                        }), aVar, adTemplate)));
                    }
                }
            });
        } else if (this.f11956ee != null) {
            bt.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.y.2
                final /* synthetic */ com.kwad.sdk.core.webview.d.b.a Zj;

                public AnonymousClass2(com.kwad.sdk.core.webview.d.b.a aVar2) {
                    aVar = aVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (y.this.f11956ee == null || aVar.aJh) {
                        return;
                    }
                    y.this.f11956ee.a(aVar);
                }
            });
        }
        cVar.a(null);
    }

    public y(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, @Nullable DialogInterface.OnDismissListener onDismissListener) {
        this(bVar, cVar, aVar, false, 0, false, false);
        this.f11957ze = onDismissListener;
    }

    public a.C0427a a(a.C0427a c0427a, com.kwad.sdk.core.webview.d.b.a aVar, AdTemplate adTemplate) {
        com.kwad.sdk.core.webview.d.b.d dVar;
        int i10;
        com.kwad.sdk.core.webview.d.b.d dVar2 = aVar.aaq;
        if (dVar2 != null && !TextUtils.isEmpty(dVar2.MI)) {
            c0427a.ai(aVar.aaq.MI);
        }
        com.kwad.sdk.core.webview.d.b.d dVar3 = aVar.aaq;
        if (dVar3 != null && (i10 = dVar3.aaJ) != 0) {
            c0427a.aq(i10);
        }
        if (com.kwad.sdk.core.response.b.e.eu(adTemplate) && (dVar = aVar.aaq) != null && dVar.aJj != null) {
            ag.a aVar2 = new ag.a();
            com.kwad.sdk.core.webview.d.b.c cVar = aVar.aaq.aJj;
            aVar2.g((float) cVar.f11975x, (float) cVar.f11976y);
            com.kwad.sdk.core.webview.d.b.c cVar2 = aVar.aaq.aJj;
            aVar2.f((float) cVar2.f11975x, (float) cVar2.f11976y);
            com.kwad.sdk.core.webview.d.b.c cVar3 = aVar.aaq.aJj;
            aVar2.z(cVar3.width, cVar3.height);
            c0427a.d(aVar2);
        } else {
            com.kwad.sdk.widget.e eVar = this.YR.aIc;
            if (eVar != null) {
                c0427a.d(eVar.getTouchCoords());
            }
        }
        c0427a.a(null, null, null);
        return c0427a;
    }

    public y(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar) {
        this(bVar, cVar, aVar, false, 0, false, false);
    }

    public y(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, boolean z10) {
        this(bVar, cVar, aVar, false, 0, false, false);
        this.Zg = true;
    }

    public y(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, int i10, boolean z10) {
        this(bVar, cVar, null, false, 2, z10, false);
    }

    public y(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, int i10) {
        this(bVar, cVar, aVar, false, 1, false, false);
    }

    public y(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable List<com.kwad.components.core.e.d.c> list, @Nullable com.kwad.sdk.core.webview.d.a.a aVar) {
        this(bVar, null, aVar, false, 0, false, false);
        if (list != null) {
            this.Zh.addAll(list);
        }
    }
}
