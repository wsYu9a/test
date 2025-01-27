package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class ActionOnlyNavDirections implements NavDirections {

    /* renamed from: a */
    private final int f2919a;

    public ActionOnlyNavDirections(int i2) {
        this.f2919a = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && ActionOnlyNavDirections.class == obj.getClass() && getActionId() == ((ActionOnlyNavDirections) obj).getActionId();
    }

    @Override // androidx.navigation.NavDirections
    public int getActionId() {
        return this.f2919a;
    }

    @Override // androidx.navigation.NavDirections
    @NonNull
    public Bundle getArguments() {
        return new Bundle();
    }

    public int hashCode() {
        return 31 + getActionId();
    }

    public String toString() {
        return "ActionOnlyNavDirections(actionId=" + getActionId() + ")";
    }
}
