package com.martian.mibook.fragment.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.utils.tablayout.ClipPagerTitleView;
import com.martian.libmars.utils.tablayout.CommonNavigator;
import com.martian.libmars.utils.tablayout.LinePagerIndicator;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment;
import com.martian.libmars.widget.dialog.a;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.book.CommentCount;
import com.martian.mibook.databinding.DialogCommentFragmentBinding;
import com.martian.mibook.fragment.dialog.CommentFragment;
import com.martian.mibook.fragment.dialog.PostBookCommentFragment;
import com.martian.mibook.fragment.dialog.PostOrReplyCommentFragment;
import com.martian.mibook.mvvm.book.viewmodel.BookInfo;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.ErrorResult;
import com.martian.mibook.mvvm.net.request.GetCommentByScoreParams;
import com.martian.mibook.mvvm.net.request.GetCommentByTimeParams;
import com.martian.mibook.mvvm.read.adapter.CommentAdapter;
import com.martian.mibook.mvvm.read.comment.Comment;
import com.martian.mibook.mvvm.read.comment.CommentReply;
import com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.martian.mibook.mvvm.widget.MiClassicsFooter;
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

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 Z2\u00020\u0001:\u0001[B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u00042\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0003J#\u0010\u001c\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u001e\u0010\u0003J\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\tH\u0002¢\u0006\u0004\b \u0010\fJ\u000f\u0010!\u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010\u0003J\u0017\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\tH\u0002¢\u0006\u0004\b#\u0010\fJ\u0019\u0010&\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b&\u0010'J\u0019\u0010*\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020(H\u0017¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010,¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b0\u00101R\u001b\u00107\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001d\u0010<\u001a\u0004\u0018\u0001088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u00104\u001a\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010E\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010DR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Y\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010X¨\u0006\\"}, d2 = {"Lcom/martian/mibook/fragment/dialog/CommentFragment;", "Lcom/martian/libmars/widget/dialog/MartianBottomSheetDialogFragment;", "<init>", "()V", "", "r0", "M0", "I0", "q0", "", "index", "L0", "(I)V", "", "isLoadMore", "showLoading", "n0", "(ZZ)V", "", "Lcom/martian/mibook/mvvm/read/comment/Comment;", "commentList", "O0", "(Ljava/util/List;)V", "l0", "Lcom/martian/libmars/widget/recyclerview/LoadingTip;", "loadingTip", "Lcom/martian/mibook/mvvm/net/ErrorResult;", "errorResult", "J0", "(Lcom/martian/libmars/widget/recyclerview/LoadingTip;Lcom/martian/mibook/mvvm/net/ErrorResult;)V", "V0", "bookCommentScore", "W0", "T0", "score", "U0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "p", "(Landroid/view/View;)Landroid/view/View;", "Lya/e2$d;", "listener", "P0", "(Lya/e2$d;)V", t.f11211k, "(Landroid/view/View;)V", "Lcom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel;", "f", "Lkotlin/Lazy;", bq.f10843g, "()Lcom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel;", "mViewModel", "Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", "g", "m0", "()Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", "appViewModel", "Lcom/martian/mibook/databinding/DialogCommentFragmentBinding;", "h", "Lcom/martian/mibook/databinding/DialogCommentFragmentBinding;", "binding", "i", "Lya/e2$d;", "j", "I", "commentType", "Lcom/martian/mibook/mvvm/read/adapter/CommentAdapter;", "k", "Lcom/martian/mibook/mvvm/read/adapter/CommentAdapter;", "commentAdapter", t.f11204d, "Z", "loadMoreFail", "m", "pageIndex", "", "n", "Ljava/lang/Long;", "lastCreatedOn", "", "o", "Ljava/lang/String;", "commentString", "Lcom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel$CommentType;", "Lcom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel$CommentType;", "bookCommentType", "q", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class CommentFragment extends MartianBottomSheetDialogFragment {

    /* renamed from: q, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: r */
    @k
    public static final String f13698r = "CommentFragment";

    /* renamed from: s */
    @k
    public static final String f13699s = "INTENT_COMMENT_COUNT";

    /* renamed from: t */
    @k
    public static final String f13700t = "INTENT_SOURCE_NAME";

    /* renamed from: u */
    @k
    public static final String f13701u = "INTENT_SOURCE_ID";

    /* renamed from: v */
    @k
    public static final String f13702v = "INTENT_PARAGRAPH_CONTENT";

    /* renamed from: w */
    @k
    public static final String f13703w = "INTENT_SELECT_PARAGRAPH_TEXT";

    /* renamed from: x */
    @k
    public static final String f13704x = "INTENT_COMMENT_BOOK_INFO";

    /* renamed from: f, reason: from kotlin metadata */
    @k
    public final Lazy mViewModel = LazyKt.lazy(new Function0<ReaderCommentViewModel>() { // from class: com.martian.mibook.fragment.dialog.CommentFragment$mViewModel$2
        public CommentFragment$mViewModel$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @k
        public final ReaderCommentViewModel invoke() {
            return (ReaderCommentViewModel) new ViewModelProvider(CommentFragment.this).get(ReaderCommentViewModel.class);
        }
    });

    /* renamed from: g, reason: from kotlin metadata */
    @k
    public final Lazy appViewModel = LazyKt.lazy(new Function0<AppViewModel>() { // from class: com.martian.mibook.fragment.dialog.CommentFragment$appViewModel$2
        public CommentFragment$appViewModel$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @l
        public final AppViewModel invoke() {
            return b.a(CommentFragment.this.getContext());
        }
    });

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public DialogCommentFragmentBinding binding;

    /* renamed from: i, reason: from kotlin metadata */
    @l
    public e2.d listener;

    /* renamed from: j, reason: from kotlin metadata */
    public int commentType;

    /* renamed from: k, reason: from kotlin metadata */
    @l
    public CommentAdapter commentAdapter;

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

    /* renamed from: com.martian.mibook.fragment.dialog.CommentFragment$a, reason: from kotlin metadata */
    public static final class Companion {

        /* renamed from: com.martian.mibook.fragment.dialog.CommentFragment$a$a */
        public static final class C0529a implements MartianBottomSheetDialogFragment.b {
            @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment.b
            public void a(@k DialogFragment dialogFragment) {
                Intrinsics.checkNotNullParameter(dialogFragment, "dialogFragment");
                boolean A0 = MiConfigSingleton.b2().A0();
                com.gyf.immersionbar.d.y3(dialogFragment).T2(!A0).G1(!A0).v1(ConfigSingleton.D().L(), 0.0f).a1();
            }
        }

        /* renamed from: com.martian.mibook.fragment.dialog.CommentFragment$a$b */
        public static final class b implements MartianBottomSheetDialogFragment.b {
            @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment.b
            public void a(@k DialogFragment dialogFragment) {
                Intrinsics.checkNotNullParameter(dialogFragment, "dialogFragment");
                boolean A0 = MiConfigSingleton.b2().A0();
                com.gyf.immersionbar.d.y3(dialogFragment).T2(!A0).G1(!A0).v1(ConfigSingleton.D().L(), 0.0f).a1();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@k FragmentActivity activity, @k CommentCount commentCount, @l String str, @l String str2, @l String str3, @l String str4, @l e2.d dVar) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(commentCount, "commentCount");
            a a10 = MartianBottomSheetDialogFragment.INSTANCE.a();
            a10.k0(true).j0(true).x0(R.style.BottomSheetDialog).q0(ConfigSingleton.i(16.0f)).n0((m.h(activity) + m.j(activity)) - ConfigSingleton.i(80.0f)).s0(new b());
            CommentFragment commentFragment = new CommentFragment();
            Bundle bundle = new Bundle();
            bundle.putString("INTENT_COMMENT_COUNT", GsonUtils.b().toJson(commentCount));
            bundle.putString("INTENT_SOURCE_NAME", str);
            bundle.putString("INTENT_SOURCE_ID", str2);
            bundle.putString("INTENT_PARAGRAPH_CONTENT", str3);
            bundle.putString("INTENT_SELECT_PARAGRAPH_TEXT", str4);
            commentFragment.setArguments(bundle);
            commentFragment.P0(dVar);
            a10.c0(activity, commentFragment, CommentFragment.f13698r, true);
        }

        @JvmStatic
        public final void b(@k FragmentActivity activity, @k BookInfo bookInfo) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(bookInfo, "bookInfo");
            a a10 = MartianBottomSheetDialogFragment.INSTANCE.a();
            a10.k0(true).j0(true).x0(R.style.BottomSheetDialog).q0(ConfigSingleton.i(16.0f)).n0((m.h(activity) + m.j(activity)) - ConfigSingleton.i(80.0f)).s0(new C0529a());
            CommentFragment commentFragment = new CommentFragment();
            Bundle bundle = new Bundle();
            bundle.putString("INTENT_COMMENT_BOOK_INFO", GsonUtils.b().toJson(bookInfo));
            commentFragment.setArguments(bundle);
            a10.c0(activity, commentFragment, CommentFragment.f13698r, true);
        }

        public Companion() {
        }
    }

    public static final class b extends m9.b {

        /* renamed from: b */
        public final /* synthetic */ m9.d f13716b;

        /* renamed from: c */
        public final /* synthetic */ CommentFragment f13717c;

        public b(m9.d dVar, CommentFragment commentFragment) {
            this.f13716b = dVar;
            this.f13717c = commentFragment;
        }

        public static final void k(m9.d helper, int i10, ClipPagerTitleView clipPagerTitleView, CommentFragment this$0, View view) {
            Intrinsics.checkNotNullParameter(helper, "$helper");
            Intrinsics.checkNotNullParameter(clipPagerTitleView, "$clipPagerTitleView");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            helper.j(i10, true);
            clipPagerTitleView.postDelayed(new Runnable() { // from class: eb.r

                /* renamed from: c */
                public final /* synthetic */ int f25834c;

                public /* synthetic */ r(int i102) {
                    i10 = i102;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    CommentFragment.b.l(CommentFragment.this, i10);
                }
            }, 300L);
        }

        public static final void l(CommentFragment this$0, int i10) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.L0(i10);
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
            linePagerIndicator.h(ConfigSingleton.i(2.0f)).j(ConfigSingleton.i(16.0f)).d(Integer.valueOf(ExtKt.e(context, ConfigSingleton.D().A0() ? R.color.night_background_secondary : R.color.white)));
            return linePagerIndicator;
        }

        @Override // m9.b
        @k
        public g c(@k Context context, int i10) {
            Intrinsics.checkNotNullParameter(context, "context");
            ClipPagerTitleView clipPagerTitleView = new ClipPagerTitleView(context);
            int i11 = ConfigSingleton.i(8.0f);
            int i12 = ConfigSingleton.i(4.0f);
            clipPagerTitleView.setTextSize(ConfigSingleton.i(12.0f));
            clipPagerTitleView.setPadding(i11, i12, i11, i12);
            clipPagerTitleView.setText(ExtKt.c(i10 == 0 ? "最热" : "最新"));
            int i13 = ConfigSingleton.D().A0() ? R.color.night_text_color_primary : R.color.day_text_color_primary;
            clipPagerTitleView.setTextColor(ExtKt.e(context, i13));
            clipPagerTitleView.setSelectTextColor(ExtKt.e(context, i13));
            clipPagerTitleView.setOnClickListener(new View.OnClickListener() { // from class: eb.q

                /* renamed from: c */
                public final /* synthetic */ int f25830c;

                /* renamed from: d */
                public final /* synthetic */ ClipPagerTitleView f25831d;

                /* renamed from: e */
                public final /* synthetic */ CommentFragment f25832e;

                public /* synthetic */ q(int i102, ClipPagerTitleView clipPagerTitleView2, CommentFragment commentFragment) {
                    i10 = i102;
                    clipPagerTitleView = clipPagerTitleView2;
                    commentFragment = commentFragment;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommentFragment.b.k(m9.d.this, i10, clipPagerTitleView, commentFragment, view);
                }
            });
            return clipPagerTitleView2;
        }
    }

    public static final class c implements PostOrReplyCommentFragment.e {
        public c() {
        }

        @Override // com.martian.mibook.fragment.dialog.PostOrReplyCommentFragment.e
        public void a(@k CommentReply comment) {
            Intrinsics.checkNotNullParameter(comment, "comment");
        }

        @Override // com.martian.mibook.fragment.dialog.PostOrReplyCommentFragment.e
        public void b(@k Comment comment) {
            Intrinsics.checkNotNullParameter(comment, "comment");
            ac.a.A(CommentFragment.this.getContext(), "发表评论");
            if (CommentFragment.this.commentAdapter != null) {
                CommentAdapter commentAdapter = CommentFragment.this.commentAdapter;
                if (commentAdapter != null) {
                    commentAdapter.b0(0, comment);
                }
            } else {
                CommentFragment.this.O0(CollectionsKt.arrayListOf(comment));
            }
            CommentFragment.this.commentString = null;
            e2.d dVar = CommentFragment.this.listener;
            if (dVar != null) {
                CommentCount commentCount = CommentFragment.this.p0().getCommentCount();
                Intrinsics.checkNotNull(commentCount);
                dVar.a(commentCount.getChapterId(), comment);
            }
            CommentCount commentCount2 = CommentFragment.this.p0().getCommentCount();
            if (commentCount2 != null) {
                commentCount2.incrNComments();
            }
            CommentCount commentCount3 = CommentFragment.this.p0().getCommentCount();
            if (commentCount3 != null) {
                commentCount3.addComment(comment);
            }
            DialogCommentFragmentBinding dialogCommentFragmentBinding = CommentFragment.this.binding;
            ThemeTextView themeTextView = dialogCommentFragmentBinding != null ? dialogCommentFragmentBinding.chapterCommentNumber : null;
            if (themeTextView == null) {
                return;
            }
            StringBuilder sb2 = new StringBuilder("(");
            CommentCount commentCount4 = CommentFragment.this.p0().getCommentCount();
            sb2.append(commentCount4 != null ? Integer.valueOf(commentCount4.getNComments()) : null);
            sb2.append("条)");
            themeTextView.setText(sb2);
        }

        @Override // com.martian.mibook.fragment.dialog.PostOrReplyCommentFragment.e
        public void c(@k String tag, @k String comment) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(comment, "comment");
            CommentFragment.this.commentString = comment;
        }
    }

    public static final class d implements PostBookCommentFragment.e {
        public d() {
        }

        @Override // com.martian.mibook.fragment.dialog.PostBookCommentFragment.e
        public void a(@k CommentReply comment) {
            Intrinsics.checkNotNullParameter(comment, "comment");
        }

        @Override // com.martian.mibook.fragment.dialog.PostBookCommentFragment.e
        public void b(@k Comment comment) {
            Integer nComments;
            Intrinsics.checkNotNullParameter(comment, "comment");
            int i10 = 0;
            if (CommentFragment.this.commentAdapter != null) {
                CommentAdapter commentAdapter = CommentFragment.this.commentAdapter;
                if (commentAdapter != null) {
                    commentAdapter.b0(0, comment);
                }
            } else {
                CommentFragment.this.O0(CollectionsKt.arrayListOf(comment));
            }
            CommentFragment.this.commentString = null;
            BookInfo mBookInfo = CommentFragment.this.p0().getMBookInfo();
            if (mBookInfo != null) {
                BookInfo mBookInfo2 = CommentFragment.this.p0().getMBookInfo();
                if (mBookInfo2 != null && (nComments = mBookInfo2.getNComments()) != null) {
                    i10 = nComments.intValue();
                }
                mBookInfo.setNComments(Integer.valueOf(i10 + 1));
            }
            DialogCommentFragmentBinding dialogCommentFragmentBinding = CommentFragment.this.binding;
            ThemeTextView themeTextView = dialogCommentFragmentBinding != null ? dialogCommentFragmentBinding.chapterCommentNumber : null;
            if (themeTextView != null) {
                StringBuilder sb2 = new StringBuilder("(");
                BookInfo mBookInfo3 = CommentFragment.this.p0().getMBookInfo();
                sb2.append(mBookInfo3 != null ? mBookInfo3.getNComments() : null);
                sb2.append("条)");
                themeTextView.setText(sb2);
            }
            CommentFragment.this.p0().r(CommentFragment.this.p0().getSourceName(), CommentFragment.this.p0().getSourceId());
        }

        @Override // com.martian.mibook.fragment.dialog.PostBookCommentFragment.e
        public void c(@k String tag, @k String comment) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(comment, "comment");
            CommentFragment.this.commentString = comment;
        }
    }

    public static final void A0(CommentFragment this$0, f it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (!this$0.loadMoreFail && this$0.commentType == 0) {
            this$0.pageIndex++;
        }
        o0(this$0, true, false, 2, null);
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

    public static final void G0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void H0(CommentFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.U0(20);
    }

    public final void M0() {
        MagicIndicator magicIndicator;
        int i10 = ConfigSingleton.D().A0() ? R.drawable.border_search_background_night : R.drawable.border_search_background_day;
        DialogCommentFragmentBinding dialogCommentFragmentBinding = this.binding;
        if (dialogCommentFragmentBinding != null && (magicIndicator = dialogCommentFragmentBinding.magicIndicatorComment) != null) {
            magicIndicator.setBackgroundResource(i10);
        }
        CommentAdapter commentAdapter = this.commentAdapter;
        if (commentAdapter != null) {
            commentAdapter.f0();
        }
    }

    @JvmStatic
    public static final void Q0(@k FragmentActivity fragmentActivity, @k CommentCount commentCount, @l String str, @l String str2, @l String str3, @l String str4, @l e2.d dVar) {
        INSTANCE.a(fragmentActivity, commentCount, str, str2, str3, str4, dVar);
    }

    @JvmStatic
    public static final void R0(@k FragmentActivity fragmentActivity, @k BookInfo bookInfo) {
        INSTANCE.b(fragmentActivity, bookInfo);
    }

    private final void U0(int score) {
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            if (activity == null || !activity.isFinishing()) {
                PostBookCommentFragment.q0(getActivity(), p0().getMBookInfo(), score, this.commentString, new d());
            }
        }
    }

    public final void W0(int bookCommentScore) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        ImageView imageView5;
        DialogCommentFragmentBinding dialogCommentFragmentBinding = this.binding;
        if (dialogCommentFragmentBinding != null && (imageView5 = dialogCommentFragmentBinding.bookCommentVote1) != null) {
            imageView5.setImageResource(bookCommentScore < 20 ? com.martian.mibook.R.drawable.icon_post_comment_star : com.martian.mibook.R.drawable.vote_star_red);
        }
        DialogCommentFragmentBinding dialogCommentFragmentBinding2 = this.binding;
        if (dialogCommentFragmentBinding2 != null && (imageView4 = dialogCommentFragmentBinding2.bookCommentVote2) != null) {
            imageView4.setImageResource(bookCommentScore < 40 ? com.martian.mibook.R.drawable.icon_post_comment_star : com.martian.mibook.R.drawable.vote_star_red);
        }
        DialogCommentFragmentBinding dialogCommentFragmentBinding3 = this.binding;
        if (dialogCommentFragmentBinding3 != null && (imageView3 = dialogCommentFragmentBinding3.bookCommentVote3) != null) {
            imageView3.setImageResource(bookCommentScore < 60 ? com.martian.mibook.R.drawable.icon_post_comment_star : com.martian.mibook.R.drawable.vote_star_red);
        }
        DialogCommentFragmentBinding dialogCommentFragmentBinding4 = this.binding;
        if (dialogCommentFragmentBinding4 != null && (imageView2 = dialogCommentFragmentBinding4.bookCommentVote4) != null) {
            imageView2.setImageResource(bookCommentScore < 80 ? com.martian.mibook.R.drawable.icon_post_comment_star : com.martian.mibook.R.drawable.vote_star_red);
        }
        DialogCommentFragmentBinding dialogCommentFragmentBinding5 = this.binding;
        if (dialogCommentFragmentBinding5 == null || (imageView = dialogCommentFragmentBinding5.bookCommentVote5) == null) {
            return;
        }
        imageView.setImageResource(bookCommentScore < 100 ? com.martian.mibook.R.drawable.icon_post_comment_star : com.martian.mibook.R.drawable.vote_star_red);
    }

    private final void l0() {
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        this.loadMoreFail = false;
        DialogCommentFragmentBinding dialogCommentFragmentBinding = this.binding;
        if (dialogCommentFragmentBinding != null && (smartRefreshLayout3 = dialogCommentFragmentBinding.refreshLayout) != null) {
            smartRefreshLayout3.p();
        }
        DialogCommentFragmentBinding dialogCommentFragmentBinding2 = this.binding;
        if (dialogCommentFragmentBinding2 != null && (smartRefreshLayout2 = dialogCommentFragmentBinding2.refreshLayout) != null) {
            smartRefreshLayout2.S();
        }
        DialogCommentFragmentBinding dialogCommentFragmentBinding3 = this.binding;
        if (dialogCommentFragmentBinding3 == null || (smartRefreshLayout = dialogCommentFragmentBinding3.refreshLayout) == null) {
            return;
        }
        smartRefreshLayout.n();
    }

    private final AppViewModel m0() {
        return (AppViewModel) this.appViewModel.getValue();
    }

    public static /* synthetic */ void o0(CommentFragment commentFragment, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            CommentAdapter commentAdapter = commentFragment.commentAdapter;
            z11 = (commentAdapter != null ? commentAdapter.getPageSize() : 0) <= 0;
        }
        commentFragment.n0(z10, z11);
    }

    public final ReaderCommentViewModel p0() {
        return (ReaderCommentViewModel) this.mViewModel.getValue();
    }

    private final void q0() {
        DialogCommentFragmentBinding dialogCommentFragmentBinding;
        ThemeLinearLayout themeLinearLayout;
        DialogCommentFragmentBinding dialogCommentFragmentBinding2;
        ThemeLinearLayout themeLinearLayout2;
        ReaderCommentViewModel.CommentType commentType = this.bookCommentType;
        if (commentType == ReaderCommentViewModel.CommentType.TYPE_CHAPTER) {
            DialogCommentFragmentBinding dialogCommentFragmentBinding3 = this.binding;
            ThemeTextView themeTextView = dialogCommentFragmentBinding3 != null ? dialogCommentFragmentBinding3.tvTitle : null;
            if (themeTextView != null) {
                themeTextView.setText(ExtKt.c("本章评论"));
            }
            DialogCommentFragmentBinding dialogCommentFragmentBinding4 = this.binding;
            ThemeTextView themeTextView2 = dialogCommentFragmentBinding4 != null ? dialogCommentFragmentBinding4.chapterCommentDesc : null;
            if (themeTextView2 != null) {
                themeTextView2.setText(ExtKt.c("全部章评"));
            }
            DialogCommentFragmentBinding dialogCommentFragmentBinding5 = this.binding;
            ThemeTextView themeTextView3 = dialogCommentFragmentBinding5 != null ? dialogCommentFragmentBinding5.chapterCommentPostHint : null;
            if (themeTextView3 != null) {
                themeTextView3.setText(ExtKt.c("加入本章讨论…"));
            }
            DialogCommentFragmentBinding dialogCommentFragmentBinding6 = this.binding;
            ThemeTextView themeTextView4 = dialogCommentFragmentBinding6 != null ? dialogCommentFragmentBinding6.chapterCommentNumber : null;
            if (themeTextView4 != null) {
                StringBuilder sb2 = new StringBuilder("(");
                CommentCount commentCount = p0().getCommentCount();
                sb2.append(commentCount != null ? Integer.valueOf(commentCount.getNComments()) : null);
                sb2.append("条)");
                themeTextView4.setText(sb2);
            }
            CommentCount commentCount2 = p0().getCommentCount();
            if (commentCount2 != null && commentCount2.getNComments() == 0 && (dialogCommentFragmentBinding2 = this.binding) != null && (themeLinearLayout2 = dialogCommentFragmentBinding2.chapterCommentPostView) != null) {
                themeLinearLayout2.performClick();
            }
        } else if (commentType == ReaderCommentViewModel.CommentType.TYPE_PARAGRAPH) {
            DialogCommentFragmentBinding dialogCommentFragmentBinding7 = this.binding;
            ThemeTextView themeTextView5 = dialogCommentFragmentBinding7 != null ? dialogCommentFragmentBinding7.tvTitle : null;
            if (themeTextView5 != null) {
                themeTextView5.setText(ExtKt.c("段评"));
            }
            DialogCommentFragmentBinding dialogCommentFragmentBinding8 = this.binding;
            ThemeTextView themeTextView6 = dialogCommentFragmentBinding8 != null ? dialogCommentFragmentBinding8.chapterCommentDesc : null;
            if (themeTextView6 != null) {
                themeTextView6.setText(ExtKt.c("全部段评"));
            }
            DialogCommentFragmentBinding dialogCommentFragmentBinding9 = this.binding;
            ThemeTextView themeTextView7 = dialogCommentFragmentBinding9 != null ? dialogCommentFragmentBinding9.chapterCommentPostHint : null;
            if (themeTextView7 != null) {
                themeTextView7.setText(ExtKt.c("段评千万条，友善第一条"));
            }
            DialogCommentFragmentBinding dialogCommentFragmentBinding10 = this.binding;
            ThemeTextView themeTextView8 = dialogCommentFragmentBinding10 != null ? dialogCommentFragmentBinding10.chapterCommentNumber : null;
            if (themeTextView8 != null) {
                StringBuilder sb3 = new StringBuilder("(");
                CommentCount commentCount3 = p0().getCommentCount();
                sb3.append(commentCount3 != null ? Integer.valueOf(commentCount3.getNComments()) : null);
                sb3.append("条)");
                themeTextView8.setText(sb3);
            }
            CommentCount commentCount4 = p0().getCommentCount();
            if (commentCount4 != null && commentCount4.getNComments() == 0 && (dialogCommentFragmentBinding = this.binding) != null && (themeLinearLayout = dialogCommentFragmentBinding.chapterCommentPostView) != null) {
                themeLinearLayout.performClick();
            }
        } else {
            DialogCommentFragmentBinding dialogCommentFragmentBinding11 = this.binding;
            ThemeLinearLayout themeLinearLayout3 = dialogCommentFragmentBinding11 != null ? dialogCommentFragmentBinding11.bookCommentView : null;
            if (themeLinearLayout3 != null) {
                themeLinearLayout3.setVisibility(0);
            }
            DialogCommentFragmentBinding dialogCommentFragmentBinding12 = this.binding;
            ThemeTextView themeTextView9 = dialogCommentFragmentBinding12 != null ? dialogCommentFragmentBinding12.tvTitle : null;
            if (themeTextView9 != null) {
                themeTextView9.setText(ExtKt.c("全部书评"));
            }
            DialogCommentFragmentBinding dialogCommentFragmentBinding13 = this.binding;
            ThemeTextView themeTextView10 = dialogCommentFragmentBinding13 != null ? dialogCommentFragmentBinding13.chapterCommentDesc : null;
            if (themeTextView10 != null) {
                themeTextView10.setText(ExtKt.c("评论"));
            }
            DialogCommentFragmentBinding dialogCommentFragmentBinding14 = this.binding;
            ThemeTextView themeTextView11 = dialogCommentFragmentBinding14 != null ? dialogCommentFragmentBinding14.chapterCommentPostHint : null;
            if (themeTextView11 != null) {
                themeTextView11.setText(ExtKt.c("写下对本书的评价…"));
            }
            p0().r(p0().getSourceName(), p0().getSourceId());
        }
        DialogCommentFragmentBinding dialogCommentFragmentBinding15 = this.binding;
        RecyclerView recyclerView = dialogCommentFragmentBinding15 != null ? dialogCommentFragmentBinding15.rvComment : null;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        L0(0);
    }

    private final void r0() {
        MutableLiveData<Unit> h02;
        MutableLiveData<Pair<String, Integer>> g02;
        ThemeLinearLayout themeLinearLayout;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        ImageView imageView5;
        LoadingTip loadingTip;
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        ThemeImageView themeImageView;
        DialogCommentFragmentBinding dialogCommentFragmentBinding = this.binding;
        if (dialogCommentFragmentBinding != null && (themeImageView = dialogCommentFragmentBinding.ivClose) != null) {
            themeImageView.setOnClickListener(new View.OnClickListener() { // from class: eb.a
                public /* synthetic */ a() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommentFragment.s0(CommentFragment.this, view);
                }
            });
        }
        DialogCommentFragmentBinding dialogCommentFragmentBinding2 = this.binding;
        if (dialogCommentFragmentBinding2 != null && (smartRefreshLayout3 = dialogCommentFragmentBinding2.refreshLayout) != null) {
            smartRefreshLayout3.j0(false);
        }
        DialogCommentFragmentBinding dialogCommentFragmentBinding3 = this.binding;
        if (dialogCommentFragmentBinding3 != null && (smartRefreshLayout2 = dialogCommentFragmentBinding3.refreshLayout) != null) {
            smartRefreshLayout2.U(new MiClassicsFooter(getContext(), 3, false, 4, null));
        }
        DialogCommentFragmentBinding dialogCommentFragmentBinding4 = this.binding;
        if (dialogCommentFragmentBinding4 != null && (smartRefreshLayout = dialogCommentFragmentBinding4.refreshLayout) != null) {
            smartRefreshLayout.f0(new sf.e() { // from class: eb.n
                public /* synthetic */ n() {
                }

                @Override // sf.e
                public final void p(pf.f fVar) {
                    CommentFragment.A0(CommentFragment.this, fVar);
                }
            });
        }
        DialogCommentFragmentBinding dialogCommentFragmentBinding5 = this.binding;
        if (dialogCommentFragmentBinding5 != null && (loadingTip = dialogCommentFragmentBinding5.commentLoadingTip) != null) {
            loadingTip.setOnReloadListener(new Function0<Unit>() { // from class: com.martian.mibook.fragment.dialog.CommentFragment$initListener$3
                public CommentFragment$initListener$3() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke */
                public final void invoke2() {
                    ac.a.A(CommentFragment.this.getContext(), "重新加载");
                    CommentFragment.this.n0(false, true);
                }
            });
        }
        p0().h().observe(this, new Observer() { // from class: eb.o
            public /* synthetic */ o() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CommentFragment.B0(Function1.this, obj);
            }
        });
        p0().z().observe(this, new Observer() { // from class: eb.p
            public /* synthetic */ p() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CommentFragment.C0(Function1.this, obj);
            }
        });
        p0().x().observe(this, new Observer() { // from class: eb.b
            public /* synthetic */ b() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CommentFragment.D0(Function1.this, obj);
            }
        });
        p0().y().observe(this, new Observer() { // from class: eb.c
            public /* synthetic */ c() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CommentFragment.E0(Function1.this, obj);
            }
        });
        p0().w().observe(this, new Observer() { // from class: eb.d
            public /* synthetic */ d() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CommentFragment.F0(Function1.this, obj);
            }
        });
        p0().B().observe(this, new Observer() { // from class: eb.e
            public /* synthetic */ e() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CommentFragment.G0(Function1.this, obj);
            }
        });
        DialogCommentFragmentBinding dialogCommentFragmentBinding6 = this.binding;
        if (dialogCommentFragmentBinding6 != null && (imageView5 = dialogCommentFragmentBinding6.bookCommentVote1) != null) {
            imageView5.setOnClickListener(new View.OnClickListener() { // from class: eb.f
                public /* synthetic */ f() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommentFragment.H0(CommentFragment.this, view);
                }
            });
        }
        DialogCommentFragmentBinding dialogCommentFragmentBinding7 = this.binding;
        if (dialogCommentFragmentBinding7 != null && (imageView4 = dialogCommentFragmentBinding7.bookCommentVote2) != null) {
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: eb.g
                public /* synthetic */ g() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommentFragment.t0(CommentFragment.this, view);
                }
            });
        }
        DialogCommentFragmentBinding dialogCommentFragmentBinding8 = this.binding;
        if (dialogCommentFragmentBinding8 != null && (imageView3 = dialogCommentFragmentBinding8.bookCommentVote3) != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: eb.h
                public /* synthetic */ h() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommentFragment.u0(CommentFragment.this, view);
                }
            });
        }
        DialogCommentFragmentBinding dialogCommentFragmentBinding9 = this.binding;
        if (dialogCommentFragmentBinding9 != null && (imageView2 = dialogCommentFragmentBinding9.bookCommentVote4) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: eb.i
                public /* synthetic */ i() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommentFragment.v0(CommentFragment.this, view);
                }
            });
        }
        DialogCommentFragmentBinding dialogCommentFragmentBinding10 = this.binding;
        if (dialogCommentFragmentBinding10 != null && (imageView = dialogCommentFragmentBinding10.bookCommentVote5) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: eb.j
                public /* synthetic */ j() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommentFragment.w0(CommentFragment.this, view);
                }
            });
        }
        DialogCommentFragmentBinding dialogCommentFragmentBinding11 = this.binding;
        if (dialogCommentFragmentBinding11 != null && (themeLinearLayout = dialogCommentFragmentBinding11.chapterCommentPostView) != null) {
            themeLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: eb.k
                public /* synthetic */ k() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommentFragment.x0(CommentFragment.this, view);
                }
            });
        }
        AppViewModel m02 = m0();
        if (m02 != null && (g02 = m02.g0()) != null) {
            g02.observe(this, new Observer() { // from class: eb.l
                public /* synthetic */ l() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    CommentFragment.y0(Function1.this, obj);
                }
            });
        }
        AppViewModel m03 = m0();
        if (m03 == null || (h02 = m03.h0()) == null) {
            return;
        }
        h02.observe(this, new Observer() { // from class: eb.m
            public /* synthetic */ m() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CommentFragment.z0(Function1.this, obj);
            }
        });
    }

    public static final void s0(CommentFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void t0(CommentFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.U0(40);
    }

    public static final void u0(CommentFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.U0(60);
    }

    public static final void v0(CommentFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.U0(80);
    }

    public static final void w0(CommentFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.U0(100);
    }

    public static final void x0(CommentFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.bookCommentType == ReaderCommentViewModel.CommentType.TYPE_BOOK_COMMENT) {
            this$0.U0(100);
        } else {
            this$0.T0();
        }
    }

    public static final void y0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void z0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void I0() {
        MagicIndicator magicIndicator;
        MagicIndicator magicIndicator2;
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        commonNavigator.setAdjustMode(true);
        commonNavigator.setMarginHorizontal(0);
        m9.d dVar = new m9.d();
        commonNavigator.setAdapter(new b(dVar, this));
        int i10 = ConfigSingleton.D().A0() ? R.drawable.border_search_background_night : R.drawable.border_search_background_day;
        DialogCommentFragmentBinding dialogCommentFragmentBinding = this.binding;
        if (dialogCommentFragmentBinding != null && (magicIndicator2 = dialogCommentFragmentBinding.magicIndicatorComment) != null) {
            magicIndicator2.setBackgroundResource(i10);
        }
        DialogCommentFragmentBinding dialogCommentFragmentBinding2 = this.binding;
        if (dialogCommentFragmentBinding2 != null && (magicIndicator = dialogCommentFragmentBinding2.magicIndicatorComment) != null) {
            magicIndicator.setNavigator(commonNavigator);
        }
        DialogCommentFragmentBinding dialogCommentFragmentBinding3 = this.binding;
        dVar.d(dialogCommentFragmentBinding3 != null ? dialogCommentFragmentBinding3.magicIndicatorComment : null);
        dVar.j(this.commentType, false);
    }

    public final void J0(LoadingTip loadingTip, ErrorResult errorResult) {
        if (errorResult == null) {
            return;
        }
        if (errorResult.getErrorCode() == -100002) {
            if (loadingTip != null) {
                loadingTip.setLoadingTip(LoadingTip.LoadStatus.network_error);
            }
        } else if (loadingTip != null) {
            loadingTip.setLoadingTip(LoadingTip.LoadStatus.serverError);
        }
        if (ba.l.q(errorResult.getErrorMsg()) || errorResult.getErrorMsg().length() >= 20 || loadingTip == null) {
            return;
        }
        loadingTip.setTips(ExtKt.c(errorResult.getErrorMsg()));
    }

    public final void L0(int index) {
        this.commentType = index;
        o0(this, false, false, 2, null);
    }

    public final void O0(List<Comment> commentList) {
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        LoadingTip loadingTip;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        CommentAdapter commentAdapter;
        RecyclerView recyclerView3;
        SmartRefreshLayout smartRefreshLayout3;
        l0();
        List<Comment> list = commentList;
        if (list == null || list.isEmpty()) {
            int i10 = this.commentType;
            if ((i10 == 0 && this.pageIndex == 0) || (i10 == 1 && this.lastCreatedOn == null)) {
                DialogCommentFragmentBinding dialogCommentFragmentBinding = this.binding;
                smartRefreshLayout = dialogCommentFragmentBinding != null ? dialogCommentFragmentBinding.refreshLayout : null;
                if (smartRefreshLayout != null) {
                    smartRefreshLayout.setVisibility(8);
                }
                DialogCommentFragmentBinding dialogCommentFragmentBinding2 = this.binding;
                if (dialogCommentFragmentBinding2 == null || (loadingTip = dialogCommentFragmentBinding2.commentLoadingTip) == null) {
                    return;
                }
                loadingTip.setLoadingTip(LoadingTip.LoadStatus.empty);
                return;
            }
            DialogCommentFragmentBinding dialogCommentFragmentBinding3 = this.binding;
            smartRefreshLayout = dialogCommentFragmentBinding3 != null ? dialogCommentFragmentBinding3.refreshLayout : null;
            if (smartRefreshLayout != null) {
                smartRefreshLayout.setVisibility(0);
            }
            DialogCommentFragmentBinding dialogCommentFragmentBinding4 = this.binding;
            if (dialogCommentFragmentBinding4 == null || (smartRefreshLayout2 = dialogCommentFragmentBinding4.refreshLayout) == null) {
                return;
            }
            smartRefreshLayout2.e0();
            return;
        }
        DialogCommentFragmentBinding dialogCommentFragmentBinding5 = this.binding;
        smartRefreshLayout = dialogCommentFragmentBinding5 != null ? dialogCommentFragmentBinding5.refreshLayout : null;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.setVisibility(0);
        }
        DialogCommentFragmentBinding dialogCommentFragmentBinding6 = this.binding;
        if (dialogCommentFragmentBinding6 != null && (smartRefreshLayout3 = dialogCommentFragmentBinding6.refreshLayout) != null) {
            smartRefreshLayout3.N(true);
        }
        int i11 = this.commentType;
        if (i11 == 0 && this.pageIndex == 0 && (commentAdapter = this.commentAdapter) != null) {
            if (commentAdapter != null) {
                commentAdapter.I(commentList);
            }
            DialogCommentFragmentBinding dialogCommentFragmentBinding7 = this.binding;
            if (dialogCommentFragmentBinding7 == null || (recyclerView3 = dialogCommentFragmentBinding7.rvComment) == null) {
                return;
            }
            recyclerView3.scrollToPosition(0);
            return;
        }
        if (i11 == 1 && this.lastCreatedOn == null && this.commentAdapter != null) {
            this.lastCreatedOn = ((Comment) CollectionsKt.last((List) commentList)).getCreatedOn();
            CommentAdapter commentAdapter2 = this.commentAdapter;
            if (commentAdapter2 != null) {
                commentAdapter2.I(commentList);
            }
            DialogCommentFragmentBinding dialogCommentFragmentBinding8 = this.binding;
            if (dialogCommentFragmentBinding8 == null || (recyclerView2 = dialogCommentFragmentBinding8.rvComment) == null) {
                return;
            }
            recyclerView2.scrollToPosition(0);
            return;
        }
        if (this.commentAdapter == null) {
            CommentAdapter commentAdapter3 = new CommentAdapter(p0(), this.bookCommentType);
            this.commentAdapter = commentAdapter3;
            DialogCommentFragmentBinding dialogCommentFragmentBinding9 = this.binding;
            if (dialogCommentFragmentBinding9 != null && (recyclerView = dialogCommentFragmentBinding9.rvComment) != null) {
                recyclerView.setAdapter(commentAdapter3);
            }
        }
        this.lastCreatedOn = ((Comment) CollectionsKt.last((List) commentList)).getCreatedOn();
        CommentAdapter commentAdapter4 = this.commentAdapter;
        if (commentAdapter4 != null) {
            commentAdapter4.n(commentList);
        }
    }

    public final void P0(@l e2.d listener) {
        this.listener = listener;
    }

    public final void T0() {
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            if (activity == null || !activity.isFinishing()) {
                PostOrReplyCommentFragment.X(getActivity(), p0().getCommentCount(), p0().getSourceName(), p0().getSourceId(), this.commentString, p0().getParagraphContent(), p0().getSelectParagraphText(), true, new c());
            }
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void V0() {
        ThemeTextView themeTextView;
        Integer nStars;
        ThemeTextView themeTextView2;
        Float score;
        int i10 = 0;
        BookInfo mBookInfo = p0().getMBookInfo();
        float floatValue = (mBookInfo == null || (score = mBookInfo.getScore()) == null) ? 0.0f : score.floatValue();
        if (floatValue > 0.0f) {
            DialogCommentFragmentBinding dialogCommentFragmentBinding = this.binding;
            if (dialogCommentFragmentBinding != null && (themeTextView2 = dialogCommentFragmentBinding.bookVoteScore) != null) {
                themeTextView2.setTextSize(2, 24.0f);
            }
            float f10 = floatValue / 10.0f;
            DialogCommentFragmentBinding dialogCommentFragmentBinding2 = this.binding;
            ThemeTextView themeTextView3 = dialogCommentFragmentBinding2 != null ? dialogCommentFragmentBinding2.bookVoteScore : null;
            if (themeTextView3 != null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(f10)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                themeTextView3.setText(format);
            }
            DialogCommentFragmentBinding dialogCommentFragmentBinding3 = this.binding;
            ThemeTextView themeTextView4 = dialogCommentFragmentBinding3 != null ? dialogCommentFragmentBinding3.bookVoteScoreHint : null;
            if (themeTextView4 != null) {
                themeTextView4.setVisibility(0);
            }
        } else {
            DialogCommentFragmentBinding dialogCommentFragmentBinding4 = this.binding;
            if (dialogCommentFragmentBinding4 != null && (themeTextView = dialogCommentFragmentBinding4.bookVoteScore) != null) {
                themeTextView.setTextSize(2, 18.0f);
            }
            DialogCommentFragmentBinding dialogCommentFragmentBinding5 = this.binding;
            ThemeTextView themeTextView5 = dialogCommentFragmentBinding5 != null ? dialogCommentFragmentBinding5.bookVoteScore : null;
            if (themeTextView5 != null) {
                Context context = getContext();
                themeTextView5.setText(context != null ? context.getString(com.martian.mibook.R.string.empty_grade) : null);
            }
            DialogCommentFragmentBinding dialogCommentFragmentBinding6 = this.binding;
            ThemeTextView themeTextView6 = dialogCommentFragmentBinding6 != null ? dialogCommentFragmentBinding6.bookVoteScoreHint : null;
            if (themeTextView6 != null) {
                themeTextView6.setVisibility(8);
            }
        }
        BookInfo mBookInfo2 = p0().getMBookInfo();
        int intValue = (mBookInfo2 == null || (nStars = mBookInfo2.getNStars()) == null) ? 0 : nStars.intValue();
        DialogCommentFragmentBinding dialogCommentFragmentBinding7 = this.binding;
        ThemeTextView themeTextView7 = dialogCommentFragmentBinding7 != null ? dialogCommentFragmentBinding7.bookCommentScoreTips : null;
        if (themeTextView7 != null) {
            themeTextView7.setText(intValue > 0 ? "评分" : "快来评分吧");
        }
        BookInfo mBookInfo3 = p0().getMBookInfo();
        Comment myComment = mBookInfo3 != null ? mBookInfo3.getMyComment() : null;
        if (myComment != null) {
            i10 = myComment.getScore();
            DialogCommentFragmentBinding dialogCommentFragmentBinding8 = this.binding;
            ThemeTextView themeTextView8 = dialogCommentFragmentBinding8 != null ? dialogCommentFragmentBinding8.bookCommentStatus : null;
            if (themeTextView8 != null) {
                Context context2 = getContext();
                String string = context2 != null ? context2.getString(com.martian.mibook.R.string.mine) : null;
                Context context3 = getContext();
                themeTextView8.setText(string + (context3 != null ? context3.getString(com.martian.mibook.R.string.grade) : null));
            }
        } else {
            DialogCommentFragmentBinding dialogCommentFragmentBinding9 = this.binding;
            ThemeTextView themeTextView9 = dialogCommentFragmentBinding9 != null ? dialogCommentFragmentBinding9.bookCommentStatus : null;
            if (themeTextView9 != null) {
                Context context4 = getContext();
                themeTextView9.setText(context4 != null ? context4.getString(com.martian.mibook.R.string.touch_to_comment) : null);
            }
        }
        W0(i10);
    }

    public final void n0(boolean isLoadMore, boolean showLoading) {
        LoadingTip loadingTip;
        ReaderCommentViewModel.CommentType commentType = this.bookCommentType;
        if (commentType == ReaderCommentViewModel.CommentType.TYPE_CHAPTER || commentType == ReaderCommentViewModel.CommentType.TYPE_PARAGRAPH) {
            if (p0().getCommentCount() == null) {
                return;
            }
            CommentCount commentCount = p0().getCommentCount();
            if (commentCount != null && commentCount.getNComments() == 0) {
                DialogCommentFragmentBinding dialogCommentFragmentBinding = this.binding;
                SmartRefreshLayout smartRefreshLayout = dialogCommentFragmentBinding != null ? dialogCommentFragmentBinding.refreshLayout : null;
                if (smartRefreshLayout != null) {
                    smartRefreshLayout.setVisibility(8);
                }
                DialogCommentFragmentBinding dialogCommentFragmentBinding2 = this.binding;
                if (dialogCommentFragmentBinding2 == null || (loadingTip = dialogCommentFragmentBinding2.commentLoadingTip) == null) {
                    return;
                }
                loadingTip.setLoadingTip(LoadingTip.LoadStatus.empty);
                return;
            }
        }
        if (this.commentType == 0) {
            if (!isLoadMore) {
                this.pageIndex = 0;
            }
            GetCommentByScoreParams getCommentByScoreParams = new GetCommentByScoreParams(null, null, null, null, null, null, 0, 127, null);
            CommentCount commentCount2 = p0().getCommentCount();
            getCommentByScoreParams.setType(commentCount2 != null ? Integer.valueOf(commentCount2.getType()) : null);
            getCommentByScoreParams.setSourceName(p0().getSourceName());
            getCommentByScoreParams.setSourceId(p0().getSourceId());
            getCommentByScoreParams.setPage(Integer.valueOf(this.pageIndex));
            CommentCount commentCount3 = p0().getCommentCount();
            getCommentByScoreParams.setChapterId(commentCount3 != null ? commentCount3.getChapterId() : null);
            CommentCount commentCount4 = p0().getCommentCount();
            getCommentByScoreParams.setParagraphIdx(commentCount4 != null ? commentCount4.getParagraphIdx() : null);
            p0().u(getCommentByScoreParams, isLoadMore, showLoading);
            return;
        }
        if (!isLoadMore) {
            this.lastCreatedOn = null;
        }
        GetCommentByTimeParams getCommentByTimeParams = new GetCommentByTimeParams(null, null, null, null, null, null, 0, 127, null);
        CommentCount commentCount5 = p0().getCommentCount();
        getCommentByTimeParams.setType(commentCount5 != null ? Integer.valueOf(commentCount5.getType()) : null);
        getCommentByTimeParams.setSourceName(p0().getSourceName());
        getCommentByTimeParams.setSourceId(p0().getSourceId());
        CommentCount commentCount6 = p0().getCommentCount();
        getCommentByTimeParams.setChapterId(commentCount6 != null ? commentCount6.getChapterId() : null);
        CommentCount commentCount7 = p0().getCommentCount();
        getCommentByTimeParams.setParagraphIdx(commentCount7 != null ? commentCount7.getParagraphIdx() : null);
        getCommentByTimeParams.setLastCreatedOn(this.lastCreatedOn);
        p0().q(getCommentByTimeParams, isLoadMore, showLoading);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b0, code lost:
    
        if (android.text.TextUtils.isEmpty(r5 != null ? r5.getBookName() : null) != false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0106, code lost:
    
        if (r5 == null) goto L86;
     */
    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(@xi.l android.os.Bundle r5) {
        /*
            r4 = this;
            super.onCreate(r5)
            android.os.Bundle r5 = r4.getArguments()
            if (r5 == 0) goto L10c
            java.lang.String r0 = "INTENT_COMMENT_COUNT"
            java.lang.String r0 = r5.getString(r0)
            boolean r1 = ba.l.q(r0)
            if (r1 != 0) goto L28
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel r1 = r4.p0()
            com.google.gson.Gson r2 = com.martian.libcomm.utils.GsonUtils.b()
            java.lang.Class<com.martian.mibook.data.book.CommentCount> r3 = com.martian.mibook.data.book.CommentCount.class
            java.lang.Object r0 = r2.fromJson(r0, r3)
            com.martian.mibook.data.book.CommentCount r0 = (com.martian.mibook.data.book.CommentCount) r0
            r1.H(r0)
        L28:
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel r0 = r4.p0()
            java.lang.String r1 = "INTENT_SOURCE_NAME"
            java.lang.String r1 = r5.getString(r1)
            r0.N(r1)
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel r0 = r4.p0()
            java.lang.String r1 = "INTENT_SOURCE_ID"
            java.lang.String r1 = r5.getString(r1)
            r0.M(r1)
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel r0 = r4.p0()
            java.lang.String r1 = "INTENT_PARAGRAPH_CONTENT"
            java.lang.String r1 = r5.getString(r1)
            r0.K(r1)
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel r0 = r4.p0()
            java.lang.String r1 = "INTENT_SELECT_PARAGRAPH_TEXT"
            java.lang.String r1 = r5.getString(r1)
            r0.L(r1)
            java.lang.String r0 = "INTENT_COMMENT_BOOK_INFO"
            java.lang.String r5 = r5.getString(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto Lf1
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel r0 = r4.p0()
            com.google.gson.Gson r1 = com.martian.libcomm.utils.GsonUtils.b()
            java.lang.Class<com.martian.mibook.mvvm.book.viewmodel.BookInfo> r2 = com.martian.mibook.mvvm.book.viewmodel.BookInfo.class
            java.lang.Object r5 = r1.fromJson(r5, r2)
            com.martian.mibook.mvvm.book.viewmodel.BookInfo r5 = (com.martian.mibook.mvvm.book.viewmodel.BookInfo) r5
            r0.J(r5)
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel r5 = r4.p0()
            com.martian.mibook.mvvm.book.viewmodel.BookInfo r5 = r5.getMBookInfo()
            if (r5 == 0) goto Le0
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel r5 = r4.p0()
            com.martian.mibook.mvvm.book.viewmodel.BookInfo r5 = r5.getMBookInfo()
            r0 = 0
            if (r5 == 0) goto L95
            java.lang.String r5 = r5.getAuthorName()
            goto L96
        L95:
            r5 = r0
        L96:
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto Lb3
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel r5 = r4.p0()
            com.martian.mibook.mvvm.book.viewmodel.BookInfo r5 = r5.getMBookInfo()
            if (r5 == 0) goto Lab
            java.lang.String r5 = r5.getBookName()
            goto Lac
        Lab:
            r5 = r0
        Lac:
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto Lb3
            goto Le0
        Lb3:
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel r5 = r4.p0()
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel r1 = r4.p0()
            com.martian.mibook.mvvm.book.viewmodel.BookInfo r1 = r1.getMBookInfo()
            if (r1 == 0) goto Lc6
            java.lang.String r1 = r1.getSourceName()
            goto Lc7
        Lc6:
            r1 = r0
        Lc7:
            r5.N(r1)
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel r5 = r4.p0()
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel r1 = r4.p0()
            com.martian.mibook.mvvm.book.viewmodel.BookInfo r1 = r1.getMBookInfo()
            if (r1 == 0) goto Ldc
            java.lang.String r0 = r1.getSourceId()
        Ldc:
            r5.M(r0)
            goto Lf1
        Le0:
            android.content.Context r5 = r4.getContext()
            java.lang.String r0 = "获取信息失败"
            java.lang.String r0 = com.martian.mibook.mvvm.extensions.ExtKt.c(r0)
            l9.t0.b(r5, r0)
            r4.dismiss()
            return
        Lf1:
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel r5 = r4.p0()
            com.martian.mibook.data.book.CommentCount r5 = r5.getCommentCount()
            if (r5 == 0) goto L108
            boolean r5 = r5.isParagraphComment()
            if (r5 == 0) goto L104
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel$CommentType r5 = com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel.CommentType.TYPE_PARAGRAPH
            goto L106
        L104:
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel$CommentType r5 = com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel.CommentType.TYPE_CHAPTER
        L106:
            if (r5 != 0) goto L10a
        L108:
            com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel$CommentType r5 = com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel.CommentType.TYPE_BOOK_COMMENT
        L10a:
            r4.bookCommentType = r5
        L10c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.fragment.dialog.CommentFragment.onCreate(android.os.Bundle):void");
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment
    @l
    @SuppressLint({"InflateParams"})
    public View p(@k View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View inflate = LayoutInflater.from(getContext()).inflate(com.martian.mibook.R.layout.dialog_comment_fragment, (ViewGroup) null);
        this.binding = DialogCommentFragmentBinding.bind(inflate);
        return inflate;
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment
    public void r(@k View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.r(view);
        r0();
        I0();
        q0();
    }
}
