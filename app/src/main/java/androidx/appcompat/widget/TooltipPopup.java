package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import com.cdo.oaps.ad.wrapper.BaseWrapper;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
class TooltipPopup {

    /* renamed from: a */
    private static final String f1031a = "TooltipPopup";

    /* renamed from: b */
    private final Context f1032b;

    /* renamed from: c */
    private final View f1033c;

    /* renamed from: d */
    private final TextView f1034d;

    /* renamed from: e */
    private final WindowManager.LayoutParams f1035e;

    /* renamed from: f */
    private final Rect f1036f;

    /* renamed from: g */
    private final int[] f1037g;

    /* renamed from: h */
    private final int[] f1038h;

    TooltipPopup(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f1035e = layoutParams;
        this.f1036f = new Rect();
        this.f1037g = new int[2];
        this.f1038h = new int[2];
        this.f1032b = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.abc_tooltip, (ViewGroup) null);
        this.f1033c = inflate;
        this.f1034d = (TextView) inflate.findViewById(R.id.message);
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    private void a(View view, int i2, int i3, boolean z, WindowManager.LayoutParams layoutParams) {
        int height;
        int i4;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f1032b.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i2 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f1032b.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
            height = i3 + dimensionPixelOffset2;
            i4 = i3 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i4 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f1032b.getResources().getDimensionPixelOffset(z ? R.dimen.tooltip_y_offset_touch : R.dimen.tooltip_y_offset_non_touch);
        View b2 = b(view);
        if (b2 == null) {
            Log.e(f1031a, "Cannot find app view");
            return;
        }
        b2.getWindowVisibleDisplayFrame(this.f1036f);
        Rect rect = this.f1036f;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f1032b.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", BaseWrapper.BASE_PKG_SYSTEM);
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f1036f.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        b2.getLocationOnScreen(this.f1038h);
        view.getLocationOnScreen(this.f1037g);
        int[] iArr = this.f1037g;
        int i5 = iArr[0];
        int[] iArr2 = this.f1038h;
        iArr[0] = i5 - iArr2[0];
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (iArr[0] + i2) - (b2.getWidth() / 2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f1033c.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.f1033c.getMeasuredHeight();
        int[] iArr3 = this.f1037g;
        int i6 = ((iArr3[1] + i4) - dimensionPixelOffset3) - measuredHeight;
        int i7 = iArr3[1] + height + dimensionPixelOffset3;
        if (z) {
            if (i6 >= 0) {
                layoutParams.y = i6;
                return;
            } else {
                layoutParams.y = i7;
                return;
            }
        }
        if (measuredHeight + i7 <= this.f1036f.height()) {
            layoutParams.y = i7;
        } else {
            layoutParams.y = i6;
        }
    }

    private static View b(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    void c() {
        if (d()) {
            ((WindowManager) this.f1032b.getSystemService("window")).removeView(this.f1033c);
        }
    }

    boolean d() {
        return this.f1033c.getParent() != null;
    }

    void e(View view, int i2, int i3, boolean z, CharSequence charSequence) {
        if (d()) {
            c();
        }
        this.f1034d.setText(charSequence);
        a(view, i2, i3, z, this.f1035e);
        ((WindowManager) this.f1032b.getSystemService("window")).addView(this.f1033c, this.f1035e);
    }
}
