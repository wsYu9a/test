package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class ConstraintHelper extends View {

    /* renamed from: a */
    protected int[] f1301a;

    /* renamed from: b */
    protected int f1302b;

    /* renamed from: c */
    protected Context f1303c;

    /* renamed from: d */
    protected Helper f1304d;

    /* renamed from: e */
    protected boolean f1305e;

    /* renamed from: f */
    private String f1306f;

    public ConstraintHelper(Context context) {
        super(context);
        this.f1301a = new int[32];
        this.f1305e = false;
        this.f1303c = context;
        b(null);
    }

    private void a(String str) {
        int i2;
        Object designInformation;
        if (str == null || this.f1303c == null) {
            return;
        }
        String trim = str.trim();
        try {
            i2 = R.id.class.getField(trim).getInt(null);
        } catch (Exception unused) {
            i2 = 0;
        }
        if (i2 == 0) {
            i2 = this.f1303c.getResources().getIdentifier(trim, "id", this.f1303c.getPackageName());
        }
        if (i2 == 0 && isInEditMode() && (getParent() instanceof ConstraintLayout) && (designInformation = ((ConstraintLayout) getParent()).getDesignInformation(0, trim)) != null && (designInformation instanceof Integer)) {
            i2 = ((Integer) designInformation).intValue();
        }
        if (i2 != 0) {
            setTag(i2, null);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
    }

    private void setIds(String str) {
        if (str == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            int indexOf = str.indexOf(44, i2);
            if (indexOf == -1) {
                a(str.substring(i2));
                return;
            } else {
                a(str.substring(i2, indexOf));
                i2 = indexOf + 1;
            }
        }
    }

    protected void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f1306f = string;
                    setIds(string);
                }
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f1301a, this.f1302b);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        if (this.f1305e) {
            super.onMeasure(i2, i3);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f1302b = 0;
        for (int i2 : iArr) {
            setTag(i2, null);
        }
    }

    @Override // android.view.View
    public void setTag(int i2, Object obj) {
        int i3 = this.f1302b + 1;
        int[] iArr = this.f1301a;
        if (i3 > iArr.length) {
            this.f1301a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f1301a;
        int i4 = this.f1302b;
        iArr2[i4] = i2;
        this.f1302b = i4 + 1;
    }

    public void updatePostLayout(ConstraintLayout constraintLayout) {
    }

    public void updatePostMeasure(ConstraintLayout constraintLayout) {
    }

    public void updatePreLayout(ConstraintLayout constraintLayout) {
        if (isInEditMode()) {
            setIds(this.f1306f);
        }
        Helper helper = this.f1304d;
        if (helper == null) {
            return;
        }
        helper.removeAllIds();
        for (int i2 = 0; i2 < this.f1302b; i2++) {
            View viewById = constraintLayout.getViewById(this.f1301a[i2]);
            if (viewById != null) {
                this.f1304d.add(constraintLayout.getViewWidget(viewById));
            }
        }
    }

    public void validateParams() {
        if (this.f1304d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ConstraintLayout.LayoutParams) layoutParams).s = this.f1304d;
        }
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1301a = new int[32];
        this.f1305e = false;
        this.f1303c = context;
        b(attributeSet);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1301a = new int[32];
        this.f1305e = false;
        this.f1303c = context;
        b(attributeSet);
    }
}
