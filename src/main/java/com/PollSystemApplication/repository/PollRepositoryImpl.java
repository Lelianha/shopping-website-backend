package com.PollSystemApplication.repository;

import com.PollSystemApplication.model.Poll;
import com.PollSystemApplication.model.User;
import com.PollSystemApplication.repository.mapper.PollMapper;
import com.PollSystemApplication.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class PollRepositoryImpl implements PollRepository {

    private static final String POLL_TABLE_NAME = "poll";
    private static final String USER_TABLE_NAME = "user";
    private static final String ANSWERS_TABLE_NAME = "answers";

    @Autowired
    JdbcTemplate jdbcTemplate;



    @Override
    public Long createPoll(Poll poll) {
        String sql = "INSERT INTO " + POLL_TABLE_NAME + " (title, first_option ,second_option , third_option , fourth_option  ) VALUES (?, ? , ? , ? , ? )";
        jdbcTemplate.update(sql, poll.getTitle() , poll.getFirstOption() , poll.getSecondOption() , poll.getThirdOption() , poll.getFourthOption()  );
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
    }



    @Override
    public Poll getPollById(Long  pollId) {
        String sql = "SELECT *  FROM " + POLL_TABLE_NAME + " WHERE id=?";
            return jdbcTemplate.queryForObject(sql, new PollMapper(), pollId);
    }


    @Override
    public void deletePollById(Long pollId) {
        String sql = "DELETE FROM "  + POLL_TABLE_NAME + " WHERE poll.id=?";
        jdbcTemplate.update(sql, pollId);
    }



    @Override
    public void updatePollById(Long pollId, Poll poll) {
        String sql = "UPDATE " + POLL_TABLE_NAME + " SET title=?, first_option=? ,  second_option=? ,   third_option=? ,  fourth_option=?" +
                "WHERE id=?";
        jdbcTemplate.update(sql, poll.getTitle(), poll.getFirstOption() , poll.getSecondOption() , poll.getThirdOption() , poll.getFourthOption(),pollId);
    }




}
