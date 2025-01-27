package com.martian.mibook.mvvm.yuewen.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.kuaishou.weapon.p0.t;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.activity.account.TXSCommissionRecordActivity;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.c;
import com.martian.mibook.databinding.FragmentCommissionIncomeNewBinding;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.mibook.lib.account.response.MissionItem;
import com.martian.mibook.lib.account.response.MissionSection;
import com.martian.mibook.lib.account.response.MissionSectionList;
import com.martian.mibook.mvvm.base.BaseMVVMFragment;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.tts.NonStickyLiveData;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.martian.mibook.mvvm.yuewen.fragment.CommissionIncomeFragment;
import com.martian.mibook.mvvm.yuewen.viewmodel.MissionCenterViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import je.i;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import oe.f;
import xi.k;
import xi.l;
import ya.e0;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u0005R\u001b\u0010\u0013\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/fragment/CommissionIncomeFragment;", "Lcom/martian/mibook/mvvm/base/BaseMVVMFragment;", "Lcom/martian/mibook/databinding/FragmentCommissionIncomeNewBinding;", "Lcom/martian/mibook/mvvm/yuewen/viewmodel/MissionCenterViewModel;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "q", "(Landroid/os/Bundle;)V", "i0", "onResume", "B0", "C0", "k", "Lkotlin/Lazy;", "t0", "()Lcom/martian/mibook/mvvm/yuewen/viewmodel/MissionCenterViewModel;", "mViewModel", t.f11204d, "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class CommissionIncomeFragment extends BaseMVVMFragment<FragmentCommissionIncomeNewBinding, MissionCenterViewModel> {

    /* renamed from: l */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k, reason: from kotlin metadata */
    @k
    public final Lazy mViewModel = LazyKt.lazy(new Function0<MissionCenterViewModel>() { // from class: com.martian.mibook.mvvm.yuewen.fragment.CommissionIncomeFragment$mViewModel$2
        public CommissionIncomeFragment$mViewModel$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @k
        public final MissionCenterViewModel invoke() {
            ViewModelStoreOwner activity = CommissionIncomeFragment.this.getActivity();
            if (activity == null) {
                activity = CommissionIncomeFragment.this;
            }
            return (MissionCenterViewModel) new ViewModelProvider(activity).get(CommissionIncomeFragment.this.M());
        }
    });

    /* renamed from: com.martian.mibook.mvvm.yuewen.fragment.CommissionIncomeFragment$a */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @k
        public final CommissionIncomeFragment a(@l String str) {
            CommissionIncomeFragment commissionIncomeFragment = new CommissionIncomeFragment();
            Bundle bundle = new Bundle();
            bundle.putString(e0.A0, str);
            commissionIncomeFragment.setArguments(bundle);
            return commissionIncomeFragment;
        }

        public Companion() {
        }
    }

    public static final void A0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void D0(CommissionIncomeFragment this$0, MissionItem missionItem) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.B(this$0.getContext(), (missionItem != null ? missionItem.getTitle() : null) + "-点击");
        MiConfigSingleton.b2().e2().Y(this$0.getActivity(), missionItem, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ FragmentCommissionIncomeNewBinding r0(CommissionIncomeFragment commissionIncomeFragment) {
        return (FragmentCommissionIncomeNewBinding) commissionIncomeFragment.n();
    }

    public static final void u0(CommissionIncomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.B(this$0.getContext(), "提现");
        i.K(this$0.getActivity());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void v0(CommissionIncomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((FragmentCommissionIncomeNewBinding) this$0.n()).clHorn.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void w0(CommissionIncomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((FragmentCommissionIncomeNewBinding) this$0.n()).tvMore.performClick();
    }

    public static final void x0(CommissionIncomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.B(this$0.getContext(), "查看明细");
        this$0.startActivity(new Intent(this$0.getContext(), (Class<?>) TXSCommissionRecordActivity.class));
    }

    public static final void y0(CommissionIncomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.B(this$0.getContext(), "提现榜");
        MiWebViewActivity.startWebViewActivity(this$0.getActivity(), ConfigSingleton.D().J0() ? "http://testap.taoyuewenhua.com/withdraw_rank" : "http://ap.taoyuewenhua.com/withdraw_rank");
    }

    public static final void z0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B0() {
        MiTaskAccount p22 = MiConfigSingleton.b2().p2();
        if (p22 != null) {
            ((FragmentCommissionIncomeNewBinding) n()).ctvMoney.j(f.m(Integer.valueOf(p22.getCommission())), 2);
        } else {
            ((FragmentCommissionIncomeNewBinding) n()).ctvMoney.j(0.0f, 2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void C0() {
        Context context = getContext();
        if (context != null) {
            MissionSectionList missionSectionList = new MissionSectionList();
            ArrayList arrayList = new ArrayList();
            MissionSection missionSection = new MissionSection();
            missionSection.setTitle(context.getString(R.string.txs_commission_mission));
            missionSection.setMissionItems(I().q(context));
            Intrinsics.checkNotNullExpressionValue(missionSection.getMissionItems(), "getMissionItems(...)");
            if (!r0.isEmpty()) {
                arrayList.add(missionSection);
            }
            missionSectionList.setMissionSections(arrayList);
            if (missionSectionList.getMissionSections() != null) {
                ((FragmentCommissionIncomeNewBinding) n()).missionItems.removeAllViews();
                Iterator<MissionSection> it = missionSectionList.getMissionSections().iterator();
                while (it.hasNext()) {
                    MiConfigSingleton.b2().e2().h(getContext(), it.next(), ((FragmentCommissionIncomeNewBinding) n()).missionItems, new c.n() { // from class: vd.v1
                        public /* synthetic */ v1() {
                        }

                        @Override // com.martian.mibook.application.c.n
                        public final void a(MissionItem missionItem) {
                            CommissionIncomeFragment.D0(CommissionIncomeFragment.this, missionItem);
                        }
                    });
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.base.BaseMVVMFragment
    public void i0() {
        if (ConfigSingleton.D().A0()) {
            ((FragmentCommissionIncomeNewBinding) n()).clHorn.setBackgroundResource(R.drawable.bg_mission_center_exchange_layout_night);
        } else {
            ((FragmentCommissionIncomeNewBinding) n()).clHorn.setBackgroundResource(R.drawable.bg_mission_center_exchange_layout_day);
        }
    }

    @Override // com.martian.mibook.mvvm.base.LazyFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        B0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.base.BaseFragment
    public void q(@l Bundle savedInstanceState) {
        NonStickyLiveData<MiTaskAccount> a02;
        ((FragmentCommissionIncomeNewBinding) n()).tvHornContent.setText(ExtKt.c("0.3元即可提现"));
        ((FragmentCommissionIncomeNewBinding) n()).tvWithdrawal.setOnClickListener(new View.OnClickListener() { // from class: vd.w1
            public /* synthetic */ w1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommissionIncomeFragment.u0(CommissionIncomeFragment.this, view);
            }
        });
        ((FragmentCommissionIncomeNewBinding) n()).ivCloseHorn.setOnClickListener(new View.OnClickListener() { // from class: vd.x1
            public /* synthetic */ x1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommissionIncomeFragment.v0(CommissionIncomeFragment.this, view);
            }
        });
        ((FragmentCommissionIncomeNewBinding) n()).ctvMoney.setOnClickListener(new View.OnClickListener() { // from class: vd.y1
            public /* synthetic */ y1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommissionIncomeFragment.w0(CommissionIncomeFragment.this, view);
            }
        });
        ((FragmentCommissionIncomeNewBinding) n()).tvMore.setOnClickListener(new View.OnClickListener() { // from class: vd.z1
            public /* synthetic */ z1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommissionIncomeFragment.x0(CommissionIncomeFragment.this, view);
            }
        });
        ((FragmentCommissionIncomeNewBinding) n()).martianTipsView.setVisibility(MiConfigSingleton.b2().C2() ? 8 : 0);
        ((FragmentCommissionIncomeNewBinding) n()).martianTipsView.setOnClickListener(new View.OnClickListener() { // from class: vd.a2
            public /* synthetic */ a2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommissionIncomeFragment.y0(CommissionIncomeFragment.this, view);
            }
        });
        AppViewModel G = G();
        if (G != null && (a02 = G.a0()) != null) {
            a02.observe(this, new Observer() { // from class: vd.b2
                public /* synthetic */ b2() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    CommissionIncomeFragment.z0(Function1.this, obj);
                }
            });
        }
        I().A().observe(this, new Observer() { // from class: vd.c2
            public /* synthetic */ c2() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CommissionIncomeFragment.A0(Function1.this, obj);
            }
        });
        C0();
        I().F();
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMFragment
    @k
    /* renamed from: t0 */
    public MissionCenterViewModel I() {
        return (MissionCenterViewModel) this.mViewModel.getValue();
    }
}
