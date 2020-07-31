package com.wsw.controller;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.wsw.entity.db.Goods;
import com.wsw.entity.db.Order;
import com.wsw.entity.db.Shoppingcart;
import com.wsw.service.GoodsService;
import com.wsw.service.OrderService;
import com.wsw.service.ShoppingcartService;
import com.wsw.util.AlipayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
public class AlipayController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private ShoppingcartService shoppingcartService;

    @RequestMapping("goAlipay")
    public void goAlipay(String orderId, String flag, HttpServletResponse response) throws Exception {
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        request.setReturnUrl(AlipayConfig.return_url);
        String out_trade_no = null;
        String subject = null;
        String total_amount = "0.01";
        if (flag.equals("order")) {
            Order order = orderService.selectByOid(Integer.valueOf(orderId));
            Goods goods = goodsService.selectByGid(order.getgId());
            //商户订单号，商户网站订单系统中唯一订单号，必填
            out_trade_no = "100101" + order.getOrId();
            //付款金额，必填
            total_amount = String.valueOf(order.getOrTotal());
            //订单名称，必填
            subject = goods.getgName();
        }
        if (flag.equals("cart")) {
            Shoppingcart shoppingcart = shoppingcartService.selectBySid(Integer.valueOf(orderId));
            Goods goods = goodsService.selectByGid(shoppingcart.getgId());
            //商户订单号，商户网站订单系统中唯一订单号，必填
            out_trade_no = "100101" + shoppingcart.getsId();
            //付款金额，必填
            total_amount = String.valueOf(shoppingcart.getsTotal());
            //订单名称，必填
            subject = goods.getgName();
        }
        //商品描述，可空
        String body = "";
        request.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        String result = alipayClient.pageExecute(request).getBody();//调用sdk生成表单
        //输出，注意输出格式，错误容易验签失败
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(result);
    }

    @RequestMapping("result")
    public String get(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html; charset=utf-8");
        //获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
        //——请在这里编写您的程序（以下代码仅作参考）——
        if (signVerified) {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");
            out.println("trade_no:" + trade_no + "<br/>out_trade_no:" + out_trade_no + "<br/>total_amount:" + total_amount);
        } else {
            out.println("验签失败");
        }
        return "redirect:../usercenter.jsp";
    }
}

