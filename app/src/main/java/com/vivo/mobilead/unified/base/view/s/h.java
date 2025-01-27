package com.vivo.mobilead.unified.base.view.s;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.util.p;
import com.vivo.mobilead.util.q;

/* loaded from: classes4.dex */
public class h extends o {
    private ImageView L;

    public h(@NonNull Context context) {
        super(context);
    }

    @Override // com.vivo.mobilead.unified.base.view.s.o, com.vivo.mobilead.unified.base.callback.c
    public void a(String str, Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            a(false);
            return;
        }
        ImageView imageView = this.L;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
        p.a(p.a(bitmap, getMaterialContainerWidth() / 3, getMaterialContainerHeight() / 3), 3.0f, 50, new a());
    }

    @Override // com.vivo.mobilead.unified.base.view.s.o, com.vivo.mobilead.unified.base.view.s.a
    protected void c(com.vivo.ad.model.b bVar, AdParams adParams) {
        String sourceAppend = adParams == null ? "" : adParams.getSourceAppend();
        com.vivo.mobilead.unified.interstitial.m.a c2 = c();
        this.t = c2;
        this.f30040j.addView(c2, new LinearLayout.LayoutParams(getMaterialContainerWidth(), getMaterialContainerHeight()));
        if (com.vivo.mobilead.util.d.e(bVar) == 4) {
            d k = k();
            this.H = k;
            this.t.addView(k, new LinearLayout.LayoutParams(this.H.getLayoutParams()));
            this.H.a(bVar, adParams != null ? adParams.getSourceAppend() : "", "4");
            this.t.setOnADWidgetClickListener(this.k);
            this.t.setTag(7);
        } else {
            ImageView b2 = b();
            this.L = b2;
            this.t.addView(b2, new LinearLayout.LayoutParams(-1, -1));
            this.t.setOnADWidgetClickListener(this.k);
            this.t.setTag(8);
        }
        View a2 = a(bVar);
        this.C = a2;
        if (a2 != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            this.t.addView(this.C);
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, com.vivo.mobilead.util.m.b(getContext(), 26.0f));
        layoutParams2.setMargins(0, com.vivo.mobilead.util.m.a(getContext(), this.q * 8.0f), 0, 0);
        this.f30040j.addView(a(bVar, adParams, true), layoutParams2);
        if (q.a(bVar)) {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.topMargin = com.vivo.mobilead.util.m.a(getContext(), this.q * 5.0f);
            this.f30040j.addView(a(bVar, sourceAppend, layoutParams3));
        }
        if (bVar.T() && bVar.y() != null) {
            this.f30040j.addView(a(bVar.y()), new LinearLayout.LayoutParams(-2, com.vivo.mobilead.util.m.a(getContext(), 16.0f)));
        }
        a(com.vivo.mobilead.util.d.f(bVar));
    }

    @Override // com.vivo.mobilead.unified.base.view.s.a
    protected int getMaterialContainerHeight() {
        return com.vivo.mobilead.util.m.a(getContext(), this.q * 187.5f);
    }

    @Override // com.vivo.mobilead.unified.base.view.s.a
    protected int getMaterialContainerWidth() {
        return com.vivo.mobilead.util.m.a(getContext(), this.q * 333.33f);
    }

    @Override // com.vivo.mobilead.unified.base.view.s.o, com.vivo.mobilead.unified.base.view.s.a
    protected int[] getMinSize() {
        return new int[]{org.mozilla.universalchardet.prober.g.n, 173};
    }

    class a implements p.b {
        a() {
        }

        @Override // com.vivo.mobilead.util.p.b
        public void a(Bitmap bitmap) {
            if (h.this.t != null) {
                ImageView imageView = new ImageView(h.this.getContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageBitmap(bitmap);
                h.this.t.addView(imageView, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            h.this.a(true);
        }

        @Override // com.vivo.mobilead.util.p.b
        public void a() {
            h.this.a(true);
        }
    }
}
