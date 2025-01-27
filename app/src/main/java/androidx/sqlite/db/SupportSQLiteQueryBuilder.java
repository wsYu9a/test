package androidx.sqlite.db;

import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class SupportSQLiteQueryBuilder {

    /* renamed from: a */
    private static final Pattern f3597a = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");

    /* renamed from: c */
    private final String f3599c;

    /* renamed from: e */
    private String f3601e;

    /* renamed from: f */
    private Object[] f3602f;

    /* renamed from: b */
    private boolean f3598b = false;

    /* renamed from: d */
    private String[] f3600d = null;

    /* renamed from: g */
    private String f3603g = null;

    /* renamed from: h */
    private String f3604h = null;

    /* renamed from: i */
    private String f3605i = null;

    /* renamed from: j */
    private String f3606j = null;

    private SupportSQLiteQueryBuilder(String str) {
        this.f3599c = str;
    }

    private static void a(StringBuilder sb, String str, String str2) {
        if (c(str2)) {
            return;
        }
        sb.append(str);
        sb.append(str2);
    }

    private static void b(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            String str = strArr[i2];
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(' ');
    }

    public static SupportSQLiteQueryBuilder builder(String str) {
        return new SupportSQLiteQueryBuilder(str);
    }

    private static boolean c(String str) {
        return str == null || str.length() == 0;
    }

    public SupportSQLiteQueryBuilder columns(String[] strArr) {
        this.f3600d = strArr;
        return this;
    }

    public SupportSQLiteQuery create() {
        if (c(this.f3603g) && !c(this.f3604h)) {
            throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
        }
        StringBuilder sb = new StringBuilder(120);
        sb.append("SELECT ");
        if (this.f3598b) {
            sb.append("DISTINCT ");
        }
        String[] strArr = this.f3600d;
        if (strArr == null || strArr.length == 0) {
            sb.append(" * ");
        } else {
            b(sb, strArr);
        }
        sb.append(" FROM ");
        sb.append(this.f3599c);
        a(sb, " WHERE ", this.f3601e);
        a(sb, " GROUP BY ", this.f3603g);
        a(sb, " HAVING ", this.f3604h);
        a(sb, " ORDER BY ", this.f3605i);
        a(sb, " LIMIT ", this.f3606j);
        return new SimpleSQLiteQuery(sb.toString(), this.f3602f);
    }

    public SupportSQLiteQueryBuilder distinct() {
        this.f3598b = true;
        return this;
    }

    public SupportSQLiteQueryBuilder groupBy(String str) {
        this.f3603g = str;
        return this;
    }

    public SupportSQLiteQueryBuilder having(String str) {
        this.f3604h = str;
        return this;
    }

    public SupportSQLiteQueryBuilder limit(String str) {
        if (c(str) || f3597a.matcher(str).matches()) {
            this.f3606j = str;
            return this;
        }
        throw new IllegalArgumentException("invalid LIMIT clauses:" + str);
    }

    public SupportSQLiteQueryBuilder orderBy(String str) {
        this.f3605i = str;
        return this;
    }

    public SupportSQLiteQueryBuilder selection(String str, Object[] objArr) {
        this.f3601e = str;
        this.f3602f = objArr;
        return this;
    }
}
