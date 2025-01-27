package com.vivo.advv.vaf.expr.engine;

import android.text.TextUtils;
import com.vivo.advv.expr.common.StringSupport;
import com.vivo.advv.vaf.expr.engine.data.Data;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.util.VVLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class NativeObjectManager {
    private static final String TAG = "NObjManager_TMTEST";
    private StringSupport mStringLoader;
    private List<ViewBase> mViews = new ArrayList();
    private Map<String, Object> mNativeObjects = new ConcurrentHashMap();

    public void addView(ViewBase viewBase) {
        if (viewBase != null) {
            this.mViews.add(viewBase);
        }
    }

    public void destroy() {
        reset();
        this.mNativeObjects = null;
        this.mStringLoader = null;
    }

    public ViewBase findCom(String str) {
        if (!TextUtils.isEmpty(str)) {
            int size = this.mViews.size();
            for (int i2 = 0; i2 < size; i2++) {
                ViewBase viewBase = this.mViews.get(i2);
                if (TextUtils.equals(viewBase.getName(), str)) {
                    return viewBase;
                }
            }
        }
        return null;
    }

    public Object getModule(String str) {
        return this.mNativeObjects.get(str);
    }

    public Object getPropertyImp(Object obj, int i2) {
        Object obj2 = null;
        if (obj == null || i2 == 0) {
            VVLog.e(TAG, "getProperty param invalidate");
            return null;
        }
        try {
            String string = this.mStringLoader.getString(i2);
            Method method = obj.getClass().getMethod(String.format("get%c%s", Character.valueOf(Character.toUpperCase(string.charAt(0))), string.substring(1).toString()), new Class[0]);
            if (method != null) {
                obj2 = method.invoke(obj, new Object[0]);
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        return (obj2 == null && (obj instanceof ViewBase)) ? ((ViewBase) obj).getUserVar(i2) : obj2;
    }

    public boolean registerObject(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            VVLog.e(TAG, "registerObject param invalidate");
            return false;
        }
        this.mNativeObjects.put(str, obj);
        return true;
    }

    public void removeView(ViewBase viewBase) {
        if (viewBase != null) {
            this.mViews.remove(viewBase);
        }
    }

    public void reset() {
        this.mViews.clear();
        this.mNativeObjects.clear();
    }

    public boolean setPropertyImp(Object obj, int i2, Data data) {
        boolean z = false;
        if (obj == null || i2 == 0 || data == null) {
            VVLog.e(TAG, "setIntegerPropertyImp param invalidate");
            return false;
        }
        try {
            String string = this.mStringLoader.getString(i2);
            String format = String.format("set%c%s", Character.valueOf(Character.toUpperCase(string.charAt(0))), string.substring(1).toString());
            Method method = obj.getClass().getMethod(format, data.mValue.getValueClass());
            if (method != null) {
                method.invoke(obj, data.mValue.getValue());
                z = true;
            } else {
                VVLog.e(TAG, "view:" + obj.getClass() + "  setIntegerPropertyImp find method failed:" + format);
            }
        } catch (IllegalAccessException e2) {
            VVLog.e(TAG, "view:" + obj.getClass() + "  setIntegerPropertyImp failed:" + e2);
        } catch (NoSuchMethodException e3) {
            VVLog.e(TAG, "view:" + obj.getClass() + "  setIntegerPropertyImp failed:" + e3);
        } catch (InvocationTargetException e4) {
            VVLog.e(TAG, "view:" + obj.getClass() + "  setIntegerPropertyImp failed:" + e4);
        }
        return (z || !(obj instanceof ViewBase)) ? z : ((ViewBase) obj).setUserVar(i2, data);
    }

    public void setStringManager(StringSupport stringSupport) {
        this.mStringLoader = stringSupport;
    }

    public boolean unregisterObject(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.mNativeObjects.remove(str);
        return true;
    }

    public ViewBase findCom(int i2) {
        return findCom(this.mStringLoader.getString(i2));
    }
}
