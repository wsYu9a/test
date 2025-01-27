package com.martian.mibook.ui.colorpicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.martian.mibook.R;
import ee.b;
import ee.c;

@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes3.dex */
public class LineColorPicker extends View {

    /* renamed from: m */
    public static final int f15934m = 0;

    /* renamed from: n */
    public static final int f15935n = 1;

    /* renamed from: b */
    public int[] f15936b;

    /* renamed from: c */
    public final Paint f15937c;

    /* renamed from: d */
    public final Rect f15938d;

    /* renamed from: e */
    public boolean f15939e;

    /* renamed from: f */
    public int f15940f;

    /* renamed from: g */
    public a f15941g;

    /* renamed from: h */
    public int f15942h;

    /* renamed from: i */
    public final int f15943i;

    /* renamed from: j */
    public boolean f15944j;

    /* renamed from: k */
    public int f15945k;

    /* renamed from: l */
    public int f15946l;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: b */
        public int f15947b;

        /* renamed from: c */
        public boolean f15948c;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public /* synthetic */ SavedState(Parcel parcel, b bVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f15947b);
            parcel.writeInt(this.f15948c ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f15947b = parcel.readInt();
            this.f15948c = parcel.readInt() == 1;
        }
    }

    public interface a {
        void a(int i10);
    }

    public LineColorPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15936b = c.f25900a;
        this.f15938d = new Rect();
        this.f15939e = false;
        this.f15940f = this.f15936b[0];
        this.f15944j = false;
        Paint paint = new Paint();
        this.f15937c = paint;
        paint.setStyle(Paint.Style.FILL);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.LineColorPicker, 0, 0);
        try {
            this.f15943i = obtainStyledAttributes.getInteger(R.styleable.LineColorPicker_orientation, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final void a(Canvas canvas) {
        Rect rect = this.f15938d;
        rect.left = 0;
        rect.top = 0;
        rect.right = 0;
        rect.bottom = canvas.getHeight();
        int round = Math.round(canvas.getHeight() * 0.08f);
        for (int i10 : this.f15936b) {
            this.f15937c.setColor(ContextCompat.getColor(getContext(), i10));
            Rect rect2 = this.f15938d;
            int i11 = rect2.right;
            rect2.left = i11;
            rect2.right = i11 + this.f15942h;
            if (this.f15939e && i10 == this.f15940f) {
                rect2.top = 0;
                rect2.bottom = canvas.getHeight();
            } else {
                rect2.top = round;
                rect2.bottom = canvas.getHeight() - round;
            }
            canvas.drawRect(this.f15938d, this.f15937c);
        }
    }

    public final void b(Canvas canvas) {
        Rect rect = this.f15938d;
        rect.left = 0;
        rect.top = 0;
        rect.right = canvas.getWidth();
        this.f15938d.bottom = 0;
        int round = Math.round(canvas.getWidth() * 0.08f);
        for (int i10 : this.f15936b) {
            this.f15937c.setColor(ContextCompat.getColor(getContext(), i10));
            Rect rect2 = this.f15938d;
            int i11 = rect2.bottom;
            rect2.top = i11;
            rect2.bottom = i11 + this.f15942h;
            if (this.f15939e && i10 == this.f15940f) {
                rect2.left = 0;
                rect2.right = canvas.getWidth();
            } else {
                rect2.left = round;
                rect2.right = canvas.getWidth() - round;
            }
            canvas.drawRect(this.f15938d, this.f15937c);
        }
    }

    public final int c(float f10, float f11) {
        int i10 = 0;
        if (this.f15943i == 0) {
            int[] iArr = this.f15936b;
            int length = iArr.length;
            int i11 = 0;
            while (i10 < length) {
                int i12 = iArr[i10];
                int i13 = this.f15942h + i11;
                if (i11 <= f10 && i13 >= f10) {
                    return i12;
                }
                i10++;
                i11 = i13;
            }
        } else {
            int[] iArr2 = this.f15936b;
            int length2 = iArr2.length;
            int i14 = 0;
            while (i10 < length2) {
                int i15 = iArr2[i10];
                int i16 = this.f15942h + i14;
                if (f11 >= i14 && f11 <= i16) {
                    return i15;
                }
                i10++;
                i14 = i16;
            }
        }
        return this.f15940f;
    }

    public final boolean d(int i10) {
        for (int i11 : this.f15936b) {
            if (i11 == i10) {
                return false;
            }
        }
        return true;
    }

    public final void e(int i10) {
        a aVar = this.f15941g;
        if (aVar != null) {
            aVar.a(i10);
        }
    }

    public final void f() {
        if (this.f15943i == 0) {
            this.f15942h = Math.round(this.f15945k / (this.f15936b.length * 1.0f));
        } else {
            this.f15942h = Math.round(this.f15946l / (this.f15936b.length * 1.0f));
        }
    }

    public int getColor() {
        return this.f15940f;
    }

    public int[] getColors() {
        return this.f15936b;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f15943i == 0) {
            a(canvas);
        } else {
            b(canvas);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f15940f = savedState.f15947b;
        this.f15939e = savedState.f15948c;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f15947b = this.f15940f;
        savedState.f15948c = this.f15939e;
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        this.f15945k = i10;
        this.f15946l = i11;
        f();
        super.onSizeChanged(i10, i11, i12, i13);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f15944j = true;
        } else if (action == 1) {
            setSelectedColor(c(motionEvent.getX(), motionEvent.getY()));
            if (this.f15944j) {
                performClick();
            }
        } else if (action == 2) {
            setSelectedColor(c(motionEvent.getX(), motionEvent.getY()));
        } else if (action == 3 || action == 4) {
            this.f15944j = false;
        }
        return true;
    }

    public void setColors(int[] iArr) {
        this.f15936b = iArr;
        if (d(this.f15940f)) {
            this.f15940f = iArr[0];
        }
        f();
        invalidate();
    }

    public void setOnColorChangedListener(a aVar) {
        this.f15941g = aVar;
    }

    public void setSelectedColor(int i10) {
        if (d(i10)) {
            return;
        }
        if (this.f15939e && this.f15940f == i10) {
            return;
        }
        this.f15940f = i10;
        this.f15939e = true;
        invalidate();
        e(i10);
    }

    public void setSelectedColorPosition(int i10) {
        setSelectedColor(this.f15936b[i10]);
    }
}
