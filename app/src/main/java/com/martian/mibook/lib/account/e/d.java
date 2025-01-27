package com.martian.mibook.lib.account.e;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.martian.libmars.d.h;
import com.martian.libmars.utils.k0;
import com.martian.libmars.utils.n0;
import com.martian.libmars.utils.w0;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.R;
import com.martian.mibook.lib.account.activity.PopupLoginActivity;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.mibook.lib.account.response.MiUser;
import com.martian.rpauth.MartianIUserManager;
import com.martian.rpauth.MartianRPUserManager;
import com.martian.rpauth.d.i;
import com.martian.rpauth.response.MartianRPAccount;
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes.dex */
public class d {

    /* loaded from: classes3.dex */
    static class a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ Activity f13923a;

        a(final Activity val$activity) {
            this.f13923a = val$activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            w0.a(this.f13923a, "登录取消");
            this.f13923a.finish();
        }
    }

    public static void a(final Activity activity) {
        PopupLoginActivity.w0(activity);
    }

    public static void b(final Activity activity, int loginType, boolean checked) {
        PopupLoginActivity.x0(activity, loginType, checked);
    }

    static /* synthetic */ void d(final Activity activity, final MiUser cloudUser, View v) {
        MartianRPAccount c2 = MartianIUserManager.b().c();
        if (c2 == null || !c2.getVip().booleanValue() || c2.getVipEnd() == null || MartianRPUserManager.t() >= c2.getVipEnd().longValue()) {
            f(activity, cloudUser);
        } else {
            com.martian.mibook.lib.model.g.b.k0(activity, "游客vip-切换账号");
            k0.P(activity, "温馨提示", "当前游客账号为VIP，切换账号将导致该游客账号VIP失效，是否确认切换？", new k0.l() { // from class: com.martian.mibook.lib.account.e.b
                @Override // com.martian.libmars.utils.k0.l
                public final void a() {
                    d.f(activity, cloudUser);
                }
            });
        }
    }

    public static void e(final Activity activity, final MiUser cloudUser, final MiTaskAccount cloudAccount, final MartianRPAccount rpAccount) {
        TextView textView;
        TextView textView2;
        if (n0.C(activity)) {
            if (cloudUser == null) {
                activity.finish();
                return;
            }
            if (!MiUserManager.s().f()) {
                activity.finish();
                return;
            }
            View inflate = activity.getLayoutInflater().inflate(R.layout.popupwindow_account_switch, (ViewGroup) null);
            CircleImageView circleImageView = (CircleImageView) inflate.findViewById(R.id.guest_header);
            CircleImageView circleImageView2 = (CircleImageView) inflate.findViewById(R.id.cloud_header);
            TextView textView3 = (TextView) inflate.findViewById(R.id.guest_nickname);
            TextView textView4 = (TextView) inflate.findViewById(R.id.cloud_nickname);
            TextView textView5 = (TextView) inflate.findViewById(R.id.guest_money);
            TextView textView6 = (TextView) inflate.findViewById(R.id.cloud_money);
            TextView textView7 = (TextView) inflate.findViewById(R.id.guest_coins);
            TextView textView8 = (TextView) inflate.findViewById(R.id.cloud_coins);
            TextView textView9 = (TextView) inflate.findViewById(R.id.guest_account);
            TextView textView10 = (TextView) inflate.findViewById(R.id.cloud_account);
            MiUser miUser = (MiUser) MiUserManager.s().e();
            if (miUser != null) {
                textView2 = textView9;
                textView = textView6;
                n0.l(activity, miUser.getHeader(), circleImageView, R.drawable.day_img_heads);
                textView3.setText("游客" + miUser.getUid());
                MiTaskAccount miTaskAccount = (MiTaskAccount) MiUserManager.s().d();
                if (miTaskAccount != null) {
                    textView7.setText(miTaskAccount.getCoins() + "金币");
                    textView5.setText(i.l(Integer.valueOf(miTaskAccount.getMoney() + miTaskAccount.getCommission())) + "元现金");
                } else {
                    textView5.setText("0.00现金");
                    textView7.setText("0金币");
                }
            } else {
                textView = textView6;
                textView2 = textView9;
                textView3.setText("游客");
                textView5.setText("0.00现金");
                textView7.setText("0金币");
            }
            n0.l(activity, cloudUser.getHeader(), circleImageView2, R.drawable.day_img_heads);
            textView4.setText(cloudUser.getNickname());
            if (cloudAccount != null) {
                textView8.setText(cloudAccount.getCoins() + "金币");
                textView.setText(i.l(Integer.valueOf(cloudAccount.getMoney() + cloudAccount.getCommission())) + "元现金");
            } else {
                textView.setText("0.00现金");
                textView8.setText("0金币");
            }
            textView2.setOnClickListener(new a(activity));
            textView10.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.lib.account.e.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.d(activity, cloudUser, view);
                }
            });
            k0.d(activity, inflate, false);
        }
    }

    public static void f(Activity activity, MiUser cloudUser) {
        if (MartianIUserManager.b() != null) {
            cloudUser.setGuest(Boolean.FALSE);
            cloudUser.setWeixinBound(Boolean.TRUE);
            MartianIUserManager.b().m(cloudUser);
        }
        c.k(activity, null);
        c.l(activity, null);
        h.F().v1(c.f13919a, true);
        activity.setResult(-1);
        w0.a(activity, "登录成功");
        activity.finish();
    }
}
