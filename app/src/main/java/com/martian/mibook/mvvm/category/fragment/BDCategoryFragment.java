package com.martian.mibook.mvvm.category.fragment;

import ac.a;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.kuaishou.weapon.p0.t;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.widget.linkage.BaseLinkageItem;
import com.martian.mibook.databinding.FragmentCategoryBinding;
import com.martian.mibook.lib.yuewen.response.TYCategoryTagGroup;
import com.martian.mibook.lib.yuewen.response.TYCategoryTagItem;
import com.martian.mibook.mvvm.base.BaseMVVMFragment;
import com.martian.mibook.mvvm.category.adapter.BDCategoryChildAdapter;
import com.martian.mibook.mvvm.category.adapter.BDCategoryGroupAdapter;
import com.martian.mibook.mvvm.category.fragment.BDCategoryFragment;
import com.martian.mibook.mvvm.category.viewmodel.CategoryItemInfo;
import com.martian.mibook.mvvm.category.viewmodel.CategoryViewModel;
import e9.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l9.m0;
import wj.b;
import xi.k;
import xi.l;
import ya.e0;
import ya.j2;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0019\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0005J\u001f\u0010\u0014\u001a\u00020\u00062\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0017\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/martian/mibook/mvvm/category/fragment/BDCategoryFragment;", "Lcom/martian/mibook/mvvm/base/BaseMVVMFragment;", "Lcom/martian/mibook/databinding/FragmentCategoryBinding;", "Lcom/martian/mibook/mvvm/category/viewmodel/CategoryViewModel;", "<init>", "()V", "", "s0", "Landroid/os/Bundle;", "savedInstanceState", "q", "(Landroid/os/Bundle;)V", "y", "k", "Y", "i0", "onDestroyView", "", "Lcom/martian/mibook/lib/yuewen/response/TYCategoryTagGroup;", "tyCategoryTagGroups", "u0", "(Ljava/util/List;)V", "", "v0", "Le9/c;", "Le9/c;", "rxManager", "Lcom/martian/mibook/mvvm/category/adapter/BDCategoryGroupAdapter;", t.f11204d, "Lcom/martian/mibook/mvvm/category/adapter/BDCategoryGroupAdapter;", "categoryGroupAdapter", "Lcom/martian/mibook/mvvm/category/adapter/BDCategoryChildAdapter;", "m", "Lcom/martian/mibook/mvvm/category/adapter/BDCategoryChildAdapter;", "categoryChildAdapter", "n", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class BDCategoryFragment extends BaseMVVMFragment<FragmentCategoryBinding, CategoryViewModel> {

    /* renamed from: n, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k, reason: from kotlin metadata */
    @l
    public c rxManager;

    /* renamed from: l */
    @l
    public BDCategoryGroupAdapter categoryGroupAdapter;

    /* renamed from: m, reason: from kotlin metadata */
    @l
    public BDCategoryChildAdapter categoryChildAdapter;

    /* renamed from: com.martian.mibook.mvvm.category.fragment.BDCategoryFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @k
        public final BDCategoryFragment a(int i10, boolean z10) {
            BDCategoryFragment bDCategoryFragment = new BDCategoryFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("intent_ctype", i10);
            bundle.putBoolean(e0.f33163m0, z10);
            bDCategoryFragment.setArguments(bundle);
            return bDCategoryFragment;
        }

        public Companion() {
        }
    }

    public static final void A(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ FragmentCategoryBinding n0(BDCategoryFragment bDCategoryFragment) {
        return (FragmentCategoryBinding) bDCategoryFragment.n();
    }

    public static final void r0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void s0() {
        if (I().getIsHomepage()) {
            c cVar = new c();
            this.rxManager = cVar;
            Intrinsics.checkNotNull(cVar);
            cVar.c(j2.M, new b() { // from class: sc.a
                public /* synthetic */ a() {
                }

                @Override // wj.b
                public final void call(Object obj) {
                    BDCategoryFragment.t0(BDCategoryFragment.this, (Integer) obj);
                }
            });
        }
    }

    public static final void t0(BDCategoryFragment this$0, Integer num) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (num == null) {
            return;
        }
        if (num.intValue() == j2.N) {
            this$0.I().r(this$0.I().getCType() == 1 ? 2 : 1);
            this$0.Y();
        }
    }

    public static final void z(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMFragment
    public void Y() {
        if (getIsLoading()) {
            return;
        }
        I().n(I().getCType());
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMFragment
    public void i0() {
    }

    @Override // com.martian.mibook.mvvm.base.LazyFragment
    public void k() {
        super.k();
        s0();
        Y();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        c cVar = this.rxManager;
        if (cVar != null) {
            cVar.b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.base.BaseFragment
    public void q(@l Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            I().r(arguments.getInt("intent_ctype", 1));
            I().s(arguments.getBoolean(e0.f33163m0, false));
        }
        ((FragmentCategoryBinding) n()).linkageRecyclerview.setPadding(0, I().getIsHomepage() ? ConfigSingleton.i(44.0f) + K() : 0, 0, 0);
        e0(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void u0(List<TYCategoryTagGroup> tyCategoryTagGroups) {
        if (m0.c(getActivity())) {
            return;
        }
        List<TYCategoryTagGroup> list = tyCategoryTagGroups;
        if (list == null || list.isEmpty()) {
            BaseMVVMFragment.P(this, "", null, 2, null);
            return;
        }
        Iterator<TYCategoryTagGroup> it = tyCategoryTagGroups.iterator();
        while (it.hasNext()) {
            List<TYCategoryTagItem> items = it.next().getItems();
            if (items == null || items.isEmpty()) {
                it.remove();
            }
        }
        ((FragmentCategoryBinding) n()).linkageRecyclerview.setVisibility(0);
        v0(tyCategoryTagGroups);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void v0(List<? extends TYCategoryTagGroup> tyCategoryTagGroups) {
        a.K(getActivity(), I().getCType() == 2 ? "女频分类" : "男频分类", "展示");
        ArrayList arrayList = new ArrayList();
        int size = tyCategoryTagGroups.size();
        for (int i10 = 0; i10 < size; i10++) {
            TYCategoryTagGroup tYCategoryTagGroup = tyCategoryTagGroups.get(i10);
            if (!TextUtils.isEmpty(tYCategoryTagGroup.getName())) {
                arrayList.add(new CategoryItemInfo(tYCategoryTagGroup.getName()));
                arrayList.add(new CategoryItemInfo(tYCategoryTagGroup.getName(), tYCategoryTagGroup.getName(), null, -1));
                Iterator<TYCategoryTagItem> it = tYCategoryTagGroup.getItems().iterator();
                while (it.hasNext()) {
                    arrayList.add(new CategoryItemInfo(tYCategoryTagGroup.getName(), tYCategoryTagGroup.getName(), it.next(), tYCategoryTagGroup.getLayoutType()));
                }
            }
        }
        if (this.categoryGroupAdapter == null) {
            this.categoryGroupAdapter = new BDCategoryGroupAdapter();
        }
        if (this.categoryChildAdapter == null) {
            this.categoryChildAdapter = new BDCategoryChildAdapter();
        }
        BDCategoryChildAdapter bDCategoryChildAdapter = this.categoryChildAdapter;
        if (bDCategoryChildAdapter != null) {
            bDCategoryChildAdapter.w(I().getCType());
        }
        LinkageRecyclerView linkageRecyclerView = ((FragmentCategoryBinding) n()).linkageRecyclerview;
        List<BaseLinkageItem> mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        BDCategoryGroupAdapter bDCategoryGroupAdapter = this.categoryGroupAdapter;
        Intrinsics.checkNotNull(bDCategoryGroupAdapter);
        BDCategoryChildAdapter bDCategoryChildAdapter2 = this.categoryChildAdapter;
        Intrinsics.checkNotNull(bDCategoryChildAdapter2);
        linkageRecyclerView.d(mutableList, bDCategoryGroupAdapter, bDCategoryChildAdapter2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.base.BaseMVVMFragment
    public void y() {
        super.y();
        ((FragmentCategoryBinding) n()).loadingTip.setOnReloadListener(new Function0<Unit>() { // from class: com.martian.mibook.mvvm.category.fragment.BDCategoryFragment$addObserver$1
            public BDCategoryFragment$addObserver$1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke */
            public final void invoke2() {
                BDCategoryFragment.this.Y();
            }
        });
        I().g().observe(this, new Observer() { // from class: sc.b
            public /* synthetic */ b() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BDCategoryFragment.z(Function1.this, obj);
            }
        });
        I().h().observe(this, new Observer() { // from class: sc.c
            public /* synthetic */ c() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BDCategoryFragment.A(Function1.this, obj);
            }
        });
        I().o().observe(this, new Observer() { // from class: sc.d
            public /* synthetic */ d() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BDCategoryFragment.r0(Function1.this, obj);
            }
        });
    }
}
