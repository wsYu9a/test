package com.google.android.material.m.w;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.transition.Transition;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import com.google.android.material.R;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

@RequiresApi(21)
/* loaded from: classes.dex */
public class m extends SharedElementCallback {

    /* renamed from: a */
    @Nullable
    private static WeakReference<View> f7656a;

    /* renamed from: e */
    @Nullable
    private Rect f7660e;

    /* renamed from: b */
    private boolean f7657b = true;

    /* renamed from: c */
    private boolean f7658c = true;

    /* renamed from: d */
    private boolean f7659d = false;

    /* renamed from: f */
    @Nullable
    private d f7661f = new e();

    class a extends u {

        /* renamed from: a */
        final /* synthetic */ Window f7662a;

        a(Window window) {
            this.f7662a = window;
        }

        @Override // com.google.android.material.m.w.u, android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            m.i(this.f7662a);
        }

        @Override // com.google.android.material.m.w.u, android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            m.h(this.f7662a);
        }
    }

    class b extends u {

        /* renamed from: a */
        final /* synthetic */ Activity f7664a;

        b(Activity activity) {
            this.f7664a = activity;
        }

        @Override // com.google.android.material.m.w.u, android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            View view;
            if (m.f7656a != null && (view = (View) m.f7656a.get()) != null) {
                view.setAlpha(1.0f);
                WeakReference unused = m.f7656a = null;
            }
            this.f7664a.finish();
            this.f7664a.overridePendingTransition(0, 0);
        }
    }

    class c extends u {

        /* renamed from: a */
        final /* synthetic */ Window f7666a;

        c(Window window) {
            this.f7666a = window;
        }

        @Override // com.google.android.material.m.w.u, android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            m.h(this.f7666a);
        }
    }

    public interface d {
        @Nullable
        com.google.android.material.j.o a(@NonNull View view);
    }

    public static class e implements d {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.m.w.m.d
        @Nullable
        public com.google.android.material.j.o a(@NonNull View view) {
            if (view instanceof com.google.android.material.j.s) {
                return ((com.google.android.material.j.s) view).getShapeAppearanceModel();
            }
            return null;
        }
    }

    public static void h(Window window) {
        window.getDecorView().getBackground().mutate().setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(0, BlendModeCompat.CLEAR));
    }

    public static void i(Window window) {
        window.getDecorView().getBackground().mutate().clearColorFilter();
    }

    private void m(Window window) {
        Transition sharedElementEnterTransition = window.getSharedElementEnterTransition();
        if (sharedElementEnterTransition instanceof l) {
            l lVar = (l) sharedElementEnterTransition;
            if (!this.f7659d) {
                window.setSharedElementReenterTransition(null);
            }
            if (this.f7658c) {
                o(window, lVar);
                lVar.addListener(new a(window));
            }
        }
    }

    private void n(Activity activity, Window window) {
        Transition sharedElementReturnTransition = window.getSharedElementReturnTransition();
        if (sharedElementReturnTransition instanceof l) {
            l lVar = (l) sharedElementReturnTransition;
            lVar.U(true);
            lVar.addListener(new b(activity));
            if (this.f7658c) {
                o(window, lVar);
                lVar.addListener(new c(window));
            }
        }
    }

    private static void o(Window window, l lVar) {
        window.setTransitionBackgroundFadeDuration(lVar.getDuration());
    }

    @Nullable
    public d e() {
        return this.f7661f;
    }

    public boolean f() {
        return this.f7659d;
    }

    public boolean g() {
        return this.f7658c;
    }

    public void j(@Nullable d dVar) {
        this.f7661f = dVar;
    }

    public void k(boolean z) {
        this.f7659d = z;
    }

    public void l(boolean z) {
        this.f7658c = z;
    }

    @Override // android.app.SharedElementCallback
    @Nullable
    public Parcelable onCaptureSharedElementSnapshot(@NonNull View view, @NonNull Matrix matrix, @NonNull RectF rectF) {
        f7656a = new WeakReference<>(view);
        return super.onCaptureSharedElementSnapshot(view, matrix, rectF);
    }

    @Override // android.app.SharedElementCallback
    @Nullable
    public View onCreateSnapshotView(@NonNull Context context, @Nullable Parcelable parcelable) {
        WeakReference<View> weakReference;
        View view;
        com.google.android.material.j.o a2;
        View onCreateSnapshotView = super.onCreateSnapshotView(context, parcelable);
        if (onCreateSnapshotView != null && (weakReference = f7656a) != null && this.f7661f != null && (view = weakReference.get()) != null && (a2 = this.f7661f.a(view)) != null) {
            onCreateSnapshotView.setTag(R.id.mtrl_motion_snapshot_view, a2);
        }
        return onCreateSnapshotView;
    }

    @Override // android.app.SharedElementCallback
    public void onMapSharedElements(@NonNull List<String> list, @NonNull Map<String, View> map) {
        View view;
        Activity activity;
        if (list.isEmpty() || map.isEmpty() || (view = map.get(list.get(0))) == null || (activity = com.google.android.material.internal.b.getActivity(view.getContext())) == null) {
            return;
        }
        Window window = activity.getWindow();
        if (this.f7657b) {
            m(window);
        } else {
            n(activity, window);
        }
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementEnd(@NonNull List<String> list, @NonNull List<View> list2, @NonNull List<View> list3) {
        if (!list2.isEmpty()) {
            View view = list2.get(0);
            int i2 = R.id.mtrl_motion_snapshot_view;
            if (view.getTag(i2) instanceof View) {
                list2.get(0).setTag(i2, null);
            }
        }
        if (!this.f7657b && !list2.isEmpty()) {
            this.f7660e = v.i(list2.get(0));
        }
        this.f7657b = false;
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementStart(@NonNull List<String> list, @NonNull List<View> list2, @NonNull List<View> list3) {
        if (!list2.isEmpty() && !list3.isEmpty()) {
            list2.get(0).setTag(R.id.mtrl_motion_snapshot_view, list3.get(0));
        }
        if (this.f7657b || list2.isEmpty() || this.f7660e == null) {
            return;
        }
        View view = list2.get(0);
        view.measure(View.MeasureSpec.makeMeasureSpec(this.f7660e.width(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f7660e.height(), 1073741824));
        Rect rect = this.f7660e;
        view.layout(rect.left, rect.top, rect.right, rect.bottom);
    }
}
