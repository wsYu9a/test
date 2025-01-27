package k8;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.martian.appwall.R;
import com.martian.appwall.response.MartianSubTask;
import com.martian.mibook.activity.appwall.AppwallTaskDetailActivity;
import java.util.List;
import oe.f;

/* loaded from: classes3.dex */
public class b extends BaseAdapter {

    /* renamed from: b */
    public List<MartianSubTask> f27729b;

    /* renamed from: c */
    public final Context f27730c;

    /* renamed from: d */
    public a f27731d;

    public interface a {
        void a(View view, int i10);
    }

    /* renamed from: k8.b$b */
    public static class C0723b {

        /* renamed from: a */
        public TextView f27732a;

        /* renamed from: b */
        public TextView f27733b;

        /* renamed from: c */
        public TextView f27734c;

        /* renamed from: d */
        public TextView f27735d;
    }

    public b(Context context, List<MartianSubTask> list) {
        this.f27730c = context;
        this.f27729b = list;
    }

    public void b(List<MartianSubTask> list) {
        if (list != null) {
            this.f27729b.addAll(list);
        }
    }

    public final /* synthetic */ void c(int i10, View view) {
        a aVar = this.f27731d;
        if (aVar != null) {
            aVar.a(view, i10);
        }
    }

    public void d(a aVar) {
        this.f27731d = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<MartianSubTask> list = this.f27729b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        List<MartianSubTask> list = this.f27729b;
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
    public View getView(int i10, View view, ViewGroup viewGroup) {
        C0723b c0723b = view != null ? (C0723b) view.getTag() : null;
        if (view == null || c0723b == null) {
            view = LayoutInflater.from(this.f27730c).inflate(R.layout.martian_appwall_subtask_item, (ViewGroup) null);
            c0723b = new C0723b();
            c0723b.f27732a = (TextView) view.findViewById(R.id.subtask_desc);
            c0723b.f27733b = (TextView) view.findViewById(R.id.subtask_coins);
            c0723b.f27734c = (TextView) view.findViewById(R.id.subtask_money);
            c0723b.f27735d = (TextView) view.findViewById(R.id.subtask_status);
            view.setTag(c0723b);
        }
        MartianSubTask martianSubTask = (MartianSubTask) getItem(i10);
        if (martianSubTask == null) {
            return null;
        }
        String content = !TextUtils.isEmpty(martianSubTask.getContent()) ? martianSubTask.getContent() : "";
        if (AppwallTaskDetailActivity.X.equalsIgnoreCase(martianSubTask.getStatus())) {
            c0723b.f27732a.setText(content);
            c0723b.f27735d.setText("已完成");
            c0723b.f27735d.setTextColor(ContextCompat.getColor(this.f27730c, com.martian.libmars.R.color.white));
            c0723b.f27735d.setBackgroundResource(R.drawable.border_button_bonus_mission_item_checked);
        } else if (AppwallTaskDetailActivity.Z.equalsIgnoreCase(martianSubTask.getStatus())) {
            c0723b.f27732a.setText(content);
            c0723b.f27735d.setText("进行中");
            c0723b.f27735d.setTextColor(ContextCompat.getColor(this.f27730c, com.martian.libmars.R.color.day_text_color_primary));
            c0723b.f27735d.setBackgroundResource(R.drawable.border_button_bonus_mission_item_checkin);
        } else {
            c0723b.f27732a.setText(content);
            c0723b.f27735d.setText("未开始");
            c0723b.f27735d.setTextColor(ContextCompat.getColor(this.f27730c, com.martian.libmars.R.color.day_text_color_unclickable));
            c0723b.f27735d.setBackgroundResource(R.drawable.border_button_bonus_mission_item_grey_line);
        }
        if (martianSubTask.getCoins() > 0) {
            c0723b.f27733b.setVisibility(0);
            c0723b.f27733b.setText("+" + martianSubTask.getCoins() + "金币");
        } else {
            c0723b.f27733b.setVisibility(8);
        }
        if (martianSubTask.getMoney() > 0) {
            c0723b.f27734c.setVisibility(0);
            c0723b.f27734c.setText("+" + f.q(Integer.valueOf(martianSubTask.getMoney())) + "元");
        } else {
            c0723b.f27734c.setVisibility(8);
        }
        c0723b.f27735d.setOnClickListener(new View.OnClickListener() { // from class: k8.a

            /* renamed from: c */
            public final /* synthetic */ int f27728c;

            public /* synthetic */ a(int i102) {
                i10 = i102;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                b.this.c(i10, view2);
            }
        });
        return view;
    }
}
