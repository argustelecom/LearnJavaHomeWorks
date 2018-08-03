package ru.levelp.weld;

import org.jboss.weld.interceptor.proxy.InterceptionContext;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Logged
@Interceptor
public class LoggerInterceptor {
    @AroundInvoke
    public Object onInvoke(InvocationContext ctx) throws Exception {
        long start = System.currentTimeMillis();
        Object result = ctx.proceed();
        long end = System.currentTimeMillis();

        System.out.println("Time: " +
                ctx.getMethod().getName() +
                ", " + (end - start) + " ms");

        return result;
    }
}
