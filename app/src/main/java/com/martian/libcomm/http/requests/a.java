package com.martian.libcomm.http.requests;

import com.martian.libsupport.g;
import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;

/* loaded from: classes2.dex */
public class a {
    public static String a(b params, String charset) {
        return g(params, charset, com.martian.libcomm.http.requests.d.c.class, com.martian.libcomm.http.requests.d.a.class);
    }

    public static TreeMap<String, String> b(b params, String charset) {
        return c(params, charset, true);
    }

    public static TreeMap<String, String> c(b params, String charset, boolean urlencode) {
        return f(params, charset, urlencode, com.martian.libcomm.http.requests.d.a.class);
    }

    public static String d(b params, String charset) {
        return g(params, charset, com.martian.libcomm.http.requests.d.a.class);
    }

    public static TreeMap<String, String> e(b params, String charset, boolean urlencode) {
        return f(params, charset, urlencode, com.martian.libcomm.http.requests.d.a.class, com.martian.libcomm.http.requests.d.c.class);
    }

    public static TreeMap<String, String> f(b params, String charset, boolean urlencode, Class<? extends Annotation>... anotationclasses) {
        TreeMap<String, String> treeMap = new TreeMap<>();
        Iterator<Field> it = g.a(params.getClass()).iterator();
        while (it.hasNext()) {
            Field next = it.next();
            int length = anotationclasses.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (next.getAnnotation(anotationclasses[i2]) != null) {
                    try {
                        next.setAccessible(true);
                        if (next.get(params) == null) {
                            continue;
                        } else {
                            if (next.getType() != Integer.class && next.getType() != Integer.TYPE) {
                                if (next.getType() != Long.class && next.getType() != Long.TYPE) {
                                    if (next.getType() == String.class) {
                                        String str = (String) next.get(params);
                                        String name = next.getName();
                                        if (urlencode) {
                                            str = URLEncoder.encode(str, charset);
                                        }
                                        treeMap.put(name, str);
                                    } else {
                                        if (next.getType() != Boolean.class && next.getType() != Boolean.TYPE) {
                                            if (next.getType() != Character.class && next.getType() != Character.TYPE) {
                                                throw new RuntimeException("type must be String or Integer ");
                                            }
                                            String str2 = next.get(params) + "";
                                            String name2 = next.getName();
                                            if (urlencode) {
                                                str2 = URLEncoder.encode(str2, charset);
                                            }
                                            treeMap.put(name2, str2);
                                        }
                                        treeMap.put(next.getName(), String.valueOf(next.get(params)));
                                    }
                                }
                                treeMap.put(next.getName(), String.valueOf(next.get(params)));
                            }
                            treeMap.put(next.getName(), String.valueOf(next.get(params)));
                        }
                    } catch (Exception unused) {
                    }
                } else {
                    i2++;
                }
            }
        }
        return treeMap;
    }

    public static String g(b params, String charset, Class<? extends Annotation>... anotationclasses) {
        TreeMap treeMap = new TreeMap();
        Iterator<Field> it = g.a(params.getClass()).iterator();
        while (true) {
            int i2 = 0;
            if (!it.hasNext()) {
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : treeMap.entrySet()) {
                    sb.append((String) entry.getKey());
                    sb.append("=");
                    sb.append((String) entry.getValue());
                    sb.append("&");
                }
                return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
            }
            Field next = it.next();
            int length = anotationclasses.length;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (next.getAnnotation(anotationclasses[i2]) != null) {
                    try {
                        next.setAccessible(true);
                        if (next.get(params) == null) {
                            continue;
                        } else {
                            if (next.getType() != Integer.class && next.getType() != Integer.TYPE) {
                                if (next.getType() != Long.class && next.getType() != Long.TYPE) {
                                    if (next.getType() == String.class) {
                                        treeMap.put(next.getName(), URLEncoder.encode((String) next.get(params), charset));
                                    } else {
                                        if (next.getType() != Boolean.class && next.getType() != Boolean.TYPE) {
                                            if (next.getType() != Character.class && next.getType() != Character.TYPE) {
                                                throw new RuntimeException("type must be String or Integer ");
                                            }
                                            treeMap.put(next.getName(), URLEncoder.encode("" + next.get(params), charset));
                                        }
                                        treeMap.put(next.getName(), String.valueOf(next.get(params)));
                                    }
                                }
                                treeMap.put(next.getName(), String.valueOf(next.get(params)));
                            }
                            treeMap.put(next.getName(), String.valueOf(next.get(params)));
                        }
                    } catch (Exception unused) {
                    }
                } else {
                    i2++;
                }
            }
        }
    }

    public static MultipartEntity h(b params, String contentType, String charset) {
        MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
        Iterator<Field> it = g.a(params.getClass()).iterator();
        while (it.hasNext()) {
            Field next = it.next();
            if (next.getAnnotation(com.martian.libcomm.http.requests.d.b.class) != null) {
                try {
                    next.setAccessible(true);
                    if (next.get(params) == null) {
                        continue;
                    } else {
                        if (next.getType() != Integer.class && next.getType() != Integer.TYPE) {
                            if (next.getType() == String.class) {
                                multipartEntity.addPart(next.getName(), new StringBody(URLEncoder.encode((String) next.get(params), charset)));
                            } else {
                                if (next.getType() != File.class) {
                                    throw new RuntimeException("type must be String File or Integer ");
                                }
                                multipartEntity.addPart(next.getName(), new FileBody((File) next.get(params), contentType));
                            }
                        }
                        multipartEntity.addPart(next.getName(), new StringBody(String.valueOf(next.get(params))));
                    }
                } catch (Exception unused) {
                }
            }
        }
        return multipartEntity;
    }

    public static RequestBody i(b params, String charset) {
        return j(params, charset, com.martian.libcomm.http.requests.d.c.class);
    }

    public static RequestBody j(b params, String charset, Class<? extends Annotation>... anotationclasses) {
        TreeMap treeMap = new TreeMap();
        Iterator<Field> it = g.a(params.getClass()).iterator();
        while (it.hasNext()) {
            Field next = it.next();
            int length = anotationclasses.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (next.getAnnotation(anotationclasses[i2]) != null) {
                    try {
                        next.setAccessible(true);
                        if (next.get(params) == null) {
                            continue;
                        } else {
                            if (next.getType() != Integer.class && next.getType() != Integer.TYPE) {
                                if (next.getType() != Long.class && next.getType() != Long.TYPE) {
                                    if (next.getType() == String.class) {
                                        treeMap.put(next.getName(), (String) next.get(params));
                                    } else {
                                        if (next.getType() != Boolean.class && next.getType() != Boolean.TYPE) {
                                            if (next.getType() != Character.class && next.getType() != Character.TYPE) {
                                                throw new RuntimeException("type must be String or Integer ");
                                            }
                                            treeMap.put(next.getName(), "" + next.get(params));
                                        }
                                        treeMap.put(next.getName(), String.valueOf(next.get(params)));
                                    }
                                }
                                treeMap.put(next.getName(), String.valueOf(next.get(params)));
                            }
                            treeMap.put(next.getName(), String.valueOf(next.get(params)));
                        }
                    } catch (Exception unused) {
                    }
                } else {
                    i2++;
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
