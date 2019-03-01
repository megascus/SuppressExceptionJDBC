# SuppressExceptionJDBC
Suppress all Exceptions from JDBC


# データベースから返されるSQLExceptionが煩わしいと思ったことはありませんか？
このライブラリを使用すれば、たとえデータベースが落ちたとしても例外に煩わされることはありません。

## 使用方法

現在は個別にビルドを行う必要があります。mavenでビルドを行ってください。

```
mvn package
```


JDBC 4.2に対応していますので、jarをクラスパスに導入するだけで使用できます。
データソースを使用している場合はJDBC URLに sej を足してください。

```jdbc:oracle:thin:scott/tiger@localhost:1521:XE```

↓

```jdbc:sej:oracle:thin:scott/tiger@localhost:1521:XE```

もしくは既存のコネクションを直接ラップすることもできます。
Connectionインターフェースではなく、実装を直接扱うことでSQLExceptionクラスを見ることすらありません。

```
Connection conn = getConnection();
SEConnection sec = new SEConnection(conn);
SEPreparedStatement sepstmt = sec.prepareStatement("select * from employee");
SEResultSet sers = sepstmt.executeQuery();
while(sers.next()) {
	・・・・
}
```

## 制限事項

Connectionインターフェースをそのまま使用する場合はSQLExceptionが投げられなくてもSQLExceptionをハンドリングする必要があります。

このライブラリはいくつかの点でJDBC標準には準拠していません。ご注意ください。(例えば、ResultSet#next()を呼び出さずにResultSet#getString(int)を呼び出してもSQLExceptionはスローされない。)
