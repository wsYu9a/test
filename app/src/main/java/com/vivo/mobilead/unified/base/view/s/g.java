package com.vivo.mobilead.unified.base.view.s;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.util.p;
import com.vivo.mobilead.util.q;

/* loaded from: classes4.dex */
public class g extends o {
    private ImageView L;

    public g(@NonNull Context context) {
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
        TextView a2 = a(2, com.vivo.mobilead.util.d.g(bVar));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, com.vivo.mobilead.util.m.a(getContext(), this.q * 5.0f));
        this.f30040j.addView(a2, layoutParams);
        if (q.a(bVar)) {
            this.f30040j.addView(a(bVar, sourceAppend, new LinearLayout.LayoutParams(-2, -2)));
        }
        if (bVar.T() && bVar.y() != null) {
            this.f30040j.addView(a(bVar.y()), new LinearLayout.LayoutParams(-2, com.vivo.mobilead.util.m.a(getContext(), 16.0f)));
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, com.vivo.mobilead.util.m.b(getContext(), 26.0f));
        layoutParams2.setMargins(0, com.vivo.mobilead.util.m.a(getContext(), this.q * 5.0f), 0, 0);
        this.f30040j.addView(a(bVar, adParams, true), layoutParams2);
        this.t = c();
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(getMaterialContainerWidth(), getMaterialContainerHeight());
        layoutParams3.topMargin = com.vivo.mobilead.util.m.a(getContext(), this.q * 8.0f);
        this.f30040j.addView(this.t, layoutParams3);
        if (com.vivo.mobilead.util.d.e(bVar) == 4) {
            d k = k();
            this.H = k;
            this.t.addView(k, new LinearLayout.LayoutParams(this.H.getLayoutParams()));
            this.H.a(bVar, adParams == null ? "" : adParams.getSourceAppend(), "4");
            this.t.setOnADWidgetClickListener(this.k);
            this.t.setTag(7);
        } else {
            ImageView b2 = b();
            this.L = b2;
            this.t.addView(b2, new LinearLayout.LayoutParams(-1, -1));
            this.t.setOnADWidgetClickListener(this.k);
            this.t.setTag(8);
        }
        View a3 = a(bVar);
        this.C = a3;
        if (a3 != null) {
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(14);
            layoutParams4.addRule(12);
            this.t.addView(this.C);
        }
        if (com.vivo.mobilead.util.d.e(bVar) == 4) {
            d k2 = k();
            this.H = k2;
            this.t.addView(k2, new LinearLayout.LayoutParams(-1, -1));
            this.H.a(bVar, adParams != null ? adParams.getSourceAppend() : "", "4");
        } else {
            ImageView b3 = b();
            this.L = b3;
            this.t.addView(b3, new LinearLayout.LayoutParams(-1, -1));
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
        return new int[]{org.mozilla.universalchardet.prober.g.n, 210};
    }

    class a implements p.b {
        a() {
        }

        @Override // com.vivo.mobilead.util.p.b
        public void a(Bitmap bitmap) {
            if (g.this.t != null) {
                ImageView imageView = new ImageView(g.this.getContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageBitmap(bitmap);
                g.this.t.addView(imageView, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            g.this.a(true);
        }

        @Override // com.vivo.mobilead.util.p.b
        public void a() {
            g.this.a(true);
        }
    }
}
