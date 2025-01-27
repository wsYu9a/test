package com.opos.mobad.o.d;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class a implements com.opos.mobad.o.d.d {

    /* renamed from: a */
    ListView f23086a;

    /* renamed from: b */
    c f23087b;

    /* renamed from: com.opos.mobad.o.d.a$a */
    public static class C0472a {

        /* renamed from: a */
        public final String f23088a;

        /* renamed from: b */
        public final String f23089b;

        public C0472a(String str, String str2) {
            this.f23088a = str;
            this.f23089b = str2;
        }
    }

    public static class b extends RelativeLayout {

        /* renamed from: a */
        private TextView f23090a;

        /* renamed from: b */
        private TextView f23091b;

        public b(Context context) {
            super(context);
            a(context);
        }

        private void a(Context context) {
            int a2 = com.opos.cmn.an.h.f.a.a(context, 12.0f);
            int a3 = com.opos.cmn.an.h.f.a.a(context, 24.0f);
            setPadding(a3, a2, a3, a2);
            TextView textView = new TextView(getContext());
            this.f23090a = textView;
            textView.setId(View.generateViewId());
            this.f23090a.setTextColor(Color.parseColor("#D9000000"));
            this.f23090a.setTextSize(1, 16.0f);
            this.f23090a.setGravity(17);
            this.f23090a.setGravity(51);
            this.f23090a.setLineSpacing(com.opos.cmn.an.h.f.a.a(getContext(), 4.0f), 1.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(10);
            addView(this.f23090a, layoutParams);
            TextView textView2 = new TextView(getContext());
            this.f23091b = textView2;
            textView2.setTextColor(Color.parseColor("#C4000000"));
            this.f23091b.setTextSize(1, 12.0f);
            this.f23091b.setGravity(17);
            this.f23091b.setGravity(51);
            this.f23091b.setLineSpacing(com.opos.cmn.an.h.f.a.a(getContext(), 4.0f), 1.0f);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(3, this.f23090a.getId());
            layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(context, 3.0f);
            addView(this.f23091b, layoutParams2);
        }

        public void a(C0472a c0472a) {
            TextView textView;
            int i2;
            if (c0472a == null) {
                return;
            }
            this.f23090a.setText(TextUtils.isEmpty(c0472a.f23088a) ? "" : c0472a.f23088a);
            if (TextUtils.isEmpty(c0472a.f23089b)) {
                textView = this.f23091b;
                i2 = 8;
            } else {
                this.f23091b.setText(c0472a.f23089b);
                textView = this.f23091b;
                i2 = 0;
            }
            textView.setVisibility(i2);
        }
    }

    private static class c extends BaseAdapter {

        /* renamed from: a */
        private List<C0472a> f23092a = new ArrayList();

        public void a(List<C0472a> list) {
            this.f23092a.clear();
            this.f23092a.addAll(list);
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f23092a.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return this.f23092a.get(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            C0472a c0472a = (C0472a) getItem(i2);
            d a2 = d.a(view, viewGroup);
            a2.f23093a.a(c0472a);
            return a2.f23093a;
        }
    }

    private static class d {

        /* renamed from: a */
        public final b f23093a;

        private d(b bVar) {
            this.f23093a = bVar;
        }

        public static final d a(View view, View view2) {
            if (view != null) {
                return (d) view.getTag();
            }
            b bVar = new b(view2.getContext());
            d dVar = new d(bVar);
            bVar.setTag(dVar);
            return dVar;
        }
    }

    public a(Context context) {
        ListView listView = new ListView(context);
        this.f23086a = listView;
        listView.setDividerHeight(0);
        c cVar = new c();
        this.f23087b = cVar;
        this.f23086a.setAdapter((ListAdapter) cVar);
    }

    public static List<C0472a> b(Map<String, String> map) {
        com.opos.cmn.an.f.a.b("ComplianceListView", "transformMapToList = " + map);
        ArrayList arrayList = new ArrayList();
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(new C0472a(entry.getKey(), entry.getValue()));
            }
        }
        return arrayList;
    }

    @Override // com.opos.mobad.o.d.d
    public int a() {
        return 1;
    }

    @Override // com.opos.mobad.o.d.d
    public void a(String str) {
    }

    @Override // com.opos.mobad.o.d.d
    public void a(Map<String, String> map) {
        this.f23087b.a(b(map));
    }

    @Override // com.opos.mobad.o.d.d
    public View b() {
        return this.f23086a;
    }

    @Override // com.opos.mobad.o.d.d
    public void c() {
    }
}
