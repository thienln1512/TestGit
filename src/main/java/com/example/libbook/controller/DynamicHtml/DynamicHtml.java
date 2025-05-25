package com.example.libbook.controller.DynamicHtml;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DynamicHtml {

    @GetMapping("/fragment/footer")
    public String getFooterFragment() {
        return "components/footer :: footer";
    }

    @GetMapping("/fragment/nav")
    public String getNavFragment() {
        return "components/navbar :: navbar";
    }

}
