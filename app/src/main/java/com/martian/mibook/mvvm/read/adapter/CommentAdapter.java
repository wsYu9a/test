package com.martian.mibook.mvvm.read.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelKt;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.internal.bm;
import com.kuaishou.weapon.p0.t;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.ui.theme.ThemeGradientExpandableTextView;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.book.VoteResult;
import com.martian.mibook.databinding.ItemBookCommentBinding;
import com.martian.mibook.databinding.ItemBookCommentReplyBinding;
import com.martian.mibook.fragment.dialog.CommentLongClickDialog;
import com.martian.mibook.fragment.dialog.PostOrReplyCommentFragment;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.read.adapter.BaseCommentAdapter;
import com.martian.mibook.mvvm.read.adapter.CommentAdapter;
import com.martian.mibook.mvvm.read.comment.Comment;
import com.martian.mibook.mvvm.read.comment.CommentReply;
import com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.martian.mibook.mvvm.utils.coroutine.Coroutine;
import com.martian.mibook.mvvm.widget.ExpLevelLabel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import je.i;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Dispatchers;
import l9.m0;
import l9.o0;
import l9.p0;
import l9.t0;
import lc.b;
import oe.f;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 Q2\u00020\u0001:\u0003RSTB\u001d\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u001a\u001a\u00060\u0019R\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ)\u0010\"\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0004\b\"\u0010#JA\u0010-\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u000bH\u0002¢\u0006\u0004\b-\u0010.J)\u00104\u001a\u00020\b2\u0006\u00100\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u0001012\u0006\u00103\u001a\u00020\u000bH\u0002¢\u0006\u0004\b4\u00105JO\u0010:\u001a\u00020\b2\u0006\u00100\u001a\u00020/2\b\u00106\u001a\u0004\u0018\u00010\u000b2\b\u00107\u001a\u0004\u0018\u00010\u000b2\b\u00108\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u00103\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0002¢\u0006\u0004\b:\u0010;J)\u0010<\u001a\u00020\b2\u0006\u00100\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u0001012\u0006\u00103\u001a\u00020\u000bH\u0002¢\u0006\u0004\b<\u00105R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u0016\u0010\u0011\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\"\u0010J\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u001d\u0010P\u001a\u0004\u0018\u00010K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O¨\u0006U"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/CommentAdapter;", "Lcom/martian/mibook/mvvm/read/adapter/BaseCommentAdapter;", "Lcom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel;", "mViewModel", "Lcom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel$CommentType;", "bookCommentType", "<init>", "(Lcom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel;Lcom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel$CommentType;)V", "", "f0", "()V", "", id.c.f26972i, "", bm.f6904i, "b0", "(ILjava/lang/Object;)V", "gradientBackgroundColorType", "l0", "(I)V", "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "Lcom/martian/mibook/mvvm/read/adapter/BaseCommentAdapter$BaseCommentViewHolder;", "G", "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/read/adapter/BaseCommentAdapter$BaseCommentViewHolder;", "Lcom/martian/libmars/ui/theme/ThemeGradientExpandableTextView;", "tvReaderComment", "Landroid/widget/TextView;", "tvReaderCommentMore", "", "content", "h0", "(Lcom/martian/libmars/ui/theme/ThemeGradientExpandableTextView;Landroid/widget/TextView;Ljava/lang/String;)V", "tvCommentTime", "Landroid/widget/ImageView;", "ivVoteUpCount", "tvVoteUpCount", "", "createdOn", "", "hasUp", "upCount", "k0", "(Landroid/widget/TextView;Landroid/widget/ImageView;Landroid/widget/TextView;Ljava/lang/Long;ZI)V", "Lcom/martian/mibook/mvvm/read/comment/Comment;", "comment", "Lcom/martian/mibook/mvvm/read/comment/CommentReply;", "commentReply", "commentLayoutPosition", "g0", "(Lcom/martian/mibook/mvvm/read/comment/Comment;Lcom/martian/mibook/mvvm/read/comment/CommentReply;I)V", "cid", "rid", "nickname", "commentReplyIndex", "n0", "(Lcom/martian/mibook/mvvm/read/comment/Comment;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;II)V", "m0", "j", "Lcom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel;", "e0", "()Lcom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel;", "k", "Lcom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel$CommentType;", "d0", "()Lcom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel$CommentType;", t.f11204d, "I", "", "m", "Ljava/util/Map;", "replyContentMap", "Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", "n", "Lkotlin/Lazy;", "c0", "()Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", "appViewModel", "o", "CommentReplyViewHolder", "CommentViewHolder", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class CommentAdapter extends BaseCommentAdapter {

    /* renamed from: p */
    public static final int f14420p = 0;

    /* renamed from: q */
    public static final int f14421q = 1;

    /* renamed from: j, reason: from kotlin metadata */
    @l
    public final ReaderCommentViewModel mViewModel;

    /* renamed from: k, reason: from kotlin metadata */
    @l
    public final ReaderCommentViewModel.CommentType bookCommentType;

    /* renamed from: l */
    public int gradientBackgroundColorType;

    /* renamed from: m, reason: from kotlin metadata */
    @k
    public Map<String, String> replyContentMap;

    /* renamed from: n, reason: from kotlin metadata */
    @k
    public final Lazy appViewModel;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0017¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/CommentAdapter$CommentReplyViewHolder;", "Lcom/martian/mibook/mvvm/read/adapter/BaseCommentAdapter$BaseCommentViewHolder;", "Lcom/martian/mibook/mvvm/read/adapter/BaseCommentAdapter;", "Lcom/martian/mibook/databinding/ItemBookCommentReplyBinding;", "viewBinding", "<init>", "(Lcom/martian/mibook/mvvm/read/adapter/CommentAdapter;Lcom/martian/mibook/databinding/ItemBookCommentReplyBinding;)V", "", bm.f6904i, "", "a", "(Ljava/lang/Object;)V", "", id.c.f26972i, "", "payloads", "o", "(ILjava/util/List;Ljava/lang/Object;)V", "Lcom/martian/mibook/mvvm/read/comment/CommentReply;", "commentReply", "", "isFold", "G", "(Lcom/martian/mibook/databinding/ItemBookCommentReplyBinding;Lcom/martian/mibook/mvvm/read/comment/CommentReply;Z)V", "g", "Lcom/martian/mibook/databinding/ItemBookCommentReplyBinding;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class CommentReplyViewHolder extends BaseCommentAdapter.BaseCommentViewHolder {

        /* renamed from: g, reason: from kotlin metadata */
        @k
        public final ItemBookCommentReplyBinding viewBinding;

        /* renamed from: h */
        public final /* synthetic */ CommentAdapter f14428h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CommentReplyViewHolder(@k CommentAdapter commentAdapter, ItemBookCommentReplyBinding viewBinding) {
            super(commentAdapter, viewBinding);
            Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
            this.f14428h = commentAdapter;
            this.viewBinding = viewBinding;
            viewBinding.ivUserHeader.setOnClickListener(new View.OnClickListener() { // from class: cd.q
                public /* synthetic */ q() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommentAdapter.CommentReplyViewHolder.z(CommentAdapter.CommentReplyViewHolder.this, view);
                }
            });
            viewBinding.llVoteView.setOnClickListener(new View.OnClickListener() { // from class: cd.r

                /* renamed from: c */
                public final /* synthetic */ CommentAdapter f1875c;

                public /* synthetic */ r(CommentAdapter commentAdapter2) {
                    commentAdapter = commentAdapter2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommentAdapter.CommentReplyViewHolder.A(CommentAdapter.CommentReplyViewHolder.this, commentAdapter, view);
                }
            });
            viewBinding.clCommentReply.setOnClickListener(new View.OnClickListener() { // from class: cd.s

                /* renamed from: c */
                public final /* synthetic */ CommentAdapter f1879c;

                public /* synthetic */ s(CommentAdapter commentAdapter2) {
                    commentAdapter = commentAdapter2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommentAdapter.CommentReplyViewHolder.B(CommentAdapter.CommentReplyViewHolder.this, commentAdapter, view);
                }
            });
            viewBinding.clCommentReply.setOnLongClickListener(new View.OnLongClickListener() { // from class: cd.t

                /* renamed from: c */
                public final /* synthetic */ CommentAdapter f1886c;

                public /* synthetic */ t(CommentAdapter commentAdapter2) {
                    commentAdapter = commentAdapter2;
                }

                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean C;
                    C = CommentAdapter.CommentReplyViewHolder.C(CommentAdapter.CommentReplyViewHolder.this, commentAdapter, view);
                    return C;
                }
            });
        }

        public static final void A(CommentReplyViewHolder this$0, CommentAdapter this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            CommentReply commentReply = (CommentReply) this$0.m();
            if (commentReply == null) {
                return;
            }
            int i10 = this$0.i();
            Comment comment = (Comment) this$0.getAdapter().x(i10);
            if (comment == null) {
                return;
            }
            this$1.g0(comment, commentReply, i10);
        }

        public static final void B(CommentReplyViewHolder this$0, CommentAdapter this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            CommentReply commentReply = (CommentReply) this$0.m();
            if (commentReply == null) {
                return;
            }
            int i10 = this$0.i();
            Comment comment = (Comment) this$0.getAdapter().x(i10);
            if (comment == null) {
                return;
            }
            this$1.n0(comment, comment.getCid(), commentReply.getRid(), commentReply.getNickname(), commentReply.getContent(), i10, commentReply.getIndex());
        }

        public static final boolean C(CommentReplyViewHolder this$0, CommentAdapter this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            int i10 = this$0.i();
            Comment comment = (Comment) this$0.getAdapter().x(i10);
            if (comment == null) {
                return false;
            }
            this$1.m0(comment, (CommentReply) this$0.m(), i10);
            return true;
        }

        public static final void D(CommentReplyViewHolder this$0, CommentReply commentReply, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(commentReply, "$commentReply");
            this$0.G(this$0.viewBinding, commentReply, true);
        }

        public static final void E(CommentReplyViewHolder this$0, CommentAdapter this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Comment comment = (Comment) this$1.x(this$0.i());
            if (comment == null) {
                return;
            }
            Context context = this$0.getCom.umeng.analytics.pro.f.X java.lang.String();
            i.J(context instanceof Activity ? (Activity) context : null, false, comment);
        }

        public static final void F(CommentReplyViewHolder this$0, CommentReply commentReply, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(commentReply, "$commentReply");
            H(this$0, this$0.viewBinding, commentReply, false, 4, null);
        }

        public static /* synthetic */ void H(CommentReplyViewHolder commentReplyViewHolder, ItemBookCommentReplyBinding itemBookCommentReplyBinding, CommentReply commentReply, boolean z10, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                z10 = false;
            }
            commentReplyViewHolder.G(itemBookCommentReplyBinding, commentReply, z10);
        }

        public static final void I(CommentAdapter this$0, int i10) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.notifyItemChanged(i10, 1);
        }

        public static final void z(CommentReplyViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            CommentReply commentReply = (CommentReply) this$0.m();
            if (commentReply == null) {
                return;
            }
            ac.a.A(this$0.getCom.umeng.analytics.pro.f.X java.lang.String(), "查看用户-头像");
            i.c0((Activity) this$0.getCom.umeng.analytics.pro.f.X java.lang.String(), 1, commentReply.getCuid());
        }

        public final void G(ItemBookCommentReplyBinding viewBinding, CommentReply commentReply, boolean isFold) {
            int i10 = i();
            Comment comment = (Comment) getAdapter().x(i10);
            if (comment == null) {
                return;
            }
            if (commentReply.isHasMore() && !isFold) {
                CommentReply commentReply2 = (CommentReply) CollectionsKt.last((List) comment.getCommentReplyList());
                commentReply2.setLoading(true);
                ReaderCommentViewModel mViewModel = this.f14428h.getMViewModel();
                if (mViewModel != null) {
                    CommentAdapter commentAdapter = this.f14428h;
                    Coroutine.onFinally$default(Coroutine.onStart$default(Coroutine.Companion.async$default(Coroutine.INSTANCE, ViewModelKt.getViewModelScope(mViewModel), null, null, null, new CommentAdapter$CommentReplyViewHolder$expandMoreOrCollapseReply$1$1(comment, commentAdapter, null), 14, null), null, new CommentAdapter$CommentReplyViewHolder$expandMoreOrCollapseReply$1$2(viewBinding, null), 1, null).onSuccess(Dispatchers.getMain(), new CommentAdapter$CommentReplyViewHolder$expandMoreOrCollapseReply$1$3(comment, commentAdapter, this, null)), null, new CommentAdapter$CommentReplyViewHolder$expandMoreOrCollapseReply$1$4(commentReply2, viewBinding, null), 1, null);
                    return;
                }
                return;
            }
            comment.setExpand(false);
            Set set = CollectionsKt.toSet(comment.getCommentReplyList());
            int i11 = i10 + 1;
            int size = set.size() + i11;
            if (i11 >= this.f14428h.B().size() || size > this.f14428h.B().size()) {
                p0.b("Invalid range: " + i11 + " to " + size);
                return;
            }
            this.f14428h.B().subList(i11, size).clear();
            comment.removeExpandCommentReplyList();
            this.f14428h.notifyItemRangeRemoved(i11, set.size());
            RecyclerView rv = this.f14428h.getRv();
            if (rv != null) {
                rv.postDelayed(new Runnable() { // from class: cd.p

                    /* renamed from: c */
                    public final /* synthetic */ int f1866c;

                    public /* synthetic */ p(int i102) {
                        i10 = i102;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        CommentAdapter.CommentReplyViewHolder.I(CommentAdapter.this, i10);
                    }
                }, 150L);
            }
        }

        @Override // com.martian.mibook.mvvm.read.adapter.BaseCommentAdapter.BaseCommentViewHolder
        @SuppressLint({"SetTextI18n"})
        public void a(@l Object r12) {
            CommentReply commentReply = r12 instanceof CommentReply ? (CommentReply) r12 : null;
            if (commentReply == null) {
                return;
            }
            if (commentReply.showExpand()) {
                boolean isHasMore = commentReply.isHasMore();
                this.viewBinding.llMoreReply.setVisibility(0);
                this.viewBinding.llFold.setVisibility((!isHasMore || commentReply.getIndex() <= 0) ? 8 : 0);
                this.viewBinding.llFold.setOnClickListener(new View.OnClickListener() { // from class: cd.m

                    /* renamed from: c */
                    public final /* synthetic */ CommentReply f1851c;

                    public /* synthetic */ m(CommentReply commentReply2) {
                        commentReply = commentReply2;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CommentAdapter.CommentReplyViewHolder.D(CommentAdapter.CommentReplyViewHolder.this, commentReply, view);
                    }
                });
                this.viewBinding.tvMoreReply.setText(commentReply2.getExpandDesc());
                if (commentReply2.showMoreReply()) {
                    this.viewBinding.ivMoreReply.setImageResource(R.drawable.icon_account_more);
                    this.viewBinding.llMoreReply.setOnClickListener(new View.OnClickListener() { // from class: cd.n

                        /* renamed from: c */
                        public final /* synthetic */ CommentAdapter f1856c;

                        public /* synthetic */ n(CommentAdapter commentAdapter) {
                            commentAdapter = commentAdapter;
                        }

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            CommentAdapter.CommentReplyViewHolder.E(CommentAdapter.CommentReplyViewHolder.this, commentAdapter, view);
                        }
                    });
                } else {
                    this.viewBinding.tvMoreReply.setText(commentReply2.getExpandDesc());
                    this.viewBinding.ivMoreReply.setImageResource(isHasMore ? R.drawable.icon_comment_expand_down : R.drawable.icon_comment_expand_up);
                    this.viewBinding.llMoreReply.setOnClickListener(new View.OnClickListener() { // from class: cd.o

                        /* renamed from: c */
                        public final /* synthetic */ CommentReply f1861c;

                        public /* synthetic */ o(CommentReply commentReply2) {
                            commentReply = commentReply2;
                        }

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            CommentAdapter.CommentReplyViewHolder.F(CommentAdapter.CommentReplyViewHolder.this, commentReply, view);
                        }
                    });
                }
            } else {
                this.viewBinding.llMoreReply.setVisibility(8);
                this.viewBinding.llFold.setVisibility(8);
            }
            m0.o(getCom.umeng.analytics.pro.f.X java.lang.String(), commentReply2.getHeader(), this.viewBinding.ivUserHeader, com.martian.mibook.lib.account.R.drawable.day_img_heads, MiConfigSingleton.b2().x1());
            this.viewBinding.tvNickname.setText(commentReply2.getNickname());
            this.viewBinding.ivVipTag.setVisibility(Intrinsics.areEqual(commentReply2.getVip(), Boolean.TRUE) ? 0 : 8);
            Integer expLevel = commentReply2.getExpLevel();
            if (expLevel != null) {
                if (expLevel.intValue() > 2) {
                    this.viewBinding.ivExpLevel.setVisibility(0);
                    ExpLevelLabel expLevelLabel = this.viewBinding.ivExpLevel;
                    Integer expLevel2 = commentReply2.getExpLevel();
                    Intrinsics.checkNotNull(expLevel2);
                    expLevelLabel.setLevel(expLevel2.intValue());
                } else {
                    this.viewBinding.ivExpLevel.setVisibility(8);
                }
            }
            if (StringsKt.equals(MiConfigSingleton.b2().T1(), commentReply2.getCuid(), true)) {
                this.viewBinding.tvTag.setVisibility(0);
                this.viewBinding.tvTag.setText(getCom.umeng.analytics.pro.f.X java.lang.String().getString(R.string.mine));
                this.viewBinding.tvTag.setBackgroundResource(com.martian.libmars.R.drawable.border_button_round_default);
            } else {
                this.viewBinding.tvTag.setVisibility(8);
            }
            if (commentReply2.getRefReply() != null) {
                ThemeTextView themeTextView = this.viewBinding.tvCommentReplyContent;
                CommentReply refReply = commentReply2.getRefReply();
                String nickname = refReply != null ? refReply.getNickname() : null;
                CommentReply refReply2 = commentReply2.getRefReply();
                themeTextView.setText("@" + nickname + "：" + (refReply2 != null ? refReply2.getContent() : null));
                this.viewBinding.llCommentReplyView.setVisibility(0);
            } else {
                this.viewBinding.llCommentReplyView.setVisibility(8);
            }
            CommentAdapter commentAdapter = this.f14428h;
            ThemeGradientExpandableTextView tvReaderComment = this.viewBinding.tvReaderComment;
            Intrinsics.checkNotNullExpressionValue(tvReaderComment, "tvReaderComment");
            ThemeTextView tvReaderCommentMore = this.viewBinding.tvReaderCommentMore;
            Intrinsics.checkNotNullExpressionValue(tvReaderCommentMore, "tvReaderCommentMore");
            commentAdapter.h0(tvReaderComment, tvReaderCommentMore, commentReply2.getContent());
            CommentAdapter commentAdapter2 = this.f14428h;
            ThemeTextView tvCommentTime = this.viewBinding.tvCommentTime;
            Intrinsics.checkNotNullExpressionValue(tvCommentTime, "tvCommentTime");
            ImageView ivVoteUpCount = this.viewBinding.ivVoteUpCount;
            Intrinsics.checkNotNullExpressionValue(ivVoteUpCount, "ivVoteUpCount");
            TextView tvVoteUpCount = this.viewBinding.tvVoteUpCount;
            Intrinsics.checkNotNullExpressionValue(tvVoteUpCount, "tvVoteUpCount");
            commentAdapter2.k0(tvCommentTime, ivVoteUpCount, tvVoteUpCount, commentReply2.getCreatedOn(), commentReply2.getHasUp(), commentReply2.getUpCount());
        }

        @Override // com.martian.mibook.mvvm.read.adapter.BaseCommentAdapter.BaseCommentViewHolder
        public void o(int r42, @k List<Object> payloads, @l Object r62) {
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            if ((!payloads.isEmpty()) && (r62 instanceof CommentReply)) {
                CommentReply commentReply = (CommentReply) r62;
                Long createdOn = commentReply.getCreatedOn();
                if (createdOn != null) {
                    this.viewBinding.tvCommentTime.setText(o0.F(createdOn.longValue()));
                }
                if (Intrinsics.areEqual(payloads.get(0), (Object) 1)) {
                    if (!commentReply.showExpand()) {
                        this.viewBinding.llMoreReply.setVisibility(8);
                        this.viewBinding.llFold.setVisibility(8);
                        return;
                    } else {
                        this.viewBinding.tvMoreReply.setText(commentReply.getExpandDesc());
                        this.viewBinding.llMoreReply.setVisibility(0);
                        this.viewBinding.llFold.setVisibility((!commentReply.isHasMore() || commentReply.getIndex() <= 0) ? 8 : 0);
                        return;
                    }
                }
                if (Intrinsics.areEqual(payloads.get(0), (Object) 2)) {
                    this.viewBinding.tvVoteUpCount.setText(commentReply.getUpCount() > 0 ? String.valueOf(commentReply.getUpCount()) : "");
                    if (commentReply.getHasUp()) {
                        this.viewBinding.ivVoteUpCount.setImageResource(R.drawable.vote_upcount_selected);
                        this.viewBinding.tvVoteUpCount.setTextColor(ContextCompat.getColor(getCom.umeng.analytics.pro.f.X java.lang.String(), com.martian.libmars.R.color.theme_default));
                    } else {
                        this.viewBinding.ivVoteUpCount.setImageResource(R.drawable.vote_upcount);
                        this.viewBinding.tvVoteUpCount.setTextColor(ConfigSingleton.D().j0());
                    }
                }
            }
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0017¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/CommentAdapter$CommentViewHolder;", "Lcom/martian/mibook/mvvm/read/adapter/BaseCommentAdapter$BaseCommentViewHolder;", "Lcom/martian/mibook/mvvm/read/adapter/BaseCommentAdapter;", "Lcom/martian/mibook/databinding/ItemBookCommentBinding;", "viewBinding", "<init>", "(Lcom/martian/mibook/mvvm/read/adapter/CommentAdapter;Lcom/martian/mibook/databinding/ItemBookCommentBinding;)V", "", bm.f6904i, "", "a", "(Ljava/lang/Object;)V", "", id.c.f26972i, "", "payloads", "o", "(ILjava/util/List;Ljava/lang/Object;)V", "Lcom/martian/mibook/mvvm/read/comment/Comment;", "comment", "B", "(Lcom/martian/mibook/mvvm/read/comment/Comment;)V", "g", "Lcom/martian/mibook/databinding/ItemBookCommentBinding;", "h", "I", "headerTopMargin", "i", "itemLeftRightPadding", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class CommentViewHolder extends BaseCommentAdapter.BaseCommentViewHolder {

        /* renamed from: g, reason: from kotlin metadata */
        @k
        public final ItemBookCommentBinding viewBinding;

        /* renamed from: h, reason: from kotlin metadata */
        public final int headerTopMargin;

        /* renamed from: i, reason: from kotlin metadata */
        public final int itemLeftRightPadding;

        /* renamed from: j */
        public final /* synthetic */ CommentAdapter f14432j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CommentViewHolder(@k CommentAdapter commentAdapter, ItemBookCommentBinding viewBinding) {
            super(commentAdapter, viewBinding);
            Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
            this.f14432j = commentAdapter;
            this.viewBinding = viewBinding;
            viewBinding.ivUserHeader.setOnClickListener(new View.OnClickListener() { // from class: cd.u
                public /* synthetic */ u() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommentAdapter.CommentViewHolder.w(CommentAdapter.CommentViewHolder.this, view);
                }
            });
            viewBinding.llVoteView.setOnClickListener(new View.OnClickListener() { // from class: cd.v

                /* renamed from: c */
                public final /* synthetic */ CommentAdapter f1893c;

                public /* synthetic */ v(CommentAdapter commentAdapter2) {
                    commentAdapter = commentAdapter2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommentAdapter.CommentViewHolder.x(CommentAdapter.CommentViewHolder.this, commentAdapter, view);
                }
            });
            viewBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: cd.w

                /* renamed from: c */
                public final /* synthetic */ CommentAdapter f1899c;

                public /* synthetic */ w(CommentAdapter commentAdapter2) {
                    commentAdapter = commentAdapter2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommentAdapter.CommentViewHolder.y(CommentAdapter.CommentViewHolder.this, commentAdapter, view);
                }
            });
            viewBinding.getRoot().setOnLongClickListener(new View.OnLongClickListener() { // from class: cd.x

                /* renamed from: c */
                public final /* synthetic */ CommentAdapter f1905c;

                public /* synthetic */ x(CommentAdapter commentAdapter2) {
                    commentAdapter = commentAdapter2;
                }

                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean z10;
                    z10 = CommentAdapter.CommentViewHolder.z(CommentAdapter.CommentViewHolder.this, commentAdapter, view);
                    return z10;
                }
            });
            viewBinding.llMoreReply.setOnClickListener(new View.OnClickListener() { // from class: cd.y
                public /* synthetic */ y() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommentAdapter.CommentViewHolder.A(CommentAdapter.CommentViewHolder.this, view);
                }
            });
            this.headerTopMargin = commentAdapter2.getBookCommentType() == ReaderCommentViewModel.CommentType.TYPE_BOOK_COMMENT ? ConfigSingleton.i(16.0f) : ConfigSingleton.i(12.0f);
            this.itemLeftRightPadding = commentAdapter2.getBookCommentType() == ReaderCommentViewModel.CommentType.TYPE_BOOK_DETAIL_HOT_COMMENT ? ConfigSingleton.i(12.0f) : ConfigSingleton.i(20.0f);
        }

        public static final void A(CommentViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Comment comment = (Comment) this$0.m();
            if (comment == null) {
                return;
            }
            this$0.B(comment);
        }

        public static final void w(CommentViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Comment comment = (Comment) this$0.m();
            if (comment == null) {
                return;
            }
            ac.a.A(this$0.getCom.umeng.analytics.pro.f.X java.lang.String(), "查看用户-头像");
            i.c0((Activity) this$0.getCom.umeng.analytics.pro.f.X java.lang.String(), 1, comment.getCuid());
        }

        public static final void x(CommentViewHolder this$0, CommentAdapter this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Comment comment = (Comment) this$0.m();
            if (comment == null) {
                return;
            }
            this$1.g0(comment, null, this$0.l());
        }

        public static final void y(CommentViewHolder this$0, CommentAdapter this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Comment comment = (Comment) this$0.m();
            if (comment == null) {
                return;
            }
            this$1.n0(comment, comment.getCid(), null, comment.getNickname(), comment.getContent(), this$0.l(), -1);
        }

        public static final boolean z(CommentViewHolder this$0, CommentAdapter this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Comment comment = (Comment) this$0.m();
            if (comment == null) {
                return false;
            }
            this$1.m0(comment, null, this$0.l());
            return true;
        }

        public final void B(Comment comment) {
            if (comment.getIsExpand()) {
                BaseCommentAdapter.BaseCommentViewHolder.d(this, 0, 1, null);
                comment.setLoading(false);
            } else if (comment.getReplyList().size() > comment.getCommentReplyList().size()) {
                comment.setLoading(true);
                comment.addExpandCommentReplyList(Comment.getCacheMoreCommentReply$default(comment, 0, 1, null));
                BaseCommentAdapter.BaseCommentViewHolder.f(this, false, 0, 3, null);
                comment.setLoading(false);
            }
        }

        @Override // com.martian.mibook.mvvm.read.adapter.BaseCommentAdapter.BaseCommentViewHolder
        @SuppressLint({"SetTextI18n"})
        public void a(@l Object r12) {
            int intValue;
            Comment comment = r12 instanceof Comment ? (Comment) r12 : null;
            if (comment == null) {
                return;
            }
            this.viewBinding.llMoreReply.setVisibility(comment.getIsExpand() ? 8 : 0);
            this.viewBinding.tvMoreReply.setText(comment.getExpandDesc());
            this.viewBinding.ivCommentLine.setVisibility(getBindingAdapterPosition() == 0 ? 8 : 0);
            ViewGroup.LayoutParams layoutParams = this.viewBinding.ivUserHeader.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = this.headerTopMargin;
            }
            ConstraintLayout root = this.viewBinding.getRoot();
            root.setPadding(this.itemLeftRightPadding, root.getPaddingTop(), this.itemLeftRightPadding, root.getPaddingBottom());
            m0.o(getCom.umeng.analytics.pro.f.X java.lang.String(), comment.getHeader(), this.viewBinding.ivUserHeader, com.martian.mibook.lib.account.R.drawable.day_img_heads, MiConfigSingleton.b2().x1());
            this.viewBinding.tvNickname.setText(comment.getNickname());
            this.viewBinding.ivVipTag.setVisibility(comment.getVip() ? 0 : 8);
            this.viewBinding.ivExpLevel.setVisibility(8);
            Integer expLevel = comment.getExpLevel();
            if (expLevel != null && (intValue = expLevel.intValue()) > 2) {
                this.viewBinding.ivExpLevel.setVisibility(0);
                this.viewBinding.ivExpLevel.setLevel(intValue);
            }
            if (comment.getTopTime() > 0) {
                this.viewBinding.tvTag.setVisibility(0);
                this.viewBinding.tvTag.setText(getCom.umeng.analytics.pro.f.X java.lang.String().getString(R.string.book_top));
                this.viewBinding.tvTag.setBackgroundResource(R.drawable.mark_green);
            } else if (StringsKt.equals(MiConfigSingleton.b2().T1(), comment.getCuid(), true)) {
                this.viewBinding.tvTag.setVisibility(0);
                this.viewBinding.tvTag.setText(getCom.umeng.analytics.pro.f.X java.lang.String().getString(R.string.mine));
                this.viewBinding.tvTag.setBackgroundResource(com.martian.libmars.R.drawable.border_button_round_default);
            } else {
                this.viewBinding.tvTag.setVisibility(8);
            }
            this.viewBinding.ivSift.setVisibility(comment.getSiftTime() > 0 ? 0 : 8);
            if (this.f14432j.getBookCommentType() == ReaderCommentViewModel.CommentType.TYPE_BOOK_COMMENT || this.f14432j.getBookCommentType() == ReaderCommentViewModel.CommentType.TYPE_BOOK_DETAIL_HOT_COMMENT) {
                this.viewBinding.llScore.setVisibility(0);
                int score = comment.getScore();
                this.viewBinding.ivVote1.setImageResource(R.drawable.vote_star_red);
                this.viewBinding.ivVote2.setImageResource(score < 40 ? R.drawable.vote_star_grey : R.drawable.vote_star_red);
                this.viewBinding.ivVote3.setImageResource(score < 60 ? R.drawable.vote_star_grey : R.drawable.vote_star_red);
                this.viewBinding.ivVote4.setImageResource(score < 80 ? R.drawable.vote_star_grey : R.drawable.vote_star_red);
                this.viewBinding.ivVote5.setImageResource(score < 100 ? R.drawable.vote_star_grey : R.drawable.vote_star_red);
                if (comment.getReadDuration() > 0) {
                    this.viewBinding.tvReadTime.setVisibility(0);
                    this.viewBinding.tvReadTime.setText(ExtKt.c("阅读" + f.j(comment.getReadDuration()) + "点评"));
                } else {
                    this.viewBinding.tvReadTime.setVisibility(8);
                }
            } else {
                this.viewBinding.llScore.setVisibility(8);
            }
            CommentAdapter commentAdapter = this.f14432j;
            ThemeGradientExpandableTextView tvReaderComment = this.viewBinding.tvReaderComment;
            Intrinsics.checkNotNullExpressionValue(tvReaderComment, "tvReaderComment");
            ThemeTextView tvReaderCommentMore = this.viewBinding.tvReaderCommentMore;
            Intrinsics.checkNotNullExpressionValue(tvReaderCommentMore, "tvReaderCommentMore");
            commentAdapter.h0(tvReaderComment, tvReaderCommentMore, comment.getContent());
            CommentAdapter commentAdapter2 = this.f14432j;
            ThemeTextView tvCommentTime = this.viewBinding.tvCommentTime;
            Intrinsics.checkNotNullExpressionValue(tvCommentTime, "tvCommentTime");
            ImageView ivVoteUpCount = this.viewBinding.ivVoteUpCount;
            Intrinsics.checkNotNullExpressionValue(ivVoteUpCount, "ivVoteUpCount");
            TextView tvVoteUpCount = this.viewBinding.tvVoteUpCount;
            Intrinsics.checkNotNullExpressionValue(tvVoteUpCount, "tvVoteUpCount");
            commentAdapter2.k0(tvCommentTime, ivVoteUpCount, tvVoteUpCount, comment.getCreatedOn(), comment.getHasUp(), comment.getUpCount());
        }

        @Override // com.martian.mibook.mvvm.read.adapter.BaseCommentAdapter.BaseCommentViewHolder
        public void o(int r42, @k List<Object> payloads, @l Object r62) {
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            if ((!payloads.isEmpty()) && (r62 instanceof Comment)) {
                Comment comment = (Comment) r62;
                Long createdOn = comment.getCreatedOn();
                if (createdOn != null) {
                    this.viewBinding.tvCommentTime.setText(o0.F(createdOn.longValue()));
                }
                if (Intrinsics.areEqual(payloads.get(0), (Object) 1)) {
                    this.viewBinding.llMoreReply.setVisibility(comment.getIsExpand() ? 8 : 0);
                    this.viewBinding.tvMoreReply.setText(comment.getExpandDesc());
                } else if (Intrinsics.areEqual(payloads.get(0), (Object) 2)) {
                    this.viewBinding.tvVoteUpCount.setText(comment.getUpCount() > 0 ? String.valueOf(comment.getUpCount()) : "");
                    if (comment.getHasUp()) {
                        this.viewBinding.ivVoteUpCount.setImageResource(R.drawable.vote_upcount_selected);
                        this.viewBinding.tvVoteUpCount.setTextColor(ContextCompat.getColor(getCom.umeng.analytics.pro.f.X java.lang.String(), com.martian.libmars.R.color.theme_default));
                    } else {
                        this.viewBinding.ivVoteUpCount.setImageResource(R.drawable.vote_upcount);
                        this.viewBinding.tvVoteUpCount.setTextColor(ConfigSingleton.D().j0());
                    }
                }
            }
        }
    }

    public static final class b implements MiBookManager.i0 {

        /* renamed from: b */
        public final /* synthetic */ CommentReply f14434b;

        /* renamed from: c */
        public final /* synthetic */ int f14435c;

        /* renamed from: d */
        public final /* synthetic */ Comment f14436d;

        public b(CommentReply commentReply, int i10, Comment comment) {
            this.f14434b = commentReply;
            this.f14435c = i10;
            this.f14436d = comment;
        }

        @Override // com.martian.mibook.application.MiBookManager.i0
        public void a(@k x8.c errorResult) {
            Intrinsics.checkNotNullParameter(errorResult, "errorResult");
            t0.b(CommentAdapter.this.getCom.umeng.analytics.pro.f.X java.lang.String(), errorResult.d());
        }

        @Override // com.martian.mibook.application.MiBookManager.i0
        public void b(@k VoteResult voteResult) {
            Intrinsics.checkNotNullParameter(voteResult, "voteResult");
            ac.a.A(CommentAdapter.this.getCom.umeng.analytics.pro.f.X java.lang.String(), "点赞");
            CommentReply commentReply = this.f14434b;
            if (commentReply != null) {
                commentReply.setHasUp(voteResult.getHasUp());
                CommentReply commentReply2 = this.f14434b;
                Integer upCount = voteResult.getUpCount();
                Intrinsics.checkNotNullExpressionValue(upCount, "getUpCount(...)");
                commentReply2.setUpCount(upCount.intValue());
                CommentAdapter.this.notifyItemChanged(this.f14435c + this.f14434b.getIndex() + 1, 2);
            } else {
                this.f14436d.setHasUp(voteResult.getHasUp());
                Comment comment = this.f14436d;
                Integer upCount2 = voteResult.getUpCount();
                Intrinsics.checkNotNullExpressionValue(upCount2, "getUpCount(...)");
                comment.setUpCount(upCount2.intValue());
                CommentAdapter.this.notifyItemChanged(this.f14435c, 2);
            }
            AppViewModel c02 = CommentAdapter.this.c0();
            if (c02 != null) {
                c02.z0(1, this.f14436d);
            }
        }
    }

    public static final class c implements CommentLongClickDialog.b {

        /* renamed from: a */
        public final /* synthetic */ CommentReply f14437a;

        /* renamed from: b */
        public final /* synthetic */ CommentAdapter f14438b;

        /* renamed from: c */
        public final /* synthetic */ Comment f14439c;

        /* renamed from: d */
        public final /* synthetic */ int f14440d;

        /* renamed from: e */
        public final /* synthetic */ FragmentActivity f14441e;

        public c(CommentReply commentReply, CommentAdapter commentAdapter, Comment comment, int i10, FragmentActivity fragmentActivity) {
            this.f14437a = commentReply;
            this.f14438b = commentAdapter;
            this.f14439c = comment;
            this.f14440d = i10;
            this.f14441e = fragmentActivity;
        }

        @Override // com.martian.mibook.fragment.dialog.CommentLongClickDialog.b
        public void a(@l Integer num) {
            if (num != null && num.intValue() == 0) {
                if (this.f14437a != null) {
                    CommentAdapter commentAdapter = this.f14438b;
                    Comment comment = this.f14439c;
                    commentAdapter.n0(comment, comment.getCid(), this.f14437a.getRid(), this.f14437a.getNickname(), this.f14437a.getContent(), this.f14440d, this.f14437a.getIndex());
                    return;
                } else {
                    CommentAdapter commentAdapter2 = this.f14438b;
                    Comment comment2 = this.f14439c;
                    commentAdapter2.n0(comment2, comment2.getCid(), null, this.f14439c.getNickname(), this.f14439c.getContent(), this.f14440d, -1);
                    return;
                }
            }
            if (num != null && num.intValue() == 1) {
                this.f14438b.g0(this.f14439c, this.f14437a, this.f14440d);
            } else if (num != null && num.intValue() == 3) {
                CommentReply commentReply = this.f14437a;
                i.O(this.f14441e, commentReply != null ? commentReply.getCid() : this.f14439c.getCid());
            }
        }
    }

    public static final class d implements PostOrReplyCommentFragment.e {

        /* renamed from: b */
        public final /* synthetic */ Comment f14443b;

        /* renamed from: c */
        public final /* synthetic */ int f14444c;

        /* renamed from: d */
        public final /* synthetic */ int f14445d;

        public d(Comment comment, int i10, int i11) {
            this.f14443b = comment;
            this.f14444c = i10;
            this.f14445d = i11;
        }

        @Override // com.martian.mibook.fragment.dialog.PostOrReplyCommentFragment.e
        public void a(@k CommentReply commentReply) {
            Intrinsics.checkNotNullParameter(commentReply, "commentReply");
            ac.a.A(CommentAdapter.this.getCom.umeng.analytics.pro.f.X java.lang.String(), "回复章评-成功");
            this.f14443b.insertNewCommentReply(commentReply, this.f14444c + 1);
            int i10 = this.f14445d + this.f14444c;
            CommentAdapter.this.notifyItemRangeChanged(i10 + 1, 2, 1);
            CommentAdapter.this.o(CollectionsKt.arrayListOf(commentReply), true, i10 + 2);
            AppViewModel c02 = CommentAdapter.this.c0();
            if (c02 != null) {
                c02.z0(1, this.f14443b);
            }
        }

        @Override // com.martian.mibook.fragment.dialog.PostOrReplyCommentFragment.e
        public void b(@k Comment comment) {
            Intrinsics.checkNotNullParameter(comment, "comment");
        }

        @Override // com.martian.mibook.fragment.dialog.PostOrReplyCommentFragment.e
        public void c(@k String tag, @k String comment) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(comment, "comment");
            CommentAdapter.this.replyContentMap.put(tag, comment);
        }
    }

    public /* synthetic */ CommentAdapter(ReaderCommentViewModel readerCommentViewModel, ReaderCommentViewModel.CommentType commentType, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(readerCommentViewModel, (i10 & 2) != 0 ? ReaderCommentViewModel.CommentType.TYPE_BOOK_COMMENT : commentType);
    }

    public final AppViewModel c0() {
        return (AppViewModel) this.appViewModel.getValue();
    }

    public static final void i0(TextView tvReaderCommentMore, ThemeGradientExpandableTextView tvReaderComment, CommentAdapter this$0) {
        Intrinsics.checkNotNullParameter(tvReaderCommentMore, "$tvReaderCommentMore");
        Intrinsics.checkNotNullParameter(tvReaderComment, "$tvReaderComment");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i10 = 0;
        if (tvReaderComment.getLineCount() < 10 && (tvReaderComment.getLineCount() <= 3 || tvReaderComment.f())) {
            i10 = 8;
        }
        tvReaderCommentMore.setVisibility(i10);
        tvReaderCommentMore.setOnClickListener(new View.OnClickListener() { // from class: cd.l

            /* renamed from: c */
            public final /* synthetic */ TextView f1845c;

            /* renamed from: d */
            public final /* synthetic */ CommentAdapter f1846d;

            public /* synthetic */ l(TextView tvReaderCommentMore2, CommentAdapter this$02) {
                tvReaderCommentMore = tvReaderCommentMore2;
                this$0 = this$02;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommentAdapter.j0(ThemeGradientExpandableTextView.this, tvReaderCommentMore, this$0, view);
            }
        });
    }

    public static final void j0(ThemeGradientExpandableTextView tvReaderComment, TextView tvReaderCommentMore, CommentAdapter this$0, View view) {
        int i10;
        Intrinsics.checkNotNullParameter(tvReaderComment, "$tvReaderComment");
        Intrinsics.checkNotNullParameter(tvReaderCommentMore, "$tvReaderCommentMore");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z10 = !tvReaderComment.f();
        if (tvReaderComment.getLineCount() < 10) {
            if (z10) {
                tvReaderComment.setMaxLines(Integer.MAX_VALUE);
                tvReaderCommentMore.setVisibility(8);
                return;
            }
            return;
        }
        tvReaderComment.setMaxLines(z10 ? Integer.MAX_VALUE : 3);
        tvReaderComment.g(z10, z10 ? ConfigSingleton.i(20.0f) : 0);
        String str = null;
        Context context = this$0.getCom.umeng.analytics.pro.f.X java.lang.String();
        if (z10) {
            if (context != null) {
                i10 = R.string.fold;
                str = context.getString(i10);
            }
            tvReaderCommentMore.setText(str);
        }
        if (context != null) {
            i10 = R.string.expand;
            str = context.getString(i10);
        }
        tvReaderCommentMore.setText(str);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    /* renamed from: G */
    public BaseCommentAdapter.BaseCommentViewHolder onCreateViewHolder(@k ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        if (viewType == 0) {
            ItemBookCommentBinding inflate = ItemBookCommentBinding.inflate(from, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new CommentViewHolder(this, inflate);
        }
        ItemBookCommentReplyBinding inflate2 = ItemBookCommentReplyBinding.inflate(from, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
        return new CommentReplyViewHolder(this, inflate2);
    }

    public final void b0(int r42, @l Object r52) {
        o(CollectionsKt.arrayListOf(r52), true, r42);
        BaseCommentAdapter.K(this, 0, 1, null);
    }

    @l
    /* renamed from: d0, reason: from getter */
    public final ReaderCommentViewModel.CommentType getBookCommentType() {
        return this.bookCommentType;
    }

    @l
    /* renamed from: e0, reason: from getter */
    public final ReaderCommentViewModel getMViewModel() {
        return this.mViewModel;
    }

    public final void f0() {
        notifyItemRangeChanged(0, getPageSize(), 2);
    }

    public final void g0(Comment comment, CommentReply commentReply, int commentLayoutPosition) {
        boolean hasUp;
        Integer num;
        Integer num2;
        if (commentReply != null) {
            Integer cid = commentReply.getCid();
            Integer rid = commentReply.getRid();
            hasUp = commentReply.getHasUp();
            num2 = cid;
            num = rid;
        } else {
            Integer cid2 = comment.getCid();
            hasUp = comment.getHasUp();
            num = 0;
            num2 = cid2;
        }
        boolean z10 = hasUp;
        MiBookManager M1 = MiConfigSingleton.b2().M1();
        Context context = getCom.umeng.analytics.pro.f.X java.lang.String();
        M1.V2(context instanceof Activity ? (Activity) context : null, num2, num, z10, new b(commentReply, commentLayoutPosition, comment));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r32) {
        Object x10 = x(r32);
        if (x10 instanceof Comment) {
            return 0;
        }
        if (x10 instanceof CommentReply) {
            return 1;
        }
        return super.getItemViewType(r32);
    }

    public final void h0(ThemeGradientExpandableTextView tvReaderComment, TextView tvReaderCommentMore, String content) {
        tvReaderComment.setMaxLines(3);
        tvReaderComment.setGradientBackgroundColorType(this.gradientBackgroundColorType);
        tvReaderComment.setText(ba.l.z(content));
        tvReaderComment.post(new Runnable() { // from class: cd.k

            /* renamed from: b */
            public final /* synthetic */ TextView f1838b;

            /* renamed from: c */
            public final /* synthetic */ ThemeGradientExpandableTextView f1839c;

            /* renamed from: d */
            public final /* synthetic */ CommentAdapter f1840d;

            public /* synthetic */ k(TextView tvReaderCommentMore2, ThemeGradientExpandableTextView tvReaderComment2, CommentAdapter this) {
                tvReaderCommentMore = tvReaderCommentMore2;
                tvReaderComment = tvReaderComment2;
                this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                CommentAdapter.i0(tvReaderCommentMore, tvReaderComment, this);
            }
        });
    }

    public final void k0(TextView tvCommentTime, ImageView ivVoteUpCount, TextView tvVoteUpCount, Long createdOn, boolean hasUp, int upCount) {
        if (createdOn != null) {
            tvCommentTime.setText(o0.F(createdOn.longValue()));
        }
        tvVoteUpCount.setText(upCount > 0 ? String.valueOf(upCount) : "");
        if (!hasUp) {
            ivVoteUpCount.setImageResource(R.drawable.vote_upcount);
            tvVoteUpCount.setTextColor(ConfigSingleton.D().j0());
            return;
        }
        ivVoteUpCount.setImageResource(R.drawable.vote_upcount_selected);
        Context context = getCom.umeng.analytics.pro.f.X java.lang.String();
        if (context != null) {
            tvVoteUpCount.setTextColor(ContextCompat.getColor(context, com.martian.libmars.R.color.theme_default));
        }
    }

    public final void l0(int gradientBackgroundColorType) {
        this.gradientBackgroundColorType = gradientBackgroundColorType;
    }

    public final void m0(Comment comment, CommentReply commentReply, int commentLayoutPosition) {
        Context context = getCom.umeng.analytics.pro.f.X java.lang.String();
        FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
        if (fragmentActivity != null) {
            CommentLongClickDialog.INSTANCE.a(fragmentActivity, comment, commentReply, new c(commentReply, this, comment, commentLayoutPosition, fragmentActivity));
        }
    }

    public final void n0(Comment comment, Integer cid, Integer rid, String nickname, String content, int commentLayoutPosition, int commentReplyIndex) {
        String num;
        ac.a.A(getCom.umeng.analytics.pro.f.X java.lang.String(), "回复章评");
        if (rid == null || (num = rid.toString()) == null) {
            num = cid != null ? cid.toString() : null;
        }
        Context context = getCom.umeng.analytics.pro.f.X java.lang.String();
        PostOrReplyCommentFragment.Y(context instanceof FragmentActivity ? (FragmentActivity) context : null, cid, rid, nickname, content, this.replyContentMap.get(num), new d(comment, commentReplyIndex, commentLayoutPosition));
    }

    public CommentAdapter(@l ReaderCommentViewModel readerCommentViewModel, @l ReaderCommentViewModel.CommentType commentType) {
        this.mViewModel = readerCommentViewModel;
        this.bookCommentType = commentType;
        this.replyContentMap = new LinkedHashMap();
        this.appViewModel = LazyKt.lazy(new Function0<AppViewModel>() { // from class: com.martian.mibook.mvvm.read.adapter.CommentAdapter$appViewModel$2
            public CommentAdapter$appViewModel$2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @l
            public final AppViewModel invoke() {
                return b.a(CommentAdapter.this.getCom.umeng.analytics.pro.f.X java.lang.String());
            }
        });
    }
}
