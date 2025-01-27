package com.sigmob.sdk.base.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

/* loaded from: classes4.dex */
public class e {

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a */
        public final /* synthetic */ View f18411a;

        /* renamed from: b */
        public final /* synthetic */ Runnable f18412b;

        public a(View view, Runnable runnable) {
            this.f18411a = view;
            this.f18412b = runnable;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            View view = this.f18411a;
            if (view != null) {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            Runnable runnable = this.f18412b;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public interface b {
        boolean a(View view, MotionEvent motionEvent, MotionEvent motionEvent2);
    }

    public class c implements View.OnTouchListener {

        /* renamed from: a */
        public final b f18413a;

        /* renamed from: b */
        public MotionEvent f18414b;

        public c(b bVar) {
            this.f18413a = bVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            b bVar;
            if (motionEvent.getAction() == 0) {
                this.f18414b = motionEvent;
                return false;
            }
            if (motionEvent.getAction() != 1 || (bVar = this.f18413a) == null) {
                return false;
            }
            bVar.a(view, this.f18414b, motionEvent);
            return false;
        }
    }

    public static <T extends View> T a(ViewGroup viewGroup, Class<T> cls) {
        T t10;
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (cls.isInstance(childAt)) {
                return cls.cast(childAt);
            }
            if ((childAt instanceof ViewGroup) && (t10 = (T) a((ViewGroup) childAt, cls)) != null) {
                return t10;
            }
        }
        return null;
    }

    public static Activity b(View view) {
        View c10 = c(view);
        if (c10 != null) {
            return a(c10);
        }
        return null;
    }

    public static View c(View view) {
        View rootView;
        if (view == null || (rootView = view.getRootView()) == null) {
            return null;
        }
        View findViewById = rootView.findViewById(R.id.content);
        return findViewById != null ? findViewById : rootView;
    }

    public static boolean d(View view) {
        return view.getParent() != null && view.getVisibility() == 0 && view.isShown();
    }

    public static void e(View view) {
        if (view == null || view.getParent() == null || !(view.getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) view.getParent()).removeView(view);
    }

    public static Activity a(View view) {
        if (view == null) {
            return null;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    public static View a(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getWindow().getDecorView().findViewById(R.id.content);
        }
        return null;
    }

    public static View a(Context context, View view) {
        View a10 = a(context);
        return a10 != null ? a10 : c(view);
    }

    public static boolean a(View view, MotionEvent motionEvent) {
        if (view == null) {
            return false;
        }
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i10 = iArr[0];
        int i11 = iArr[1];
        return rawY >= i11 && rawY <= view.getMeasuredHeight() + i11 && rawX >= i10 && rawX <= view.getMeasuredWidth() + i10;
    }

    public static void a(View view, Runnable runnable) {
        if (view == null || runnable == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new a(view, runnable));
    }
}
