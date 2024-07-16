package com.devbook.formattech.service.implementation;

import com.devbook.formattech.Dto.FriendShipDto;
import com.devbook.formattech.converter.FriendShipMapper;
import com.devbook.formattech.entity.FriendShip;
import com.devbook.formattech.entity.User;
import com.devbook.formattech.exceptions.ResourceNotFoundException;
import com.devbook.formattech.repository.FriendShipRepository;
import com.devbook.formattech.service.FriendShipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class FriendShipServiceImpl  implements FriendShipService {

  private static final Logger log = LoggerFactory.getLogger(CountryServiceImpl.class);

  @Autowired
  private FriendShipRepository friendShipRepository;

  @Autowired
  private FriendShipMapper friendShipMapper;

  @Override
  public FriendShipDto createFriendShip(FriendShipDto friendShipDto) {
    FriendShip friendShip = friendShipMapper.friendShip(friendShipDto);
    friendShip = friendShipRepository.save(friendShip);
    return friendShipMapper.friendShipDto(friendShip);
  }

  @Override
  public List<FriendShipDto> getAllFriendShips() {
    return friendShipRepository.findAll().stream()
            .map(FriendShipMapper::friendShipDto).collect(Collectors.toUnmodifiableList());
  }

  @Override
  public FriendShipDto getFriendShipById(int id) {
    return friendShipRepository.findById(id)
            .map(FriendShipMapper::friendShipDto)
            .orElseThrow(() -> new ResourceNotFoundException("Friendship not found with id: " + id));
  }

  @Override
  public FriendShipDto updateFriendShip(int id, FriendShipDto friendShipDto) {
    FriendShip existingFriendShip = friendShipRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Friendship not found with id: " + id));
    existingFriendShip.setStatus(friendShipDto.getStatus());
    FriendShip updatedFrienship = friendShipRepository.save(existingFriendShip);
    return friendShipMapper.friendShipDto(updatedFrienship);
  }

  public FriendShip deleteFriendShip(int id) {
    FriendShip friendShip = friendShipRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    friendShip.setActive(false);
    return friendShipRepository.save(friendShip);
  }

}
