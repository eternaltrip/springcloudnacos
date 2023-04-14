package org.yj.config.sentinel;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 因为sentinel的异常返回都是限流
 * 所以这里对不同的异常做不同的返回信息说明
 */
@Component
public class SentinelExceptionHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        String msg ="未知异常";
        int status =429;
        if( e instanceof FlowException){
            msg ="请求被限流";
        }else if(e instanceof ParamFlowException){
            msg ="请求被热点参数限流";
        }else if(e instanceof DegradeException){
            msg ="请求被降级";
        }else if(e instanceof AuthorityException){
            msg ="没有权限访问";
            status = 401;
        }
        httpServletResponse.setStatus(status);
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.getWriter().println("{\"msg\":\"" + msg + "\" , \"stauts\":\"" + status +"\"}");
    }
}
