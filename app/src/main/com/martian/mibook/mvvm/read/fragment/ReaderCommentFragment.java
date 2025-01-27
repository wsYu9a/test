package com.martian.mibook.mvvm.read.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ba.m;
import com.kuaishou.weapon.p0.bq;
import com.kuaishou.weapon.p0.t;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.utils.tablayout.ClipPagerTitleView;
import com.martian.libmars.utils.tablayout.CommonNavigator;
import com.martian.libmars.utils.tablayout.LinePagerIndicator;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment;
import com.martian.libmars.widget.dialog.a;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.book.CommentCount;
import com.martian.mibook.data.theme.MiReadingTheme;
import com.martian.mibook.databinding.DialogReaderCommentFragmentBinding;
import com.martian.mibook.mvvm.book.viewmodel.BookInfo;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.request.GetCommentByScoreParams;
import com.martian.mibook.mvvm.net.request.GetCommentByTimeParams;
import com.martian.mibook.mvvm.read.adapter.ReaderCommentAdapter;
import com.martian.mibook.mvvm.read.comment.Comment;
import com.martian.mibook.mvvm.read.comment.CommentReply;
import com.martian.mibook.mvvm.read.fragment.ReaderCommentFragment;
import com.martian.mibook.mvvm.read.fragment.ReaderPostBookCommentFragment;
import com.martian.mibook.mvvm.read.fragment.ReaderPostOrReplyCommentFragment;
import com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel;
import com.martian.mibook.mvvm.read.widget.ReaderLoadingTip;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.martian.mibook.mvvm.widget.MiClassicsFooter;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import lc.b;
import m9.e;
import m9.g;
import pf.f;
import xi.k;
import xi.l;
import ya.e2;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 R2\u00020\u0001:\u0001SB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\u00042\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0017\u0010\u0003J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0019\u0010\u000bJ\u000f\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001b\u0010\u000bJ\u0019\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010\"\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020 H\u0017¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b(\u0010)R\u001b\u0010/\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001d\u00104\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010,\u001a\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010<R\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010Q\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010P¨\u0006T"}, d2 = {"Lcom/martian/mibook/mvvm/read/fragment/ReaderCommentFragment;", "Lcom/martian/libmars/widget/dialog/MartianBottomSheetDialogFragment;", "<init>", "()V", "", "q0", "H0", bq.f10843g, "", "index", "I0", "(I)V", "", "isLoadMore", "showLoading", "m0", "(ZZ)V", "", "Lcom/martian/mibook/mvvm/read/comment/Comment;", "commentList", "J0", "(Ljava/util/List;)V", "k0", "R0", "score", "T0", "P0", "Q0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "p", "(Landroid/view/View;)Landroid/view/View;", "Lya/e2$d;", "listener", "L0", "(Lya/e2$d;)V", t.f11211k, "(Landroid/view/View;)V", "Lcom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel;", "f", "Lkotlin/Lazy;", "o0", "()Lcom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel;", "mViewModel", "Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", "g", "l0", "()Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", "appViewModel", "Lcom/martian/mibook/databinding/DialogReaderCommentFragmentBinding;", "h", "Lcom/martian/mibook/databinding/DialogReaderCommentFragmentBinding;", "binding", "i", "Lya/e2$d;", "j", "I", "commentType", "Lcom/martian/mibook/mvvm/read/adapter/ReaderCommentAdapter;", "k", "Lcom/martian/mibook/mvvm/read/adapter/ReaderCommentAdapter;", "readerCommentAdapter", t.f11204d, "Z", "loadMoreFail", "m", "pageIndex", "", "n", "Ljava/lang/Long;", "lastCreatedOn", "", "o", "Ljava/lang/String;", "commentString", "Lcom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel$CommentType;", "Lcom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel$CommentType;", "bookCommentType", "q", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ReaderCommentFragment extends MartianBottomSheetDialogFragment {

    /* renamed from: q, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: r */
    @k
    public static final String f14627r = "ReaderCommentFragment";

    /* renamed from: s */
    @k
    public static final String f14628s = "INTENT_COMMENT_COUNT";

    /* renamed from: t */
    @k
    public static final String f14629t = "INTENT_SOURCE_NAME";

    /* renamed from: u */
    @k
    public static final String f14630u = "INTENT_SOURCE_ID";

    /* renamed from: v */
    @k
    public static final String f14631v = "INTENT_PARAGRAPH_CONTENT";

    /* renamed from: w */
    @k
    public static final String f14632w = "INTENT_SELECT_PARAGRAPH_TEXT";

    /* renamed from: x */
    @k
    public static final String f14633x = "INTENT_COMMENT_BOOK_INFO";

    /* renamed from: f, reason: from kotlin metadata */
    @k
    public final Lazy mViewModel = LazyKt.lazy(new Function0<ReaderCommentViewModel>() { // from class: com.martian.mibook.mvvm.read.fragment.ReaderCommentFragment$mViewModel$2
        public ReaderCommentFragment$mViewModel$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @k
        public final ReaderCommentViewModel invoke() {
            return (ReaderCommentViewModel) new ViewModelProvider(ReaderCommentFragment.this).get(ReaderCommentViewModel.class);
        }
    });

    /* renamed from: g, reason: from kotlin metadata */
    @k
    public final Lazy appViewModel = LazyKt.lazy(new Function0<AppViewModel>() { // from class: com.martian.mibook.mvvm.read.fragment.ReaderCommentFragment$appViewModel$2
        public ReaderCommentFragment$appViewModel$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @l
        public final AppViewModel invoke() {
            return b.a(ReaderCommentFragment.this.getActivity());
        }
    });

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public DialogReaderCommentFragmentBinding binding;

    /* renamed from: i, reason: from kotlin metadata */
    @l
    public e2.d listener;

    /* renamed from: j, reason: from kotlin metadata */
    public int commentType;

    /* renamed from: k, reason: from kotlin metadata */
    @l
    public ReaderCommentAdapter readerCommentAdapter;

    /* renamed from: l */
    public boolean loadMoreFail;

    /* renamed from: m, reason: from kotlin metadata */
    public int pageIndex;

    /* renamed from: n, reason: from kotlin metadata */
    @l
    public Long lastCreatedOn;

    /* renamed from: o, reason: from kotlin metadata */
    @l
    public String commentString;

    /* renamed from: p, reason: from kotlin metadata */
    @l
    public ReaderCommentViewModel.CommentType bookCommentType;

    /* renamed from: com.martian.mibook.mvvm.read.fragment.ReaderCommentFragment$a, reason: from kotlin metadata */
    public static final class Companion {

        /* renamed from: com.martian.mibook.mvvm.read.fragment.ReaderCommentFragment$a$a */
        public static final class C0538a implements MartianBottomSheetDialogFragment.b {
            @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment.b
            public void a(@k DialogFragment dialogFragment) {
                Intrinsics.checkNotNullParameter(dialogFragment, "dialogFragment");
                MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
                boolean s10 = MiConfigSingleton.b2().h2().s();
                com.gyf.immersionbar.d.y3(dialogFragment).T2(!s10).G1(!s10).B1(k10.getNavigationBarBackgroundColor(false), 0.0f).a1();
            }
        }

        /* renamed from: com.martian.mibook.mvvm.read.fragment.ReaderCommentFragment$a$b */
        public static final class b implements MartianBottomSheetDialogFragment.b {
            @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment.b
            public void a(@k DialogFragment dialogFragment) {
                Intrinsics.checkNotNullParameter(dialogFragment, "dialogFragment");
                MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
                boolean s10 = MiConfigSingleton.b2().h2().s();
                com.gyf.immersionbar.d.y3(dialogFragment).T2(!s10).G1(!s10).B1(k10.getNavigationBarBackgroundColor(false), 0.0f).a1();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@l FragmentActivity fragmentActivity, @k CommentCount commentCount, @l String str, @l String str2, @l String str3, @l String str4, @l e2.d dVar) {
            Intrinsics.checkNotNullParameter(commentCount, "commentCount");
            if (fragmentActivity == null || fragmentActivity.isFinishing()) {
                return;
            }
            a a10 = MartianBottomSheetDialogFragment.INSTANCE.a();
            a10.k0(true).j0(true).x0(R.style.BottomSheetFullScreenDialog).q0(ConfigSingleton.i(16.0f)).n0((m.h(fragmentActivity) + m.j(fragmentActivity)) - ConfigSingleton.i(80.0f)).s0(new b());
            ReaderCommentFragment readerCommentFragment = new ReaderCommentFragment();
            Bundle bundle = new Bundle();
            bundle.putString("INTENT_COMMENT_COUNT", GsonUtils.b().toJson(commentCount));
            bundle.putString("INTENT_SOURCE_NAME", str);
            bundle.putString("INTENT_SOURCE_ID", str2);
            bundle.putString("INTENT_PARAGRAPH_CONTENT", str3);
            bundle.putString("INTENT_SELECT_PARAGRAPH_TEXT", str4);
            readerCommentFragment.setArguments(bundle);
            readerCommentFragment.L0(dVar);
            a10.c0(fragmentActivity, readerCommentFragment, ReaderCommentFragment.f14627r, true);
        }

        @JvmStatic
        public final void b(@l FragmentActivity fragmentActivity, @l BookInfo bookInfo) {
            if (fragmentActivity == null || fragmentActivity.isFinishing() || bookInfo == null) {
                return;
            }
            a a10 = MartianBottomSheetDialogFragment.INSTANCE.a();
            a10.k0(true).j0(true).x0(R.style.BottomSheetFullScreenDialog).q0(ConfigSingleton.i(16.0f)).n0((m.h(fragmentActivity) + m.j(fragmentActivity)) - ConfigSingleton.i(80.0f)).s0(new C0538a());
            ReaderCommentFragment readerCommentFragment = new ReaderCommentFragment();
            Bundle bundle = new Bundle();
            bundle.putString("INTENT_COMMENT_BOOK_INFO", GsonUtils.b().toJson(bookInfo));
            readerCommentFragment.setArguments(bundle);
            a10.c0(fragmentActivity, readerCommentFragment, ReaderCommentFragment.f14627r, true);
        }

        public Companion() {
        }
    }

    public static final class b extends m9.b {

        /* renamed from: b */
        public final /* synthetic */ m9.d f14645b;

        /* renamed from: c */
        public final /* synthetic */ ReaderCommentFragment f14646c;

        public b(m9.d dVar, ReaderCommentFragment readerCommentFragment) {
            this.f14645b = dVar;
            this.f14646c = readerCommentFragment;
        }

        public static final void k(m9.d helper, int i10, ClipPagerTitleView clipPagerTitleView, ReaderCommentFragment this$0, View view) {
            Intrinsics.checkNotNullParameter(helper, "$helper");
            Intrinsics.checkNotNullParameter(clipPagerTitleView, "$clipPagerTitleView");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            helper.j(i10, true);
            clipPagerTitleView.postDelayed(new Runnable() { // from class: ed.q

                /* renamed from: c */
                public final /* synthetic */ int f25875c;

                public /* synthetic */ q(int i102) {
                    i10 = i102;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    ReaderCommentFragment.b.l(ReaderCommentFragment.this, i10);
                }
            }, 300L);
        }

        public static final void l(ReaderCommentFragment this$0, int i10) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.I0(i10);
        }

        @Override // m9.b
        public int a() {
            return 2;
        }

        @Override // m9.b
        @k
        public e b(@k Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setXOffset(ConfigSingleton.i(2.0f));
            linePagerIndicator.h(ConfigSingleton.i(2.0f)).j(ConfigSingleton.i(16.0f)).d(Integer.valueOf(MiConfigSingleton.b2().h2().k().getPopupBackgroundColor()));
            return linePagerIndicator;
        }

        @Override // m9.b
        @k
        public g c(@k Context context, int i10) {
            Intrinsics.checkNotNullParameter(context, "context");
            ClipPagerTitleView clipPagerTitleView = new ClipPagerTitleView(context);
            clipPagerTitleView.setTypeFace(MiConfigSingleton.b2().i2().g());
            int i11 = ConfigSingleton.i(8.0f);
            int i12 = ConfigSingleton.i(4.0f);
            clipPagerTitleView.setTextSize(ConfigSingleton.i(12.0f));
            clipPagerTitleView.setPadding(i11, i12, i11, i12);
            clipPagerTitleView.setText(ExtKt.c(i10 == 0 ? "最热" : "最新"));
            int textColorPrimary = MiConfigSingleton.b2().h2().k().getTextColorPrimary();
            clipPagerTitleView.setTextColor(textColorPrimary);
            clipPagerTitleView.setSelectTextColor(textColorPrimary);
            clipPagerTitleView.setOnClickListener(new View.OnClickListener() { // from class: ed.r

                /* renamed from: c */
                public final /* synthetic */ int f25878c;

                /* renamed from: d */
                public final /* synthetic */ ClipPagerTitleView f25879d;

                /* renamed from: e */
                public final /* synthetic */ ReaderCommentFragment f25880e;

                public /* synthetic */ r(int i102, ClipPagerTitleView clipPagerTitleView2, ReaderCommentFragment readerCommentFragment) {
                    i10 = i102;
                    clipPagerTitleView = clipPagerTitleView2;
                    readerCommentFragment = readerCommentFragment;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderCommentFragment.b.k(m9.d.this, i10, clipPagerTitleView, readerCommentFragment, view);
                }
            });
            return clipPagerTitleView2;
        }
    }

    public static final class c implements ReaderPostOrReplyCommentFragment.e {
        public c() {
        }

        @Override // com.martian.mibook.mvvm.read.fragment.ReaderPostOrReplyCommentFragment.e
        public void a(@k CommentReply commentReply) {
            Intrinsics.checkNotNullParameter(commentReply, "commentReply");
        }

        @Override // com.martian.mibook.mvvm.read.fragment.ReaderPostOrReplyCommentFragment.e
        public void b(@k Comment comment) {
            Intrinsics.checkNotNullParameter(comment, "comment");
            ac.a.A(ReaderCommentFragment.this.getContext(), "发表评论");
            if (ReaderCommentFragment.this.readerCommentAdapter != null) {
                ReaderCommentAdapter readerCommentAdapter = ReaderCommentFragment.this.readerCommentAdapter;
                if (readerCommentAdapter != null) {
                    readerCommentAdapter.b0(0, comment);
                }
            } else {
                ReaderCommentFragment.this.J0(CollectionsKt.arrayListOf(comment));
            }
            ReaderCommentFragment.this.commentString = null;
            e2.d dVar = ReaderCommentFragment.this.listener;
            if (dVar != null) {
                CommentCount commentCount = ReaderCommentFragment.this.o0().getCommentCount();
                Intrinsics.checkNotNull(commentCount);
                dVar.a(commentCount.getChapterId(), comment);
            }
            CommentCount commentCount2 = ReaderCommentFragment.this.o0().getCommentCount();
            if (commentCount2 != null) {
                commentCount2.incrNComments();
            }
            CommentCount commentCount3 = ReaderCommentFragment.this.o0().getCommentCount();
            if (commentCount3 != null) {
                commentCount3.addComment(comment);
            }
            DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding = ReaderCommentFragment.this.binding;
            ReaderThemeTextView readerThemeTextView = dialogReaderCommentFragmentBinding != null ? dialogReaderCommentFragmentBinding.chapterCommentNumber : null;
            if (readerThemeTextView == null) {
                return;
            }
            StringBuilder sb2 = new StringBuilder("(");
            CommentCount commentCount4 = ReaderCommentFragment.this.o0().getCommentCount();
            sb2.append(commentCount4 != null ? Integer.valueOf(commentCount4.getNComments()) : null);
            sb2.append("条)");
            readerThemeTextView.setText(sb2);
        }

        @Override // com.martian.mibook.mvvm.read.fragment.ReaderPostOrReplyCommentFragment.e
        public void c(@k String tag, @k String comment) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(comment, "comment");
            ReaderCommentFragment.this.commentString = comment;
        }
    }

    public static final class d implements ReaderPostBookCommentFragment.e {
        public d() {
        }

        @Override // com.martian.mibook.mvvm.read.fragment.ReaderPostBookCommentFragment.e
        public void a(@k CommentReply comment) {
            Intrinsics.checkNotNullParameter(comment, "comment");
        }

        @Override // com.martian.mibook.mvvm.read.fragment.ReaderPostBookCommentFragment.e
        public void b(@k Comment comment) {
            Integer nComments;
            Intrinsics.checkNotNullParameter(comment, "comment");
            int i10 = 0;
            if (ReaderCommentFragment.this.readerCommentAdapter != null) {
                ReaderCommentAdapter readerCommentAdapter = ReaderCommentFragment.this.readerCommentAdapter;
                if (readerCommentAdapter != null) {
                    readerCommentAdapter.b0(0, comment);
                }
            } else {
                ReaderCommentFragment.this.J0(CollectionsKt.arrayListOf(comment));
            }
            ReaderCommentFragment.this.commentString = null;
            BookInfo mBookInfo = ReaderCommentFragment.this.o0().getMBookInfo();
            if (mBookInfo != null) {
                BookInfo mBookInfo2 = ReaderCommentFragment.this.o0().getMBookInfo();
                if (mBookInfo2 != null && (nComments = mBookInfo2.getNComments()) != null) {
                    i10 = nComments.intValue();
                }
                mBookInfo.setNComments(Integer.valueOf(i10 + 1));
            }
            DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding = ReaderCommentFragment.this.binding;
            ReaderThemeTextView readerThemeTextView = dialogReaderCommentFragmentBinding != null ? dialogReaderCommentFragmentBinding.chapterCommentNumber : null;
            if (readerThemeTextView != null) {
                StringBuilder sb2 = new StringBuilder("(");
                BookInfo mBookInfo3 = ReaderCommentFragment.this.o0().getMBookInfo();
                sb2.append(mBookInfo3 != null ? mBookInfo3.getNComments() : null);
                sb2.append("条)");
                readerThemeTextView.setText(sb2);
            }
            AppViewModel l02 = ReaderCommentFragment.this.l0();
            if (l02 != null) {
                AppViewModel.A0(l02, null, null, 3, null);
            }
            ReaderCommentFragment.this.o0().r(ReaderCommentFragment.this.o0().getSourceName(), ReaderCommentFragment.this.o0().getSourceId());
        }

        @Override // com.martian.mibook.mvvm.read.fragment.ReaderPostBookCommentFragment.e
        public void c(@k String tag, @k String comment) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(comment, "comment");
            ReaderCommentFragment.this.commentString = comment;
        }
    }

    public static final void A0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void B0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
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

    public static final void G0(ReaderCommentFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q0(20);
    }

    private final void H0() {
        MagicIndicator magicIndicator;
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        commonNavigator.setAdjustMode(true);
        commonNavigator.setMarginHorizontal(0);
        m9.d dVar = new m9.d();
        commonNavigator.setAdapter(new b(dVar, this));
        MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
        DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding = this.binding;
        MagicIndicator magicIndicator2 = dialogReaderCommentFragmentBinding != null ? dialogReaderCommentFragmentBinding.magicIndicatorComment : null;
        if (magicIndicator2 != null) {
            magicIndicator2.setBackground(k10.getRoundBgResTextThirdlyDrawable(getContext()));
        }
        DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding2 = this.binding;
        if (dialogReaderCommentFragmentBinding2 != null && (magicIndicator = dialogReaderCommentFragmentBinding2.magicIndicatorComment) != null) {
            magicIndicator.setNavigator(commonNavigator);
        }
        DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding3 = this.binding;
        dVar.d(dialogReaderCommentFragmentBinding3 != null ? dialogReaderCommentFragmentBinding3.magicIndicatorComment : null);
        dVar.j(this.commentType, false);
    }

    public final void I0(int index) {
        this.commentType = index;
        n0(this, false, false, 2, null);
    }

    public final void J0(List<Comment> commentList) {
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        ReaderLoadingTip readerLoadingTip;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        ReaderCommentAdapter readerCommentAdapter;
        RecyclerView recyclerView3;
        SmartRefreshLayout smartRefreshLayout3;
        k0();
        List<Comment> list = commentList;
        if (list == null || list.isEmpty()) {
            int i10 = this.commentType;
            if ((i10 == 0 && this.pageIndex == 0) || (i10 == 1 && this.lastCreatedOn == null)) {
                DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding = this.binding;
                smartRefreshLayout = dialogReaderCommentFragmentBinding != null ? dialogReaderCommentFragmentBinding.refreshLayout : null;
                if (smartRefreshLayout != null) {
                    smartRefreshLayout.setVisibility(8);
                }
                DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding2 = this.binding;
                if (dialogReaderCommentFragmentBinding2 == null || (readerLoadingTip = dialogReaderCommentFragmentBinding2.commentLoadingTip) == null) {
                    return;
                }
                readerLoadingTip.setLoadingTip(ReaderLoadingTip.LoadStatus.empty);
                return;
            }
            DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding3 = this.binding;
            smartRefreshLayout = dialogReaderCommentFragmentBinding3 != null ? dialogReaderCommentFragmentBinding3.refreshLayout : null;
            if (smartRefreshLayout != null) {
                smartRefreshLayout.setVisibility(0);
            }
            DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding4 = this.binding;
            if (dialogReaderCommentFragmentBinding4 == null || (smartRefreshLayout2 = dialogReaderCommentFragmentBinding4.refreshLayout) == null) {
                return;
            }
            smartRefreshLayout2.e0();
            return;
        }
        DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding5 = this.binding;
        smartRefreshLayout = dialogReaderCommentFragmentBinding5 != null ? dialogReaderCommentFragmentBinding5.refreshLayout : null;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.setVisibility(0);
        }
        DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding6 = this.binding;
        if (dialogReaderCommentFragmentBinding6 != null && (smartRefreshLayout3 = dialogReaderCommentFragmentBinding6.refreshLayout) != null) {
            smartRefreshLayout3.N(true);
        }
        int i11 = this.commentType;
        if (i11 == 0 && this.pageIndex == 0 && (readerCommentAdapter = this.readerCommentAdapter) != null) {
            if (readerCommentAdapter != null) {
                readerCommentAdapter.I(commentList);
            }
            DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding7 = this.binding;
            if (dialogReaderCommentFragmentBinding7 == null || (recyclerView3 = dialogReaderCommentFragmentBinding7.rvComment) == null) {
                return;
            }
            recyclerView3.scrollToPosition(0);
            return;
        }
        if (i11 == 1 && this.lastCreatedOn == null && this.readerCommentAdapter != null) {
            this.lastCreatedOn = ((Comment) CollectionsKt.last((List) commentList)).getCreatedOn();
            ReaderCommentAdapter readerCommentAdapter2 = this.readerCommentAdapter;
            if (readerCommentAdapter2 != null) {
                readerCommentAdapter2.I(commentList);
            }
            DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding8 = this.binding;
            if (dialogReaderCommentFragmentBinding8 == null || (recyclerView2 = dialogReaderCommentFragmentBinding8.rvComment) == null) {
                return;
            }
            recyclerView2.scrollToPosition(0);
            return;
        }
        if (this.readerCommentAdapter == null) {
            ReaderCommentAdapter readerCommentAdapter3 = new ReaderCommentAdapter(o0(), this.bookCommentType);
            this.readerCommentAdapter = readerCommentAdapter3;
            DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding9 = this.binding;
            if (dialogReaderCommentFragmentBinding9 != null && (recyclerView = dialogReaderCommentFragmentBinding9.rvComment) != null) {
                recyclerView.setAdapter(readerCommentAdapter3);
            }
        }
        this.lastCreatedOn = ((Comment) CollectionsKt.last((List) commentList)).getCreatedOn();
        ReaderCommentAdapter readerCommentAdapter4 = this.readerCommentAdapter;
        if (readerCommentAdapter4 != null) {
            readerCommentAdapter4.n(commentList);
        }
    }

    @JvmStatic
    public static final void M0(@l FragmentActivity fragmentActivity, @k CommentCount commentCount, @l String str, @l String str2, @l String str3, @l String str4, @l e2.d dVar) {
        INSTANCE.a(fragmentActivity, commentCount, str, str2, str3, str4, dVar);
    }

    @JvmStatic
    public static final void O0(@l FragmentActivity fragmentActivity, @l BookInfo bookInfo) {
        INSTANCE.b(fragmentActivity, bookInfo);
    }

    private final void P0() {
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            if (activity == null || !activity.isFinishing()) {
                ReaderPostOrReplyCommentFragment.X(getActivity(), o0().getCommentCount(), o0().getSourceName(), o0().getSourceId(), this.commentString, o0().getParagraphContent(), o0().getSelectParagraphText(), true, new c());
            }
        }
    }

    private final void Q0(int score) {
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            if (activity == null || !activity.isFinishing()) {
                ReaderPostBookCommentFragment.q0(getActivity(), o0().getMBookInfo(), score, this.commentString, new d());
            }
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void R0() {
        ReaderThemeTextView readerThemeTextView;
        Integer nStars;
        ReaderThemeTextView readerThemeTextView2;
        Float score;
        int i10 = 0;
        BookInfo mBookInfo = o0().getMBookInfo();
        float floatValue = (mBookInfo == null || (score = mBookInfo.getScore()) == null) ? 0.0f : score.floatValue();
        if (floatValue > 0.0f) {
            DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding = this.binding;
            if (dialogReaderCommentFragmentBinding != null && (readerThemeTextView2 = dialogReaderCommentFragmentBinding.bookVoteScore) != null) {
                readerThemeTextView2.setTextSize(2, 24.0f);
            }
            float f10 = floatValue / 10.0f;
            DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding2 = this.binding;
            ReaderThemeTextView readerThemeTextView3 = dialogReaderCommentFragmentBinding2 != null ? dialogReaderCommentFragmentBinding2.bookVoteScore : null;
            if (readerThemeTextView3 != null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(f10)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                readerThemeTextView3.setText(format);
            }
            DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding3 = this.binding;
            ReaderThemeTextView readerThemeTextView4 = dialogReaderCommentFragmentBinding3 != null ? dialogReaderCommentFragmentBinding3.bookVoteScoreHint : null;
            if (readerThemeTextView4 != null) {
                readerThemeTextView4.setVisibility(0);
            }
        } else {
            DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding4 = this.binding;
            if (dialogReaderCommentFragmentBinding4 != null && (readerThemeTextView = dialogReaderCommentFragmentBinding4.bookVoteScore) != null) {
                readerThemeTextView.setTextSize(2, 18.0f);
            }
            DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding5 = this.binding;
            ReaderThemeTextView readerThemeTextView5 = dialogReaderCommentFragmentBinding5 != null ? dialogReaderCommentFragmentBinding5.bookVoteScore : null;
            if (readerThemeTextView5 != null) {
                Context context = getContext();
                readerThemeTextView5.setText(context != null ? context.getString(com.martian.mibook.R.string.empty_grade) : null);
            }
            DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding6 = this.binding;
            ReaderThemeTextView readerThemeTextView6 = dialogReaderCommentFragmentBinding6 != null ? dialogReaderCommentFragmentBinding6.bookVoteScoreHint : null;
            if (readerThemeTextView6 != null) {
                readerThemeTextView6.setVisibility(8);
            }
        }
        BookInfo mBookInfo2 = o0().getMBookInfo();
        int intValue = (mBookInfo2 == null || (nStars = mBookInfo2.getNStars()) == null) ? 0 : nStars.intValue();
        DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding7 = this.binding;
        ReaderThemeTextView readerThemeTextView7 = dialogReaderCommentFragmentBinding7 != null ? dialogReaderCommentFragmentBinding7.bookCommentScoreTips : null;
        if (readerThemeTextView7 != null) {
            readerThemeTextView7.setText(intValue > 0 ? "评分" : "快来评分吧");
        }
        BookInfo mBookInfo3 = o0().getMBookInfo();
        Comment myComment = mBookInfo3 != null ? mBookInfo3.getMyComment() : null;
        if (myComment != null) {
            i10 = myComment.getScore();
            DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding8 = this.binding;
            ReaderThemeTextView readerThemeTextView8 = dialogReaderCommentFragmentBinding8 != null ? dialogReaderCommentFragmentBinding8.bookCommentStatus : null;
            if (readerThemeTextView8 != null) {
                Context context2 = getContext();
                String string = context2 != null ? context2.getString(com.martian.mibook.R.string.mine) : null;
                Context context3 = getContext();
                readerThemeTextView8.setText(string + (context3 != null ? context3.getString(com.martian.mibook.R.string.grade) : null));
            }
        } else {
            DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding9 = this.binding;
            ReaderThemeTextView readerThemeTextView9 = dialogReaderCommentFragmentBinding9 != null ? dialogReaderCommentFragmentBinding9.bookCommentStatus : null;
            if (readerThemeTextView9 != null) {
                Context context4 = getContext();
                readerThemeTextView9.setText(context4 != null ? context4.getString(com.martian.mibook.R.string.touch_to_comment) : null);
            }
        }
        T0(i10);
    }

    public final void T0(int score) {
        ReaderThemeImageView readerThemeImageView;
        ReaderThemeImageView readerThemeImageView2;
        ReaderThemeImageView readerThemeImageView3;
        ReaderThemeImageView readerThemeImageView4;
        ReaderThemeImageView readerThemeImageView5;
        DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding = this.binding;
        if (dialogReaderCommentFragmentBinding != null && (readerThemeImageView5 = dialogReaderCommentFragmentBinding.bookCommentVote1) != null) {
            readerThemeImageView5.setImageResource(score < 20 ? com.martian.mibook.R.drawable.icon_post_comment_star : com.martian.mibook.R.drawable.vote_star_red);
        }
        DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding2 = this.binding;
        if (dialogReaderCommentFragmentBinding2 != null && (readerThemeImageView4 = dialogReaderCommentFragmentBinding2.bookCommentVote2) != null) {
            readerThemeImageView4.setImageResource(score < 40 ? com.martian.mibook.R.drawable.icon_post_comment_star : com.martian.mibook.R.drawable.vote_star_red);
        }
        DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding3 = this.binding;
        if (dialogReaderCommentFragmentBinding3 != null && (readerThemeImageView3 = dialogReaderCommentFragmentBinding3.bookCommentVote3) != null) {
            readerThemeImageView3.setImageResource(score < 60 ? com.martian.mibook.R.drawable.icon_post_comment_star : com.martian.mibook.R.drawable.vote_star_red);
        }
        DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding4 = this.binding;
        if (dialogReaderCommentFragmentBinding4 != null && (readerThemeImageView2 = dialogReaderCommentFragmentBinding4.bookCommentVote4) != null) {
            readerThemeImageView2.setImageResource(score < 80 ? com.martian.mibook.R.drawable.icon_post_comment_star : com.martian.mibook.R.drawable.vote_star_red);
        }
        DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding5 = this.binding;
        if (dialogReaderCommentFragmentBinding5 == null || (readerThemeImageView = dialogReaderCommentFragmentBinding5.bookCommentVote5) == null) {
            return;
        }
        readerThemeImageView.setImageResource(score < 100 ? com.martian.mibook.R.drawable.icon_post_comment_star : com.martian.mibook.R.drawable.vote_star_red);
    }

    private final void k0() {
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        this.loadMoreFail = false;
        DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding = this.binding;
        if (dialogReaderCommentFragmentBinding != null && (smartRefreshLayout3 = dialogReaderCommentFragmentBinding.refreshLayout) != null) {
            smartRefreshLayout3.p();
        }
        DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding2 = this.binding;
        if (dialogReaderCommentFragmentBinding2 != null && (smartRefreshLayout2 = dialogReaderCommentFragmentBinding2.refreshLayout) != null) {
            smartRefreshLayout2.S();
        }
        DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding3 = this.binding;
        if (dialogReaderCommentFragmentBinding3 == null || (smartRefreshLayout = dialogReaderCommentFragmentBinding3.refreshLayout) == null) {
            return;
        }
        smartRefreshLayout.n();
    }

    public final AppViewModel l0() {
        return (AppViewModel) this.appViewModel.getValue();
    }

    public final void m0(boolean isLoadMore, boolean showLoading) {
        ReaderLoadingTip readerLoadingTip;
        ReaderCommentViewModel.CommentType commentType = this.bookCommentType;
        if (commentType == ReaderCommentViewModel.CommentType.TYPE_CHAPTER || commentType == ReaderCommentViewModel.CommentType.TYPE_PARAGRAPH) {
            if (o0().getCommentCount() == null) {
                return;
            }
            CommentCount commentCount = o0().getCommentCount();
            if (commentCount != null && commentCount.getNComments() == 0) {
                DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding = this.binding;
                SmartRefreshLayout smartRefreshLayout = dialogReaderCommentFragmentBinding != null ? dialogReaderCommentFragmentBinding.refreshLayout : null;
                if (smartRefreshLayout != null) {
                    smartRefreshLayout.setVisibility(8);
                }
                DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding2 = this.binding;
                if (dialogReaderCommentFragmentBinding2 == null || (readerLoadingTip = dialogReaderCommentFragmentBinding2.commentLoadingTip) == null) {
                    return;
                }
                readerLoadingTip.e(ReaderLoadingTip.LoadStatus.empty, "暂无评论");
                return;
            }
        }
        if (this.commentType == 0) {
            if (!isLoadMore) {
                this.pageIndex = 0;
            }
            GetCommentByScoreParams getCommentByScoreParams = new GetCommentByScoreParams(null, null, null, null, null, null, 0, 127, null);
            CommentCount commentCount2 = o0().getCommentCount();
            getCommentByScoreParams.setType(commentCount2 != null ? Integer.valueOf(commentCount2.getType()) : null);
            getCommentByScoreParams.setSourceName(o0().getSourceName());
            getCommentByScoreParams.setSourceId(o0().getSourceId());
            getCommentByScoreParams.setPage(Integer.valueOf(this.pageIndex));
            CommentCount commentCount3 = o0().getCommentCount();
            getCommentByScoreParams.setChapterId(commentCount3 != null ? commentCount3.getChapterId() : null);
            CommentCount commentCount4 = o0().getCommentCount();
            getCommentByScoreParams.setParagraphIdx(commentCount4 != null ? commentCount4.getParagraphIdx() : null);
            o0().u(getCommentByScoreParams, isLoadMore, showLoading);
            return;
        }
        if (!isLoadMore) {
            this.lastCreatedOn = null;
        }
        GetCommentByTimeParams getCommentByTimeParams = new GetCommentByTimeParams(null, null, null, null, null, null, 0, 127, null);
        CommentCount commentCount5 = o0().getCommentCount();
        getCommentByTimeParams.setType(commentCount5 != null ? Integer.valueOf(commentCount5.getType()) : null);
        getCommentByTimeParams.setSourceName(o0().getSourceName());
        getCommentByTimeParams.setSourceId(o0().getSourceId());
        CommentCount commentCount6 = o0().getCommentCount();
        getCommentByTimeParams.setChapterId(commentCount6 != null ? commentCount6.getChapterId() : null);
        CommentCount commentCount7 = o0().getCommentCount();
        getCommentByTimeParams.setParagraphIdx(commentCount7 != null ? commentCount7.getParagraphIdx() : null);
        getCommentByTimeParams.setLastCreatedOn(this.lastCreatedOn);
        o0().q(getCommentByTimeParams, isLoadMore, showLoading);
    }

    public static /* synthetic */ void n0(ReaderCommentFragment readerCommentFragment, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            ReaderCommentAdapter readerCommentAdapter = readerCommentFragment.readerCommentAdapter;
            z11 = (readerCommentAdapter != null ? readerCommentAdapter.getPageSize() : 0) <= 0;
        }
        readerCommentFragment.m0(z10, z11);
    }

    public final ReaderCommentViewModel o0() {
        return (ReaderCommentViewModel) this.mViewModel.getValue();
    }

    private final void p0() {
        DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding;
        ReaderThemeLinearLayout readerThemeLinearLayout;
        DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding2;
        ReaderThemeLinearLayout readerThemeLinearLayout2;
        ReaderCommentViewModel.CommentType commentType = this.bookCommentType;
        if (commentType == ReaderCommentViewModel.CommentType.TYPE_CHAPTER) {
            DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding3 = this.binding;
            ReaderThemeTextView readerThemeTextView = dialogReaderCommentFragmentBinding3 != null ? dialogReaderCommentFragmentBinding3.tvTitle : null;
            if (readerThemeTextView != null) {
                readerThemeTextView.setText(ExtKt.c("本章评论"));
            }
            DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding4 = this.binding;
            ReaderThemeTextView readerThemeTextView2 = dialogReaderCommentFragmentBinding4 != null ? dialogReaderCommentFragmentBinding4.chapterCommentDesc : null;
            if (readerThemeTextView2 != null) {
                readerThemeTextView2.setText(ExtKt.c("全部章评"));
            }
            DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding5 = this.binding;
            ReaderThemeTextView readerThemeTextView3 = dialogReaderCommentFragmentBinding5 != null ? dialogReaderCommentFragmentBinding5.chapterCommentPostHint : null;
            if (readerThemeTextView3 != null) {
                readerThemeTextView3.setText(ExtKt.c("加入本章讨论…"));
            }
            DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding6 = this.binding;
            ReaderThemeTextView readerThemeTextView4 = dialogReaderCommentFragmentBinding6 != null ? dialogReaderCommentFragmentBinding6.chapterCommentNumber : null;
            if (readerThemeTextView4 != null) {
                StringBuilder sb2 = new StringBuilder("(");
                CommentCount commentCount = o0().getCommentCount();
                sb2.append(commentCount != null ? Integer.valueOf(commentCount.getNComments()) : null);
                sb2.append("条)");
                readerThemeTextView4.setText(sb2);
            }
            CommentCount commentCount2 = o0().getCommentCount();
            if (commentCount2 != null && commentCount2.getNComments() == 0 && (dialogReaderCommentFragmentBinding2 = this.binding) != null && (readerThemeLinearLayout2 = dialogReaderCommentFragmentBinding2.chapterCommentPostView) != null) {
                readerThemeLinearLayout2.performClick();
            }
        } else if (commentType == ReaderCommentViewModel.CommentType.TYPE_PARAGRAPH) {
            DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding7 = this.binding;
            ReaderThemeTextView readerThemeTextView5 = dialogReaderCommentFragmentBinding7 != null ? dialogReaderCommentFragmentBinding7.tvTitle : null;
            if (readerThemeTextView5 != null) {
                readerThemeTextView5.setText(ExtKt.c("段评"));
            }
            DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding8 = this.binding;
            ReaderThemeTextView readerThemeTextView6 = dialogReaderCommentFragmentBinding8 != null ? dialogReaderCommentFragmentBinding8.chapterCommentDesc : null;
            if (readerThemeTextView6 != null) {
                readerThemeTextView6.setText(ExtKt.c("全部段评"));
            }
            DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding9 = this.binding;
            ReaderThemeTextView readerThemeTextView7 = dialogReaderCommentFragmentBinding9 != null ? dialogReaderCommentFragmentBinding9.chapterCommentPostHint : null;
            if (readerThemeTextView7 != null) {
                readerThemeTextView7.setText(ExtKt.c("段评千万条，友善第一条"));
            }
            DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding10 = this.binding;
            ReaderThemeTextView readerThemeTextView8 = dialogReaderCommentFragmentBinding10 != null ? dialogReaderCommentFragmentBinding10.chapterCommentNumber : null;
            if (readerThemeTextView8 != null) {
                StringBuilder sb3 = new StringBuilder("(");
                CommentCount commentCount3 = o0().getCommentCount();
                sb3.append(commentCount3 != null ? Integer.valueOf(commentCount3.getNComments()) : null);
                sb3.append("条)");
                readerThemeTextView8.setText(sb3);
            }
            CommentCount commentCount4 = o0().getCommentCount();
            if (commentCount4 != null && commentCount4.getNComments() == 0 && (dialogReaderCommentFragmentBinding = this.binding) != null && (readerThemeLinearLayout = dialogReaderCommentFragmentBinding.chapterCommentPostView) != null) {
                readerThemeLinearLayout.performClick();
            }
        } else {
            DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding11 = this.binding;
            ReaderThemeLinearLayout readerThemeLinearLayout3 = dialogReaderCommentFragmentBinding11 != null ? dialogReaderCommentFragmentBinding11.bookCommentView : null;
            if (readerThemeLinearLayout3 != null) {
                readerThemeLinearLayout3.setVisibility(0);
            }
            DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding12 = this.binding;
            ReaderThemeTextView readerThemeTextView9 = dialogReaderCommentFragmentBinding12 != null ? dialogReaderCommentFragmentBinding12.tvTitle : null;
            if (readerThemeTextView9 != null) {
                readerThemeTextView9.setText(ExtKt.c("全部书评"));
            }
            DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding13 = this.binding;
            ReaderThemeTextView readerThemeTextView10 = dialogReaderCommentFragmentBinding13 != null ? dialogReaderCommentFragmentBinding13.chapterCommentDesc : null;
            if (readerThemeTextView10 != null) {
                readerThemeTextView10.setText(ExtKt.c("评论"));
            }
            DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding14 = this.binding;
            ReaderThemeTextView readerThemeTextView11 = dialogReaderCommentFragmentBinding14 != null ? dialogReaderCommentFragmentBinding14.chapterCommentPostHint : null;
            if (readerThemeTextView11 != null) {
                readerThemeTextView11.setText(ExtKt.c("写下对本书的评价…"));
            }
            o0().r(o0().getSourceName(), o0().getSourceId());
        }
        DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding15 = this.binding;
        RecyclerView recyclerView = dialogReaderCommentFragmentBinding15 != null ? dialogReaderCommentFragmentBinding15.rvComment : null;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        I0(0);
    }

    private final void q0() {
        MutableLiveData<Unit> i02;
        MutableLiveData<Pair<String, Integer>> g02;
        ReaderThemeLinearLayout readerThemeLinearLayout;
        ReaderThemeImageView readerThemeImageView;
        ReaderThemeImageView readerThemeImageView2;
        ReaderThemeImageView readerThemeImageView3;
        ReaderThemeImageView readerThemeImageView4;
        ReaderThemeImageView readerThemeImageView5;
        ReaderLoadingTip readerLoadingTip;
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        ReaderThemeImageView readerThemeImageView6;
        DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding = this.binding;
        if (dialogReaderCommentFragmentBinding != null && (readerThemeImageView6 = dialogReaderCommentFragmentBinding.ivClose) != null) {
            readerThemeImageView6.setOnClickListener(new View.OnClickListener() { // from class: ed.a
                public /* synthetic */ a() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderCommentFragment.r0(ReaderCommentFragment.this, view);
                }
            });
        }
        DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding2 = this.binding;
        if (dialogReaderCommentFragmentBinding2 != null && (smartRefreshLayout3 = dialogReaderCommentFragmentBinding2.refreshLayout) != null) {
            smartRefreshLayout3.j0(false);
        }
        DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding3 = this.binding;
        if (dialogReaderCommentFragmentBinding3 != null && (smartRefreshLayout2 = dialogReaderCommentFragmentBinding3.refreshLayout) != null) {
            smartRefreshLayout2.U(new MiClassicsFooter(getContext(), 3, true));
        }
        DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding4 = this.binding;
        if (dialogReaderCommentFragmentBinding4 != null && (smartRefreshLayout = dialogReaderCommentFragmentBinding4.refreshLayout) != null) {
            smartRefreshLayout.f0(new sf.e() { // from class: ed.n
                public /* synthetic */ n() {
                }

                @Override // sf.e
                public final void p(pf.f fVar) {
                    ReaderCommentFragment.z0(ReaderCommentFragment.this, fVar);
                }
            });
        }
        DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding5 = this.binding;
        if (dialogReaderCommentFragmentBinding5 != null && (readerLoadingTip = dialogReaderCommentFragmentBinding5.commentLoadingTip) != null) {
            readerLoadingTip.setOnReloadListener(new Function0<Unit>() { // from class: com.martian.mibook.mvvm.read.fragment.ReaderCommentFragment$initListener$3
                public ReaderCommentFragment$initListener$3() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke */
                public final void invoke2() {
                    ac.a.A(ReaderCommentFragment.this.getContext(), "重新加载");
                    ReaderCommentFragment.this.m0(false, true);
                }
            });
        }
        o0().h().observe(this, new Observer() { // from class: ed.o
            public /* synthetic */ o() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReaderCommentFragment.A0(Function1.this, obj);
            }
        });
        o0().z().observe(this, new Observer() { // from class: ed.p
            public /* synthetic */ p() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReaderCommentFragment.B0(Function1.this, obj);
            }
        });
        o0().x().observe(this, new Observer() { // from class: ed.b
            public /* synthetic */ b() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReaderCommentFragment.C0(Function1.this, obj);
            }
        });
        o0().y().observe(this, new Observer() { // from class: ed.c
            public /* synthetic */ c() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReaderCommentFragment.D0(Function1.this, obj);
            }
        });
        o0().w().observe(this, new Observer() { // from class: ed.d
            public /* synthetic */ d() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReaderCommentFragment.E0(Function1.this, obj);
            }
        });
        o0().B().observe(this, new Observer() { // from class: ed.e
            public /* synthetic */ e() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReaderCommentFragment.F0(Function1.this, obj);
            }
        });
        DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding6 = this.binding;
        if (dialogReaderCommentFragmentBinding6 != null && (readerThemeImageView5 = dialogReaderCommentFragmentBinding6.bookCommentVote1) != null) {
            readerThemeImageView5.setOnClickListener(new View.OnClickListener() { // from class: ed.f
                public /* synthetic */ f() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderCommentFragment.G0(ReaderCommentFragment.this, view);
                }
            });
        }
        DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding7 = this.binding;
        if (dialogReaderCommentFragmentBinding7 != null && (readerThemeImageView4 = dialogReaderCommentFragmentBinding7.bookCommentVote2) != null) {
            readerThemeImageView4.setOnClickListener(new View.OnClickListener() { // from class: ed.g
                public /* synthetic */ g() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderCommentFragment.s0(ReaderCommentFragment.this, view);
                }
            });
        }
        DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding8 = this.binding;
        if (dialogReaderCommentFragmentBinding8 != null && (readerThemeImageView3 = dialogReaderCommentFragmentBinding8.bookCommentVote3) != null) {
            readerThemeImageView3.setOnClickListener(new View.OnClickListener() { // from class: ed.h
                public /* synthetic */ h() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderCommentFragment.t0(ReaderCommentFragment.this, view);
                }
            });
        }
        DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding9 = this.binding;
        if (dialogReaderCommentFragmentBinding9 != null && (readerThemeImageView2 = dialogReaderCommentFragmentBinding9.bookCommentVote4) != null) {
            readerThemeImageView2.setOnClickListener(new View.OnClickListener() { // from class: ed.i
                public /* synthetic */ i() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderCommentFragment.u0(ReaderCommentFragment.this, view);
                }
            });
        }
        DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding10 = this.binding;
        if (dialogReaderCommentFragmentBinding10 != null && (readerThemeImageView = dialogReaderCommentFragmentBinding10.bookCommentVote5) != null) {
            readerThemeImageView.setOnClickListener(new View.OnClickListener() { // from class: ed.j
                public /* synthetic */ j() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderCommentFragment.v0(ReaderCommentFragment.this, view);
                }
            });
        }
        DialogReaderCommentFragmentBinding dialogReaderCommentFragmentBinding11 = this.binding;
        if (dialogReaderCommentFragmentBinding11 != null && (readerThemeLinearLayout = dialogReaderCommentFragmentBinding11.chapterCommentPostView) != null) {
            readerThemeLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: ed.k
                public /* synthetic */ k() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderCommentFragment.w0(ReaderCommentFragment.this, view);
                }
            });
        }
        AppViewModel l02 = l0();
        if (l02 != null && (g02 = l02.g0()) != null) {
            g02.observe(this, new Observer() { // from class: ed.l
                public /* synthetic */ l() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ReaderCommentFragment.x0(Function1.this, obj);
                }
            });
        }
        AppViewModel l03 = l0();
        if (l03 == null || (i02 = l03.i0()) == null) {
            return;
        }
        i02.observe(this, new Observer() { // from class: ed.m
            public /* synthetic */ m() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReaderCommentFragment.y0(Function1.this, obj);
            }
        });
    }

    public static final void r0(ReaderCommentFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void s0(ReaderCommentFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q0(40);
    }

    public static final void t0(ReaderCommentFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q0(60);
    }

    public static final void u0(ReaderCommentFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q0(80);
    }

    public static final void v0(ReaderCommentFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q0(100);
    }

    public static final void w0(ReaderCommentFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.bookCommentType == ReaderCommentViewModel.CommentType.TYPE_BOOK_COMMENT) {
            this$0.Q0(100);
        } else {
            this$0.P0();
        }
    }

    public static final void x0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void y0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void z0(ReaderCommentFragment this$0, f it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (!this$0.loadMoreFail && this$0.commentType == 0) {
            this$0.pageIndex++;
        }
        n0(this$0, true, false, 2, null);
    }

    public final void L0(@l e2.d listener) {
        this.listener = listener;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b8, code lost:
    
        if (android.text.TextUtils.isEmpty(r6 != null ? r6.getBookName() : null) != false) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x010e, code lost:
    
        if (r6 == null) goto L134;
     */
    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(@xi.l android.os.Bundle r6) {
        /*
            r5 = this;
            super.onCreate(r6)
            android.os.Bundle r6 = r5.getArguments()
            if (r6 == 0) goto L114
            java.lang.String r0 = "INTENT_COMMENT_COUNT"
            java.lang.String r0 = r6.getString(r0)
            boolean r1 = ba.l.q(r0)
            r2 = 0
            if (r1 != 0) goto L2a
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel r1 = r5.o0()
            com.google.gson.Gson r3 = com.martian.libcomm.utils.GsonUtils.b()
            java.lang.Class<com.martian.mibook.data.book.CommentCount> r4 = com.martian.mibook.data.book.CommentCount.class
            java.lang.Object r0 = r3.fromJson(r0, r4)
            com.martian.mibook.data.book.CommentCount r0 = (com.martian.mibook.data.book.CommentCount) r0
            r1.H(r0)
            goto L31
        L2a:
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel r0 = r5.o0()
            r0.H(r2)
        L31:
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel r0 = r5.o0()
            java.lang.String r1 = "INTENT_SOURCE_NAME"
            java.lang.String r1 = r6.getString(r1)
            r0.N(r1)
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel r0 = r5.o0()
            java.lang.String r1 = "INTENT_SOURCE_ID"
            java.lang.String r1 = r6.getString(r1)
            r0.M(r1)
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel r0 = r5.o0()
            java.lang.String r1 = "INTENT_PARAGRAPH_CONTENT"
            java.lang.String r1 = r6.getString(r1)
            r0.K(r1)
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel r0 = r5.o0()
            java.lang.String r1 = "INTENT_SELECT_PARAGRAPH_TEXT"
            java.lang.String r1 = r6.getString(r1)
            r0.L(r1)
            java.lang.String r0 = "INTENT_COMMENT_BOOK_INFO"
            java.lang.String r6 = r6.getString(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto Lf9
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel r0 = r5.o0()
            com.google.gson.Gson r1 = com.martian.libcomm.utils.GsonUtils.b()
            java.lang.Class<com.martian.mibook.mvvm.book.viewmodel.BookInfo> r3 = com.martian.mibook.mvvm.book.viewmodel.BookInfo.class
            java.lang.Object r6 = r1.fromJson(r6, r3)
            com.martian.mibook.mvvm.book.viewmodel.BookInfo r6 = (com.martian.mibook.mvvm.book.viewmodel.BookInfo) r6
            r0.J(r6)
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel r6 = r5.o0()
            com.martian.mibook.mvvm.book.viewmodel.BookInfo r6 = r6.getMBookInfo()
            if (r6 == 0) goto Le8
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel r6 = r5.o0()
            com.martian.mibook.mvvm.book.viewmodel.BookInfo r6 = r6.getMBookInfo()
            if (r6 == 0) goto L9d
            java.lang.String r6 = r6.getAuthorName()
            goto L9e
        L9d:
            r6 = r2
        L9e:
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto Lbb
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel r6 = r5.o0()
            com.martian.mibook.mvvm.book.viewmodel.BookInfo r6 = r6.getMBookInfo()
            if (r6 == 0) goto Lb3
            java.lang.String r6 = r6.getBookName()
            goto Lb4
        Lb3:
            r6 = r2
        Lb4:
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto Lbb
            goto Le8
        Lbb:
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel r6 = r5.o0()
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel r0 = r5.o0()
            com.martian.mibook.mvvm.book.viewmodel.BookInfo r0 = r0.getMBookInfo()
            if (r0 == 0) goto Lce
            java.lang.String r0 = r0.getSourceName()
            goto Lcf
        Lce:
            r0 = r2
        Lcf:
            r6.N(r0)
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel r6 = r5.o0()
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel r0 = r5.o0()
            com.martian.mibook.mvvm.book.viewmodel.BookInfo r0 = r0.getMBookInfo()
            if (r0 == 0) goto Le4
            java.lang.String r2 = r0.getSourceId()
        Le4:
            r6.M(r2)
            goto Lf9
        Le8:
            android.content.Context r6 = r5.getContext()
            java.lang.String r0 = "获取信息失败"
            java.lang.String r0 = com.martian.mibook.mvvm.extensions.ExtKt.c(r0)
            l9.t0.b(r6, r0)
            r5.dismiss()
            return
        Lf9:
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel r6 = r5.o0()
            com.martian.mibook.data.book.CommentCount r6 = r6.getCommentCount()
            if (r6 == 0) goto L110
            boolean r6 = r6.isParagraphComment()
            if (r6 == 0) goto L10c
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel$CommentType r6 = com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel.CommentType.TYPE_PARAGRAPH
            goto L10e
        L10c:
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel$CommentType r6 = com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel.CommentType.TYPE_CHAPTER
        L10e:
            if (r6 != 0) goto L112
        L110:
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel$CommentType r6 = com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel.CommentType.TYPE_BOOK_COMMENT
        L112:
            r5.bookCommentType = r6
        L114:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.read.fragment.ReaderCommentFragment.onCreate(android.os.Bundle):void");
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment
    @l
    @SuppressLint({"InflateParams"})
    public View p(@k View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View inflate = LayoutInflater.from(getContext()).inflate(com.martian.mibook.R.layout.dialog_reader_comment_fragment, (ViewGroup) null);
        this.binding = DialogReaderCommentFragmentBinding.bind(inflate);
        return inflate;
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment
    public void r(@k View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.r(view);
        q0();
        H0();
        p0();
    }
}
