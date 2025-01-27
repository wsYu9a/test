package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class ViewInfoStore {

    /* renamed from: a */
    private static final boolean f3545a = false;

    /* renamed from: b */
    @VisibleForTesting
    final SimpleArrayMap<RecyclerView.ViewHolder, InfoRecord> f3546b = new SimpleArrayMap<>();

    /* renamed from: c */
    @VisibleForTesting
    final LongSparseArray<RecyclerView.ViewHolder> f3547c = new LongSparseArray<>();

    static class InfoRecord {

        /* renamed from: a */
        static final int f3548a = 1;

        /* renamed from: b */
        static final int f3549b = 2;

        /* renamed from: c */
        static final int f3550c = 4;

        /* renamed from: d */
        static final int f3551d = 8;

        /* renamed from: e */
        static final int f3552e = 3;

        /* renamed from: f */
        static final int f3553f = 12;

        /* renamed from: g */
        static final int f3554g = 14;

        /* renamed from: h */
        static Pools.Pool<InfoRecord> f3555h = new Pools.SimplePool(20);

        /* renamed from: i */
        int f3556i;

        /* renamed from: j */
        @Nullable
        RecyclerView.ItemAnimator.ItemHolderInfo f3557j;

        @Nullable
        RecyclerView.ItemAnimator.ItemHolderInfo k;

        private InfoRecord() {
        }

        static void a() {
            while (f3555h.acquire() != null) {
            }
        }

        static InfoRecord b() {
            InfoRecord acquire = f3555h.acquire();
            return acquire == null ? new InfoRecord() : acquire;
        }

        static void c(InfoRecord infoRecord) {
            infoRecord.f3556i = 0;
            infoRecord.f3557j = null;
            infoRecord.k = null;
            f3555h.release(infoRecord);
        }
    }

    interface ProcessCallback {
        void processAppeared(RecyclerView.ViewHolder viewHolder, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void processDisappeared(RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void processPersistent(RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void unused(RecyclerView.ViewHolder viewHolder);
    }

    ViewInfoStore() {
    }

    private RecyclerView.ItemAnimator.ItemHolderInfo k(RecyclerView.ViewHolder viewHolder, int i2) {
        InfoRecord valueAt;
        RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo;
        int indexOfKey = this.f3546b.indexOfKey(viewHolder);
        if (indexOfKey >= 0 && (valueAt = this.f3546b.valueAt(indexOfKey)) != null) {
            int i3 = valueAt.f3556i;
            if ((i3 & i2) != 0) {
                int i4 = (i2 ^ (-1)) & i3;
                valueAt.f3556i = i4;
                if (i2 == 4) {
                    itemHolderInfo = valueAt.f3557j;
                } else {
                    if (i2 != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    itemHolderInfo = valueAt.k;
                }
                if ((i4 & 12) == 0) {
                    this.f3546b.removeAt(indexOfKey);
                    InfoRecord.c(valueAt);
                }
                return itemHolderInfo;
            }
        }
        return null;
    }

    void a(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecord = this.f3546b.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.b();
            this.f3546b.put(viewHolder, infoRecord);
        }
        infoRecord.f3556i |= 2;
        infoRecord.f3557j = itemHolderInfo;
    }

    void b(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.f3546b.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.b();
            this.f3546b.put(viewHolder, infoRecord);
        }
        infoRecord.f3556i |= 1;
    }

    void c(long j2, RecyclerView.ViewHolder viewHolder) {
        this.f3547c.put(j2, viewHolder);
    }

    void d(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecord = this.f3546b.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.b();
            this.f3546b.put(viewHolder, infoRecord);
        }
        infoRecord.k = itemHolderInfo;
        infoRecord.f3556i |= 8;
    }

    void e(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecord = this.f3546b.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.b();
            this.f3546b.put(viewHolder, infoRecord);
        }
        infoRecord.f3557j = itemHolderInfo;
        infoRecord.f3556i |= 4;
    }

    void f() {
        this.f3546b.clear();
        this.f3547c.clear();
    }

    RecyclerView.ViewHolder g(long j2) {
        return this.f3547c.get(j2);
    }

    boolean h(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.f3546b.get(viewHolder);
        return (infoRecord == null || (infoRecord.f3556i & 1) == 0) ? false : true;
    }

    boolean i(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.f3546b.get(viewHolder);
        return (infoRecord == null || (infoRecord.f3556i & 4) == 0) ? false : true;
    }

    void j() {
        InfoRecord.a();
    }

    @Nullable
    RecyclerView.ItemAnimator.ItemHolderInfo l(RecyclerView.ViewHolder viewHolder) {
        return k(viewHolder, 8);
    }

    @Nullable
    RecyclerView.ItemAnimator.ItemHolderInfo m(RecyclerView.ViewHolder viewHolder) {
        return k(viewHolder, 4);
    }

    void n(ProcessCallback processCallback) {
        for (int size = this.f3546b.size() - 1; size >= 0; size--) {
            RecyclerView.ViewHolder keyAt = this.f3546b.keyAt(size);
            InfoRecord removeAt = this.f3546b.removeAt(size);
            int i2 = removeAt.f3556i;
            if ((i2 & 3) == 3) {
                processCallback.unused(keyAt);
            } else if ((i2 & 1) != 0) {
                RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo = removeAt.f3557j;
                if (itemHolderInfo == null) {
                    processCallback.unused(keyAt);
                } else {
                    processCallback.processDisappeared(keyAt, itemHolderInfo, removeAt.k);
                }
            } else if ((i2 & 14) == 14) {
                processCallback.processAppeared(keyAt, removeAt.f3557j, removeAt.k);
            } else if ((i2 & 12) == 12) {
                processCallback.processPersistent(keyAt, removeAt.f3557j, removeAt.k);
            } else if ((i2 & 4) != 0) {
                processCallback.processDisappeared(keyAt, removeAt.f3557j, null);
            } else if ((i2 & 8) != 0) {
                processCallback.processAppeared(keyAt, removeAt.f3557j, removeAt.k);
            }
            InfoRecord.c(removeAt);
        }
    }

    void o(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.f3546b.get(viewHolder);
        if (infoRecord == null) {
            return;
        }
        infoRecord.f3556i &= -2;
    }

    public void onViewDetached(RecyclerView.ViewHolder viewHolder) {
        o(viewHolder);
    }

    void p(RecyclerView.ViewHolder viewHolder) {
        int size = this.f3547c.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            if (viewHolder == this.f3547c.valueAt(size)) {
                this.f3547c.removeAt(size);
                break;
            }
            size--;
        }
        InfoRecord remove = this.f3546b.remove(viewHolder);
        if (remove != null) {
            InfoRecord.c(remove);
        }
    }
}
