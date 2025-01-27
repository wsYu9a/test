package com.martian.mibook.mvvm.yuewen.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.BookrackCategoryManager;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.yuewen.adapter.BookShelfTagsAdapter;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import l9.i0;
import l9.t0;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003ABCB)\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000e\u001a\u00020\r2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010 \u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00022\b\b\u0001\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020$2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0014H\u0016¢\u0006\u0004\b'\u0010\u0019J\u000f\u0010(\u001a\u00020\rH\u0007¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\r2\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\r2\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b.\u0010-J'\u00101\u001a\u00020\r2\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b1\u00102R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0011\u0010@\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b>\u0010?¨\u0006D"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfTagsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfTagsAdapter$ViewHolder;", "Landroid/content/Context;", f.X, "", "", "categories", "", "secretCategoryEnabled", "<init>", "(Landroid/content/Context;Ljava/util/List;Z)V", "category", "", bt.aO, "(Ljava/util/List;Ljava/lang/String;)V", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfTagsAdapter$a;", "onItemClickListener", "u", "(Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfTagsAdapter$a;)V", "", id.c.f26972i, "v", "(I)V", "o", "()I", "Landroid/view/ViewGroup;", "viewGroup", "i", t.f11211k, "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfTagsAdapter$ViewHolder;", "viewHolder", "p", "(Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfTagsAdapter$ViewHolder;I)V", "m", "(I)Ljava/lang/String;", "", "getItemId", "(I)J", "getItemCount", "s", "()V", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfTagsAdapter$b;", "listener", bt.aJ, "(Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfTagsAdapter$b;)V", IAdInterListener.AdReqParam.WIDTH, "firstPwd", "hint", "x", "(Ljava/lang/String;Ljava/lang/String;Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfTagsAdapter$b;)V", "c", "Landroid/content/Context;", "d", "Ljava/util/List;", e.TAG, "Z", "f", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfTagsAdapter$a;", "g", "I", "selectedPosition", "n", "()Ljava/lang/String;", "selectedCategory", "a", "b", "ViewHolder", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class BookShelfTagsAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: c, reason: from kotlin metadata */
    @l
    public final Context com.umeng.analytics.pro.f.X java.lang.String;

    /* renamed from: d, reason: from kotlin metadata */
    @l
    public List<String> categories;

    /* renamed from: e */
    public boolean secretCategoryEnabled;

    /* renamed from: f, reason: from kotlin metadata */
    @l
    public a onItemClickListener;

    /* renamed from: g, reason: from kotlin metadata */
    public int selectedPosition;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u0007\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfTagsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "a", "()Landroid/widget/TextView;", "tagTitle", "c", "Landroid/view/View;", "()Landroid/view/View;", "tagView", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final TextView tagTitle;

        /* renamed from: c, reason: from kotlin metadata */
        @k
        public final View tagView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@k View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.bookrack_tag_title);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.tagTitle = (TextView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.bookrack_tag_view);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.tagView = findViewById2;
        }

        @k
        /* renamed from: a, reason: from getter */
        public final TextView getTagTitle() {
            return this.tagTitle;
        }

        @k
        /* renamed from: b, reason: from getter */
        public final View getTagView() {
            return this.tagView;
        }
    }

    public interface a {
        void a(@l String str);
    }

    public interface b {
        void a();
    }

    public static final class c implements b {

        /* renamed from: b */
        public final /* synthetic */ int f15503b;

        /* renamed from: c */
        public final /* synthetic */ String f15504c;

        public c(int i10, String str) {
            this.f15503b = i10;
            this.f15504c = str;
        }

        @Override // com.martian.mibook.mvvm.yuewen.adapter.BookShelfTagsAdapter.b
        public void a() {
            BookShelfTagsAdapter.this.v(this.f15503b);
            a aVar = BookShelfTagsAdapter.this.onItemClickListener;
            if (aVar != null) {
                aVar.a(this.f15504c);
            }
        }
    }

    public BookShelfTagsAdapter(@l Context context, @l List<String> list, boolean z10) {
        this.com.umeng.analytics.pro.f.X java.lang.String = context;
        this.categories = list;
        this.secretCategoryEnabled = z10;
    }

    public static final void A(BookShelfTagsAdapter this$0, b listener, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        if (ba.l.q(str)) {
            t0.b(this$0.com.umeng.analytics.pro.f.X java.lang.String, ExtKt.c("密码不能为空,请重试"));
        } else if (!MiConfigSingleton.b2().M1().Z1(this$0.com.umeng.analytics.pro.f.X java.lang.String, str)) {
            t0.b(this$0.com.umeng.analytics.pro.f.X java.lang.String, ExtKt.c("密码不正确，请重试"));
        } else {
            this$0.secretCategoryEnabled = true;
            listener.a();
        }
    }

    public static final void q(int i10, BookShelfTagsAdapter this$0, String category, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(category, "$category");
        if (i10 == this$0.selectedPosition) {
            return;
        }
        if (StringsKt.equals(BookrackCategoryManager.SECRETE_CATEGORY, category, true)) {
            this$0.z(this$0.new c(i10, category));
            return;
        }
        this$0.v(i10);
        a aVar = this$0.onItemClickListener;
        if (aVar != null) {
            aVar.a(category);
        }
    }

    public static final void y(BookShelfTagsAdapter this$0, String firstPwd, b listener, String password) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(firstPwd, "$firstPwd");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(password, "password");
        if (ba.l.q(password)) {
            t0.b(this$0.com.umeng.analytics.pro.f.X java.lang.String, ExtKt.c("密码不能为空"));
            return;
        }
        if (ba.l.q(firstPwd)) {
            if (password.length() == 4) {
                this$0.x(password, ExtKt.c("请再次输入密码"), listener);
                return;
            } else {
                t0.b(this$0.com.umeng.analytics.pro.f.X java.lang.String, ExtKt.c("请输入四位数字密码"));
                return;
            }
        }
        if (!Intrinsics.areEqual(password, firstPwd)) {
            t0.b(this$0.com.umeng.analytics.pro.f.X java.lang.String, ExtKt.c("两次密码输入不一致，请重试"));
            return;
        }
        t0.b(this$0.com.umeng.analytics.pro.f.X java.lang.String, ExtKt.c("设置成功"));
        MiConfigSingleton.b2().M1().G2(this$0.com.umeng.analytics.pro.f.X java.lang.String, password);
        listener.a();
        this$0.secretCategoryEnabled = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        List<String> list = this.categories;
        if (list == null) {
            return 0;
        }
        Intrinsics.checkNotNull(list);
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r32) {
        return r32;
    }

    @k
    public final String m(int r22) {
        if (r22 < 0 || r22 >= getPageSize()) {
            return "";
        }
        List<String> list = this.categories;
        Intrinsics.checkNotNull(list);
        return list.get(r22);
    }

    @k
    public final String n() {
        List<String> list;
        int i10 = this.selectedPosition;
        if (i10 >= 0 && (list = this.categories) != null) {
            Intrinsics.checkNotNull(list);
            if (i10 < list.size()) {
                List<String> list2 = this.categories;
                Intrinsics.checkNotNull(list2);
                return list2.get(this.selectedPosition);
            }
        }
        String ALL_BOOK_CATEGORY = BookrackCategoryManager.ALL_BOOK_CATEGORY;
        Intrinsics.checkNotNullExpressionValue(ALL_BOOK_CATEGORY, "ALL_BOOK_CATEGORY");
        return ALL_BOOK_CATEGORY;
    }

    /* renamed from: o, reason: from getter */
    public final int getSelectedPosition() {
        return this.selectedPosition;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public void onBindViewHolder(@k ViewHolder viewHolder, @SuppressLint({"RecyclerView"}) int r72) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        String m10 = m(r72);
        viewHolder.getTagTitle().setText(m10);
        boolean A0 = ConfigSingleton.D().A0();
        if (r72 == this.selectedPosition) {
            viewHolder.getTagTitle().setTextColor(ContextCompat.getColor(viewHolder.getTagTitle().getContext(), MiConfigSingleton.b2().l0()));
            viewHolder.getTagTitle().setBackgroundResource(A0 ? com.martian.libmars.R.drawable.border_search_background_night_card : R.drawable.border_mission_button);
            viewHolder.getTagTitle().getPaint().setFakeBoldText(true);
        } else {
            viewHolder.getTagTitle().setTextColor(ConfigSingleton.D().j0());
            viewHolder.getTagTitle().setBackgroundResource(A0 ? com.martian.libmars.R.drawable.border_search_background_night_card : com.martian.libmars.R.drawable.border_search_background_day);
            viewHolder.getTagTitle().getPaint().setFakeBoldText(false);
        }
        viewHolder.getTagView().setOnClickListener(new View.OnClickListener() { // from class: td.p

            /* renamed from: b */
            public final /* synthetic */ int f30834b;

            /* renamed from: c */
            public final /* synthetic */ BookShelfTagsAdapter f30835c;

            /* renamed from: d */
            public final /* synthetic */ String f30836d;

            public /* synthetic */ p(int r722, BookShelfTagsAdapter this, String m102) {
                position = r722;
                this = this;
                m10 = m102;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookShelfTagsAdapter.q(position, this, m10, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    /* renamed from: r */
    public ViewHolder onCreateViewHolder(@k ViewGroup viewGroup, int i10) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        View inflate = View.inflate(this.com.umeng.analytics.pro.f.X java.lang.String, R.layout.bookrack_tag_item, null);
        Intrinsics.checkNotNull(inflate);
        return new ViewHolder(inflate);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void s() {
        notifyDataSetChanged();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void t(@k List<String> categories, @l String str) {
        Intrinsics.checkNotNullParameter(categories, "categories");
        this.categories = categories;
        int i10 = 0;
        this.selectedPosition = 0;
        int size = categories.size();
        while (true) {
            if (i10 >= size) {
                break;
            }
            if (ba.l.p(str, categories.get(i10))) {
                this.selectedPosition = i10;
                break;
            }
            i10++;
        }
        notifyDataSetChanged();
    }

    public final void u(@l a onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public final void v(int r22) {
        int i10;
        if (r22 < 0 || r22 >= getPageSize() || (i10 = this.selectedPosition) == r22) {
            return;
        }
        this.selectedPosition = r22;
        notifyItemChanged(i10);
        notifyItemChanged(this.selectedPosition);
    }

    public final void w(b bVar) {
        x("", "请设置四位数字密码", bVar);
    }

    public final void x(String firstPwd, String hint, b listener) {
        String str = ba.l.q(firstPwd) ? "设置密码" : "确认密码";
        Context context = this.com.umeng.analytics.pro.f.X java.lang.String;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        i0.D0((Activity) context, ExtKt.c(str), hint, false, true, new i0.j() { // from class: td.r

            /* renamed from: b */
            public final /* synthetic */ String f30840b;

            /* renamed from: c */
            public final /* synthetic */ BookShelfTagsAdapter.b f30841c;

            public /* synthetic */ r(String firstPwd2, BookShelfTagsAdapter.b listener2) {
                firstPwd = firstPwd2;
                listener = listener2;
            }

            @Override // l9.i0.j
            public final void a(String str2) {
                BookShelfTagsAdapter.y(BookShelfTagsAdapter.this, firstPwd, listener, str2);
            }
        });
    }

    public final void z(b bVar) {
        if (this.secretCategoryEnabled) {
            bVar.a();
        } else {
            if (!MiConfigSingleton.b2().M1().U1(this.com.umeng.analytics.pro.f.X java.lang.String)) {
                w(bVar);
                return;
            }
            Context context = this.com.umeng.analytics.pro.f.X java.lang.String;
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            i0.D0((Activity) context, ExtKt.c("输入密码"), ExtKt.c("请输入4位私密分类密码"), true, true, new i0.j() { // from class: td.q

                /* renamed from: b */
                public final /* synthetic */ BookShelfTagsAdapter.b f30838b;

                public /* synthetic */ q(BookShelfTagsAdapter.b bVar2) {
                    listener = bVar2;
                }

                @Override // l9.i0.j
                public final void a(String str) {
                    BookShelfTagsAdapter.A(BookShelfTagsAdapter.this, listener, str);
                }
            });
        }
    }
}
