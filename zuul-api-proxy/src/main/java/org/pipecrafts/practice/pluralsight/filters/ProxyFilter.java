package org.pipecrafts.practice.pluralsight.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;

/**
 * Created by Aaron Rasing on 3/11/18.
 */
public class ProxyFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        boolean isMobile = false;

        RequestContext context = getCurrentContext();
        String param = context.getRequest().getParameter("source");
        if(param != null && param.equals("mobile")) {
            isMobile = true;
        }

        return isMobile;
    }

    @Override
    public Object run() {

        System.out.println("Calling a filter!");
        return null;
    }
}
