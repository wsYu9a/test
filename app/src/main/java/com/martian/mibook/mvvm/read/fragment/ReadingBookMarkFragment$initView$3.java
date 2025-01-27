package com.martian.mibook.mvvm.read.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import com.martian.mibook.mvvm.read.adapter.BookMarkListAdapter;
import com.martian.mibook.mvvm.read.fragment.ReadingBookMarkFragment;
import com.martian.mibook.mvvm.read.fragment.ReadingBookMarkFragment$initView$3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import xi.k;
import xi.l;

/* loaded from: classes3.dex */
public final class ReadingBookMarkFragment$initView$3 implements BookMarkListAdapter.b {

    /* renamed from: a */
    public final /* synthetic */ ReadingBookMarkFragment f14716a;

    public ReadingBookMarkFragment$initView$3(ReadingBookMarkFragment readingBookMarkFragment) {
        this.f14716a = readingBookMarkFragment;
    }

    public static final void d(ReadingBookMarkFragment this$0, int i10, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), null, null, new ReadingBookMarkFragment$initView$3$onItemLongClick$1$1(this$0, i10, null), 3, null);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.martian.mibook.mvvm.read.fragment.ReadingBookMarkFragment$initView$3$onItemClick$1$1.<init>(com.martian.mibook.mvvm.read.fragment.ReadingBookMarkFragment, com.martian.mibook.lib.model.data.MiBookMark):void, class status: GENERATED_AND_UNLOADED
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
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
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
    @Override // com.martian.mibook.mvvm.read.adapter.BookMarkListAdapter.b
    public void a(@xi.l android.view.View r3, int r4) {
        /*
            r2 = this;
            com.martian.mibook.mvvm.read.fragment.ReadingBookMarkFragment r3 = r2.f14716a
            com.martian.mibook.mvvm.read.adapter.BookMarkListAdapter r3 = com.martian.mibook.mvvm.read.fragment.ReadingBookMarkFragment.l0(r3)
            if (r3 == 0) goto Ld
            com.martian.mibook.lib.model.data.MiBookMark r3 = r3.k(r4)
            goto Le
        Ld:
            r3 = 0
        Le:
            if (r3 == 0) goto L20
            com.martian.mibook.mvvm.read.fragment.ReadingBookMarkFragment r4 = r2.f14716a
            com.martian.mibook.mvvm.read.widget.a r0 = com.martian.mibook.mvvm.read.fragment.ReadingBookMarkFragment.n0(r4)
            if (r0 == 0) goto L20
            com.martian.mibook.mvvm.read.fragment.ReadingBookMarkFragment$initView$3$onItemClick$1$1 r1 = new com.martian.mibook.mvvm.read.fragment.ReadingBookMarkFragment$initView$3$onItemClick$1$1
            r1.<init>()
            r0.O(r1)
        L20:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.read.fragment.ReadingBookMarkFragment$initView$3.a(android.view.View, int):void");
    }

    @Override // com.martian.mibook.mvvm.read.adapter.BookMarkListAdapter.b
    @k
    public Boolean b(@l View view, int i10) {
        new AlertDialog.Builder(this.f14716a.getContext()).setTitle("书签操作").setItems(new String[]{"删除书签"}, new DialogInterface.OnClickListener() { // from class: ed.r0

            /* renamed from: c */
            public final /* synthetic */ int f25882c;

            public /* synthetic */ r0(int i102) {
                i10 = i102;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                ReadingBookMarkFragment$initView$3.d(ReadingBookMarkFragment.this, i10, dialogInterface, i11);
            }
        }).show();
        return Boolean.TRUE;
    }
}
