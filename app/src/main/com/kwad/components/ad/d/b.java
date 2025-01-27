package com.kwad.components.ad.d;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.ad.reward.monitor.c;
import com.kwad.components.core.video.j;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.core.videocache.f;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.u;
import java.io.File;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: com.kwad.components.ad.d.b$1 */
    public class AnonymousClass1 implements AdHttpResponseListener {
        final /* synthetic */ a cZ;

        /* renamed from: ce */
        private boolean f11410ce = false;

        /* renamed from: cf */
        final /* synthetic */ long f11411cf;

        /* renamed from: ch */
        final /* synthetic */ AdVideoPreCacheConfig f11412ch;

        public AnonymousClass1(long j10, a aVar, AdVideoPreCacheConfig adVideoPreCacheConfig) {
            adVideoPreCacheSize = j10;
            aVar = aVar;
            adVideoPreCacheConfig = adVideoPreCacheConfig;
        }

        @Override // com.kwad.sdk.export.proxy.AdHttpResponseListener
        public final boolean onReadProgress(long j10, long j11) {
            if ((j10 >= adVideoPreCacheSize || j10 >= j11) && !this.f11410ce) {
                this.f11410ce = true;
                b.a(aVar);
                if (!adVideoPreCacheConfig.isContinueLoadingAll()) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.kwad.sdk.export.proxy.AdHttpResponseListener
        public final void onResponseEnd() {
        }

        @Override // com.kwad.sdk.export.proxy.AdHttpResponseListener
        public final void onResponseStart() {
        }
    }

    @WorkerThread
    public static boolean a(@NonNull AdTemplate adTemplate, boolean z10, AdVideoPreCacheConfig adVideoPreCacheConfig, a aVar) {
        String str;
        String K = com.kwad.sdk.core.response.b.a.K(e.eb(adTemplate));
        if (TextUtils.isEmpty(K)) {
            return false;
        }
        long adVideoPreCacheSize = adVideoPreCacheConfig.getAdVideoPreCacheSize() * 1024;
        boolean z11 = true;
        if (adVideoPreCacheSize > 0) {
            long j10 = adVideoPreCacheConfig.isContinueLoadingAll() ? -1L : adVideoPreCacheSize;
            a.C0497a c0497a = new a.C0497a();
            f bC = com.kwad.sdk.core.videocache.c.a.bC(ServiceProvider.getContext());
            if (bC.eN(K)) {
                a(aVar);
            } else {
                z11 = bC.a(K, j10, c0497a, new AdHttpResponseListener() { // from class: com.kwad.components.ad.d.b.1
                    final /* synthetic */ a cZ;

                    /* renamed from: ce */
                    private boolean f11410ce = false;

                    /* renamed from: cf */
                    final /* synthetic */ long f11411cf;

                    /* renamed from: ch */
                    final /* synthetic */ AdVideoPreCacheConfig f11412ch;

                    public AnonymousClass1(long adVideoPreCacheSize2, a aVar2, AdVideoPreCacheConfig adVideoPreCacheConfig2) {
                        adVideoPreCacheSize = adVideoPreCacheSize2;
                        aVar = aVar2;
                        adVideoPreCacheConfig = adVideoPreCacheConfig2;
                    }

                    @Override // com.kwad.sdk.export.proxy.AdHttpResponseListener
                    public final boolean onReadProgress(long j102, long j11) {
                        if ((j102 >= adVideoPreCacheSize || j102 >= j11) && !this.f11410ce) {
                            this.f11410ce = true;
                            b.a(aVar);
                            if (!adVideoPreCacheConfig.isContinueLoadingAll()) {
                                return true;
                            }
                        }
                        return false;
                    }

                    @Override // com.kwad.sdk.export.proxy.AdHttpResponseListener
                    public final void onResponseEnd() {
                    }

                    @Override // com.kwad.sdk.export.proxy.AdHttpResponseListener
                    public final void onResponseStart() {
                    }
                });
            }
            str = c0497a.msg;
        } else {
            str = "";
            if (adVideoPreCacheSize2 < 0) {
                File ca2 = com.kwad.sdk.core.diskcache.b.a.EG().ca(K);
                if (!u.M(ca2)) {
                    a.C0497a c0497a2 = new a.C0497a();
                    z11 = com.kwad.sdk.core.diskcache.b.a.EG().a(K, c0497a2);
                    str = c0497a2.msg;
                }
                adTemplate.setDownloadSize(ca2 != null ? ca2.length() : 0L);
                if (z11) {
                    a(aVar2);
                }
            } else {
                a(aVar2);
            }
        }
        if (z11) {
            j.m(K, adVideoPreCacheConfig2.getAdVideoPreCacheSize());
        } else {
            c.a(z10, adTemplate, str);
            com.kwad.components.ad.reward.monitor.b.a(z10, adTemplate);
            a(aVar2, str);
        }
        return z11;
    }

    public static void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.ae();
    }

    private static void a(a aVar, String str) {
        if (aVar == null) {
            return;
        }
        aVar.af();
    }
}
