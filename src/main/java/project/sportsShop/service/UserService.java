package project.sportsShop.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import project.sportsShop.vo.User;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = sqlSession.selectOne("users.getUser", username);
        if (user == null) {
            throw new UsernameNotFoundException("해당 유저를 찾을 수 없습니다.");
        }
        return user;
    }

    /**
     * 리턴 값 (0: 정상, 2: 이미 존재하는 유저, 3: 유저 추가에 실패)
     */
    public int addUser(User user) {
        // 이미 가입된 계정이 있는지 확인하기
        User searchUser = sqlSession.selectOne("users.getUser", user.getUsername());

        if (searchUser != null) {
            // throw new IOException("이미 존재하는 유저입니다.");
            return 2;
        }

        // 계정을 데이터베이스에 저장!
        try {
            sqlSession.insert("users.addUser", user);
        } catch (Throwable e) {
            // throw new IOException("유저 추가에 실패했습니다.");
            return 3;
        }

        return 0;
    }
}
