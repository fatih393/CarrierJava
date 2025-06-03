package com.carrier.carrierapp.application.Features.Mediator;

public interface RequestHandler <TRequest extends Request<TResponse>, TResponse> {
    TResponse handle(TRequest request);
}
