package com.martian.mibook.application;

import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* loaded from: classes3.dex */
public class u0 {

    /* renamed from: a */
    private b f11593a;

    /* renamed from: b */
    private RecyclerView f11594b;

    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            if (newState == 0 || newState == 1 || newState == 2) {
                u0.this.e();
            }
        }
    }

    public interface b {
        void j(int position);
    }

    private int[] a(int[] startPos, int[] endPos) {
        int i2 = startPos[0];
        int i3 = endPos[0];
        for (int i4 = 1; i4 < startPos.length; i4++) {
            if (i2 > startPos[i4]) {
                i2 = startPos[i4];
            }
        }
        for (int i5 = 1; i5 < endPos.length; i5++) {
            if (i3 < endPos[i5]) {
                i3 = endPos[i5];
            }
        }
        return new int[]{i2, i3};
    }

    private int[] b(GridLayoutManager manager) {
        return new int[]{manager.findFirstVisibleItemPosition(), manager.findLastVisibleItemPosition()};
    }

    private int[] c(LinearLayoutManager manager) {
        return new int[]{manager.findFirstVisibleItemPosition(), manager.findLastVisibleItemPosition()};
    }

    private int[] d(StaggeredGridLayoutManager manager) {
        int[] iArr = new int[manager.getSpanCount()];
        int[] iArr2 = new int[manager.getSpanCount()];
        manager.findFirstVisibleItemPositions(iArr);
        manager.findLastVisibleItemPositions(iArr2);
        return a(iArr, iArr2);
    }

    /* renamed from: h */
    public /* synthetic */ void i(final RecyclerView irc, final com.martian.libmars.widget.recyclerview.e.c adapter) {
        if (g()) {
            e();
        } else {
            if (irc == null || adapter == null) {
                return;
            }
            l(irc, new b() { // from class: com.martian.mibook.application.d0
                @Override // com.martian.mibook.application.u0.b
                public final void j(int i2) {
                    u0.j(com.martian.libmars.widget.recyclerview.e.c.this, i2);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void j(final com.martian.libmars.widget.recyclerview.e.c adapter, int position) {
        if (adapter instanceof b) {
            ((b) adapter).j(position - 2);
        }
    }

    private void k(View view, int position, int orientation) {
        if (view != null && view.getVisibility() == 0 && view.isShown() && view.getGlobalVisibleRect(new Rect())) {
            Rect rect = new Rect();
            boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
            boolean z = (orientation == 1 && rect.height() > view.getMeasuredHeight() / 2) || (orientation == 0 && rect.width() > view.getMeasuredWidth() / 2);
            if (globalVisibleRect && z) {
                this.f11593a.j(position);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005f A[Catch: Exception -> 0x006a, TRY_LEAVE, TryCatch #0 {Exception -> 0x006a, blocks: (B:11:0x0021, B:13:0x0030, B:18:0x0055, B:23:0x0059, B:24:0x005b, B:26:0x005f, B:33:0x0041, B:35:0x0045), top: B:10:0x0021 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e() {
        /*
            r8 = this;
            androidx.recyclerview.widget.RecyclerView r0 = r8.f11594b
            if (r0 == 0) goto L75
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L75
            androidx.recyclerview.widget.RecyclerView r0 = r8.f11594b
            boolean r0 = r0.isShown()
            if (r0 == 0) goto L75
            androidx.recyclerview.widget.RecyclerView r0 = r8.f11594b
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            boolean r0 = r0.getGlobalVisibleRect(r1)
            if (r0 != 0) goto L20
            goto L75
        L20:
            r0 = 2
            int[] r1 = new int[r0]     // Catch: java.lang.Exception -> L6a
            r2 = -1
            androidx.recyclerview.widget.RecyclerView r3 = r8.f11594b     // Catch: java.lang.Exception -> L6a
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = r3.getLayoutManager()     // Catch: java.lang.Exception -> L6a
            boolean r4 = r3 instanceof androidx.recyclerview.widget.LinearLayoutManager     // Catch: java.lang.Exception -> L6a
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L41
            r1 = r3
            androidx.recyclerview.widget.LinearLayoutManager r1 = (androidx.recyclerview.widget.LinearLayoutManager) r1     // Catch: java.lang.Exception -> L6a
            int[] r2 = r8.c(r1)     // Catch: java.lang.Exception -> L6a
            int r1 = r1.getOrientation()     // Catch: java.lang.Exception -> L6a
            if (r1 != r6) goto L3f
            r1 = 1
            goto L50
        L3f:
            r1 = 0
            goto L50
        L41:
            boolean r4 = r3 instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager     // Catch: java.lang.Exception -> L6a
            if (r4 == 0) goto L53
            r1 = r3
            androidx.recyclerview.widget.StaggeredGridLayoutManager r1 = (androidx.recyclerview.widget.StaggeredGridLayoutManager) r1     // Catch: java.lang.Exception -> L6a
            int[] r2 = r8.d(r1)     // Catch: java.lang.Exception -> L6a
            int r1 = r1.getOrientation()     // Catch: java.lang.Exception -> L6a
        L50:
            r7 = r2
            r2 = r1
            r1 = r7
        L53:
            if (r3 == 0) goto L69
            int r4 = r1.length     // Catch: java.lang.Exception -> L6a
            if (r4 >= r0) goto L59
            goto L69
        L59:
            r0 = r1[r5]     // Catch: java.lang.Exception -> L6a
        L5b:
            r4 = r1[r6]     // Catch: java.lang.Exception -> L6a
            if (r0 > r4) goto L75
            android.view.View r4 = r3.findViewByPosition(r0)     // Catch: java.lang.Exception -> L6a
            r8.k(r4, r0, r2)     // Catch: java.lang.Exception -> L6a
            int r0 = r0 + 1
            goto L5b
        L69:
            return
        L6a:
            r0 = move-exception
            r0.printStackTrace()
            java.lang.String r0 = r0.getMessage()
            com.martian.libmars.utils.q0.e(r0)
        L75:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.application.u0.e():void");
    }

    public void f(final RecyclerView irc, final com.martian.libmars.widget.recyclerview.e.c<?> adapter) {
        new Handler().post(new Runnable() { // from class: com.martian.mibook.application.e0
            @Override // java.lang.Runnable
            public final void run() {
                u0.this.i(irc, adapter);
            }
        });
    }

    public boolean g() {
        return this.f11593a != null;
    }

    public void l(RecyclerView recyclerView, b onExposeListener) {
        this.f11593a = onExposeListener;
        this.f11594b = recyclerView;
        if (recyclerView == null || recyclerView.getVisibility() != 0) {
            return;
        }
        this.f11594b.addOnScrollListener(new a());
        e();
    }
}
