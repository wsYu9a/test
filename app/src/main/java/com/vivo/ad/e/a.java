package com.vivo.ad.e;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.vivo.mobilead.util.g;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.m;
import com.vivo.mobilead.util.y0;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class a extends Dialog {

    /* renamed from: a */
    private Context f26606a;

    /* renamed from: b */
    private com.vivo.ad.e.c f26607b;

    /* renamed from: c */
    private ListView f26608c;

    /* renamed from: d */
    private View f26609d;

    /* renamed from: e */
    private TextView f26610e;

    /* renamed from: f */
    private com.vivo.ad.e.b f26611f;

    /* renamed from: g */
    private com.vivo.ad.model.b f26612g;

    /* renamed from: h */
    private String f26613h;

    /* renamed from: i */
    private d f26614i;

    /* renamed from: com.vivo.ad.e.a$a */
    class C0554a implements AdapterView.OnItemClickListener {
        C0554a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            com.vivo.ad.model.a item = a.this.f26611f.getItem(i2);
            if (item != null) {
                if (item.a() == null || item.a().size() == 0) {
                    a.this.a(item);
                } else {
                    a.this.a(item.e(), item.a());
                }
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.b();
        }
    }

    public static class c {

        /* renamed from: a */
        private Context f26617a;

        /* renamed from: b */
        private com.vivo.ad.model.b f26618b;

        /* renamed from: c */
        private String f26619c;

        /* renamed from: d */
        private DialogInterface.OnDismissListener f26620d;

        /* renamed from: e */
        private DialogInterface.OnShowListener f26621e;

        /* renamed from: f */
        private d f26622f;

        public c(Context context) {
            this.f26617a = context;
        }

        public c a(com.vivo.ad.model.b bVar) {
            this.f26618b = bVar;
            return this;
        }

        public c a(String str) {
            this.f26619c = str;
            return this;
        }

        public c a(DialogInterface.OnDismissListener onDismissListener) {
            this.f26620d = onDismissListener;
            return this;
        }

        public c a(DialogInterface.OnShowListener onShowListener) {
            this.f26621e = onShowListener;
            return this;
        }

        public c a(d dVar) {
            this.f26622f = dVar;
            return this;
        }

        public void a() {
            a(17, 0.0f);
        }

        public void a(int i2, float f2) {
            a aVar = new a(this.f26617a, i2, f2);
            aVar.a(this.f26618b, this.f26619c);
            aVar.setOnDismissListener(new com.vivo.mobilead.g.d(this.f26620d));
            aVar.setOnShowListener(new com.vivo.mobilead.g.e(this.f26621e));
            aVar.a(this.f26622f);
            aVar.show();
        }
    }

    public interface d {
        void a(String str);
    }

    protected a(@NonNull Context context, int i2, float f2) {
        super(context);
        this.f26606a = context;
        a(i2, f2);
    }

    private void c() {
        if (((Activity) this.f26606a).isFinishing()) {
            return;
        }
        Toast makeText = Toast.makeText(this.f26606a, "感谢您的反馈，反馈已上报", 0);
        makeText.setGravity(17, 0, 0);
        makeText.show();
    }

    @Override // android.app.Dialog
    public void show() {
        com.vivo.ad.model.b bVar;
        Context context = this.f26606a;
        if (context == null || !(context instanceof Activity) || ((Activity) context).isFinishing() || (bVar = this.f26612g) == null || bVar.r() == null || this.f26612g.r().size() == 0) {
            return;
        }
        if (this.f26612g.a() != null && this.f26612g.a().e()) {
            c();
        } else {
            b();
            super.show();
        }
    }

    public void b() {
        if (this.f26609d != null && this.f26607b.getChildCount() == 2) {
            this.f26607b.removeView(this.f26609d);
        }
        this.f26611f.a(this.f26612g.r());
    }

    private void a(int i2, float f2) {
        setFeatureDrawableAlpha(0, 0);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.getAttributes().y = m.b(this.f26606a, f2);
            window.setGravity(i2);
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        Context context = this.f26606a;
        if (context instanceof Activity) {
            setOwnerActivity((Activity) context);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(m.b(this.f26606a, 10.0f));
        Context context2 = this.f26606a;
        com.vivo.ad.e.c cVar = new com.vivo.ad.e.c(context2, m.b(context2, 249.0f));
        this.f26607b = cVar;
        cVar.setOrientation(1);
        this.f26607b.setBackground(gradientDrawable);
        this.f26611f = new com.vivo.ad.e.b(this.f26606a);
        ListView listView = new ListView(this.f26606a);
        this.f26608c = listView;
        listView.setBackground(gradientDrawable);
        this.f26608c.setDividerHeight(0);
        this.f26608c.setAdapter((ListAdapter) this.f26611f);
        this.f26608c.setOnItemClickListener(new C0554a());
        this.f26607b.addView(this.f26608c, new LinearLayout.LayoutParams(-1, -2));
        setContentView(this.f26607b, new ViewGroup.LayoutParams(m.b(this.f26606a, 320.0f), -2));
    }

    public void a(com.vivo.ad.model.b bVar, String str) {
        this.f26612g = bVar;
        this.f26613h = str;
    }

    public void a(d dVar) {
        this.f26614i = dVar;
    }

    public void a(com.vivo.ad.model.a aVar) {
        dismiss();
        c();
        d dVar = this.f26614i;
        if (dVar != null) {
            dVar.a(aVar.d());
        }
        k0.a(this.f26612g, aVar.d(), this.f26613h);
        this.f26612g.a().c(true);
    }

    public void a(String str, ArrayList<com.vivo.ad.model.a> arrayList) {
        if (arrayList == null || arrayList.size() == 0 || TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f26609d == null) {
            this.f26609d = a();
        }
        this.f26610e.setText(str);
        this.f26607b.addView(this.f26609d, 0, new LinearLayout.LayoutParams(-1, -2));
        this.f26611f.b(arrayList);
    }

    private View a() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f26606a);
        relativeLayout.setPadding(0, 0, m.b(this.f26606a, 20.33f), 0);
        int a2 = m.a(this.f26606a, 10.0f);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f26606a);
        relativeLayout2.setId(y0.a());
        relativeLayout2.setPadding(m.b(this.f26606a, 20.33f), a2, a2, a2);
        ImageView imageView = new ImageView(this.f26606a);
        imageView.setImageDrawable(g.b(this.f26606a, "vivo_module_feedback_back.png"));
        relativeLayout2.addView(imageView, new RelativeLayout.LayoutParams(m.b(this.f26606a, 7.67f), m.b(this.f26606a, 13.27f)));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(5);
        layoutParams.addRule(15);
        relativeLayout.addView(relativeLayout2, layoutParams);
        relativeLayout2.setOnClickListener(new b());
        TextView textView = new TextView(this.f26606a);
        this.f26610e = textView;
        textView.setId(y0.a());
        this.f26610e.setTextColor(Color.parseColor("#333333"));
        this.f26610e.setTextSize(1, 14.67f);
        this.f26610e.setSingleLine();
        this.f26610e.setEllipsize(TextUtils.TruncateAt.END);
        this.f26610e.setGravity(17);
        this.f26610e.setPadding(m.b(this.f26606a, 5.0f), m.b(this.f26606a, 15.33f), m.b(this.f26606a, 5.0f), m.b(this.f26606a, 16.67f));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(11);
        layoutParams2.addRule(1, relativeLayout2.getId());
        layoutParams2.rightMargin = m.a(this.f26606a, 17.67f);
        relativeLayout.addView(this.f26610e, layoutParams2);
        ImageView imageView2 = new ImageView(this.f26606a);
        imageView2.setImageDrawable(new ColorDrawable(Color.parseColor("#EEEEEE")));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, m.b(this.f26606a, 0.5f));
        layoutParams3.addRule(3, this.f26610e.getId());
        layoutParams3.leftMargin = m.b(this.f26606a, 20.33f);
        relativeLayout.addView(imageView2, layoutParams3);
        return relativeLayout;
    }
}
