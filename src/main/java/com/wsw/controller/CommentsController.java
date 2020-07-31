package com.wsw.controller;

import com.wsw.entity.db.Comments;
import com.wsw.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @RequestMapping("/addComments")
    public String CommentsInfo(Comments cComment, int gId, HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println(cComment);
        commentsService.insert(cComment);
        List<Comments> list = commentsService.selectAll(gId);
        session.setAttribute("commentsList", list);
        return "redirect:../iemt.jsp";
    }
}
