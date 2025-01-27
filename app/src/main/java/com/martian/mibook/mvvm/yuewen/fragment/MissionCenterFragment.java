package com.martian.mibook.mvvm.yuewen.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.gyf.immersionbar.d;
import com.kuaishou.weapon.p0.t;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.utils.tablayout.CommonNavigator;
import com.martian.libmars.utils.tablayout.ScaleTransitionPagerTitleView;
import com.martian.libmars.widget.dialog.MartianDialogFragment;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.FragmentMissionCenterNewBinding;
import com.martian.mibook.lib.account.response.IntervalBonus;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.mibook.mvvm.base.BaseMVVMFragment;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.ErrorResult;
import com.martian.mibook.mvvm.tts.NonStickyLiveData;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.martian.mibook.mvvm.yuewen.fragment.MissionCenterFragment;
import com.martian.mibook.mvvm.yuewen.viewmodel.MissionCenterViewModel;
import com.martian.rpauth.MartianRPUserManager;
import id.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import l9.i0;
import l9.t0;
import m9.b;
import m9.e;
import m9.g;
import xi.k;
import xi.l;
import ya.e0;

@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0006*\u0001'\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\u0005J\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0005J\u000f\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0005J\u000f\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\u0005J\u000f\u0010\u0018\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0018\u0010\u0005R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u001aR&\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001b\u0010&\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/fragment/MissionCenterFragment;", "Lcom/martian/mibook/mvvm/base/BaseMVVMFragment;", "Lcom/martian/mibook/databinding/FragmentMissionCenterNewBinding;", "Lcom/martian/mibook/mvvm/yuewen/viewmodel/MissionCenterViewModel;", "<init>", "()V", "", "A0", "z0", "H0", "O0", "P0", "I0", "", "Landroidx/fragment/app/Fragment;", "x0", "()Ljava/util/List;", "Landroid/os/Bundle;", "savedInstanceState", "q", "(Landroid/os/Bundle;)V", "k", "i0", "onDestroyView", "J0", "", "Ljava/util/List;", "fragmentList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", t.f11204d, "Ljava/util/ArrayList;", "pageTitleList", "m", "Lkotlin/Lazy;", "y0", "()Lcom/martian/mibook/mvvm/yuewen/viewmodel/MissionCenterViewModel;", "mViewModel", "com/martian/mibook/mvvm/yuewen/fragment/MissionCenterFragment$onPageChangeCallback$1", "n", "Lcom/martian/mibook/mvvm/yuewen/fragment/MissionCenterFragment$onPageChangeCallback$1;", "onPageChangeCallback", "ViewPager2Adapter", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class MissionCenterFragment extends BaseMVVMFragment<FragmentMissionCenterNewBinding, MissionCenterViewModel> {

    /* renamed from: k, reason: from kotlin metadata */
    @k
    public List<Fragment> fragmentList = new ArrayList();

    /* renamed from: l */
    @k
    public ArrayList<String> pageTitleList = CollectionsKt.arrayListOf(ExtKt.c("零钱"), ExtKt.c("佣金"));

    /* renamed from: m, reason: from kotlin metadata */
    @k
    public final Lazy mViewModel = LazyKt.lazy(new Function0<MissionCenterViewModel>() { // from class: com.martian.mibook.mvvm.yuewen.fragment.MissionCenterFragment$mViewModel$2
        public MissionCenterFragment$mViewModel$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @k
        public final MissionCenterViewModel invoke() {
            ViewModelStoreOwner activity = MissionCenterFragment.this.getActivity();
            if (activity == null) {
                activity = MissionCenterFragment.this;
            }
            return (MissionCenterViewModel) new ViewModelProvider(activity).get(MissionCenterFragment.this.M());
        }
    });

    /* renamed from: n, reason: from kotlin metadata */
    @k
    public final MissionCenterFragment$onPageChangeCallback$1 onPageChangeCallback = new ViewPager2.OnPageChangeCallback() { // from class: com.martian.mibook.mvvm.yuewen.fragment.MissionCenterFragment$onPageChangeCallback$1
        public MissionCenterFragment$onPageChangeCallback$1() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int state) {
            MissionCenterFragment.s0(MissionCenterFragment.this).magicIndicator.a(state);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int r22, float positionOffset, int positionOffsetPixels) {
            MissionCenterFragment.s0(MissionCenterFragment.this).magicIndicator.b(r22, positionOffset, positionOffsetPixels);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int r22) {
            MissionCenterFragment.s0(MissionCenterFragment.this).magicIndicator.c(r22);
        }
    };

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/fragment/MissionCenterFragment$ViewPager2Adapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "Landroidx/fragment/app/Fragment;", "fragment", "", "fragments", "<init>", "(Lcom/martian/mibook/mvvm/yuewen/fragment/MissionCenterFragment;Landroidx/fragment/app/Fragment;Ljava/util/List;)V", "", "getItemCount", "()I", c.f26972i, "createFragment", "(I)Landroidx/fragment/app/Fragment;", "c", "Ljava/util/List;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class ViewPager2Adapter extends FragmentStateAdapter {

        /* renamed from: c, reason: from kotlin metadata */
        @k
        public final List<Fragment> fragments;

        /* renamed from: d */
        public final /* synthetic */ MissionCenterFragment f15636d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ViewPager2Adapter(@k MissionCenterFragment missionCenterFragment, @k Fragment fragment, List<? extends Fragment> fragments) {
            super(fragment);
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(fragments, "fragments");
            this.f15636d = missionCenterFragment;
            this.fragments = fragments;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        @k
        public Fragment createFragment(int r22) {
            return this.fragments.get(r22);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getPageSize() {
            return this.fragments.size();
        }
    }

    public static final class a extends b {
        public a() {
        }

        public static final void j(MissionCenterFragment this$0, int i10, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            MissionCenterFragment.s0(this$0).viewpager2.setCurrentItem(i10);
        }

        @Override // m9.b
        public int a() {
            return MissionCenterFragment.this.fragmentList.size();
        }

        @Override // m9.b
        @l
        public e b(@k Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return null;
        }

        @Override // m9.b
        @k
        public g c(@k Context context, int i10) {
            Intrinsics.checkNotNullParameter(context, "context");
            ScaleTransitionPagerTitleView scaleTransitionPagerTitleView = new ScaleTransitionPagerTitleView(context, false);
            scaleTransitionPagerTitleView.setText(ExtKt.c((String) MissionCenterFragment.this.pageTitleList.get(i10)));
            scaleTransitionPagerTitleView.setTextSize(16.0f);
            scaleTransitionPagerTitleView.setMaxScale(1.375f);
            scaleTransitionPagerTitleView.setNormalColor(ConfigSingleton.D().j0());
            scaleTransitionPagerTitleView.setSelectedColor(ConfigSingleton.D().h0());
            scaleTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() { // from class: vd.l2

                /* renamed from: c */
                public final /* synthetic */ int f31377c;

                public /* synthetic */ l2(int i102) {
                    i10 = i102;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MissionCenterFragment.a.j(MissionCenterFragment.this, i10, view);
                }
            });
            return scaleTransitionPagerTitleView;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void A0() {
        NonStickyLiveData<MiTaskAccount> a02;
        NonStickyLiveData<IntervalBonus> W;
        NonStickyLiveData<ErrorResult> N;
        NonStickyLiveData<IntervalBonus> O;
        ((FragmentMissionCenterNewBinding) n()).actionbarBack.setOnClickListener(new View.OnClickListener() { // from class: vd.d2
            public /* synthetic */ d2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MissionCenterFragment.B0(MissionCenterFragment.this, view);
            }
        });
        AppViewModel G = G();
        if (G != null && (O = G.O()) != null) {
            O.observe(this, new Observer() { // from class: vd.e2
                public /* synthetic */ e2() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MissionCenterFragment.C0(Function1.this, obj);
                }
            });
        }
        AppViewModel G2 = G();
        if (G2 != null && (N = G2.N()) != null) {
            N.observe(this, new Observer() { // from class: vd.f2
                public /* synthetic */ f2() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MissionCenterFragment.D0(Function1.this, obj);
                }
            });
        }
        AppViewModel G3 = G();
        if (G3 != null && (W = G3.W()) != null) {
            W.observe(this, new Observer() { // from class: vd.g2
                public /* synthetic */ g2() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MissionCenterFragment.E0(Function1.this, obj);
                }
            });
        }
        AppViewModel G4 = G();
        if (G4 != null && (a02 = G4.a0()) != null) {
            a02.observe(this, new Observer() { // from class: vd.h2
                public /* synthetic */ h2() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MissionCenterFragment.F0(Function1.this, obj);
                }
            });
        }
        ((FragmentMissionCenterNewBinding) n()).rlIntervalView.setOnClickListener(new View.OnClickListener() { // from class: vd.i2
            public /* synthetic */ i2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MissionCenterFragment.G0(MissionCenterFragment.this, view);
            }
        });
    }

    public static final void B0(MissionCenterFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final void C0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void D0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void E0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void F0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void G0(MissionCenterFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (MiConfigSingleton.b2().G1().g(this$0.getActivity(), 1003)) {
            if (MiConfigSingleton.b2().p2() == null) {
                t0.b(this$0.getContext(), this$0.getString(R.string.account_not_generated_retry));
                return;
            }
            if (MiConfigSingleton.b2().e2().C() > MartianRPUserManager.a()) {
                ac.a.E(this$0.getContext(), "时段奖励-倒计时-点击");
                i0.F0(this$0.getActivity(), this$0.getString(R.string.tips), this$0.getString(R.string.countdown_ends_to_claim_rewards), this$0.getString(R.string.i_know), null, null);
                return;
            }
            ac.a.E(this$0.getContext(), "时段奖励-红包-点击");
            AppViewModel G = this$0.G();
            if (G != null) {
                G.I();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void H0() {
        d.B2(this, ((FragmentMissionCenterNewBinding) n()).coordinator);
        if (I().getHasBackKey()) {
            ((FragmentMissionCenterNewBinding) n()).actionbarBack.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = ((FragmentMissionCenterNewBinding) n()).magicIndicator.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            ((RelativeLayout.LayoutParams) layoutParams).addRule(13);
            return;
        }
        ((FragmentMissionCenterNewBinding) n()).actionbarBack.setVisibility(8);
        ViewGroup.LayoutParams layoutParams2 = ((FragmentMissionCenterNewBinding) n()).magicIndicator.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) layoutParams2).removeRule(13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void I0() {
        ViewPager2Adapter viewPager2Adapter = new ViewPager2Adapter(this, this, x0());
        ((FragmentMissionCenterNewBinding) n()).viewpager2.setOffscreenPageLimit(this.fragmentList.size());
        ((FragmentMissionCenterNewBinding) n()).viewpager2.setAdapter(viewPager2Adapter);
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        commonNavigator.setLeftPadding(ConfigSingleton.i(4.0f));
        commonNavigator.setAdapter(new a());
        ((FragmentMissionCenterNewBinding) n()).magicIndicator.setTextColorType(-1);
        ((FragmentMissionCenterNewBinding) n()).magicIndicator.setNavigator(commonNavigator);
        ((FragmentMissionCenterNewBinding) n()).viewpager2.registerOnPageChangeCallback(this.onPageChangeCallback);
        ((FragmentMissionCenterNewBinding) n()).viewpager2.setCurrentItem(I().getId.c.i java.lang.String() == 0 ? 0 : 1);
    }

    public static final void L0(MartianDialogFragment martianDialogFragment, View view) {
        if (martianDialogFragment != null) {
            martianDialogFragment.dismiss();
        }
    }

    public static final void M0(MartianDialogFragment martianDialogFragment, View view) {
        if (martianDialogFragment != null) {
            martianDialogFragment.dismiss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void O0() {
        long C = MiConfigSingleton.b2().e2().C();
        boolean z10 = C > MartianRPUserManager.a();
        ((FragmentMissionCenterNewBinding) n()).bookrackIntervalCountdown.setVisibility(z10 ? 0 : 8);
        ((FragmentMissionCenterNewBinding) n()).bookrackIntervalGrab.setVisibility(z10 ? 8 : 0);
        if (z10) {
            ((FragmentMissionCenterNewBinding) n()).bookrackIntervalCountdown.n(C, getString(R.string.grab_bonus_imm));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void P0() {
        if (ConfigSingleton.D().A0()) {
            ((FragmentMissionCenterNewBinding) n()).ivTopBg.setAlpha(0.0f);
        } else {
            ((FragmentMissionCenterNewBinding) n()).ivTopBg.setAlpha(1.0f);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ FragmentMissionCenterNewBinding s0(MissionCenterFragment missionCenterFragment) {
        return (FragmentMissionCenterNewBinding) missionCenterFragment.n();
    }

    private final List<Fragment> x0() {
        this.fragmentList.clear();
        this.fragmentList.add(MoneyIncomeFragment.INSTANCE.a(I().getT8.a.f java.lang.String()));
        this.fragmentList.add(CommissionIncomeFragment.INSTANCE.a(I().getT8.a.f java.lang.String()));
        return this.fragmentList;
    }

    private final void z0() {
        Intent intent;
        Intent intent2;
        Intent intent3;
        MissionCenterViewModel I = I();
        FragmentActivity activity = getActivity();
        int i10 = 0;
        I.I((activity == null || (intent3 = activity.getIntent()) == null) ? false : intent3.getBooleanExtra(e0.B0, false));
        MissionCenterViewModel I2 = I();
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent2 = activity2.getIntent()) != null) {
            i10 = intent2.getIntExtra(e0.f33189z0, 0);
        }
        I2.K(i10);
        MissionCenterViewModel I3 = I();
        FragmentActivity activity3 = getActivity();
        I3.J((activity3 == null || (intent = activity3.getIntent()) == null) ? null : intent.getStringExtra(e0.A0));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: vd.j2.<init>(com.martian.libmars.widget.dialog.MartianDialogFragment):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @android.annotation.SuppressLint({"SetTextI18n"})
    public final void J0() {
        /*
            r5 = this;
            com.martian.mibook.application.MiConfigSingleton r0 = com.martian.mibook.application.MiConfigSingleton.b2()
            ya.a r0 = r0.G1()
            com.martian.mibook.lib.account.response.MiTaskAccount r0 = r0.o()
            if (r0 == 0) goto L94
            boolean r1 = r0.getFresh()
            if (r1 == 0) goto L94
            com.martian.mibook.application.MiConfigSingleton r1 = com.martian.mibook.application.MiConfigSingleton.b2()
            java.lang.String r2 = "TTBOOK_FRESH_BONUS"
            boolean r1 = r1.E0(r2)
            if (r1 == 0) goto L94
            android.view.LayoutInflater r1 = r5.getLayoutInflater()
            r2 = 0
            r3 = 0
            com.martian.mibook.databinding.PopupwindowFreshgrabedBackgroundBinding r1 = com.martian.mibook.databinding.PopupwindowFreshgrabedBackgroundBinding.inflate(r1, r2, r3)
            java.lang.String r2 = "inflate(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            android.widget.TextView r2 = r1.rdTitle
            java.lang.String r4 = "限 时 福 利"
            java.lang.String r4 = com.martian.mibook.mvvm.extensions.ExtKt.c(r4)
            r2.setText(r4)
            android.widget.TextView r2 = r1.grabMoney
            int r0 = r0.getMRate()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            java.lang.String r0 = "金币 = 1元"
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.lang.String r0 = com.martian.mibook.mvvm.extensions.ExtKt.c(r0)
            r2.setText(r0)
            android.widget.TextView r0 = r1.rdHint
            java.lang.String r2 = "新人专属连续7天兑换福利"
            java.lang.String r2 = com.martian.mibook.mvvm.extensions.ExtKt.c(r2)
            r0.setText(r2)
            android.widget.ImageView r0 = r1.rdGrab
            int r2 = com.martian.mibook.R.drawable.button_known
            r0.setImageResource(r2)
            com.martian.libmars.widget.dialog.MartianDialogFragment$a r0 = com.martian.libmars.widget.dialog.MartianDialogFragment.INSTANCE
            com.martian.libmars.widget.dialog.b r0 = r0.a()
            android.widget.RelativeLayout r2 = r1.getRoot()
            com.martian.libmars.widget.dialog.b r0 = r0.Q(r2)
            com.martian.libmars.widget.dialog.b r0 = r0.J(r3)
            com.martian.libmars.widget.dialog.MartianDialogFragment r0 = r0.C(r5)
            android.widget.ImageView r2 = r1.rdClose
            vd.j2 r3 = new vd.j2
            r3.<init>()
            r2.setOnClickListener(r3)
            android.widget.ImageView r1 = r1.rdGrab
            vd.k2 r2 = new vd.k2
            r2.<init>()
            r1.setOnClickListener(r2)
        L94:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.yuewen.fragment.MissionCenterFragment.J0():void");
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMFragment
    public void i0() {
        P0();
    }

    @Override // com.martian.mibook.mvvm.base.LazyFragment
    public void k() {
        super.k();
        AppViewModel G = G();
        if (G != null) {
            G.J0();
        }
        AppViewModel G2 = G();
        if (G2 != null) {
            G2.n0();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ((FragmentMissionCenterNewBinding) n()).viewpager2.unregisterOnPageChangeCallback(this.onPageChangeCallback);
    }

    @Override // com.martian.mibook.mvvm.base.BaseFragment
    public void q(@l Bundle savedInstanceState) {
        z0();
        H0();
        A0();
        I0();
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMFragment
    @k
    /* renamed from: y0 */
    public MissionCenterViewModel I() {
        return (MissionCenterViewModel) this.mViewModel.getValue();
    }
}
