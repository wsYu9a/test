package com.martian.mibook.mvvm.yuewen.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.m.e;
import com.martian.mibook.databinding.ItemSignCoinsBinding;
import com.martian.mibook.databinding.ItemSignRedEnvelopeBinding;
import com.martian.mibook.lib.account.response.BonusPool;
import com.umeng.analytics.pro.f;
import id.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004#$%&B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006'"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/BonusPollSignAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "Lcom/martian/mibook/mvvm/yuewen/adapter/BonusPollSignAdapter$b;", "onSignItemClickListener", "", "o", "(Lcom/martian/mibook/mvvm/yuewen/adapter/BonusPollSignAdapter$b;)V", "", c.f26972i, "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemCount", "()I", "holder", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "Lcom/martian/mibook/lib/account/response/BonusPool;", "bonusPool", "n", "(Lcom/martian/mibook/lib/account/response/BonusPool;)V", "m", "()Lcom/martian/mibook/lib/account/response/BonusPool;", "c", "Lcom/martian/mibook/lib/account/response/BonusPool;", "d", "Lcom/martian/mibook/mvvm/yuewen/adapter/BonusPollSignAdapter$b;", e.TAG, "a", "b", "SignCoinsViewHolder", "SignRedEnvelopeViewHolder", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class BonusPollSignAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: f */
    public static final int f15398f = 0;

    /* renamed from: g */
    public static final int f15399g = 1;

    /* renamed from: c, reason: from kotlin metadata */
    @l
    public BonusPool bonusPool;

    /* renamed from: d, reason: from kotlin metadata */
    @l
    public b onSignItemClickListener;

    /* renamed from: e */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h */
    public static int f15400h = 7;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/BonusPollSignAdapter$SignCoinsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ItemSignCoinsBinding;", "signBinding", "<init>", "(Lcom/martian/mibook/mvvm/yuewen/adapter/BonusPollSignAdapter;Lcom/martian/mibook/databinding/ItemSignCoinsBinding;)V", "", c.f26972i, "", "b", "(I)V", "Lcom/martian/mibook/databinding/ItemSignCoinsBinding;", "Landroid/content/Context;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", f.X, "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class SignCoinsViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ItemSignCoinsBinding signBinding;

        /* renamed from: c, reason: from kotlin metadata */
        @k
        public final Context com.umeng.analytics.pro.f.X java.lang.String;

        /* renamed from: d */
        public final /* synthetic */ BonusPollSignAdapter f15405d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SignCoinsViewHolder(@k BonusPollSignAdapter bonusPollSignAdapter, ItemSignCoinsBinding signBinding) {
            super(signBinding.getRoot());
            Intrinsics.checkNotNullParameter(signBinding, "signBinding");
            this.f15405d = bonusPollSignAdapter;
            this.signBinding = signBinding;
            Context context = signBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this.com.umeng.analytics.pro.f.X java.lang.String = context;
        }

        public static final void c(int i10, int i11, boolean z10, BonusPollSignAdapter this$0, View view) {
            b bVar;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (i10 != i11 || z10 || (bVar = this$0.onSignItemClickListener) == null) {
                return;
            }
            bVar.a();
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: td.g.<init>(int, int, boolean, com.martian.mibook.mvvm.yuewen.adapter.BonusPollSignAdapter):void, class status: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
            	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
            */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0192  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x01ad  */
        @android.annotation.SuppressLint({"SetTextI18n", "UseCompatLoadingForDrawables"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void b(int r11) {
            /*
                Method dump skipped, instructions count: 471
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.yuewen.adapter.BonusPollSignAdapter.SignCoinsViewHolder.b(int):void");
        }

        @k
        /* renamed from: getContext, reason: from getter */
        public final Context getCom.umeng.analytics.pro.f.X java.lang.String() {
            return this.com.umeng.analytics.pro.f.X java.lang.String;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/BonusPollSignAdapter$SignRedEnvelopeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ItemSignRedEnvelopeBinding;", "signBinding", "<init>", "(Lcom/martian/mibook/mvvm/yuewen/adapter/BonusPollSignAdapter;Lcom/martian/mibook/databinding/ItemSignRedEnvelopeBinding;)V", "", c.f26972i, "", "b", "(I)V", "Lcom/martian/mibook/databinding/ItemSignRedEnvelopeBinding;", "Landroid/content/Context;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", f.X, "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class SignRedEnvelopeViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ItemSignRedEnvelopeBinding signBinding;

        /* renamed from: c, reason: from kotlin metadata */
        @k
        public final Context com.umeng.analytics.pro.f.X java.lang.String;

        /* renamed from: d */
        public final /* synthetic */ BonusPollSignAdapter f15408d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SignRedEnvelopeViewHolder(@k BonusPollSignAdapter bonusPollSignAdapter, ItemSignRedEnvelopeBinding signBinding) {
            super(signBinding.getRoot());
            Intrinsics.checkNotNullParameter(signBinding, "signBinding");
            this.f15408d = bonusPollSignAdapter;
            this.signBinding = signBinding;
            Context context = signBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this.com.umeng.analytics.pro.f.X java.lang.String = context;
        }

        public static final void c(int i10, int i11, boolean z10, BonusPollSignAdapter this$0, View view) {
            b bVar;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (i10 != i11 || z10 || (bVar = this$0.onSignItemClickListener) == null) {
                return;
            }
            bVar.a();
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: td.h.<init>(int, int, boolean, com.martian.mibook.mvvm.yuewen.adapter.BonusPollSignAdapter):void, class status: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
            	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
            */
        @android.annotation.SuppressLint({"SetTextI18n"})
        public final void b(int r8) {
            /*
                r7 = this;
                com.martian.mibook.mvvm.yuewen.adapter.BonusPollSignAdapter r0 = r7.f15408d
                com.martian.mibook.lib.account.response.BonusPool r0 = com.martian.mibook.mvvm.yuewen.adapter.BonusPollSignAdapter.i(r0)
                r1 = 0
                if (r0 == 0) goto Le
                int r0 = r0.getCheckinDays()
                goto Lf
            Le:
                r0 = 0
            Lf:
                com.martian.mibook.mvvm.yuewen.adapter.BonusPollSignAdapter r2 = r7.f15408d
                com.martian.mibook.lib.account.response.BonusPool r2 = com.martian.mibook.mvvm.yuewen.adapter.BonusPollSignAdapter.i(r2)
                if (r2 == 0) goto L1c
                boolean r2 = r2.getCheckinToday()
                goto L1d
            L1c:
                r2 = 0
            L1d:
                if (r8 != r0) goto L48
                if (r2 != 0) goto L48
                com.martian.mibook.databinding.ItemSignRedEnvelopeBinding r1 = r7.signBinding
                com.martian.libmars.ui.theme.ThemeTextView r1 = r1.tvDayStatus
                android.content.Context r3 = r7.com.umeng.analytics.pro.f.X java.lang.String
                int r4 = com.martian.mibook.R.string.grab_bonus_imm
                java.lang.String r3 = r3.getString(r4)
                r1.setText(r3)
                com.martian.mibook.databinding.ItemSignRedEnvelopeBinding r1 = r7.signBinding
                com.martian.libmars.ui.theme.ThemeTextView r1 = r1.tvDayStatus
                r3 = -1
                r1.setTextColorType(r3)
                com.martian.mibook.databinding.ItemSignRedEnvelopeBinding r1 = r7.signBinding
                com.martian.libmars.ui.theme.ThemeTextView r1 = r1.tvDayStatus
                android.content.Context r3 = r7.com.umeng.analytics.pro.f.X java.lang.String
                int r4 = com.martian.mibook.R.color.coins_button_receive_text_color
                int r3 = androidx.core.content.ContextCompat.getColor(r3, r4)
                r1.setTextColor(r3)
                goto L89
            L48:
                int r3 = r8 + 1
                if (r3 != r0) goto L5e
                if (r2 == 0) goto L5e
                com.martian.mibook.databinding.ItemSignRedEnvelopeBinding r3 = r7.signBinding
                com.martian.libmars.ui.theme.ThemeTextView r3 = r3.tvDayStatus
                android.content.Context r4 = r7.com.umeng.analytics.pro.f.X java.lang.String
                int r5 = com.martian.mibook.R.string.mission_finish
                java.lang.String r4 = r4.getString(r5)
                r3.setText(r4)
                goto L7b
            L5e:
                com.martian.mibook.databinding.ItemSignRedEnvelopeBinding r4 = r7.signBinding
                com.martian.libmars.ui.theme.ThemeTextView r4 = r4.tvDayStatus
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "第"
                r5.append(r6)
                r5.append(r3)
                java.lang.String r3 = "天"
                r5.append(r3)
                java.lang.String r3 = r5.toString()
                r4.setText(r3)
            L7b:
                com.martian.mibook.databinding.ItemSignRedEnvelopeBinding r3 = r7.signBinding
                com.martian.libmars.ui.theme.ThemeTextView r3 = r3.tvDayStatus
                r3.setTextColorType(r1)
                com.martian.mibook.databinding.ItemSignRedEnvelopeBinding r1 = r7.signBinding
                com.martian.libmars.ui.theme.ThemeTextView r1 = r1.tvDayStatus
                r1.p()
            L89:
                com.martian.mibook.databinding.ItemSignRedEnvelopeBinding r1 = r7.signBinding
                android.widget.LinearLayout r1 = r1.getRoot()
                int r3 = r0 + (-1)
                if (r8 > r3) goto L97
                r3 = 1053609165(0x3ecccccd, float:0.4)
                goto L99
            L97:
                r3 = 1065353216(0x3f800000, float:1.0)
            L99:
                r1.setAlpha(r3)
                com.martian.mibook.databinding.ItemSignRedEnvelopeBinding r1 = r7.signBinding
                android.widget.LinearLayout r1 = r1.getRoot()
                com.martian.mibook.mvvm.yuewen.adapter.BonusPollSignAdapter r3 = r7.f15408d
                td.h r4 = new td.h
                r4.<init>()
                r1.setOnClickListener(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.yuewen.adapter.BonusPollSignAdapter.SignRedEnvelopeViewHolder.b(int):void");
        }

        @k
        /* renamed from: getContext, reason: from getter */
        public final Context getCom.umeng.analytics.pro.f.X java.lang.String() {
            return this.com.umeng.analytics.pro.f.X java.lang.String;
        }
    }

    /* renamed from: com.martian.mibook.mvvm.yuewen.adapter.BonusPollSignAdapter$a */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return BonusPollSignAdapter.f15400h;
        }

        public final void b(int i10) {
            BonusPollSignAdapter.f15400h = i10;
        }

        public Companion() {
        }
    }

    public interface b {
        void a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return f15400h;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r32) {
        return r32 == f15400h - 1 ? 1 : 0;
    }

    @l
    /* renamed from: m, reason: from getter */
    public final BonusPool getBonusPool() {
        return this.bonusPool;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void n(@l BonusPool bonusPool) {
        this.bonusPool = bonusPool;
        notifyDataSetChanged();
    }

    public final void o(@l b onSignItemClickListener) {
        this.onSignItemClickListener = onSignItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@k RecyclerView.ViewHolder holder, int r32) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof SignRedEnvelopeViewHolder) {
            ((SignRedEnvelopeViewHolder) holder).b(r32);
        } else if (holder instanceof SignCoinsViewHolder) {
            ((SignCoinsViewHolder) holder).b(r32);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    public RecyclerView.ViewHolder onCreateViewHolder(@k ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            ItemSignRedEnvelopeBinding inflate = ItemSignRedEnvelopeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new SignRedEnvelopeViewHolder(this, inflate);
        }
        ItemSignCoinsBinding inflate2 = ItemSignCoinsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
        return new SignCoinsViewHolder(this, inflate2);
    }
}
