package com.kwad.components.ad.interstitial.aggregate;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.kwad.components.ad.interstitial.f.c;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdResultData;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class a extends PagerAdapter {
    private final KsAdVideoPlayConfig bS;
    private final boolean jA;
    private b jB;
    private InterfaceC0377a jC;
    private final KsInterstitialAd.AdInteractionListener jr;
    private final List<AdResultData> jy = new ArrayList();
    private final com.kwad.components.ad.interstitial.d jz;

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.a$1 */
    public class AnonymousClass1 implements c.a {
        final /* synthetic */ int jD;

        public AnonymousClass1(int i10) {
            i10 = i10;
        }

        @Override // com.kwad.components.ad.interstitial.f.c.a
        public final void b(long j10, long j11) {
            AdResultData adResultData = (AdResultData) a.this.jy.get(i10);
            if (adResultData == null) {
                return;
            }
            com.kwad.components.ad.interstitial.report.a.ei().b(com.kwad.sdk.core.response.b.c.o(adResultData), j10, j11);
            if (a.this.jC != null) {
                a.this.jC.cL();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.a$a */
    public interface InterfaceC0377a {
        void cL();
    }

    public interface b {
        void a(com.kwad.components.ad.interstitial.h.c cVar, int i10);
    }

    public a(AdResultData adResultData, com.kwad.components.ad.interstitial.d dVar, KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.jz = dVar;
        this.bS = ksAdVideoPlayConfig;
        this.jr = adInteractionListener;
        this.jA = com.kwad.sdk.core.response.b.a.cz(e.eb(com.kwad.sdk.core.response.b.c.o(adResultData))) == 1;
    }

    public final void d(List<AdResultData> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.jy.clear();
        this.jy.addAll(list);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(@NonNull ViewGroup viewGroup, int i10, Object obj) {
        if (obj instanceof View) {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.jy.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public final Object instantiateItem(@NonNull ViewGroup viewGroup, int i10) {
        com.kwad.components.ad.interstitial.h.c cVar = new com.kwad.components.ad.interstitial.h.c(viewGroup.getContext());
        viewGroup.addView(cVar);
        cVar.setAggregateAdView(i10 > 0);
        if (i10 == 0) {
            cVar.setAdConvertListener(new c.a() { // from class: com.kwad.components.ad.interstitial.aggregate.a.1
                final /* synthetic */ int jD;

                public AnonymousClass1(int i102) {
                    i10 = i102;
                }

                @Override // com.kwad.components.ad.interstitial.f.c.a
                public final void b(long j10, long j11) {
                    AdResultData adResultData = (AdResultData) a.this.jy.get(i10);
                    if (adResultData == null) {
                        return;
                    }
                    com.kwad.components.ad.interstitial.report.a.ei().b(com.kwad.sdk.core.response.b.c.o(adResultData), j10, j11);
                    if (a.this.jC != null) {
                        a.this.jC.cL();
                    }
                }
            });
        }
        if (i102 > 0) {
            if (i102 == 1) {
                cVar.setAggregateShowTriggerType(this.jA ? 8 : 7);
            } else {
                cVar.setAggregateShowTriggerType(7);
            }
        }
        cVar.a(this.jy.get(i102), this.jz, this.bS, this.jr);
        b bVar = this.jB;
        if (bVar != null) {
            bVar.a(cVar, i102);
        }
        return cVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    public final void a(b bVar) {
        this.jB = bVar;
    }

    public final void a(InterfaceC0377a interfaceC0377a) {
        this.jC = interfaceC0377a;
    }
}
