package ce;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import ba.k;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import java.util.List;

/* loaded from: classes3.dex */
public class h extends BaseAdapter {

    /* renamed from: b */
    public final Context f1938b;

    /* renamed from: c */
    public final List<k.d> f1939c;

    /* renamed from: d */
    public int f1940d = 0;

    public h(Context context, List<k.d> list) {
        this.f1938b = context;
        this.f1939c = list;
    }

    public void a(k.d dVar) {
        this.f1939c.add(dVar);
    }

    public k.d b(String str) {
        for (k.d dVar : this.f1939c) {
            if (dVar.f1490a.equals(str)) {
                return dVar;
            }
        }
        return null;
    }

    public k.d c(int i10) {
        return this.f1939c.get(i10);
    }

    public void d(int i10) {
        this.f1940d = i10;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<k.d> list = this.f1939c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return this.f1939c.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        if (this.f1939c.get(i10) == null) {
            return 0L;
        }
        return r3.hashCode();
    }

    @Override // android.widget.Adapter
    @SuppressLint({"InflateParams", "SetTextI18n"})
    public View getView(int i10, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f1938b).inflate(R.layout.archive_tag_item, (ViewGroup) null);
        }
        k.d dVar = (k.d) getItem(i10);
        try {
            ((TextView) view).setTextSize(14.0f);
            ((TextView) view).setText(dVar.f1490a + " (" + dVar.f1491b + "本)");
            if (i10 == this.f1940d) {
                ((TextView) view).setTextColor(ContextCompat.getColor(this.f1938b, MiConfigSingleton.b2().l0()));
            } else {
                ((TextView) view).setTextColor(ContextCompat.getColor(this.f1938b, com.martian.libmars.R.color.heavy_grey));
            }
        } catch (Exception unused) {
        }
        return view;
    }
}
