package com.example.farmingholiday.service;

import com.example.farmingholiday.domain.Host;
import com.example.farmingholiday.dto.BlockHostDto;
import com.example.farmingholiday.dto.HostDto;
import com.example.farmingholiday.repository.HostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HostService {
    final private HostRepository hostRepository;

    public HostService(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    public HostDto getHost(long id){
        Optional<Host> host = hostRepository.findById(id);
        return host.map(HostDto::from).orElse(null);
    }

    public List<BlockHostDto> getBlockHost(){
        List<Host> hosts = hostRepository.findAll();
        return hosts.stream()
                .map(BlockHostDto::from)
                .collect(Collectors.toList());
    }
}
