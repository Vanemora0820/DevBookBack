package com.devbook.formattech.service.implementation;

import com.devbook.formattech.Dto.ReactionDto;
import com.devbook.formattech.converter.ReactionMapper;
import com.devbook.formattech.entity.Reaction;
import com.devbook.formattech.entity.User;
import com.devbook.formattech.exceptions.ResourceNotFoundException;
import com.devbook.formattech.repository.ReactionRepository;
import com.devbook.formattech.service.ReactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ReactionServiceImpl implements ReactionService {

    private static final Logger log = LoggerFactory.getLogger(ReactionService.class);

    @Autowired
    private ReactionRepository reactionRepository;

    @Autowired
    private ReactionMapper reactionMapper;


    @Override
    public ReactionDto createReaction(ReactionDto reactionDto) {
        Reaction reaction = reactionMapper.reaction(reactionDto);
        reaction = reactionRepository.save(reaction);
        return reactionMapper.reactionDto(reaction);
    }

    @Override
    public List<ReactionDto> getAllReactions() {
        return reactionRepository.findAll().stream()
                .map(ReactionMapper::reactionDto).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public ReactionDto getReactionById(int id) {
        return reactionRepository.findById(id)
                .map(ReactionMapper::reactionDto)
                .orElseThrow(() -> new ResourceNotFoundException("Reaction not found with id: " + id));
    }

    @Override
    public ReactionDto updateReaction(int id, ReactionDto reactionDto) {
        Reaction existingReaction = reactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reaction not found with id: " + id));
        existingReaction.setType(reactionDto.getType());
        Reaction updatedReaction = reactionRepository.save(existingReaction);
        return reactionMapper.reactionDto(updatedReaction);
    }

    public Reaction deleteReaction(int id) {
        Reaction reaction = reactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        reaction.setActive(false);
        return reactionRepository.save(reaction);
    }

}
