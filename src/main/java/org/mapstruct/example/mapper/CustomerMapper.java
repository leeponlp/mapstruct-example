package org.mapstruct.example.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.example.dto.list.Customer;
import org.mapstruct.example.dto.list.CustomerDTO;
import org.mapstruct.factory.Mappers;

/**
 * @Author: 苏小城
 * @Description:
 * @Date: Created in 18:51 2018/3/27
 */
@Mapper(uses = { OrderItemMapper.class })
public interface CustomerMapper {

    CustomerMapper MAPPER = Mappers.getMapper( CustomerMapper.class );

    @Mappings({
        @Mapping(source = "orders", target = "orderItems"),
        @Mapping(source = "customerName", target = "name")
    })
    Customer toCustomer(CustomerDTO customerDTO);

    @InheritInverseConfiguration
    CustomerDTO fromCustomer(Customer customer);
}
