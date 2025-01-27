package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import java.util.Calendar;

/* loaded from: classes.dex */
final class MaterialCalendarGridView extends GridView {

    /* renamed from: a */
    private final Calendar f6999a;

    class a extends AccessibilityDelegateCompat {
        a() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo(null);
        }
    }

    public MaterialCalendarGridView(Context context) {
        this(context, null);
    }

    private void a(int i2, Rect rect) {
        if (i2 == 33) {
            setSelection(getAdapter().h());
        } else if (i2 == 130) {
            setSelection(getAdapter().b());
        } else {
            super.onFocusChanged(true, i2, rect);
        }
    }

    private static int c(@NonNull View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private static boolean d(@Nullable Long l, @Nullable Long l2, @Nullable Long l3, @Nullable Long l4) {
        return l == null || l2 == null || l3 == null || l4 == null || l3.longValue() > l2.longValue() || l4.longValue() < l.longValue();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public o getAdapter2() {
        return (o) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    protected final void onDraw(@NonNull Canvas canvas) {
        int a2;
        int c2;
        int a3;
        int c3;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        o adapter = getAdapter();
        f<?> fVar = adapter.f7080c;
        c cVar = adapter.f7081d;
        Long item = adapter.getItem(adapter.b());
        Long item2 = adapter.getItem(adapter.h());
        for (Pair<Long, Long> pair : fVar.d0()) {
            Long l = pair.first;
            if (l != null) {
                if (pair.second == null) {
                    continue;
                } else {
                    long longValue = l.longValue();
                    long longValue2 = pair.second.longValue();
                    if (d(item, item2, Long.valueOf(longValue), Long.valueOf(longValue2))) {
                        return;
                    }
                    if (longValue < item.longValue()) {
                        a2 = adapter.b();
                        c2 = adapter.f(a2) ? 0 : materialCalendarGridView.getChildAt(a2 - 1).getRight();
                    } else {
                        materialCalendarGridView.f6999a.setTimeInMillis(longValue);
                        a2 = adapter.a(materialCalendarGridView.f6999a.get(5));
                        c2 = c(materialCalendarGridView.getChildAt(a2));
                    }
                    if (longValue2 > item2.longValue()) {
                        a3 = Math.min(adapter.h(), getChildCount() - 1);
                        c3 = adapter.g(a3) ? getWidth() : materialCalendarGridView.getChildAt(a3).getRight();
                    } else {
                        materialCalendarGridView.f6999a.setTimeInMillis(longValue2);
                        a3 = adapter.a(materialCalendarGridView.f6999a.get(5));
                        c3 = c(materialCalendarGridView.getChildAt(a3));
                    }
                    int itemId = (int) adapter.getItemId(a2);
                    int itemId2 = (int) adapter.getItemId(a3);
                    while (itemId <= itemId2) {
                        int numColumns = getNumColumns() * itemId;
                        int numColumns2 = (getNumColumns() + numColumns) - 1;
                        View childAt = materialCalendarGridView.getChildAt(numColumns);
                        canvas.drawRect(numColumns > a2 ? 0 : c2, childAt.getTop() + cVar.f7024a.e(), a3 > numColumns2 ? getWidth() : c3, childAt.getBottom() - cVar.f7024a.b(), cVar.f7031h);
                        itemId++;
                        materialCalendarGridView = this;
                    }
                }
            }
            materialCalendarGridView = this;
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onFocusChanged(boolean z, int i2, Rect rect) {
        if (z) {
            a(i2, rect);
        } else {
            super.onFocusChanged(false, i2, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (!super.onKeyDown(i2, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().b()) {
            return true;
        }
        if (19 != i2) {
            return false;
        }
        setSelection(getAdapter().b());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i2) {
        if (i2 < getAdapter().b()) {
            super.setSelection(getAdapter().b());
        } else {
            super.setSelection(i2);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof o)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), o.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f6999a = w.v();
        if (k.x(getContext())) {
            setNextFocusLeftId(R.id.cancel_button);
            setNextFocusRightId(R.id.confirm_button);
        }
        ViewCompat.setAccessibilityDelegate(this, new a());
    }
}
