package com.carrier.carrierapp.application.Features.Commands.Order.DeleteOrder;

import com.carrier.carrierapp.application.Features.Mediator.RequestHandler;
import com.carrier.carrierapp.application.Services.IOrderService;
import com.carrier.carrierapp.application.repositories.order.IOrderWriteRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteOrderCommandHandler implements RequestHandler<DeleteOrderCommandRequest, DeleteOrderCommandResponse> {

private final IOrderService orderService;
    public DeleteOrderCommandHandler( IOrderService orderService) {

        this.orderService = orderService;
    }

    @Override
    public DeleteOrderCommandResponse handle(DeleteOrderCommandRequest request) {
       boolean control = orderService.deleteOrder(request.getID());
       if (control)
           return new DeleteOrderCommandResponse("Silme başarılı");
       return new DeleteOrderCommandResponse("Silme başarısız");
    }
}
