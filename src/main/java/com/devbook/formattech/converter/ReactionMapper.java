package com.devbook.formattech.converter;

import com.devbook.formattech.Dto.ReactionDto;
import com.devbook.formattech.entity.Reaction;
import org.springframework.stereotype.Component;

@Component
public class ReactionMapper {


    public static ReactionDto reactionDto  (Reaction reaction){

        ReactionDto reactionDto = new ReactionDto();
        reactionDto.setId(reaction.getId());
        reactionDto.setType(reaction.getType());
        return reactionDto;

    }


    public static Reaction reaction(ReactionDto reactionDto){

        Reaction reaction = new Reaction();
        reaction.setId(reactionDto.getId());
        reaction.setType(reactionDto.getType());
        return reaction;
    }
}
