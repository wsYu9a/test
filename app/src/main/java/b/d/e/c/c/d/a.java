package b.d.e.c.c.d;

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
import b.d.e.c.a.d;
import com.martian.ttbook.b.a.q.f;
import com.martian.ttbook.b.c.a.a.d.b.j;
import com.martian.ttbook.sdk.R;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private f f4777a;

    /* renamed from: b */
    private b f4778b;

    /* renamed from: c */
    private Dialog f4779c;

    /* renamed from: b.d.e.c.c.d.a$a */
    private class DialogC0049a extends Dialog {

        /* renamed from: a */
        private b f4780a;

        /* renamed from: b */
        private f f4781b;

        /* renamed from: c */
        private View f4782c;

        /* renamed from: d */
        private View f4783d;

        /* renamed from: e */
        private ViewGroup f4784e;

        /* renamed from: b.d.e.c.c.d.a$a$a */
        class ViewOnClickListenerC0050a implements View.OnClickListener {
            ViewOnClickListenerC0050a(a aVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.d.e.c.a.d.k("AIWTAG", "c c");
                DialogC0049a.this.dismiss();
            }
        }

        /* renamed from: b.d.e.c.c.d.a$a$b */
        class b implements View.OnClickListener {
            b(a aVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.d.e.c.a.d.k("AIWTAG", "d c");
                DialogC0049a.this.dismiss();
                if (DialogC0049a.this.f4780a != null) {
                    DialogC0049a.this.f4780a.e();
                }
            }
        }

        /* renamed from: b.d.e.c.c.d.a$a$c */
        class c implements f.d {
            c(a aVar) {
            }

            @Override // com.martian.ttbook.b.a.q.f.d
            public void onLoadCompleted() {
                b.d.e.c.a.d.k("AIWTAG", "sd cp");
                if (DialogC0049a.this.f4780a != null) {
                    DialogC0049a.this.f4780a.d();
                }
            }
        }

        /* renamed from: b.d.e.c.c.d.a$a$d */
        class d implements DialogInterface.OnDismissListener {
            d(a aVar) {
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                b.d.e.c.a.d.k("AIWTAG", "sd dm");
                DialogC0049a.this.f4781b.removeAllViews();
                DialogC0049a.this.f4781b.destroy();
                if (DialogC0049a.this.f4780a != null) {
                    DialogC0049a.this.f4780a.f();
                }
            }
        }

        public DialogC0049a(@NonNull Context context, String str, b bVar) {
            super(context, a.f("JhSdkDialog"));
            this.f4780a = bVar;
            LinearLayout linearLayout = new LinearLayout(context);
            c(context);
            linearLayout.addView(this.f4782c, new FrameLayout.LayoutParams(-1, -2));
            setCancelable(true);
            setContentView(linearLayout);
            this.f4783d.setOnClickListener(new ViewOnClickListenerC0050a(a.this));
            this.f4784e.setOnClickListener(new b(a.this));
            this.f4781b.e(new c(a.this));
            setOnDismissListener(new d(a.this));
            this.f4781b.loadUrl(j.d().replace("/api/getSdkAds", str));
        }

        private void c(Context context) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setBackgroundColor(-1);
            linearLayout.setOrientation(1);
            int b2 = com.martian.ttbook.b.a.k.b.b(context, 10.0d);
            linearLayout.setPadding(b2, b2, b2, b2);
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
            com.martian.ttbook.b.a.k.j.g(imageView, "iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAABaklEQVRYR+2VP0vEQBDF31tsBfHTWO5saWOjoOefQq5RK0v9AtpZqYVi4X9QCyutJqn8OqK1OLKSwBHPu9wtEoSkTObN/PJ2ZpZo+GHD9dECtA60Dgx1QFUfAMw457re+6c6Y6uqswBOSL6IyMIgzVCALMveAUwC+DCz+RDC46CEqjpH8h7AhJm9hRCmkgBUtUPyEgDN7JPkmohc9UuaZdmymZ2TdADMzFZCCNdJAFEcEwO4iBBF4m4I4aw3saqukzwtYwCs/gbaqxt6BGVwBQIkN733x/F7nucbZnZUxFrd4jG+NkAfJ+Kr7aLowTjFRwaIgorVvW6O9OelcCQHSlEfiNhwP/qizsj+P4BGj6A6CQB2Cpv3/rwJGx3DRhdRnudLZhZX7/cqds4teu/v6qxiAB0RuU1axSmXEYBXEZlOBdg3swWSWyLyXGe243VM8tDMbkIIu0kAdQqmxIy1iFIKVrUtQOtA68AX4HzJIQMvlE8AAAAASUVORK5CYII=");
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.martian.ttbook.b.a.k.b.b(context, 20.0d), com.martian.ttbook.b.a.k.b.b(context, 20.0d));
            layoutParams2.addRule(15);
            layoutParams2.addRule(11);
            relativeLayout.addView(imageView, layoutParams2);
            linearLayout.addView(relativeLayout, new LinearLayout.LayoutParams(-1, com.martian.ttbook.b.a.k.b.b(context, 50.0d)));
            FrameLayout frameLayout = new FrameLayout(context);
            f fVar = new f(context);
            frameLayout.addView(fVar, new FrameLayout.LayoutParams(-1, -2));
            linearLayout.addView(frameLayout, new FrameLayout.LayoutParams(-1, com.martian.ttbook.b.a.k.b.b(context, 300.0d)));
            RelativeLayout relativeLayout2 = new RelativeLayout(context);
            com.martian.ttbook.b.a.k.j.f(relativeLayout2, context, 255, 11, 93, 230, 90);
            int b3 = com.martian.ttbook.b.a.k.b.b(context, 15.0d);
            relativeLayout2.setPadding(b3, b3, b3, b3);
            TextView textView2 = new TextView(context);
            textView2.setText("立即下载");
            textView2.setTextColor(-1);
            textView2.setTextSize(15.0f);
            textView2.setTypeface(Typeface.defaultFromStyle(1));
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(13);
            relativeLayout2.addView(textView2, layoutParams3);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
            marginLayoutParams.leftMargin = com.martian.ttbook.b.a.k.b.b(context, 15.0d);
            marginLayoutParams.rightMargin = com.martian.ttbook.b.a.k.b.b(context, 15.0d);
            marginLayoutParams.topMargin = com.martian.ttbook.b.a.k.b.b(context, 3.0d);
            linearLayout.addView(relativeLayout2, marginLayoutParams);
            this.f4782c = linearLayout;
            this.f4783d = imageView;
            this.f4784e = relativeLayout2;
            this.f4781b = fVar;
        }

        public void b() {
            Window window = a.this.f4779c.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.width = -1;
            attributes.height = -2;
            window.setWindowAnimations(a.f("JhSdkSlidup"));
            window.setAttributes(attributes);
        }

        @Override // android.app.Dialog
        public void show() {
            b();
            super.show();
        }
    }

    public interface b {
        void d();

        void e();

        void f();
    }

    public a(b bVar) {
        this.f4778b = bVar;
    }

    public static int f(String str) {
        try {
            return Integer.parseInt(R.style.class.getField(str).get(null).toString());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public void c() {
        d.k("AIWTAG", "RLY");
        f fVar = this.f4777a;
        if (fVar != null) {
            fVar.removeAllViews();
            this.f4777a.destroy();
            this.f4777a = null;
        }
    }

    public void d(Context context, View view) {
        d.k("AIWTAG", "s d");
        try {
            if (this.f4779c == null) {
                return;
            }
            d.k("AIWTAG", "sd s");
            this.f4779c.show();
        } catch (Exception e2) {
            d.f("AIWTAG", "s e %s ", e2);
            b bVar = this.f4778b;
            if (bVar != null) {
                bVar.f();
            }
        }
    }

    public void e(Context context, String str) {
        d.f("AIWTAG", "SAD CT= %s", context);
        if (TextUtils.isEmpty(j.d())) {
            d.k("AIWTAG", "SAD R");
            return;
        }
        try {
            if (context instanceof Activity) {
                d.k("AIWTAG", "SAD C");
                this.f4779c = new DialogC0049a(context, str, this.f4778b);
            }
        } catch (Exception e2) {
            d.f("AIWTAG", "R E %s", e2);
            c();
        }
    }
}
