package com.martian.mibook.mvvm.read.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.ReaderThemeManager;
import com.martian.mibook.application.ReadingInstance;
import com.martian.mibook.databinding.ItemClickRuleBinding;
import com.martian.mibook.mvvm.read.adapter.ClickRulesListAdapter;
import com.umeng.analytics.pro.f;
import id.c;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002/0B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\u0006J\u0015\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0018\u001a\u00020\b2\n\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u0006R\u0018\u0010!\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R!\u0010(\u001a\b\u0012\u0004\u0012\u00020#0\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R!\u0010+\u001a\b\u0012\u0004\u0012\u00020#0\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010%\u001a\u0004\b*\u0010'R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-¨\u00061"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/ClickRulesListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/martian/mibook/mvvm/read/adapter/ClickRulesListAdapter$ClickRuleViewHolder;", "", "isScrollSlideMode", "<init>", "(Z)V", "scrollMode", "", "p", "Lcom/martian/mibook/mvvm/read/adapter/ClickRulesListAdapter$a;", "onItemClickListener", "q", "(Lcom/martian/mibook/mvvm/read/adapter/ClickRulesListAdapter$a;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "o", "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/read/adapter/ClickRulesListAdapter$ClickRuleViewHolder;", "getItemCount", "()I", "holder", c.f26972i, "n", "(Lcom/martian/mibook/mvvm/read/adapter/ClickRulesListAdapter$ClickRuleViewHolder;I)V", "c", "Z", "m", "()Z", t.f11211k, "d", "Lcom/martian/mibook/mvvm/read/adapter/ClickRulesListAdapter$a;", "mOnItemClickListener", "", "Lcom/martian/mibook/application/ReadingInstance$ClickRule;", e.TAG, "Lkotlin/Lazy;", "k", "()Ljava/util/List;", "clickRules", "f", t.f11204d, "slideModeClickRules", "g", "Ljava/util/List;", "clickRulesList", "ClickRuleViewHolder", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ClickRulesListAdapter extends RecyclerView.Adapter<ClickRuleViewHolder> {

    /* renamed from: c, reason: from kotlin metadata */
    public boolean isScrollSlideMode;

    /* renamed from: d, reason: from kotlin metadata */
    @l
    public a mOnItemClickListener;

    /* renamed from: e */
    @k
    public final Lazy clickRules = LazyKt.lazy(ClickRulesListAdapter$clickRules$2.INSTANCE);

    /* renamed from: f, reason: from kotlin metadata */
    @k
    public final Lazy slideModeClickRules = LazyKt.lazy(ClickRulesListAdapter$slideModeClickRules$2.INSTANCE);

    /* renamed from: g, reason: from kotlin metadata */
    @k
    public List<? extends ReadingInstance.ClickRule> clickRulesList = k();

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\n \u000e*\u0004\u0018\u00010\r0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/ClickRulesListAdapter$ClickRuleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ItemClickRuleBinding;", "clickRuleBinding", "<init>", "(Lcom/martian/mibook/mvvm/read/adapter/ClickRulesListAdapter;Lcom/martian/mibook/databinding/ItemClickRuleBinding;)V", "Lcom/martian/mibook/application/ReadingInstance$ClickRule;", "clickRule", "", "c", "(Lcom/martian/mibook/application/ReadingInstance$ClickRule;)V", "b", "Lcom/martian/mibook/databinding/ItemClickRuleBinding;", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "Landroid/content/Context;", f.X, "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class ClickRuleViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ItemClickRuleBinding clickRuleBinding;

        /* renamed from: c, reason: from kotlin metadata */
        public final Context com.umeng.analytics.pro.f.X java.lang.String;

        /* renamed from: d */
        public final /* synthetic */ ClickRulesListAdapter f14418d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClickRuleViewHolder(@k ClickRulesListAdapter clickRulesListAdapter, ItemClickRuleBinding clickRuleBinding) {
            super(clickRuleBinding.getRoot());
            Intrinsics.checkNotNullParameter(clickRuleBinding, "clickRuleBinding");
            this.f14418d = clickRulesListAdapter;
            this.clickRuleBinding = clickRuleBinding;
            this.com.umeng.analytics.pro.f.X java.lang.String = clickRuleBinding.getRoot().getContext();
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: cd.j

                /* renamed from: c */
                public final /* synthetic */ ClickRulesListAdapter.ClickRuleViewHolder f1834c;

                public /* synthetic */ j(ClickRulesListAdapter.ClickRuleViewHolder this) {
                    this = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClickRulesListAdapter.ClickRuleViewHolder.b(ClickRulesListAdapter.this, this, view);
                }
            });
        }

        public static final void b(ClickRulesListAdapter this$0, ClickRuleViewHolder this$1, View view) {
            int bindingAdapterPosition;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (this$0.mOnItemClickListener == null || (bindingAdapterPosition = this$1.getBindingAdapterPosition()) >= this$0.clickRulesList.size() || bindingAdapterPosition < 0) {
                return;
            }
            ReadingInstance.ClickRule clickRule = (ReadingInstance.ClickRule) this$0.clickRulesList.get(bindingAdapterPosition);
            a aVar = this$0.mOnItemClickListener;
            if (aVar != null) {
                aVar.a(view, bindingAdapterPosition, this$0.getIsScrollSlideMode(), clickRule);
            }
        }

        public final void c(@k ReadingInstance.ClickRule clickRule) {
            Intrinsics.checkNotNullParameter(clickRule, "clickRule");
            int clickRuleValue = clickRule.getClickRuleValue();
            if (clickRuleValue == ReadingInstance.ClickRule.RULE_1.getClickRuleValue()) {
                this.clickRuleBinding.ivRule.setImageResource(R.drawable.icon_click_rule_1);
            } else if (clickRuleValue == ReadingInstance.ClickRule.RULE_2.getClickRuleValue()) {
                this.clickRuleBinding.ivRule.setImageResource(R.drawable.icon_click_rule_2);
            } else if (clickRuleValue == ReadingInstance.ClickRule.RULE_3.getClickRuleValue()) {
                this.clickRuleBinding.ivRule.setImageResource(R.drawable.icon_click_rule_3);
            } else if (clickRuleValue == ReadingInstance.ClickRule.RULE_4.getClickRuleValue()) {
                this.clickRuleBinding.ivRule.setImageResource(R.drawable.icon_click_rule_4);
            } else if (clickRuleValue == ReadingInstance.ClickRule.RULE_5.getClickRuleValue()) {
                this.clickRuleBinding.ivRule.setImageResource(R.drawable.icon_click_rule_5);
            } else if (clickRuleValue == ReadingInstance.ClickRule.RULE_6.getClickRuleValue()) {
                this.clickRuleBinding.ivRule.setImageResource(R.drawable.icon_click_rule_6);
            } else {
                this.clickRuleBinding.ivRule.setImageResource(-1);
            }
            ReaderThemeManager h22 = MiConfigSingleton.b2().h2();
            this.clickRuleBinding.ivRule.setAlpha(h22.s() ? 0.5f : 1.0f);
            if (!this.f14418d.getIsScrollSlideMode()) {
                if (clickRule.getClickRuleValue() == ReadingInstance.z().w(this.com.umeng.analytics.pro.f.X java.lang.String)) {
                    this.clickRuleBinding.roundLayout.setRoundingBorderColor(h22.g());
                    return;
                } else {
                    this.clickRuleBinding.roundLayout.setRoundingBorderColor(0);
                    return;
                }
            }
            boolean U = ReadingInstance.z().U(this.com.umeng.analytics.pro.f.X java.lang.String);
            if (!(U && clickRule.getClickRuleValue() == ReadingInstance.ClickRule.RULE_5.getClickRuleValue()) && (U || clickRule.getClickRuleValue() != ReadingInstance.ClickRule.RULE_6.getClickRuleValue())) {
                this.clickRuleBinding.roundLayout.setRoundingBorderColor(0);
            } else {
                this.clickRuleBinding.roundLayout.setRoundingBorderColor(h22.g());
            }
        }
    }

    public interface a {
        void a(@l View view, int i10, boolean z10, @k ReadingInstance.ClickRule clickRule);
    }

    public ClickRulesListAdapter(boolean z10) {
        this.isScrollSlideMode = z10;
        p(this.isScrollSlideMode);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.clickRulesList.size();
    }

    public final List<ReadingInstance.ClickRule> k() {
        return (List) this.clickRules.getValue();
    }

    public final List<ReadingInstance.ClickRule> l() {
        return (List) this.slideModeClickRules.getValue();
    }

    /* renamed from: m, reason: from getter */
    public final boolean getIsScrollSlideMode() {
        return this.isScrollSlideMode;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public void onBindViewHolder(@k ClickRuleViewHolder holder, int r32) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.c(this.clickRulesList.get(r32));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    /* renamed from: o */
    public ClickRuleViewHolder onCreateViewHolder(@k ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemClickRuleBinding inflate = ItemClickRuleBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ClickRuleViewHolder(this, inflate);
    }

    public final void p(boolean scrollMode) {
        this.isScrollSlideMode = scrollMode;
        this.clickRulesList = scrollMode ? l() : k();
    }

    public final void q(@k a onItemClickListener) {
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        this.mOnItemClickListener = onItemClickListener;
    }

    public final void r(boolean z10) {
        this.isScrollSlideMode = z10;
    }
}
