package com.martian.appwall.b;

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
import com.martian.rpauth.d.i;
import java.util.List;

/* loaded from: classes2.dex */
public class b extends BaseAdapter {

    /* renamed from: a */
    List<MartianSubTask> f9668a;

    /* renamed from: b */
    private final Context f9669b;

    /* renamed from: c */
    private a f9670c;

    public interface a {
        void a(View view, int position);
    }

    /* renamed from: com.martian.appwall.b.b$b */
    public static class C0256b {

        /* renamed from: a */
        TextView f9671a;

        /* renamed from: b */
        TextView f9672b;

        /* renamed from: c */
        TextView f9673c;

        /* renamed from: d */
        TextView f9674d;
    }

    public b(Context context, List<MartianSubTask> subTasks) {
        this.f9669b = context;
        this.f9668a = subTasks;
    }

    /* renamed from: c */
    public /* synthetic */ void d(final int position, View v) {
        a aVar = this.f9670c;
        if (aVar != null) {
            aVar.a(v, position);
        }
    }

    public void a(List<MartianSubTask> martianSubTasks) {
        if (martianSubTasks != null) {
            this.f9668a.addAll(martianSubTasks);
        }
    }

    public String b(String desc) {
        return desc + "<font color='red'><b><br>[进行中]</br></b></font>";
    }

    public void e(a mOnItemStatusListener) {
        this.f9670c = mOnItemStatusListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<MartianSubTask> list = this.f9668a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        List<MartianSubTask> list = this.f9668a;
        if (list == null) {
            return null;
        }
        return list.get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {
        C0256b c0256b = convertView != null ? (C0256b) convertView.getTag() : null;
        if (convertView == null || c0256b == null) {
            convertView = LayoutInflater.from(this.f9669b).inflate(R.layout.martian_appwall_subtask_item, (ViewGroup) null);
            c0256b = new C0256b();
            c0256b.f9671a = (TextView) convertView.findViewById(R.id.subtask_desc);
            c0256b.f9672b = (TextView) convertView.findViewById(R.id.subtask_coins);
            c0256b.f9673c = (TextView) convertView.findViewById(R.id.subtask_money);
            c0256b.f9674d = (TextView) convertView.findViewById(R.id.subtask_status);
            convertView.setTag(c0256b);
        }
        MartianSubTask martianSubTask = (MartianSubTask) getItem(position);
        if (martianSubTask == null) {
            return null;
        }
        String content = !TextUtils.isEmpty(martianSubTask.getContent()) ? martianSubTask.getContent() : "";
        if ("COMPLETED".equalsIgnoreCase(martianSubTask.getStatus())) {
            c0256b.f9671a.setText(content);
            c0256b.f9674d.setText("已完成");
            c0256b.f9674d.setTextColor(ContextCompat.getColor(this.f9669b, R.color.white));
            c0256b.f9674d.setBackgroundResource(R.drawable.border_button_bonus_mission_item_checked);
        } else if ("EXECUTABLE".equalsIgnoreCase(martianSubTask.getStatus())) {
            c0256b.f9671a.setText(content);
            c0256b.f9674d.setText("进行中");
            c0256b.f9674d.setTextColor(ContextCompat.getColor(this.f9669b, R.color.day_text_color_primary));
            c0256b.f9674d.setBackgroundResource(R.drawable.border_button_bonus_mission_item_checkin);
        } else {
            c0256b.f9671a.setText(content);
            c0256b.f9674d.setText("未开始");
            c0256b.f9674d.setTextColor(ContextCompat.getColor(this.f9669b, R.color.day_text_color_unclickable));
            c0256b.f9674d.setBackgroundResource(R.drawable.border_button_bonus_mission_item_grey_line);
        }
        if (martianSubTask.getCoins() > 0) {
            c0256b.f9672b.setVisibility(0);
            c0256b.f9672b.setText("+" + martianSubTask.getCoins() + "金币");
        } else {
            c0256b.f9672b.setVisibility(8);
        }
        if (martianSubTask.getMoney() > 0) {
            c0256b.f9673c.setVisibility(0);
            c0256b.f9673c.setText("+" + i.p(Integer.valueOf(martianSubTask.getMoney())) + "元");
        } else {
            c0256b.f9673c.setVisibility(8);
        }
        c0256b.f9674d.setOnClickListener(new View.OnClickListener() { // from class: com.martian.appwall.b.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.this.d(position, view);
            }
        });
        return convertView;
    }
}
