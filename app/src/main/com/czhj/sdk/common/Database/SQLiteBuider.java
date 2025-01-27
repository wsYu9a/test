package com.czhj.sdk.common.Database;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class SQLiteBuider {

    /* renamed from: a, reason: collision with root package name */
    public static final String f8414a = "SQLiteBuider";

    /* renamed from: b, reason: collision with root package name */
    public static Map<String, String> f8415b;

    public static class CreateTable {

        /* renamed from: a, reason: collision with root package name */
        public String f8416a;

        /* renamed from: b, reason: collision with root package name */
        public String f8417b;

        public static class Builder {

            /* renamed from: a, reason: collision with root package name */
            public String f8418a = null;

            /* renamed from: b, reason: collision with root package name */
            public Map<String, String> f8419b = null;

            /* renamed from: c, reason: collision with root package name */
            public Map<String, String> f8420c = null;

            /* renamed from: d, reason: collision with root package name */
            public boolean f8421d;

            public Builder autoincrement(boolean z10) {
                this.f8421d = z10;
                return this;
            }

            public CreateTable build() {
                StringBuilder sb2 = new StringBuilder("create table if not exists ");
                sb2.append(this.f8418a);
                sb2.append(" ( ");
                List b10 = SQLiteBuider.b(this.f8419b);
                if (b10.size() > 1) {
                    Iterator it = SQLiteBuider.b(this.f8420c).iterator();
                    while (it.hasNext()) {
                        sb2.append((String) it.next());
                        sb2.append(" ,");
                    }
                    sb2.append(" primary key ( ");
                    Iterator<String> it2 = this.f8419b.keySet().iterator();
                    while (it2.hasNext()) {
                        sb2.append(it2.next());
                        if (it2.hasNext()) {
                            sb2.append(" ,");
                        } else {
                            sb2.append(" )");
                        }
                    }
                } else {
                    sb2.append(this.f8421d ? String.format("id integer primary key AUTOINCREMENT", new Object[0]) : String.format("%s primary key ", b10.get(0)));
                    this.f8420c.remove(this.f8419b.keySet().iterator().next());
                    for (String str : SQLiteBuider.b(this.f8420c)) {
                        sb2.append(" ,");
                        sb2.append(str);
                        sb2.append(" ");
                    }
                }
                sb2.append(" ); ");
                CreateTable createTable = new CreateTable();
                createTable.f8417b = sb2.toString();
                createTable.f8416a = this.f8418a;
                return createTable;
            }

            public Builder setColumns(Map<String, String> map) {
                this.f8420c = map;
                return this;
            }

            public Builder setPrimaryKey(String str, String str2) {
                if (this.f8419b == null) {
                    this.f8419b = new HashMap();
                }
                this.f8419b.put(str, str2);
                return this;
            }

            public Builder setTableName(String str) {
                this.f8418a = str;
                return this;
            }
        }
    }

    public static class CreateTriggerBuilder {

        /* renamed from: a, reason: collision with root package name */
        public String f8422a = null;

        /* renamed from: b, reason: collision with root package name */
        public String f8423b = null;

        /* renamed from: c, reason: collision with root package name */
        public String f8424c = null;

        /* renamed from: d, reason: collision with root package name */
        public String f8425d = null;

        public String build() {
            return String.format("create trigger if not exists %s after %s on %s begin %s end;", this.f8422a, this.f8423b, this.f8424c, this.f8425d);
        }

        public CreateTriggerBuilder setExecSql(String str) {
            this.f8425d = str;
            return this;
        }

        public CreateTriggerBuilder setOnAction(String str) {
            this.f8423b = str;
            return this;
        }

        public CreateTriggerBuilder setOnTableName(String str) {
            this.f8424c = str;
            return this;
        }

        public CreateTriggerBuilder setTriggerName(String str) {
            this.f8422a = str;
            return this;
        }
    }

    public static class Insert {

        /* renamed from: a, reason: collision with root package name */
        public String f8426a;

        /* renamed from: b, reason: collision with root package name */
        public String f8427b;

        /* renamed from: c, reason: collision with root package name */
        public Map<String, Object> f8428c;

        /* renamed from: d, reason: collision with root package name */
        public List<Object> f8429d;

        public static class Builder {

            /* renamed from: a, reason: collision with root package name */
            public String f8430a = null;

            /* renamed from: b, reason: collision with root package name */
            public Map<String, Object> f8431b = null;

            public Insert build() {
                List<Object> asList = Arrays.asList(this.f8431b.keySet().toArray());
                StringBuilder sb2 = new StringBuilder("insert or replace into ");
                sb2.append(this.f8430a);
                StringBuilder sb3 = new StringBuilder("(");
                StringBuilder sb4 = new StringBuilder("(");
                int i10 = 0;
                while (i10 < asList.size()) {
                    sb3.append(asList.get(i10));
                    sb4.append("?");
                    i10++;
                    if (i10 < asList.size()) {
                        sb3.append(", ");
                        sb4.append(", ");
                    }
                }
                sb3.append(")");
                sb4.append(")");
                sb2.append((CharSequence) sb3);
                sb2.append(" values ");
                sb2.append((CharSequence) sb4);
                Insert insert = new Insert();
                insert.f8426a = this.f8430a;
                insert.f8429d = asList;
                insert.f8428c = this.f8431b;
                insert.f8427b = sb2.toString();
                return insert;
            }

            public void setColumnValues(Map<String, Object> map) {
                this.f8431b = map;
            }

            public void setTableName(String str) {
                this.f8430a = str;
            }
        }

        public List<Object> getColumns() {
            return this.f8429d;
        }

        public String getSql() {
            return this.f8427b;
        }

        public String getTableName() {
            return this.f8426a;
        }

        public Map<String, Object> getValues() {
            return this.f8428c;
        }
    }

    public static class Update {

        /* renamed from: a, reason: collision with root package name */
        public String f8432a;

        /* renamed from: b, reason: collision with root package name */
        public String f8433b;

        /* renamed from: c, reason: collision with root package name */
        public Map<String, Object> f8434c;

        /* renamed from: d, reason: collision with root package name */
        public String f8435d;

        public static class Builder {

            /* renamed from: a, reason: collision with root package name */
            public String f8436a = null;

            /* renamed from: b, reason: collision with root package name */
            public Map<String, Object> f8437b = null;

            /* renamed from: c, reason: collision with root package name */
            public String f8438c = null;

            public Update build() {
                StringBuilder sb2 = new StringBuilder("update ");
                sb2.append(this.f8436a);
                sb2.append(" set ");
                Iterator<String> it = this.f8437b.keySet().iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    sb2.append(next + " = " + this.f8437b.get(next));
                    if (it.hasNext()) {
                        sb2.append(", ");
                    }
                }
                if (!TextUtils.isEmpty(this.f8438c)) {
                    sb2.append(" " + this.f8438c);
                }
                Update update = new Update();
                update.f8432a = this.f8436a;
                update.f8434c = this.f8437b;
                update.f8435d = this.f8438c;
                update.f8433b = sb2.toString();
                return update;
            }

            public void setColumnValues(Map<String, Object> map) {
                this.f8437b = map;
            }

            public void setTableName(String str) {
                this.f8436a = str;
            }

            public void setWhere(String str) {
                this.f8438c = str;
            }
        }

        public String getSql() {
            return this.f8433b;
        }
    }

    public static List<String> b(Map<String, String> map) {
        String str;
        ArrayList arrayList = new ArrayList(map.size());
        for (String str2 : map.keySet()) {
            String lowerCase = map.get(str2).toLowerCase();
            lowerCase.hashCode();
            switch (lowerCase) {
                case "int":
                case "long":
                    str = TypedValues.Custom.S_INT;
                    break;
                case "text":
                case "java.lang.string":
                    str = "text";
                    break;
                default:
                    str = "blob";
                    break;
            }
            arrayList.add(String.format("%s %s ", str2, str));
        }
        return arrayList;
    }
}
