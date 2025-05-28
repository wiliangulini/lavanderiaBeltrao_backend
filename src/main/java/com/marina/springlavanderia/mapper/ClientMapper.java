package com.marina.springlavanderia.mapper;

import com.marina.springlavanderia.DTO.ClientDTO;
import com.marina.springlavanderia.model.Client;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDTO toDTO(Client client);
    Client toEntity(ClientDTO dto);

    List<ClientDTO> toDTOs(List<Client> clients);
}
