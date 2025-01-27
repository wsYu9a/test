package uk;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.Map;
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout;

/* loaded from: classes5.dex */
public class a {

    public static final class b {

        /* renamed from: a */
        public final Activity f31128a;

        /* renamed from: b */
        public uk.co.senab.actionbarpulltorefresh.library.b f31129b;

        /* renamed from: c */
        public int[] f31130c;

        /* renamed from: d */
        public View[] f31131d;

        /* renamed from: e */
        public vk.b f31132e;

        /* renamed from: f */
        public ViewGroup f31133f;

        /* renamed from: g */
        public HashMap<Class, xk.c> f31134g;

        public /* synthetic */ b(Activity activity, C0792a c0792a) {
            this(activity);
        }

        public static void c(ViewGroup viewGroup, PullToRefreshLayout pullToRefreshLayout) {
            View childAt = viewGroup.getChildAt(0);
            while (childAt != null) {
                viewGroup.removeViewAt(0);
                pullToRefreshLayout.addView(childAt);
                childAt = viewGroup.getChildAt(0);
            }
            viewGroup.addView(pullToRefreshLayout, -1, -1);
        }

        public b a() {
            this.f31130c = null;
            this.f31131d = null;
            return this;
        }

        public b b(ViewGroup viewGroup) {
            this.f31133f = viewGroup;
            return this;
        }

        public b d(vk.b bVar) {
            this.f31132e = bVar;
            return this;
        }

        public b e(uk.co.senab.actionbarpulltorefresh.library.b bVar) {
            this.f31129b = bVar;
            return this;
        }

        public void f(PullToRefreshLayout pullToRefreshLayout) {
            f e10 = pullToRefreshLayout.e(this.f31128a, this.f31129b);
            e10.D(this.f31132e);
            ViewGroup viewGroup = this.f31133f;
            if (viewGroup != null) {
                c(viewGroup, pullToRefreshLayout);
            }
            pullToRefreshLayout.setPullToRefreshAttacher(e10);
            int[] iArr = this.f31130c;
            if (iArr != null) {
                pullToRefreshLayout.b(iArr);
            } else {
                View[] viewArr = this.f31131d;
                if (viewArr != null) {
                    pullToRefreshLayout.c(viewArr);
                } else {
                    pullToRefreshLayout.a();
                }
            }
            HashMap<Class, xk.c> hashMap = this.f31134g;
            if (hashMap != null) {
                for (Map.Entry<Class, xk.c> entry : hashMap.entrySet()) {
                    e10.K(entry.getKey(), entry.getValue());
                }
            }
        }

        public b g(int... iArr) {
            this.f31130c = iArr;
            this.f31131d = null;
            return this;
        }

        public b h(View... viewArr) {
            this.f31131d = viewArr;
            this.f31130c = null;
            return this;
        }

        public b i(Class<?> cls, xk.c cVar) {
            if (this.f31134g == null) {
                this.f31134g = new HashMap<>();
            }
            this.f31134g.put(cls, cVar);
            return this;
        }

        public b(Activity activity) {
            this.f31128a = activity;
        }
    }

    public static b a(Activity activity) {
        return new b(activity);
    }
}
