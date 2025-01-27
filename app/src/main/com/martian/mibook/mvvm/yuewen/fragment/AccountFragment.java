package com.martian.mibook.mvvm.yuewen.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.appbar.AppBarLayout;
import com.kuaishou.weapon.p0.t;
import com.martian.ads.ad.AdConfig;
import com.martian.appwall.request.MartianExpLevelParams;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.activity.EnterRestartActivity;
import com.martian.mibook.activity.GenderGuideActivity;
import com.martian.mibook.activity.SettingActivity;
import com.martian.mibook.activity.account.BookCoinsTxsActivity;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.a;
import com.martian.mibook.data.ReadingRecordItem;
import com.martian.mibook.databinding.FragmentAccountNewBinding;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.mibook.lib.account.response.MiUser;
import com.martian.mibook.lib.account.response.TYActivity;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.mvvm.base.BaseMVVMActivity;
import com.martian.mibook.mvvm.base.BaseMVVMFragment;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.ErrorResult;
import com.martian.mibook.mvvm.tts.NonStickyLiveData;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.martian.mibook.mvvm.widget.ExpLevelLabel;
import com.martian.mibook.mvvm.widget.HorizontalSpaceItemDecoration;
import com.martian.mibook.mvvm.yuewen.adapter.AccountReadingRecordAdapter;
import com.martian.mibook.mvvm.yuewen.fragment.AccountFragment;
import com.martian.mibook.mvvm.yuewen.viewmodel.AccountViewModel;
import com.martian.rpauth.MartianIUserManager;
import com.martian.rpauth.response.MartianRPAccount;
import com.tencent.connect.common.Constants;
import hf.e;
import i8.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import je.i;
import je.v0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import l9.m0;
import l9.p0;
import l9.t0;
import lb.c;
import td.f;
import xi.k;
import xi.l;
import ya.e0;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0012\u0010\u0005J\u000f\u0010\u0013\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0013\u0010\u0005J\u0019\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u0005J\u000f\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u0005J\u000f\u0010\u001b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u0005R\u001b\u0010 \u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/fragment/AccountFragment;", "Lcom/martian/mibook/mvvm/base/BaseMVVMFragment;", "Lcom/martian/mibook/databinding/FragmentAccountNewBinding;", "Lcom/martian/mibook/mvvm/yuewen/viewmodel/AccountViewModel;", "<init>", "()V", "", "M1", "c1", "O1", "F1", "U1", "T1", "V1", "P1", "a1", "Y0", "Q1", "S1", "R1", "Landroid/os/Bundle;", "savedInstanceState", "q", "(Landroid/os/Bundle;)V", "i0", "k", "onResume", "onDestroyView", "Le9/c;", "Lkotlin/Lazy;", "Z0", "()Le9/c;", "rxManager", "", t.f11204d, "Z", "showTeenageGuideDialog", "Ltd/f;", "m", "Ltd/f;", "activityAdapter", "Lcom/martian/mibook/mvvm/yuewen/adapter/AccountReadingRecordAdapter;", "n", "Lcom/martian/mibook/mvvm/yuewen/adapter/AccountReadingRecordAdapter;", "recordAdapter", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nAccountFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AccountFragment.kt\ncom/martian/mibook/mvvm/yuewen/fragment/AccountFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,764:1\n262#2,2:765\n262#2,2:767\n350#2:769\n*S KotlinDebug\n*F\n+ 1 AccountFragment.kt\ncom/martian/mibook/mvvm/yuewen/fragment/AccountFragment\n*L\n720#1:765,2\n726#1:767,2\n92#1:769\n*E\n"})
/* loaded from: classes3.dex */
public final class AccountFragment extends BaseMVVMFragment<FragmentAccountNewBinding, AccountViewModel> {

    /* renamed from: k, reason: from kotlin metadata */
    @k
    public final Lazy rxManager = LazyKt.lazy(AccountFragment$rxManager$2.INSTANCE);

    /* renamed from: l */
    public boolean showTeenageGuideDialog;

    /* renamed from: m, reason: from kotlin metadata */
    @l
    public f activityAdapter;

    /* renamed from: n, reason: from kotlin metadata */
    @l
    public AccountReadingRecordAdapter recordAdapter;

    public static final class a implements c.h {
        public a() {
        }

        @Override // lb.c.h
        public void a(@k MiUser miUser) {
            Intrinsics.checkNotNullParameter(miUser, "miUser");
            MartianIUserManager.b().l(miUser);
            AccountFragment.this.Q1();
        }

        @Override // lb.c.h
        public void b(boolean z10) {
        }

        @Override // lb.c.h
        public void onResultError(@k x8.c errorResult) {
            Intrinsics.checkNotNullParameter(errorResult, "errorResult");
            t0.b(AccountFragment.this.getActivity(), errorResult.d());
        }
    }

    public static final class b extends d8.b {
        public b() {
        }

        @Override // d8.b, d8.a
        public void a() {
            t0.b(AccountFragment.this.getActivity(), "广告请求失败");
        }

        @Override // d8.b, d8.a
        public void k(@k AdConfig adConfig, boolean z10) {
            Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        }
    }

    public static final class c extends d8.b {
        public c() {
        }

        @Override // d8.b, d8.a
        public void a() {
            t0.b(AccountFragment.this.getActivity(), "广告请求失败");
        }

        @Override // d8.b, d8.a
        public void k(@k AdConfig adConfig, boolean z10) {
            Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        }
    }

    public static final class d implements f.a {
        public d() {
        }

        @Override // td.f.a
        public void a(@l TYActivity tYActivity) {
            MiConfigSingleton.b2().e2().W(AccountFragment.this.getActivity(), tYActivity, AccountFragment.this.Z0(), "我的-福利活动");
        }
    }

    public static final void A1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void B1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void C1(AccountFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String obj = ((FragmentAccountNewBinding) this$0.n()).tvUserId.getText().toString();
        if (obj.length() > 0) {
            ba.l.f(this$0.getContext(), obj);
            t0.b(this$0.getContext(), obj + ExtKt.c("已复制到剪贴板"));
        }
    }

    public static final void D1(AccountFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        lb.c.k(this$0.getActivity(), "", this$0.new a());
    }

    public static final void E1(AccountFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.k(this$0.getContext(), "账户管理");
        if (MiConfigSingleton.b2().G1().j(this$0.getActivity(), 1022)) {
            i.c0(this$0.getActivity(), 0, e0.f33140b + e.f26694a + MiConfigSingleton.b2().t2());
        }
    }

    public static final void G1(AccountFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MiConfigSingleton.b2().H1().D(this$0.getActivity(), new a.n() { // from class: vd.a
            public /* synthetic */ a() {
            }

            @Override // com.martian.mibook.application.a.n
            public final void a() {
                AccountFragment.H1(AccountFragment.this);
            }
        });
    }

    public static final void H1(AccountFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q1();
    }

    public static final void I1(AccountFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new AlertDialog.Builder(this$0.getActivity()).setTitle("广告测试").setCancelable(true).setItems(new String[]{"开屏", "插屏", "激励视频", "信息流", "穿山甲测试工具", "点击拷贝OAID", "点击拷贝DeviceId", "合规状态:" + MiConfigSingleton.b2().C2()}, new DialogInterface.OnClickListener() { // from class: vd.e0
            public /* synthetic */ e0() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                AccountFragment.J1(AccountFragment.this, dialogInterface, i10);
            }
        }).show();
    }

    public static final void J1(AccountFragment this$0, DialogInterface dialogInterface, int i10) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        switch (i10) {
            case 0:
                Intent intent = new Intent(this$0.getActivity(), (Class<?>) EnterRestartActivity.class);
                FragmentActivity activity = this$0.getActivity();
                if (activity != null) {
                    activity.startActivity(intent);
                    break;
                }
                break;
            case 1:
                MiConfigSingleton.b2().H1().H0(this$0.getActivity(), e0.U, this$0.new b());
                break;
            case 2:
                MiConfigSingleton.b2().H1().I0(this$0.getActivity(), true, this$0.new c());
                break;
            case 3:
                MiConfigSingleton.b2().u2().J(this$0.getActivity(), "本次阅读奖励", 0, 100);
                break;
            case 4:
                try {
                    Class<?> cls = Class.forName("com.bytedance.tools.ui.ToolsActivity");
                    if (Activity.class.isAssignableFrom(cls)) {
                        Intent intent2 = new Intent(this$0.getActivity(), cls);
                        FragmentActivity activity2 = this$0.getActivity();
                        if (activity2 != null) {
                            activity2.startActivity(intent2);
                            break;
                        }
                    }
                } catch (ClassNotFoundException e10) {
                    t0.b(this$0.getActivity(), "测试工具不可用" + e10);
                    return;
                } catch (Exception e11) {
                    t0.b(this$0.getActivity(), "测试工具不可用" + e11);
                    return;
                }
                break;
            case 5:
                String M = ConfigSingleton.D().M();
                Intrinsics.checkNotNull(M);
                if (M.length() <= 0) {
                    t0.b(this$0.getActivity(), "拷贝失败，没有oaid");
                    break;
                } else {
                    p0.b("oaid:" + M);
                    ba.l.f(this$0.getContext(), M);
                    t0.b(this$0.getActivity(), "拷贝成功");
                    break;
                }
            case 6:
                String y10 = ConfigSingleton.D().y();
                Intrinsics.checkNotNull(y10);
                if (y10.length() <= 0) {
                    t0.b(this$0.getActivity(), "拷贝失败，没有deviceId");
                    break;
                } else {
                    p0.b("deviceId:" + y10);
                    ba.l.f(this$0.getContext(), y10);
                    t0.b(this$0.getActivity(), "拷贝成功");
                    break;
                }
            case 7:
                MiConfigSingleton.b2().e3(!MiConfigSingleton.b2().C2() ? 1 : 0);
                break;
        }
    }

    public static final void K1(AccountFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new AlertDialog.Builder(this$0.getActivity()).setTitle("功能测试").setCancelable(true).setItems(new String[]{"deeplink跳转淘小说", "切换成付费用户", "跳转快应用", "金币弹窗", "deeplink跳转到全本小说", "修改baseUrl", "vip开通弹窗"}, new DialogInterface.OnClickListener() { // from class: vd.a0
            public /* synthetic */ a0() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                AccountFragment.L1(AccountFragment.this, dialogInterface, i10);
            }
        }).show();
    }

    public static final void L1(AccountFragment this$0, DialogInterface dialogInterface, int i10) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i10 == 0) {
            g.z(this$0.getActivity(), "ttbook://m.taoyuewenhua.com/homepage?sourceName=tf&sourceId=yw_22292070000065702");
            return;
        }
        if (i10 == 1) {
            this$0.I().r();
            return;
        }
        if (i10 == 2) {
            g.z(this$0.getActivity(), "hap://app/com.qidian.wxcp.moxiang/pages/read?channel_id=spread_240207103733434pxc74609&bookid=24776721509993806&ccid=66509508175777184&adsource=tt&adtype=pullup");
            return;
        }
        if (i10 == 3) {
            MiConfigSingleton.b2().u2().S(this$0.getActivity(), "本次阅读奖励", 0, 100);
        } else if (i10 == 4) {
            g.z(this$0.getActivity(), "qcbook://m.taoyuewenhua.com/homepage?sourceName=tf&sourceId=yw_26039933601117204&goReading=true&recommendId=abc");
        } else {
            if (i10 != 5) {
                return;
            }
            s8.b.f30606b = !s8.b.f30606b;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void N1(int i10, int i11, int i12, AccountFragment this$0, int i13, AppBarLayout appBarLayout, int i14) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        float abs = 1.0f - (Math.abs(i14) / (i10 - (i11 / 2)));
        float f10 = 1.0f - abs;
        float f11 = i12 * f10;
        int height = ((FragmentAccountNewBinding) this$0.n()).llUserName.getHeight();
        ConstraintLayout llUserName = ((FragmentAccountNewBinding) this$0.n()).llUserName;
        Intrinsics.checkNotNullExpressionValue(llUserName, "llUserName");
        ViewGroup.LayoutParams layoutParams = llUserName.getLayoutParams();
        ((FragmentAccountNewBinding) this$0.n()).ivAvatar.setScaleX(abs);
        ((FragmentAccountNewBinding) this$0.n()).ivAvatar.setScaleY(abs);
        float f12 = -f11;
        ((FragmentAccountNewBinding) this$0.n()).ivAvatar.setTranslationX(f12);
        float f13 = f12 * 2;
        ((FragmentAccountNewBinding) this$0.n()).llUserName.setTranslationX(f13);
        ((FragmentAccountNewBinding) this$0.n()).llUserName.setTranslationY((height + ((layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null) != null ? r2.topMargin : 0)) * f10);
        ((FragmentAccountNewBinding) this$0.n()).rlUserId.setTranslationX(f13);
        ((FragmentAccountNewBinding) this$0.n()).rlUserId.setAlpha(1.0f - (Math.abs(i14) / i13));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void O1() {
        if (MiConfigSingleton.b2().C2() && MiConfigSingleton.b2().Y() > 1) {
            this.showTeenageGuideDialog = true;
        }
        if (MiConfigSingleton.b2().N2()) {
            ((FragmentAccountNewBinding) n()).accountMyComment.setVisibility(0);
        } else {
            ((FragmentAccountNewBinding) n()).accountMyComment.setVisibility(8);
        }
        ((FragmentAccountNewBinding) n()).rvReadingRecord.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        ((FragmentAccountNewBinding) n()).rvReadingRecord.addItemDecoration(new HorizontalSpaceItemDecoration(ConfigSingleton.i(12.0f)));
        F1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetTextI18n"})
    private final void S1() {
        MiUser p10 = MiConfigSingleton.b2().G1().p();
        if (p10 == null) {
            return;
        }
        if (ba.l.q(p10.getNickname())) {
            ((FragmentAccountNewBinding) n()).tvUserNickname.setText(getString(R.string.nickname));
        } else {
            ((FragmentAccountNewBinding) n()).tvUserNickname.setText(p10.getNickname());
        }
        if (StringsKt.equals(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, MiConfigSingleton.b2().t2(), true)) {
            ((FragmentAccountNewBinding) n()).rlUserId.setVisibility(8);
        } else {
            if (MiConfigSingleton.b2().N2()) {
                ((FragmentAccountNewBinding) n()).tvUserLoginTips.setVisibility(8);
                ((FragmentAccountNewBinding) n()).llUserIdView.setVisibility(0);
                ((FragmentAccountNewBinding) n()).tvUserId.setText(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS + MiConfigSingleton.b2().t2());
                if (p10.getWeixinBound()) {
                    ((FragmentAccountNewBinding) n()).tvBindWechat.setVisibility(8);
                    ((FragmentAccountNewBinding) n()).llUserId.setVisibility(0);
                } else {
                    ((FragmentAccountNewBinding) n()).tvBindWechat.setVisibility(0);
                    ((FragmentAccountNewBinding) n()).llUserId.setVisibility(8);
                }
            } else {
                ((FragmentAccountNewBinding) n()).llUserIdView.setVisibility(8);
                ((FragmentAccountNewBinding) n()).tvBindWechat.setVisibility(8);
                ((FragmentAccountNewBinding) n()).tvUserLoginTips.setVisibility(0);
                ((FragmentAccountNewBinding) n()).tvUserLoginTips.setText(getString(R.string.login_click_guide));
            }
            ((FragmentAccountNewBinding) n()).rlUserId.setVisibility(0);
        }
        m0.l(getContext(), p10.getHeader(), ((FragmentAccountNewBinding) n()).ivAvatar, com.martian.mibook.lib.account.R.drawable.day_img_heads);
        MiTaskAccount p22 = MiConfigSingleton.b2().p2();
        if (p22 == null) {
            ((FragmentAccountNewBinding) n()).mcDuration.setNumberText(0);
            ((FragmentAccountNewBinding) n()).mcMoney.j(0.0f, 2);
            ((FragmentAccountNewBinding) n()).mcCommission.j(0.0f, 2);
            ((FragmentAccountNewBinding) n()).mcCommissionView.setVisibility(0);
            ExpLevelLabel accountExpLevel = ((FragmentAccountNewBinding) n()).accountExpLevel;
            Intrinsics.checkNotNullExpressionValue(accountExpLevel, "accountExpLevel");
            accountExpLevel.setVisibility(8);
            return;
        }
        ((FragmentAccountNewBinding) n()).mcDuration.setNumberText(p22.getCoins());
        if (p22.getShowCommission()) {
            ((FragmentAccountNewBinding) n()).mcMoney.j(oe.f.m(Integer.valueOf(p22.getMoney())), 2);
            ((FragmentAccountNewBinding) n()).mcCommission.j(oe.f.m(Integer.valueOf(p22.getCommission())), 2);
            ((FragmentAccountNewBinding) n()).mcCommissionView.setVisibility(0);
        } else {
            ((FragmentAccountNewBinding) n()).mcMoney.j(oe.f.m(Integer.valueOf(p22.getMoney() + p22.getCommission())), 2);
            ((FragmentAccountNewBinding) n()).mcCommissionView.setVisibility(8);
        }
        ((FragmentAccountNewBinding) n()).accountExpLevel.setLevel(p22.getExpLevel());
        ExpLevelLabel accountExpLevel2 = ((FragmentAccountNewBinding) n()).accountExpLevel;
        Intrinsics.checkNotNullExpressionValue(accountExpLevel2, "accountExpLevel");
        accountExpLevel2.setVisibility(0);
    }

    public static final void b1(AccountFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Y0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void c1() {
        NonStickyLiveData<ErrorResult> Z;
        NonStickyLiveData<MiTaskAccount> a02;
        NonStickyLiveData<MartianRPAccount> Y;
        AppViewModel G = G();
        if (G != null && (Y = G.Y()) != null) {
            Y.observe(this, new Observer() { // from class: vd.f0
                public /* synthetic */ f0() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AccountFragment.d1(Function1.this, obj);
                }
            });
        }
        AppViewModel G2 = G();
        if (G2 != null && (a02 = G2.a0()) != null) {
            a02.observe(this, new Observer() { // from class: vd.h
                public /* synthetic */ h() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AccountFragment.o1(Function1.this, obj);
                }
            });
        }
        AppViewModel G3 = G();
        if (G3 != null && (Z = G3.Z()) != null) {
            Z.observe(this, new Observer() { // from class: vd.r
                public /* synthetic */ r() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AccountFragment.y1(Function1.this, obj);
                }
            });
        }
        I().u().observe(this, new Observer() { // from class: vd.s
            public /* synthetic */ s() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AccountFragment.z1(Function1.this, obj);
            }
        });
        I().s().observe(this, new Observer() { // from class: vd.t
            public /* synthetic */ t() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AccountFragment.A1(Function1.this, obj);
            }
        });
        I().t().observe(this, new Observer() { // from class: vd.u
            public /* synthetic */ u() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AccountFragment.B1(Function1.this, obj);
            }
        });
        ((FragmentAccountNewBinding) n()).llUserId.setOnClickListener(new View.OnClickListener() { // from class: vd.v
            public /* synthetic */ v() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountFragment.C1(AccountFragment.this, view);
            }
        });
        ((FragmentAccountNewBinding) n()).tvBindWechat.setOnClickListener(new View.OnClickListener() { // from class: vd.x
            public /* synthetic */ x() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountFragment.D1(AccountFragment.this, view);
            }
        });
        ((FragmentAccountNewBinding) n()).cslUserInfo.setOnClickListener(new View.OnClickListener() { // from class: vd.y
            public /* synthetic */ y() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountFragment.E1(AccountFragment.this, view);
            }
        });
        ((FragmentAccountNewBinding) n()).accountNightMode.setOnClickListener(new View.OnClickListener() { // from class: vd.z
            public /* synthetic */ z() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountFragment.e1(AccountFragment.this, view);
            }
        });
        ((FragmentAccountNewBinding) n()).accountSetting.setOnClickListener(new View.OnClickListener() { // from class: vd.g0
            public /* synthetic */ g0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountFragment.f1(AccountFragment.this, view);
            }
        });
        ((FragmentAccountNewBinding) n()).mcDurationView.setOnClickListener(new View.OnClickListener() { // from class: vd.h0
            public /* synthetic */ h0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountFragment.g1(AccountFragment.this, view);
            }
        });
        ((FragmentAccountNewBinding) n()).mcMoneyView.setOnClickListener(new View.OnClickListener() { // from class: vd.i0
            public /* synthetic */ i0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountFragment.h1(AccountFragment.this, view);
            }
        });
        ((FragmentAccountNewBinding) n()).accountIncomeView.setOnClickListener(new View.OnClickListener() { // from class: vd.j0
            public /* synthetic */ j0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountFragment.i1(AccountFragment.this, view);
            }
        });
        ((FragmentAccountNewBinding) n()).mcCommissionView.setOnClickListener(new View.OnClickListener() { // from class: vd.b
            public /* synthetic */ b() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountFragment.j1(AccountFragment.this, view);
            }
        });
        ((FragmentAccountNewBinding) n()).accountBookCoinsView.setOnClickListener(new View.OnClickListener() { // from class: vd.c
            public /* synthetic */ c() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountFragment.k1(AccountFragment.this, view);
            }
        });
        ((FragmentAccountNewBinding) n()).accountBookCoinsRecharge.setOnClickListener(new View.OnClickListener() { // from class: vd.d
            public /* synthetic */ d() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountFragment.l1(AccountFragment.this, view);
            }
        });
        ((FragmentAccountNewBinding) n()).accountReadingRecordView.setOnClickListener(new View.OnClickListener() { // from class: vd.e
            public /* synthetic */ e() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountFragment.m1(AccountFragment.this, view);
            }
        });
        ((FragmentAccountNewBinding) n()).accountWechatCustomer.setOnClickListener(new View.OnClickListener() { // from class: vd.f
            public /* synthetic */ f() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountFragment.n1(AccountFragment.this, view);
            }
        });
        ((FragmentAccountNewBinding) n()).accountGenderGuide.setOnClickListener(new View.OnClickListener() { // from class: vd.g
            public /* synthetic */ g() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountFragment.p1(AccountFragment.this, view);
            }
        });
        ((FragmentAccountNewBinding) n()).accountFeedback.setOnClickListener(new View.OnClickListener() { // from class: vd.i
            public /* synthetic */ i() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountFragment.q1(AccountFragment.this, view);
            }
        });
        ((FragmentAccountNewBinding) n()).accountMessageCenter.setOnClickListener(new View.OnClickListener() { // from class: vd.j
            public /* synthetic */ j() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountFragment.r1(AccountFragment.this, view);
            }
        });
        ((FragmentAccountNewBinding) n()).accountClearCache.setOnClickListener(new View.OnClickListener() { // from class: vd.k
            public /* synthetic */ k() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountFragment.s1(AccountFragment.this, view);
            }
        });
        ((FragmentAccountNewBinding) n()).accountVipView.setOnClickListener(new View.OnClickListener() { // from class: vd.m
            public /* synthetic */ m() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountFragment.t1(AccountFragment.this, view);
            }
        });
        ((FragmentAccountNewBinding) n()).accountVipButton.setOnClickListener(new View.OnClickListener() { // from class: vd.n
            public /* synthetic */ n() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountFragment.u1(AccountFragment.this, view);
            }
        });
        ((FragmentAccountNewBinding) n()).accountCheckUpdate.setOnClickListener(new View.OnClickListener() { // from class: vd.o
            public /* synthetic */ o() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountFragment.v1(AccountFragment.this, view);
            }
        });
        ((FragmentAccountNewBinding) n()).accountMyComment.setOnClickListener(new View.OnClickListener() { // from class: vd.p
            public /* synthetic */ p() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountFragment.w1(AccountFragment.this, view);
            }
        });
        ((FragmentAccountNewBinding) n()).accountExpLevel.setOnClickListener(new View.OnClickListener() { // from class: vd.q
            public /* synthetic */ q() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountFragment.x1(AccountFragment.this, view);
            }
        });
    }

    public static final void d1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void e1(AccountFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.k(this$0.getContext(), MiConfigSingleton.b2().H0() ? "切换夜间" : "切换日间");
        MiConfigSingleton.b2().d1(!ConfigSingleton.D().H0());
        this$0.T1();
        FragmentActivity activity = this$0.getActivity();
        BaseMVVMActivity baseMVVMActivity = activity instanceof BaseMVVMActivity ? (BaseMVVMActivity) activity : null;
        if (baseMVVMActivity != null) {
            baseMVVMActivity.A0();
        }
        AppViewModel G = this$0.G();
        if (G != null) {
            G.v0(true);
        }
    }

    public static final void f1(AccountFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.k(this$0.getContext(), "设置中心");
        Intent intent = new Intent(this$0.getContext(), (Class<?>) SettingActivity.class);
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.startActivityForResult(intent, 10002);
        }
    }

    public static final void g1(AccountFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (MiConfigSingleton.b2().G1().f(this$0.getActivity())) {
            ac.a.k(this$0.getContext(), "金币收入");
            kc.b.n(0, "我的-金币收入");
        }
    }

    public static final void h1(AccountFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (MiConfigSingleton.b2().G1().f(this$0.getActivity())) {
            ac.a.k(this$0.getContext(), "零钱收入");
            kc.b.n(0, "我的-零钱收入");
        }
    }

    public static final void i1(AccountFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (MiConfigSingleton.b2().G1().f(this$0.getActivity())) {
            ac.a.k(this$0.getContext(), "现金收入");
            kc.b.n(0, "我的-现金收入");
        }
    }

    public static final void j1(AccountFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (MiConfigSingleton.b2().G1().f(this$0.getActivity())) {
            ac.a.k(this$0.getContext(), "佣金收入");
            kc.b.n(1, "我的-佣金收入");
        }
    }

    public static final void k1(AccountFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (MiConfigSingleton.b2().G1().f(this$0.getActivity())) {
            ac.a.k(this$0.getContext(), "书币账户");
            this$0.startActivity(new Intent(this$0.getContext(), (Class<?>) BookCoinsTxsActivity.class));
        }
    }

    public static final void l1(AccountFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.k(this$0.getContext(), "充值书币");
        i.X(this$0.getActivity());
    }

    public static final void m1(AccountFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.k(this$0.getContext(), "阅读记录");
        kc.b.u();
    }

    public static final void n1(AccountFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.k(this$0.getContext(), "微信客服");
        if (!g.p(this$0.getContext())) {
            t0.b(this$0.getContext(), ExtKt.c("请先安装微信"));
            return;
        }
        String wechatCustomerUrl = MiConfigSingleton.b2().c2().getWechatCustomerUrl();
        if (TextUtils.isEmpty(wechatCustomerUrl)) {
            t0.b(this$0.getContext(), ExtKt.c("抱歉，暂不支持"));
            return;
        }
        Intrinsics.checkNotNull(wechatCustomerUrl);
        if (StringsKt.contains$default((CharSequence) wechatCustomerUrl, (CharSequence) "{{UID}}", false, 2, (Object) null)) {
            Intrinsics.checkNotNull(wechatCustomerUrl);
            String t22 = MiConfigSingleton.b2().t2();
            Intrinsics.checkNotNullExpressionValue(t22, "getUserId(...)");
            wechatCustomerUrl = StringsKt.replace$default(wechatCustomerUrl, "{{UID}}", t22, false, 4, (Object) null);
        }
        MiWebViewActivity.J5(this$0.getActivity(), wechatCustomerUrl, false, "", false, "", false, true);
    }

    public static final void o1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void p1(AccountFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.k(this$0.getContext(), "性别偏好");
        GenderGuideActivity.k3(this$0.getActivity());
    }

    public static final void q1(AccountFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.k(this$0.getContext(), "意见反馈");
        i.L(this$0.getActivity());
    }

    public static final void r1(AccountFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.k(this$0.getContext(), "消息中心");
        i.P(this$0.getActivity());
    }

    public static final void s1(AccountFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        if (context != null) {
            ac.a.k(context, "我的-清理缓存");
            this$0.I().p(context);
        }
    }

    public static final void t1(AccountFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        i.d0(this$0.getActivity(), "我的");
    }

    public static final void u1(AccountFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        i.d0(this$0.getActivity(), "我的");
    }

    public static final void v1(AccountFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.k(this$0.getContext(), "我的-检查更新-原生");
        this$0.I().o(true);
    }

    public static final void w1(AccountFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.k(this$0.getContext(), "我的-我的评论");
        i.c0(this$0.getActivity(), 0, e0.f33140b + e.f26694a + MiConfigSingleton.b2().t2());
    }

    public static final void x1(AccountFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new MartianExpLevelParams().setNight_mode(Boolean.valueOf(ConfigSingleton.D().H0()));
        MiWebViewActivity.startWebViewActivity(this$0.getActivity(), new MartianExpLevelParams().toHttpUrl(z5.k.f33694e));
    }

    public static final void y1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void z1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void F1() {
        if (MiConfigSingleton.b2().B0()) {
            ((FragmentAccountNewBinding) n()).accountMoreServiceView.setVisibility(0);
            ((FragmentAccountNewBinding) n()).accountTestMode.setVisibility(0);
            ((FragmentAccountNewBinding) n()).accountAdTest.setVisibility(0);
            ((FragmentAccountNewBinding) n()).accountFunctionTest.setVisibility(0);
            ((FragmentAccountNewBinding) n()).accountTestMode.setOnClickListener(new View.OnClickListener() { // from class: vd.l
                public /* synthetic */ l() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AccountFragment.G1(AccountFragment.this, view);
                }
            });
            ((FragmentAccountNewBinding) n()).accountAdTest.setOnClickListener(new View.OnClickListener() { // from class: vd.w
                public /* synthetic */ w() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AccountFragment.I1(AccountFragment.this, view);
                }
            });
            ((FragmentAccountNewBinding) n()).accountFunctionTest.setOnClickListener(new View.OnClickListener() { // from class: vd.d0
                public /* synthetic */ d0() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AccountFragment.K1(AccountFragment.this, view);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void M1() {
        com.gyf.immersionbar.d.B2(this, ((FragmentAccountNewBinding) n()).appbarLayout);
        ((FragmentAccountNewBinding) n()).nsvContent.setPadding(0, 0, 0, com.gyf.immersionbar.d.K0(this));
        U1();
        ((FragmentAccountNewBinding) n()).appbarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new AppBarLayout.OnOffsetChangedListener() { // from class: vd.c0

            /* renamed from: a */
            public final /* synthetic */ int f31315a;

            /* renamed from: b */
            public final /* synthetic */ int f31316b;

            /* renamed from: c */
            public final /* synthetic */ int f31317c;

            /* renamed from: d */
            public final /* synthetic */ AccountFragment f31318d;

            /* renamed from: e */
            public final /* synthetic */ int f31319e;

            public /* synthetic */ c0(int i10, int i11, int i12, AccountFragment this, int i13) {
                i10 = i10;
                i11 = i11;
                i12 = i12;
                this = this;
                i13 = i13;
            }

            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public final void onOffsetChanged(AppBarLayout appBarLayout, int i10) {
                AccountFragment.N1(i10, i11, i12, this, i13, appBarLayout, i10);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void P1() {
        if (MiConfigSingleton.b2().C2()) {
            return;
        }
        List<TYActivity> L = MiConfigSingleton.b2().e2().L();
        if (L == null || L.isEmpty()) {
            ((FragmentAccountNewBinding) n()).accountActivitiesView.setVisibility(8);
            return;
        }
        Iterator<TYActivity> it = L.iterator();
        while (it.hasNext()) {
            TYActivity next = it.next();
            if (next.isInterAdActivity() || ba.l.q(next.getIcon())) {
                it.remove();
            } else {
                ac.a.l(getActivity(), "我的-福利活动-" + next.getTitle() + "-曝光");
            }
        }
        if (L.isEmpty()) {
            ((FragmentAccountNewBinding) n()).accountActivitiesView.setVisibility(8);
            return;
        }
        ((FragmentAccountNewBinding) n()).accountActivitiesView.setVisibility(0);
        if (this.activityAdapter == null) {
            this.activityAdapter = new f();
            int i10 = 2;
            if (L.size() > 2 && L.size() % 3 != 1) {
                i10 = 3;
            }
            ((FragmentAccountNewBinding) n()).accountActivities.setNumColumns(i10);
            ((FragmentAccountNewBinding) n()).accountActivities.setAdapter((ListAdapter) this.activityAdapter);
            ((FragmentAccountNewBinding) n()).accountActivities.setFocusable(false);
            f fVar = this.activityAdapter;
            if (fVar != null) {
                fVar.d(new d());
            }
        }
        f fVar2 = this.activityAdapter;
        if (fVar2 != null) {
            fVar2.c(L);
        }
    }

    public final void Q1() {
        if (getContext() != null) {
            if (MiConfigSingleton.b2().F2()) {
                S1();
            } else {
                R1();
            }
            V1();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetTextI18n"})
    public final void R1() {
        ((FragmentAccountNewBinding) n()).tvUserNickname.setText(getString(R.string.login_click));
        ((FragmentAccountNewBinding) n()).rlUserId.setVisibility(0);
        ((FragmentAccountNewBinding) n()).llUserIdView.setVisibility(8);
        ((FragmentAccountNewBinding) n()).tvBindWechat.setVisibility(8);
        ((FragmentAccountNewBinding) n()).tvUserLoginTips.setVisibility(0);
        ((FragmentAccountNewBinding) n()).tvUserLoginTips.setText(getString(R.string.login_click_hint));
        ((FragmentAccountNewBinding) n()).mcDuration.setText("--");
        ((FragmentAccountNewBinding) n()).mcMoney.setText("--");
        ((FragmentAccountNewBinding) n()).mcCommission.setText("--");
        ((FragmentAccountNewBinding) n()).ivAvatar.setImageResource(com.martian.mibook.lib.account.R.drawable.day_img_heads);
        ((FragmentAccountNewBinding) n()).mcCommissionView.setVisibility(0);
        ((FragmentAccountNewBinding) n()).accountBookCoins.setText("--");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T1() {
        ((FragmentAccountNewBinding) n()).accountNightMode.setImageResource(MiConfigSingleton.b2().H0() ? R.drawable.icon_account_day_mode : R.drawable.icon_account_night_mode);
        U1();
        V1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void U1() {
        if (ConfigSingleton.D().A0()) {
            ((FragmentAccountNewBinding) n()).ivAccountTopBg.setAlpha(0.0f);
        } else {
            ((FragmentAccountNewBinding) n()).ivAccountTopBg.setAlpha(1.0f);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetTextI18n"})
    public final void V1() {
        String c10;
        boolean K2 = MiConfigSingleton.b2().K2();
        boolean L2 = MiConfigSingleton.b2().L2();
        long v22 = MiConfigSingleton.b2().v2();
        ((FragmentAccountNewBinding) n()).accountVipView.setVisibility(0);
        if (!K2 || L2) {
            ((FragmentAccountNewBinding) n()).accountVipBg.setImageResource(R.drawable.icon_bg_vip);
            Context context = getContext();
            if (context != null) {
                ((FragmentAccountNewBinding) n()).accountVipDesc.setTextColor(ContextCompat.getColor(context, com.martian.libmars.R.color.vip_text_color_primary));
                ((FragmentAccountNewBinding) n()).accountVipDesc.setText(ExtKt.c("免广告·听书"));
            }
            ((FragmentAccountNewBinding) n()).accountVipButton.setText(getString(R.string.active_vip));
            ((FragmentAccountNewBinding) n()).accountVipButton.setBackgroundResource(com.martian.mibook.lib.account.R.drawable.border_background_bonus_white);
            ((FragmentAccountNewBinding) n()).accountNightMode.setEnableFilter(true);
            ((FragmentAccountNewBinding) n()).accountNightMode.p();
            ((FragmentAccountNewBinding) n()).accountSetting.setEnableFilter(true);
            ((FragmentAccountNewBinding) n()).accountSetting.p();
            ((FragmentAccountNewBinding) n()).accountFeedbackDesc.setText(getString(R.string.feedback));
            ((FragmentAccountNewBinding) n()).accountFeedbackIcon.setImageResource(R.drawable.icon_account_feedback);
            return;
        }
        ((FragmentAccountNewBinding) n()).accountVipBg.setImageResource(R.drawable.icon_bg_vip_actived);
        Context context2 = getContext();
        if (context2 != null) {
            ((FragmentAccountNewBinding) n()).accountVipDesc.setTextColor(ContextCompat.getColor(context2, com.martian.libmars.R.color.vip_bg_start_color));
            TextView textView = ((FragmentAccountNewBinding) n()).accountVipDesc;
            if (v22 > 0) {
                String i10 = ba.f.i(v22, "yyyy.MM.dd");
                c10 = ExtKt.c("会员至：") + i10;
            } else {
                c10 = ExtKt.c("免广告·听书");
            }
            textView.setText(c10);
        }
        ((FragmentAccountNewBinding) n()).accountVipButton.setBackgroundResource(R.drawable.shape_vip_button);
        ((FragmentAccountNewBinding) n()).accountVipButton.setText(getString(R.string.renewal_vip));
        ((FragmentAccountNewBinding) n()).accountNightMode.setEnableFilter(true);
        ((FragmentAccountNewBinding) n()).accountSetting.setEnableFilter(true);
        ((FragmentAccountNewBinding) n()).accountFeedbackDesc.setText(getString(R.string.vip_feedback));
        ((FragmentAccountNewBinding) n()).accountFeedbackIcon.setImageResource(R.drawable.icon_account_feedback_vip);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y0() {
        Book H;
        List<MiReadingRecord> miReadingRecords = MiConfigSingleton.b2().M1().a0().getMiReadingRecords();
        if (miReadingRecords == null || miReadingRecords.isEmpty()) {
            ((FragmentAccountNewBinding) n()).accountReadingRecordView.setVisibility(8);
            return;
        }
        ((FragmentAccountNewBinding) n()).accountReadingRecordView.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        for (MiReadingRecord miReadingRecord : miReadingRecords) {
            if (miReadingRecord != null) {
                ReadingRecordItem readingRecordItem = new ReadingRecordItem(null, null, false, false, false, 31, null);
                readingRecordItem.setReadingRecord(miReadingRecord);
                readingRecordItem.setBookCover(miReadingRecord.getCover());
                String sourceString = miReadingRecord.getSourceString();
                Intrinsics.checkNotNullExpressionValue(sourceString, "getSourceString(...)");
                readingRecordItem.setLocalBook(StringsKt.startsWith$default(sourceString, vb.e.f31296c, false, 2, (Object) null));
                if (!readingRecordItem.getLocalBook() && TextUtils.isEmpty(miReadingRecord.getCover()) && (H = MiConfigSingleton.b2().M1().H(miReadingRecord.getSourceString())) != null) {
                    readingRecordItem.setBookCover(H.getCover());
                    miReadingRecord.setCover(H.getCover());
                }
                readingRecordItem.setInBookStore(MiConfigSingleton.b2().M1().T().v(miReadingRecord.getSourceString()));
                arrayList.add(readingRecordItem);
            }
        }
        if (this.recordAdapter == null) {
            this.recordAdapter = new AccountReadingRecordAdapter();
            ((FragmentAccountNewBinding) n()).rvReadingRecord.setAdapter(this.recordAdapter);
        }
        AccountReadingRecordAdapter accountReadingRecordAdapter = this.recordAdapter;
        if (accountReadingRecordAdapter != null) {
            accountReadingRecordAdapter.m(arrayList, ((FragmentAccountNewBinding) n()).rvReadingRecord);
        }
    }

    public final e9.c Z0() {
        return (e9.c) this.rxManager.getValue();
    }

    public final void a1() {
        MiConfigSingleton.b2().M1().O2(getActivity(), new MiBookManager.f0() { // from class: vd.b0
            public /* synthetic */ b0() {
            }

            @Override // com.martian.mibook.application.MiBookManager.f0
            public final void a() {
                AccountFragment.b1(AccountFragment.this);
            }
        });
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMFragment
    public void i0() {
        T1();
    }

    @Override // com.martian.mibook.mvvm.base.LazyFragment
    public void k() {
        super.k();
        P1();
        AppViewModel G = G();
        if (G != null) {
            G.n0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Z0().b();
    }

    @Override // com.martian.mibook.mvvm.base.LazyFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Q1();
        a1();
        if (this.showTeenageGuideDialog) {
            this.showTeenageGuideDialog = false;
            v0.Y0(getActivity());
        }
    }

    @Override // com.martian.mibook.mvvm.base.BaseFragment
    public void q(@l Bundle savedInstanceState) {
        M1();
        c1();
        O1();
    }
}
