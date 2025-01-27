package ce;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.martian.mibook.R;
import com.martian.mibook.lib.account.response.TYActivity;
import java.util.ArrayList;
import java.util.List;
import l9.m0;

/* loaded from: classes3.dex */
public class b extends BaseAdapter {

    /* renamed from: b */
    public final a f1919b;

    /* renamed from: c */
    public List<TYActivity> f1920c = new ArrayList();

    public interface a {
        void a(TYActivity tYActivity);
    }

    /* renamed from: ce.b$b */
    public static class C0017b {

        /* renamed from: a */
        public ImageView f1921a;

        /* renamed from: b */
        public TextView f1922b;

        /* renamed from: c */
        public TextView f1923c;
    }

    public b(a aVar) {
        this.f1919b = aVar;
    }

    public TYActivity b(int i10) {
        return this.f1920c.get(i10);
    }

    public final /* synthetic */ void c(TYActivity tYActivity, View view) {
        a aVar = this.f1919b;
        if (aVar != null) {
            aVar.a(tYActivity);
        }
    }

    public void d(List<TYActivity> list) {
        this.f1920c = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f1920c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return this.f1920c.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"InflateParams"})
    public View getView(int i10, View view, ViewGroup viewGroup) {
        C0017b c0017b;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bonus_activity_item, (ViewGroup) null);
            c0017b = new C0017b();
            c0017b.f1921a = (ImageView) view.findViewById(R.id.activity_icon);
            c0017b.f1922b = (TextView) view.findViewById(R.id.activity_title);
            c0017b.f1923c = (TextView) view.findViewById(R.id.activity_desc);
            view.setTag(c0017b);
        } else {
            c0017b = (C0017b) view.getTag();
        }
        TYActivity tYActivity = (TYActivity) getItem(i10);
        c0017b.f1922b.setText(tYActivity.getTitle());
        c0017b.f1923c.setText(tYActivity.getDesc());
        m0.k(viewGroup.getContext(), tYActivity.getIcon(), c0017b.f1921a);
        view.setOnClickListener(new View.OnClickListener() { // from class: ce.a

            /* renamed from: c */
            public final /* synthetic */ TYActivity f1918c;

            public /* synthetic */ a(TYActivity tYActivity2) {
                tYActivity = tYActivity2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                b.this.c(tYActivity, view2);
            }
        });
        return view;
    }
}
