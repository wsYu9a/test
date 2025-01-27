package com.vivo.ad.e;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.vivo.mobilead.util.g;
import com.vivo.mobilead.util.m;
import com.vivo.mobilead.util.y0;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: a */
    private ArrayList<com.vivo.ad.model.a> f26623a = new ArrayList<>();

    /* renamed from: b */
    private boolean f26624b = false;

    /* renamed from: c */
    private Context f26625c;

    static class a {

        /* renamed from: a */
        TextView f26626a;

        /* renamed from: b */
        TextView f26627b;

        /* renamed from: c */
        ImageView f26628c;

        a() {
        }
    }

    public b(Context context) {
        this.f26625c = context;
    }

    private View c(int i2, View view) {
        a aVar;
        View view2;
        if (view == null) {
            LinearLayout linearLayout = new LinearLayout(this.f26625c);
            linearLayout.setOrientation(1);
            linearLayout.setPadding(m.b(this.f26625c, 20.33f), 0, m.b(this.f26625c, 20.33f), 0);
            TextView textView = new TextView(this.f26625c);
            textView.setTextColor(Color.parseColor("#333333"));
            textView.setTextSize(1, 14.67f);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setSingleLine();
            textView.setPadding(0, m.b(this.f26625c, 10.33f), 0, 0);
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
            TextView textView2 = new TextView(this.f26625c);
            textView2.setTextColor(Color.parseColor("#999999"));
            textView2.setTextSize(1, 11.33f);
            textView2.setSingleLine();
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setPadding(0, m.b(this.f26625c, 2.33f), 0, m.b(this.f26625c, 9.33f));
            linearLayout.addView(textView2, new LinearLayout.LayoutParams(-1, -2));
            ImageView imageView = new ImageView(this.f26625c);
            imageView.setBackgroundColor(Color.parseColor("#eeeeee"));
            linearLayout.addView(imageView, new LinearLayout.LayoutParams(-1, m.b(this.f26625c, 0.5f)));
            aVar = new a();
            aVar.f26626a = textView;
            aVar.f26627b = textView2;
            aVar.f26628c = imageView;
            linearLayout.setTag(aVar);
            view2 = linearLayout;
        } else {
            aVar = (a) view.getTag();
            view2 = view;
        }
        com.vivo.ad.model.a item = getItem(i2);
        aVar.f26626a.setText(item.e());
        aVar.f26627b.setText(item.b());
        return view2;
    }

    public void a(ArrayList<com.vivo.ad.model.a> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        this.f26624b = false;
        this.f26623a.clear();
        this.f26623a.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void b(ArrayList<com.vivo.ad.model.a> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        this.f26624b = true;
        this.f26623a.clear();
        this.f26623a.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f26623a.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        com.vivo.ad.model.a item = getItem(i2);
        if (this.f26624b) {
            return 1;
        }
        if (item.a() == null || item.a().size() <= 0) {
            return !TextUtils.isEmpty(item.b()) ? 2 : 0;
        }
        return 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View a2 = getItemViewType(i2) == 3 ? a(i2, view) : getItemViewType(i2) == 2 ? c(i2, view) : b(i2, view);
        a aVar = (a) a2.getTag();
        if (i2 == getCount() - 1) {
            aVar.f26628c.setVisibility(4);
        } else {
            aVar.f26628c.setVisibility(0);
        }
        return a2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 4;
    }

    @Override // android.widget.Adapter
    public com.vivo.ad.model.a getItem(int i2) {
        return this.f26623a.get(i2);
    }

    private View a(int i2, View view) {
        a aVar;
        View view2;
        if (view == null) {
            RelativeLayout relativeLayout = new RelativeLayout(this.f26625c);
            relativeLayout.setPadding(m.b(this.f26625c, 20.33f), 0, m.b(this.f26625c, 20.33f), 0);
            ImageView imageView = new ImageView(this.f26625c);
            imageView.setId(y0.a());
            imageView.setImageDrawable(g.b(this.f26625c, "vivo_module_feedback_next.png"));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(m.b(this.f26625c, 7.67f), m.b(this.f26625c, 13.27f));
            layoutParams.addRule(11);
            layoutParams.topMargin = m.b(this.f26625c, 25.67f);
            layoutParams.bottomMargin = m.b(this.f26625c, 29.73f);
            layoutParams.leftMargin = m.b(this.f26625c, 20.53f);
            relativeLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.f26625c);
            textView.setId(y0.a());
            textView.setTextColor(Color.parseColor("#333333"));
            textView.setTextSize(1, 14.67f);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setSingleLine();
            textView.setPadding(0, m.b(this.f26625c, 14.0f), 0, 0);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(9);
            layoutParams2.addRule(10);
            layoutParams2.addRule(0, imageView.getId());
            relativeLayout.addView(textView, layoutParams2);
            TextView textView2 = new TextView(this.f26625c);
            textView2.setTextColor(Color.parseColor("#999999"));
            textView2.setTextSize(1, 11.33f);
            textView2.setSingleLine();
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setPadding(0, m.b(this.f26625c, 2.33f), 0, m.b(this.f26625c, 14.67f));
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(9);
            layoutParams3.addRule(0, imageView.getId());
            layoutParams3.addRule(3, textView.getId());
            relativeLayout.addView(textView2, layoutParams3);
            ImageView imageView2 = new ImageView(this.f26625c);
            imageView2.setBackgroundColor(Color.parseColor("#eeeeee"));
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, m.b(this.f26625c, 0.5f));
            layoutParams4.addRule(3, imageView.getId());
            relativeLayout.addView(imageView2, layoutParams4);
            aVar = new a();
            aVar.f26626a = textView;
            aVar.f26627b = textView2;
            aVar.f26628c = imageView2;
            relativeLayout.setTag(aVar);
            view2 = relativeLayout;
        } else {
            aVar = (a) view.getTag();
            view2 = view;
        }
        com.vivo.ad.model.a item = getItem(i2);
        aVar.f26626a.setText(item.e());
        aVar.f26627b.setText(item.b());
        return view2;
    }

    private View b(int i2, View view) {
        a aVar;
        View view2;
        if (view == null) {
            LinearLayout linearLayout = new LinearLayout(this.f26625c);
            linearLayout.setOrientation(1);
            linearLayout.setPadding(m.b(this.f26625c, 20.33f), 0, m.b(this.f26625c, 20.33f), 0);
            TextView textView = new TextView(this.f26625c);
            textView.setTextColor(Color.parseColor("#333333"));
            textView.setTextSize(1, 14.67f);
            textView.setSingleLine();
            textView.setGravity(3);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
            ImageView imageView = new ImageView(this.f26625c);
            imageView.setBackgroundColor(Color.parseColor("#eeeeee"));
            linearLayout.addView(imageView, new LinearLayout.LayoutParams(-1, m.b(this.f26625c, 0.5f)));
            aVar = new a();
            aVar.f26626a = textView;
            aVar.f26628c = imageView;
            linearLayout.setTag(aVar);
            view2 = linearLayout;
        } else {
            aVar = (a) view.getTag();
            view2 = view;
        }
        aVar.f26626a.setText(getItem(i2).e());
        if (this.f26624b) {
            aVar.f26626a.setPadding(0, m.b(this.f26625c, 14.33f), 0, m.b(this.f26625c, 14.33f));
        } else {
            aVar.f26626a.setPadding(0, m.b(this.f26625c, 19.33f), 0, m.b(this.f26625c, 20.33f));
        }
        return view2;
    }
}
