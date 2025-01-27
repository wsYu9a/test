package com.opos.mobad.q.a.f.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.cmn.a.b.g;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import java.util.List;

/* loaded from: classes4.dex */
public class c extends a {

    /* renamed from: j */
    private ImageView f23331j;
    private Bitmap k;

    public c(Context context, com.opos.mobad.q.a.c.a aVar) {
        super(context, aVar);
        this.k = null;
    }

    private void b() {
        ImageView imageView = new ImageView(this.f20278a);
        this.f23331j = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f23324i.addView(this.f23331j, new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f20278a, 360.0f), com.opos.cmn.an.h.f.a.a(this.f20278a, 85.0f)));
    }

    public void a(AdItemData adItemData, boolean z) {
        MaterialData materialData;
        if (adItemData == null || (materialData = adItemData.i().get(0)) == null) {
            return;
        }
        a(this.f23331j, adItemData, com.opos.mobad.cmn.a.b.a.NonClickBt);
        List<MaterialFileData> f2 = materialData.f();
        if (f2 == null || f2.size() <= 0 || f2.get(0) == null) {
            return;
        }
        Bitmap a2 = g.a(f2.get(0).a(), com.opos.cmn.an.h.f.a.a(this.f20278a, 360.0f), com.opos.cmn.an.h.f.a.a(this.f20278a, 85.0f));
        this.k = a2;
        if (a2 != null) {
            this.f23331j.setImageBitmap(a2);
        }
    }

    public void d(AdItemData adItemData) {
        a(adItemData, false);
    }

    @Override // com.opos.mobad.cmn.a.c
    public void g() {
        b();
    }

    @Override // com.opos.mobad.cmn.a.c
    public void h() {
        try {
            TextView textView = this.f20279b;
            if (textView != null) {
                this.f23324i.removeView(textView);
            }
            Bitmap bitmap = this.k;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.k.recycle();
                this.k = null;
                com.opos.cmn.an.f.a.b("ImgTipBar", "mImgBitmap.recycle()");
            }
            a(this.f23331j);
        } catch (Exception unused) {
            com.opos.cmn.an.f.a.b("ImgTipBar", "");
        }
    }

    @Override // com.opos.mobad.cmn.a.c
    public void i() {
    }
}
