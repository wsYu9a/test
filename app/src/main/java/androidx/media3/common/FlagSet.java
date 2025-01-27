package androidx.media3.common;

import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@UnstableApi
/* loaded from: classes.dex */
public final class FlagSet {
    private final SparseBooleanArray flags;

    public /* synthetic */ FlagSet(SparseBooleanArray sparseBooleanArray, AnonymousClass1 anonymousClass1) {
        this(sparseBooleanArray);
    }

    public boolean contains(int i10) {
        return this.flags.get(i10);
    }

    public boolean containsAny(int... iArr) {
        for (int i10 : iArr) {
            if (contains(i10)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlagSet)) {
            return false;
        }
        FlagSet flagSet = (FlagSet) obj;
        if (Util.SDK_INT >= 24) {
            return this.flags.equals(flagSet.flags);
        }
        if (size() != flagSet.size()) {
            return false;
        }
        for (int i10 = 0; i10 < size(); i10++) {
            if (get(i10) != flagSet.get(i10)) {
                return false;
            }
        }
        return true;
    }

    public int get(int i10) {
        Assertions.checkIndex(i10, 0, size());
        return this.flags.keyAt(i10);
    }

    public int hashCode() {
        if (Util.SDK_INT >= 24) {
            return this.flags.hashCode();
        }
        int size = size();
        for (int i10 = 0; i10 < size(); i10++) {
            size = (size * 31) + get(i10);
        }
        return size;
    }

    public int size() {
        return this.flags.size();
    }

    public static final class Builder {
        private boolean buildCalled;
        private final SparseBooleanArray flags = new SparseBooleanArray();

        @CanIgnoreReturnValue
        public Builder add(int i10) {
            Assertions.checkState(!this.buildCalled);
            this.flags.append(i10, true);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addAll(int... iArr) {
            for (int i10 : iArr) {
                add(i10);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addIf(int i10, boolean z10) {
            return z10 ? add(i10) : this;
        }

        public FlagSet build() {
            Assertions.checkState(!this.buildCalled);
            this.buildCalled = true;
            return new FlagSet(this.flags);
        }

        @CanIgnoreReturnValue
        public Builder remove(int i10) {
            Assertions.checkState(!this.buildCalled);
            this.flags.delete(i10);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder removeAll(int... iArr) {
            for (int i10 : iArr) {
                remove(i10);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder removeIf(int i10, boolean z10) {
            return z10 ? remove(i10) : this;
        }

        @CanIgnoreReturnValue
        public Builder addAll(FlagSet flagSet) {
            for (int i10 = 0; i10 < flagSet.size(); i10++) {
                add(flagSet.get(i10));
            }
            return this;
        }
    }

    private FlagSet(SparseBooleanArray sparseBooleanArray) {
        this.flags = sparseBooleanArray;
    }
}
