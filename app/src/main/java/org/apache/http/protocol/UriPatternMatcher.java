package org.apache.http.protocol;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
/* loaded from: classes5.dex */
public class UriPatternMatcher<T> {

    @GuardedBy("this")
    private final Map<String, T> map = new HashMap();

    public synchronized Map<String, T> getObjects() {
        return this.map;
    }

    public synchronized T lookup(String str) {
        T t;
        if (str == null) {
            throw new IllegalArgumentException("Request URI may not be null");
        }
        int indexOf = str.indexOf("?");
        if (indexOf != -1) {
            str = str.substring(0, indexOf);
        }
        t = this.map.get(str);
        if (t == null) {
            String str2 = null;
            for (String str3 : this.map.keySet()) {
                if (matchUriRequestPattern(str3, str) && (str2 == null || str2.length() < str3.length() || (str2.length() == str3.length() && str3.endsWith("*")))) {
                    t = this.map.get(str3);
                    str2 = str3;
                }
            }
        }
        return t;
    }

    protected boolean matchUriRequestPattern(String str, String str2) {
        if (str.equals("*")) {
            return true;
        }
        if (str.endsWith("*") && str2.startsWith(str.substring(0, str.length() - 1))) {
            return true;
        }
        return str.startsWith("*") && str2.endsWith(str.substring(1, str.length()));
    }

    public synchronized void register(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("URI request pattern may not be null");
        }
        this.map.put(str, t);
    }

    @Deprecated
    public synchronized void setHandlers(Map<String, T> map) {
        if (map == null) {
            throw new IllegalArgumentException("Map of handlers may not be null");
        }
        this.map.clear();
        this.map.putAll(map);
    }

    public synchronized void setObjects(Map<String, T> map) {
        if (map == null) {
            throw new IllegalArgumentException("Map of handlers may not be null");
        }
        this.map.clear();
        this.map.putAll(map);
    }

    public synchronized void unregister(String str) {
        if (str == null) {
            return;
        }
        this.map.remove(str);
    }
}
