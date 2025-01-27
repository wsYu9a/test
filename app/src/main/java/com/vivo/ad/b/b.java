package com.vivo.ad.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.vivo.ad.model.s;
import java.util.List;

/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: a */
    private Context f26574a;

    /* renamed from: b */
    private List<s> f26575b;

    /* renamed from: c */
    private a f26576c;

    public b(List list, Context context) {
        this.f26575b = list;
        this.f26574a = context;
    }

    private a a() {
        return new c(this.f26574a);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<s> list = this.f26575b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        List<s> list = this.f26575b;
        if (list == null) {
            return null;
        }
        return list.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            this.f26576c = a();
        } else {
            this.f26576c = (a) view.getTag();
        }
        this.f26576c.a(this.f26575b.get(i2));
        return this.f26576c.b();
    }
}
