package androidx.core.view.accessibility;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class AccessibilityNodeProviderCompat {
    public static final int HOST_VIEW_ID = -1;

    @Nullable
    private final Object mProvider;

    @RequiresApi(16)
    public static class AccessibilityNodeProviderApi16 extends AccessibilityNodeProvider {
        final AccessibilityNodeProviderCompat mCompat;

        public AccessibilityNodeProviderApi16(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            this.mCompat = accessibilityNodeProviderCompat;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i10) {
            AccessibilityNodeInfoCompat createAccessibilityNodeInfo = this.mCompat.createAccessibilityNodeInfo(i10);
            if (createAccessibilityNodeInfo == null) {
                return null;
            }
            return createAccessibilityNodeInfo.unwrap();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i10) {
            List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText = this.mCompat.findAccessibilityNodeInfosByText(str, i10);
            if (findAccessibilityNodeInfosByText == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = findAccessibilityNodeInfosByText.size();
            for (int i11 = 0; i11 < size; i11++) {
                arrayList.add(findAccessibilityNodeInfosByText.get(i11).unwrap());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i10, int i11, Bundle bundle) {
            return this.mCompat.performAction(i10, i11, bundle);
        }
    }

    @RequiresApi(19)
    public static class AccessibilityNodeProviderApi19 extends AccessibilityNodeProviderApi16 {
        public AccessibilityNodeProviderApi19(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            super(accessibilityNodeProviderCompat);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i10) {
            AccessibilityNodeInfoCompat findFocus = this.mCompat.findFocus(i10);
            if (findFocus == null) {
                return null;
            }
            return findFocus.unwrap();
        }
    }

    @RequiresApi(26)
    public static class AccessibilityNodeProviderApi26 extends AccessibilityNodeProviderApi19 {
        public AccessibilityNodeProviderApi26(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            super(accessibilityNodeProviderCompat);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i10, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.mCompat.addExtraDataToAccessibilityNodeInfo(i10, AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo), str, bundle);
        }
    }

    public AccessibilityNodeProviderCompat() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mProvider = new AccessibilityNodeProviderApi26(this);
        } else {
            this.mProvider = new AccessibilityNodeProviderApi19(this);
        }
    }

    public void addExtraDataToAccessibilityNodeInfo(int i10, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, @NonNull String str, @Nullable Bundle bundle) {
    }

    @Nullable
    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i10) {
        return null;
    }

    @Nullable
    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(@NonNull String str, int i10) {
        return null;
    }

    @Nullable
    public AccessibilityNodeInfoCompat findFocus(int i10) {
        return null;
    }

    @Nullable
    public Object getProvider() {
        return this.mProvider;
    }

    public boolean performAction(int i10, int i11, @Nullable Bundle bundle) {
        return false;
    }

    public AccessibilityNodeProviderCompat(@Nullable Object obj) {
        this.mProvider = obj;
    }
}
