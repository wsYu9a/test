package java.net.ssl;

import android.content.Context;
import android.util.Printer;
import androidx.annotation.Keep;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.net.ssl.Cif;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

@Keep
/* loaded from: classes4.dex */
public class SSLSocketLogger {
    public static final String TAG = "SSLTest";
    public static final boolean debug = false;
    private static SocketCreateListener sSocketCreateListener = null;
    private static final Object sSocketCreateListenerLock = new Object();
    private static final String sTypeSSLContext = "SSLContext";

    @Keep
    public interface SocketCreateListener {
        @Keep
        SSLSocket onCreateSocket(SSLSocket sSLSocket);
    }

    @Keep
    public static SocketCreateListener getListener() {
        return sSocketCreateListener;
    }

    public static void handleException(Throwable th2) {
        Throwable targetException;
        if (th2 instanceof Cif.Cfor) {
            targetException = th2.getCause();
        } else if (!(th2 instanceof InvocationTargetException)) {
            return;
        } else {
            targetException = ((InvocationTargetException) th2).getTargetException();
        }
        handleException(targetException);
    }

    public static Socket onCreateSocket(SSLSocket sSLSocket) {
        synchronized (sSocketCreateListenerLock) {
            try {
                SocketCreateListener socketCreateListener = sSocketCreateListener;
                if (socketCreateListener == null) {
                    return sSLSocket;
                }
                return socketCreateListener.onCreateSocket(sSLSocket);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static void replaceSSLContextService(Map<Object, Object> map) {
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            if ((value instanceof Provider.Service) && !(value instanceof a)) {
                Provider.Service service = (Provider.Service) value;
                if (sTypeSSLContext.equals(service.getType())) {
                    int i10 = a.f27303a;
                    ArrayList arrayList = new ArrayList();
                    try {
                        arrayList.addAll((List) Cif.f(service).j("aliases"));
                    } catch (Cif.Cfor e10) {
                        handleException(e10);
                    }
                    HashMap hashMap = new HashMap();
                    try {
                        hashMap.putAll((Map) Cif.f(service).j("attributes"));
                    } catch (Cif.Cfor e11) {
                        handleException(e11);
                    }
                    entry.setValue(new a(service.getProvider(), service.getType(), service.getAlgorithm(), service.getClassName(), arrayList, hashMap));
                }
            }
        }
    }

    @Keep
    public static void setListener(SocketCreateListener socketCreateListener) {
        synchronized (sSocketCreateListenerLock) {
            sSocketCreateListener = socketCreateListener;
        }
    }

    @Keep
    public static boolean setup(Context context, Printer printer, SocketCreateListener socketCreateListener) {
        Field field;
        try {
            int i10 = x0.a.f31766a;
            synchronized (sSocketCreateListenerLock) {
                sSocketCreateListener = socketCreateListener;
            }
            try {
                new Cif(SSLSocketFactory.class, SSLSocketFactory.class).g("defaultSocketFactory", new DefaultSSLSocketFactory((SSLSocketFactory) SSLSocketFactory.getDefault()));
                try {
                    Security.setProperty("ssl.SocketFactory.provider", DefaultSSLSocketFactory.class.getName());
                } catch (Exception e10) {
                    handleException(e10);
                }
            } catch (Cif.Cfor e11) {
                handleException(e11);
            }
            Provider provider = SSLContext.getDefault().getProvider();
            try {
                Map map = (Map) Cif.f(provider).j("legacyMap");
                if (map != null) {
                    replaceSSLContextService(map);
                }
            } catch (Throwable th2) {
                handleException(th2);
            }
            try {
                Map map2 = (Map) Cif.f(provider).j("serviceMap");
                if (map2 != null) {
                    replaceSSLContextService(map2);
                }
            } catch (Throwable th3) {
                handleException(th3);
            }
            try {
                Map map3 = (Map) Cif.f(provider).j("serviceTable");
                if (map3 != null) {
                    replaceSSLContextService(map3);
                }
            } catch (Throwable th4) {
                handleException(th4);
            }
            try {
                Map map4 = (Map) Cif.f(provider).j("aliasTable");
                if (map4 != null) {
                    replaceSSLContextService(map4);
                }
            } catch (Throwable th5) {
                handleException(th5);
            }
            try {
                Map map5 = (Map) Cif.f(provider).j("propertyServiceTable");
                if (map5 != null) {
                    replaceSSLContextService(map5);
                }
            } catch (Throwable th6) {
                handleException(th6);
            }
            try {
                Map map6 = (Map) Cif.f(provider).j("propertyAliasTable");
                if (map6 != null) {
                    replaceSSLContextService(map6);
                }
            } catch (Throwable th7) {
                handleException(th7);
            }
            try {
                Cif.f(provider).g("returnedService", null);
            } catch (Throwable th8) {
                handleException(th8);
            }
            try {
                Cif.f(provider).g("lastAlgorithm", null);
            } catch (Cif.Cfor e12) {
                handleException(e12);
            }
            try {
                Cif.f(provider).g("lastServiceName", null);
            } catch (Cif.Cfor e13) {
                handleException(e13);
            }
            try {
                Cif.f(provider).g("lastType", null);
            } catch (Cif.Cfor e14) {
                handleException(e14);
            }
            try {
                Cif.f(provider).g("lastType", null);
            } catch (Cif.Cfor e15) {
                handleException(e15);
            }
            try {
                Cif.f(provider).g("lastServicesByType", null);
            } catch (Cif.Cfor e16) {
                handleException(e16);
            }
            try {
                Cif.f(provider).g("lastServicesSet", null);
            } catch (Cif.Cfor e17) {
                handleException(e17);
            }
            try {
                Method method = Cif.a.f27306a;
            } catch (Throwable th9) {
                Class cls = SSLContext.class;
                do {
                    try {
                        Method method2 = Cif.a.f27306a;
                        try {
                            try {
                                field = (Field) Cif.b((Field) Cif.a.f27307b.invoke(cls, "ENGINE"));
                            } catch (InvocationTargetException e18) {
                                throw e18.getTargetException();
                            }
                        } catch (Exception e19) {
                            throw new Cif.Cfor(e19);
                        }
                    } catch (Throwable unused) {
                        cls = cls.getSuperclass();
                    }
                } while (cls != null);
                throw new Cif.Cfor(th9);
            }
            try {
                field = (Field) Cif.b((Field) Cif.a.f27310e.invoke(SSLContext.class, "ENGINE"));
                try {
                    new Cif(field.getType(), field.get(SSLContext.class)).g("serviceCache", null);
                } catch (Cif.Cfor e20) {
                    handleException(e20);
                }
                try {
                    Cif.l().e();
                } catch (Cif.Cfor e21) {
                    handleException(e21);
                }
                return true;
            } catch (InvocationTargetException e22) {
                throw e22.getTargetException();
            }
        } catch (Throwable th10) {
            th10.printStackTrace();
            return false;
        }
    }
}
