package ce;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.martian.mibook.R;
import java.util.List;

/* loaded from: classes3.dex */
public class w extends BaseAdapter {

    /* renamed from: b */
    public final List<String> f1985b;

    /* renamed from: c */
    public int f1986c = 0;

    /* renamed from: d */
    public final Context f1987d;

    public static class a {

        /* renamed from: a */
        public TextView f1988a;

        /* renamed from: b */
        public View f1989b;
    }

    public w(Context context, List<String> list) {
        this.f1987d = context;
        this.f1985b = list;
    }

    public boolean a() {
        return this.f1986c == 0;
    }

    public void b(int i10) {
        this.f1986c = i10;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<String> list = this.f1985b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        List<String> list = this.f1985b;
        if (list == null) {
            return null;
        }
        return list.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"InflateParams"})
    public View getView(int i10, View view, ViewGroup viewGroup) {
        a aVar = view != null ? (a) view.getTag() : null;
        if (view == null || aVar == null) {
            view = LayoutInflater.from(this.f1987d).inflate(R.layout.withdraw_title_item, (ViewGroup) null);
            aVar = new a();
            aVar.f1988a = (TextView) view.findViewById(R.id.withdraw_title);
            aVar.f1989b = view.findViewById(R.id.withdraw_line);
            view.setTag(aVar);
        }
        aVar.f1988a.setText((String) getItem(i10));
        if (i10 == this.f1986c) {
            aVar.f1988a.setTextColor(ContextCompat.getColor(this.f1987d, com.martian.libmars.R.color.bonus_red));
            aVar.f1989b.setVisibility(0);
        } else {
            aVar.f1988a.setTextColor(ContextCompat.getColor(this.f1987d, com.martian.libmars.R.color.heavy_grey));
            aVar.f1989b.setVisibility(4);
        }
        return view;
    }
}
