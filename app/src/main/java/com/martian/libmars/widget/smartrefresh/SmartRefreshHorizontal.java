package com.martian.libmars.widget.smartrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import com.kuaishou.weapon.p0.t;
import com.martian.libmars.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pf.b;
import xi.k;
import xi.l;
import y9.c;
import y9.d;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010%R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/martian/libmars/widget/smartrefresh/SmartRefreshHorizontal;", "Lcom/scwang/smart/refresh/layout/SmartRefreshLayout;", "Landroid/content/Context;", f.X, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "onAttachedToWindow", "()V", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "", "changed", t.f11204d, bt.aO, t.f11211k, "b", "onLayout", "(ZIIII)V", "Landroidx/core/widget/NestedScrollView;", "nestedScrollView", "setNestedScrollView", "(Landroidx/core/widget/NestedScrollView;)V", "Landroid/view/MotionEvent;", "ev", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "f1", "Z", "isInLayout", "", "g1", "F", "lastX", "h1", "lastY", "i1", "Landroidx/core/widget/NestedScrollView;", "libmars_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class SmartRefreshHorizontal extends SmartRefreshLayout {

    /* renamed from: f1, reason: from kotlin metadata */
    public boolean isInLayout;

    /* renamed from: g1, reason: from kotlin metadata */
    public float lastX;

    /* renamed from: h1, reason: from kotlin metadata */
    public float lastY;

    /* renamed from: i1, reason: from kotlin metadata */
    @l
    public NestedScrollView nestedScrollView;

    public static final class a extends c {
        @Override // tf.a, sf.j
        public boolean a(@k View content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return d.f33078a.b(content, this.f30862a);
        }

        @Override // tf.a, sf.j
        public boolean b(@k View content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return d.f33078a.a(content, this.f30862a, this.f30864c);
        }
    }

    @JvmOverloads
    public SmartRefreshHorizontal(@l Context context) {
        this(context, null, 2, null);
    }

    @Override // com.scwang.smart.refresh.layout.SmartRefreshLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.F0;
        if (bVar != null && !(bVar instanceof y9.b)) {
            View view = bVar.getView();
            Intrinsics.checkNotNullExpressionValue(view, "getView(...)");
            this.F0 = new y9.b(view);
            int i10 = this.f16726r;
            View findViewById = i10 > 0 ? findViewById(i10) : null;
            int i11 = this.f16728s;
            View findViewById2 = i11 > 0 ? findViewById(i11) : null;
            this.F0.c(this.f16703f0);
            this.F0.b(this.Q);
            this.F0.e(this.I0, findViewById, findViewById2);
        }
        setRotation(-90.0f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        if (r0 != 3) goto L100;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(@xi.k android.view.MotionEvent r5) {
        /*
            r4 = this;
            java.lang.String r0 = "ev"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            androidx.core.widget.NestedScrollView r0 = r4.nestedScrollView
            if (r0 == 0) goto L68
            int r0 = r5.getAction()
            r1 = 1
            if (r0 == 0) goto L54
            if (r0 == r1) goto L4b
            r2 = 2
            if (r0 == r2) goto L19
            r2 = 3
            if (r0 == r2) goto L4b
            goto L68
        L19:
            float r0 = r5.getX()
            float r2 = r4.lastX
            float r0 = r0 - r2
            float r2 = r5.getY()
            float r3 = r4.lastY
            float r2 = r2 - r3
            float r3 = java.lang.Math.abs(r0)
            float r2 = java.lang.Math.abs(r2)
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 <= 0) goto L42
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L42
            androidx.core.widget.NestedScrollView r0 = r4.nestedScrollView
            if (r0 != 0) goto L3d
            goto L68
        L3d:
            r1 = 0
            r0.setNestedScrollingEnabled(r1)
            goto L68
        L42:
            androidx.core.widget.NestedScrollView r0 = r4.nestedScrollView
            if (r0 != 0) goto L47
            goto L68
        L47:
            r0.setNestedScrollingEnabled(r1)
            goto L68
        L4b:
            androidx.core.widget.NestedScrollView r0 = r4.nestedScrollView
            if (r0 != 0) goto L50
            goto L68
        L50:
            r0.setNestedScrollingEnabled(r1)
            goto L68
        L54:
            float r0 = r5.getX()
            r4.lastX = r0
            float r0 = r5.getY()
            r4.lastY = r0
            androidx.core.widget.NestedScrollView r0 = r4.nestedScrollView
            if (r0 != 0) goto L65
            goto L68
        L65:
            r0.setNestedScrollingEnabled(r1)
        L68:
            boolean r5 = super.onInterceptTouchEvent(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.libmars.widget.smartrefresh.SmartRefreshHorizontal.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // com.scwang.smart.refresh.layout.SmartRefreshLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int r20, int r21, int r22, int b10) {
        pf.a aVar;
        int i10;
        int i11;
        pf.a aVar2;
        int i12 = r22 - r20;
        int i13 = b10 - r21;
        int i14 = (i13 - i12) / 2;
        int i15 = 0;
        if (!this.isInLayout) {
            int i16 = r21 - i14;
            int i17 = r20 + i14;
            this.isInLayout = true;
            super.layout(i17, i16, i12 + i17, i13 + i16);
            this.isInLayout = false;
            return;
        }
        pf.a aVar3 = this.D0;
        pf.a aVar4 = this.E0;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int childCount = getChildCount();
        while (i15 < childCount) {
            View childAt = getChildAt(i15);
            if ((aVar3 == null || childAt != aVar3.getView()) && ((aVar4 == null || childAt != aVar4.getView()) && childAt.getVisibility() != 8)) {
                int i18 = i12 - (paddingTop + paddingBottom);
                int i19 = i13 - (paddingLeft + paddingRight);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    int i20 = marginLayoutParams.topMargin;
                    aVar = aVar3;
                    int i21 = marginLayoutParams.bottomMargin;
                    i18 -= i20 + i21;
                    int i22 = marginLayoutParams.leftMargin;
                    i19 -= marginLayoutParams.rightMargin + i22;
                    i11 = i21 + paddingBottom;
                    i10 = i22 + paddingLeft;
                } else {
                    aVar = aVar3;
                    i10 = paddingLeft;
                    i11 = paddingBottom;
                }
                int i23 = (i18 - i19) / 2;
                int i24 = i11 + i23;
                int i25 = i10 - i23;
                childAt.setRotation(90.0f);
                aVar2 = aVar4;
                childAt.setTag(R.id.srl_tag, "GONE");
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i19, 1073741824), View.MeasureSpec.makeMeasureSpec(i18, 1073741824));
                childAt.layout(i24, i25, i19 + i24, i18 + i25);
            } else {
                aVar = aVar3;
                aVar2 = aVar4;
            }
            i15++;
            aVar3 = aVar;
            aVar4 = aVar2;
        }
        super.onLayout(changed, r20, r21, r22, b10);
    }

    @Override // com.scwang.smart.refresh.layout.SmartRefreshLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(heightMeasureSpec, widthMeasureSpec);
    }

    public final void setNestedScrollView(@l NestedScrollView nestedScrollView) {
        this.nestedScrollView = nestedScrollView;
    }

    @JvmOverloads
    public SmartRefreshHorizontal(@l Context context, @l AttributeSet attributeSet) {
        super(context, attributeSet);
        C(false);
        c(new a());
    }

    public /* synthetic */ SmartRefreshHorizontal(Context context, AttributeSet attributeSet, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }
}
