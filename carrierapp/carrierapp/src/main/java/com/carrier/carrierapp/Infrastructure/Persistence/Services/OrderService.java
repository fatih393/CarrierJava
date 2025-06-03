package com.carrier.carrierapp.Infrastructure.Persistence.Services;

import com.carrier.carrierapp.application.Services.IOrderService;
import com.carrier.carrierapp.application.repositories.order.IOrderReadRepository;
import com.carrier.carrierapp.application.repositories.order.IOrderWriteRepository;
import com.carrier.carrierapp.domain.entity.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderService implements IOrderService {
  private final IOrderWriteRepository writeRepository;
  private  final IOrderReadRepository readRepository;


    public OrderService(IOrderWriteRepository writeRepository, IOrderReadRepository readRepository) {
        this.writeRepository = writeRepository;
        this.readRepository = readRepository;
    }

    @Override
    public boolean addOrder(Order order) {
        try{
            writeRepository.save(order);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean updateOrder(Order updateOrder) {
        System.out.println(updateOrder);
       return writeRepository.update(updateOrder);
    }

    @Override
    public boolean deleteOrder(int id) {
       return writeRepository.deleteById(id);
    }

    @Override
    public List<Order> getAllOrder() {
        return readRepository.findAll();
    }
    @Override
    public  Order getById(int id){
       Optional<Order> order = readRepository.findById(id);
       return order.get();
    }
}
