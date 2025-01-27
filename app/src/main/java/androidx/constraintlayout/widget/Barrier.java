package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public class Barrier extends ConstraintHelper {
    public static final int BOTTOM = 3;
    public static final int END = 6;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int START = 5;
    public static final int TOP = 2;

    /* renamed from: g */
    private int f1298g;

    /* renamed from: h */
    private int f1299h;

    /* renamed from: i */
    private androidx.constraintlayout.solver.widgets.Barrier f1300i;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public boolean allowsGoneWidget() {
        return this.f1300i.allowsGoneWidget();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void b(AttributeSet attributeSet) {
        super.b(attributeSet);
        this.f1300i = new androidx.constraintlayout.solver.widgets.Barrier();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.f1300i.setAllowsGoneWidget(obtainStyledAttributes.getBoolean(index, true));
                }
            }
        }
        this.f1304d = this.f1300i;
        validateParams();
    }

    public int getType() {
        return this.f1298g;
    }

    public void setAllowsGoneWidget(boolean z) {
        this.f1300i.setAllowsGoneWidget(z);
    }

    public void setType(int i2) {
        this.f1298g = i2;
        this.f1299h = i2;
        if (Build.VERSION.SDK_INT >= 17) {
            if (1 == getResources().getConfiguration().getLayoutDirection()) {
                int i3 = this.f1298g;
                if (i3 == 5) {
                    this.f1299h = 1;
                } else if (i3 == 6) {
                    this.f1299h = 0;
                }
            } else {
                int i4 = this.f1298g;
                if (i4 == 5) {
                    this.f1299h = 0;
                } else if (i4 == 6) {
                    this.f1299h = 1;
                }
            }
        } else if (i2 == 5) {
            this.f1299h = 0;
        } else if (i2 == 6) {
            this.f1299h = 1;
        }
        this.f1300i.setBarrierType(this.f1299h);
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        super.setVisibility(8);
    }
}
