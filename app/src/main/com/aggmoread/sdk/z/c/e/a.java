package com.aggmoread.sdk.z.c.e;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.aggmoread.sdk.R;
import com.aggmoread.sdk.z.b.d;
import com.aggmoread.sdk.z.b.u.i;
import com.aggmoread.sdk.z.d.a.a.d.b.j;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    private i f5191a;

    /* renamed from: b */
    private b f5192b;

    /* renamed from: c */
    private Dialog f5193c;

    /* renamed from: com.aggmoread.sdk.z.c.e.a$a */
    public class DialogC0113a extends Dialog {

        /* renamed from: a */
        private b f5194a;

        /* renamed from: b */
        private i f5195b;

        /* renamed from: c */
        private View f5196c;

        /* renamed from: d */
        private View f5197d;

        /* renamed from: e */
        private ViewGroup f5198e;

        /* renamed from: com.aggmoread.sdk.z.c.e.a$a$a */
        public class ViewOnClickListenerC0114a implements View.OnClickListener {
            public ViewOnClickListenerC0114a(a aVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.aggmoread.sdk.z.b.d.c("AIWTAG", "c c");
                DialogC0113a.this.dismiss();
            }
        }

        /* renamed from: com.aggmoread.sdk.z.c.e.a$a$b */
        public class b implements View.OnClickListener {
            public b(a aVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.aggmoread.sdk.z.b.d.c("AIWTAG", "d c");
                DialogC0113a.this.dismiss();
                if (DialogC0113a.this.f5194a != null) {
                    DialogC0113a.this.f5194a.a();
                }
            }
        }

        /* renamed from: com.aggmoread.sdk.z.c.e.a$a$c */
        public class c implements i.d {
            public c(a aVar) {
            }

            @Override // com.aggmoread.sdk.z.b.u.i.d
            public void a() {
                com.aggmoread.sdk.z.b.d.c("AIWTAG", "sd cp");
                if (DialogC0113a.this.f5194a != null) {
                    DialogC0113a.this.f5194a.onRenderSuccess();
                }
            }
        }

        /* renamed from: com.aggmoread.sdk.z.c.e.a$a$d */
        public class d implements DialogInterface.OnDismissListener {
            public d(a aVar) {
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                com.aggmoread.sdk.z.b.d.c("AIWTAG", "sd dm");
                DialogC0113a.this.f5195b.removeAllViews();
                DialogC0113a.this.f5195b.destroy();
                if (DialogC0113a.this.f5194a != null) {
                    DialogC0113a.this.f5194a.b();
                }
            }
        }

        public DialogC0113a(@NonNull Context context, String str, b bVar) {
            super(context, a.b("CustomDialog1"));
            this.f5194a = bVar;
            LinearLayout linearLayout = new LinearLayout(context);
            a(context);
            linearLayout.addView(this.f5196c, new FrameLayout.LayoutParams(-1, -2));
            setCancelable(true);
            setContentView(linearLayout);
            this.f5197d.setOnClickListener(new ViewOnClickListenerC0114a(a.this));
            this.f5198e.setOnClickListener(new b(a.this));
            this.f5195b.a(new c(a.this));
            setOnDismissListener(new d(a.this));
            this.f5195b.loadUrl(j.d().replace("/api/getSdkAds", str));
        }

        @Override // android.app.Dialog
        public void show() {
            a();
            super.show();
        }

        public void a() {
            Window window = a.this.f5193c.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.width = -1;
            attributes.height = -2;
            window.setWindowAnimations(a.b("CustomAnim"));
            window.setAttributes(attributes);
        }

        private void a(Context context) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setBackgroundColor(-1);
            linearLayout.setOrientation(1);
            int a10 = com.aggmoread.sdk.z.b.m.b.a(context, 10.0d);
            linearLayout.setPadding(a10, a10, a10, a10);
            RelativeLayout relativeLayout = new RelativeLayout(context);
            TextView textView = new TextView(context);
            textView.setTextColor(-16777216);
            textView.setTypeface(Typeface.defaultFromStyle(1));
            textView.setTextSize(18.0f);
            textView.setText("应用信息");
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            relativeLayout.addView(textView, layoutParams);
            ImageView imageView = new ImageView(context);
            com.aggmoread.sdk.z.b.m.j.a(imageView, "iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAABaklEQVRYR+2VP0vEQBDF31tsBfHTWO5saWOjoOefQq5RK0v9AtpZqYVi4X9QCyutJqn8OqK1OLKSwBHPu9wtEoSkTObN/PJ2ZpZo+GHD9dECtA60Dgx1QFUfAMw457re+6c6Y6uqswBOSL6IyMIgzVCALMveAUwC+DCz+RDC46CEqjpH8h7AhJm9hRCmkgBUtUPyEgDN7JPkmohc9UuaZdmymZ2TdADMzFZCCNdJAFEcEwO4iBBF4m4I4aw3saqukzwtYwCs/gbaqxt6BGVwBQIkN733x/F7nucbZnZUxFrd4jG+NkAfJ+Kr7aLowTjFRwaIgorVvW6O9OelcCQHSlEfiNhwP/qizsj+P4BGj6A6CQB2Cpv3/rwJGx3DRhdRnudLZhZX7/cqds4teu/v6qxiAB0RuU1axSmXEYBXEZlOBdg3swWSWyLyXGe243VM8tDMbkIIu0kAdQqmxIy1iFIKVrUtQOtA68AX4HzJIQMvlE8AAAAASUVORK5CYII=");
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.aggmoread.sdk.z.b.m.b.a(context, 20.0d), com.aggmoread.sdk.z.b.m.b.a(context, 20.0d));
            layoutParams2.addRule(15);
            layoutParams2.addRule(11);
            relativeLayout.addView(imageView, layoutParams2);
            linearLayout.addView(relativeLayout, new LinearLayout.LayoutParams(-1, com.aggmoread.sdk.z.b.m.b.a(context, 50.0d)));
            FrameLayout frameLayout = new FrameLayout(context);
            i iVar = new i(context);
            frameLayout.addView(iVar, new FrameLayout.LayoutParams(-1, -2));
            linearLayout.addView(frameLayout, new FrameLayout.LayoutParams(-1, com.aggmoread.sdk.z.b.m.b.a(context, 300.0d)));
            RelativeLayout relativeLayout2 = new RelativeLayout(context);
            com.aggmoread.sdk.z.b.m.j.a(relativeLayout2, context, 255, 11, 93, 230, 90);
            int a11 = com.aggmoread.sdk.z.b.m.b.a(context, 15.0d);
            relativeLayout2.setPadding(a11, a11, a11, a11);
            TextView textView2 = new TextView(context);
            textView2.setText("立即下载");
            textView2.setTextColor(-1);
            textView2.setTextSize(15.0f);
            textView2.setTypeface(Typeface.defaultFromStyle(1));
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(13);
            relativeLayout2.addView(textView2, layoutParams3);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
            marginLayoutParams.leftMargin = com.aggmoread.sdk.z.b.m.b.a(context, 15.0d);
            marginLayoutParams.rightMargin = com.aggmoread.sdk.z.b.m.b.a(context, 15.0d);
            marginLayoutParams.topMargin = com.aggmoread.sdk.z.b.m.b.a(context, 3.0d);
            linearLayout.addView(relativeLayout2, marginLayoutParams);
            this.f5196c = linearLayout;
            this.f5197d = imageView;
            this.f5198e = relativeLayout2;
            this.f5195b = iVar;
        }
    }

    public interface b {
        void a();

        void b();

        void onRenderSuccess();
    }

    public a(b bVar) {
        this.f5192b = bVar;
    }

    public static int b(String str) {
        try {
            return Integer.parseInt(R.style.class.getField(str).get(null).toString());
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public void a() {
        d.c("AIWTAG", "RLY");
        i iVar = this.f5191a;
        if (iVar != null) {
            iVar.removeAllViews();
            this.f5191a.destroy();
            this.f5191a = null;
        }
    }

    public void a(Context context, View view) {
        d.c("AIWTAG", "s d");
        try {
            if (this.f5193c == null) {
                return;
            }
            d.c("AIWTAG", "sd s");
            this.f5193c.show();
        } catch (Exception e10) {
            d.a("AIWTAG", "s e %s ", e10);
            b bVar = this.f5192b;
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    public void a(Context context, String str) {
        d.a("AIWTAG", "SAD CT= %s", context);
        if (TextUtils.isEmpty(j.d())) {
            d.c("AIWTAG", "SAD R");
            return;
        }
        try {
            if (context instanceof Activity) {
                d.c("AIWTAG", "SAD C");
                this.f5193c = new DialogC0113a(context, str, this.f5192b);
            }
        } catch (Exception e10) {
            d.a("AIWTAG", "R E %s", e10);
            a();
        }
    }
}
