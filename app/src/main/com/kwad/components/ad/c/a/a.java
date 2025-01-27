package com.kwad.components.ad.c.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
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
public final class a {

    /* renamed from: com.kwad.components.ad.c.a.a$1 */
    public class AnonymousClass1 implements AdHttpResponseListener {

        /* renamed from: ce */
        private boolean f11396ce = false;

        /* renamed from: cf */
        final /* synthetic */ long f11397cf;

        /* renamed from: cg */
        final /* synthetic */ b f11398cg;

        /* renamed from: ch */
        final /* synthetic */ AdVideoPreCacheConfig f11399ch;

        public AnonymousClass1(long j10, b bVar, AdVideoPreCacheConfig adVideoPreCacheConfig) {
            adVideoPreCacheSize = j10;
            bVar = bVar;
            adVideoPreCacheConfig = adVideoPreCacheConfig;
        }

        @Override // com.kwad.sdk.export.proxy.AdHttpResponseListener
        public final boolean onReadProgress(long j10, long j11) {
            if ((j10 >= adVideoPreCacheSize || j10 >= j11) && !this.f11396ce) {
                this.f11396ce = true;
                a.a(bVar);
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
    public static boolean a(@NonNull AdTemplate adTemplate, AdVideoPreCacheConfig adVideoPreCacheConfig, b bVar) {
        String str;
        String K = com.kwad.sdk.core.response.b.a.K(e.eb(adTemplate));
        if (TextUtils.isEmpty(K)) {
            a(bVar, "字段为null");
            return false;
        }
        long adVideoPreCacheSize = adVideoPreCacheConfig.getAdVideoPreCacheSize() * 1024;
        boolean z10 = true;
        if (adVideoPreCacheSize > 0) {
            long j10 = adVideoPreCacheConfig.isContinueLoadingAll() ? -1L : adVideoPreCacheSize;
            a.C0497a c0497a = new a.C0497a();
            f bC = com.kwad.sdk.core.videocache.c.a.bC(ServiceProvider.getContext());
            if (bC.eN(K)) {
                a(bVar);
            } else {
                z10 = bC.a(K, j10, c0497a, new AdHttpResponseListener() { // from class: com.kwad.components.ad.c.a.a.1

                    /* renamed from: ce */
                    private boolean f11396ce = false;

                    /* renamed from: cf */
                    final /* synthetic */ long f11397cf;

                    /* renamed from: cg */
                    final /* synthetic */ b f11398cg;

                    /* renamed from: ch */
                    final /* synthetic */ AdVideoPreCacheConfig f11399ch;

                    public AnonymousClass1(long adVideoPreCacheSize2, b bVar2, AdVideoPreCacheConfig adVideoPreCacheConfig2) {
                        adVideoPreCacheSize = adVideoPreCacheSize2;
                        bVar = bVar2;
                        adVideoPreCacheConfig = adVideoPreCacheConfig2;
                    }

                    @Override // com.kwad.sdk.export.proxy.AdHttpResponseListener
                    public final boolean onReadProgress(long j102, long j11) {
                        if ((j102 >= adVideoPreCacheSize || j102 >= j11) && !this.f11396ce) {
                            this.f11396ce = true;
                            a.a(bVar);
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
            String str2 = "";
            if (adVideoPreCacheSize2 < 0) {
                File ca2 = com.kwad.sdk.core.diskcache.b.a.EG().ca(K);
                if (!u.M(ca2)) {
                    a.C0497a c0497a2 = new a.C0497a();
                    z10 = com.kwad.sdk.core.diskcache.b.a.EG().a(K, c0497a2);
                    str2 = c0497a2.msg;
                }
                adTemplate.setDownloadSize(ca2 != null ? ca2.length() : 0L);
                if (z10) {
                    a(bVar2);
                }
            } else {
                a(bVar2);
            }
            str = str2;
        }
        if (z10) {
            j.m(K, adVideoPreCacheConfig2.getAdVideoPreCacheSize());
        } else {
            a(bVar2, str);
        }
        return z10;
    }

    public static void a(b bVar) {
        if (bVar == null) {
            return;
        }
        bVar.ae();
    }

    private static void a(b bVar, String str) {
        if (bVar == null) {
            return;
        }
        bVar.af();
    }
}
