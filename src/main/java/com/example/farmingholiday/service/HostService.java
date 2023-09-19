package com.example.farmingholiday.service;

import com.example.farmingholiday.domain.Hashtag;
import com.example.farmingholiday.domain.Host;
import com.example.farmingholiday.dto.BlockHostDto;
import com.example.farmingholiday.dto.HostDto;
import com.example.farmingholiday.repository.HashtagRepository;
import com.example.farmingholiday.repository.HostRepository;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HostService {
    private final HostRepository hostRepository;
    private final HashtagRepository hashtagRepository;

    public HostDto getHost(long id){
        Optional<Host> host = hostRepository.findById(id);
        return host.map(HostDto::from).orElse(null);
    }

    public List<BlockHostDto> get4BlockHost(){
        List<Host> hosts = hostRepository.findTop4ByOrderByRateDesc();
        return matchHashtagsToHosts(hosts);
    }

    public List<BlockHostDto> getBlockHost(){
        List<Host> hosts = hostRepository.findAll();
        return matchHashtagsToHosts(hosts);
    }

    private List<BlockHostDto> matchHashtagsToHosts(List<Host> hosts){
        // stream 으로 구현하면 stream 두번 써야해서(어려워서) 이중 for 문으로 만듦
        List<BlockHostDto> blockHostDtos = new ArrayList<>();
        for(Host host : hosts){
            List<Hashtag> hashtags = hashtagRepository.findAllByHost(host);
            List<String> hashtagContent = new ArrayList<>();
            for(Hashtag hashtag : hashtags){
                hashtagContent.add(hashtag.getContent());
            }
            blockHostDtos.add(BlockHostDto.from(host, hashtagContent));
        }
        return blockHostDtos;
    }
}
