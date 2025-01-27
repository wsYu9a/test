package com.opos.cmn.e.a.b.b;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.cmn.i.g;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private RelativeLayout f16948a;

    /* renamed from: b */
    private RelativeLayout f16949b;

    /* renamed from: c */
    private TextView f16950c;

    /* renamed from: d */
    private ImageView f16951d;

    /* renamed from: e */
    private LinearLayout f16952e;

    /* renamed from: f */
    private Dialog f16953f;

    /* renamed from: com.opos.cmn.e.a.b.b.d$1 */
    class AnonymousClass1 extends com.opos.cmn.e.a.a {

        /* renamed from: a */
        final /* synthetic */ b f16954a;

        AnonymousClass1(b bVar) {
            bVar = bVar;
        }

        @Override // com.opos.cmn.e.a.a
        public void a(View view, int[] iArr) {
            b bVar = bVar;
            if (bVar != null) {
                bVar.a(d.this, view, iArr);
            }
        }
    }

    /* renamed from: com.opos.cmn.e.a.b.b.d$2 */
    class AnonymousClass2 extends com.opos.cmn.e.a.a {

        /* renamed from: a */
        final /* synthetic */ b f16956a;

        AnonymousClass2(b bVar) {
            bVar2 = bVar;
        }

        @Override // com.opos.cmn.e.a.a
        public void a(View view, int[] iArr) {
            b bVar = bVar2;
            if (bVar != null) {
                bVar.a(d.this, view, iArr);
            }
        }
    }

    public static class a {

        /* renamed from: a */
        private Context f16958a;

        /* renamed from: b */
        private CharSequence f16959b;

        /* renamed from: c */
        private CharSequence f16960c;

        /* renamed from: d */
        private b f16961d;

        /* renamed from: e */
        private CharSequence f16962e;

        /* renamed from: f */
        private b f16963f;

        public a(Context context) {
            this.f16958a = context;
        }

        public a a(CharSequence charSequence) {
            this.f16959b = charSequence;
            return this;
        }

        public a a(CharSequence charSequence, b bVar) {
            this.f16960c = charSequence;
            this.f16961d = bVar;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(CharSequence charSequence, b bVar) {
            this.f16962e = charSequence;
            this.f16963f = bVar;
            return this;
        }
    }

    public interface b {
        void a(d dVar, View view, int[] iArr);
    }

    private d(a aVar) {
        b(aVar);
        a(aVar);
    }

    /* synthetic */ d(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    private void b(a aVar) {
        RelativeLayout relativeLayout = new RelativeLayout(aVar.f16958a);
        this.f16948a = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        c(aVar);
        this.f16949b = new RelativeLayout(aVar.f16958a);
        d(aVar);
        if (Build.VERSION.SDK_INT >= 29) {
            this.f16949b.setForceDarkAllowed(false);
        }
        TextView textView = new TextView(aVar.f16958a);
        this.f16950c = textView;
        textView.setId(1);
        this.f16950c.setGravity(17);
        this.f16950c.setMaxLines(2);
        this.f16950c.setEllipsize(TextUtils.TruncateAt.END);
        this.f16950c.setTextColor(Color.parseColor("#2f2f2f"));
        this.f16950c.setTextSize(1, 16.0f);
        this.f16950c.setText(aVar.f16959b);
        e(aVar);
        ImageView imageView = new ImageView(aVar.f16958a);
        this.f16951d = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f16951d.setImageDrawable(new ColorDrawable(Color.parseColor("#cdd2d4")));
        f(aVar);
        g(aVar);
    }

    private void c(a aVar) {
        ImageView imageView = new ImageView(aVar.f16958a);
        imageView.setImageDrawable(new ColorDrawable(-16777216));
        imageView.setAlpha(0.6f);
        this.f16948a.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void d(a aVar) {
        com.opos.cmn.e.a.a.c cVar = new com.opos.cmn.e.a.a.c(aVar.f16958a, 14.0f);
        cVar.setImageDrawable(new ColorDrawable(-1));
        this.f16949b.addView(cVar, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void e(a aVar) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(aVar.f16958a, 260.0f), com.opos.cmn.an.h.f.a.a(aVar.f16958a, 91.0f));
        layoutParams.addRule(10);
        this.f16949b.addView(this.f16950c, layoutParams);
    }

    private void f(a aVar) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(aVar.f16958a, 260.0f), com.opos.cmn.an.h.f.a.a(aVar.f16958a, 1.0f));
        layoutParams.addRule(3, 1);
        this.f16949b.addView(this.f16951d, layoutParams);
    }

    private void g(a aVar) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(aVar.f16958a, 260.0f), com.opos.cmn.an.h.f.a.a(aVar.f16958a, 130.0f));
        layoutParams.addRule(13);
        this.f16948a.addView(this.f16949b, layoutParams);
    }

    private void h(a aVar) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(aVar.f16958a, 260.0f), com.opos.cmn.an.h.f.a.a(aVar.f16958a, 38.0f));
        layoutParams.addRule(12);
        this.f16949b.addView(this.f16952e, layoutParams);
    }

    public void a(Activity activity) {
        if (this.f16953f == null) {
            int i2 = R.style.Theme.Translucent.NoTitleBar;
            if (com.opos.cmn.an.h.f.a.a(activity)) {
                i2 = R.style.Theme.Translucent.NoTitleBar.Fullscreen;
            }
            Dialog dialog = new Dialog(activity, i2);
            this.f16953f = dialog;
            dialog.setCancelable(false);
            this.f16953f.setCanceledOnTouchOutside(false);
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = this.f16953f.getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                this.f16953f.getWindow().setAttributes(attributes);
            }
            g.a(activity.getApplicationContext(), this.f16953f.getWindow());
            this.f16953f.setContentView(this.f16948a);
        }
        if (this.f16953f.isShowing()) {
            return;
        }
        this.f16953f.show();
    }

    protected void a(a aVar) {
        LinearLayout linearLayout = new LinearLayout(aVar.f16958a);
        this.f16952e = linearLayout;
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(1, -1);
        layoutParams.weight = 1.0f;
        TextView textView = new TextView(aVar.f16958a);
        textView.setGravity(17);
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(Color.parseColor("#767575"));
        textView.setTextSize(1, 13.0f);
        textView.setText(aVar.f16960c);
        b bVar = aVar.f16961d;
        AnonymousClass1 anonymousClass1 = new com.opos.cmn.e.a.a() { // from class: com.opos.cmn.e.a.b.b.d.1

            /* renamed from: a */
            final /* synthetic */ b f16954a;

            AnonymousClass1(b bVar2) {
                bVar = bVar2;
            }

            @Override // com.opos.cmn.e.a.a
            public void a(View view, int[] iArr) {
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a(d.this, view, iArr);
                }
            }
        };
        textView.setOnTouchListener(anonymousClass1);
        textView.setOnClickListener(anonymousClass1);
        this.f16952e.addView(textView, layoutParams);
        TextView textView2 = new TextView(aVar.f16958a);
        textView2.setBackgroundColor(Color.parseColor("#cdd2d4"));
        this.f16952e.addView(textView2, new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(aVar.f16958a, 1.0f), -1));
        TextView textView3 = new TextView(aVar.f16958a);
        textView3.setGravity(17);
        textView3.setSingleLine();
        textView3.setEllipsize(TextUtils.TruncateAt.END);
        textView3.setTextColor(Color.parseColor("#d95955"));
        textView3.setTextSize(1, 13.0f);
        textView3.setText(aVar.f16962e);
        b bVar2 = aVar.f16963f;
        AnonymousClass2 anonymousClass2 = new com.opos.cmn.e.a.a() { // from class: com.opos.cmn.e.a.b.b.d.2

            /* renamed from: a */
            final /* synthetic */ b f16956a;

            AnonymousClass2(b bVar22) {
                bVar2 = bVar22;
            }

            @Override // com.opos.cmn.e.a.a
            public void a(View view, int[] iArr) {
                b bVar3 = bVar2;
                if (bVar3 != null) {
                    bVar3.a(d.this, view, iArr);
                }
            }
        };
        textView3.setOnTouchListener(anonymousClass2);
        textView3.setOnClickListener(anonymousClass2);
        this.f16952e.addView(textView3, layoutParams);
        if (bVar22 == null) {
            textView3.setVisibility(8);
            textView2.setVisibility(8);
        }
        if (bVar2 == null) {
            textView.setVisibility(8);
            textView2.setVisibility(8);
        }
        h(aVar);
    }

    public void a(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.f16950c.setText(charSequence);
    }

    public boolean a() {
        Dialog dialog = this.f16953f;
        return dialog != null && dialog.isShowing();
    }

    public void b() {
        Dialog dialog = this.f16953f;
        if (dialog != null) {
            dialog.cancel();
        }
    }
}
