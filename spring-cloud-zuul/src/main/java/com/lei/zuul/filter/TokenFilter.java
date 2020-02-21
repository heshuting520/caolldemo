package com.lei.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;


public class TokenFilter extends ZuulFilter {
    private final Logger logger = LoggerFactory.getLogger(TokenFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();

        logger.info("--->>> TokenFilter {},{}", httpServletRequest.getMethod(), httpServletRequest.getRequestURL().toString());

        String token = httpServletRequest.getParameter("token");
        if(StringUtils.isNotBlank(token)){
            requestContext.setResponseStatusCode(200);
            requestContext.setSendZuulResponse(true);
            requestContext.set("isSuccess", true);
            return null;

        } else {
            requestContext.setSendZuulResponse(false); //不对其进行路由
            requestContext.setResponseStatusCode(400);
            requestContext.setResponseBody("token is empty");
            requestContext.set("isSuccess", false);
            return null;
        }
    }
}
