package androidx.core.view.accessibility;

import android.os.Build;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import androidx.annotation.NonNull;
import java.util.List;

/* loaded from: classes.dex */
public class AccessibilityRecordCompat {

    /* renamed from: a */
    private final AccessibilityRecord f2137a;

    @Deprecated
    public AccessibilityRecordCompat(Object obj) {
        this.f2137a = (AccessibilityRecord) obj;
    }

    @Deprecated
    public static AccessibilityRecordCompat obtain(AccessibilityRecordCompat accessibilityRecordCompat) {
        return new AccessibilityRecordCompat(AccessibilityRecord.obtain(accessibilityRecordCompat.f2137a));
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessibilityRecordCompat)) {
            return false;
        }
        AccessibilityRecordCompat accessibilityRecordCompat = (AccessibilityRecordCompat) obj;
        AccessibilityRecord accessibilityRecord = this.f2137a;
        if (accessibilityRecord == null) {
            if (accessibilityRecordCompat.f2137a != null) {
                return false;
            }
        } else if (!accessibilityRecord.equals(accessibilityRecordCompat.f2137a)) {
            return false;
        }
        return true;
    }

    @Deprecated
    public int getAddedCount() {
        return this.f2137a.getAddedCount();
    }

    @Deprecated
    public CharSequence getBeforeText() {
        return this.f2137a.getBeforeText();
    }

    @Deprecated
    public CharSequence getClassName() {
        return this.f2137a.getClassName();
    }

    @Deprecated
    public CharSequence getContentDescription() {
        return this.f2137a.getContentDescription();
    }

    @Deprecated
    public int getCurrentItemIndex() {
        return this.f2137a.getCurrentItemIndex();
    }

    @Deprecated
    public int getFromIndex() {
        return this.f2137a.getFromIndex();
    }

    @Deprecated
    public Object getImpl() {
        return this.f2137a;
    }

    @Deprecated
    public int getItemCount() {
        return this.f2137a.getItemCount();
    }

    @Deprecated
    public int getMaxScrollX() {
        return getMaxScrollX(this.f2137a);
    }

    @Deprecated
    public int getMaxScrollY() {
        return getMaxScrollY(this.f2137a);
    }

    @Deprecated
    public Parcelable getParcelableData() {
        return this.f2137a.getParcelableData();
    }

    @Deprecated
    public int getRemovedCount() {
        return this.f2137a.getRemovedCount();
    }

    @Deprecated
    public int getScrollX() {
        return this.f2137a.getScrollX();
    }

    @Deprecated
    public int getScrollY() {
        return this.f2137a.getScrollY();
    }

    @Deprecated
    public AccessibilityNodeInfoCompat getSource() {
        return AccessibilityNodeInfoCompat.l(this.f2137a.getSource());
    }

    @Deprecated
    public List<CharSequence> getText() {
        return this.f2137a.getText();
    }

    @Deprecated
    public int getToIndex() {
        return this.f2137a.getToIndex();
    }

    @Deprecated
    public int getWindowId() {
        return this.f2137a.getWindowId();
    }

    @Deprecated
    public int hashCode() {
        AccessibilityRecord accessibilityRecord = this.f2137a;
        if (accessibilityRecord == null) {
            return 0;
        }
        return accessibilityRecord.hashCode();
    }

    @Deprecated
    public boolean isChecked() {
        return this.f2137a.isChecked();
    }

    @Deprecated
    public boolean isEnabled() {
        return this.f2137a.isEnabled();
    }

    @Deprecated
    public boolean isFullScreen() {
        return this.f2137a.isFullScreen();
    }

    @Deprecated
    public boolean isPassword() {
        return this.f2137a.isPassword();
    }

    @Deprecated
    public boolean isScrollable() {
        return this.f2137a.isScrollable();
    }

    @Deprecated
    public void recycle() {
        this.f2137a.recycle();
    }

    @Deprecated
    public void setAddedCount(int i2) {
        this.f2137a.setAddedCount(i2);
    }

    @Deprecated
    public void setBeforeText(CharSequence charSequence) {
        this.f2137a.setBeforeText(charSequence);
    }

    @Deprecated
    public void setChecked(boolean z) {
        this.f2137a.setChecked(z);
    }

    @Deprecated
    public void setClassName(CharSequence charSequence) {
        this.f2137a.setClassName(charSequence);
    }

    @Deprecated
    public void setContentDescription(CharSequence charSequence) {
        this.f2137a.setContentDescription(charSequence);
    }

    @Deprecated
    public void setCurrentItemIndex(int i2) {
        this.f2137a.setCurrentItemIndex(i2);
    }

    @Deprecated
    public void setEnabled(boolean z) {
        this.f2137a.setEnabled(z);
    }

    @Deprecated
    public void setFromIndex(int i2) {
        this.f2137a.setFromIndex(i2);
    }

    @Deprecated
    public void setFullScreen(boolean z) {
        this.f2137a.setFullScreen(z);
    }

    @Deprecated
    public void setItemCount(int i2) {
        this.f2137a.setItemCount(i2);
    }

    @Deprecated
    public void setMaxScrollX(int i2) {
        setMaxScrollX(this.f2137a, i2);
    }

    @Deprecated
    public void setMaxScrollY(int i2) {
        setMaxScrollY(this.f2137a, i2);
    }

    @Deprecated
    public void setParcelableData(Parcelable parcelable) {
        this.f2137a.setParcelableData(parcelable);
    }

    @Deprecated
    public void setPassword(boolean z) {
        this.f2137a.setPassword(z);
    }

    @Deprecated
    public void setRemovedCount(int i2) {
        this.f2137a.setRemovedCount(i2);
    }

    @Deprecated
    public void setScrollX(int i2) {
        this.f2137a.setScrollX(i2);
    }

    @Deprecated
    public void setScrollY(int i2) {
        this.f2137a.setScrollY(i2);
    }

    @Deprecated
    public void setScrollable(boolean z) {
        this.f2137a.setScrollable(z);
    }

    @Deprecated
    public void setSource(View view) {
        this.f2137a.setSource(view);
    }

    @Deprecated
    public void setToIndex(int i2) {
        this.f2137a.setToIndex(i2);
    }

    public static int getMaxScrollX(AccessibilityRecord accessibilityRecord) {
        if (Build.VERSION.SDK_INT >= 15) {
            return accessibilityRecord.getMaxScrollX();
        }
        return 0;
    }

    public static int getMaxScrollY(AccessibilityRecord accessibilityRecord) {
        if (Build.VERSION.SDK_INT >= 15) {
            return accessibilityRecord.getMaxScrollY();
        }
        return 0;
    }

    @Deprecated
    public static AccessibilityRecordCompat obtain() {
        return new AccessibilityRecordCompat(AccessibilityRecord.obtain());
    }

    public static void setMaxScrollX(AccessibilityRecord accessibilityRecord, int i2) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollX(i2);
        }
    }

    public static void setMaxScrollY(AccessibilityRecord accessibilityRecord, int i2) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollY(i2);
        }
    }

    @Deprecated
    public void setSource(View view, int i2) {
        setSource(this.f2137a, view, i2);
    }

    public static void setSource(@NonNull AccessibilityRecord accessibilityRecord, View view, int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            accessibilityRecord.setSource(view, i2);
        }
    }
}
