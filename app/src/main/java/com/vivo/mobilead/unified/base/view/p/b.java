package com.vivo.mobilead.unified.base.view.p;

import android.content.Context;
import androidx.annotation.NonNull;
import com.vivo.mobilead.util.m;
import com.vivo.mobilead.util.n;

/* loaded from: classes4.dex */
public class b extends d {

    /* renamed from: j */
    private d f29961j;

    public b(@NonNull Context context) {
        super(context);
    }

    @Override // com.vivo.mobilead.unified.base.view.p.d
    public void a(com.vivo.ad.model.b bVar, int i2) {
        if (this.f29961j != null) {
            removeAllViews();
        }
        d dVar = this.f29961j;
        boolean z = dVar != null ? dVar.f29975h : false;
        if (bVar.T() || bVar.Z() || bVar.U()) {
            this.f29961j = new a(getContext());
        } else {
            this.f29961j = new c(getContext());
        }
        addView(this.f29961j, getDefaultWidth(), getDefaultHeight());
        this.f29961j.setBannerClickListener(this.f29968a);
        this.f29961j.setSourceAppend(this.f29969b);
        d dVar2 = this.f29961j;
        dVar2.f29975h = z;
        dVar2.a(bVar, i2);
    }

    @Override // com.vivo.mobilead.unified.base.view.p.d
    public int getDefaultHeight() {
        return m.a(getContext(), 160.0f);
    }

    @Override // com.vivo.mobilead.unified.base.view.p.d
    public int getDefaultWidth() {
        return Math.min(m.a(getContext(), 360.0f), Math.min(n.f(), n.e()));
    }

    @Override // com.vivo.mobilead.unified.base.view.p.d
    public void setBannerClickListener(com.vivo.mobilead.unified.base.callback.b bVar) {
        this.f29968a = bVar;
        d dVar = this.f29961j;
        if (dVar != null) {
            dVar.setBannerClickListener(bVar);
        }
    }

    @Override // com.vivo.mobilead.unified.base.view.p.d
    public void setSourceAppend(String str) {
        this.f29969b = str;
        d dVar = this.f29961j;
        if (dVar != null) {
            dVar.setSourceAppend(str);
        }
    }
}
