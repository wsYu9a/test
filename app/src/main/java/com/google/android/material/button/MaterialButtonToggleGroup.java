package com.google.android.material.button;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.annotation.BoolRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.u;
import com.google.android.material.j.o;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* renamed from: a */
    private static final String f6881a = MaterialButtonToggleGroup.class.getSimpleName();

    /* renamed from: b */
    private static final int f6882b = R.style.Widget_MaterialComponents_MaterialButtonToggleGroup;

    /* renamed from: c */
    private final List<d> f6883c;

    /* renamed from: d */
    private final c f6884d;

    /* renamed from: e */
    private final f f6885e;

    /* renamed from: f */
    private final LinkedHashSet<e> f6886f;

    /* renamed from: g */
    private final Comparator<MaterialButton> f6887g;

    /* renamed from: h */
    private Integer[] f6888h;

    /* renamed from: i */
    private boolean f6889i;

    /* renamed from: j */
    private boolean f6890j;
    private boolean k;

    @IdRes
    private int l;

    class a implements Comparator<MaterialButton> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
            int compareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
            if (compareTo != 0) {
                return compareTo;
            }
            int compareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
            return compareTo2 != 0 ? compareTo2 : Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton2)));
        }
    }

    class b extends AccessibilityDelegateCompat {
        b() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, MaterialButtonToggleGroup.this.p(view), 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    private class c implements MaterialButton.b {
        private c() {
        }

        @Override // com.google.android.material.button.MaterialButton.b
        public void a(@NonNull MaterialButton materialButton, boolean z) {
            if (MaterialButtonToggleGroup.this.f6889i) {
                return;
            }
            if (MaterialButtonToggleGroup.this.f6890j) {
                MaterialButtonToggleGroup.this.l = z ? materialButton.getId() : -1;
            }
            if (MaterialButtonToggleGroup.this.z(materialButton.getId(), z)) {
                MaterialButtonToggleGroup.this.n(materialButton.getId(), materialButton.isChecked());
            }
            MaterialButtonToggleGroup.this.invalidate();
        }

        /* synthetic */ c(MaterialButtonToggleGroup materialButtonToggleGroup, a aVar) {
            this();
        }
    }

    private static class d {

        /* renamed from: a */
        private static final com.google.android.material.j.d f6894a = new com.google.android.material.j.a(0.0f);

        /* renamed from: b */
        com.google.android.material.j.d f6895b;

        /* renamed from: c */
        com.google.android.material.j.d f6896c;

        /* renamed from: d */
        com.google.android.material.j.d f6897d;

        /* renamed from: e */
        com.google.android.material.j.d f6898e;

        d(com.google.android.material.j.d dVar, com.google.android.material.j.d dVar2, com.google.android.material.j.d dVar3, com.google.android.material.j.d dVar4) {
            this.f6895b = dVar;
            this.f6896c = dVar3;
            this.f6897d = dVar4;
            this.f6898e = dVar2;
        }

        public static d a(d dVar) {
            com.google.android.material.j.d dVar2 = f6894a;
            return new d(dVar2, dVar.f6898e, dVar2, dVar.f6897d);
        }

        public static d b(d dVar, View view) {
            return u.i(view) ? c(dVar) : d(dVar);
        }

        public static d c(d dVar) {
            com.google.android.material.j.d dVar2 = dVar.f6895b;
            com.google.android.material.j.d dVar3 = dVar.f6898e;
            com.google.android.material.j.d dVar4 = f6894a;
            return new d(dVar2, dVar3, dVar4, dVar4);
        }

        public static d d(d dVar) {
            com.google.android.material.j.d dVar2 = f6894a;
            return new d(dVar2, dVar2, dVar.f6896c, dVar.f6897d);
        }

        public static d e(d dVar, View view) {
            return u.i(view) ? d(dVar) : c(dVar);
        }

        public static d f(d dVar) {
            com.google.android.material.j.d dVar2 = dVar.f6895b;
            com.google.android.material.j.d dVar3 = f6894a;
            return new d(dVar2, dVar3, dVar.f6896c, dVar3);
        }
    }

    public interface e {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, @IdRes int i2, boolean z);
    }

    private class f implements MaterialButton.c {
        private f() {
        }

        @Override // com.google.android.material.button.MaterialButton.c
        public void a(@NonNull MaterialButton materialButton, boolean z) {
            MaterialButtonToggleGroup.this.invalidate();
        }

        /* synthetic */ f(MaterialButtonToggleGroup materialButtonToggleGroup, a aVar) {
            this();
        }
    }

    public MaterialButtonToggleGroup(@NonNull Context context) {
        this(context, null);
    }

    private void A() {
        TreeMap treeMap = new TreeMap(this.f6887g);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            treeMap.put(o(i2), Integer.valueOf(i2));
        }
        this.f6888h = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (r(i2)) {
                return i2;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (r(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if ((getChildAt(i3) instanceof MaterialButton) && r(i3)) {
                i2++;
            }
        }
        return i2;
    }

    private void h() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i2 = firstVisibleChildIndex + 1; i2 < getChildCount(); i2++) {
            MaterialButton o = o(i2);
            int min = Math.min(o.getStrokeWidth(), o(i2 - 1).getStrokeWidth());
            LinearLayout.LayoutParams i3 = i(o);
            if (getOrientation() == 0) {
                MarginLayoutParamsCompat.setMarginEnd(i3, 0);
                MarginLayoutParamsCompat.setMarginStart(i3, -min);
            } else {
                i3.bottomMargin = 0;
                i3.topMargin = -min;
            }
            o.setLayoutParams(i3);
        }
        v(firstVisibleChildIndex);
    }

    @NonNull
    private LinearLayout.LayoutParams i(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    private void k(int i2) {
        w(i2, true);
        z(i2, true);
        setCheckedId(i2);
    }

    public void n(@IdRes int i2, boolean z) {
        Iterator<e> it = this.f6886f.iterator();
        while (it.hasNext()) {
            it.next().a(this, i2, z);
        }
    }

    private MaterialButton o(int i2) {
        return (MaterialButton) getChildAt(i2);
    }

    public int p(@Nullable View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (getChildAt(i3) == view) {
                return i2;
            }
            if ((getChildAt(i3) instanceof MaterialButton) && r(i3)) {
                i2++;
            }
        }
        return -1;
    }

    @Nullable
    private d q(int i2, int i3, int i4) {
        d dVar = this.f6883c.get(i2);
        if (i3 == i4) {
            return dVar;
        }
        boolean z = getOrientation() == 0;
        if (i2 == i3) {
            return z ? d.e(dVar, this) : d.f(dVar);
        }
        if (i2 == i4) {
            return z ? d.b(dVar, this) : d.a(dVar);
        }
        return null;
    }

    private boolean r(int i2) {
        return getChildAt(i2).getVisibility() != 8;
    }

    private void setCheckedId(int i2) {
        this.l = i2;
        n(i2, true);
    }

    private void setGeneratedIdIfNeeded(@NonNull MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(ViewCompat.generateViewId());
        }
    }

    private void setupButtonChild(@NonNull MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.a(this.f6884d);
        materialButton.setOnPressedChangeListenerInternal(this.f6885e);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    private void v(int i2) {
        if (getChildCount() == 0 || i2 == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) o(i2).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
        } else {
            MarginLayoutParamsCompat.setMarginEnd(layoutParams, 0);
            MarginLayoutParamsCompat.setMarginStart(layoutParams, 0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    private void w(@IdRes int i2, boolean z) {
        View findViewById = findViewById(i2);
        if (findViewById instanceof MaterialButton) {
            this.f6889i = true;
            ((MaterialButton) findViewById).setChecked(z);
            this.f6889i = false;
        }
    }

    private static void y(o.b bVar, @Nullable d dVar) {
        if (dVar == null) {
            bVar.o(0.0f);
        } else {
            bVar.L(dVar.f6895b).y(dVar.f6898e).Q(dVar.f6896c).D(dVar.f6897d);
        }
    }

    public boolean z(int i2, boolean z) {
        List<Integer> checkedButtonIds = getCheckedButtonIds();
        if (this.k && checkedButtonIds.isEmpty()) {
            w(i2, true);
            this.l = i2;
            return false;
        }
        if (z && this.f6890j) {
            checkedButtonIds.remove(Integer.valueOf(i2));
            Iterator<Integer> it = checkedButtonIds.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                w(intValue, false);
                n(intValue, false);
            }
        }
        return true;
    }

    @VisibleForTesting
    void B() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i2 = 0; i2 < childCount; i2++) {
            MaterialButton o = o(i2);
            if (o.getVisibility() != 8) {
                o.b v = o.getShapeAppearanceModel().v();
                y(v, q(i2, firstVisibleChildIndex, lastVisibleChildIndex));
                o.setShapeAppearanceModel(v.m());
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e(f6881a, "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i2, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        if (materialButton.isChecked()) {
            z(materialButton.getId(), true);
            setCheckedId(materialButton.getId());
        }
        o shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.f6883c.add(new d(shapeAppearanceModel.r(), shapeAppearanceModel.j(), shapeAppearanceModel.t(), shapeAppearanceModel.l()));
        ViewCompat.setAccessibilityDelegate(materialButton, new b());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NonNull Canvas canvas) {
        A();
        super.dispatchDraw(canvas);
    }

    public void g(@NonNull e eVar) {
        this.f6886f.add(eVar);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return MaterialButtonToggleGroup.class.getName();
    }

    @IdRes
    public int getCheckedButtonId() {
        if (this.f6890j) {
            return this.l;
        }
        return -1;
    }

    @NonNull
    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            MaterialButton o = o(i2);
            if (o.isChecked()) {
                arrayList.add(Integer.valueOf(o.getId()));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        Integer[] numArr = this.f6888h;
        if (numArr != null && i3 < numArr.length) {
            return numArr[i3].intValue();
        }
        Log.w(f6881a, "Child order wasn't updated");
        return i3;
    }

    public void j(@IdRes int i2) {
        if (i2 == this.l) {
            return;
        }
        k(i2);
    }

    public void l() {
        this.f6889i = true;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            MaterialButton o = o(i2);
            o.setChecked(false);
            n(o.getId(), false);
        }
        this.f6889i = false;
        setCheckedId(-1);
    }

    public void m() {
        this.f6886f.clear();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i2 = this.l;
        if (i2 != -1) {
            k(i2);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getVisibleButtonCount(), false, t() ? 1 : 2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        B();
        h();
        super.onMeasure(i2, i3);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            MaterialButton materialButton = (MaterialButton) view;
            materialButton.f(this.f6884d);
            materialButton.setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.f6883c.remove(indexOfChild);
        }
        B();
        h();
    }

    public boolean s() {
        return this.k;
    }

    public void setSelectionRequired(boolean z) {
        this.k = z;
    }

    public void setSingleSelection(boolean z) {
        if (this.f6890j != z) {
            this.f6890j = z;
            l();
        }
    }

    public boolean t() {
        return this.f6890j;
    }

    public void u(@NonNull e eVar) {
        this.f6886f.remove(eVar);
    }

    public void x(@IdRes int i2) {
        w(i2, false);
        z(i2, false);
        this.l = -1;
        n(i2, false);
    }

    public MaterialButtonToggleGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonToggleGroupStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MaterialButtonToggleGroup(@androidx.annotation.NonNull android.content.Context r7, @androidx.annotation.Nullable android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = com.google.android.material.button.MaterialButtonToggleGroup.f6882b
            android.content.Context r7 = com.google.android.material.theme.a.a.c(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r6.f6883c = r7
            com.google.android.material.button.MaterialButtonToggleGroup$c r7 = new com.google.android.material.button.MaterialButtonToggleGroup$c
            r0 = 0
            r7.<init>(r6, r0)
            r6.f6884d = r7
            com.google.android.material.button.MaterialButtonToggleGroup$f r7 = new com.google.android.material.button.MaterialButtonToggleGroup$f
            r7.<init>(r6, r0)
            r6.f6885e = r7
            java.util.LinkedHashSet r7 = new java.util.LinkedHashSet
            r7.<init>()
            r6.f6886f = r7
            com.google.android.material.button.MaterialButtonToggleGroup$a r7 = new com.google.android.material.button.MaterialButtonToggleGroup$a
            r7.<init>()
            r6.f6887g = r7
            r7 = 0
            r6.f6889i = r7
            android.content.Context r0 = r6.getContext()
            int[] r2 = com.google.android.material.R.styleable.MaterialButtonToggleGroup
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.n.j(r0, r1, r2, r3, r4, r5)
            int r9 = com.google.android.material.R.styleable.MaterialButtonToggleGroup_singleSelection
            boolean r9 = r8.getBoolean(r9, r7)
            r6.setSingleSelection(r9)
            int r9 = com.google.android.material.R.styleable.MaterialButtonToggleGroup_checkedButton
            r0 = -1
            int r9 = r8.getResourceId(r9, r0)
            r6.l = r9
            int r9 = com.google.android.material.R.styleable.MaterialButtonToggleGroup_selectionRequired
            boolean r7 = r8.getBoolean(r9, r7)
            r6.k = r7
            r7 = 1
            r6.setChildrenDrawingOrderEnabled(r7)
            r8.recycle()
            androidx.core.view.ViewCompat.setImportantForAccessibility(r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButtonToggleGroup.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setSingleSelection(@BoolRes int i2) {
        setSingleSelection(getResources().getBoolean(i2));
    }
}
