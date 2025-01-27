package com.vivo.mobilead.nativead;

import com.vivo.mobilead.unified.base.callback.MediaListener;
import com.vivo.mobilead.unified.base.view.o;

/* loaded from: classes4.dex */
public class h implements com.vivo.ad.nativead.d {

    /* renamed from: a */
    private o f29641a;

    @Override // com.vivo.ad.nativead.d
    public void a() {
        o oVar = this.f29641a;
        if (oVar != null) {
            oVar.e();
        }
    }

    @Override // com.vivo.ad.nativead.d
    public void b() {
        o oVar = this.f29641a;
        if (oVar != null) {
            oVar.b();
        }
    }

    @Override // com.vivo.ad.nativead.d
    public void c() {
        o oVar = this.f29641a;
        if (oVar != null) {
            oVar.c();
        }
    }

    @Override // com.vivo.ad.nativead.d
    public void a(MediaListener mediaListener) {
        o oVar = this.f29641a;
        if (oVar != null) {
            oVar.setMediaListener(mediaListener);
        }
    }

    public void a(o oVar) {
        this.f29641a = oVar;
    }
}
