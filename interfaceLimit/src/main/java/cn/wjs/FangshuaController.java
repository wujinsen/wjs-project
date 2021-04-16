package cn.wjs;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FangshuaController {

    @AccessLimit(seconds = 5, maxCount = 5, needLogin = true)
    @RequestMapping("/fangshua")
    @ResponseBody
    public String fangshua() {
        return "";
    }
}
