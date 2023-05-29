package com.itmy.edo.common.filter;

import cn.hutool.core.lang.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

@WebFilter(urlPatterns = "/*")
public class LogFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        long start = System.currentTimeMillis();
        String uuid = UUID.randomUUID().toString();
        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request, 1024*10);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);
        filterChain.doFilter(requestWrapper, responseWrapper);
        //打印请求日志
        printRequestLog(requestWrapper, uuid);
        //打印响应日志
        long end = System.currentTimeMillis();
        printResponseLog(request, responseWrapper, end - start, uuid);
    }

    @Override
    public void destroy() {

    }

    /**
     * 打印请求日志
     */
    private void printRequestLog(ContentCachingRequestWrapper cachingRequestWrapper, String uuid){
        try {
            if (!cachingRequestWrapper.getMethod().equals("OPTIONS")) {
                String body = new String(cachingRequestWrapper.getContentAsByteArray(), StandardCharsets.UTF_8);
                String params = getParamsStr(cachingRequestWrapper);
                logger.info("接口调用标识:{}, 接口:{}, 请求方式:{}, 请求参数:{}, 请求体:{}, 调用时间:{}", uuid, cachingRequestWrapper.getRequestURI(),
                        cachingRequestWrapper.getMethod(), params, body, LocalDateTime.now().toString().replace("T", " "));
            }
        }catch (Exception e){
            logger.error("日志打印错误:{}", cachingRequestWrapper.getRequestURI(), e);
        }
    }

    /**
     * 打印响应日志
     */
    private void printResponseLog(HttpServletRequest request, ContentCachingResponseWrapper responseWrapper, Long times, String uuid) {
        try {
            if (!request.getMethod().equals("OPTIONS")) {
                String params = getParamsStr(request);
                String responseBody = new String(responseWrapper.getContentAsByteArray(), StandardCharsets.UTF_8);
                responseWrapper.copyBodyToResponse();
                logger.info("接口调用标识:{}, 接口:{}, 参数:{}, 响应体:{}, 响应时间:{}, 执行时长:{}ms", uuid, request.getRequestURI(),
                        params, responseBody, LocalDateTime.now().toString().replace("T", " "), times);
            }
        }catch (Exception e){
            logger.error("日志打印错误:{}", request.getRequestURI(), e);
        }
    }

    private String getParamsStr(HttpServletRequest request){
        StringBuilder params = new StringBuilder();
        if(request.getParameterMap() != null && request.getParameterMap().size() > 0){
            Set<Map.Entry<String, String[]>> entries = request.getParameterMap().entrySet();
            for(Map.Entry<String, String[]> entry : entries){
                String key = entry.getKey();
                String[] values = entry.getValue();
                if(values != null && values.length > 0){
                    params.append(key).append("=");
                    for(String value : values){
                        params.append(value).append(",");
                    }
                    params.deleteCharAt(params.length() - 1);
                    params.append("&");
                }
            }
            params.deleteCharAt(params.length() - 1);
        }
        return params.toString();
    }
}
