package com.example.farmingholiday.service;

import com.example.farmingholiday.domain.FarmingHoliday;
import com.example.farmingholiday.domain.Guest;
import com.example.farmingholiday.domain.Hashtag;
import com.example.farmingholiday.domain.Host;
import com.example.farmingholiday.domain.LikeFarmingHoliday;
import com.example.farmingholiday.domain.LikeHost;
import com.example.farmingholiday.dto.home.BlockHostDto;
import com.example.farmingholiday.dto.detail.HostDto;
import com.example.farmingholiday.repository.FarmingHolidayRepository;
import com.example.farmingholiday.repository.GuestRepository;
import com.example.farmingholiday.repository.HashtagRepository;
import com.example.farmingholiday.repository.HostRepository;
import com.example.farmingholiday.repository.LikeHostRepository;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HostService {
    private final HostRepository hostRepository;
    private final HashtagRepository hashtagRepository;
    private final FarmingHolidayRepository farmingHolidayRepository;
    private final GuestRepository guestRepository;
    private final LikeHostRepository likeHostRepository;

    public HostDto getDetailHost(long farmingHolidayId, long guestId){
        FarmingHoliday farmingHoliday = farmingHolidayRepository.findById(farmingHolidayId).orElse(null);
        Host host = farmingHoliday.getHost();
        Guest guest = guestRepository.findById(guestId).orElse(null);
        boolean isLike = likeHostRepository.findByHostAndGuest(host, guest).isPresent();
        return HostDto.from(host, findHashtag(host), isLike);
    }

    public List<BlockHostDto> get4BlockHost(long guestId){
        List<Host> hosts = hostRepository.findTop4ByOrderByRateDesc();
        return hosts.stream()
            .map(e-> BlockHostDto.from(e, findHashtag(e), getLikeHostList(guestId).contains(e)))
            .collect(Collectors.toList());
    }

    public List<BlockHostDto> getBlockHost(long guestId){
        List<Host> hosts = hostRepository.findAll();
        return hosts.stream()
            .map(e-> BlockHostDto.from(e, findHashtag(e), getLikeHostList(guestId).contains(e)))
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

    private List<Host> getLikeHostList(long guestId){
        Guest guest = guestRepository.findById(guestId).orElse(null);
        return likeHostRepository.findAllByGuest(guest).stream()
            .map(LikeHost::getHost).toList();
    }
}
