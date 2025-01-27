package be;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.martian.mibook.R;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.abs.Book;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class m extends BaseAdapter {

    /* renamed from: b */
    public List<TYBookItem> f1590b;

    /* renamed from: c */
    public final FragmentActivity f1591c;

    /* renamed from: d */
    public final Set<String> f1592d = new HashSet();

    /* renamed from: e */
    public boolean f1593e = true;

    public static class a {

        /* renamed from: a */
        public ImageView f1594a;

        /* renamed from: b */
        public TextView f1595b;

        /* renamed from: c */
        public TextView f1596c;
    }

    public m(FragmentActivity fragmentActivity) {
        this.f1591c = fragmentActivity;
        ac.a.K(fragmentActivity, "退出阅读推荐", "展示");
    }

    public boolean c() {
        return this.f1593e;
    }

    public final /* synthetic */ void d(int i10, View view) {
        je.i.H(this.f1591c, (Book) getItem(i10));
    }

    public final /* synthetic */ void e(int i10, View view) {
        je.i.H(this.f1591c, (Book) getItem(i10));
    }

    public final void f(TYBookItem tYBookItem) {
        if (this.f1592d.contains(tYBookItem.getSourceId())) {
            return;
        }
        this.f1592d.add(tYBookItem.getSourceId());
        MiConfigSingleton.b2().V1().g(0, tYBookItem.getSourceName(), tYBookItem.getSourceId(), tYBookItem.getRecommendId(), "", "展示");
    }

    public void g(List<TYBookItem> list) {
        this.f1590b = list;
        notifyDataSetChanged();
    }

    public Context getContext() {
        return this.f1591c;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<TYBookItem> list = this.f1590b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return this.f1590b.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        if (getItem(i10) == null) {
            return 0L;
        }
        return r3.hashCode();
    }

    @Override // android.widget.Adapter
    @SuppressLint({"SetTextI18n"})
    public View getView(int i10, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(this.f1593e ? R.layout.item_reading_add_shelf_recommend_book_list : R.layout.item_reading_add_shelf_recommend_book_grid, (ViewGroup) null);
            aVar = new a();
            aVar.f1594a = (ImageView) view.findViewById(R.id.iv_book_cover);
            aVar.f1595b = (TextView) view.findViewById(R.id.tv_book_name);
            aVar.f1596c = (TextView) view.findViewById(R.id.tv_book_tag);
            view.setTag(aVar);
            view.setOnClickListener(new View.OnClickListener() { // from class: be.k

                /* renamed from: c */
                public final /* synthetic */ int f1587c;

                public /* synthetic */ k(int i102) {
                    i10 = i102;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    m.this.d(i10, view2);
                }
            });
            aVar.f1594a.setOnClickListener(new View.OnClickListener() { // from class: be.l

                /* renamed from: c */
                public final /* synthetic */ int f1589c;

                public /* synthetic */ l(int i102) {
                    i10 = i102;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    m.this.e(i10, view2);
                }
            });
        } else {
            aVar = (a) view.getTag();
        }
        TYBookItem tYBookItem = (TYBookItem) getItem(i102);
        if (tYBookItem != null) {
            MiBookManager.u1(this.f1591c, tYBookItem, aVar.f1594a);
            if (!ba.l.q(tYBookItem.getBookName())) {
                aVar.f1595b.setText(tYBookItem.getBookName());
            }
            aVar.f1596c.setText(tYBookItem.getBookInfo());
            f(tYBookItem);
        }
        return view;
    }

    public void h(boolean z10) {
        this.f1593e = z10;
    }
}
