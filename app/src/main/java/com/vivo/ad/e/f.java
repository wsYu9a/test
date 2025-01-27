package com.vivo.ad.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.vivo.mobilead.model.VivoAdError;
import com.vivo.mobilead.util.g;
import com.vivo.mobilead.util.i;
import com.vivo.mobilead.util.m;
import com.vivo.mobilead.util.y0;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class f extends BaseAdapter {

    /* renamed from: a */
    private ArrayList<com.vivo.ad.model.a> f26679a = new ArrayList<>();

    /* renamed from: b */
    private Context f26680b;

    /* renamed from: c */
    private boolean f26681c;

    /* renamed from: d */
    private int f26682d;

    static class b {

        /* renamed from: a */
        View f26686a;

        /* renamed from: b */
        ImageView f26687b;

        /* renamed from: c */
        TextView f26688c;

        /* renamed from: d */
        TextView f26689d;

        /* renamed from: e */
        ImageView f26690e;

        /* renamed from: f */
        ImageView f26691f;

        b() {
        }
    }

    public f(Context context) {
        this.f26680b = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f26679a.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        return a(i2, view);
    }

    public void a(ArrayList<com.vivo.ad.model.a> arrayList, int i2) {
        this.f26682d = i2;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        this.f26679a.clear();
        this.f26679a.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public com.vivo.ad.model.a getItem(int i2) {
        return this.f26679a.get(i2);
    }

    class a extends com.vivo.mobilead.util.b1.a.c.b {

        /* renamed from: a */
        final /* synthetic */ b f26683a;

        /* renamed from: b */
        final /* synthetic */ String f26684b;

        a(b bVar, String str) {
            this.f26683a = bVar;
            this.f26684b = str;
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(String str, Bitmap bitmap) {
            Object tag = this.f26683a.f26687b.getTag();
            if ((tag instanceof String) && TextUtils.equals((String) tag, this.f26684b)) {
                this.f26683a.f26687b.setVisibility(0);
                this.f26683a.f26687b.setImageBitmap(bitmap);
            }
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(VivoAdError vivoAdError) {
            Object tag = this.f26683a.f26687b.getTag();
            if ((tag instanceof String) && TextUtils.equals((String) tag, this.f26684b)) {
                if (f.this.f26682d == 0) {
                    this.f26683a.f26687b.setVisibility(4);
                } else {
                    this.f26683a.f26687b.setVisibility(8);
                }
            }
        }
    }

    private View a(int i2, View view) {
        b bVar;
        View view2;
        if (view == null) {
            RelativeLayout relativeLayout = new RelativeLayout(this.f26680b);
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, m.b(this.f26680b, 67.6f)));
            ImageView imageView = new ImageView(this.f26680b);
            imageView.setId(y0.a());
            imageView.setImageDrawable(g.b(this.f26680b, "vivo_module_feedback_next.png"));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(m.b(this.f26680b, 7.67f), m.b(this.f26680b, 13.27f));
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            layoutParams.leftMargin = m.b(this.f26680b, 20.53f);
            layoutParams.rightMargin = m.b(this.f26680b, 20.53f);
            relativeLayout.addView(imageView, layoutParams);
            ImageView imageView2 = new ImageView(this.f26680b);
            imageView2.setId(y0.a());
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(m.b(this.f26680b, 20.0f), m.b(this.f26680b, 20.0f));
            layoutParams2.addRule(9);
            layoutParams2.addRule(15);
            layoutParams2.leftMargin = m.b(this.f26680b, 19.0f);
            imageView2.setVisibility(4);
            relativeLayout.addView(imageView2, layoutParams2);
            LinearLayout linearLayout = new LinearLayout(this.f26680b);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            linearLayout.setGravity(16);
            TextView textView = new TextView(this.f26680b);
            textView.setId(y0.a());
            textView.setTextColor(-16777216);
            textView.setTextSize(1, 16.0f);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setSingleLine();
            linearLayout.addView(textView);
            TextView textView2 = new TextView(this.f26680b);
            textView2.setTextColor(Color.parseColor("#B2B2B2"));
            textView2.setTextSize(1, 12.0f);
            textView2.setSingleLine();
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            linearLayout.addView(textView2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(linearLayout.getLayoutParams());
            layoutParams3.addRule(1, imageView2.getId());
            layoutParams3.leftMargin = m.a(this.f26680b, 17.0f);
            layoutParams3.rightMargin = m.a(this.f26680b, 46.0f);
            relativeLayout.addView(linearLayout, layoutParams3);
            ImageView imageView3 = new ImageView(this.f26680b);
            imageView3.setBackgroundColor(Color.parseColor("#eeeeee"));
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, m.b(this.f26680b, 0.5f));
            layoutParams4.addRule(12);
            relativeLayout.addView(imageView3, layoutParams4);
            bVar = new b();
            bVar.f26688c = textView;
            bVar.f26689d = textView2;
            bVar.f26690e = imageView3;
            bVar.f26691f = imageView;
            bVar.f26686a = relativeLayout;
            bVar.f26687b = imageView2;
            relativeLayout.setTag(bVar);
            view2 = relativeLayout;
        } else {
            bVar = (b) view.getTag();
            view2 = view;
        }
        com.vivo.ad.model.a item = getItem(i2);
        if (this.f26682d == 0) {
            bVar.f26687b.setVisibility(4);
        } else {
            bVar.f26687b.setVisibility(8);
        }
        bVar.f26688c.setText(item.e());
        bVar.f26688c.setTextColor(-16777216);
        if (!TextUtils.isEmpty(item.b())) {
            bVar.f26689d.setText(item.b());
            bVar.f26689d.setVisibility(0);
        } else {
            bVar.f26689d.setVisibility(8);
        }
        String c2 = item.c();
        if (!TextUtils.isEmpty(c2)) {
            bVar.f26687b.setTag(c2);
            bVar.f26687b.setVisibility(4);
            com.vivo.mobilead.util.b1.a.b.b().a(c2, new a(bVar, c2));
        } else {
            bVar.f26687b.setTag(null);
        }
        if (item.a() != null && item.a().size() > 0) {
            bVar.f26691f.setVisibility(0);
        } else {
            bVar.f26691f.setVisibility(4);
        }
        if (i2 == getCount() - 1) {
            bVar.f26690e.setVisibility(4);
        } else {
            bVar.f26690e.setVisibility(0);
        }
        bVar.f26686a.setClickable(false);
        if (i2 == getCount() - 1 && this.f26681c) {
            bVar.f26686a.setClickable(true);
            bVar.f26687b.setColorFilter(i.a("#999999"));
            bVar.f26688c.setText("已投诉");
            bVar.f26688c.setTextColor(Color.parseColor("#999999"));
            bVar.f26689d.setVisibility(8);
            bVar.f26691f.setVisibility(4);
            bVar.f26690e.setVisibility(4);
        } else {
            bVar.f26687b.setColorFilter(-16777216);
        }
        return view2;
    }

    public void a(boolean z) {
        this.f26681c = z;
    }
}
