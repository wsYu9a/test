package ce;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.ClockInfo;
import com.martian.mibook.data.theme.MiReadingTheme;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class t extends BaseAdapter {

    /* renamed from: b */
    public final List<ClockInfo> f1978b;

    /* renamed from: c */
    public boolean f1979c = true;

    public static class a {

        /* renamed from: a */
        public TextView f1980a;

        /* renamed from: b */
        public ImageView f1981b;
    }

    public t(int i10) {
        ArrayList arrayList = new ArrayList();
        this.f1978b = arrayList;
        arrayList.add(new ClockInfo(0, "不限时", i10 == 0));
        arrayList.add(new ClockInfo(1, "听完当前章节", i10 == 1));
        arrayList.add(new ClockInfo(2, "15分钟", i10 == 2));
        arrayList.add(new ClockInfo(3, "30分钟", i10 == 3));
        arrayList.add(new ClockInfo(4, "60分钟", i10 == 4));
        arrayList.add(new ClockInfo(5, "90分钟", i10 == 5));
        arrayList.add(new ClockInfo(6, "120分钟", i10 == 6));
    }

    @Override // android.widget.Adapter
    /* renamed from: a */
    public ClockInfo getItem(int i10) {
        return this.f1978b.get(i10);
    }

    public void b(boolean z10) {
        this.f1979c = z10;
    }

    public void c(int i10) {
        for (ClockInfo clockInfo : this.f1978b) {
            clockInfo.setChecked(clockInfo.getIdx() == i10);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f1978b.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"InflateParams"})
    public View getView(int i10, View view, ViewGroup viewGroup) {
        a aVar;
        int h02;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tingshu_clock_item, (ViewGroup) null);
            aVar = new a();
            aVar.f1980a = (TextView) view.findViewById(R.id.clock_name);
            aVar.f1981b = (ImageView) view.findViewById(R.id.clock_icon);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        ClockInfo item = getItem(i10);
        aVar.f1980a.setText(item.getName());
        if (this.f1979c) {
            MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
            if (item.isChecked()) {
                aVar.f1981b.setVisibility(0);
                aVar.f1981b.setColorFilter(k10.getItemColorPrimary());
                aVar.f1980a.setTextColor(k10.getItemColorPrimary());
            } else {
                aVar.f1981b.setVisibility(4);
                aVar.f1980a.setTextColor(k10.getTextColorPrimary());
            }
        } else {
            if (item.isChecked()) {
                h02 = ContextCompat.getColor(view.getContext(), com.martian.libmars.R.color.theme_default);
                aVar.f1981b.setVisibility(0);
                aVar.f1981b.setColorFilter(h02);
            } else {
                h02 = ConfigSingleton.D().h0();
                aVar.f1981b.setVisibility(4);
            }
            aVar.f1980a.setTextColor(h02);
        }
        return view;
    }
}
