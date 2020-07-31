package com.wsw.controller;

import com.wsw.converter.UserConverter;
import com.wsw.entity.db.Goods;
import com.wsw.entity.db.Message;
import com.wsw.entity.db.Type;
import com.wsw.entity.db.User;
import com.wsw.service.GoodsService;
import com.wsw.service.ShoppingcartService;
import com.wsw.service.TypeService;
import com.wsw.service.UserService;
import com.wsw.entity.vo.UserRegVO;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private ShoppingcartService shoppingcartService;

    private Message msg = new Message();

    @RequestMapping("/checkUname")
    @ResponseBody
    public Message checkUname(@RequestBody UserRegVO userRegVO) {
        String uname = userRegVO.getUName();
        if (uname.equals("") || uname == null) {
            msg.setMessage("用户名不能为空!");
            return msg;
        } else if (uname.length() < 4 || uname.contains(" ") || uname.contains("_")) {
            msg.setMessage("用户名输入有误!");
            return msg;
        }
        return null;
    }

    @RequestMapping("/checkURelname")
    @ResponseBody
    public Message checkURealname(@RequestBody UserRegVO userRegVO) {
        String uRealName = userRegVO.getURealName();
        String regx = "[\\u4E00-\\u9FA5]{2,5}(?:·[\\u4E00-\\u9FA5]{2,5})*";
        if (uRealName.equals("") || uRealName == null) {
            msg.setMessage("姓名不能为空!");
            return msg;
        } else if (!uRealName.matches(regx)) {
            msg.setMessage("姓名输入有误!");
            return msg;
        }
        return null;
    }

    @RequestMapping("/checkUTel")
    @ResponseBody
    public Message checkUTel(@RequestBody UserRegVO userRegVO) {
        String uTel = userRegVO.getUTel();
        String regx = "^[1]+[3,,5,7,8]+\\d{9}$";
        if (uTel.equals("") || uTel == null) {
            msg.setMessage("电话号码不能为空!");
            return msg;
        } else if (!uTel.matches(regx)) {
            msg.setMessage("电话号码输入有误!");
            return msg;
        }
        return null;
    }

    @RequestMapping("/checkPassword")
    @ResponseBody
    public Message checkUpass(@RequestBody UserRegVO userRegVO) {
        String pwd = userRegVO.getPassword();
        String regx = "\\w{4,6}\\d{4,6}";
        if (pwd.equals("") || pwd == null) {
            msg.setMessage("密码不能为空!");
            return msg;
        } else if (!pwd.matches(regx)) {
            msg.setMessage("密码输入有误!");
            return msg;
        }
        return null;
    }

    @RequestMapping("/checkCpwd")
    @ResponseBody
    public Message checkUcpass(@RequestBody UserRegVO userRegVO) {
        String pwd = userRegVO.getPassword();
        String cpwd = userRegVO.getCheckPassword();
        if (cpwd.equals("") || cpwd == null) {
            msg.setMessage("密码不能为空!");
            return msg;
        } else if (!pwd.equals(cpwd)) {
            msg.setMessage("两次密码输入不一致!");
            return msg;
        }
        return null;
    }

    @RequestMapping("/userReg")
    public String doReg(UserRegVO userRegVO) {
        User user = UserConverter.userConverter(userRegVO);
        if (user.equals("") || user == null) {
            return "redirect:../register.jsp";
        }
        //用户名已被注册
        User user2 = userService.selectByUname(user.uName);
        if (user2 != null) {
            return "redirect:../register.jsp";
        }
        //手机号已被注册
        User user3 = userService.selectByTel(user);
        if (user3 != null) {
            return "redirect:../register.jsp";
        }

        userService.reg(user);
        return "redirect:../login.jsp";
    }

    @RequestMapping("/userLogin")
    public String doLogin(UserRegVO userRegVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter out = response.getWriter();
        if (userRegVO == null) {
            out.print("<script>alert('手机号或密码错误！');</script>");
        }
        User user = UserConverter.userConverter(userRegVO);
        if( StringUtils.isNotBlank(user.getuPassword())){
            user.setuPassword(DigestUtils.md5Hex(user.getuPassword()));
        }
        response.setContentType("text/html;utf-8");
        response.setCharacterEncoding("utf-8");
        User user2 = userService.login(user);
        if (user2 == null) {
            out.print("<script>window.location.href='../login.jsp';</script>");
        }
        HttpSession session = request.getSession();
        List<Goods> list = goodsService.selectAll();
        session.setAttribute("goods", list);
        if (user2 != null) {
            session.setAttribute("uid", user2.getuId());
            session.setAttribute("info", user2.getuName());
            return "redirect:../index.jsp";
        }
        return "redirect:../login.jsp";
    }

    @ResponseBody
    @RequestMapping("/getCount")
    public Message getCount(String uname, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;utf-8");
        response.setCharacterEncoding("utf-8");
        System.out.println(uname);
        if (uname.equals("") || uname == null) {
            return null;
        }
        Message message = new Message();
        User user = userService.selectByUname(uname);
        int count = shoppingcartService.selectCountByUid(user.getuId());
        message.setMessage(String.valueOf(count));
        return message;
    }

    @RequestMapping("/getInfo")
    public String getInfo(HttpServletRequest request) {
        List<Type> list = typeService.selectAllType();
        List<Goods> list2 = goodsService.selectTen();
        List<Goods> list3 = goodsService.selectNew();
        HttpSession session = request.getSession();
        session.setAttribute("typeList", list);
        session.setAttribute("goodList", list2);
        session.setAttribute("goodsNew", list3);
        return "redirect:../index.jsp";
    }

    @RequestMapping("/update")
    public String update(String uname, HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;utf-8");
        response.setCharacterEncoding("utf-8");
        if (uname.equals("") || uname == null) {
            out.print("<script>confirm('亲，请先登录！');window.location.href='../login.jsp';</script>");
            return null;
        }
        User user = userService.selectByUname(uname);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        return "redirect:../usersub.jsp";
    }

    @RequestMapping("/doUpdate")
    public String update(int id, User user, HttpServletRequest request, HttpServletResponse response) throws Exception {
        user.setuId(id);
        userService.update(user);
        HttpSession session = request.getSession();
        session.setAttribute("user", userService.selectByUid(id));
        return "redirect:../usersub.jsp";
    }

    @RequestMapping("/exit")
    public String exit(String flag, HttpServletRequest request) {
        if (StringUtils.isEmpty(flag)) {
            return null;
        }
        if (Objects.equals("exit", flag)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", null);
            return "redirect:../login.jsp";
        }
        return "";
    }


}
