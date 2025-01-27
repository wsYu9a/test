package com.martian.mibook.ui.o;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.account.response.BonusPool;
import com.martian.ttbookhd.R;

/* loaded from: classes4.dex */
public class j3 extends RecyclerView.Adapter<b> {

    /* renamed from: a */
    private final Activity f14503a;

    /* renamed from: b */
    private final int f14504b = 7;

    /* renamed from: c */
    private BonusPool f14505c;

    /* renamed from: d */
    private final a f14506d;

    public interface a {
        void a();
    }

    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: a */
        private final TextView f14507a;

        /* renamed from: b */
        private final TextView f14508b;

        /* renamed from: c */
        private final LinearLayout f14509c;

        /* renamed from: d */
        private final ImageView f14510d;

        public b(@NonNull View itemView) {
            super(itemView);
            this.f14507a = (TextView) itemView.findViewById(R.id.bonus_sign_item_day);
            this.f14508b = (TextView) itemView.findViewById(R.id.bonus_sign_item_status);
            this.f14509c = (LinearLayout) itemView.findViewById(R.id.bonus_item_bg);
            this.f14510d = (ImageView) itemView.findViewById(R.id.bonus_sign_logo);
        }
    }

    public j3(Activity mContext, a listener) {
        this.f14503a = mContext;
        this.f14506d = listener;
    }

    /* renamed from: b */
    public /* synthetic */ void c(final int position, View v) {
        if (this.f14506d == null || position != this.f14505c.getCheckinDays() || this.f14505c.getCheckinToday()) {
            return;
        }
        this.f14506d.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"SetTextI18n"})
    /* renamed from: d */
    public void onBindViewHolder(@NonNull b viewHolder, final int position) {
        if (this.f14505c == null) {
            viewHolder.f14508b.setText((position + 1) + "天");
            return;
        }
        boolean I0 = MiConfigSingleton.V3().I0();
        if (position == 6) {
            viewHolder.f14507a.setText("现金");
            viewHolder.f14510d.setImageResource(R.drawable.icon_mission_money);
        } else {
            if (this.f14505c.getCoinList().size() > position) {
                viewHolder.f14507a.setText("" + this.f14505c.getCoinList().get(position));
            } else {
                viewHolder.f14507a.setText("");
            }
            viewHolder.f14510d.setImageResource(R.drawable.icon_mission_coins);
        }
        int checkinDays = this.f14505c.getCheckinDays();
        int i2 = R.drawable.border_sign_night_checkin;
        if (position == checkinDays && !this.f14505c.getCheckinToday()) {
            LinearLayout linearLayout = viewHolder.f14509c;
            if (!I0) {
                i2 = R.drawable.border_sign_day_checkin;
            }
            linearLayout.setBackgroundResource(i2);
            viewHolder.f14508b.setText(this.f14503a.getString(R.string.grab_bonus_imm));
            viewHolder.f14508b.setPadding(com.martian.libmars.d.h.b(6.0f), 0, com.martian.libmars.d.h.b(6.0f), com.martian.libmars.d.h.b(1.0f));
            viewHolder.f14508b.setTextColor(ContextCompat.getColor(this.f14503a, R.color.white));
            viewHolder.f14508b.setBackgroundResource(R.drawable.border_button_round_default);
        } else if (position < this.f14505c.getCheckinDays()) {
            viewHolder.f14509c.setBackgroundResource(I0 ? R.drawable.border_sign_night_checkined : R.drawable.border_sign_day_checkined);
            if (position == this.f14505c.getCheckinDays() - 1 && this.f14505c.getCheckinToday()) {
                viewHolder.f14508b.setText("今已领");
            } else {
                viewHolder.f14508b.setText("已领");
            }
            viewHolder.f14508b.setPadding(0, 0, 0, 0);
            viewHolder.f14508b.setTextColor(MiConfigSingleton.V3().r0());
            viewHolder.f14508b.setBackgroundColor(ContextCompat.getColor(this.f14503a, R.color.transparent));
        } else {
            LinearLayout linearLayout2 = viewHolder.f14509c;
            if (!I0) {
                i2 = R.drawable.border_sign_day_checkin;
            }
            linearLayout2.setBackgroundResource(i2);
            viewHolder.f14508b.setText((position + 1) + "天");
            viewHolder.f14508b.setPadding(0, 0, 0, 0);
            viewHolder.f14508b.setTextColor(MiConfigSingleton.V3().p0());
            viewHolder.f14508b.setBackgroundColor(ContextCompat.getColor(this.f14503a, R.color.transparent));
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j3.this.c(position, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: e */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return new b(View.inflate(this.f14503a, R.layout.bonus_sign_item, null));
    }

    public void f(BonusPool bonusPool) {
        this.f14505c = bonusPool;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 7;
    }
}
