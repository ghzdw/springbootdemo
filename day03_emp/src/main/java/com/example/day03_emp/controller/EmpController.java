package com.example.day03_emp.controller;

import com.example.day03_emp.service.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmpController {
    private static Logger logger= LoggerFactory.getLogger(EmpController.class);
    @Resource
    private EmpService empService;
    @Resource
    private FreeMarkerViewResolver freeMarkerViewResolver;
    @RequestMapping("/")
    public String toLogin(){
        return "login";
    }
    @PostMapping("/login") //pwd为空出错400，返回到4xx.ftl
    public  String login(HttpServletRequest request, HttpSession session,
                         @RequestParam(name = "pwd",required = true) String password ){
        Map<String,Object> paramMap=new HashMap<>();
        String username = request.getParameter("username");
        paramMap.put("username",username);
        paramMap.put("pwd",password);
        //mybatis查询不到返回map不会像jdbctemplate那样直接报错，而是返回null
        Map<String, Object> admin = empService.login(paramMap);
        if (admin!=null){
            session.setAttribute("admin",admin);
            return "main";
        }else {
            return "login";
        }
    }

    @GetMapping("/emps")
    public  String getEmps(Map<String,Object> map,HttpServletRequest request){
        List<Map<String, Object>> emps = empService.getEmps();
        //放入到request域对象中，在org.springframework.web.servlet.view.freemarker.FreeMarkerView.buildTemplateModel()
        //中把所有的域对象的属性都组装到了freemarker的数据模型里，所以freemarker可以使用域对象的数据
        map.put("emps",emps);
        System.out.println(freeMarkerViewResolver);
        return "empList";
    }
    //来到员工添加页面
    @GetMapping("/emp")
    public  String toAddOneEmp(){
        return "addEmp";
    }

    @PostMapping("/emp")
    public  String addOneEmp(@RequestParam  Map<String,Object> map){//使用map接受页面传来的参数
        Integer integer = empService.addOneEmp(map);
        logger.info("添加一个员工,返回的值:"+integer);//返回值为1，表示添加成功
        return  "redirect:/emps";
    }
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        Integer integer = empService.deleteEmpById(id);
        logger.info("删除一个员工,返回的值:"+integer);
        if (integer==1){
            logger.info("删除编号为{}的员工成功",id);
        }else {
            logger.info("删除编号为{}的员工失败",id);
        }
        return  "redirect:/emps";
    }

    @GetMapping("/emp/{id}") @ResponseBody
    public Map<String, Object> getEmpById(@PathVariable("id") Integer id,HttpServletRequest request){
        Map<String, Object> empToUpdate = empService.getEmpById(id);
        request.setAttribute("empToUpdate",empToUpdate);
        return empToUpdate;
    }

    @PutMapping("/emp")
    public String deleteEmployee(@RequestParam Map<String,Object> map){
        Integer integer = empService.updateEmpById(map);
        logger.info("修改一个员工,返回的值:"+integer);
        if (integer==1){
            logger.info("修改编号为{}的员工成功",map.get("id"));
        }else {
            logger.info("修改编号为{}的员工失败",map.get("id"));
        }
//        return "empList";//empList没有数据,重复提交
//        return "forward:/emps";//Request method 'PUT' not supported
        return  "redirect:/emps";// 这里/emps是requestMapping的路径，不是页面；
        // 也可以是页面，是页面的时候/指的是src/main/webapp根目录.重定向的方式解决了表单重复提交的问题
    }
}
