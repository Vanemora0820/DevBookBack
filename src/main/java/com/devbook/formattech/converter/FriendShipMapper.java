package com.devbook.formattech.converter;


import com.devbook.formattech.Dto.FriendShipDto;
import com.devbook.formattech.entity.FriendShip;
import org.springframework.stereotype.Component;

@Component
public class FriendShipMapper {

    public static FriendShipDto friendShipDto (FriendShip friendShip) {

        FriendShipDto friendShipDto = new FriendShipDto();
        friendShipDto.setId(friendShip.getId());
        friendShipDto.setStatus(friendShip.getStatus());
        return friendShipDto;
    }

    public static FriendShip friendShip (FriendShipDto friendShipDto) {

        FriendShip friendShip = new FriendShip();
        friendShip.setId(friendShipDto.getId());
        friendShip.setStatus(friendShipDto.getStatus());
        return friendShip;
    }
}
