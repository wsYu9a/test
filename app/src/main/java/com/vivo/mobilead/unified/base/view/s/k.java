package com.vivo.mobilead.unified.base.view.s;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.vivo.ad.view.s;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.util.p;
import com.vivo.mobilead.util.q;
import java.util.List;

/* loaded from: classes4.dex */
public class k extends o {
    private ImageView[] L;
    private boolean M;
    private int N;
    private ImageView O;

    public k(@NonNull Context context) {
        this(context, null);
    }

    @Override // com.vivo.mobilead.unified.base.view.s.o, com.vivo.mobilead.unified.base.callback.c
    public void a(String str, Bitmap bitmap) {
        if (com.vivo.mobilead.util.d.e(this.v) != 1) {
            if (bitmap == null || bitmap.isRecycled()) {
                a(false);
                return;
            }
            ImageView imageView = this.O;
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
            }
            p.a(p.a(bitmap, getMaterialContainerWidth() / 3, getMaterialContainerHeight() / 3), 3.0f, 50, new a());
            return;
        }
        if (this.M) {
            return;
        }
        if (bitmap == null || TextUtils.isEmpty(str)) {
            this.M = true;
            a(false);
        } else {
            int i2 = this.N;
            ImageView[] imageViewArr = this.L;
            if (i2 < imageViewArr.length) {
                imageViewArr[i2].setImageBitmap(bitmap);
                this.N++;
            }
        }
        if (this.N == this.L.length) {
            a(true);
        }
    }

    @Override // com.vivo.mobilead.unified.base.view.s.o, com.vivo.mobilead.unified.base.view.s.a
    protected void c(com.vivo.ad.model.b bVar, AdParams adParams) {
        String sourceAppend = adParams == null ? "" : adParams.getSourceAppend();
        TextView a2 = a(2, com.vivo.mobilead.util.d.g(bVar));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, com.vivo.mobilead.util.m.a(getContext(), this.q * 10.0f));
        this.f30040j.addView(a2, layoutParams);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        this.f30040j.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        if (com.vivo.mobilead.util.d.e(bVar) == 1) {
            List<String> b2 = bVar.f().b();
            for (int i2 = 0; i2 < 3; i2++) {
                s d2 = d();
                this.L[i2] = d2;
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getMaterialContainerHeight(), getMaterialContainerHeight(), 1.0f);
                if (i2 > 0) {
                    layoutParams2.setMargins(com.vivo.mobilead.util.m.a(getContext(), this.q * 3.0f), 0, 0, 0);
                }
                linearLayout.addView(d2, layoutParams2);
                a(b2.get(i2));
            }
        } else {
            this.p = 0;
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(getMaterialContainerHeight(), getMaterialContainerHeight(), 1.0f);
            s d3 = d();
            d3.setImageDrawable(com.vivo.mobilead.util.g.b(getContext(), "vivo_module_express_placeholder_left.png"));
            d3.setScaleType(ImageView.ScaleType.FIT_XY);
            linearLayout.addView(d3, layoutParams3);
            this.t = c();
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getMaterialContainerHeight(), getMaterialContainerHeight(), 1.0f);
            layoutParams4.setMargins(com.vivo.mobilead.util.m.a(getContext(), this.q * 3.0f), 0, 0, 0);
            linearLayout.addView(this.t, layoutParams4);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(getMaterialContainerHeight(), getMaterialContainerHeight(), 1.0f);
            layoutParams5.setMargins(com.vivo.mobilead.util.m.a(getContext(), this.q * 3.0f), 0, 0, 0);
            s d4 = d();
            d4.setImageDrawable(com.vivo.mobilead.util.g.b(getContext(), "vivo_module_express_placeholder_right.png"));
            d4.setScaleType(ImageView.ScaleType.FIT_XY);
            linearLayout.addView(d4, layoutParams5);
            if (com.vivo.mobilead.util.d.e(bVar) == 4) {
                d k = k();
                this.H = k;
                this.t.addView(k, new LinearLayout.LayoutParams(this.H.getLayoutParams()));
                this.H.a(bVar, adParams != null ? adParams.getSourceAppend() : "", "4");
                this.t.setOnADWidgetClickListener(this.k);
                this.t.setTag(7);
            } else {
                ImageView b3 = b();
                this.O = b3;
                this.t.addView(b3, new LinearLayout.LayoutParams(-1, -1));
                this.t.setOnADWidgetClickListener(this.k);
                this.t.setTag(8);
            }
            a(com.vivo.mobilead.util.d.f(bVar));
        }
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, com.vivo.mobilead.util.m.b(getContext(), 26.0f));
        layoutParams6.setMargins(0, com.vivo.mobilead.util.m.a(getContext(), this.q * 8.0f), 0, 0);
        this.f30040j.addView(a(bVar, adParams, true), layoutParams6);
        if (q.a(bVar)) {
            LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams7.topMargin = com.vivo.mobilead.util.m.a(getContext(), this.q * 5.0f);
            this.f30040j.addView(a(bVar, sourceAppend, layoutParams7));
        }
        if (!bVar.T() || bVar.y() == null) {
            return;
        }
        this.f30040j.addView(a(bVar.y()), new LinearLayout.LayoutParams(-2, com.vivo.mobilead.util.m.a(getContext(), 16.0f)));
    }

    @Override // com.vivo.mobilead.unified.base.view.s.a
    protected int getMaterialContainerHeight() {
        return com.vivo.mobilead.util.m.a(getContext(), this.q * 82.0f);
    }

    @Override // com.vivo.mobilead.unified.base.view.s.a
    protected int getMaterialContainerWidth() {
        return com.vivo.mobilead.util.m.a(getContext(), this.q * 109.33f);
    }

    @Override // com.vivo.mobilead.unified.base.view.s.o, com.vivo.mobilead.unified.base.view.s.a
    protected int[] getMinSize() {
        return new int[]{org.mozilla.universalchardet.prober.g.n, 125};
    }

    @Override // com.vivo.mobilead.unified.base.view.s.o, com.vivo.mobilead.unified.base.view.s.a
    public void j() {
    }

    public k(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public k(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.L = new ImageView[3];
        this.M = false;
        this.N = 0;
    }

    class a implements p.b {
        a() {
        }

        @Override // com.vivo.mobilead.util.p.b
        public void a(Bitmap bitmap) {
            if (k.this.t != null) {
                ImageView imageView = new ImageView(k.this.getContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageBitmap(bitmap);
                k.this.t.addView(imageView, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            k.this.a(true);
        }

        @Override // com.vivo.mobilead.util.p.b
        public void a() {
            k.this.a(true);
        }
    }
}
