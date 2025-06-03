package com.carrier.carrierapp.application.Features.Commands.Order.UpdateOrder;

import com.carrier.carrierapp.application.Features.Mediator.RequestHandler;
import com.carrier.carrierapp.application.Services.ICarrierService;
import com.carrier.carrierapp.application.Services.IOrderService;
import com.carrier.carrierapp.application.repositories.carrier.ICarrierReadRepository;
import com.carrier.carrierapp.application.repositories.order.IOrderReadRepository;
import com.carrier.carrierapp.application.repositories.order.IOrderWriteRepository;
import com.carrier.carrierapp.domain.entity.Carrier;
import com.carrier.carrierapp.domain.entity.Order;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class UpdateOrderCommandHandler implements RequestHandler<UpdateOrderCommandRequest, UpdateOrderCommandResponse> {
private final IOrderService orderService;
private final ICarrierService carrierService;
    public UpdateOrderCommandHandler(IOrderService orderService, ICarrierService carrierService) {

        this.orderService = orderService;
        this.carrierService = carrierService;
    }

    @Override
    public UpdateOrderCommandResponse handle(UpdateOrderCommandRequest request) {
        ModelMapper modelMapper = new ModelMapper();
        Order orderEntity = orderService.getById(request.getID());
        Date createDate = orderEntity.getOrderDate();
        orderEntity = modelMapper.map(request, Order.class);
        orderEntity.setOrderDate(createDate);



        Carrier carrierEntity = carrierService.getByIdCarrier(request.getCarrierId());

        orderEntity.setCarrier(carrierEntity);

        boolean control = orderService.updateOrder(orderEntity);
        if (control)
            return  new UpdateOrderCommandResponse("guncelleme başarılı");
        return new UpdateOrderCommandResponse("guncelleme başarısız");
    }
}
