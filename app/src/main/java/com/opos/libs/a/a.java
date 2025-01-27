package com.opos.libs.a;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    public Map<Integer, Set<Integer>> f19325a;

    /* renamed from: b */
    public AtomicInteger f19326b;

    /* renamed from: c */
    public ReentrantReadWriteLock f19327c = new ReentrantReadWriteLock();

    /* renamed from: com.opos.libs.a.a$a */
    public static class C0418a {

        /* renamed from: a */
        public int f19328a;

        /* renamed from: b */
        public Map<Integer, Set<Integer>> f19329b = new HashMap();

        public C0418a(int i2) {
            this.f19328a = i2;
        }

        public C0418a a(int i2, int i3) {
            Set<Integer> set = this.f19329b.get(Integer.valueOf(i2));
            if (set == null) {
                set = new HashSet<>();
                this.f19329b.put(Integer.valueOf(i2), set);
            }
            set.add(Integer.valueOf(i3));
            return this;
        }

        public C0418a a(int i2, int... iArr) {
            if (iArr != null) {
                Set<Integer> set = this.f19329b.get(Integer.valueOf(i2));
                if (set == null) {
                    set = new HashSet<>();
                    this.f19329b.put(Integer.valueOf(i2), set);
                }
                for (int i3 : iArr) {
                    set.add(Integer.valueOf(i3));
                }
            }
            return this;
        }

        public a a() {
            return new a(this.f19328a, this.f19329b);
        }
    }

    public a(int i2, Map<Integer, Set<Integer>> map) {
        this.f19326b = new AtomicInteger(i2);
        a(map);
    }

    public int a() {
        return this.f19326b.get();
    }

    public int a(int i2) {
        com.opos.cmn.an.f.a.b("SyncStateController", "changeToState:" + i2);
        try {
            this.f19327c.readLock().lock();
            int i3 = this.f19326b.get();
            if (i3 != i2) {
                int i4 = 3;
                while (i4 > 0) {
                    if (!a(i3, i2)) {
                        this.f19327c.readLock().unlock();
                        return i3;
                    }
                    if (!this.f19326b.compareAndSet(i3, i2)) {
                        i4--;
                        i3 = this.f19326b.get();
                    }
                }
                this.f19327c.readLock().unlock();
                return a(i2, (Callable<Boolean>) null);
            }
            return i2;
        } finally {
            this.f19327c.readLock().unlock();
        }
    }

    public int a(int i2, Callable<Boolean> callable) {
        String str;
        com.opos.cmn.an.f.a.b("SyncStateController", "changeToStateBy:" + i2 + ", callable = " + callable + ", mCurrentState:" + this.f19326b.get());
        try {
            this.f19327c.writeLock().lock();
            int i3 = this.f19326b.get();
            if (i3 == i2) {
                str = "changeToStateBy but now target:" + i2;
            } else {
                if (a(i3, i2)) {
                    if (callable == null) {
                        this.f19326b.compareAndSet(i3, i2);
                    } else {
                        try {
                        } catch (Exception e2) {
                            com.opos.cmn.an.f.a.b("SyncStateController", "call exception :" + e2);
                        }
                        if (!callable.call().booleanValue()) {
                            com.opos.cmn.an.f.a.b("SyncStateController", "execute fail");
                            i2 = i3;
                        } else if (!this.f19326b.compareAndSet(i3, i2)) {
                            com.opos.cmn.an.f.a.b("SyncStateController", "unexpected fail");
                        }
                    }
                    return i2;
                }
                str = "changeToStateBy but target is not enable:" + i2;
            }
            com.opos.cmn.an.f.a.b("SyncStateController", str);
            return i3;
        } finally {
            this.f19327c.writeLock().unlock();
        }
    }

    public final void a(Map<Integer, Set<Integer>> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.f19325a = new HashMap();
        for (Integer num : map.keySet()) {
            Set<Integer> set = map.get(num);
            if (set != null && !set.isEmpty()) {
                this.f19325a.put(num, new HashSet(map.get(num)));
            }
        }
    }

    public final boolean a(int i2, int i3) {
        String str;
        Map<Integer, Set<Integer>> map = this.f19325a;
        if (map == null) {
            str = "checkEnable but mController = null";
        } else if (!map.containsKey(Integer.valueOf(i2))) {
            str = "checkEnable but error current state:" + i2;
        } else {
            if (this.f19325a.get(Integer.valueOf(i2)).contains(Integer.valueOf(i3))) {
                return true;
            }
            str = "checkEnable but error next state:" + i2 + ",to:" + i3;
        }
        com.opos.cmn.an.f.a.b("SyncStateController", str);
        return false;
    }
}
