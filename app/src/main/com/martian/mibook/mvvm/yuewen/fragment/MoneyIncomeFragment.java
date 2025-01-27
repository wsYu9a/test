package com.martian.mibook.mvvm.yuewen.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ba.h;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.activity.account.IncomeHistoryActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.c;
import com.martian.mibook.databinding.FragmentMoneyIncomeNewBinding;
import com.martian.mibook.lib.account.response.BonusPool;
import com.martian.mibook.lib.account.response.CheckinResult;
import com.martian.mibook.lib.account.response.ExchangeMoney;
import com.martian.mibook.lib.account.response.IntervalBonus;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.mibook.lib.account.response.MissionItem;
import com.martian.mibook.lib.account.response.MissionSection;
import com.martian.mibook.lib.account.response.MissionSectionList;
import com.martian.mibook.mvvm.base.BaseMVVMFragment;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.ErrorResult;
import com.martian.mibook.mvvm.tts.NonStickyLiveData;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.martian.mibook.mvvm.yuewen.adapter.BonusPollSignAdapter;
import com.martian.mibook.mvvm.yuewen.fragment.MoneyIncomeFragment;
import com.martian.mibook.mvvm.yuewen.viewmodel.MissionCenterViewModel;
import com.martian.rpauth.MartianRPUserManager;
import com.umeng.analytics.pro.f;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import je.i;
import je.v0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import l9.i0;
import l9.t0;
import r3.c;
import vi.d;
import xi.k;
import xi.l;
import ya.e0;
import ya.j2;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 62\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u000278B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\u0005J%\u0010\u0011\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0005J\u000f\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0005J\u000f\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0005J\u0019\u0010\u0019\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u0005J\u0017\u0010\u001c\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\u0005J\u000f\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001f\u0010\u0005R\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001b\u0010-\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104¨\u00069"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/fragment/MoneyIncomeFragment;", "Lcom/martian/mibook/mvvm/base/BaseMVVMFragment;", "Lcom/martian/mibook/databinding/FragmentMoneyIncomeNewBinding;", "Lcom/martian/mibook/mvvm/yuewen/viewmodel/MissionCenterViewModel;", "<init>", "()V", "", "L0", "W0", "Landroid/text/Spanned;", "P0", "()Landroid/text/Spanned;", "O0", "", TTDownloadField.TT_TAG, "Lcom/martian/mibook/lib/account/response/MissionItem;", "item", c.f30241d, "(Ljava/lang/Integer;Lcom/martian/mibook/lib/account/response/MissionItem;)V", "s1", "T0", "r1", "t1", "Landroid/os/Bundle;", "savedInstanceState", "q", "(Landroid/os/Bundle;)V", "i0", "U0", "(Lcom/martian/mibook/lib/account/response/MissionItem;)V", "onResume", "onDestroyView", "Lcom/martian/mibook/mvvm/yuewen/adapter/BonusPollSignAdapter;", "k", "Lcom/martian/mibook/mvvm/yuewen/adapter/BonusPollSignAdapter;", "bonusPollSignAdapter", t.f11204d, "Lkotlin/Lazy;", "Q0", "()Lcom/martian/mibook/mvvm/yuewen/viewmodel/MissionCenterViewModel;", "mViewModel", "Le9/c;", "m", "R0", "()Le9/c;", "rxManager", "", "n", "Z", "startRate", "", "o", "J", "rateTime", "p", "a", "SignItemDecoration", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class MoneyIncomeFragment extends BaseMVVMFragment<FragmentMoneyIncomeNewBinding, MissionCenterViewModel> {

    /* renamed from: p, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k, reason: from kotlin metadata */
    @l
    public BonusPollSignAdapter bonusPollSignAdapter;

    /* renamed from: n, reason: from kotlin metadata */
    public boolean startRate;

    /* renamed from: l */
    @k
    public final Lazy mViewModel = LazyKt.lazy(new Function0<MissionCenterViewModel>() { // from class: com.martian.mibook.mvvm.yuewen.fragment.MoneyIncomeFragment$mViewModel$2
        public MoneyIncomeFragment$mViewModel$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @k
        public final MissionCenterViewModel invoke() {
            ViewModelStoreOwner activity = MoneyIncomeFragment.this.getActivity();
            if (activity == null) {
                activity = MoneyIncomeFragment.this;
            }
            return (MissionCenterViewModel) new ViewModelProvider(activity).get(MoneyIncomeFragment.this.M());
        }
    });

    /* renamed from: m, reason: from kotlin metadata */
    @k
    public final Lazy rxManager = LazyKt.lazy(MoneyIncomeFragment$rxManager$2.INSTANCE);

    /* renamed from: o, reason: from kotlin metadata */
    public long rateTime = MartianRPUserManager.a();

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/fragment/MoneyIncomeFragment$SignItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/content/Context;", f.X, "<init>", "(Lcom/martian/mibook/mvvm/yuewen/fragment/MoneyIncomeFragment;Landroid/content/Context;)V", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", e.TAG, "I", "spacing", "f", "spanCount", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class SignItemDecoration extends RecyclerView.ItemDecoration {

        /* renamed from: e */
        public int spacing;

        /* renamed from: f, reason: from kotlin metadata */
        public int spanCount;

        /* renamed from: g */
        public final /* synthetic */ MoneyIncomeFragment f15647g;

        public SignItemDecoration(@k MoneyIncomeFragment moneyIncomeFragment, Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.f15647g = moneyIncomeFragment;
            int i10 = context.getResources().getDisplayMetrics().widthPixels - ConfigSingleton.i(48.0f);
            this.spanCount = BonusPollSignAdapter.INSTANCE.a();
            int i11 = ConfigSingleton.i(36.0f);
            int i12 = ConfigSingleton.i(48.0f);
            int i13 = this.spanCount;
            this.spacing = ((i10 - (i11 * (i13 - 1))) - i12) / (i13 - 1);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@k Rect outRect, @k View view, @k RecyclerView parent, @k RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            if (childAdapterPosition == 0) {
                outRect.left = 0;
            } else {
                outRect.left = this.spacing / 2;
            }
            if (childAdapterPosition == this.spanCount - 1) {
                outRect.right = 0;
            } else {
                outRect.right = this.spacing / 2;
            }
        }
    }

    /* renamed from: com.martian.mibook.mvvm.yuewen.fragment.MoneyIncomeFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @k
        public final MoneyIncomeFragment a(@l String str) {
            MoneyIncomeFragment moneyIncomeFragment = new MoneyIncomeFragment();
            Bundle bundle = new Bundle();
            bundle.putString(e0.A0, str);
            moneyIncomeFragment.setArguments(bundle);
            return moneyIncomeFragment;
        }

        public Companion() {
        }
    }

    public static final class b implements BonusPollSignAdapter.b {
        public b() {
        }

        @Override // com.martian.mibook.mvvm.yuewen.adapter.BonusPollSignAdapter.b
        public void a() {
            MoneyIncomeFragment.this.U0(new MissionItem(13, ExtKt.c("签到领奖励，签满7天领大额金币"), 0, 1, false, 13, ExtKt.c("立即签到")));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ FragmentMoneyIncomeNewBinding H0(MoneyIncomeFragment moneyIncomeFragment) {
        return (FragmentMoneyIncomeNewBinding) moneyIncomeFragment.n();
    }

    private final void L0() {
        R0().c(j2.O, new wj.b() { // from class: vd.x2
            public /* synthetic */ x2() {
            }

            @Override // wj.b
            public final void call(Object obj) {
                MoneyIncomeFragment.M0(MoneyIncomeFragment.this, (Integer) obj);
            }
        });
    }

    public static final void M0(MoneyIncomeFragment this$0, Integer num) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (num != null && num.intValue() == 8) {
            w1(this$0, num, null, 2, null);
        }
    }

    private final e9.c R0() {
        return (e9.c) this.rxManager.getValue();
    }

    public static final void V0(MoneyIncomeFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w1(this$0, 111, null, 2, null);
        this$0.s1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void W0() {
        NonStickyLiveData<ErrorResult> T;
        NonStickyLiveData<ExchangeMoney> U;
        NonStickyLiveData<MiTaskAccount> a02;
        NonStickyLiveData<IntervalBonus> W;
        NonStickyLiveData<ErrorResult> N;
        NonStickyLiveData<IntervalBonus> O;
        NonStickyLiveData<ErrorResult> Q;
        NonStickyLiveData<CheckinResult> R;
        NonStickyLiveData<BonusPool> P;
        Context context;
        ((FragmentMoneyIncomeNewBinding) n()).switchButton.setChecked(MiConfigSingleton.b2().D1());
        if (this.bonusPollSignAdapter == null) {
            if (((FragmentMoneyIncomeNewBinding) n()).rvSign.getLayoutManager() == null && (context = getContext()) != null) {
                ((FragmentMoneyIncomeNewBinding) n()).rvSign.setLayoutManager(new LinearLayoutManager(context, 0, false));
                ((FragmentMoneyIncomeNewBinding) n()).rvSign.addItemDecoration(new SignItemDecoration(this, context));
            }
            this.bonusPollSignAdapter = new BonusPollSignAdapter();
            ((FragmentMoneyIncomeNewBinding) n()).rvSign.setAdapter(this.bonusPollSignAdapter);
        }
        BonusPollSignAdapter bonusPollSignAdapter = this.bonusPollSignAdapter;
        if (bonusPollSignAdapter != null) {
            bonusPollSignAdapter.o(new b());
        }
        AppViewModel G = G();
        if (G != null && (P = G.P()) != null) {
            P.observe(this, new Observer() { // from class: vd.c3
                public /* synthetic */ c3() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MoneyIncomeFragment.h1(Function1.this, obj);
                }
            });
        }
        AppViewModel G2 = G();
        if (G2 != null && (R = G2.R()) != null) {
            R.observe(this, new Observer() { // from class: vd.q2
                public /* synthetic */ q2() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MoneyIncomeFragment.k1(Function1.this, obj);
                }
            });
        }
        AppViewModel G3 = G();
        if (G3 != null && (Q = G3.Q()) != null) {
            Q.observe(this, new Observer() { // from class: vd.r2
                public /* synthetic */ r2() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MoneyIncomeFragment.l1(Function1.this, obj);
                }
            });
        }
        ((FragmentMoneyIncomeNewBinding) n()).switchButton.setOnClickListener(new View.OnClickListener() { // from class: vd.s2
            public /* synthetic */ s2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MoneyIncomeFragment.m1(MoneyIncomeFragment.this, view);
            }
        });
        ((FragmentMoneyIncomeNewBinding) n()).ivCoinsQuestion.setOnClickListener(new View.OnClickListener() { // from class: vd.t2
            public /* synthetic */ t2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MoneyIncomeFragment.n1(MoneyIncomeFragment.this, view);
            }
        });
        ((FragmentMoneyIncomeNewBinding) n()).tvNowExchange.setOnClickListener(new View.OnClickListener() { // from class: vd.u2
            public /* synthetic */ u2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MoneyIncomeFragment.o1(MoneyIncomeFragment.this, view);
            }
        });
        ((FragmentMoneyIncomeNewBinding) n()).tvWithdrawal.setOnClickListener(new View.OnClickListener() { // from class: vd.v2
            public /* synthetic */ v2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MoneyIncomeFragment.q1(MoneyIncomeFragment.this, view);
            }
        });
        ((FragmentMoneyIncomeNewBinding) n()).ctvMoney.setOnClickListener(new View.OnClickListener() { // from class: vd.w2
            public /* synthetic */ w2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MoneyIncomeFragment.X0(MoneyIncomeFragment.this, view);
            }
        });
        ((FragmentMoneyIncomeNewBinding) n()).tvMore.setOnClickListener(new View.OnClickListener() { // from class: vd.y2
            public /* synthetic */ y2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MoneyIncomeFragment.Y0(MoneyIncomeFragment.this, view);
            }
        });
        ((FragmentMoneyIncomeNewBinding) n()).tvCoinsNum.setOnClickListener(new View.OnClickListener() { // from class: vd.z2
            public /* synthetic */ z2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MoneyIncomeFragment.Z0(MoneyIncomeFragment.this, view);
            }
        });
        AppViewModel G4 = G();
        if (G4 != null && (O = G4.O()) != null) {
            O.observe(this, new Observer() { // from class: vd.d3
                public /* synthetic */ d3() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MoneyIncomeFragment.a1(Function1.this, obj);
                }
            });
        }
        AppViewModel G5 = G();
        if (G5 != null && (N = G5.N()) != null) {
            N.observe(this, new Observer() { // from class: vd.e3
                public /* synthetic */ e3() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MoneyIncomeFragment.b1(Function1.this, obj);
                }
            });
        }
        AppViewModel G6 = G();
        if (G6 != null && (W = G6.W()) != null) {
            W.observe(this, new Observer() { // from class: vd.f3
                public /* synthetic */ f3() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MoneyIncomeFragment.c1(Function1.this, obj);
                }
            });
        }
        I().y().observe(this, new Observer() { // from class: vd.g3
            public /* synthetic */ g3() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MoneyIncomeFragment.d1(Function1.this, obj);
            }
        });
        I().x().observe(this, new Observer() { // from class: vd.h3
            public /* synthetic */ h3() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MoneyIncomeFragment.e1(Function1.this, obj);
            }
        });
        I().z().observe(this, new Observer() { // from class: vd.i3
            public /* synthetic */ i3() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MoneyIncomeFragment.f1(Function1.this, obj);
            }
        });
        AppViewModel G7 = G();
        if (G7 != null && (a02 = G7.a0()) != null) {
            a02.observe(this, new Observer() { // from class: vd.n2
                public /* synthetic */ n2() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MoneyIncomeFragment.g1(Function1.this, obj);
                }
            });
        }
        AppViewModel G8 = G();
        if (G8 != null && (U = G8.U()) != null) {
            U.observe(this, new Observer() { // from class: vd.o2
                public /* synthetic */ o2() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MoneyIncomeFragment.i1(Function1.this, obj);
                }
            });
        }
        AppViewModel G9 = G();
        if (G9 == null || (T = G9.T()) == null) {
            return;
        }
        T.observe(this, new Observer() { // from class: vd.p2
            public /* synthetic */ p2() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MoneyIncomeFragment.j1(Function1.this, obj);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void X0(MoneyIncomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((FragmentMoneyIncomeNewBinding) this$0.n()).tvMore.performClick();
    }

    public static final void Y0(MoneyIncomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.F(this$0.getContext(), "收益明细");
        Context context = this$0.getContext();
        String str = this$0.I().getT8.a.f java.lang.String();
        int i10 = 0;
        if (str != null && StringsKt.contains$default((CharSequence) str, (CharSequence) "金币", false, 2, (Object) null)) {
            i10 = 1;
        }
        IncomeHistoryActivity.M2(context, i10 ^ 1);
    }

    public static final void Z0(MoneyIncomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.F(this$0.getContext(), "收益明细");
        IncomeHistoryActivity.M2(this$0.getContext(), 0);
    }

    public static final void a1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void b1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void c1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void d1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void e1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void f1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void g1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void h1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void i1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void j1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void k1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void l1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void m1(MoneyIncomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.E(this$0.getContext(), "签到提醒");
        if (MiConfigSingleton.b2().D1()) {
            MiConfigSingleton.b2().a3(false);
        } else if (h.e(this$0.getContext())) {
            MiConfigSingleton.b2().a3(true);
        } else {
            h.b(this$0.getActivity());
        }
        boolean D1 = MiConfigSingleton.b2().D1();
        AppViewModel G = this$0.G();
        if (G != null) {
            G.M0(D1);
        }
        ((FragmentMoneyIncomeNewBinding) this$0.n()).switchButton.setChecked(D1);
    }

    public static final void n1(MoneyIncomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.F(this$0.getContext(), "汇率说明");
        v0.Q0(this$0.getContext());
    }

    public static final void o1(MoneyIncomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.I().s() > 0) {
            ac.a.F(this$0.getContext(), "金币兑换弹窗-展示");
            i0.w0(this$0.getContext(), this$0.getString(R.string.confirm_message), this$0.P0(), new i0.l() { // from class: vd.a3
                public /* synthetic */ a3() {
                }

                @Override // l9.i0.l
                public final void a() {
                    MoneyIncomeFragment.p1(MoneyIncomeFragment.this);
                }
            });
        } else {
            t0.b(this$0.getContext(), "金币不够，再去看会小说吧");
            ac.a.F(this$0.getContext(), "金币兑换-不足");
        }
    }

    public static final void p1(MoneyIncomeFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I().L();
    }

    public static final void q1(MoneyIncomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.F(this$0.getContext(), "提现");
        i.Q(this$0.getActivity(), this$0.I().getT8.a.f java.lang.String(), 20001);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetTextI18n"})
    public final void s1() {
        MiTaskAccount B = I().B();
        if (B == null) {
            ((FragmentMoneyIncomeNewBinding) n()).ctvMoney.j(0.0f, 2);
            ((FragmentMoneyIncomeNewBinding) n()).tvCoinsNum.setText("金币收益0≈0.0元");
            return;
        }
        ((FragmentMoneyIncomeNewBinding) n()).ctvMoney.j(oe.f.m(Integer.valueOf(B.getMoney())), 2);
        int coins = B.getCoins();
        BigDecimal divide = new BigDecimal(coins).divide(new BigDecimal(10000));
        ((FragmentMoneyIncomeNewBinding) n()).tvCoinsNum.setText("金币收益" + coins + "≈" + divide + "元");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void t1() {
        Context context = getContext();
        if (context != null) {
            MissionSectionList missionSectionList = new MissionSectionList();
            ArrayList arrayList = new ArrayList();
            MissionSection missionSection = new MissionSection();
            missionSection.setTitle(context.getString(R.string.mission_recommend));
            missionSection.setMissionItems(I().E(context));
            MissionSection missionSection2 = new MissionSection();
            missionSection2.setTitle(context.getString(R.string.mission_fresh));
            missionSection2.setMissionItems(I().v(context));
            if (MiConfigSingleton.b2().Y() > 2 || (MiConfigSingleton.b2().e2().f0() && MiConfigSingleton.b2().e2().g0())) {
                Intrinsics.checkNotNullExpressionValue(missionSection.getMissionItems(), "getMissionItems(...)");
                if (!r5.isEmpty()) {
                    arrayList.add(missionSection);
                }
                Intrinsics.checkNotNullExpressionValue(missionSection2.getMissionItems(), "getMissionItems(...)");
                if (!r3.isEmpty()) {
                    arrayList.add(missionSection2);
                }
            } else {
                Intrinsics.checkNotNullExpressionValue(missionSection2.getMissionItems(), "getMissionItems(...)");
                if (!r5.isEmpty()) {
                    arrayList.add(missionSection2);
                }
                Intrinsics.checkNotNullExpressionValue(missionSection.getMissionItems(), "getMissionItems(...)");
                if (!r4.isEmpty()) {
                    arrayList.add(missionSection);
                }
            }
            if (!I().getHasBackKey()) {
                MissionSection missionSection3 = new MissionSection();
                missionSection3.setTitle(context.getString(R.string.mission_daily));
                missionSection3.setMissionItems(I().r(context));
                arrayList.add(missionSection3);
            }
            missionSectionList.setMissionSections(arrayList);
            if (missionSectionList.getMissionSections() != null) {
                ((FragmentMoneyIncomeNewBinding) n()).missionItems.removeAllViews();
                Iterator<MissionSection> it = missionSectionList.getMissionSections().iterator();
                while (it.hasNext()) {
                    MiConfigSingleton.b2().e2().h(getContext(), it.next(), ((FragmentMoneyIncomeNewBinding) n()).missionItems, new c.n() { // from class: vd.b3
                        public /* synthetic */ b3() {
                        }

                        @Override // com.martian.mibook.application.c.n
                        public final void a(MissionItem missionItem) {
                            MoneyIncomeFragment.u1(MoneyIncomeFragment.this, missionItem);
                        }
                    });
                }
            }
        }
    }

    public static final void u1(MoneyIncomeFragment this$0, MissionItem missionItem) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.U0(missionItem);
    }

    public static /* synthetic */ void w1(MoneyIncomeFragment moneyIncomeFragment, Integer num, MissionItem missionItem, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            missionItem = null;
        }
        moneyIncomeFragment.v1(num, missionItem);
    }

    public final void O0() {
        if (!MiConfigSingleton.b2().e2().e0() && this.startRate) {
            this.startRate = false;
            if (MartianRPUserManager.a() - this.rateTime >= 20000) {
                I().M();
            } else {
                t0.b(getActivity(), ExtKt.c("未检测到有效好评"));
            }
        }
    }

    public final Spanned P0() {
        int s10 = I().s();
        return Html.fromHtml("是否将<font color='red'>" + s10 + "金币</font>兑换成<font color='red'>" + oe.f.q(Integer.valueOf(I().t(s10))) + "元</font>？");
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMFragment
    @k
    /* renamed from: Q0 */
    public MissionCenterViewModel I() {
        return (MissionCenterViewModel) this.mViewModel.getValue();
    }

    public final void T0() {
        AppViewModel G;
        if (MiConfigSingleton.b2().G1().f(getActivity())) {
            ac.a.E(getContext(), "签到");
            BonusPollSignAdapter bonusPollSignAdapter = this.bonusPollSignAdapter;
            BonusPool bonusPool = bonusPollSignAdapter != null ? bonusPollSignAdapter.getBonusPool() : null;
            if (bonusPool == null) {
                AppViewModel G2 = G();
                if (G2 != null) {
                    G2.M();
                    return;
                }
                return;
            }
            if (bonusPool.getCheckinToday()) {
                t0.b(getContext(), bonusPool.getCheckinDays() == bonusPool.getFullCheckinDays() ? "今日已分红" : "今日已签到");
            } else {
                if (!MiConfigSingleton.b2().G1().f(getActivity()) || (G = G()) == null) {
                    return;
                }
                G.J();
            }
        }
    }

    public final void U0(@l MissionItem item) {
        if (item == null) {
            return;
        }
        if (item.getType() == 4) {
            ac.a.E(getContext(), "新手红包");
            MiConfigSingleton.b2().e2().Z(item);
            r1();
            return;
        }
        if (item.getType() == 0) {
            ac.a.E(getContext(), "小说任务");
            MiConfigSingleton.b2().e2().Z(item);
            e9.c.e(j2.f33262c, Integer.valueOf(j2.f33272m));
            return;
        }
        if (item.getType() == 9) {
            ac.a.E(getContext(), "发表评论");
            MiConfigSingleton.b2().e2().Z(item);
            e9.c.e(j2.f33262c, Integer.valueOf(j2.f33272m));
            return;
        }
        if (item.getType() == 10) {
            ac.a.E(getContext(), "五星好评");
            MiConfigSingleton.b2().e2().Z(item);
            if (MiConfigSingleton.b2().G1().g(getActivity(), 1013)) {
                org.codechimp.apprater.a.m(new d());
                org.codechimp.apprater.a.g(getContext());
                this.startRate = true;
                this.rateTime = MartianRPUserManager.a();
                return;
            }
            return;
        }
        if (item.getType() == 106 || item.getType() == 111) {
            MiConfigSingleton.b2().e2().Z(item);
            MiConfigSingleton.b2().e2().J0(getActivity(), new c.o() { // from class: vd.m2
                public /* synthetic */ m2() {
                }

                @Override // com.martian.mibook.application.c.o
                public final void a() {
                    MoneyIncomeFragment.V0(MoneyIncomeFragment.this);
                }
            });
        } else if (item.getType() == 13) {
            T0();
        } else {
            MiConfigSingleton.b2().e2().Y(getActivity(), item, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.base.BaseMVVMFragment
    public void i0() {
        if (ConfigSingleton.D().A0()) {
            ((FragmentMoneyIncomeNewBinding) n()).clExchangeLayout.setBackgroundResource(R.drawable.bg_mission_center_exchange_layout_night);
        } else {
            ((FragmentMoneyIncomeNewBinding) n()).clExchangeLayout.setBackgroundResource(R.drawable.bg_mission_center_exchange_layout_day);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        R0().b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.base.LazyFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((FragmentMoneyIncomeNewBinding) n()).switchButton.setChecked(MiConfigSingleton.b2().D1());
        s1();
        O0();
    }

    @Override // com.martian.mibook.mvvm.base.BaseFragment
    public void q(@l Bundle savedInstanceState) {
        W0();
        AppViewModel G = G();
        if (G != null) {
            G.M();
        }
        t1();
        s1();
        L0();
    }

    public final void r1() {
        if (MiConfigSingleton.b2().G1().f(getActivity())) {
            MiTaskAccount p22 = MiConfigSingleton.b2().p2();
            if (p22 == null || p22.getFreshRedpaper() <= 0) {
                t0.b(getActivity(), ExtKt.c("您已领取过"));
                return;
            }
            ac.a.G(getContext(), "新手红包-领取-请求");
            AppViewModel G = G();
            if (G != null) {
                G.s0();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void v1(Integer num, MissionItem missionItem) {
        Context context;
        if (num == null || (context = getContext()) == null || ((FragmentMoneyIncomeNewBinding) n()).missionItems.findViewWithTag(num) == null) {
            return;
        }
        if (missionItem == null) {
            missionItem = I().p(context, num.intValue());
        }
        MissionItem missionItem2 = missionItem;
        if (missionItem2 != null) {
            MiConfigSingleton.b2().e2().I(getContext(), missionItem2, ((FragmentMoneyIncomeNewBinding) n()).missionItems, true, null);
        }
    }
}
