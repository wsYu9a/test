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

@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes4.dex */
public class LineColorPicker extends View {

    /* renamed from: a */
    public static final int f14207a = 0;

    /* renamed from: b */
    public static final int f14208b = 1;

    /* renamed from: c */
    int[] f14209c;

    /* renamed from: d */
    private final Paint f14210d;

    /* renamed from: e */
    private final Rect f14211e;

    /* renamed from: f */
    boolean f14212f;

    /* renamed from: g */
    private int f14213g;

    /* renamed from: h */
    private b f14214h;

    /* renamed from: i */
    private int f14215i;

    /* renamed from: j */
    private final int f14216j;
    private boolean k;
    private int l;
    private int m;

    public interface b {
        void a(int color);
    }

    static class c extends View.BaseSavedState {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: a */
        int f14217a;

        /* renamed from: b */
        boolean f14218b;

        static class a implements Parcelable.Creator<c> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public c createFromParcel(Parcel in) {
                return new c(in);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public c[] newArray(int size) {
                return new c[size];
            }
        }

        /* synthetic */ c(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f14217a);
            parcel.writeInt(this.f14218b ? 1 : 0);
        }

        c(Parcelable superState) {
            super(superState);
        }

        private c(Parcel in) {
            super(in);
            this.f14217a = in.readInt();
            this.f14218b = in.readInt() == 1;
        }
    }

    public LineColorPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f14209c = com.martian.mibook.ui.colorpicker.b.f14239a;
        this.f14211e = new Rect();
        this.f14212f = false;
        this.f14213g = this.f14209c[0];
        this.k = false;
        Paint paint = new Paint();
        this.f14210d = paint;
        paint.setStyle(Paint.Style.FILL);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.LineColorPicker, 0, 0);
        try {
            this.f14216j = obtainStyledAttributes.getInteger(1, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void a(Canvas canvas) {
        Rect rect = this.f14211e;
        rect.left = 0;
        rect.top = 0;
        rect.right = 0;
        rect.bottom = canvas.getHeight();
        int round = Math.round(canvas.getHeight() * 0.08f);
        for (int i2 : this.f14209c) {
            this.f14210d.setColor(ContextCompat.getColor(getContext(), i2));
            Rect rect2 = this.f14211e;
            int i3 = rect2.right;
            rect2.left = i3;
            rect2.right = i3 + this.f14215i;
            if (this.f14212f && i2 == this.f14213g) {
                rect2.top = 0;
                rect2.bottom = canvas.getHeight();
            } else {
                rect2.top = round;
                rect2.bottom = canvas.getHeight() - round;
            }
            canvas.drawRect(this.f14211e, this.f14210d);
        }
    }

    private void b(Canvas canvas) {
        Rect rect = this.f14211e;
        rect.left = 0;
        rect.top = 0;
        rect.right = canvas.getWidth();
        this.f14211e.bottom = 0;
        int round = Math.round(canvas.getWidth() * 0.08f);
        for (int i2 : this.f14209c) {
            this.f14210d.setColor(ContextCompat.getColor(getContext(), i2));
            Rect rect2 = this.f14211e;
            int i3 = rect2.bottom;
            rect2.top = i3;
            rect2.bottom = i3 + this.f14215i;
            if (this.f14212f && i2 == this.f14213g) {
                rect2.left = 0;
                rect2.right = canvas.getWidth();
            } else {
                rect2.left = round;
                rect2.right = canvas.getWidth() - round;
            }
            canvas.drawRect(this.f14211e, this.f14210d);
        }
    }

    private int c(float x, float y) {
        int i2 = 0;
        if (this.f14216j == 0) {
            int[] iArr = this.f14209c;
            int length = iArr.length;
            int i3 = 0;
            while (i2 < length) {
                int i4 = iArr[i2];
                int i5 = this.f14215i + i3;
                if (i3 <= x && i5 >= x) {
                    return i4;
                }
                i2++;
                i3 = i5;
            }
        } else {
            int[] iArr2 = this.f14209c;
            int length2 = iArr2.length;
            int i6 = 0;
            while (i2 < length2) {
                int i7 = iArr2[i2];
                int i8 = this.f14215i + i6;
                if (y >= i6 && y <= i8) {
                    return i7;
                }
                i2++;
                i6 = i8;
            }
        }
        return this.f14213g;
    }

    private boolean d(int c2) {
        for (int i2 : this.f14209c) {
            if (i2 == c2) {
                return false;
            }
        }
        return true;
    }

    private void e(int color) {
        b bVar = this.f14214h;
        if (bVar != null) {
            bVar.a(color);
        }
    }

    private void f() {
        if (this.f14216j == 0) {
            this.f14215i = Math.round(this.l / (this.f14209c.length * 1.0f));
        } else {
            this.f14215i = Math.round(this.m / (this.f14209c.length * 1.0f));
        }
    }

    public int getColor() {
        return this.f14213g;
    }

    public int[] getColors() {
        return this.f14209c;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f14216j == 0) {
            a(canvas);
        } else {
            b(canvas);
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof c)) {
            super.onRestoreInstanceState(state);
            return;
        }
        c cVar = (c) state;
        super.onRestoreInstanceState(cVar.getSuperState());
        this.f14213g = cVar.f14217a;
        this.f14212f = cVar.f14218b;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.f14217a = this.f14213g;
        cVar.f14218b = this.f14212f;
        return cVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h2, int oldW, int oldH) {
        this.l = w;
        this.m = h2;
        f();
        super.onSizeChanged(w, h2, oldW, oldH);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (action == 0) {
            this.k = true;
        } else if (action == 1) {
            setSelectedColor(c(event.getX(), event.getY()));
            if (this.k) {
                performClick();
            }
        } else if (action == 2) {
            setSelectedColor(c(event.getX(), event.getY()));
        } else if (action == 3 || action == 4) {
            this.k = false;
        }
        return true;
    }

    public void setColors(int[] colors) {
        this.f14209c = colors;
        if (d(this.f14213g)) {
            this.f14213g = colors[0];
        }
        f();
        invalidate();
    }

    public void setOnColorChangedListener(b l) {
        this.f14214h = l;
    }

    public void setSelectedColor(int color) {
        if (d(color)) {
            return;
        }
        if (this.f14212f && this.f14213g == color) {
            return;
        }
        this.f14213g = color;
        this.f14212f = true;
        invalidate();
        e(color);
    }

    public void setSelectedColorPosition(int position) {
        setSelectedColor(this.f14209c[position]);
    }
}
