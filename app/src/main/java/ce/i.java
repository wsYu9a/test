package ce;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import java.util.List;

/* loaded from: classes3.dex */
public class i extends BaseAdapter {

    /* renamed from: b */
    public final Activity f1941b;

    /* renamed from: c */
    public final List<String> f1942c;

    /* renamed from: d */
    public int f1943d = 0;

    public static class a {

        /* renamed from: a */
        public TextView f1944a;
    }

    public i(Activity activity, List<String> list) {
        this.f1941b = activity;
        this.f1942c = list;
    }

    public String a() {
        return (String) getItem(this.f1943d);
    }

    public int b() {
        return this.f1943d;
    }

    public void c(int i10) {
        this.f1943d = i10;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<String> list = this.f1942c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return this.f1942c.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"InflateParams"})
    public View getView(int i10, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.f1941b).inflate(R.layout.book_category_item, (ViewGroup) null);
            aVar = new a();
            aVar.f1944a = (TextView) view.findViewById(R.id.tv_category_name);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.f1944a.setText((String) getItem(i10));
        if (i10 == this.f1943d) {
            aVar.f1944a.setTextColor(ContextCompat.getColor(this.f1941b, com.martian.libmars.R.color.theme_default));
        } else {
            aVar.f1944a.setTextColor(MiConfigSingleton.b2().j0());
        }
        return view;
    }
}
