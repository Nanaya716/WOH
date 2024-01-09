package edu.cqie.ssm.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;

public class PageRequestHandlerMethodArgumentResolver extends PageableHandlerMethodArgumentResolver {
    /**
     * {@link PageableHandlerMethodArgumentResolver} SpringData 提供的只能解析 {@link Pageable} 类型的
     * 这里让它也能解析它的子类 {@link PageRequest}
     *
     * @param parameter
     * @return
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return Pageable.class.isAssignableFrom(parameter.getParameterType());
    }
}
