package uk.co.senab.actionbarpulltorefresh.library.k;

import android.annotation.TargetApi;
import android.os.Build;
import android.widget.AbsListView;

/* loaded from: classes5.dex */
public class a implements c {

    /* renamed from: a */
    public static final Class[] f37187a = {AbsListView.class};

    /* renamed from: uk.co.senab.actionbarpulltorefresh.library.k.a$a */
    static class C0896a {
        C0896a() {
        }

        static int a(AbsListView absListView) {
            return 2;
        }

        static boolean b(AbsListView absListView) {
            return false;
        }
    }

    @TargetApi(11)
    static class b {
        b() {
        }

        static int a(AbsListView absListView) {
            return absListView.getVerticalScrollbarPosition();
        }

        static boolean b(AbsListView absListView) {
            return absListView.isFastScrollAlwaysVisible();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0048, code lost:
    
        if (r6 < (r5.getRight() - r5.getVerticalScrollbarWidth())) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0055, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0057, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0052, code lost:
    
        if (r6 > r5.getVerticalScrollbarWidth()) goto L66;
     */
    @Override // uk.co.senab.actionbarpulltorefresh.library.k.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(android.view.View r5, float r6, float r7) {
        /*
            r4 = this;
            android.widget.AbsListView r5 = (android.widget.AbsListView) r5
            int r7 = r5.getCount()
            r0 = 1
            r1 = 0
            if (r7 != 0) goto Lc
        La:
            r7 = 1
            goto L24
        Lc:
            int r7 = r5.getFirstVisiblePosition()
            if (r7 != 0) goto L23
            android.view.View r7 = r5.getChildAt(r1)
            if (r7 == 0) goto L23
            int r7 = r7.getTop()
            int r2 = r5.getPaddingTop()
            if (r7 < r2) goto L23
            goto La
        L23:
            r7 = 0
        L24:
            if (r7 == 0) goto L57
            boolean r2 = r5.isFastScrollEnabled()
            if (r2 == 0) goto L57
            boolean r2 = r4.c(r5)
            if (r2 == 0) goto L57
            int r2 = r4.b(r5)
            if (r2 == r0) goto L4b
            r3 = 2
            if (r2 == r3) goto L3c
            goto L57
        L3c:
            int r7 = r5.getRight()
            int r5 = r5.getVerticalScrollbarWidth()
            int r7 = r7 - r5
            float r5 = (float) r7
            int r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r5 >= 0) goto L55
            goto L56
        L4b:
            int r5 = r5.getVerticalScrollbarWidth()
            float r5 = (float) r5
            int r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r5 <= 0) goto L55
            goto L56
        L55:
            r0 = 0
        L56:
            r7 = r0
        L57:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: uk.co.senab.actionbarpulltorefresh.library.k.a.a(android.view.View, float, float):boolean");
    }

    int b(AbsListView absListView) {
        return Build.VERSION.SDK_INT >= 11 ? b.a(absListView) : C0896a.a(absListView);
    }

    boolean c(AbsListView absListView) {
        return Build.VERSION.SDK_INT >= 11 ? b.b(absListView) : C0896a.b(absListView);
    }
}
