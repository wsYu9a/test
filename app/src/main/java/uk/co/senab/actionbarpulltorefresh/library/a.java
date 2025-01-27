package uk.co.senab.actionbarpulltorefresh.library;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class a {

    public static final class b {

        /* renamed from: a */
        private final Activity f37132a;

        /* renamed from: b */
        private g f37133b;

        /* renamed from: c */
        private int[] f37134c;

        /* renamed from: d */
        private View[] f37135d;

        /* renamed from: e */
        private uk.co.senab.actionbarpulltorefresh.library.i.b f37136e;

        /* renamed from: f */
        private ViewGroup f37137f;

        /* renamed from: g */
        private HashMap<Class, uk.co.senab.actionbarpulltorefresh.library.k.c> f37138g;

        /* synthetic */ b(Activity activity, C0895a c0895a) {
            this(activity);
        }

        private static void c(ViewGroup viewGroup, PullToRefreshLayout pullToRefreshLayout) {
            View childAt = viewGroup.getChildAt(0);
            while (childAt != null) {
                viewGroup.removeViewAt(0);
                pullToRefreshLayout.addView(childAt);
                childAt = viewGroup.getChildAt(0);
            }
            viewGroup.addView(pullToRefreshLayout, -1, -1);
        }

        public b a() {
            this.f37134c = null;
            this.f37135d = null;
            return this;
        }

        public b b(ViewGroup viewGroup) {
            this.f37137f = viewGroup;
            return this;
        }

        public b d(uk.co.senab.actionbarpulltorefresh.library.i.b bVar) {
            this.f37136e = bVar;
            return this;
        }

        public b e(g gVar) {
            this.f37133b = gVar;
            return this;
        }

        public void f(PullToRefreshLayout pullToRefreshLayout) {
            h e2 = pullToRefreshLayout.e(this.f37132a, this.f37133b);
            e2.D(this.f37136e);
            ViewGroup viewGroup = this.f37137f;
            if (viewGroup != null) {
                c(viewGroup, pullToRefreshLayout);
            }
            pullToRefreshLayout.setPullToRefreshAttacher(e2);
            int[] iArr = this.f37134c;
            if (iArr != null) {
                pullToRefreshLayout.b(iArr);
            } else {
                View[] viewArr = this.f37135d;
                if (viewArr != null) {
                    pullToRefreshLayout.c(viewArr);
                } else {
                    pullToRefreshLayout.a();
                }
            }
            HashMap<Class, uk.co.senab.actionbarpulltorefresh.library.k.c> hashMap = this.f37138g;
            if (hashMap != null) {
                for (Map.Entry<Class, uk.co.senab.actionbarpulltorefresh.library.k.c> entry : hashMap.entrySet()) {
                    e2.K(entry.getKey(), entry.getValue());
                }
            }
        }

        public b g(int... iArr) {
            this.f37134c = iArr;
            this.f37135d = null;
            return this;
        }

        public b h(View... viewArr) {
            this.f37135d = viewArr;
            this.f37134c = null;
            return this;
        }

        public b i(Class<?> cls, uk.co.senab.actionbarpulltorefresh.library.k.c cVar) {
            if (this.f37138g == null) {
                this.f37138g = new HashMap<>();
            }
            this.f37138g.put(cls, cVar);
            return this;
        }

        private b(Activity activity) {
            this.f37132a = activity;
        }
    }

    public static b a(Activity activity) {
        return new b(activity);
    }
}
