package com.martian.mibook.ui.o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.e.j7;
import com.martian.mibook.lib.account.response.TYWithdrawBookCoins;
import com.martian.ttbookhd.R;
import java.util.List;

/* loaded from: classes4.dex */
public class p3 extends RecyclerView.Adapter<b> {

    /* renamed from: a */
    private final Context f14619a;

    /* renamed from: b */
    private int f14620b = 0;

    /* renamed from: c */
    private List<TYWithdrawBookCoins> f14621c;

    /* renamed from: d */
    private a f14622d;

    public interface a {
        void a(int position, TYWithdrawBookCoins tyWithdrawBookCoins);
    }

    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: a */
        ThemeLinearLayout f14623a;

        /* renamed from: b */
        TextView f14624b;

        /* renamed from: c */
        TextView f14625c;

        public b(@NonNull j7 itemBinding) {
            super(itemBinding.getRoot());
            this.f14623a = itemBinding.f12209b;
            this.f14624b = itemBinding.f12211d;
            this.f14625c = itemBinding.f12210c;
        }
    }

    public p3(Context mContext, List<TYWithdrawBookCoins> bookCoinsList) {
        this.f14619a = mContext;
        this.f14621c = bookCoinsList;
    }

    /* renamed from: b */
    public /* synthetic */ void c(final int position, final TYWithdrawBookCoins tyWithdrawBookCoins, View v) {
        a aVar = this.f14622d;
        if (aVar != null) {
            aVar.a(position, tyWithdrawBookCoins);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"SetTextI18n"})
    /* renamed from: d */
    public void onBindViewHolder(@NonNull b viewHolder, final int position) {
        String str;
        final TYWithdrawBookCoins tYWithdrawBookCoins = this.f14621c.get(position);
        if (tYWithdrawBookCoins == null) {
            return;
        }
        if (this.f14620b == position) {
            viewHolder.f14623a.setBackgroundResource(R.drawable.border_button_theme_default_middle);
            viewHolder.f14625c.setTextColor(ContextCompat.getColor(this.f14619a, R.color.white));
            viewHolder.f14624b.setTextColor(ContextCompat.getColor(this.f14619a, R.color.white));
        } else {
            viewHolder.f14623a.setBackgroundResource(MiConfigSingleton.V3().I0() ? R.drawable.border_background_withdraw_night : R.drawable.border_background_withdraw_day);
            viewHolder.f14625c.setTextColor(ContextCompat.getColor(this.f14619a, R.color.theme_default));
            viewHolder.f14624b.setTextColor(com.martian.libmars.d.h.F().r0());
        }
        TextView textView = viewHolder.f14624b;
        if (com.martian.libsupport.k.p(tYWithdrawBookCoins.getDesc())) {
            str = tYWithdrawBookCoins.getBookCoins() + this.f14619a.getString(R.string.txs_coin);
        } else {
            str = tYWithdrawBookCoins.getDesc();
        }
        textView.setText(str);
        viewHolder.f14625c.setText(com.martian.rpauth.d.i.m(tYWithdrawBookCoins.getMoney()) + "元");
        viewHolder.f14623a.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p3.this.c(position, tYWithdrawBookCoins, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: e */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return new b(j7.d(LayoutInflater.from(this.f14619a), null, false));
    }

    public void f(List<TYWithdrawBookCoins> bookCoinsList) {
        this.f14621c = bookCoinsList;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<TYWithdrawBookCoins> list = this.f14621c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void n(a onCoinsItemClickListener) {
        this.f14622d = onCoinsItemClickListener;
    }

    public void o(int position) {
        this.f14620b = position;
        notifyDataSetChanged();
    }
}
