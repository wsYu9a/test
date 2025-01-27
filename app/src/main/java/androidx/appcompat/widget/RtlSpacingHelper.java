package androidx.appcompat.widget;

/* loaded from: classes.dex */
class RtlSpacingHelper {
    public static final int UNDEFINED = Integer.MIN_VALUE;

    /* renamed from: a, reason: collision with root package name */
    private int f886a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f887b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f888c = Integer.MIN_VALUE;

    /* renamed from: d, reason: collision with root package name */
    private int f889d = Integer.MIN_VALUE;

    /* renamed from: e, reason: collision with root package name */
    private int f890e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f891f = 0;

    /* renamed from: g, reason: collision with root package name */
    private boolean f892g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f893h = false;

    RtlSpacingHelper() {
    }

    public int getEnd() {
        return this.f892g ? this.f886a : this.f887b;
    }

    public int getLeft() {
        return this.f886a;
    }

    public int getRight() {
        return this.f887b;
    }

    public int getStart() {
        return this.f892g ? this.f887b : this.f886a;
    }

    public void setAbsolute(int i2, int i3) {
        this.f893h = false;
        if (i2 != Integer.MIN_VALUE) {
            this.f890e = i2;
            this.f886a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f891f = i3;
            this.f887b = i3;
        }
    }

    public void setDirection(boolean z) {
        if (z == this.f892g) {
            return;
        }
        this.f892g = z;
        if (!this.f893h) {
            this.f886a = this.f890e;
            this.f887b = this.f891f;
            return;
        }
        if (z) {
            int i2 = this.f889d;
            if (i2 == Integer.MIN_VALUE) {
                i2 = this.f890e;
            }
            this.f886a = i2;
            int i3 = this.f888c;
            if (i3 == Integer.MIN_VALUE) {
                i3 = this.f891f;
            }
            this.f887b = i3;
            return;
        }
        int i4 = this.f888c;
        if (i4 == Integer.MIN_VALUE) {
            i4 = this.f890e;
        }
        this.f886a = i4;
        int i5 = this.f889d;
        if (i5 == Integer.MIN_VALUE) {
            i5 = this.f891f;
        }
        this.f887b = i5;
    }

    public void setRelative(int i2, int i3) {
        this.f888c = i2;
        this.f889d = i3;
        this.f893h = true;
        if (this.f892g) {
            if (i3 != Integer.MIN_VALUE) {
                this.f886a = i3;
            }
            if (i2 != Integer.MIN_VALUE) {
                this.f887b = i2;
                return;
            }
            return;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f886a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f887b = i3;
        }
    }
}
