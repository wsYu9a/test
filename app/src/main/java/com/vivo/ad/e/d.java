package com.vivo.ad.e;

import android.R;
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
import com.vivo.ad.view.p;
import com.vivo.mobilead.util.g;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.m;
import com.vivo.mobilead.util.y0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
public class d extends Dialog {

    /* renamed from: a */
    private Context f26630a;

    /* renamed from: b */
    private com.vivo.ad.e.c f26631b;

    /* renamed from: c */
    private ListView f26632c;

    /* renamed from: d */
    private View f26633d;

    /* renamed from: e */
    private TextView f26634e;

    /* renamed from: f */
    private f f26635f;

    /* renamed from: g */
    private com.vivo.ad.model.b f26636g;

    /* renamed from: h */
    private String f26637h;

    /* renamed from: i */
    private InterfaceC0555d f26638i;

    /* renamed from: j */
    private boolean f26639j;
    private ArrayList<HashMap<String, ArrayList<com.vivo.ad.model.a>>> k;
    private boolean l;
    private p.h m;

    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            com.vivo.ad.model.a item = d.this.f26635f.getItem(i2);
            if (item != null) {
                if (item.a() == null || item.a().size() == 0) {
                    d.this.a(item);
                } else {
                    d.this.a(item.e(), item.a());
                }
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.c();
        }
    }

    public static class c {

        /* renamed from: a */
        private Context f26642a;

        /* renamed from: b */
        private com.vivo.ad.model.b f26643b;

        /* renamed from: c */
        private String f26644c;

        /* renamed from: d */
        private DialogInterface.OnDismissListener f26645d;

        /* renamed from: e */
        private DialogInterface.OnShowListener f26646e;

        /* renamed from: f */
        private InterfaceC0555d f26647f;

        /* renamed from: g */
        private boolean f26648g = false;

        /* renamed from: h */
        private boolean f26649h;

        /* renamed from: i */
        private p.h f26650i;

        public c(Context context) {
            this.f26642a = context;
        }

        public c a(com.vivo.ad.model.b bVar) {
            this.f26643b = bVar;
            return this;
        }

        public c a(String str) {
            this.f26644c = str;
            return this;
        }

        public c a(DialogInterface.OnDismissListener onDismissListener) {
            this.f26645d = onDismissListener;
            return this;
        }

        public c a(DialogInterface.OnShowListener onShowListener) {
            this.f26646e = onShowListener;
            return this;
        }

        public c a(InterfaceC0555d interfaceC0555d) {
            this.f26647f = interfaceC0555d;
            return this;
        }

        public void a() {
            com.vivo.ad.model.b bVar;
            Context context = this.f26642a;
            if (context != null) {
                if (((context instanceof Activity) && ((Activity) context).isFinishing()) || (bVar = this.f26643b) == null || bVar.r() == null || this.f26643b.r().size() == 0) {
                    return;
                }
                d dVar = new d(this.f26642a, this.f26648g);
                dVar.a(this.f26643b, this.f26644c, this.f26649h);
                dVar.setOnDismissListener(new com.vivo.mobilead.g.d(this.f26645d));
                dVar.setOnShowListener(new com.vivo.mobilead.g.e(this.f26646e));
                dVar.a(this.f26647f);
                dVar.a(this.f26650i);
                dVar.show();
            }
        }

        public c a(boolean z) {
            this.f26649h = z;
            return this;
        }

        public c a(p.h hVar) {
            this.f26650i = hVar;
            return this;
        }
    }

    /* renamed from: com.vivo.ad.e.d$d */
    public interface InterfaceC0555d {
        void a(String str, boolean z);
    }

    public d(@NonNull Context context, boolean z) {
        super(context);
        this.f26639j = false;
        this.k = new ArrayList<>();
        this.f26630a = context;
        this.f26639j = z;
        b();
    }

    public void c() {
        if (this.f26633d == null || this.f26631b.getChildCount() != 2) {
            this.f26635f.a(this.f26636g.r(), this.k.size());
        } else {
            int size = this.k.size();
            if (size > 0) {
                this.k.remove(size - 1);
                size--;
            }
            if (size == 0) {
                this.f26631b.removeView(this.f26633d);
                this.f26635f.a(this.f26636g.r(), size);
            } else {
                Iterator<Map.Entry<String, ArrayList<com.vivo.ad.model.a>>> it = this.k.get(size - 1).entrySet().iterator();
                if (it.hasNext()) {
                    Map.Entry<String, ArrayList<com.vivo.ad.model.a>> next = it.next();
                    this.f26634e.setText(next.getKey());
                    this.f26635f.a(next.getValue(), this.k.size());
                }
            }
        }
        if (this.k.size() == 0 && this.l) {
            this.f26635f.a(true);
        }
    }

    private void d() {
        k0.a(this.f26636g, this.f26637h);
        p pVar = new p(this.f26630a, this.f26636g, this.f26637h);
        pVar.a(this.m);
        pVar.a(false);
    }

    private void e() {
        Context context = this.f26630a;
        if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
            return;
        }
        Toast makeText = Toast.makeText(this.f26630a, "感谢您的反馈，反馈已上报", 0);
        makeText.setGravity(17, 0, 0);
        makeText.show();
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            c();
            super.show();
        } catch (Exception unused) {
        }
    }

    private void b() {
        setFeatureDrawableAlpha(0, 0);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            if (this.f26639j) {
                window.clearFlags(2);
            }
        }
        setOwnerActivity((Activity) this.f26630a);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(m.b(this.f26630a, 10.0f));
        Context context = this.f26630a;
        com.vivo.ad.e.c cVar = new com.vivo.ad.e.c(context, m.b(context, 334.0f));
        this.f26631b = cVar;
        cVar.setOrientation(1);
        this.f26631b.setBackground(gradientDrawable);
        this.f26635f = new f(this.f26630a);
        ListView listView = new ListView(this.f26630a);
        this.f26632c = listView;
        listView.setBackground(gradientDrawable);
        this.f26632c.setSelector(R.color.transparent);
        this.f26632c.setDividerHeight(0);
        this.f26632c.setAdapter((ListAdapter) this.f26635f);
        this.f26632c.setOnItemClickListener(new a());
        this.f26631b.addView(this.f26632c, new LinearLayout.LayoutParams(-1, -2));
        setContentView(this.f26631b, new ViewGroup.LayoutParams(m.b(this.f26630a, 320.0f), -2));
    }

    public void a(com.vivo.ad.model.b bVar, String str, boolean z) {
        this.f26636g = bVar;
        this.f26637h = str;
        this.l = z;
    }

    public void a(InterfaceC0555d interfaceC0555d) {
        this.f26638i = interfaceC0555d;
    }

    public void a(com.vivo.ad.model.a aVar) {
        if (TextUtils.equals("1001", aVar.d())) {
            e();
            this.l = false;
            k0.c(this.f26636g, String.valueOf(aVar.d()), this.f26637h);
        } else if (TextUtils.equals("1002", aVar.d())) {
            dismiss();
            this.l = false;
            d();
        } else {
            this.l = true;
            e();
            k0.a(this.f26636g, String.valueOf(aVar.d()), this.f26637h);
            this.f26636g.a().c(true);
        }
        InterfaceC0555d interfaceC0555d = this.f26638i;
        if (interfaceC0555d != null) {
            interfaceC0555d.a(aVar.d(), this.l);
        }
        if (isShowing()) {
            dismiss();
        }
    }

    public void a(String str, ArrayList<com.vivo.ad.model.a> arrayList) {
        if (arrayList == null || arrayList.size() == 0 || TextUtils.isEmpty(str)) {
            return;
        }
        HashMap<String, ArrayList<com.vivo.ad.model.a>> hashMap = new HashMap<>();
        hashMap.put(str, arrayList);
        this.k.add(hashMap);
        if (this.f26633d == null) {
            this.f26633d = a();
        }
        if (this.k.size() > 0 && this.f26631b.indexOfChild(this.f26633d) < 0) {
            this.f26631b.addView(this.f26633d, 0, new LinearLayout.LayoutParams(-1, -2));
        }
        this.f26634e.setText(str);
        this.f26635f.a(arrayList, this.k.size());
    }

    private View a() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f26630a);
        relativeLayout.setPadding(0, 0, m.b(this.f26630a, 20.33f), 0);
        int a2 = m.a(this.f26630a, 10.0f);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f26630a);
        relativeLayout2.setId(y0.a());
        relativeLayout2.setPadding(m.b(this.f26630a, 20.33f), a2, a2, a2);
        ImageView imageView = new ImageView(this.f26630a);
        imageView.setImageDrawable(g.b(this.f26630a, "vivo_module_feedback_back.png"));
        relativeLayout2.addView(imageView, new RelativeLayout.LayoutParams(m.b(this.f26630a, 7.67f), m.b(this.f26630a, 13.27f)));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(5);
        layoutParams.addRule(15);
        relativeLayout.addView(relativeLayout2, layoutParams);
        relativeLayout2.setOnClickListener(new b());
        TextView textView = new TextView(this.f26630a);
        this.f26634e = textView;
        textView.setId(y0.a());
        this.f26634e.setTextColor(-16777216);
        this.f26634e.setTextSize(1, 16.0f);
        this.f26634e.setSingleLine();
        this.f26634e.setEllipsize(TextUtils.TruncateAt.END);
        this.f26634e.setGravity(17);
        this.f26634e.setPadding(m.b(this.f26630a, 5.0f), m.b(this.f26630a, 15.33f), m.b(this.f26630a, 5.0f), m.b(this.f26630a, 16.67f));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(11);
        layoutParams2.addRule(1, relativeLayout2.getId());
        layoutParams2.rightMargin = m.a(this.f26630a, 17.67f);
        relativeLayout.addView(this.f26634e, layoutParams2);
        ImageView imageView2 = new ImageView(this.f26630a);
        imageView2.setImageDrawable(new ColorDrawable(Color.parseColor("#EEEEEE")));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, m.b(this.f26630a, 0.5f));
        layoutParams3.addRule(3, this.f26634e.getId());
        layoutParams3.leftMargin = m.b(this.f26630a, 20.33f);
        relativeLayout.addView(imageView2, layoutParams3);
        return relativeLayout;
    }

    public void a(p.h hVar) {
        this.m = hVar;
    }
}
