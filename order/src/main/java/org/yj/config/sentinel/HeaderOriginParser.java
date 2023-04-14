package org.yj.config.sentinel;


import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import com.mysql.cj.util.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


/**
 * sentinel的过滤，白名单或者黑名单
 */
@Component
public class HeaderOriginParser implements RequestOriginParser {

    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {

        String origin = httpServletRequest.getHeader("origin");
        if(StringUtils.isNullOrEmpty(origin)){
            origin = "blank";
        }
        return origin;
    }
}
