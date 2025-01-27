package com.martian.mibook.mvvm.utils;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.martian.mibook.mvvm.utils.RecyclerViewExposeManager;
import com.martian.mibook.mvvm.utils.RecyclerViewExposeManager$onScrollListener$2;
import id.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Job;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0006\u0018\u00002\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J\u0012\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0002J\u001a\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0016J\u0012\u0010\u001c\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\"\u0010\u001f\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0002J\"\u0010%\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010&\u001a\u00020\u0004J\u0018\u0010%\u001a\u00020\u00162\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010&\u001a\u00020\u0004J\u000e\u0010'\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0010R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager;", "", "()V", "itemOnExposeListener", "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager$OnItemExposeListener;", "onScrollListener", "com/martian/mibook/mvvm/utils/RecyclerViewExposeManager$onScrollListener$2$1", "getOnScrollListener", "()Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager$onScrollListener$2$1;", "onScrollListener$delegate", "Lkotlin/Lazy;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "scrollJob", "Lkotlinx/coroutines/Job;", "threshold", "", "findRange", "", "startPos", "endPos", "handleCurrentVisibleItems", "", "isInvalidate", "", "delayMillis", "", "removeRecyclerItemExposeListener", "resetScrollTimer", "nestedScrollView", "Landroidx/core/widget/NestedScrollView;", "setCallbackForLogicVisibleView", "view", "Landroid/view/View;", c.f26972i, "", "orientation", "setRecyclerItemExposeListener", "onExposeListener", "setThreshold", "OnItemExposeListener", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRecyclerViewExposeManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecyclerViewExposeManager.kt\ncom/martian/mibook/mvvm/utils/RecyclerViewExposeManager\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,205:1\n260#2:206\n*S KotlinDebug\n*F\n+ 1 RecyclerViewExposeManager.kt\ncom/martian/mibook/mvvm/utils/RecyclerViewExposeManager\n*L\n118#1:206\n*E\n"})
/* loaded from: classes3.dex */
public final class RecyclerViewExposeManager {

    @l
    private OnItemExposeListener itemOnExposeListener;

    @l
    private RecyclerView recyclerView;

    @l
    private Job scrollJob;
    private float threshold = 0.8f;

    /* renamed from: onScrollListener$delegate, reason: from kotlin metadata */
    @k
    private final Lazy onScrollListener = LazyKt.lazy(new Function0<RecyclerViewExposeManager$onScrollListener$2.AnonymousClass1>() { // from class: com.martian.mibook.mvvm.utils.RecyclerViewExposeManager$onScrollListener$2

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/martian/mibook/mvvm/utils/RecyclerViewExposeManager$onScrollListener$2$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* renamed from: com.martian.mibook.mvvm.utils.RecyclerViewExposeManager$onScrollListener$2$1 */
        public static final class AnonymousClass1 extends RecyclerView.OnScrollListener {
            public AnonymousClass1() {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@k RecyclerView recyclerView, int newState) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                if (newState == 0 || newState == 1 || newState == 2) {
                    RecyclerViewExposeManager.handleCurrentVisibleItems$default(RecyclerViewExposeManager.this, false, 1, null);
                }
            }
        }

        public RecyclerViewExposeManager$onScrollListener$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @k
        public final AnonymousClass1 invoke() {
            return new RecyclerView.OnScrollListener() { // from class: com.martian.mibook.mvvm.utils.RecyclerViewExposeManager$onScrollListener$2.1
                public AnonymousClass1() {
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(@k RecyclerView recyclerView, int newState) {
                    Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                    if (newState == 0 || newState == 1 || newState == 2) {
                        RecyclerViewExposeManager.handleCurrentVisibleItems$default(RecyclerViewExposeManager.this, false, 1, null);
                    }
                }
            };
        }
    });

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager$OnItemExposeListener;", "", "onItemViewVisible", "", c.f26972i, "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnItemExposeListener {
        void onItemViewVisible(int r12, @l RecyclerView recyclerView);
    }

    private final int[] findRange(int[] startPos, int[] endPos) {
        int i10 = startPos[0];
        int i11 = endPos[0];
        int length = startPos.length;
        for (int i12 = 1; i12 < length; i12++) {
            int i13 = startPos[i12];
            if (i10 > i13) {
                i10 = i13;
            }
        }
        int length2 = endPos.length;
        for (int i14 = 1; i14 < length2; i14++) {
            int i15 = endPos[i14];
            if (i11 < i15) {
                i11 = i15;
            }
        }
        return new int[]{i10, i11};
    }

    private final RecyclerViewExposeManager$onScrollListener$2.AnonymousClass1 getOnScrollListener() {
        return (RecyclerViewExposeManager$onScrollListener$2.AnonymousClass1) this.onScrollListener.getValue();
    }

    public static /* synthetic */ void handleCurrentVisibleItems$default(RecyclerViewExposeManager recyclerViewExposeManager, boolean z10, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            j10 = 500;
        }
        recyclerViewExposeManager.handleCurrentVisibleItems(z10, j10);
    }

    public static final void handleCurrentVisibleItems$lambda$2(RecyclerViewExposeManager this$0, boolean z10) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleCurrentVisibleItems(z10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
    
        r9 = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r2, null, null, new com.martian.mibook.mvvm.utils.RecyclerViewExposeManager$resetScrollTimer$1(r8, null), 3, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void resetScrollTimer(androidx.core.widget.NestedScrollView r9) {
        /*
            r8 = this;
            kotlinx.coroutines.Job r0 = r8.scrollJob
            r1 = 0
            if (r0 == 0) goto L9
            r2 = 1
            kotlinx.coroutines.Job.DefaultImpls.cancel$default(r0, r1, r2, r1)
        L9:
            if (r9 == 0) goto L10
            android.content.Context r9 = r9.getContext()
            goto L11
        L10:
            r9 = r1
        L11:
            boolean r0 = r9 instanceof androidx.fragment.app.FragmentActivity
            if (r0 == 0) goto L18
            androidx.fragment.app.FragmentActivity r9 = (androidx.fragment.app.FragmentActivity) r9
            goto L19
        L18:
            r9 = r1
        L19:
            if (r9 == 0) goto L32
            androidx.lifecycle.LifecycleCoroutineScope r2 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r9)
            if (r2 == 0) goto L32
            com.martian.mibook.mvvm.utils.RecyclerViewExposeManager$resetScrollTimer$1 r5 = new com.martian.mibook.mvvm.utils.RecyclerViewExposeManager$resetScrollTimer$1
            r5.<init>(r8, r1)
            r6 = 3
            r7 = 0
            r3 = 0
            r4 = 0
            kotlinx.coroutines.Job r9 = kotlinx.coroutines.BuildersKt.launch$default(r2, r3, r4, r5, r6, r7)
            if (r9 == 0) goto L32
            r8.scrollJob = r9
        L32:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.utils.RecyclerViewExposeManager.resetScrollTimer(androidx.core.widget.NestedScrollView):void");
    }

    private final void setCallbackForLogicVisibleView(View view, int r11, int orientation) {
        Rect rect;
        boolean globalVisibleRect;
        if (view != null && view.getVisibility() == 0 && view.isShown() && (globalVisibleRect = view.getGlobalVisibleRect((rect = new Rect())))) {
            view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.martian.mibook.mvvm.utils.RecyclerViewExposeManager$setCallbackForLogicVisibleView$1$1
                final /* synthetic */ boolean $globalRect;
                final /* synthetic */ int $orientation;
                final /* synthetic */ int $position;
                final /* synthetic */ Rect $rect;
                final /* synthetic */ View $this_apply;
                final /* synthetic */ RecyclerViewExposeManager this$0;

                public RecyclerViewExposeManager$setCallbackForLogicVisibleView$1$1(View view2, Rect rect2, RecyclerViewExposeManager this, int orientation2, boolean globalVisibleRect2, int r112) {
                    view = view2;
                    rect = rect2;
                    this = this;
                    orientation = orientation2;
                    globalVisibleRect = globalVisibleRect2;
                    position = r112;
                }

                /* JADX WARN: Code restructure failed: missing block: B:15:0x0056, code lost:
                
                    r0 = r3.itemOnExposeListener;
                 */
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public boolean onPreDraw() {
                    /*
                        r7 = this;
                        android.view.View r0 = r1
                        android.view.ViewTreeObserver r0 = r0.getViewTreeObserver()
                        r0.removeOnPreDrawListener(r7)
                        android.graphics.Rect r0 = r2
                        int r0 = r0.height()
                        android.graphics.Rect r1 = r2
                        int r1 = r1.width()
                        android.view.View r2 = r1
                        int r2 = r2.getMeasuredHeight()
                        float r2 = (float) r2
                        com.martian.mibook.mvvm.utils.RecyclerViewExposeManager r3 = r3
                        float r3 = com.martian.mibook.mvvm.utils.RecyclerViewExposeManager.access$getThreshold$p(r3)
                        float r2 = r2 * r3
                        android.view.View r3 = r1
                        int r3 = r3.getMeasuredWidth()
                        float r3 = (float) r3
                        com.martian.mibook.mvvm.utils.RecyclerViewExposeManager r4 = r3
                        float r4 = com.martian.mibook.mvvm.utils.RecyclerViewExposeManager.access$getThreshold$p(r4)
                        float r3 = r3 * r4
                        int r4 = r4
                        r5 = 0
                        r6 = 1
                        if (r4 != r6) goto L40
                        float r0 = (float) r0
                        int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                        if (r0 < 0) goto L40
                        r0 = 1
                        goto L41
                    L40:
                        r0 = 0
                    L41:
                        if (r4 != 0) goto L4a
                        float r1 = (float) r1
                        int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                        if (r1 < 0) goto L4a
                        r1 = 1
                        goto L4b
                    L4a:
                        r1 = 0
                    L4b:
                        if (r0 != 0) goto L4f
                        if (r1 == 0) goto L50
                    L4f:
                        r5 = 1
                    L50:
                        boolean r0 = r5
                        if (r0 == 0) goto L69
                        if (r5 == 0) goto L69
                        com.martian.mibook.mvvm.utils.RecyclerViewExposeManager r0 = r3
                        com.martian.mibook.mvvm.utils.RecyclerViewExposeManager$OnItemExposeListener r0 = com.martian.mibook.mvvm.utils.RecyclerViewExposeManager.access$getItemOnExposeListener$p(r0)
                        if (r0 == 0) goto L69
                        int r1 = r6
                        com.martian.mibook.mvvm.utils.RecyclerViewExposeManager r2 = r3
                        androidx.recyclerview.widget.RecyclerView r2 = com.martian.mibook.mvvm.utils.RecyclerViewExposeManager.access$getRecyclerView$p(r2)
                        r0.onItemViewVisible(r1, r2)
                    L69:
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.utils.RecyclerViewExposeManager$setCallbackForLogicVisibleView$1$1.onPreDraw():boolean");
                }
            });
        }
    }

    public static final void setRecyclerItemExposeListener$lambda$0(RecyclerViewExposeManager this$0, NestedScrollView nestedScrollView, View view, int i10, int i11, int i12, int i13) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.resetScrollTimer(nestedScrollView);
    }

    public final void handleCurrentVisibleItems(boolean isInvalidate, long delayMillis) {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            recyclerView.postDelayed(new Runnable() { // from class: qd.b

                /* renamed from: c */
                public final /* synthetic */ boolean f30003c;

                public /* synthetic */ b(boolean isInvalidate2) {
                    isInvalidate = isInvalidate2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    RecyclerViewExposeManager.handleCurrentVisibleItems$lambda$2(RecyclerViewExposeManager.this, isInvalidate);
                }
            }, delayMillis);
        }
    }

    public final void removeRecyclerItemExposeListener() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            recyclerView.removeOnScrollListener(getOnScrollListener());
        }
        this.itemOnExposeListener = null;
        this.recyclerView = null;
    }

    public final void setRecyclerItemExposeListener(@l RecyclerView recyclerView, @k OnItemExposeListener onExposeListener) {
        Intrinsics.checkNotNullParameter(onExposeListener, "onExposeListener");
        if (recyclerView == null || recyclerView.getVisibility() != 0) {
            return;
        }
        this.recyclerView = recyclerView;
        this.itemOnExposeListener = onExposeListener;
        recyclerView.addOnScrollListener(getOnScrollListener());
        handleCurrentVisibleItems$default(this, false, 1, null);
    }

    public final void setThreshold(float threshold) {
        if (threshold > 1.0f) {
            threshold = 1.0f;
        } else if (threshold < 0.0f) {
            threshold = 0.0f;
        }
        this.threshold = threshold;
    }

    private final void handleCurrentVisibleItems(boolean isInvalidate) {
        int i10;
        int i11;
        int i12;
        RecyclerView recyclerView;
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null || !ViewCompat.isAttachedToWindow(recyclerView2) || recyclerView2.getVisibility() != 0 || recyclerView2.getChildCount() <= 0) {
            return;
        }
        if (isInvalidate && (recyclerView = this.recyclerView) != null) {
            recyclerView.invalidate();
        }
        try {
            int[] iArr = new int[2];
            RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                iArr[0] = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                iArr[1] = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                i10 = ((LinearLayoutManager) layoutManager).getOrientation();
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                int[] iArr2 = new int[((StaggeredGridLayoutManager) layoutManager).getSpanCount()];
                int[] iArr3 = new int[((StaggeredGridLayoutManager) layoutManager).getSpanCount()];
                ((StaggeredGridLayoutManager) layoutManager).findFirstVisibleItemPositions(iArr2);
                ((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(iArr3);
                int[] findRange = findRange(iArr2, iArr3);
                iArr[0] = findRange[0];
                iArr[1] = findRange[1];
                i10 = ((StaggeredGridLayoutManager) layoutManager).getOrientation();
            } else {
                i10 = -1;
            }
            if (layoutManager == null || (i11 = iArr[0]) > (i12 = iArr[1])) {
                return;
            }
            while (true) {
                setCallbackForLogicVisibleView(layoutManager.findViewByPosition(i11), i11, i10);
                if (i11 == i12) {
                    return;
                } else {
                    i11++;
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static /* synthetic */ void handleCurrentVisibleItems$default(RecyclerViewExposeManager recyclerViewExposeManager, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        recyclerViewExposeManager.handleCurrentVisibleItems(z10);
    }

    public final void setRecyclerItemExposeListener(@l NestedScrollView nestedScrollView, @l RecyclerView recyclerView, @k OnItemExposeListener onExposeListener) {
        Intrinsics.checkNotNullParameter(onExposeListener, "onExposeListener");
        if (recyclerView == null || recyclerView.getVisibility() != 0) {
            return;
        }
        this.recyclerView = recyclerView;
        this.itemOnExposeListener = onExposeListener;
        if (Build.VERSION.SDK_INT < 23) {
            recyclerView.addOnScrollListener(getOnScrollListener());
        } else if (nestedScrollView != null) {
            nestedScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: qd.a

                /* renamed from: b */
                public final /* synthetic */ NestedScrollView f30001b;

                public /* synthetic */ a(NestedScrollView nestedScrollView2) {
                    nestedScrollView = nestedScrollView2;
                }

                @Override // android.view.View.OnScrollChangeListener
                public final void onScrollChange(View view, int i10, int i11, int i12, int i13) {
                    RecyclerViewExposeManager.setRecyclerItemExposeListener$lambda$0(RecyclerViewExposeManager.this, nestedScrollView, view, i10, i11, i12, i13);
                }
            });
        }
        handleCurrentVisibleItems$default(this, false, 1, null);
    }
}
