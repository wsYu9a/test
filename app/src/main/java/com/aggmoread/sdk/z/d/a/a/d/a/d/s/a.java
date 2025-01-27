package com.aggmoread.sdk.z.d.a.a.d.a.d.s;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import com.aggmoread.sdk.z.d.a.a.d.a.d.l;
import com.aggmoread.sdk.z.d.a.a.d.b.j;
import com.aggmoread.sdk.z.d.a.a.e.e;
import com.aggmoread.sdk.z.d.a.a.e.m;
import com.aggmoread.sdk.z.d.a.a.e.n;
import com.aggmoread.sdk.z.d.a.a.e.p;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a extends l {

    /* renamed from: c */
    private static a f5577c;

    /* renamed from: a */
    private final String[] f5578a = {"tt_reward_ad_appname", "tt_reward_ad_appname_backup", "tt_reward_ad_download", "tt_reward_ad_download_backup", "tt_full_ad_app_name", "tt_full_ad_download"};

    /* renamed from: b */
    private final List<String> f5579b = Arrays.asList("查看详情", "立即查看", "了解一下", "下载打开", "立即下载");

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.s.a$a */
    public class RunnableC0142a implements Runnable {

        /* renamed from: b */
        final /* synthetic */ String[] f5580b;

        /* renamed from: c */
        final /* synthetic */ WebView f5581c;

        /* renamed from: d */
        final /* synthetic */ AtomicInteger f5582d;

        public RunnableC0142a(a aVar, String[] strArr, WebView webView, AtomicInteger atomicInteger) {
            this.f5580b = strArr;
            this.f5581c = webView;
            this.f5582d = atomicInteger;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    this.f5580b[0] = this.f5581c.getTitle();
                } catch (Exception e10) {
                    e.b("XXXXX", "web view title err " + e10.getMessage());
                }
            } finally {
                this.f5582d.incrementAndGet();
            }
        }
    }

    private a() {
    }

    private static View a() {
        try {
            Class<?> cls = Class.forName("android.view.WindowManagerGlobal");
            Object invoke = cls.getDeclaredMethod("getInstance", null).invoke(null, null);
            if (invoke != null) {
                Field declaredField = cls.getDeclaredField("mViews");
                declaredField.setAccessible(true);
                ArrayList arrayList = (ArrayList) declaredField.get(invoke);
                return (View) arrayList.get(arrayList.size() - 1);
            }
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException | Exception e10) {
            e10.printStackTrace();
        }
        return null;
    }

    public static int b(Object obj) {
        int i10 = -1;
        try {
            Object invoke = obj.getClass().getMethod("getMediaExtraInfo", null).invoke(obj, null);
            int intValue = invoke instanceof Map ? ((Integer) ((Map) invoke).get("price")).intValue() : -1;
            if (intValue < 0) {
                try {
                    e.a("csj c -1 ");
                } catch (Exception e10) {
                    i10 = intValue;
                    e = e10;
                    e.a("csj c err " + e);
                    e.a("csj ecpm  " + i10);
                    return i10;
                }
            } else {
                i10 = intValue;
            }
        } catch (Exception e11) {
            e = e11;
        }
        e.a("csj ecpm  " + i10);
        return i10;
    }

    public static synchronized a c() {
        a aVar;
        synchronized (a.class) {
            try {
                if (f5577c == null) {
                    synchronized (a.class) {
                        try {
                            if (f5577c == null) {
                                f5577c = new a();
                            }
                        } finally {
                        }
                    }
                }
                aVar = f5577c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    public String d() {
        return c(a());
    }

    public String e() {
        return c(a());
    }

    public String f(View view) {
        return c(view);
    }

    public static View a(View view, String str) {
        if (a(str, view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View a10 = a(viewGroup.getChildAt(i10), str);
            if (a10 != null) {
                return a10;
            }
        }
        return null;
    }

    private String b() {
        e.b("XXXXX", "tryGetRewardAdName");
        View a10 = a();
        if (a10 == null) {
            e.b("XXXXX", "not found adview");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        a(a10, arrayList);
        if (arrayList.size() > 0) {
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                TextView textView = arrayList.get(i10);
                if (textView != null) {
                    if (sb2.toString().contains(textView.getText().toString())) {
                        e.b("XXXXX", "has contains ,next !,textView " + textView);
                    } else {
                        if (i10 != 0) {
                            sb2.append("#");
                        }
                        sb2.append(textView.getText().toString());
                    }
                }
            }
            String sb3 = sb2.toString();
            e.b("XXXXX", "app name " + sb3);
            return sb3;
        }
        ArrayList arrayList2 = new ArrayList();
        b(a10, arrayList2);
        e.b("XXXXX", "webView size " + arrayList2.size());
        for (int i11 = 0; i11 < arrayList2.size(); i11++) {
            WebView webView = arrayList2.get(i11);
            AtomicInteger atomicInteger = new AtomicInteger();
            String[] strArr = new String[1];
            n.a(new RunnableC0142a(this, strArr, webView, atomicInteger));
            while (atomicInteger.get() == 0) {
                Log.e("XXXXX", "wait ");
            }
            String str = strArr[0];
            Log.e("XXXXX", "title " + str);
            if (!TextUtils.isEmpty(str)) {
                if (!str.startsWith("http:") && !str.startsWith("https:")) {
                    return str;
                }
                if (str.contains("?rit=")) {
                    Map<String, String> a11 = p.a(str);
                    if (a11 != null) {
                        String str2 = a11.get("app_name");
                        Log.e("XXXXX", "appName " + str2 + ",developer_name " + a11.get("developer_name"));
                        return str2;
                    }
                    Log.e("XXXXX", "i " + i11);
                    Log.e("XXXXX", " view " + webView);
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    private String c(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        String b10 = b(view);
        if (TextUtils.isEmpty(b10)) {
            b10 = b();
        }
        if (TextUtils.isEmpty(b10) && j.f6028r.booleanValue()) {
            a(view);
        }
        e.b("XXXXX", "delay time " + (System.currentTimeMillis() - currentTimeMillis));
        return b10;
    }

    public String d(View view) {
        return c(view);
    }

    public String e(View view) {
        return c(view);
    }

    private List<Object> a(Class cls, Object obj, String str) {
        ArrayList arrayList = new ArrayList();
        try {
            e.b("XXXXX", "getFieldValueByClassName ");
            Field[] declaredFields = cls.getDeclaredFields();
            if (declaredFields.length > 0) {
                for (Field field : declaredFields) {
                    field.setAccessible(true);
                    Object obj2 = field.get(obj);
                    e.b("XXXXX", "field name " + field.getName() + ", value " + obj2);
                    if (obj2 != null) {
                        String name = obj2.getClass().getName();
                        if (name.startsWith(str) && !name.contains("nativeexpress") && name.split("\\.").length == 7) {
                            e.b("XXXXX", "fieldClsName find");
                            field.setAccessible(true);
                            arrayList.add(field.get(obj));
                        }
                    }
                }
            }
        } catch (Exception e10) {
            e.b("XXXXX", "get field value err " + e10.getMessage());
        }
        return arrayList;
    }

    public String b(View view) {
        boolean z10;
        Class<? super Object> superclass;
        StringBuilder sb2 = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        View a10 = a(view, "NativeExpressView");
        if (a10 == null) {
            e.b("XXXXX", "NativeExpressView not found");
            return null;
        }
        try {
            Class<?> cls = a10.getClass();
            if (cls.getName().contains("NativeExpressView") || (superclass = cls.getSuperclass()) == null) {
                z10 = true;
            } else {
                cls = superclass;
                z10 = false;
            }
            e.b("XXXXX", "findTextByNativeExpressView isDeclaredField = " + z10 + ", cls " + cls);
            List<Object> a11 = a(cls, a10, "com.bytedance.sdk.openadsdk.core");
            if (a11.size() > 0) {
                Iterator<Object> it = a11.iterator();
                while (it.hasNext()) {
                    List<String> a12 = a(it.next());
                    if (a12.size() > 0) {
                        for (int i10 = 0; i10 < a12.size(); i10++) {
                            String str = a12.get(i10);
                            e.b("XXXXX", "value fins str  = " + i10 + ", " + a12.get(i10));
                            if (!sb2.toString().contains(str)) {
                                if (i10 != 0) {
                                    sb2.append("#");
                                }
                                sb2.append(str);
                            }
                        }
                        e.b("XXXXX", "find delay time " + (System.currentTimeMillis() - currentTimeMillis));
                        return sb2.toString();
                    }
                }
            }
            if (!j.f6028r.booleanValue()) {
                return null;
            }
            for (Field field : cls.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(a10);
                e.b("XXXXX", "field " + field.getName() + ", field " + obj);
                if (obj != null && obj.getClass().getName().contains("com.bytedance.sdk.openadsdk.core")) {
                    for (Field field2 : obj.getClass().getDeclaredFields()) {
                        field2.setAccessible(true);
                        Object obj2 = field2.get(obj);
                        if (obj2 instanceof String) {
                            e.b("XXXXX", "field_ " + field2.getName() + ", value_ " + obj2);
                        }
                    }
                }
            }
            return null;
        } catch (Exception e10) {
            e.b("XXXXX", "get field err " + e10.getMessage());
            e10.printStackTrace();
            return null;
        }
    }

    private List<String> a(Object obj) {
        String str;
        Exception e10;
        ArrayList arrayList = new ArrayList();
        try {
            Class<?> cls = obj.getClass();
            e.b("XXXXX", "getChCharactersField cls " + cls);
            for (Field field : cls.getDeclaredFields()) {
                if (field.getGenericType().toString().equals("class java.lang.String")) {
                    field.setAccessible(true);
                    Object obj2 = field.get(obj);
                    e.b("XXXXX", "getChCharactersField value " + obj2);
                    if (obj2 instanceof String) {
                        String str2 = (String) obj2;
                        if (!str2.startsWith("http") && !this.f5579b.contains(str2.trim()) && Pattern.compile("[一-龥]").matcher(str2).find()) {
                            try {
                                str = (String) new JSONObject(str2).opt("app_name");
                                try {
                                    e.b("XXXXX", "json app name " + str);
                                } catch (Exception e11) {
                                    e10 = e11;
                                    e.b("XXXXX", "json err " + e10.getMessage());
                                    arrayList.add(str);
                                }
                            } catch (Exception e12) {
                                str = str2;
                                e10 = e12;
                            }
                            arrayList.add(str);
                        }
                    }
                }
            }
        } catch (Exception e13) {
            e.b("XXXXX", "getChCharactersField err " + e13.getMessage());
        }
        return arrayList;
    }

    private void b(View view, List<WebView> list) {
        if (view instanceof WebView) {
            e.b("XXXXX", "find webView " + view);
            list.add((WebView) view);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                b(viewGroup.getChildAt(i10), list);
            }
        }
    }

    private void a(View view) {
        e.b("XXXXX", "dumpView view " + view);
        if (view instanceof TextView) {
            e.b("XXXXX", "dump textView " + ((TextView) view).getText().toString());
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                a(viewGroup.getChildAt(i10));
            }
        }
    }

    private void a(View view, List<TextView> list) {
        if (view instanceof TextView) {
            if (a(view, this.f5578a)) {
                TextView textView = (TextView) view;
                if (textView.getText() == null || TextUtils.isEmpty(textView.getText().toString())) {
                    return;
                }
                list.add(textView);
                return;
            }
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                a(viewGroup.getChildAt(i10), list);
            }
        }
    }

    public static void a(Map<String, Object> map, Object obj, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        c().a(map, b(obj), eVar);
    }

    public static boolean a(View view, String... strArr) {
        Resources resources;
        if (view == null || strArr == null || strArr.length == 0) {
            e.b("XXXXX", "check false!");
            return false;
        }
        try {
            int id2 = view.getId();
            if (id2 > 0 && (resources = view.getResources()) != null) {
                String resourceEntryName = resources.getResourceEntryName(id2);
                for (String str : strArr) {
                    if (str.equals(resourceEntryName)) {
                        e.b("XXXXX", "find equal e = " + str + ", view " + view);
                        return true;
                    }
                }
            }
        } catch (Exception e10) {
            e.b("XXXXX", "csj app_name err " + e10.getMessage());
        }
        return false;
    }

    public static boolean a(com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        return false;
    }

    public static boolean a(com.aggmoread.sdk.z.d.a.a.d.b.e eVar, Object obj) {
        int b10;
        if (a(eVar) && (b10 = b(obj)) >= 0) {
            return m.a(eVar, b10);
        }
        return false;
    }

    private static boolean a(String str, View view) {
        if (view.getClass().getName().contains(str)) {
            return true;
        }
        Class<? super Object> superclass = view.getClass().getSuperclass();
        return superclass != null && superclass.getName().contains(str);
    }
}
