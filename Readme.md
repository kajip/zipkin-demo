# Zipkin デモ

Spring Cloud Sleuth で Zipkin にトレース情報を記録するデモ

## 使い方

### 1. アプリケーションのビルド

```% ./gradlew clean build```

### 2. Docker でZipkin を建てる

アプリケーションは、localhost:9411 の Zipkin 向けにデータを送りつける設定になっています

```% docker run -d -p 9411:9411 openzipkin/zipkin```

### 3. アプリケーションを起動

２つのspring-bootプロセスを起動します。端末を２つ開いてそれぞれで起動してください

サービス1：
```% java -jar service01/build/libs/service01.jar```

サービス2：
```% java -jar service02/build/libs/service02.jar```

### 4. アプリケーションを叩く

サービス１からサービス２を呼び出す実装になっています。

curl などで、サービス１の /service を叩いてください

```% curl -v http://localhost:8080/service```

### 5. Zipkin でトレース情報を確認

下記URLで Zipkin にアクセスし、トレース情報を確認します

```http://localhost:9411/```

### 30秒ごとにタイマー起動するコンポーネントもあり、そちらもzipkin にトレース情報が残ります