package com.marina.springlavanderia.service;

import com.marina.springlavanderia.DTO.ClientDTO;
import com.marina.springlavanderia.mapper.ClientMapper;
import com.marina.springlavanderia.model.Client;
import com.marina.springlavanderia.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    public List<ClientDTO> listarTodos() {
        return clientMapper.toDTOs(clientRepository.findAll());
    }

    public Optional<ClientDTO> buscarPorId(Long id) {
        return clientRepository.findById(id).map(clientMapper::toDTO);
    }

    public ClientDTO salvar(ClientDTO dto) {
        Client client = clientMapper.toEntity(dto);
        return clientMapper.toDTO(clientRepository.save(client));
    }

    public Optional<ClientDTO> atualizar(Long id, ClientDTO dto) {
        return clientRepository.findById(id).map(existing -> {
            dto.setId(id); // garante que o ID não mude
            Client atualizado = clientMapper.toEntity(dto);
            return clientMapper.toDTO(clientRepository.save(atualizado));
        });
    }

    public boolean deletar(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
