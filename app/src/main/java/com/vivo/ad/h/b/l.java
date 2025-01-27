package com.vivo.ad.h.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.vivo.ad.model.a0;
import com.vivo.ad.view.p;
import com.vivo.mobilead.util.q;
import java.io.File;

/* loaded from: classes4.dex */
public class l extends RelativeLayout {

    /* renamed from: a */
    private LinearLayout f26789a;

    /* renamed from: b */
    private com.vivo.ad.view.j f26790b;

    /* renamed from: c */
    private LinearLayout f26791c;

    /* renamed from: d */
    private TextView f26792d;

    /* renamed from: e */
    private TextView f26793e;

    /* renamed from: f */
    private com.vivo.mobilead.unified.base.view.a f26794f;

    /* renamed from: g */
    private com.vivo.ad.view.c f26795g;

    /* renamed from: h */
    private TextView f26796h;

    /* renamed from: i */
    private TextView f26797i;

    /* renamed from: j */
    private TextView f26798j;
    private TextView k;
    private com.vivo.ad.view.i l;
    private com.vivo.ad.view.o m;
    private com.vivo.ad.view.i n;
    private LinearLayout.LayoutParams o;
    private int p;
    private int q;
    private boolean r;

    class b extends com.vivo.mobilead.util.b1.a.c.b {

        /* renamed from: a */
        final /* synthetic */ int f26801a;

        b(int i2) {
            this.f26801a = i2;
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(String str, byte[] bArr, File file) {
            super.a(str, bArr, file);
            l.this.setIconGifRoundWithOverlayColor(this.f26801a);
            l.this.a(bArr, file);
        }
    }

    class c implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ com.vivo.mobilead.unified.base.callback.i f26803a;

        c(com.vivo.mobilead.unified.base.callback.i iVar) {
            this.f26803a = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.vivo.mobilead.unified.base.callback.i iVar = this.f26803a;
            if (iVar != null) {
                iVar.a(view, l.this.p, l.this.q);
            }
        }
    }

    class d implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ com.vivo.mobilead.unified.base.callback.i f26805a;

        d(com.vivo.mobilead.unified.base.callback.i iVar) {
            this.f26805a = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.vivo.mobilead.unified.base.callback.i iVar = this.f26805a;
            if (iVar != null) {
                iVar.a(view, l.this.p, l.this.q);
            }
        }
    }

    class e implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ com.vivo.mobilead.unified.base.callback.i f26807a;

        e(com.vivo.mobilead.unified.base.callback.i iVar) {
            this.f26807a = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.vivo.mobilead.unified.base.callback.i iVar = this.f26807a;
            if (iVar != null) {
                iVar.a(view, l.this.p, l.this.q);
            }
        }
    }

    public l(Context context, boolean z) {
        super(context);
        this.r = z;
        a(context);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.p = (int) motionEvent.getX();
            this.q = (int) motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setBgClick(com.vivo.mobilead.unified.base.callback.i iVar) {
        this.f26791c.setOnClickListener(new c(iVar));
        this.f26790b.setOnClickListener(new d(iVar));
        setOnClickListener(new e(iVar));
    }

    public void setBtnClick(com.vivo.ad.view.k kVar) {
        this.f26794f.setOnAWClickListener(kVar);
    }

    public void setBtnText(String str) {
        this.f26794f.setText(str);
    }

    public void setDesc(String str) {
        this.f26793e.setText(str);
    }

    public void setFiveElementClickListener(com.vivo.ad.view.k kVar) {
        this.l.setOnADWidgetClickListener(kVar);
    }

    public void setIcon(Bitmap bitmap) {
        this.f26790b.setImageBitmap(bitmap);
    }

    public void setIconGifRoundWithOverlayColor(int i2) {
        this.f26790b.setGifRoundWithOverlayColor(i2);
    }

    public void setTitle(String str) {
        this.f26792d.setText(str);
    }

    class a extends com.vivo.mobilead.util.b1.a.c.b {

        /* renamed from: a */
        final /* synthetic */ int f26799a;

        a(int i2) {
            this.f26799a = i2;
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(String str, Bitmap bitmap) {
            l lVar = l.this;
            if (lVar.b(lVar.getContext())) {
                return;
            }
            l.this.setIcon(bitmap);
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(String str, byte[] bArr, File file) {
            super.a(str, bArr, file);
            l.this.setIconGifRoundWithOverlayColor(this.f26799a);
            l.this.a(bArr, file);
        }
    }

    public boolean b(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).isFinishing();
        }
        return false;
    }

    public void a(com.vivo.ad.model.b bVar, boolean z, int i2) {
        this.r = z;
        bVar.j();
        a0 Q = bVar.Q();
        if (Q == null) {
            return;
        }
        String e2 = Q.e();
        String a2 = Q.a();
        String b2 = com.vivo.mobilead.util.f.b(bVar);
        if (bVar.s()) {
            com.vivo.mobilead.util.b1.a.b.b().a(b2, new a(i2));
        } else if (!TextUtils.isEmpty(b2) && b2.endsWith(".gif")) {
            com.vivo.mobilead.util.b1.a.b.b().a(b2, new b(i2));
        } else {
            setIcon(com.vivo.mobilead.h.b.a().a(b2));
        }
        setTitle(e2);
        setDesc(a2);
        this.f26794f.setText(bVar);
        this.f26795g.a(com.vivo.mobilead.h.b.a().a(bVar.e()), bVar.k(), bVar.O());
    }

    public void b() {
        com.vivo.mobilead.unified.base.view.a aVar = this.f26794f;
        if (aVar != null) {
            aVar.c();
        }
    }

    public void a() {
        com.vivo.ad.view.c cVar = this.f26795g;
        if (cVar != null) {
            cVar.setVisibility(8);
        }
    }

    private void a(Context context) {
        setBackgroundColor(-1);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f26789a = linearLayout;
        linearLayout.setGravity(16);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        this.f26789a.setOrientation(0);
        this.f26789a.setPadding(com.vivo.mobilead.util.m.a(context, 17.0f), com.vivo.mobilead.util.m.a(context, 14.0f), com.vivo.mobilead.util.m.a(context, 23.0f), com.vivo.mobilead.util.m.a(context, 14.0f));
        this.f26790b = new com.vivo.ad.view.j(context, com.vivo.mobilead.util.m.a(context, 16.0f));
        this.f26790b.setLayoutParams(new LinearLayout.LayoutParams(com.vivo.mobilead.util.m.a(context, 40.0f), com.vivo.mobilead.util.m.a(context, 40.0f)));
        com.vivo.ad.view.i iVar = new com.vivo.ad.view.i(context);
        this.f26791c = iVar;
        iVar.setOrientation(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.o = layoutParams2;
        layoutParams2.leftMargin = com.vivo.mobilead.util.m.a(context, 12.0f);
        this.o.rightMargin = com.vivo.mobilead.util.m.a(context, 14.0f);
        LinearLayout.LayoutParams layoutParams3 = this.o;
        layoutParams3.weight = 1.0f;
        this.f26791c.setLayoutParams(layoutParams3);
        TextView textView = new TextView(context);
        this.f26792d = textView;
        textView.setTextSize(1, 17.0f);
        this.f26792d.setTextColor(Color.parseColor("#252525"));
        this.f26792d.setTypeface(Typeface.create("sans-serif-medium", 0));
        this.f26792d.setEllipsize(TextUtils.TruncateAt.END);
        this.f26792d.setMaxLines(1);
        TextView textView2 = new TextView(context);
        this.f26793e = textView2;
        textView2.setTextSize(1, 12.0f);
        this.f26793e.setMaxLines(1);
        this.f26793e.setTextColor(Color.parseColor("#f2666666"));
        this.f26793e.setEllipsize(TextUtils.TruncateAt.END);
        TextView textView3 = this.f26793e;
        textView3.setPadding(textView3.getPaddingLeft(), com.vivo.mobilead.util.m.a(context, 2.0f), this.f26793e.getPaddingRight(), this.f26793e.getPaddingBottom());
        this.f26791c.addView(this.f26792d);
        this.f26791c.addView(this.f26793e);
        a(this.f26791c);
        com.vivo.mobilead.unified.base.view.a aVar = new com.vivo.mobilead.unified.base.view.a(context);
        this.f26794f = aVar;
        aVar.e();
        com.vivo.ad.view.c cVar = new com.vivo.ad.view.c(getContext());
        this.f26795g = cVar;
        cVar.a(Color.parseColor("#26000000"), new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
        this.f26795g.a(10, -1);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(10);
        layoutParams4.addRule(9);
        this.f26789a.addView(this.f26790b);
        this.f26789a.addView(this.f26791c);
        this.f26789a.addView(this.f26794f);
        addView(this.f26789a, layoutParams);
        addView(this.f26795g, layoutParams4);
    }

    public void a(byte[] bArr, File file) {
        this.f26790b.a(bArr, file);
    }

    private void a(ViewGroup viewGroup) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        com.vivo.ad.view.i iVar = new com.vivo.ad.view.i(getContext());
        this.l = iVar;
        iVar.setOrientation(1);
        this.f26798j = new TextView(getContext());
        this.k = new TextView(getContext());
        this.f26798j.setTextSize(1, 13.0f);
        this.f26798j.setTextColor(Color.parseColor("#000000"));
        this.f26798j.setSingleLine();
        this.f26798j.setEllipsize(TextUtils.TruncateAt.END);
        this.f26798j.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.k.setTextSize(1, 11.0f);
        this.k.setSingleLine();
        this.k.setEllipsize(TextUtils.TruncateAt.END);
        this.k.setTextColor(Color.parseColor("#999999"));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.rightMargin = com.vivo.mobilead.util.m.b(getContext(), 8.0f);
        this.k.setLayoutParams(layoutParams2);
        TextView textView = new TextView(getContext());
        this.f26796h = textView;
        textView.setTextSize(1, 11.0f);
        this.f26796h.setTextColor(Color.parseColor("#999999"));
        this.f26796h.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        TextView textView2 = new TextView(getContext());
        this.f26797i = textView2;
        textView2.setTextSize(1, 11.0f);
        this.f26797i.setEllipsize(TextUtils.TruncateAt.END);
        this.f26797i.setSingleLine();
        this.f26797i.setTextColor(Color.parseColor("#999999"));
        this.f26797i.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.m = new com.vivo.ad.view.o(getContext());
        this.m.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.n = new com.vivo.ad.view.i(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        this.n.setOrientation(0);
        this.n.setLayoutParams(layoutParams3);
        this.l.addView(this.f26798j);
        if (this.r) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(0);
            linearLayout.addView(this.k);
            linearLayout.addView(this.f26796h);
            this.l.addView(linearLayout, new LinearLayout.LayoutParams(-2, -2));
            this.n.addView(this.f26797i);
            this.n.addView(this.m, new LinearLayout.LayoutParams(-2, -2));
            this.l.addView(this.n);
        } else {
            this.l.addView(this.k);
            this.l.addView(this.f26797i);
            this.n.addView(this.f26796h);
            this.n.addView(this.m);
            this.l.addView(this.n);
        }
        this.l.setVisibility(8);
        viewGroup.addView(this.l, layoutParams);
    }

    public void a(com.vivo.ad.model.b bVar, p.h hVar, String str) {
        if (q.a(bVar)) {
            com.vivo.ad.model.q y = bVar.y();
            this.l.setVisibility(0);
            this.m.a(bVar, str);
            this.m.setDialogListener(hVar);
            this.f26798j.setText(y.d() + ExifInterface.GPS_MEASUREMENT_INTERRUPTED + y.s());
            this.f26797i.setText(y.g());
            this.f26796h.setText((y.q() / 1024) + "MB");
            this.k.setTextColor(Color.parseColor("#999999"));
            this.f26796h.setTextColor(Color.parseColor("#999999"));
            this.f26797i.setTextColor(Color.parseColor("#999999"));
            TextView textView = this.f26792d;
            if (textView != null) {
                textView.setVisibility(8);
            }
            if (this.f26793e != null) {
                this.k.setText(((Object) this.f26793e.getText()) + " ");
                this.f26793e.setVisibility(8);
            }
        }
    }
}
