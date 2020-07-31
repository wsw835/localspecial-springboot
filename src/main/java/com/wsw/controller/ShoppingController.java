package com.wsw.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wsw.converter.AddressConverter;
import com.wsw.converter.GoodsConverter;
import com.wsw.entity.db.Address;
import com.wsw.entity.db.Comments;
import com.wsw.entity.db.Goods;
import com.wsw.entity.db.Order;
import com.wsw.entity.db.Orderdetail;
import com.wsw.entity.db.Shoppingcart;
import com.wsw.entity.db.Type;
import com.wsw.entity.db.User;
import com.wsw.entity.vo.PositionVO;
import com.wsw.mapper.GoodsMapper;
import com.wsw.service.*;
import com.wsw.entity.vo.AddressVO;
import com.wsw.entity.vo.GoodsVO;
import com.wsw.entity.vo.HistoryVO;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class ShoppingController {

    @Autowired
    private TypeService typeService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderdetailService orderdetailService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ShoppingcartService shoppingcartService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private CommentsService commentsService;
    @Autowired
    private GoodsMapper goodsMapper;


    private static final String path = "E:/images";

    @RequestMapping("/insert")
    public String OnShop(GoodsVO goodsVO, String img) throws Exception {
        System.out.println(goodsVO);
        img = goodsVO.getImage().getOriginalFilename();
        InputStream in = goodsVO.getImage().getInputStream();
        FileOutputStream out = new FileOutputStream(new File(img));
        byte[] buffer = new byte[1024 * 10];
        int len = 0;
        while ((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
            out.flush();
        }
        Goods goods = GoodsConverter.goodsConverter(goodsVO, img);
        System.out.println(goods);
        goodsService.insert(goods);
        return "redirect:../admin/index.jsp";
    }

    @RequestMapping("/getImage")
    public void getImage(String imageName, HttpServletResponse response) throws Exception {
        FileInputStream in = new FileInputStream(new File(imageName));
        IOUtils.copy(in, response.getOutputStream());
    }

    @RequestMapping("/getInfo")
    public String getInfo(HttpServletRequest request) {
        List<Type> list = typeService.selectAllType();
        HttpSession session = request.getSession();
        session.setAttribute("type", list);
        return "redirect:../admin/goods-add.jsp";
    }

    @RequestMapping("/getAll")
    public String getAll(HttpServletRequest request) {
        List<Goods> list = goodsService.selectAll();
        HttpSession session = request.getSession();
        session.setAttribute("goods", list);
        return "redirect:../admin/goods-list.jsp";
    }

    @RequestMapping("/getOne")
    public String getOne(HttpServletRequest request, int id, String uname, HttpServletResponse response) throws Exception {
        Goods goods = goodsService.selectByGid(id);
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;utf-8");
        response.setCharacterEncoding("utf-8");
        session.setAttribute("goodOne", goods);
        if (uname.equals("") || uname == null) {
            out.print("<script>confirm('亲，请先登录！');window.location.href='../login.jsp';</script>");
            return null;
        }
        User user = userService.selectByUname(uname);
        if (user != null) {
            List<Address> addressList = addressService.selectAll(user.getuId());
            session.setAttribute("addressList", addressList);
        }
        List<Comments> list = commentsService.selectAll(id);
        session.setAttribute("user", user);
        session.setAttribute("commentsList", list);
        return "redirect:../iemt.jsp";
    }

    @RequestMapping("/addOrder")
    public String addOrder(String name, int id, HttpServletResponse response, int gNum,
                           HttpServletRequest request) throws Exception {
        response.setContentType("text/html;utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        if (name.equals("") || name == null) {
            out.print("<script>confirm('亲，请先登录！');window.location.href='../login.jsp';</script>");
            return null;
        }
        Goods goods = goodsService.selectByGid(id);
        User user = userService.selectByUname(name);
        //插入订单信息
        orderService.insert(new Order(null, goods.getgId(), user.getuId(), gNum, goods.getgPrice() * gNum));
        //查出当前插入的订单的信息
        Order order = orderService.selectLast();
        //插入订单详细信息
        Orderdetail orderdetail = new Orderdetail(goods.getgPrice() * gNum, order.getOrId(), gNum);
        orderdetailService.insert(orderdetail);
        out.print("<script>alert('下单成功！');</script>");
        return "redirect:../index.jsp";
    }

    @RequestMapping("/showOrder")
    public String showOrder(String uname, HttpServletResponse response, HttpServletRequest request,
                            @RequestParam(defaultValue = "1") int pageNo) throws Exception {
        response.setContentType("text/html;utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        if (uname.equals("") || uname == null) {
            out.print("<script>confirm('亲，请先登录！');window.location.href='../login.jsp';</script>");
            return null;
        }
        User user = userService.selectByUname(uname);
        PageHelper.startPage(pageNo, 2);
        //获取所有的订单详情的信息
        List<Order> list = orderService.selectAllOrder(user.getuId());
        PageInfo<Order> pageInfo = new PageInfo<>(list);
        HttpSession session = request.getSession();
        session.setAttribute("orderList", list);
        session.setAttribute("pageInfo", pageInfo);
        return "redirect:../usercenter.jsp";
    }

    @RequestMapping("/getOrderByTag")
    public void getOrderByTag(String uname, String flag, HttpServletResponse response, HttpServletRequest request,
                              @RequestParam(defaultValue = "1") int pageNo) throws Exception {
        response.setContentType("text/html;utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        if (uname.equals("") || uname == null) {
            out.print("<script>confirm('亲，请先登录！');window.location.href='../login.jsp';</script>");
        }
        User user = userService.selectByUname(uname);
        PageHelper.startPage(pageNo, 2);
        //获取所有的订单详情的信息
        List<Order> list = orderService.selectAllOrder(user.getuId());
        PageInfo<Order> pageInfo = new PageInfo<>(list);
        HttpSession session = request.getSession();
        session.setAttribute("orderList", list);
        session.setAttribute("pageInfo", pageInfo);
    }


    @RequestMapping("/deleteOrder")
    public String delete(int orId, HttpServletRequest request, HttpServletResponse response, String uname, @RequestParam(defaultValue = "1") int pageNo) {
        response.setContentType("text/html;utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        PageHelper.startPage(pageNo, 2);
        orderService.delete(orId);
        //获取所有的订单详情的信息
        User user = userService.selectByUname(uname);
        List<Order> list = orderService.selectAllOrder(user.getuId());
        //获取所有的订单详情的信息
        PageInfo<Order> pageInfo = new PageInfo<>(list);
        session.setAttribute("orderList", list);
        session.setAttribute("pageInfo", pageInfo);
        return "redirect:../usercenter.jsp";
    }

    @RequestMapping("/addCart")
    public String addCart(String name, int id, HttpServletResponse response, int gNum,
                          HttpServletRequest request) throws Exception {
        response.setContentType("text/html;utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        if (name.equals("") || name == null) {
            out.print("<script>confirm('亲，请先登录！');window.location.href='../login.jsp';</script>");
            return null;
        }
        Goods goods = goodsService.selectByGid(id);
        User user = userService.selectByUname(name);
        Shoppingcart shoppingcart = new Shoppingcart(gNum, goods.getgPrice() * gNum, goods.getgId(), user.getuId());
        shoppingcartService.insert(shoppingcart);
        return "redirect:../index.jsp";
    }

    @RequestMapping("/showCart")
    public String showCart(String uname, HttpServletResponse response, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        response.setContentType("text/html;utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        if (uname.equals("") || uname == null) {
            out.print("<script>confirm('亲，请先登录！');window.location.href='../login.jsp';</script>");
            return null;
        }
        User user = userService.selectByUname(uname);
        List<Shoppingcart> list = shoppingcartService.selectAll(user.getuId());
        session.setAttribute("cartList", list);
        return "redirect:../submit.jsp";
    }

    @RequestMapping("/deleteCart")
    public String deleteCart(int sId, HttpServletRequest request, HttpServletResponse response, String uname) {
        response.setContentType("text/html;utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        shoppingcartService.delete(sId);
        User user = userService.selectByUname(uname);
        //获取所有的购物车详情的信息
        List<Shoppingcart> list = shoppingcartService.selectAll(user.getuId());
        session.setAttribute("cartList", list);
        return "redirect:../submit.jsp";
    }

    @RequestMapping("/addAddr")
    public String addAddr(String uname, AddressVO addressVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        response.setContentType("text/html;utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        if (uname.equals("") || uname == null) {
            out.print("<script>confirm('亲，请先登录！');window.location.href='../login.jsp';</script>");
            return null;
        }
        User user = userService.selectByUname(uname);
        Address address = AddressConverter.addressConverter(addressVO, user.getuId());
        //一旦设为默认地址则修改上一个默认地址状态
        if (address.getaState() == 1) {
            addressService.update();
        }
        addressService.insert(address);
        List<Address> addressList = addressService.selectAll(user.getuId());
        session.setAttribute("addressList", addressList);
        return "redirect:../newPath.jsp";
    }

    @RequestMapping("/showAddr")
    public void showAddr(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        response.setContentType("text/html;utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String uname=String.valueOf(session.getAttribute("info"));
        if (StringUtils.isEmpty(uname)) {
            out.print("<script>confirm('亲，请先登录！');window.location.href='../login.jsp';</script>");
        }
        User user = userService.selectByUname(uname);
        List<Address> addressList = addressService.selectAll(user.getuId());
        session.setAttribute("addressList", addressList);
    }

    @RequestMapping("/deleteAddr")
    @ResponseBody
    public void deleteAddr(@RequestBody String aId, HttpServletRequest request, HttpServletResponse response) throws Exception{
        response.setContentType("text/html;utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        session.removeAttribute("addressList");
        PrintWriter out = response.getWriter();
        Integer uid=Integer.parseInt(String.valueOf(session.getAttribute("uid")));
        if (uid == null) {
            out.print("<script>confirm('亲，请先登录！');window.location.href='../login.jsp';</script>");
        }
        addressService.delete(aId.split("=")[1]);
        List<Address> addressList = addressService.selectAll(uid);
        session.setAttribute("addressList", addressList);
    }

    @RequestMapping("/goodsForType")
    public String selectByTid(int tId, HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<Goods> list = goodsService.selectByTid(tId);
        Type type = typeService.selectByTid(tId);
        session.setAttribute("typeGoods", list);
        session.setAttribute("type", type);
        return "redirect:../list.jsp";
    }

    @RequestMapping("/searchInfo")
    public String getSearchInfo(String keyword, String uname) {
        List<Type> listType = typeService.selectAllType();
        List<Goods> listGoods = goodsService.selectAll();
        if (keyword == null || keyword.equals("")) {
            return "redirect:../index.jsp";
        } else {
            for (Type t : listType) {
                if (t.gettName().contains(keyword)) {
                    return "redirect:/goods/goodsForType?tId=" + t.gettId();
                }
            }
            for (Goods g : listGoods) {
                if (g.getgName().equals(keyword)) {
                    return "redirect:/goods/getOne?id=" + g.getgId() + "&uname=" + uname;
                }
            }
        }
        return "redirect:../index.jsp";
    }

    @RequestMapping("/history")
    @ResponseBody
    public HistoryVO getHistory(@RequestBody HistoryVO historyVO) {
        SearchHistoryService searchHistoryService = new SearchHistoryService();
        System.out.println(historyVO.getKeyword());
        int uid = 0;
        List<String> list = null;
        User user = userService.selectByUname(historyVO.getUname());
        if (user == null) {
            uid = 123;
            searchHistoryService.updateList(uid, historyVO.getKeyword());
            historyVO.setList(searchHistoryService.getAutoMatchs(uid, historyVO.getKeyword().substring(0, 1)));
            return historyVO;
        }
        uid = user.getuId();
        searchHistoryService.updateList(uid, historyVO.getKeyword());
        historyVO.setList(searchHistoryService.getAutoMatchs(uid, historyVO.getKeyword().substring(0, 1)));
        return historyVO;
    }

    @RequestMapping("/show")
    public String getTo() {
        orderService.update();
        return "redirect:../index.jsp";
    }

    @RequestMapping("/location")
    @ResponseBody
    public void locatedGoods(@RequestBody PositionVO vo,
                               HttpServletRequest request, HttpServletResponse response) {
        if( vo!=null && StringUtils.isNotBlank(vo.getProvince())){
            String id=goodsMapper.getIdOfProvince(vo.getProvince());
            if(StringUtils.isNotBlank(id)){
                List<Goods> goodsList=goodsMapper.listGoodsOfLocate(id);
                if(goodsList!=null){
                    request.getSession().setAttribute("goodLocatedList",goodsList);
                }
            }
        }
    }
}

