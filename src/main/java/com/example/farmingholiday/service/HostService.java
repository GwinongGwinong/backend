package com.example.farmingholiday.service;

import com.example.farmingholiday.domain.FarmingHoliday;
import com.example.farmingholiday.domain.Hashtag;
import com.example.farmingholiday.domain.Host;
import com.example.farmingholiday.domain.House;
import com.example.farmingholiday.dto.BlockHostDto;
import com.example.farmingholiday.dto.HostDto;
import com.example.farmingholiday.repository.FarmingHolidayRepository;
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
    private final FarmingHolidayRepository farmingHolidayRepository;

    public HostDto getDetailHost(long id){
        FarmingHoliday farmingHoliday = farmingHolidayRepository.findById(id).orElse(null);
        Host host = farmingHoliday.getHost();
        return HostDto.from(host, findHashtag(host));
    }

    public List<BlockHostDto> get4BlockHost(){
        List<Host> hosts = hostRepository.findTop4ByOrderByRateDesc();
        return hosts.stream().map(e-> BlockHostDto.from(e, findHashtag(e)))
            .collect(Collectors.toList());
    }

    public List<BlockHostDto> getBlockHost(){
        List<Host> hosts = hostRepository.findAll();
        return hosts.stream().map(e-> BlockHostDto.from(e, findHashtag(e)))
            .collect(Collectors.toList());
    }

    private List<String> findHashtag(Host host){
        List<Hashtag> hashtags = hashtagRepository.findAllByHost(host);
        List<String> hashtagContent = new ArrayList<>();
        for(Hashtag hashtag : hashtags){
            hashtagContent.add(hashtag.getContent());
        }
        return hashtagContent;
    }
}
