package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* loaded from: classes.dex */
public class BottomSheetDialog extends AppCompatDialog {

    /* renamed from: c */
    private BottomSheetBehavior<FrameLayout> f6859c;

    /* renamed from: d */
    private FrameLayout f6860d;

    /* renamed from: e */
    boolean f6861e;

    /* renamed from: f */
    boolean f6862f;

    /* renamed from: g */
    private boolean f6863g;

    /* renamed from: h */
    private boolean f6864h;

    /* renamed from: i */
    @NonNull
    private BottomSheetBehavior.f f6865i;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
            if (bottomSheetDialog.f6862f && bottomSheetDialog.isShowing() && BottomSheetDialog.this.h()) {
                BottomSheetDialog.this.cancel();
            }
        }
    }

    class b extends AccessibilityDelegateCompat {
        b() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!BottomSheetDialog.this.f6862f) {
                accessibilityNodeInfoCompat.setDismissable(false);
            } else {
                accessibilityNodeInfoCompat.addAction(1048576);
                accessibilityNodeInfoCompat.setDismissable(true);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            if (i2 == 1048576) {
                BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                if (bottomSheetDialog.f6862f) {
                    bottomSheetDialog.cancel();
                    return true;
                }
            }
            return super.performAccessibilityAction(view, i2, bundle);
        }
    }

    class c implements View.OnTouchListener {
        c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    class d extends BottomSheetBehavior.f {
        d() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void a(@NonNull View view, float f2) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void b(@NonNull View view, int i2) {
            if (i2 == 5) {
                BottomSheetDialog.this.cancel();
            }
        }
    }

    public BottomSheetDialog(@NonNull Context context) {
        this(context, 0);
    }

    private static int a(@NonNull Context context, int i2) {
        if (i2 != 0) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, typedValue, true) ? typedValue.resourceId : R.style.Theme_Design_Light_BottomSheetDialog;
    }

    private FrameLayout c() {
        if (this.f6860d == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, null);
            this.f6860d = frameLayout;
            BottomSheetBehavior<FrameLayout> s = BottomSheetBehavior.s((FrameLayout) frameLayout.findViewById(R.id.design_bottom_sheet));
            this.f6859c = s;
            s.i(this.f6865i);
            this.f6859c.O(this.f6862f);
        }
        return this.f6860d;
    }

    private View i(int i2, @Nullable View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        c();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f6860d.findViewById(R.id.coordinator);
        if (i2 != 0 && view == null) {
            view = getLayoutInflater().inflate(i2, (ViewGroup) coordinatorLayout, false);
        }
        FrameLayout frameLayout = (FrameLayout) this.f6860d.findViewById(R.id.design_bottom_sheet);
        frameLayout.removeAllViews();
        if (layoutParams == null) {
            frameLayout.addView(view);
        } else {
            frameLayout.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new a());
        ViewCompat.setAccessibilityDelegate(frameLayout, new b());
        frameLayout.setOnTouchListener(new c());
        return this.f6860d;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior<FrameLayout> d2 = d();
        if (!this.f6861e || d2.z() == 5) {
            super.cancel();
        } else {
            d2.T(5);
        }
    }

    @NonNull
    public BottomSheetBehavior<FrameLayout> d() {
        if (this.f6859c == null) {
            c();
        }
        return this.f6859c;
    }

    public boolean e() {
        return this.f6861e;
    }

    void f() {
        this.f6859c.F(this.f6865i);
    }

    public void g(boolean z) {
        this.f6861e = z;
    }

    boolean h() {
        if (!this.f6864h) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{android.R.attr.windowCloseOnTouchOutside});
            this.f6863g = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.f6864h = true;
        }
        return this.f6863g;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
            }
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f6859c;
        if (bottomSheetBehavior == null || bottomSheetBehavior.z() != 5) {
            return;
        }
        this.f6859c.T(4);
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.f6862f != z) {
            this.f6862f = z;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f6859c;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.O(z);
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.f6862f) {
            this.f6862f = true;
        }
        this.f6863g = z;
        this.f6864h = true;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(@LayoutRes int i2) {
        super.setContentView(i(i2, null, null));
    }

    public BottomSheetDialog(@NonNull Context context, @StyleRes int i2) {
        super(context, a(context, i2));
        this.f6862f = true;
        this.f6863g = true;
        this.f6865i = new d();
        supportRequestWindowFeature(1);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(i(0, view, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(i(0, view, layoutParams));
    }

    protected BottomSheetDialog(@NonNull Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.f6862f = true;
        this.f6863g = true;
        this.f6865i = new d();
        supportRequestWindowFeature(1);
        this.f6862f = z;
    }
}
