package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ViewPropertyAnimatorCompatSet {

    /* renamed from: c */
    private Interpolator f442c;

    /* renamed from: d */
    ViewPropertyAnimatorListener f443d;

    /* renamed from: e */
    private boolean f444e;

    /* renamed from: b */
    private long f441b = -1;

    /* renamed from: f */
    private final ViewPropertyAnimatorListenerAdapter f445f = new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.view.ViewPropertyAnimatorCompatSet.1

        /* renamed from: a */
        private boolean f446a = false;

        /* renamed from: b */
        private int f447b = 0;

        AnonymousClass1() {
        }

        void a() {
            this.f447b = 0;
            this.f446a = false;
            ViewPropertyAnimatorCompatSet.this.a();
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            int i2 = this.f447b + 1;
            this.f447b = i2;
            if (i2 == ViewPropertyAnimatorCompatSet.this.f440a.size()) {
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = ViewPropertyAnimatorCompatSet.this.f443d;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationEnd(null);
                }
                a();
            }
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            if (this.f446a) {
                return;
            }
            this.f446a = true;
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = ViewPropertyAnimatorCompatSet.this.f443d;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationStart(null);
            }
        }
    };

    /* renamed from: a */
    final ArrayList<ViewPropertyAnimatorCompat> f440a = new ArrayList<>();

    /* renamed from: androidx.appcompat.view.ViewPropertyAnimatorCompatSet$1 */
    class AnonymousClass1 extends ViewPropertyAnimatorListenerAdapter {

        /* renamed from: a */
        private boolean f446a = false;

        /* renamed from: b */
        private int f447b = 0;

        AnonymousClass1() {
        }

        void a() {
            this.f447b = 0;
            this.f446a = false;
            ViewPropertyAnimatorCompatSet.this.a();
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            int i2 = this.f447b + 1;
            this.f447b = i2;
            if (i2 == ViewPropertyAnimatorCompatSet.this.f440a.size()) {
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = ViewPropertyAnimatorCompatSet.this.f443d;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationEnd(null);
                }
                a();
            }
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            if (this.f446a) {
                return;
            }
            this.f446a = true;
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = ViewPropertyAnimatorCompatSet.this.f443d;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationStart(null);
            }
        }
    }

    void a() {
        this.f444e = false;
    }

    public void cancel() {
        if (this.f444e) {
            Iterator<ViewPropertyAnimatorCompat> it = this.f440a.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
            this.f444e = false;
        }
    }

    public ViewPropertyAnimatorCompatSet play(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        if (!this.f444e) {
            this.f440a.add(viewPropertyAnimatorCompat);
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet playSequentially(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2) {
        this.f440a.add(viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompat2.setStartDelay(viewPropertyAnimatorCompat.getDuration());
        this.f440a.add(viewPropertyAnimatorCompat2);
        return this;
    }

    public ViewPropertyAnimatorCompatSet setDuration(long j2) {
        if (!this.f444e) {
            this.f441b = j2;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet setInterpolator(Interpolator interpolator) {
        if (!this.f444e) {
            this.f442c = interpolator;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (!this.f444e) {
            this.f443d = viewPropertyAnimatorListener;
        }
        return this;
    }

    public void start() {
        if (this.f444e) {
            return;
        }
        Iterator<ViewPropertyAnimatorCompat> it = this.f440a.iterator();
        while (it.hasNext()) {
            ViewPropertyAnimatorCompat next = it.next();
            long j2 = this.f441b;
            if (j2 >= 0) {
                next.setDuration(j2);
            }
            Interpolator interpolator = this.f442c;
            if (interpolator != null) {
                next.setInterpolator(interpolator);
            }
            if (this.f443d != null) {
                next.setListener(this.f445f);
            }
            next.start();
        }
        this.f444e = true;
    }
}
