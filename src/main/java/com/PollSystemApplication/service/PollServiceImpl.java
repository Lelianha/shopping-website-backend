package com.PollSystemApplication.service;

import com.PollSystemApplication.model.Poll;
import com.PollSystemApplication.model.User;
import com.PollSystemApplication.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PollServiceImpl implements PollService {

    @Autowired
    PollRepository pollRepository;

    @Override
    public Long createPoll(Poll poll) {
        return pollRepository.createPoll(poll);
    }

    @Override
    public Poll getPollById(Long  pollId) {
        return pollRepository.getPollById(pollId);
    }

    @Override
    public void deletePollById(Long pollId) {pollRepository.deletePollById(pollId);}

    @Override
    public void updatePollById(Long pollId, Poll poll){
        pollRepository.updatePollById(pollId, poll);
    }



        }


