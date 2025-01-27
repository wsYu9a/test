package com.vivo.mobilead.unified.base.view.q;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.vivo.mobilead.unified.base.callback.g;
import java.util.List;

/* loaded from: classes4.dex */
public class a extends BaseAdapter {

    /* renamed from: a */
    private Context f29978a;

    /* renamed from: b */
    private List<com.vivo.ad.model.b> f29979b;

    /* renamed from: c */
    private g f29980c;

    /* renamed from: com.vivo.mobilead.unified.base.view.q.a$a */
    class C0623a implements g {
        C0623a() {
        }

        @Override // com.vivo.mobilead.unified.base.callback.g
        public void a(View view, int i2, int i3, int i4, int i5, int i6, boolean z) {
            if (a.this.f29980c != null) {
                a.this.f29980c.a(view, i2, i3, i4, i5, i6, z);
            }
        }
    }

    public static class b {

        /* renamed from: a */
        com.vivo.mobilead.unified.base.view.q.b f29982a;
    }

    public a(Context context, List<com.vivo.ad.model.b> list) {
        this.f29978a = context;
        this.f29979b = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<com.vivo.ad.model.b> list = this.f29979b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        List<com.vivo.ad.model.b> list = this.f29979b;
        if (list != null) {
            return list.get(i2);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        View view2;
        if (view == null) {
            com.vivo.mobilead.unified.base.view.q.b bVar2 = new com.vivo.mobilead.unified.base.view.q.b(this.f29978a, i2);
            bVar = new b();
            bVar.f29982a = bVar2;
            bVar2.setTag(bVar);
            view2 = bVar2;
        } else {
            bVar = (b) view.getTag();
            view2 = view;
        }
        com.vivo.ad.model.b bVar3 = this.f29979b.get(i2);
        if (bVar3 != null) {
            bVar.f29982a.a(bVar3);
            bVar.f29982a.setOnADWidgetItemClickListener(new C0623a());
        }
        return view2;
    }

    public void a(g gVar) {
        this.f29980c = gVar;
    }
}
