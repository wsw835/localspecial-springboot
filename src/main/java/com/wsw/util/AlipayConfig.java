package com.wsw.util;

public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016100100641466";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCBjkiHwAlX4kO9G+s3ZeWMpkuauFMTtAd7/SVo2i1Dh3U6Rt+5E2QaClhYS1pB9gPi4HxXh6V0oeA2gUZozMlk5WF350TCjqvc+jTjzmo3rVnCAn4pV2nMIiqfzsT/V831G/JaCToVWLXEer6Q4slZh1hPkDDB0bHFH0DodvYa87QEqGVa1tpMUsuD6bON8HQghFjPyKdf4zM1Sd0TvwGfC/ZAdDHFfpLE43MN/ePX32rcsAPS7RPG/QvNckRymefQk96CuOTrKsSlSQuDwhvmIgtXTMnmvfYHFMX3aafHnOs/870xENt0UPCkOElSGL9YpGZYrgBHQjrTkuzLuP8ZAgMBAAECggEAdwn+OMVJkHe1F/ikKpW00oQl6ba9ltgPHGzgR7RYbLj1DKP8grh/fLHOtOoft4XN0lPDzEU10LHAKzSjNj4cOlnNMffMpRukbHl1yW9rB1d/ppTVyTSpYEhwc7/wIFJUSofwKaxasyx8b1j86nGG4n1KtmhddGkxd1cdM7vCq8W75jEywQjoLUxpO7Bii7+asJzfBghQbaUTauZZ4RVK35mrli0AZKqXehZ0LsmvDiOFNWMAgmfuL3aKIAjOaKAbJ4MoiaFCYQB1Sr6SA52B5whTvpEKMx904o1NDcL6cLfT3Mmga6W380yymh2jkwzD3RitVVWDe5BA8wmDkeH3FQKBgQC8B7esZRR2jhPqKch0C/O9SO8R6Ekx+uYvEi8lkmkQbVUqLpbwCHczr/iIHN1cCwk9UZLJzncF5rL7il7mVrsNRjXu+q4MIp0oZEKyo9UDvm3he3yacvznYrx43DL4SVj9ohQVRx2FGGisVnmEJS0tZfJ/vPTa+SterdZcfDvnLwKBgQCwY1uWYh0J/BlzHIWT2lHh+qMKOdxoJuIijiLHOGvMWUUe/wHe6PhfS67d+otT7CHXRblENuwPHJC2lkuDNULkSTxfG4H9PLQQ+OtSnso27Yp2qsv4FSj9DNLo/PYXLeOo1AQZ8fE/VpPiI07K4uMDO5bqgbXRV3ouQW+fCzXsNwKBgAY9f1QCWsaAepq33kYzq1gp1n1SpzM4b3E6ekQV8tSvvDbVKv82WLZnbakexB3s49acIXH/HyYb/O6qLfIZCMYtAVc4DJSshWi0wx3ooAYqyLzF+2Go1UnclgKw1CQ3UvO/8EiwfoNPRxIJIKlJDpHGI2En5TxrLoxK2qVhHh/TAoGALdOyoPCewNBZwFmBrvdC3OZkY6zCweCQUhABoybagv4SgkoYr1Rx6zhbl1qXxlcMN8TqrHlkfUyboISN2+oDlhIc+EzKSgPyeJJjeVS+DuVKWyhm0+6TdqNVTKkkOsN2aY+j/SWp2x3gUBmCSB4IgveBby4CEgCbQtdHa9fay6MCgYAgsqktgKbgXIQ0b0mo3TghDBmaD0tWgeAJ4/zc36R11nlbE2LhA9rhk330K2yZVfNNd84TlIVxy5iK4S0Qx5KggfqDtKcx9+qj7lc6VEgBYYvdLyfRjQF3ODulDjmc6ddt82dZldY6gpP1URZDuGePFFxzJG6lC5Zg/8o733FvEg==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmHWOxT5Z5KV8w5olPVKklqIIMU+sX6WVgfLGYpBy60FbhShG/2Cm19At6cxp/bP8m5QompVQgva7K1Q1pjiTNZVIaSG5ccpmjrKkVT3I0Aohwe+UV1/uY4Ga96HA39Mg1NEcO7DzYiIM6XfaVRt/YW/4w8h2zIo8sSnBiBQ0qJgffr4IcwIxmgs8CPs6ktV/CLuDYFFl5JDexnYeWzeoS1O4z1nLSZhg5NVLwzQEphn7FN0x8onosGA8UC2Nwxge1oYDHZhlZjFkvtTaBTW+/cds4FtiM0z2Dz/n6iie1zRtjpE38FjphCLPHsHS5JBH1xl/MlGxwLFgPnV3P6plSQIDAQAB";

    /*   // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
       public static String notify_url = "http://localhost:8080/shoppingstate/notify_url.jsp";
   */
    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http:localhost:8088/goods/show";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

}
