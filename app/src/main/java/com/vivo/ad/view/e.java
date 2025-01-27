package com.vivo.ad.view;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.vivo.ad.e.a;
import com.vivo.mobilead.model.VivoAdError;

/* loaded from: classes4.dex */
public class e extends LinearLayout {

    /* renamed from: a */
    private final int f27003a;

    /* renamed from: b */
    private final int f27004b;

    /* renamed from: c */
    private DialogInterface.OnDismissListener f27005c;

    /* renamed from: d */
    private DialogInterface.OnShowListener f27006d;

    /* renamed from: e */
    private boolean f27007e;

    /* renamed from: f */
    private boolean f27008f;

    /* renamed from: g */
    private com.vivo.ad.model.b f27009g;

    /* renamed from: h */
    private String f27010h;

    /* renamed from: i */
    private TextView f27011i;

    /* renamed from: j */
    private ImageView f27012j;
    private ImageView k;
    private View.OnClickListener l;
    private DialogInterface.OnShowListener m;
    private DialogInterface.OnDismissListener n;
    private a.d o;

    class a extends com.vivo.mobilead.util.b1.a.c.b {
        a() {
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(String str, Bitmap bitmap) {
            e eVar = e.this;
            eVar.b(bitmap, eVar.f27009g.k(), e.this.f27009g.O());
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(VivoAdError vivoAdError) {
            e eVar = e.this;
            eVar.b(null, eVar.f27009g.k(), e.this.f27009g.O());
        }
    }

    class b extends com.vivo.mobilead.g.c {
        b() {
        }

        @Override // com.vivo.mobilead.g.c
        public void a(View view) {
            if (e.this.f27007e) {
                e.this.c();
            } else {
                new a.c(e.this.getContext()).a(e.this.f27010h).a(e.this.f27009g).a(e.this.n).a(e.this.m).a(e.this.o).a();
            }
        }
    }

    class c implements DialogInterface.OnShowListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            e.this.f27008f = true;
            if (e.this.f27006d != null) {
                e.this.f27006d.onShow(dialogInterface);
            }
        }
    }

    class d implements DialogInterface.OnDismissListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            e.this.f27008f = false;
            if (e.this.f27005c != null) {
                e.this.f27005c.onDismiss(dialogInterface);
            }
        }
    }

    /* renamed from: com.vivo.ad.view.e$e */
    class C0562e implements a.d {
        C0562e() {
        }

        @Override // com.vivo.ad.e.a.d
        public void a(String str) {
            e.this.f27007e = true;
        }
    }

    public e(@NonNull Context context) {
        super(context);
        this.f27003a = Color.parseColor("#26000000");
        this.f27004b = Color.parseColor("#ffffff");
        this.f27007e = false;
        this.l = new b();
        this.m = new c();
        this.n = new d();
        this.o = new C0562e();
        a();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    public void setTagBackground(GradientDrawable gradientDrawable) {
        setBackground(gradientDrawable);
    }

    public void c() {
        Toast makeText = Toast.makeText(getContext(), "感谢您的反馈，反馈已上报", 0);
        makeText.setGravity(17, 0, 0);
        makeText.show();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.generateLayoutParams(layoutParams);
    }

    private void a() {
        setTag("feedback");
        setOrientation(0);
        setGravity(16);
        int b2 = com.vivo.mobilead.util.m.b(getContext(), 4.0f);
        int b3 = com.vivo.mobilead.util.m.b(getContext(), 2.0f);
        setPadding(b2, b3, b2, b3);
        TextView textView = new TextView(getContext());
        this.f27011i = textView;
        textView.setMaxLines(1);
        this.f27011i.setTextSize(1, 10.0f);
        this.f27011i.setTextColor(this.f27004b);
        addView(this.f27011i, new LinearLayout.LayoutParams(-2, -2));
        ImageView imageView = new ImageView(getContext());
        this.k = imageView;
        imageView.setVisibility(8);
        this.k.setScaleType(ImageView.ScaleType.FIT_XY);
        this.k.setImageDrawable(com.vivo.mobilead.util.g.b(getContext(), "vivo_module_feedback_arrow_down.png"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.vivo.mobilead.util.m.b(getContext(), 6.5f), com.vivo.mobilead.util.m.b(getContext(), 3.73f));
        layoutParams.leftMargin = com.vivo.mobilead.util.m.a(getContext(), 2.0f);
        addView(this.k, layoutParams);
        setOnClickListener(this.l);
        a(this.f27003a, (float[]) null);
    }

    private void b() {
        if (this.f27009g == null) {
            return;
        }
        Bitmap a2 = com.vivo.mobilead.h.b.a().a(this.f27009g.e());
        if (a2 == null) {
            com.vivo.mobilead.util.b1.a.b.b().a(this.f27009g.e(), new a());
        } else {
            b(a2, this.f27009g.k(), this.f27009g.O());
        }
    }

    public void b(Bitmap bitmap, String str, String str2) {
        a(bitmap, str, str2);
    }

    public void a(com.vivo.ad.model.b bVar, String str, DialogInterface.OnShowListener onShowListener, DialogInterface.OnDismissListener onDismissListener) {
        if (bVar == null) {
            return;
        }
        this.f27006d = onShowListener;
        this.f27005c = onDismissListener;
        this.f27010h = str;
        this.f27009g = bVar;
        b();
    }

    public void a(Bitmap bitmap, String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        if (bitmap == null) {
            if (!TextUtils.isEmpty(str)) {
                str2 = str + str2;
            }
            ImageView imageView = this.f27012j;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        } else {
            if (this.f27012j == null) {
                int b2 = com.vivo.mobilead.util.m.b(getContext(), 11.0f);
                ImageView imageView2 = new ImageView(getContext());
                this.f27012j = imageView2;
                imageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(b2, b2);
                layoutParams.rightMargin = com.vivo.mobilead.util.m.b(getContext(), 3.0f);
                addView(this.f27012j, 0, layoutParams);
            }
            this.f27012j.setImageBitmap(bitmap);
            this.f27012j.setVisibility(0);
        }
        if (str2.length() > 10) {
            str2 = str2.substring(0, 10) + "...";
        }
        this.f27011i.setText(str2);
        com.vivo.ad.model.b bVar = this.f27009g;
        if (bVar != null && bVar.r() != null && this.f27009g.r().size() > 0) {
            this.k.setVisibility(0);
        } else {
            this.k.setVisibility(8);
        }
    }

    public void a(int i2, float[] fArr) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadii(fArr);
        setBackground(gradientDrawable);
    }
}
