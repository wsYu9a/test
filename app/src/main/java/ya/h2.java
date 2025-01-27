package ya;

import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.martian.libmars.widget.recyclerview.adatper.CommonRecycleViewAdapter;

/* loaded from: classes3.dex */
public class h2 {

    /* renamed from: a */
    public b f33227a;

    /* renamed from: b */
    public RecyclerView f33228b;

    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i10) {
            if (i10 == 0 || i10 == 1 || i10 == 2) {
                h2.this.g();
            }
        }
    }

    public interface b {
        void e(int i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void j(CommonRecycleViewAdapter commonRecycleViewAdapter, int i10) {
        if (commonRecycleViewAdapter instanceof b) {
            ((b) commonRecycleViewAdapter).e(i10 - 2);
        }
    }

    public final int[] c(int[] iArr, int[] iArr2) {
        int i10 = iArr[0];
        int i11 = iArr2[0];
        for (int i12 = 1; i12 < iArr.length; i12++) {
            int i13 = iArr[i12];
            if (i10 > i13) {
                i10 = i13;
            }
        }
        for (int i14 = 1; i14 < iArr2.length; i14++) {
            int i15 = iArr2[i14];
            if (i11 < i15) {
                i11 = i15;
            }
        }
        return new int[]{i10, i11};
    }

    public final int[] d(GridLayoutManager gridLayoutManager) {
        return new int[]{gridLayoutManager.findFirstVisibleItemPosition(), gridLayoutManager.findLastVisibleItemPosition()};
    }

    public final int[] e(LinearLayoutManager linearLayoutManager) {
        return new int[]{linearLayoutManager.findFirstVisibleItemPosition(), linearLayoutManager.findLastVisibleItemPosition()};
    }

    public final int[] f(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
        int[] iArr2 = new int[staggeredGridLayoutManager.getSpanCount()];
        staggeredGridLayoutManager.findFirstVisibleItemPositions(iArr);
        staggeredGridLayoutManager.findLastVisibleItemPositions(iArr2);
        return c(iArr, iArr2);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0062 A[Catch: Exception -> 0x0043, TRY_LEAVE, TryCatch #0 {Exception -> 0x0043, blocks: (B:11:0x0021, B:13:0x002f, B:18:0x0058, B:23:0x005c, B:24:0x005e, B:26:0x0062, B:33:0x0045, B:35:0x0049), top: B:10:0x0021 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g() {
        /*
            r8 = this;
            androidx.recyclerview.widget.RecyclerView r0 = r8.f33228b
            if (r0 == 0) goto L70
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L70
            androidx.recyclerview.widget.RecyclerView r0 = r8.f33228b
            boolean r0 = r0.isShown()
            if (r0 == 0) goto L70
            androidx.recyclerview.widget.RecyclerView r0 = r8.f33228b
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            boolean r0 = r0.getGlobalVisibleRect(r1)
            if (r0 != 0) goto L20
            goto L70
        L20:
            r0 = 2
            int[] r1 = new int[r0]     // Catch: java.lang.Exception -> L43
            androidx.recyclerview.widget.RecyclerView r2 = r8.f33228b     // Catch: java.lang.Exception -> L43
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = r2.getLayoutManager()     // Catch: java.lang.Exception -> L43
            boolean r3 = r2 instanceof androidx.recyclerview.widget.LinearLayoutManager     // Catch: java.lang.Exception -> L43
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L45
            r1 = r2
            androidx.recyclerview.widget.LinearLayoutManager r1 = (androidx.recyclerview.widget.LinearLayoutManager) r1     // Catch: java.lang.Exception -> L43
            int[] r3 = r8.e(r1)     // Catch: java.lang.Exception -> L43
            int r1 = r1.getOrientation()     // Catch: java.lang.Exception -> L43
            if (r1 != r5) goto L3e
            r1 = 1
            goto L3f
        L3e:
            r1 = 0
        L3f:
            r7 = r3
            r3 = r1
            r1 = r7
            goto L56
        L43:
            r0 = move-exception
            goto L6d
        L45:
            boolean r3 = r2 instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager     // Catch: java.lang.Exception -> L43
            if (r3 == 0) goto L55
            r1 = r2
            androidx.recyclerview.widget.StaggeredGridLayoutManager r1 = (androidx.recyclerview.widget.StaggeredGridLayoutManager) r1     // Catch: java.lang.Exception -> L43
            int[] r3 = r8.f(r1)     // Catch: java.lang.Exception -> L43
            int r1 = r1.getOrientation()     // Catch: java.lang.Exception -> L43
            goto L3f
        L55:
            r3 = -1
        L56:
            if (r2 == 0) goto L6c
            int r6 = r1.length     // Catch: java.lang.Exception -> L43
            if (r6 >= r0) goto L5c
            goto L6c
        L5c:
            r0 = r1[r4]     // Catch: java.lang.Exception -> L43
        L5e:
            r4 = r1[r5]     // Catch: java.lang.Exception -> L43
            if (r0 > r4) goto L70
            android.view.View r4 = r2.findViewByPosition(r0)     // Catch: java.lang.Exception -> L43
            r8.l(r4, r0, r3)     // Catch: java.lang.Exception -> L43
            int r0 = r0 + 1
            goto L5e
        L6c:
            return
        L6d:
            r0.printStackTrace()
        L70:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ya.h2.g():void");
    }

    public void h(RecyclerView recyclerView, CommonRecycleViewAdapter<?> commonRecycleViewAdapter) {
        new Handler().post(new Runnable() { // from class: ya.g2

            /* renamed from: c */
            public final /* synthetic */ RecyclerView f33219c;

            /* renamed from: d */
            public final /* synthetic */ CommonRecycleViewAdapter f33220d;

            public /* synthetic */ g2(RecyclerView recyclerView2, CommonRecycleViewAdapter commonRecycleViewAdapter2) {
                recyclerView = recyclerView2;
                commonRecycleViewAdapter = commonRecycleViewAdapter2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                h2.this.k(recyclerView, commonRecycleViewAdapter);
            }
        });
    }

    public boolean i() {
        return this.f33227a != null;
    }

    public final /* synthetic */ void k(RecyclerView recyclerView, CommonRecycleViewAdapter commonRecycleViewAdapter) {
        if (i()) {
            g();
        } else {
            if (recyclerView == null || commonRecycleViewAdapter == null) {
                return;
            }
            m(recyclerView, new b() { // from class: ya.f2
                public /* synthetic */ f2() {
                }

                @Override // ya.h2.b
                public final void e(int i10) {
                    h2.j(CommonRecycleViewAdapter.this, i10);
                }
            });
        }
    }

    public final void l(View view, int i10, int i11) {
        if (view != null && view.getVisibility() == 0 && view.isShown() && view.getGlobalVisibleRect(new Rect())) {
            Rect rect = new Rect();
            boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
            boolean z10 = (i11 == 1 && rect.height() > view.getMeasuredHeight() / 2) || (i11 == 0 && rect.width() > view.getMeasuredWidth() / 2);
            if (globalVisibleRect && z10) {
                this.f33227a.e(i10);
            }
        }
    }

    public void m(RecyclerView recyclerView, b bVar) {
        this.f33227a = bVar;
        this.f33228b = recyclerView;
        if (recyclerView == null || recyclerView.getVisibility() != 0) {
            return;
        }
        this.f33228b.addOnScrollListener(new a());
        g();
    }
}
