package com.devbook.formattech.service;

import com.devbook.formattech.Dto.FriendShipDto;
import com.devbook.formattech.entity.FriendShip;

import java.util.List;

public interface FriendShipService {
  FriendShipDto createFriendShip(FriendShipDto friendShipDto);

  List<FriendShipDto> getAllFriendShips();

  FriendShipDto getFriendShipById(int id);

  FriendShipDto updateFriendShip(int id, FriendShipDto friendShipDto);

  FriendShip deleteFriendShip(int id);
}
