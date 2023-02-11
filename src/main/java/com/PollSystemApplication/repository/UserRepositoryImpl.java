package com.PollSystemApplication.repository;

import com.PollSystemApplication.model.User;
import com.PollSystemApplication.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String USER_TABLE_NAME = "user";

    private static final String POLL_TABLE_NAME = "poll";

    private static final String ANSWERS_TABLE_NAME = "answers";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Long createUser(User user) {
        String sql = "INSERT INTO " + USER_TABLE_NAME + " (first_name, last_name, email ,age, address , joining_date ) VALUES (?, ?,?, ? , ? , ?  )";
        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getAge(), user.getAddress(), user.getJoiningDate());
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
    }


    @Override
    public Map<String, Object> getUserById(Long userId) {
        String sql = "SELECT * FROM " + USER_TABLE_NAME + " WHERE user.id=?";
            return jdbcTemplate.queryForMap(sql,userId);
    }

    @Override
    public void deleteUserById(Long userId) {
        String sql = "DELETE FROM " + USER_TABLE_NAME + " WHERE user.id=?";
        jdbcTemplate.update(sql, userId);
    }


    @Override
    public void updateUserById(Long userId, User user) {
        String sql = "UPDATE " + USER_TABLE_NAME + " SET first_name=?, last_name=?, email=? , age=? , address=? , joining_date=? " +
                "WHERE id=?";
        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getAge(), user.getAddress(), user.getJoiningDate(), userId);

    }

    @Override
    public void answerUser(User user) {
        String sql = "INSERT INTO " + ANSWERS_TABLE_NAME + " (user_id ,question_id ,answer ) VALUES ( ?, ? , ? )";
        jdbcTemplate.update(sql, user.getId(), user.getQuestionId(), user.getAnswer());

    }



   @Override
   public List<Map<String, Object>> getCountQuestionOptions( Long questionId) {
    String sql = "SELECT  SUM(answer=poll.first_option) AS Counter_For_First_Option ,SUM(answer=poll.second_option) AS Counter_For_Second_Option , SUM(answer=poll.third_option) AS Counter_For_Third_Option ,SUM(answer=poll.fourth_option) AS Counter_For_Fourth_Option FROM "  + USER_TABLE_NAME + " LEFT JOIN "  + ANSWERS_TABLE_NAME + " ON user.id = answers.user_id" + " LEFT JOIN "  + POLL_TABLE_NAME + " ON answers.question_id = poll.id " + " WHERE  question_id=?";
    return jdbcTemplate.queryForList(sql,questionId);
}



    @Override
    public  Map<String, Object> getAnswersTotal( Long questionId) {
        String sql = "SELECT COUNT(DISTINCT user_id) AS Answers_In_Total FROM " + USER_TABLE_NAME + " LEFT JOIN "  + ANSWERS_TABLE_NAME + " ON user.id = answers.user_id" + " LEFT JOIN "  + POLL_TABLE_NAME + " ON answers.question_id = poll.id " + " WHERE  answer=poll.first_option AND question_id=? OR answer=poll.second_option AND question_id=? OR answer=poll.third_option AND question_id=? OR answer=poll.fourth_option AND question_id=? ";
        return jdbcTemplate.queryForMap(sql,questionId,questionId,questionId,questionId);
    }



    @Override
    public  List<Map<String, Object>> getUserAnswers(Long userId) {
        String sql = "SELECT  question_id  , answer  FROM " + USER_TABLE_NAME + " LEFT JOIN "  + ANSWERS_TABLE_NAME + " ON user.id = answers.user_id" + " LEFT JOIN "  + POLL_TABLE_NAME + " ON answers.question_id = poll.id " + " WHERE user_id=?";
        return jdbcTemplate.queryForList(sql, userId);
    }


    @Override
    public  Map<String, Object> getAnswersNumber( Long userId) {
        String sql = "SELECT COUNT(question_id) AS Answers_Number  FROM " + USER_TABLE_NAME + " LEFT JOIN "  + ANSWERS_TABLE_NAME + " ON user.id = answers.user_id" + " LEFT JOIN "  + POLL_TABLE_NAME + " ON answers.question_id = poll.id " + " WHERE user_id=?";
        return jdbcTemplate.queryForMap(sql,userId);
    }

    @Override
    public List<Map<String, Object>> getAllQuestions() {
        String sql = "SELECT title , SUM(answer=poll.first_option) AS Counter_For_First_Option ,SUM(answer=poll.second_option) AS Counter_For_Second_Option , SUM(answer=poll.third_option) AS Counter_For_Third_Option ,SUM(answer=poll.fourth_option) AS Counter_For_Fourth_Option FROM "  + USER_TABLE_NAME + " LEFT JOIN "  + ANSWERS_TABLE_NAME + " ON user.id = answers.user_id" + " LEFT JOIN "  + POLL_TABLE_NAME + " ON answers.question_id = poll.id " + " GROUP BY title" ;
        return jdbcTemplate.queryForList(sql);
    }


}





