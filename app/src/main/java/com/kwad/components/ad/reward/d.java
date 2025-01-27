package com.kwad.components.ad.reward;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class d extends com.kwad.components.ad.m.b {
    private List<AdTemplate> pW;
    private boolean pX;
    private List<com.kwad.components.core.e.d.c> pY;
    private x.b pZ;

    /* renamed from: com.kwad.components.ad.reward.d$1 */
    public class AnonymousClass1 implements View.OnTouchListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return motionEvent.getAction() == 2;
        }
    }

    public d(List<AdTemplate> list, @Nullable JSONObject jSONObject, x.b bVar) {
        super(jSONObject, null);
        this.pX = false;
        this.pY = new ArrayList();
        this.pW = list;
        this.pZ = bVar;
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<AdTemplate> it = this.pW.iterator();
        while (it.hasNext()) {
            this.pY.add(new com.kwad.components.core.e.d.c(it.next()));
        }
    }

    @Override // com.kwad.components.ad.m.b
    public final String F(AdTemplate adTemplate) {
        List<AdTemplate> list = this.pW;
        return (list == null || list.size() < 2) ? super.F(adTemplate) : com.kwad.sdk.core.response.b.b.cw(this.pW.get(1));
    }

    @Override // com.kwad.components.ad.m.b
    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, com.kwad.components.core.e.d.c cVar, int i10) {
        super.a(frameLayout, adBaseFrameLayout, this.pW, this.pY);
    }

    @Override // com.kwad.components.ad.m.b
    public final void b(com.kwad.sdk.core.webview.b bVar) {
        bVar.setAdTemplateList(this.pW);
    }

    @Override // com.kwad.components.ad.m.b
    public final boolean bW() {
        return this.pX ? this.JL : super.bW();
    }

    @Override // com.kwad.components.ad.m.b
    @SuppressLint({"ClickableViewAccessibility"})
    public final void fD() {
        super.fD();
        this.dY.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.ad.reward.d.1
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return motionEvent.getAction() == 2;
            }
        });
    }

    @Override // com.kwad.components.ad.m.b
    public final boolean fE() {
        return false;
    }

    public final void fF() {
        ay ayVar = this.f11649ed;
        if (ayVar != null) {
            ayVar.tv();
        }
    }

    @Override // com.kwad.components.ad.m.b
    public final void fG() {
        com.kwad.components.ad.reward.monitor.c.a(true, "middle_play_end_card");
    }

    @Override // com.kwad.components.ad.m.b
    public final void fH() {
        AdTemplate adTemplate = this.mAdTemplate;
        com.kwad.components.ad.reward.monitor.c.a(adTemplate, true, "middle_play_end_card", F(adTemplate));
    }

    @Override // com.kwad.components.ad.m.b
    public final void fI() {
        com.kwad.components.ad.reward.monitor.c.a(true, "middle_play_end_card", F(this.mAdTemplate), System.currentTimeMillis() - getLoadTime());
    }

    @Override // com.kwad.components.ad.m.b
    public final String getName() {
        return "MiddlePlayEndCard";
    }

    public final void setShowLandingPage(boolean z10) {
        this.pX = z10;
    }

    @Override // com.kwad.components.ad.m.b
    public final void a(com.kwad.components.core.webview.a aVar) {
        super.a(aVar);
        List<AdTemplate> list = this.pW;
        x xVar = new x(new ArrayList(list.subList(1, list.size() - 1)));
        xVar.a(this.pZ);
        aVar.a(xVar);
    }
}
