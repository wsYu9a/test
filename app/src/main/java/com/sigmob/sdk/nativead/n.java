package com.sigmob.sdk.nativead;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class n extends ViewGroup {

    /* renamed from: a */
    public final int f19988a;

    /* renamed from: b */
    public final int f19989b;

    /* renamed from: c */
    public final int f19990c;

    /* renamed from: d */
    public final int f19991d;

    /* renamed from: e */
    public final float f19992e;

    /* renamed from: f */
    public final float f19993f;

    /* renamed from: g */
    public final float f19994g;

    /* renamed from: h */
    public final float f19995h;

    /* renamed from: i */
    public final float f19996i;

    /* renamed from: j */
    public int f19997j;

    /* renamed from: k */
    public int f19998k;

    /* renamed from: l */
    public boolean f19999l;

    /* renamed from: m */
    public int f20000m;

    /* renamed from: n */
    public int f20001n;

    /* renamed from: o */
    public float f20002o;

    /* renamed from: p */
    public int f20003p;

    /* renamed from: q */
    public int f20004q;

    /* renamed from: r */
    public int f20005r;

    /* renamed from: s */
    public int f20006s;

    /* renamed from: t */
    public boolean f20007t;

    /* renamed from: u */
    public boolean f20008u;

    /* renamed from: v */
    public float[] f20009v;

    /* renamed from: w */
    public e f20010w;

    /* renamed from: x */
    public a f20011x;

    /* renamed from: y */
    public int f20012y;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i10;
            if (n.this.f19999l) {
                b bVar = (b) view;
                b selectedItem = n.this.getSelectedItem();
                int i11 = 0;
                if (n.this.f20007t) {
                    bVar.a(!bVar.f20014a);
                    int childCount = n.this.getChildCount();
                    while (true) {
                        if (i11 >= childCount) {
                            i10 = -1;
                            break;
                        } else {
                            if (n.this.b(i11) == bVar) {
                                i10 = i11;
                                break;
                            }
                            i11++;
                        }
                    }
                } else {
                    if (selectedItem != null) {
                        selectedItem.a(false);
                    }
                    bVar.a(true);
                    i10 = n.this.getSelectedIndex();
                }
                if (n.this.f20010w != null) {
                    n.this.f20010w.a(i10, bVar.getText().toString());
                }
            }
        }
    }

    public class b extends TextView {

        /* renamed from: a */
        public boolean f20014a;

        /* renamed from: b */
        public Paint f20015b;

        /* renamed from: c */
        public Rect f20016c;

        public b(Context context, CharSequence charSequence) {
            super(context);
            this.f20014a = false;
            this.f20015b = new Paint(1);
            this.f20016c = new Rect();
            this.f20015b.setStyle(Paint.Style.FILL);
            setPadding(n.this.f20005r, n.this.f20006s, n.this.f20005r, n.this.f20006s);
            setLayoutParams(new c(n.this.f20012y, -2));
            setGravity(17);
            setTextSize(0, n.this.f20002o);
            setSingleLine(true);
            setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            setMaxEms(4);
            setText(charSequence);
            setClickable(true);
            a();
        }

        public final void b() {
            int i10 = this.f20014a ? n.this.f20001n : n.this.f19998k;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadii(n.this.f20009v);
            gradientDrawable.setColor(i10);
            setBackground(gradientDrawable);
        }

        @Override // android.widget.TextView
        public boolean getDefaultEditable() {
            return false;
        }

        @Override // android.widget.TextView, android.view.View
        public void onDraw(Canvas canvas) {
            if (!n.this.f20008u) {
                b();
            }
            super.onDraw(canvas);
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
        
            if (r3.f20016c.contains((int) r4.getX(), (int) r4.getY()) != false) goto L43;
         */
        @Override // android.widget.TextView, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouchEvent(android.view.MotionEvent r4) {
            /*
                r3 = this;
                int r0 = r4.getAction()
                if (r0 == 0) goto L26
                r1 = 1
                if (r0 == r1) goto L1f
                r1 = 2
                if (r0 == r1) goto Ld
                goto L2c
            Ld:
                android.graphics.Rect r0 = r3.f20016c
                float r1 = r4.getX()
                int r1 = (int) r1
                float r2 = r4.getY()
                int r2 = (int) r2
                boolean r0 = r0.contains(r1, r2)
                if (r0 != 0) goto L2c
            L1f:
                r3.a()
                r3.invalidate()
                goto L2c
            L26:
                android.graphics.Rect r0 = r3.f20016c
                r3.getDrawingRect(r0)
                goto L1f
            L2c:
                boolean r4 = super.onTouchEvent(r4)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.nativead.n.b.onTouchEvent(android.view.MotionEvent):boolean");
        }

        public final void a() {
            int i10;
            n.this.f20008u = false;
            if (this.f20014a) {
                this.f20015b.setColor(n.this.f20001n);
                i10 = n.this.f20000m;
            } else {
                this.f20015b.setColor(n.this.f19998k);
                i10 = n.this.f19997j;
            }
            setTextColor(i10);
        }

        public void a(boolean z10) {
            this.f20014a = z10;
            a();
        }
    }

    public static class c extends ViewGroup.LayoutParams {
        public c(int i10, int i11) {
            super(i10, i11);
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class d extends View.BaseSavedState {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: a */
        public int f20018a;

        /* renamed from: b */
        public String[] f20019b;

        /* renamed from: c */
        public int f20020c;

        public class a implements Parcelable.Creator<d> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public d[] newArray(int i10) {
                return new d[i10];
            }
        }

        public d(Parcel parcel) {
            super(parcel);
            int readInt = parcel.readInt();
            this.f20018a = readInt;
            String[] strArr = new String[readInt];
            this.f20019b = strArr;
            parcel.readStringArray(strArr);
            this.f20020c = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            int length = this.f20019b.length;
            this.f20018a = length;
            parcel.writeInt(length);
            parcel.writeStringArray(this.f20019b);
            parcel.writeInt(this.f20020c);
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public interface e {
        void a(int i10, String str);
    }

    public n(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public ArrayList<Integer> getAllItemSelectedIndex() {
        int childCount = getChildCount();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (b(i10).f20014a) {
                arrayList.add(Integer.valueOf(i10));
            }
        }
        return arrayList;
    }

    public ArrayList<String> getAllItemSelectedTextWithListArray() {
        int childCount = getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i10 = 0; i10 < childCount; i10++) {
            b b10 = b(i10);
            if (b10.f20014a) {
                arrayList.add(b10.getText().toString());
            }
        }
        return arrayList;
    }

    public String[] getAllItemSelectedTextWithStringArray() {
        int childCount = getChildCount();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < childCount; i10++) {
            b b10 = b(i10);
            if (b10.f20014a) {
                arrayList.add(b10.getText().toString());
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public String[] getAllItemText() {
        int childCount = getChildCount();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < childCount; i10++) {
            arrayList.add(b(i10).getText().toString());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public int getSelectedIndex() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (b(i10).f20014a) {
                return i10;
            }
        }
        return -1;
    }

    public b getSelectedItem() {
        int selectedIndex = getSelectedIndex();
        if (selectedIndex != -1) {
            return b(selectedIndex);
        }
        return null;
    }

    public String getSelectedItemText() {
        if (getSelectedItem() != null) {
            return getSelectedItem().getText().toString();
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i12 - i10) - getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = getChildCount();
        int i14 = paddingLeft;
        int i15 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (childAt.getVisibility() != 8) {
                if (i14 + measuredWidth > paddingRight) {
                    paddingTop += i15 + this.f20004q;
                    i14 = paddingLeft;
                    i15 = measuredHeight;
                } else {
                    i15 = Math.max(i15, measuredHeight);
                }
                childAt.layout(i14, paddingTop, i14 + measuredWidth, measuredHeight + paddingTop);
                i14 += measuredWidth + this.f20003p;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        measureChildren(i10, i11);
        int childCount = getChildCount();
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (childAt.getVisibility() != 8) {
                int i17 = i15 + measuredWidth;
                if (i17 > size) {
                    i13 += i14 + this.f20004q;
                    i12++;
                } else {
                    measuredHeight = Math.max(i14, measuredHeight);
                    measuredWidth = i17;
                }
                i15 = measuredWidth + this.f20003p;
                i14 = measuredHeight;
            }
        }
        int paddingTop = i13 + i14 + getPaddingTop() + getPaddingBottom();
        int paddingLeft = i12 == 0 ? i15 + getPaddingLeft() + getPaddingRight() : size;
        if (mode != 1073741824) {
            size = paddingLeft;
        }
        if (mode2 != 1073741824) {
            size2 = paddingTop;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        setList(dVar.f20019b);
        b b10 = b(dVar.f20020c);
        if (b10 != null) {
            b10.a(true);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.f20019b = getAllItemText();
        dVar.f20020c = getSelectedIndex();
        return dVar;
    }

    public void setIndexListItemSelected(List<Integer> list) {
        if (list == null || list.isEmpty() || list.size() == 0) {
            return;
        }
        if (list.size() > getChildCount()) {
            return;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            b(i10).a(true);
        }
    }

    public void setList(List<String> list) {
        setList((String[]) list.toArray(new String[list.size()]));
    }

    public void setOnItemClickListener(e eVar) {
        this.f20010w = eVar;
    }

    public n(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b b(int i10) {
        if (getChildAt(i10) == null) {
            return null;
        }
        return (b) getChildAt(i10);
    }

    public boolean c(int i10) {
        b b10 = b(i10);
        return b10 != null && b10.f20014a;
    }

    public int d(int i10) {
        return a(i10, true);
    }

    public void setList(String... strArr) {
        removeAllViews();
        for (String str : strArr) {
            a((CharSequence) str);
        }
    }

    public n(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19988a = -16777216;
        int parseColor = Color.parseColor("#EEEEEE");
        this.f19989b = parseColor;
        this.f19990c = -1;
        int parseColor2 = Color.parseColor("#FE7E03");
        this.f19991d = parseColor2;
        this.f20008u = false;
        this.f20009v = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.f20011x = new a();
        int i11 = context.getResources().getDisplayMetrics().widthPixels;
        int i12 = context.getResources().getDisplayMetrics().heightPixels;
        int a10 = (int) a(100.0f);
        if (i12 > i11) {
            this.f20012y = (i11 - a10) / 3;
        } else {
            this.f20012y = (i12 - a10) / 3;
        }
        float b10 = b(13.0f);
        this.f19992e = b10;
        float a11 = a(10.0f);
        this.f19993f = a11;
        float a12 = a(10.0f);
        this.f19994g = a12;
        float a13 = a(10.0f);
        this.f19995h = a13;
        float a14 = a(5.0f);
        this.f19996i = a14;
        this.f19997j = -16777216;
        this.f19998k = parseColor;
        this.f20000m = -1;
        this.f20001n = parseColor2;
        this.f20002o = b10;
        this.f20003p = (int) a11;
        this.f20004q = (int) a12;
        this.f20005r = (int) a13;
        this.f20006s = (int) a14;
        this.f20007t = false;
        this.f19999l = true;
    }

    public final void a(CharSequence charSequence) {
        b bVar = new b(getContext(), charSequence);
        bVar.setOnClickListener(this.f20011x);
        addView(bVar);
    }

    public void b() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            b b10 = b(i10);
            if (b10 != null) {
                if (b10.f20014a) {
                    b10.a(false);
                }
                b10.setClickable(false);
            }
        }
    }

    public void c() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            b(i10).a(true);
        }
    }

    public void a() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            b b10 = b(i10);
            if (b10 != null && b10.f20014a) {
                b10.a(false);
            }
        }
    }

    public final int b(float f10) {
        return (int) TypedValue.applyDimension(2, f10, getResources().getDisplayMetrics());
    }

    public void a(int i10) {
        b b10 = b(i10);
        if (b10 == null || !b10.f20014a) {
            return;
        }
        b10.a(false);
    }

    public final float a(float f10) {
        return TypedValue.applyDimension(1, f10, getResources().getDisplayMetrics());
    }

    public int a(String str) {
        ArrayList<String> allItemSelectedTextWithListArray = getAllItemSelectedTextWithListArray();
        if (allItemSelectedTextWithListArray == null || !allItemSelectedTextWithListArray.contains(str)) {
            return -1;
        }
        return allItemSelectedTextWithListArray.indexOf(str);
    }

    public int a(int i10, boolean z10) {
        if (i10 >= getChildCount()) {
            return -1;
        }
        b(i10).a(z10);
        return i10;
    }

    public void a(int i10, String str) {
        if (i10 >= getChildCount()) {
            return;
        }
        b(i10).setText(str);
    }
}
