package com.martian.mibook.mvvm.read.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ItemRecommendBookFriendBinding;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.result.TYBookTopUser;
import com.martian.mibook.mvvm.read.adapter.BookFriendsRecommendAdapter;
import com.martian.mibook.mvvm.read.adapter.RecommendBookFriendsAdapter;
import com.martian.mibook.mvvm.widget.HorizontalSpaceItemDecoration;
import com.umeng.analytics.pro.f;
import id.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import l9.m0;
import l9.t0;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\n\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002)*B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\b2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J#\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u001f\u001a\u00020\b2\n\u0010\u001d\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001f\u0010 R\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/RecommendBookFriendsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/martian/mibook/mvvm/read/adapter/RecommendBookFriendsAdapter$ViewHolder;", "<init>", "()V", "", "Lcom/martian/mibook/mvvm/net/result/TYBookTopUser;", "users", "", "p", "(Ljava/util/List;)V", t.f11204d, "Lcom/martian/mibook/mvvm/read/adapter/RecommendBookFriendsAdapter$a;", "onItemClickListener", "o", "(Lcom/martian/mibook/mvvm/read/adapter/RecommendBookFriendsAdapter$a;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onDetachedFromRecyclerView", "Landroid/view/ViewGroup;", "parent", "", "viewType", "n", "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/read/adapter/RecommendBookFriendsAdapter$ViewHolder;", "getItemCount", "()I", "holder", c.f26972i, "m", "(Lcom/martian/mibook/mvvm/read/adapter/RecommendBookFriendsAdapter$ViewHolder;I)V", "", "c", "Ljava/util/List;", "bookTopUsers", "d", "Landroidx/recyclerview/widget/RecyclerView;", e.TAG, "Lcom/martian/mibook/mvvm/read/adapter/RecommendBookFriendsAdapter$a;", "a", "ViewHolder", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class RecommendBookFriendsAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: c, reason: from kotlin metadata */
    @l
    public List<TYBookTopUser> bookTopUsers;

    /* renamed from: d, reason: from kotlin metadata */
    @l
    public RecyclerView recyclerView;

    /* renamed from: e */
    @l
    public a onItemClickListener;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001d\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u001f¨\u0006!"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/RecommendBookFriendsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ItemRecommendBookFriendBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/read/adapter/RecommendBookFriendsAdapter;Lcom/martian/mibook/databinding/ItemRecommendBookFriendBinding;)V", "Lcom/martian/mibook/mvvm/net/result/TYBookTopUser;", "tyBookTopUser", "", c.f26972i, "", "c", "(Lcom/martian/mibook/mvvm/net/result/TYBookTopUser;I)V", "bookIndex", e.TAG, "(I)V", "Landroid/widget/TextView;", "textView", "colorId", "f", "(Landroid/widget/TextView;I)V", "b", "Lcom/martian/mibook/databinding/ItemRecommendBookFriendBinding;", "d", "()Lcom/martian/mibook/databinding/ItemRecommendBookFriendBinding;", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", f.X, "Lcom/martian/mibook/mvvm/read/adapter/BookFriendsRecommendAdapter;", "Lcom/martian/mibook/mvvm/read/adapter/BookFriendsRecommendAdapter;", "bookFriendsRecommendAdapter", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ItemRecommendBookFriendBinding binding;

        /* renamed from: c, reason: from kotlin metadata */
        @k
        public final Context com.umeng.analytics.pro.f.X java.lang.String;

        /* renamed from: d, reason: from kotlin metadata */
        @l
        public BookFriendsRecommendAdapter bookFriendsRecommendAdapter;

        /* renamed from: e */
        public final /* synthetic */ RecommendBookFriendsAdapter f14558e;

        @SourceDebugExtension({"SMAP\nRecommendBookFriendsAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecommendBookFriendsAdapter.kt\ncom/martian/mibook/mvvm/read/adapter/RecommendBookFriendsAdapter$ViewHolder$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,180:1\n1864#2,2:181\n350#2,7:183\n1866#2:190\n*S KotlinDebug\n*F\n+ 1 RecommendBookFriendsAdapter.kt\ncom/martian/mibook/mvvm/read/adapter/RecommendBookFriendsAdapter$ViewHolder$2\n*L\n123#1:181,2\n124#1:183,7\n123#1:190\n*E\n"})
        public static final class a implements BookFriendsRecommendAdapter.a {

            /* renamed from: b */
            public final /* synthetic */ RecommendBookFriendsAdapter f14560b;

            public a(RecommendBookFriendsAdapter recommendBookFriendsAdapter) {
                this.f14560b = recommendBookFriendsAdapter;
            }

            @Override // com.martian.mibook.mvvm.read.adapter.BookFriendsRecommendAdapter.a
            @SuppressLint({"NotifyDataSetChanged", "SetTextI18n"})
            public void a(@l TYBookItem tYBookItem, @k TextView tvAddBookShelf, @k BookFriendsRecommendAdapter.ViewType viewType) {
                Integer num;
                Intrinsics.checkNotNullParameter(tvAddBookShelf, "tvAddBookShelf");
                Intrinsics.checkNotNullParameter(viewType, "viewType");
                Context context = ViewHolder.this.getCom.umeng.analytics.pro.f.X java.lang.String();
                Activity activity = context instanceof Activity ? (Activity) context : null;
                ViewHolder viewHolder = ViewHolder.this;
                RecommendBookFriendsAdapter recommendBookFriendsAdapter = this.f14560b;
                MiConfigSingleton.b2().M1().g(activity, tYBookItem);
                if (tYBookItem != null) {
                    tYBookItem.setInBookStore(true);
                }
                t0.b(viewHolder.getCom.umeng.analytics.pro.f.X java.lang.String(), "已加入书架");
                if (viewType != BookFriendsRecommendAdapter.ViewType.TYPE_PAGE_RECOMMEND) {
                    tvAddBookShelf.setText(ExtKt.c("已在书架"));
                    return;
                }
                tvAddBookShelf.setVisibility(8);
                List list = recommendBookFriendsAdapter.bookTopUsers;
                if (list != null) {
                    int i10 = 0;
                    for (Object obj : list) {
                        int i11 = i10 + 1;
                        if (i10 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        TYBookTopUser tYBookTopUser = (TYBookTopUser) obj;
                        List<TYBookItem> readBooks = tYBookTopUser.getReadBooks();
                        if (readBooks != null) {
                            Iterator<TYBookItem> it = readBooks.iterator();
                            int i12 = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    i12 = -1;
                                    break;
                                }
                                if (Intrinsics.areEqual(tYBookItem != null ? tYBookItem.getSourceString() : null, it.next().getSourceString())) {
                                    break;
                                } else {
                                    i12++;
                                }
                            }
                            num = Integer.valueOf(i12);
                        } else {
                            num = null;
                        }
                        if (num != null && num.intValue() != -1) {
                            List<TYBookItem> readBooks2 = tYBookTopUser.getReadBooks();
                            TYBookItem tYBookItem2 = readBooks2 != null ? readBooks2.get(num.intValue()) : null;
                            if (tYBookItem2 != null) {
                                tYBookItem2.setInBookStore(true);
                            }
                            RecyclerView recyclerView = recommendBookFriendsAdapter.recyclerView;
                            RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView != null ? recyclerView.findViewHolderForAdapterPosition(i10) : null;
                            ViewHolder viewHolder2 = findViewHolderForAdapterPosition instanceof ViewHolder ? (ViewHolder) findViewHolderForAdapterPosition : null;
                            if (viewHolder2 != null) {
                                viewHolder2.e(num.intValue());
                            }
                        }
                        i10 = i11;
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@k RecommendBookFriendsAdapter recommendBookFriendsAdapter, ItemRecommendBookFriendBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f14558e = recommendBookFriendsAdapter;
            this.binding = binding;
            Context context = binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this.com.umeng.analytics.pro.f.X java.lang.String = context;
            binding.rvReadBooks.setLayoutManager(new LinearLayoutManager(context, 0, false));
            binding.rvReadBooks.addItemDecoration(new HorizontalSpaceItemDecoration(ConfigSingleton.i(12.0f)));
            binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: cd.b2

                /* renamed from: c */
                public final /* synthetic */ RecommendBookFriendsAdapter f1782c;

                public /* synthetic */ b2(RecommendBookFriendsAdapter recommendBookFriendsAdapter2) {
                    recommendBookFriendsAdapter = recommendBookFriendsAdapter2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RecommendBookFriendsAdapter.ViewHolder.b(RecommendBookFriendsAdapter.ViewHolder.this, recommendBookFriendsAdapter, view);
                }
            });
            if (this.bookFriendsRecommendAdapter == null) {
                BookFriendsRecommendAdapter bookFriendsRecommendAdapter = new BookFriendsRecommendAdapter();
                this.bookFriendsRecommendAdapter = bookFriendsRecommendAdapter;
                binding.rvReadBooks.setAdapter(bookFriendsRecommendAdapter);
                BookFriendsRecommendAdapter bookFriendsRecommendAdapter2 = this.bookFriendsRecommendAdapter;
                if (bookFriendsRecommendAdapter2 != null) {
                    bookFriendsRecommendAdapter2.o(new a(recommendBookFriendsAdapter2));
                }
            }
        }

        public static final void b(ViewHolder this$0, RecommendBookFriendsAdapter this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            int bindingAdapterPosition = this$0.getBindingAdapterPosition();
            if (bindingAdapterPosition >= this$1.getPageSize() || bindingAdapterPosition < 0) {
                return;
            }
            List list = this$1.bookTopUsers;
            TYBookTopUser tYBookTopUser = list != null ? (TYBookTopUser) list.get(this$0.getBindingAdapterPosition()) : null;
            a aVar = this$1.onItemClickListener;
            if (aVar != null) {
                aVar.a(tYBookTopUser);
            }
        }

        @SuppressLint({"SetTextI18n"})
        public final void c(@k TYBookTopUser tyBookTopUser, int r62) {
            Intrinsics.checkNotNullParameter(tyBookTopUser, "tyBookTopUser");
            this.binding.tvName.setText(tyBookTopUser.getNickname());
            int i10 = r62 + 1;
            this.binding.tvIndex.setText(String.valueOf(i10));
            if (i10 == 1) {
                TextView tvIndex = this.binding.tvIndex;
                Intrinsics.checkNotNullExpressionValue(tvIndex, "tvIndex");
                f(tvIndex, R.color.book_mall_rank_1);
            } else if (i10 == 2) {
                TextView tvIndex2 = this.binding.tvIndex;
                Intrinsics.checkNotNullExpressionValue(tvIndex2, "tvIndex");
                f(tvIndex2, R.color.book_mall_rank_2);
            } else if (i10 != 3) {
                this.binding.tvIndex.setTextColor(ConfigSingleton.D().j0());
            } else {
                TextView tvIndex3 = this.binding.tvIndex;
                Intrinsics.checkNotNullExpressionValue(tvIndex3, "tvIndex");
                f(tvIndex3, R.color.book_mall_rank_3);
            }
            ThemeTextView themeTextView = this.binding.tvReadTime;
            Integer duration = tyBookTopUser.getDuration();
            themeTextView.setText(ExtKt.c("阅读本书：" + oe.f.a(duration != null ? duration.intValue() : 0)));
            m0.l(this.com.umeng.analytics.pro.f.X java.lang.String, tyBookTopUser.getHeader(), this.binding.ivAvatar, com.martian.mibook.lib.account.R.drawable.day_img_heads);
            ThemeTextView themeTextView2 = this.binding.tvBookShelf;
            Object readCount = tyBookTopUser.getReadCount();
            if (readCount == null) {
                readCount = "";
            }
            themeTextView2.setText(ExtKt.c("TA的书架·" + readCount));
            BookFriendsRecommendAdapter bookFriendsRecommendAdapter = this.bookFriendsRecommendAdapter;
            if (bookFriendsRecommendAdapter != null) {
                BookFriendsRecommendAdapter.q(bookFriendsRecommendAdapter, tyBookTopUser.getReadBooks(), null, 2, null);
            }
        }

        @k
        /* renamed from: d, reason: from getter */
        public final ItemRecommendBookFriendBinding getBinding() {
            return this.binding;
        }

        public final void e(int i10) {
            BookFriendsRecommendAdapter bookFriendsRecommendAdapter = this.bookFriendsRecommendAdapter;
            if (bookFriendsRecommendAdapter != null) {
                bookFriendsRecommendAdapter.l(i10);
            }
        }

        public final void f(TextView textView, int colorId) {
            textView.setTextColor(ContextCompat.getColor(this.com.umeng.analytics.pro.f.X java.lang.String, colorId));
        }

        @k
        /* renamed from: getContext, reason: from getter */
        public final Context getCom.umeng.analytics.pro.f.X java.lang.String() {
            return this.com.umeng.analytics.pro.f.X java.lang.String;
        }
    }

    public interface a {
        void a(@l TYBookTopUser tYBookTopUser);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        List<TYBookTopUser> list = this.bookTopUsers;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final void l(@l List<TYBookTopUser> list) {
        List<TYBookTopUser> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        if (this.bookTopUsers == null) {
            this.bookTopUsers = new ArrayList();
        }
        List<TYBookTopUser> list3 = this.bookTopUsers;
        int size = list3 != null ? list3.size() : 0;
        List<TYBookTopUser> list4 = this.bookTopUsers;
        if (list4 != null) {
            list4.addAll(list2);
        }
        notifyItemRangeInserted(size, list.size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m */
    public void onBindViewHolder(@k ViewHolder holder, int r32) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        List<TYBookTopUser> list = this.bookTopUsers;
        TYBookTopUser tYBookTopUser = list != null ? list.get(r32) : null;
        if (tYBookTopUser != null) {
            holder.c(tYBookTopUser, r32);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    /* renamed from: n */
    public ViewHolder onCreateViewHolder(@k ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemRecommendBookFriendBinding inflate = ItemRecommendBookFriendBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(this, inflate);
    }

    public final void o(@l a onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@k RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.recyclerView = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@k RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = null;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void p(@l List<TYBookTopUser> users) {
        this.bookTopUsers = users != null ? CollectionsKt.toMutableList((Collection) users) : null;
        notifyDataSetChanged();
    }
}
