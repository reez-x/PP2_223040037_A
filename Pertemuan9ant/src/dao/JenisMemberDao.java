/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import model.JenisMember;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
/**
 *
 * @author thega
 */
public class JenisMemberDao {
    
    private final SqlSessionFactory sqlSessionFactory;
    
    public JenisMemberDao (SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    
    public int insert(JenisMember jenisMember){
        int result;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            result = session.insert("mapper.JenisMemberMapper.insert", jenisMember);
            session.commit();

        }
    
        return result;
    }
    
    
    public int update(JenisMember jenisMember) {
        int result;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            result = session.update("mapper.JenisMemberMapper.update", jenisMember);
            session.commit();

        }
        return result;
    }

    public int delete(String jenisMemberId) {
        int result;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            result = session.delete("mapper.JenisMemberMapper.delete", jenisMemberId);
            session.commit();

        }
            return result;
    }
    
    
    public List<JenisMember> findAll() {
        List<JenisMember> result;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            result = session.selectList("mapper.JenisMemberMapper.findAll");
        }
    
    return result;
    }
}