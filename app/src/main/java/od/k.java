package od;

import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.PopupBookAdPosterBinding;
import com.martian.mibook.lib.yuewen.response.TYInitialBook;
import kotlin.jvm.internal.Intrinsics;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/* loaded from: classes3.dex */
public final class k {
    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: od.c.<init>(me.imid.swipebacklayout.lib.app.SwipeBackActivity, com.martian.mibook.lib.yuewen.response.TYInitialBook, androidx.fragment.app.DialogFragment):void, class status: GENERATED_AND_UNLOADED
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
    public static final void i(me.imid.swipebacklayout.lib.app.SwipeBackActivity r8, com.martian.mibook.lib.yuewen.response.TYInitialBook r9) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: od.k.i(me.imid.swipebacklayout.lib.app.SwipeBackActivity, com.martian.mibook.lib.yuewen.response.TYInitialBook):void");
    }

    public static final void j(SwipeBackActivity this_showBookCreativePopupWindow, TYInitialBook tyInitialBook, DialogFragment dialogFragment, View view) {
        Intrinsics.checkNotNullParameter(this_showBookCreativePopupWindow, "$this_showBookCreativePopupWindow");
        Intrinsics.checkNotNullParameter(tyInitialBook, "$tyInitialBook");
        ac.a.s(this_showBookCreativePopupWindow, "创意投放素材-阅读");
        je.i.R(this_showBookCreativePopupWindow, tyInitialBook);
        if (dialogFragment != null) {
            dialogFragment.dismissAllowingStateLoss();
        }
    }

    public static final void k(PopupBookAdPosterBinding binding, View view) {
        Intrinsics.checkNotNullParameter(binding, "$binding");
        binding.popupBookAdTextView.a();
    }

    public static final void l(SwipeBackActivity this_showBookCreativePopupWindow, DialogFragment dialogFragment, View view) {
        Intrinsics.checkNotNullParameter(this_showBookCreativePopupWindow, "$this_showBookCreativePopupWindow");
        ac.a.s(this_showBookCreativePopupWindow, "创意投放素材-关闭");
        if (dialogFragment != null) {
            dialogFragment.dismissAllowingStateLoss();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: od.i.<init>(me.imid.swipebacklayout.lib.app.SwipeBackActivity, boolean, com.martian.mibook.lib.yuewen.response.TYInitialBook, androidx.fragment.app.DialogFragment):void, class status: GENERATED_AND_UNLOADED
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
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @android.annotation.SuppressLint({"SetTextI18n"})
    public static final void m(@xi.k me.imid.swipebacklayout.lib.app.SwipeBackActivity r11, @xi.k com.martian.mibook.lib.yuewen.response.TYInitialBook r12) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: od.k.m(me.imid.swipebacklayout.lib.app.SwipeBackActivity, com.martian.mibook.lib.yuewen.response.TYInitialBook):void");
    }

    public static final void n(SwipeBackActivity this_showBookPromotePopupWindow, boolean z10, TYInitialBook tyInitialBook, DialogFragment dialogFragment, View view) {
        Intrinsics.checkNotNullParameter(this_showBookPromotePopupWindow, "$this_showBookPromotePopupWindow");
        Intrinsics.checkNotNullParameter(tyInitialBook, "$tyInitialBook");
        MiConfigSingleton.b2().e2().w0();
        ac.a.s(this_showBookPromotePopupWindow, z10 ? "投放引流-点击" : "书籍推荐弹窗-点击");
        je.i.R(this_showBookPromotePopupWindow, tyInitialBook);
        if (dialogFragment != null) {
            dialogFragment.dismissAllowingStateLoss();
        }
    }

    public static final void o(SwipeBackActivity this_showBookPromotePopupWindow, boolean z10, DialogFragment dialogFragment, TYInitialBook tyInitialBook, View view) {
        Intrinsics.checkNotNullParameter(this_showBookPromotePopupWindow, "$this_showBookPromotePopupWindow");
        Intrinsics.checkNotNullParameter(tyInitialBook, "$tyInitialBook");
        MiConfigSingleton.b2().e2().w0();
        ac.a.s(this_showBookPromotePopupWindow, z10 ? "投放引流-关闭" : "书籍推荐弹窗-关闭");
        if (dialogFragment != null) {
            dialogFragment.dismissAllowingStateLoss();
        }
        if (MiConfigSingleton.b2().Y() == 1) {
            tyInitialBook.setGoReading(Boolean.FALSE);
            MiConfigSingleton.b2().M1().f1(tyInitialBook, true);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: od.f.<init>(androidx.fragment.app.DialogFragment):void, class status: GENERATED_AND_UNLOADED
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
    public static final void p(@xi.k androidx.fragment.app.FragmentActivity r6, @xi.k java.util.List<zc.a> r7, int r8) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "rightsItems"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            android.view.LayoutInflater r0 = r6.getLayoutInflater()
            int r1 = com.martian.mibook.R.layout.vip_popupwindow_rights
            r2 = 0
            android.view.View r0 = r0.inflate(r1, r2)
            com.martian.mibook.databinding.VipPopupwindowRightsBinding r1 = com.martian.mibook.databinding.VipPopupwindowRightsBinding.bind(r0)
            java.lang.String r2 = "bind(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            com.martian.libmars.widget.dialog.MartianDialogFragment$a r2 = com.martian.libmars.widget.dialog.MartianDialogFragment.INSTANCE
            com.martian.libmars.widget.dialog.b r2 = r2.a()
            com.martian.libmars.widget.dialog.b r0 = r2.Q(r0)
            r2 = 1
            com.martian.libmars.widget.dialog.b r0 = r0.J(r2)
            com.martian.libmars.widget.dialog.MartianDialogFragment r0 = r0.E(r6)
            com.martian.mibook.mvvm.payment.adapter.VipRightsAdapter r3 = new com.martian.mibook.mvvm.payment.adapter.VipRightsAdapter
            r3.<init>(r7)
            androidx.recyclerview.widget.RecyclerView r7 = r1.vipRightsRecyclerView
            androidx.recyclerview.widget.LinearLayoutManager r4 = new androidx.recyclerview.widget.LinearLayoutManager
            r5 = 0
            r4.<init>(r6, r2, r5)
            r7.setLayoutManager(r4)
            androidx.recyclerview.widget.RecyclerView r6 = r1.vipRightsRecyclerView
            r6.setAdapter(r3)
            androidx.recyclerview.widget.RecyclerView r6 = r1.vipRightsRecyclerView
            r6.scrollToPosition(r8)
            com.martian.mibook.mvvm.payment.ui.ThemeVipRelativeLayout r6 = r1.vipRightsButton
            od.f r7 = new od.f
            r7.<init>()
            r6.setOnClickListener(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: od.k.p(androidx.fragment.app.FragmentActivity, java.util.List, int):void");
    }

    public static final void q(DialogFragment dialogFragment, View view) {
        if (dialogFragment != null) {
            dialogFragment.dismissAllowingStateLoss();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: od.g.<init>(androidx.fragment.app.DialogFragment):void, class status: GENERATED_AND_UNLOADED
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
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @android.annotation.SuppressLint({"SetTextI18n"})
    public static final void r(@xi.k androidx.fragment.app.FragmentActivity r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: od.k.r(androidx.fragment.app.FragmentActivity, boolean):void");
    }

    public static final void s(DialogFragment dialogFragment, View view) {
        if (dialogFragment != null) {
            dialogFragment.dismissAllowingStateLoss();
        }
    }

    public static final void t(boolean z10, FragmentActivity this_showVipStatusPopupWindow, DialogFragment dialogFragment, View view) {
        Intrinsics.checkNotNullParameter(this_showVipStatusPopupWindow, "$this_showVipStatusPopupWindow");
        if (z10) {
            je.i.d0(this_showVipStatusPopupWindow, "到期弹窗");
        }
        if (dialogFragment != null) {
            dialogFragment.dismissAllowingStateLoss();
        }
    }
}
