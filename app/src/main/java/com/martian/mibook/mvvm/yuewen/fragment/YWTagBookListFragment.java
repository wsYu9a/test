package com.martian.mibook.mvvm.yuewen.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.google.android.material.appbar.AppBarLayout;
import com.kuaishou.weapon.p0.t;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.mibook.R;
import com.martian.mibook.databinding.FragmentCategoryBookListBinding;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.yuewen.response.TYTag;
import com.martian.mibook.lib.yuewen.response.YWCategoryBookList;
import com.martian.mibook.mvvm.base.BaseMVVMFragment;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.request.YWCategoryBookListParams;
import com.martian.mibook.mvvm.widget.MiClassicsFooter;
import com.martian.mibook.mvvm.widget.MiClassicsHeader;
import com.martian.mibook.mvvm.yuewen.adapter.TYBookItemListAdapter;
import com.martian.mibook.mvvm.yuewen.fragment.YWTagBookListFragment;
import com.martian.mibook.mvvm.yuewen.viewmodel.TagBookListViewModel;
import com.martian.mibook.ui.FlexboxTagLayout;
import com.umeng.analytics.pro.bt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l9.m0;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001O\u0018\u0000 S2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001TB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u001f\u0010\u000e\u001a\u00020\u00062\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u0005J\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u001dH\u0002¢\u0006\u0004\b \u0010\u001fJ\u000f\u0010!\u001a\u00020\u001dH\u0002¢\u0006\u0004\b!\u0010\u001fJ\u000f\u0010\"\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\"\u0010\u001fJ\u000f\u0010#\u001a\u00020\u001dH\u0002¢\u0006\u0004\b#\u0010\u001fJ\u000f\u0010$\u001a\u00020\u001dH\u0002¢\u0006\u0004\b$\u0010\u001fJ\u0019\u0010'\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0006H\u0016¢\u0006\u0004\b)\u0010\u0005J\u000f\u0010*\u001a\u00020\u0006H\u0016¢\u0006\u0004\b*\u0010\u0005R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001d0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u001d0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010-R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u001d0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010-R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\u001d0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010-R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\u001d0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010-R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u001d0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u0010-R\u0016\u0010:\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010=R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010-R\u0016\u0010C\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010=R\u0016\u0010E\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010=R\u0016\u0010G\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010=R\u0016\u0010I\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010=R\u0016\u0010J\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010=R\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010R\u001a\u00020O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010Q¨\u0006U"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/fragment/YWTagBookListFragment;", "Lcom/martian/mibook/mvvm/base/BaseMVVMFragment;", "Lcom/martian/mibook/databinding/FragmentCategoryBookListBinding;", "Lcom/martian/mibook/mvvm/yuewen/viewmodel/TagBookListViewModel;", "<init>", "()V", "", "b1", "Z0", "O0", "e1", "", "Lcom/martian/mibook/lib/yuewen/response/TYTag;", "tyTags", "a1", "(Ljava/util/List;)V", "", "isLoadMore", "showLoading", "R0", "(ZZ)V", "Lcom/martian/mibook/lib/yuewen/response/YWCategoryBookList;", "bookList", "g1", "(Lcom/martian/mibook/lib/yuewen/response/YWCategoryBookList;)V", "P0", "canScroll", "f1", "(Z)V", "", "Q0", "()Ljava/lang/String;", "W0", "V0", "Y0", "U0", "X0", "Landroid/os/Bundle;", "savedInstanceState", "q", "(Landroid/os/Bundle;)V", "y", "i0", "", "k", "Ljava/util/List;", "categoryTitle", t.f11204d, "numberList", "m", "statusList", "n", "orderList", "o", "completeList", "p", "publicList", "Z", "loadMoreFail", "", t.f11211k, "I", "pageIndex", "s", "pageSize", bt.aO, "u", "numberPosition", "v", "statusPosition", IAdInterListener.AdReqParam.WIDTH, "completePosition", "x", "publicPosition", "orderPosition", "Lcom/martian/mibook/mvvm/yuewen/adapter/TYBookItemListAdapter;", bt.aJ, "Lcom/martian/mibook/mvvm/yuewen/adapter/TYBookItemListAdapter;", "mAdapter", "com/martian/mibook/mvvm/yuewen/fragment/YWTagBookListFragment$i", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/martian/mibook/mvvm/yuewen/fragment/YWTagBookListFragment$i;", "offsetChangedListener", "B", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class YWTagBookListFragment extends BaseMVVMFragment<FragmentCategoryBookListBinding, TagBookListViewModel> {

    /* renamed from: B, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    @k
    public static final String C = "intent_ctype";

    @k
    public static final String D = "intent_expose_type";

    @k
    public static final String E = "INTENT_TAG";

    /* renamed from: q, reason: from kotlin metadata */
    public boolean loadMoreFail;

    /* renamed from: r */
    public int pageIndex;

    /* renamed from: t */
    @l
    public List<? extends TYTag> tyTags;

    /* renamed from: u, reason: from kotlin metadata */
    public int numberPosition;

    /* renamed from: v, reason: from kotlin metadata */
    public int statusPosition;

    /* renamed from: w */
    public int completePosition;

    /* renamed from: x, reason: from kotlin metadata */
    public int publicPosition;

    /* renamed from: y, reason: from kotlin metadata */
    public int orderPosition;

    /* renamed from: z */
    @l
    public TYBookItemListAdapter mAdapter;

    /* renamed from: k, reason: from kotlin metadata */
    @k
    public final List<String> categoryTitle = new ArrayList();

    /* renamed from: l */
    @k
    public final List<String> numberList = new ArrayList();

    /* renamed from: m, reason: from kotlin metadata */
    @k
    public final List<String> statusList = new ArrayList();

    /* renamed from: n, reason: from kotlin metadata */
    @k
    public final List<String> orderList = new ArrayList();

    /* renamed from: o, reason: from kotlin metadata */
    @k
    public final List<String> completeList = new ArrayList();

    /* renamed from: p, reason: from kotlin metadata */
    @k
    public final List<String> publicList = new ArrayList();

    /* renamed from: s, reason: from kotlin metadata */
    public int pageSize = 10;

    /* renamed from: A */
    @k
    public final i offsetChangedListener = new i();

    /* renamed from: com.martian.mibook.mvvm.yuewen.fragment.YWTagBookListFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @k
        public final YWTagBookListFragment a() {
            return new YWTagBookListFragment();
        }

        public Companion() {
        }
    }

    public static final class b implements FlexboxTagLayout.a {
        public b() {
        }

        @Override // com.martian.mibook.ui.FlexboxTagLayout.a
        public void a(@k String title, int i10) {
            Intrinsics.checkNotNullParameter(title, "title");
            YWTagBookListFragment.this.orderPosition = i10;
            YWTagBookListFragment.this.O0();
        }
    }

    public static final class c implements FlexboxTagLayout.a {
        public c() {
        }

        @Override // com.martian.mibook.ui.FlexboxTagLayout.a
        public void a(@k String title, int i10) {
            Intrinsics.checkNotNullParameter(title, "title");
            YWTagBookListFragment.this.O0();
        }
    }

    public static final class d implements FlexboxTagLayout.a {
        public d() {
        }

        @Override // com.martian.mibook.ui.FlexboxTagLayout.a
        public void a(@k String title, int i10) {
            Intrinsics.checkNotNullParameter(title, "title");
            YWTagBookListFragment.this.numberPosition = i10;
            YWTagBookListFragment.this.O0();
        }
    }

    public static final class e implements FlexboxTagLayout.a {
        public e() {
        }

        @Override // com.martian.mibook.ui.FlexboxTagLayout.a
        public void a(@k String title, int i10) {
            Intrinsics.checkNotNullParameter(title, "title");
            YWTagBookListFragment.this.statusPosition = i10;
            YWTagBookListFragment.this.O0();
        }
    }

    public static final class f implements FlexboxTagLayout.a {
        public f() {
        }

        @Override // com.martian.mibook.ui.FlexboxTagLayout.a
        public void a(@k String title, int i10) {
            Intrinsics.checkNotNullParameter(title, "title");
            YWTagBookListFragment.this.completePosition = i10;
            YWTagBookListFragment.this.O0();
        }
    }

    public static final class g implements FlexboxTagLayout.a {
        public g() {
        }

        @Override // com.martian.mibook.ui.FlexboxTagLayout.a
        public void a(@k String title, int i10) {
            Intrinsics.checkNotNullParameter(title, "title");
            YWTagBookListFragment.this.publicPosition = i10;
            YWTagBookListFragment.this.O0();
        }
    }

    public static final class h implements sf.h {
        public h() {
        }

        @Override // sf.g
        public void b(@k pf.f refreshLayout) {
            Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
            YWTagBookListFragment.this.O0();
        }

        @Override // sf.e
        public void p(@k pf.f refreshLayout) {
            Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
            if (!YWTagBookListFragment.this.loadMoreFail) {
                YWTagBookListFragment.this.pageIndex++;
            }
            YWTagBookListFragment.T0(YWTagBookListFragment.this, true, false, 2, null);
        }
    }

    public static final class i implements AppBarLayout.OnOffsetChangedListener {

        /* renamed from: a */
        public boolean f15716a;

        /* renamed from: b */
        public boolean f15717b;

        /* renamed from: c */
        @l
        public ObjectAnimator f15718c;

        /* renamed from: d */
        @l
        public ObjectAnimator f15719d;

        public static final class a extends AnimatorListenerAdapter {

            /* renamed from: b */
            public final /* synthetic */ View f15721b;

            /* renamed from: c */
            public final /* synthetic */ i f15722c;

            public a(View view, i iVar) {
                this.f15721b = view;
                this.f15722c = iVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@k Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationEnd(animation);
                this.f15721b.setVisibility(8);
                this.f15722c.f15717b = false;
            }
        }

        public i() {
        }

        public final ObjectAnimator b(View view, String str, float... fArr) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, str, Arrays.copyOf(fArr, fArr.length));
            ofFloat.setDuration(400L);
            Intrinsics.checkNotNull(ofFloat);
            return ofFloat;
        }

        public final void c(View view) {
            this.f15716a = true;
            YWTagBookListFragment.t0(YWTagBookListFragment.this).tvFlg.setText(ExtKt.c(YWTagBookListFragment.this.Q0()));
            if (view.getVisibility() == 0) {
                this.f15716a = false;
                return;
            }
            view.setVisibility(0);
            ObjectAnimator b10 = b(view, "alpha", 0.0f, 1.0f);
            this.f15718c = b10;
            g(b10);
        }

        public final void d(View view) {
            this.f15717b = true;
            if (view.getVisibility() == 8) {
                this.f15717b = false;
                return;
            }
            ObjectAnimator b10 = b(view, "alpha", 1.0f, 0.0f);
            this.f15719d = b10;
            if (b10 != null) {
                b10.addListener(new a(view, this));
            }
            g(this.f15719d);
        }

        public final void e() {
            if (this.f15717b) {
                ObjectAnimator objectAnimator = this.f15719d;
                if (objectAnimator != null) {
                    objectAnimator.cancel();
                }
                this.f15717b = false;
            }
            if (this.f15716a) {
                return;
            }
            ThemeLinearLayout llCeiling = YWTagBookListFragment.t0(YWTagBookListFragment.this).llCeiling;
            Intrinsics.checkNotNullExpressionValue(llCeiling, "llCeiling");
            c(llCeiling);
        }

        public final void f() {
            if (this.f15716a) {
                ObjectAnimator objectAnimator = this.f15718c;
                if (objectAnimator != null) {
                    objectAnimator.cancel();
                }
                this.f15716a = false;
            }
            if (this.f15717b) {
                return;
            }
            ThemeLinearLayout llCeiling = YWTagBookListFragment.t0(YWTagBookListFragment.this).llCeiling;
            Intrinsics.checkNotNullExpressionValue(llCeiling, "llCeiling");
            d(llCeiling);
        }

        public final void g(ObjectAnimator objectAnimator) {
            if (objectAnimator != null) {
                objectAnimator.start();
            }
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(@k AppBarLayout appBarLayout, int i10) {
            Intrinsics.checkNotNullParameter(appBarLayout, "appBarLayout");
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int abs = (int) Math.abs(i10 * 1.0f);
            if (abs == 0) {
                return;
            }
            if (abs >= totalScrollRange) {
                e();
            } else {
                f();
            }
        }
    }

    public static final void I0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void J0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void L0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void M0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void O0() {
        this.pageIndex = 0;
        T0(this, false, false, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void P0() {
        this.loadMoreFail = false;
        ((FragmentCategoryBookListBinding) n()).refreshLayout.p();
        ((FragmentCategoryBookListBinding) n()).refreshLayout.S();
        ((FragmentCategoryBookListBinding) n()).refreshLayout.n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String Q0() {
        String str;
        if (((FragmentCategoryBookListBinding) n()).flexboxCategory.getMSelectPosition() != 0) {
            str = ((Object) this.categoryTitle.get(((FragmentCategoryBookListBinding) n()).flexboxCategory.getMSelectPosition())) + "·";
        } else {
            str = "";
        }
        if (Intrinsics.areEqual(I().getCom.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_TAG java.lang.String(), Book.STATUS_FINISHED)) {
            return str + V0() + U0() + W0();
        }
        if (Intrinsics.areEqual(I().getCom.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_TAG java.lang.String(), "新书")) {
            return str + V0() + X0() + W0();
        }
        return str + V0() + Y0() + W0();
    }

    public static /* synthetic */ void T0(YWTagBookListFragment yWTagBookListFragment, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            TYBookItemListAdapter tYBookItemListAdapter = yWTagBookListFragment.mAdapter;
            z11 = (tYBookItemListAdapter != null ? tYBookItemListAdapter.getPageSize() : 0) <= 0;
        }
        yWTagBookListFragment.R0(z10, z11);
    }

    private final String V0() {
        int i10 = this.numberPosition;
        if (i10 == 1) {
            return getString(R.string.number_word1) + "·";
        }
        if (i10 == 2) {
            return getString(R.string.number_word2) + "·";
        }
        if (i10 != 3) {
            return "";
        }
        return getString(R.string.number_word3) + "·";
    }

    private final String W0() {
        if (m0.c(getActivity())) {
            return "";
        }
        int i10 = this.orderPosition;
        String string = i10 != 1 ? i10 != 2 ? getString(R.string.top_search) : getString(R.string.grade) : getString(R.string.yw_finished_books_recently);
        Intrinsics.checkNotNull(string);
        return string;
    }

    private final String Y0() {
        int i10 = this.statusPosition;
        if (i10 == 1) {
            return getString(R.string.bookstores_finish) + "·";
        }
        if (i10 == 2) {
            return getString(R.string.serialise) + "·";
        }
        if (i10 != 3) {
            return "";
        }
        return getString(R.string.bookstores_fresh) + "·";
    }

    private final void Z0() {
        I().o(new YWTagBookListFragment$initData$1(this, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void b1() {
        String a10 = wd.a.f31692a.a(I().getExposeType());
        if (!ba.l.q(a10)) {
            ac.a.V(getActivity(), a10 + "-" + getTag());
        }
        ((FragmentCategoryBookListBinding) n()).recyclerviewTagBooks.setLayoutManager(new LinearLayoutManager(getContext()));
        ((FragmentCategoryBookListBinding) n()).refreshLayout.O(new MiClassicsHeader(getContext(), null, 2, null));
        ((FragmentCategoryBookListBinding) n()).refreshLayout.j0(false);
        ((FragmentCategoryBookListBinding) n()).refreshLayout.U(new MiClassicsFooter(getContext(), null, false, 6, null));
        ((FragmentCategoryBookListBinding) n()).refreshLayout.B(new h());
        ((FragmentCategoryBookListBinding) n()).llCeiling.setOnClickListener(new View.OnClickListener() { // from class: vd.n4
            public /* synthetic */ n4() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YWTagBookListFragment.c1(YWTagBookListFragment.this, view);
            }
        });
        ((FragmentCategoryBookListBinding) n()).appbarLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: vd.o4
            public /* synthetic */ o4() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                YWTagBookListFragment.d1(YWTagBookListFragment.this);
            }
        });
        ((FragmentCategoryBookListBinding) n()).appbarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) this.offsetChangedListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void c1(YWTagBookListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TYBookItemListAdapter tYBookItemListAdapter = this$0.mAdapter;
        if ((tYBookItemListAdapter != null ? tYBookItemListAdapter.getPageSize() : 0) <= 100) {
            ((FragmentCategoryBookListBinding) this$0.n()).recyclerviewTagBooks.smoothScrollToPosition(0);
        } else {
            ((FragmentCategoryBookListBinding) this$0.n()).recyclerviewTagBooks.scrollToPosition(0);
        }
        ((FragmentCategoryBookListBinding) this$0.n()).appbarLayout.setExpanded(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void d1(YWTagBookListFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewGroup.LayoutParams layoutParams = ((FragmentCategoryBookListBinding) this$0.n()).rvLoadedTip.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) layoutParams).height = ((FragmentCategoryBookListBinding) this$0.n()).coordinator.getHeight() - ((FragmentCategoryBookListBinding) this$0.n()).appbarLayout.getHeight();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f1(boolean canScroll) {
        ((FragmentCategoryBookListBinding) n()).refreshLayout.N(canScroll);
        ViewGroup.LayoutParams layoutParams = ((FragmentCategoryBookListBinding) n()).llTopFilter.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
        ((AppBarLayout.LayoutParams) layoutParams).setScrollFlags(canScroll ? 3 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ FragmentCategoryBookListBinding t0(YWTagBookListFragment yWTagBookListFragment) {
        return (FragmentCategoryBookListBinding) yWTagBookListFragment.n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R0(boolean isLoadMore, boolean showLoading) {
        YWCategoryBookListParams yWCategoryBookListParams;
        YWTagBookListFragment yWTagBookListFragment;
        int i10;
        TYTag tYTag;
        YWCategoryBookListParams yWCategoryBookListParams2 = new YWCategoryBookListParams(null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, 16383, null);
        String d10 = ExtKt.d(I().getCom.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_TAG java.lang.String());
        if (Intrinsics.areEqual(d10, Book.STATUS_FINISHED) || Intrinsics.areEqual(d10, "新书")) {
            d10 = null;
        }
        yWCategoryBookListParams2.setTags(d10);
        if (((FragmentCategoryBookListBinding) n()).flexboxCategory.getMSelectPosition() > 0) {
            int mSelectPosition = ((FragmentCategoryBookListBinding) n()).flexboxCategory.getMSelectPosition();
            yWCategoryBookListParams = yWCategoryBookListParams2;
            yWTagBookListFragment = this;
            List<? extends TYTag> list = yWTagBookListFragment.tyTags;
            if (mSelectPosition <= (list != null ? list.size() : 0)) {
                List<? extends TYTag> list2 = yWTagBookListFragment.tyTags;
                if (list2 == null || (tYTag = list2.get(((FragmentCategoryBookListBinding) n()).flexboxCategory.getMSelectPosition() - 1)) == null || (i10 = tYTag.getCategoryId()) == null) {
                    i10 = 0;
                }
                yWCategoryBookListParams.setCategoryId(i10);
            }
        } else {
            yWCategoryBookListParams = yWCategoryBookListParams2;
            yWTagBookListFragment = this;
        }
        yWCategoryBookListParams.setFreeType(Integer.valueOf(I().getCType()));
        yWCategoryBookListParams.setPage(yWTagBookListFragment.pageIndex);
        yWCategoryBookListParams.setPageSize(yWTagBookListFragment.pageSize);
        yWCategoryBookListParams.setWordCount(Integer.valueOf(yWTagBookListFragment.numberPosition));
        yWCategoryBookListParams.setStatusPosition(Integer.valueOf(yWTagBookListFragment.statusPosition));
        yWCategoryBookListParams.setCompletePosition(Integer.valueOf(yWTagBookListFragment.completePosition));
        yWCategoryBookListParams.setPublicPosition(Integer.valueOf(yWTagBookListFragment.publicPosition));
        yWCategoryBookListParams.setOrderPosition(Integer.valueOf(yWTagBookListFragment.orderPosition));
        yWCategoryBookListParams.setFrom(Integer.valueOf(I().getExposeType()));
        I().p(yWCategoryBookListParams, showLoading, isLoadMore);
    }

    public final String U0() {
        int i10 = this.completePosition;
        if (i10 == 1) {
            return getString(R.string.completed_within_one_month) + "·";
        }
        if (i10 == 2) {
            return getString(R.string.completed_within_half_a_year) + "·";
        }
        if (i10 != 3) {
            return "";
        }
        return getString(R.string.completed_within_one_year) + "·";
    }

    public final String X0() {
        int i10 = this.publicPosition;
        if (i10 == 1) {
            return getString(R.string.on_shelves_within_three_months) + "·";
        }
        if (i10 != 2) {
            return "";
        }
        return getString(R.string.on_shelves_within_six_months) + "·";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a1(List<? extends TYTag> tyTags) {
        Unit unit;
        if (m0.c(getActivity())) {
            return;
        }
        e1();
        List<String> list = this.numberList;
        String string = getString(R.string.withdraw_money_all);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        list.add(string);
        List<String> list2 = this.numberList;
        String string2 = getString(R.string.number_word1);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        list2.add(string2);
        List<String> list3 = this.numberList;
        String string3 = getString(R.string.number_word2);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        list3.add(string3);
        List<String> list4 = this.numberList;
        String string4 = getString(R.string.number_word3);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        list4.add(string4);
        ((FragmentCategoryBookListBinding) n()).flexboxNumber.setData(this.numberList);
        String str = I().getCom.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_TAG java.lang.String();
        if (Intrinsics.areEqual(str, Book.STATUS_FINISHED)) {
            List<String> list5 = this.completeList;
            String string5 = getString(R.string.withdraw_money_all);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            list5.add(string5);
            List<String> list6 = this.completeList;
            String string6 = getString(R.string.completed_within_one_month);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            list6.add(string6);
            List<String> list7 = this.completeList;
            String string7 = getString(R.string.completed_within_half_a_year);
            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
            list7.add(string7);
            List<String> list8 = this.completeList;
            String string8 = getString(R.string.completed_within_one_year);
            Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
            list8.add(string8);
            ((FragmentCategoryBookListBinding) n()).flexboxComplete.setData(this.completeList);
            ((FragmentCategoryBookListBinding) n()).hsvStatus.setVisibility(8);
            ((FragmentCategoryBookListBinding) n()).hsvPublic.setVisibility(8);
            ((FragmentCategoryBookListBinding) n()).hsvComplete.setVisibility(0);
        } else if (Intrinsics.areEqual(str, "新书")) {
            List<String> list9 = this.publicList;
            String string9 = getString(R.string.withdraw_money_all);
            Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
            list9.add(string9);
            List<String> list10 = this.publicList;
            String string10 = getString(R.string.on_shelves_within_three_months);
            Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
            list10.add(string10);
            List<String> list11 = this.publicList;
            String string11 = getString(R.string.on_shelves_within_six_months);
            Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
            list11.add(string11);
            ((FragmentCategoryBookListBinding) n()).flexboxPublic.setData(this.publicList);
            ((FragmentCategoryBookListBinding) n()).hsvStatus.setVisibility(8);
            ((FragmentCategoryBookListBinding) n()).hsvComplete.setVisibility(8);
            ((FragmentCategoryBookListBinding) n()).hsvPublic.setVisibility(0);
        } else {
            List<String> list12 = this.statusList;
            String string12 = getString(R.string.withdraw_money_all);
            Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
            list12.add(string12);
            List<String> list13 = this.statusList;
            String string13 = getString(R.string.bookstores_finish);
            Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
            list13.add(string13);
            List<String> list14 = this.statusList;
            String string14 = getString(R.string.serialise);
            Intrinsics.checkNotNullExpressionValue(string14, "getString(...)");
            list14.add(string14);
            List<String> list15 = this.statusList;
            String string15 = getString(R.string.bookstores_fresh);
            Intrinsics.checkNotNullExpressionValue(string15, "getString(...)");
            list15.add(string15);
            ((FragmentCategoryBookListBinding) n()).flexboxStatus.setData(this.statusList);
            ((FragmentCategoryBookListBinding) n()).hsvComplete.setVisibility(8);
            ((FragmentCategoryBookListBinding) n()).hsvPublic.setVisibility(8);
            ((FragmentCategoryBookListBinding) n()).hsvStatus.setVisibility(0);
        }
        List<String> list16 = this.orderList;
        String string16 = getString(R.string.top_search);
        Intrinsics.checkNotNullExpressionValue(string16, "getString(...)");
        list16.add(string16);
        List<String> list17 = this.orderList;
        String string17 = getString(R.string.yw_finished_books_recently);
        Intrinsics.checkNotNullExpressionValue(string17, "getString(...)");
        list17.add(string17);
        List<String> list18 = this.orderList;
        String string18 = getString(R.string.grade);
        Intrinsics.checkNotNullExpressionValue(string18, "getString(...)");
        list18.add(string18);
        ((FragmentCategoryBookListBinding) n()).flexboxOrder.setData(this.orderList);
        if (tyTags != null) {
            if (tyTags.size() > 1) {
                List<String> list19 = this.categoryTitle;
                String string19 = getString(R.string.withdraw_money_all);
                Intrinsics.checkNotNullExpressionValue(string19, "getString(...)");
                list19.add(string19);
                for (TYTag tYTag : tyTags) {
                    List<String> list20 = this.categoryTitle;
                    String categoryName = tYTag.getCategoryName();
                    Intrinsics.checkNotNullExpressionValue(categoryName, "getCategoryName(...)");
                    list20.add(categoryName);
                }
                ((FragmentCategoryBookListBinding) n()).flexboxCategory.setData(this.categoryTitle);
                ((FragmentCategoryBookListBinding) n()).hsvCategory.setVisibility(0);
            } else {
                ((FragmentCategoryBookListBinding) n()).hsvCategory.setVisibility(8);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            ((FragmentCategoryBookListBinding) n()).hsvCategory.setVisibility(8);
        }
        ((FragmentCategoryBookListBinding) n()).categoryDivider.setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e1() {
        this.categoryTitle.clear();
        this.numberList.clear();
        this.completeList.clear();
        this.statusList.clear();
        this.completeList.clear();
        this.publicList.clear();
        ((FragmentCategoryBookListBinding) n()).flexboxCategory.removeAllViews();
        ((FragmentCategoryBookListBinding) n()).flexboxNumber.removeAllViews();
        ((FragmentCategoryBookListBinding) n()).flexboxComplete.removeAllViews();
        ((FragmentCategoryBookListBinding) n()).flexboxPublic.removeAllViews();
        ((FragmentCategoryBookListBinding) n()).flexboxStatus.removeAllViews();
        ((FragmentCategoryBookListBinding) n()).flexboxOrder.removeAllViews();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g1(YWCategoryBookList bookList) {
        P0();
        if (this.mAdapter == null) {
            this.mAdapter = new TYBookItemListAdapter();
            ((FragmentCategoryBookListBinding) n()).recyclerviewTagBooks.setAdapter(this.mAdapter);
        }
        if (this.pageIndex != 0) {
            List<TYBookItem> bookList2 = bookList != null ? bookList.getBookList() : null;
            if (bookList2 == null || bookList2.isEmpty()) {
                ((FragmentCategoryBookListBinding) n()).refreshLayout.e0();
                return;
            }
            TYBookItemListAdapter tYBookItemListAdapter = this.mAdapter;
            if (tYBookItemListAdapter != null) {
                tYBookItemListAdapter.k(bookList != null ? bookList.getBookList() : null);
                return;
            }
            return;
        }
        List<TYBookItem> bookList3 = bookList != null ? bookList.getBookList() : null;
        if (bookList3 == null || bookList3.isEmpty()) {
            ((FragmentCategoryBookListBinding) n()).recyclerviewTagBooks.setVisibility(8);
            f1(false);
            O("", ((FragmentCategoryBookListBinding) n()).rvLoadedTip);
        } else {
            T(((FragmentCategoryBookListBinding) n()).rvLoadedTip);
            f1(true);
            TYBookItemListAdapter tYBookItemListAdapter2 = this.mAdapter;
            if (tYBookItemListAdapter2 != null) {
                tYBookItemListAdapter2.q(bookList != null ? bookList.getBookList() : null);
            }
            ((FragmentCategoryBookListBinding) n()).recyclerviewTagBooks.setVisibility(0);
        }
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMFragment
    public void i0() {
    }

    @Override // com.martian.mibook.mvvm.base.BaseFragment
    public void q(@l Bundle savedInstanceState) {
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            I().v(intent.getIntExtra("intent_ctype", 1));
            I().w(intent.getIntExtra(D, 1));
            I().x(intent.getStringExtra(E));
            this.statusPosition = Intrinsics.areEqual(I().getCom.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_TAG java.lang.String(), Book.STATUS_FINISHED) ? 1 : Intrinsics.areEqual(I().getCom.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_TAG java.lang.String(), "新书") ? 3 : 0;
        }
        b1();
        Z0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.base.BaseMVVMFragment
    public void y() {
        I().h().observe(getViewLifecycleOwner(), new Observer() { // from class: vd.j4
            public /* synthetic */ j4() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YWTagBookListFragment.I0(Function1.this, obj);
            }
        });
        I().s().observe(this, new Observer() { // from class: vd.k4
            public /* synthetic */ k4() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YWTagBookListFragment.J0(Function1.this, obj);
            }
        });
        I().r().observe(this, new Observer() { // from class: vd.l4
            public /* synthetic */ l4() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YWTagBookListFragment.L0(Function1.this, obj);
            }
        });
        I().g().observe(this, new Observer() { // from class: vd.m4
            public /* synthetic */ m4() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YWTagBookListFragment.M0(Function1.this, obj);
            }
        });
        ((FragmentCategoryBookListBinding) n()).rvLoadedTip.setOnReloadListener(new Function0<Unit>() { // from class: com.martian.mibook.mvvm.yuewen.fragment.YWTagBookListFragment$addObserver$5
            public YWTagBookListFragment$addObserver$5() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke */
            public final void invoke2() {
                YWTagBookListFragment.this.R0(false, true);
            }
        });
        ((FragmentCategoryBookListBinding) n()).flexboxNumber.setOnItemTitleClickListener(new d());
        ((FragmentCategoryBookListBinding) n()).flexboxStatus.setOnItemTitleClickListener(new e());
        ((FragmentCategoryBookListBinding) n()).flexboxComplete.setOnItemTitleClickListener(new f());
        ((FragmentCategoryBookListBinding) n()).flexboxPublic.setOnItemTitleClickListener(new g());
        ((FragmentCategoryBookListBinding) n()).flexboxOrder.setOnItemTitleClickListener(new b());
        ((FragmentCategoryBookListBinding) n()).flexboxCategory.setOnItemTitleClickListener(new c());
    }
}
