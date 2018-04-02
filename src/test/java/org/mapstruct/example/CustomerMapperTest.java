/**
 *  Copyright 2012-2017 Gunnar Morling (http://www.gunnarmorling.de/)
 *  and/or other contributors as indicated by the @authors tag. See the
 *  copyright.txt file in the distribution for a full listing of all
 *  contributors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.mapstruct.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.mapstruct.example.dto.list.Customer;
import org.mapstruct.example.dto.list.CustomerDTO;
import org.mapstruct.example.dto.list.OrderItem;
import org.mapstruct.example.dto.list.OrderItemDTO;
import org.mapstruct.example.mapper.CustomerMapper;

/**
 *
 * @author Filip Hrisafov
 */
public class CustomerMapperTest {

    @Test
    public void testMapDtoToEntity() {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.id = 10L;
        customerDTO.customerName = "Filip";
        OrderItemDTO order1 = new OrderItemDTO();
        order1.name = "Table";
        order1.quantity = 2L;
        customerDTO.orderItemDTOs = new ArrayList<>( Collections.singleton( order1 ) );

        Customer customer = CustomerMapper.MAPPER.toCustomer( customerDTO );

        assertThat( customer.getId() ).isEqualTo( 10 );
        assertThat( customer.getName() ).isEqualTo( "Filip" );
        assertThat( customer.getOrderItems() )
            .extracting( "name", "quantity" )
            .containsExactly( tuple( "Table", 2L ) );
    }

    @Test
    public void testEntityDtoToDto() {

        Customer customer = new Customer();
        customer.setId( 10L );
        customer.setName( "Filip" );
        List<OrderItem> orderItems = new ArrayList<>();
        OrderItem orderItem = new OrderItem();
        orderItem.setName( "Table" );
        orderItem.setQuantity( 2L );
        orderItems.add(orderItem);
        customer.setOrderItems(orderItems);

        CustomerDTO customerDto = CustomerMapper.MAPPER.fromCustomer( customer );

        assertThat( customerDto.id ).isEqualTo( 10 );
        assertThat( customerDto.customerName ).isEqualTo( "Filip" );
        assertThat( customerDto.orderItemDTOs )
            .extracting( "name", "quantity" )
            .containsExactly( tuple( "Table", 2L ) );
    }
}
