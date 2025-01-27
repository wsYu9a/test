package com.martian.mibook.lib.account.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.martian.libmars.utils.n0;
import com.martian.mibook.lib.account.R;
import com.martian.mibook.lib.account.response.MartianRPWithdrawOrder;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.List;

/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: a */
    List<MartianRPWithdrawOrder> f13799a;

    /* renamed from: b */
    private final Context f13800b;

    /* renamed from: com.martian.mibook.lib.account.adapter.a$a */
    public static class C0270a {

        /* renamed from: a */
        CircleImageView f13801a;

        /* renamed from: b */
        TextView f13802b;

        /* renamed from: c */
        TextView f13803c;

        /* renamed from: d */
        TextView f13804d;

        /* renamed from: e */
        TextView f13805e;

        /* renamed from: f */
        TextView f13806f;
    }

    public a(Context context, List<MartianRPWithdrawOrder> rpWithdrawOrders) {
        this.f13800b = context;
        this.f13799a = rpWithdrawOrders;
    }

    public void a(List<MartianRPWithdrawOrder> grabUsers) {
        if (grabUsers != null) {
            this.f13799a.addAll(grabUsers);
        }
    }

    public String b(int paymentType) {
        return paymentType != 1 ? paymentType != 2 ? paymentType != 3 ? paymentType != 4 ? "支付宝" : "微信" : "淘书币" : "Q币" : "话费";
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<MartianRPWithdrawOrder> list = this.f13799a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        List<MartianRPWithdrawOrder> list = this.f13799a;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        C0270a c0270a = convertView != null ? (C0270a) convertView.getTag() : null;
        if (convertView == null || c0270a == null) {
            convertView = LayoutInflater.from(this.f13800b).inflate(R.layout.martian_all_withdraw_order_item, (ViewGroup) null);
            c0270a = new C0270a();
            c0270a.f13801a = (CircleImageView) convertView.findViewById(R.id.rd_withdraw_type);
            c0270a.f13802b = (TextView) convertView.findViewById(R.id.rd_withdraw_name);
            c0270a.f13803c = (TextView) convertView.findViewById(R.id.rd_withdraw_status);
            c0270a.f13804d = (TextView) convertView.findViewById(R.id.rd_withdraw_time);
            c0270a.f13805e = (TextView) convertView.findViewById(R.id.rd_withdraw_money);
            c0270a.f13806f = (TextView) convertView.findViewById(R.id.rd_withdraw_msg);
            convertView.setTag(c0270a);
        }
        MartianRPWithdrawOrder martianRPWithdrawOrder = (MartianRPWithdrawOrder) getItem(position);
        if (martianRPWithdrawOrder == null) {
            return null;
        }
        n0.l(this.f13800b, martianRPWithdrawOrder.getHeader(), c0270a.f13801a, R.drawable.day_img_heads);
        c0270a.f13802b.setText(martianRPWithdrawOrder.getNickname());
        c0270a.f13803c.setText(b(martianRPWithdrawOrder.getPaymentType()) + "成功提现");
        if (martianRPWithdrawOrder.getMoney() != 0) {
            c0270a.f13805e.setText(com.martian.rpauth.d.i.p(Integer.valueOf(martianRPWithdrawOrder.getMoney())));
        }
        c0270a.f13804d.setText(com.martian.rpauth.d.i.d(Long.valueOf(martianRPWithdrawOrder.getCreatedOn())));
        return convertView;
    }
}
