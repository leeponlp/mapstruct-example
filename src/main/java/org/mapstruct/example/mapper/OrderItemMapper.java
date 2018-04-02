
package org.mapstruct.example.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.example.dto.list.OrderItem;
import org.mapstruct.example.dto.list.OrderItemDTO;
import org.mapstruct.factory.Mappers;

/**
 * @Author: 苏小城
 * @Description:
 * @Date: Created in 18:51 2018/3/27
 */
@Mapper
public interface OrderItemMapper {

    OrderItemMapper MAPPER = Mappers.getMapper(OrderItemMapper.class);

    OrderItem toOrder(OrderItemDTO orderItemDto);

    @InheritInverseConfiguration
    OrderItemDTO fromOrder(OrderItem orderItem);
}
