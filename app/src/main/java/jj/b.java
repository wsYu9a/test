package jj;

import com.umeng.analytics.pro.f;
import hj.d;
import java.util.Collections;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.threeten.bp.zone.ZoneRules;
import org.threeten.bp.zone.ZoneRulesException;

/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: a */
    public static final CopyOnWriteArrayList<b> f27584a = new CopyOnWriteArrayList<>();

    /* renamed from: b */
    public static final ConcurrentMap<String, b> f27585b = new ConcurrentHashMap(512, 0.75f, 2);

    static {
        a.a();
    }

    public static Set<String> a() {
        return Collections.unmodifiableSet(f27585b.keySet());
    }

    public static b b(String str) {
        ConcurrentMap<String, b> concurrentMap = f27585b;
        b bVar = concurrentMap.get(str);
        if (bVar != null) {
            return bVar;
        }
        if (concurrentMap.isEmpty()) {
            throw new ZoneRulesException("No time-zone data files registered");
        }
        throw new ZoneRulesException("Unknown time-zone ID: " + str);
    }

    public static ZoneRules c(String str, boolean z10) {
        d.j(str, "zoneId");
        return b(str).f(str, z10);
    }

    public static NavigableMap<String, ZoneRules> d(String str) {
        d.j(str, "zoneId");
        return b(str).g(str);
    }

    public static boolean i() {
        Iterator<b> it = f27584a.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            z10 |= it.next().e();
        }
        return z10;
    }

    public static void j(b bVar) {
        d.j(bVar, f.M);
        k(bVar);
        f27584a.add(bVar);
    }

    public static void k(b bVar) {
        for (String str : bVar.h()) {
            d.j(str, "zoneId");
            if (f27585b.putIfAbsent(str, bVar) != null) {
                throw new ZoneRulesException("Unable to register zone as one already registered with that ID: " + str + ", currently loading from provider: " + bVar);
            }
        }
    }

    public boolean e() {
        return false;
    }

    public abstract ZoneRules f(String str, boolean z10);

    public abstract NavigableMap<String, ZoneRules> g(String str);

    public abstract Set<String> h();
}
