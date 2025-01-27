package com.martian.mibook.mvvm.yuewen.fragment;

import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kuaishou.weapon.p0.t;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.FragmentBookMallNewBinding;
import com.martian.mibook.lib.yuewen.response.YWBookChannel;
import com.martian.mibook.lib.yuewen.response.YWBookMall;
import com.martian.mibook.mvvm.base.BaseMVVMFragment;
import com.martian.mibook.mvvm.net.request.YWBookMallParams;
import com.martian.mibook.mvvm.tts.ReadAloudBook;
import com.martian.mibook.mvvm.tts.TTSReadManager;
import com.martian.mibook.mvvm.widget.MiClassicsFooter;
import com.martian.mibook.mvvm.widget.MiClassicsHeader;
import com.martian.mibook.mvvm.yuewen.adapter.BookMallAdapter;
import com.martian.mibook.mvvm.yuewen.adapter.holder.ItemGenderHolder;
import com.martian.mibook.mvvm.yuewen.fragment.YWBookMallFragment;
import com.martian.mibook.mvvm.yuewen.viewmodel.BookMallViewModel;
import com.umeng.analytics.pro.bt;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import pf.f;
import sf.h;
import xi.k;
import xi.l;
import ya.e0;
import ya.j2;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 H2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001IB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J#\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0015\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u001d\u0010\u0018\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002¢\u0006\u0004\b\u0018\u0010\u0016J\u001d\u0010\u0019\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002¢\u0006\u0004\b\u0019\u0010\u0016J\u000f\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u0005J\u000f\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u0005J\u0017\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010\u0005J\u0019\u0010\"\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0006H\u0016¢\u0006\u0004\b$\u0010\u0005J\u000f\u0010%\u001a\u00020\u0006H\u0016¢\u0006\u0004\b%\u0010\u0005J\r\u0010&\u001a\u00020\u0006¢\u0006\u0004\b&\u0010\u0005J\u000f\u0010'\u001a\u00020\u0006H\u0016¢\u0006\u0004\b'\u0010\u0005J\u000f\u0010(\u001a\u00020\u0006H\u0016¢\u0006\u0004\b(\u0010\u0005J\u000f\u0010)\u001a\u00020\u0006H\u0016¢\u0006\u0004\b)\u0010\u0005J\u000f\u0010*\u001a\u00020\u0006H\u0016¢\u0006\u0004\b*\u0010\u0005R\u0016\u0010-\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010,R\u0016\u00100\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010/R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010/R\u0016\u0010=\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010,R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010/R\u0016\u0010E\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010/R\u0016\u0010G\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010/¨\u0006J"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/fragment/YWBookMallFragment;", "Lcom/martian/mibook/mvvm/base/BaseMVVMFragment;", "Lcom/martian/mibook/databinding/FragmentBookMallNewBinding;", "Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookMallViewModel;", "<init>", "()V", "", "W0", "G0", "", "isLoadMore", "showLoading", "U0", "(ZZ)V", "Lcom/martian/mibook/lib/yuewen/response/YWBookMall;", "ywBookMall", "Z0", "(Lcom/martian/mibook/lib/yuewen/response/YWBookMall;)V", "", "Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;", "bookChannels", "M0", "(Ljava/util/List;)V", "L0", "I0", "X0", "O0", "Y0", "scroll", "a1", "(Z)V", "T0", "Landroid/os/Bundle;", "savedInstanceState", "q", "(Landroid/os/Bundle;)V", "k", "y", "R0", "onResume", "onPause", "i0", "onDestroyView", "", "I", "pageIndex", t.f11204d, "Z", "loadMoreFail", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookMallAdapter;", "m", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookMallAdapter;", "mBookMallAdapter", "n", "genderGuideRemoved", "Le9/c;", "o", "Le9/c;", "rxManager", "p", "isScroll", "mScrollY", "Lsf/h;", t.f11211k, "Lsf/h;", "onRefreshLoadMoreListener", "s", "isHideRecord", bt.aO, "removeRecommendLove", "u", "isAddAudioStatusListener", "v", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nYWBookMallFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 YWBookMallFragment.kt\ncom/martian/mibook/mvvm/yuewen/fragment/YWBookMallFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,457:1\n1#2:458\n*E\n"})
/* loaded from: classes3.dex */
public final class YWBookMallFragment extends BaseMVVMFragment<FragmentBookMallNewBinding, BookMallViewModel> {

    /* renamed from: v, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k, reason: from kotlin metadata */
    public int pageIndex;

    /* renamed from: l */
    public boolean loadMoreFail;

    /* renamed from: m, reason: from kotlin metadata */
    @l
    public BookMallAdapter mBookMallAdapter;

    /* renamed from: n, reason: from kotlin metadata */
    public boolean genderGuideRemoved;

    /* renamed from: o, reason: from kotlin metadata */
    @l
    public e9.c rxManager;

    /* renamed from: p, reason: from kotlin metadata */
    public boolean isScroll = true;

    /* renamed from: q, reason: from kotlin metadata */
    public int mScrollY;

    /* renamed from: r */
    @l
    public h onRefreshLoadMoreListener;

    /* renamed from: s, reason: from kotlin metadata */
    public boolean isHideRecord;

    /* renamed from: t */
    public boolean removeRecommendLove;

    /* renamed from: u, reason: from kotlin metadata */
    public boolean isAddAudioStatusListener;

    /* renamed from: com.martian.mibook.mvvm.yuewen.fragment.YWBookMallFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @k
        public final YWBookMallFragment a(int i10, boolean z10) {
            YWBookMallFragment yWBookMallFragment = new YWBookMallFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(e0.f33185x0, i10);
            bundle.putBoolean(e0.f33163m0, z10);
            yWBookMallFragment.setArguments(bundle);
            return yWBookMallFragment;
        }

        public Companion() {
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f15674a;

        static {
            int[] iArr = new int[ReadAloudBook.ReadAloudPlayerStatus.values().length];
            try {
                iArr[ReadAloudBook.ReadAloudPlayerStatus.STATE_NEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReadAloudBook.ReadAloudPlayerStatus.STATE_PREVIOUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ReadAloudBook.ReadAloudPlayerStatus.STATE_PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ReadAloudBook.ReadAloudPlayerStatus.STATE_STOPPED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f15674a = iArr;
        }
    }

    public static final class c implements ViewTreeObserver.OnPreDrawListener {
        public c() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            YWBookMallFragment.t0(YWBookMallFragment.this).rvBookMall.getViewTreeObserver().removeOnPreDrawListener(this);
            ViewGroup.LayoutParams layoutParams = YWBookMallFragment.t0(YWBookMallFragment.this).rvLoadedTip.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            ((RelativeLayout.LayoutParams) layoutParams).height = YWBookMallFragment.t0(YWBookMallFragment.this).rvBookMall.getHeight();
            YWBookMallFragment.t0(YWBookMallFragment.this).rvLoadedTip.setPadding(0, 0, 0, (int) (r0.height * 0.118f));
            return true;
        }
    }

    public static final class d implements ItemGenderHolder.a {
        public d() {
        }

        @Override // com.martian.mibook.mvvm.yuewen.adapter.holder.ItemGenderHolder.a
        public void a(int i10, @k YWBookChannel bookChannel) {
            Intrinsics.checkNotNullParameter(bookChannel, "bookChannel");
            MiConfigSingleton.b2().g3(false);
            YWBookMallFragment.this.genderGuideRemoved = true;
            BookMallAdapter bookMallAdapter = YWBookMallFragment.this.mBookMallAdapter;
            if (bookMallAdapter != null) {
                bookMallAdapter.s(bookChannel);
            }
        }

        @Override // com.martian.mibook.mvvm.yuewen.adapter.holder.ItemGenderHolder.a
        public void b() {
            MiConfigSingleton.b2().g3(false);
            e9.c cVar = YWBookMallFragment.this.rxManager;
            if (cVar != null) {
                cVar.d(j2.D, Integer.valueOf(j2.G));
            }
            e9.c cVar2 = YWBookMallFragment.this.rxManager;
            if (cVar2 != null) {
                cVar2.d(j2.M, Integer.valueOf(j2.N));
            }
        }
    }

    public static final class e implements h {
        public e() {
        }

        @Override // sf.g
        public void b(@k f refreshLayout) {
            Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
            YWBookMallFragment.this.R0();
        }

        @Override // sf.e
        public void p(@k f refreshLayout) {
            Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
            if (!YWBookMallFragment.this.loadMoreFail) {
                YWBookMallFragment.this.pageIndex++;
            }
            YWBookMallFragment.V0(YWBookMallFragment.this, true, false, 2, null);
        }
    }

    public static final void A(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void H0(YWBookMallFragment this$0, ReadAloudBook.ReadAloudPlayerStatus readAloudPlayerStatus) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i10 = readAloudPlayerStatus == null ? -1 : b.f15674a[readAloudPlayerStatus.ordinal()];
        if (i10 == 1 || i10 == 2 || i10 == 3) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), null, null, new YWBookMallFragment$addAudioStatusListener$1$1(this$0, null), 3, null);
        } else {
            if (i10 != 4) {
                return;
            }
            this$0.isAddAudioStatusListener = false;
        }
    }

    public static final void J0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void O0() {
        if (this.rxManager == null) {
            this.rxManager = new e9.c();
        }
        e9.c cVar = this.rxManager;
        if (cVar != null) {
            cVar.c(j2.D, new wj.b() { // from class: vd.u3
                public /* synthetic */ u3() {
                }

                @Override // wj.b
                public final void call(Object obj) {
                    YWBookMallFragment.P0(YWBookMallFragment.this, (Integer) obj);
                }
            });
        }
        e9.c cVar2 = this.rxManager;
        if (cVar2 != null) {
            cVar2.c(j2.f33277r, new wj.b() { // from class: vd.v3
                public /* synthetic */ v3() {
                }

                @Override // wj.b
                public final void call(Object obj) {
                    YWBookMallFragment.Q0(YWBookMallFragment.this, (Integer) obj);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void P0(YWBookMallFragment this$0, Integer num) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (num == null) {
            return;
        }
        if (num.intValue() == j2.E) {
            if (this$0.getIsVisibleToUser()) {
                this$0.Y0();
                ((FragmentBookMallNewBinding) this$0.n()).refreshLayout.q(0, 500, 1.0f, false);
                return;
            }
            return;
        }
        if (num.intValue() == j2.I) {
            this$0.isScroll = true;
            return;
        }
        if (num.intValue() == j2.H) {
            this$0.isScroll = false;
        }
    }

    public static final void Q0(YWBookMallFragment this$0, Integer num) {
        BookMallAdapter bookMallAdapter;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (num != null && num.intValue() == j2.f33284y && this$0.I().getTid() == MiConfigSingleton.b2().p() && (bookMallAdapter = this$0.mBookMallAdapter) != null) {
            bookMallAdapter.n();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void T0() {
        this.loadMoreFail = false;
        ((FragmentBookMallNewBinding) n()).refreshLayout.p();
        ((FragmentBookMallNewBinding) n()).refreshLayout.S();
        ((FragmentBookMallNewBinding) n()).refreshLayout.n();
    }

    public static /* synthetic */ void V0(YWBookMallFragment yWBookMallFragment, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            BookMallAdapter bookMallAdapter = yWBookMallFragment.mBookMallAdapter;
            z11 = (bookMallAdapter != null ? bookMallAdapter.getPageSize() : 0) <= 0;
        }
        yWBookMallFragment.U0(z10, z11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void W0() {
        ((FragmentBookMallNewBinding) n()).rvBookMall.setLayoutManager(new LinearLayoutManager(getContext()));
        ((FragmentBookMallNewBinding) n()).rvBookMall.setHasFixedSize(true);
        ((FragmentBookMallNewBinding) n()).rvBookMall.setItemViewCacheSize(6);
        BookMallViewModel I = I();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        this.mBookMallAdapter = new BookMallAdapter(I, viewLifecycleOwner);
        ((FragmentBookMallNewBinding) n()).rvBookMall.setAdapter(this.mBookMallAdapter);
        BookMallAdapter bookMallAdapter = this.mBookMallAdapter;
        if (bookMallAdapter != null) {
            bookMallAdapter.u(new d());
        }
        ((FragmentBookMallNewBinding) n()).refreshLayout.O(new MiClassicsHeader(getContext(), (Integer) 1));
        ((FragmentBookMallNewBinding) n()).refreshLayout.U(new MiClassicsFooter(getContext(), 1, false, 4, null));
        this.onRefreshLoadMoreListener = new e();
        ((FragmentBookMallNewBinding) n()).refreshLayout.B(this.onRefreshLoadMoreListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ FragmentBookMallNewBinding t0(YWBookMallFragment yWBookMallFragment) {
        return (FragmentBookMallNewBinding) yWBookMallFragment.n();
    }

    public static final void z(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void G0() {
        if (this.isAddAudioStatusListener) {
            return;
        }
        this.isAddAudioStatusListener = true;
        TTSReadManager.v(this, new Observer() { // from class: vd.t3
            public /* synthetic */ t3() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YWBookMallFragment.H0(YWBookMallFragment.this, (ReadAloudBook.ReadAloudPlayerStatus) obj);
            }
        });
    }

    public final void I0(List<YWBookChannel> bookChannels) {
        Object obj;
        if (MiConfigSingleton.b2().Q2() && I().getTid() == MiConfigSingleton.b2().p() && !this.genderGuideRemoved) {
            Iterator<T> it = bookChannels.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                Integer mcid = ((YWBookChannel) obj).getMcid();
                if (mcid != null && mcid.intValue() == -1000099) {
                    break;
                }
            }
            if (((YWBookChannel) obj) == null) {
                YWBookChannel title = new YWBookChannel().setMcid(Integer.valueOf(BookMallAdapter.f15422v)).setTitle(getString(R.string.choose_gender));
                Intrinsics.checkNotNull(title);
                bookChannels.add(title);
            }
        }
    }

    public final void L0(List<YWBookChannel> bookChannels) {
        if (I().getTid() == MiConfigSingleton.b2().p()) {
            BookMallAdapter bookMallAdapter = this.mBookMallAdapter;
            YWBookChannel m10 = bookMallAdapter != null ? BookMallAdapter.m(bookMallAdapter, null, 1, null) : null;
            if (m10 != null) {
                bookChannels.add(m10);
            }
        }
    }

    public final void M0(List<YWBookChannel> bookChannels) {
        if (I().getTid() == 2 || I().getTid() == 1) {
            YWBookChannel yWBookChannel = new YWBookChannel();
            yWBookChannel.setMcid(-5);
            bookChannels.add(yWBookChannel);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R0() {
        this.pageIndex = 0;
        this.removeRecommendLove = false;
        ((FragmentBookMallNewBinding) n()).refreshLayout.n();
        BookMallAdapter bookMallAdapter = this.mBookMallAdapter;
        if (bookMallAdapter != null) {
            RecyclerView rvBookMall = ((FragmentBookMallNewBinding) n()).rvBookMall;
            Intrinsics.checkNotNullExpressionValue(rvBookMall, "rvBookMall");
            bookMallAdapter.t(rvBookMall);
        }
        I().J();
        V0(this, false, false, 2, null);
    }

    public final void U0(boolean isLoadMore, boolean showLoading) {
        YWBookMallParams yWBookMallParams = new YWBookMallParams(null, null, 0, 0, 0, 0, null, 127, null);
        yWBookMallParams.setPage(Integer.valueOf(this.pageIndex));
        yWBookMallParams.setTid(I().getTid());
        yWBookMallParams.setCtype(I().u());
        yWBookMallParams.setCount(I().w());
        yWBookMallParams.makeSpeed();
        I().t(yWBookMallParams, showLoading, isLoadMore);
    }

    public final void X0(List<YWBookChannel> bookChannels) {
        if (MiConfigSingleton.b2().W2()) {
            return;
        }
        Iterator<YWBookChannel> it = bookChannels.iterator();
        while (it.hasNext()) {
            String title = it.next().getTitle();
            if (!ba.l.q(title)) {
                if (!StringsKt.equals("为你推荐", title, true)) {
                    Intrinsics.checkNotNull(title);
                    if (!StringsKt.contains$default((CharSequence) title, (CharSequence) "推荐", false, 2, (Object) null)) {
                        if (StringsKt.equals("猜你喜欢", title, true)) {
                            it.remove();
                            this.removeRecommendLove = true;
                        } else {
                            this.removeRecommendLove = false;
                        }
                    }
                }
                it.remove();
            } else if (this.removeRecommendLove) {
                it.remove();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y0() {
        ((FragmentBookMallNewBinding) n()).rvBookMall.scrollToPosition(0);
        this.mScrollY = 0;
        e9.c cVar = this.rxManager;
        if (cVar != null) {
            cVar.d(j2.D, Integer.valueOf(j2.J));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Z0(YWBookMall ywBookMall) {
        List<YWBookChannel> channelList;
        e9.c cVar;
        T0();
        if (this.pageIndex != 0) {
            if (ywBookMall != null && (channelList = ywBookMall.getChannelList()) != null) {
                X0(channelList);
                if (channelList.isEmpty()) {
                    r1 = ((FragmentBookMallNewBinding) n()).refreshLayout.a(true);
                } else {
                    BookMallAdapter bookMallAdapter = this.mBookMallAdapter;
                    if (bookMallAdapter != null) {
                        bookMallAdapter.i(channelList);
                        r1 = Unit.INSTANCE;
                    }
                }
                if (r1 != null) {
                    return;
                }
            }
            ((FragmentBookMallNewBinding) n()).refreshLayout.e0();
            return;
        }
        Collection collection = (Collection) (ywBookMall != null ? ywBookMall.getChannelList() : null);
        if (collection == null || collection.isEmpty()) {
            ((FragmentBookMallNewBinding) n()).rvBookMall.setVisibility(8);
            ((FragmentBookMallNewBinding) n()).refreshLayout.N(false);
            O("", ((FragmentBookMallNewBinding) n()).rvLoadedTip);
        } else {
            T(((FragmentBookMallNewBinding) n()).rvLoadedTip);
            ((FragmentBookMallNewBinding) n()).refreshLayout.N(true);
            ArrayList arrayList = new ArrayList();
            if (ywBookMall != null) {
                M0(arrayList);
                YWBookChannel yWBookChannel = ywBookMall.getChannelList().get(0);
                Intrinsics.checkNotNullExpressionValue(yWBookChannel, "get(...)");
                arrayList.add(yWBookChannel);
                L0(arrayList);
                I0(arrayList);
                List<YWBookChannel> channelList2 = ywBookMall.getChannelList();
                Intrinsics.checkNotNullExpressionValue(channelList2, "getChannelList(...)");
                arrayList.addAll(CollectionsKt.drop(channelList2, 1));
                X0(arrayList);
            }
            ((FragmentBookMallNewBinding) n()).rvBookMall.setVisibility(0);
            BookMallAdapter bookMallAdapter2 = this.mBookMallAdapter;
            if (bookMallAdapter2 != null) {
                bookMallAdapter2.x(arrayList);
            }
        }
        if (I().getTid() != MiConfigSingleton.b2().p() || (cVar = this.rxManager) == null) {
            return;
        }
        cVar.d(j2.D, Integer.valueOf(j2.K));
    }

    public final void a1(boolean scroll) {
        if (this.isScroll == scroll) {
            return;
        }
        this.isScroll = scroll;
        e9.c cVar = this.rxManager;
        if (cVar != null) {
            cVar.d(j2.D, Integer.valueOf(scroll ? j2.I : j2.H));
        }
        e9.c cVar2 = this.rxManager;
        if (cVar2 != null) {
            cVar2.d(j2.S, Integer.valueOf(this.isScroll ? j2.I : j2.H));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.base.BaseMVVMFragment
    public void i0() {
        BookMallAdapter bookMallAdapter = this.mBookMallAdapter;
        if (bookMallAdapter != null) {
            bookMallAdapter.r(((FragmentBookMallNewBinding) n()).rvBookMall);
        }
    }

    @Override // com.martian.mibook.mvvm.base.LazyFragment
    public void k() {
        super.k();
        R0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        e9.c cVar = this.rxManager;
        if (cVar != null) {
            cVar.b();
        }
        this.rxManager = null;
        this.onRefreshLoadMoreListener = null;
    }

    @Override // com.martian.mibook.mvvm.base.LazyFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        e9.c cVar = this.rxManager;
        if (cVar != null) {
            cVar.f();
        }
    }

    @Override // com.martian.mibook.mvvm.base.LazyFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        O0();
        a1(this.mScrollY > ConfigSingleton.i(180.0f));
        if (I().getTid() == MiConfigSingleton.b2().p()) {
            BookMallAdapter bookMallAdapter = this.mBookMallAdapter;
            if (bookMallAdapter != null) {
                bookMallAdapter.n();
            }
            G0();
        }
    }

    @Override // com.martian.mibook.mvvm.base.BaseFragment
    public void q(@l Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            I().M(arguments.getInt(e0.f33185x0, MiConfigSingleton.b2().p()));
            I().K(arguments.getBoolean(e0.f33163m0, true));
        }
        W0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.base.BaseMVVMFragment
    public void y() {
        I().h().observe(getViewLifecycleOwner(), new Observer() { // from class: vd.w3
            public /* synthetic */ w3() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YWBookMallFragment.z(Function1.this, obj);
            }
        });
        I().D().observe(getViewLifecycleOwner(), new Observer() { // from class: vd.x3
            public /* synthetic */ x3() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YWBookMallFragment.A(Function1.this, obj);
            }
        });
        I().g().observe(getViewLifecycleOwner(), new Observer() { // from class: vd.y3
            public /* synthetic */ y3() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YWBookMallFragment.J0(Function1.this, obj);
            }
        });
        ((FragmentBookMallNewBinding) n()).rvLoadedTip.setOnReloadListener(new Function0<Unit>() { // from class: com.martian.mibook.mvvm.yuewen.fragment.YWBookMallFragment$addObserver$4
            public YWBookMallFragment$addObserver$4() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke */
            public final void invoke2() {
                YWBookMallFragment.this.U0(false, true);
            }
        });
        ((FragmentBookMallNewBinding) n()).rvBookMall.getViewTreeObserver().addOnPreDrawListener(new c());
        ((FragmentBookMallNewBinding) n()).rvBookMall.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.martian.mibook.mvvm.yuewen.fragment.YWBookMallFragment$addObserver$6

            /* renamed from: u */
            public final /* synthetic */ int f15673u;

            public YWBookMallFragment$addObserver$6(int i10) {
                i10 = i10;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@k RecyclerView recyclerView, int dx, int dy) {
                int i10;
                int i11;
                boolean z10;
                int i12;
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, dx, dy);
                YWBookMallFragment yWBookMallFragment = YWBookMallFragment.this;
                i10 = yWBookMallFragment.mScrollY;
                yWBookMallFragment.mScrollY = i10 + dy;
                if (YWBookMallFragment.this.I().getTid() == MiConfigSingleton.b2().p()) {
                    z10 = YWBookMallFragment.this.isHideRecord;
                    if (!z10) {
                        int i13 = i10;
                        i12 = YWBookMallFragment.this.mScrollY;
                        if (i13 - i12 <= 0.0f) {
                            YWBookMallFragment.this.isHideRecord = true;
                            c cVar = YWBookMallFragment.this.rxManager;
                            if (cVar != null) {
                                cVar.d(j2.D, Integer.valueOf(j2.L));
                            }
                        }
                    }
                }
                YWBookMallFragment yWBookMallFragment2 = YWBookMallFragment.this;
                i11 = yWBookMallFragment2.mScrollY;
                yWBookMallFragment2.a1(i11 > ConfigSingleton.i(180.0f));
            }
        });
        if (I().getTid() == MiConfigSingleton.b2().p()) {
            G0();
        }
    }
}
