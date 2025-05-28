package com.marina.springlavanderia.mapper;

import com.marina.springlavanderia.DTO.PedidoItemDTO;
import com.marina.springlavanderia.DTO.PedidosDTO;
import com.marina.springlavanderia.model.PedidoItem;
import com.marina.springlavanderia.model.Pedidos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    PedidosDTO toDTO(Pedidos pedido);
    Pedidos toEntity(PedidosDTO dto);

    PedidoItemDTO toItemDTO(PedidoItem item);
    PedidoItem toItemEntity(PedidoItemDTO dto);

    List<PedidoItemDTO> toItemDTOs(List<PedidoItem> itens);
    List<PedidoItem> toItemEntities(List<PedidoItemDTO> dtos);

    @Mapping(target = "id", ignore = true) // evita sobrescrever ID acidental
    void updateEntityFromDTO(PedidosDTO dto, @MappingTarget Pedidos entity);

}
