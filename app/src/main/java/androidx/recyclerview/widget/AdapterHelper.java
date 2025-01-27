package androidx.recyclerview.widget;

import androidx.core.util.Pools;
import androidx.recyclerview.widget.OpReorderer;
import androidx.recyclerview.widget.RecyclerView;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
class AdapterHelper implements OpReorderer.Callback {

    /* renamed from: a */
    static final int f3118a = 0;

    /* renamed from: b */
    static final int f3119b = 1;

    /* renamed from: c */
    private static final boolean f3120c = false;

    /* renamed from: d */
    private static final String f3121d = "AHT";

    /* renamed from: e */
    private Pools.Pool<UpdateOp> f3122e;

    /* renamed from: f */
    final ArrayList<UpdateOp> f3123f;

    /* renamed from: g */
    final ArrayList<UpdateOp> f3124g;

    /* renamed from: h */
    final Callback f3125h;

    /* renamed from: i */
    Runnable f3126i;

    /* renamed from: j */
    final boolean f3127j;
    final OpReorderer k;
    private int l;

    interface Callback {
        RecyclerView.ViewHolder findViewHolder(int i2);

        void markViewHoldersUpdated(int i2, int i3, Object obj);

        void offsetPositionsForAdd(int i2, int i3);

        void offsetPositionsForMove(int i2, int i3);

        void offsetPositionsForRemovingInvisible(int i2, int i3);

        void offsetPositionsForRemovingLaidOutOrNewView(int i2, int i3);

        void onDispatchFirstPass(UpdateOp updateOp);

        void onDispatchSecondPass(UpdateOp updateOp);
    }

    static class UpdateOp {

        /* renamed from: a */
        static final int f3128a = 1;

        /* renamed from: b */
        static final int f3129b = 2;

        /* renamed from: c */
        static final int f3130c = 4;

        /* renamed from: d */
        static final int f3131d = 8;

        /* renamed from: e */
        static final int f3132e = 30;

        /* renamed from: f */
        int f3133f;

        /* renamed from: g */
        int f3134g;

        /* renamed from: h */
        Object f3135h;

        /* renamed from: i */
        int f3136i;

        UpdateOp(int i2, int i3, int i4, Object obj) {
            this.f3133f = i2;
            this.f3134g = i3;
            this.f3136i = i4;
            this.f3135h = obj;
        }

        String a() {
            int i2 = this.f3133f;
            return i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 != 8 ? "??" : "mv" : "up" : t.w : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            UpdateOp updateOp = (UpdateOp) obj;
            int i2 = this.f3133f;
            if (i2 != updateOp.f3133f) {
                return false;
            }
            if (i2 == 8 && Math.abs(this.f3136i - this.f3134g) == 1 && this.f3136i == updateOp.f3134g && this.f3134g == updateOp.f3136i) {
                return true;
            }
            if (this.f3136i != updateOp.f3136i || this.f3134g != updateOp.f3134g) {
                return false;
            }
            Object obj2 = this.f3135h;
            if (obj2 != null) {
                if (!obj2.equals(updateOp.f3135h)) {
                    return false;
                }
            } else if (updateOp.f3135h != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f3133f * 31) + this.f3134g) * 31) + this.f3136i;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f3134g + "c:" + this.f3136i + ",p:" + this.f3135h + "]";
        }
    }

    AdapterHelper(Callback callback) {
        this(callback, false);
    }

    private void b(UpdateOp updateOp) {
        t(updateOp);
    }

    private void c(UpdateOp updateOp) {
        t(updateOp);
    }

    private void d(UpdateOp updateOp) {
        boolean z;
        char c2;
        int i2 = updateOp.f3134g;
        int i3 = updateOp.f3136i + i2;
        char c3 = 65535;
        int i4 = i2;
        int i5 = 0;
        while (i4 < i3) {
            if (this.f3125h.findViewHolder(i4) != null || f(i4)) {
                if (c3 == 0) {
                    i(obtainUpdateOp(2, i2, i5, null));
                    z = true;
                } else {
                    z = false;
                }
                c2 = 1;
            } else {
                if (c3 == 1) {
                    t(obtainUpdateOp(2, i2, i5, null));
                    z = true;
                } else {
                    z = false;
                }
                c2 = 0;
            }
            if (z) {
                i4 -= i5;
                i3 -= i5;
                i5 = 1;
            } else {
                i5++;
            }
            i4++;
            c3 = c2;
        }
        if (i5 != updateOp.f3136i) {
            recycleUpdateOp(updateOp);
            updateOp = obtainUpdateOp(2, i2, i5, null);
        }
        if (c3 == 0) {
            i(updateOp);
        } else {
            t(updateOp);
        }
    }

    private void e(UpdateOp updateOp) {
        int i2 = updateOp.f3134g;
        int i3 = updateOp.f3136i + i2;
        int i4 = i2;
        char c2 = 65535;
        int i5 = 0;
        while (i2 < i3) {
            if (this.f3125h.findViewHolder(i2) != null || f(i2)) {
                if (c2 == 0) {
                    i(obtainUpdateOp(4, i4, i5, updateOp.f3135h));
                    i4 = i2;
                    i5 = 0;
                }
                c2 = 1;
            } else {
                if (c2 == 1) {
                    t(obtainUpdateOp(4, i4, i5, updateOp.f3135h));
                    i4 = i2;
                    i5 = 0;
                }
                c2 = 0;
            }
            i5++;
            i2++;
        }
        if (i5 != updateOp.f3136i) {
            Object obj = updateOp.f3135h;
            recycleUpdateOp(updateOp);
            updateOp = obtainUpdateOp(4, i4, i5, obj);
        }
        if (c2 == 0) {
            i(updateOp);
        } else {
            t(updateOp);
        }
    }

    private boolean f(int i2) {
        int size = this.f3124g.size();
        for (int i3 = 0; i3 < size; i3++) {
            UpdateOp updateOp = this.f3124g.get(i3);
            int i4 = updateOp.f3133f;
            if (i4 == 8) {
                if (l(updateOp.f3136i, i3 + 1) == i2) {
                    return true;
                }
            } else if (i4 == 1) {
                int i5 = updateOp.f3134g;
                int i6 = updateOp.f3136i + i5;
                while (i5 < i6) {
                    if (l(i5, i3 + 1) == i2) {
                        return true;
                    }
                    i5++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void i(UpdateOp updateOp) {
        int i2;
        int i3 = updateOp.f3133f;
        if (i3 == 1 || i3 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int x = x(updateOp.f3134g, i3);
        int i4 = updateOp.f3134g;
        int i5 = updateOp.f3133f;
        if (i5 == 2) {
            i2 = 0;
        } else {
            if (i5 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + updateOp);
            }
            i2 = 1;
        }
        int i6 = 1;
        for (int i7 = 1; i7 < updateOp.f3136i; i7++) {
            int x2 = x(updateOp.f3134g + (i2 * i7), updateOp.f3133f);
            int i8 = updateOp.f3133f;
            if (i8 == 2 ? x2 == x : i8 == 4 && x2 == x + 1) {
                i6++;
            } else {
                UpdateOp obtainUpdateOp = obtainUpdateOp(i8, x, i6, updateOp.f3135h);
                j(obtainUpdateOp, i4);
                recycleUpdateOp(obtainUpdateOp);
                if (updateOp.f3133f == 4) {
                    i4 += i6;
                }
                x = x2;
                i6 = 1;
            }
        }
        Object obj = updateOp.f3135h;
        recycleUpdateOp(updateOp);
        if (i6 > 0) {
            UpdateOp obtainUpdateOp2 = obtainUpdateOp(updateOp.f3133f, x, i6, obj);
            j(obtainUpdateOp2, i4);
            recycleUpdateOp(obtainUpdateOp2);
        }
    }

    private void t(UpdateOp updateOp) {
        this.f3124g.add(updateOp);
        int i2 = updateOp.f3133f;
        if (i2 == 1) {
            this.f3125h.offsetPositionsForAdd(updateOp.f3134g, updateOp.f3136i);
            return;
        }
        if (i2 == 2) {
            this.f3125h.offsetPositionsForRemovingLaidOutOrNewView(updateOp.f3134g, updateOp.f3136i);
            return;
        }
        if (i2 == 4) {
            this.f3125h.markViewHoldersUpdated(updateOp.f3134g, updateOp.f3136i, updateOp.f3135h);
        } else {
            if (i2 == 8) {
                this.f3125h.offsetPositionsForMove(updateOp.f3134g, updateOp.f3136i);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + updateOp);
        }
    }

    private int x(int i2, int i3) {
        int i4;
        int i5;
        for (int size = this.f3124g.size() - 1; size >= 0; size--) {
            UpdateOp updateOp = this.f3124g.get(size);
            int i6 = updateOp.f3133f;
            if (i6 == 8) {
                int i7 = updateOp.f3134g;
                int i8 = updateOp.f3136i;
                if (i7 < i8) {
                    i5 = i7;
                    i4 = i8;
                } else {
                    i4 = i7;
                    i5 = i8;
                }
                if (i2 < i5 || i2 > i4) {
                    if (i2 < i7) {
                        if (i3 == 1) {
                            updateOp.f3134g = i7 + 1;
                            updateOp.f3136i = i8 + 1;
                        } else if (i3 == 2) {
                            updateOp.f3134g = i7 - 1;
                            updateOp.f3136i = i8 - 1;
                        }
                    }
                } else if (i5 == i7) {
                    if (i3 == 1) {
                        updateOp.f3136i = i8 + 1;
                    } else if (i3 == 2) {
                        updateOp.f3136i = i8 - 1;
                    }
                    i2++;
                } else {
                    if (i3 == 1) {
                        updateOp.f3134g = i7 + 1;
                    } else if (i3 == 2) {
                        updateOp.f3134g = i7 - 1;
                    }
                    i2--;
                }
            } else {
                int i9 = updateOp.f3134g;
                if (i9 <= i2) {
                    if (i6 == 1) {
                        i2 -= updateOp.f3136i;
                    } else if (i6 == 2) {
                        i2 += updateOp.f3136i;
                    }
                } else if (i3 == 1) {
                    updateOp.f3134g = i9 + 1;
                } else if (i3 == 2) {
                    updateOp.f3134g = i9 - 1;
                }
            }
        }
        for (int size2 = this.f3124g.size() - 1; size2 >= 0; size2--) {
            UpdateOp updateOp2 = this.f3124g.get(size2);
            if (updateOp2.f3133f == 8) {
                int i10 = updateOp2.f3136i;
                if (i10 == updateOp2.f3134g || i10 < 0) {
                    this.f3124g.remove(size2);
                    recycleUpdateOp(updateOp2);
                }
            } else if (updateOp2.f3136i <= 0) {
                this.f3124g.remove(size2);
                recycleUpdateOp(updateOp2);
            }
        }
        return i2;
    }

    AdapterHelper a(UpdateOp... updateOpArr) {
        Collections.addAll(this.f3123f, updateOpArr);
        return this;
    }

    public int applyPendingUpdatesToPosition(int i2) {
        int size = this.f3123f.size();
        for (int i3 = 0; i3 < size; i3++) {
            UpdateOp updateOp = this.f3123f.get(i3);
            int i4 = updateOp.f3133f;
            if (i4 != 1) {
                if (i4 == 2) {
                    int i5 = updateOp.f3134g;
                    if (i5 <= i2) {
                        int i6 = updateOp.f3136i;
                        if (i5 + i6 > i2) {
                            return -1;
                        }
                        i2 -= i6;
                    } else {
                        continue;
                    }
                } else if (i4 == 8) {
                    int i7 = updateOp.f3134g;
                    if (i7 == i2) {
                        i2 = updateOp.f3136i;
                    } else {
                        if (i7 < i2) {
                            i2--;
                        }
                        if (updateOp.f3136i <= i2) {
                            i2++;
                        }
                    }
                }
            } else if (updateOp.f3134g <= i2) {
                i2 += updateOp.f3136i;
            }
        }
        return i2;
    }

    void g() {
        int size = this.f3124g.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f3125h.onDispatchSecondPass(this.f3124g.get(i2));
        }
        v(this.f3124g);
        this.l = 0;
    }

    void h() {
        g();
        int size = this.f3123f.size();
        for (int i2 = 0; i2 < size; i2++) {
            UpdateOp updateOp = this.f3123f.get(i2);
            int i3 = updateOp.f3133f;
            if (i3 == 1) {
                this.f3125h.onDispatchSecondPass(updateOp);
                this.f3125h.offsetPositionsForAdd(updateOp.f3134g, updateOp.f3136i);
            } else if (i3 == 2) {
                this.f3125h.onDispatchSecondPass(updateOp);
                this.f3125h.offsetPositionsForRemovingInvisible(updateOp.f3134g, updateOp.f3136i);
            } else if (i3 == 4) {
                this.f3125h.onDispatchSecondPass(updateOp);
                this.f3125h.markViewHoldersUpdated(updateOp.f3134g, updateOp.f3136i, updateOp.f3135h);
            } else if (i3 == 8) {
                this.f3125h.onDispatchSecondPass(updateOp);
                this.f3125h.offsetPositionsForMove(updateOp.f3134g, updateOp.f3136i);
            }
            Runnable runnable = this.f3126i;
            if (runnable != null) {
                runnable.run();
            }
        }
        v(this.f3123f);
        this.l = 0;
    }

    void j(UpdateOp updateOp, int i2) {
        this.f3125h.onDispatchFirstPass(updateOp);
        int i3 = updateOp.f3133f;
        if (i3 == 2) {
            this.f3125h.offsetPositionsForRemovingInvisible(i2, updateOp.f3136i);
        } else {
            if (i3 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.f3125h.markViewHoldersUpdated(i2, updateOp.f3136i, updateOp.f3135h);
        }
    }

    int k(int i2) {
        return l(i2, 0);
    }

    int l(int i2, int i3) {
        int size = this.f3124g.size();
        while (i3 < size) {
            UpdateOp updateOp = this.f3124g.get(i3);
            int i4 = updateOp.f3133f;
            if (i4 == 8) {
                int i5 = updateOp.f3134g;
                if (i5 == i2) {
                    i2 = updateOp.f3136i;
                } else {
                    if (i5 < i2) {
                        i2--;
                    }
                    if (updateOp.f3136i <= i2) {
                        i2++;
                    }
                }
            } else {
                int i6 = updateOp.f3134g;
                if (i6 > i2) {
                    continue;
                } else if (i4 == 2) {
                    int i7 = updateOp.f3136i;
                    if (i2 < i6 + i7) {
                        return -1;
                    }
                    i2 -= i7;
                } else if (i4 == 1) {
                    i2 += updateOp.f3136i;
                }
            }
            i3++;
        }
        return i2;
    }

    boolean m(int i2) {
        return (i2 & this.l) != 0;
    }

    boolean n() {
        return this.f3123f.size() > 0;
    }

    boolean o() {
        return (this.f3124g.isEmpty() || this.f3123f.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public UpdateOp obtainUpdateOp(int i2, int i3, int i4, Object obj) {
        UpdateOp acquire = this.f3122e.acquire();
        if (acquire == null) {
            return new UpdateOp(i2, i3, i4, obj);
        }
        acquire.f3133f = i2;
        acquire.f3134g = i3;
        acquire.f3136i = i4;
        acquire.f3135h = obj;
        return acquire;
    }

    boolean p(int i2, int i3, Object obj) {
        if (i3 < 1) {
            return false;
        }
        this.f3123f.add(obtainUpdateOp(4, i2, i3, obj));
        this.l |= 4;
        return this.f3123f.size() == 1;
    }

    boolean q(int i2, int i3) {
        if (i3 < 1) {
            return false;
        }
        this.f3123f.add(obtainUpdateOp(1, i2, i3, null));
        this.l |= 1;
        return this.f3123f.size() == 1;
    }

    boolean r(int i2, int i3, int i4) {
        if (i2 == i3) {
            return false;
        }
        if (i4 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.f3123f.add(obtainUpdateOp(8, i2, i3, null));
        this.l |= 8;
        return this.f3123f.size() == 1;
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public void recycleUpdateOp(UpdateOp updateOp) {
        if (this.f3127j) {
            return;
        }
        updateOp.f3135h = null;
        this.f3122e.release(updateOp);
    }

    boolean s(int i2, int i3) {
        if (i3 < 1) {
            return false;
        }
        this.f3123f.add(obtainUpdateOp(2, i2, i3, null));
        this.l |= 2;
        return this.f3123f.size() == 1;
    }

    void u() {
        this.k.b(this.f3123f);
        int size = this.f3123f.size();
        for (int i2 = 0; i2 < size; i2++) {
            UpdateOp updateOp = this.f3123f.get(i2);
            int i3 = updateOp.f3133f;
            if (i3 == 1) {
                b(updateOp);
            } else if (i3 == 2) {
                d(updateOp);
            } else if (i3 == 4) {
                e(updateOp);
            } else if (i3 == 8) {
                c(updateOp);
            }
            Runnable runnable = this.f3126i;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f3123f.clear();
    }

    void v(List<UpdateOp> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            recycleUpdateOp(list.get(i2));
        }
        list.clear();
    }

    void w() {
        v(this.f3123f);
        v(this.f3124g);
        this.l = 0;
    }

    AdapterHelper(Callback callback, boolean z) {
        this.f3122e = new Pools.SimplePool(30);
        this.f3123f = new ArrayList<>();
        this.f3124g = new ArrayList<>();
        this.l = 0;
        this.f3125h = callback;
        this.f3127j = z;
        this.k = new OpReorderer(this);
    }
}
