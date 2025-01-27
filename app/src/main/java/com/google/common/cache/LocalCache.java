package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.a;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.RetainedWith;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import p5.b1;

@a5.b(emulated = true)
/* loaded from: classes2.dex */
public class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {
    public static final int A = 63;
    public static final int B = 16;
    public static final Logger C = Logger.getLogger(LocalCache.class.getName());
    public static final s<Object, Object> D = new a();
    public static final Queue<?> E = new b();

    /* renamed from: x */
    public static final int f9182x = 1073741824;

    /* renamed from: y */
    public static final int f9183y = 65536;

    /* renamed from: z */
    public static final int f9184z = 3;

    /* renamed from: b */
    public final int f9185b;

    /* renamed from: c */
    public final int f9186c;

    /* renamed from: d */
    public final Segment<K, V>[] f9187d;

    /* renamed from: e */
    public final int f9188e;

    /* renamed from: f */
    public final Equivalence<Object> f9189f;

    /* renamed from: g */
    public final Equivalence<Object> f9190g;

    /* renamed from: h */
    public final Strength f9191h;

    /* renamed from: i */
    public final Strength f9192i;

    /* renamed from: j */
    public final long f9193j;

    /* renamed from: k */
    public final d5.n<K, V> f9194k;

    /* renamed from: l */
    public final long f9195l;

    /* renamed from: m */
    public final long f9196m;

    /* renamed from: n */
    public final long f9197n;

    /* renamed from: o */
    public final Queue<RemovalNotification<K, V>> f9198o;

    /* renamed from: p */
    public final d5.j<K, V> f9199p;

    /* renamed from: q */
    public final b5.b0 f9200q;

    /* renamed from: r */
    public final EntryFactory f9201r;

    /* renamed from: s */
    public final a.b f9202s;

    /* renamed from: t */
    @CheckForNull
    public final CacheLoader<? super K, V> f9203t;

    /* renamed from: u */
    @RetainedWith
    @CheckForNull
    public Set<K> f9204u;

    /* renamed from: v */
    @RetainedWith
    @CheckForNull
    public Collection<V> f9205v;

    /* renamed from: w */
    @RetainedWith
    @CheckForNull
    public Set<Map.Entry<K, V>> f9206w;

    public static abstract class EntryFactory extends Enum<EntryFactory> {
        private static final /* synthetic */ EntryFactory[] $VALUES = $values();
        static final int ACCESS_MASK = 1;
        public static final EntryFactory STRONG;
        public static final EntryFactory STRONG_ACCESS;
        public static final EntryFactory STRONG_ACCESS_WRITE;
        public static final EntryFactory STRONG_WRITE;
        public static final EntryFactory WEAK;
        public static final EntryFactory WEAK_ACCESS;
        public static final EntryFactory WEAK_ACCESS_WRITE;
        static final int WEAK_MASK = 4;
        public static final EntryFactory WEAK_WRITE;
        static final int WRITE_MASK = 2;
        static final EntryFactory[] factories = {new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.1
            public AnonymousClass1(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.c<K, V> newEntry(Segment<K, V> segment, K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
                return new o(k10, i10, cVar);
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.2
            public AnonymousClass2(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.c<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.c<K, V> cVar, com.google.common.cache.c<K, V> cVar2) {
                com.google.common.cache.c<K, V> copyEntry = super.copyEntry(segment, cVar, cVar2);
                copyAccessEntry(cVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.c<K, V> newEntry(Segment<K, V> segment, K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
                return new m(k10, i10, cVar);
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.3
            public AnonymousClass3(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.c<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.c<K, V> cVar, com.google.common.cache.c<K, V> cVar2) {
                com.google.common.cache.c<K, V> copyEntry = super.copyEntry(segment, cVar, cVar2);
                copyWriteEntry(cVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.c<K, V> newEntry(Segment<K, V> segment, K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
                return new q(k10, i10, cVar);
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.4
            public AnonymousClass4(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.c<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.c<K, V> cVar, com.google.common.cache.c<K, V> cVar2) {
                com.google.common.cache.c<K, V> copyEntry = super.copyEntry(segment, cVar, cVar2);
                copyAccessEntry(cVar, copyEntry);
                copyWriteEntry(cVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.c<K, V> newEntry(Segment<K, V> segment, K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
                return new n(k10, i10, cVar);
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.5
            public AnonymousClass5(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.c<K, V> newEntry(Segment<K, V> segment, K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
                return new w(segment.keyReferenceQueue, k10, i10, cVar);
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.6
            public AnonymousClass6(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.c<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.c<K, V> cVar, com.google.common.cache.c<K, V> cVar2) {
                com.google.common.cache.c<K, V> copyEntry = super.copyEntry(segment, cVar, cVar2);
                copyAccessEntry(cVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.c<K, V> newEntry(Segment<K, V> segment, K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
                return new u(segment.keyReferenceQueue, k10, i10, cVar);
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.7
            public AnonymousClass7(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.c<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.c<K, V> cVar, com.google.common.cache.c<K, V> cVar2) {
                com.google.common.cache.c<K, V> copyEntry = super.copyEntry(segment, cVar, cVar2);
                copyWriteEntry(cVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.c<K, V> newEntry(Segment<K, V> segment, K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
                return new y(segment.keyReferenceQueue, k10, i10, cVar);
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.8
            public AnonymousClass8(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.c<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.c<K, V> cVar, com.google.common.cache.c<K, V> cVar2) {
                com.google.common.cache.c<K, V> copyEntry = super.copyEntry(segment, cVar, cVar2);
                copyAccessEntry(cVar, copyEntry);
                copyWriteEntry(cVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.c<K, V> newEntry(Segment<K, V> segment, K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
                return new v(segment.keyReferenceQueue, k10, i10, cVar);
            }
        }};

        /* renamed from: com.google.common.cache.LocalCache$EntryFactory$1 */
        public enum AnonymousClass1 extends EntryFactory {
            public AnonymousClass1(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.c<K, V> newEntry(Segment<K, V> segment, K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
                return new o(k10, i10, cVar);
            }
        }

        /* renamed from: com.google.common.cache.LocalCache$EntryFactory$2 */
        public enum AnonymousClass2 extends EntryFactory {
            public AnonymousClass2(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.c<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.c<K, V> cVar, com.google.common.cache.c<K, V> cVar2) {
                com.google.common.cache.c<K, V> copyEntry = super.copyEntry(segment, cVar, cVar2);
                copyAccessEntry(cVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.c<K, V> newEntry(Segment<K, V> segment, K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
                return new m(k10, i10, cVar);
            }
        }

        /* renamed from: com.google.common.cache.LocalCache$EntryFactory$3 */
        public enum AnonymousClass3 extends EntryFactory {
            public AnonymousClass3(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.c<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.c<K, V> cVar, com.google.common.cache.c<K, V> cVar2) {
                com.google.common.cache.c<K, V> copyEntry = super.copyEntry(segment, cVar, cVar2);
                copyWriteEntry(cVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.c<K, V> newEntry(Segment<K, V> segment, K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
                return new q(k10, i10, cVar);
            }
        }

        /* renamed from: com.google.common.cache.LocalCache$EntryFactory$4 */
        public enum AnonymousClass4 extends EntryFactory {
            public AnonymousClass4(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.c<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.c<K, V> cVar, com.google.common.cache.c<K, V> cVar2) {
                com.google.common.cache.c<K, V> copyEntry = super.copyEntry(segment, cVar, cVar2);
                copyAccessEntry(cVar, copyEntry);
                copyWriteEntry(cVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.c<K, V> newEntry(Segment<K, V> segment, K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
                return new n(k10, i10, cVar);
            }
        }

        /* renamed from: com.google.common.cache.LocalCache$EntryFactory$5 */
        public enum AnonymousClass5 extends EntryFactory {
            public AnonymousClass5(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.c<K, V> newEntry(Segment<K, V> segment, K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
                return new w(segment.keyReferenceQueue, k10, i10, cVar);
            }
        }

        /* renamed from: com.google.common.cache.LocalCache$EntryFactory$6 */
        public enum AnonymousClass6 extends EntryFactory {
            public AnonymousClass6(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.c<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.c<K, V> cVar, com.google.common.cache.c<K, V> cVar2) {
                com.google.common.cache.c<K, V> copyEntry = super.copyEntry(segment, cVar, cVar2);
                copyAccessEntry(cVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.c<K, V> newEntry(Segment<K, V> segment, K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
                return new u(segment.keyReferenceQueue, k10, i10, cVar);
            }
        }

        /* renamed from: com.google.common.cache.LocalCache$EntryFactory$7 */
        public enum AnonymousClass7 extends EntryFactory {
            public AnonymousClass7(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.c<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.c<K, V> cVar, com.google.common.cache.c<K, V> cVar2) {
                com.google.common.cache.c<K, V> copyEntry = super.copyEntry(segment, cVar, cVar2);
                copyWriteEntry(cVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.c<K, V> newEntry(Segment<K, V> segment, K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
                return new y(segment.keyReferenceQueue, k10, i10, cVar);
            }
        }

        /* renamed from: com.google.common.cache.LocalCache$EntryFactory$8 */
        public enum AnonymousClass8 extends EntryFactory {
            public AnonymousClass8(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.c<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.c<K, V> cVar, com.google.common.cache.c<K, V> cVar2) {
                com.google.common.cache.c<K, V> copyEntry = super.copyEntry(segment, cVar, cVar2);
                copyAccessEntry(cVar, copyEntry);
                copyWriteEntry(cVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.c<K, V> newEntry(Segment<K, V> segment, K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
                return new v(segment.keyReferenceQueue, k10, i10, cVar);
            }
        }

        private static /* synthetic */ EntryFactory[] $values() {
            return new EntryFactory[]{STRONG, STRONG_ACCESS, STRONG_WRITE, STRONG_ACCESS_WRITE, WEAK, WEAK_ACCESS, WEAK_WRITE, WEAK_ACCESS_WRITE};
        }

        static {
            AnonymousClass1 anonymousClass1 = new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.1
                public AnonymousClass1(String str, int i10) {
                    super(str, i10, null);
                }

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public <K, V> com.google.common.cache.c<K, V> newEntry(Segment<K, V> segment, K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
                    return new o(k10, i10, cVar);
                }
            };
            STRONG = anonymousClass1;
            AnonymousClass2 anonymousClass2 = new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.2
                public AnonymousClass2(String str, int i10) {
                    super(str, i10, null);
                }

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public <K, V> com.google.common.cache.c<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.c<K, V> cVar, com.google.common.cache.c<K, V> cVar2) {
                    com.google.common.cache.c<K, V> copyEntry = super.copyEntry(segment, cVar, cVar2);
                    copyAccessEntry(cVar, copyEntry);
                    return copyEntry;
                }

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public <K, V> com.google.common.cache.c<K, V> newEntry(Segment<K, V> segment, K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
                    return new m(k10, i10, cVar);
                }
            };
            STRONG_ACCESS = anonymousClass2;
            AnonymousClass3 anonymousClass3 = new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.3
                public AnonymousClass3(String str, int i10) {
                    super(str, i10, null);
                }

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public <K, V> com.google.common.cache.c<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.c<K, V> cVar, com.google.common.cache.c<K, V> cVar2) {
                    com.google.common.cache.c<K, V> copyEntry = super.copyEntry(segment, cVar, cVar2);
                    copyWriteEntry(cVar, copyEntry);
                    return copyEntry;
                }

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public <K, V> com.google.common.cache.c<K, V> newEntry(Segment<K, V> segment, K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
                    return new q(k10, i10, cVar);
                }
            };
            STRONG_WRITE = anonymousClass3;
            AnonymousClass4 anonymousClass4 = new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.4
                public AnonymousClass4(String str, int i10) {
                    super(str, i10, null);
                }

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public <K, V> com.google.common.cache.c<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.c<K, V> cVar, com.google.common.cache.c<K, V> cVar2) {
                    com.google.common.cache.c<K, V> copyEntry = super.copyEntry(segment, cVar, cVar2);
                    copyAccessEntry(cVar, copyEntry);
                    copyWriteEntry(cVar, copyEntry);
                    return copyEntry;
                }

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public <K, V> com.google.common.cache.c<K, V> newEntry(Segment<K, V> segment, K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
                    return new n(k10, i10, cVar);
                }
            };
            STRONG_ACCESS_WRITE = anonymousClass4;
            AnonymousClass5 anonymousClass5 = new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.5
                public AnonymousClass5(String str, int i10) {
                    super(str, i10, null);
                }

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public <K, V> com.google.common.cache.c<K, V> newEntry(Segment<K, V> segment, K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
                    return new w(segment.keyReferenceQueue, k10, i10, cVar);
                }
            };
            WEAK = anonymousClass5;
            AnonymousClass6 anonymousClass6 = new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.6
                public AnonymousClass6(String str, int i10) {
                    super(str, i10, null);
                }

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public <K, V> com.google.common.cache.c<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.c<K, V> cVar, com.google.common.cache.c<K, V> cVar2) {
                    com.google.common.cache.c<K, V> copyEntry = super.copyEntry(segment, cVar, cVar2);
                    copyAccessEntry(cVar, copyEntry);
                    return copyEntry;
                }

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public <K, V> com.google.common.cache.c<K, V> newEntry(Segment<K, V> segment, K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
                    return new u(segment.keyReferenceQueue, k10, i10, cVar);
                }
            };
            WEAK_ACCESS = anonymousClass6;
            AnonymousClass7 anonymousClass7 = new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.7
                public AnonymousClass7(String str, int i10) {
                    super(str, i10, null);
                }

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public <K, V> com.google.common.cache.c<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.c<K, V> cVar, com.google.common.cache.c<K, V> cVar2) {
                    com.google.common.cache.c<K, V> copyEntry = super.copyEntry(segment, cVar, cVar2);
                    copyWriteEntry(cVar, copyEntry);
                    return copyEntry;
                }

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public <K, V> com.google.common.cache.c<K, V> newEntry(Segment<K, V> segment, K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
                    return new y(segment.keyReferenceQueue, k10, i10, cVar);
                }
            };
            WEAK_WRITE = anonymousClass7;
            AnonymousClass8 anonymousClass8 = new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.8
                public AnonymousClass8(String str, int i10) {
                    super(str, i10, null);
                }

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public <K, V> com.google.common.cache.c<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.c<K, V> cVar, com.google.common.cache.c<K, V> cVar2) {
                    com.google.common.cache.c<K, V> copyEntry = super.copyEntry(segment, cVar, cVar2);
                    copyAccessEntry(cVar, copyEntry);
                    copyWriteEntry(cVar, copyEntry);
                    return copyEntry;
                }

                @Override // com.google.common.cache.LocalCache.EntryFactory
                public <K, V> com.google.common.cache.c<K, V> newEntry(Segment<K, V> segment, K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
                    return new v(segment.keyReferenceQueue, k10, i10, cVar);
                }
            };
            WEAK_ACCESS_WRITE = anonymousClass8;
            $VALUES = $values();
            factories = new EntryFactory[]{anonymousClass1, anonymousClass2, anonymousClass3, anonymousClass4, anonymousClass5, anonymousClass6, anonymousClass7, anonymousClass8};
        }

        private EntryFactory(String str, int i10) {
            super(str, i10);
        }

        public static EntryFactory getFactory(Strength strength, boolean z10, boolean z11) {
            return factories[(strength == Strength.WEAK ? 4 : 0) | (z10 ? 1 : 0) | (z11 ? 2 : 0)];
        }

        public static EntryFactory valueOf(String str) {
            return (EntryFactory) Enum.valueOf(EntryFactory.class, str);
        }

        public static EntryFactory[] values() {
            return (EntryFactory[]) $VALUES.clone();
        }

        public <K, V> void copyAccessEntry(com.google.common.cache.c<K, V> cVar, com.google.common.cache.c<K, V> cVar2) {
            cVar2.setAccessTime(cVar.getAccessTime());
            LocalCache.e(cVar.getPreviousInAccessQueue(), cVar2);
            LocalCache.e(cVar2, cVar.getNextInAccessQueue());
            LocalCache.F(cVar);
        }

        public <K, V> com.google.common.cache.c<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.c<K, V> cVar, com.google.common.cache.c<K, V> cVar2) {
            return newEntry(segment, cVar.getKey(), cVar.getHash(), cVar2);
        }

        public <K, V> void copyWriteEntry(com.google.common.cache.c<K, V> cVar, com.google.common.cache.c<K, V> cVar2) {
            cVar2.setWriteTime(cVar.getWriteTime());
            LocalCache.f(cVar.getPreviousInWriteQueue(), cVar2);
            LocalCache.f(cVar2, cVar.getNextInWriteQueue());
            LocalCache.G(cVar);
        }

        public abstract <K, V> com.google.common.cache.c<K, V> newEntry(Segment<K, V> segment, K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar);

        public /* synthetic */ EntryFactory(String str, int i10, a aVar) {
            this(str, i10);
        }
    }

    public static final class LoadingSerializationProxy<K, V> extends ManualSerializationProxy<K, V> implements d5.g<K, V>, Serializable {
        private static final long serialVersionUID = 1;

        @CheckForNull
        transient d5.g<K, V> autoDelegate;

        public LoadingSerializationProxy(LocalCache<K, V> localCache) {
            super(localCache);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.autoDelegate = (d5.g<K, V>) recreateCacheBuilder().b(this.loader);
        }

        private Object readResolve() {
            return this.autoDelegate;
        }

        @Override // d5.g, b5.n
        public final V apply(K k10) {
            return this.autoDelegate.apply(k10);
        }

        @Override // d5.g
        public V get(K k10) throws ExecutionException {
            return this.autoDelegate.get(k10);
        }

        @Override // d5.g
        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            return this.autoDelegate.getAll(iterable);
        }

        @Override // d5.g
        public V getUnchecked(K k10) {
            return this.autoDelegate.getUnchecked(k10);
        }

        @Override // d5.g
        public void refresh(K k10) {
            this.autoDelegate.refresh(k10);
        }
    }

    public static class LocalLoadingCache<K, V> extends LocalManualCache<K, V> implements d5.g<K, V> {
        private static final long serialVersionUID = 1;

        public LocalLoadingCache(CacheBuilder<? super K, ? super V> cacheBuilder, CacheLoader<? super K, V> cacheLoader) {
            super(new LocalCache(cacheBuilder, (CacheLoader) b5.u.E(cacheLoader)), null);
        }

        @Override // d5.g, b5.n
        public final V apply(K k10) {
            return getUnchecked(k10);
        }

        @Override // d5.g
        public V get(K k10) throws ExecutionException {
            return this.localCache.u(k10);
        }

        @Override // d5.g
        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            return this.localCache.p(iterable);
        }

        @Override // d5.g
        public V getUnchecked(K k10) {
            try {
                return get(k10);
            } catch (ExecutionException e10) {
                throw new UncheckedExecutionException(e10.getCause());
            }
        }

        @Override // d5.g
        public void refresh(K k10) {
            this.localCache.N(k10);
        }

        @Override // com.google.common.cache.LocalCache.LocalManualCache
        public Object writeReplace() {
            return new LoadingSerializationProxy(this.localCache);
        }
    }

    public static class LocalManualCache<K, V> implements d5.b<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        final LocalCache<K, V> localCache;

        public class a extends CacheLoader<Object, V> {

            /* renamed from: b */
            public final /* synthetic */ Callable f9207b;

            public a(LocalManualCache localManualCache, Callable callable) {
                this.f9207b = callable;
            }

            @Override // com.google.common.cache.CacheLoader
            public V load(Object obj) throws Exception {
                return (V) this.f9207b.call();
            }
        }

        public /* synthetic */ LocalManualCache(LocalCache localCache, a aVar) {
            this(localCache);
        }

        @Override // d5.b
        public ConcurrentMap<K, V> asMap() {
            return this.localCache;
        }

        @Override // d5.b
        public void cleanUp() {
            this.localCache.c();
        }

        @Override // d5.b
        public V get(K k10, Callable<? extends V> callable) throws ExecutionException {
            b5.u.E(callable);
            return this.localCache.o(k10, new a(this, callable));
        }

        @Override // d5.b
        public ImmutableMap<K, V> getAllPresent(Iterable<?> iterable) {
            return this.localCache.q(iterable);
        }

        @Override // d5.b
        @CheckForNull
        public V getIfPresent(Object obj) {
            return this.localCache.s(obj);
        }

        @Override // d5.b
        public void invalidate(Object obj) {
            b5.u.E(obj);
            this.localCache.remove(obj);
        }

        @Override // d5.b
        public void invalidateAll(Iterable<?> iterable) {
            this.localCache.w(iterable);
        }

        @Override // d5.b
        public void put(K k10, V v10) {
            this.localCache.put(k10, v10);
        }

        @Override // d5.b
        public void putAll(Map<? extends K, ? extends V> map) {
            this.localCache.putAll(map);
        }

        @Override // d5.b
        public long size() {
            return this.localCache.A();
        }

        @Override // d5.b
        public d5.c stats() {
            a.C0266a c0266a = new a.C0266a();
            c0266a.g(this.localCache.f9202s);
            for (Segment<K, V> segment : this.localCache.f9187d) {
                c0266a.g(segment.statsCounter);
            }
            return c0266a.f();
        }

        public Object writeReplace() {
            return new ManualSerializationProxy(this.localCache);
        }

        public LocalManualCache(CacheBuilder<? super K, ? super V> cacheBuilder) {
            this(new LocalCache(cacheBuilder, null));
        }

        @Override // d5.b
        public void invalidateAll() {
            this.localCache.clear();
        }

        private LocalManualCache(LocalCache<K, V> localCache) {
            this.localCache = localCache;
        }
    }

    public static class ManualSerializationProxy<K, V> extends d5.e<K, V> implements Serializable {
        private static final long serialVersionUID = 1;
        final int concurrencyLevel;

        @CheckForNull
        transient d5.b<K, V> delegate;
        final long expireAfterAccessNanos;
        final long expireAfterWriteNanos;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final CacheLoader<? super K, V> loader;
        final long maxWeight;
        final d5.j<? super K, ? super V> removalListener;

        @CheckForNull
        final b5.b0 ticker;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;
        final d5.n<K, V> weigher;

        public ManualSerializationProxy(LocalCache<K, V> localCache) {
            this(localCache.f9191h, localCache.f9192i, localCache.f9189f, localCache.f9190g, localCache.f9196m, localCache.f9195l, localCache.f9193j, localCache.f9194k, localCache.f9188e, localCache.f9199p, localCache.f9200q, localCache.f9203t);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.delegate = (d5.b<K, V>) recreateCacheBuilder().a();
        }

        private Object readResolve() {
            return this.delegate;
        }

        public CacheBuilder<K, V> recreateCacheBuilder() {
            CacheBuilder<K, V> cacheBuilder = (CacheBuilder<K, V>) CacheBuilder.D().H(this.keyStrength).I(this.valueStrength).z(this.keyEquivalence).L(this.valueEquivalence).e(this.concurrencyLevel).G(this.removalListener);
            cacheBuilder.f9161a = false;
            long j10 = this.expireAfterWriteNanos;
            if (j10 > 0) {
                cacheBuilder.g(j10, TimeUnit.NANOSECONDS);
            }
            long j11 = this.expireAfterAccessNanos;
            if (j11 > 0) {
                cacheBuilder.f(j11, TimeUnit.NANOSECONDS);
            }
            d5.n nVar = this.weigher;
            if (nVar != CacheBuilder.OneWeigher.INSTANCE) {
                cacheBuilder.O(nVar);
                long j12 = this.maxWeight;
                if (j12 != -1) {
                    cacheBuilder.C(j12);
                }
            } else {
                long j13 = this.maxWeight;
                if (j13 != -1) {
                    cacheBuilder.B(j13);
                }
            }
            b5.b0 b0Var = this.ticker;
            if (b0Var != null) {
                cacheBuilder.K(b0Var);
            }
            return cacheBuilder;
        }

        private ManualSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j10, long j11, long j12, d5.n<K, V> nVar, int i10, d5.j<? super K, ? super V> jVar, b5.b0 b0Var, CacheLoader<? super K, V> cacheLoader) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.expireAfterWriteNanos = j10;
            this.expireAfterAccessNanos = j11;
            this.maxWeight = j12;
            this.weigher = nVar;
            this.concurrencyLevel = i10;
            this.removalListener = jVar;
            this.ticker = (b0Var == b5.b0.b() || b0Var == CacheBuilder.f9158x) ? null : b0Var;
            this.loader = cacheLoader;
        }

        @Override // d5.e, e5.l0
        public d5.b<K, V> delegate() {
            return this.delegate;
        }
    }

    public enum NullEntry implements com.google.common.cache.c<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.c
        public long getAccessTime() {
            return 0L;
        }

        @Override // com.google.common.cache.c
        public int getHash() {
            return 0;
        }

        @Override // com.google.common.cache.c
        public Object getKey() {
            return null;
        }

        @Override // com.google.common.cache.c
        public com.google.common.cache.c<Object, Object> getNext() {
            return null;
        }

        @Override // com.google.common.cache.c
        public com.google.common.cache.c<Object, Object> getNextInAccessQueue() {
            return this;
        }

        @Override // com.google.common.cache.c
        public com.google.common.cache.c<Object, Object> getNextInWriteQueue() {
            return this;
        }

        @Override // com.google.common.cache.c
        public com.google.common.cache.c<Object, Object> getPreviousInAccessQueue() {
            return this;
        }

        @Override // com.google.common.cache.c
        public com.google.common.cache.c<Object, Object> getPreviousInWriteQueue() {
            return this;
        }

        @Override // com.google.common.cache.c
        public s<Object, Object> getValueReference() {
            return null;
        }

        @Override // com.google.common.cache.c
        public long getWriteTime() {
            return 0L;
        }

        @Override // com.google.common.cache.c
        public void setAccessTime(long j10) {
        }

        @Override // com.google.common.cache.c
        public void setNextInAccessQueue(com.google.common.cache.c<Object, Object> cVar) {
        }

        @Override // com.google.common.cache.c
        public void setNextInWriteQueue(com.google.common.cache.c<Object, Object> cVar) {
        }

        @Override // com.google.common.cache.c
        public void setPreviousInAccessQueue(com.google.common.cache.c<Object, Object> cVar) {
        }

        @Override // com.google.common.cache.c
        public void setPreviousInWriteQueue(com.google.common.cache.c<Object, Object> cVar) {
        }

        @Override // com.google.common.cache.c
        public void setValueReference(s<Object, Object> sVar) {
        }

        @Override // com.google.common.cache.c
        public void setWriteTime(long j10) {
        }
    }

    public enum Strength {
        STRONG { // from class: com.google.common.cache.LocalCache.Strength.1
            @Override // com.google.common.cache.LocalCache.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            public <K, V> s<K, V> referenceValue(Segment<K, V> segment, com.google.common.cache.c<K, V> cVar, V v10, int i10) {
                return i10 == 1 ? new p(v10) : new a0(v10, i10);
            }
        },
        SOFT { // from class: com.google.common.cache.LocalCache.Strength.2
            @Override // com.google.common.cache.LocalCache.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            public <K, V> s<K, V> referenceValue(Segment<K, V> segment, com.google.common.cache.c<K, V> cVar, V v10, int i10) {
                return i10 == 1 ? new l(segment.valueReferenceQueue, v10, cVar) : new z(segment.valueReferenceQueue, v10, cVar, i10);
            }
        },
        WEAK { // from class: com.google.common.cache.LocalCache.Strength.3
            @Override // com.google.common.cache.LocalCache.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            public <K, V> s<K, V> referenceValue(Segment<K, V> segment, com.google.common.cache.c<K, V> cVar, V v10, int i10) {
                return i10 == 1 ? new x(segment.valueReferenceQueue, v10, cVar) : new b0(segment.valueReferenceQueue, v10, cVar, i10);
            }
        };

        /* renamed from: com.google.common.cache.LocalCache$Strength$1 */
        public enum AnonymousClass1 extends Strength {
            @Override // com.google.common.cache.LocalCache.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            public <K, V> s<K, V> referenceValue(Segment<K, V> segment, com.google.common.cache.c<K, V> cVar, V v10, int i10) {
                return i10 == 1 ? new p(v10) : new a0(v10, i10);
            }
        }

        /* renamed from: com.google.common.cache.LocalCache$Strength$2 */
        public enum AnonymousClass2 extends Strength {
            @Override // com.google.common.cache.LocalCache.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            public <K, V> s<K, V> referenceValue(Segment<K, V> segment, com.google.common.cache.c<K, V> cVar, V v10, int i10) {
                return i10 == 1 ? new l(segment.valueReferenceQueue, v10, cVar) : new z(segment.valueReferenceQueue, v10, cVar, i10);
            }
        }

        /* renamed from: com.google.common.cache.LocalCache$Strength$3 */
        public enum AnonymousClass3 extends Strength {
            @Override // com.google.common.cache.LocalCache.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            public <K, V> s<K, V> referenceValue(Segment<K, V> segment, com.google.common.cache.c<K, V> cVar, V v10, int i10) {
                return i10 == 1 ? new x(segment.valueReferenceQueue, v10, cVar) : new b0(segment.valueReferenceQueue, v10, cVar, i10);
            }
        }

        public abstract Equivalence<Object> defaultEquivalence();

        public abstract <K, V> s<K, V> referenceValue(Segment<K, V> segment, com.google.common.cache.c<K, V> cVar, V v10, int i10);

        /* synthetic */ Strength(a aVar) {
            this();
        }
    }

    public class a implements s<Object, Object> {
        @Override // com.google.common.cache.LocalCache.s
        public com.google.common.cache.c<Object, Object> a() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.s
        public void b(Object obj) {
        }

        @Override // com.google.common.cache.LocalCache.s
        public int c() {
            return 0;
        }

        @Override // com.google.common.cache.LocalCache.s
        public s<Object, Object> d(ReferenceQueue<Object> referenceQueue, @CheckForNull Object obj, com.google.common.cache.c<Object, Object> cVar) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.s
        public Object e() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.s
        public Object get() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isActive() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isLoading() {
            return false;
        }
    }

    public static final class a0<K, V> extends p<K, V> {

        /* renamed from: c */
        public final int f9213c;

        public a0(V v10, int i10) {
            super(v10);
            this.f9213c = i10;
        }

        @Override // com.google.common.cache.LocalCache.p, com.google.common.cache.LocalCache.s
        public int c() {
            return this.f9213c;
        }
    }

    public class b extends AbstractQueue<Object> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Object> iterator() {
            return ImmutableSet.of().iterator();
        }

        @Override // java.util.Queue
        public boolean offer(Object obj) {
            return true;
        }

        @Override // java.util.Queue
        public Object peek() {
            return null;
        }

        @Override // java.util.Queue
        public Object poll() {
            return null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return 0;
        }
    }

    public static final class b0<K, V> extends x<K, V> {

        /* renamed from: c */
        public final int f9214c;

        public b0(ReferenceQueue<V> referenceQueue, V v10, com.google.common.cache.c<K, V> cVar, int i10) {
            super(referenceQueue, v10, cVar);
            this.f9214c = i10;
        }

        @Override // com.google.common.cache.LocalCache.x, com.google.common.cache.LocalCache.s
        public int c() {
            return this.f9214c;
        }

        @Override // com.google.common.cache.LocalCache.x, com.google.common.cache.LocalCache.s
        public s<K, V> d(ReferenceQueue<V> referenceQueue, V v10, com.google.common.cache.c<K, V> cVar) {
            return new b0(referenceQueue, v10, cVar, this.f9214c);
        }
    }

    public abstract class c<T> extends AbstractSet<T> {
        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LocalCache.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return LocalCache.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LocalCache.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return LocalCache.R(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <E> E[] toArray(E[] eArr) {
            return (E[]) LocalCache.R(this).toArray(eArr);
        }
    }

    public static final class c0<K, V> extends AbstractQueue<com.google.common.cache.c<K, V>> {

        /* renamed from: b */
        public final com.google.common.cache.c<K, V> f9216b = new a(this);

        public class a extends d<K, V> {

            /* renamed from: b */
            @Weak
            public com.google.common.cache.c<K, V> f9217b = this;

            /* renamed from: c */
            @Weak
            public com.google.common.cache.c<K, V> f9218c = this;

            public a(c0 c0Var) {
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
            public com.google.common.cache.c<K, V> getNextInWriteQueue() {
                return this.f9217b;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
            public com.google.common.cache.c<K, V> getPreviousInWriteQueue() {
                return this.f9218c;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
            public long getWriteTime() {
                return Long.MAX_VALUE;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
            public void setNextInWriteQueue(com.google.common.cache.c<K, V> cVar) {
                this.f9217b = cVar;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
            public void setPreviousInWriteQueue(com.google.common.cache.c<K, V> cVar) {
                this.f9218c = cVar;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
            public void setWriteTime(long j10) {
            }
        }

        public class b extends e5.d<com.google.common.cache.c<K, V>> {
            public b(com.google.common.cache.c cVar) {
                super(cVar);
            }

            @Override // e5.d
            /* renamed from: b */
            public com.google.common.cache.c<K, V> a(com.google.common.cache.c<K, V> cVar) {
                com.google.common.cache.c<K, V> nextInWriteQueue = cVar.getNextInWriteQueue();
                if (nextInWriteQueue == c0.this.f9216b) {
                    return null;
                }
                return nextInWriteQueue;
            }
        }

        @Override // java.util.Queue
        /* renamed from: a */
        public boolean offer(com.google.common.cache.c<K, V> cVar) {
            LocalCache.f(cVar.getPreviousInWriteQueue(), cVar.getNextInWriteQueue());
            LocalCache.f(this.f9216b.getPreviousInWriteQueue(), cVar);
            LocalCache.f(cVar, this.f9216b);
            return true;
        }

        @Override // java.util.Queue
        /* renamed from: b */
        public com.google.common.cache.c<K, V> peek() {
            com.google.common.cache.c<K, V> nextInWriteQueue = this.f9216b.getNextInWriteQueue();
            if (nextInWriteQueue == this.f9216b) {
                return null;
            }
            return nextInWriteQueue;
        }

        @Override // java.util.Queue
        /* renamed from: c */
        public com.google.common.cache.c<K, V> poll() {
            com.google.common.cache.c<K, V> nextInWriteQueue = this.f9216b.getNextInWriteQueue();
            if (nextInWriteQueue == this.f9216b) {
                return null;
            }
            remove(nextInWriteQueue);
            return nextInWriteQueue;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            com.google.common.cache.c<K, V> nextInWriteQueue = this.f9216b.getNextInWriteQueue();
            while (true) {
                com.google.common.cache.c<K, V> cVar = this.f9216b;
                if (nextInWriteQueue == cVar) {
                    cVar.setNextInWriteQueue(cVar);
                    com.google.common.cache.c<K, V> cVar2 = this.f9216b;
                    cVar2.setPreviousInWriteQueue(cVar2);
                    return;
                } else {
                    com.google.common.cache.c<K, V> nextInWriteQueue2 = nextInWriteQueue.getNextInWriteQueue();
                    LocalCache.G(nextInWriteQueue);
                    nextInWriteQueue = nextInWriteQueue2;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((com.google.common.cache.c) obj).getNextInWriteQueue() != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f9216b.getNextInWriteQueue() == this.f9216b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<com.google.common.cache.c<K, V>> iterator() {
            return new b(peek());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            com.google.common.cache.c cVar = (com.google.common.cache.c) obj;
            com.google.common.cache.c<K, V> previousInWriteQueue = cVar.getPreviousInWriteQueue();
            com.google.common.cache.c<K, V> nextInWriteQueue = cVar.getNextInWriteQueue();
            LocalCache.f(previousInWriteQueue, nextInWriteQueue);
            LocalCache.G(cVar);
            return nextInWriteQueue != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i10 = 0;
            for (com.google.common.cache.c<K, V> nextInWriteQueue = this.f9216b.getNextInWriteQueue(); nextInWriteQueue != this.f9216b; nextInWriteQueue = nextInWriteQueue.getNextInWriteQueue()) {
                i10++;
            }
            return i10;
        }
    }

    public static abstract class d<K, V> implements com.google.common.cache.c<K, V> {
        @Override // com.google.common.cache.c
        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.c
        public int getHash() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.c
        public K getKey() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.c
        public com.google.common.cache.c<K, V> getNext() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.c
        public com.google.common.cache.c<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.c
        public com.google.common.cache.c<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.c
        public com.google.common.cache.c<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.c
        public com.google.common.cache.c<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.c
        public s<K, V> getValueReference() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.c
        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.c
        public void setAccessTime(long j10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.c
        public void setNextInAccessQueue(com.google.common.cache.c<K, V> cVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.c
        public void setNextInWriteQueue(com.google.common.cache.c<K, V> cVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.c
        public void setPreviousInAccessQueue(com.google.common.cache.c<K, V> cVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.c
        public void setPreviousInWriteQueue(com.google.common.cache.c<K, V> cVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.c
        public void setValueReference(s<K, V> sVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.c
        public void setWriteTime(long j10) {
            throw new UnsupportedOperationException();
        }
    }

    public final class d0 implements Map.Entry<K, V> {

        /* renamed from: b */
        public final K f9220b;

        /* renamed from: c */
        public V f9221c;

        public d0(K k10, V v10) {
            this.f9220b = k10;
            this.f9221c = v10;
        }

        @Override // java.util.Map.Entry
        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f9220b.equals(entry.getKey()) && this.f9221c.equals(entry.getValue());
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f9220b;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f9221c;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f9220b.hashCode() ^ this.f9221c.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            V v11 = (V) LocalCache.this.put(this.f9220b, v10);
            this.f9221c = v10;
            return v11;
        }

        public String toString() {
            String valueOf = String.valueOf(getKey());
            String valueOf2 = String.valueOf(getValue());
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 1 + valueOf2.length());
            sb2.append(valueOf);
            sb2.append("=");
            sb2.append(valueOf2);
            return sb2.toString();
        }
    }

    public static final class e<K, V> extends AbstractQueue<com.google.common.cache.c<K, V>> {

        /* renamed from: b */
        public final com.google.common.cache.c<K, V> f9223b = new a(this);

        public class a extends d<K, V> {

            /* renamed from: b */
            @Weak
            public com.google.common.cache.c<K, V> f9224b = this;

            /* renamed from: c */
            @Weak
            public com.google.common.cache.c<K, V> f9225c = this;

            public a(e eVar) {
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
            public long getAccessTime() {
                return Long.MAX_VALUE;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
            public com.google.common.cache.c<K, V> getNextInAccessQueue() {
                return this.f9224b;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
            public com.google.common.cache.c<K, V> getPreviousInAccessQueue() {
                return this.f9225c;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
            public void setAccessTime(long j10) {
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
            public void setNextInAccessQueue(com.google.common.cache.c<K, V> cVar) {
                this.f9224b = cVar;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
            public void setPreviousInAccessQueue(com.google.common.cache.c<K, V> cVar) {
                this.f9225c = cVar;
            }
        }

        public class b extends e5.d<com.google.common.cache.c<K, V>> {
            public b(com.google.common.cache.c cVar) {
                super(cVar);
            }

            @Override // e5.d
            /* renamed from: b */
            public com.google.common.cache.c<K, V> a(com.google.common.cache.c<K, V> cVar) {
                com.google.common.cache.c<K, V> nextInAccessQueue = cVar.getNextInAccessQueue();
                if (nextInAccessQueue == e.this.f9223b) {
                    return null;
                }
                return nextInAccessQueue;
            }
        }

        @Override // java.util.Queue
        /* renamed from: a */
        public boolean offer(com.google.common.cache.c<K, V> cVar) {
            LocalCache.e(cVar.getPreviousInAccessQueue(), cVar.getNextInAccessQueue());
            LocalCache.e(this.f9223b.getPreviousInAccessQueue(), cVar);
            LocalCache.e(cVar, this.f9223b);
            return true;
        }

        @Override // java.util.Queue
        /* renamed from: b */
        public com.google.common.cache.c<K, V> peek() {
            com.google.common.cache.c<K, V> nextInAccessQueue = this.f9223b.getNextInAccessQueue();
            if (nextInAccessQueue == this.f9223b) {
                return null;
            }
            return nextInAccessQueue;
        }

        @Override // java.util.Queue
        /* renamed from: c */
        public com.google.common.cache.c<K, V> poll() {
            com.google.common.cache.c<K, V> nextInAccessQueue = this.f9223b.getNextInAccessQueue();
            if (nextInAccessQueue == this.f9223b) {
                return null;
            }
            remove(nextInAccessQueue);
            return nextInAccessQueue;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            com.google.common.cache.c<K, V> nextInAccessQueue = this.f9223b.getNextInAccessQueue();
            while (true) {
                com.google.common.cache.c<K, V> cVar = this.f9223b;
                if (nextInAccessQueue == cVar) {
                    cVar.setNextInAccessQueue(cVar);
                    com.google.common.cache.c<K, V> cVar2 = this.f9223b;
                    cVar2.setPreviousInAccessQueue(cVar2);
                    return;
                } else {
                    com.google.common.cache.c<K, V> nextInAccessQueue2 = nextInAccessQueue.getNextInAccessQueue();
                    LocalCache.F(nextInAccessQueue);
                    nextInAccessQueue = nextInAccessQueue2;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((com.google.common.cache.c) obj).getNextInAccessQueue() != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f9223b.getNextInAccessQueue() == this.f9223b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<com.google.common.cache.c<K, V>> iterator() {
            return new b(peek());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            com.google.common.cache.c cVar = (com.google.common.cache.c) obj;
            com.google.common.cache.c<K, V> previousInAccessQueue = cVar.getPreviousInAccessQueue();
            com.google.common.cache.c<K, V> nextInAccessQueue = cVar.getNextInAccessQueue();
            LocalCache.e(previousInAccessQueue, nextInAccessQueue);
            LocalCache.F(cVar);
            return nextInAccessQueue != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i10 = 0;
            for (com.google.common.cache.c<K, V> nextInAccessQueue = this.f9223b.getNextInAccessQueue(); nextInAccessQueue != this.f9223b; nextInAccessQueue = nextInAccessQueue.getNextInAccessQueue()) {
                i10++;
            }
            return i10;
        }
    }

    public final class f extends LocalCache<K, V>.h<Map.Entry<K, V>> {
        public f(LocalCache localCache) {
            super();
        }

        @Override // com.google.common.cache.LocalCache.h, java.util.Iterator
        /* renamed from: f */
        public Map.Entry<K, V> next() {
            return c();
        }
    }

    public final class g extends LocalCache<K, V>.c<Map.Entry<K, V>> {
        public g() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = LocalCache.this.get(key)) != null && LocalCache.this.f9190g.equivalent(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new f(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && LocalCache.this.remove(key, entry.getValue());
        }
    }

    public abstract class h<T> implements Iterator<T> {

        /* renamed from: b */
        public int f9228b;

        /* renamed from: c */
        public int f9229c = -1;

        /* renamed from: d */
        @CheckForNull
        public Segment<K, V> f9230d;

        /* renamed from: e */
        @CheckForNull
        public AtomicReferenceArray<com.google.common.cache.c<K, V>> f9231e;

        /* renamed from: f */
        @CheckForNull
        public com.google.common.cache.c<K, V> f9232f;

        /* renamed from: g */
        @CheckForNull
        public LocalCache<K, V>.d0 f9233g;

        /* renamed from: h */
        @CheckForNull
        public LocalCache<K, V>.d0 f9234h;

        public h() {
            this.f9228b = LocalCache.this.f9187d.length - 1;
            a();
        }

        public final void a() {
            this.f9233g = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i10 = this.f9228b;
                if (i10 < 0) {
                    return;
                }
                Segment<K, V>[] segmentArr = LocalCache.this.f9187d;
                this.f9228b = i10 - 1;
                Segment<K, V> segment = segmentArr[i10];
                this.f9230d = segment;
                if (segment.count != 0) {
                    this.f9231e = this.f9230d.table;
                    this.f9229c = r0.length() - 1;
                    if (e()) {
                        return;
                    }
                }
            }
        }

        public boolean b(com.google.common.cache.c<K, V> cVar) {
            try {
                long a10 = LocalCache.this.f9200q.a();
                K key = cVar.getKey();
                Object t10 = LocalCache.this.t(cVar, a10);
                if (t10 == null) {
                    this.f9230d.postReadCleanup();
                    return false;
                }
                this.f9233g = new d0(key, t10);
                this.f9230d.postReadCleanup();
                return true;
            } catch (Throwable th2) {
                this.f9230d.postReadCleanup();
                throw th2;
            }
        }

        public LocalCache<K, V>.d0 c() {
            LocalCache<K, V>.d0 d0Var = this.f9233g;
            if (d0Var == null) {
                throw new NoSuchElementException();
            }
            this.f9234h = d0Var;
            a();
            return this.f9234h;
        }

        public boolean d() {
            com.google.common.cache.c<K, V> cVar = this.f9232f;
            if (cVar == null) {
                return false;
            }
            while (true) {
                this.f9232f = cVar.getNext();
                com.google.common.cache.c<K, V> cVar2 = this.f9232f;
                if (cVar2 == null) {
                    return false;
                }
                if (b(cVar2)) {
                    return true;
                }
                cVar = this.f9232f;
            }
        }

        public boolean e() {
            while (true) {
                int i10 = this.f9229c;
                if (i10 < 0) {
                    return false;
                }
                AtomicReferenceArray<com.google.common.cache.c<K, V>> atomicReferenceArray = this.f9231e;
                this.f9229c = i10 - 1;
                com.google.common.cache.c<K, V> cVar = atomicReferenceArray.get(i10);
                this.f9232f = cVar;
                if (cVar != null && (b(cVar) || d())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9233g != null;
        }

        @Override // java.util.Iterator
        public abstract T next();

        @Override // java.util.Iterator
        public void remove() {
            b5.u.g0(this.f9234h != null);
            LocalCache.this.remove(this.f9234h.getKey());
            this.f9234h = null;
        }
    }

    public final class i extends LocalCache<K, V>.h<K> {
        public i(LocalCache localCache) {
            super();
        }

        @Override // com.google.common.cache.LocalCache.h, java.util.Iterator
        public K next() {
            return c().getKey();
        }
    }

    public final class j extends LocalCache<K, V>.c<K> {
        public j() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LocalCache.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new i(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LocalCache.this.remove(obj) != null;
        }
    }

    public static class k<K, V> implements s<K, V> {

        /* renamed from: b */
        public volatile s<K, V> f9237b;

        /* renamed from: c */
        public final com.google.common.util.concurrent.s<V> f9238c;

        /* renamed from: d */
        public final b5.x f9239d;

        public class a implements b5.n<V, V> {
            public a() {
            }

            @Override // b5.n
            public V apply(V v10) {
                k.this.j(v10);
                return v10;
            }
        }

        public k() {
            this(LocalCache.S());
        }

        @Override // com.google.common.cache.LocalCache.s
        public com.google.common.cache.c<K, V> a() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.s
        public void b(@CheckForNull V v10) {
            if (v10 != null) {
                j(v10);
            } else {
                this.f9237b = LocalCache.S();
            }
        }

        @Override // com.google.common.cache.LocalCache.s
        public int c() {
            return this.f9237b.c();
        }

        @Override // com.google.common.cache.LocalCache.s
        public s<K, V> d(ReferenceQueue<V> referenceQueue, @CheckForNull V v10, com.google.common.cache.c<K, V> cVar) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.s
        public V e() throws ExecutionException {
            return (V) b1.f(this.f9238c);
        }

        public long f() {
            return this.f9239d.g(TimeUnit.NANOSECONDS);
        }

        public final p5.c0<V> g(Throwable th2) {
            return com.google.common.util.concurrent.l.l(th2);
        }

        @Override // com.google.common.cache.LocalCache.s
        public V get() {
            return this.f9237b.get();
        }

        public s<K, V> h() {
            return this.f9237b;
        }

        public p5.c0<V> i(K k10, CacheLoader<? super K, V> cacheLoader) {
            try {
                this.f9239d.k();
                V v10 = this.f9237b.get();
                if (v10 == null) {
                    V load = cacheLoader.load(k10);
                    return j(load) ? this.f9238c : com.google.common.util.concurrent.l.m(load);
                }
                p5.c0<V> reload = cacheLoader.reload(k10, v10);
                return reload == null ? com.google.common.util.concurrent.l.m(null) : com.google.common.util.concurrent.l.x(reload, new a(), com.google.common.util.concurrent.p.c());
            } catch (Throwable th2) {
                p5.c0<V> g10 = k(th2) ? this.f9238c : g(th2);
                if (th2 instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                return g10;
            }
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isActive() {
            return this.f9237b.isActive();
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isLoading() {
            return true;
        }

        public boolean j(@CheckForNull V v10) {
            return this.f9238c.set(v10);
        }

        public boolean k(Throwable th2) {
            return this.f9238c.setException(th2);
        }

        public k(s<K, V> sVar) {
            this.f9238c = com.google.common.util.concurrent.s.n();
            this.f9239d = b5.x.e();
            this.f9237b = sVar;
        }
    }

    public static class l<K, V> extends SoftReference<V> implements s<K, V> {

        /* renamed from: b */
        public final com.google.common.cache.c<K, V> f9241b;

        public l(ReferenceQueue<V> referenceQueue, V v10, com.google.common.cache.c<K, V> cVar) {
            super(v10, referenceQueue);
            this.f9241b = cVar;
        }

        @Override // com.google.common.cache.LocalCache.s
        public com.google.common.cache.c<K, V> a() {
            return this.f9241b;
        }

        @Override // com.google.common.cache.LocalCache.s
        public void b(V v10) {
        }

        @Override // com.google.common.cache.LocalCache.s
        public int c() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.s
        public s<K, V> d(ReferenceQueue<V> referenceQueue, V v10, com.google.common.cache.c<K, V> cVar) {
            return new l(referenceQueue, v10, cVar);
        }

        @Override // com.google.common.cache.LocalCache.s
        public V e() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isLoading() {
            return false;
        }
    }

    public static final class m<K, V> extends o<K, V> {

        /* renamed from: f */
        public volatile long f9242f;

        /* renamed from: g */
        @Weak
        public com.google.common.cache.c<K, V> f9243g;

        /* renamed from: h */
        @Weak
        public com.google.common.cache.c<K, V> f9244h;

        public m(K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
            super(k10, i10, cVar);
            this.f9242f = Long.MAX_VALUE;
            this.f9243g = LocalCache.E();
            this.f9244h = LocalCache.E();
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
        public long getAccessTime() {
            return this.f9242f;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
        public com.google.common.cache.c<K, V> getNextInAccessQueue() {
            return this.f9243g;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
        public com.google.common.cache.c<K, V> getPreviousInAccessQueue() {
            return this.f9244h;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
        public void setAccessTime(long j10) {
            this.f9242f = j10;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
        public void setNextInAccessQueue(com.google.common.cache.c<K, V> cVar) {
            this.f9243g = cVar;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
        public void setPreviousInAccessQueue(com.google.common.cache.c<K, V> cVar) {
            this.f9244h = cVar;
        }
    }

    public static final class n<K, V> extends o<K, V> {

        /* renamed from: f */
        public volatile long f9245f;

        /* renamed from: g */
        @Weak
        public com.google.common.cache.c<K, V> f9246g;

        /* renamed from: h */
        @Weak
        public com.google.common.cache.c<K, V> f9247h;

        /* renamed from: i */
        public volatile long f9248i;

        /* renamed from: j */
        @Weak
        public com.google.common.cache.c<K, V> f9249j;

        /* renamed from: k */
        @Weak
        public com.google.common.cache.c<K, V> f9250k;

        public n(K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
            super(k10, i10, cVar);
            this.f9245f = Long.MAX_VALUE;
            this.f9246g = LocalCache.E();
            this.f9247h = LocalCache.E();
            this.f9248i = Long.MAX_VALUE;
            this.f9249j = LocalCache.E();
            this.f9250k = LocalCache.E();
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
        public long getAccessTime() {
            return this.f9245f;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
        public com.google.common.cache.c<K, V> getNextInAccessQueue() {
            return this.f9246g;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
        public com.google.common.cache.c<K, V> getNextInWriteQueue() {
            return this.f9249j;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
        public com.google.common.cache.c<K, V> getPreviousInAccessQueue() {
            return this.f9247h;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
        public com.google.common.cache.c<K, V> getPreviousInWriteQueue() {
            return this.f9250k;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
        public long getWriteTime() {
            return this.f9248i;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
        public void setAccessTime(long j10) {
            this.f9245f = j10;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
        public void setNextInAccessQueue(com.google.common.cache.c<K, V> cVar) {
            this.f9246g = cVar;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
        public void setNextInWriteQueue(com.google.common.cache.c<K, V> cVar) {
            this.f9249j = cVar;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
        public void setPreviousInAccessQueue(com.google.common.cache.c<K, V> cVar) {
            this.f9247h = cVar;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
        public void setPreviousInWriteQueue(com.google.common.cache.c<K, V> cVar) {
            this.f9250k = cVar;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
        public void setWriteTime(long j10) {
            this.f9248i = j10;
        }
    }

    public static class o<K, V> extends d<K, V> {

        /* renamed from: b */
        public final K f9251b;

        /* renamed from: c */
        public final int f9252c;

        /* renamed from: d */
        @CheckForNull
        public final com.google.common.cache.c<K, V> f9253d;

        /* renamed from: e */
        public volatile s<K, V> f9254e = LocalCache.S();

        public o(K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
            this.f9251b = k10;
            this.f9252c = i10;
            this.f9253d = cVar;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
        public int getHash() {
            return this.f9252c;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
        public K getKey() {
            return this.f9251b;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
        public com.google.common.cache.c<K, V> getNext() {
            return this.f9253d;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
        public s<K, V> getValueReference() {
            return this.f9254e;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
        public void setValueReference(s<K, V> sVar) {
            this.f9254e = sVar;
        }
    }

    public static class p<K, V> implements s<K, V> {

        /* renamed from: b */
        public final V f9255b;

        public p(V v10) {
            this.f9255b = v10;
        }

        @Override // com.google.common.cache.LocalCache.s
        public com.google.common.cache.c<K, V> a() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.s
        public void b(V v10) {
        }

        @Override // com.google.common.cache.LocalCache.s
        public int c() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.s
        public s<K, V> d(ReferenceQueue<V> referenceQueue, V v10, com.google.common.cache.c<K, V> cVar) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.s
        public V e() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.s
        public V get() {
            return this.f9255b;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isLoading() {
            return false;
        }
    }

    public static final class q<K, V> extends o<K, V> {

        /* renamed from: f */
        public volatile long f9256f;

        /* renamed from: g */
        @Weak
        public com.google.common.cache.c<K, V> f9257g;

        /* renamed from: h */
        @Weak
        public com.google.common.cache.c<K, V> f9258h;

        public q(K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
            super(k10, i10, cVar);
            this.f9256f = Long.MAX_VALUE;
            this.f9257g = LocalCache.E();
            this.f9258h = LocalCache.E();
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
        public com.google.common.cache.c<K, V> getNextInWriteQueue() {
            return this.f9257g;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
        public com.google.common.cache.c<K, V> getPreviousInWriteQueue() {
            return this.f9258h;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
        public long getWriteTime() {
            return this.f9256f;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
        public void setNextInWriteQueue(com.google.common.cache.c<K, V> cVar) {
            this.f9257g = cVar;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
        public void setPreviousInWriteQueue(com.google.common.cache.c<K, V> cVar) {
            this.f9258h = cVar;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.c
        public void setWriteTime(long j10) {
            this.f9256f = j10;
        }
    }

    public final class r extends LocalCache<K, V>.h<V> {
        public r(LocalCache localCache) {
            super();
        }

        @Override // com.google.common.cache.LocalCache.h, java.util.Iterator
        public V next() {
            return c().getValue();
        }
    }

    public interface s<K, V> {
        @CheckForNull
        com.google.common.cache.c<K, V> a();

        void b(@CheckForNull V v10);

        int c();

        s<K, V> d(ReferenceQueue<V> referenceQueue, @CheckForNull V v10, com.google.common.cache.c<K, V> cVar);

        V e() throws ExecutionException;

        @CheckForNull
        V get();

        boolean isActive();

        boolean isLoading();
    }

    public final class t extends AbstractCollection<V> {
        public t() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            LocalCache.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return LocalCache.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return LocalCache.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new r(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return LocalCache.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return LocalCache.R(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <E> E[] toArray(E[] eArr) {
            return (E[]) LocalCache.R(this).toArray(eArr);
        }
    }

    public static final class u<K, V> extends w<K, V> {

        /* renamed from: e */
        public volatile long f9260e;

        /* renamed from: f */
        @Weak
        public com.google.common.cache.c<K, V> f9261f;

        /* renamed from: g */
        @Weak
        public com.google.common.cache.c<K, V> f9262g;

        public u(ReferenceQueue<K> referenceQueue, K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
            super(referenceQueue, k10, i10, cVar);
            this.f9260e = Long.MAX_VALUE;
            this.f9261f = LocalCache.E();
            this.f9262g = LocalCache.E();
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.c
        public long getAccessTime() {
            return this.f9260e;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.c
        public com.google.common.cache.c<K, V> getNextInAccessQueue() {
            return this.f9261f;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.c
        public com.google.common.cache.c<K, V> getPreviousInAccessQueue() {
            return this.f9262g;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.c
        public void setAccessTime(long j10) {
            this.f9260e = j10;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.c
        public void setNextInAccessQueue(com.google.common.cache.c<K, V> cVar) {
            this.f9261f = cVar;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.c
        public void setPreviousInAccessQueue(com.google.common.cache.c<K, V> cVar) {
            this.f9262g = cVar;
        }
    }

    public static final class v<K, V> extends w<K, V> {

        /* renamed from: e */
        public volatile long f9263e;

        /* renamed from: f */
        @Weak
        public com.google.common.cache.c<K, V> f9264f;

        /* renamed from: g */
        @Weak
        public com.google.common.cache.c<K, V> f9265g;

        /* renamed from: h */
        public volatile long f9266h;

        /* renamed from: i */
        @Weak
        public com.google.common.cache.c<K, V> f9267i;

        /* renamed from: j */
        @Weak
        public com.google.common.cache.c<K, V> f9268j;

        public v(ReferenceQueue<K> referenceQueue, K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
            super(referenceQueue, k10, i10, cVar);
            this.f9263e = Long.MAX_VALUE;
            this.f9264f = LocalCache.E();
            this.f9265g = LocalCache.E();
            this.f9266h = Long.MAX_VALUE;
            this.f9267i = LocalCache.E();
            this.f9268j = LocalCache.E();
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.c
        public long getAccessTime() {
            return this.f9263e;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.c
        public com.google.common.cache.c<K, V> getNextInAccessQueue() {
            return this.f9264f;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.c
        public com.google.common.cache.c<K, V> getNextInWriteQueue() {
            return this.f9267i;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.c
        public com.google.common.cache.c<K, V> getPreviousInAccessQueue() {
            return this.f9265g;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.c
        public com.google.common.cache.c<K, V> getPreviousInWriteQueue() {
            return this.f9268j;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.c
        public long getWriteTime() {
            return this.f9266h;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.c
        public void setAccessTime(long j10) {
            this.f9263e = j10;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.c
        public void setNextInAccessQueue(com.google.common.cache.c<K, V> cVar) {
            this.f9264f = cVar;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.c
        public void setNextInWriteQueue(com.google.common.cache.c<K, V> cVar) {
            this.f9267i = cVar;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.c
        public void setPreviousInAccessQueue(com.google.common.cache.c<K, V> cVar) {
            this.f9265g = cVar;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.c
        public void setPreviousInWriteQueue(com.google.common.cache.c<K, V> cVar) {
            this.f9268j = cVar;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.c
        public void setWriteTime(long j10) {
            this.f9266h = j10;
        }
    }

    public static class w<K, V> extends WeakReference<K> implements com.google.common.cache.c<K, V> {

        /* renamed from: b */
        public final int f9269b;

        /* renamed from: c */
        @CheckForNull
        public final com.google.common.cache.c<K, V> f9270c;

        /* renamed from: d */
        public volatile s<K, V> f9271d;

        public w(ReferenceQueue<K> referenceQueue, K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
            super(k10, referenceQueue);
            this.f9271d = LocalCache.S();
            this.f9269b = i10;
            this.f9270c = cVar;
        }

        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.c
        public int getHash() {
            return this.f9269b;
        }

        @Override // com.google.common.cache.c
        public K getKey() {
            return get();
        }

        @Override // com.google.common.cache.c
        public com.google.common.cache.c<K, V> getNext() {
            return this.f9270c;
        }

        public com.google.common.cache.c<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public com.google.common.cache.c<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public com.google.common.cache.c<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public com.google.common.cache.c<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.c
        public s<K, V> getValueReference() {
            return this.f9271d;
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        public void setAccessTime(long j10) {
            throw new UnsupportedOperationException();
        }

        public void setNextInAccessQueue(com.google.common.cache.c<K, V> cVar) {
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(com.google.common.cache.c<K, V> cVar) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(com.google.common.cache.c<K, V> cVar) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(com.google.common.cache.c<K, V> cVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.c
        public void setValueReference(s<K, V> sVar) {
            this.f9271d = sVar;
        }

        public void setWriteTime(long j10) {
            throw new UnsupportedOperationException();
        }
    }

    public static class x<K, V> extends WeakReference<V> implements s<K, V> {

        /* renamed from: b */
        public final com.google.common.cache.c<K, V> f9272b;

        public x(ReferenceQueue<V> referenceQueue, V v10, com.google.common.cache.c<K, V> cVar) {
            super(v10, referenceQueue);
            this.f9272b = cVar;
        }

        @Override // com.google.common.cache.LocalCache.s
        public com.google.common.cache.c<K, V> a() {
            return this.f9272b;
        }

        @Override // com.google.common.cache.LocalCache.s
        public void b(V v10) {
        }

        public int c() {
            return 1;
        }

        public s<K, V> d(ReferenceQueue<V> referenceQueue, V v10, com.google.common.cache.c<K, V> cVar) {
            return new x(referenceQueue, v10, cVar);
        }

        @Override // com.google.common.cache.LocalCache.s
        public V e() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isLoading() {
            return false;
        }
    }

    public static final class y<K, V> extends w<K, V> {

        /* renamed from: e */
        public volatile long f9273e;

        /* renamed from: f */
        @Weak
        public com.google.common.cache.c<K, V> f9274f;

        /* renamed from: g */
        @Weak
        public com.google.common.cache.c<K, V> f9275g;

        public y(ReferenceQueue<K> referenceQueue, K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
            super(referenceQueue, k10, i10, cVar);
            this.f9273e = Long.MAX_VALUE;
            this.f9274f = LocalCache.E();
            this.f9275g = LocalCache.E();
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.c
        public com.google.common.cache.c<K, V> getNextInWriteQueue() {
            return this.f9274f;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.c
        public com.google.common.cache.c<K, V> getPreviousInWriteQueue() {
            return this.f9275g;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.c
        public long getWriteTime() {
            return this.f9273e;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.c
        public void setNextInWriteQueue(com.google.common.cache.c<K, V> cVar) {
            this.f9274f = cVar;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.c
        public void setPreviousInWriteQueue(com.google.common.cache.c<K, V> cVar) {
            this.f9275g = cVar;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.c
        public void setWriteTime(long j10) {
            this.f9273e = j10;
        }
    }

    public static final class z<K, V> extends l<K, V> {

        /* renamed from: c */
        public final int f9276c;

        public z(ReferenceQueue<V> referenceQueue, V v10, com.google.common.cache.c<K, V> cVar, int i10) {
            super(referenceQueue, v10, cVar);
            this.f9276c = i10;
        }

        @Override // com.google.common.cache.LocalCache.l, com.google.common.cache.LocalCache.s
        public int c() {
            return this.f9276c;
        }

        @Override // com.google.common.cache.LocalCache.l, com.google.common.cache.LocalCache.s
        public s<K, V> d(ReferenceQueue<V> referenceQueue, V v10, com.google.common.cache.c<K, V> cVar) {
            return new z(referenceQueue, v10, cVar, this.f9276c);
        }
    }

    public LocalCache(CacheBuilder<? super K, ? super V> cacheBuilder, @CheckForNull CacheLoader<? super K, V> cacheLoader) {
        this.f9188e = Math.min(cacheBuilder.j(), 65536);
        Strength o10 = cacheBuilder.o();
        this.f9191h = o10;
        this.f9192i = cacheBuilder.v();
        this.f9189f = cacheBuilder.n();
        this.f9190g = cacheBuilder.u();
        long p10 = cacheBuilder.p();
        this.f9193j = p10;
        this.f9194k = (d5.n<K, V>) cacheBuilder.w();
        this.f9195l = cacheBuilder.k();
        this.f9196m = cacheBuilder.l();
        this.f9197n = cacheBuilder.q();
        CacheBuilder.NullListener nullListener = (d5.j<K, V>) cacheBuilder.r();
        this.f9199p = nullListener;
        this.f9198o = nullListener == CacheBuilder.NullListener.INSTANCE ? j() : new ConcurrentLinkedQueue<>();
        this.f9200q = cacheBuilder.t(L());
        this.f9201r = EntryFactory.getFactory(o10, T(), X());
        this.f9202s = cacheBuilder.s().get();
        this.f9203t = cacheLoader;
        int min = Math.min(cacheBuilder.m(), 1073741824);
        if (k() && !i()) {
            min = (int) Math.min(min, p10);
        }
        int i10 = 0;
        int i11 = 1;
        int i12 = 1;
        int i13 = 0;
        while (i12 < this.f9188e && (!k() || i12 * 20 <= this.f9193j)) {
            i13++;
            i12 <<= 1;
        }
        this.f9186c = 32 - i13;
        this.f9185b = i12 - 1;
        this.f9187d = C(i12);
        int i14 = min / i12;
        while (i11 < (i14 * i12 < min ? i14 + 1 : i14)) {
            i11 <<= 1;
        }
        if (k()) {
            long j10 = this.f9193j;
            long j11 = i12;
            long j12 = (j10 / j11) + 1;
            long j13 = j10 % j11;
            while (true) {
                Segment<K, V>[] segmentArr = this.f9187d;
                if (i10 >= segmentArr.length) {
                    return;
                }
                if (i10 == j13) {
                    j12--;
                }
                segmentArr[i10] = h(i11, j12, cacheBuilder.s().get());
                i10++;
            }
        } else {
            while (true) {
                Segment<K, V>[] segmentArr2 = this.f9187d;
                if (i10 >= segmentArr2.length) {
                    return;
                }
                segmentArr2[i10] = h(i11, -1L, cacheBuilder.s().get());
                i10++;
            }
        }
    }

    public static <K, V> com.google.common.cache.c<K, V> E() {
        return NullEntry.INSTANCE;
    }

    public static <K, V> void F(com.google.common.cache.c<K, V> cVar) {
        com.google.common.cache.c<K, V> E2 = E();
        cVar.setNextInAccessQueue(E2);
        cVar.setPreviousInAccessQueue(E2);
    }

    public static <K, V> void G(com.google.common.cache.c<K, V> cVar) {
        com.google.common.cache.c<K, V> E2 = E();
        cVar.setNextInWriteQueue(E2);
        cVar.setPreviousInWriteQueue(E2);
    }

    public static int P(int i10) {
        int i11 = i10 + ((i10 << 15) ^ (-12931));
        int i12 = i11 ^ (i11 >>> 10);
        int i13 = i12 + (i12 << 3);
        int i14 = i13 ^ (i13 >>> 6);
        int i15 = i14 + (i14 << 2) + (i14 << 14);
        return i15 ^ (i15 >>> 16);
    }

    public static <E> ArrayList<E> R(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        Iterators.a(arrayList, collection.iterator());
        return arrayList;
    }

    public static <K, V> s<K, V> S() {
        return (s<K, V>) D;
    }

    public static <K, V> void e(com.google.common.cache.c<K, V> cVar, com.google.common.cache.c<K, V> cVar2) {
        cVar.setNextInAccessQueue(cVar2);
        cVar2.setPreviousInAccessQueue(cVar);
    }

    public static <K, V> void f(com.google.common.cache.c<K, V> cVar, com.google.common.cache.c<K, V> cVar2) {
        cVar.setNextInWriteQueue(cVar2);
        cVar2.setPreviousInWriteQueue(cVar);
    }

    public static <E> Queue<E> j() {
        return (Queue<E>) E;
    }

    public long A() {
        long j10 = 0;
        for (int i10 = 0; i10 < this.f9187d.length; i10++) {
            j10 += Math.max(0, r0[i10].count);
        }
        return j10;
    }

    @a5.d
    public com.google.common.cache.c<K, V> B(K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
        Segment<K, V> Q = Q(i10);
        Q.lock();
        try {
            return Q.newEntry(k10, i10, cVar);
        } finally {
            Q.unlock();
        }
    }

    public final Segment<K, V>[] C(int i10) {
        return new Segment[i10];
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a5.d
    public s<K, V> D(com.google.common.cache.c<K, V> cVar, V v10, int i10) {
        return this.f9192i.referenceValue(Q(cVar.getHash()), cVar, b5.u.E(v10), i10);
    }

    public void H() {
        while (true) {
            RemovalNotification<K, V> poll = this.f9198o.poll();
            if (poll == null) {
                return;
            }
            try {
                this.f9199p.onRemoval(poll);
            } catch (Throwable th2) {
                C.log(Level.WARNING, "Exception thrown by removal listener", th2);
            }
        }
    }

    public void I(com.google.common.cache.c<K, V> cVar) {
        int hash = cVar.getHash();
        Q(hash).reclaimKey(cVar, hash);
    }

    public void J(s<K, V> sVar) {
        com.google.common.cache.c<K, V> a10 = sVar.a();
        int hash = a10.getHash();
        Q(hash).reclaimValue(a10.getKey(), hash, sVar);
    }

    public boolean K() {
        return m();
    }

    public boolean L() {
        return M() || K();
    }

    public boolean M() {
        return n() || O();
    }

    public void N(K k10) {
        int v10 = v(b5.u.E(k10));
        Q(v10).refresh(k10, v10, this.f9203t, false);
    }

    public boolean O() {
        return this.f9197n > 0;
    }

    public Segment<K, V> Q(int i10) {
        return this.f9187d[(i10 >>> this.f9186c) & this.f9185b];
    }

    public boolean T() {
        return U() || K();
    }

    public boolean U() {
        return m() || k();
    }

    public boolean V() {
        return this.f9191h != Strength.STRONG;
    }

    public boolean W() {
        return this.f9192i != Strength.STRONG;
    }

    public boolean X() {
        return Y() || M();
    }

    public boolean Y() {
        return n();
    }

    public void c() {
        for (Segment<K, V> segment : this.f9187d) {
            segment.cleanUp();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment<K, V> segment : this.f9187d) {
            segment.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@CheckForNull Object obj) {
        if (obj == null) {
            return false;
        }
        int v10 = v(obj);
        return Q(v10).containsKey(obj, v10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@CheckForNull Object obj) {
        if (obj == null) {
            return false;
        }
        long a10 = this.f9200q.a();
        Segment<K, V>[] segmentArr = this.f9187d;
        long j10 = -1;
        int i10 = 0;
        while (i10 < 3) {
            int length = segmentArr.length;
            long j11 = 0;
            int i11 = 0;
            while (i11 < length) {
                Segment<K, V> segment = segmentArr[i11];
                int i12 = segment.count;
                AtomicReferenceArray<com.google.common.cache.c<K, V>> atomicReferenceArray = segment.table;
                for (int i13 = 0; i13 < atomicReferenceArray.length(); i13++) {
                    com.google.common.cache.c<K, V> cVar = atomicReferenceArray.get(i13);
                    while (cVar != null) {
                        Segment<K, V>[] segmentArr2 = segmentArr;
                        V liveValue = segment.getLiveValue(cVar, a10);
                        long j12 = a10;
                        if (liveValue != null && this.f9190g.equivalent(obj, liveValue)) {
                            return true;
                        }
                        cVar = cVar.getNext();
                        segmentArr = segmentArr2;
                        a10 = j12;
                    }
                }
                j11 += segment.modCount;
                i11++;
                a10 = a10;
            }
            long j13 = a10;
            Segment<K, V>[] segmentArr3 = segmentArr;
            if (j11 == j10) {
                return false;
            }
            i10++;
            j10 = j11;
            segmentArr = segmentArr3;
            a10 = j13;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @a5.c
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f9206w;
        if (set != null) {
            return set;
        }
        g gVar = new g();
        this.f9206w = gVar;
        return gVar;
    }

    @a5.d
    public com.google.common.cache.c<K, V> g(com.google.common.cache.c<K, V> cVar, com.google.common.cache.c<K, V> cVar2) {
        return Q(cVar.getHash()).copyEntry(cVar, cVar2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object obj) {
        if (obj == null) {
            return null;
        }
        int v10 = v(obj);
        return Q(v10).get(obj, v10);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CheckForNull
    public V getOrDefault(@CheckForNull Object obj, @CheckForNull V v10) {
        V v11 = get(obj);
        return v11 != null ? v11 : v10;
    }

    public Segment<K, V> h(int i10, long j10, a.b bVar) {
        return new Segment<>(this, i10, j10, bVar);
    }

    public boolean i() {
        return this.f9194k != CacheBuilder.OneWeigher.INSTANCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V>[] segmentArr = this.f9187d;
        long j10 = 0;
        for (int i10 = 0; i10 < segmentArr.length; i10++) {
            if (segmentArr[i10].count != 0) {
                return false;
            }
            j10 += segmentArr[i10].modCount;
        }
        if (j10 == 0) {
            return true;
        }
        for (int i11 = 0; i11 < segmentArr.length; i11++) {
            if (segmentArr[i11].count != 0) {
                return false;
            }
            j10 -= segmentArr[i11].modCount;
        }
        return j10 == 0;
    }

    public boolean k() {
        return this.f9193j >= 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.f9204u;
        if (set != null) {
            return set;
        }
        j jVar = new j();
        this.f9204u = jVar;
        return jVar;
    }

    public boolean l() {
        return n() || m();
    }

    public boolean m() {
        return this.f9195l > 0;
    }

    public boolean n() {
        return this.f9196m > 0;
    }

    public V o(K k10, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
        int v10 = v(b5.u.E(k10));
        return Q(v10).get(k10, v10, cacheLoader);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImmutableMap<K, V> p(Iterable<? extends K> iterable) throws ExecutionException {
        LinkedHashMap c02 = Maps.c0();
        LinkedHashSet A2 = Sets.A();
        int i10 = 0;
        int i11 = 0;
        for (K k10 : iterable) {
            Object obj = get(k10);
            if (!c02.containsKey(k10)) {
                c02.put(k10, obj);
                if (obj == null) {
                    i11++;
                    A2.add(k10);
                } else {
                    i10++;
                }
            }
        }
        try {
            if (!A2.isEmpty()) {
                try {
                    Map z10 = z(Collections.unmodifiableSet(A2), this.f9203t);
                    for (Object obj2 : A2) {
                        Object obj3 = z10.get(obj2);
                        if (obj3 == null) {
                            String valueOf = String.valueOf(obj2);
                            StringBuilder sb2 = new StringBuilder(valueOf.length() + 37);
                            sb2.append("loadAll failed to return a value for ");
                            sb2.append(valueOf);
                            throw new CacheLoader.InvalidCacheLoadException(sb2.toString());
                        }
                        c02.put(obj2, obj3);
                    }
                } catch (CacheLoader.UnsupportedLoadingOperationException unused) {
                    for (Object obj4 : A2) {
                        i11--;
                        c02.put(obj4, o(obj4, this.f9203t));
                    }
                }
            }
            ImmutableMap<K, V> copyOf = ImmutableMap.copyOf((Map) c02);
            this.f9202s.a(i10);
            this.f9202s.b(i11);
            return copyOf;
        } catch (Throwable th2) {
            this.f9202s.a(i10);
            this.f9202s.b(i11);
            throw th2;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k10, V v10) {
        b5.u.E(k10);
        b5.u.E(v10);
        int v11 = v(k10);
        return Q(v11).put(k10, v11, v10, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k10, V v10) {
        b5.u.E(k10);
        b5.u.E(v10);
        int v11 = v(k10);
        return Q(v11).put(k10, v11, v10, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImmutableMap<K, V> q(Iterable<?> iterable) {
        ImmutableMap.b builder = ImmutableMap.builder();
        int i10 = 0;
        int i11 = 0;
        for (Object obj : iterable) {
            V v10 = get(obj);
            if (v10 == null) {
                i11++;
            } else {
                builder.i(obj, v10);
                i10++;
            }
        }
        this.f9202s.a(i10);
        this.f9202s.b(i11);
        return builder.c();
    }

    public com.google.common.cache.c<K, V> r(@CheckForNull Object obj) {
        if (obj == null) {
            return null;
        }
        int v10 = v(obj);
        return Q(v10).getEntry(obj, v10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(@CheckForNull Object obj) {
        if (obj == null) {
            return null;
        }
        int v10 = v(obj);
        return Q(v10).remove(obj, v10);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k10, @CheckForNull V v10, V v11) {
        b5.u.E(k10);
        b5.u.E(v11);
        if (v10 == null) {
            return false;
        }
        int v12 = v(k10);
        return Q(v12).replace(k10, v12, v10, v11);
    }

    @CheckForNull
    public V s(Object obj) {
        int v10 = v(b5.u.E(obj));
        V v11 = Q(v10).get(obj, v10);
        if (v11 == null) {
            this.f9202s.b(1);
        } else {
            this.f9202s.a(1);
        }
        return v11;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return Ints.x(A());
    }

    @CheckForNull
    public V t(com.google.common.cache.c<K, V> cVar, long j10) {
        V v10;
        if (cVar.getKey() == null || (v10 = cVar.getValueReference().get()) == null || x(cVar, j10)) {
            return null;
        }
        return v10;
    }

    public V u(K k10) throws ExecutionException {
        return o(k10, this.f9203t);
    }

    public int v(@CheckForNull Object obj) {
        return P(this.f9189f.hash(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.f9205v;
        if (collection != null) {
            return collection;
        }
        t tVar = new t();
        this.f9205v = tVar;
        return tVar;
    }

    public void w(Iterable<?> iterable) {
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    public boolean x(com.google.common.cache.c<K, V> cVar, long j10) {
        b5.u.E(cVar);
        if (!m() || j10 - cVar.getAccessTime() < this.f9195l) {
            return n() && j10 - cVar.getWriteTime() >= this.f9196m;
        }
        return true;
    }

    @a5.d
    public boolean y(com.google.common.cache.c<K, V> cVar, long j10) {
        return Q(cVar.getHash()).getLiveValue(cVar, j10) != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00cd  */
    @javax.annotation.CheckForNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Map<K, V> z(java.util.Set<? extends K> r7, com.google.common.cache.CacheLoader<? super K, V> r8) throws java.util.concurrent.ExecutionException {
        /*
            r6 = this;
            b5.u.E(r8)
            b5.u.E(r7)
            b5.x r0 = b5.x.c()
            r1 = 1
            r2 = 0
            java.util.Map r7 = r8.loadAll(r7)     // Catch: java.lang.Throwable -> La2 java.lang.Error -> La5 java.lang.Exception -> Lac java.lang.RuntimeException -> Lb3 java.lang.InterruptedException -> Lba com.google.common.cache.CacheLoader.UnsupportedLoadingOperationException -> Lc8
            if (r7 == 0) goto L76
            r0.l()
            java.util.Set r3 = r7.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L1d:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L3c
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            java.lang.Object r4 = r4.getValue()
            if (r5 == 0) goto L3a
            if (r4 != 0) goto L36
            goto L3a
        L36:
            r6.put(r5, r4)
            goto L1d
        L3a:
            r2 = 1
            goto L1d
        L3c:
            if (r2 != 0) goto L4a
            com.google.common.cache.a$b r8 = r6.f9202s
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.g(r1)
            r8.e(r0)
            return r7
        L4a:
            com.google.common.cache.a$b r7 = r6.f9202s
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.g(r1)
            r7.d(r0)
            com.google.common.cache.CacheLoader$InvalidCacheLoadException r7 = new com.google.common.cache.CacheLoader$InvalidCacheLoadException
            java.lang.String r8 = java.lang.String.valueOf(r8)
            int r0 = r8.length()
            int r0 = r0 + 42
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            r1.append(r8)
            java.lang.String r8 = " returned null keys or values from loadAll"
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r7.<init>(r8)
            throw r7
        L76:
            com.google.common.cache.a$b r7 = r6.f9202s
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.g(r1)
            r7.d(r0)
            com.google.common.cache.CacheLoader$InvalidCacheLoadException r7 = new com.google.common.cache.CacheLoader$InvalidCacheLoadException
            java.lang.String r8 = java.lang.String.valueOf(r8)
            int r0 = r8.length()
            int r0 = r0 + 31
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            r1.append(r8)
            java.lang.String r8 = " returned null map from loadAll"
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r7.<init>(r8)
            throw r7
        La2:
            r7 = move-exception
            r1 = 0
            goto Lcb
        La5:
            r7 = move-exception
            com.google.common.util.concurrent.ExecutionError r8 = new com.google.common.util.concurrent.ExecutionError     // Catch: java.lang.Throwable -> La2
            r8.<init>(r7)     // Catch: java.lang.Throwable -> La2
            throw r8     // Catch: java.lang.Throwable -> La2
        Lac:
            r7 = move-exception
            java.util.concurrent.ExecutionException r8 = new java.util.concurrent.ExecutionException     // Catch: java.lang.Throwable -> La2
            r8.<init>(r7)     // Catch: java.lang.Throwable -> La2
            throw r8     // Catch: java.lang.Throwable -> La2
        Lb3:
            r7 = move-exception
            com.google.common.util.concurrent.UncheckedExecutionException r8 = new com.google.common.util.concurrent.UncheckedExecutionException     // Catch: java.lang.Throwable -> La2
            r8.<init>(r7)     // Catch: java.lang.Throwable -> La2
            throw r8     // Catch: java.lang.Throwable -> La2
        Lba:
            r7 = move-exception
            java.lang.Thread r8 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> La2
            r8.interrupt()     // Catch: java.lang.Throwable -> La2
            java.util.concurrent.ExecutionException r8 = new java.util.concurrent.ExecutionException     // Catch: java.lang.Throwable -> La2
            r8.<init>(r7)     // Catch: java.lang.Throwable -> La2
            throw r8     // Catch: java.lang.Throwable -> La2
        Lc8:
            r7 = move-exception
            throw r7     // Catch: java.lang.Throwable -> Lca
        Lca:
            r7 = move-exception
        Lcb:
            if (r1 != 0) goto Ld8
            com.google.common.cache.a$b r8 = r6.f9202s
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.g(r1)
            r8.d(r0)
        Ld8:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.z(java.util.Set, com.google.common.cache.CacheLoader):java.util.Map");
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int v10 = v(obj);
        return Q(v10).remove(obj, v10, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k10, V v10) {
        b5.u.E(k10);
        b5.u.E(v10);
        int v11 = v(k10);
        return Q(v11).replace(k10, v11, v10);
    }

    public static class Segment<K, V> extends ReentrantLock {

        @GuardedBy("this")
        final Queue<com.google.common.cache.c<K, V>> accessQueue;
        volatile int count;

        @CheckForNull
        final ReferenceQueue<K> keyReferenceQueue;

        @Weak
        final LocalCache<K, V> map;
        final long maxSegmentWeight;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        final Queue<com.google.common.cache.c<K, V>> recencyQueue;
        final a.b statsCounter;

        @CheckForNull
        volatile AtomicReferenceArray<com.google.common.cache.c<K, V>> table;
        int threshold;

        @GuardedBy("this")
        long totalWeight;

        @CheckForNull
        final ReferenceQueue<V> valueReferenceQueue;

        @GuardedBy("this")
        final Queue<com.google.common.cache.c<K, V>> writeQueue;

        public class a implements Runnable {

            /* renamed from: b */
            public final /* synthetic */ Object f9208b;

            /* renamed from: c */
            public final /* synthetic */ int f9209c;

            /* renamed from: d */
            public final /* synthetic */ k f9210d;

            /* renamed from: e */
            public final /* synthetic */ p5.c0 f9211e;

            public a(Object obj, int i10, k kVar, p5.c0 c0Var) {
                this.f9208b = obj;
                this.f9209c = i10;
                this.f9210d = kVar;
                this.f9211e = c0Var;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Segment.this.getAndRecordStats(this.f9208b, this.f9209c, this.f9210d, this.f9211e);
                } catch (Throwable th2) {
                    LocalCache.C.log(Level.WARNING, "Exception thrown during refresh", th2);
                    this.f9210d.k(th2);
                }
            }
        }

        public Segment(LocalCache<K, V> localCache, int i10, long j10, a.b bVar) {
            this.map = localCache;
            this.maxSegmentWeight = j10;
            this.statsCounter = (a.b) b5.u.E(bVar);
            initTable(newEntryArray(i10));
            this.keyReferenceQueue = localCache.V() ? new ReferenceQueue<>() : null;
            this.valueReferenceQueue = localCache.W() ? new ReferenceQueue<>() : null;
            this.recencyQueue = localCache.U() ? new ConcurrentLinkedQueue<>() : LocalCache.j();
            this.writeQueue = localCache.Y() ? new c0<>() : LocalCache.j();
            this.accessQueue = localCache.U() ? new e<>() : LocalCache.j();
        }

        public void cleanUp() {
            runLockedCleanup(this.map.f9200q.a());
            runUnlockedCleanup();
        }

        public void clear() {
            RemovalCause removalCause;
            if (this.count != 0) {
                lock();
                try {
                    preWriteCleanup(this.map.f9200q.a());
                    AtomicReferenceArray<com.google.common.cache.c<K, V>> atomicReferenceArray = this.table;
                    for (int i10 = 0; i10 < atomicReferenceArray.length(); i10++) {
                        for (com.google.common.cache.c<K, V> cVar = atomicReferenceArray.get(i10); cVar != null; cVar = cVar.getNext()) {
                            if (cVar.getValueReference().isActive()) {
                                K key = cVar.getKey();
                                V v10 = cVar.getValueReference().get();
                                if (key != null && v10 != null) {
                                    removalCause = RemovalCause.EXPLICIT;
                                    enqueueNotification(key, cVar.getHash(), v10, cVar.getValueReference().c(), removalCause);
                                }
                                removalCause = RemovalCause.COLLECTED;
                                enqueueNotification(key, cVar.getHash(), v10, cVar.getValueReference().c(), removalCause);
                            }
                        }
                    }
                    for (int i11 = 0; i11 < atomicReferenceArray.length(); i11++) {
                        atomicReferenceArray.set(i11, null);
                    }
                    clearReferenceQueues();
                    this.writeQueue.clear();
                    this.accessQueue.clear();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                    unlock();
                    postWriteCleanup();
                } catch (Throwable th2) {
                    unlock();
                    postWriteCleanup();
                    throw th2;
                }
            }
        }

        public void clearKeyReferenceQueue() {
            while (this.keyReferenceQueue.poll() != null) {
            }
        }

        public void clearReferenceQueues() {
            if (this.map.V()) {
                clearKeyReferenceQueue();
            }
            if (this.map.W()) {
                clearValueReferenceQueue();
            }
        }

        public void clearValueReferenceQueue() {
            while (this.valueReferenceQueue.poll() != null) {
            }
        }

        public boolean containsKey(Object obj, int i10) {
            try {
                if (this.count == 0) {
                    return false;
                }
                com.google.common.cache.c<K, V> liveEntry = getLiveEntry(obj, i10, this.map.f9200q.a());
                if (liveEntry == null) {
                    return false;
                }
                return liveEntry.getValueReference().get() != null;
            } finally {
                postReadCleanup();
            }
        }

        @a5.d
        public boolean containsValue(Object obj) {
            try {
                if (this.count != 0) {
                    long a10 = this.map.f9200q.a();
                    AtomicReferenceArray<com.google.common.cache.c<K, V>> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i10 = 0; i10 < length; i10++) {
                        for (com.google.common.cache.c<K, V> cVar = atomicReferenceArray.get(i10); cVar != null; cVar = cVar.getNext()) {
                            V liveValue = getLiveValue(cVar, a10);
                            if (liveValue != null && this.map.f9190g.equivalent(obj, liveValue)) {
                                postReadCleanup();
                                return true;
                            }
                        }
                    }
                }
                return false;
            } finally {
                postReadCleanup();
            }
        }

        @GuardedBy("this")
        public com.google.common.cache.c<K, V> copyEntry(com.google.common.cache.c<K, V> cVar, com.google.common.cache.c<K, V> cVar2) {
            if (cVar.getKey() == null) {
                return null;
            }
            s<K, V> valueReference = cVar.getValueReference();
            V v10 = valueReference.get();
            if (v10 == null && valueReference.isActive()) {
                return null;
            }
            com.google.common.cache.c<K, V> copyEntry = this.map.f9201r.copyEntry(this, cVar, cVar2);
            copyEntry.setValueReference(valueReference.d(this.valueReferenceQueue, v10, copyEntry));
            return copyEntry;
        }

        @GuardedBy("this")
        public void drainKeyReferenceQueue() {
            int i10 = 0;
            do {
                Reference<? extends K> poll = this.keyReferenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.I((com.google.common.cache.c) poll);
                i10++;
            } while (i10 != 16);
        }

        @GuardedBy("this")
        public void drainRecencyQueue() {
            while (true) {
                com.google.common.cache.c<K, V> poll = this.recencyQueue.poll();
                if (poll == null) {
                    return;
                }
                if (this.accessQueue.contains(poll)) {
                    this.accessQueue.add(poll);
                }
            }
        }

        @GuardedBy("this")
        public void drainReferenceQueues() {
            if (this.map.V()) {
                drainKeyReferenceQueue();
            }
            if (this.map.W()) {
                drainValueReferenceQueue();
            }
        }

        @GuardedBy("this")
        public void drainValueReferenceQueue() {
            int i10 = 0;
            do {
                Reference<? extends V> poll = this.valueReferenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.J((s) poll);
                i10++;
            } while (i10 != 16);
        }

        @GuardedBy("this")
        public void enqueueNotification(@CheckForNull K k10, int i10, @CheckForNull V v10, int i11, RemovalCause removalCause) {
            this.totalWeight -= i11;
            if (removalCause.wasEvicted()) {
                this.statsCounter.c();
            }
            if (this.map.f9198o != LocalCache.E) {
                this.map.f9198o.offer(RemovalNotification.create(k10, v10, removalCause));
            }
        }

        @GuardedBy("this")
        public void evictEntries(com.google.common.cache.c<K, V> cVar) {
            if (this.map.k()) {
                drainRecencyQueue();
                if (cVar.getValueReference().c() > this.maxSegmentWeight && !removeEntry(cVar, cVar.getHash(), RemovalCause.SIZE)) {
                    throw new AssertionError();
                }
                while (this.totalWeight > this.maxSegmentWeight) {
                    com.google.common.cache.c<K, V> nextEvictable = getNextEvictable();
                    if (!removeEntry(nextEvictable, nextEvictable.getHash(), RemovalCause.SIZE)) {
                        throw new AssertionError();
                    }
                }
            }
        }

        @GuardedBy("this")
        public void expand() {
            AtomicReferenceArray<com.google.common.cache.c<K, V>> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i10 = this.count;
            AtomicReferenceArray<com.google.common.cache.c<K, V>> newEntryArray = newEntryArray(length << 1);
            this.threshold = (newEntryArray.length() * 3) / 4;
            int length2 = newEntryArray.length() - 1;
            for (int i11 = 0; i11 < length; i11++) {
                com.google.common.cache.c<K, V> cVar = atomicReferenceArray.get(i11);
                if (cVar != null) {
                    com.google.common.cache.c<K, V> next = cVar.getNext();
                    int hash = cVar.getHash() & length2;
                    if (next == null) {
                        newEntryArray.set(hash, cVar);
                    } else {
                        com.google.common.cache.c<K, V> cVar2 = cVar;
                        while (next != null) {
                            int hash2 = next.getHash() & length2;
                            if (hash2 != hash) {
                                cVar2 = next;
                                hash = hash2;
                            }
                            next = next.getNext();
                        }
                        newEntryArray.set(hash, cVar2);
                        while (cVar != cVar2) {
                            int hash3 = cVar.getHash() & length2;
                            com.google.common.cache.c<K, V> copyEntry = copyEntry(cVar, newEntryArray.get(hash3));
                            if (copyEntry != null) {
                                newEntryArray.set(hash3, copyEntry);
                            } else {
                                removeCollectedEntry(cVar);
                                i10--;
                            }
                            cVar = cVar.getNext();
                        }
                    }
                }
            }
            this.table = newEntryArray;
            this.count = i10;
        }

        @GuardedBy("this")
        public void expireEntries(long j10) {
            com.google.common.cache.c<K, V> peek;
            com.google.common.cache.c<K, V> peek2;
            drainRecencyQueue();
            do {
                peek = this.writeQueue.peek();
                if (peek == null || !this.map.x(peek, j10)) {
                    do {
                        peek2 = this.accessQueue.peek();
                        if (peek2 == null || !this.map.x(peek2, j10)) {
                            return;
                        }
                    } while (removeEntry(peek2, peek2.getHash(), RemovalCause.EXPIRED));
                    throw new AssertionError();
                }
            } while (removeEntry(peek, peek.getHash(), RemovalCause.EXPIRED));
            throw new AssertionError();
        }

        public V get(K k10, int i10, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            com.google.common.cache.c<K, V> entry;
            b5.u.E(k10);
            b5.u.E(cacheLoader);
            try {
                try {
                    if (this.count != 0 && (entry = getEntry(k10, i10)) != null) {
                        long a10 = this.map.f9200q.a();
                        V liveValue = getLiveValue(entry, a10);
                        if (liveValue != null) {
                            recordRead(entry, a10);
                            this.statsCounter.a(1);
                            return scheduleRefresh(entry, k10, i10, liveValue, a10, cacheLoader);
                        }
                        s<K, V> valueReference = entry.getValueReference();
                        if (valueReference.isLoading()) {
                            return waitForLoadingValue(entry, k10, valueReference);
                        }
                    }
                    return lockedGetOrLoad(k10, i10, cacheLoader);
                } catch (ExecutionException e10) {
                    Throwable cause = e10.getCause();
                    if (cause instanceof Error) {
                        throw new ExecutionError((Error) cause);
                    }
                    if (cause instanceof RuntimeException) {
                        throw new UncheckedExecutionException(cause);
                    }
                    throw e10;
                }
            } finally {
                postReadCleanup();
            }
        }

        public V getAndRecordStats(K k10, int i10, k<K, V> kVar, p5.c0<V> c0Var) throws ExecutionException {
            V v10;
            try {
                v10 = (V) b1.f(c0Var);
            } catch (Throwable th2) {
                th = th2;
                v10 = null;
            }
            try {
                if (v10 != null) {
                    this.statsCounter.e(kVar.f());
                    storeLoadedValue(k10, i10, kVar, v10);
                    return v10;
                }
                String valueOf = String.valueOf(k10);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 35);
                sb2.append("CacheLoader returned null for key ");
                sb2.append(valueOf);
                sb2.append(p1.b.f29697h);
                throw new CacheLoader.InvalidCacheLoadException(sb2.toString());
            } catch (Throwable th3) {
                th = th3;
                if (v10 == null) {
                    this.statsCounter.d(kVar.f());
                    removeLoadingValue(k10, i10, kVar);
                }
                throw th;
            }
        }

        @CheckForNull
        public com.google.common.cache.c<K, V> getEntry(Object obj, int i10) {
            for (com.google.common.cache.c<K, V> first = getFirst(i10); first != null; first = first.getNext()) {
                if (first.getHash() == i10) {
                    K key = first.getKey();
                    if (key == null) {
                        tryDrainReferenceQueues();
                    } else if (this.map.f9189f.equivalent(obj, key)) {
                        return first;
                    }
                }
            }
            return null;
        }

        public com.google.common.cache.c<K, V> getFirst(int i10) {
            return this.table.get(i10 & (r0.length() - 1));
        }

        @CheckForNull
        public com.google.common.cache.c<K, V> getLiveEntry(Object obj, int i10, long j10) {
            com.google.common.cache.c<K, V> entry = getEntry(obj, i10);
            if (entry == null) {
                return null;
            }
            if (!this.map.x(entry, j10)) {
                return entry;
            }
            tryExpireEntries(j10);
            return null;
        }

        public V getLiveValue(com.google.common.cache.c<K, V> cVar, long j10) {
            if (cVar.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v10 = cVar.getValueReference().get();
            if (v10 == null) {
                tryDrainReferenceQueues();
                return null;
            }
            if (!this.map.x(cVar, j10)) {
                return v10;
            }
            tryExpireEntries(j10);
            return null;
        }

        @GuardedBy("this")
        public com.google.common.cache.c<K, V> getNextEvictable() {
            for (com.google.common.cache.c<K, V> cVar : this.accessQueue) {
                if (cVar.getValueReference().c() > 0) {
                    return cVar;
                }
            }
            throw new AssertionError();
        }

        public void initTable(AtomicReferenceArray<com.google.common.cache.c<K, V>> atomicReferenceArray) {
            this.threshold = (atomicReferenceArray.length() * 3) / 4;
            if (!this.map.i()) {
                int i10 = this.threshold;
                if (i10 == this.maxSegmentWeight) {
                    this.threshold = i10 + 1;
                }
            }
            this.table = atomicReferenceArray;
        }

        /* JADX WARN: Finally extract failed */
        @CheckForNull
        public k<K, V> insertLoadingValueReference(K k10, int i10, boolean z10) {
            lock();
            try {
                long a10 = this.map.f9200q.a();
                preWriteCleanup(a10);
                AtomicReferenceArray<com.google.common.cache.c<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                com.google.common.cache.c<K, V> cVar = (com.google.common.cache.c) atomicReferenceArray.get(length);
                for (com.google.common.cache.c cVar2 = cVar; cVar2 != null; cVar2 = cVar2.getNext()) {
                    Object key = cVar2.getKey();
                    if (cVar2.getHash() == i10 && key != null && this.map.f9189f.equivalent(k10, key)) {
                        s<K, V> valueReference = cVar2.getValueReference();
                        if (!valueReference.isLoading() && (!z10 || a10 - cVar2.getWriteTime() >= this.map.f9197n)) {
                            this.modCount++;
                            k<K, V> kVar = new k<>(valueReference);
                            cVar2.setValueReference(kVar);
                            unlock();
                            postWriteCleanup();
                            return kVar;
                        }
                        unlock();
                        postWriteCleanup();
                        return null;
                    }
                }
                this.modCount++;
                k<K, V> kVar2 = new k<>();
                com.google.common.cache.c<K, V> newEntry = newEntry(k10, i10, cVar);
                newEntry.setValueReference(kVar2);
                atomicReferenceArray.set(length, newEntry);
                unlock();
                postWriteCleanup();
                return kVar2;
            } catch (Throwable th2) {
                unlock();
                postWriteCleanup();
                throw th2;
            }
        }

        public p5.c0<V> loadAsync(K k10, int i10, k<K, V> kVar, CacheLoader<? super K, V> cacheLoader) {
            p5.c0<V> i11 = kVar.i(k10, cacheLoader);
            i11.addListener(new a(k10, i10, kVar, i11), com.google.common.util.concurrent.p.c());
            return i11;
        }

        public V loadSync(K k10, int i10, k<K, V> kVar, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            return getAndRecordStats(k10, i10, kVar, kVar.i(k10, cacheLoader));
        }

        public V lockedGetOrLoad(K k10, int i10, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            k<K, V> kVar;
            s<K, V> sVar;
            boolean z10;
            V loadSync;
            lock();
            try {
                long a10 = this.map.f9200q.a();
                preWriteCleanup(a10);
                int i11 = this.count - 1;
                AtomicReferenceArray<com.google.common.cache.c<K, V>> atomicReferenceArray = this.table;
                int length = i10 & (atomicReferenceArray.length() - 1);
                com.google.common.cache.c<K, V> cVar = atomicReferenceArray.get(length);
                com.google.common.cache.c<K, V> cVar2 = cVar;
                while (true) {
                    kVar = null;
                    if (cVar2 == null) {
                        sVar = null;
                        break;
                    }
                    K key = cVar2.getKey();
                    if (cVar2.getHash() == i10 && key != null && this.map.f9189f.equivalent(k10, key)) {
                        s<K, V> valueReference = cVar2.getValueReference();
                        if (valueReference.isLoading()) {
                            z10 = false;
                            sVar = valueReference;
                        } else {
                            V v10 = valueReference.get();
                            if (v10 == null) {
                                enqueueNotification(key, i10, v10, valueReference.c(), RemovalCause.COLLECTED);
                            } else {
                                if (!this.map.x(cVar2, a10)) {
                                    recordLockedRead(cVar2, a10);
                                    this.statsCounter.a(1);
                                    unlock();
                                    postWriteCleanup();
                                    return v10;
                                }
                                enqueueNotification(key, i10, v10, valueReference.c(), RemovalCause.EXPIRED);
                            }
                            this.writeQueue.remove(cVar2);
                            this.accessQueue.remove(cVar2);
                            this.count = i11;
                            sVar = valueReference;
                        }
                    } else {
                        cVar2 = cVar2.getNext();
                    }
                }
                z10 = true;
                if (z10) {
                    kVar = new k<>();
                    if (cVar2 == null) {
                        cVar2 = newEntry(k10, i10, cVar);
                        cVar2.setValueReference(kVar);
                        atomicReferenceArray.set(length, cVar2);
                    } else {
                        cVar2.setValueReference(kVar);
                    }
                }
                unlock();
                postWriteCleanup();
                if (!z10) {
                    return waitForLoadingValue(cVar2, k10, sVar);
                }
                try {
                    synchronized (cVar2) {
                        loadSync = loadSync(k10, i10, kVar, cacheLoader);
                    }
                    return loadSync;
                } finally {
                    this.statsCounter.b(1);
                }
            } catch (Throwable th2) {
                unlock();
                postWriteCleanup();
                throw th2;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @GuardedBy("this")
        public com.google.common.cache.c<K, V> newEntry(K k10, int i10, @CheckForNull com.google.common.cache.c<K, V> cVar) {
            return this.map.f9201r.newEntry(this, b5.u.E(k10), i10, cVar);
        }

        public AtomicReferenceArray<com.google.common.cache.c<K, V>> newEntryArray(int i10) {
            return new AtomicReferenceArray<>(i10);
        }

        public void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                cleanUp();
            }
        }

        public void postWriteCleanup() {
            runUnlockedCleanup();
        }

        @GuardedBy("this")
        public void preWriteCleanup(long j10) {
            runLockedCleanup(j10);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x008d, code lost:
        
            unlock();
            postWriteCleanup();
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0093, code lost:
        
            return null;
         */
        @javax.annotation.CheckForNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public V put(K r15, int r16, V r17, boolean r18) {
            /*
                Method dump skipped, instructions count: 238
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.put(java.lang.Object, int, java.lang.Object, boolean):java.lang.Object");
        }

        public boolean reclaimKey(com.google.common.cache.c<K, V> cVar, int i10) {
            lock();
            try {
                AtomicReferenceArray<com.google.common.cache.c<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                com.google.common.cache.c<K, V> cVar2 = atomicReferenceArray.get(length);
                for (com.google.common.cache.c<K, V> cVar3 = cVar2; cVar3 != null; cVar3 = cVar3.getNext()) {
                    if (cVar3 == cVar) {
                        this.modCount++;
                        com.google.common.cache.c<K, V> removeValueFromChain = removeValueFromChain(cVar2, cVar3, cVar3.getKey(), i10, cVar3.getValueReference().get(), cVar3.getValueReference(), RemovalCause.COLLECTED);
                        int i11 = this.count - 1;
                        atomicReferenceArray.set(length, removeValueFromChain);
                        this.count = i11;
                        return true;
                    }
                }
                unlock();
                postWriteCleanup();
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public boolean reclaimValue(K k10, int i10, s<K, V> sVar) {
            lock();
            try {
                AtomicReferenceArray<com.google.common.cache.c<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                com.google.common.cache.c<K, V> cVar = atomicReferenceArray.get(length);
                for (com.google.common.cache.c<K, V> cVar2 = cVar; cVar2 != null; cVar2 = cVar2.getNext()) {
                    K key = cVar2.getKey();
                    if (cVar2.getHash() == i10 && key != null && this.map.f9189f.equivalent(k10, key)) {
                        if (cVar2.getValueReference() != sVar) {
                            unlock();
                            if (!isHeldByCurrentThread()) {
                                postWriteCleanup();
                            }
                            return false;
                        }
                        this.modCount++;
                        com.google.common.cache.c<K, V> removeValueFromChain = removeValueFromChain(cVar, cVar2, key, i10, sVar.get(), sVar, RemovalCause.COLLECTED);
                        int i11 = this.count - 1;
                        atomicReferenceArray.set(length, removeValueFromChain);
                        this.count = i11;
                        return true;
                    }
                }
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
                return false;
            } finally {
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
            }
        }

        @GuardedBy("this")
        public void recordLockedRead(com.google.common.cache.c<K, V> cVar, long j10) {
            if (this.map.K()) {
                cVar.setAccessTime(j10);
            }
            this.accessQueue.add(cVar);
        }

        public void recordRead(com.google.common.cache.c<K, V> cVar, long j10) {
            if (this.map.K()) {
                cVar.setAccessTime(j10);
            }
            this.recencyQueue.add(cVar);
        }

        @GuardedBy("this")
        public void recordWrite(com.google.common.cache.c<K, V> cVar, int i10, long j10) {
            drainRecencyQueue();
            this.totalWeight += i10;
            if (this.map.K()) {
                cVar.setAccessTime(j10);
            }
            if (this.map.M()) {
                cVar.setWriteTime(j10);
            }
            this.accessQueue.add(cVar);
            this.writeQueue.add(cVar);
        }

        @CheckForNull
        public V refresh(K k10, int i10, CacheLoader<? super K, V> cacheLoader, boolean z10) {
            k<K, V> insertLoadingValueReference = insertLoadingValueReference(k10, i10, z10);
            if (insertLoadingValueReference == null) {
                return null;
            }
            p5.c0<V> loadAsync = loadAsync(k10, i10, insertLoadingValueReference, cacheLoader);
            if (loadAsync.isDone()) {
                try {
                    return (V) b1.f(loadAsync);
                } catch (Throwable unused) {
                }
            }
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
        
            r9 = r5.getValueReference();
            r12 = r9.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
        
            if (r12 == null) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
        
            r2 = com.google.common.cache.RemovalCause.EXPLICIT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:
        
            r10 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0051, code lost:
        
            r11.modCount++;
            r13 = removeValueFromChain(r4, r5, r6, r13, r12, r9, r10);
            r2 = r11.count - 1;
            r0.set(r1, r13);
            r11.count = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0067, code lost:
        
            unlock();
            postWriteCleanup();
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x006d, code lost:
        
            return r12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x004c, code lost:
        
            if (r9.isActive() == false) goto L95;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x004e, code lost:
        
            r2 = com.google.common.cache.RemovalCause.COLLECTED;
         */
        @javax.annotation.CheckForNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public V remove(java.lang.Object r12, int r13) {
            /*
                r11 = this;
                r11.lock()
                com.google.common.cache.LocalCache<K, V> r0 = r11.map     // Catch: java.lang.Throwable -> L46
                b5.b0 r0 = r0.f9200q     // Catch: java.lang.Throwable -> L46
                long r0 = r0.a()     // Catch: java.lang.Throwable -> L46
                r11.preWriteCleanup(r0)     // Catch: java.lang.Throwable -> L46
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.c<K, V>> r0 = r11.table     // Catch: java.lang.Throwable -> L46
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L46
                int r1 = r1 + (-1)
                r1 = r1 & r13
                java.lang.Object r2 = r0.get(r1)     // Catch: java.lang.Throwable -> L46
                r4 = r2
                com.google.common.cache.c r4 = (com.google.common.cache.c) r4     // Catch: java.lang.Throwable -> L46
                r5 = r4
            L1f:
                r2 = 0
                if (r5 == 0) goto L6e
                java.lang.Object r6 = r5.getKey()     // Catch: java.lang.Throwable -> L46
                int r3 = r5.getHash()     // Catch: java.lang.Throwable -> L46
                if (r3 != r13) goto L75
                if (r6 == 0) goto L75
                com.google.common.cache.LocalCache<K, V> r3 = r11.map     // Catch: java.lang.Throwable -> L46
                com.google.common.base.Equivalence<java.lang.Object> r3 = r3.f9189f     // Catch: java.lang.Throwable -> L46
                boolean r3 = r3.equivalent(r12, r6)     // Catch: java.lang.Throwable -> L46
                if (r3 == 0) goto L75
                com.google.common.cache.LocalCache$s r9 = r5.getValueReference()     // Catch: java.lang.Throwable -> L46
                java.lang.Object r12 = r9.get()     // Catch: java.lang.Throwable -> L46
                if (r12 == 0) goto L48
                com.google.common.cache.RemovalCause r2 = com.google.common.cache.RemovalCause.EXPLICIT     // Catch: java.lang.Throwable -> L46
            L44:
                r10 = r2
                goto L51
            L46:
                r12 = move-exception
                goto L7a
            L48:
                boolean r3 = r9.isActive()     // Catch: java.lang.Throwable -> L46
                if (r3 == 0) goto L6e
                com.google.common.cache.RemovalCause r2 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> L46
                goto L44
            L51:
                int r2 = r11.modCount     // Catch: java.lang.Throwable -> L46
                int r2 = r2 + 1
                r11.modCount = r2     // Catch: java.lang.Throwable -> L46
                r3 = r11
                r7 = r13
                r8 = r12
                com.google.common.cache.c r13 = r3.removeValueFromChain(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L46
                int r2 = r11.count     // Catch: java.lang.Throwable -> L46
                int r2 = r2 + (-1)
                r0.set(r1, r13)     // Catch: java.lang.Throwable -> L46
                r11.count = r2     // Catch: java.lang.Throwable -> L46
                r11.unlock()
                r11.postWriteCleanup()
                return r12
            L6e:
                r11.unlock()
                r11.postWriteCleanup()
                return r2
            L75:
                com.google.common.cache.c r5 = r5.getNext()     // Catch: java.lang.Throwable -> L46
                goto L1f
            L7a:
                r11.unlock()
                r11.postWriteCleanup()
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.remove(java.lang.Object, int):java.lang.Object");
        }

        @GuardedBy("this")
        public void removeCollectedEntry(com.google.common.cache.c<K, V> cVar) {
            enqueueNotification(cVar.getKey(), cVar.getHash(), cVar.getValueReference().get(), cVar.getValueReference().c(), RemovalCause.COLLECTED);
            this.writeQueue.remove(cVar);
            this.accessQueue.remove(cVar);
        }

        @a5.d
        @GuardedBy("this")
        public boolean removeEntry(com.google.common.cache.c<K, V> cVar, int i10, RemovalCause removalCause) {
            AtomicReferenceArray<com.google.common.cache.c<K, V>> atomicReferenceArray = this.table;
            int length = (atomicReferenceArray.length() - 1) & i10;
            com.google.common.cache.c<K, V> cVar2 = atomicReferenceArray.get(length);
            for (com.google.common.cache.c<K, V> cVar3 = cVar2; cVar3 != null; cVar3 = cVar3.getNext()) {
                if (cVar3 == cVar) {
                    this.modCount++;
                    com.google.common.cache.c<K, V> removeValueFromChain = removeValueFromChain(cVar2, cVar3, cVar3.getKey(), i10, cVar3.getValueReference().get(), cVar3.getValueReference(), removalCause);
                    int i11 = this.count - 1;
                    atomicReferenceArray.set(length, removeValueFromChain);
                    this.count = i11;
                    return true;
                }
            }
            return false;
        }

        @CheckForNull
        @GuardedBy("this")
        public com.google.common.cache.c<K, V> removeEntryFromChain(com.google.common.cache.c<K, V> cVar, com.google.common.cache.c<K, V> cVar2) {
            int i10 = this.count;
            com.google.common.cache.c<K, V> next = cVar2.getNext();
            while (cVar != cVar2) {
                com.google.common.cache.c<K, V> copyEntry = copyEntry(cVar, next);
                if (copyEntry != null) {
                    next = copyEntry;
                } else {
                    removeCollectedEntry(cVar);
                    i10--;
                }
                cVar = cVar.getNext();
            }
            this.count = i10;
            return next;
        }

        public boolean removeLoadingValue(K k10, int i10, k<K, V> kVar) {
            lock();
            try {
                AtomicReferenceArray<com.google.common.cache.c<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                com.google.common.cache.c<K, V> cVar = atomicReferenceArray.get(length);
                com.google.common.cache.c<K, V> cVar2 = cVar;
                while (true) {
                    if (cVar2 == null) {
                        break;
                    }
                    K key = cVar2.getKey();
                    if (cVar2.getHash() != i10 || key == null || !this.map.f9189f.equivalent(k10, key)) {
                        cVar2 = cVar2.getNext();
                    } else if (cVar2.getValueReference() == kVar) {
                        if (kVar.isActive()) {
                            cVar2.setValueReference(kVar.h());
                        } else {
                            atomicReferenceArray.set(length, removeEntryFromChain(cVar, cVar2));
                        }
                        unlock();
                        postWriteCleanup();
                        return true;
                    }
                }
                unlock();
                postWriteCleanup();
                return false;
            } catch (Throwable th2) {
                unlock();
                postWriteCleanup();
                throw th2;
            }
        }

        @CheckForNull
        @GuardedBy("this")
        public com.google.common.cache.c<K, V> removeValueFromChain(com.google.common.cache.c<K, V> cVar, com.google.common.cache.c<K, V> cVar2, @CheckForNull K k10, int i10, V v10, s<K, V> sVar, RemovalCause removalCause) {
            enqueueNotification(k10, i10, v10, sVar.c(), removalCause);
            this.writeQueue.remove(cVar2);
            this.accessQueue.remove(cVar2);
            if (!sVar.isLoading()) {
                return removeEntryFromChain(cVar, cVar2);
            }
            sVar.b(null);
            return cVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0072, code lost:
        
            return false;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean replace(K r18, int r19, V r20, V r21) {
            /*
                r17 = this;
                r9 = r17
                r0 = r19
                r17.lock()
                com.google.common.cache.LocalCache<K, V> r1 = r9.map     // Catch: java.lang.Throwable -> L6a
                b5.b0 r1 = r1.f9200q     // Catch: java.lang.Throwable -> L6a
                long r7 = r1.a()     // Catch: java.lang.Throwable -> L6a
                r9.preWriteCleanup(r7)     // Catch: java.lang.Throwable -> L6a
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.c<K, V>> r10 = r9.table     // Catch: java.lang.Throwable -> L6a
                int r1 = r10.length()     // Catch: java.lang.Throwable -> L6a
                r11 = 1
                int r1 = r1 - r11
                r12 = r0 & r1
                java.lang.Object r1 = r10.get(r12)     // Catch: java.lang.Throwable -> L6a
                r2 = r1
                com.google.common.cache.c r2 = (com.google.common.cache.c) r2     // Catch: java.lang.Throwable -> L6a
                r13 = r2
            L24:
                r14 = 0
                if (r13 == 0) goto L6c
                java.lang.Object r4 = r13.getKey()     // Catch: java.lang.Throwable -> L6a
                int r1 = r13.getHash()     // Catch: java.lang.Throwable -> L6a
                if (r1 != r0) goto Lb1
                if (r4 == 0) goto Lb1
                com.google.common.cache.LocalCache<K, V> r1 = r9.map     // Catch: java.lang.Throwable -> L6a
                com.google.common.base.Equivalence<java.lang.Object> r1 = r1.f9189f     // Catch: java.lang.Throwable -> L6a
                r15 = r18
                boolean r1 = r1.equivalent(r15, r4)     // Catch: java.lang.Throwable -> L6a
                if (r1 == 0) goto Lae
                com.google.common.cache.LocalCache$s r16 = r13.getValueReference()     // Catch: java.lang.Throwable -> L6a
                java.lang.Object r6 = r16.get()     // Catch: java.lang.Throwable -> L6a
                if (r6 != 0) goto L73
                boolean r1 = r16.isActive()     // Catch: java.lang.Throwable -> L6a
                if (r1 == 0) goto L6c
                int r1 = r9.modCount     // Catch: java.lang.Throwable -> L6a
                int r1 = r1 + r11
                r9.modCount = r1     // Catch: java.lang.Throwable -> L6a
                com.google.common.cache.RemovalCause r8 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> L6a
                r1 = r17
                r3 = r13
                r5 = r19
                r7 = r16
                com.google.common.cache.c r0 = r1.removeValueFromChain(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L6a
                int r1 = r9.count     // Catch: java.lang.Throwable -> L6a
                int r1 = r1 - r11
                r10.set(r12, r0)     // Catch: java.lang.Throwable -> L6a
                r9.count = r1     // Catch: java.lang.Throwable -> L6a
                goto L6c
            L6a:
                r0 = move-exception
                goto Lba
            L6c:
                r17.unlock()
                r17.postWriteCleanup()
                return r14
            L73:
                com.google.common.cache.LocalCache<K, V> r1 = r9.map     // Catch: java.lang.Throwable -> L6a
                com.google.common.base.Equivalence<java.lang.Object> r1 = r1.f9190g     // Catch: java.lang.Throwable -> L6a
                r3 = r20
                boolean r1 = r1.equivalent(r3, r6)     // Catch: java.lang.Throwable -> L6a
                if (r1 == 0) goto Laa
                int r1 = r9.modCount     // Catch: java.lang.Throwable -> L6a
                int r1 = r1 + r11
                r9.modCount = r1     // Catch: java.lang.Throwable -> L6a
                int r5 = r16.c()     // Catch: java.lang.Throwable -> L6a
                com.google.common.cache.RemovalCause r10 = com.google.common.cache.RemovalCause.REPLACED     // Catch: java.lang.Throwable -> L6a
                r1 = r17
                r2 = r18
                r3 = r19
                r4 = r6
                r6 = r10
                r1.enqueueNotification(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L6a
                r1 = r17
                r2 = r13
                r3 = r18
                r4 = r21
                r5 = r7
                r1.setValue(r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L6a
                r9.evictEntries(r13)     // Catch: java.lang.Throwable -> L6a
                r17.unlock()
                r17.postWriteCleanup()
                return r11
            Laa:
                r9.recordLockedRead(r13, r7)     // Catch: java.lang.Throwable -> L6a
                goto L6c
            Lae:
                r3 = r20
                goto Lb4
            Lb1:
                r15 = r18
                goto Lae
            Lb4:
                com.google.common.cache.c r13 = r13.getNext()     // Catch: java.lang.Throwable -> L6a
                goto L24
            Lba:
                r17.unlock()
                r17.postWriteCleanup()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.replace(java.lang.Object, int, java.lang.Object, java.lang.Object):boolean");
        }

        public void runLockedCleanup(long j10) {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                    expireEntries(j10);
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        public void runUnlockedCleanup() {
            if (isHeldByCurrentThread()) {
                return;
            }
            this.map.H();
        }

        public V scheduleRefresh(com.google.common.cache.c<K, V> cVar, K k10, int i10, V v10, long j10, CacheLoader<? super K, V> cacheLoader) {
            V refresh;
            return (!this.map.O() || j10 - cVar.getWriteTime() <= this.map.f9197n || cVar.getValueReference().isLoading() || (refresh = refresh(k10, i10, cacheLoader, true)) == null) ? v10 : refresh;
        }

        @GuardedBy("this")
        public void setValue(com.google.common.cache.c<K, V> cVar, K k10, V v10, long j10) {
            s<K, V> valueReference = cVar.getValueReference();
            int weigh = this.map.f9194k.weigh(k10, v10);
            b5.u.h0(weigh >= 0, "Weights must be non-negative");
            cVar.setValueReference(this.map.f9192i.referenceValue(this, cVar, v10, weigh));
            recordWrite(cVar, weigh, j10);
            valueReference.b(v10);
        }

        public boolean storeLoadedValue(K k10, int i10, k<K, V> kVar, V v10) {
            lock();
            try {
                long a10 = this.map.f9200q.a();
                preWriteCleanup(a10);
                int i11 = this.count + 1;
                if (i11 > this.threshold) {
                    expand();
                    i11 = this.count + 1;
                }
                int i12 = i11;
                AtomicReferenceArray<com.google.common.cache.c<K, V>> atomicReferenceArray = this.table;
                int length = i10 & (atomicReferenceArray.length() - 1);
                com.google.common.cache.c<K, V> cVar = atomicReferenceArray.get(length);
                com.google.common.cache.c<K, V> cVar2 = cVar;
                while (true) {
                    if (cVar2 == null) {
                        this.modCount++;
                        com.google.common.cache.c<K, V> newEntry = newEntry(k10, i10, cVar);
                        setValue(newEntry, k10, v10, a10);
                        atomicReferenceArray.set(length, newEntry);
                        this.count = i12;
                        evictEntries(newEntry);
                        break;
                    }
                    K key = cVar2.getKey();
                    if (cVar2.getHash() == i10 && key != null && this.map.f9189f.equivalent(k10, key)) {
                        s<K, V> valueReference = cVar2.getValueReference();
                        V v11 = valueReference.get();
                        if (kVar != valueReference && (v11 != null || valueReference == LocalCache.D)) {
                            enqueueNotification(k10, i10, v10, 0, RemovalCause.REPLACED);
                            unlock();
                            postWriteCleanup();
                            return false;
                        }
                        this.modCount++;
                        if (kVar.isActive()) {
                            enqueueNotification(k10, i10, v11, kVar.c(), v11 == null ? RemovalCause.COLLECTED : RemovalCause.REPLACED);
                            i12--;
                        }
                        setValue(cVar2, k10, v10, a10);
                        this.count = i12;
                        evictEntries(cVar2);
                    } else {
                        cVar2 = cVar2.getNext();
                    }
                }
                unlock();
                postWriteCleanup();
                return true;
            } catch (Throwable th2) {
                unlock();
                postWriteCleanup();
                throw th2;
            }
        }

        public void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        public void tryExpireEntries(long j10) {
            if (tryLock()) {
                try {
                    expireEntries(j10);
                } finally {
                    unlock();
                }
            }
        }

        public V waitForLoadingValue(com.google.common.cache.c<K, V> cVar, K k10, s<K, V> sVar) throws ExecutionException {
            if (!sVar.isLoading()) {
                throw new AssertionError();
            }
            b5.u.x0(!Thread.holdsLock(cVar), "Recursive load of: %s", k10);
            try {
                V e10 = sVar.e();
                if (e10 != null) {
                    recordRead(cVar, this.map.f9200q.a());
                    return e10;
                }
                String valueOf = String.valueOf(k10);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 35);
                sb2.append("CacheLoader returned null for key ");
                sb2.append(valueOf);
                sb2.append(p1.b.f29697h);
                throw new CacheLoader.InvalidCacheLoadException(sb2.toString());
            } finally {
                this.statsCounter.b(1);
            }
        }

        @CheckForNull
        public V get(Object obj, int i10) {
            try {
                if (this.count != 0) {
                    long a10 = this.map.f9200q.a();
                    com.google.common.cache.c<K, V> liveEntry = getLiveEntry(obj, i10, a10);
                    if (liveEntry == null) {
                        return null;
                    }
                    V v10 = liveEntry.getValueReference().get();
                    if (v10 != null) {
                        recordRead(liveEntry, a10);
                        return scheduleRefresh(liveEntry, liveEntry.getKey(), i10, v10, a10, this.map.f9203t);
                    }
                    tryDrainReferenceQueues();
                }
                return null;
            } finally {
                postReadCleanup();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
        
            r10 = r6.getValueReference();
            r9 = r10.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0048, code lost:
        
            if (r12.map.f9190g.equivalent(r15, r9) == false) goto L94;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x004a, code lost:
        
            r13 = com.google.common.cache.RemovalCause.EXPLICIT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0059, code lost:
        
            r12.modCount++;
            r14 = removeValueFromChain(r5, r6, r7, r14, r9, r10, r13);
            r15 = r12.count - 1;
            r0.set(r1, r14);
            r12.count = r15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x006f, code lost:
        
            if (r13 != com.google.common.cache.RemovalCause.EXPLICIT) goto L101;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0072, code lost:
        
            r2 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0073, code lost:
        
            unlock();
            postWriteCleanup();
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0079, code lost:
        
            return r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x004f, code lost:
        
            if (r9 != null) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0055, code lost:
        
            if (r10.isActive() == false) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0057, code lost:
        
            r13 = com.google.common.cache.RemovalCause.COLLECTED;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean remove(java.lang.Object r13, int r14, java.lang.Object r15) {
            /*
                r12 = this;
                r12.lock()
                com.google.common.cache.LocalCache<K, V> r0 = r12.map     // Catch: java.lang.Throwable -> L4d
                b5.b0 r0 = r0.f9200q     // Catch: java.lang.Throwable -> L4d
                long r0 = r0.a()     // Catch: java.lang.Throwable -> L4d
                r12.preWriteCleanup(r0)     // Catch: java.lang.Throwable -> L4d
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.c<K, V>> r0 = r12.table     // Catch: java.lang.Throwable -> L4d
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L4d
                r2 = 1
                int r1 = r1 - r2
                r1 = r1 & r14
                java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> L4d
                r5 = r3
                com.google.common.cache.c r5 = (com.google.common.cache.c) r5     // Catch: java.lang.Throwable -> L4d
                r6 = r5
            L1f:
                r3 = 0
                if (r6 == 0) goto L7a
                java.lang.Object r7 = r6.getKey()     // Catch: java.lang.Throwable -> L4d
                int r4 = r6.getHash()     // Catch: java.lang.Throwable -> L4d
                if (r4 != r14) goto L81
                if (r7 == 0) goto L81
                com.google.common.cache.LocalCache<K, V> r4 = r12.map     // Catch: java.lang.Throwable -> L4d
                com.google.common.base.Equivalence<java.lang.Object> r4 = r4.f9189f     // Catch: java.lang.Throwable -> L4d
                boolean r4 = r4.equivalent(r13, r7)     // Catch: java.lang.Throwable -> L4d
                if (r4 == 0) goto L81
                com.google.common.cache.LocalCache$s r10 = r6.getValueReference()     // Catch: java.lang.Throwable -> L4d
                java.lang.Object r9 = r10.get()     // Catch: java.lang.Throwable -> L4d
                com.google.common.cache.LocalCache<K, V> r13 = r12.map     // Catch: java.lang.Throwable -> L4d
                com.google.common.base.Equivalence<java.lang.Object> r13 = r13.f9190g     // Catch: java.lang.Throwable -> L4d
                boolean r13 = r13.equivalent(r15, r9)     // Catch: java.lang.Throwable -> L4d
                if (r13 == 0) goto L4f
                com.google.common.cache.RemovalCause r13 = com.google.common.cache.RemovalCause.EXPLICIT     // Catch: java.lang.Throwable -> L4d
                goto L59
            L4d:
                r13 = move-exception
                goto L86
            L4f:
                if (r9 != 0) goto L7a
                boolean r13 = r10.isActive()     // Catch: java.lang.Throwable -> L4d
                if (r13 == 0) goto L7a
                com.google.common.cache.RemovalCause r13 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> L4d
            L59:
                int r15 = r12.modCount     // Catch: java.lang.Throwable -> L4d
                int r15 = r15 + r2
                r12.modCount = r15     // Catch: java.lang.Throwable -> L4d
                r4 = r12
                r8 = r14
                r11 = r13
                com.google.common.cache.c r14 = r4.removeValueFromChain(r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L4d
                int r15 = r12.count     // Catch: java.lang.Throwable -> L4d
                int r15 = r15 - r2
                r0.set(r1, r14)     // Catch: java.lang.Throwable -> L4d
                r12.count = r15     // Catch: java.lang.Throwable -> L4d
                com.google.common.cache.RemovalCause r14 = com.google.common.cache.RemovalCause.EXPLICIT     // Catch: java.lang.Throwable -> L4d
                if (r13 != r14) goto L72
                goto L73
            L72:
                r2 = 0
            L73:
                r12.unlock()
                r12.postWriteCleanup()
                return r2
            L7a:
                r12.unlock()
                r12.postWriteCleanup()
                return r3
            L81:
                com.google.common.cache.c r6 = r6.getNext()     // Catch: java.lang.Throwable -> L4d
                goto L1f
            L86:
                r12.unlock()
                r12.postWriteCleanup()
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.remove(java.lang.Object, int, java.lang.Object):boolean");
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0075, code lost:
        
            return null;
         */
        @javax.annotation.CheckForNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public V replace(K r18, int r19, V r20) {
            /*
                r17 = this;
                r9 = r17
                r0 = r19
                r17.lock()
                com.google.common.cache.LocalCache<K, V> r1 = r9.map     // Catch: java.lang.Throwable -> L6d
                b5.b0 r1 = r1.f9200q     // Catch: java.lang.Throwable -> L6d
                long r7 = r1.a()     // Catch: java.lang.Throwable -> L6d
                r9.preWriteCleanup(r7)     // Catch: java.lang.Throwable -> L6d
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.c<K, V>> r10 = r9.table     // Catch: java.lang.Throwable -> L6d
                int r1 = r10.length()     // Catch: java.lang.Throwable -> L6d
                int r1 = r1 + (-1)
                r11 = r0 & r1
                java.lang.Object r1 = r10.get(r11)     // Catch: java.lang.Throwable -> L6d
                r2 = r1
                com.google.common.cache.c r2 = (com.google.common.cache.c) r2     // Catch: java.lang.Throwable -> L6d
                r12 = r2
            L24:
                r13 = 0
                if (r12 == 0) goto L6f
                java.lang.Object r4 = r12.getKey()     // Catch: java.lang.Throwable -> L6d
                int r1 = r12.getHash()     // Catch: java.lang.Throwable -> L6d
                if (r1 != r0) goto La2
                if (r4 == 0) goto La2
                com.google.common.cache.LocalCache<K, V> r1 = r9.map     // Catch: java.lang.Throwable -> L6d
                com.google.common.base.Equivalence<java.lang.Object> r1 = r1.f9189f     // Catch: java.lang.Throwable -> L6d
                r14 = r18
                boolean r1 = r1.equivalent(r14, r4)     // Catch: java.lang.Throwable -> L6d
                if (r1 == 0) goto La4
                com.google.common.cache.LocalCache$s r15 = r12.getValueReference()     // Catch: java.lang.Throwable -> L6d
                java.lang.Object r16 = r15.get()     // Catch: java.lang.Throwable -> L6d
                if (r16 != 0) goto L76
                boolean r1 = r15.isActive()     // Catch: java.lang.Throwable -> L6d
                if (r1 == 0) goto L6f
                int r1 = r9.modCount     // Catch: java.lang.Throwable -> L6d
                int r1 = r1 + 1
                r9.modCount = r1     // Catch: java.lang.Throwable -> L6d
                com.google.common.cache.RemovalCause r8 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> L6d
                r1 = r17
                r3 = r12
                r5 = r19
                r6 = r16
                r7 = r15
                com.google.common.cache.c r0 = r1.removeValueFromChain(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L6d
                int r1 = r9.count     // Catch: java.lang.Throwable -> L6d
                int r1 = r1 + (-1)
                r10.set(r11, r0)     // Catch: java.lang.Throwable -> L6d
                r9.count = r1     // Catch: java.lang.Throwable -> L6d
                goto L6f
            L6d:
                r0 = move-exception
                goto Laa
            L6f:
                r17.unlock()
                r17.postWriteCleanup()
                return r13
            L76:
                int r1 = r9.modCount     // Catch: java.lang.Throwable -> L6d
                int r1 = r1 + 1
                r9.modCount = r1     // Catch: java.lang.Throwable -> L6d
                int r5 = r15.c()     // Catch: java.lang.Throwable -> L6d
                com.google.common.cache.RemovalCause r6 = com.google.common.cache.RemovalCause.REPLACED     // Catch: java.lang.Throwable -> L6d
                r1 = r17
                r2 = r18
                r3 = r19
                r4 = r16
                r1.enqueueNotification(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L6d
                r1 = r17
                r2 = r12
                r3 = r18
                r4 = r20
                r5 = r7
                r1.setValue(r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L6d
                r9.evictEntries(r12)     // Catch: java.lang.Throwable -> L6d
                r17.unlock()
                r17.postWriteCleanup()
                return r16
            La2:
                r14 = r18
            La4:
                com.google.common.cache.c r12 = r12.getNext()     // Catch: java.lang.Throwable -> L6d
                goto L24
            Laa:
                r17.unlock()
                r17.postWriteCleanup()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.replace(java.lang.Object, int, java.lang.Object):java.lang.Object");
        }
    }
}
