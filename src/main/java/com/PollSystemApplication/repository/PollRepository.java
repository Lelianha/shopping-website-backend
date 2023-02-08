package com.PollSystemApplication.repository;
import com.PollSystemApplication.model.Poll;

public interface PollRepository {
    Long createPoll(Poll poll);
    Poll getPollById(Long  pollId);
    void deletePollById(Long pollId);
    void updatePollById(Long pollId, Poll poll);
}
