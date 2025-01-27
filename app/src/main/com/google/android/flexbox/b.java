package com.google.android.flexbox;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.widget.CompoundButtonCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import s4.d;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: f */
    public static final int f9084f = 10;

    /* renamed from: g */
    public static final long f9085g = 4294967295L;

    /* renamed from: h */
    public static final /* synthetic */ boolean f9086h = false;

    /* renamed from: a */
    public final d f9087a;

    /* renamed from: b */
    public boolean[] f9088b;

    /* renamed from: c */
    @Nullable
    public int[] f9089c;

    /* renamed from: d */
    @Nullable
    public long[] f9090d;

    /* renamed from: e */
    @Nullable
    public long[] f9091e;

    /* renamed from: com.google.android.flexbox.b$b */
    public static class C0255b {

        /* renamed from: a */
        public List<com.google.android.flexbox.a> f9092a;

        /* renamed from: b */
        public int f9093b;

        public void a() {
            this.f9092a = null;
            this.f9093b = 0;
        }
    }

    public static class c implements Comparable<c> {

        /* renamed from: b */
        public int f9094b;

        /* renamed from: c */
        public int f9095c;

        public c() {
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(@NonNull c another) {
            int i10 = this.f9095c;
            int i11 = another.f9095c;
            return i10 != i11 ? i10 - i11 : this.f9094b - another.f9094b;
        }

        @NonNull
        public String toString() {
            return "Order{order=" + this.f9095c + ", index=" + this.f9094b + '}';
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public b(d flexContainer) {
        this.f9087a = flexContainer;
    }

    public final int A(int widthMeasureSpec, FlexItem flexItem, int padding) {
        d dVar = this.f9087a;
        int b10 = dVar.b(widthMeasureSpec, dVar.getPaddingLeft() + this.f9087a.getPaddingRight() + flexItem.x() + flexItem.y() + padding, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(b10);
        return size > flexItem.r() ? View.MeasureSpec.makeMeasureSpec(flexItem.r(), View.MeasureSpec.getMode(b10)) : size < flexItem.k() ? View.MeasureSpec.makeMeasureSpec(flexItem.k(), View.MeasureSpec.getMode(b10)) : b10;
    }

    public final int B(FlexItem flexItem, boolean isMainHorizontal) {
        return isMainHorizontal ? flexItem.w() : flexItem.y();
    }

    public final int C(FlexItem flexItem, boolean isMainHorizontal) {
        return isMainHorizontal ? flexItem.y() : flexItem.w();
    }

    public final int D(FlexItem flexItem, boolean isMainHorizontal) {
        return isMainHorizontal ? flexItem.m() : flexItem.x();
    }

    public final int E(FlexItem flexItem, boolean isMainHorizontal) {
        return isMainHorizontal ? flexItem.x() : flexItem.m();
    }

    public final int F(FlexItem flexItem, boolean isMainHorizontal) {
        return isMainHorizontal ? flexItem.getHeight() : flexItem.getWidth();
    }

    public final int G(FlexItem flexItem, boolean isMainHorizontal) {
        return isMainHorizontal ? flexItem.getWidth() : flexItem.getHeight();
    }

    public final int H(boolean isMainHorizontal) {
        return isMainHorizontal ? this.f9087a.getPaddingBottom() : this.f9087a.getPaddingEnd();
    }

    public final int I(boolean isMainHorizontal) {
        return isMainHorizontal ? this.f9087a.getPaddingEnd() : this.f9087a.getPaddingBottom();
    }

    public final int J(boolean isMainHorizontal) {
        return isMainHorizontal ? this.f9087a.getPaddingTop() : this.f9087a.getPaddingStart();
    }

    public final int K(boolean isMainHorizontal) {
        return isMainHorizontal ? this.f9087a.getPaddingStart() : this.f9087a.getPaddingTop();
    }

    public final int L(View view, boolean isMainHorizontal) {
        return isMainHorizontal ? view.getMeasuredHeight() : view.getMeasuredWidth();
    }

    public final int M(View view, boolean isMainHorizontal) {
        return isMainHorizontal ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    public final boolean N(int childIndex, int childCount, com.google.android.flexbox.a flexLine) {
        return childIndex == childCount - 1 && flexLine.d() != 0;
    }

    public boolean O(SparseIntArray orderCache) {
        int flexItemCount = this.f9087a.getFlexItemCount();
        if (orderCache.size() != flexItemCount) {
            return true;
        }
        for (int i10 = 0; i10 < flexItemCount; i10++) {
            View c10 = this.f9087a.c(i10);
            if (c10 != null && ((FlexItem) c10.getLayoutParams()).getOrder() != orderCache.get(i10)) {
                return true;
            }
        }
        return false;
    }

    public final boolean P(View view, int mode, int maxSize, int currentLength, int childLength, FlexItem flexItem, int index, int indexInFlexLine, int flexLinesSize) {
        if (this.f9087a.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.q()) {
            return true;
        }
        if (mode == 0) {
            return false;
        }
        int maxLine = this.f9087a.getMaxLine();
        if (maxLine != -1 && maxLine <= flexLinesSize + 1) {
            return false;
        }
        int i10 = this.f9087a.i(view, index, indexInFlexLine);
        if (i10 > 0) {
            childLength += i10;
        }
        return maxSize < currentLength + childLength;
    }

    public void Q(View view, com.google.android.flexbox.a flexLine, int left, int top, int right, int bottom) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.f9087a.getAlignItems();
        if (flexItem.g() != -1) {
            alignItems = flexItem.g();
        }
        int i10 = flexLine.f9072g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.f9087a.getFlexWrap() == 2) {
                    view.layout(left, (top - i10) + view.getMeasuredHeight() + flexItem.m(), right, (bottom - i10) + view.getMeasuredHeight() + flexItem.m());
                    return;
                } else {
                    int i11 = top + i10;
                    view.layout(left, (i11 - view.getMeasuredHeight()) - flexItem.w(), right, i11 - flexItem.w());
                    return;
                }
            }
            if (alignItems == 2) {
                int measuredHeight = (((i10 - view.getMeasuredHeight()) + flexItem.m()) - flexItem.w()) / 2;
                if (this.f9087a.getFlexWrap() != 2) {
                    int i12 = top + measuredHeight;
                    view.layout(left, i12, right, view.getMeasuredHeight() + i12);
                    return;
                } else {
                    int i13 = top - measuredHeight;
                    view.layout(left, i13, right, view.getMeasuredHeight() + i13);
                    return;
                }
            }
            if (alignItems == 3) {
                if (this.f9087a.getFlexWrap() != 2) {
                    int max = Math.max(flexLine.f9077l - view.getBaseline(), flexItem.m());
                    view.layout(left, top + max, right, bottom + max);
                    return;
                } else {
                    int max2 = Math.max((flexLine.f9077l - view.getMeasuredHeight()) + view.getBaseline(), flexItem.w());
                    view.layout(left, top - max2, right, bottom - max2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.f9087a.getFlexWrap() != 2) {
            view.layout(left, top + flexItem.m(), right, bottom + flexItem.m());
        } else {
            view.layout(left, top - flexItem.w(), right, bottom - flexItem.w());
        }
    }

    public void R(View view, com.google.android.flexbox.a flexLine, boolean isRtl, int left, int top, int right, int bottom) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.f9087a.getAlignItems();
        if (flexItem.g() != -1) {
            alignItems = flexItem.g();
        }
        int i10 = flexLine.f9072g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (isRtl) {
                    view.layout((left - i10) + view.getMeasuredWidth() + flexItem.x(), top, (right - i10) + view.getMeasuredWidth() + flexItem.x(), bottom);
                    return;
                } else {
                    view.layout(((left + i10) - view.getMeasuredWidth()) - flexItem.y(), top, ((right + i10) - view.getMeasuredWidth()) - flexItem.y(), bottom);
                    return;
                }
            }
            if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i10 - view.getMeasuredWidth()) + MarginLayoutParamsCompat.getMarginStart(marginLayoutParams)) - MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) / 2;
                if (isRtl) {
                    view.layout(left - measuredWidth, top, right - measuredWidth, bottom);
                    return;
                } else {
                    view.layout(left + measuredWidth, top, right + measuredWidth, bottom);
                    return;
                }
            }
            if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (isRtl) {
            view.layout(left - flexItem.y(), top, right - flexItem.y(), bottom);
        } else {
            view.layout(left + flexItem.x(), top, right + flexItem.x(), bottom);
        }
    }

    @VisibleForTesting
    public long S(int widthMeasureSpec, int heightMeasureSpec) {
        return (widthMeasureSpec & 4294967295L) | (heightMeasureSpec << 32);
    }

    public final void T(int widthMeasureSpec, int heightMeasureSpec, com.google.android.flexbox.a flexLine, int maxMainSize, int paddingAlongMainAxis, boolean calledRecursively) {
        int i10;
        int i11;
        int i12;
        int i13 = flexLine.f9070e;
        float f10 = flexLine.f9076k;
        float f11 = 0.0f;
        if (f10 <= 0.0f || maxMainSize > i13) {
            return;
        }
        float f12 = (i13 - maxMainSize) / f10;
        flexLine.f9070e = paddingAlongMainAxis + flexLine.f9071f;
        if (!calledRecursively) {
            flexLine.f9072g = Integer.MIN_VALUE;
        }
        int i14 = 0;
        boolean z10 = false;
        int i15 = 0;
        float f13 = 0.0f;
        while (i14 < flexLine.f9073h) {
            int i16 = flexLine.f9080o + i14;
            View g10 = this.f9087a.g(i16);
            if (g10 == null || g10.getVisibility() == 8) {
                i10 = i13;
                i11 = i14;
            } else {
                FlexItem flexItem = (FlexItem) g10.getLayoutParams();
                int flexDirection = this.f9087a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    i10 = i13;
                    int i17 = i14;
                    int measuredWidth = g10.getMeasuredWidth();
                    long[] jArr = this.f9091e;
                    if (jArr != null) {
                        measuredWidth = y(jArr[i16]);
                    }
                    int measuredHeight = g10.getMeasuredHeight();
                    long[] jArr2 = this.f9091e;
                    if (jArr2 != null) {
                        measuredHeight = x(jArr2[i16]);
                    }
                    if (this.f9088b[i16] || flexItem.h() <= 0.0f) {
                        i11 = i17;
                    } else {
                        float h10 = measuredWidth - (flexItem.h() * f12);
                        i11 = i17;
                        if (i11 == flexLine.f9073h - 1) {
                            h10 += f13;
                            f13 = 0.0f;
                        }
                        int round = Math.round(h10);
                        if (round < flexItem.k()) {
                            round = flexItem.k();
                            this.f9088b[i16] = true;
                            flexLine.f9076k -= flexItem.h();
                            z10 = true;
                        } else {
                            f13 += h10 - round;
                            double d10 = f13;
                            if (d10 > 1.0d) {
                                round++;
                                f13 -= 1.0f;
                            } else if (d10 < -1.0d) {
                                round--;
                                f13 += 1.0f;
                            }
                        }
                        int z11 = z(heightMeasureSpec, flexItem, flexLine.f9078m);
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                        g10.measure(makeMeasureSpec, z11);
                        int measuredWidth2 = g10.getMeasuredWidth();
                        int measuredHeight2 = g10.getMeasuredHeight();
                        Z(i16, makeMeasureSpec, z11, g10);
                        this.f9087a.h(i16, g10);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int max = Math.max(i15, measuredHeight + flexItem.m() + flexItem.w() + this.f9087a.e(g10));
                    flexLine.f9070e += measuredWidth + flexItem.x() + flexItem.y();
                    i12 = max;
                } else {
                    int measuredHeight3 = g10.getMeasuredHeight();
                    long[] jArr3 = this.f9091e;
                    if (jArr3 != null) {
                        measuredHeight3 = x(jArr3[i16]);
                    }
                    int measuredWidth3 = g10.getMeasuredWidth();
                    long[] jArr4 = this.f9091e;
                    if (jArr4 != null) {
                        measuredWidth3 = y(jArr4[i16]);
                    }
                    if (this.f9088b[i16] || flexItem.h() <= f11) {
                        i10 = i13;
                        i11 = i14;
                    } else {
                        float h11 = measuredHeight3 - (flexItem.h() * f12);
                        if (i14 == flexLine.f9073h - 1) {
                            h11 += f13;
                            f13 = 0.0f;
                        }
                        int round2 = Math.round(h11);
                        if (round2 < flexItem.z()) {
                            round2 = flexItem.z();
                            this.f9088b[i16] = true;
                            flexLine.f9076k -= flexItem.h();
                            i10 = i13;
                            i11 = i14;
                            z10 = true;
                        } else {
                            f13 += h11 - round2;
                            i10 = i13;
                            i11 = i14;
                            double d11 = f13;
                            if (d11 > 1.0d) {
                                round2++;
                                f13 -= 1.0f;
                            } else if (d11 < -1.0d) {
                                round2--;
                                f13 += 1.0f;
                            }
                        }
                        int A = A(widthMeasureSpec, flexItem, flexLine.f9078m);
                        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                        g10.measure(A, makeMeasureSpec2);
                        measuredWidth3 = g10.getMeasuredWidth();
                        int measuredHeight4 = g10.getMeasuredHeight();
                        Z(i16, A, makeMeasureSpec2, g10);
                        this.f9087a.h(i16, g10);
                        measuredHeight3 = measuredHeight4;
                    }
                    i12 = Math.max(i15, measuredWidth3 + flexItem.x() + flexItem.y() + this.f9087a.e(g10));
                    flexLine.f9070e += measuredHeight3 + flexItem.m() + flexItem.w();
                }
                flexLine.f9072g = Math.max(flexLine.f9072g, i12);
                i15 = i12;
            }
            i14 = i11 + 1;
            i13 = i10;
            f11 = 0.0f;
        }
        int i18 = i13;
        if (!z10 || i18 == flexLine.f9070e) {
            return;
        }
        T(widthMeasureSpec, heightMeasureSpec, flexLine, maxMainSize, paddingAlongMainAxis, true);
    }

    public final int[] U(int childCount, List<c> orders, SparseIntArray orderCache) {
        Collections.sort(orders);
        orderCache.clear();
        int[] iArr = new int[childCount];
        int i10 = 0;
        for (c cVar : orders) {
            int i11 = cVar.f9094b;
            iArr[i10] = i11;
            orderCache.append(i11, cVar.f9095c);
            i10++;
        }
        return iArr;
    }

    public final void V(View view, int crossSize, int index) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((crossSize - flexItem.x()) - flexItem.y()) - this.f9087a.e(view), flexItem.k()), flexItem.r());
        long[] jArr = this.f9091e;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? x(jArr[index]) : view.getMeasuredHeight(), 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        Z(index, makeMeasureSpec2, makeMeasureSpec, view);
        this.f9087a.h(index, view);
    }

    public final void W(View view, int crossSize, int index) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((crossSize - flexItem.m()) - flexItem.w()) - this.f9087a.e(view), flexItem.z()), flexItem.A());
        long[] jArr = this.f9091e;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? y(jArr[index]) : view.getMeasuredWidth(), 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        Z(index, makeMeasureSpec, makeMeasureSpec2, view);
        this.f9087a.h(index, view);
    }

    public void X() {
        Y(0);
    }

    public void Y(int fromIndex) {
        View g10;
        if (fromIndex >= this.f9087a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f9087a.getFlexDirection();
        if (this.f9087a.getAlignItems() != 4) {
            for (com.google.android.flexbox.a aVar : this.f9087a.getFlexLinesInternal()) {
                for (Integer num : aVar.f9079n) {
                    View g11 = this.f9087a.g(num.intValue());
                    if (flexDirection == 0 || flexDirection == 1) {
                        W(g11, aVar.f9072g, num.intValue());
                    } else {
                        if (flexDirection != 2 && flexDirection != 3) {
                            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                        }
                        V(g11, aVar.f9072g, num.intValue());
                    }
                }
            }
            return;
        }
        int[] iArr = this.f9089c;
        List<com.google.android.flexbox.a> flexLinesInternal = this.f9087a.getFlexLinesInternal();
        int size = flexLinesInternal.size();
        for (int i10 = iArr != null ? iArr[fromIndex] : 0; i10 < size; i10++) {
            com.google.android.flexbox.a aVar2 = flexLinesInternal.get(i10);
            int i11 = aVar2.f9073h;
            for (int i12 = 0; i12 < i11; i12++) {
                int i13 = aVar2.f9080o + i12;
                if (i12 < this.f9087a.getFlexItemCount() && (g10 = this.f9087a.g(i13)) != null && g10.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) g10.getLayoutParams();
                    if (flexItem.g() == -1 || flexItem.g() == 4) {
                        if (flexDirection == 0 || flexDirection == 1) {
                            W(g10, aVar2.f9072g, i13);
                        } else {
                            if (flexDirection != 2 && flexDirection != 3) {
                                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                            }
                            V(g10, aVar2.f9072g, i13);
                        }
                    }
                }
            }
        }
    }

    public final void Z(int index, int widthMeasureSpec, int heightMeasureSpec, View view) {
        long[] jArr = this.f9090d;
        if (jArr != null) {
            jArr[index] = S(widthMeasureSpec, heightMeasureSpec);
        }
        long[] jArr2 = this.f9091e;
        if (jArr2 != null) {
            jArr2[index] = S(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    public final void a(List<com.google.android.flexbox.a> flexLines, com.google.android.flexbox.a flexLine, int viewIndex, int usedCrossSizeSoFar) {
        flexLine.f9078m = usedCrossSizeSoFar;
        this.f9087a.f(flexLine);
        flexLine.f9081p = viewIndex;
        flexLines.add(flexLine);
    }

    public void b(C0255b result, int mainMeasureSpec, int crossMeasureSpec, int needsCalcAmount, int fromIndex, int toIndex, @Nullable List<com.google.android.flexbox.a> existingLines) {
        int i10;
        C0255b c0255b;
        int i11;
        int i12;
        int i13;
        List<com.google.android.flexbox.a> list;
        int i14;
        View view;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        com.google.android.flexbox.a aVar;
        int i23;
        int i24 = mainMeasureSpec;
        int i25 = crossMeasureSpec;
        int i26 = toIndex;
        boolean j10 = this.f9087a.j();
        int mode = View.MeasureSpec.getMode(mainMeasureSpec);
        int size = View.MeasureSpec.getSize(mainMeasureSpec);
        List<com.google.android.flexbox.a> arrayList = existingLines == null ? new ArrayList() : existingLines;
        result.f9092a = arrayList;
        boolean z10 = i26 == -1;
        int K = K(j10);
        int I = I(j10);
        int J = J(j10);
        int H = H(j10);
        com.google.android.flexbox.a aVar2 = new com.google.android.flexbox.a();
        int i27 = fromIndex;
        aVar2.f9080o = i27;
        int i28 = I + K;
        aVar2.f9070e = i28;
        int flexItemCount = this.f9087a.getFlexItemCount();
        boolean z11 = z10;
        int i29 = 0;
        int i30 = 0;
        int i31 = 0;
        int i32 = Integer.MIN_VALUE;
        while (true) {
            if (i27 >= flexItemCount) {
                i10 = i30;
                c0255b = result;
                break;
            }
            View g10 = this.f9087a.g(i27);
            if (g10 != null) {
                if (g10.getVisibility() != 8) {
                    if (g10 instanceof CompoundButton) {
                        v((CompoundButton) g10);
                    }
                    FlexItem flexItem = (FlexItem) g10.getLayoutParams();
                    int i33 = flexItemCount;
                    if (flexItem.g() == 4) {
                        aVar2.f9079n.add(Integer.valueOf(i27));
                    }
                    int G = G(flexItem, j10);
                    if (flexItem.p() != -1.0f && mode == 1073741824) {
                        G = Math.round(size * flexItem.p());
                    }
                    if (j10) {
                        int b10 = this.f9087a.b(i24, i28 + E(flexItem, true) + C(flexItem, true), G);
                        i11 = size;
                        i12 = mode;
                        int d10 = this.f9087a.d(i25, J + H + D(flexItem, true) + B(flexItem, true) + i29, F(flexItem, true));
                        g10.measure(b10, d10);
                        Z(i27, b10, d10, g10);
                        i13 = b10;
                    } else {
                        i11 = size;
                        i12 = mode;
                        int b11 = this.f9087a.b(i25, J + H + D(flexItem, false) + B(flexItem, false) + i29, F(flexItem, false));
                        int d11 = this.f9087a.d(i24, E(flexItem, false) + i28 + C(flexItem, false), G);
                        g10.measure(b11, d11);
                        Z(i27, b11, d11, g10);
                        i13 = d11;
                    }
                    this.f9087a.h(i27, g10);
                    i(g10, i27);
                    i30 = View.combineMeasuredStates(i30, g10.getMeasuredState());
                    int i34 = i29;
                    int i35 = i28;
                    com.google.android.flexbox.a aVar3 = aVar2;
                    int i36 = i27;
                    list = arrayList;
                    int i37 = i13;
                    if (P(g10, i12, i11, aVar2.f9070e, C(flexItem, j10) + M(g10, j10) + E(flexItem, j10), flexItem, i36, i31, arrayList.size())) {
                        i27 = i36;
                        if (aVar3.d() > 0) {
                            if (i27 > 0) {
                                i23 = i27 - 1;
                                aVar = aVar3;
                            } else {
                                aVar = aVar3;
                                i23 = 0;
                            }
                            a(list, aVar, i23, i34);
                            i29 = aVar.f9072g + i34;
                        } else {
                            i29 = i34;
                        }
                        if (!j10) {
                            i14 = crossMeasureSpec;
                            view = g10;
                            i17 = -1;
                            if (flexItem.getWidth() == -1) {
                                d dVar = this.f9087a;
                                view.measure(dVar.b(i14, dVar.getPaddingLeft() + this.f9087a.getPaddingRight() + flexItem.x() + flexItem.y() + i29, flexItem.getWidth()), i37);
                                i(view, i27);
                            }
                        } else if (flexItem.getHeight() == -1) {
                            d dVar2 = this.f9087a;
                            i14 = crossMeasureSpec;
                            i17 = -1;
                            view = g10;
                            view.measure(i37, dVar2.d(i14, dVar2.getPaddingTop() + this.f9087a.getPaddingBottom() + flexItem.m() + flexItem.w() + i29, flexItem.getHeight()));
                            i(view, i27);
                        } else {
                            i14 = crossMeasureSpec;
                            view = g10;
                            i17 = -1;
                        }
                        aVar2 = new com.google.android.flexbox.a();
                        i16 = 1;
                        aVar2.f9073h = 1;
                        i15 = i35;
                        aVar2.f9070e = i15;
                        aVar2.f9080o = i27;
                        i18 = 0;
                        i19 = Integer.MIN_VALUE;
                    } else {
                        i14 = crossMeasureSpec;
                        i27 = i36;
                        view = g10;
                        aVar2 = aVar3;
                        i15 = i35;
                        i16 = 1;
                        i17 = -1;
                        aVar2.f9073h++;
                        i18 = i31 + 1;
                        i29 = i34;
                        i19 = i32;
                    }
                    aVar2.f9082q |= flexItem.o() != 0.0f;
                    aVar2.f9083r |= flexItem.h() != 0.0f;
                    int[] iArr = this.f9089c;
                    if (iArr != null) {
                        iArr[i27] = list.size();
                    }
                    aVar2.f9070e += M(view, j10) + E(flexItem, j10) + C(flexItem, j10);
                    aVar2.f9075j += flexItem.o();
                    aVar2.f9076k += flexItem.h();
                    this.f9087a.a(view, i27, i18, aVar2);
                    int max = Math.max(i19, L(view, j10) + D(flexItem, j10) + B(flexItem, j10) + this.f9087a.e(view));
                    aVar2.f9072g = Math.max(aVar2.f9072g, max);
                    if (j10) {
                        if (this.f9087a.getFlexWrap() != 2) {
                            aVar2.f9077l = Math.max(aVar2.f9077l, view.getBaseline() + flexItem.m());
                        } else {
                            aVar2.f9077l = Math.max(aVar2.f9077l, (view.getMeasuredHeight() - view.getBaseline()) + flexItem.w());
                        }
                    }
                    i20 = i33;
                    if (N(i27, i20, aVar2)) {
                        a(list, aVar2, i27, i29);
                        i29 += aVar2.f9072g;
                    }
                    i21 = toIndex;
                    if (i21 == i17 || list.size() <= 0 || list.get(list.size() - i16).f9081p < i21 || i27 < i21 || z11) {
                        i22 = needsCalcAmount;
                    } else {
                        i29 = -aVar2.a();
                        i22 = needsCalcAmount;
                        z11 = true;
                    }
                    if (i29 > i22 && z11) {
                        c0255b = result;
                        i10 = i30;
                        break;
                    }
                    i31 = i18;
                    i32 = max;
                    i27++;
                    i24 = mainMeasureSpec;
                    flexItemCount = i20;
                    i25 = i14;
                    i28 = i15;
                    arrayList = list;
                    size = i11;
                    mode = i12;
                    i26 = i21;
                } else {
                    aVar2.f9074i++;
                    aVar2.f9073h++;
                    if (N(i27, flexItemCount, aVar2)) {
                        a(arrayList, aVar2, i27, i29);
                    }
                }
            } else if (N(i27, flexItemCount, aVar2)) {
                a(arrayList, aVar2, i27, i29);
            }
            i11 = size;
            i12 = mode;
            i14 = i25;
            i21 = i26;
            i15 = i28;
            list = arrayList;
            i20 = flexItemCount;
            i27++;
            i24 = mainMeasureSpec;
            flexItemCount = i20;
            i25 = i14;
            i28 = i15;
            arrayList = list;
            size = i11;
            mode = i12;
            i26 = i21;
        }
        c0255b.f9093b = i10;
    }

    public void c(C0255b result, int widthMeasureSpec, int heightMeasureSpec) {
        b(result, widthMeasureSpec, heightMeasureSpec, Integer.MAX_VALUE, 0, -1, null);
    }

    public void d(C0255b result, int widthMeasureSpec, int heightMeasureSpec, int needsCalcAmount, int fromIndex, @Nullable List<com.google.android.flexbox.a> existingLines) {
        b(result, widthMeasureSpec, heightMeasureSpec, needsCalcAmount, fromIndex, -1, existingLines);
    }

    public void e(C0255b result, int widthMeasureSpec, int heightMeasureSpec, int needsCalcAmount, int toIndex, List<com.google.android.flexbox.a> existingLines) {
        b(result, widthMeasureSpec, heightMeasureSpec, needsCalcAmount, 0, toIndex, existingLines);
    }

    public void f(C0255b result, int widthMeasureSpec, int heightMeasureSpec) {
        b(result, heightMeasureSpec, widthMeasureSpec, Integer.MAX_VALUE, 0, -1, null);
    }

    public void g(C0255b result, int widthMeasureSpec, int heightMeasureSpec, int needsCalcAmount, int fromIndex, @Nullable List<com.google.android.flexbox.a> existingLines) {
        b(result, heightMeasureSpec, widthMeasureSpec, needsCalcAmount, fromIndex, -1, existingLines);
    }

    public void h(C0255b result, int widthMeasureSpec, int heightMeasureSpec, int needsCalcAmount, int toIndex, List<com.google.android.flexbox.a> existingLines) {
        b(result, heightMeasureSpec, widthMeasureSpec, needsCalcAmount, 0, toIndex, existingLines);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i(android.view.View r7, int r8) {
        /*
            r6 = this;
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            com.google.android.flexbox.FlexItem r0 = (com.google.android.flexbox.FlexItem) r0
            int r1 = r7.getMeasuredWidth()
            int r2 = r7.getMeasuredHeight()
            int r3 = r0.k()
            r4 = 1
            if (r1 >= r3) goto L1b
            int r1 = r0.k()
        L19:
            r3 = 1
            goto L27
        L1b:
            int r3 = r0.r()
            if (r1 <= r3) goto L26
            int r1 = r0.r()
            goto L19
        L26:
            r3 = 0
        L27:
            int r5 = r0.z()
            if (r2 >= r5) goto L32
            int r2 = r0.z()
            goto L3e
        L32:
            int r5 = r0.A()
            if (r2 <= r5) goto L3d
            int r2 = r0.A()
            goto L3e
        L3d:
            r4 = r3
        L3e:
            if (r4 == 0) goto L55
            r0 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r0)
            r7.measure(r1, r0)
            r6.Z(r8, r1, r0, r7)
            s4.d r0 = r6.f9087a
            r0.h(r8, r7)
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.b.i(android.view.View, int):void");
    }

    public void j(List<com.google.android.flexbox.a> flexLines, int fromFlexItem) {
        int i10 = this.f9089c[fromFlexItem];
        if (i10 == -1) {
            i10 = 0;
        }
        if (flexLines.size() > i10) {
            flexLines.subList(i10, flexLines.size()).clear();
        }
        int[] iArr = this.f9089c;
        int length = iArr.length - 1;
        if (fromFlexItem > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, fromFlexItem, length, -1);
        }
        long[] jArr = this.f9090d;
        int length2 = jArr.length - 1;
        if (fromFlexItem > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, fromFlexItem, length2, 0L);
        }
    }

    public final List<com.google.android.flexbox.a> k(List<com.google.android.flexbox.a> flexLines, int size, int totalCrossSize) {
        int i10 = (size - totalCrossSize) / 2;
        ArrayList arrayList = new ArrayList();
        com.google.android.flexbox.a aVar = new com.google.android.flexbox.a();
        aVar.f9072g = i10;
        int size2 = flexLines.size();
        for (int i11 = 0; i11 < size2; i11++) {
            if (i11 == 0) {
                arrayList.add(aVar);
            }
            arrayList.add(flexLines.get(i11));
            if (i11 == flexLines.size() - 1) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    @NonNull
    public final List<c> l(int childCount) {
        ArrayList arrayList = new ArrayList(childCount);
        for (int i10 = 0; i10 < childCount; i10++) {
            FlexItem flexItem = (FlexItem) this.f9087a.c(i10).getLayoutParams();
            c cVar = new c();
            cVar.f9095c = flexItem.getOrder();
            cVar.f9094b = i10;
            arrayList.add(cVar);
        }
        return arrayList;
    }

    public int[] m(SparseIntArray orderCache) {
        int flexItemCount = this.f9087a.getFlexItemCount();
        return U(flexItemCount, l(flexItemCount), orderCache);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int[] n(View viewBeforeAdded, int indexForViewBeforeAdded, ViewGroup.LayoutParams paramsForViewBeforeAdded, SparseIntArray orderCache) {
        int flexItemCount = this.f9087a.getFlexItemCount();
        List<c> l10 = l(flexItemCount);
        c cVar = new c();
        if (viewBeforeAdded == null || !(paramsForViewBeforeAdded instanceof FlexItem)) {
            cVar.f9095c = 1;
        } else {
            cVar.f9095c = ((FlexItem) paramsForViewBeforeAdded).getOrder();
        }
        if (indexForViewBeforeAdded == -1 || indexForViewBeforeAdded == flexItemCount) {
            cVar.f9094b = flexItemCount;
        } else if (indexForViewBeforeAdded < this.f9087a.getFlexItemCount()) {
            cVar.f9094b = indexForViewBeforeAdded;
            while (indexForViewBeforeAdded < flexItemCount) {
                l10.get(indexForViewBeforeAdded).f9094b++;
                indexForViewBeforeAdded++;
            }
        } else {
            cVar.f9094b = flexItemCount;
        }
        l10.add(cVar);
        return U(flexItemCount + 1, l10, orderCache);
    }

    public void o(int widthMeasureSpec, int heightMeasureSpec, int paddingAlongCrossAxis) {
        int i10;
        int i11;
        int flexDirection = this.f9087a.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode = View.MeasureSpec.getMode(heightMeasureSpec);
            int size = View.MeasureSpec.getSize(heightMeasureSpec);
            i10 = mode;
            i11 = size;
        } else {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            i10 = View.MeasureSpec.getMode(widthMeasureSpec);
            i11 = View.MeasureSpec.getSize(widthMeasureSpec);
        }
        List<com.google.android.flexbox.a> flexLinesInternal = this.f9087a.getFlexLinesInternal();
        if (i10 == 1073741824) {
            int sumOfCrossSize = this.f9087a.getSumOfCrossSize() + paddingAlongCrossAxis;
            int i12 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).f9072g = i11 - paddingAlongCrossAxis;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.f9087a.getAlignContent();
                if (alignContent == 1) {
                    int i13 = i11 - sumOfCrossSize;
                    com.google.android.flexbox.a aVar = new com.google.android.flexbox.a();
                    aVar.f9072g = i13;
                    flexLinesInternal.add(0, aVar);
                    return;
                }
                if (alignContent == 2) {
                    this.f9087a.setFlexLines(k(flexLinesInternal, i11, sumOfCrossSize));
                    return;
                }
                if (alignContent == 3) {
                    if (sumOfCrossSize >= i11) {
                        return;
                    }
                    float size2 = (i11 - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                    ArrayList arrayList = new ArrayList();
                    int size3 = flexLinesInternal.size();
                    float f10 = 0.0f;
                    while (i12 < size3) {
                        arrayList.add(flexLinesInternal.get(i12));
                        if (i12 != flexLinesInternal.size() - 1) {
                            com.google.android.flexbox.a aVar2 = new com.google.android.flexbox.a();
                            if (i12 == flexLinesInternal.size() - 2) {
                                aVar2.f9072g = Math.round(f10 + size2);
                                f10 = 0.0f;
                            } else {
                                aVar2.f9072g = Math.round(size2);
                            }
                            int i14 = aVar2.f9072g;
                            f10 += size2 - i14;
                            if (f10 > 1.0f) {
                                aVar2.f9072g = i14 + 1;
                                f10 -= 1.0f;
                            } else if (f10 < -1.0f) {
                                aVar2.f9072g = i14 - 1;
                                f10 += 1.0f;
                            }
                            arrayList.add(aVar2);
                        }
                        i12++;
                    }
                    this.f9087a.setFlexLines(arrayList);
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= i11) {
                        this.f9087a.setFlexLines(k(flexLinesInternal, i11, sumOfCrossSize));
                        return;
                    }
                    int size4 = (i11 - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    com.google.android.flexbox.a aVar3 = new com.google.android.flexbox.a();
                    aVar3.f9072g = size4;
                    for (com.google.android.flexbox.a aVar4 : flexLinesInternal) {
                        arrayList2.add(aVar3);
                        arrayList2.add(aVar4);
                        arrayList2.add(aVar3);
                    }
                    this.f9087a.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < i11) {
                    float size5 = (i11 - sumOfCrossSize) / flexLinesInternal.size();
                    int size6 = flexLinesInternal.size();
                    float f11 = 0.0f;
                    while (i12 < size6) {
                        com.google.android.flexbox.a aVar5 = flexLinesInternal.get(i12);
                        float f12 = aVar5.f9072g + size5;
                        if (i12 == flexLinesInternal.size() - 1) {
                            f12 += f11;
                            f11 = 0.0f;
                        }
                        int round = Math.round(f12);
                        f11 += f12 - round;
                        if (f11 > 1.0f) {
                            round++;
                            f11 -= 1.0f;
                        } else if (f11 < -1.0f) {
                            round--;
                            f11 += 1.0f;
                        }
                        aVar5.f9072g = round;
                        i12++;
                    }
                }
            }
        }
    }

    public void p(int widthMeasureSpec, int heightMeasureSpec) {
        q(widthMeasureSpec, heightMeasureSpec, 0);
    }

    public void q(int widthMeasureSpec, int heightMeasureSpec, int fromIndex) {
        int size;
        int paddingLeft;
        int paddingRight;
        r(this.f9087a.getFlexItemCount());
        if (fromIndex >= this.f9087a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f9087a.getFlexDirection();
        int flexDirection2 = this.f9087a.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(widthMeasureSpec);
            size = View.MeasureSpec.getSize(widthMeasureSpec);
            int largestMainSize = this.f9087a.getLargestMainSize();
            if (mode != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.f9087a.getPaddingLeft();
            paddingRight = this.f9087a.getPaddingRight();
        } else {
            if (flexDirection2 != 2 && flexDirection2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
            size = View.MeasureSpec.getSize(heightMeasureSpec);
            if (mode2 != 1073741824) {
                size = this.f9087a.getLargestMainSize();
            }
            paddingLeft = this.f9087a.getPaddingTop();
            paddingRight = this.f9087a.getPaddingBottom();
        }
        int i10 = paddingLeft + paddingRight;
        int[] iArr = this.f9089c;
        List<com.google.android.flexbox.a> flexLinesInternal = this.f9087a.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i11 = iArr != null ? iArr[fromIndex] : 0; i11 < size2; i11++) {
            com.google.android.flexbox.a aVar = flexLinesInternal.get(i11);
            int i12 = aVar.f9070e;
            if (i12 < size && aVar.f9082q) {
                w(widthMeasureSpec, heightMeasureSpec, aVar, size, i10, false);
            } else if (i12 > size && aVar.f9083r) {
                T(widthMeasureSpec, heightMeasureSpec, aVar, size, i10, false);
            }
        }
    }

    public final void r(int size) {
        boolean[] zArr = this.f9088b;
        if (zArr == null) {
            this.f9088b = new boolean[Math.max(size, 10)];
        } else if (zArr.length < size) {
            this.f9088b = new boolean[Math.max(zArr.length * 2, size)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    public void s(int size) {
        int[] iArr = this.f9089c;
        if (iArr == null) {
            this.f9089c = new int[Math.max(size, 10)];
        } else if (iArr.length < size) {
            this.f9089c = Arrays.copyOf(this.f9089c, Math.max(iArr.length * 2, size));
        }
    }

    public void t(int size) {
        long[] jArr = this.f9090d;
        if (jArr == null) {
            this.f9090d = new long[Math.max(size, 10)];
        } else if (jArr.length < size) {
            this.f9090d = Arrays.copyOf(this.f9090d, Math.max(jArr.length * 2, size));
        }
    }

    public void u(int size) {
        long[] jArr = this.f9091e;
        if (jArr == null) {
            this.f9091e = new long[Math.max(size, 10)];
        } else if (jArr.length < size) {
            this.f9091e = Arrays.copyOf(this.f9091e, Math.max(jArr.length * 2, size));
        }
    }

    public final void v(CompoundButton compoundButton) {
        FlexItem flexItem = (FlexItem) compoundButton.getLayoutParams();
        int k10 = flexItem.k();
        int z10 = flexItem.z();
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(compoundButton);
        int minimumWidth = buttonDrawable == null ? 0 : buttonDrawable.getMinimumWidth();
        int minimumHeight = buttonDrawable != null ? buttonDrawable.getMinimumHeight() : 0;
        if (k10 == -1) {
            k10 = minimumWidth;
        }
        flexItem.v(k10);
        if (z10 == -1) {
            z10 = minimumHeight;
        }
        flexItem.n(z10);
    }

    public final void w(int widthMeasureSpec, int heightMeasureSpec, com.google.android.flexbox.a flexLine, int maxMainSize, int paddingAlongMainAxis, boolean calledRecursively) {
        int i10;
        int i11;
        int i12;
        double d10;
        int i13;
        double d11;
        float f10 = flexLine.f9075j;
        float f11 = 0.0f;
        if (f10 <= 0.0f || maxMainSize < (i10 = flexLine.f9070e)) {
            return;
        }
        float f12 = (maxMainSize - i10) / f10;
        flexLine.f9070e = paddingAlongMainAxis + flexLine.f9071f;
        if (!calledRecursively) {
            flexLine.f9072g = Integer.MIN_VALUE;
        }
        int i14 = 0;
        boolean z10 = false;
        int i15 = 0;
        float f13 = 0.0f;
        while (i14 < flexLine.f9073h) {
            int i16 = flexLine.f9080o + i14;
            View g10 = this.f9087a.g(i16);
            if (g10 == null || g10.getVisibility() == 8) {
                i11 = i10;
            } else {
                FlexItem flexItem = (FlexItem) g10.getLayoutParams();
                int flexDirection = this.f9087a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    int i17 = i10;
                    int measuredWidth = g10.getMeasuredWidth();
                    long[] jArr = this.f9091e;
                    if (jArr != null) {
                        measuredWidth = y(jArr[i16]);
                    }
                    int measuredHeight = g10.getMeasuredHeight();
                    long[] jArr2 = this.f9091e;
                    i11 = i17;
                    if (jArr2 != null) {
                        measuredHeight = x(jArr2[i16]);
                    }
                    if (!this.f9088b[i16] && flexItem.o() > 0.0f) {
                        float o10 = measuredWidth + (flexItem.o() * f12);
                        if (i14 == flexLine.f9073h - 1) {
                            o10 += f13;
                            f13 = 0.0f;
                        }
                        int round = Math.round(o10);
                        if (round > flexItem.r()) {
                            round = flexItem.r();
                            this.f9088b[i16] = true;
                            flexLine.f9075j -= flexItem.o();
                            z10 = true;
                        } else {
                            f13 += o10 - round;
                            double d12 = f13;
                            if (d12 > 1.0d) {
                                round++;
                                d10 = d12 - 1.0d;
                            } else if (d12 < -1.0d) {
                                round--;
                                d10 = d12 + 1.0d;
                            }
                            f13 = (float) d10;
                        }
                        int z11 = z(heightMeasureSpec, flexItem, flexLine.f9078m);
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                        g10.measure(makeMeasureSpec, z11);
                        int measuredWidth2 = g10.getMeasuredWidth();
                        int measuredHeight2 = g10.getMeasuredHeight();
                        Z(i16, makeMeasureSpec, z11, g10);
                        this.f9087a.h(i16, g10);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int max = Math.max(i15, measuredHeight + flexItem.m() + flexItem.w() + this.f9087a.e(g10));
                    flexLine.f9070e += measuredWidth + flexItem.x() + flexItem.y();
                    i12 = max;
                } else {
                    int measuredHeight3 = g10.getMeasuredHeight();
                    long[] jArr3 = this.f9091e;
                    if (jArr3 != null) {
                        measuredHeight3 = x(jArr3[i16]);
                    }
                    int measuredWidth3 = g10.getMeasuredWidth();
                    long[] jArr4 = this.f9091e;
                    if (jArr4 != null) {
                        measuredWidth3 = y(jArr4[i16]);
                    }
                    if (this.f9088b[i16] || flexItem.o() <= f11) {
                        i13 = i10;
                    } else {
                        float o11 = measuredHeight3 + (flexItem.o() * f12);
                        if (i14 == flexLine.f9073h - 1) {
                            o11 += f13;
                            f13 = 0.0f;
                        }
                        int round2 = Math.round(o11);
                        if (round2 > flexItem.A()) {
                            round2 = flexItem.A();
                            this.f9088b[i16] = true;
                            flexLine.f9075j -= flexItem.o();
                            i13 = i10;
                            z10 = true;
                        } else {
                            f13 += o11 - round2;
                            i13 = i10;
                            double d13 = f13;
                            if (d13 > 1.0d) {
                                round2++;
                                d11 = d13 - 1.0d;
                            } else if (d13 < -1.0d) {
                                round2--;
                                d11 = d13 + 1.0d;
                            }
                            f13 = (float) d11;
                        }
                        int A = A(widthMeasureSpec, flexItem, flexLine.f9078m);
                        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                        g10.measure(A, makeMeasureSpec2);
                        measuredWidth3 = g10.getMeasuredWidth();
                        int measuredHeight4 = g10.getMeasuredHeight();
                        Z(i16, A, makeMeasureSpec2, g10);
                        this.f9087a.h(i16, g10);
                        measuredHeight3 = measuredHeight4;
                    }
                    i12 = Math.max(i15, measuredWidth3 + flexItem.x() + flexItem.y() + this.f9087a.e(g10));
                    flexLine.f9070e += measuredHeight3 + flexItem.m() + flexItem.w();
                    i11 = i13;
                }
                flexLine.f9072g = Math.max(flexLine.f9072g, i12);
                i15 = i12;
            }
            i14++;
            i10 = i11;
            f11 = 0.0f;
        }
        int i18 = i10;
        if (!z10 || i18 == flexLine.f9070e) {
            return;
        }
        w(widthMeasureSpec, heightMeasureSpec, flexLine, maxMainSize, paddingAlongMainAxis, true);
    }

    public int x(long longValue) {
        return (int) (longValue >> 32);
    }

    public int y(long longValue) {
        return (int) longValue;
    }

    public final int z(int heightMeasureSpec, FlexItem flexItem, int padding) {
        d dVar = this.f9087a;
        int d10 = dVar.d(heightMeasureSpec, dVar.getPaddingTop() + this.f9087a.getPaddingBottom() + flexItem.m() + flexItem.w() + padding, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(d10);
        return size > flexItem.A() ? View.MeasureSpec.makeMeasureSpec(flexItem.A(), View.MeasureSpec.getMode(d10)) : size < flexItem.z() ? View.MeasureSpec.makeMeasureSpec(flexItem.z(), View.MeasureSpec.getMode(d10)) : d10;
    }
}
