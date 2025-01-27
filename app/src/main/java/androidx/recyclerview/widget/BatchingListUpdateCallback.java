package androidx.recyclerview.widget;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class BatchingListUpdateCallback implements ListUpdateCallback {

    /* renamed from: a */
    private static final int f3181a = 0;

    /* renamed from: b */
    private static final int f3182b = 1;

    /* renamed from: c */
    private static final int f3183c = 2;

    /* renamed from: d */
    private static final int f3184d = 3;

    /* renamed from: e */
    final ListUpdateCallback f3185e;

    /* renamed from: f */
    int f3186f = 0;

    /* renamed from: g */
    int f3187g = -1;

    /* renamed from: h */
    int f3188h = -1;

    /* renamed from: i */
    Object f3189i = null;

    public BatchingListUpdateCallback(@NonNull ListUpdateCallback listUpdateCallback) {
        this.f3185e = listUpdateCallback;
    }

    public void dispatchLastEvent() {
        int i2 = this.f3186f;
        if (i2 == 0) {
            return;
        }
        if (i2 == 1) {
            this.f3185e.onInserted(this.f3187g, this.f3188h);
        } else if (i2 == 2) {
            this.f3185e.onRemoved(this.f3187g, this.f3188h);
        } else if (i2 == 3) {
            this.f3185e.onChanged(this.f3187g, this.f3188h, this.f3189i);
        }
        this.f3189i = null;
        this.f3186f = 0;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int i2, int i3, Object obj) {
        int i4;
        if (this.f3186f == 3) {
            int i5 = this.f3187g;
            int i6 = this.f3188h;
            if (i2 <= i5 + i6 && (i4 = i2 + i3) >= i5 && this.f3189i == obj) {
                this.f3187g = Math.min(i2, i5);
                this.f3188h = Math.max(i6 + i5, i4) - this.f3187g;
                return;
            }
        }
        dispatchLastEvent();
        this.f3187g = i2;
        this.f3188h = i3;
        this.f3189i = obj;
        this.f3186f = 3;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int i2, int i3) {
        int i4;
        if (this.f3186f == 1 && i2 >= (i4 = this.f3187g)) {
            int i5 = this.f3188h;
            if (i2 <= i4 + i5) {
                this.f3188h = i5 + i3;
                this.f3187g = Math.min(i2, i4);
                return;
            }
        }
        dispatchLastEvent();
        this.f3187g = i2;
        this.f3188h = i3;
        this.f3186f = 1;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int i2, int i3) {
        dispatchLastEvent();
        this.f3185e.onMoved(i2, i3);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int i2, int i3) {
        int i4;
        if (this.f3186f == 2 && (i4 = this.f3187g) >= i2 && i4 <= i2 + i3) {
            this.f3188h += i3;
            this.f3187g = i2;
        } else {
            dispatchLastEvent();
            this.f3187g = i2;
            this.f3188h = i3;
            this.f3186f = 2;
        }
    }
}
