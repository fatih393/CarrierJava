package com.carrier.carrierapp.application.Features.Mediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Mediator {

    private final ApplicationContext context;

    @Autowired
    public Mediator(ApplicationContext context) {
        this.context = context;
    }

    @SuppressWarnings("unchecked")
    public <TResponse, TRequest extends Request<TResponse>> TResponse send(TRequest request) {
        String handlerBeanName = getHandlerBeanName(request.getClass());
        Object handlerBean = context.getBean(handlerBeanName);

        RequestHandler<TRequest, TResponse> handler = (RequestHandler<TRequest, TResponse>) handlerBean;
        return handler.handle(request);
    }

    private String getHandlerBeanName(Class<?> requestClass) {
        String handlerClassName = requestClass.getSimpleName().replace("Request", "Handler");
        return Character.toLowerCase(handlerClassName.charAt(0)) + handlerClassName.substring(1);
    }
}
