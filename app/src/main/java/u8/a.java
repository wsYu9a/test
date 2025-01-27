package u8;

import ba.i;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import okhttp3.FormBody;
import okhttp3.RequestBody;

/* loaded from: classes3.dex */
public class a {
    public static String a(b bVar, String str) {
        return g(bVar, str, v8.c.class, v8.a.class);
    }

    public static TreeMap<String, String> b(b bVar, String str) {
        return c(bVar, str, true);
    }

    public static TreeMap<String, String> c(b bVar, String str, boolean z10) {
        return f(bVar, str, z10, v8.a.class);
    }

    public static String d(b bVar, String str) {
        return g(bVar, str, v8.a.class);
    }

    public static TreeMap<String, String> e(b bVar, String str, boolean z10) {
        return f(bVar, str, z10, v8.a.class, v8.c.class);
    }

    public static TreeMap<String, String> f(b bVar, String str, boolean z10, Class<? extends Annotation>... clsArr) {
        TreeMap<String, String> treeMap = new TreeMap<>();
        Iterator<Field> it = i.a(bVar.getClass()).iterator();
        while (it.hasNext()) {
            Field next = it.next();
            int length = clsArr.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                if (next.getAnnotation(clsArr[i10]) != null) {
                    try {
                        next.setAccessible(true);
                        if (next.get(bVar) == null) {
                            continue;
                        } else {
                            if (next.getType() != Integer.class && next.getType() != Integer.TYPE) {
                                if (next.getType() != Long.class && next.getType() != Long.TYPE) {
                                    if (next.getType() == String.class) {
                                        String str2 = (String) next.get(bVar);
                                        String name = next.getName();
                                        if (z10) {
                                            str2 = URLEncoder.encode(str2, str);
                                        }
                                        treeMap.put(name, str2);
                                    } else {
                                        if (next.getType() != Boolean.class && next.getType() != Boolean.TYPE) {
                                            if (next.getType() != Character.class && next.getType() != Character.TYPE) {
                                                throw new RuntimeException("type must be String or Integer ");
                                            }
                                            String str3 = next.get(bVar) + "";
                                            String name2 = next.getName();
                                            if (z10) {
                                                str3 = URLEncoder.encode(str3, str);
                                            }
                                            treeMap.put(name2, str3);
                                        }
                                        treeMap.put(next.getName(), String.valueOf(next.get(bVar)));
                                    }
                                }
                                treeMap.put(next.getName(), String.valueOf(next.get(bVar)));
                            }
                            treeMap.put(next.getName(), String.valueOf(next.get(bVar)));
                        }
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                } else {
                    i10++;
                }
            }
        }
        return treeMap;
    }

    public static String g(b bVar, String str, Class<? extends Annotation>... clsArr) {
        TreeMap treeMap = new TreeMap();
        Iterator<Field> it = i.a(bVar.getClass()).iterator();
        while (true) {
            int i10 = 0;
            if (!it.hasNext()) {
                StringBuilder sb2 = new StringBuilder();
                for (Map.Entry entry : treeMap.entrySet()) {
                    sb2.append((String) entry.getKey());
                    sb2.append("=");
                    sb2.append((String) entry.getValue());
                    sb2.append("&");
                }
                return sb2.length() == 0 ? "" : sb2.substring(0, sb2.length() - 1);
            }
            Field next = it.next();
            int length = clsArr.length;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                if (next.getAnnotation(clsArr[i10]) != null) {
                    try {
                        next.setAccessible(true);
                        if (next.get(bVar) == null) {
                            continue;
                        } else {
                            if (next.getType() != Integer.class && next.getType() != Integer.TYPE) {
                                if (next.getType() != Long.class && next.getType() != Long.TYPE) {
                                    if (next.getType() == String.class) {
                                        treeMap.put(next.getName(), URLEncoder.encode((String) next.get(bVar), str));
                                    } else {
                                        if (next.getType() != Boolean.class && next.getType() != Boolean.TYPE) {
                                            if (next.getType() != Character.class && next.getType() != Character.TYPE) {
                                                throw new RuntimeException("type must be String or Integer ");
                                            }
                                            treeMap.put(next.getName(), URLEncoder.encode("" + next.get(bVar), str));
                                        }
                                        treeMap.put(next.getName(), String.valueOf(next.get(bVar)));
                                    }
                                }
                                treeMap.put(next.getName(), String.valueOf(next.get(bVar)));
                            }
                            treeMap.put(next.getName(), String.valueOf(next.get(bVar)));
                        }
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                } else {
                    i10++;
                }
            }
        }
    }

    public static RequestBody h(b bVar, String str) {
        return i(bVar, str, v8.c.class);
    }

    public static RequestBody i(b bVar, String str, Class<? extends Annotation>... clsArr) {
        TreeMap treeMap = new TreeMap();
        Iterator<Field> it = i.a(bVar.getClass()).iterator();
        while (it.hasNext()) {
            Field next = it.next();
            int length = clsArr.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                if (next.getAnnotation(clsArr[i10]) != null) {
                    try {
                        next.setAccessible(true);
                        if (next.get(bVar) == null) {
                            continue;
                        } else {
                            if (next.getType() != Integer.class && next.getType() != Integer.TYPE) {
                                if (next.getType() != Long.class && next.getType() != Long.TYPE) {
                                    if (next.getType() == String.class) {
                                        treeMap.put(next.getName(), (String) next.get(bVar));
                                    } else {
                                        if (next.getType() != Boolean.class && next.getType() != Boolean.TYPE) {
                                            if (next.getType() != Character.class && next.getType() != Character.TYPE) {
                                                throw new RuntimeException("type must be String or Integer ");
                                            }
                                            treeMap.put(next.getName(), "" + next.get(bVar));
                                        }
                                        treeMap.put(next.getName(), String.valueOf(next.get(bVar)));
                                    }
                                }
                                treeMap.put(next.getName(), String.valueOf(next.get(bVar)));
                            }
                            treeMap.put(next.getName(), String.valueOf(next.get(bVar)));
                        }
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                } else {
                    i10++;
                }
            }
        }
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry entry : treeMap.entrySet()) {
            builder.add((String) entry.getKey(), (String) entry.getValue());
        }
        return builder.build();
    }
}
