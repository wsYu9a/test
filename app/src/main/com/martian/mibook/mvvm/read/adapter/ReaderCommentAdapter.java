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
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelKt;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.internal.bm;
import com.kuaishou.weapon.p0.t;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.widget.GradientExpandableTextView;
import com.martian.mibook.R;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.book.VoteResult;
import com.martian.mibook.data.theme.MiReadingTheme;
import com.martian.mibook.databinding.ItemReaderBookCommentBinding;
import com.martian.mibook.databinding.ItemReaderBookCommentReplyBinding;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.read.adapter.BaseCommentAdapter;
import com.martian.mibook.mvvm.read.adapter.ReaderCommentAdapter;
import com.martian.mibook.mvvm.read.comment.Comment;
import com.martian.mibook.mvvm.read.comment.CommentReply;
import com.martian.mibook.mvvm.read.dialog.ReaderCommentLongClickDialog;
import com.martian.mibook.mvvm.read.fragment.ReaderPostOrReplyCommentFragment;
import com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.martian.mibook.mvvm.utils.coroutine.Coroutine;
import com.martian.mibook.mvvm.widget.ExpLevelLabel;
import com.martian.mibook.ui.reader.ReaderGradientExpandableTextView;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
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
import kotlin.jvm.internal.TypeIntrinsics;
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

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 L2\u00020\u0001:\u0003MNOB\u001d\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007JA\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJO\u0010#\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u00112\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0002¢\u0006\u0004\b#\u0010$J)\u0010%\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u0011H\u0002¢\u0006\u0004\b%\u0010\u001cJ\r\u0010&\u001a\u00020\u0013¢\u0006\u0004\b&\u0010'J\u001f\u0010+\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u00112\b\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u0011H\u0016¢\u0006\u0004\b-\u0010.J#\u00103\u001a\u000602R\u00020\u00012\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020\u0011H\u0016¢\u0006\u0004\b3\u00104J)\u00108\u001a\u00020\u00132\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0004\b8\u00109R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\"\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f0B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u001d\u0010K\u001a\u0004\u0018\u00010F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J¨\u0006P"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/ReaderCommentAdapter;", "Lcom/martian/mibook/mvvm/read/adapter/BaseCommentAdapter;", "Lcom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel;", "mViewModel", "Lcom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel$CommentType;", "bookCommentType", "<init>", "(Lcom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel;Lcom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel$CommentType;)V", "Landroid/widget/TextView;", "tvCommentTime", "Landroid/widget/ImageView;", "ivVoteUpCount", "tvVoteUpCount", "", "createdOn", "", "hasUp", "", "upCount", "", "k0", "(Landroid/widget/TextView;Landroid/widget/ImageView;Landroid/widget/TextView;Ljava/lang/Long;ZI)V", "Lcom/martian/mibook/mvvm/read/comment/Comment;", "comment", "Lcom/martian/mibook/mvvm/read/comment/CommentReply;", "commentReply", "commentLayoutPosition", "g0", "(Lcom/martian/mibook/mvvm/read/comment/Comment;Lcom/martian/mibook/mvvm/read/comment/CommentReply;I)V", "cid", "rid", "", "nickname", "content", "commentReplyIndex", "m0", "(Lcom/martian/mibook/mvvm/read/comment/Comment;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;II)V", "l0", "f0", "()V", id.c.f26972i, "", bm.f6904i, "b0", "(ILjava/lang/Object;)V", "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "Lcom/martian/mibook/mvvm/read/adapter/BaseCommentAdapter$BaseCommentViewHolder;", "G", "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/read/adapter/BaseCommentAdapter$BaseCommentViewHolder;", "Lcom/martian/libmars/widget/GradientExpandableTextView;", "tvReaderComment", "tvReaderCommentMore", "h0", "(Lcom/martian/libmars/widget/GradientExpandableTextView;Landroid/widget/TextView;Ljava/lang/String;)V", "j", "Lcom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel;", "e0", "()Lcom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel;", "k", "Lcom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel$CommentType;", "d0", "()Lcom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel$CommentType;", "", t.f11204d, "Ljava/util/Map;", "replyContentMap", "Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", "m", "Lkotlin/Lazy;", "c0", "()Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", "appViewModel", "n", "CommentReplyViewHolder", "CommentViewHolder", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ReaderCommentAdapter extends BaseCommentAdapter {

    /* renamed from: o */
    public static final int f14455o = 0;

    /* renamed from: p */
    public static final int f14456p = 1;

    /* renamed from: j, reason: from kotlin metadata */
    @l
    public final ReaderCommentViewModel mViewModel;

    /* renamed from: k, reason: from kotlin metadata */
    @l
    public final ReaderCommentViewModel.CommentType bookCommentType;

    /* renamed from: l */
    @k
    public Map<String, String> replyContentMap;

    /* renamed from: m, reason: from kotlin metadata */
    @k
    public final Lazy appViewModel;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0017¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/ReaderCommentAdapter$CommentReplyViewHolder;", "Lcom/martian/mibook/mvvm/read/adapter/BaseCommentAdapter$BaseCommentViewHolder;", "Lcom/martian/mibook/mvvm/read/adapter/BaseCommentAdapter;", "Lcom/martian/mibook/databinding/ItemReaderBookCommentReplyBinding;", "viewBinding", "<init>", "(Lcom/martian/mibook/mvvm/read/adapter/ReaderCommentAdapter;Lcom/martian/mibook/databinding/ItemReaderBookCommentReplyBinding;)V", "", bm.f6904i, "", "a", "(Ljava/lang/Object;)V", "", id.c.f26972i, "", "payloads", "o", "(ILjava/util/List;Ljava/lang/Object;)V", "Lcom/martian/mibook/mvvm/read/comment/CommentReply;", "commentReply", "", "isFold", "G", "(Lcom/martian/mibook/databinding/ItemReaderBookCommentReplyBinding;Lcom/martian/mibook/mvvm/read/comment/CommentReply;Z)V", "g", "Lcom/martian/mibook/databinding/ItemReaderBookCommentReplyBinding;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class CommentReplyViewHolder extends BaseCommentAdapter.BaseCommentViewHolder {

        /* renamed from: g, reason: from kotlin metadata */
        @k
        public final ItemReaderBookCommentReplyBinding viewBinding;

        /* renamed from: h */
        public final /* synthetic */ ReaderCommentAdapter f14462h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CommentReplyViewHolder(@k ReaderCommentAdapter readerCommentAdapter, ItemReaderBookCommentReplyBinding viewBinding) {
            super(readerCommentAdapter, viewBinding);
            Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
            this.f14462h = readerCommentAdapter;
            this.viewBinding = viewBinding;
            viewBinding.ivUserHeader.setOnClickListener(new View.OnClickListener() { // from class: cd.f0
                public /* synthetic */ f0() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderCommentAdapter.CommentReplyViewHolder.z(ReaderCommentAdapter.CommentReplyViewHolder.this, view);
                }
            });
            viewBinding.llVoteView.setOnClickListener(new View.OnClickListener() { // from class: cd.g0

                /* renamed from: c */
                public final /* synthetic */ ReaderCommentAdapter f1815c;

                public /* synthetic */ g0(ReaderCommentAdapter readerCommentAdapter2) {
                    readerCommentAdapter = readerCommentAdapter2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderCommentAdapter.CommentReplyViewHolder.A(ReaderCommentAdapter.CommentReplyViewHolder.this, readerCommentAdapter, view);
                }
            });
            viewBinding.clCommentReply.setOnClickListener(new View.OnClickListener() { // from class: cd.h0

                /* renamed from: c */
                public final /* synthetic */ ReaderCommentAdapter f1822c;

                public /* synthetic */ h0(ReaderCommentAdapter readerCommentAdapter2) {
                    readerCommentAdapter = readerCommentAdapter2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderCommentAdapter.CommentReplyViewHolder.B(ReaderCommentAdapter.CommentReplyViewHolder.this, readerCommentAdapter, view);
                }
            });
            viewBinding.clCommentReply.setOnLongClickListener(new View.OnLongClickListener() { // from class: cd.i0

                /* renamed from: c */
                public final /* synthetic */ ReaderCommentAdapter f1829c;

                public /* synthetic */ i0(ReaderCommentAdapter readerCommentAdapter2) {
                    readerCommentAdapter = readerCommentAdapter2;
                }

                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean C;
                    C = ReaderCommentAdapter.CommentReplyViewHolder.C(ReaderCommentAdapter.CommentReplyViewHolder.this, readerCommentAdapter, view);
                    return C;
                }
            });
        }

        public static final void A(CommentReplyViewHolder this$0, ReaderCommentAdapter this$1, View view) {
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

        public static final void B(CommentReplyViewHolder this$0, ReaderCommentAdapter this$1, View view) {
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
            this$1.m0(comment, comment.getCid(), commentReply.getRid(), commentReply.getNickname(), commentReply.getContent(), i10, commentReply.getIndex());
        }

        public static final boolean C(CommentReplyViewHolder this$0, ReaderCommentAdapter this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            int i10 = this$0.i();
            Comment comment = (Comment) this$0.getAdapter().x(i10);
            if (comment == null) {
                return false;
            }
            this$1.l0(comment, (CommentReply) this$0.m(), i10);
            return true;
        }

        public static final void D(CommentReplyViewHolder this$0, CommentReply commentReply, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(commentReply, "$commentReply");
            this$0.G(this$0.viewBinding, commentReply, true);
        }

        public static final void E(CommentReplyViewHolder this$0, ReaderCommentAdapter this$1, View view) {
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

        public static /* synthetic */ void H(CommentReplyViewHolder commentReplyViewHolder, ItemReaderBookCommentReplyBinding itemReaderBookCommentReplyBinding, CommentReply commentReply, boolean z10, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                z10 = false;
            }
            commentReplyViewHolder.G(itemReaderBookCommentReplyBinding, commentReply, z10);
        }

        public static final void I(ReaderCommentAdapter this$0, int i10) {
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

        public final void G(ItemReaderBookCommentReplyBinding viewBinding, CommentReply commentReply, boolean isFold) {
            int i10 = i();
            Comment comment = (Comment) getAdapter().x(i10);
            if (comment == null) {
                return;
            }
            if (commentReply.isHasMore() && !isFold) {
                CommentReply commentReply2 = (CommentReply) CollectionsKt.last((List) comment.getCommentReplyList());
                commentReply2.setLoading(true);
                ReaderCommentViewModel mViewModel = this.f14462h.getMViewModel();
                if (mViewModel != null) {
                    ReaderCommentAdapter readerCommentAdapter = this.f14462h;
                    Coroutine.onFinally$default(Coroutine.onStart$default(Coroutine.Companion.async$default(Coroutine.INSTANCE, ViewModelKt.getViewModelScope(mViewModel), null, null, null, new ReaderCommentAdapter$CommentReplyViewHolder$expandMoreOrCollapseReply$1$1(comment, readerCommentAdapter, null), 14, null), null, new ReaderCommentAdapter$CommentReplyViewHolder$expandMoreOrCollapseReply$1$2(viewBinding, null), 1, null).onSuccess(Dispatchers.getMain(), new ReaderCommentAdapter$CommentReplyViewHolder$expandMoreOrCollapseReply$1$3(comment, readerCommentAdapter, this, null)), null, new ReaderCommentAdapter$CommentReplyViewHolder$expandMoreOrCollapseReply$1$4(commentReply2, viewBinding, null), 1, null);
                    return;
                }
                return;
            }
            comment.setExpand(false);
            Set set = CollectionsKt.toSet(comment.getCommentReplyList());
            int i11 = i10 + 1;
            int size = set.size() + i11;
            if (i11 >= this.f14462h.B().size() || size > this.f14462h.B().size()) {
                p0.b("Invalid range: " + i11 + " to " + size);
                return;
            }
            this.f14462h.B().subList(i11, size).clear();
            comment.removeExpandCommentReplyList();
            this.f14462h.notifyItemRangeRemoved(i11, set.size());
            RecyclerView rv = this.f14462h.getRv();
            if (rv != null) {
                rv.postDelayed(new Runnable() { // from class: cd.e0

                    /* renamed from: c */
                    public final /* synthetic */ int f1802c;

                    public /* synthetic */ e0(int i102) {
                        i10 = i102;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        ReaderCommentAdapter.CommentReplyViewHolder.I(ReaderCommentAdapter.this, i10);
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
                this.viewBinding.llFold.setOnClickListener(new View.OnClickListener() { // from class: cd.j0

                    /* renamed from: c */
                    public final /* synthetic */ CommentReply f1836c;

                    public /* synthetic */ j0(CommentReply commentReply2) {
                        commentReply = commentReply2;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ReaderCommentAdapter.CommentReplyViewHolder.D(ReaderCommentAdapter.CommentReplyViewHolder.this, commentReply, view);
                    }
                });
                this.viewBinding.tvMoreReply.setText(commentReply2.getExpandDesc());
                if (commentReply2.showMoreReply()) {
                    this.viewBinding.ivMoreReply.setImageResource(R.drawable.icon_account_more);
                    this.viewBinding.llMoreReply.setOnClickListener(new View.OnClickListener() { // from class: cd.k0

                        /* renamed from: c */
                        public final /* synthetic */ ReaderCommentAdapter f1842c;

                        public /* synthetic */ k0(ReaderCommentAdapter readerCommentAdapter) {
                            readerCommentAdapter = readerCommentAdapter;
                        }

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ReaderCommentAdapter.CommentReplyViewHolder.E(ReaderCommentAdapter.CommentReplyViewHolder.this, readerCommentAdapter, view);
                        }
                    });
                } else {
                    this.viewBinding.ivMoreReply.setImageResource(isHasMore ? R.drawable.icon_comment_expand_down : R.drawable.icon_comment_expand_up);
                    this.viewBinding.llMoreReply.setOnClickListener(new View.OnClickListener() { // from class: cd.l0

                        /* renamed from: c */
                        public final /* synthetic */ CommentReply f1848c;

                        public /* synthetic */ l0(CommentReply commentReply2) {
                            commentReply = commentReply2;
                        }

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ReaderCommentAdapter.CommentReplyViewHolder.F(ReaderCommentAdapter.CommentReplyViewHolder.this, commentReply, view);
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
                ReaderThemeTextView readerThemeTextView = this.viewBinding.tvCommentReplyContent;
                CommentReply refReply = commentReply2.getRefReply();
                String nickname = refReply != null ? refReply.getNickname() : null;
                CommentReply refReply2 = commentReply2.getRefReply();
                readerThemeTextView.setText("@" + nickname + "：" + (refReply2 != null ? refReply2.getContent() : null));
                this.viewBinding.llCommentReplyView.setVisibility(0);
            } else {
                this.viewBinding.llCommentReplyView.setVisibility(8);
            }
            ReaderCommentAdapter readerCommentAdapter = this.f14462h;
            ReaderGradientExpandableTextView tvReaderComment = this.viewBinding.tvReaderComment;
            Intrinsics.checkNotNullExpressionValue(tvReaderComment, "tvReaderComment");
            ReaderThemeTextView tvReaderCommentMore = this.viewBinding.tvReaderCommentMore;
            Intrinsics.checkNotNullExpressionValue(tvReaderCommentMore, "tvReaderCommentMore");
            readerCommentAdapter.h0(tvReaderComment, tvReaderCommentMore, commentReply2.getContent());
            ReaderCommentAdapter readerCommentAdapter2 = this.f14462h;
            ReaderThemeTextView tvCommentTime = this.viewBinding.tvCommentTime;
            Intrinsics.checkNotNullExpressionValue(tvCommentTime, "tvCommentTime");
            ImageView ivVoteUpCount = this.viewBinding.ivVoteUpCount;
            Intrinsics.checkNotNullExpressionValue(ivVoteUpCount, "ivVoteUpCount");
            TextView tvVoteUpCount = this.viewBinding.tvVoteUpCount;
            Intrinsics.checkNotNullExpressionValue(tvVoteUpCount, "tvVoteUpCount");
            readerCommentAdapter2.k0(tvCommentTime, ivVoteUpCount, tvVoteUpCount, commentReply2.getCreatedOn(), commentReply2.getHasUp(), commentReply2.getUpCount());
        }

        @Override // com.martian.mibook.mvvm.read.adapter.BaseCommentAdapter.BaseCommentViewHolder
        public void o(int r32, @k List<Object> payloads, @l Object r52) {
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            if ((!payloads.isEmpty()) && (r52 instanceof CommentReply)) {
                if (Intrinsics.areEqual(payloads.get(0), (Object) 1)) {
                    CommentReply commentReply = (CommentReply) r52;
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
                    CommentReply commentReply2 = (CommentReply) r52;
                    this.viewBinding.tvVoteUpCount.setText(commentReply2.getUpCount() > 0 ? String.valueOf(commentReply2.getUpCount()) : "");
                    MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
                    if (commentReply2.getHasUp()) {
                        this.viewBinding.ivVoteUpCount.setColorFilter(k10.getItemColorPrimary());
                        this.viewBinding.tvVoteUpCount.setTextColor(k10.getItemColorPrimary());
                    } else {
                        this.viewBinding.ivVoteUpCount.setColorFilter(k10.getTextColorThirdly());
                        this.viewBinding.tvVoteUpCount.setTextColor(k10.getTextColorThirdly());
                    }
                }
            }
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u000b\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0017¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00122\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/ReaderCommentAdapter$CommentViewHolder;", "Lcom/martian/mibook/mvvm/read/adapter/BaseCommentAdapter$BaseCommentViewHolder;", "Lcom/martian/mibook/mvvm/read/adapter/BaseCommentAdapter;", "Lcom/martian/mibook/databinding/ItemReaderBookCommentBinding;", "viewBinding", "<init>", "(Lcom/martian/mibook/mvvm/read/adapter/ReaderCommentAdapter;Lcom/martian/mibook/databinding/ItemReaderBookCommentBinding;)V", "Lcom/martian/mibook/mvvm/read/comment/Comment;", "comment", "", "B", "(Lcom/martian/mibook/mvvm/read/comment/Comment;)V", "", bm.f6904i, "a", "(Ljava/lang/Object;)V", "", id.c.f26972i, "", "payloads", "o", "(ILjava/util/List;Ljava/lang/Object;)V", "g", "Lcom/martian/mibook/databinding/ItemReaderBookCommentBinding;", "h", "I", "headerTopMargin", "i", "itemLeftRightPadding", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class CommentViewHolder extends BaseCommentAdapter.BaseCommentViewHolder {

        /* renamed from: g, reason: from kotlin metadata */
        @k
        public final ItemReaderBookCommentBinding viewBinding;

        /* renamed from: h, reason: from kotlin metadata */
        public final int headerTopMargin;

        /* renamed from: i, reason: from kotlin metadata */
        public final int itemLeftRightPadding;

        /* renamed from: j */
        public final /* synthetic */ ReaderCommentAdapter f14466j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CommentViewHolder(@k ReaderCommentAdapter readerCommentAdapter, ItemReaderBookCommentBinding viewBinding) {
            super(readerCommentAdapter, viewBinding);
            Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
            this.f14466j = readerCommentAdapter;
            this.viewBinding = viewBinding;
            viewBinding.ivUserHeader.setOnClickListener(new View.OnClickListener() { // from class: cd.m0
                public /* synthetic */ m0() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderCommentAdapter.CommentViewHolder.w(ReaderCommentAdapter.CommentViewHolder.this, view);
                }
            });
            viewBinding.llVoteView.setOnClickListener(new View.OnClickListener() { // from class: cd.n0

                /* renamed from: c */
                public final /* synthetic */ ReaderCommentAdapter f1858c;

                public /* synthetic */ n0(ReaderCommentAdapter readerCommentAdapter2) {
                    readerCommentAdapter = readerCommentAdapter2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderCommentAdapter.CommentViewHolder.x(ReaderCommentAdapter.CommentViewHolder.this, readerCommentAdapter, view);
                }
            });
            viewBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: cd.o0

                /* renamed from: c */
                public final /* synthetic */ ReaderCommentAdapter f1863c;

                public /* synthetic */ o0(ReaderCommentAdapter readerCommentAdapter2) {
                    readerCommentAdapter = readerCommentAdapter2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderCommentAdapter.CommentViewHolder.y(ReaderCommentAdapter.CommentViewHolder.this, readerCommentAdapter, view);
                }
            });
            viewBinding.getRoot().setOnLongClickListener(new View.OnLongClickListener() { // from class: cd.p0

                /* renamed from: c */
                public final /* synthetic */ ReaderCommentAdapter f1868c;

                public /* synthetic */ p0(ReaderCommentAdapter readerCommentAdapter2) {
                    readerCommentAdapter = readerCommentAdapter2;
                }

                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean z10;
                    z10 = ReaderCommentAdapter.CommentViewHolder.z(ReaderCommentAdapter.CommentViewHolder.this, readerCommentAdapter, view);
                    return z10;
                }
            });
            viewBinding.llMoreReply.setOnClickListener(new View.OnClickListener() { // from class: cd.q0
                public /* synthetic */ q0() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderCommentAdapter.CommentViewHolder.A(ReaderCommentAdapter.CommentViewHolder.this, view);
                }
            });
            this.headerTopMargin = readerCommentAdapter2.getBookCommentType() == ReaderCommentViewModel.CommentType.TYPE_BOOK_COMMENT ? ConfigSingleton.i(16.0f) : ConfigSingleton.i(12.0f);
            this.itemLeftRightPadding = readerCommentAdapter2.getBookCommentType() == ReaderCommentViewModel.CommentType.TYPE_BOOK_DETAIL_HOT_COMMENT ? ConfigSingleton.i(12.0f) : ConfigSingleton.i(20.0f);
        }

        public static final void A(CommentViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Comment comment = (Comment) this$0.m();
            if (comment == null) {
                return;
            }
            this$0.B(comment);
        }

        private final void B(Comment comment) {
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

        public static final void w(CommentViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Comment comment = (Comment) this$0.m();
            if (comment == null) {
                return;
            }
            ac.a.A(this$0.getCom.umeng.analytics.pro.f.X java.lang.String(), "查看用户-头像");
            i.c0((Activity) this$0.getCom.umeng.analytics.pro.f.X java.lang.String(), 1, comment.getCuid());
        }

        public static final void x(CommentViewHolder this$0, ReaderCommentAdapter this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Comment comment = (Comment) this$0.m();
            if (comment == null) {
                return;
            }
            this$1.g0(comment, null, this$0.l());
        }

        public static final void y(CommentViewHolder this$0, ReaderCommentAdapter this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Comment comment = (Comment) this$0.m();
            if (comment == null) {
                return;
            }
            this$1.m0(comment, comment.getCid(), null, comment.getNickname(), comment.getContent(), this$0.l(), -1);
        }

        public static final boolean z(CommentViewHolder this$0, ReaderCommentAdapter this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Comment comment = (Comment) this$0.m();
            if (comment == null) {
                return false;
            }
            this$1.l0(comment, null, this$0.l());
            return true;
        }

        @Override // com.martian.mibook.mvvm.read.adapter.BaseCommentAdapter.BaseCommentViewHolder
        @SuppressLint({"SetTextI18n"})
        public void a(@l Object r12) {
            int intValue;
            Comment comment = r12 instanceof Comment ? (Comment) r12 : null;
            if (comment == null) {
                return;
            }
            MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
            this.viewBinding.llMoreReply.setVisibility(comment.getIsExpand() ? 8 : 0);
            this.viewBinding.tvMoreReply.setText(comment.getExpandDesc());
            this.viewBinding.ivCommentLine.setVisibility(l() == 0 ? 8 : 0);
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
                this.viewBinding.tvTag.setBackground(k10.getBorderLineBackgroundSelectedDrawable(getCom.umeng.analytics.pro.f.X java.lang.String()));
            } else {
                this.viewBinding.tvTag.setVisibility(8);
            }
            this.viewBinding.ivSift.setVisibility(comment.getSiftTime() > 0 ? 0 : 8);
            if (this.f14466j.getBookCommentType() == ReaderCommentViewModel.CommentType.TYPE_BOOK_COMMENT) {
                this.viewBinding.llScore.setVisibility(0);
                int score = comment.getScore();
                this.viewBinding.ivVote1.setAlpha(0.8f);
                this.viewBinding.ivVote2.setAlpha(score > 20 ? 0.8f : 0.3f);
                this.viewBinding.ivVote3.setAlpha(score > 40 ? 0.8f : 0.3f);
                this.viewBinding.ivVote4.setAlpha(score > 60 ? 0.8f : 0.3f);
                this.viewBinding.ivVote5.setAlpha(score <= 80 ? 0.3f : 0.8f);
                if (comment.getReadDuration() > 0) {
                    this.viewBinding.tvReadTime.setVisibility(0);
                    this.viewBinding.tvReadTime.setText(ExtKt.c("阅读" + f.j(comment.getReadDuration()) + "点评"));
                } else {
                    this.viewBinding.tvReadTime.setVisibility(8);
                }
            } else {
                this.viewBinding.llScore.setVisibility(8);
            }
            ReaderCommentAdapter readerCommentAdapter = this.f14466j;
            ReaderGradientExpandableTextView tvReaderComment = this.viewBinding.tvReaderComment;
            Intrinsics.checkNotNullExpressionValue(tvReaderComment, "tvReaderComment");
            ReaderThemeTextView tvReaderCommentMore = this.viewBinding.tvReaderCommentMore;
            Intrinsics.checkNotNullExpressionValue(tvReaderCommentMore, "tvReaderCommentMore");
            readerCommentAdapter.h0(tvReaderComment, tvReaderCommentMore, comment.getContent());
            ReaderCommentAdapter readerCommentAdapter2 = this.f14466j;
            ReaderThemeTextView tvCommentTime = this.viewBinding.tvCommentTime;
            Intrinsics.checkNotNullExpressionValue(tvCommentTime, "tvCommentTime");
            ImageView ivVoteUpCount = this.viewBinding.ivVoteUpCount;
            Intrinsics.checkNotNullExpressionValue(ivVoteUpCount, "ivVoteUpCount");
            TextView tvVoteUpCount = this.viewBinding.tvVoteUpCount;
            Intrinsics.checkNotNullExpressionValue(tvVoteUpCount, "tvVoteUpCount");
            readerCommentAdapter2.k0(tvCommentTime, ivVoteUpCount, tvVoteUpCount, comment.getCreatedOn(), comment.getHasUp(), comment.getUpCount());
        }

        @Override // com.martian.mibook.mvvm.read.adapter.BaseCommentAdapter.BaseCommentViewHolder
        public void o(int r32, @k List<Object> payloads, @l Object r52) {
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            if ((!payloads.isEmpty()) && (r52 instanceof Comment)) {
                if (Intrinsics.areEqual(payloads.get(0), (Object) 1)) {
                    Comment comment = (Comment) r52;
                    this.viewBinding.llMoreReply.setVisibility(comment.getIsExpand() ? 8 : 0);
                    this.viewBinding.tvMoreReply.setText(comment.getExpandDesc());
                } else if (Intrinsics.areEqual(payloads.get(0), (Object) 2)) {
                    Comment comment2 = (Comment) r52;
                    this.viewBinding.tvVoteUpCount.setText(comment2.getUpCount() > 0 ? String.valueOf(comment2.getUpCount()) : "");
                    MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
                    if (comment2.getHasUp()) {
                        this.viewBinding.ivVoteUpCount.setColorFilter(k10.getItemColorPrimary());
                        this.viewBinding.tvVoteUpCount.setTextColor(k10.getItemColorPrimary());
                    } else {
                        this.viewBinding.ivVoteUpCount.setColorFilter(k10.getTextColorThirdly());
                        this.viewBinding.tvVoteUpCount.setTextColor(k10.getTextColorThirdly());
                    }
                }
            }
        }
    }

    public static final class b implements MiBookManager.i0 {

        /* renamed from: b */
        public final /* synthetic */ CommentReply f14468b;

        /* renamed from: c */
        public final /* synthetic */ int f14469c;

        /* renamed from: d */
        public final /* synthetic */ Comment f14470d;

        public b(CommentReply commentReply, int i10, Comment comment) {
            this.f14468b = commentReply;
            this.f14469c = i10;
            this.f14470d = comment;
        }

        @Override // com.martian.mibook.application.MiBookManager.i0
        public void a(@k x8.c errorResult) {
            Intrinsics.checkNotNullParameter(errorResult, "errorResult");
            t0.b(ReaderCommentAdapter.this.getCom.umeng.analytics.pro.f.X java.lang.String(), errorResult.d());
        }

        @Override // com.martian.mibook.application.MiBookManager.i0
        public void b(@k VoteResult voteResult) {
            Intrinsics.checkNotNullParameter(voteResult, "voteResult");
            ac.a.A(ReaderCommentAdapter.this.getCom.umeng.analytics.pro.f.X java.lang.String(), "点赞");
            CommentReply commentReply = this.f14468b;
            if (commentReply != null) {
                commentReply.setHasUp(voteResult.getHasUp());
                CommentReply commentReply2 = this.f14468b;
                Integer upCount = voteResult.getUpCount();
                Intrinsics.checkNotNullExpressionValue(upCount, "getUpCount(...)");
                commentReply2.setUpCount(upCount.intValue());
                ReaderCommentAdapter.this.notifyItemChanged(this.f14469c + this.f14468b.getIndex() + 1, 2);
            } else {
                this.f14470d.setHasUp(voteResult.getHasUp());
                Comment comment = this.f14470d;
                Integer upCount2 = voteResult.getUpCount();
                Intrinsics.checkNotNullExpressionValue(upCount2, "getUpCount(...)");
                comment.setUpCount(upCount2.intValue());
                ReaderCommentAdapter.this.notifyItemChanged(this.f14469c, 2);
            }
            AppViewModel c02 = ReaderCommentAdapter.this.c0();
            if (c02 != null) {
                c02.z0(1, this.f14470d);
            }
        }
    }

    public static final class c implements ReaderCommentLongClickDialog.b {

        /* renamed from: a */
        public final /* synthetic */ CommentReply f14471a;

        /* renamed from: b */
        public final /* synthetic */ ReaderCommentAdapter f14472b;

        /* renamed from: c */
        public final /* synthetic */ Comment f14473c;

        /* renamed from: d */
        public final /* synthetic */ int f14474d;

        /* renamed from: e */
        public final /* synthetic */ FragmentActivity f14475e;

        public c(CommentReply commentReply, ReaderCommentAdapter readerCommentAdapter, Comment comment, int i10, FragmentActivity fragmentActivity) {
            this.f14471a = commentReply;
            this.f14472b = readerCommentAdapter;
            this.f14473c = comment;
            this.f14474d = i10;
            this.f14475e = fragmentActivity;
        }

        @Override // com.martian.mibook.mvvm.read.dialog.ReaderCommentLongClickDialog.b
        public void a(@l Integer num) {
            if (num != null && num.intValue() == 0) {
                if (this.f14471a != null) {
                    ReaderCommentAdapter readerCommentAdapter = this.f14472b;
                    Comment comment = this.f14473c;
                    readerCommentAdapter.m0(comment, comment.getCid(), this.f14471a.getRid(), this.f14471a.getNickname(), this.f14471a.getContent(), this.f14474d, this.f14471a.getIndex());
                    return;
                } else {
                    ReaderCommentAdapter readerCommentAdapter2 = this.f14472b;
                    Comment comment2 = this.f14473c;
                    readerCommentAdapter2.m0(comment2, comment2.getCid(), null, this.f14473c.getNickname(), this.f14473c.getContent(), this.f14474d, -1);
                    return;
                }
            }
            if (num != null && num.intValue() == 1) {
                this.f14472b.g0(this.f14473c, this.f14471a, this.f14474d);
            } else if (num != null && num.intValue() == 3) {
                CommentReply commentReply = this.f14471a;
                i.O(this.f14475e, commentReply != null ? commentReply.getCid() : this.f14473c.getCid());
            }
        }
    }

    public static final class d implements ReaderPostOrReplyCommentFragment.e {

        /* renamed from: b */
        public final /* synthetic */ Comment f14477b;

        /* renamed from: c */
        public final /* synthetic */ int f14478c;

        /* renamed from: d */
        public final /* synthetic */ String f14479d;

        /* renamed from: e */
        public final /* synthetic */ int f14480e;

        public d(Comment comment, int i10, String str, int i11) {
            this.f14477b = comment;
            this.f14478c = i10;
            this.f14479d = str;
            this.f14480e = i11;
        }

        @Override // com.martian.mibook.mvvm.read.fragment.ReaderPostOrReplyCommentFragment.e
        public void a(@k CommentReply commentReply) {
            Intrinsics.checkNotNullParameter(commentReply, "commentReply");
            ac.a.A(ReaderCommentAdapter.this.getCom.umeng.analytics.pro.f.X java.lang.String(), "回复章评-成功");
            this.f14477b.insertNewCommentReply(commentReply, this.f14478c + 1);
            TypeIntrinsics.asMutableMap(ReaderCommentAdapter.this.replyContentMap).remove(this.f14479d);
            int i10 = this.f14480e + this.f14478c;
            ReaderCommentAdapter.this.notifyItemRangeChanged(i10 + 1, 2, 1);
            ReaderCommentAdapter.this.o(CollectionsKt.arrayListOf(commentReply), true, i10 + 2);
            AppViewModel c02 = ReaderCommentAdapter.this.c0();
            if (c02 != null) {
                c02.z0(1, this.f14477b);
            }
        }

        @Override // com.martian.mibook.mvvm.read.fragment.ReaderPostOrReplyCommentFragment.e
        public void b(@k Comment comment) {
            Intrinsics.checkNotNullParameter(comment, "comment");
        }

        @Override // com.martian.mibook.mvvm.read.fragment.ReaderPostOrReplyCommentFragment.e
        public void c(@k String tag, @k String comment) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(comment, "comment");
            ReaderCommentAdapter.this.replyContentMap.put(tag, comment);
        }
    }

    public /* synthetic */ ReaderCommentAdapter(ReaderCommentViewModel readerCommentViewModel, ReaderCommentViewModel.CommentType commentType, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(readerCommentViewModel, (i10 & 2) != 0 ? ReaderCommentViewModel.CommentType.TYPE_BOOK_COMMENT : commentType);
    }

    public final AppViewModel c0() {
        return (AppViewModel) this.appViewModel.getValue();
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

    public static final void i0(TextView tvReaderCommentMore, GradientExpandableTextView tvReaderComment, ReaderCommentAdapter this$0) {
        Intrinsics.checkNotNullParameter(tvReaderCommentMore, "$tvReaderCommentMore");
        Intrinsics.checkNotNullParameter(tvReaderComment, "$tvReaderComment");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i10 = 0;
        if (tvReaderComment.getLineCount() < 10 && (tvReaderComment.getLineCount() <= 3 || tvReaderComment.f())) {
            i10 = 8;
        }
        tvReaderCommentMore.setVisibility(i10);
        tvReaderCommentMore.setOnClickListener(new View.OnClickListener() { // from class: cd.c0

            /* renamed from: c */
            public final /* synthetic */ TextView f1786c;

            /* renamed from: d */
            public final /* synthetic */ ReaderCommentAdapter f1787d;

            public /* synthetic */ c0(TextView tvReaderCommentMore2, ReaderCommentAdapter this$02) {
                tvReaderCommentMore = tvReaderCommentMore2;
                this$0 = this$02;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderCommentAdapter.j0(GradientExpandableTextView.this, tvReaderCommentMore, this$0, view);
            }
        });
    }

    public static final void j0(GradientExpandableTextView tvReaderComment, TextView tvReaderCommentMore, ReaderCommentAdapter this$0, View view) {
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

    public final void k0(TextView tvCommentTime, ImageView ivVoteUpCount, TextView tvVoteUpCount, Long createdOn, boolean hasUp, int upCount) {
        if (createdOn != null) {
            tvCommentTime.setText(o0.F(createdOn.longValue()));
        }
        tvVoteUpCount.setText(upCount > 0 ? String.valueOf(upCount) : "");
        MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
        if (hasUp) {
            ivVoteUpCount.setColorFilter(k10.getItemColorPrimary());
            tvVoteUpCount.setTextColor(k10.getItemColorPrimary());
        } else if (getCom.umeng.analytics.pro.f.X java.lang.String() != null) {
            ivVoteUpCount.setColorFilter(k10.getTextColorThirdly());
            tvVoteUpCount.setTextColor(k10.getTextColorThirdly());
        }
    }

    public final void l0(Comment comment, CommentReply commentReply, int commentLayoutPosition) {
        Context context = getCom.umeng.analytics.pro.f.X java.lang.String();
        FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
        if (fragmentActivity == null) {
            return;
        }
        ReaderCommentLongClickDialog.INSTANCE.a(fragmentActivity, comment, commentReply, new c(commentReply, this, comment, commentLayoutPosition, fragmentActivity));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m0(com.martian.mibook.mvvm.read.comment.Comment r11, java.lang.Integer r12, java.lang.Integer r13, java.lang.String r14, java.lang.String r15, int r16, int r17) {
        /*
            r10 = this;
            android.content.Context r0 = r10.getCom.umeng.analytics.pro.f.X java.lang.String()
            java.lang.String r1 = "回复章评"
            ac.a.A(r0, r1)
            r0 = 0
            if (r13 == 0) goto L15
            java.lang.String r1 = r13.toString()
            if (r1 != 0) goto L13
            goto L15
        L13:
            r6 = r1
            goto L1d
        L15:
            if (r12 == 0) goto L1c
            java.lang.String r1 = r12.toString()
            goto L13
        L1c:
            r6 = r0
        L1d:
            android.content.Context r1 = r10.getCom.umeng.analytics.pro.f.X java.lang.String()
            boolean r2 = r1 instanceof androidx.fragment.app.FragmentActivity
            if (r2 == 0) goto L28
            r0 = r1
            androidx.fragment.app.FragmentActivity r0 = (androidx.fragment.app.FragmentActivity) r0
        L28:
            r1 = r0
            r0 = r10
            java.util.Map<java.lang.String, java.lang.String> r2 = r0.replyContentMap
            java.lang.Object r2 = r2.get(r6)
            r8 = r2
            java.lang.String r8 = (java.lang.String) r8
            com.martian.mibook.mvvm.read.adapter.ReaderCommentAdapter$d r9 = new com.martian.mibook.mvvm.read.adapter.ReaderCommentAdapter$d
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r17
            r7 = r16
            r2.<init>(r4, r5, r6, r7)
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r8
            r7 = r9
            com.martian.mibook.mvvm.read.fragment.ReaderPostOrReplyCommentFragment.Y(r1, r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.read.adapter.ReaderCommentAdapter.m0(com.martian.mibook.mvvm.read.comment.Comment, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, int, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    /* renamed from: G */
    public BaseCommentAdapter.BaseCommentViewHolder onCreateViewHolder(@k ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        if (viewType == 0) {
            ItemReaderBookCommentBinding inflate = ItemReaderBookCommentBinding.inflate(from, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new CommentViewHolder(this, inflate);
        }
        ItemReaderBookCommentReplyBinding inflate2 = ItemReaderBookCommentReplyBinding.inflate(from, parent, false);
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

    public final void h0(GradientExpandableTextView tvReaderComment, TextView tvReaderCommentMore, String content) {
        tvReaderComment.setMaxLines(3);
        tvReaderComment.setText(ba.l.z(content));
        tvReaderComment.post(new Runnable() { // from class: cd.d0

            /* renamed from: b */
            public final /* synthetic */ TextView f1793b;

            /* renamed from: c */
            public final /* synthetic */ GradientExpandableTextView f1794c;

            /* renamed from: d */
            public final /* synthetic */ ReaderCommentAdapter f1795d;

            public /* synthetic */ d0(TextView tvReaderCommentMore2, GradientExpandableTextView tvReaderComment2, ReaderCommentAdapter this) {
                tvReaderCommentMore = tvReaderCommentMore2;
                tvReaderComment = tvReaderComment2;
                this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ReaderCommentAdapter.i0(tvReaderCommentMore, tvReaderComment, this);
            }
        });
    }

    public ReaderCommentAdapter(@l ReaderCommentViewModel readerCommentViewModel, @l ReaderCommentViewModel.CommentType commentType) {
        this.mViewModel = readerCommentViewModel;
        this.bookCommentType = commentType;
        this.replyContentMap = new LinkedHashMap();
        this.appViewModel = LazyKt.lazy(new Function0<AppViewModel>() { // from class: com.martian.mibook.mvvm.read.adapter.ReaderCommentAdapter$appViewModel$2
            public ReaderCommentAdapter$appViewModel$2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @l
            public final AppViewModel invoke() {
                return b.a(ReaderCommentAdapter.this.getCom.umeng.analytics.pro.f.X java.lang.String());
            }
        });
    }
}
