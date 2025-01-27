package com.martian.mibook.mvvm.read.activity;

import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.martian.libmars.databinding.LayoutToolbarBinding;
import com.martian.mibook.R;
import com.martian.mibook.databinding.ActivityRecommendBookFriendsBinding;
import com.martian.mibook.mvvm.base.BaseMVVMActivity;
import com.martian.mibook.mvvm.net.result.TYBookTopUser;
import com.martian.mibook.mvvm.read.activity.RecommendBookFriendsActivity;
import com.martian.mibook.mvvm.read.adapter.RecommendBookFriendsAdapter;
import com.martian.mibook.mvvm.read.viewmodel.RecommendBookFriendsViewModel;
import com.martian.mibook.mvvm.widget.MiClassicsFooter;
import com.martian.mibook.mvvm.widget.MiClassicsHeader;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sf.h;
import xi.k;
import xi.l;
import ya.e0;

@Route(path = kc.a.f27759o)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u001f\u0010\f\u001a\u00020\u00062\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u0019\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0005J\u0019\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0005J#\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/martian/mibook/mvvm/read/activity/RecommendBookFriendsActivity;", "Lcom/martian/mibook/mvvm/base/BaseMVVMActivity;", "Lcom/martian/mibook/databinding/ActivityRecommendBookFriendsBinding;", "Lcom/martian/mibook/mvvm/read/viewmodel/RecommendBookFriendsViewModel;", "<init>", "()V", "", "initView", "R1", "", "Lcom/martian/mibook/mvvm/net/result/TYBookTopUser;", "bookTopUsers", "V1", "(Ljava/util/List;)V", "S1", "Lcom/martian/libmars/databinding/LayoutToolbarBinding;", "toolbarBinding", "s1", "(Lcom/martian/libmars/databinding/LayoutToolbarBinding;)V", "p1", "Landroid/os/Bundle;", "savedInstanceState", "c1", "(Landroid/os/Bundle;)V", "k1", "", "isLoadMore", "showLoading", "T1", "(ZZ)V", "h", "Z", "loadMoreFail", "Lcom/martian/mibook/mvvm/read/adapter/RecommendBookFriendsAdapter;", "i", "Lcom/martian/mibook/mvvm/read/adapter/RecommendBookFriendsAdapter;", "mAdapter", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class RecommendBookFriendsActivity extends BaseMVVMActivity<ActivityRecommendBookFriendsBinding, RecommendBookFriendsViewModel> {

    /* renamed from: h, reason: from kotlin metadata */
    public boolean loadMoreFail;

    /* renamed from: i, reason: from kotlin metadata */
    @l
    public RecommendBookFriendsAdapter mAdapter;

    public static final class a implements h {
        public a() {
        }

        @Override // sf.g
        public void b(@k pf.f refreshLayout) {
            Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
            RecommendBookFriendsActivity.this.R1();
        }

        @Override // sf.e
        public void p(@k pf.f refreshLayout) {
            Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
            if (!RecommendBookFriendsActivity.this.loadMoreFail) {
                RecommendBookFriendsViewModel m12 = RecommendBookFriendsActivity.this.m1();
                m12.z(m12.getPageIndex() + 1);
            }
            RecommendBookFriendsActivity.U1(RecommendBookFriendsActivity.this, true, false, 2, null);
        }
    }

    public static final class b implements RecommendBookFriendsAdapter.a {
        public b() {
        }

        @Override // com.martian.mibook.mvvm.read.adapter.RecommendBookFriendsAdapter.a
        public void a(@l TYBookTopUser tYBookTopUser) {
            kc.b.k(RecommendBookFriendsActivity.this.m1().getSourceName(), RecommendBookFriendsActivity.this.m1().getSourceId(), tYBookTopUser != null ? tYBookTopUser.getCuid() : null, tYBookTopUser != null ? tYBookTopUser.getNickname() : null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ActivityRecommendBookFriendsBinding K1(RecommendBookFriendsActivity recommendBookFriendsActivity) {
        return (ActivityRecommendBookFriendsBinding) recommendBookFriendsActivity.a1();
    }

    public static final void O1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void P1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void Q1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void R1() {
        m1().z(0);
        U1(this, false, false, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void S1() {
        this.loadMoreFail = false;
        ((ActivityRecommendBookFriendsBinding) a1()).refreshLayout.p();
        ((ActivityRecommendBookFriendsBinding) a1()).refreshLayout.S();
        ((ActivityRecommendBookFriendsBinding) a1()).refreshLayout.n();
    }

    public static /* synthetic */ void U1(RecommendBookFriendsActivity recommendBookFriendsActivity, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            RecommendBookFriendsAdapter recommendBookFriendsAdapter = recommendBookFriendsActivity.mAdapter;
            z11 = (recommendBookFriendsAdapter != null ? recommendBookFriendsAdapter.getPageSize() : 0) <= 0;
        }
        recommendBookFriendsActivity.T1(z10, z11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V1(List<TYBookTopUser> bookTopUsers) {
        S1();
        if (this.mAdapter == null) {
            this.mAdapter = new RecommendBookFriendsAdapter();
            ((ActivityRecommendBookFriendsBinding) a1()).recyclerview.setAdapter(this.mAdapter);
            RecommendBookFriendsAdapter recommendBookFriendsAdapter = this.mAdapter;
            if (recommendBookFriendsAdapter != null) {
                recommendBookFriendsAdapter.o(new b());
            }
        }
        if (m1().getPageIndex() != 0) {
            List<TYBookTopUser> list = bookTopUsers;
            if (list == null || list.isEmpty()) {
                ((ActivityRecommendBookFriendsBinding) a1()).refreshLayout.e0();
                return;
            }
            RecommendBookFriendsAdapter recommendBookFriendsAdapter2 = this.mAdapter;
            if (recommendBookFriendsAdapter2 != null) {
                recommendBookFriendsAdapter2.l(bookTopUsers);
                return;
            }
            return;
        }
        List<TYBookTopUser> list2 = bookTopUsers;
        if (list2 == null || list2.isEmpty()) {
            ((ActivityRecommendBookFriendsBinding) a1()).recyclerview.setVisibility(8);
            z1("", ((ActivityRecommendBookFriendsBinding) a1()).rvLoadedTip);
            return;
        }
        C1(((ActivityRecommendBookFriendsBinding) a1()).rvLoadedTip);
        RecommendBookFriendsAdapter recommendBookFriendsAdapter3 = this.mAdapter;
        if (recommendBookFriendsAdapter3 != null) {
            recommendBookFriendsAdapter3.p(bookTopUsers);
        }
        ((ActivityRecommendBookFriendsBinding) a1()).recyclerview.setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        ((ActivityRecommendBookFriendsBinding) a1()).recyclerview.setLayoutManager(new LinearLayoutManager(this));
        ((ActivityRecommendBookFriendsBinding) a1()).refreshLayout.O(new MiClassicsHeader((Context) this, (Integer) 1));
        ((ActivityRecommendBookFriendsBinding) a1()).refreshLayout.U(new MiClassicsFooter(this, 1, false, 4, null));
        ((ActivityRecommendBookFriendsBinding) a1()).refreshLayout.B(new a());
    }

    public final void T1(boolean isLoadMore, boolean showLoading) {
        m1().t(showLoading, isLoadMore);
    }

    @Override // com.martian.mibook.mvvm.base.BaseActivity
    public void c1(@l Bundle savedInstanceState) {
        initView();
        R1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity
    public void k1() {
        m1().h().observe(this, new Observer() { // from class: bd.z0
            public /* synthetic */ z0() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RecommendBookFriendsActivity.O1(Function1.this, obj);
            }
        });
        ((ActivityRecommendBookFriendsBinding) a1()).rvLoadedTip.setOnReloadListener(new Function0<Unit>() { // from class: com.martian.mibook.mvvm.read.activity.RecommendBookFriendsActivity$addObserver$2
            public RecommendBookFriendsActivity$addObserver$2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke */
            public final void invoke2() {
                RecommendBookFriendsActivity.this.R1();
            }
        });
        m1().g().observe(this, new Observer() { // from class: bd.a1
            public /* synthetic */ a1() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RecommendBookFriendsActivity.P1(Function1.this, obj);
            }
        });
        m1().o().observe(this, new Observer() { // from class: bd.b1
            public /* synthetic */ b1() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RecommendBookFriendsActivity.Q1(Function1.this, obj);
            }
        });
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity
    public void p1() {
        super.p1();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            m1().C(extras.getString(e0.f33173r0));
            m1().B(extras.getString(e0.f33175s0));
        }
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity
    public void s1(@l LayoutToolbarBinding toolbarBinding) {
        super.s1(toolbarBinding);
        if (toolbarBinding != null) {
            toolbarBinding.f12249i.setText(getString(R.string.recommend_book_friends));
        }
    }
}
