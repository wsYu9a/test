package com.opos.mobad.l;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes4.dex */
public class o {

    /* renamed from: a */
    private Map<Integer, Set<Integer>> f21223a;

    /* renamed from: b */
    private AtomicInteger f21224b;

    /* renamed from: c */
    private ReentrantReadWriteLock f21225c = new ReentrantReadWriteLock();

    public static class a {

        /* renamed from: a */
        private int f21226a;

        /* renamed from: b */
        private Map<Integer, Set<Integer>> f21227b = new HashMap();

        public a(int i2) {
            this.f21226a = i2;
        }

        public a a(int i2, int i3) {
            Set<Integer> set = this.f21227b.get(Integer.valueOf(i2));
            if (set == null) {
                set = new HashSet<>();
                this.f21227b.put(Integer.valueOf(i2), set);
            }
            set.add(Integer.valueOf(i3));
            return this;
        }

        public a a(int i2, int... iArr) {
            if (iArr != null) {
                Set<Integer> set = this.f21227b.get(Integer.valueOf(i2));
                if (set == null) {
                    set = new HashSet<>();
                    this.f21227b.put(Integer.valueOf(i2), set);
                }
                for (int i3 : iArr) {
                    set.add(Integer.valueOf(i3));
                }
            }
            return this;
        }

        public o a() {
            return new o(this.f21226a, this.f21227b);
        }
    }

    protected o(int i2, Map<Integer, Set<Integer>> map) {
        this.f21224b = new AtomicInteger(i2);
        a(map);
    }

    private int a(int i2, int i3, Callable<Boolean> callable) {
        try {
            if (!callable.call().booleanValue()) {
                a("execute fail");
                return i2;
            }
            if (!this.f21224b.compareAndSet(i2, i3)) {
                a("unexpected fail");
                b();
            }
            return i3;
        } catch (Exception e2) {
            a("call exception :" + e2);
            return i2;
        }
    }

    private static final void a(String str) {
        com.opos.cmn.an.f.a.b("SyncStateController", str);
    }

    private void a(Map<Integer, Set<Integer>> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.f21223a = new HashMap();
        for (Integer num : map.keySet()) {
            Set<Integer> set = map.get(num);
            if (set != null && !set.isEmpty()) {
                this.f21223a.put(num, new HashSet(map.get(num)));
            }
        }
    }

    private void b() {
    }

    private boolean b(int i2, int i3) {
        String str;
        Map<Integer, Set<Integer>> map = this.f21223a;
        if (map == null) {
            str = "checkEnable but mController = null";
        } else if (!map.containsKey(Integer.valueOf(i2))) {
            str = "checkEnable but error current state:" + i2;
        } else {
            if (this.f21223a.get(Integer.valueOf(i2)).contains(Integer.valueOf(i3))) {
                return true;
            }
            str = "checkEnable but error next state:" + i2 + ",to:" + i3;
        }
        a(str);
        return false;
    }

    public int a() {
        return this.f21224b.get();
    }

    public int a(int i2) {
        a("changeToState:" + i2);
        try {
            this.f21225c.readLock().lock();
            int i3 = this.f21224b.get();
            if (i3 != i2) {
                int i4 = 3;
                while (i4 > 0) {
                    if (!b(i3, i2)) {
                        this.f21225c.readLock().unlock();
                        return i3;
                    }
                    if (!this.f21224b.compareAndSet(i3, i2)) {
                        i4--;
                        i3 = this.f21224b.get();
                    }
                }
                this.f21225c.readLock().unlock();
                return a(i2, (Callable<Boolean>) null);
            }
            return i2;
        } finally {
            this.f21225c.readLock().unlock();
        }
    }

    public int a(int i2, int i3) {
        AtomicInteger atomicInteger;
        a("changeToStateFrom:" + i2 + ", to:" + i3 + ", mCurrentState:" + this.f21224b.get());
        try {
            this.f21225c.readLock().lock();
            if (this.f21224b.get() == i3) {
                a("changeToStateFrom target equal mCurrentState:" + this.f21224b);
            } else {
                if (!b(i2, i3)) {
                    atomicInteger = this.f21224b;
                } else if (!this.f21224b.compareAndSet(i2, i3)) {
                    atomicInteger = this.f21224b;
                }
                i3 = atomicInteger.get();
            }
            return i3;
        } finally {
            this.f21225c.readLock().unlock();
        }
    }

    public int a(int i2, Callable<Boolean> callable) {
        String str;
        a("changeToStateBy:" + i2 + ", callable = " + callable + ", mCurrentState:" + this.f21224b.get());
        try {
            this.f21225c.writeLock().lock();
            int i3 = this.f21224b.get();
            if (i3 == i2) {
                str = "changeToStateBy but now target:" + i2;
            } else {
                if (b(i3, i2)) {
                    if (callable != null) {
                        i2 = a(i3, i2, callable);
                    } else if (!this.f21224b.compareAndSet(i3, i2)) {
                        b();
                    }
                    return i2;
                }
                str = "changeToStateBy but target is not enable:" + i2;
            }
            a(str);
            return i3;
        } finally {
            this.f21225c.writeLock().unlock();
        }
    }
}
