package com.rzdp.treeflexapigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.bouncycastle.cert.ocsp.Req;
import org.springframework.stereotype.Component;

public class RelayAccessTokenFilter extends ZuulFilter {

    private static final String FILTER_TYPE = "pre";
    private static final Integer FILTER_ORDER = 1;
    private static final Boolean SHOULD_FILTER = true;

    @Override
    public String filterType() {
        return FILTER_TYPE;
    }

    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return SHOULD_FILTER;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext context = RequestContext.getCurrentContext();

        return null;
    }
}
