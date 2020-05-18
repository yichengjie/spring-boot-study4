package com.yicj.study.filter;

import com.yicj.study.util.AppContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
@Slf4j
public class FirstFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("进入 FirstFilter ");
        String userName = request.getParameter("name") ;
        try {
            AppContext.setUserName(userName);
            chain.doFilter(request, response);
        }finally {
            AppContext.clear();
        }
    }
}
