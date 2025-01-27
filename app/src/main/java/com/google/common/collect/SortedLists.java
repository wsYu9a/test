package com.google.common.collect;

import e5.d1;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

@a5.b
@a5.a
@e5.m
/* loaded from: classes2.dex */
public final class SortedLists {

    public enum KeyAbsentBehavior {
        NEXT_LOWER { // from class: com.google.common.collect.SortedLists.KeyAbsentBehavior.1
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i10) {
                return i10 - 1;
            }
        },
        NEXT_HIGHER { // from class: com.google.common.collect.SortedLists.KeyAbsentBehavior.2
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i10) {
                return i10;
            }
        },
        INVERTED_INSERTION_INDEX { // from class: com.google.common.collect.SortedLists.KeyAbsentBehavior.3
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i10) {
                return ~i10;
            }
        };

        /* renamed from: com.google.common.collect.SortedLists$KeyAbsentBehavior$1 */
        public enum AnonymousClass1 extends KeyAbsentBehavior {
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i10) {
                return i10 - 1;
            }
        }

        /* renamed from: com.google.common.collect.SortedLists$KeyAbsentBehavior$2 */
        public enum AnonymousClass2 extends KeyAbsentBehavior {
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i10) {
                return i10;
            }
        }

        /* renamed from: com.google.common.collect.SortedLists$KeyAbsentBehavior$3 */
        public enum AnonymousClass3 extends KeyAbsentBehavior {
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i10) {
                return ~i10;
            }
        }

        public abstract int resultIndex(int i10);

        /* synthetic */ KeyAbsentBehavior(a aVar) {
            this();
        }
    }

    public enum KeyPresentBehavior {
        ANY_PRESENT { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.1
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, @d1 E e10, List<? extends E> list, int i10) {
                return i10;
            }
        },
        LAST_PRESENT { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, @d1 E e10, List<? extends E> list, int i10) {
                int size = list.size() - 1;
                while (i10 < size) {
                    int i11 = ((i10 + size) + 1) >>> 1;
                    if (comparator.compare(list.get(i11), e10) > 0) {
                        size = i11 - 1;
                    } else {
                        i10 = i11;
                    }
                }
                return i10;
            }
        },
        FIRST_PRESENT { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, @d1 E e10, List<? extends E> list, int i10) {
                int i11 = 0;
                while (i11 < i10) {
                    int i12 = (i11 + i10) >>> 1;
                    if (comparator.compare(list.get(i12), e10) < 0) {
                        i11 = i12 + 1;
                    } else {
                        i10 = i12;
                    }
                }
                return i11;
            }
        },
        FIRST_AFTER { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.4
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, @d1 E e10, List<? extends E> list, int i10) {
                return KeyPresentBehavior.LAST_PRESENT.resultIndex(comparator, e10, list, i10) + 1;
            }
        },
        LAST_BEFORE { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.5
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, @d1 E e10, List<? extends E> list, int i10) {
                return KeyPresentBehavior.FIRST_PRESENT.resultIndex(comparator, e10, list, i10) - 1;
            }
        };

        /* renamed from: com.google.common.collect.SortedLists$KeyPresentBehavior$1 */
        public enum AnonymousClass1 extends KeyPresentBehavior {
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, @d1 E e10, List<? extends E> list, int i10) {
                return i10;
            }
        }

        /* renamed from: com.google.common.collect.SortedLists$KeyPresentBehavior$2 */
        public enum AnonymousClass2 extends KeyPresentBehavior {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, @d1 E e10, List<? extends E> list, int i10) {
                int size = list.size() - 1;
                while (i10 < size) {
                    int i11 = ((i10 + size) + 1) >>> 1;
                    if (comparator.compare(list.get(i11), e10) > 0) {
                        size = i11 - 1;
                    } else {
                        i10 = i11;
                    }
                }
                return i10;
            }
        }

        /* renamed from: com.google.common.collect.SortedLists$KeyPresentBehavior$3 */
        public enum AnonymousClass3 extends KeyPresentBehavior {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, @d1 E e10, List<? extends E> list, int i10) {
                int i11 = 0;
                while (i11 < i10) {
                    int i12 = (i11 + i10) >>> 1;
                    if (comparator.compare(list.get(i12), e10) < 0) {
                        i11 = i12 + 1;
                    } else {
                        i10 = i12;
                    }
                }
                return i11;
            }
        }

        /* renamed from: com.google.common.collect.SortedLists$KeyPresentBehavior$4 */
        public enum AnonymousClass4 extends KeyPresentBehavior {
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, @d1 E e10, List<? extends E> list, int i10) {
                return KeyPresentBehavior.LAST_PRESENT.resultIndex(comparator, e10, list, i10) + 1;
            }
        }

        /* renamed from: com.google.common.collect.SortedLists$KeyPresentBehavior$5 */
        public enum AnonymousClass5 extends KeyPresentBehavior {
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, @d1 E e10, List<? extends E> list, int i10) {
                return KeyPresentBehavior.FIRST_PRESENT.resultIndex(comparator, e10, list, i10) - 1;
            }
        }

        public abstract <E> int resultIndex(Comparator<? super E> comparator, @d1 E e10, List<? extends E> list, int i10);

        /* synthetic */ KeyPresentBehavior(a aVar) {
            this();
        }
    }

    public static <E, K extends Comparable> int a(List<E> list, b5.n<? super E, K> nVar, K k10, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        b5.u.E(k10);
        return b(list, nVar, k10, Ordering.natural(), keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E, K> int b(List<E> list, b5.n<? super E, K> nVar, @d1 K k10, Comparator<? super K> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        return d(Lists.D(list, nVar), k10, comparator, keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E extends Comparable> int c(List<? extends E> list, E e10, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        b5.u.E(e10);
        return d(list, e10, Ordering.natural(), keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E> int d(List<? extends E> list, @d1 E e10, Comparator<? super E> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        b5.u.E(comparator);
        b5.u.E(list);
        b5.u.E(keyPresentBehavior);
        b5.u.E(keyAbsentBehavior);
        if (!(list instanceof RandomAccess)) {
            list = Lists.r(list);
        }
        int size = list.size() - 1;
        int i10 = 0;
        while (i10 <= size) {
            int i11 = (i10 + size) >>> 1;
            int compare = comparator.compare(e10, list.get(i11));
            if (compare < 0) {
                size = i11 - 1;
            } else {
                if (compare <= 0) {
                    return i10 + keyPresentBehavior.resultIndex(comparator, e10, list.subList(i10, size + 1), i11 - i10);
                }
                i10 = i11 + 1;
            }
        }
        return keyAbsentBehavior.resultIndex(i10);
    }
}
