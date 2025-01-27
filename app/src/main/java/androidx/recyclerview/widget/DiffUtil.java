package androidx.recyclerview.widget;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class DiffUtil {

    /* renamed from: a */
    private static final Comparator<Snake> f3228a = new Comparator<Snake>() { // from class: androidx.recyclerview.widget.DiffUtil.1
        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        public int compare(Snake snake, Snake snake2) {
            int i2 = snake.f3246a - snake2.f3246a;
            return i2 == 0 ? snake.f3247b - snake2.f3247b : i2;
        }
    };

    /* renamed from: androidx.recyclerview.widget.DiffUtil$1 */
    static class AnonymousClass1 implements Comparator<Snake> {
        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        public int compare(Snake snake, Snake snake2) {
            int i2 = snake.f3246a - snake2.f3246a;
            return i2 == 0 ? snake.f3247b - snake2.f3247b : i2;
        }
    }

    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i2, int i3);

        public abstract boolean areItemsTheSame(int i2, int i3);

        @Nullable
        public Object getChangePayload(int i2, int i3) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    public static class DiffResult {
        public static final int NO_POSITION = -1;

        /* renamed from: a */
        private static final int f3229a = 1;

        /* renamed from: b */
        private static final int f3230b = 2;

        /* renamed from: c */
        private static final int f3231c = 4;

        /* renamed from: d */
        private static final int f3232d = 8;

        /* renamed from: e */
        private static final int f3233e = 16;

        /* renamed from: f */
        private static final int f3234f = 5;

        /* renamed from: g */
        private static final int f3235g = 31;

        /* renamed from: h */
        private final List<Snake> f3236h;

        /* renamed from: i */
        private final int[] f3237i;

        /* renamed from: j */
        private final int[] f3238j;
        private final Callback k;
        private final int l;
        private final int m;
        private final boolean n;

        DiffResult(Callback callback, List<Snake> list, int[] iArr, int[] iArr2, boolean z) {
            this.f3236h = list;
            this.f3237i = iArr;
            this.f3238j = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.k = callback;
            this.l = callback.getOldListSize();
            this.m = callback.getNewListSize();
            this.n = z;
            a();
            f();
        }

        private void a() {
            Snake snake = this.f3236h.isEmpty() ? null : this.f3236h.get(0);
            if (snake != null && snake.f3246a == 0 && snake.f3247b == 0) {
                return;
            }
            Snake snake2 = new Snake();
            snake2.f3246a = 0;
            snake2.f3247b = 0;
            snake2.f3249d = false;
            snake2.f3248c = 0;
            snake2.f3250e = false;
            this.f3236h.add(0, snake2);
        }

        private void b(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i2, int i3, int i4) {
            if (!this.n) {
                listUpdateCallback.onInserted(i2, i3);
                return;
            }
            for (int i5 = i3 - 1; i5 >= 0; i5--) {
                int[] iArr = this.f3238j;
                int i6 = i4 + i5;
                int i7 = iArr[i6] & 31;
                if (i7 == 0) {
                    listUpdateCallback.onInserted(i2, 1);
                    Iterator<PostponedUpdate> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().f3240b++;
                    }
                } else if (i7 == 4 || i7 == 8) {
                    int i8 = iArr[i6] >> 5;
                    listUpdateCallback.onMoved(i(list, i8, true).f3240b, i2);
                    if (i7 == 4) {
                        listUpdateCallback.onChanged(i2, 1, this.k.getChangePayload(i8, i6));
                    }
                } else {
                    if (i7 != 16) {
                        throw new IllegalStateException("unknown flag for pos " + i6 + " " + Long.toBinaryString(i7));
                    }
                    list.add(new PostponedUpdate(i6, i2, false));
                }
            }
        }

        private void c(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i2, int i3, int i4) {
            if (!this.n) {
                listUpdateCallback.onRemoved(i2, i3);
                return;
            }
            for (int i5 = i3 - 1; i5 >= 0; i5--) {
                int[] iArr = this.f3237i;
                int i6 = i4 + i5;
                int i7 = iArr[i6] & 31;
                if (i7 == 0) {
                    listUpdateCallback.onRemoved(i2 + i5, 1);
                    Iterator<PostponedUpdate> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().f3240b--;
                    }
                } else if (i7 == 4 || i7 == 8) {
                    int i8 = iArr[i6] >> 5;
                    PostponedUpdate i9 = i(list, i8, false);
                    listUpdateCallback.onMoved(i2 + i5, i9.f3240b - 1);
                    if (i7 == 4) {
                        listUpdateCallback.onChanged(i9.f3240b - 1, 1, this.k.getChangePayload(i6, i8));
                    }
                } else {
                    if (i7 != 16) {
                        throw new IllegalStateException("unknown flag for pos " + i6 + " " + Long.toBinaryString(i7));
                    }
                    list.add(new PostponedUpdate(i6, i2 + i5, true));
                }
            }
        }

        private void d(int i2, int i3, int i4) {
            if (this.f3237i[i2 - 1] != 0) {
                return;
            }
            e(i2, i3, i4, false);
        }

        private boolean e(int i2, int i3, int i4, boolean z) {
            int i5;
            int i6;
            int i7;
            if (z) {
                i3--;
                i6 = i2;
                i5 = i3;
            } else {
                i5 = i2 - 1;
                i6 = i5;
            }
            while (i4 >= 0) {
                Snake snake = this.f3236h.get(i4);
                int i8 = snake.f3246a;
                int i9 = snake.f3248c;
                int i10 = i8 + i9;
                int i11 = snake.f3247b + i9;
                if (z) {
                    for (int i12 = i6 - 1; i12 >= i10; i12--) {
                        if (this.k.areItemsTheSame(i12, i5)) {
                            i7 = this.k.areContentsTheSame(i12, i5) ? 8 : 4;
                            this.f3238j[i5] = (i12 << 5) | 16;
                            this.f3237i[i12] = (i5 << 5) | i7;
                            return true;
                        }
                    }
                } else {
                    for (int i13 = i3 - 1; i13 >= i11; i13--) {
                        if (this.k.areItemsTheSame(i5, i13)) {
                            i7 = this.k.areContentsTheSame(i5, i13) ? 8 : 4;
                            int i14 = i2 - 1;
                            this.f3237i[i14] = (i13 << 5) | 16;
                            this.f3238j[i13] = (i14 << 5) | i7;
                            return true;
                        }
                    }
                }
                i6 = snake.f3246a;
                i3 = snake.f3247b;
                i4--;
            }
            return false;
        }

        private void f() {
            int i2 = this.l;
            int i3 = this.m;
            for (int size = this.f3236h.size() - 1; size >= 0; size--) {
                Snake snake = this.f3236h.get(size);
                int i4 = snake.f3246a;
                int i5 = snake.f3248c;
                int i6 = i4 + i5;
                int i7 = snake.f3247b + i5;
                if (this.n) {
                    while (i2 > i6) {
                        d(i2, i3, size);
                        i2--;
                    }
                    while (i3 > i7) {
                        g(i2, i3, size);
                        i3--;
                    }
                }
                for (int i8 = 0; i8 < snake.f3248c; i8++) {
                    int i9 = snake.f3246a + i8;
                    int i10 = snake.f3247b + i8;
                    int i11 = this.k.areContentsTheSame(i9, i10) ? 1 : 2;
                    this.f3237i[i9] = (i10 << 5) | i11;
                    this.f3238j[i10] = (i9 << 5) | i11;
                }
                i2 = snake.f3246a;
                i3 = snake.f3247b;
            }
        }

        private void g(int i2, int i3, int i4) {
            if (this.f3238j[i3 - 1] != 0) {
                return;
            }
            e(i2, i3, i4, true);
        }

        private static PostponedUpdate i(List<PostponedUpdate> list, int i2, boolean z) {
            int size = list.size() - 1;
            while (size >= 0) {
                PostponedUpdate postponedUpdate = list.get(size);
                if (postponedUpdate.f3239a == i2 && postponedUpdate.f3241c == z) {
                    list.remove(size);
                    while (size < list.size()) {
                        list.get(size).f3240b += z ? 1 : -1;
                        size++;
                    }
                    return postponedUpdate;
                }
                size--;
            }
            return null;
        }

        public int convertNewPositionToOld(@IntRange(from = 0) int i2) {
            if (i2 >= 0 && i2 < this.m) {
                int i3 = this.f3238j[i2];
                if ((i3 & 31) == 0) {
                    return -1;
                }
                return i3 >> 5;
            }
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i2 + ", new list size = " + this.m);
        }

        public int convertOldPositionToNew(@IntRange(from = 0) int i2) {
            if (i2 >= 0 && i2 < this.l) {
                int i3 = this.f3237i[i2];
                if ((i3 & 31) == 0) {
                    return -1;
                }
                return i3 >> 5;
            }
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i2 + ", old list size = " + this.l);
        }

        public void dispatchUpdatesTo(@NonNull RecyclerView.Adapter adapter) {
            dispatchUpdatesTo(new AdapterListUpdateCallback(adapter));
        }

        @VisibleForTesting
        List<Snake> h() {
            return this.f3236h;
        }

        public void dispatchUpdatesTo(@NonNull ListUpdateCallback listUpdateCallback) {
            BatchingListUpdateCallback batchingListUpdateCallback = listUpdateCallback instanceof BatchingListUpdateCallback ? (BatchingListUpdateCallback) listUpdateCallback : new BatchingListUpdateCallback(listUpdateCallback);
            ArrayList arrayList = new ArrayList();
            int i2 = this.l;
            int i3 = this.m;
            for (int size = this.f3236h.size() - 1; size >= 0; size--) {
                Snake snake = this.f3236h.get(size);
                int i4 = snake.f3248c;
                int i5 = snake.f3246a + i4;
                int i6 = snake.f3247b + i4;
                if (i5 < i2) {
                    c(arrayList, batchingListUpdateCallback, i5, i2 - i5, i5);
                }
                if (i6 < i3) {
                    b(arrayList, batchingListUpdateCallback, i5, i3 - i6, i6);
                }
                for (int i7 = i4 - 1; i7 >= 0; i7--) {
                    int[] iArr = this.f3237i;
                    int i8 = snake.f3246a;
                    if ((iArr[i8 + i7] & 31) == 2) {
                        batchingListUpdateCallback.onChanged(i8 + i7, 1, this.k.getChangePayload(i8 + i7, snake.f3247b + i7));
                    }
                }
                i2 = snake.f3246a;
                i3 = snake.f3247b;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }
    }

    public static abstract class ItemCallback<T> {
        public abstract boolean areContentsTheSame(@NonNull T t, @NonNull T t2);

        public abstract boolean areItemsTheSame(@NonNull T t, @NonNull T t2);

        @Nullable
        public Object getChangePayload(@NonNull T t, @NonNull T t2) {
            return null;
        }
    }

    private static class PostponedUpdate {

        /* renamed from: a */
        int f3239a;

        /* renamed from: b */
        int f3240b;

        /* renamed from: c */
        boolean f3241c;

        public PostponedUpdate(int i2, int i3, boolean z) {
            this.f3239a = i2;
            this.f3240b = i3;
            this.f3241c = z;
        }
    }

    static class Range {

        /* renamed from: a */
        int f3242a;

        /* renamed from: b */
        int f3243b;

        /* renamed from: c */
        int f3244c;

        /* renamed from: d */
        int f3245d;

        public Range() {
        }

        public Range(int i2, int i3, int i4, int i5) {
            this.f3242a = i2;
            this.f3243b = i3;
            this.f3244c = i4;
            this.f3245d = i5;
        }
    }

    static class Snake {

        /* renamed from: a */
        int f3246a;

        /* renamed from: b */
        int f3247b;

        /* renamed from: c */
        int f3248c;

        /* renamed from: d */
        boolean f3249d;

        /* renamed from: e */
        boolean f3250e;

        Snake() {
        }
    }

    private DiffUtil() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
    
        if (r24[r13 - 1] < r24[r13 + r5]) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b8, code lost:
    
        if (r25[r12 - 1] < r25[r12 + 1]) goto L142;
     */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e1 A[LOOP:4: B:54:0x00cd->B:58:0x00e1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ec A[EDGE_INSN: B:59:0x00ec->B:60:0x00ec BREAK  A[LOOP:4: B:54:0x00cd->B:58:0x00e1], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static androidx.recyclerview.widget.DiffUtil.Snake a(androidx.recyclerview.widget.DiffUtil.Callback r19, int r20, int r21, int r22, int r23, int[] r24, int[] r25, int r26) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.DiffUtil.a(androidx.recyclerview.widget.DiffUtil$Callback, int, int, int, int, int[], int[], int):androidx.recyclerview.widget.DiffUtil$Snake");
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback) {
        return calculateDiff(callback, true);
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback, boolean z) {
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, oldListSize, 0, newListSize));
        int abs = oldListSize + newListSize + Math.abs(oldListSize - newListSize);
        int i2 = abs * 2;
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake a2 = a(callback, range.f3242a, range.f3243b, range.f3244c, range.f3245d, iArr, iArr2, abs);
            if (a2 != null) {
                if (a2.f3248c > 0) {
                    arrayList.add(a2);
                }
                a2.f3246a += range.f3242a;
                a2.f3247b += range.f3244c;
                Range range2 = arrayList3.isEmpty() ? new Range() : (Range) arrayList3.remove(arrayList3.size() - 1);
                range2.f3242a = range.f3242a;
                range2.f3244c = range.f3244c;
                if (a2.f3250e) {
                    range2.f3243b = a2.f3246a;
                    range2.f3245d = a2.f3247b;
                } else if (a2.f3249d) {
                    range2.f3243b = a2.f3246a - 1;
                    range2.f3245d = a2.f3247b;
                } else {
                    range2.f3243b = a2.f3246a;
                    range2.f3245d = a2.f3247b - 1;
                }
                arrayList2.add(range2);
                if (!a2.f3250e) {
                    int i3 = a2.f3246a;
                    int i4 = a2.f3248c;
                    range.f3242a = i3 + i4;
                    range.f3244c = a2.f3247b + i4;
                } else if (a2.f3249d) {
                    int i5 = a2.f3246a;
                    int i6 = a2.f3248c;
                    range.f3242a = i5 + i6 + 1;
                    range.f3244c = a2.f3247b + i6;
                } else {
                    int i7 = a2.f3246a;
                    int i8 = a2.f3248c;
                    range.f3242a = i7 + i8;
                    range.f3244c = a2.f3247b + i8 + 1;
                }
                arrayList2.add(range);
            } else {
                arrayList3.add(range);
            }
        }
        Collections.sort(arrayList, f3228a);
        return new DiffResult(callback, arrayList, iArr, iArr2, z);
    }
}
