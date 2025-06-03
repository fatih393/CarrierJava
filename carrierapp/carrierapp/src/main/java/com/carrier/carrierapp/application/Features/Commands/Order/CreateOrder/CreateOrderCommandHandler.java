package com.carrier.carrierapp.application.Features.Commands.Order.CreateOrder;

import com.carrier.carrierapp.application.Features.Mediator.RequestHandler;
import com.carrier.carrierapp.application.Services.ICarrierService;
import com.carrier.carrierapp.application.Services.IOrderService;
import com.carrier.carrierapp.application.repositories.carrier.ICarrierReadRepository;
import com.carrier.carrierapp.application.repositories.order.IOrderWriteRepository;
import com.carrier.carrierapp.domain.entity.Carrier;
import com.carrier.carrierapp.domain.entity.Order;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class CreateOrderCommandHandler implements RequestHandler<CreateOrderCommandRequest, CreateOrderCommandResponse> {
   private final IOrderWriteRepository writeRepository;
   private final ICarrierReadRepository carrierReadRepository;
    private final ICarrierService carrierService;
    private final IOrderService orderService;
    public CreateOrderCommandHandler(IOrderWriteRepository writeRepository, ICarrierReadRepository carrierReadRepository, ICarrierService carrierService, IOrderService orderService) {
        this.writeRepository = writeRepository;
        this.carrierReadRepository = carrierReadRepository;
        this.carrierService = carrierService;
        this.orderService = orderService;
    }

    @Override
    public CreateOrderCommandResponse handle(CreateOrderCommandRequest request) {
        ModelMapper modelMapper = new ModelMapper();
        Order orderEntity = modelMapper.map(request, Order.class);
        orderEntity.setOrderDate(new Date());
        orderEntity.setId(0);

      Carrier carrier =  carrierService.getByIdCarrier(request.getCarrierId());
        orderEntity.setCarrier(carrier);



         boolean control =   orderService.addOrder(orderEntity);
         if (control)
             return new CreateOrderCommandResponse("Kayıt başarılı");
         return new CreateOrderCommandResponse("Kayıt başarısız");



    }
}
